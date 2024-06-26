package com;

import com.Modelos.Item;
import com.Servicos.ItemService;
import com.Util.LeitorDados;
import com.Util.SaidaDados;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);
    private static LeitorDados leitorDados = new LeitorDados(); 
    private static SaidaDados saidaDados = new SaidaDados(); 

    public static String lerString(String msg) {
        System.out.print(msg + " ");
        String valor = leitor.nextLine();
        return valor;
    }

    public static int lerInt(String msg) {
        int valor = 0;

        while (true) {
            try {
                System.out.print(msg + " ");
                valor = leitor.nextInt();
                break;

            } catch (InputMismatchException e) {
                System.out.println("O valor digitado não é do tipo 'int'");
                leitor.nextLine(); // Limpar o buffer do scanner
            }
        }

        return valor;
    }

    public static float lerFloat(String msg) {
        float valor = 0;
        while (true) {
            try {
                System.out.print(msg + " ");
                valor = leitor.nextFloat();
                break;

            } catch (InputMismatchException e) {
                System.out.println("O valor digitado não é do tipo 'float'");
                leitor.nextLine(); // Limpar o buffer do scanner
            }
        }
        return valor;
    }

    private static ItemService itemService = new ItemService();

    public static void main(String[] args) {
        int diasParaValidade = 7; // Itens que expiram nos próximos 7 dias
        int quantidadeMinima = 1; // Quantidade mínima para reabastecimento

        // Verificar itens próximos da validade que precisam ser reabastecidos
        List<Item> itensProximosReabastecimento = itemService.verificarItensProximosReabastecimento(diasParaValidade, quantidadeMinima);

        // Exibindo os itens que precisam ser reabastecidos
        if (!itensProximosReabastecimento.isEmpty()) {
            System.out.println("Itens próximos da validade que precisam ser reabastecidos:");
            for (Item item : itensProximosReabastecimento) {
                System.out.println(item.getNome() + " - Quantidade atual: " + item.getQuantidade() + ", Validade: " + item.getValidade());
            }
        } else {
            System.out.println("Nenhum item próximo da validade precisa ser reabastecido.");
        }
    }
    
}
