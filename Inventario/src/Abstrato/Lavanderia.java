package Abstrato;

public class Lavanderia extends Comodo {

    public Lavanderia() {
        super("Lavanderia");
    }

    @Override
    public void organizar() {
        System.out.println("Organizando a lavanderia...");
    }
}
 