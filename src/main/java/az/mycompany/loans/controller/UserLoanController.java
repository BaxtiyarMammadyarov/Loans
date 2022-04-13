package az.mycompany.loans.controller;

import az.mycompany.loans.model.CalculateInvoices;
import az.mycompany.loans.model.UserCalculate;
import az.mycompany.loans.model.UserDto;
import az.mycompany.loans.repository.UserRepo;
import az.mycompany.loans.service.LoanService;
import az.mycompany.loans.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("Request",new UserCalculate());

        return "new";
    }

    @GetMapping("/issue")
    public String newIssue(Model model,UserCalculate userCalculate){
       loanService.calculate(model,userCalculate);
        return "calculates";
    }



}
