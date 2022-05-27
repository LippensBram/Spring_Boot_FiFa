package validator;

import domain.AankoopTicket;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AankoopTicketValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AankoopTicket.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AankoopTicket aankoopTicket = (AankoopTicket) target;

        int voetbalCode1 = aankoopTicket.getVoetbalCode1();
        int voetbalCode2 = aankoopTicket.getVoetbalCode2();
        if (voetbalCode1 > voetbalCode2) {
            errors.rejectValue("voetbalCode1",
                    "aankoop.voetbalCode1",
                    "voetbalCode1 moet onder voetbalCode2 liggen");
        }
        if (voetbalCode2 < voetbalCode1) {
            errors.rejectValue("voetbalCode2",
                    "aankoop.voetbalCode2",
                    "voetbalCode2 moet boven voetbalCode1 liggen");
        }
    }
}
