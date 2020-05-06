
import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.nio.file.*;
import java.security.spec.RSAPrivateCrtKeySpec;

public class ExportImport{
	
	public void ExportPrivateKey(String useri) throws Exception{
		if(Files.exists(Paths.get(useri+".private.xml"))){
		String text="";
		for (String line : Files.readAllLines(Paths.get(useri+".private.xml"))){
             text += line + "\n";
		}
		StringBuilder privateKey =  new StringBuilder();
        BufferedReader rdr = new BufferedReader(new StringReader(text));
        String line;
        while ((line = rdr.readLine()) != null) {
            privateKey.append(line);
        }

        String pkcs8Pem = privateKey.toString();
        pkcs8Pem = pkcs8Pem.replace("------Private Key-------", "");
        pkcs8Pem = pkcs8Pem.replace("//s+", "");

        byte [] pkcs8EncodedBytes = pkcs8Pem.getBytes("UTF-8");

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8EncodedBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privKey = kf.generatePrivate(keySpec);
		RSAPrivateCrtKeySpec ks = kf.getKeySpec(
		privKey, RSAPrivateCrtKeySpec.class);
		
		System.out.println("<RSAKeyValue>");
		System.out.println("    <Modulus>" + ks.getModulus() + "</Modulus>");
		System.out.println("    <Exponent>" + ks.getPublicExponent() + "</Exponent>");
		System.out.println("    <P>" + ks.getPrimeP() + "</P>");
		System.out.println("    <Q>" + ks.getPrimeQ() + "</Q>");
		System.out.println("    <DP>" + ks.getPrimeExponentP() + "</DP>");
		System.out.println("    <DQ>" + ks.getPrimeExponentQ() + "</DQ>");
		System.out.println("    <InverseQ>" + ks.getCrtCoefficient() + "</InverseQ>");
		System.out.println("    <D>" + ks.getPrivateExponent() + "</D>");
		System.out.println("</RSAKeyValue>");
		}
		else{
			System.out.println("Gabim");
		}
	}
}
