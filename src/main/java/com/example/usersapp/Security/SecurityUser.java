package com.example.usersapp.Security;

import com.example.usersapp.model.Privilege;
import com.example.usersapp.model.Role;
import com.example.usersapp.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SecurityUser implements UserDetails {
    private final User user;

    @Override
    public String getUsername() {
        System.out.println("SecurityUser: getUsername");
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        System.out.println("SecurityUser: getPassword");
        return user.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("SecurityUser: getAuthorities");
        return user
                .getRoles()
                .stream()
                .map(SecurityRole::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        System.out.println("SecurityUser: isAccountNonExpired");
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        System.out.println("SecurityUser: isAccountNonLocked");
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        System.out.println("SecurityUser: isCredentialsNonExpired");
        return true;
    }

    @Override
    public boolean isEnabled() {
        System.out.println("SecurityUser: isEnabled");
        return true;
    }
    private List<String> getPrivileges(List<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

//    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String privilege : privileges) {
//            authorities.add(new SecurityPrivilege(privilege));
//        }
//        return authorities;
//    }
}