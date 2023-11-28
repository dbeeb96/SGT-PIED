package com.sgtpied.sgt.manager.services;

import com.sgtpied.sgt.manager.models.Tasks;
import com.sgtpied.sgt.manager.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    @Autowired
    private TasksRepository TasksRepository;

    public List<Tasks> findAll(){
        return TasksRepository.findAll();
    }

    public Page<Tasks> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1,5);
        return TasksRepository.findAll(pageable);
    }

    public  void save(Tasks Tasks){
        TasksRepository.save(Tasks);
    }

    public void delete(Integer id) {
        TasksRepository.deleteById(id);
    }

    public Tasks getById(Integer id) {
        return TasksRepository.findById(id).orElse(null);
    }

    public void update(Tasks Tasks) {
        TasksRepository.save(Tasks);
    }

    public List<Tasks> findByKeyword(String keyword){
        return TasksRepository.findByKeyword(keyword);
    }

    public List<Tasks> findTasksWithSorting(String field){
        return TasksRepository.findAll(Sort.by(field));
    }

    public Page<Tasks> findTasksWithSorting2(String field, String direction, int pageNumber){
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(field).ascending(): Sort.by(field).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1,5, sort);
        return TasksRepository.findAll(pageable);
    }
}
