package com.graalvmonlambda.product;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.apache.commons.io.IOUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ProductRequestHandler implements RequestStreamHandler {

  @Override
  public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
    String requestJson;
    try {
      requestJson = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(requestJson);
    String responseJson = "Hello World!!";
    try (PrintWriter writer =
             new PrintWriter(
                 new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)))) {
      writer.write(responseJson);
      if (writer.checkError()) {
        throw new RuntimeException("Writer encountered an error");
      }
    }
  }
}
