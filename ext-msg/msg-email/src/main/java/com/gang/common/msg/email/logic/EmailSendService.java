package com.gang.common.msg.email.logic;

import com.gang.common.lib.to.ResponseModel;
import com.gang.common.msg.email.to.EmailSendContent;
import com.gang.common.msg.email.to.EmailSendSetting;
import com.gang.common.msg.logic.BaseSendServiceManager;
import com.gang.common.msg.to.MsgRequestTO;
import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * @Classname EmailSendService
 * @Description TODO
 * @Date 2020/2/22 21:11
 * @Created by zengzg
 */
@Component
public class EmailSendService extends BaseSendServiceManager<EmailSendSetting, EmailSendContent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public ResponseModel sendMsg(MsgRequestTO<EmailSendContent, EmailSendSetting> requestTO) {
        EmailSendSetting emailSendSetting = getSetting();
        Properties properties = new Properties();
        createProperties(emailSendSetting, properties);

        EmailSendContent sendContent = requestTO.getContentTO();

        sendHandle(sendContent, properties, emailSendSetting);
        return ResponseModel.commonResponse("邮箱 : " + sendContent.getReceiverList() + " : " + sendContent.getTitle() + " : " + "发送成功");
    }

    public void createProperties(EmailSendSetting emailSetting, Properties properties) {

        properties.setProperty("mail.transport.protocol", emailSetting.getProtocol());
        properties.setProperty("mail.smtp.host", emailSetting.getHost());
        properties.setProperty("mail.smtp.port", emailSetting.getPort());
        properties.setProperty("mail.smtp.auth", emailSetting.getAuth());
        properties.setProperty("mail.smtp.timeout", String.valueOf(emailSetting.getTime() * 2000));
        try {
            if (emailSetting.isEnable()) {
                logger.info("------> open ssl policy <-------");
                MailSSLSocketFactory sf = null;
                sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                if ("465".equals(emailSetting.getPort()) || "994".equals(emailSetting.getPort())) {
                    properties.put("mail.smtp.ssl.enable", "true");
                }
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.ssl.socketFactory", sf);

                logger.info("------> open ssl policy end<-------");
            }
        } catch (GeneralSecurityException e) {
            logger.error("E----> server error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }
    }

    public void sendHandle(EmailSendContent sendContent, Properties properties, EmailSendSetting emailSetting) {

        logger.info("------> send before <-------");
        Session session = Session.getInstance(properties,
                new MyAuthenricator(emailSetting.getAccount(), emailSetting.getPassword()));
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(emailSetting.getAccount(), ""));
            mimeMessage.setSubject(sendContent.getTitle());
            mimeMessage.setSentDate(new Date());
            mimeMessage.setText(sendContent.getContent());
            mimeMessage.setContent(sendContent.getContent(), "text/html;charset =utf-8");
            mimeMessage.saveChanges();

            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendContent.getReceiverList()));
            Transport.send(mimeMessage);

        } catch (Exception e) {

            logger.error("E----> send error  :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }
    }


    static class MyAuthenricator extends Authenticator {
        private String u = null;
        private String p = null;

        MyAuthenricator(String u, String p) {
            this.u = u;
            this.p = p;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(u, p);
        }
    }
}
