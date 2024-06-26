package com.Servicos;

import com.Modelos.Comodo;
import com.Util.LeitorDados;
import com.Util.SaidaDados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ComodoService {

    private LeitorDados leitorDados;
    private SaidaDados saidaDados;
    private List<Comodo> comodos;

    public ComodoService() {
        leitorDados = new LeitorDados();
        saidaDados = new SaidaDados();
        carregarComodos();
    }

    private void carregarComodos() {
        try {
            comodos = leitorDados.carregarComodos();
        } catch (IOException e) {
            comodos = new ArrayList<>();
            System.err.println("Erro ao carregar cômodos: " + e.getMessage());
        }
    }

    public List<Comodo> listarComodos() {
        return comodos;
    }

    public void adicionarComodo(Comodo comodo) {
        comodos.add(comodo);
        salvarComodos();
    }

    public void removerComodo(Comodo comodo) {
        comodos.remove(comodo);
        salvarComodos();
    }

    public void editarComodo(Comodo comodoAntigo, Comodo comodoNovo) {
        int index = comodos.indexOf(comodoAntigo);
        if (index != -1) {
            comodos.set(index, comodoNovo);
            salvarComodos();
        }
    }

    public Comodo buscarComodoPorNome(String nome) {
        for (Comodo comodo : comodos) {
            if (comodo.getNome().equalsIgnoreCase(nome)) {
                return comodo;
            }
        }
        return null;
    }

    private void salvarComodos() {
        try {
            saidaDados.salvarComodos(comodos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar cômodos: " + e.getMessage());
        }
    }
}
