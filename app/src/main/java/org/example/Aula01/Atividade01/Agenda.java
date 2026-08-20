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
    @SuppressWarnings("unchecked")
    private void reduzir() {
        if (tamanho <= contatos.length / 4) {
            T[] novoVetor = (T[]) new Object[contatos.length / 2];
            for (int i = 0; i < tamanho; i++) {
                novoVetor[i] = contatos[i];
            }
            contatos = novoVetor;
        }
    }

    public int localizar(T contato) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i] != null && contatos[i].equals(contato)) {
                return i;
            }
        }
        return -1;
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
                throw new IllegalArgumentException("O contato já está cadastado");
            }
            contatos[i] = contatos[i - 1];
        }
        contatos[indice] = contato;
        tamanho++;
    }

    @SuppressWarnings("unchecked")
    public void remover(T contato) {
        if (contatos.length == 0) {
            System.out.println("A lista está vazia");
        }

        int indice = localizar(contato);
        if (indice == -1) {
            System.out.println("Contato não encontrado");
            return;
        }

        //levanta todo mundo e muda vai uma cadeira pra esquerda e deixa o índice no final
        for (int i = indice; i < tamanho - 1 ; i++) {
            contatos[i] = contatos[i + 1];
        }

        //Remove o índice lá no final
        contatos[tamanho - 1] = null;
        tamanho--;
        reduzir();
        System.out.println("Contato removido");
    }

    @SuppressWarnings("unchecked")
   public T buscarContato(String nome, String telefone) {
        Contato contatoEncontrado = new Contato(nome,telefone);
        int indice = localizar( (T) contatoEncontrado);

        if (indice != -1) {
            return contatos[indice];
        }
        System.out.println("Contato não encontrado");
        return null;
    }

    public void listarContatos() {
        if (contatos.length == 0) {
            throw new IndexOutOfBoundsException("A lista de Contatos está vazia");
        }
        for (int i = 0; i < contatos.length - 1; i++) {
            System.out.print("");
            System.out.println("[ " + i + "]" + " " + contatos[i]);
        }
    }

    /*public T atualizarContato()  {

    }
     */

    @SuppressWarnings("unchecked")
    public void inserirContatos(T[] contatosNovos) {
    }

    public void buscaPrefixo(String nome) {
    }
}