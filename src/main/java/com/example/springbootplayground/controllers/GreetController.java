package com.example.springbootplayground.controllers;

import com.example.springbootplayground.models.Greet;
import com.example.springbootplayground.repo.GreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/v1/greets")
public class GreetController {

    private final GreetRepository greetRepository;

    @Autowired
    public GreetController(GreetRepository greetRepository) {
        this.greetRepository = greetRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addNewGreet(@RequestParam String content) {

        Greet n = new Greet();
        n.setContent(content);
        greetRepository.save(n);

        System.out.println("content = [" + content + "]");

        return "saved";

    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Greet> getAllUsers() {
        return greetRepository.findAll();
    }

}
