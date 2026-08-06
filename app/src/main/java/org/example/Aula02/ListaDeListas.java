package org.example.Aula02;

import org.example.Aula00.VetorEstatico;

public class ListaDeListas {

    private VetorEstatico[] nomesLetras;

    public ListaDeListas() {
        nomesLetras = new VetorEstatico[26];
        //Cria os Arrays verticais, formando a lista de listas
        for (int i = 0; i < nomesLetras.length; i++) {
            nomesLetras[i] = new VetorEstatico(20);
        }
    }

    public void inserir(String nome) {
        char letra = Character.toUpperCase(nome.charAt(0));
        int indice = letra - 'A';
        nomesLetras[indice].inserir(indice,nome);
    }

    public void imprimir() {
        for (int i = 0; i < 26 ; i++) {
            char letra = (char) ('A' + i);
            System.out.print(letra + " ");
            nomesLetras[i].imprimir();
        }
    }
}
