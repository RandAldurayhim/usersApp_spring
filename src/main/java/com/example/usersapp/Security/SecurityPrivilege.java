package com.example.usersapp.Security;

import com.example.usersapp.model.Privilege;


public class SecurityPrivilege {
    private final Privilege privilege;
    public SecurityPrivilege(String privilege){
        Privilege P = new Privilege();
        P.setName(privilege);
        this.privilege=P;
    }

}
