package org.example.Aula08;

public class Main {
    static void main() {

        EditorTexto editorTexto = new EditorTexto();

        editorTexto.escrever("Ola");
        editorTexto.escrever("Mundo");

        System.out.println("Conteúdo atual: " + editorTexto.getConteudo());

        editorTexto.desfazer();
        System.out.println("Conteúdo após o desfazer: " + editorTexto.getConteudo());

        editorTexto.refazer();
        System.out.println("Conteúdo após o refazer: " + editorTexto.getConteudo());
    }
}
