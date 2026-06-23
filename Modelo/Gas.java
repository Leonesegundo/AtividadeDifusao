package Difusão.Modelo;

public class Gas {
   
    double velocidadeDifusao;
    double totalMoleculas;
    int posicaoInicialX;
    int posicaoInicialY;
    int posicaoInicialZ;


    // Construtor: define as propriedades do gás e onde ele vai começar
   public  Gas ( double velocidadeDifusao, double totalMoleculas, int x, int y, int z) {
        this.velocidadeDifusao = velocidadeDifusao;
        this.totalMoleculas = totalMoleculas;
        this.posicaoInicialX = x;
        this.posicaoInicialY = y;
        this.posicaoInicialZ = z;
   
    }


    public void distribuicaoInicial(Sala sala){

        Celula celulaInicial = sala.getCelula(posicaoInicialX , posicaoInicialY , posicaoInicialZ);
        
        // Injeta a quantidade total de gás na célula de partida correspondente
        if (  celulaInicial != null  && !celulaInicial.isBloqueada()){
            celulaInicial.setQuantidade(this.totalMoleculas);
        
        } else {
            System.out.println("Posição inicial inválida ou célula bloqueada.");
        }
        

    }




}
