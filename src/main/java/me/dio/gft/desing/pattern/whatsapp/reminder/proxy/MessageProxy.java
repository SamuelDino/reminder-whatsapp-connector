package me.dio.gft.desing.pattern.whatsapp.reminder.proxy;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallCreator;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageProxy {

    private static Call call = null;

    public static List<String> getMessages(final String ACCOUNT_SID) {

        if (call==null){
            Call call = (Call) new CallCreator(ACCOUNT_SID,
                    new PhoneNumber("your number"),
                    new PhoneNumber("your number"),
                    URI.create("https://timberwolf-mastiff-9776.twil.io/demo-reply"))
                    .create();
        }

        Iterable<Message> messages = Message.reader().read();
        Iterator varInterator = messages.iterator();

        List<String> allMessages = new ArrayList<>();

        while (varInterator.hasNext()) {
            Message m = (Message) varInterator.next();
            allMessages.add(m.getBody());
        }

        return allMessages;
    }
}
