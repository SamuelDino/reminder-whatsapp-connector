package me.dio.gft.desing.pattern.whatsapp.reminder.application;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import me.dio.gft.desing.pattern.whatsapp.reminder.proxy.MessageProxy;

import java.time.LocalDateTime;

public class WhatsAppTest {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "account_sid";
    public static final String AUTH_TOKEN = "auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        sendMessage("Message: Last Message sent on "+LocalDateTime.now().toString());
        showMessages();
        sendMessage("Message: Next Message sent on "+LocalDateTime.now().toString());
        showMessages();
    }

    private static void sendMessage(String msg) {
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+your number"),
                        new com.twilio.type.PhoneNumber("whatsapp:+twilio number"),
                        msg)
                .create();
    }

    private static void showMessages(){
        for(String s:MessageProxy.getMessages(ACCOUNT_SID)){
            System.out.println(s);
        }
    }
}

