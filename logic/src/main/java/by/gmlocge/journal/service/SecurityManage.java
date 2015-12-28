package by.gmlocge.journal.service;

import by.gmlocge.journal.Const;
import by.gmlocge.journal.entity.security.Account;
import by.gmlocge.journal.entity.security.Role;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class SecurityManage implements ISecurityManage {
    private static final Logger logger = LoggerFactory.getLogger(SecurityManage.class);

    @Autowired
    private IAccountRepository daoAccount;
    @Autowired
    private IUserJournalRepository daoUser;
    @Autowired
    private IRoleRepository daoRole;

    @PostConstruct
    private void init() {
        // создаем роль гостя
        logger.trace("обновление ролей");
        Role rSimply = createOrUpdateRole(Const.NAME_SIMPLY_ROLE, Const.PERMISSIONS_AUTH);
        logger.trace("update role - " + rSimply);
        // создаем роль админа
        Role rAdmin = createOrUpdateRole(Const.NAME_ADMIN_ROLE, Const.PERMISSIONS_ALL);
        logger.trace("update role - " + rAdmin);

        UserJournal uAdmin = createUser("d4", "admin");
        uAdmin = updateUser(uAdmin, new HashSet<>(Arrays.asList(rSimply, rAdmin)));
//        logger.trace("update user - " + uAdmin);
        UserJournal uSimply = createUser("test", "test");
        uSimply = updateUser(uSimply, new HashSet<>(Arrays.asList(rSimply)));
//        logger.trace("update user - " + uSimply);
        UserJournal uGuest = createUser("guest", "guest");
        uGuest = updateUser(uGuest, new HashSet<>(Arrays.asList(rSimply)));
//        logger.trace("update user - " + uGuest);

    }

    @Override
    public Role createOrUpdateRole(String name, Set<String> permissions) {
        Role role = daoRole.findOneByName(name);
        if (null == role) {
            role = new Role();
            role.setName(name);
            daoRole.save(role);
        }
        role.setPermissions(permissions);
        daoRole.save(role);
        return role;
    }

    @Override
    public Set<Role> createOrUpdateRoleIfNotExist(Set<Role> roles) {
        for (Role role : roles) {
            if (null == role.getId() || 0 == role.getId()) {
                daoRole.save(role);
            }
        }
        return roles;
    }

    @Override
    public List<UserJournal> findAllUsers() {
        List<UserJournal> l = daoUser.findAll();
        return l;
    }


    @Override
    public UserJournal createUser(String login, String password) {
        UserJournal userJournal = null;
        Account account = daoAccount.findOneByLogin(login);
        userJournal = daoUser.findOneByAccounts(account);
        if (null == account || null == userJournal) {
            if (null == account) {
                account = new Account();
            }
            account.setLogin(login);
            account.setEmail(login);
            account.setPassword(password);
            userJournal = new UserJournal();
            userJournal.setFirstName(login);
            userJournal.getAccounts().add(account);
            daoAccount.save(account);
            daoUser.save(userJournal);
            logger.trace("создаем пользователя - " + userJournal);
        } else {
            userJournal = daoUser.findOneByAccounts(account);
            logger.trace("пользователь с таким логином уже существует- " + account);
        }
        return userJournal;
    }

    @Override
    @Transactional
    public UserJournal getUser(String login) {
        UserJournal userJournal = null;
        Account account = daoAccount.findOneByLogin(login);
        userJournal = daoUser.findOneByAccounts(account);
        return userJournal;
    }

    @Override
    public Set<String> getUserPermissions(UserJournal userJournal) {
        userJournal =  daoUser.findOne(userJournal.getId());
        Set<Role> roles = userJournal.getRoles();
        Set<String> permissions = new HashSet<>();
        for (Role role : roles) {
            permissions.addAll(role.getPermissions());
        }
        return permissions;
    }


    @Override
    @Transactional
    public UserJournal updateUser(UserJournal user, Set<Role> roles) {
        if (user != null) {
            roles = createOrUpdateRoleIfNotExist(roles);
            user.setRoles(roles);
            daoUser.save(user);
        }
        return user;
    }
//        @Override
//        @Transactional(propagation = Propagation.REQUIRED)
//        public UserJournal addPermission (String login, Set < String > permissions){
//        Account account = daoAccount.findOneByLogin(login);
//            UserJournal userJournal = null;
//        if (account != null) {
//            userJournal = daoUser.findOneByAccounts(account);
////            Hibernate.initialize(userJournal.getPermissions());
//            userJournal.getPermissions().addAll(permissions);
//            daoUser.save(userJournal);
//        }
//            return userJournal;
//        }


//    @Autowired
//    public ServiceData(@Value("${usogdp.road.nameForSearch}") String bchRoadName) {
//        this.bchRoadName = bchRoadName;
//    }

}
