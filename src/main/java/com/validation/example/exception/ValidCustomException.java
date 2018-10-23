package com.validation.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * validation 어노테이션으로 해결할 수 없는 문제들이 발생할 경우에도
 * markingErrorField 가 처리할 수 있도록 defaultMessage 와 field 를 가진 값들을
 * errors 배열 안에 담은 Exception 클래스를 생성
 *
 * validation 에러가 발생했을 때와 동일하게 400 status code 지정
 * ValidCustomException 에서만 사용하는 Error InnerClass 를 생성하여 defaultMessage 와 field 를 추가
 *
 * 하지만 이것만 가지고는 바로 사용할 수 없다.
 * Spring 에서 직접 생성한 Exception 에 새로운 field (여기선 Error[] errors) 를 포함하여 view 에 전달하기 위해서는
 * DefaultErrorAttributes 에서 필드를 직접 추가해야만 합니다.
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidCustomException extends RuntimeException {

  private Error[] errors;

  public ValidCustomException(String defaultMessage, String field) {
    this.errors = new Error[] { new Error(defaultMessage, field) };
  }

  public ValidCustomException(Error[] errors) {
    this.errors = errors;
  }

  public Error[] getErrors() {
    return errors;
  }

  public static class Error {

    private String defaultMessage;
    private String field;

    public Error(String defaultMessage, String field) {
      this.defaultMessage = defaultMessage;
      this.field = field;
    }

    public String getDefaultMessage() {
      return defaultMessage;
    }

    public String getField() {
      return field;
    }

  }

}
