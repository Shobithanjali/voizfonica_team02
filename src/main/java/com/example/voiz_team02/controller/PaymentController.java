package com.example.voiz_team02.controller;


import com.example.voiz_team02.data.PaymentRepository;
import com.example.voiz_team02.model.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
@Controller
@RequestMapping("/payment")
@SessionAttributes("payment")

public class PaymentController {
    private PaymentRepository payRepo;

    public PaymentController(PaymentRepository payRepo) {
        this.payRepo = payRepo;
    }

    @ModelAttribute
    @GetMapping
    public String showPayment(Model model){
        model.addAttribute("payment",new Payment());
        return "payment";
    }
    @PostMapping
    public String processPayment(@Valid Payment payment, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "payment";
        }
        payRepo.save(payment);
        sessionStatus.setComplete();
        return "redirect:/success";
    }
}
