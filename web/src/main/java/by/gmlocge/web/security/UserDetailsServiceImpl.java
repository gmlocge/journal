package by.gmlocge.web.security;

import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.service.ISecurityManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private ISecurityManage securityManage;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Ищем в базе юзера по его имени");
        UserJournal uj = securityManage.getUser(username);
        uj = securityManage.loadFullUser(uj);
//        Set<String> per = securityManage.getUserPermissions(uj);
//        String pw = uj.ge
//        if (null == uj ) throw new UsernameNotFoundException("Не найден пользователь с таким именем, или не верный пароль");
//        User user = new User(username,"pw",null );
        return uj;
//                new UserWeb(username, user.getPassword(), true,  user.getActive(), true, true, getGrantedAuthority(user), user);
    }

//    public List<SimpleGrantedAuthority> getGrantedAuthority(User user){
//        List<NodeProperty> lGr=new ArrayList<>();
//        for (Group r:user.getRoles()){
//            lGr.addAll(userManagerService.getPropertysValue(r, Group.NAME_FIELD_PERMISSION_FOR_NODE_PROPERTY));
//        }
//
//        List<SimpleGrantedAuthority> gal=new ArrayList<>();
//        for(NodeProperty np:lGr){
//            gal.add(new SimpleGrantedAuthority(np.getValue()));
//        }
//
//        return gal;
//    }

}
