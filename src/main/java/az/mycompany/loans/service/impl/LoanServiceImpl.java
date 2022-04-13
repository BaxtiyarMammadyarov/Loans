package az.mycompany.loans.service.impl;

import az.mycompany.loans.entity.LoanEntity;
import az.mycompany.loans.entity.UserEntity;
import az.mycompany.loans.model.*;
import az.mycompany.loans.repository.InvoicesRepo;
import az.mycompany.loans.repository.LoanRepo;
import az.mycompany.loans.repository.UserRepo;
import az.mycompany.loans.service.LoanService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanServiceImpl implements LoanService {

    final InvoicesRepo invoicesRepo;
    final LoanRepo loanRepo;
    final UserRepo userRepo;

    @Override
    public List<ResponseUserLoan> allLoans() {

        List<LoanEntity>loanEntities=loanRepo.findAll();
        if(loanEntities!=null){

           return loanEntities.stream().map(this::covertResponse).collect(Collectors.toList());

        }
        return null;
    }

    @Override
    public void calculate(Model model, CalculateInvoices calculateInvoices) {
        List<InvocesResponse> list=new ArrayList<>();
        BigDecimal unpaid=calculateInvoices.getAmount();
        BigDecimal result;
        for (int i=0;i<calculateInvoices.getPeriod();i++){
            InvocesResponse invocesResponse=new InvocesResponse();
            invocesResponse.setInvoiceNo("00"+i);
            invocesResponse.setDuaDate(calculateInvoices.getPayout().plusMonths(i+1));
            result=calculateInvoices.getAmount()
                    .divide(BigDecimal.valueOf(calculateInvoices.getPeriod()))
                    .add(unpaid.multiply(calculateInvoices.getInterest()));
            invocesResponse.setAmount(result);
            list.add(invocesResponse);
            unpaid.subtract(result);


        }
        model.addAttribute("user",userRepo.findById(calculateInvoices.getUserId()));
        model.addAttribute("calInvoice",calculateInvoices);
        model.addAttribute("listInvoice",list);

    }

    @PostConstruct
    public void testPost(){
        UserEntity userEntity=new UserEntity();
        userEntity.setName("baxtiyar");
        userEntity.setSurname("Mammadyarov");
        userEntity.setTelePhoneNr("0552009261");
        userRepo.save(userEntity);
        LoanEntity entity1=new LoanEntity();
        entity1.setAmount(new BigDecimal(1000.00));
        entity1.setPercentage(new BigDecimal(10.00));
        entity1.setUserEntity(userEntity);
        entity1.setPayOutDate(LocalDateTime.now());
        entity1.setLoanPeriod(3);
        loanRepo.save(entity1);

        LoanEntity entity2=new LoanEntity();
        entity2.setAmount(new BigDecimal(2000.00));
        entity2.setPercentage(new BigDecimal(10.00));
        entity2.setUserEntity(userEntity);
        entity2.setPayOutDate(LocalDateTime.now());
        entity2.setLoanPeriod(6);
         loanRepo.save(entity2);
    }

    private ResponseUserLoan  covertResponse(LoanEntity entity){
        ResponseUserLoan responseUserLoan=new ResponseUserLoan();
        responseUserLoan.setId(entity.getUserEntity().getClientUniqueId());
        responseUserLoan.setName(entity.getUserEntity().getName());
        responseUserLoan.setSurname(entity.getUserEntity().getSurname());
        responseUserLoan.setAmount(entity.getAmount());
        responseUserLoan.setPayoutDate(entity.getPayOutDate().toLocalDate());
        return responseUserLoan;

    }

}
