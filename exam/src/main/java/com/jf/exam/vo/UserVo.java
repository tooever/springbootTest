package com.jf.exam.vo;

import com.jf.exam.pojo.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String sfzh;

    private String rolename;

    private String status;

    private List<UserRole> userRoleList;


}
