package com.tw.kubernetesdemo.exception;

public class AccountNotFoundException extends ResourceNotFoundException {

  public AccountNotFoundException() {
    super("No account was found.", "ACCOUNT_NOT_FOUND");
  }

}