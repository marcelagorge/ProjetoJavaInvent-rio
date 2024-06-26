package com.Util;

import com.Modelos.Categoria;
import com.Modelos.Comodo;
import com.Modelos.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class LeitorDados {

    private static final String ARQUIVO_CATEGORIAS = "src/main/resources/categorias.json";
    private static final String ARQUIVO_COMODOS = "src/main/resources/comodos.json";
    private static final String ARQUIVO_ITENS = "src/main/resources/itens.json";
    
    public List<Categoria> carregarCategorias() throws IOException {
        Gson gson = new Gson();
        List<Categoria> categorias = new ArrayList<>();

        try (Reader reader = new FileReader(ARQUIVO_CATEGORIAS)) {
            Categoria[] categoriasArray = gson.fromJson(reader, Categoria[].class);
            for (Categoria categoria : categoriasArray) {
                categorias.add(categoria);
            }
        }

        return categorias;
    }

    public List<Comodo> carregarComodos() throws IOException {
        Gson gson = new Gson();
        List<Comodo> comodos = new ArrayList<>();

        try (Reader reader = new FileReader(ARQUIVO_COMODOS)) {
            Comodo[] comodosArray = gson.fromJson(reader, Comodo[].class);
            for (Comodo comodo : comodosArray) {
                comodos.add(comodo);
            }
        }

        return comodos;
    }

    public List<Item> carregarItens() throws IOException {
        Gson gson = new Gson();
        List<Item> itens = new ArrayList<>();

        try (Reader reader = new FileReader(ARQUIVO_ITENS)) {
            Item[] itensArray = gson.fromJson(reader, Item[].class);
            for (Item item : itensArray) {
                itens.add(item);
            }
        }

        return itens;
    }
}
