package br.com.dio.lab.conta.banco.exception;

public class NameInvalidInputException extends BankAccountInvalidInputException {

    private static final String VALIDATE_NAME_ERROR_MESSAGE = "do nome";

    public NameInvalidInputException() {
        super(VALIDATE_NAME_ERROR_MESSAGE);
    }

}
