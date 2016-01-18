package by.gmlocge.web.form;

import javax.validation.constraints.Size;

/**
 * Created by D on 05.01.2016.
 */
public class PasswordForm {
    @Size(min=4, max=25)
    private String passwordOld;
    @Size(min=4, max=25)
    private String passwordNew;
    @Size(min=4, max=25)
    private String passwordConfirm;

    public PasswordForm() {
    }

    public String getPasswordOld() {
        return passwordOld;
    }

    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
