package com.primeiroSistemaSpring.CadastroDeNinjas.service;

import com.primeiroSistemaSpring.CadastroDeNinjas.model.Missoes;
import com.primeiroSistemaSpring.CadastroDeNinjas.repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio relacionada às Missões.
 * <p>
 * Esta classe contém as regras de negócio e atua como intermediária
 * entre o Controller e o Repository, seguindo o padrão MVC.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    /**
     * Lista todas as missões cadastradas.
     *
     * @return Lista contendo todas as missões
     */
    public List<Missoes> listarTodas() {
        return missoesRepository.findAll();
    }

    /**
     * Busca uma missão específica pelo ID.
     *
     * @param id Identificador único da missão
     * @return Optional contendo a missão se encontrada
     */
    public Optional<Missoes> buscarPorId(Long id) {
        return missoesRepository.findById(id);
    }

    /**
     * Busca missões pelo nome (case-insensitive e parcial).
     *
     * @param nomeMissao Nome ou parte do nome da missão
     * @return Lista de missões encontradas
     */
    public List<Missoes> buscarPorNome(String nomeMissao) {
        return missoesRepository.findByNomeMissaoContainingIgnoreCase(nomeMissao);
    }

    /**
     * Busca missões por nível de dificuldade.
     *
     * @param dificuldade Nível de dificuldade
     * @return Lista de missões com a dificuldade especificada
     */
    public List<Missoes> buscarPorDificuldade(String dificuldade) {
        return missoesRepository.findByDificuldade(dificuldade);
    }

    /**
     * Cria uma nova missão no sistema.
     *
     * @param missao Objeto missão a ser criada
     * @return Missão criada com ID gerado
     */
    public Missoes criar(Missoes missao) {
        return missoesRepository.save(missao);
    }

    /**
     * Atualiza os dados de uma missão existente.
     * <p>
     * Verifica se a missão existe antes de atualizar. Se não existir,
     * retorna null.
     * </p>
     *
     * @param id Identificador da missão a ser atualizada
     * @param missaoAtualizada Objeto com os novos dados
     * @return Missão atualizada ou null se não encontrada
     */
    public Missoes atualizar(Long id, Missoes missaoAtualizada) {
        Optional<Missoes> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }

    /**
     * Remove uma missão do sistema.
     *
     * @param id Identificador da missão a ser removida
     * @return true se removida com sucesso, false se não encontrada
     */
    public boolean deletar(Long id) {
        if (missoesRepository.existsById(id)) {
            missoesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
