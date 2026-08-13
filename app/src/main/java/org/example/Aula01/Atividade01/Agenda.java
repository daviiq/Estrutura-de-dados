package org.example.Aula01.Atividade01;

public class Agenda<T> {

    private T[] contatos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Agenda(int quantidade) {
        contatos = (T[]) new Object[quantidade];
        this.tamanho = 0;
    }

    @SuppressWarnings("unchecked")
    private void expandir() {
        T[] novoVetor = (T[]) new Object[contatos.length * 2];
        //Insere os contatos nas posições do novo Vetor
        for (int i = 0; i < contatos.length; i++) {
            novoVetor[i] = contatos[i];
        }
        contatos = novoVetor;
    }

    private void reduzir() {
        if (tamanho <= contatos.length / 4) {
            T[] novoVetor = (T[]) new Object[contatos.length / 2];
            for (int i = 0; i < tamanho; i++) {
                novoVetor[i] = contatos[i];
            }
            contatos = novoVetor;
        }
    }

    public void inserir(int indice, T contato) {
        if (tamanho > contatos.length) {
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

    public void remover(Contato contato) {
        if (contatos.length == 0) {
            System.out.println("A lista está vazia");
        }

        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].equals(contato)) {
                System.out.println("O contato foi removido" + contato);
                remover(contato);
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

    public void inserirContatos(T[] contatosNovos) {
        for (int i = 0; i < contatos.length; i++) {
            inserir(i,(T) contatosNovos);
        }
    }

    public void buscaPrefixo(String nome) {
        
    }
}