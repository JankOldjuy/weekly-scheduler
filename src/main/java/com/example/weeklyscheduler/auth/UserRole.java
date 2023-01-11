package com.example.weeklyscheduler.auth;

import java.util.List;
/**
 * @author jmo
 */
public enum UserRole {

    USER(List.of(Permission.USER_CREATE, Permission.USER_DELETE,
            Permission.USER_UPDATE)),
    ADMIN(List.of(Permission.ADMIN_CREATE, Permission.ADMIN_DELETE, Permission.ADMIN_UPDATE));


    private List<Permission> permissions;

    UserRole(List<Permission> permissions){
    this.permissions = permissions;
    }


    public List<Permission> getPermissions() {
        return permissions;
    }

    /**
     * @author jmo
     */
    public enum Permission {

        ADMIN_DELETE, ADMIN_CREATE, ADMIN_UPDATE,
        USER_DELETE, USER_CREATE, USER_UPDATE
    }
}
