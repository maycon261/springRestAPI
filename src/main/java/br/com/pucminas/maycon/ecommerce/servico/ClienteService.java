package br.com.pucminas.maycon.ecommerce.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pucminas.maycon.ecommerce.model.Cliente;
import br.com.pucminas.maycon.ecommerce.model.Login;

/**
 * Responvasel em validar as solicitacoes do controller e
 * <p> a persistencia no modelos</>
 * @author Maycon
 *
 */
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clientesRepository;

	
	/**
	 * Verifica se cliente esta cadastrado 
	 * @param login
	 * @return
	 */
	public boolean getClienteEmailSenha(Login login) {

		
			System.out.println(login.email + login.senha);

			Cliente c = clientesRepository.findByEmail(login.getEmail());

			if (c == null) {

				return false;
			} else if (!c.getSenha().equals(login.getSenha())) {
				return false;
			}		

		return true;
	}

	/**
	 * Retorna lista de clientes existentes no banco de dados
	 * @return
	 */
	public List<Cliente> getTodosClientes() {

		List<Cliente> clientes = new ArrayList<>();
		clientesRepository.findAll().forEach(clientes::add);
		return clientes;
	}

	/**
	 * Retorna um cliente especifico
	 * @param cpf
	 * @return
	 */
	public Cliente getCliente(String cpf) {
		return clientesRepository.findOne(cpf);
	}

	/**
	 * Insere um cliente no banco de dados
	 * @param cliente
	 * @return
	 */
	public Cliente inserirCliente(Cliente cliente) {

		return clientesRepository.save(cliente);
	}

	/**
	 * Atualiza um cliente especifico
	 * @param cpf
	 * @param cliente
	 * @return
	 */
	public boolean atualizarCliente(String cpf, Cliente cliente) {
		Cliente _cliente = clientesRepository.findOne(cpf);
		
		if (_cliente == null) {
			return false;
		}
		
		_cliente.updateFields(cliente);
		
		clientesRepository.save(_cliente);
		
		return true;
	}

	/**
	 * Deleta um cliente especifico
	 * @param cpf
	 * @return
	 */
	public boolean excluirCliente(String cpf) {
		clientesRepository.delete(cpf);
		
		Cliente _cliente = clientesRepository.findOne(cpf);
		
		if (_cliente == null) {
			return true;
		}
		
		return false;
	}

}
