package bra.ifsp.farmasisava.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import bra.ifsp.farmasisava.model.Caixa;
import bra.ifsp.farmasisava.model.Usuario;

public class DefaultUI implements CaixaObserver{
	private Caixa caixa = new Caixa();
	private JMenuItem subMenuAbrirCaixa = new JMenuItem("Abrir Caixa");
	private JMenuItem subMenuFecharCaixa = new JMenuItem("Fechar Caixa");
	private JMenu menuVenda = new JMenu("Vendas");
	private JMenuItem subMenuVenda = new JMenuItem("Iniciar");
	
	public DefaultUI(Usuario usuario) {
		DefaultUI ui = this;
		JFrame frame = new JFrame("FarmasisAVA - Usuário: " + usuario.getLogin());
	
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 208);
		frame.setLocationRelativeTo(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
		panelPrincipal.setLayout(new BorderLayout());
		
		
		JMenuBar menuBar = new JMenuBar();
		
		//Criando o menu de cadastro e seus subitens
		JMenu menuClientes = new JMenu("Clientes Especiais");
		menuBar.add(menuClientes);
			JMenuItem subMenuItemClientesCadastrar = new JMenuItem("Cadastrar");
			JMenuItem subMenuItemClientesAlterar = new JMenuItem("Alterar");
			JMenuItem subMenuItemClientesListar = new JMenuItem("Listar");
			menuClientes.add(subMenuItemClientesCadastrar);
			menuClientes.add(subMenuItemClientesAlterar);
			menuClientes.add(subMenuItemClientesListar);
			
			
			subMenuItemClientesCadastrar.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new ClienteEspeciaisCadastroUI();
					
				}
			
			});
			
			subMenuItemClientesListar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new ListarClientesUI();
					
				}
			});
			
			subMenuItemClientesAlterar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new ClientesEspeciaisAlterarUI();
					
				}
			});
			
									
		JMenu menuProdutos = new JMenu("Medicamentos");
			JMenuItem subMenuItemProdutosCadastrar = new JMenuItem("Cadastrar");
			JMenuItem subMenuItemProdutosAlterar = new JMenuItem("Alterar");
			JMenuItem subMenuItemProdutosListar = new JMenuItem("Listar");
			
			menuProdutos.add(subMenuItemProdutosCadastrar);
			menuProdutos.add(subMenuItemProdutosAlterar);
			menuProdutos.add(subMenuItemProdutosListar);
			subMenuItemProdutosCadastrar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new MedicamentoCadastrarUI();
					
				}
			});
			
			subMenuItemProdutosAlterar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new MedicamentoAlterar();
				}
			});
			
			subMenuItemProdutosListar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new MedicamentoListarUI();
				}
			});
			
			
			
		JMenu menuEstoque = new JMenu("Estoque");
			JMenuItem subMenuItemEstoqueAlterar = new JMenuItem("Alterar");
			subMenuItemEstoqueAlterar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new EstoqueMedicamentoUI();
				}
			});
			menuEstoque.add(subMenuItemEstoqueAlterar);
		menuBar.add(menuProdutos);
		menuBar.add(menuEstoque);

		

		
		
		//Criando o menu de caixa e seu subitens
		JMenu menuCaixa = new JMenu("Caixa");
		menuBar.add(menuCaixa);
		
		menuCaixa.add(subMenuAbrirCaixa);
		menuCaixa.add(subMenuFecharCaixa);
		
		
		
		menuBar.add(menuVenda);
		menuVenda.add(subMenuVenda);
		subMenuVenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				new VendaItensUI(caixa);
			}
		});
		menuVenda.setEnabled(false);
		/*Caixa ccc = new Caixa();
		ccc.registraInteressado(this);*/
		
		subMenuAbrirCaixa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AbrirCaixaSenhaUI(caixa,ui);
				
			}
		});
		
		subMenuFecharCaixa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FecharCaixaSenhaUI(caixa, ui);
				
			}
		});
		
		//Criando o menu de Iniciar as Vendas
		frame.setJMenuBar(menuBar);
		frame.add(panelPrincipal);
		
		JPanel barraLateral = new JPanel();
		barraLateral.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		panelPrincipal.add(barraLateral, BorderLayout.WEST);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/logo-farmacia.png"));
		
		JLabel imageLabel = new JLabel(img);
	
		
		JLabel relogio = new JLabel("");
		relogio.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
		
		relogio.setHorizontalAlignment(SwingConstants.CENTER);
	
	    Timer timer = new Timer(500, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        
	        	relogio.setText(DateFormat.getDateTimeInstance().format(new Date()));
	        	    
	        }
	    });
	   
	    timer.setRepeats(true);
	    timer.setCoalesce(true);
	    timer.setInitialDelay(0);
	    timer.start();
		
		barraLateral.setLayout(new BorderLayout(10,10));
		barraLateral.add(imageLabel, BorderLayout.NORTH);
		barraLateral.add(relogio,BorderLayout.SOUTH);
	
		frame.setVisible(true);
		//AtualizaMenu();
	}
	
	
	/*public void AtualizaMenu() {
		if(caixa.isCaixaAberto()) {
			subMenuAbrirCaixa.setEnabled(false);
			subMenuFecharCaixa.setEnabled(true);
			menuVenda.setEnabled(true);
		} else {
			subMenuAbrirCaixa.setEnabled(true);
			subMenuFecharCaixa.setEnabled(false);
			menuVenda.setEnabled(false);
		}
	}*/
	@Override
	public void notificaMudanca(Caixa caixa) {
		if(caixa.getCaixaEstado() == "aberto"){
			subMenuAbrirCaixa.setEnabled(false);
			subMenuFecharCaixa.setEnabled(true);
			menuVenda.setEnabled(true);
		}
		else{
			subMenuAbrirCaixa.setEnabled(true);
			subMenuFecharCaixa.setEnabled(false);
			menuVenda.setEnabled(false);
		}
	}
	
}
