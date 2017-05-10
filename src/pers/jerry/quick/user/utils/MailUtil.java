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

    private static final String CONSTANT_MAIL_ACCOUNT = "mail.account";
    private static final String CONSTANT_MAIL_PASSWORD = "mail.password";
    private static final String CONSTANT_MAIL_SMTP_HOST = "mail.SMTP.host";
    private static final String CONSTANT_MAIL_FROM_NAME = "mail.from.name";
    private static final String UTF8 = "UTF-8";

    private static String mailAccount;
    private static String mailPassword;
    private static String mailSMTPHost;
    private static String mailFromName;

    static {
        init();
    }

    private MailUtil() {
    }

    private static void init() {
        final ResourceBundle resource = ResourceBundle.getBundle("MailSetting");
        mailAccount =  resource.getString(CONSTANT_MAIL_ACCOUNT);
        mailPassword =  resource.getString(CONSTANT_MAIL_PASSWORD);
        mailSMTPHost =  resource.getString(CONSTANT_MAIL_SMTP_HOST);
        mailFromName =  resource.getString(CONSTANT_MAIL_FROM_NAME);
    }

    public static void main(String[] args) {
        final String a = "a24.324.bsdf.fadf";
//        System.out.println(a.substring(a.lastIndexOf(".") + 1));
//        System.out.println(a.substring(a.lastIndexOf(".") + 1));
        final String b = a.substring(a.lastIndexOf('.') + 1);
        System.out.println(b);
        final String c=a.substring(0, a.lastIndexOf('.'));
        System.out.println(a.substring(0, a.lastIndexOf('.')));
        System.out.println(c.substring(c.lastIndexOf(".")+1));
//        try {
//            sendMail("jerry.zhao@coresolutions.com");
//        } catch (final UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (final MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    public static void sendMail(String receiveMailAccount) throws MessagingException, UnsupportedEncodingException {
        final Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", mailSMTPHost);
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
        message.setFrom(new InternetAddress(sendMail, mailFromName, UTF8));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiveMail, UTF8));
        message.setSubject("JAVA MAIL TEST");
        message.setContent("JAVA MAIL TESTJAVA MAIL TESTJAVA MAIL TESTJAVA MAIL TEST", "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

    /**
     * @return the mailAccount
     */
    public String getMailAccount() {
        return mailAccount;
    }

    /**
     * @param mailAccount the mailAccount to set
     */
    public void setMailAccount(String mailAccount) {
        MailUtil.mailAccount = mailAccount;
    }

    /**
     * @return the mailPassword
     */
    public String getMailPassword() {
        return mailPassword;
    }

    /**
     * @param mailPassword the mailPassword to set
     */
    public void setMailPassword(String mailPassword) {
        MailUtil.mailPassword = mailPassword;
    }

    /**
     * @return the mailSMTPHost
     */
    public String getMailSMTPHost() {
        return mailSMTPHost;
    }

    /**
     * @param mailSMTPHost the mailSMTPHost to set
     */
    public void setMailSMTPHost(String mailSMTPHost) {
        MailUtil.mailSMTPHost = mailSMTPHost;
    }

}
