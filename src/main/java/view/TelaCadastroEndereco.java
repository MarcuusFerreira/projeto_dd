package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JFormattedTextField;

public class TelaCadastroEndereco extends JFrame {

	private JPanel contentPane;
	private JTextField textRua;
	private JTextField textNumero;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblNumero;
	private Component lblRua;
	private Component lblCep;
	private MaskFormatter mascaraCep;
	private JFormattedTextField ftxCep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco frame = new TelaCadastroEndereco();
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
	public TelaCadastroEndereco() {
		setTitle("Cadastro de Endereço");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 299);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(30dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(3dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(23dlu;default)"),}));
		
		lblCep = new JLabel("CEP");
		contentPane.add(lblCep, "2, 4, right, default");
		
		try {
			mascaraCep = new MaskFormatter("#####-###");
			mascaraCep.setValueContainsLiteralCharacters(false);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a máscara de CEP");
		}
		
		ftxCep = new JFormattedTextField(mascaraCep);
		contentPane.add(ftxCep, "4, 4, fill, default");
		
		lblRua = new JLabel("Rua");
		contentPane.add(lblRua, "2, 6, right, default");
		
		textRua = new JTextField();
		contentPane.add(textRua, "4, 6, fill, default");
		textRua.setColumns(10);
		
		lblNumero = new JLabel("Número");
		contentPane.add(lblNumero, "2, 8, right, default");
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		contentPane.add(textNumero, "4, 8, fill, default");
		
		lblBairro = new JLabel("Bairro");
		contentPane.add(lblBairro, "2, 10, right, default");
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		contentPane.add(textBairro, "4, 10, fill, default");
		
		lblCidade = new JLabel("Cidade");
		contentPane.add(lblCidade, "2, 12, right, default");
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		contentPane.add(textCidade, "4, 12, fill, default");
		
		lblEstado = new JLabel("Estado");
		contentPane.add(lblEstado, "2, 14, right, default");
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		contentPane.add(textEstado, "4, 14, fill, default");
		
		JButton btnSalvar = new JButton("Salvar");
		contentPane.add(btnSalvar, "1, 18, 4, 1, default, fill");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}