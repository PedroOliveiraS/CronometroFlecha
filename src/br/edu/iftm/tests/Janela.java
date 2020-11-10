package br.edu.iftm.tests;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

	
public class Janela extends JFrame{
	
	boolean Play = true;
	
	JPanel panelFlecha;
	JLabel labelHora;
	JLabel labelMinutos;
	JLabel labelSegundos;
	JLabel labelMilissegundos;
	
	JButton btnPlayPause;
	JButton btnReset;
	
	public Janela(){
		this.setFocusable(false);
		this.setSize(700, 500);
		this.setLayout(null);
		this.setTitle("Cronômetro do Flecha");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.preencheTela();
		this.setVisible(true);
		this.setResizable(false);	
	}
	
	public void preencheTela(){
		
		// Inicializando o painel 1
		panelFlecha = new JPanel();
		panelFlecha.setLayout(null);
		panelFlecha.setSize(700, 500);
		panelFlecha.setVisible(true);
		panelFlecha.setBackground(Color.decode("#9e9fba"));
		this.add(panelFlecha);
		
		// Inicializando o JLabel de horas
		labelHora = new JLabel();
		labelHora.setText("00");
		labelHora.setLayout(null);
		labelHora.setVisible(true);
		labelHora.setBounds(60, 140, 160, 110);
		labelHora.setFont(new Font("Times", Font.PLAIN, 140));
		panelFlecha.add(labelHora);
		
		// Inicializando o JLabel de minutos
		labelMinutos = new JLabel();
		labelMinutos.setText("00");
		labelMinutos.setLayout(null);
		labelMinutos.setVisible(true);
		labelMinutos.setBounds(240, 140, 160, 110);
		labelMinutos.setFont(new Font("Times", Font.PLAIN, 140));
		panelFlecha.add(labelMinutos);
		
		// Inicializando o JLabel de segundos
		labelSegundos = new JLabel();
		labelSegundos.setText("00");
		labelSegundos.setLayout(null);
		labelSegundos.setVisible(true);
		labelSegundos.setBounds(420, 140, 160, 110);
		labelSegundos.setFont(new Font("Times", Font.PLAIN, 140));
		panelFlecha.add(labelSegundos);
		
		
		// Inicializando o JLabel de milissegundos
		labelMilissegundos = new JLabel();
		labelMilissegundos.setText("00");
		labelMilissegundos.setLayout(null);
		labelMilissegundos.setVisible(true);
		labelMilissegundos.setBounds(570, 170, 160, 110);
		labelMilissegundos.setFont(new Font("Times", Font.PLAIN, 50));
		panelFlecha.add(labelMilissegundos);
		
		
		// Inicializando o botão de play/pause
		btnPlayPause = new JButton();
		btnPlayPause.setLayout(null);
		btnPlayPause.setIcon(new ImageIcon("./images/jogar.png"));
		btnPlayPause.setVisible(true);
		btnPlayPause.setBounds(300, 320, 65, 65);
		btnPlayPause.setBorderPainted(false);
		btnPlayPause.setOpaque(true);
		btnPlayPause.setFocusPainted(false);
		btnPlayPause.setContentAreaFilled(false);
		//btnPlayPause.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Titulo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 70, 214)));
		panelFlecha.add(btnPlayPause);
		
		btnPlayPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Play == true){
					Play = false;
					btnPlayPause.setIcon(new ImageIcon("./images/pausa.png"));
				}else{
					Play = true;
					btnPlayPause.setIcon(new ImageIcon("./images/jogar.png"));
					
				}
			}
		});
		// Inicializando o botão de play/pause
		btnReset = new JButton();
		btnReset.setLayout(null);
		btnReset.setIcon(new ImageIcon("./images/reset.png"));
		btnReset.setVisible(true);
		btnReset.setBounds(240, 340, 45, 45);
		btnReset.setBorderPainted(false);
		btnReset.setOpaque(true);
		btnReset.setFocusPainted(false);
		btnReset.setContentAreaFilled(false);
		panelFlecha.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("a");
			}
		});
				
	}

}
