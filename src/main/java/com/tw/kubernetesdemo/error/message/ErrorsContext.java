package com.tw.kubernetesdemo.error.message;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorsContext {

  private List<Error> errors;
}