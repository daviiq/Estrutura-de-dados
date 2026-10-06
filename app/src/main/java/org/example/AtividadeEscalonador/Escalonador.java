package org.example.AtividadeEscalonador;
import org.example.Filas.FilaCircular;
import org.example.Vetores.Vetor;

public class Escalonador {
    private FilaCircular<Processo> processos;
    private Vetor<String> instrucoes;
    private final int quantum = 2;
    private Processo processo1;
    private Processo processo2;
    private Processo processo3;
    private Processo processo4;
    private Processo processo6;

    public Escalonador(FilaCircular<Processo> processos) {
        this.processos = processos;
    }

    private void executarEscalonador() {
        int tempoAtual = 0;
        int instrucoesRestantes;

        //Adiciona os processos P1 na fila
        System.out.println("Adicionando Processos P1...");
        for (int i = 1; i <8; i++) {
            processos.enfileirar(processo1);
            processo1.setStatus(Status.PRONTO);
        }
        System.out.println("Executando o Escalonador... ");

        while (!processos.isEmpty()) {
            System.out.println("Lendo novo lote de instruções: " + quantum + "processos");

            //Loop para ler no máximo 2 processos por vez
            for (int i = 0; i < quantum; i++) {
                if (!processos.isEmpty()) {
                    Processo pAtual = processos.desenfileirar();
                    System.out.println("Executando: " + pAtual.getNome());
                    processo1.setStatus(Status.EXECUTANDO);
                }
            }
            //Se a fila estiver vazia aguarda 2 segundos para puxar o novo processo
            if (!processos.isEmpty()) {
                System.out.println("Aguardando 2 segundos para novos processos!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
