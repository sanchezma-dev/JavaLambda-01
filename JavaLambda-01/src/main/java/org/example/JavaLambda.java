package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class JavaLambda implements RequestHandler<RequestMessage, ResponseMessage> {

    @Override
    public ResponseMessage handleRequest(RequestMessage requestMessage, Context context) {


        String message = String.format("My first: %s - and my feeling is: %s",
                requestMessage.getName(), requestMessage.getFeeling());

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(message);
        return responseMessage;
    }

}