package com.example.demo;
import com.sun.jndi.cosnaming.IiopUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    AddressBook addressBook;

    @RequestMapping("/")
    public String listCourses(Model model) {
        model.addAttribute("people", addressBook.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addressbookform(Model model) {
        model.addAttribute("people", new People());
        return "addressbookform";
    }

    @PostMapping("/process")
    public String processForm(@Valid People people, BindingResult result) {
        if (result.hasErrors()) {
            return "addressbookform";
        }
        addressBook.save(people);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("people", addressBook.findOne(id));
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("people", addressBook.findOne(id));
        return "addressbookform";
    }
    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        addressBook.delete(id);
        return "redirect:/";
    }
}
