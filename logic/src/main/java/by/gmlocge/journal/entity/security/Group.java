package by.gmlocge.journal.entity.security;

import by.gmlocge.journal.Const;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = Const.SCHEMA, name = "ugroups")
public class Group implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Authority> authorities = new HashSet<>();

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group role = (Group) o;

        return name.equals(role.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
