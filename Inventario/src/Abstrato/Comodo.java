package Abstrato;
import java.util.ArrayList;
import java.util.List;

public abstract class Comodo {
    private String nome;
    private List<Item> itens;

    public Comodo(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public abstract void organizar();

    @Override
    public String toString() {
        return "Comodo: " + nome + ", Itens: " + itens;
    }
}