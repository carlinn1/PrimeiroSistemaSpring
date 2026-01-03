package com.primeiroSistemaSpring.CadastroDeNinjas.repository;

import com.primeiroSistemaSpring.CadastroDeNinjas.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações de persistência da entidade Ninja.
 * <p>
 * Esta interface estende JpaRepository, fornecendo automaticamente
 * métodos CRUD básicos e consultas personalizadas.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {

    /**
     * Busca ninjas pelo nome.
     *
     * @param nome Nome do ninja a ser buscado
     * @return Lista de ninjas com o nome especificado
     */
    List<Ninja> findByNomeContainingIgnoreCase(String nome);

    /**
     * Busca ninjas por idade.
     *
     * @param idade Idade do ninja
     * @return Lista de ninjas com a idade especificada
     */
    List<Ninja> findByIdade(int idade);
}
