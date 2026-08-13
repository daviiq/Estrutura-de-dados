package org.example.Vetores;

public class Vetor<T> {

    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade) {
        elementos = (T[]) new Object[quantidade];
        this.tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    private void expandir() {
        T[] novoVetor = (T[]) new Object[elementos.length * 2];
        //Insere os elementos nas posições do novo Vetor
        for (int i = 0; i < elementos.length; i++) {
            novoVetor[i] = elementos[i];
        }
        elementos = novoVetor;
    }

    @SuppressWarnings("unchecked")
    private void reduzir() {
        if (tamanho <= elementos.length / 4) {
            T[] novoVetor = (T[]) new Object[elementos.length / 2];
            for (int i = 0; i < tamanho; i++) {
                novoVetor[i] = elementos[i];
            }
            elementos = novoVetor;
        }
    }

    public void inserir(int indice, T elemento) {
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

    public void limpar() {
        
    }
}
