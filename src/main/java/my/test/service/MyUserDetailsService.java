package my.test.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Component
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user =
                User.withUsername("user1")
//                        .password(new BCryptPasswordEncoder().encode("password")) //password with bcrypt
                        .password("$2a$10$RiNzPYRQ4h/bBYbZy7Jbdu9/yk/uAEd0MCfR2DuuZGjmXlDI5fFjm") //spring security bug, BCryptPassword must start with $2a
                        .roles("USER")
                        .build();
        return user;
    }
}
