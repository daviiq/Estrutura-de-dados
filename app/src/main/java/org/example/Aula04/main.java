package org.example.Aula04;

import org.example.Vetores.Vetor;
import org.example.Vetores.VetorObjetos;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    static void main() {
        VetorObjetos vetorObjetos = new VetorObjetos(10);

        vetorObjetos.inserir("banana");
        vetorObjetos.inserir(1);
        vetorObjetos.inserir(3.5);

        //Dessa forma precisamos fazer TypeCasts para resolver o problema

        String palavra = (String) vetorObjetos.ler(0);
        int numero = (Integer) vetorObjetos.ler(1);
        double preco = (Double) vetorObjetos.ler(2);

        //Desta forma, conseguimos armazenar um tipo de dado simples
        //De forma genárica
        Caixa<String> caixaFoda = new Caixa<>();
        caixaFoda.guardar("Algo foda aqui embaixo");
        System.out.println(caixaFoda.abrir());

        Caixa<Integer> caixaNum = new Caixa<>();
        caixaNum.guardar(67);
        System.out.println(caixaNum.abrir());

        Vetor<Produto> estoque = new Vetor<>(10);
        estoque.inserir(1,new Produto(1,"Pão",7.99));
        estoque.inserir(2,new Produto(2,"PEDRA",7.99));

        List<String> listas = new ArrayList<>();
    }
}
