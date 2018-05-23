package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Abdullah Al Amin on 5/22/2018.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/hello")
    public @ResponseBody String hello(){
        return "hello world";
    }
}
