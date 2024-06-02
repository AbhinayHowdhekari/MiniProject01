package in.MiniProject1.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class Emailutils {

    private final JavaMailSender email;

    @Autowired
    public Emailutils(JavaMailSender email) {
        this.email = email;
    }

    public boolean emailsender(String to, String body, String subject) {
        MimeMessage message = email.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        boolean flag = false;
        try {
            helper.setSubject(subject);
            helper.setText(body); // Set to true if the body contains HTML
            helper.setTo(to);
            email.send(message);
            flag = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
