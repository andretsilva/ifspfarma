package bra.ifsp.farmasisava.model;

import java.util.Date;

import org.junit.Test;

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
	
	public void testValidarIdade0() throws Exception{
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
	
	//TOTO
	@Test(expected = Exception.class) 
	public void testValidarIdade1() throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	     Date data = format.parse("05/05/2007");     
	     this.objCliente.setDataNascimento(data);    
	    }
	    catch (Exception ex) {
	     System.out.println(ex.getMessage());
	    }
		assertEquals(true, this.objCliente.validarIdade(this.objCliente.getDataNascimento()));
	}
	
	//TODO
	@Test(expected = Exception.class) 
	public void testValidarIdade2() throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	     Date data = format.parse("05/05/1750");     
	     this.objCliente.setDataNascimento(data);    
	    }
	    catch (Exception ex) {
	     System.out.println(ex.getMessage());
	    }
		assertEquals(true, this.objCliente.validarIdade(this.objCliente.getDataNascimento()));
	}

}
