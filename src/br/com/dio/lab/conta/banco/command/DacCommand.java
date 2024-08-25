package br.com.dio.lab.conta.banco.command;

import br.com.dio.lab.conta.banco.validator.DacValidator;

import java.util.Scanner;

public final class DacCommand extends BankAccountCommand {

    private static final String DAC_INPUT_MESSAGE = "Estamos quase lá. Por favor, insira o número do dígito verificador:";

    private static final DacValidator DAC_VALIDATOR = new DacValidator();

    @Override
    public String execute(Scanner scanner) {
        printInputMessage(DAC_INPUT_MESSAGE);

        Integer dac = getInputValue(scanner::nextInt);

        handleValidation(DAC_VALIDATOR, dac);

        return dac.toString();
    }

}
