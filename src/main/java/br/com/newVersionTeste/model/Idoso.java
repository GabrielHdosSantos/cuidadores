package br.com.newVersionTeste.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_idosos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Idoso extends User{

    private String nome;
    private String descricao;
    private double valor;
    private int idade;
    private String imageUrl;
    private boolean Searching;
    private String linkWhats;
    private String cidade;



}
