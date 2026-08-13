package org.example.Aula00.Atividade00.Questao1;

public class Gerente extends Funcionario{


    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double getSalario(Projeto projeto){
        salarioBase = salarioBase*(1+ (double) projeto.getQuantidadeFuncionarios()/100);

        if (projeto.isFinalizado()) {
            return salarioBase * 1.1;
        }
        return salarioBase;
    }

}
