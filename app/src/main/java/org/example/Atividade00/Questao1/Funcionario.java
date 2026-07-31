package org.example.Atividade00.Questao1;

public class Funcionario {
    protected String nome;
    protected double salarioBase;

    public double getSalario(Projeto projeto){
        if(projeto.getStatus().equals("finalizado"){
            return salarioBase * 1.1;
        }
        return salarioBase;
    }

    public Funcionario(String nome, double salarioBase){
        this.salarioBase = salarioBase;
        this.nome = nome;
    }

}
