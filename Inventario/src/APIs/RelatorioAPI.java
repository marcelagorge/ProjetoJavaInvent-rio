package APIs;

import Modelos.Comodo;
import Modelos.Item;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioAPI {
    private List<Item> itensDisponiveis; // Lista de todos os itens disponíveis
    private List<Comodo> comodos; // Lista de todos os cômodos

    public RelatorioAPI(List<Item> itensDisponiveis, List<Comodo> comodos) {
        this.itensDisponiveis = itensDisponiveis;
        this.comodos = comodos;
    }

    // Método para listar itens por cômodo
    public Map<String, List<Item>> listarItensPorComodo() {
        Map<String, List<Item>> itensPorComodo = new HashMap<>();

        // Inicializa as listas de itens por cômodo
        for (Comodo comodo : comodos) {
            itensPorComodo.put(comodo.getNome(), new ArrayList<>());
        }

        // Agrupa os itens por cômodo
        for (Item item : itensDisponiveis) {
            for (Comodo comodo : comodos) {
                if (comodo.getItens().contains(item)) {
                    itensPorComodo.get(comodo.getNome()).add(item);
                }
            }
        }

        return itensPorComodo;
    }

    // Método para listar itens próximos da validade
    public List<Item> listarItensProximosValidade(int dias) {
        LocalDate hoje = LocalDate.now();
        return itensDisponiveis.stream()
                .filter(item -> estaProximoValidade(item.getDataValidade(), hoje, dias))
                .collect(Collectors.toList());
    }

    // Método para verificar se um item está próximo da validade
    private boolean estaProximoValidade(String dataValidadeItem, LocalDate hoje, int dias) {
        LocalDate dataValidade = LocalDate.parse(dataValidadeItem, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long diasRestantes = ChronoUnit.DAYS.between(hoje, dataValidade);
        return diasRestantes <= dias && diasRestantes >= 0;
    }

    // Getters e setters
    public List<Item> getItensDisponiveis() {
        return itensDisponiveis;
    }

    public void setItensDisponiveis(List<Item> itensDisponiveis) {
        this.itensDisponiveis = itensDisponiveis;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }
}
