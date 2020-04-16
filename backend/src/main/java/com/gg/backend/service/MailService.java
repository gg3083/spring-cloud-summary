package com.gg.backend.service;

import com.gg.backend.util.GmailHelper;
import com.gg.backend.util.QQmailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GG
 * @date 2018/11/11 21:44
 */
@Service
public class MailService {

    @Autowired
    private GmailHelper gmailHelper;

    @Autowired
    private QQmailHelper qqmailHelper;

    private String subject = "nmsl";
    private String body = "<h1>nmsl</h1><br /><p>wsnd</p><br /><p>hjyz</p>";

    public void sendByGmail( String receive_mail ){
        String[] mail = receive_mail.split(",");
        gmailHelper.sendEmail( mail , subject , body );
    }

    public void sendByQq( String receive_mail ){
        String[] mail = receive_mail.split(",");
        qqmailHelper.sendEmail( mail , subject , body );
    }

}
