package az.mycompany.loans.service.impl;

import az.mycompany.loans.entity.UserEntity;
import az.mycompany.loans.model.UserDto;
import az.mycompany.loans.repository.UserRepo;
import az.mycompany.loans.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    final UserRepo userRepo;

    public List<UserDto> allUser(){

        return userRepo.findAll().stream().map(this::convertDto).collect(Collectors.toList());

    }

    private UserDto convertDto(UserEntity entity){
        UserDto userDto=new UserDto();
        userDto.setClientUniqueId(entity.getClientUniqueId());
        userDto.setName(entity.getName());
        userDto.setSurname(entity.getSurname());
        userDto.setTelePhoneNr(entity.getTelePhoneNr());
     return userDto;
    }
}
