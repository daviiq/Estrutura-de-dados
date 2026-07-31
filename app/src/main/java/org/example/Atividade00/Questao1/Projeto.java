package org.example.Atividade00.Questao1;

public class Projeto {

    private String nome;
    private int ID;
    private Gerente gerente;
    private Funcionario[] equipe;
    private boolean finalizado;

    public Projeto(String nome, int ID, Gerente gerente, Funcionario[] equipe, boolean finalizado) {
        this.nome = nome;
        this.ID = ID;
        this.gerente = gerente;
        this.equipe = equipe;
        this.finalizado = finalizado;
    }

    //Nome do projeto
    public String getNome() {
        return nome;
    }

    //Verifica se está finalizado
    public boolean isFinalizado() {
        return finalizado;
    }

    //Retorna o Array da equipe
    public Funcionario[] getEquipe() {
        return equipe;
    }

    //Retorna a quantidade de funcionários na equipe
    public int getQuantidadeFuncionarios() {
        return equipe.length;
    }

    //Retorna as informações do gerente
    public Gerente getGerente() {
        return gerente;
    }

    //Calcula o Custo total do projeto
    public double calcularCustoTotal() {

        double total = gerente.getSalario(this);

        for (Funcionario funcionario : equipe) {
            total += funcionario.getSalario(this);
        }
        return total;
    }

    //Adiciona o funcionário na equipe do projeto
    public void adicionarFuncionario(Funcionario funcionario, int posicao) {
        equipe[posicao] = funcionario;
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

        System.out.println("\nEquipe:");

        for (Funcionario funcionario : equipe) {
            System.out.println(funcionario.getNome() +
                    " - R$ " + funcionario.getSalario(this));
        }

        System.out.println("\nCusto total: R$ " + calcularCustoTotal());
    }
}
