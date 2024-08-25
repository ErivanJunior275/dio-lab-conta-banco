package br.com.dio.lab.conta.banco.util;

import java.text.NumberFormat;
import java.util.Locale;

public final class BankAccountFormatterUtil {

    private static final String CURRENCY_SYMBOL = "R$ ";

    private BankAccountFormatterUtil() {}

    public static String formatAccountBalance(Double accountBalance) {
        String formattedAccountBalanceValue =
                NumberFormat.getCurrencyInstance(Locale.of("pt", "BR")).format(accountBalance);

        return CURRENCY_SYMBOL + formattedAccountBalanceValue;
    }

}
