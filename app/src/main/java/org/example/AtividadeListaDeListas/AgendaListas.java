package org.example.AtividadeListaDeListas;

import org.example.Aula01.Atividade01.Contato;
import org.example.Vetores.Vetor;

public class AgendaListas {
    private Vetor<Contato> contatos[];
    private int tamanho;
    
    public AgendaListas() {
        contatos = new Vetor[26];
    }

    public int tamanhoVetor(){
        return this.tamanho;
    }

    public int localizar(Contato contato) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i] != null && contatos[i].equals(contato)) {
                return i;
            }
        }
        return -1;
    }

    public void inserirFinal(Contato contato) {
        inserir(tamanho, contato);
    }

    public void inserir(int indice, Vetor<Contato> contato) {
        if (tamanho == contatos.length) {
            throw new IndexOutOfBoundsException("Vetor cheio");
        }
        contatos[indice] = contato;
        tamanho++;
    }

    public void inserirOrdenado(Contato contato) {
        if(tamanho == contatos.length) {
            throw new IndexOutOfBoundsException("Vetor cheio");;
        }
        inserir(tamanho,contato);
        tamanho++;
        ordena();
    }
    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        for (int i = indice; i < tamanho - 1; i++) {
            contatos[i] = contatos[i+1];
        }
        contatos[tamanho - 1] = null;
        tamanho--;
    }

    public void limpar() {
        for (int i = 0; i < contatos.length; i++) {
            contatos[i] = null;
        }
    }

    public void listarcontatos() {
        if (contatos.length == 0) {
            throw new IndexOutOfBoundsException("A lista de contatos está vazia");
        }
        for (int i = 0; i < contatos.length - 1; i++) {
            System.out.print("");
            System.out.println("[ " + i + "]" + " " + contatos[i]);
        }
    }

    public T ler(int indice) {
        if (indice >= 0 || indice < tamanho) {
            return contatos[indice];
        } else {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
    }

    public void ordena() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho -1 -i; j++) {
                Contato atual = contatos[j];
                Contato proximo = contatos[j + 1];
                if (contatos[j].compareTo(proximo) > 0 ) {
                    //Faz o Swap das posições trocando de um temporário para a posição especifica
                    if (atual != null && proximo != null && atual.compareTo(proximo) > 0) {
                        contatos[j] = proximo;
                        contatos[j + 1] = atual;
                        comparacoes++;
                    }
                }
            }
        }
    }

    //Basicamente o método localizar. Tendo como complexidade O(N) (Quanto maior o Array, mais demora)
    public int buscaLinearOrdenada(T valor ) {
        zerarComparacoes();
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i] != null) {
                if (contatos[i].equals(valor)) {
                    return i;
                }

                // Faz uma ordenação simples, se o valor for maior que o procurado,
                // já para de procurar na hora
                if (contatos[i].compareTo(valor) > 0) {
                    return -1;
                }
            }
        }
        return -1;
    }

    //Possui complexidade O(logN), tornando assim mais rápido na procura, pois divide o Array no meio
    //Porém, o array PRECISA estar ordenado para funcionar
    public int buscaBinaria(T valor) {
        zerarComparacoes();
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (contatos[meio] == null) {
                return -1; //Evita o NullPointerExcpetion caso tenha buracos na lista
            }

            //Como o tipo T não aceita o operador < utilizamos o compareTo para isso
            //Importante destacar que a classe precisa ser extendida para o Comparable<T>

            int comparacao = contatos[meio].compareTo(valor);
            comparacoes++;

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
        return -1; //Caso não encontre o contato
    }
}

//array agenda[] = new array[26]