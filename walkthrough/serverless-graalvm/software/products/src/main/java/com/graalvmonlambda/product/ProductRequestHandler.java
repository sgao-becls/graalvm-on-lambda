package com.graalvmonlambda.product;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ProductRequestHandler implements RequestHandler<InputDTO, String> {

  @Override
  public String handleRequest(InputDTO event, Context context) {
    context.getLogger().log("Hello, " + event.getName());
    return event + " Hi";
  }
}
