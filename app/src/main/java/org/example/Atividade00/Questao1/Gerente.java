package org.example.Atividade00.Questao1;

public class Gerente extends Funcionario{

    public String nome;
    public double salarioBase;

    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double getSalario(Projeto projeto){
        //TypeCast para ambos darem o mesmo resultado de certeza
        //To obrigando ao resultado ser double
        salarioBase = salarioBase*(1+ (double) projeto.getQuantidadeFuncionarios()/100);

        if (projeto.isFinalizado()) {
            return salarioBase * 1.1;
        }
        return salarioBase;
    }

    public String getNome() {
        return nome;
    }
}
