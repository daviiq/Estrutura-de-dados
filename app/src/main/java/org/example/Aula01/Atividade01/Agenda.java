package org.example.Aula01.Atividade01;

public class Agenda {

    private Contato[] contatos;
    private int tamanho = 10;

    public Agenda(int quantidade) {
        contatos = new Contato[tamanho];
        this.tamanho = 10;
    }

    public void inserir(int indice, Contato contato) {
        if (tamanho > contatos.length) {
            throw new IndexOutOfBoundsException("A lista está cheia");
        }

        if (indice < 0 || indice > contatos.length) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        for (int i = tamanho; i > indice; i--) {
            if (contatos[i].equals(contato)) {
                throw new IndexOutOfBoundsException("O contato já está cadastado");
            }
            contatos[i] = contatos[i - 1];
        }
        contatos[indice] = contato;
        tamanho++;
    }

    public void remover(int indice) {
        if (indice < 0 || indice > contatos.length) {
            throw new IndexOutOfBoundsException("Posição Inválida");
        }

        for (int i = indice; i < tamanho; i++) {
            contatos[i] = contatos[i + 1];
        }
        contatos[tamanho - 1] = null;
        tamanho--;
    }

    public void remover(Contato contato) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos.equals(contato)) {
                remover(i);
            } else {
                throw new IndexOutOfBoundsException("O Contato não está na lista");
            }
        }
    }

    public Contato buscarContato(Contato contato) {

    }

    public Contato listarContatos() {
    }

}