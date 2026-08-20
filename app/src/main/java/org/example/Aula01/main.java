package org.example.Aula01;

import org.example.Aula01.Atividade01.Agenda;
import org.example.Aula01.Atividade01.Contato;

public class main {
    static void main() {
        Contato contato1 = new Contato("Davi", "48991231718");
        Contato contato2 = new Contato("Pedro","1234541211");
        Agenda<Contato> agenda = new Agenda<>(10);

        agenda.inserir(0,contato1);
        agenda.remover(contato1);
        agenda.inserir(0,contato2);
        agenda.buscarContato("Pedro","1234541211");

        System.out.println("\n--- Lista de Contatos ---");
        agenda.listarContatos();
    }
}
