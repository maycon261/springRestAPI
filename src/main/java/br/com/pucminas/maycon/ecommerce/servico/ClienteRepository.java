package br.com.pucminas.maycon.ecommerce.servico;

import org.springframework.data.repository.CrudRepository;

import br.com.pucminas.maycon.ecommerce.model.Cliente;

/**
 * Prove as operacoes CRUD
 * @author Maycon
 *
 */
public interface ClienteRepository extends CrudRepository<Cliente,String> {

	public Cliente findByEmail(String email);
}
