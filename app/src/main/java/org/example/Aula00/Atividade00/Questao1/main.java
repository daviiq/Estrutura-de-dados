package org.example.Aula00.Atividade00.Questao1;

public class main {
    static void main() {

        Funcionario gustavo = new Funcionario("Gustavo",  2000);
        Funcionario davi = new Funcionario("Davi", 4000);
        Funcionario gabriel = new Funcionario("gabriel", 2000);
        Gerente loulou = new Gerente("Loulou", 10000);

        Projeto projeto1 = new Projeto("Grupo", 01, loulou,true);
        projeto1.adicionarFuncionario(gustavo);
        projeto1.adicionarFuncionario(gabriel);
        projeto1.adicionarFuncionario(davi);

        projeto1.listarInfoProjeto();



    }
}
