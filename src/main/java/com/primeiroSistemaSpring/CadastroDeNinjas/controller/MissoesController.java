package com.primeiroSistemaSpring.CadastroDeNinjas.controller;

import com.primeiroSistemaSpring.CadastroDeNinjas.model.Missoes;
import com.primeiroSistemaSpring.CadastroDeNinjas.service.MissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de Missões.
 * <p>
 * Esta classe expõe endpoints HTTP para realizar operações CRUD
 * (Create, Read, Update, Delete) em missões.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    /**
     * Lista todas as missões cadastradas.
     *
     * @return Lista de todas as missões
     */
    @GetMapping
    public ResponseEntity<List<Missoes>> listarTodas() {
        List<Missoes> missoes = missoesService.listarTodas();
        return ResponseEntity.ok(missoes);
    }

    /**
     * Busca uma missão específica pelo ID.
     *
     * @param id Identificador da missão
     * @return Missão encontrada ou 404 se não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Missoes> buscarPorId(@PathVariable Long id) {
        Optional<Missoes> missao = missoesService.buscarPorId(id);
        return missao.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Busca missões por nome.
     *
     * @param nome Nome ou parte do nome da missão
     * @return Lista de missões encontradas
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Missoes>> buscarPorNome(@RequestParam String nome) {
        List<Missoes> missoes = missoesService.buscarPorNome(nome);
        return ResponseEntity.ok(missoes);
    }

    /**
     * Busca missões por nível de dificuldade.
     *
     * @param dificuldade Nível de dificuldade
     * @return Lista de missões encontradas
     */
    @GetMapping("/dificuldade/{dificuldade}")
    public ResponseEntity<List<Missoes>> buscarPorDificuldade(@PathVariable String dificuldade) {
        List<Missoes> missoes = missoesService.buscarPorDificuldade(dificuldade);
        return ResponseEntity.ok(missoes);
    }

    /**
     * Cria uma nova missão no sistema.
     *
     * @param missao Dados da missão a ser criada
     * @return Missão criada com status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Missoes> criar(@RequestBody Missoes missao) {
        Missoes missaoCriada = missoesService.criar(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body(missaoCriada);
    }

    /**
     * Atualiza os dados de uma missão existente.
     *
     * @param id Identificador da missão a ser atualizada
     * @param missao Novos dados da missão
     * @return Missão atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Missoes> atualizar(@PathVariable Long id, @RequestBody Missoes missao) {
        Missoes missaoAtualizada = missoesService.atualizar(id, missao);
        if (missaoAtualizada != null) {
            return ResponseEntity.ok(missaoAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Remove uma missão do sistema.
     *
     * @param id Identificador da missão a ser removida
     * @return Status 204 (No Content) se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = missoesService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
