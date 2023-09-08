package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Person;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("name") String name, @RequestParam("email") String email) {
        // Process the form data here (e.g., save to database, perform some action, etc.)
        // For this example, we'll simply print the data to the console.
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        // You can redirect to a different page after processing the data.
        // For this example, we'll redirect back to the form page.
        return "redirect:/form";
    }
    
//    @PostMapping("/submit")
//    public String submitForm(@RequestBody Person person) {
//        // Process the form data (Person object) received from the request body.
//        // For this example, we'll simply print the data to the console.
//        System.out.println("Name: " + person.getName());
//        System.out.println("Email: " + person.getEmail());
//
//        // You can redirect to a different page after processing the data.
//        // For this example, we'll redirect back to the form page.
//        return "redirect:/form";
//    }
}
