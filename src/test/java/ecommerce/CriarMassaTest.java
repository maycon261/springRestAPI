package ecommerce;

import java.util.Locale;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.javafaker.Faker;

import br.com.pucminas.maycon.ecommerce.Boot;
import br.com.pucminas.maycon.ecommerce.controle.ClienteController;
import br.com.pucminas.maycon.ecommerce.model.Cliente;


/**
 * inserir 20 no banco
 * 
 * @author Maycon
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Boot.class)
public class CriarMassaTest {

	
	Faker faker;
	Cliente cliente;
	GeraCpfCnpj geraCpf;
	
	@Autowired
	private ClienteController cc;
	
	@Before
	public void setUp() {
		faker = new Faker(new Locale("pt-BR"));
		geraCpf = new GeraCpfCnpj();
		
	}
	
	@Test
	@Ignore
	public void deveInserir() {
		
		
				
		for (int i = 0; i < 20; i++) {
			
			
		
			cliente = new Cliente(
					geraCpf.cpf(),
					faker.name().fullName(),
					faker.address().streetAddress(),
					faker.address().state(),
					faker.address().cityName(),
					faker.phoneNumber().phoneNumber(),
					faker.internet().emailAddress(),
					faker.internet().password());			
			
			cc.inserirCliente(cliente);
			
			cliente = null;
		}
		
		
		
	}
	
	
	
}
