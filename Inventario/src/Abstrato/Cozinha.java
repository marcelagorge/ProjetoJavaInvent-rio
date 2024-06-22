package Abstrato;

public class Cozinha extends Comodo {

    public Cozinha() {
        super("Cozinha");
    }

    @Override
    public void organizar() {
        System.out.println("Organizando a cozinha...");
    }
}