package org.example.Aula00;

public class main {
    static void main() {
        VetorEstatico vetorEstatico = new VetorEstatico(5);

       vetorEstatico.inserir(0,"A");
       vetorEstatico.inserir(1,"A");
       vetorEstatico.inserir(2,"A");
       vetorEstatico.inserir(3,"C");
       vetorEstatico.inserir(4,"D");
       vetorEstatico.removerFinal();
       vetorEstatico.imprimir();

        System.out.println(vetorEstatico.obterTamanho());


    }
}
