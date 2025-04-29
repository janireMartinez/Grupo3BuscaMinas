package vista;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Main;
import modelo.Dificultad;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaPerder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String nombre;
	private Dificultad dificultad;
	private VentanaJuego ventanaJuego;

	public VentanaPerder(String nombre, Dificultad dificultad, VentanaJuego ventanaJuego) {
		this.nombre = nombre;
		this.dificultad = dificultad;
		this.ventanaJuego = ventanaJuego;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 238, 205));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("¡PERDISTE!");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 10, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("¿Desea jugar una nueva partida?");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 10, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193, 238, 205));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 20};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0};
		panel.setLayout(gbl_panel);
		
		JButton botonSi = new JButton("Si");
		botonSi.setBackground(new Color(193, 238, 205));
		botonSi.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		botonSi.setPreferredSize(new Dimension(80, 30));
		botonSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ventanaJuego.dispose();
				VentanaJuego nuevaVentanaJuego = new VentanaJuego(nombre, dificultad);
				nuevaVentanaJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_botonSi = new GridBagConstraints();
		gbc_botonSi.insets = new Insets(0, 0, 0, 5);
		gbc_botonSi.gridx = 0;
		gbc_botonSi.gridy = 0;
		panel.add(botonSi, gbc_botonSi);
		
		JButton botonNo = new JButton("No");
		botonNo.setBackground(new Color(193, 238, 205));
		botonNo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		botonNo.setPreferredSize(new Dimension(80, 30));
		botonNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.cerrarSesion(nombre, dificultad, ventanaJuego);
			}
		});
		GridBagConstraints gbc_botonNo = new GridBagConstraints();
		gbc_botonNo.gridx = 1;
		gbc_botonNo.gridy = 0;
		panel.add(botonNo, gbc_botonNo);
	}

}
