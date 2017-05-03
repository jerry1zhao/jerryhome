// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.user.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public final class MailUtil {

    private static final String mailAccount = "785325280@qq.com";
    private static final String mailPassword = "tihahoibsbekbbif";
    private static final String mailSMTPhost = "smtp.qq.com";

    private MailUtil() {
    }

    public static void main(String[] args) {
        final ResourceBundle resource = ResourceBundle.getBundle("DBSetting");
        final String key = resource.getString("jdbc.url");
        System.out.println(key);
    }

    public static void sendMail(String receiveMailAccount) throws MessagingException, UnsupportedEncodingException {
        final Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", mailSMTPhost);
        props.setProperty("mail.smtp.auth", "true");

        final Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        final MimeMessage message = createMimeMessage(session, mailAccount, receiveMailAccount);

        final Transport transport = session.getTransport();
        transport.connect(mailAccount, mailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail)
            throws MessagingException, UnsupportedEncodingException {
        final MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail, "Jerry", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiveMail, "UTF-8"));
        message.setSubject("JAVA MAIL TEST");
        message.setContent("JAVA MAIL TESTJAVA MAIL TESTJAVA MAIL TESTJAVA MAIL TEST", "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

}
