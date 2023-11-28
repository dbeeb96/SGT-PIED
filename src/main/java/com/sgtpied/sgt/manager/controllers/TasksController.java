package com.sgtpied.sgt.manager.controllers;
import com.sgtpied.sgt.manager.models.Tasks;
import com.sgtpied.sgt.manager.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/parameters/tasks")
    public String getAllPages(Model model){
        return getOnePage(model, 1);
    }

    @GetMapping("/parameters/tasks/page/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage){
        Page<Tasks> page = tasksService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<Tasks> tasks = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("tasks", tasks);

        return "/parameters/tasks";
    }

//    @GetMapping("/parameters/countries")
//    public String getAll(Model model, String keyword){
//        List<Tasks> countries;
//        countries = (keyword == null) ? tasksService.findAll():  tasksService.findByKeyword(keyword);
//        model.addAttribute("countries", countries);
//        return "/parameters/countries";
//    }

//    @GetMapping("/parameters/countries/{field}")
//    public String getAllWithSort(Model model, @PathVariable String field, @PathParam("sortDir") String sortDir){
//        List<Tasks> countries;
//        countries = tasksService.findTasksWithSorting2(field, sortDir);
//        model.addAttribute("sortDir", sortDir);
//        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
//        model.addAttribute("countries", countries);
//        return "/parameters/countries";
//    }

    @GetMapping("/parameters/tasks/page/{pageNumber}/{field}")
    public String getPageWithSort(Model model,
                                  @PathVariable("pageNumber") int currentPage,
                                  @PathVariable String field,
                                  @PathParam("sortDir") String sortDir){

        Page<Tasks> page = tasksService.findTasksWithSorting2(field, sortDir, currentPage);
        List<Tasks> tasks = page.getContent();
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
        model.addAttribute("tasks", tasks);
        return "parameters/tasks";
    }

    //The Get Tasks By Id
    @GetMapping("/parameters/tasks/{id}")
    @ResponseBody
    public Tasks getTasks(@PathVariable Integer id){
        return tasksService.getById(id);
    }

    @GetMapping("/parameters/tasksAdd")
    public String addTasks(){
        return "parameters/tasksAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/parameters/tasks/{op}/{id}")
    public String editTasks(@PathVariable Integer id, @PathVariable String op, Model model){
        Tasks tasks = tasksService.getById(id);
        model.addAttribute("Tasks", tasks);
        return "/parameters/tasks"+ op;
    }

    @PostMapping("/parameters/tasks")
    public String save(Tasks tasks){
        tasksService.save(tasks);
        return "redirect:/parameters/tasks";
    }

    @RequestMapping(value = "/parameters/tasks/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public  String delete(@PathVariable Integer id){
        tasksService.delete(id);
        return "redirect:/parameters/tasks";
    }

}
