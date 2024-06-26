package APIs;

import java.util.ArrayList;
import java.util.List;
import Modelos.Item;

public class ItemAPI {
    private List<Item> itens;

    public ItemAPI() {
        this.itens = new ArrayList<>();
    }

    // Método para adicionar um novo item
    public void adicionarItem(String nome, String dataValidade, int quantidade) {
        Item item = new Item(nome, dataValidade, quantidade);
        itens.add(item);
    }

    // Método para listar todos os itens
    public List<Item> listarItens() {
        return itens;
    }

    // Método para buscar um item pelo nome
    public Item buscarItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null; // Retorna null se não encontrar o item
    }

    // Método para remover um item pelo nome
    public boolean removerItem(String nome) {
        Item item = buscarItem(nome);
        if (item != null) {
            itens.remove(item);
            return true; // Retorna true se o item foi removido com sucesso
        }
        return false; // Retorna false se o item não foi encontrado
    }
}

