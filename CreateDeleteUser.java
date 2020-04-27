import java.security.*;
import java.util.Base64;

public class CreateDeleteUser
{
	public void RSAPublicPrivateKey() throws Exception{

        KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
        key.initialize(4096); 
		KeyPair keypair = key.generateKeyPair();

        System.out.println ("----------Public Key----------");
        System.out.println (Base64.getMimeEncoder().encodeToString( keypair.getPublic().getEncoded()));
		System.out.println ("----------Private Key----------");
        System.out.println (Base64.getMimeEncoder().encodeToString( keypair.getPrivate().getEncoded()));

    }
}
