package org.example.Aula03.Atividade03;
import org.example.Aula01.Atividade01.Contato;

public class Agenda {
    private Contato[] contatos;
    private int tamanho;

    public Agenda(int quantidade) {
        contatos = new Contato[quantidade];
        this.tamanho = 0;
    }

    private void expandir() {
        Contato[] novoContato = new Contato[contatos.length * 2];
        for (int i = 0; i < contatos.length; i++) {
            novoContato[i] = contatos[i];
        }
        contatos = novoContato;
    }

    private void reduzir() {
        if (tamanho <= contatos.length /4) {
            Contato[] novoContato = new Contato[contatos.length * 2];
            for (int i = 0; i < contatos.length; i++) {
                novoContato[i] = contatos[i];
            }
            contatos = novoContato;
        }
    }

    public void inserir(int indice, Contato contato) {
        if (tamanho == contatos.length) {
            expandir();
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
        reduzir();
    }
}
