package org.example.Aula01.Atividade01;

public class Agenda {

    private Contato[] contatos;
    private int tamanho;

    public Agenda(int quantidade) {
        contatos = new Contato[quantidade];
        this.tamanho = 0;
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
        if (contatos.length == 0) {
            System.out.println("A lista está vazia");
        }

        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].equals(contato)) {
                System.out.println("O contato foi removido" + contato);
                remover(i);
            } else {
                throw new IndexOutOfBoundsException("O Contato não está na lista");
            }
        }
    }

   public String buscarContato(String nome, String telefone) {
       for (int i = 0; i < contatos.length; i++) {
           if (contatos[i] != null && contatos[i].equals(nome) || contatos[i].equals(telefone)){
               return "Contatos";
           }
       }
       return "";
   }

    public void listarContatos() {

        if (contatos.length == 0) {
            System.out.println("A lista está vazia");
        }

        System.out.print("[");
        System.out.println("");
        for (int i = 0; i <tamanho - 1; i++) {
            System.out.println(contatos[i].toString());
        }
        System.out.print("]");
    }

    public void inserirContatos(Contato[] contatosNovos) {

    }

    public void buscaPrefixo(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().startsWith(nome)) {
                return;
            } else {
                System.out.println("O Contato não está na lista");
            }
        }
    }
}