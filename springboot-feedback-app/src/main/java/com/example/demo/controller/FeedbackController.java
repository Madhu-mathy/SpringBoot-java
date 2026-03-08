package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository; 

    @GetMapping("/feedback")
    public String showForm(Model model) {
    	model.addAttribute("feedbackObj", new Feedback());
        return "feedback"; 
    }

   
    
    @PostMapping("/saveFeedback")

    public String saveFeedback(@ModelAttribute("feedbackObj") Feedback feedback) {
     feedbackRepository.save(feedback);
     return "success"; 
 }
}