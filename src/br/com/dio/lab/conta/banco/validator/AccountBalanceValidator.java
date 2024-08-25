package br.com.dio.lab.conta.banco.validator;

import br.com.dio.lab.conta.banco.exception.AccountBalanceInvalidInputException;

public class AccountBalanceValidator implements BankAccountValidator<Double> {

    @Override
    public void validate(Double accountBalance) throws AccountBalanceInvalidInputException {

        if (accountBalance != null && Double.compare(accountBalance, 100.00d) >= 1) {
            return;
        }

        throw new AccountBalanceInvalidInputException();
    }

}
