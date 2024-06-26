package APIs;

import java.util.ArrayList;
import java.util.List;
import Modelos.Comodo;
import Modelos.Item;

public class ComodoAPI {
    private List<Comodo> comodos;
    private List<Item> itensDisponiveis; // Lista de todos os itens disponíveis

    public ComodoAPI() {
        this.comodos = new ArrayList<>();
        this.itensDisponiveis = new ArrayList<>(); // Inicializar lista de itens disponíveis
    }

    // Método para adicionar um novo quarto
    public void adicionarComodo(String nome) {
        Comodo quarto = new Comodo(nome);
        comodos.add(quarto);
    }

    // Método para listar todos os cômodos
    public List<Comodo> listarComodos() {
        return comodos;
    }

    // Método para buscar um cômodo pelo nome
    public Comodo buscarComodo(String nome) {
        for (Comodo comodo : comodos) {
            if (comodo.getNome().equalsIgnoreCase(nome)) {
                return comodo;
            }
        }
        return null; // Retorna null se não encontrar o cômodo
    }

    // Método para adicionar um item a um cômodo específico, apenas se o item existir na lista de itens disponíveis
    public void adicionarItemAoComodo(String nomeComodo, Item item) {
        if (itensDisponiveis.contains(item)) { // Verifica se o item está na lista de itens disponíveis
            Comodo comodo = buscarComodo(nomeComodo);
            if (comodo != null) {
                comodo.getItens().add(item);
            }
        }
    }

    // Método para remover um item de um cômodo específico pelo nome do item
    public boolean removerItemDoComodo(String nomeComodo, String nomeItem) {
        Comodo comodo = buscarComodo(nomeComodo);
        if (comodo != null) {
            List<Item> itens = comodo.getItens();
            for (Item item : itens) {
                if (item.getNome().equalsIgnoreCase(nomeItem)) {
                    itens.remove(item);
                    return true; // Retorna true se o item foi removido com sucesso
                }
            }
        }
        return false; // Retorna false se o cômodo não foi encontrado ou o item não foi encontrado no cômodo
    }

    // Método para adicionar um novo item à lista de itens disponíveis
    public void adicionarItemDisponivel(Item item) {
        itensDisponiveis.add(item);
    }

    // Método para listar todos os itens disponíveis
    public List<Item> listarItensDisponiveis() {
        return itensDisponiveis;
    }
}
