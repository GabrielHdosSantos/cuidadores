package br.com.newVersionTeste.repository;

import br.com.newVersionTeste.dto.CuidadorDto;
import br.com.newVersionTeste.dto.IdososDto;
import br.com.newVersionTeste.model.Idoso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IdosoRepository extends JpaRepository<Idoso, Long> {

    @Query(value = "SELECT * FROM tb_idosos tc WHERE tc.searching = true", nativeQuery = true)
    Page<IdososDto> findAllIdososSearching(Pageable pageable);


}
