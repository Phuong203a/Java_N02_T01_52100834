package com.example.ex1;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.net.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
    public class HomeController {

        @GetMapping("/")
        public String index() {
            return "index";
        }

        @GetMapping("/contact")
        public String contact() {
            return "contact";
        }

        @PostMapping("/contact")
        public String showContactInfo(@RequestParam("name") String name, @RequestParam("job") String job, @RequestParam("age") int age, Model model) {
            model.addAttribute("name", name);
            model.addAttribute("job", job);
            model.addAttribute("age", age);
            return "submit-contact";
        }

        @GetMapping("/about")
        public String about() {
            return "about";
        }

        @RequestMapping(value = "/{path:[^\\.]*}")
        public String handleUnsupportedGetMethod() {
            return "err-request-get";
        }


    }
    etErrorCode(HttpServletRequest httpRequest) {
        return 0;
    }
}
