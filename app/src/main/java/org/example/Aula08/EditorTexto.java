package org.example.Aula08;

import java.util.Stack;

public class EditorTexto {

    private Stack<String> desfazer;
    private Stack<String> refazer;
    private String conteudo;

    public EditorTexto() {
        this.conteudo = "";
        this.refazer = new Stack<>();
        this.desfazer = new Stack<>();
    }
    
    public void escrever(String texto) {
        desfazer.push(texto);
        conteudo += texto;
        
        //Limpando pilha de refazer
        this.refazer = new Stack<>();
    }
    
    public void desfazer() {
        if (!desfazer.isEmpty()) {
            refazer.push(conteudo);
            desfazer.pop();

            while (!desfazer.isEmpty()) {
                conteudo = desfazer.pop();
            }
        } else {
            System.out.println("Nada para desfazer");
        }
    }
    
    public void refazer() {
        if(!refazer.isEmpty()) {
            desfazer.push(conteudo);
            conteudo = refazer.pop();
        }

    }

    public String getConteudo() {
        return this.conteudo;
    }
}
