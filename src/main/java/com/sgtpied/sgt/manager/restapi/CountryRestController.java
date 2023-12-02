/*package com.sgtpied.sgt.manager.restapi;

import com.sgtpied.sgt.manager.models.Tasks;
import com.sgtpied.sgt.manager.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/api/parameters/countries")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Tasks> getAll(){
        List<Tasks> countries =   tasksService.findAll();
        return countries;
    }
}
*/