package br.com.dio.lab.conta.banco.exceptions;

public class AgenciaInvalidInputException extends ContaBancoException {

    public static final String ERRO_VALIDACAO_AGENCIA = "Erro na validação da agência";

    public AgenciaInvalidInputException() {
        super(ERRO_VALIDACAO_AGENCIA);
    }

}
