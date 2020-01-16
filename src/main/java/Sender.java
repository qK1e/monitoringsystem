import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sender {
    private String username;
    private String password;
    private String to;
    private String smtp;


    public Sender(String username, String password, String to, String smtp) {
        this.username = username;
        this.password = password;
        this.to = to;
        this.smtp = smtp;
    }

    public void send(String msg)
    {
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", smtp);
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.ssl.enable","true");

            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Мониторинг сайтов");
            message.setText(msg);
            Transport.send(message);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
