package org.example.AtividadeAlgoritmosBusca;

import org.example.Vetores.Vetor;
import java.util.Random;

public class Main {

    //Método Auxiliar para calcular o tempo + comparações
    private static void executarTesteBusca(String legenda, Vetor<Integer> vetor, int indiceAlvo, boolean linear) {
        Integer valorProcurado = vetor.ler(indiceAlvo);

        long inicio = System.nanoTime();
        int resultadoIndice; //Indice informado

        if (linear) {
            resultadoIndice = vetor.buscaLinearOrdenada(valorProcurado);
        } else {
            resultadoIndice = vetor.buscaBinaria(valorProcurado);
        }

        long fim = System.nanoTime();
        long duracaoTotal = fim - inicio; //Conversão do tempo total



        System.out.println("[" + legenda + "]");
        System.out.println("  -> Valor do Indice: " + valorProcurado);
        System.out.println("  -> Indice encontrado: " + resultadoIndice);
        System.out.println("  -> Comparacoes feitas: " + Vetor.quantidadeComparacoes());
        System.out.println("  -> Tempo de execucao: " + duracaoTotal + " ns (" + (duracaoTotal / 1000000.0) + " ms)");
        System.out.println();
    }

    static void main() {
        Vetor<Integer> vetor1k = new Vetor<>(1000);
        Vetor<Integer> vetor10k = new Vetor<>(10000);
        Vetor<Integer> vetor100k = new Vetor<>(100000);
        Random random = new Random();

        // Preenchimento dos Vetores:
        for (int i = 0; i < 1000; i++) {
            vetor1k.inserirFinal(random.nextInt());
        }
        vetor1k.ordena();

        for (int i = 0; i < 10000; i++) {
            vetor10k.inserirFinal(random.nextInt());
        }
        vetor10k.ordena();

        for (int i = 0; i < 100000; i++) {
            vetor100k.inserirFinal(random.nextInt());
        }
        vetor100k.ordena();

        // ================= TESTES COM VETOR 1K =================

        // --- BUSCA LINEAR ---
        System.out.println("------------ Vetor 1K ------------");
        executarTesteBusca("Linear - Inicio (Pos 0)", vetor1k, 0, true);
        executarTesteBusca("Linear - Meio (Pos 500)", vetor1k, 500, true);
        executarTesteBusca("Linear - Fim (Pos 999)", vetor1k, 999, true);

        // --- BUSCA Binaria ---
        executarTesteBusca("Binaria - Inicio (Pos 0)", vetor1k, 0, false);
        executarTesteBusca("Binaria - Meio (Pos 500)", vetor1k, 500, false);
        executarTesteBusca("Binaria - Fim (Pos 999)", vetor1k, 999, false);

        // ================= TESTES COM VETOR 10K =================

        // --- BUSCA LINEAR ---
        System.out.println("------------ Vetor 10K ------------");
        executarTesteBusca("Linear - Inicio (Pos 0)", vetor10k, 0, true);
        executarTesteBusca("Linear - Meio (Pos 5000)", vetor10k, 5000, true);
        executarTesteBusca("Linear - Fim (Pos 9999)", vetor10k, 9999, true);

        // --- BUSCA Binaria ---
        executarTesteBusca("Binaria - Inicio (Pos 0)", vetor10k, 0, false);
        executarTesteBusca("Binaria - Meio (Pos 5000)", vetor10k, 5000, false);
        executarTesteBusca("Binaria - Fim (Pos 9999)", vetor10k, 9999, false);

        // ================= TESTES COM VETOR 100K =================

        // --- BUSCA LINEAR ---
        System.out.println("------------ Vetor 100K ------------");
        executarTesteBusca("Linear - Inicio (Pos 0)", vetor100k, 0, true);
        executarTesteBusca("Linear - Meio (Pos 50000)", vetor100k, 50000, true);
        executarTesteBusca("Linear - Fim (Pos 99999)", vetor100k, 9999, true);

        // --- BUSCA Binaria ---
        executarTesteBusca("Binaria - Inicio (Pos 0)", vetor100k, 0, false);
        executarTesteBusca("Binaria - Meio (Pos 50000)", vetor100k, 50000, false);
        executarTesteBusca("Binaria - Fim (Pos 99999)", vetor100k, 99999, false);
    }
}
