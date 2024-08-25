package br.com.dio.lab.conta.banco.command;

import br.com.dio.lab.conta.banco.exception.BankAccountInvalidInputException;
import br.com.dio.lab.conta.banco.validator.AgencyValidator;

import java.util.Scanner;

public final class AgencyCommand extends BankAccountCommand {

    private static final String AGENCY_INPUT_MESSAGE = "Por favor, digite o número de sua agência:";

    private static final AgencyValidator AGENCY_VALIDATOR = new AgencyValidator();

    @Override
    public String execute(Scanner scanner) throws BankAccountInvalidInputException {
        printInputMessage(AGENCY_INPUT_MESSAGE);

        String agency = getInputValue(scanner::nextLine);

        handleValidation(AGENCY_VALIDATOR, agency);

        return agency;
    }


}
