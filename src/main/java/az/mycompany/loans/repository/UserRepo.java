package az.mycompany.loans.repository;

import az.mycompany.loans.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserEntity,String> {


}
