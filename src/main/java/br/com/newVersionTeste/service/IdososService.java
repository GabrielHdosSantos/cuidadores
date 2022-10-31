package br.com.newVersionTeste.service;

import br.com.newVersionTeste.dto.IdososDto;
import br.com.newVersionTeste.model.Idoso;
import br.com.newVersionTeste.repository.IdosoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class IdososService {

    private final IdosoRepository idosoRepository;

    public void createIdoso(Idoso idoso){

        idosoRepository.save(idoso);
    }

    public void updateIdoso(Idoso idoso, Long idIdoso){

        idoso.setId(idIdoso);
        idosoRepository.save(idoso);
    }

    public Page<Idoso> findAllIdososProcurandoTrabalho(int page, String cidade){

        int size = 10;
        PageRequest pageRequest = PageRequest.of(page, size);

        return idosoRepository.findAllIdososSearching(pageRequest, cidade)
                              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro foi encontrado!"));
    }


}
