package agilemeetingdash.emailhandler;

import com.sendgrid.*;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class emailhandler {
	private static String USER_NAME = "vsoftagilemeetdash@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "jay@8888j88"; // GMail password
  public static void sendmail(String emailto ) throws IOException {
	  String from = USER_NAME;
      String pass = PASSWORD;
      String[] to = { emailto }; // list of recipient email addresses
      String subject = "You have new task from VSOFT Agile Meeting Dashboard";
      String body = "<h3>Here is link to your new task</h3><a href='http://localhost:8080/agilemeetingdash/'> Click here to see </a><p></p><p>or visit : localhost:8080/agilemeetdash/</p>";

      sendFromGMail(from, pass, to, subject, body);
  }
	    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");//here
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setContent(body, "text/html");
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	    }
}