package by.gmlocge.test;

import by.gmlocge.journal.entity.security.Authority;
import by.gmlocge.journal.entity.security.AuthorityPredefined;
import by.gmlocge.journal.entity.security.Group;
import by.gmlocge.journal.repository.IGroupRepository;
import by.gmlocge.journal.repository.IUserJournalRepository;
import by.gmlocge.journal.service.ISecurityManage;
import by.gmlocge.journal.service.SecurityManage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by d4 on 27.10.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestSecurityManage {

    @InjectMocks
    ISecurityManage securityManage = new SecurityManage();

    @Mock
    private IUserJournalRepository daoUser;
    @Mock
    private IGroupRepository daoGroup;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testCreateGroup() {
        // Given
        String groupName = "admin";
        Group group = new Group();
        group.setName(groupName);
        when(daoGroup.findOneByName(groupName)).thenReturn(null);
        when(daoGroup.save(group)).thenReturn(group);
        // when
        Group result = securityManage.createGroup(groupName);
        // Then
        verify(daoGroup, times(1)).findOneByName(groupName);
        verify(daoGroup, times(1)).save(group);
        assertThat(result, is(group));
    }

    @Test(expected = EntityExistsException.class)
    public void testTrowExceptionWhenCreateGroup() {
        // Given
        when(daoGroup.findOneByName("exising group")).thenReturn(new Group());
        // when
        securityManage.createGroup("exising group");
    }

    @Test(expected = EntityNotFoundException.class)
    public void testNotFoundWhenAddAuthoritiesToGroup() {
        // Given
        Integer id = 1;
        Group group = new Group();
        group.setId(id);
        when(daoGroup.findOne(id)).thenReturn(null);
        // when
        securityManage.addAuthoritiesToGroup(group, null);
    }

    @Test
    public void testNothingToAddWhenAddAuthoritiesToGroup() {
        // Given
        Integer id = 1;
        Group group = new Group();
        group.setId(id);
        when(daoGroup.findOne(id)).thenReturn(group);
        // when
        Group result = securityManage.addAuthoritiesToGroup(group, null);
        // then
        verify(daoGroup, times(1)).findOne(id);
        assertThat(result.getAuthorities(), is(group.getAuthorities()));
    }

    @Test
    public void testAddAuthoritiesToGroup() {
        // Given
        Integer id = 1;
        Group group = new Group();
        group.setId(id);
        when(daoGroup.findOne(id)).thenReturn(group);
        when(daoGroup.save(group)).thenReturn(group);
        Set<Authority> authorities = securityManage.createAuthorities(AuthorityPredefined.AUTH, AuthorityPredefined.GUEST);
        // when
        Group result = securityManage.addAuthoritiesToGroup(group, authorities);
        System.out.println(group);
        // Then
        System.out.println(result);
        verify(daoGroup, times(1)).findOne(id);
        verify(daoGroup, times(1)).save(group);
        Assert.assertEquals(authorities.size(), result.getAuthorities().size());
        for (Authority authority: result.getAuthorities()){
            assertThat(authority.getGroup(), is(result));
            Assert.assertTrue(authorities.contains(authority));
        }

    }

}
