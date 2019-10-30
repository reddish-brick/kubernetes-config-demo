package com.tw.kubernetesdemo.error.message;

public enum ErrorType {
  RESOURCE_NOT_FOUND("No resource found with given url"),
  INTERNAL_SERVER_ERROR("The server had an error."),
  SERVICE_UNAVAILABLE("A downstream dependency failed."),
  MALFORMED_REQUEST("The request JSON is not well formed."),
  BAD_REQUEST("Required resource identifier or parameter is missing."),
  VALIDATION_FAILED("One or more fields specified in the request failed validation");

  private final String message;

  private ErrorType(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }
}
