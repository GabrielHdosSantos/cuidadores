package br.com.newVersionTeste.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_cuidadores")
@Builder
public class Cuidador extends User{

    private String nome;
    private String descricao;
    private String imageUrl;
    private int idade;
    private boolean Searching;
    private String linkWhats;

}
