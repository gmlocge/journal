package by.gmlocge.journal.entity.security;

import by.gmlocge.journal.Const;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = Const.SCHEMA, name = "USERS")
public class UserJournal implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    @Size(min=2, max=25)
    private String username; // as login
    @Column(nullable = false)
    @Size(min=4, max=30)
    private String password;

    @Size(min=2, max=25)
    private String firstName;
    @Size(min=2, max=25)
    private String lastName;
    @Size(min=2, max=25)
    private String middleName;

    private String phone;

    private boolean accountNonLocked = true;
    private boolean enabled = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonExpired = true;

    private LocalDateTime siginDate;

    @ManyToMany
    @JoinTable(schema = Const.SCHEMA)
    @JsonIgnore
    private Set<Group> groups = new HashSet<>();

    @Override
    public Set<Authority> getAuthorities() {
        Set<Authority> authorities = new HashSet<>();
        for (Group group : groups) {
            authorities.addAll(group.getAuthorities());
        }
        return authorities;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getSiginDate() {
        return siginDate;
    }

    public void setSiginDate(LocalDateTime siginDate) {
        this.siginDate = siginDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserJournal{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
