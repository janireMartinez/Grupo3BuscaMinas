package vista;

import modelo.Puntuacion;
import modelo.Ranking;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import controlador.Main;
import modelo.Ranking;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class VentanaRanking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Ranking ranking;
	private JLabel Ranking1, Ranking2, Ranking3, Ranking4, Ranking5;
    private JLabel Puntuacion1, Puntuacion2, Puntuacion3, Puntuacion4, Puntuacion5;
    private JLabel Tiempo1, Tiempo2, Tiempo3, Tiempo4, Tiempo5;

	public VentanaRanking() { 
		ranking = Ranking.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("RANKING");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Puntuación");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tiempo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 5;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		Ranking1 = new JLabel("");
		GridBagConstraints gbc_Ranking1 = new GridBagConstraints();
		gbc_Ranking1.insets = new Insets(0, 0, 5, 0);
		gbc_Ranking1.gridx = 0;
		gbc_Ranking1.gridy = 0;
		panel_2.add(Ranking1, gbc_Ranking1);
		
		Ranking2 = new JLabel("");
		GridBagConstraints gbc_Ranking2 = new GridBagConstraints();
		gbc_Ranking2.insets = new Insets(0, 0, 5, 0);
		gbc_Ranking2.gridx = 0;
		gbc_Ranking2.gridy = 1;
		panel_2.add(Ranking2, gbc_Ranking2);
		
		Ranking3 = new JLabel("");
		GridBagConstraints gbc_Ranking3 = new GridBagConstraints();
		gbc_Ranking3.insets = new Insets(0, 0, 5, 0);
		gbc_Ranking3.gridx = 0;
		gbc_Ranking3.gridy = 2;
		panel_2.add(Ranking3, gbc_Ranking3);
		
		Ranking4 = new JLabel("");
		GridBagConstraints gbc_Ranking4 = new GridBagConstraints();
		gbc_Ranking4.insets = new Insets(0, 0, 5, 0);
		gbc_Ranking4.gridx = 0;
		gbc_Ranking4.gridy = 3;
		panel_2.add(Ranking4, gbc_Ranking4);
		
		Ranking5 = new JLabel("");
		GridBagConstraints gbc_Ranking5 = new GridBagConstraints();
		gbc_Ranking5.gridx = 0;
		gbc_Ranking5.gridy = 4;
		panel_2.add(Ranking5, gbc_Ranking5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 5;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 2;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		Puntuacion1 = new JLabel("");
		GridBagConstraints gbc_Puntuacion1 = new GridBagConstraints();
		gbc_Puntuacion1.insets = new Insets(0, 0, 5, 0);
		gbc_Puntuacion1.gridx = 0;
		gbc_Puntuacion1.gridy = 0;
		panel_3.add(Puntuacion1, gbc_Puntuacion1);
		
		Puntuacion2 = new JLabel("");
		GridBagConstraints gbc_Puntuacion2 = new GridBagConstraints();
		gbc_Puntuacion2.insets = new Insets(0, 0, 5, 0);
		gbc_Puntuacion2.gridx = 0;
		gbc_Puntuacion2.gridy = 1;
		panel_3.add(Puntuacion2, gbc_Puntuacion2);
		
		Puntuacion3 = new JLabel("");
		GridBagConstraints gbc_Puntuacion3 = new GridBagConstraints();
		gbc_Puntuacion3.insets = new Insets(0, 0, 5, 0);
		gbc_Puntuacion3.gridx = 0;
		gbc_Puntuacion3.gridy = 2;
		panel_3.add(Puntuacion3, gbc_Puntuacion3);
		
		Puntuacion4 = new JLabel("");
		GridBagConstraints gbc_Puntuacion4 = new GridBagConstraints();
		gbc_Puntuacion4.insets = new Insets(0, 0, 5, 0);
		gbc_Puntuacion4.gridx = 0;
		gbc_Puntuacion4.gridy = 3;
		panel_3.add(Puntuacion4, gbc_Puntuacion4);
		
		Puntuacion5 = new JLabel("");
		GridBagConstraints gbc_Puntuacion5 = new GridBagConstraints();
		gbc_Puntuacion5.gridx = 0;
		gbc_Puntuacion5.gridy = 4;
		panel_3.add(Puntuacion5, gbc_Puntuacion5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 5;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 2;
		contentPane.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		Tiempo1 = new JLabel("");
		GridBagConstraints gbc_Tiempo1 = new GridBagConstraints();
		gbc_Tiempo1.insets = new Insets(0, 0, 5, 0);
		gbc_Tiempo1.gridx = 0;
		gbc_Tiempo1.gridy = 0;
		panel_4.add(Tiempo1, gbc_Tiempo1);
		
		Tiempo2 = new JLabel("");
		GridBagConstraints gbc_Tiempo2 = new GridBagConstraints();
		gbc_Tiempo2.insets = new Insets(0, 0, 5, 0);
		gbc_Tiempo2.gridx = 0;
		gbc_Tiempo2.gridy = 1;
		panel_4.add(Tiempo2, gbc_Tiempo2);
		
		Tiempo3 = new JLabel("");
		GridBagConstraints gbc_Tiempo3 = new GridBagConstraints();
		gbc_Tiempo3.insets = new Insets(0, 0, 5, 0);
		gbc_Tiempo3.gridx = 0;
		gbc_Tiempo3.gridy = 2;
		panel_4.add(Tiempo3, gbc_Tiempo3);
		
		Tiempo4 = new JLabel("");
		GridBagConstraints gbc_Tiempo4 = new GridBagConstraints();
		gbc_Tiempo4.insets = new Insets(0, 0, 5, 0);
		gbc_Tiempo4.gridx = 0;
		gbc_Tiempo4.gridy = 3;
		panel_4.add(Tiempo4, gbc_Tiempo4);
		
		Tiempo5 = new JLabel("");
		GridBagConstraints gbc_Tiempo5 = new GridBagConstraints();
		gbc_Tiempo5.gridx = 0;
		gbc_Tiempo5.gridy = 4;
		panel_4.add(Tiempo5, gbc_Tiempo5);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 3;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 7;
		contentPane.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JButton BotonInicio = new JButton("Volver al inicio");
		BotonInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.cambioRankingInico();
			}
		});
		GridBagConstraints gbc_BotonInicio = new GridBagConstraints();
		gbc_BotonInicio.insets = new Insets(0, 0, 0, 5);
		gbc_BotonInicio.gridx = 0;
		gbc_BotonInicio.gridy = 0;
		panel_5.add(BotonInicio, gbc_BotonInicio);
		
		JButton BotonCerrar = new JButton("Cerrar sesion");
		BotonCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.cerrarSesionRanking();
			}
		});
		GridBagConstraints gbc_BotonCerrar = new GridBagConstraints();
		gbc_BotonCerrar.gridx = 2;
		gbc_BotonCerrar.gridy = 0;
		panel_5.add(BotonCerrar, gbc_BotonCerrar);
		
		cargarRanking();
	}
	
	public void cargarRanking() {
		List<Puntuacion> puntuaciones = ranking.getPuntuacionLista();
        JLabel[] rankingLabels = {Ranking1, Ranking2, Ranking3, Ranking4, Ranking5};
        JLabel[] puntuacionLabels = {Puntuacion1, Puntuacion2, Puntuacion3, Puntuacion4, Puntuacion5};
        JLabel[] tiempoLabels = {Tiempo1, Tiempo2, Tiempo3, Tiempo4, Tiempo5};

        for (int i = 0; i < 5; i++) {
            if (i < puntuaciones.size()) {
                Puntuacion p = puntuaciones.get(i);
                rankingLabels[i].setText(p.getNombre());
                puntuacionLabels[i].setText(String.valueOf(p.getPuntuacion()));
                tiempoLabels[i].setText(p.getTiempo() + " s");
            } else {
                rankingLabels[i].setText("-");
                puntuacionLabels[i].setText("-");
                tiempoLabels[i].setText("-");
            }
        }
        contentPane.revalidate();
        contentPane.repaint();
	}

}
