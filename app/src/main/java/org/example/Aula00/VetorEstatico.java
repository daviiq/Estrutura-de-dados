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
        if (tamanho > 0) {

            elementos[tamanho - 1] = null;
            tamanho--;
        } else {
            throw new IndexOutOfBoundsException("O vetor está vazio");
        }
    }

    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Posição incorreta");
        }
        for (int i = indice; i < tamanho; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho-1] = null;
        tamanho--;
    }

    public void remover(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                remover(i);
            } else {
                throw new IndexOutOfBoundsException("O elemento não existe dentro do Array");
            }
        }
    }

    public String ler(int indice) {
        if (indice >= 0 || indice < tamanho) {
            return elementos[indice];
        } else {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
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
