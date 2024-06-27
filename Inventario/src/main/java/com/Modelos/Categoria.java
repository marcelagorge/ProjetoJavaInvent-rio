package com.Modelos;

import java.util.ArrayList;
import java.util.List;

public class Categoria extends Elementos {
    private List<Item> itens;

    public Categoria() {
        this.itens = new ArrayList<>();
    }

    public Categoria(String nome) {
        super(nome); // Chama o construtor da classe Elementos que recebe um nome
        this.itens = new ArrayList<>();
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    // Métodos para adicionar, remover, buscar itens na lista
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public Item buscarItemPorNome(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + getNome() + '\'' +
                ", itens=" + itens +
                '}';
    }
}
