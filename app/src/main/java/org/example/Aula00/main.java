package org.example.Aula00;

public class main {
    static void main() {
        VetorEstatico vetorEstatico = new VetorEstatico(5);

       vetorEstatico.inserir(0,"A");
       vetorEstatico.inserir(1,"B");
       vetorEstatico.inserir(2,"C");
       vetorEstatico.inserir(3,"D");
       vetorEstatico.inserir(4,"E");
       vetorEstatico.removerFinal();
       vetorEstatico.remover(1);
       vetorEstatico.imprimir();

        System.out.println("");
        System.out.println("O tamanho do array é: " + "" +vetorEstatico.obterTamanho());
    }
}
