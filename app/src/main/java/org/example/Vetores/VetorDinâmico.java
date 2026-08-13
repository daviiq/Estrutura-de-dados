package org.example.Vetores;

public class VetorDinâmico {

    private String[] elementos;
    private int tamanho;

    public VetorDinâmico(int quantidade) {
        elementos = new String[quantidade];
        this.tamanho = 0;
    }

    private void expandir() {
        String[] novoVetor = new String[elementos.length * 2];
        //Insere os elementos nas posições do novo Vetor
        for (int i = 0; i < elementos.length; i++) {
            novoVetor[i] = elementos[i];
        }
        elementos = novoVetor;
    }

    private void reduzir() {
        if (tamanho <= elementos.length / 4) {
            String[] novoVetor = new String[elementos.length / 2];
            for (int i = 0; i < tamanho; i++) {
                novoVetor[i] = elementos[i];
            }
            elementos = novoVetor;
        }
    }

    public void inserir(int indice, String elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }
        elementos[indice] = elemento;
        tamanho++;
    }
    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        for (int i = 0; i < tamanho; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho - 1] = null;
        tamanho--;
        reduzir();
    }
}
