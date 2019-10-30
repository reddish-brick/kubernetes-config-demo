package com.tw.kubernetesdemo.error;

import com.tw.kubernetesdemo.error.message.Error;
import com.tw.kubernetesdemo.error.message.ErrorsContext;
import com.tw.kubernetesdemo.exception.ResourceNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@ControllerAdvice(
    annotations = {RestController.class}
)
public class DefaultExceptionHandler {

  public DefaultExceptionHandler() {
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({ResourceNotFoundException.class})
  public ErrorsContext handleResourceNotFoundException(ResourceNotFoundException e) {
    return new ErrorsContext(Arrays.asList(new Error(e.getType(), e.getMessage(), Collections.emptyList())));
  }
}
