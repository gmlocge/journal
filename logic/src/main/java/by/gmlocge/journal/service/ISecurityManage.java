package by.gmlocge.journal.service;

import by.gmlocge.journal.entity.security.Role;
import by.gmlocge.journal.entity.security.UserAuthority;
import by.gmlocge.journal.entity.security.UserJournal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional(readOnly = true)
public interface ISecurityManage {

    Set<UserAuthority> createAuthorities(GrantedAuthority... gas);

    List<UserJournal> findAllUsers();

    @Transactional
    UserJournal updateUser(UserJournal user);

    UserJournal createUser(String login, String password, Set<UserAuthority> authorities);

    UserJournal getUser(String login);

//    Set<String> getUserPermissions(UserJournal userJournal);

    Set<UserAuthority> getUserAuthority(UserJournal userJournal);

//    UserJournal updateUser(UserJournal user, Set<Role> roles);


//    @Transactional(propagation = Propagation.REQUIRED)
//    UserJournal addPermission(String login, Set<String> permissions);
}
