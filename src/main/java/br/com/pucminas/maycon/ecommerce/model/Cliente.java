package br.com.pucminas.maycon.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Entidade
 * Representa a tabela CLIENTES do nosso banco de dados 
 * @author Maycon
 *
 */
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id    
    @Column(name = "cpf",unique=true, nullable = false)
	private String CPF;

	@Column(name="nome_cliente")
	private String nome;
	
	private String endereco;
	private String estado;
	private String municipio;
	private String telefone;
	private String email;
	private String senha;

	public Cliente() {
	};

	public Cliente(String cPF, String nome, String endereco, String estado, String municipio, String telefone,
			String email, String senha) {
		super();
		CPF = cPF;
		this.nome = nome;
		this.endereco = endereco;
		this.estado = estado;
		this.municipio = municipio;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome_cliente() {
		return nome;
	}

	public void setNome_cliente(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}
	
	/**
	 * Metodo faz a atualizacao dos seus proprios atributos
	 * <p>Utilizado ao se fazer uma operacao de UPDATE no banco</>
	 * @param cliente 
	 */
	public void updateFields(Cliente cliente) {
		
		if (!(cliente.getNome_cliente() == null) ) {
			this.nome = cliente.getNome_cliente();
		} 
		
		if (!(cliente.getEndereco() == null) ) {
			this.endereco = cliente.getEndereco();
		}
		
		if (!(cliente.getEstado() == null) ) {
			this.estado = cliente.getEstado();
		}
		
		if (!(cliente.getMunicipio() == null) ) {
			this.municipio = cliente.getMunicipio();
		}
		
		if (!(cliente.getTelefone() == null) ) {
			this.telefone = cliente.getTelefone();
		}
		
		if (!(cliente.getEmail() == null) ) {
			this.email = cliente.getEmail();
		}
		
		if (!(cliente.getSenha() == null) ) {
			this.senha = cliente.getSenha();
		}
		
		
		
		
	}

}
