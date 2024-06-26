package com.Modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Item extends Elementos {
    private Categoria categoria;
    private Comodo comodo;
    private int quantidade;
    private String validade;

    public Item(){}

    public Item(String nome, Categoria categoria, Comodo comodo, int quantidade, String validade) {
        super(nome); 
        this.categoria = categoria;
        this.comodo = comodo;
        this.quantidade = quantidade;
        this.validade = validade;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Comodo getComodo() {
        return comodo;
    }

    public void setComodo(Comodo comodo) {
        this.comodo = comodo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + getNome() + '\'' +
                ", quantidade=" + quantidade +
                ", validade='" + validade + '\'' +
                '}';
    }

    public boolean estaProximoValidade(int dias) {
        LocalDate hoje = LocalDate.now();
        LocalDate dataValidadeItem = LocalDate.parse(validade, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long diasRestantes = ChronoUnit.DAYS.between(hoje, dataValidadeItem);
        return diasRestantes <= dias && diasRestantes >= 0;
    }
}
