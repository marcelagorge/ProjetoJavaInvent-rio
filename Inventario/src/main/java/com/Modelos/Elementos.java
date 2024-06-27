package com.Modelos;

public abstract class Elementos {

    String nome;

    

    public Elementos() {
    }

    public Elementos(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}



