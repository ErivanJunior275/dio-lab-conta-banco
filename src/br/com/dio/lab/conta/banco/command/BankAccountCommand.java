package br.com.dio.lab.conta.banco.command;

import br.com.dio.lab.conta.banco.exception.BankAccountInvalidInputException;
import br.com.dio.lab.conta.banco.validator.BankAccountValidator;

import java.util.Scanner;
import java.util.concurrent.Callable;

public abstract class BankAccountCommand {

    public abstract String execute(Scanner scanner);

    public void printInputMessage(String inputMessage) {
        System.out.println(inputMessage);
    }

    public <T> T getInputValue(Callable<T> scannerInput) {

        try {
            return scannerInput.call();
        } catch (Exception ex) {
            throw new BankAccountInvalidInputException();
        }

    }

    public <T> void handleValidation(BankAccountValidator<T> validator, T inputValue) throws BankAccountInvalidInputException {
        validator.validate(inputValue);
    }

}
