package Abstrato;

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

    public String getDataValidade() {
        return dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item: " + nome + ", Validade: " + dataValidade + ", Quantidade: " + quantidade;
    }
}
