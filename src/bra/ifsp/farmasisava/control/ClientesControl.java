package bra.ifsp.farmasisava.control;
import bra.ifsp.farmasisava.model.Cliente;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bra.ifsp.farmasisava.bd.JDBCClienteDao;
public class ClientesControl {
	
		//public void CadastrarCliente(Cliente cliente) {
		public boolean CadastrarCliente(Cliente cliente) {
			JDBCClienteDao cd = new JDBCClienteDao();
			Cliente checkCliente = cd.obterCliente(cliente.getCpf());
			if( checkCliente.getCpf() != null ) {
				cd.CadastrarCliente(cliente);
				//JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso");
				return false;
			} else {
				//JOptionPane.showMessageDialog(null, "Cpf já cadastrado");
				return true;
			}
		}
		
		public void AlterarCliente(Cliente cliente) {
			JDBCClienteDao cd = new JDBCClienteDao();

			cd.AlterarCliente(cliente);
			
		}
		
		public ArrayList<Cliente> obterClientes(){
			
			JDBCClienteDao cd = new JDBCClienteDao();
			return cd.obterClientes();
		}
		
		public Cliente obterCliente(String cpf){
			
			JDBCClienteDao cd = new JDBCClienteDao();
			return cd.obterCliente(cpf);
		}

}
