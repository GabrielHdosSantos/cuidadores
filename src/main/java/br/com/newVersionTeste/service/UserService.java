package br.com.newVersionTeste.service;

import br.com.newVersionTeste.dto.LoginDTO;
import br.com.newVersionTeste.dto.LoginResultDTO;
import br.com.newVersionTeste.model.Cuidador;
import br.com.newVersionTeste.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public LoginResultDTO login(LoginDTO loginDTO){

       var user= userRepository.findUserByUsernameAndPassword(loginDTO.username, loginDTO.password).get();

       if(user instanceof Cuidador){
           return LoginResultDTO.builder().result("cuidador").data(user).build();
       }

        return LoginResultDTO.builder().result("idoso").data(user).build();
    }


}
