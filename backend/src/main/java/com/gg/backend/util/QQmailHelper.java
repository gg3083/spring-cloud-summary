package com.gg.backend.util;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author GG
 * @date 2018/11/11 22:23
 */
@Log
@Component
public class QQmailHelper {

    private final static String qq = "1056619204";
    private final static String qq_mail = "1056619204@qq.com";
    private final static String pwd = "liwdrbomzfffbdgh";

    public void sendEmail(String[] mail, String subject ,String body ) {
        try {
            Properties prop = new Properties();
            prop.setProperty("mail.debug", "true");// 开启debug调试，以便在控制台查看
            prop.setProperty("mail.host", "smtp.qq.com");// 设置邮件服务器主机名
            prop.setProperty("mail.smtp.auth", "true");// 发送服务器需要身份验证
            prop.setProperty("mail.transport.protocol", "smtp");// 发送邮件协议名称

            // 开启SSL加密，否则会失败
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);

            // 创建session
            Session session = Session.getInstance(prop);// 通过session得到transport对象
            Transport ts = session.getTransport();// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
            ts.connect("smtp.qq.com", qq, pwd);//后面的字符是授权码，用qq密码反正我是失败了（用自己的，别用我的，这个号是我瞎编的，为了。。。。）
            // 创建邮件
            // 创建邮件对象
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(qq_mail));// 指明邮件的发件人
            for (int i = 0; i < mail.length; i++) {
                // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
                message.setRecipient(Message.RecipientType.TO, new InternetAddress( mail[i] ));
            }
            message.setSubject( subject );// 邮件的标题
            message.setContent(body , "text/html;charset=UTF-8");// 邮件的文本内容
            ts.sendMessage(message, message.getAllRecipients());/// 发送邮件
            ts.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

    }
}
