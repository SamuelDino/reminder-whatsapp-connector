package me.dio.gft.desing.pattern.whatsapp.reminder.application;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import me.dio.gft.desing.pattern.whatsapp.reminder.proxy.MessageProxy;

import java.time.LocalDateTime;

public class WhatsAppTest {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "account_sid";
    public static final String AUTH_TOKEN = "auth_token";
    public static final String YOUR_NUMBER = "+5585999999999";
    public static final String TWILIO_NUMBER = "+101999999999";
    public static final String URI_TO_CALL = "https://timberwolf-mastiff-9776.twil.io/demo-reply";
    public static final MessageProxy messageProxy = new MessageProxy();

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        sendMessage("Message: Last Message sent on " + LocalDateTime.now().toString());
        showMessages();
        sendMessage("Message: Next Message sent on " + LocalDateTime.now().toString());
        showMessages();
    }

    private static void sendMessage(String msg) {
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:"+YOUR_NUMBER),
                        new com.twilio.type.PhoneNumber("whatsapp:"+TWILIO_NUMBER),
                        msg)
                .create();
    }

    private static void showMessages() {
        for (String s : messageProxy.getMessages(ACCOUNT_SID, YOUR_NUMBER, URI_TO_CALL)) {
            System.out.println(s);
        }
    }
}

