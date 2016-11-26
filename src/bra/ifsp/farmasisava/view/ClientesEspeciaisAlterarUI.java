package bra.ifsp.farmasisava.view;


import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import bra.ifsp.farmasisava.control.ClientesControl;
import bra.ifsp.farmasisava.model.Cliente;

public class ClientesEspeciaisAlterarUI {

	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtCpfBuscar;
	public ClientesEspeciaisAlterarUI() {
		JFrame frameClientes = new JFrame("Clientes");

		frameClientes.setSize(400,307);
		frameClientes.setResizable(false);
		frameClientes.getContentPane().setLayout(null);
		
		frameClientes.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 66, 374, 202);
		frameClientes.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 60, 14);
		panel.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(157, 11, 86, 14);
		panel.add(lblEndereco);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 25, 123, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(157, 25, 207, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 53, 60, 14);
		panel.add(lblTelefone);
		
		JFormattedTextField txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(10, 69, 123, 20);
		panel.add(txtTelefone);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(157, 53, 46, 14);
		panel.add(lblCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(283, 53, 46, 14);
		panel.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(278, 69, 86, 20);
		panel.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(157, 69, 111, 20);
		panel.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(157, 100, 46, 14);
		panel.add(lblCep);
		
		JFormattedTextField txtCEP = new JFormattedTextField();
		txtCEP.setBounds(157, 114, 111, 20);
		panel.add(txtCEP);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(283, 100, 46, 14);
		panel.add(lblUf);
		
		JComboBox<String> cbUF = new JComboBox<String>();
		cbUF.setModel(new DefaultComboBoxModel<String>(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		cbUF.setSelectedIndex(25);
		cbUF.setBounds(278, 114, 86, 20);
		panel.add(cbUF);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 100, 46, 14);
		panel.add(lblCpf);
		
		txtCPF = new JFormattedTextField();
		txtCPF.setEditable(false);
		txtCPF.setBounds(10, 114, 123, 20);
		panel.add(txtCPF);
		txtCPF.setColumns(10);
		
		try {
			MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
			maskCPF.install(txtCPF);
		}
		catch(Exception ex){
			ex.getMessage();
		}
		
		JButton btnAlterar = new JButton("Salvar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(253, 166, 111, 23);
		panel.add(btnAlterar);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 145, 123, 14);
		panel.add(lblDataDeNascimento);
		
		JFormattedTextField dtDdataNascimento = new JFormattedTextField();
		dtDdataNascimento.setBounds(10, 167, 123, 20);
		panel.add(dtDdataNascimento);
		
		JLabel lblNewLabel = new JLabel("Digite o CPF do cliente para alterar");
		lblNewLabel.setBounds(10, 11, 374, 14);
		frameClientes.getContentPane().add(lblNewLabel);
		
		txtCpfBuscar = new JFormattedTextField();
		txtCpfBuscar.setBounds(10, 33, 169, 20);
		frameClientes.getContentPane().add(txtCpfBuscar);
		txtCpfBuscar.setColumns(10);
		
		try {
			MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
			maskCPF.install(txtCpfBuscar);
		}
		catch(Exception ex){
			ex.getMessage();
		}
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesControl cc = new ClientesControl();
				Cliente clienteObtido = cc.obterCliente(txtCpfBuscar.getText().toString());
				if(clienteObtido.getCpf() != null) {
					txtNome.setText(clienteObtido.getNome());
					txtEndereco.setText(clienteObtido.getEndereco());
					txtCPF.setText(clienteObtido.getCpf());
					txtCEP.setText(clienteObtido.getCEP());
					txtCidade.setText(clienteObtido.getCidade());
					txtBairro.setText(clienteObtido.getBairro());
					txtTelefone.setText(clienteObtido.getTelefone());
					cbUF.setSelectedItem(clienteObtido.getUf());
					SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
					 
					dtDdataNascimento.setText(dt.format(clienteObtido.getDataNascimento()).toString());
					
					btnAlterar.setEnabled(true);
				} else {
					 JOptionPane.showMessageDialog(null, "CPF não encontrado", "Erro!",
                             JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnBuscar.setBounds(190, 32, 89, 23);
		frameClientes.getContentPane().add(btnBuscar);
		
		btnAlterar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				ClientesControl cc = new ClientesControl();
				cliente.setNome(txtNome.getText());
				cliente.setEndereco(txtEndereco.getText());
				cliente.setCpf(txtCPF.getText());
				cliente.setCEP(txtCEP.getText());
				cliente.setCidade(txtCidade.getText());
				cliente.setBairro(txtBairro.getText());
				cliente.setTelefone(txtTelefone.getText());
				cliente.setUf(cbUF.getSelectedItem().toString());
				
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				try {
					Date data = format.parse(dtDdataNascimento.getText());
					cliente.setDataNascimento(data);
					
			
				}
				catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				cc.AlterarCliente(cliente);
				
				 JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso", "Cliente alterado!",
                         JOptionPane.INFORMATION_MESSAGE);
				 frameClientes.setVisible(false);
			}
			
			
		});
		
		
		frameClientes.setVisible(true);
	}
}
