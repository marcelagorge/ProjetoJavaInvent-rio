import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    
    private static Scanner leitor = new Scanner(System.in);

   
    public static String lerString(String msg) {
        System.out.print(msg + " ");
        String valor = leitor.nextLine();
        return valor;
    }

   
    public static int lerInt(String msg) {
        int valor = 0;

        while (true) {
            try {
                System.out.print(msg + " ");
                valor = leitor.nextInt();
                break;

            } catch (InputMismatchException e) {
                System.out.println("O valor digitado não é do tipo 'int'");

            } finally {

                leitor.nextLine(); 
            }
        }

        return valor;
    }

   
    public static float lerFloat(String msg) {

        float valor = 0;
        while (true) {

            try {
                System.out.print(msg + " ");
                valor = leitor.nextFloat();
                break;

            } catch (InputMismatchException e) {
                System.out.println("O valor digitado não é do tipo 'float'");

            } finally {

                leitor.nextLine(); 
            }

        }
        return valor;
    }
 {
    
}
}
