package com.gg.backend.util;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author GG
 * @date 2018/11/11 22:09
 */
@Log
@Component
public class GmailHelper {

    private final static String send_mail = "gg3083.cn@gmail.com";
    private final static String send_password = "guge..00";

    public void sendEmail( String[] receive_mail ,String subject ,String body )  {
        try {
            Properties emailProperties = System.getProperties();
            emailProperties.put("mail.smtp.port", "587");
            emailProperties.put("mail.smtp.auth", "true");
            emailProperties.put("mail.smtp.starttls.enable", "true");
            Session mailSession = Session.getDefaultInstance(emailProperties, null);
            MimeMessage emailMessage = new MimeMessage(mailSession);

            for (int i = 0; i < receive_mail.length; i++) {
                emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receive_mail[i]));
            }
            emailMessage.setSubject( subject );
            emailMessage.setContent( body , "text/html");// for a html email

            Transport transport = mailSession.getTransport("smtp");

            transport.connect("smtp.gmail.com",  send_mail , send_password );
            transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
            transport.close();
        }catch ( MessagingException e){
            e.printStackTrace();
        }

    }


}
