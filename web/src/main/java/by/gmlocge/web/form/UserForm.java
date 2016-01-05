package by.gmlocge.web.form;

import javax.persistence.Column;

/**
 * Created by D on 05.01.2016.
 */
public class UserForm {

    private String username; // as login
    @Column(nullable = false)
    private String password;

    private String firstName;
    private String lastName;
    private String middleName;


}
