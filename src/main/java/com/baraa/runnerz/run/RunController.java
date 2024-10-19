package com.baraa.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController : to return value Json
@RestController
//mean any respones and post or delete will go through this link
@RequestMapping ("/api/runs")
public class RunController {


    //can declare in this class only
    //args
    //نوع ال arg ده Runrepository و اسمه runrepository
    private final RunRepository runRepository;

    // this constrctor  call RunController
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }




  //to return all data in Run list not real one
      @GetMapping("")
      List<Run> findAll() {
      return runRepository.findAll();  // Corrected: findAll(), not finaAll()
  }


    // if you want print or map /api/run/1
     @GetMapping("{id}")
     Run findById(@PathVariable Integer id){
         Optional<Run> run = runRepository.findById(id);
         if (run.isEmpty()){
             throw new RunNotFoundException();
         }
         return run.get();
     }


     //post
     // automatically map the data from the request body to a Java object. put and post
    @PostMapping("")
    //TO RETURN 201 CREATE
    @ResponseStatus(HttpStatus.CREATED)
    void create (@Valid @RequestBody Run run){
        runRepository.save(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update (@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.save(run);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete (@PathVariable Integer id){
        runRepository.findById(id).get();
    }

    @GetMapping("/loction/{location}")
        List<Run> findByLoction(@PathVariable String location){
            return runRepository.findAllByLocation(location);
        }

}
