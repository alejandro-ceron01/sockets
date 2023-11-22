
public class Sustitucion {
    
     public static String encryptSubstitution(String message, int shift) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ciphertext.append((char) ((ch - base + shift) % 26 + base));
            } else {
                ciphertext.append(ch);
            }
        }

        return ciphertext.toString();
    }
     
     
     public static String decryptSubstitution(String ciphertext, int shift) {
        return encryptSubstitution(ciphertext, 26 - shift); // Descifrar es simplemente cifrar con el desplazamiento inverso
    }

    public static void main(String[] args) {
        String originalMessage = "hola como estas";
        int shift = 3;

        String encryptedMessage = encryptSubstitution(originalMessage, shift);
        String descryptedMessage = decryptSubstitution(encryptedMessage,shift);

        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("descrypted Message: " + descryptedMessage);
    }
    
}
