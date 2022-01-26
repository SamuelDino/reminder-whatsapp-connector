package me.dio.gft.desing.pattern.whatsapp.reminder.proxy;

import com.twilio.rest.api.v2010.account.Call;

public interface Call2 {
    Call getCall(String ACCOUNT_SID, String YOUR_NUMBER,String URI_TO_CALL);
}
