package br.com.dio.lab.conta.banco.validators;

import br.com.dio.lab.conta.banco.exceptions.NomeInvalidInputException;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NomeValidator implements ContaBancoValidator {

    private final Scanner scanner;

    private static final String MAIUSCULA = "(?:[\\p{Lu}&&[\\p{IsLatin}]])";
    private static final String MINUSCULA = "(?:[\\p{Ll}&&[\\p{IsLatin}]])";
    private static final String PREFIXO = choice("d'", "D'", "O'", "Mc", "Mac", "al\\-");
    private static final String SUFIXO = choice("Jr\\.", "II", "III", "IV");
    private static final String CONJUNCAO = choice("e", "y", "de" + opt(choice(" la", " las", " lo", " los")), "do", "dos", "da", "das", "del", "van", "von", "bin", "le");
    private static final String NOME = MAIUSCULA + plus(opt("'") + MINUSCULA);
    private static final String PRENOME = NOME + star("\\-" + NOME);
    private static final String SOBRENOME = choice(opt(PREFIXO) + NOME, PRENOME);
    private static final String NOME_COMPLETO = "^" + PRENOME + plus(" " + opt(CONJUNCAO + " ") + SOBRENOME) + opt(" " + SUFIXO) + "$";
    private static final Pattern pattern = Pattern.compile(NOME_COMPLETO);

    public NomeValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String validateAndGetValue() {
        String nome;

        try {
            nome = scanner.nextLine();
        } catch (RuntimeException rex) {
            throw new NomeInvalidInputException();
        }

        if (nome == null || !validNamePattern(nome)) {
            throw new NomeInvalidInputException();
        }

        return nome;
    }

    private boolean validNamePattern(String nome) {
        Matcher matcher = pattern.matcher(nome);

        return matcher.matches();
    }

    private static String opt(String in) {
        return "(?:" + in + ")?";
    }

    private static String plus(String in) {
        return "(?:" + in + ")+";
    }

    private static String star(String in) {
        return "(?:" + in + ")*";
    }

    private static String choice(String... in) {
        StringJoiner sj = new StringJoiner("|", "(?:", ")");
        for (String s : in) {
            sj.add(s);
        }
        return sj.toString();
    }

}
