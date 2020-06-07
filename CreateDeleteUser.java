import java.security.*;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import java.nio.file.*;
import java.util.Scanner;

public class CreateDeleteUser{
	public String publicKey;
	public String privateKey;
	public KeyPair keypair;
	Scanner input = new Scanner(System.in);

	public KeyPair RSAPublicPrivateKey() throws Exception{

        KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
        key.initialize(4096); 
		keypair = key.generateKeyPair();
		
		return keypair;

    }
	
	public void createUser(String user) throws Exception{
		
		
		String useri = user.trim();
		if(Files.exists(Paths.get(useri+".public.xml"))){
			System.out.println("Gabim: Celesi '"+useri+"' ekziston paraprakisht.");
			System.exit(1);
		}
        try {
			
			System.out.println("Jepni fjalekalimin: ");
			String fjalekalimi = input.nextLine();
			System.out.println("Perserit fjalekalimin: ");
			String fjalekalimiPerseritur = input.nextLine();
			if ( fjalekalimi.equals(fjalekalimiPerseritur) && !fjalekalimi.isEmpty() && fjalekalimi.length()>=6){
			
				Pattern p = Pattern.compile("[^A-Za-z0-9]"); //referenced by www.stackoverflow.com
				Matcher m = p.matcher(useri);
				boolean b = m.find();
				if (b){
					System.out.println("Nuk jane te lejuara karakteret speciale.");
					System.exit(1);
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter(useri+".public.xml"));
				publicKey= Base64.getMimeEncoder().encodeToString( keypair.getPublic().getEncoded());
				writer.write("------Public Key-------\n"+publicKey);
				System.out.println("Eshte krijuar celesi publik '"+useri+".public.xml'");
				
				BufferedWriter writer1 = new BufferedWriter(new FileWriter(useri+".private.xml"));
				privateKey=Base64.getMimeEncoder().encodeToString( keypair.getPrivate().getEncoded());
				System.out.println("Eshte krijuar celesi private '"+useri+".private.xml'");
				writer1.write("------Private Key-------\n"+privateKey);
				
		
				
				writer.close();
				writer1.close();
			}
			else{
				System.out.println("Fjalekalimi nuk pershtatet!");
				System.exit(1);
			}
				
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void deleteUser(String shfrytezuesi) throws Exception{
		shfrytezuesi = shfrytezuesi.trim();
		
		if(!Files.exists(Paths.get(shfrytezuesi+".public.xml"))){
			System.out.println("Gabim: Celesi '"+shfrytezuesi+"' nuk ekziston. ");
			System.exit(1);
		}
		else{
            Files.deleteIfExists(Paths.get(shfrytezuesi+".public.xml")); 
            Files.deleteIfExists(Paths.get(shfrytezuesi+".private.xml")); 
			System.out.println("Eshte larguar celesi privat '"+shfrytezuesi+".private.xml'");
			System.out.println("Eshte larguar celesi publik '"+shfrytezuesi+".public.xml'");
		}
	}
	
}
