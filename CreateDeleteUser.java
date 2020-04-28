import java.security.*;
import java.util.Base64;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateDeleteUser{
	public String publicKey;
	public String privateKey;
	public KeyPair keypair;

	public KeyPair RSAPublicPrivateKey() throws Exception{

        KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
        key.initialize(4096); 
		keypair = key.generateKeyPair();
		
		return keypair;

    }
	public void createUser(String useri) throws Exception{

        try {
			
			if (useri == null || useri.trim().isEmpty()) {
			System.out.println("Incorrect format of string");
			System.exit(1);
			}
			Pattern p = Pattern.compile("[^A-Za-z0-9]");
			Matcher m = p.matcher(useri);
			boolean b = m.find();
			if (b){
			System.out.println("It is not allowed to use special characters");
			System.exit(1);
			
			}
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Twin/Desktop/FIEK/SEMESTRI IV/Siguria e te dhenave/Projekti/Keys/"+useri+".public.xml"));
			publicKey= Base64.getMimeEncoder().encodeToString( keypair.getPublic().getEncoded());
            writer.write("------Public Key-------\n"+publicKey);
			System.out.println("Eshte krijuar celesi publik '"+useri+".public.xml'");
			
			BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:/Users/Twin/Desktop/FIEK/SEMESTRI IV/Siguria e te dhenave/Projekti/Keys/"+useri+".private.xml"));
			privateKey=Base64.getMimeEncoder().encodeToString( keypair.getPrivate().getEncoded());
			System.out.println("Eshte krijuar celesi publik '"+useri+".public.xml'");
            writer1.write("------Private Key-------\n"+privateKey);
			
            writer.close();
			writer1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
