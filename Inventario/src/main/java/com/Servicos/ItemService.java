package com.Servicos;

import com.Modelos.Item;
import com.Util.LeitorDados;
import com.Util.SaidaDados;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ItemService {

    private LeitorDados leitorDados;
    private SaidaDados saidaDados;
    private List<Item> itens;

    public ItemService() {
        leitorDados = new LeitorDados();
        saidaDados = new SaidaDados();
        carregarItens();
    }

    private void carregarItens() {
        try {
            itens = leitorDados.carregarItens();
        } catch (IOException e) {
            itens = new ArrayList<>();
            System.err.println("Erro ao carregar itens: " + e.getMessage());
        }
    }

    public List<Item> listarItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        salvarItens();
    }

    public void removerItem(Item item) {
        itens.remove(item);
        salvarItens();
    }

    public void editarItem(Item itemAntigo, Item itemNovo) {
        int index = itens.indexOf(itemAntigo);
        if (index != -1) {
            itens.set(index, itemNovo);
            salvarItens();
        }
    }

    public Item buscarItemPorNome(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    private void salvarItens() {
        try {
            saidaDados.salvarItens(itens);
        } catch (IOException e) {
            System.err.println("Erro ao salvar itens: " + e.getMessage());
        }
    }

    // Método para verificar itens próximos da validade
    public List<Item> verificarItensProximosValidade(int dias) {
        List<Item> itensProximosValidade = new ArrayList<>();
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Item item : itens) {
            LocalDate dataValidadeItem = LocalDate.parse(item.getValidade(), formatter);
            long diasRestantes = ChronoUnit.DAYS.between(hoje, dataValidadeItem);
            if (diasRestantes <= dias && diasRestantes >= 0) {
                itensProximosValidade.add(item);
            }
        }
        return itensProximosValidade;
    }

    // Método para simular envio de notificações (printar mensagens no console)
    public void enviarNotificacoes(List<Item> itensNotificar) {
        System.out.println("Itens próximos da validade:");
        for (Item item : itensNotificar) {
            System.out.println(item.getNome() + " - Validade: " + item.getValidade());
        }
    }
    
    // Método para verificar itens próximos da validade que precisam ser reabastecidos
public List<Item> verificarItensProximosReabastecimento(int dias, int quantidadeMinima) {
    List<Item> itensProximosReabastecimento = new ArrayList<>();
    LocalDate hoje = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    for (Item item : itens) {
        LocalDate dataValidadeItem = LocalDate.parse(item.getValidade(), formatter);
        long diasRestantes = ChronoUnit.DAYS.between(hoje, dataValidadeItem);
        
        // Verificar se o item está próximo da validade e a quantidade disponível é insuficiente
        if (diasRestantes <= dias && diasRestantes >= 0 && item.getQuantidade() < quantidadeMinima) {
            itensProximosReabastecimento.add(item);
        }
    }
    return itensProximosReabastecimento;
}
}
