package br.com.lucasmoraes.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// O PROPÓSITO DA CAMADA CONTROLLER NO SPRING BOOT É:
// PROCESSAR AS REQUISIÇÕES HTTP E ATUAR COMO A PRIMERIA CAMADA DE ACESSO DO USUÁRIO
@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/")
    public void create(@RequestBody UserModel userModel) {
        System.out.println(userModel.name);
    }
}
