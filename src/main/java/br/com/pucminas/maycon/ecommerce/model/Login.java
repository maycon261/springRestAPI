package br.com.pucminas.maycon.ecommerce.model;

/**
 * Classe de Negocio
 * <p>Utilizada para validar o login na aplicacao</>
 * <p>Client passa o email e senha, e rest valida</>
 * @author Maycon
 *
 */
public class Login {

	public String email;
    public String senha;
    
    public Login() {}	
    
    
	public Login(String email, String senha) {		
		this.email = email;
		this.senha = senha;
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
}
