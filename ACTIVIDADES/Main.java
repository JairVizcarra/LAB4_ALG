import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Árbol de Pitágoras");

        // Aqui se puede cambiar el valor deacuerdo a lo que quieras
        int profundidad = 6;

        PythagorasTree arbol = new PythagorasTree(profundidad);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(arbol);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
