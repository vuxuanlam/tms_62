package tms62.springsecurity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountDetails implements UserDetails {
    
    private static final long      serialVersionUID = 1L;
    private int                    userId;
    private String                 email;
    private String                 password;
    private List<GrantedAuthority> authorities;
    
    public AccountDetails(int userId, String email, String password,
            List<GrantedAuthority> authorities) {
    
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    public int getUserId() {
    
        return this.userId;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    
        // TODO Auto-generated method stub
        return authorities;
    }
    
    @Override
    public String getPassword() {
    
        // TODO Auto-generated method stub
        return password;
    }
    
    @Override
    public String getUsername() {
    
        // TODO Auto-generated method stub
        return email;
    }
    
    @Override
    public boolean isAccountNonExpired() {
    
        // TODO Auto-generated method stub
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
    
        // TODO Auto-generated method stub
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
    
        // TODO Auto-generated method stub
        return true;
    }
    
    @Override
    public boolean isEnabled() {
    
        // TODO Auto-generated method stub
        return true;
    }
}
