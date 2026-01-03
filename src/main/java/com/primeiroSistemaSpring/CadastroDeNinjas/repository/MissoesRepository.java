package com.primeiroSistemaSpring.CadastroDeNinjas.repository;

import com.primeiroSistemaSpring.CadastroDeNinjas.model.Missoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações de persistência da entidade Missoes.
 * <p>
 * Esta interface estende JpaRepository, fornecendo automaticamente
 * métodos CRUD básicos e consultas personalizadas.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
@Repository
public interface MissoesRepository extends JpaRepository<Missoes, Long> {

    /**
     * Busca missões pelo nome.
     *
     * @param nomeMissao Nome da missão a ser buscada
     * @return Lista de missões com o nome especificado
     */
    List<Missoes> findByNomeMissaoContainingIgnoreCase(String nomeMissao);

    /**
     * Busca missões por nível de dificuldade.
     *
     * @param dificuldade Nível de dificuldade da missão
     * @return Lista de missões com a dificuldade especificada
     */
    List<Missoes> findByDificuldade(String dificuldade);
}
