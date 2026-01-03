package com.primeiroSistemaSpring.CadastroDeNinjas.service;

import com.primeiroSistemaSpring.CadastroDeNinjas.model.Ninja;
import com.primeiroSistemaSpring.CadastroDeNinjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio relacionada aos Ninjas.
 * <p>
 * Esta classe contém as regras de negócio e atua como intermediária
 * entre o Controller e o Repository, seguindo o padrão MVC.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    /**
     * Lista todos os ninjas cadastrados.
     *
     * @return Lista contendo todos os ninjas
     */
    public List<Ninja> listarTodos() {
        return ninjaRepository.findAll();
    }

    /**
     * Busca um ninja específico pelo ID.
     *
     * @param id Identificador único do ninja
     * @return Optional contendo o ninja se encontrado
     */
    public Optional<Ninja> buscarPorId(Long id) {
        return ninjaRepository.findById(id);
    }

    /**
     * Busca ninjas pelo nome (case-insensitive e parcial).
     *
     * @param nome Nome ou parte do nome do ninja
     * @return Lista de ninjas encontrados
     */
    public List<Ninja> buscarPorNome(String nome) {
        return ninjaRepository.findByNomeContainingIgnoreCase(nome);
    }

    /**
     * Busca ninjas por idade.
     *
     * @param idade Idade do ninja
     * @return Lista de ninjas com a idade especificada
     */
    public List<Ninja> buscarPorIdade(int idade) {
        return ninjaRepository.findByIdade(idade);
    }

    /**
     * Cria um novo ninja no sistema.
     *
     * @param ninja Objeto ninja a ser criado
     * @return Ninja criado com ID gerado
     */
    public Ninja criar(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    /**
     * Atualiza os dados de um ninja existente.
     * <p>
     * Verifica se o ninja existe antes de atualizar. Se não existir,
     * retorna null.
     * </p>
     *
     * @param id Identificador do ninja a ser atualizado
     * @param ninjaAtualizado Objeto com os novos dados
     * @return Ninja atualizado ou null se não encontrado
     */
    public Ninja atualizar(Long id, Ninja ninjaAtualizado) {
        Optional<Ninja> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

    /**
     * Remove um ninja do sistema.
     *
     * @param id Identificador do ninja a ser removido
     * @return true se removido com sucesso, false se não encontrado
     */
    public boolean deletar(Long id) {
        if (ninjaRepository.existsById(id)) {
            ninjaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
