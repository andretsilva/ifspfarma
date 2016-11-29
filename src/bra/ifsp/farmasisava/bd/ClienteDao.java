package bra.ifsp.farmasisava.bd;

import java.util.ArrayList;

import bra.ifsp.farmasisava.model.Cliente;

public interface ClienteDao {
	public void CadastrarCliente(Cliente cliente);
	public ArrayList<Cliente> obterClientes();
	public void AlterarCliente(Cliente cliente);
	public Cliente obterCliente(String cpf);

}
