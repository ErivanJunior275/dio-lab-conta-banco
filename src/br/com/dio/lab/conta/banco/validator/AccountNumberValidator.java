package br.com.dio.lab.conta.banco.validator;

import br.com.dio.lab.conta.banco.exception.AccountNumberInvalidInputException;

public final class AccountNumberValidator implements BankAccountValidator<String> {

    @Override
    public void validate(final String accountNumber) throws AccountNumberInvalidInputException {

        if (isValidValue(accountNumber)) {
            return;
        }

        throw new AccountNumberInvalidInputException();
    }

    private boolean isValidValue(String accountNumber) {
        return validateNotEmptyOrNull(accountNumber)
                && validateOnlyDigits(accountNumber)
                && validateLength(accountNumber)
                && validateNotOnlyZeros(accountNumber);
    }

    private boolean validateLength(String accountNumber) {
        return accountNumber.length() <= 20;
    }

}
