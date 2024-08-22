package br.com.dio.lab.conta.banco;

import br.com.dio.lab.conta.banco.domain.ContaCliente;
import br.com.dio.lab.conta.banco.exceptions.ContaBancoException;
import br.com.dio.lab.conta.banco.validators.*;

import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Terminal de NumeroConta Bancária:");

        try (Scanner scanner = new Scanner(System.in)) {

            String nome = handleNameInput(scanner);
            String agencia = handleAgencyInput(scanner);
            String conta = handleAccountNumberInput(scanner);
            String dac = handleDacInput(scanner);
            String saldo = handleAccountBalanceInput(scanner);

            ContaCliente contaCliente = new ContaCliente(nome, agencia, conta, dac, saldo);

            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é " +
                            "%s, conta %s-%s e seu saldo de %s já está disponível para saque%n",
                    contaCliente.nome(), contaCliente.agencia(), contaCliente.numeroConta(),
                    contaCliente.dac(), contaCliente.saldo());
        } catch (ContaBancoException cbex) {
            System.out.println(cbex.getMessage());
        }

    }

    private static String handleNameInput(Scanner scanner) {
        System.out.println("Para iniciarmos seu cadastro, por favor, digite seu nome:");

        return new NomeValidator(scanner).validateAndGetValue();
    }

    private static String handleAgencyInput(Scanner scanner) {
        System.out.println("Por favor, digite o número de sua agência:");

        return new AgenciaValidator(scanner).validateAndGetValue();
    }

    private static String handleAccountNumberInput(Scanner scanner) {
        System.out.println("Estamos quase lá. Agora, por favor, digite o número da sua conta (sem dígito verificador):");

        return new NumeroContaValidator(scanner).validateAndGetValue();
    }

    private static String handleDacInput(Scanner scanner) {
        System.out.println("Por favor, insira o número do dígito verificador:");

        return new DacContaValidator(scanner).validateAndGetValue();
    }

    private static String handleAccountBalanceInput(Scanner scanner) {
        System.out.println("Por favor, insira o número do dígito verificador:");

        return new SaldoContaValidator(scanner).validateAndGetValue();
    }

}
