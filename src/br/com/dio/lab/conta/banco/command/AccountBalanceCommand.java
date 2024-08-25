package br.com.dio.lab.conta.banco.command;

import br.com.dio.lab.conta.banco.util.BankAccountFormatterUtil;
import br.com.dio.lab.conta.banco.validator.AccountBalanceValidator;

import java.util.Scanner;

public class AccountBalanceCommand extends BankAccountCommand {

    private static final String ACCOUNT_BALANCE_INPUT_MESSAGE = "Por favor, insira o saldo inicial que deseja depositar na conta:";

    private static final AccountBalanceValidator ACCOUNT_BALANCE_VALIDATOR = new AccountBalanceValidator();

    @Override
    public String execute(Scanner scanner) {
        printInputMessage(ACCOUNT_BALANCE_INPUT_MESSAGE);

        Double accountBalance = getInputValue(scanner::nextDouble);

        handleValidation(ACCOUNT_BALANCE_VALIDATOR, accountBalance);

        return BankAccountFormatterUtil.formatAccountBalance(accountBalance);
    }

}
