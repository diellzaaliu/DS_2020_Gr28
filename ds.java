import java.security.*;
import java.util.*;
import java.io.*;


public class ds{

    public static void main(String[] args) throws Exception
    {
        PlayfairCipher x = new PlayfairCipher();
		CreateDeleteUser y=new CreateDeleteUser();
		y.RSAPublicPrivateKey();
		
	if(args.length == 0)
    {
        System.out.println("Proper Usage is: PlayFair encrypt/decrypt <key> <plaintext>\nor\nMorseCode encode/decode <text>\nor\nBeale encrypt/decrypt <book> <plaintext> ");
        System.exit(1);
    }
	else if(args.length==1){
		System.out.println("Nuk keni dhene argumente te mjaftueshme");
		System.exit(1);
	}
    else if(args[0].equalsIgnoreCase("Create-User")){
		   
		   y.createUser(args[1]);
	}
	else if(args[0].equalsIgnoreCase("Delete-User")){
		   y.deleteUser(args[1]);
	}
	else if(args[0].equalsIgnoreCase("PlayFair")){
   
        x.setKey(args[2]);
        x.KeyGen();
		
			if(args[1].equalsIgnoreCase("Encrypt")){
				if (args[3].length() % 2 == 0){
					System.out.println("Encryption: " + x.encryptMessage(args[3]));
			}
			}
			else if(args[1].equalsIgnoreCase("Decrypt")){
				if (args[3].length() % 2 == 0){
					System.out.println("Decryption: " + x.decryptMessage(args[3]));
			}
			}
			else{
					System.out.println("Message length should be even");
				}
				
		}
		
	else if(args[0].equalsIgnoreCase("MorseCode")){
			
			if(args[1].equalsIgnoreCase("Encode")){
				MorseCode.Encode(args[2]);
			}
			else if(args[1].equalsIgnoreCase("Decode")){
				MorseCode.Decode(args[2]);
			}
		}
	else if(args[0].equalsIgnoreCase("Beale")){
			BealeCipher text=new BealeCipher();
			text.ReadFile(args[2]);
			if(args[1].equalsIgnoreCase("Encrypt")){
				text.Encryption(args[3]);
			}else if(args[1].equalsIgnoreCase("Decrypt")){
				text.Decryption(args[3]);
			}
		}
	else{
			System.out.println("Proper Usage is: PlayFair encrypt <key> <plaintext>\nor\nMorseCode encode <text>\nor\nBeale encrypt <book> <plaintext> ");
			System.exit(1);
		}
				
	}
	}	
    
	

 
