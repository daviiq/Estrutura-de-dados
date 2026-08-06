package org.example.Aula01.Atividade01;

public class main {
    static void main() {
        Contato contato1 = new Contato("Davi", "48991231718");
        Agenda agenda = new Agenda(5);

        agenda.inserir(1,contato1);
        agenda.listarContatos();
    }
}
