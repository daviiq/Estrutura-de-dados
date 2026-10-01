package org.example.FIlas;

public class FilaCircular<T extends Comparable<T>> {

    private T[] elementos;
    private int frente;
    private int tras;
    private int tamanho;

    public FilaCircular(int capacidade) {
        this.elementos = (T[]) new Comparable[capacidade];
        this.tamanho = 0;
        this.tras = -1;
        this.frente = 0;
    }

    public void enfileirar(T elemento) {
        if (tamanho == elementos.length) {
            throw new IndexOutOfBoundsException("Ta cheio");
        }
        /*Torna a fila circular através de uma conta matemática, onde descobrimos o resto
        * Dividindo a capacidade ( elementos.length ), pelo valor
        * */
        tras = (tras - 1) % elementos.length;
        elementos[tras] = elemento;
        tamanho++;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public T desenfileirar() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Está vazio");
        }
        T valor = elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1) % elementos.length;
        tamanho--;
        return valor;
    }

    public void imprimir() {
        System.out.println("Fila: ");
        for (int i = 0; i <tamanho; i++) {
            int indice = ( frente + i ) % elementos.length;
            System.out.println(elementos[indice] + " ");
        }
        System.out.println();
    }
}
