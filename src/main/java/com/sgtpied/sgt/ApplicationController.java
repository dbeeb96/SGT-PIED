package com.sgtpied.sgt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String goHome(){
        return "index";
    }
    @GetMapping("taches")
    public String taches(){
        return "/taches/index";
    }
    @GetMapping("hr")
    public String manager(){
        return "/employee/index";
    }

    @GetMapping("fleet")
    public String fleet(){
        return "/projet/index";
    }

    @GetMapping("accounts")
    public String accounts(){
        return "/accounts/index";
    }

    @GetMapping("payroll")
    public String payroll(){
        return "/payroll/index";
    }
    @GetMapping("parameters")
    public String parameters(){
        return "/parameters/index";
    }

    @GetMapping("reports")
    public String reports(){
        return "/reports/index";
    }

    @GetMapping("security")
    public String security(){
        return "/security/index";
    }

    @GetMapping("/fullCalendar")
    public String showFullCalendar() {
        return "calandar/fullCalendar"; // This maps to the fullCalendar.html template
    }
}
