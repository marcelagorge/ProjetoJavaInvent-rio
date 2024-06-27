package com.Modelos;

import java.util.ArrayList;
import java.util.List;

public class Comodo extends Elementos {
    private List<Item> itens;

    public Comodo(String nome) {
        super(nome); // Chama o construtor da classe Elementos que recebe um nome
        this.itens = new ArrayList<>();
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
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
        return "Comodo{" +
                "nome='" + getNome() + '\'' +
                ", itens=" + itens +
                '}';
    }
}
