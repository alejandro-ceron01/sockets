
import java.util.Scanner;


public class Transposicion {
        // Método para encriptar un mensaje utilizando el método de transposición
    public static String encryptMessage(String message, String key) {
        // Calcular el tamaño de la matriz de transposición
        int numRows = (int) Math.ceil((double) message.length() / key.length());

        // Crear una matriz para almacenar el mensaje en filas y columnas
        char[][] transpositionMatrix = new char[numRows][key.length()];

        // Llenar la matriz con el mensaje
        int messageIndex = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (messageIndex < message.length()) {
                    transpositionMatrix[i][j] = message.charAt(messageIndex++);
                } else {
                    // Rellenar con caracteres aleatorios si el mensaje es más corto que la matriz
                    transpositionMatrix[i][j] = 'X';
                }
            }
        }

        // Construir el mensaje encriptado leyendo la matriz por columnas según la clave
        StringBuilder encryptedMessage = new StringBuilder();
        for (char keyChar : key.toCharArray()) {
            int columnIndex = key.indexOf(keyChar);
            for (int i = 0; i < numRows; i++) {
                encryptedMessage.append(transpositionMatrix[i][columnIndex]);
            }
        }

        return encryptedMessage.toString();
    }
    
     // Método para desencriptar un mensaje utilizando el método de transposición
    public static String decryptMessage(String encryptedMessage, String key) {
        // Calcular el tamaño de la matriz de transposición
        int numRows = (int) Math.ceil((double) encryptedMessage.length() / key.length());

        // Crear una matriz para almacenar el mensaje encriptado en filas y columnas
        char[][] transpositionMatrix = new char[numRows][key.length()];

        // Construir la matriz de transposición leyendo el mensaje encriptado por columnas según la clave
        int encryptedIndex = 0;
        for (char keyChar : key.toCharArray()) {
            int columnIndex = key.indexOf(keyChar);
            for (int i = 0; i < numRows; i++) {
                transpositionMatrix[i][columnIndex] = encryptedMessage.charAt(encryptedIndex++);
            }
        }

        // Construir el mensaje original leyendo la matriz por filas
        StringBuilder originalMessage = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                originalMessage.append(transpositionMatrix[i][j]);
            }
        }

        return originalMessage.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener el mensaje y la clave del usuario
        System.out.print("Ingrese el mensaje a encriptar: ");
        String message = scanner.nextLine();
        System.out.print("Ingrese la clave: ");
        String key = scanner.nextLine();

        // Encriptar el mensaje
        String encryptedMessage = encryptMessage(message, key);

        // Mostrar el mensaje encriptado
        System.out.println("Mensaje encriptado: " + encryptedMessage);

        // Desencriptar el mensaje
        //String decryptedMessage = decryptMessage(encryptedMessage, key);

        // Mostrar el mensaje desencriptado
        //System.out.println("Mensaje desencriptado: " + decryptedMessage);
    }

}
