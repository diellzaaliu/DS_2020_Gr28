import java.security.*;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.*;

public class writereadmessage {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    public static void setKey(String useri) throws Exception
    {
		key = Files.readAllBytes(Paths.get(useri+".public.xml"));
        MessageDigest sha = null;
        try {
            key = Files.readAllBytes(Paths.get(useri+".public.xml"));       
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key,16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String message, String useri) 
    {
        try
        {
            setKey(useri);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            String ciphertext = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
			String name = Base64.getEncoder().encodeToString(useri.getBytes("UTF-8"));
			
			return name+" . "+ciphertext;
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
	 public static String decrypt(String mesazhiEnkriptuar, String useri) 
    {
        try
        {
            setKey(useri);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(mesazhiEnkriptuar)));
        } 
        catch (Exception e) 
        {
            System.out.println("There are some errors while decrypting the message,: " + e.toString());
        }
        return null;
    }

}
