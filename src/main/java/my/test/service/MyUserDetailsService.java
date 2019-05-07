package my.test.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

//@Component
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user =
                User.withUsername("johnny")
//                        .password(new BCryptPasswordEncoder().encode("password")) //password with bcrypt
                        .password("$2a$10$TkEUwNcmzltJZSFmMpIWLuTaCbnNYScwgR17aMb02PL1TqsTl26g2") //spring security bug, BCryptPassword must start with $2a //123
                        .roles("USER")
                        .build();
        return user;
    }
}
