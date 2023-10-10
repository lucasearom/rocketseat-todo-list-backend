package br.com.lucasmoraes.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// O PROPÓSITO DA CAMADA CONTROLLER NO SPRING BOOT É:
// PROCESSAR AS REQUISIÇÕES HTTP E ATUAR COMO A PRIMERIA CAMADA DE ACESSO DO USUÁRIO
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {

        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            System.out.println("Usuário já existente!");
            // RETORNA MENSAGEM DE ERRO E STATUS CODE
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existente!");
        }

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
