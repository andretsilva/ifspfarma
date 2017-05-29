package bra.ifsp.farmasisava.control;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import bra.ifsp.farmasisava.model.Cliente;
import junit.framework.TestCase;

public class ClientesControlTest extends TestCase {
	
	private Cliente objCliente;
	private ClientesControl objClienteCtrl;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.objCliente = new Cliente();
		this.objClienteCtrl = new ClientesControl();
	}

	@Test
	public void testCadastrarCliente0() {
		//fail("Not yet implemented");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	     Date data = format.parse("05/05/1950");     
	     this.objCliente.setDataNascimento(data);    
	    }
	    catch (Exception ex) {
	     System.out.println(ex.getMessage());
	    }
	    this.objCliente.setBairro("test");
	    this.objCliente.setCEP("123123123");
	    this.objCliente.setCidade("sao paulo");
	    this.objCliente.setEndereco("rua rua");
	    this.objCliente.setNome("Testador");
	    this.objCliente.setTelefone("456456");
	    this.objCliente.setUf("SP");
	    
	    this.objCliente.setCpf("43412622893");
	    
	    assertEquals(true, this.objClienteCtrl.CadastrarCliente(objCliente));
	}
	
	@Test
	public void testCadastrarCliente1() {
		fail("Not yet implemented");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	     Date data = format.parse("05/05/1950");     
	     this.objCliente.setDataNascimento(data);    
	    }
	    catch (Exception ex) {
	     System.out.println(ex.getMessage());
	    }
	    this.objCliente.setBairro("test");
	    this.objCliente.setCEP("123123123");
	    this.objCliente.setCidade("sao paulo");
	    this.objCliente.setEndereco("rua rua");
	    this.objCliente.setNome("Testador");
	    this.objCliente.setTelefone("456456");
	    this.objCliente.setUf("SP");
	    
	    this.objCliente.setCpf("43412622893");
	    
	    assertEquals(false, this.objClienteCtrl.CadastrarCliente(objCliente));
	}

}

