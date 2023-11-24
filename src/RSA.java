import javax.crypto.*;
import java.security.*;
import java.util.Scanner;
public class RSA {
 
 public String encriptMode(String mensaje){
 try {
 KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
 KeyPair keypair = keygen.generateKeyPair();
 
 Cipher rsaCipher = Cipher.getInstance("RSA");
 
 rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPrivate());
 byte[] mensajeCifrado = rsaCipher.doFinal(mensaje.getBytes("UTF8"));
 System.out.println("Mensaje cifrado: " +mensajeCifrado);
 
 return mensajeCifrado.toString();
 /*
 rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPublic());
 byte[] mensajeDescifrado = rsaCipher.doFinal(mensajeCifrado);
 String mensajeDescifrado2 = new String(mensajeDescifrado, "UTF8");
 System.out.println(mensajeDescifrado2);*/
 } catch (Exception e) {
 e.printStackTrace();
 }
 return "";
 }
}