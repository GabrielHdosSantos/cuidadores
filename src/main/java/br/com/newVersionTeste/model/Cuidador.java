package br.com.newVersionTeste.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cuidadores")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuidador extends User{

    private String nome;
    private String descricao;
    private String imageUrl;
    private int idade;
    private boolean Searching;
    private String linkWhats;
    private String cidade;

}
