package org.example.REBOOT_ALUNOS;
import java.util.*;

/** Missao 3. Todos chegam em t=0; custo de troca de contexto igual a zero. */
public class Escalonador {
    public static class Resultado {
        public final List<String> execucao = new ArrayList<>();
        public final List<String> conclusao = new ArrayList<>();
        public int tempoTotal;
    }

    public static Resultado executar(String[] nomes, int[] duracoes, int quantum) {
        if (nomes == null || duracoes == null || nomes.length != duracoes.length)
            throw new IllegalArgumentException("entradas incompativeis");
        if (quantum <= 0) throw new IllegalArgumentException("quantum deve ser positivo");
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] == null || nomes[i].isEmpty() || duracoes[i] <= 0)
                throw new IllegalArgumentException("nome e duracao invalidos");
        }
        // Cada inteiro representa o indice de um processo.
        // ArrayDeque isola esta missao dos erros da FilaCircular.
        Deque<Integer> fila = new ArrayDeque<>();

        // Isso só criava outra referência para o mesmo array, então o loop
        // alterava o array do chamador. O clone() cria uma cópia independente.
        int[] restante = duracoes.clone();
        for (int i = 0; i < nomes.length; i++) fila.addLast(i);
        Resultado resultado = new Resultado();

        while (!fila.isEmpty()) {
            int p = fila.removeFirst();
            // Se o processo precisa de menos tempo que o quantum, ele só
            // executa o que falta. Sem isso, tempoTotal ficava inflado e
            // restante[p] ficava negativo.
            int executado = Math.min(quantum, restante[p]);


            resultado.execucao.add(nomes[p]);
            resultado.tempoTotal += executado;
            restante[p] -= executado;


            //Devolve o processo pro final da fila, permitindo rodar os demais processos
            if (restante[p] > 0) fila.addLast(p);
            else resultado.conclusao.add(nomes[p]);
        }
        return resultado;
    }
}
