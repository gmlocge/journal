package by.gmlocge.journal.entity.security;

import by.gmlocge.journal.Const;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * http://stackoverflow.com/questions/28659115/spring-security-defining-user-registration-with-role-user
 *
 */
@Entity
@Table(schema = Const.SCHEMA)
@IdClass(Authority.class)
public class Authority implements GrantedAuthority {

    @Id
    private String authority;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Group group;

    public Authority() {
    }

    public Authority(GrantedAuthority ga) {
        this.authority = ga.getAuthority();
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

        Authority that = (Authority) o;

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
