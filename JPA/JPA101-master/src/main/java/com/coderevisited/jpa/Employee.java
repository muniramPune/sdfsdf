package com.coderevisited.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "eid")
    private int id;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lanme")
    private String lanme;

    
    @Column(name = "desg")
    private String desg;

    public Employee() {

    }

    public Employee(int id, String fname, String lanme, String desg) {
        this.setId(id);
        this.setfname(fname);
        this.setlanme(lanme);
        this.setdesg(desg);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfname() {
        return fname;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public String getlanme() {
        return lanme;
    }

    public void setlanme(String lanme) {
        this.lanme = lanme;
    }

    public String getdesg() {
        return desg;
    }

    public void setdesg(String desg) {
        this.desg = desg;
    }
}
