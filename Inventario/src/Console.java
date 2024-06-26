import APIs.RelatorioAPI;
import Modelos.Item;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);

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

    public static void exibirMenu(RelatorioAPI relatorioAPI) {
        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu de Relatórios ===");
            System.out.println("1. Relatório de Itens por Categoria");
            System.out.println("2. Relatório de Itens Próximos da Validade");
            System.out.println("3. Relatório de Itens por Cômodo");
            System.out.println("0. Sair");
            int opcao = lerInt("Escolha uma opção:");

            switch (opcao) {
                case 1:
                    exibirRelatorioItensPorCategoria(relatorioAPI);
                    break;
                case 2:
                    exibirRelatorioItensProximosValidade(relatorioAPI);
                    break;
                case 3:
                    exibirRelatorioItensPorComodo(relatorioAPI);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }

    private static void exibirRelatorioItensPorCategoria(RelatorioAPI relatorioAPI) {
        System.out.println("=== Relatório de Itens por Categoria ===");
        List<Item> itensDisponiveis = relatorioAPI.getItensDisponiveis();

        for (Item item : itensDisponiveis) {
            System.out.println("- " + item.getNome());
        }
        System.out.println();
    }

    private static void exibirRelatorioItensProximosValidade(RelatorioAPI relatorioAPI) {
        System.out.println("=== Relatório de Itens Próximos da Validade ===");
        int dias = lerInt("Digite o número de dias para listar itens próximos da validade:");
        List<Item> itensProximosValidade = relatorioAPI.listarItensProximosValidade(dias);

        for (Item item : itensProximosValidade) {
            LocalDate dataValidade = LocalDate.parse(item.getDataValidade(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("- " + item.getNome() + " - Data de Validade: " + dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        System.out.println();
    }

    private static void exibirRelatorioItensPorComodo(RelatorioAPI relatorioAPI) {
        System.out.println("=== Relatório de Itens por Cômodo ===");
        Map<String, List<Item>> itensPorComodo = relatorioAPI.listarItensPorComodo();

        for (Map.Entry<String, List<Item>> entry : itensPorComodo.entrySet()) {
            String nomeComodo = entry.getKey();
            List<Item> itens = entry.getValue();

            System.out.println("Comodo: " + nomeComodo);
            for (Item item : itens) {
                System.out.println("- " + item.getNome());
            }
            System.out.println();
        }
    }
}
