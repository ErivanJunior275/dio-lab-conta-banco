package br.com.dio.lab.conta.banco.exception;

public final class AccountNumberInvalidInputException extends BankAccountInvalidInputException {

    public static final String VALIDATE_ACCOUNT_NUMBER_ERROR_MESSAGE = "do número da conta";

    public AccountNumberInvalidInputException() {
        super(VALIDATE_ACCOUNT_NUMBER_ERROR_MESSAGE);
    }

}
