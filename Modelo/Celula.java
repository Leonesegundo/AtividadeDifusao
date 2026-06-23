package Difusão.Modelo;

public class Celula {

    private double quantidade; // Quantidade de gas no celula
    private boolean bloqueada ;  // barreira fisica da celula 

    public Celula(){
        this.quantidade = 0.0;
        this.bloqueada = false;


    }

    // metodos para acumular gas dos vizinhos 
    public void adicionarGas(double valor){
        this.quantidade += valor;
    }

    


    // ---------------- Get  e Seters --------------------

    


    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }



}
