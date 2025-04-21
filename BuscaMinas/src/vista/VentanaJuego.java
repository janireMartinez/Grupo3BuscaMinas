package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Timer;

import modelo.Casilla;
import modelo.Dificultad;
import modelo.TableroEntero;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

public class VentanaJuego extends JFrame {

	private JPanel panelTiempo;
	private Timer timer;
	private int segundos = 0;
    private static final long serialVersionUID = 1L;
    private TableroEntero tablero;
    private JLabel panelBombas;


    public VentanaJuego(String nombre, Dificultad dificultad) {
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
        setBounds(100, 100, windowWidth, windowHeight);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{labelNombreHeight, panelArribaHeight, tableroHeight};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
        getContentPane().setLayout(gridBagLayout);

        JLabel labelNombre = new JLabel("¡Bienvenido " + nombre + "!");
        GridBagConstraints gbc_labelNombre = new GridBagConstraints();
        gbc_labelNombre.anchor = GridBagConstraints.BELOW_BASELINE;
        gbc_labelNombre.insets = new Insets(0, 0, 5, 0);
        gbc_labelNombre.gridx = 0;
        gbc_labelNombre.gridy = 0;
        getContentPane().add(labelNombre, gbc_labelNombre);

        JPanel panelArriba = new JPanel(new GridLayout(1, 3));
        panelArriba.setMinimumSize(new Dimension(tableroWidth, 60));
        JLabel panelBombas = new JLabel("Bombas: " + dificultad.getBombas());
        panelBombas.setHorizontalAlignment(SwingConstants.CENTER);
        panelArriba.add(panelBombas);

        JLabel panelDificultad = new JLabel("Cambio Dificultad");
        panelDificultad.setHorizontalAlignment(SwingConstants.CENTER);
        panelArriba.add(panelDificultad);
        
        panelTiempo = new JPanel();
        panelTiempo.setMinimumSize(new Dimension(100, 40));
        panelArriba.add(panelTiempo);

        GridBagConstraints gbc_panelArriba = new GridBagConstraints();
        gbc_panelArriba.insets = new Insets(0, 0, 5, 0);
        gbc_panelArriba.fill = GridBagConstraints.BOTH;
        gbc_panelArriba.gridx = 0;
        gbc_panelArriba.gridy = 1;
        getContentPane().add(panelArriba, gbc_panelArriba);
        
        //CREAR TABLERO CON LA DIFICULTAD SELECIONADA 
        tablero = new TableroEntero(dificultad);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(tablero.getFilas(), tablero.getColumnas()));
        panel.setPreferredSize(new Dimension(tableroWidth, tableroHeight));
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.NONE;
        gbc_panel.anchor = GridBagConstraints.CENTER;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 2;
        getContentPane().add(panel, gbc_panel);
        
        //PARA AÑADIR LOS BOTONES AL TABLERO
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
        							JOptionPane.showMessageDialog(VentanaJuego.this, "Has perdido");
        							tablero.setJuegoAcabado(true);
        						} else if (tablero.ganar()) {
        							timer.stop();
        							JOptionPane.showMessageDialog(VentanaJuego.this, "Has ganado");
        							tablero.setJuegoAcabado(true);
        						}
        					} else if (e.getButton() == MouseEvent.BUTTON3) {
        						tablero.marcarCasilla(fila, columna);
        						panelBombas.setText("Bombas: " + tablero.getBombasRestantes());
        					}
        					panel.revalidate();
        					panel.repaint();
        				}
        			}
        			
        		});
        		panel.add(boton);
        	}
        }
        panel.revalidate();
		panel.repaint();

        iniciarTemporizador();
        
    }
    
    private void iniciarTemporizador() {
        timer = new Timer(1000, (ActionListener) e -> {
            segundos++;
            actualizarTiempo();
        });
        timer.start();
    }
    
    private void actualizarTiempo() {

    	String tiempoStr = String.format("%03d", segundos);  // para poner los segundos 001 002 003..   https://stackoverflow.com/questions/6034523/format-an-integer-using-java-string-format

        // cargar las imágenes según los caracteres ordenados 
        ImageIcon img1 = new ImageIcon("images/time" + tiempoStr.charAt(0) + ".gif");
        ImageIcon img2 = new ImageIcon("images/time" + tiempoStr.charAt(1) + ".gif");
        ImageIcon img3 = new ImageIcon("images/time" + tiempoStr.charAt(2) + ".gif");

        // limpiarlo
        panelTiempo.removeAll();
        panelTiempo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

       // imagenes
        panelTiempo.add(new JLabel(img1));
        panelTiempo.add(new JLabel(img2));
        panelTiempo.add(new JLabel(img3));

        // Refrescar el panel           https://stackoverflow.com/questions/1097366/java-swing-revalidate-vs-repaint
        panelTiempo.revalidate();
        panelTiempo.repaint();
    }
}