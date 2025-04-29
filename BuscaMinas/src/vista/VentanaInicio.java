package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Main;
import modelo.Dificultad;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textUsuario;
	private JComboBox<String> boxDificultad;

	public VentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 238, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193, 238, 205));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel usuarioLabel = new JLabel("Nuevo usuario: ");
		usuarioLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		GridBagConstraints gbc_usuarioLabel = new GridBagConstraints();
		gbc_usuarioLabel.insets = new Insets(0, 0, 0, 5);
		gbc_usuarioLabel.anchor = GridBagConstraints.EAST;
		gbc_usuarioLabel.gridx = 0;
		gbc_usuarioLabel.gridy = 0;
		panel.add(usuarioLabel, gbc_usuarioLabel);
		
		textUsuario = new JTextField();
		textUsuario.setForeground(new Color(0, 128, 0));
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.gridx = 1;
		gbc_textUsuario.gridy = 0;
		panel.add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(193, 238, 205));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{80, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel dificultad = new JLabel("Seleccionar dificultad:");
		dificultad.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		GridBagConstraints gbc_dificultad = new GridBagConstraints();
		gbc_dificultad.insets = new Insets(0, 0, 0, 5);
		gbc_dificultad.anchor = GridBagConstraints.EAST;
		gbc_dificultad.gridx = 0;
		gbc_dificultad.gridy = 0;
		panel_1.add(dificultad, gbc_dificultad);
		
		boxDificultad = new JComboBox<>();
		boxDificultad.setForeground(new Color(0, 128, 0));
		boxDificultad.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		boxDificultad.setModel(new DefaultComboBoxModel(new String[] {"Fácil", "Media", "Difícil"}));
		boxDificultad.setToolTipText("");
		GridBagConstraints gbc_boxDificultad = new GridBagConstraints();
		gbc_boxDificultad.fill = GridBagConstraints.HORIZONTAL;
		gbc_boxDificultad.gridx = 1;
		gbc_boxDificultad.gridy = 0;
		panel_1.add(boxDificultad, gbc_boxDificultad);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(193, 238, 205));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 3;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton buttonIniciarPartida = new JButton("Iniciar Partida");
		buttonIniciarPartida.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		buttonIniciarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = textUsuario.getText();
				if (textUsuario.getText() == null || textUsuario.getText().trim().isEmpty()) {
				    JOptionPane.showMessageDialog(null, "El campo usuario está vacío", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Dificultad dificultad;
					String seleccion = (String) boxDificultad.getSelectedItem();
					
					switch (seleccion) {
					case "Fácil":
						dificultad = Dificultad.FACIL;
						break;
						
					case "Media":
						dificultad = Dificultad.MEDIA;
						break;
						
					case "Difícil":
						dificultad = Dificultad.DIFICIL;
						break;
						
					default:
						dificultad = Dificultad.FACIL;
					}
				    Main.cambioInicioJuego(nombre, dificultad);
				}
				
			}
		});
		GridBagConstraints gbc_buttonIniciarPartida = new GridBagConstraints();
		gbc_buttonIniciarPartida.insets = new Insets(0, 0, 0, 5);
		gbc_buttonIniciarPartida.gridx = 0;
		gbc_buttonIniciarPartida.gridy = 0;
		panel_2.add(buttonIniciarPartida, gbc_buttonIniciarPartida);
		
		JButton buttonSalir = new JButton("Salir");
		buttonSalir.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		buttonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_buttonSalir = new GridBagConstraints();
		gbc_buttonSalir.gridx = 1;
		gbc_buttonSalir.gridy = 0;
		panel_2.add(buttonSalir, gbc_buttonSalir);
	}

	public static String getTextUsuario() {
        return textUsuario.getText();
    }

	

}
