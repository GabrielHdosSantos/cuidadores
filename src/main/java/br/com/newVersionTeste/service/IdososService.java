package br.com.newVersionTeste.service;

import br.com.newVersionTeste.dto.CuidadorDto;
import br.com.newVersionTeste.dto.IdososDto;
import br.com.newVersionTeste.model.Idoso;
import br.com.newVersionTeste.repository.IdosoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<IdososDto> findAllIdososProcurandoTrabalho(){

        var result = idosoRepository
                .findAllIdososSearching()
                .orElseThrow(() -> new RuntimeException("Nenhum idoso foi encontrado!"));

        return result;
    }


}
