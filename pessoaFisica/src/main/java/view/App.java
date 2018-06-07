package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.PessoaFisicaDAO;
import model.PessoaFisica;

public class App extends JFrame{
	
	PessoaFisica pessoaFis = new PessoaFisica();
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("BAIRRO: ");
	
	JFormattedTextField txtCep = null; //txt formatado
	JLabel cep = new JLabel("CEP: ");
	
	JTextField txtCidade = new JTextField();
	JLabel cidade = new JLabel("CIDADE: ");	
	
	JLabel est = new JLabel("ESTADO: ");
	JComboBox cmbEst = new JComboBox(); //aparecer opcoes dos estados
	
	JFormattedTextField txtTel = null;
	JLabel tel = new JLabel("TELEFONE: ");
	
	JFormattedTextField txtCel = null;
	JLabel cel = new JLabel("CELULAR: ");
	
	JFormattedTextField txtRg = null;
	JLabel rg = new JLabel("RG: ");
	
	JFormattedTextField txtCpf = null;
	JLabel cpf = new JLabel("CPF: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	JButton btnImprimir = new JButton("Imprimir");
	
	
	MaskFormatter formatTel = null; //add mascara
	MaskFormatter formatCel = null;
	MaskFormatter formatCpf = null;
	MaskFormatter formatCep = null;
	MaskFormatter formatRg = null;
	private JTextField txtTelefone;
	private JTextField txtRG;
	private JTextField txtCEP;
	private JTextField txtCelular;
	private JTextField txtCPF;
	
	public App(){
		super("Cadastro PF");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 50, 70, 30);
		txtEnd.setBounds(90, 50, 225, 30);
		

		txtTelefone = new JTextField();
		txtTelefone.setBounds(90, 160, 225, 25);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		txtRG.setBounds(90, 195, 225, 25);
		getContentPane().add(txtRG);
		
		txtCEP = new JTextField();
		txtCEP.setColumns(10);
		txtCEP.setBounds(371, 75, 225, 25);
		getContentPane().add(txtCEP);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(400, 160, 225, 25);
		getContentPane().add(txtCelular);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(400, 195, 225, 25);
		getContentPane().add(txtCPF);
		
		paine.add(cep);
		cep.setBounds(335, 70, 40, 30);
		
		
		paine.add(cidade);
		paine.add(txtCidade);	
		cidade.setBounds(10, 85, 70, 30);
		txtCidade.setBounds(90, 85, 225, 30);
		
		paine.add(est);
		est.setBounds(335, 105, 70, 30);
		paine.add(cmbEst);
		cmbEst.setBounds(400, 105, 70, 30);
		cmbEst.addItem("AC");		cmbEst.addItem("AL");
		cmbEst.addItem("AP");		cmbEst.addItem("AM");
		cmbEst.addItem("BA");		cmbEst.addItem("CE");
		cmbEst.addItem("DF");		cmbEst.addItem("ES");
		cmbEst.addItem("GO");		cmbEst.addItem("MA");
		cmbEst.addItem("MT");		cmbEst.addItem("MS");
		cmbEst.addItem("MG");		cmbEst.addItem("PA");
		cmbEst.addItem("PB");		cmbEst.addItem("PR");
		cmbEst.addItem("PE");		cmbEst.addItem("PI");
		cmbEst.addItem("RJ");		cmbEst.addItem("RN");
		cmbEst.addItem("RS");		cmbEst.addItem("RO");
		cmbEst.addItem("RR");		cmbEst.addItem("SC");
		cmbEst.addItem("SP");		cmbEst.addItem("SE");
		cmbEst.addItem("TO");		
		
		paine.add(bairro);
		paine.add(txtBairro);	
		bairro.setBounds(10, 120, 70, 30);
		txtBairro.setBounds(90, 120, 225, 30);
				
		paine.add(tel);
		tel.setBounds(10, 155, 70, 30);
		
		paine.add(cpf);
		cpf.setBounds(335, 190, 70, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pessoaFis.setNome(txtNome.getText());
				pessoaFis.setEndereco(txtEnd.getText());
				pessoaFis.setCidade(txtCidade.getText());
				pessoaFis.setBairro(txtBairro.getText());
				pessoaFis.setTelefone(txtTelefone.getText());
				pessoaFis.setRg(txtRG.getText());
				pessoaFis.setCep(txtCEP.getText());
				Object est = cmbEst.getSelectedItem();
				pessoaFis.setEstado(est.toString());
				pessoaFis.setCelular(txtCelular.getText());
				pessoaFis.setCpf(txtCPF.getText());
				PessoaFisicaDAO.getInstance().merge(pessoaFis);
				System.out.println("Cadastro Realizado");
			}
		});
		
		paine.add(btnImprimir);
		btnImprimir.setBounds(390, 250, 130, 30);
		
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setSize(695, 355);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		App cadpf = new App();
	}
}