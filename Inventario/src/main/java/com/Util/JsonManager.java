package com.Util;

import com.Modelos.Categoria;
import com.Modelos.Comodo;
import com.Modelos.Item;
import com.Modelos.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {

    private static final String ITENS_JSON_FILE = "itens.json";
    private static final String COMODOS_JSON_FILE = "comodos.json";
    private static final String CATEGORIAS_JSON_FILE = "categorias.json";
    private static final String USERS_JSON_FILE = "users.json";

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Método para ler itens do JSON
    public static List<Item> lerItensDoJson() {
        List<Item> itens = new ArrayList<>();
        try (FileReader reader = new FileReader(ITENS_JSON_FILE)) {
            Type itemListType = new TypeToken<List<Item>>() {}.getType();
            itens = gson.fromJson(reader, itemListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itens;
    }

    // Método para salvar itens no JSON
    public static void salvarItensNoJson(List<Item> itens) {
        try (FileWriter writer = new FileWriter(ITENS_JSON_FILE)) {
            gson.toJson(itens, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos semelhantes para comodos e categorias...

    // Método para ler comodos do JSON
    public static List<Comodo> lerComodos() {
        List<Comodo> comodos = new ArrayList<>();
        try (FileReader reader = new FileReader(COMODOS_JSON_FILE)) {
            Type comodoListType = new TypeToken<List<Comodo>>() {}.getType();
            comodos = gson.fromJson(reader, comodoListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comodos;
    }

    // Método para salvar comodos no JSON
    public static void salvarComodos(List<Comodo> comodos) {
        try (FileWriter writer = new FileWriter(COMODOS_JSON_FILE)) {
            gson.toJson(comodos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para ler categorias do JSON
    public static List<Categoria> lerCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        try (FileReader reader = new FileReader(CATEGORIAS_JSON_FILE)) {
            Type categoriaListType = new TypeToken<List<Categoria>>() {}.getType();
            categorias = gson.fromJson(reader, categoriaListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categorias;
    }

    // Método para salvar categorias no JSON
    public static void salvarCategorias(List<Categoria> categorias) {
        try (FileWriter writer = new FileWriter(CATEGORIAS_JSON_FILE)) {
            gson.toJson(categorias, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void adicionarItemEmCategoria(Categoria categoria, Item item) {
        List<Categoria> categorias = lerCategorias();
        for (Categoria cat : categorias) {
            if (cat.getNome().equals(categoria.getNome())) {
                cat.adicionarItem(item); // Assumindo que existe um método adicionarItem na classe Categoria
                break;
            }
        }
        salvarCategorias(categorias);
    }

    public static void adicionarItemEmComodo(Comodo comodo, Item item) {
        List<Comodo> comodos = lerComodos();
        for (Comodo com : comodos) {
            if (com.getNome().equals(comodo.getNome())) {
                com.adicionarItem(item); // Assumindo que existe um método adicionarItem na classe Comodo
                break;
            }
        }
        salvarComodos(comodos);
    }

    public static void removerItem(String nomeItem) {
        List<Item> itens = lerItensDoJson();
        Item itemRemovido = null;
        
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemRemovido = item;
                break;
            }
        }
        
        if (itemRemovido != null) {
            itens.remove(itemRemovido);
            salvarItensNoJson(itens);
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    public static void removerItemDeCategoria(Categoria categoria, Item item) {
        List<Categoria> categorias = lerCategorias();
        for (Categoria cat : categorias) {
            if (cat.getNome().equals(categoria.getNome())) {
                cat.removerItem(item);
                break;
            }
        }
        salvarCategorias(categorias);
    }
    
    public static void removerItemDeComodo(Comodo comodo, Item item) {
        List<Comodo> comodos = lerComodos();
        for (Comodo com : comodos) {
            if (com.getNome().equals(comodo.getNome())) {
                com.removerItem(item);
                break;
            }
        }
        salvarComodos(comodos);
    }

    public static List<Usuario> lerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (FileReader reader = new FileReader(USERS_JSON_FILE)) {
            Type userListType = new TypeToken<List<Usuario>>() {}.getType();
            usuarios = gson.fromJson(reader, userListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public static void salvarUsuarios(List<Usuario> usuarios) {
        try (FileWriter writer = new FileWriter(USERS_JSON_FILE)) {
            gson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void adicionarUsuario(Usuario usuario) {
        List<Usuario> usuarios = lerUsuarios();
        usuarios.add(usuario);
        salvarUsuarios(usuarios);
    }
}


