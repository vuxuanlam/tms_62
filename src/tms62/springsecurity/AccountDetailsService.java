package tms62.springsecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tms62.business.AccountBusiness;
import tms62.constant.value.DatabaseValue;
import tms62.model.entity.Users;
import tms62.util.Helpers;

public class AccountDetailsService implements UserDetailsService {
    
    AccountBusiness        accountBusiness;
    Users                  user;
    SimpleGrantedAuthority authority;
    List<GrantedAuthority> authorities;
    AccountDetails         accountDetails;
    
    public void setAccountBusiness(AccountBusiness accountBusiness) {
    
        this.accountBusiness = accountBusiness;
    }
    
    public AccountBusiness getAccountBusiness() {
    
        return accountBusiness;
    }
    
    @Override
    public AccountDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
    
        user = accountBusiness.getUserByEmail(email);
        if (Helpers.isExist(user)) {
            authorities = new ArrayList<GrantedAuthority>();
            if (user.getRole() == DatabaseValue.ADMIN)
                authority = new SimpleGrantedAuthority("ROLE_ADMIN");
            else
                if (user.getRole() == DatabaseValue.SUPERVIOR)
                    authority = new SimpleGrantedAuthority("ROLE_SUPERVIOR");
                else
                    authority = new SimpleGrantedAuthority("ROLE_USER");
            authorities.add(authority);
            accountDetails = new AccountDetails(user.getUserId(), email,
                    user.getPassword(), authorities);
            return accountDetails;
        }
        else {
            throw new UsernameNotFoundException("Email not found");
        }
    }
}
