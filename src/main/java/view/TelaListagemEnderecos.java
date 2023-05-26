package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.EnderecoController;
import model.entity.Endereco;
import javax.swing.JButton;

public class TelaListagemEnderecos extends JFrame {

	private JPanel contentPane;
	private JTable tblEnderecos;
	
	private JButton btnBuscarTodos;
	
	private List<Endereco> enderecos;
	private String[] nomeColunas = {"ID", "CEP", "Número", "Bairro", "Cidade", "Estado"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemEnderecos frame = new TelaListagemEnderecos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListagemEnderecos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblEnderecos = new JTable();
		tblEnderecos.setBounds(10, 10, 416, 247);
		contentPane.add(tblEnderecos);
		
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.setBounds(150, 267, 118, 21);
		contentPane.add(btnBuscarTodos);
		btnBuscarTodos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
	}
	
	
	private void limparTabela() {
		tblEnderecos.setModel(new DefaultTableModel(new Object[][] {nomeColunas, }, nomeColunas));
	}
	
	private void atualizarTabela() {
		this.limparTabela();
		
		EnderecoController controller = new EnderecoController();
		enderecos = (ArrayList<Endereco>) controller.consultarTodos();
		
		DefaultTableModel model = (DefaultTableModel) tblEnderecos.getModel();
		
		enderecos.forEach(endereco -> {
			Object[] novaLinhaTabela = new Object[7];
			novaLinhaTabela[0] = endereco.getId();
			novaLinhaTabela[1] = endereco.getCep();
			novaLinhaTabela[2] = endereco.getRua();
			novaLinhaTabela[3] = endereco.getNumero();
			novaLinhaTabela[4] = endereco.getBairro();
			novaLinhaTabela[5] = endereco.getCidade();
			novaLinhaTabela[6] = endereco.getEstado();
			model.addRow(novaLinhaTabela);
		});
	}
}
