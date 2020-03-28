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
