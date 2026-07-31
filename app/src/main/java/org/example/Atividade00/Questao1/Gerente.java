package org.example.Atividade00.Questao1;

public class Gerente extends Funcionario{
    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double getSalario(Projeto projeto){
        salarioBase = salarioBase*(1+getFuncionarios()/100);

        if(projeto.getStatus().equals("finalizado"){
            return salarioBase * 1.1;
        }
        return salarioBase;
    }
}
