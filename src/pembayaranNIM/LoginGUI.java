package pembayaranNIM;

import javax.swing.*;

class LoginGUI {
    private JFrame frame;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public LoginGUI() {
        frame = new JFrame("Login Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 25);
        frame.add(userLabel);

        userField = new JTextField();
        userField.setBounds(150, 50, 150, 25);
        frame.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 25);
        frame.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 25);
        frame.add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        frame.add(loginButton);

        loginButton.addActionListener(e -> login());

        frame.setVisible(true);
    }

    private void login() {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Username dan Password tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Cek kredensial untuk dua akun admin
        if ((username.equals("nazwa") && password.equals("438")) ||
                (username.equals("zahwa") && password.equals("417"))) {
            JOptionPane.showMessageDialog(frame, "Login berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            new MainMenu();
        } else {
            JOptionPane.showMessageDialog(frame, "Login gagal!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


