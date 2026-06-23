package Difusão.Modelo;

import java.util.ArrayList;
import java.util.List;


public class Sala {
    
    
    private Celula[][][] grid; // matriz tridimensional de células  SALA ;
    int largura;
    int altura;
    int profundidade;

    public Sala(int largura ,  int altura  , int profundidade){
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;

        this.grid = new Celula[largura][altura][profundidade];
        inicializarSala();
    }

    //  inicializando com valores padrão
    private void inicializarSala(){
        for(int x =  0 ; x < largura ; x++  ){
            for(int y = 0  ; y <  altura  ; y++ ){
                for(int z  = 0 ; z < profundidade ; z++ ){
                    grid[x][y][z] = new Celula(); // Cria uma célula limpa e livre nesta coordenada


                }



            }

        }

    }

    // Verifica se as coordenadas estão dentro do limite do grid
    public boolean ehPosicaoValida(int x, int y, int z) {
        return (x >= 0 && x < largura) && 
               (y >= 0 && y < altura) && 
               (z >= 0 && z < profundidade);
    }

   // Retorna uma célula específica caso a posição seja válida
    public Celula getCelula(int x, int y, int z) {
        if (ehPosicaoValida(x, y, z)) {
            return grid[x][y][z];
        }
        return null;
    }

    public List<Celula> obterVizinhos(int x, int y, int z) {
        List<Celula> vizinhos = new ArrayList<>();
        
        // Direções: Esquerda, Direita, Baixo, Cima, Trás, Frente
        int[][] direcoes = {
            {-1, 0, 0}, {1, 0, 0},
            {0, -1, 0}, {0, 1, 0},
            {0, 0, -1}, {0, 0, 1}
        };

        for (int[] d : direcoes) {
            int nx = x + d[0];
            int ny = y + d[1];
            int nz = z + d[2];

            if (ehPosicaoValida(nx, ny, nz)) {
                Celula vizinha = grid[nx][ny][nz];
                if (!vizinha.isBloqueada()) {
                    vizinhos.add(vizinha);
                }
            }
        }
        return vizinhos;
    }
    


    public int getLargura() {
        return largura; 
        
    }
    
    public int getAltura() { 
        return altura;
    }
    
    
    public int getProfundidade() {
        return profundidade; 
    }

    



}
