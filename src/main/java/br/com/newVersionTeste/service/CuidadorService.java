package br.com.newVersionTeste.service;

import br.com.newVersionTeste.dto.CuidadorDto;
import br.com.newVersionTeste.dto.IdososDto;
import br.com.newVersionTeste.model.Cuidador;
import br.com.newVersionTeste.repository.CuidadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CuidadorService {

    private final CuidadorRepository cuidadorRepository;

    public void CreateCuidador(Cuidador cuidador){

        cuidadorRepository.save(cuidador);
    }

    public void UpdateCuidador(Cuidador cuidador, Long idCuidador){

        cuidador.setId(idCuidador);
        cuidadorRepository.save(cuidador);

    }

    public Page<CuidadorDto> findAllCuidadoresProcurandoTrabalho(int page, String cidade){

        int size = 10;
        PageRequest pageRequest = PageRequest.of(page, size);

        return cuidadorRepository.findAllCuidadoresSearching(pageRequest, cidade)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro foi encontrado!"));
    }

}
