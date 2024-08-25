package br.com.dio.lab.conta.banco;

import br.com.dio.lab.conta.banco.command.*;
import br.com.dio.lab.conta.banco.domain.ClientAccount;
import br.com.dio.lab.conta.banco.exception.BankAccountInvalidInputException;

import java.util.Locale;
import java.util.Scanner;

public class AccountTerminal {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Terminal de Conta Bancária:");

        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.of("pt", "BR"))) {

            String name = handleInput(new NameCommand(), scanner);
            String agency = handleInput(new AgencyCommand(), scanner);
            String accountNumber = handleInput(new AccountNumberCommand(), scanner);
            String dac = handleInput(new DacCommand(), scanner);
            String accountBalance = handleInput(new AccountBalanceCommand(), scanner);

            ClientAccount clientAccount = new ClientAccount(name, agency, accountNumber, dac, accountBalance);

            printCreatedAccountMessage(clientAccount);
        } catch (BankAccountInvalidInputException bankAccountInvalidInputException) {
            System.out.println(bankAccountInvalidInputException.getMessage());
        }

    }

    private static String handleInput(BankAccountCommand bankAccountCommand, Scanner scanner) throws BankAccountInvalidInputException {
        return bankAccountCommand.execute(scanner);
    }

    private static void printCreatedAccountMessage(ClientAccount clientAccount) {
        System.out.println(clientAccount.getCreatedAccountMessage());
    }

}
