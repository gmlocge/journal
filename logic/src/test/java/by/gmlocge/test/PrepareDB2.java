package by.gmlocge.test;

import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.repository.IUserJournalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by d4 on 27.10.2016.
 */
@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PrepareDB2 {

    @Autowired
    IUserJournalRepository daoUser;

    @Test
    public void testCheckAdmin(){

        UserJournal uj = daoUser.findOneByUsername("d4");
        System.out.println(uj);
//        assertTha


    }
}
