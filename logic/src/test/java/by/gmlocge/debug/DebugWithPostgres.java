package by.gmlocge.debug;

import by.gmlocge.journal.entity.Device;
import by.gmlocge.journal.entity.Org;
import by.gmlocge.journal.entity.Serve;
import by.gmlocge.journal.entity.security.AuthorityPredefined;
import by.gmlocge.journal.entity.security.Group;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.repository.*;
import by.gmlocge.journal.service.ISecurityManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

public class DebugWithPostgres {
    private static final Logger logger = LoggerFactory.getLogger(DebugWithPostgres.class);

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("debug-context-postgres.xml");
//        testOne(ac);
//        testGroup(ac);

        testUser(ac);
    }

    private static void testGroup(ApplicationContext ac) {
        IGroupRepository daoGroup = ac.getBean(IGroupRepository.class);
        ISecurityManage securityManage = ac.getBean(ISecurityManage.class);

//        System.out.println(daoGroup.findOneByName(Const.NAME_ADMIN_GROUP));

        Group group = securityManage.createGroupIfNotExist("test");

//        securityManage.addAuthorityToGroup(group, AuthorityPredefined.BASE.getGroupAuthority());
        group = securityManage.addAuthoritiesToGroup(group, securityManage.createAuthorities(AuthorityPredefined.values()));
        System.out.println("add ga");
        System.out.println(group);
        group = securityManage.removeAuthoritiesFromGroup(group, securityManage.createAuthorities(AuthorityPredefined.values()));
        System.out.println("remove ga");
        System.out.println(group);
    }


    private static void testOne(ApplicationContext ac) {
//        ServiceData serviseData = ac.getBean(ServiceData.class);
        IDeviceRepository daoDevice = ac.getBean(IDeviceRepository.class);
        IServeRepository daoServe = ac.getBean(IServeRepository.class);
        IOrgRepository daoOrg = ac.getBean(IOrgRepository.class);

        String devName = "dev-" + UUID.randomUUID();
        Device device = daoDevice.findOneByName(devName);
        if (device == null) {
            device = new Device();
            device.setName(devName);
            daoDevice.save(device);
        }
        String orgName = "gomel org-" + UUID.randomUUID();
        Org org = new Org();
        org.setName(orgName);
        daoOrg.save(org);

        Serve serve = new Serve();
        serve.setDevice(device);
        serve.setBegin(LocalDateTime.now());
        serve.setEnd(LocalDateTime.now());
        serve.setOrg(org);
        daoServe.save(serve);
    }

    private static void testUser(ApplicationContext ac) {
//        ServiceData serviseData = ac.getBean(ServiceData.class);
        ISecurityManage sm = ac.getBean(ISecurityManage.class);
        IUserJournalRepository daoUser = ac.getBean(IUserJournalRepository.class);

        UserJournal testU = sm.createUserIfNotExist("testR", "testR");
        testU = sm.addGroupsToUser(testU, new HashSet<>());
        logger.info("update - " + testU);

        for(UserJournal uj: daoUser.findAll() ){
            System.out.println(uj);
        }

//        IAccountRepository daoAccount = ac.getBean(IAccountRepository.class);

//        String logIn = "test";
//        String p = "test";
//        UserJournal userJournal = securityManage.createUserIfNotExist(logIn, p);
//        userJournal = securityManage.loadFullUser(userJournal);
//        System.out.println(userJournal);
//        List<Group> groups = securityManage.getAllGroups();
//        userJournal = securityManage.addGroupsToUser(userJournal, new HashSet<>(groups));
//
//        Set<Authority> authorities = securityManage.getUserAuthority(userJournal);
//        System.out.println(authorities);
//        Set<Group> roles = userJournal.getRoles();
//        Set<String> permissions = new HashSet<>();
//        for (Group role : roles) {
//            permissions.addAll(role.getPermissions());
//        }
//        System.out.println(permissions);
//        Authority ua = new Authority("ROLE_CUSTOM");
//        ua.setUser(userJournal);

//        UserJournal uAdmin = securityManage.createUser("d4", "admin", );

//        System.out.println(securityManage.findAllUsers());
//        Set<Authority> authorities = securityManage.getUserAuthority(userJournal);
//        authorities.add(ua);
//        userJournal.setAuthorities(authorities);
//        securityManage.updateUser(userJournal);

//        authorities = securityManage.getUserAuthority(userJournal);
//        System.out.println(authorities);

    }

}
