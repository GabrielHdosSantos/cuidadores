package br.com.newVersionTeste.controller;

import br.com.newVersionTeste.dto.LoginDTO;
import br.com.newVersionTeste.dto.LoginResultDTO;
import br.com.newVersionTeste.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<LoginResultDTO> login (@RequestBody LoginDTO loginDTO){

        var result = userService.login(loginDTO);

        return ResponseEntity.ok(result);
    }



}
