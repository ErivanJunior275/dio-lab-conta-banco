package br.com.dio.lab.conta.banco.domain;

public record ClientAccount(String name, String agency, String number, String dac, String balance) {

    public String getCreatedAccountMessage() {
        return String.format("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é " +
                        "%s, conta %s-%s e seu saldo de %s já está disponível para saque.",
                this.name(),
                this.agency(),
                this.number(),
                this.dac(),
                this.balance());
    }

}
