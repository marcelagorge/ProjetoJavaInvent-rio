package Modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Item {
    private String nome;
    private String dataValidade;
    private int quantidade;

    public Item(String nome, String dataValidade, int quantidade) {
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean estaProximoValidade(int dias) {
        LocalDate hoje = LocalDate.now();
        LocalDate dataValidadeItem = LocalDate.parse(dataValidade, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long diasRestantes = ChronoUnit.DAYS.between(hoje, dataValidadeItem);
        return diasRestantes <= dias && diasRestantes >= 0;
    }
}
