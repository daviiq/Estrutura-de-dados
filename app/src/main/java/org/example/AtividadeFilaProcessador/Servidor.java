package org.example.AtividadeFilaProcessador;
import org.example.FIlas.Fila;
import java.util.Random;

public class Servidor {

    private int totalRegGeradas = 0;
    private int totalRegAtendidas = 0;
    private int totalRegPerdidas = 0;
    private Random aleatorio;
    private Fila<String> fila;
    private int numProcessadores;
    private int nRequisicoes;

    public int getTotalRegGeradas() {
        return totalRegGeradas;
    }

    public int getTotalRegAtendidas() {
        return totalRegAtendidas;
    }

    public int getTotalRegPerdidas() {
        return totalRegPerdidas;
    }

    public Random getAleatorio() {
        return aleatorio;
    }

    public Fila<String> getFila() {
        return fila;
    }

    public int getNumProcessadores() {
        return numProcessadores;
    }

    public int getnRequisicoes() {
        return nRequisicoes;
    }

    public Servidor(int nRequisicoes, int numProcessadores, int capacidade) {
        this.nRequisicoes = nRequisicoes;
        this.numProcessadores = numProcessadores;
        this.fila = new Fila<>(capacidade);
        this.aleatorio = new Random();
    }

    public void executar(int ciclos) {
        //Equanto o Ciclo for menor ou igual ao ciclos
        for (int ciclo = 1; ciclo < ciclos; ciclo++) {

            /* O servidor atende a quantidade de requisições com base
            na quantidade de processadores
             */
            for (int i = 0; i < numProcessadores; i++) {
                if (!fila.isEmpty()) {
                    fila.desenfileirar();
                    totalRegAtendidas++;
                }
            }

            //Cria as novas requisições
            int novasReq = aleatorio.nextInt(1, nRequisicoes);

            /*Para cada ciclo,verifica se possui ciclos disponíveis
            e desenfilera as requisições */
            for (int i = 0; i < novasReq; i++) {
                totalRegGeradas++;

                /*Se a fila está completamente cheia e o ciclo já está
                no máximo, então enfileira a fila e aumenta a quantidade
                perdidas
                 */
                if (fila.getTamanho() < fila.capacidade()) {
                    fila.enfileirar("Req");
                } else {
                    totalRegPerdidas++; //Descarta as requisições
                }
            }
        }
    }
    public String relatorio() {
        double porcentagemPerda = 0;
        if (totalRegGeradas > 0) {
            porcentagemPerda = ((double) totalRegPerdidas/totalRegGeradas) * 100;
        }
        return "Total requisicoes Geradas: " + totalRegGeradas + "\n" +
                "Total requisicoes Atendidas: " + totalRegAtendidas + "\n" +
                "Total requisicoes Perdidas: " + totalRegPerdidas + "\n" +
                "Este servidor teve uma porcentagem de " + porcentagemPerda +"% de perda";
    }
}
