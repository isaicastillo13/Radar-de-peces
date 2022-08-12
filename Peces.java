
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Peces implements ActionListener {

    private JFrame frame;
    private JButton btn_ap, btn_temp, btn_visible;
    private JTextField txtf_ubi, txtf_miUbiX, txtf_miUbiY, txtf_ubiX, txtf_ubiY, txtf_int;
    private JLabel lbl_bIzq, lbl_bInf, lbl_norte, lbl_sur, lbl_este, lbl_oeste, lbl_ubi, lbl_miUbi, lbl_int;
    private int k = 10, j = 1, ubiX, ubiY, x=0, y=0, ubicardumen, respX, respY, intento = 0;
    Font font;
    Color color;
    private String botones[] = {"Finalizar", "Repetir"};
    boolean visible = true, salir = false;
    Random random = new Random();

    public Peces() {

        //fuente y colores
        Font font = new Font("Serif", Font.BOLD, 15);
        Font fonttxt = new Font("Serif", Font.BOLD, 15);
        Color color = new Color(255, 0, 0);
        Color fondo = new Color(194, 222, 209);

        frame = new JFrame("LOCALIZADOR");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(1000, 700);
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	presentacion();
        puntoscardinales(font, color);
        coordenadasxy();
        botones();
        ocultarcardumen();
        UbicacionCardumen();
        ocultarubicacion();

        

    }

    public void presentacion() {
        JOptionPane.showMessageDialog(null, 
                  "Universidad Tecnologica de Panama\n\n"
                + "Ingieneria de Sistemas Computacionales\n\n"
                + "Licenciantura en Desarrollo de Software\n\n"
                + "Desarrollo de Software III\n\n"
                + "Ricardo Chang\n\n"
                + "Isaias Castillo\n\n"
                + "8-1004-1416\n\n"
                + "1LS122\n\n"
                + "8 de junio de 2022\n\n");
    }

    public void puntoscardinales(Font font, Color color) {

        this.font = font;
        this.color = color;

        //Puntos Cardinales
        lbl_norte = new JLabel("Norte");
        lbl_norte.setFont(font);
        lbl_norte.setForeground(color);
        lbl_norte.setBounds(310, 0, 100, 50);
        frame.add(lbl_norte);

        lbl_sur = new JLabel("Sur");
        lbl_sur.setFont(font);
        lbl_sur.setForeground(color);
        lbl_sur.setBounds(320, 580, 100, 50);
        frame.add(lbl_sur);

        lbl_este = new JLabel("Este");
        lbl_este.setFont(font);
        lbl_este.setForeground(color);
        lbl_este.setBounds(620, 285, 50, 50);
        frame.add(lbl_este);

        lbl_oeste = new JLabel("Oeste");
        lbl_oeste.setFont(font);
        lbl_oeste.setForeground(color);
        lbl_oeste.setBounds(7, 285, 50, 50);
        frame.add(lbl_oeste);
    }

    public void coordenadasxy() {
        //Numeracion lateral (Y)
        for (int i = 0; i < 100; i += 10) {
            lbl_bIzq = new JLabel(String.valueOf(k));
            lbl_bIzq.setBounds(40, 40 + 55 * (i / 10), 20, 50);
            frame.add(lbl_bIzq);
            k--;
        }

        //Numeracion Inferior (X)
        for (int i = 90; i < 100; i++) {
            lbl_bInf = new JLabel(String.valueOf(j));
            lbl_bInf.setBounds(65 + 55 * (i % 10), 585, 50, 20);
            frame.add(lbl_bInf);
            j++;
        }
    }

    public void botones() {

        for (int i = 0; i < 100; i++) {
            btn_ap = new JButton(String.valueOf(i));
            btn_ap.setBounds(60 + 55 * (i % 10), 40 + 55 * (i / 10), 50, 50);
            btn_ap.setActionCommand("botones");
            btn_ap.addActionListener(this);
            frame.add(btn_ap);

        }
    }

    public void ocultarcardumen() {
        //Generar un numero ramdon para ocultar el cardumen
        ubicardumen = random.nextInt(99 + 0) + 0;
        System.out.println(ubicardumen);
    }

    public void UbicacionCardumen() {

        //Coordenadas del cardumen
        lbl_ubi = new JLabel("Ubicacion de Cardumen");
        lbl_ubi.setBounds(650, 50, 1200, 20);
        frame.add(lbl_ubi);
        ubiX = (60 + 55 * (ubicardumen % 10));
        ubiY = (40 + 55 * (ubicardumen / 10));

        txtf_ubiX = new JTextField();
        txtf_ubiX.setBounds(650, 70, 30, 20);
        txtf_ubiX.setVisible(visible);
        txtf_ubiX.setText(String.valueOf(ubiX));
        frame.add(txtf_ubiX);

        txtf_ubiY = new JTextField(ubiY);
        txtf_ubiY.setBounds(700, 70, 30, 20);
        txtf_ubiX.setVisible(visible);
        txtf_ubiY.setText(String.valueOf(ubiY));

        frame.add(txtf_ubiY);

    }

    public void ocultarubicacion() {
        btn_visible = new JButton("Ocultar/Mostrar");
        btn_visible.setBounds(650, 100, 100, 20);
        btn_visible.addActionListener(this);
        btn_visible.setActionCommand("ver");
        frame.add(btn_visible);
    }

    public void miUbicacion(int xx, int yy) {
        lbl_miUbi = new JLabel("Ubicacion Actual");
        lbl_miUbi.setBounds(650, 130, 1200, 20);
        frame.add(lbl_miUbi);

        txtf_miUbiX = new JTextField();
        txtf_miUbiX.setBounds(650, 150, 30, 20);
        txtf_miUbiX.setText(String.valueOf(xx));
        frame.add(txtf_miUbiX);

        txtf_miUbiY = new JTextField(ubiY);
        txtf_miUbiY.setBounds(700, 150, 30, 20);
        txtf_miUbiY.setText(String.valueOf(yy));
        frame.add(txtf_miUbiY);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("botones")) {
            btn_temp = (JButton) e.getSource();
            x = btn_temp.getLocation().x;
            y = btn_temp.getLocation().y;

            seMueven(x, y);
            miUbicacion(x, y);
            navega(x, y);

        } else if (e.getActionCommand().equals("ver")) {
            System.out.println(visible);
            if (visible == true) {
                visible = false;
                txtf_ubiX.setVisible(visible);
                txtf_ubiY.setVisible(visible);

            } else if (visible == false) {

                visible = true;
                txtf_ubiX.setVisible(visible);
                txtf_ubiY.setVisible(visible);
            }

        }

    }

    public void seMueven(int xx, int yy) {
        if (xx == ubiX && yy == ubiY) {

        } else {
            if (xx < ubiX) {
                xx = xx + 55;
            }

            if (yy < ubiY) {
                yy = yy + 55;
            }

            if (xx > ubiX) {
                xx = xx - 55;
            }

            if (yy > ubiY) {
                yy = yy - 55;
            }

            if (xx == ubiX && yy == ubiY) {
                JOptionPane.showMessageDialog(null, "Se Movio el Cardumen");
                ocultarcardumen();
                UbicacionCardumen();
            }
        }

    }

    public void navega(int xx, int yy) {

        if (xx == ubiX && yy > ubiY) {
            JOptionPane.showMessageDialog(null, "Navege hacia al Norte");
            intento += 1;

        } else if (xx == ubiX && yy < ubiY) {
            JOptionPane.showMessageDialog(null, "Navege hacia al Sur");
            intento += 1;

        } else if (xx > ubiX && yy == ubiY) {
            JOptionPane.showMessageDialog(null, "Navege hacia al Oeste");
            intento += 1;

        } else if (xx < ubiX && yy == ubiY) {
            JOptionPane.showMessageDialog(null, "Navege hacia al Este");
            intento += 1;

        } else if (xx > ubiX && yy > ubiY) {
            JOptionPane.showMessageDialog(null, "Navege hacia al Noroeste");
            intento += 1;

        } else if (xx < ubiX && yy > ubiY) {
            JOptionPane.showMessageDialog(null, "Navege hacia al Noreste");
            intento += 1;

        } else if (xx < ubiX && yy < ubiY) {
            JOptionPane.showMessageDialog(null, "Navege hacia al Sureste");
            intento += 1;

        } else if (xx > ubiX && yy < ubiY) {
            JOptionPane.showMessageDialog(null, "Navege hacia al Suroeste");
            intento += 1;

        } else if (xx == ubiX && yy == ubiY) {
            JOptionPane.showMessageDialog(null, "Cardumen Capturado");
            if (JOptionPane.showConfirmDialog(null, "¿Volver a usar?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                txtf_miUbiX.setText("");
                txtf_miUbiY.setText("");
                txtf_int.setText("");
		intento=0;

                puntoscardinales(font, color);
                coordenadasxy();
                botones();
                ocultarcardumen();
                UbicacionCardumen();
                ocultarubicacion();

            } else {
                System.exit(0);
            }
        }

        intentos(intento);
    }

    public void intentos(int ii) {

        lbl_int = new JLabel("Cantidad de Intentos");
        lbl_int.setBounds(650, 210, 1200, 20);
        frame.add(lbl_int);

        txtf_int = new JTextField();
        txtf_int.setBounds(650, 230, 30, 20);
        txtf_int.setText(String.valueOf(ii));
        frame.add(txtf_int);
    }
}
