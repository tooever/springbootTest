package com.jf.exam.pojo;

import javax.persistence.*;

@Table(name = "t_userrole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rolename;

    private String rolecode;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return rolename
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * @param rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * @return rolecode
     */
    public String getRolecode() {
        return rolecode;
    }

    /**
     * @param rolecode
     */
    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }
}