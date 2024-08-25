package br.com.dio.lab.conta.banco.exception;

public class AgencyInvalidInputException extends BankAccountInvalidInputException {

    public static final String VALIDATE_AGENCY_ERROR_MESSAGE = "da agência";

    public AgencyInvalidInputException() {
        super(VALIDATE_AGENCY_ERROR_MESSAGE);
    }

}
