package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import userDAO.UserDAO;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OutputController {
    private UserDAO dao;

    @Autowired
    public OutputController(UserDAO dao) {
        this.dao = dao;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }
    @ModelAttribute("newUser")
    public User getPerson(){
        return new User();
    }

    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable("id") int id){
        dao.removeUserById(id);
        return "redirect:/people";
    }


    @PatchMapping("/people/{id}")
    public String updatePerson(@ModelAttribute("user")@Valid User updateuser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "view/edit";
        }
        dao.replaceUser(updateuser);
        return "redirect:/people";
    }
}
