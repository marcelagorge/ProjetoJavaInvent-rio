package APIs;

import java.util.ArrayList;
import java.util.List;
import Modelos.Categoria;

public class CategoriaAPI {
    private List<Categoria> categorias;

    public CategoriaAPI() {
        this.categorias = new ArrayList<>();
    }

    // Método para adicionar uma nova categoria
    public void adicionarCategoria(String nome) {
        Categoria categoria = new Categoria(nome);
        categorias.add(categoria);
    }

    // Método para listar todas as categorias
    public List<Categoria> listarCategorias() {
        return categorias;
    }

    // Método para buscar uma categoria pelo nome
    public Categoria buscarCategoria(String nome) {
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nome)) {
                return categoria;
            }
        }
        return null; // Retorna null se não encontrar a categoria
    }

    // Método para remover uma categoria pelo nome
    public boolean removerCategoria(String nome) {
        Categoria categoria = buscarCategoria(nome);
        if (categoria != null) {
            categorias.remove(categoria);
            return true; // Retorna true se a categoria foi removida com sucesso
        }
        return false; // Retorna false se a categoria não foi encontrada
    }
}
