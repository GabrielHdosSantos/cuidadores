package br.com.newVersionTeste.repository;

import br.com.newVersionTeste.dto.CuidadorDto;
import br.com.newVersionTeste.model.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {

    @Query(value = "SELECT * FROM tb_cuidadores tc WHERE tc.searching = true", nativeQuery = true)
    Optional<List<CuidadorDto>> findAllCuidadoresSearching();

}
