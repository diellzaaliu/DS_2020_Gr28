import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public  class BealeCipher
{
	public int ciphertext;
	public String data; 
	public String tedhenat[];
public void ReadFile(String keyFile) {  

    try {
      File book = new File(keyFile);
      Scanner myReader = new Scanner(book);  
      while (myReader.hasNextLine()) {
        data = myReader.nextLine();
		tedhenat=data.split("[ ]+");
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
	}
public  void Encryption(String teksti){
		
		for(int i=0;i<teksti.length();i++){
			for(int j=0;j<tedhenat.length;j++){
			if(tedhenat[j].charAt(0)==teksti.charAt(i)){
				System.out.print(j+" ");
			}
			else{
				continue;
			}
		}
		}
	}
public  void Decryption(String teksti){
		
		for(int i=0;i<teksti.length();i++){
			for(int j=0;j<tedhenat.length;j++){
			if(j==teksti.charAt(i)){
				System.out.println(tedhenat[j].charAt(0));
			}
			else{
				continue;
			}
		}
		}
	}
	}
