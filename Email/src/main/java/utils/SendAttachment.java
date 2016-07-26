package utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.InputStream;

class SendAttachment{
	public static void main(String[] args){
		sendMail("vinay@nlsinc.com","D:\\junk\\a.txt");
	}
	
 public static void sendMail(String toAddress, String mailAttachment){

  String to=toAddress;//change accordingly
  final String user="balaji111om@gmail.com";//change accordingly
  final String password="tejarohan";//change accordingly
 
  //1) get the session object   
  Properties properties = System.getProperties();
  properties.setProperty("mail.smtp.host", "smtp.gmail.com");
  properties.put("mail.smtp.auth", "true");
  properties.put("mail.smtp.port", "587");
  properties.put("mail.smtp.starttls.enable", "true");

  Session session = Session.getDefaultInstance(properties,
   new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(user,password);
   }
  });
   
  //2) compose message   
  try{
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(user));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    message.setSubject("Message Alert");
    
    //3) create MimeBodyPart object and set your message content    
    BodyPart messageBodyPart1 = new MimeBodyPart();
    messageBodyPart1.setText("This is message body");
    
    //4) create new MimeBodyPart object and set DataHandler object to this object    
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	InputStream st =  SendAttachment.class.getClassLoader().getResourceAsStream(mailAttachment);
		//DataSource fds = new FileDataSource(st);
    String filename = mailAttachment;//change accordingly
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName(filename);
   
   
    //5) create Multipart object and add MimeBodyPart objects to this object    
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart );
   
    //7) send message
    Transport.send(message);
 
   System.out.println("message sent....");
   }catch (MessagingException ex) {ex.printStackTrace();}
 }
}