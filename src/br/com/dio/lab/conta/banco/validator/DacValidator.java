package br.com.dio.lab.conta.banco.validator;

import br.com.dio.lab.conta.banco.exception.DacInvalidInputException;

public class DacValidator implements BankAccountValidator<Integer> {

    @Override
    public void validate(Integer dac) throws DacInvalidInputException {

        if (dac != null && dac >= 0 && dac <= 9) {
            return;
        }

        throw new DacInvalidInputException();
    }

}
