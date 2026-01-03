package com.primeiroSistemaSpring.CadastroDeNinjas.controller;

import com.primeiroSistemaSpring.CadastroDeNinjas.model.Ninja;
import com.primeiroSistemaSpring.CadastroDeNinjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de Ninjas.
 * <p>
 * Esta classe expõe endpoints HTTP para realizar operações CRUD
 * (Create, Read, Update, Delete) em ninjas.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    /**
     * Endpoint de boas-vindas.
     *
     * @return Mensagem de boas-vindas
     */
    @GetMapping("/inicio")
    public String boasVindas() {
        return "Bem-vindo ao Sistema de Cadastro de Ninjas!";
    }

    /**
     * Lista todos os ninjas cadastrados.
     *
     * @return Lista de todos os ninjas
     */
    @GetMapping
    public ResponseEntity<List<Ninja>> listarTodos() {
        List<Ninja> ninjas = ninjaService.listarTodos();
        return ResponseEntity.ok(ninjas);
    }

    /**
     * Busca um ninja específico pelo ID.
     *
     * @param id Identificador do ninja
     * @return Ninja encontrado ou 404 se não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ninja> buscarPorId(@PathVariable Long id) {
        Optional<Ninja> ninja = ninjaService.buscarPorId(id);
        return ninja.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Busca ninjas por nome.
     *
     * @param nome Nome ou parte do nome do ninja
     * @return Lista de ninjas encontrados
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Ninja>> buscarPorNome(@RequestParam String nome) {
        List<Ninja> ninjas = ninjaService.buscarPorNome(nome);
        return ResponseEntity.ok(ninjas);
    }

    /**
     * Busca ninjas por idade.
     *
     * @param idade Idade do ninja
     * @return Lista de ninjas encontrados
     */
    @GetMapping("/idade/{idade}")
    public ResponseEntity<List<Ninja>> buscarPorIdade(@PathVariable int idade) {
        List<Ninja> ninjas = ninjaService.buscarPorIdade(idade);
        return ResponseEntity.ok(ninjas);
    }

    /**
     * Cria um novo ninja no sistema.
     *
     * @param ninja Dados do ninja a ser criado
     * @return Ninja criado com status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Ninja> criar(@RequestBody Ninja ninja) {
        Ninja ninjaCriado = ninjaService.criar(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body(ninjaCriado);
    }

    /**
     * Atualiza os dados de um ninja existente.
     *
     * @param id Identificador do ninja a ser atualizado
     * @param ninja Novos dados do ninja
     * @return Ninja atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Ninja> atualizar(@PathVariable Long id, @RequestBody Ninja ninja) {
        Ninja ninjaAtualizado = ninjaService.atualizar(id, ninja);
        if (ninjaAtualizado != null) {
            return ResponseEntity.ok(ninjaAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Remove um ninja do sistema.
     *
     * @param id Identificador do ninja a ser removido
     * @return Status 204 (No Content) se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = ninjaService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
