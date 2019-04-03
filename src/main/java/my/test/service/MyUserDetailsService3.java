package my.test.service;

import my.test.database.entity.Account;
import my.test.database.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService3 implements UserDetailsService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(userName);
        if (account == null) {
            throw new UsernameNotFoundException("Account not found by name: " + userName);
        }
        return toUserDetails(account);
    }

    private UserDetails toUserDetails(Account account) {
        return User.withUsername(account.getUserName())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }
}
