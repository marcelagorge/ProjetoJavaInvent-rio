package com.Servicos;

import com.Modelos.Item;
import com.Modelos.Categoria;
import com.Util.LeitorDados;
import com.Util.SaidaDados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaService {

    private LeitorDados leitorDados;
    private SaidaDados saidaDados;
    private List<Categoria> categorias;

    public CategoriaService() {
        leitorDados = new LeitorDados();
        saidaDados = new SaidaDados();
        carregarCategorias();
    }

    private void carregarCategorias() {
        try {
            categorias = leitorDados.carregarCategorias();
        } catch (IOException e) {
            categorias = new ArrayList<>();
            System.err.println("Erro ao carregar categorias: " + e.getMessage());
        }
    }

    public List<Categoria> listarCategorias() {
        return categorias;
    }

    public void adicionarCategoria(Categoria categoria) {
        categorias.add(categoria);
        salvarCategorias();
    }

    public void removerCategoria(Categoria categoria) {
        categorias.remove(categoria);
        salvarCategorias();
    }

    public void editarCategoria(Categoria categoriaAntiga, Categoria categoriaNova) {
        int index = categorias.indexOf(categoriaAntiga);
        if (index != -1) {
            categorias.set(index, categoriaNova);
            salvarCategorias();
        }
    }

    public Categoria buscarCategoria(String nome) {
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nome)) {
                return categoria;
            }
        }
        return null;
    }

    private void salvarCategorias() {
        try {
            saidaDados.salvarCategorias(categorias);
        } catch (IOException e) {
            System.err.println("Erro ao salvar categorias: " + e.getMessage());
        }
    }

    // Método para gerar relatório de itens por categoria
    public void relatorioItensPorCategoria() {
        System.out.println("Relatório de Itens por Categoria:");
        for (Categoria categoria : categorias) {
            System.out.println("Categoria: " + categoria.getNome());
            for (Item item : categoria.getItens()) {
                System.out.println("  - " + item.getNome());
            }
            System.out.println();
        }
    }
}
