package com.Menus;

import com.Modelos.Categoria;
import com.Modelos.Comodo;
import com.Modelos.Item;
import com.Console;
import com.Util.JsonManager;
import java.util.List;

public class MenuAdministrador {

    public static void main(String[] args) {
        
    }

    public static void executarMenuAdministrador() {
        while (true) {
            System.out.println("\n=== Menu do Administrador ===");
            System.out.println("1. Ver Itens");
            System.out.println("2. Ver Comodos");
            System.out.println("3. Ver Categorias");
            System.out.println("4. Adicionar Item (Geral)");
            System.out.println("5. Adicionar Comodo");
            System.out.println("6. Adicionar Categoria");
            System.out.println("7. Adicionar Item a Categoria");
            System.out.println("8. Adicionar Item a Comodo");
            System.out.println("9. Remover Item (Geral)");
            System.out.println("10. Remover Item de Comodo");
            System.out.println("11. Remover Item de Categoria");
            System.out.println("0. Sair");
    
            int opcao = Console.lerInt("Escolha uma opção:");
    
            switch (opcao) {
                case 1:
                    verItens();
                    break;
                case 2:
                    verComodos();
                    break;
                case 3:
                    verCategorias();
                    break;
                case 4:
                    adicionarItemGeral();
                    break;
                case 5:
                    adicionarComodo();
                    break;
                case 6:
                    adicionarCategoria();
                    break;
                case 7:
                    adicionarItemACategoria();
                    break;
                case 8:
                    adicionarItemAComodo();
                    break;
                case 9:
                    removerItem();
                    break;
                case 10:
                    removerItemDeComodo();
                    break;
                case 11:
                    removerItemDeCategoria();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void verItens() {
        List<Item> itens = JsonManager.lerItensDoJson();
        System.out.println("\n=== Itens ===");
        for (Item item : itens) {
            System.out.println(item);
        }
    }

    private static void verComodos() {
        List<Comodo> comodos = JsonManager.lerComodos();
        System.out.println("\n=== Comodos ===");
        for (Comodo comodo : comodos) {
            System.out.println(comodo);
        }

        int opcaoComodo = Console.lerInt("digite 1 para voltar: ");

        if (opcaoComodo > 0 && opcaoComodo <= comodos.size()) {
            Comodo comodoSelecionado = comodos.get(opcaoComodo - 1);
            System.out.println("\nItens no Comodo " + comodoSelecionado.getNome() + ":");
            for (Item item : comodoSelecionado.getItens()) {
                System.out.println(item);
            }
        }
    }

    private static void verCategorias() {
        List<Categoria> categorias = JsonManager.lerCategorias();
        System.out.println("\n=== Categorias ===");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }

        int opcaoCategoria = Console.lerInt("digite 1 para voltar:");

        if (opcaoCategoria > 0 && opcaoCategoria <= categorias.size()) {
            Categoria categoriaSelecionada = categorias.get(opcaoCategoria - 1);
            System.out.println("\nItens na Categoria " + categoriaSelecionada.getNome() + ":");
            for (Item item : categoriaSelecionada.getItens()) {
                System.out.println(item);
            }
        }
    }

    private static void adicionarItemGeral() {
        String nomeItem = Console.lerString("Nome do Item:");
        int quantidade = Console.lerInt("Quantidade:");
        String validade = Console.lerString("Data de Validade (dd/MM/yyyy):");

        Item item = new Item(nomeItem, null, null, quantidade, validade);
        List<Item> itens = JsonManager.lerItensDoJson();
        itens.add(item);
        JsonManager.salvarItensNoJson(itens);
        System.out.println("Item adicionado com sucesso à lista geral de itens.");
    }

    private static void adicionarComodo() {
        String nomeComodo = Console.lerString("Nome do Comodo:");
        Comodo comodo = new Comodo(nomeComodo);
        List<Comodo> comodos = JsonManager.lerComodos();
        comodos.add(comodo);
        JsonManager.salvarComodos(comodos);
        System.out.println("Comodo adicionado com sucesso.");
    }

    private static void adicionarCategoria() {
        String nomeCategoria = Console.lerString("Nome da Categoria:");
        Categoria categoria = new Categoria(nomeCategoria);
        List<Categoria> categorias = JsonManager.lerCategorias();
        categorias.add(categoria);
        JsonManager.salvarCategorias(categorias);
        System.out.println("Categoria adicionada com sucesso.");
    }

    private static void adicionarItemACategoria() {
        List<Categoria> categorias = JsonManager.lerCategorias();
        System.out.println("\n=== Categorias ===");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i).getNome());
        }
    
        int opcaoCategoria = Console.lerInt("\nEscolha a categoria onde deseja adicionar o item:");
    
        if (opcaoCategoria > 0 && opcaoCategoria <= categorias.size()) {
            Categoria categoriaSelecionada = categorias.get(opcaoCategoria - 1);
    
            String nomeItem = Console.lerString("Nome do Item:");
    
            // Buscar o item pelo nome
            Item itemExistente = buscarItemPorNome(nomeItem);
    
            if (itemExistente != null) {
                categoriaSelecionada.adicionarItem(itemExistente);
                JsonManager.salvarCategorias(categorias);
                System.out.println("Item adicionado com sucesso à categoria " + categoriaSelecionada.getNome());
            } else {
                System.out.println("Item não encontrado com o nome fornecido.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    // Método para buscar um item pelo nome
    private static Item buscarItemPorNome(String nomeItem) {
        List<Item> itens = JsonManager.lerItensDoJson();
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return item;
            }
        }
        return null; // Retorna null se o item não for encontrado
    }
    

    private static void adicionarItemAComodo() {
        List<Comodo> comodos = JsonManager.lerComodos();
        System.out.println("\n=== Comodos ===");
        for (int i = 0; i < comodos.size(); i++) {
            System.out.println((i + 1) + ". " + comodos.get(i).getNome());
        }
    
        int opcaoComodo = Console.lerInt("\nEscolha o comodo onde deseja adicionar o item:");
    
        if (opcaoComodo > 0 && opcaoComodo <= comodos.size()) {
            Comodo comodoSelecionado = comodos.get(opcaoComodo - 1);
    
            String nomeItem = Console.lerString("Nome do Item:");
    
            // Buscar o item pelo nome
            Item itemExistente = buscarItemPorNome(nomeItem);
    
            if (itemExistente != null) {
                comodoSelecionado.adicionarItem(itemExistente);
                JsonManager.salvarComodos(comodos);
                System.out.println("Item adicionado com sucesso ao comodo " + comodoSelecionado.getNome());
            } else {
                System.out.println("Item não encontrado com o nome fornecido.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    public static void removerItem() {
        String nomeItem = Console.lerString("Digite o nome do item que deseja remover:");
        JsonManager.removerItem(nomeItem);
    }

    private static void removerItemDeCategoria() {
        List<Categoria> categorias = JsonManager.lerCategorias();
        System.out.println("\n=== Categorias ===");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i).getNome());
        }
    
        int opcaoCategoria = Console.lerInt("\nEscolha a categoria onde deseja remover o item:");
    
        if (opcaoCategoria > 0 && opcaoCategoria <= categorias.size()) {
            Categoria categoriaSelecionada = categorias.get(opcaoCategoria - 1);
    
            String nomeItem = Console.lerString("Nome do Item:");
    
            // Buscar o item pelo nome na categoria selecionada
            Item itemExistente = categoriaSelecionada.buscarItemPorNome(nomeItem);
    
            if (itemExistente != null) {
                categoriaSelecionada.removerItem(itemExistente);
                JsonManager.salvarCategorias(categorias);
                System.out.println("Item removido com sucesso da categoria " + categoriaSelecionada.getNome());
            } else {
                System.out.println("Item não encontrado na categoria " + categoriaSelecionada.getNome());
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    
    private static void removerItemDeComodo() {
        List<Comodo> comodos = JsonManager.lerComodos();
        System.out.println("\n=== Comodos ===");
        for (int i = 0; i < comodos.size(); i++) {
            System.out.println((i + 1) + ". " + comodos.get(i).getNome());
        }
    
        int opcaoComodo = Console.lerInt("\nEscolha o comodo onde deseja remover o item:");
    
        if (opcaoComodo > 0 && opcaoComodo <= comodos.size()) {
            Comodo comodoSelecionado = comodos.get(opcaoComodo - 1);
    
            String nomeItem = Console.lerString("Nome do Item:");
    
            // Buscar o item pelo nome no comodo selecionado
            Item itemExistente = comodoSelecionado.buscarItemPorNome(nomeItem);
    
            if (itemExistente != null) {
                comodoSelecionado.removerItem(itemExistente);
                JsonManager.salvarComodos(comodos);
                System.out.println("Item removido com sucesso do comodo " + comodoSelecionado.getNome());
            } else {
                System.out.println("Item não encontrado no comodo " + comodoSelecionado.getNome());
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

  
}
