package br.com.dio.lab.conta.banco.validator;

import br.com.dio.lab.conta.banco.exception.NameInvalidInputException;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NameValidator implements BankAccountValidator<String> {

    private static final String UPPERCASE = "(?:[\\p{Lu}&&[\\p{IsLatin}]])";
    private static final String LOWERCASE = "(?:[\\p{Ll}&&[\\p{IsLatin}]])";
    private static final String PREFIX = choice("d'", "D'", "O'", "Mc", "Mac", "al\\-");
    private static final String SUFIX = choice("Jr\\.", "II", "III", "IV");
    private static final String CONJUNCAO = choice("e", "y", "de" + opt(choice(" la", " las", " lo", " los")), "do", "dos", "da", "das", "del", "van", "von", "bin", "le");
    private static final String NAME = UPPERCASE + plus(opt("'") + LOWERCASE);
    private static final String FIRST_NAME = NAME + star("\\-" + NAME);
    private static final String LAST_NAME = choice(opt(PREFIX) + NAME, FIRST_NAME);
    private static final String FULL_NAME = "^" + FIRST_NAME + plus(" " + opt(CONJUNCAO + " ") + LAST_NAME) + opt(" " + SUFIX) + "$";
    private static final Pattern PATTERN = Pattern.compile(FULL_NAME);

    @Override
    public void validate(String name) throws NameInvalidInputException {

        if (name != null && validNamePattern(name)) {
            return;
        }

        throw new NameInvalidInputException();
    }

    private boolean validNamePattern(String name) {
        Matcher matcher = PATTERN.matcher(name);

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
