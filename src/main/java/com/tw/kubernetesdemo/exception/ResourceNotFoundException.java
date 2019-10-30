package com.tw.kubernetesdemo.exception;

public class ResourceNotFoundException extends RuntimeException {

  private final String type;

  public ResourceNotFoundException(String message, String type) {
    super(message);
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
}