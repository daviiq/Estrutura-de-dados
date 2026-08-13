package org.example.Aula00.Atividade00.Questao1;

public class Funcionario {
    protected String nome;
    protected double salarioBase;

    public double getSalario(Projeto projeto){
        if(projeto.isFinalizado()) {
            return salarioBase * 1.1;
        }
        return salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario(String nome, double salarioBase){
        this.salarioBase = salarioBase;
        this.nome = nome;
    }
}
