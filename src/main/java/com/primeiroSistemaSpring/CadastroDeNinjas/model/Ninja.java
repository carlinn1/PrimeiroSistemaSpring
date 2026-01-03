package com.primeiroSistemaSpring.CadastroDeNinjas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa um Ninja no sistema de cadastro.
 * <p>
 * Esta classe mapeia a tabela tb_cadastro no banco de dados e mantém
 * informações sobre os ninjas cadastrados e suas missões associadas.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
@Entity
@Table(name = "tb_cadastro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ninja {

    /**
     * Identificador único do ninja.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Nome completo do ninja.
     */
    private String nome;
    
    /**
     * E-mail de contato do ninja.
     */
    private String email;
    
    /**
     * Idade do ninja em anos.
     */
    private int idade;

    /**
     * Missão atualmente associada ao ninja.
     * <p>
     * Relacionamento Many-to-One: Vários ninjas podem participar da mesma missão.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private Missoes missoes;
}
