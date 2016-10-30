package by.gmlocge.journal.service;

import by.gmlocge.journal.Const;
import by.gmlocge.journal.entity.security.AuthorityPredefined;
import by.gmlocge.journal.entity.security.Group;
import by.gmlocge.journal.entity.security.UserJournal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by D on 03.01.2016.
 */
@Service
public class ServicePrepareDB {
    private static final Logger logger = LoggerFactory.getLogger(ServicePrepareDB.class);

    @Autowired
    private ISecurityManage sm;

    @Autowired
    private DataSource ds;

    public static void createSchema(DataSource ds) {
        try {
            Connection con = ds.getConnection();
            Statement st = con.createStatement();
            boolean hasCreated = st.execute("CREATE SCHEMA IF NOT EXISTS JOURNAL");
            logger.info("hack: schema JOURNAL has created! status:{}", hasCreated);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    @PostConstruct
    private void init() {
        // this is hack: all will be work after second run;
        createSchema(ds);
        // -----------------
        Group gBase = sm.createGroupIfNotExist(Const.NAME_BASE_GROUP);
        gBase = sm.addAuthoritiesToGroup(gBase, sm.createAuthorities(AuthorityPredefined.AUTH, AuthorityPredefined.GUEST));
        logger.info("update - " + gBase);
        Group gAdmin = sm.createGroupIfNotExist(Const.NAME_ADMIN_GROUP);
        gAdmin = sm.addAuthoritiesToGroup(gAdmin, sm.createAuthorities(AuthorityPredefined.values()));
        logger.info("update - " + gAdmin);

        UserJournal uAdmin = sm.createUserIfNotExist("d4", "admin");
        uAdmin = sm.addGroupsToUser(uAdmin, new HashSet<>(Arrays.asList(gBase, gAdmin)));
        logger.info("update - " + uAdmin);

        UserJournal uTest = sm.createUserIfNotExist("test", "1test");
        uTest = sm.addGroupToUser(uTest, gBase);
        logger.info("update - " + uTest);

    }

}
