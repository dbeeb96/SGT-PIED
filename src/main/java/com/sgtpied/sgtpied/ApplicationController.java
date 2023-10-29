package com.sgtpied.sgtpied;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String goHome(){
        return "index";
    }

    @GetMapping("hr")
    public String manager(){
        return "/manager/index";
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

    @GetMapping("helpdesk")
    public String helpdesk(){
        return "/taches/index";
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

}
