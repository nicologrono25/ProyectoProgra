import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crea una instancia de la ventana de inicio de sesión
        LoginWindowM loginWindow = new LoginWindowM();

        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginWindow.setBounds(200, 200, 400, 300);
        loginWindow.setTitle("Inicio de sesión");

        // Muestra la ventana de inicio de sesión
        loginWindow.setVisible(true);
    }
}
