
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindowM extends JFrame {
    private JPanel panel1;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField1;
    private JButton iniciarSesionButton;

    // Usuario y contraseña predeterminados
    private final String usuarioPredeterminado = "admin";
    private final String contraseñaPredeterminada = "123456";

    public LoginWindowM() {
        setContentPane(panel1);

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioIngresado = textFieldUsuario.getText();
                String contraseñaIngresada = new String(passwordField1.getPassword()); // Obtiene la contraseña ingresada

                // Verifica si el usuario y la contraseña ingresados son correctos
                if (usuarioPredeterminado.equals(usuarioIngresado) && contraseñaPredeterminada.equals(contraseñaIngresada)) {
                    // Cierra la ventana de inicio de sesión
                    dispose();

                    // Muestra la ventana principal
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            Interfaz principalForm = new Interfaz();
                            principalForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            principalForm.setBounds(200, 200, 800, 500);
                            principalForm.setContentPane(principalForm.getMainPanel());
                            principalForm.setVisible(true);
                        }
                    });
                } else {
                    // Muestra un mensaje de error si el usuario o la contraseña son incorrectos
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Intente de nuevo.");
                }
            }
        });
    }
}
