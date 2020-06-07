
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
  
public class WriteMessage { 
      
    public static void main(String[] args) 
    { 
       
        String to = "agnesa.selimi2@gmail.com";  
        String from = "aferditabeqiraj@gmail.com";  
        String host = "localhost"; // or IP address 
  
        
        Properties properties = System.getProperties();  
  
        
        properties.setProperty("mail.smtp.host", host);  
  
        
        Session session = Session.getDefaultInstance(properties);  
  
       
        try { 
  
             
            MimeMessage message = new MimeMessage(session);  
   
            message.setFrom(new InternetAddress(from));  
            message.addRecipient(Message.RecipientType.TO,  
                                new InternetAddress(to)); 
            message.setSubject("subject"); 
            message.setText("Hello"); 
  
            // Send message 
            Transport.send(message); 
            System.out.println("Hi there"); 
        } 
        catch (MessagingException mex) { 
            mex.printStackTrace(); 
        } 
    } 
}
