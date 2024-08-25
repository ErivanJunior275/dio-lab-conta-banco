package br.com.dio.lab.conta.banco.validator;

import br.com.dio.lab.conta.banco.exception.BankAccountInvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface BankAccountValidator<T> {

    void validate(T value) throws BankAccountInvalidInputException;

    default boolean validateNotEmptyOrNull(String value) {
        return value != null && !value.isEmpty();
    }

    default boolean validateOnlyDigits(String value) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }

    default boolean validateNotOnlyZeros(String value) {
        return Integer.parseInt(value) > 0;
    }

}
