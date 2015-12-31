package by.gmlocge.journal.entity.security;

import by.gmlocge.journal.Const;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(schema = Const.SCHEMA)
public class UserAuthority implements GrantedAuthority {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @Id
    private UserJournal user;

    @NotNull
    @Id
    private String authority;

    public UserAuthority() {
    }

    public UserAuthority(GrantedAuthority ga) {
        this.authority = ga.getAuthority();
    }

    public UserAuthority(String authority) {
        this.authority = authority;
    }

    public UserJournal getUser() {
        return user;
    }

    public void setUser(UserJournal user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAuthority that = (UserAuthority) o;

        return !(authority != null ? !authority.equals(that.authority) : that.authority != null);

    }

    @Override
    public int hashCode() {
        return authority != null ? authority.hashCode() : 0;
    }

    @Override
    public String toString() {
        return authority;
    }
}
