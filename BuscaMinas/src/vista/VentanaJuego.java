package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Timer;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class VentanaJuego extends JFrame {

	private JPanel panelTiempo;
	private Timer timer;
	private int segundos = 0;
    private static final long serialVersionUID = 1L;


    public VentanaJuego() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 647, 516);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{36, 129, 481, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel labelNombre = new JLabel("¡Bienvenido " + VentanaInicio.getTextUsuario() + "!");
        GridBagConstraints gbc_labelNombre = new GridBagConstraints();
        gbc_labelNombre.anchor = GridBagConstraints.BELOW_BASELINE;
        gbc_labelNombre.insets = new Insets(0, 0, 5, 0);
        gbc_labelNombre.gridx = 0;
        gbc_labelNombre.gridy = 0;
        getContentPane().add(labelNombre, gbc_labelNombre);

        JPanel panelArriba = new JPanel(new GridLayout(1, 3));
        JLabel panelBombas = new JLabel("Bombas");
        panelBombas.setHorizontalAlignment(SwingConstants.CENTER);
        panelArriba.add(panelBombas);

        JLabel panelDificultad = new JLabel("Cambio Dificultad");
        panelDificultad.setHorizontalAlignment(SwingConstants.CENTER);
        panelArriba.add(panelDificultad);
        
        panelTiempo = new JPanel();
        panelArriba.add(panelTiempo);

        GridBagConstraints gbc_panelArriba = new GridBagConstraints();
        gbc_panelArriba.insets = new Insets(0, 0, 5, 0);
        gbc_panelArriba.fill = GridBagConstraints.BOTH;
        gbc_panelArriba.gridx = 0;
        gbc_panelArriba.gridy = 1;
        getContentPane().add(panelArriba, gbc_panelArriba);
        
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 2;
        getContentPane().add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0};
        gbl_panel.rowHeights = new int[]{0}; 	
        gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

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