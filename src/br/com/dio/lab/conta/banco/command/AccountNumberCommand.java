package br.com.dio.lab.conta.banco.command;

import br.com.dio.lab.conta.banco.exception.BankAccountInvalidInputException;
import br.com.dio.lab.conta.banco.validator.AccountNumberValidator;

import java.util.Scanner;

public final class AccountNumberCommand extends BankAccountCommand {

    private static final String ACCOUNT_NUMBER_INPUT_MESSAGE = "Agora, por favor, digite o número da sua conta (sem dígito verificador):";

    private static final AccountNumberValidator ACCOUNT_NUMBER_VALIDATOR = new AccountNumberValidator();

    @Override
    public String execute(Scanner scanner) throws BankAccountInvalidInputException {
        printInputMessage(ACCOUNT_NUMBER_INPUT_MESSAGE);

        String accountNumber = getInputValue(scanner::nextLine);

        handleValidation(ACCOUNT_NUMBER_VALIDATOR, accountNumber);

        return accountNumber;
    }

}
