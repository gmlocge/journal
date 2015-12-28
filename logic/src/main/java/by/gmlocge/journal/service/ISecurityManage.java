package by.gmlocge.journal.service;

import by.gmlocge.journal.entity.security.Role;
import by.gmlocge.journal.entity.security.UserJournal;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional(readOnly = true)
public interface ISecurityManage {

    Role createOrUpdateRole(String name, Set<String> permissions);

    Set<Role> createOrUpdateRoleIfNotExist(Set<Role> roles);

    List<UserJournal> findAllUsers();

    UserJournal createUser(String login, String password);

    UserJournal getUser(String login);

    Set<String> getUserPermissions(UserJournal userJournal);

    UserJournal updateUser(UserJournal user, Set<Role> roles);


//    @Transactional(propagation = Propagation.REQUIRED)
//    UserJournal addPermission(String login, Set<String> permissions);
}
