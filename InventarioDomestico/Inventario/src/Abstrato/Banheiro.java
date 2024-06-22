package Abstrato;

public class Banheiro extends Comodo {

    public Banheiro() {
        super("Banheiro");
    }

    @Override
    public void organizar() {
        System.out.println("Organizando o banheiro...");
    }
}