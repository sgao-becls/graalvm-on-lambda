package com.graalvmonlambda.product;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ProductRequestHandler implements RequestHandler<String, String> {

  @Override
  public String handleRequest(String event, Context context) {
    context.getLogger().log(event);
    return event + " Ha";
  }
}
