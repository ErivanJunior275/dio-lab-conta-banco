package br.com.dio.lab.conta.banco.validators;

import br.com.dio.lab.conta.banco.exceptions.AgenciaInvalidInputException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgenciaValidator implements ContaBancoValidator {

    private final Scanner scanner;

    private String agencia;

    public AgenciaValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String validateAndGetValue() {

        try {
            this.agencia = scanner.nextLine();
        } catch (RuntimeException rex) {
            throw new AgenciaInvalidInputException();
        }

        if (checkInvalidValue()) {
            throw new AgenciaInvalidInputException();
        }

        return agencia;
    }

    private boolean checkInvalidValue() {
        return !validateNotEmptyOrNull() || !validateOnlyDigits()
                || !validateLength() || !validateNotOnlyZeros();
    }

    private boolean validateNotEmptyOrNull() {
        return this.agencia != null && !this.agencia.isEmpty();
    }

    private boolean validateOnlyDigits() {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(this.agencia);

        return matcher.matches();
    }

    private boolean validateLength() {
        return this.agencia.length() > 2 && this.agencia.length() <= 4;
    }

    private boolean validateNotOnlyZeros() {
        return Integer.parseInt(this.agencia) > 0;
    }

}
