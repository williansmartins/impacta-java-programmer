package br.com.impacta.apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import br.com.impacta.controladores.FilmeController;
import br.com.impacta.persistencia.Filme;
import br.com.impacta.persistencia.FilmeDAO;


/**
 * View do projeto
 * 
 * 
 * */
public class TelaCriarFilme {

	static FilmeController controller = new FilmeController();
	static DefaultTableModel modelo = new DefaultTableModel();
	static boolean ehNovo = true;
	static List<Filme> galeria = controller.listar();

	public static void main(String[] args) {
		int margem1 = 100;

		JFrame frame = new JFrame();
		frame.setSize(800, 600);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		JButton botaoSalvar = new JButton();
		botaoSalvar.setText("Salvar");
		botaoSalvar.setSize(150, 40);
		botaoSalvar.setLocation(margem1, 450);
		frame.add(botaoSalvar);

		JButton botaoExcluir = new JButton();
		botaoExcluir.setText("Excluir");
		botaoExcluir.setSize(150, 40);
		botaoExcluir.setLocation(270, 450);
		frame.add(botaoExcluir);

		JButton botaoLimpar = new JButton();
		botaoLimpar.setText("Limpar");
		botaoLimpar.setSize(150, 40);
		botaoLimpar.setLocation(440, 450);
		frame.add(botaoLimpar);
		
		JButton botaoSortear = new JButton();
		botaoSortear.setText("Sortear");
		botaoSortear.setSize(150, 40);
		botaoSortear.setLocation(610, 450);
		frame.add(botaoSortear);

		JLabel labelTopo = new JLabel("Gerenciamento de filmes");
		labelTopo.setFont(new Font("Arial", Font.BOLD, 34));
		labelTopo.setBounds(188, 5, 500, 50);
		frame.add(labelTopo);

		// titulo
		JLabel labelTitulo = new JLabel("T�tulo:");
		labelTitulo.setBounds(50, 100, 100, 30);
		JTextField caixaTitulo = new JTextField(20);
		caixaTitulo.setBounds(margem1, 100, 200, 30);
		frame.add(labelTitulo);
		frame.add(caixaTitulo);

		// diretores
		JLabel labelDiretores = new JLabel("Diretores:");
		labelDiretores.setBounds(50 - 10, 150, 100, 30);
		JTextField caixaDiretores = new JTextField(20);
		caixaDiretores.setBounds(margem1, 150, 200, 30);
		frame.add(labelDiretores);
		frame.add(caixaDiretores);

		// ano (1)
		JLabel labelAno = new JLabel("Ano:");
		labelAno.setBounds(50, 200, 100, 30);
		JTextField caixaAno = new JTextField(2);
		caixaAno.setBounds(100, 200, 50, 30);
		frame.add(labelAno);
		frame.add(caixaAno);

		// duracao (2)
		JLabel labelDuracao = new JLabel("Dura��o:");
		labelDuracao.setBounds(170, 200, 100, 30);
		JTextField caixaDuracao = new JTextField(2);
		caixaDuracao.setBounds(250, 200, 50, 30);
		frame.add(labelDuracao);
		frame.add(caixaDuracao);

		// voto (3)
		JLabel labelVoto = new JLabel("Voto:");
		labelVoto.setBounds(320, 200, 100, 30);
		JTextField caixaVoto = new JTextField(2);
		caixaVoto.setBounds(370, 200, 50, 30);
		frame.add(labelVoto);
		frame.add(caixaVoto);

		// nota (4)
		JLabel labelNota = new JLabel("Nota:");
		labelNota.setBounds(440, 200, 100, 30);
		JTextField caixaNota = new JTextField(2);
		caixaNota.setBounds(490, 200, 50, 30);
		frame.add(labelNota);
		frame.add(caixaNota);

		// url
		JLabel labelUrl = new JLabel("URL:");
		labelUrl.setBounds(50, 250, 100, 30);
		JTextField caixaUrl = new JTextField();
		caixaUrl.setBounds(margem1, 250, 200, 30);
		frame.add(labelUrl);
		frame.add(caixaUrl);

		// Generos
		JLabel labelGeneros = new JLabel("Generos:");
		labelGeneros.setBounds(50 - 10, 300, 100, 30);
		JTextArea caixaGeneros = new JTextArea();
		caixaGeneros.setBounds(margem1, 300, 200, 100);
		frame.add(labelGeneros);
		frame.add(caixaGeneros);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		caixaGeneros
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		// Tabela

		JTable tabela = new JTable(modelo);
		tabela.setBounds(570, 100, 100, 300);
		tabela.setDefaultEditor(Object.class, null);

		JPanel painel = new JPanel();
		painel.setBounds(560, 100, 220, 320);
		painel.setLayout(new BorderLayout());
		painel.add(tabela.getTableHeader(), BorderLayout.NORTH);
		painel.add(new JScrollPane(tabela));
		frame.add(painel);

		modelo.addColumn("Codigo");
		modelo.addColumn("Titulo");
		modelo.addColumn("Ano");

		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(50);

		frame.setVisible(true);

		// popular tabela com dados fake
		popularTabela();

		// acoes
		botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String stringTitulo = caixaTitulo.getText();
				String stringGeneros = caixaGeneros.getText();
				String stringNota = caixaNota.getText();
				String stringDiretores = caixaDiretores.getText();
				String stringAno = caixaAno.getText();
				String stringDuracao = caixaDuracao.getText();
				String stringVoto = caixaVoto.getText();
				String stringUrl = caixaUrl.getText();

				Filme filme = new Filme();
				filme.setTitulo(stringTitulo);
				filme.setAno(Integer.parseInt(stringAno));
				filme.setGeneros(stringGeneros);
				filme.setNota(Double.parseDouble(stringNota));
				filme.setDiretores(stringDiretores);
				filme.setDuracao(Integer.parseInt(stringDuracao));
				filme.setVotos(Integer.parseInt(stringVoto));
				filme.setUrl(stringUrl);

				if (ehNovo) {
					controller.criar(filme);
					modelo.addRow(new Object[] { "", filme.getTitulo(), filme.getAno() });
				} else {
					int linhaSelecionada = tabela.getSelectedRow();

					Object celula = modelo.getValueAt(linhaSelecionada, 0);
					String codigoEmTexto = celula.toString();
					int codigoEmInteiro = Integer.parseInt(codigoEmTexto);
					
					filme.setCodigo(codigoEmInteiro);
					controller.atualizar(filme);
					modelo.removeRow(linhaSelecionada);
					modelo.addRow(new Object[] { filme.getCodigo(), filme.getTitulo(), filme.getAno() });
					ehNovo = true;
				}

				caixaTitulo.setText("");
				caixaVoto.setText("");
				caixaDuracao.setText("");
				caixaAno.setText("");
				caixaNota.setText("");
				caixaDiretores.setText("");
				caixaUrl.setText("");
				caixaGeneros.setText("");
			}
		});

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tabela.getSelectedRow();
				Object celula = tabela.getValueAt(linhaSelecionada, 0);
				String codigoEmTexto = celula.toString();
				int codigoEmInteiro = Integer.parseInt(codigoEmTexto);

				if (linhaSelecionada >= 0) {
					System.out.println(linhaSelecionada);
					modelo.removeRow(linhaSelecionada);
					controller.remover(codigoEmInteiro);
				} else {
					JOptionPane.showMessageDialog(null, "selecione algum item");
				}
			}
		});

		botaoLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				caixaTitulo.setText("");
				caixaVoto.setText("");
				caixaDuracao.setText("");
				caixaAno.setText("");
				caixaNota.setText("");
				caixaDiretores.setText("");
				caixaUrl.setText("");
				caixaGeneros.setText("");
			}
		});
		
		botaoSortear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Long aleatorioLong = Math.round(Math.random()*galeria.size());
				int aleatorioInt = aleatorioLong.intValue();  
				Filme filme = galeria.get(aleatorioInt);
				
				String mensagem = "Titulo: " + filme.getTitulo() + ". Deseja abrir o site?";
				int resposta = JOptionPane.showConfirmDialog(null, mensagem , 
						"Filme sorteado", 
						JOptionPane.OK_CANCEL_OPTION);
				
				if(resposta==0) {
					try {
						Desktop.getDesktop().browse(new URI(filme.getUrl()));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		labelTopo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				caixaTitulo.setText("E o vento levou");
				caixaVoto.setText("10");
				caixaDuracao.setText("120");
				caixaAno.setText("2022");
				caixaNota.setText("10");
				caixaDiretores.setText("Diretor1 e Diretor2");
				caixaUrl.setText("http://www.eoventolevou.com.br");
				caixaGeneros.setText("Romance");
			}
		});

		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				ehNovo = false;
				int linha = tabela.getSelectedRow();
				if (linha >= 0 && !event.getValueIsAdjusting()) {
					int codigo = Integer.parseInt(tabela.getValueAt(linha, 0).toString());

					// objetivo = encontrar 1 filme no meio de v�rios
					Filme filmeEscolhido = null;

					for (Filme filme : controller.listar()) {
						System.out.println(filme.getTitulo());

						if (codigo == filme.getCodigo()) {
							filmeEscolhido = filme;
							break;
						}
					}

					caixaTitulo.setText(filmeEscolhido.getTitulo());
					caixaVoto.setText("" + filmeEscolhido.getVotos());
					caixaDuracao.setText("" + filmeEscolhido.getDuracao());
					caixaAno.setText("" + filmeEscolhido.getAno());
					caixaNota.setText("" + filmeEscolhido.getNota());
					caixaDiretores.setText(filmeEscolhido.getDiretores());
					caixaUrl.setText(filmeEscolhido.getUrl());
					caixaGeneros.setText(filmeEscolhido.getGeneros());

				}
			}
		});

	}

	static void popularTabela() {
		for (Filme filme : galeria) {
			// adicionar o filme na tabela
			modelo.addRow(new Object[] { filme.getCodigo(), filme.getTitulo(), filme.getAno() });
		}
		
		
	}

}
