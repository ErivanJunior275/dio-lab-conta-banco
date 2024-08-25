package br.com.dio.lab.conta.banco.validator;

import br.com.dio.lab.conta.banco.exception.AgencyInvalidInputException;

public class AgencyValidator implements BankAccountValidator<String> {

    @Override
    public void validate(final String agency) throws AgencyInvalidInputException {

        if (isValidValue(agency)) {
            return;
        }

        throw new AgencyInvalidInputException();
    }

    private boolean isValidValue(String agency) {
        return validateNotEmptyOrNull(agency) && validateOnlyDigits(agency)
                && validateLength(agency) && validateNotOnlyZeros(agency);
    }

    private boolean validateLength(String agency) {
        return agency.length() > 2 && agency.length() <= 5;
    }

}
