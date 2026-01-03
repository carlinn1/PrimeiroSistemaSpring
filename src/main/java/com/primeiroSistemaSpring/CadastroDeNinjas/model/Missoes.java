package com.primeiroSistemaSpring.CadastroDeNinjas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entidade que representa uma Missão no sistema.
 * <p>
 * Esta classe mapeia a tabela tb_missoes no banco de dados e mantém
 * informações sobre as missões disponíveis e os ninjas participantes.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
@Entity
@Table(name = "tb_missoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Missoes {

    /**
     * Identificador único da missão.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Nome descritivo da missão.
     */
    private String nomeMissao;
    
    /**
     * Nível de dificuldade da missão (ex: Fácil, Média, Difícil).
     */
    private String dificuldade;

    /**
     * Lista de ninjas participantes desta missão.
     * <p>
     * Relacionamento One-to-Many: Uma missão pode ter vários ninjas.
     * </p>
     */
    @OneToMany(mappedBy = "missoes")
    private List<Ninja> ninjas;
}
