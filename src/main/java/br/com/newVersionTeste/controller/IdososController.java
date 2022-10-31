package br.com.newVersionTeste.controller;

import br.com.newVersionTeste.model.Idoso;
import br.com.newVersionTeste.service.IdososService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("page/{page}/localidade/{cidade}")
    public ResponseEntity<Page<Idoso>> findAllCuidadoresSearchingService(@PathVariable int page, @PathVariable String cidade){

        var data = idososService.findAllIdososProcurandoTrabalho(page, cidade);
        return ResponseEntity.ok(data);
    }



}
