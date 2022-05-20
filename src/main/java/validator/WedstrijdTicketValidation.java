package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.AankoopTicket;

public class WedstrijdTicketValidation implements Validator {

	@Override
    public boolean supports(Class<?> klass) {
        return AankoopTicket.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AankoopTicket aankoop = (AankoopTicket) target;

        int code1 = aankoop.getVoetbalCode1();
        int code2 = aankoop.getVoetbalCode2();
        if (code1 > code2) {
            errors.rejectValue("code1",
                    "aankoop.code1",
                    "code1 moet onder code2 liggen");
        }
        if (code2 < code1) {
            errors.rejectValue("code2",
                    "aankoop.code2",
                    "code1 moet boven code1 liggen");
        }
    }
}
