package pl.coderslab.charity.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.coderslab.charity.dto.LoggedUserInformation;
import pl.coderslab.charity.entity.UserEntity;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@AllArgsConstructor
public class CustomUser implements UserDetails {

    private UserEntity userEntity;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
    }

    public void setPassword(String password) {
        userEntity.setPassword(password);
    }

    /**
     * Generates DTO object containing "safe" information about currently logged user.
     * Yeah, that means not sending password hash to view, just because it's easier to add CustomUser as ModelAttribute.
     *
     * @return DTO object with basic user info.
     */
    public LoggedUserInformation generateBasicInfo() {
        return new LoggedUserInformation(
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );
    }
}
