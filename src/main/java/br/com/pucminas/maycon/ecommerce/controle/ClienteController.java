package br.com.pucminas.maycon.ecommerce.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pucminas.maycon.ecommerce.model.Cliente;
import br.com.pucminas.maycon.ecommerce.model.Login;
import br.com.pucminas.maycon.ecommerce.servico.ClienteService;



/**
 * Classe responsavel em centralizar as requisicoes do front end
 * 
 * @author Maycon
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteService clientesService;

	
	/**
	 * Retorna uma lista com todos os clientes cadastrados
	 * @return
	 */
	@RequestMapping("/clientes")
	public List<Cliente> getTodosClientes() {
		return clientesService.getTodosClientes();

	}

	
	/**
	 * validacao do login
	 * @param login
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "/login")
	public boolean realizaLogin(@RequestBody Login login) {
		return clientesService.getClienteEmailSenha(login);

	}

	/**
	 * Retorna um cliente cadastrado
	 * @param cpf
	 * @return
	 */
	@RequestMapping("/cliente/{cpf}")
	public Cliente getCliente(@PathVariable String cpf) {
		return clientesService.getCliente(cpf);

	}

	/**
	 * Insere um cliente 
	 * @param cliente
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/cliente")
	@ResponseBody
	public boolean inserirCliente(@RequestBody Cliente cliente) {
		Cliente c = clientesService.inserirCliente(cliente);

		if (!(c == null)) {
			return true;
		}
		return false;
	}

	/**
	 * Atualiza cliente
	 * @param cliente
	 * @param cpf
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PATCH, value = "/cliente/{cpf}")
	public boolean atualizarCliente(@RequestBody Cliente cliente, @PathVariable String cpf) {
		return clientesService.atualizarCliente(cpf, cliente);

	}

	/**
	 * Delela cliente
	 * @param cpf
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/cliente/{cpf}")
	public boolean excluirCliente(@PathVariable String cpf) {
		return clientesService.excluirCliente(cpf);

	}

}
