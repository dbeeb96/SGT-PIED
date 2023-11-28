package com.sgtpied.sgt.manager.controllers;
import com.sgtpied.sgt.manager.models.Module;

import com.sgtpied.sgt.manager.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    //Lister tous les modules
    @GetMapping("/parameters/modules")
    public String parameters(Model model){
        List<Module> modules = moduleService.findAll();
        model.addAttribute("modules", modules);
        return "/parameters/modules";
    }

    //Obtenir le travail de son id
    @GetMapping("/parameters/module/{id}")
    @ResponseBody
    public Module getById(@PathVariable Integer id){
        return moduleService.findById(id);
    }
// Sauvegarder les modules
    @PostMapping("/parameters/modules")
    public String save(Module module){
        moduleService.save(module);
        return "redirect:/parameters/modules";
    }
// Supprimer le modules de par son id
    @RequestMapping(value="/parameters/module/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        moduleService.delete(id);
        return "redirect:/parameters/modules";
    }

}
