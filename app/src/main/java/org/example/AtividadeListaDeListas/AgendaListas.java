package org.example.AtividadeListaDeListas;

import org.example.Aula01.Atividade01.Contato;
import org.example.Vetores.Vetor;

public class AgendaListas {
    private Vetor<Contato> contatos[];
    private int tamanho;

    public AgendaListas() {
        //Cria as listas de listas
        this.contatos = (Vetor<Contato>[]) new Vetor[26];

        for (int i = 0; i < 26; i++) {
            this.contatos[i] = new Vetor<>(10);
        }
    }

    //Calcula o Indice de 0 a 25 baseado na primeira letra do nome
    public int calcularIndice(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        //pega a primeira letra do nome e remove os espaços
        char primeiraLetra = Character.toUpperCase(nome.trim().charAt(0));

        if (primeiraLetra >= 'A' && primeiraLetra <= 'Z') {
            return primeiraLetra - 'A';
        }
        throw new IllegalArgumentException("O nome deve começar com uma letra de A a Z");
    }

    //Insere o contato de forma ordenada na lista da letra correspondente
    public void adicionarContato (Contato contato) {
        int indice = calcularIndice(contato.getNome());
        contatos[indice].inserirOrdenado(contato);
    }

    //Busca o contato dentro da lista da sua letra
    public Contato buscarContato(Contato contato) {
        int indice = calcularIndice(contato.getNome());
        int posicao = contatos[indice].buscaBinaria(contato);

        if (posicao != -1) {
            return contatos[indice].ler(posicao);
        }
        return null;
    }

    //Localiza e remove o contato
    public boolean removerContato (Contato contato) {
        int indice = calcularIndice(contato.getNome());
        int posicao = contatos[indice].buscaBinaria(contato);

        if (posicao == -1) {
            return false;
        }
        contatos[indice].remover(posicao);
        return true;
    }

    //Atualiza o Contato removendo o antigo e inserindo o novo
    public boolean atualizarContato(Contato antigo, Contato novo) {
        if (removerContato(antigo)) {
            adicionarContato(novo);
            return true;
        }
        return false;
    }

    //Mostra os contato agrupados por Letra
    public void listarAgenda() {
        for (int i = 0; i < 26; i++) {
            char letra = (char) ('A' + i);
            System.out.println("lETRA: " + letra);
            if (contatos[i].tamanhoVetor() == 0 ) {
                System.out.println("Nenhum contato registrado");
            } else {
                contatos[i].listarElementos();
            }
        }
    }
}