package org.example.FIlas;
import java.util.Arrays;

public class Fila <T extends Comparable>{
    private T[] elementos;
    private int tamanho;

    public Fila(int capacidade){
        this.elementos = (T[]) new Comparable[capacidade];
        this.tamanho = 0;
    }

    public void enfileirar(T elemento){
        if(tamanho == elementos.length){
            throw new RuntimeException("Fila Cheia");
        }

        elementos[tamanho] = elemento;
        tamanho++;
    }

    public int capacidade() {
        return elementos.length;
    }

    public boolean isEmpty() {
        return tamanho ==0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public T desenfileirar(){
        if(isEmpty()){
            throw new RuntimeException("Fila Vazia");
        }
        T elemento = elementos[0];
        for (int i = 0; i <tamanho ; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho-1] = null;
        tamanho --;
        return elemento;
    }

    public T peak(){
        if(isEmpty()){
            throw new RuntimeException("Fila Vazia");
        }

        return elementos[0];
    }

    @Override
    public String toString() {
        return "Fila{" +
                "elementos=" + Arrays.toString(elementos) +
                ", tamanho=" + tamanho +
                '}';
    }

    public void imprimir(){
        if(isEmpty()){
            throw new RuntimeException("Fila Vazia");
        }else{
            System.out.println("Fila: ");
            for (int i = 0; i <tamanho ; i++) {
                System.out.println(elementos[i] + "");
            }
            System.out.println();
        }
    }
}