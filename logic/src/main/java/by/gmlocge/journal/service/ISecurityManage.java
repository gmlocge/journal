package by.gmlocge.journal.service;

import by.gmlocge.journal.entity.security.Group;
import by.gmlocge.journal.entity.security.Authority;
import by.gmlocge.journal.entity.security.UserJournal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Transactional
public interface ISecurityManage {

    List<Group> getAllGroups();
    Group getGroupByName(String name);

    Group createGroup(String name) throws EntityExistsException;
    Group createGroupIfNotExist(String name);

    Group addAuthoritiesToGroup(Group g, Set<Authority> authorities) throws EntityNotFoundException;
    Group addAuthorityToGroup(Group g, Authority authority) throws EntityNotFoundException;
    Group removeAuthoritiesFromGroup(Group g, Set<Authority> authorities);
    Group removeAuthorityFromGroup(Group g, Authority authority) throws EntityNotFoundException;

    Set<Authority> createAuthorities(GrantedAuthority... gas);

    List<UserJournal> findAllUsers();

    UserJournal loadFullUser(UserJournal user);

    UserJournal getUser(String username);
    Set<Authority> getUserAuthority(UserJournal userJournal);

    UserJournal  createUser(String username, String password) throws EntityExistsException;
    UserJournal  createUserIfNotExist(String username, String password);

    UserJournal addGroupsToUser(UserJournal user, Set<Group> groups);
    UserJournal addGroupToUser(UserJournal user, Group group);
    UserJournal removeGroupsFromUser(UserJournal user, Set<Group> groups);
    UserJournal removeGroupFromUser(UserJournal user, Group group);
}
