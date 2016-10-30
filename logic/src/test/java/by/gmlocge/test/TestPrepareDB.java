package by.gmlocge.test;

import by.gmlocge.journal.Const;
import by.gmlocge.journal.entity.security.Group;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.repository.IDeviceRepository;
import by.gmlocge.journal.repository.IGroupRepository;
import by.gmlocge.journal.repository.IUserJournalRepository;
import by.gmlocge.journal.service.ISecurityManage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityExistsException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by d4 on 27.10.2016.
 */
@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPrepareDB {

    @Autowired
    IDeviceRepository daoDevice;

    @Autowired
    IUserJournalRepository daoUser;

    @Autowired
    IGroupRepository daoGroup;

    @Autowired
    private ISecurityManage sm;

    @Test
    public void testCheckAdmin(){
        UserJournal uj = daoUser.findOneByUsername("d4");
        assertNotNull(uj);
        assertEquals(uj.getUsername(),"d4");
    }

    @Test
    public void testCheckGroups(){
        Group adminGroup = daoGroup.findOneByName(Const.NAME_ADMIN_GROUP);
        assertNotNull(adminGroup);
        assertEquals(adminGroup.getName(),Const.NAME_ADMIN_GROUP);

        Group baseGroup = daoGroup.findOneByName(Const.NAME_BASE_GROUP);
        assertNotNull(baseGroup);
        assertEquals(baseGroup.getName(),Const.NAME_BASE_GROUP);
    }

    @Test(expected = EntityExistsException.class)
    public void testCatchExcepWhenCreateTheSameGroup(){
        sm.createGroup(Const.NAME_ADMIN_GROUP);
    }

    @Test
    public void testCheckSpringRepositoryInint(){
        assertNotNull(daoDevice);
        assertNotNull(daoUser);
        assertNotNull(daoGroup);
        assertNotNull(sm);
    }
}
