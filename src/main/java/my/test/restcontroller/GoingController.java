package my.test.restcontroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/going")
public class GoingController {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/school")
    public String go2() {
        return "go to school";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/zoo")
    public String go1() {
        return "go to zoo";
    }
}
