package com.validation.example;

import com.validation.example.exception.ValidCustomException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@SpringBootApplication
public class ExampleApplication {

  @Bean
  public ErrorAttributes errorAttributes() {
    return new DefaultErrorAttributes() {

      public Map<String, Object> getErrorAttributes(
              RequestAttributes requestAttributes,
              boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes((WebRequest) requestAttributes, includeStackTrace);
        Throwable error = getError((WebRequest) requestAttributes);

        if (error instanceof ValidCustomException) {
          errorAttributes.put("errors", ((ValidCustomException) error).getErrors());
        }
        return errorAttributes;
      }

    };
  }

  public static void main(String[] args) {
    SpringApplication.run(ExampleApplication.class, args);
  }
}
