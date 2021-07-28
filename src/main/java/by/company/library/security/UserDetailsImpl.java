package by.company.library.security;

import by.company.library.domain.dbo.RoleEntity;
import by.company.library.domain.dbo.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String passportNo;
    private String name;
    private String surName;
    private Date birthDate;
    private String password;
    private String email;
    private String phone;
    private RoleEntity role;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl fromUserEntityToUserDetailsImpl(UserEntity userEntity) {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.passportNo = userEntity.getPassportNo();
        userDetails.name = userEntity.getName();
        userDetails.surName = userEntity.getSurname();
        userDetails.email = userEntity.getEmail();
        userDetails.password = userEntity.getPassword();
        userDetails.phone = userEntity.getPhone();
        userDetails.birthDate = userEntity.getBirthDate();
        userDetails.role = userEntity.getRole();
        userDetails.authorities = Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole().getRoleType()));
        return userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}