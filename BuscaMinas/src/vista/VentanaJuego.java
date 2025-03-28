package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VentanaJuego extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel panelTiempo; 
    private int segundos = 0;

    public VentanaJuego() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 647, 516);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{36, 129, 481, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel labelNombre = new JLabel("¡Bienvenido + VARIABLE NOMBRE!");
        GridBagConstraints gbc_labelNombre = new GridBagConstraints();
        gbc_labelNombre.anchor = GridBagConstraints.BELOW_BASELINE;
        gbc_labelNombre.insets = new Insets(0, 0, 5, 0);
        gbc_labelNombre.gridx = 0;
        gbc_labelNombre.gridy = 0;
        getContentPane().add(labelNombre, gbc_labelNombre);

        JPanel panelArriba = new JPanel(new GridLayout(1, 3));
        JLabel panelBombas = new JLabel("Bombas");
        panelArriba.add(panelBombas);

        JLabel panelDificultad = new JLabel("Cambio Dificultad");
        panelArriba.add(panelDificultad);

        panelTiempo = new JLabel();
        panelArriba.add(panelTiempo);

        GridBagConstraints gbc_panelArriba = new GridBagConstraints();
        gbc_panelArriba.insets = new Insets(0, 0, 5, 0);
        gbc_panelArriba.fill = GridBagConstraints.BOTH;
        gbc_panelArriba.gridx = 0;
        gbc_panelArriba.gridy = 1;
        getContentPane().add(panelArriba, gbc_panelArriba);

        
        // iniciar el temporizador
        iniciarTemporizador();
    }

    private void iniciarTemporizador() {
        // ScheduledExecutorService es para ejecutar el temporizador cada segundo https://stackoverflow.com/questions/44032059/scheduledexecutorservice-only-runs-once
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            segundos++;
            actualizarTiempo();
        }, 0, 1, TimeUnit.SECONDS);  // Inicia inmediatamente y repite cada segundo
    }

    private void actualizarTiempo() {
        // Generar el tiempo en formato de 3 digitos 001, 002, 003, 004 ... 999
        String tiempoStr = String.format("%03d", segundos); // Asegura que tenga 3 dígitos
        ImageIcon img1 = new ImageIcon("images/time" + tiempoStr.charAt(0) + ".gif");
        ImageIcon img2 = new ImageIcon("images/time" + tiempoStr.charAt(1) + ".gif");
        ImageIcon img3 = new ImageIcon("images/time" + tiempoStr.charAt(2) + ".gif");


        // Panel con las 3 imagenes del temporizador
        JPanel panelImagenes = new JPanel(new FlowLayout());
        panelImagenes.add(new JLabel(img1));
        panelImagenes.add(new JLabel(img2));
        panelImagenes.add(new JLabel(img3));

        panelTiempo.setIcon(null); // Eliminar el icono anterior
        panelTiempo.setText(""); // Vaciar el texto

        // Reemplazar el JPanel con un JLabel para las imagenes
        panelTiempo.removeAll();
        panelTiempo.add(panelImagenes);
        panelTiempo.revalidate();
        panelTiempo.repaint();
    }

}