package com.tw.kubernetesdemo.error.message;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Error {

  private String type;
  private String description;
  private List<ErrorDetail> details;

  public Error(String type, String description, List<ErrorDetail> details) {
    this.type = type;
    this.description = description;
    this.details = details;
  }
}