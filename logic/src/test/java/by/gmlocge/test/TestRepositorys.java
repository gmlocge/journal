package by.gmlocge.test;

import by.gmlocge.journal.entity.*;
import by.gmlocge.journal.entity.security.Role;
import by.gmlocge.journal.entity.security.UserAuthority;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.entity.security.UserRole;
import by.gmlocge.journal.repository.*;
import by.gmlocge.journal.service.ISecurityManage;
import by.gmlocge.journal.service.IServiseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TestRepositorys {
    private static final Logger logger = LoggerFactory.getLogger(TestRepositorys.class);

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("test-context.xml");
        testOne(ac);

        testUser(ac);
    }

    private static void testOne(ApplicationContext ac) {
        IServiseData serviseData = ac.getBean(IServiseData.class);
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
        IServiseData serviseData = ac.getBean(IServiseData.class);
        ISecurityManage securityManage = ac.getBean(ISecurityManage.class);
        IUserJournalRepository daoUser = ac.getBean(IUserJournalRepository.class);
//        IAccountRepository daoAccount = ac.getBean(IAccountRepository.class);

        String logIn = "test";
        String p = "test";
        UserJournal userJournal = securityManage.getUser(logIn);

//        Set<Role> roles = userJournal.getRoles();
//        Set<String> permissions = new HashSet<>();
//        for (Role role : roles) {
//            permissions.addAll(role.getPermissions());
//        }
//        System.out.println(permissions);
        UserAuthority ua = new UserAuthority("ROLE_CUSTOM");
        ua.setUser(userJournal);
//        UserJournal uAdmin = securityManage.createUser("d4", "admin", );

//        System.out.println(securityManage.findAllUsers());
        Set<UserAuthority> authorities = securityManage.getUserAuthority(userJournal);
        authorities.add(ua);
        userJournal.setAuthorities(authorities);
        securityManage.updateUser(userJournal);

        authorities = securityManage.getUserAuthority(userJournal);
        System.out.println(authorities);

    }

}
