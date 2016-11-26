package bra.ifsp.farmasisava.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import bra.ifsp.farmasisava.control.ClientesControl;
import bra.ifsp.farmasisava.model.Cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


public class ClienteEspeciaisCadastroUI {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JFormattedTextField txtCPF;
	public ClienteEspeciaisCadastroUI() {
		JFrame frameClientes = new JFrame("Clientes");

		frameClientes.setSize(400,250);
		frameClientes.setResizable(false);
		frameClientes.getContentPane().setLayout(null);
		
		frameClientes.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 11, 374, 200);
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
		
		try {
			MaskFormatter maskCEP = new MaskFormatter("#####-###");
			maskCEP.install(txtCEP);
		}
		catch(Exception ex){
			ex.getMessage();
		}
		
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(253, 166, 111, 23);
		panel.add(btnCadastrar);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(10, 145, 123, 14);
		panel.add(lblDataDeNascimento);
		
		JFormattedTextField dtDdataNascimento = new JFormattedTextField();
		dtDdataNascimento.setBounds(10, 167, 123, 20);
		panel.add(dtDdataNascimento);
		
		try {
			MaskFormatter maskNasc = new MaskFormatter("##/##/####");
			maskNasc.install(dtDdataNascimento);
		}
		catch(Exception ex){
			ex.getMessage();
		}
		btnCadastrar.addActionListener(new ActionListener(){

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
						
					if(cliente.validarIdade(data)){
						cc.CadastrarCliente(cliente);
						frameClientes.setVisible(false);
						
					} else {
						JOptionPane.showMessageDialog(null, "Idade do cliente não esta na faixa correta!");
					}
				}
				catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				
				
				
				
				
			}
			
			
		});
		
		
		frameClientes.setVisible(true);
	}
}
