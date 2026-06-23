package Difusão.Modelo;

public class FonteDeVento {
    
    int x , y , z ;
    double velocidade;
    String direcao;

    public FonteDeVento(int x , int y , int z , double velocidade , String direcao){
        this.x = x;
        this.y = y;
        this.z = z;
        this.velocidade = velocidade;
        this.direcao = direcao;
    }

    public double calcularInfluencia(int xOrig, int yOrig, int zOrig, int xDest, int yDest, int zDest, double velDifusao) {
        int deltaX = xDest - xOrig;
        int deltaY = yDest - yOrig;
        int deltaZ = zDest - zOrig;

        boolean contraOvento = false;

        if (this.direcao.equalsIgnoreCase("X+") && deltaX < 0) contraOvento = true;
        else if (this.direcao.equalsIgnoreCase("X-") && deltaX > 0) contraOvento = true;
        else if (this.direcao.equalsIgnoreCase("Y+") && deltaY < 0) contraOvento = true;
        else if (this.direcao.equalsIgnoreCase("Y-") && deltaY > 0) contraOvento = true;
        else if (this.direcao.equalsIgnoreCase("Z+") && deltaZ < 0) contraOvento = true;
        else if (this.direcao.equalsIgnoreCase("Z-") && deltaZ > 0) contraOvento = true;

        if (contraOvento) {
            if (this.velocidade >= velDifusao) {
                return 0.0; // Barreira completa ("parede de vento")
            } else {
                return 1.0 - (this.velocidade / velDifusao); // Atenuação parcial
            }
        }

        return 1.0; // Sem alteração no fluxo
    }
    
    // Getters básicos caso precise consultar depois
    
    public double getVelocidade() { 
        return velocidade;
    }
    
    public String getDirecao() { 
        return direcao;
    }
    
    
        
}
