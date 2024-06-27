package com.Menus;

import com.Modelos.Categoria;
import com.Modelos.Comodo;
import com.Modelos.Item;
import com.Util.JsonManager;
import com.Console;

import java.util.List;

public class MenuUsuarioComum {

    public static void main(String[] args) {
        exibirMenu();
    }

    public static void exibirMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menu Usuário Comum ===");
            System.out.println("1. Ver Itens");
            System.out.println("2. Ver Categorias");
            System.out.println("3. Ver Cômodos");
            System.out.println("4. Sair");

            int opcao = Console.lerInt("\nEscolha uma opção:");

            switch (opcao) {
                case 1:
                    verItens();
                    break;
                case 2:
                    verCategorias();
                    break;
                case 3:
                    verComodos();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
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

    private static void verCategorias() {
        List<Categoria> categorias = JsonManager.lerCategorias();
        System.out.println("\n=== Categorias ===");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    private static void verComodos() {
        List<Comodo> comodos = JsonManager.lerComodos();
        System.out.println("\n=== Cômodos ===");
        for (Comodo comodo : comodos) {
            System.out.println(comodo);
        }
    }
}
