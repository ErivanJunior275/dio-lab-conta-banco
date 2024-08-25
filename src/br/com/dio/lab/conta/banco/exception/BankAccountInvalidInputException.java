package br.com.dio.lab.conta.banco.exception;

public class BankAccountInvalidInputException extends Exception {

    protected BankAccountInvalidInputException(String invalidInputMessage) {
        super(String.format("Erro na validação %s, verifique as informações preenchidas e tente novamente.", invalidInputMessage));
    }

    public BankAccountInvalidInputException() {
        super("O valor informado é incompatível com o esperado, verifique as informações preenchidas e tente " +
                "novamente.");
    }

}
