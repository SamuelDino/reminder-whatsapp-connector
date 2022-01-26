package me.dio.gft.desing.pattern.whatsapp.reminder.proxy;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallCreator;
import com.twilio.type.PhoneNumber;

import java.net.URI;

public class Call2Impl implements Call2 {

    public Call getCall(final String ACCOUNT_SID, final String YOUR_NUMBER, final String URI_TO_CALL) {
        return (Call) new CallCreator(ACCOUNT_SID,
                new PhoneNumber(YOUR_NUMBER),
                new PhoneNumber(YOUR_NUMBER),
                URI.create(URI_TO_CALL))
                .create();
    }
}
