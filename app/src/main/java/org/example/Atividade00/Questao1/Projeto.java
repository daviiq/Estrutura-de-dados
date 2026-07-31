package org.example.Atividade00.Questao1;
import java.util.ArrayList;
public class Projeto {

    private String nome;
    private int ID;
    private Gerente gerente;
    private ArrayList<Funcionario> equipe;
    private boolean finalizado;

    public Projeto(String nome, int ID, Gerente gerente, boolean estado) {
        this.nome = nome;
        this.ID = ID;
        this.gerente = gerente;
        this.finalizado = estado;
        this.equipe = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public ArrayList<Funcionario> getEquipe() {
        return equipe;
    }

    public int getQuantidadeFuncionarios() {
        return equipe.toArray().length;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public double calcularCustoTotal() {

        double total = gerente.getSalario(this);

        for (Funcionario funcionario : equipe) {
            total += funcionario.getSalario(this);
        }
        return total;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        equipe.add(funcionario);
    }

    /*Lista as informações gerais do projeto
    Eu sei que não deveria colocar Sout aqui, mas acredito que como seria um projeto
    simples, não vejo problema de otimizar o tempo
     */

    public void listarInfoProjeto() {

        System.out.println("Projeto: " + nome);

        System.out.println("\nGerente:");
        System.out.println(gerente.getNome() +
                " - R$ " + gerente.getSalario(this));

        System.out.println("\nEquipe: "+getNome());

        for (Funcionario funcionario : equipe) {
            System.out.println(funcionario.getNome() +
                    " - R$ " + funcionario.getSalario(this));
        }

        System.out.println("\nCusto total: R$ " + calcularCustoTotal());
    }
}
