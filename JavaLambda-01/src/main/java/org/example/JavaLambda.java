package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.time.format.DateTimeFormatter;

public class JavaLambda implements RequestHandler<RequestMessage, ResponseMessage> {

    @Override
    public ResponseMessage handleRequest(RequestMessage requestMessage, Context context) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = requestMessage.getDateTime().format(formatter);

        String message = String.format("My first: %s -  is dated: %s - and my feeling is: %s",
                requestMessage.getName(), formattedDate, requestMessage.getFeeling());

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(message);
        return responseMessage;
    }

}