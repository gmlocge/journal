package by.gmlocge.web.validator;

import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.service.ISecurityManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class UserFormValidator implements Validator {

//	@Autowired
//	@Qualifier("emailValidator")
//	EmailValidator emailValidator;

    @Autowired
    Validator validator;

    @Autowired
    ISecurityManage sm;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserJournal.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserJournal user = (UserJournal) target;

        validator.validate(target, errors);

//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.userForm.address");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.userForm.sex");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.userForm.country");

//		if(!emailValidator.valid(user.getEmail())){
//			errors.rejectValue("email", "Pattern.userForm.email");
//		}

        if (null == user.getUsername() || user.getUsername().length() < 4) {
            errors.rejectValue("username", "Size.userForm.username");
        } else {
            UserJournal uj = sm.findUser(user.getUsername());
            if (null != uj) {
                errors.rejectValue("username", "userForm.username.exist");
            }
        }

//		if(user.getNumber()==null || user.getNumber()<=0){
//			errors.rejectValue("number", "NotEmpty.userForm.number");
//		}


//		if (!user.getPassword().equals(user.getConfirmPassword())) {
//			errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
//		}

    }

}