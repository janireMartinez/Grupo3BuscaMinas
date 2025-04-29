package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Timer;

import controlador.Main;
import modelo.Casilla;
import modelo.Dificultad;
import modelo.Ranking;
import modelo.TableroEntero;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.SwingConstants;

public class VentanaJuego extends JFrame {

	private JPanel panelTiempo;
	private Timer timer;
	private int segundos = 0;
    private static final long serialVersionUID = 1L;
    private TableroEntero tablero;
    private JLabel panelBombas;
    private String nombre;
    private Dificultad dificultad;
    private Ranking ranking;


    public VentanaJuego(String nombre, Dificultad dificultad) {
    	this.nombre = nombre;
    	this.dificultad = dificultad;
    	this.ranking = Ranking.getInstance();
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int buttonSize = 30; 
        int filas = dificultad.getFilas();
        int columnas = dificultad.getColumnas();
        int tableroWidth = columnas * buttonSize;
        int tableroHeight = filas * buttonSize;
        int panelArribaHeight = 60; 
        int labelNombreHeight = 40; 
        int margenes = 20; 
        int windowWidth = tableroWidth + 30; 
        int windowHeight = tableroHeight + panelArribaHeight + labelNombreHeight + margenes;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{labelNombreHeight, panelArribaHeight, tableroHeight};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
        getContentPane().setLayout(gridBagLayout);

        JLabel labelNombre = new JLabel("¡Bienvenido " + nombre + "!");
        labelNombre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
        GridBagConstraints gbc_labelNombre = new GridBagConstraints();
        gbc_labelNombre.anchor = GridBagConstraints.BELOW_BASELINE;
        gbc_labelNombre.insets = new Insets(0, 0, 5, 0);
        gbc_labelNombre.gridx = 0;
        gbc_labelNombre.gridy = 0;
        getContentPane().add(labelNombre, gbc_labelNombre);

        JPanel panelArriba = new JPanel(new GridLayout(1, 3));
        panelArriba.setMinimumSize(new Dimension(tableroWidth, 60));
        JLabel panelBombas = new JLabel("Bombas: " + dificultad.getBombas());
        panelBombas.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
        panelBombas.setHorizontalAlignment(SwingConstants.CENTER);
        panelArriba.add(panelBombas);

        JPanel panelDificultadConCombo = new JPanel(new BorderLayout());

        JLabel labelDificultad = new JLabel("");
        labelDificultad.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
        labelDificultad.setHorizontalAlignment(SwingConstants.CENTER);
        panelDificultadConCombo.add(labelDificultad, BorderLayout.NORTH);

        JComboBox<Dificultad> comboDificultad = new JComboBox<>(Dificultad.values());
        comboDificultad.setSelectedItem(dificultad); 
        panelDificultadConCombo.add(comboDificultad, BorderLayout.SOUTH);

        panelArriba.add(panelDificultadConCombo);
        
        comboDificultad.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Dificultad nuevaDificultad = (Dificultad) comboDificultad.getSelectedItem();
                    dispose(); 
                    timer.stop(); 
                    new VentanaJuego(nombre, nuevaDificultad).setVisible(true);
                }
            }
        });
        
        panelTiempo = new JPanel();
        panelTiempo.setPreferredSize(new Dimension(100, 40));
        panelTiempo.setMinimumSize(new Dimension(100, 40));
        panelTiempo.setMaximumSize(new Dimension(100, 40));
        panelArriba.add(panelTiempo); 



        GridBagConstraints gbc_panelArriba = new GridBagConstraints();
        gbc_panelArriba.insets = new Insets(0, 0, 5, 0);
        gbc_panelArriba.fill = GridBagConstraints.BOTH;
        gbc_panelArriba.gridx = 0;
        gbc_panelArriba.gridy = 1;
        getContentPane().add(panelArriba, gbc_panelArriba);
        
        tablero = new TableroEntero(dificultad);
        
        JPanel panel = new JPanel(new GridLayout(tablero.getFilas(), tablero.getColumnas()));
        panel.setPreferredSize(new Dimension(tableroWidth, tableroHeight));

        JPanel panelConMargenes = new JPanel(new BorderLayout());
        panelConMargenes.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        panelConMargenes.add(panel, BorderLayout.CENTER);

        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.NONE;
        gbc_panel.anchor = GridBagConstraints.CENTER;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 2;
        getContentPane().add(panelConMargenes, gbc_panel);

        
        Casilla[][] casilla = tablero.getCasilla();
        for (int i = 0; i < tablero.getFilas(); i++) {
        	for	(int j = 0; j < tablero.getColumnas(); j++) {
        		JButton boton = casilla[i][j].getBoton();
        		final int fila = i;
        		final int columna = j;
        		boton.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseClicked(MouseEvent e) {
        				if (!tablero.isJuegoAcabado()) {
        					if (e.getButton() == MouseEvent.BUTTON1) {
        						tablero.revelarCasilla(fila, columna);
        						if (tablero.perder(fila, columna)) {
        							timer.stop();
        							tablero.setJuegoAcabado(true);
        							Main.apareceVentanaPerder(nombre, dificultad, VentanaJuego.this);
        						} else if (tablero.ganar()) {
        							timer.stop();
        							tablero.setJuegoAcabado(true);
        							int casillaDescubierta = dificultad.getFilas() * dificultad.getColumnas() - 10;
        							int cantidadMinas = casillaDescubierta;
        							int minasActivadas = tablero.getMinasMarcadas();
        							int coeficienteDificultad = dificultad.coeficientePuntuacion();
        							int puntuacion = 0;
        							
        							if (segundos > 0) {
        								puntuacion = (cantidadMinas - minasActivadas) * coeficienteDificultad / segundos;
        								
        							}
        							ranking.calcularPuntuacion(nombre, cantidadMinas, minasActivadas, coeficienteDificultad, segundos);
        							Main.cambioJuegoRanking();
        							dispose();
        						} 
        						panel.revalidate();
                                panel.repaint();
        					} else if (e.getButton() == MouseEvent.BUTTON3) {
        						tablero.marcarCasilla(fila, columna);
        						panelBombas.setText("Bombas: " + tablero.getBombasRestantes());
        						panel.revalidate();
                                panel.repaint();
        					}
        				}
        			}
        			
        		});
        		panel.add(boton);
        	}
        }
        panel.revalidate();
		panel.repaint();

        iniciarTemporizador();
        pack();
        setLocationRelativeTo(null);
    }
    
    private void iniciarTemporizador() {
        timer = new Timer(1000, (ActionListener) e -> {
            segundos++;
            actualizarTiempo();
        });
        timer.start();
    }
    
    private void actualizarTiempo() {

    	String tiempoStr = String.format("%03d", segundos); 

    	ImageIcon img1 = new ImageIcon(VentanaJuego.class.getResource("/images/time" + tiempoStr.charAt(0) + ".gif"));
        ImageIcon img2 = new ImageIcon(VentanaJuego.class.getResource("/images/time" + tiempoStr.charAt(1) + ".gif"));
        ImageIcon img3 = new ImageIcon(VentanaJuego.class.getResource("/images/time" + tiempoStr.charAt(2) + ".gif"));

        panelTiempo.removeAll();
        panelTiempo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        panelTiempo.add(new JLabel(img1));
        panelTiempo.add(new JLabel(img2));
        panelTiempo.add(new JLabel(img3));

        panelTiempo.revalidate();
        panelTiempo.repaint();
    }
}