package org.example.Vetores;

public class Vetor<T extends Comparable<T>> {

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

    public int localizar(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] != null && elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
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
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = null;
        }
    }

    //Basicamente o método localizar. Tendo como complexidade O(N) (Quanto maior o Array, mais demora)
    public int buscaLinear( T[] elementos, T valor ) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    //Possui complexidade O(logN), tornando assim mais rápido na procura, pois divide o Array no meio
    //Porém, o array PRECISA estar ordenado para funcionar
    public int buscaBinaria(T[] elementos, T valor) {
        int inicio = 0;
        int fim = elementos.length - 1;

        while (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (elementos[meio] == null) {
                return -1; //Evita o NullPointerExcpetion caso tenha buracos na lista
            }

            //Como o tipo T não aceita o operador < utilizamos o compareTo para isso
            //Importante destacar que a classe precisa ser extendida para o Comparable<T>

            int comparacao = elementos[meio].compareTo(valor);

            //Procura no meio
            if (comparacao == 0) {
                return meio;
            }

            //Procura na direita
            if (comparacao < 0) {
                inicio = meio + 1;
            }

            //Procura na esquerda
            if (comparacao > 0) {
                fim = meio - 1;
            }
        }
        return -1; //Caso não encontre o elemento
    }
}
