package az.mycompany.loans.service;


import az.mycompany.loans.model.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public interface LoanService {

    List<ResponseUserLoan> allLoans();

    void calculate(Model model, CalculateInvoices calculateInvoices);


}
