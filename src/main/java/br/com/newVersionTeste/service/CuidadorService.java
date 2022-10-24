package br.com.newVersionTeste.service;

import br.com.newVersionTeste.dto.CuidadorDto;
import br.com.newVersionTeste.model.Cuidador;
import br.com.newVersionTeste.repository.CuidadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<CuidadorDto> findAllCuidadoresProcurandoTrabalho(){

        var result = cuidadorRepository
                                .findAllCuidadoresSearching()
                                .orElseThrow(() -> new RuntimeException("Nenhum cuidador foi encontrado!"));

        return result;
    }

}
