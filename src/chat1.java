
import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class chat1 implements Observer {

    Scanner scanner = new Scanner(System.in);

    public void levantarServer() {
        Servidor s = new Servidor(5000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    public void menu() {
        System.out.println("¡¡Bienvenido!!");
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("Escoga un metodo de encriptacion");
            System.out.println("1.- Sustitucion");
            System.out.println("2.- Transposicion");
            System.out.println("3.- ");
            System.out.println("4.- ");
            System.out.println("5.- ");
            System.out.println("6.- Salir");
            
            try {

                System.out.println("Seleccione la opcion deseada: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        System.out.println("Este es el programa que realiza el Metodo de ordenacion de insercion");
                        break;
                    case 4:
                        System.out.println("Este es el programa que realiza el Metodo de ordenacion Shell");
                        break;
                    case 5:
                        System.out.println("Este es el programa que realiza Listas de personas");
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Las opciones son entre 1 y 8");

                }
            } catch (InputMismatchException e) {
                System.out.println("Debes seleccionar un numero de opcion");
                scanner.next();
            }

        }

    }

    public static void main(String[] args) {
        chat1 c = new chat1();
        c.levantarServer();
        c.menu();

    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
