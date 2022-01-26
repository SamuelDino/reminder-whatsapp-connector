package me.dio.gft.desing.pattern.whatsapp.reminder.proxy;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageProxy {

    private Call2 callService;
    private Call call;

    public MessageProxy(){
        this.callService = new Call2Impl();
    }

    public List<String> getMessages(final String ACCOUNT_SID, final String YOUR_NUMBER, final String URI_TO_CALL) {

        if (call == null) {
            call = callService.getCall(ACCOUNT_SID, YOUR_NUMBER, URI_TO_CALL);
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
