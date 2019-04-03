package my.test.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyUserDetailsService2 implements UserDetailsService {

    private List<UserObject> users = new ArrayList();

    public MyUserDetailsService2() {
        String pw1 = "$2a$10$TkEUwNcmzltJZSFmMpIWLuTaCbnNYScwgR17aMb02PL1TqsTl26g2"; //123
        String pw2 = "$2a$10$6Cj8Ad4co61ini1hix1BPOoN01KPVP5.WrO.DspH/Z..jQOw1urWm"; //456
        users.add(new UserObject("user1", pw1, "USER"));
        users.add(new UserObject("user2", pw2, "ADMIN"));
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserObject> user = users.stream()
                .filter(u -> u.name.equals(userName))
                .findAny();
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found by name: " + userName);
        }
        return toUserDetails(user.get());
    }

    private UserDetails toUserDetails(UserObject userObject) {
        return User.withUsername(userObject.name)
                .password(userObject.password)
                .roles(userObject.role).build();
    }

    private static class UserObject {
        private String name;
        private String password;
        private String role;

        public UserObject(String name, String password, String role) {
            this.name = name;
            this.password = password;
            this.role = role;
        }
    }
}
