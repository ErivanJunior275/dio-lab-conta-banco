package br.com.dio.lab.conta.banco.command;

import br.com.dio.lab.conta.banco.exception.BankAccountInvalidInputException;
import br.com.dio.lab.conta.banco.validator.NameValidator;

import java.util.Scanner;

public final class NameCommand extends BankAccountCommand {

    private static final String NAME_INPUT_MESSAGE = "Para iniciarmos seu cadastro, por favor, digite seu name:";

    private static final NameValidator NAME_VALIDATOR = new NameValidator();

    @Override
    public String execute(Scanner scanner) throws BankAccountInvalidInputException {
        printInputMessage(NAME_INPUT_MESSAGE);

        String name = getInputValue(scanner::nextLine);

        handleValidation(NAME_VALIDATOR, name);

        return name;
    }

}
