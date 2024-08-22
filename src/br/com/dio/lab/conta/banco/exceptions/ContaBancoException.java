package br.com.dio.lab.conta.banco.exceptions;

public class ContaBancoException extends RuntimeException {

    public ContaBancoException(String message) {
        super(String.format("%s, verifique as informações preenchidas e tente novamente.", message));
    }

}
