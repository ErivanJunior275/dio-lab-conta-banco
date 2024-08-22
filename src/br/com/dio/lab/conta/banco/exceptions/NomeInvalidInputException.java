package br.com.dio.lab.conta.banco.exceptions;

public class NomeInvalidInputException extends ContaBancoException {

    private static final String ERRO_VALIDACAO_NOME = "Erro na validação do nome";

    public NomeInvalidInputException() {
        super(ERRO_VALIDACAO_NOME);
    }

}
