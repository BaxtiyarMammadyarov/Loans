package az.mycompany.loans.service;

import az.mycompany.loans.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> allUser();
}
