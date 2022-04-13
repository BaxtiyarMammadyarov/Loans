package az.mycompany.loans.controller;

import az.mycompany.loans.model.CalculateInvoices;
import az.mycompany.loans.service.LoanService;
import az.mycompany.loans.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserLoanController {
    final LoanService loanService;
    final UserService userService;

    @GetMapping("/loans")
    public String allLoans(Model model){
        model.addAttribute("loans",loanService.allLoans());
        return "Loans";
    }

    @GetMapping("/new")
    public String newLoans(Model model){
        model.addAttribute("users",userService.allUser());
        model.addAttribute("Request",new CalculateInvoices());

        return "new";
    }

    @PostMapping("/issue")
    public String newIssue(Model model,@ModelAttribute("Request") CalculateInvoices calculateInvoices){
       loanService.calculate(model,calculateInvoices);
        return "calculates";
    }



}
