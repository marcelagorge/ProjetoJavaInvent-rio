package Abstrato;

public class Garagem extends Comodo {

    public Garagem() {
        super("Garagem");
    }

    @Override
    public void organizar() {
        System.out.println("Organizando a garagem...");
    }
}