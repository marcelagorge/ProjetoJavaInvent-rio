package Modelos;
import java.util.ArrayList;
import java.util.List;

public class Comodo {
    private String nome;
    private List<Item> itens;

    public Comodo(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }


}