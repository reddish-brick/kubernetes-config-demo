package com.tw.kubernetesdemo.error.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorDetail {

  private String field;
  private String code;
  private String message;
}