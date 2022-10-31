package br.com.newVersionTeste.controller;

import br.com.newVersionTeste.dto.CuidadorDto;
import br.com.newVersionTeste.model.Cuidador;
import br.com.newVersionTeste.service.CuidadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cuidador")
@CrossOrigin("*")
public class CuidadorController {

    private final CuidadorService cuidadorService;

    @PostMapping
    public ResponseEntity createCuidador(@RequestBody Cuidador cuidador){

        cuidadorService.CreateCuidador(cuidador);
        return ResponseEntity.ok("cuidador criado com sucesso!");
    }

    @PutMapping("{idCuidador}")
    public ResponseEntity updateCuidador(@RequestBody Cuidador cuidador, @PathVariable Long idCuidador){

        cuidadorService.UpdateCuidador(cuidador, idCuidador);
        return ResponseEntity.ok("cuidador atualizado com sucesso!");
    }

    @GetMapping("page/{page}/localidade/{cidade}")
    public ResponseEntity<Page<CuidadorDto>> findAllCuidadoresSearchingService(@PathVariable int page, @PathVariable String cidade){

        var data = cuidadorService.findAllCuidadoresProcurandoTrabalho(page, cidade);
        return ResponseEntity.ok(data);
    }

}
