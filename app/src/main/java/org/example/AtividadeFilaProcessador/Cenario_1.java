package org.example.AtividadeFilaProcessador;

public class Cenario_1 {
    static void main() {
        Servidor servidor = new Servidor(10,5,100);

        servidor.executar(5);
        servidor.relatorio();
    }
}
