package my.test.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/hello")
    public String greeting1(){
        return "ni hao";
    }

    @GetMapping("/hand")
    public String greeting2(){
        return "hand shake";
    }
}
