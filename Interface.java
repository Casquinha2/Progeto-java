import javax.swing.*;

public class Interface {
    private JPanel panel1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("teste");
        frame.setContentPane(new Interface().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }}