package br.com.dio.lab.conta.banco.exception;

public final class DacInvalidInputException extends BankAccountInvalidInputException {

    private static final String VALIDATE_DAC_ERROR_MESSAGE = "do dac";

    public DacInvalidInputException() {
        super(VALIDATE_DAC_ERROR_MESSAGE);
    }

}
