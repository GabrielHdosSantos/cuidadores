package br.com.newVersionTeste.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_idosos")
@Builder
public class Idoso extends User{

    private String nome;
    private String descricao;
    private double valor;
    private int idade;
    private String imageUrl;
    private boolean Searching;
    private String linkWhats;

}
