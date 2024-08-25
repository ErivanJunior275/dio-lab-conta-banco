package br.com.dio.lab.conta.banco.exception;

public final class AccountBalanceInvalidInputException extends BankAccountInvalidInputException {

    public static final String VALIDATE_ACCOUNT_BALANCE_ERROR_MESSAGE = "do valor do saldo inicial para conta";

    public AccountBalanceInvalidInputException() {
        super(VALIDATE_ACCOUNT_BALANCE_ERROR_MESSAGE);
    }

}
