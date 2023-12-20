import javax.swing.*;
import java.awt.*;

public class Interface {
    private JPanel panel1;
    private JLabel ImageDragao;
    public Interface(){
        ImageDragao.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("dragao.png")).getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH)));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("teste");
        frame.setContentPane(new Interface().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }}
