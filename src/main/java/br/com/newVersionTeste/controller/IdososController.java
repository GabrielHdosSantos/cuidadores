package br.com.newVersionTeste.controller;

import br.com.newVersionTeste.dto.CuidadorDto;
import br.com.newVersionTeste.dto.IdososDto;
import br.com.newVersionTeste.model.Cuidador;
import br.com.newVersionTeste.model.Idoso;
import br.com.newVersionTeste.repository.IdosoRepository;
import br.com.newVersionTeste.service.IdososService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/idosos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IdososController {

    private final IdososService idososService;

    @PostMapping
    public ResponseEntity createCuidador(@RequestBody Idoso idoso){

        idososService.createIdoso(idoso);
        return ResponseEntity.ok("idoso criado com sucesso!");
    }

    @PutMapping("{idIdoso}")
    public ResponseEntity updateCuidador(@RequestBody Idoso idoso, @PathVariable Long idIdoso){

        idososService.updateIdoso(idoso, idIdoso);
        return ResponseEntity.ok("idoso atualizado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<IdososDto>> findAllCuidadoresSearchingService(){

        var data = idososService.findAllIdososProcurandoTrabalho();
        return ResponseEntity.ok(data);
    }



}
