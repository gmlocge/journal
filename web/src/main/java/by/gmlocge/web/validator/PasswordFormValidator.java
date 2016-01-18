package by.gmlocge.web.validator;

import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.service.ISecurityManage;
import by.gmlocge.web.form.PasswordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class PasswordFormValidator implements Validator {

    @Autowired
    Validator validator;

    @Autowired
    ISecurityManage sm;

    @Override
    public boolean supports(Class<?> clazz) {
        return PasswordForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordForm form = (PasswordForm) target;
        validator.validate(target, errors);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserJournal uj = (UserJournal) auth.getPrincipal();

        if (!form.getPasswordOld().equals(uj.getPassword())) {
            errors.rejectValue("passwordOld", "password.old.Confirm");
        }

        if (!form.getPasswordNew().equals(form.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "password.new.Confirm");
        }
    }

}