package org.example.Aula00;

public class VetorEstatico {

    private String[] elementos;
    private int tamanho;

    public VetorEstatico(int quantidade) {
        elementos = new String[quantidade];
        this.tamanho = 0;
    }

    public void inserir(int indice, String elemento) {

        if (tamanho > elementos.length) {
            throw new IndexOutOfBoundsException("Vetor cheio");

        }

        if (indice < 0 || indice > elementos.length) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        for (int i = tamanho; i > indice; i--) {
            elementos[i] = elementos[i-1];
        }
        elementos[indice] = elemento;
        tamanho++;
    }

    public int obterTamanho() {
        return tamanho;
    }

    public void removerFinal() {
        elementos[tamanho -1] = null;
        tamanho--;
    }



    public void imprimir() {
        System.out.print("[");
        System.out.println("");
        for (int i = 0; i <tamanho; i++) {
            System.out.println(elementos[i]);
        }
        System.out.print("]");
    }
}
