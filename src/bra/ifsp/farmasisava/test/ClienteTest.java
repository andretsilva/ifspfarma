package bra.ifsp.farmasisava.test;

import java.util.Date;
import java.text.SimpleDateFormat;
import bra.ifsp.farmasisava.model.Cliente;
import junit.framework.TestCase;

public class ClienteTest extends TestCase{
	
	private Cliente objCliente;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.objCliente = new Cliente();
	}
	
	public void testValidarIdade() throws Exception{
		//TODO
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	     Date data = format.parse("05/05/1950");     
	     this.objCliente.setDataNascimento(data);    
	    }
	    catch (Exception ex) {
	     System.out.println(ex.getMessage());
	    }
		assertEquals(true, this.objCliente.validarIdade(this.objCliente.getDataNascimento()));
	}

}
