package bra.ifsp.farmasisava.control;

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
		fail("Not yet implemented");
	}
	
	@Test
	public void testCadastrarCliente1() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlterarCliente() {
		fail("Not yet implemented");
	}

}
