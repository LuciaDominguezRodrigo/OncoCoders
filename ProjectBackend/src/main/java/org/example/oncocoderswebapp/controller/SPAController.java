package org.example.oncocoderswebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SPAController {


        @RequestMapping(value = {"/", "/{path:[^\\.]*}"})
        public String forwardToAngular() {
            return "forward:/index.html";
        }
}


