package by.gmlocge.journal.service;

import by.gmlocge.journal.Const;
import by.gmlocge.journal.entity.security.Role;
import by.gmlocge.journal.entity.security.UserAuthority;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.entity.security.UserRole;
import by.gmlocge.journal.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class SecurityManage implements ISecurityManage {
    private static final Logger logger = LoggerFactory.getLogger(SecurityManage.class);

    @Autowired
    private IUserJournalRepository daoUser;
//    @Autowired
//    private IUserAuthorityRepository daoUserAuthority;

    @PostConstruct
    private void init() {
        // создаем роль гостя
//        logger.trace("обновление ролей");
//        Role rSimply = createOrUpdateRole(Const.NAME_SIMPLY_ROLE, Const.PERMISSIONS_AUTH);
//        logger.trace("update role - " + rSimply);
//         создаем роль админа
//        Role rAdmin = createOrUpdateRole(Const.NAME_ADMIN_ROLE, Const.PERMISSIONS_ALL);
//        logger.trace("update role - " + rAdmin);


        UserJournal uAdmin = createUser("d4", "admin", createAuthorities(UserRole.values()));

//        uAdmin = updateUser(uAdmin, new HashSet<>(Arrays.asList(rSimply, rAdmin)));
//        logger.trace("update user - " + uAdmin);
        UserJournal uSimply = createUser("test", "test", createAuthorities(UserRole.AUTH, UserRole.GUEST));
//        uSimply = updateUser(uSimply, new HashSet<>(Arrays.asList(rSimply)));
////        logger.trace("update user - " + uSimply);
//        UserJournal uGuest = createUser("guest", "guest");
//        uGuest = updateUser(uGuest, new HashSet<>(Arrays.asList(rSimply)));
////        logger.trace("update user - " + uGuest);

    }



    @Override
    public Set<UserAuthority> createAuthorities(GrantedAuthority... gas) {
        Set<UserAuthority> authorities = new HashSet<>();
        for (GrantedAuthority grantedAuthority : gas) {
            UserAuthority ua = new UserAuthority(grantedAuthority);
            authorities.add(ua);
        }
        return  authorities;
    }

//    @Override
//    public Role createOrUpdateRole(String name, Set<String> permissions) {
//        Role role = daoRole.findOneByName(name);
//        if (null == role) {
//            role = new Role();
//            role.setName(name);
//            daoRole.save(role);
//        }
//        role.setPermissions(permissions);
//        daoRole.save(role);
//        return role;
//    }
//
//    @Override
//    public Set<Role> createOrUpdateRoleIfNotExist(Set<Role> roles) {
//        for (Role role : roles) {
//            if (null == role.getId() || 0 == role.getId()) {
//                daoRole.save(role);
//            }
//        }
//        return roles;
//    }

    @Override
    public List<UserJournal> findAllUsers() {
        List<UserJournal> l = daoUser.findAll();
        return l;
    }

    @Override
    @Transactional
    public UserJournal updateUser(UserJournal user) {
        return daoUser.save(user);
    }


    @Override
    public UserJournal createUser(String username, String password, Set<UserAuthority> authorities) {
        UserJournal userJournal = null;
        userJournal = daoUser.findOneByUsername(username);
        if (null == userJournal) {
            userJournal = new UserJournal();
            userJournal.setUsername(username);
            userJournal.setPassword(password);
            userJournal.setAuthorities(updateUserForAuthorities(userJournal,authorities));
            daoUser.save(userJournal);
            logger.trace("создаем пользователя - " + userJournal);
        }
        return userJournal;
    }

    Set<UserAuthority> updateUserForAuthorities(UserJournal user, Set<UserAuthority> authorities ){
        for (UserAuthority authority : authorities) {
            authority.setUser(user);
        }
        return  authorities;
    }

    @Override
    public UserJournal getUser(String login) {
        return daoUser.findOneByUsername(login);
    }

    @Override
    public Set<UserAuthority> getUserAuthority(UserJournal userJournal) {
        userJournal = daoUser.findOne(userJournal.getId());
        userJournal.getAuthorities().size();
        return userJournal.getAuthorities();
//        Set<Role> roles = userJournal.getRoles();
//        Set<String> permissions = new HashSet<>();
//        for (Role role : roles) {
//            permissions.addAll(role.getPermissions());
//        }
//        return permissions;
    }


//    @Override
//    @Transactional
//    public UserJournal updateUser(UserJournal user, Set<Role> roles) {
//        if (user != null) {
//            roles = createOrUpdateRoleIfNotExist(roles);
//            user.setRoles(roles);
//            daoUser.save(user);
//        }
//        return user;
//    }
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
