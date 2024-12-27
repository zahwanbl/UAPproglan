package pembayaranNIM;
import javax.swing.*;
class MainMenu {
    private JFrame frame;

    public MainMenu() {
        frame = new JFrame("Menu Utama");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);

        JButton studentButton = new JButton("Data Mahasiswa");
        studentButton.setBounds(150, 50, 200, 50);
        frame.add(studentButton);

        JButton paymentButton = new JButton("Pembayaran");
        paymentButton.setBounds(150, 120, 200, 50);
        frame.add(paymentButton);

        JButton historyButton = new JButton("Riwayat Pembayaran");
        historyButton.setBounds(150, 190, 200, 50);
        frame.add(historyButton);

        studentButton.addActionListener(e -> {
            frame.dispose();
            new StudentDataGUI();
        });

        paymentButton.addActionListener(e -> {
            frame.dispose();
            new PaymentGUI();
        });

        historyButton.addActionListener(e -> {
            frame.dispose();
            new PaymentHistoryGUI();
        });

        frame.setVisible(true);
    }
}
