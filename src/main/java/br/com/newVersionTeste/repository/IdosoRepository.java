package br.com.newVersionTeste.repository;

import br.com.newVersionTeste.model.Idoso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdosoRepository extends JpaRepository<Idoso, Long> {

    @Query(value = "SELECT * FROM tb_idosos tc WHERE tc.searching = true and tc.cidade = :cidade", nativeQuery = true)
    Optional<Page<Idoso>> findAllIdososSearching(Pageable pageable, @Param("cidade") String cidade);


}
