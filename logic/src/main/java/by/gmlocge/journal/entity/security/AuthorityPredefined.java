package by.gmlocge.journal.entity.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by D on 31.12.2015.
 */
public enum AuthorityPredefined implements GrantedAuthority {

    AUTH("ROLE_AUTH"),
    GUEST("ROLE_GUEST"),
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    BASE("ROLE_BASE");

    private String authority;

    AuthorityPredefined(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public Authority getGroupAuthority() {
        return new Authority(this.getAuthority());
    }

}
