package by.gmlocge.journal.entity;

import by.gmlocge.journal.Const;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = Const.SCHEMA)
public class Serve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn
    private Device device;

    @OneToOne
    @JoinColumn
    private Org org;

    private LocalDateTime begin;
    private LocalDateTime end;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
