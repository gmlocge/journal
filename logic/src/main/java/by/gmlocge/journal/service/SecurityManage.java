package by.gmlocge.journal.service;

import by.gmlocge.journal.Const;
import by.gmlocge.journal.entity.security.AuthorityPredefined;
import by.gmlocge.journal.entity.security.Group;
import by.gmlocge.journal.entity.security.Authority;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@Transactional
public class SecurityManage implements ISecurityManage {
    private static final Logger logger = LoggerFactory.getLogger(SecurityManage.class);

    @Autowired
    private IUserJournalRepository daoUser;
    @Autowired
    private IGroupRepository daoGroup;

    @PostConstruct
    private void init() {
        Group gBase = createGroupIfNotExist(Const.NAME_BASE_GROUP);
        addAuthoritiesToGroup(gBase, createAuthorities(AuthorityPredefined.AUTH, AuthorityPredefined.GUEST));
        logger.trace("update group - " + gBase);
        Group gAdmin = createGroupIfNotExist(Const.NAME_ADMIN_GROUP);
        addAuthoritiesToGroup(gAdmin, createAuthorities(AuthorityPredefined.values()));
        logger.trace("update group - " + gAdmin);

//        UserJournal uAdmin = createUserIfNotExist("d4", "admin");
//        uAdmin = addGroupsToUser(uAdmin, new HashSet<>(Arrays.asList(gBase, gAdmin)));
//        uAdmin = loadFullUser(uAdmin);
//        logger.trace("update user - " + uAdmin);
//
//        UserJournal uTest = createUserIfNotExist("test", "1test");
//        uTest = addGroupToUser(uTest, gBase);
//        uTest = loadFullUser(uTest);
//        logger.trace("update user - " + uTest);

    }


    @Override
    public Set<Authority> createAuthorities(GrantedAuthority... gas) {
        Set<Authority> authorities = new HashSet<>();
        for (GrantedAuthority grantedAuthority : gas) {
            Authority ua = new Authority(grantedAuthority);
            authorities.add(ua);
        }
        return authorities;
    }

    @Override
    public Group createGroup(String name) throws EntityExistsException {
        Group group = daoGroup.findOneByName(name);
        if (null != group) {
            throw new EntityExistsException("group with name '" + group.getName() + "' already exist!");
        }
        group = new Group();
        group.setName(name);
        daoGroup.save(group);
        return group;
    }

    @Override
    public Group createGroupIfNotExist(String name) {
        Group group = daoGroup.findOneByName(name);
        if (null != group) {
            return group;
        }
        return createGroup(name);
    }

    @Override
    public Group getGroupByName(String name) {
        Group group = daoGroup.findOneByName(name);
        return group;
    }

    @Override
    public List<Group> getAllGroups() {
        return daoGroup.findAll();
    }

    public Group updateAuthoritiesInGroup(Group group) {
        for (Authority authority : group.getAuthorities()) {
            authority.setGroup(group);
        }
        return group;
    }

    @Override
    public Group addAuthoritiesToGroup(Group g, Set<Authority> authorities) throws EntityNotFoundException {
        Group group = daoGroup.findOne(g.getId());
        if (null == group) {
            throw new EntityNotFoundException("Group with id=" + g.getId() + " not found for update");
        }
        if (null == authorities) {
            return group;
        }
        group.getAuthorities().addAll(authorities);
        updateAuthoritiesInGroup(group);
        daoGroup.save(group);
        return group;
    }

    @Override
    public Group addAuthorityToGroup(Group g, Authority authority) throws EntityNotFoundException {
        return addAuthoritiesToGroup(g, new HashSet<>(Arrays.asList(authority)));
    }

    @Override
    public Group removeAuthoritiesFromGroup(Group g, Set<Authority> authorities) {
        Group group = daoGroup.findOne(g.getId());
        if (null == group || null == authorities) {
            return null;
        }
        group.getAuthorities().removeAll(authorities);
        updateAuthoritiesInGroup(group);
        daoGroup.save(group);
        return group;
    }

    @Override
    public Group removeAuthorityFromGroup(Group g, Authority authority) throws EntityNotFoundException {
        return removeAuthoritiesFromGroup(g, new HashSet<>(Arrays.asList(authority)));
    }

    @Override
    public List<UserJournal> findAllUsers() {
        List<UserJournal> l = daoUser.findAll();
        return l;
    }

    @Override
    public UserJournal createUser(String username, String password) throws EntityExistsException {
        UserJournal userJournal = daoUser.findOneByUsername(username);
        if (null == userJournal) {
            userJournal = new UserJournal();
            userJournal.setUsername(username);
            userJournal.setPassword(password);
            daoUser.save(userJournal);
            logger.trace("создаем пользователя - " + userJournal);
            return userJournal;
        }
        throw new EntityExistsException("user with given name already exist:" + userJournal);
    }

    @Override
    public UserJournal createUserIfNotExist(String username, String password) {
        UserJournal userJournal = daoUser.findOneByUsername(username);
        if (null == userJournal) {
            return createUser(username, password);
        }
        return userJournal;
    }

    @Override
    public UserJournal loadFullUser(UserJournal user) {
        user = daoUser.findOne(user.getId());
        user.getGroups().size();
        return user;
    }

    @Override
    public UserJournal getUser(String username) {
        UserJournal user = daoUser.findOneByUsername(username);
        user.getGroups().size();
        return user;
    }

    @Override
    public Set<Authority> getUserAuthority(UserJournal user) {
        user = daoUser.findOne(user.getId());
        user.getAuthorities().size();
        return user.getAuthorities();
    }


    @Override
    public UserJournal addGroupsToUser(UserJournal user, Set<Group> groups) {
        user = daoUser.findOne(user.getId());
        if (null != user) {
            user.getAuthorities().size();
            user.getGroups().addAll(groups);
            daoUser.save(user);
        }
        return user;
    }

    @Override
    public UserJournal addGroupToUser(UserJournal user, Group group) {
        return addGroupsToUser(user, new HashSet<>(Arrays.asList(group)));
    }

    @Override
    public UserJournal removeGroupsFromUser(UserJournal user, Set<Group> groups) {
        user = daoUser.findOne(user.getId());
        if (user != null) {
            user.getAuthorities().size();
            user.getGroups().removeAll(groups);
            daoUser.save(user);
        }
        return user;
    }

    @Override
    public UserJournal removeGroupFromUser(UserJournal user, Group group) {
        return removeGroupsFromUser(user, new HashSet<>(Arrays.asList(group)));
    }

//    @Autowired
//    public ServiceData(@Value("${usogdp.road.nameForSearch}") String bchRoadName) {
//        this.bchRoadName = bchRoadName;
//    }

}
