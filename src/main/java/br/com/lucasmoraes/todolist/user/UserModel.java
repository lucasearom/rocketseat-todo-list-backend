package br.com.lucasmoraes.todolist.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data // RESPONSÁVEL POR GERAR MÉTODOS GETTERS E SETTERS
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID") // GERA UM VALOR ALEATÓRIO PARA O ID
    private UUID id;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt; // DEFINE QUANDO O DADO FOI CRIADO

    // MÉTODOS GETTERS E SETTERS PARA ATRIBUTOS PRIVADOS

}
