package me.dio.gft.desing.pattern.whatsapp.reminder.connector;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallCreator;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WhatsApp {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "account_sid";
    public static final String AUTH_TOKEN = "auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        sendMessage(LocalDateTime.now().toString());
        for(String s:getMessages()){
            System.out.println(s);
        }

    }

    private static List<String> getMessages() {
        Call call = (Call) new CallCreator(ACCOUNT_SID,
                new PhoneNumber("your number"),
                new PhoneNumber("your number"),
                URI.create("https://timberwolf-mastiff-9776.twil.io/demo-reply")).create();

        System.out.println(call.getSid());
        Iterable<Message> messages = Message.reader().read();
        Iterator var6 = messages.iterator();

        List<String> allMessages = new ArrayList<>();

        while (var6.hasNext()) {
            Message m = (Message) var6.next();
            //System.out.println(m.getSid());
            allMessages.add(m.getBody());
        }

        return allMessages;
    }

    private static void sendMessage(String msg) {
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+your number"),
                        new com.twilio.type.PhoneNumber("whatsapp:+twilio number"),
                        msg)
                .create();
        System.out.println(message.getSid());
    }

}

