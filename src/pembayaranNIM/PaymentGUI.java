package pembayaranNIM;

import javax.swing.*;
import java.awt.event.*;
import java.util.Map;

class PaymentGUI {
    private JFrame frame;
    private JTextField nimField;
    private JTextField amountField;
    private JTextField majorField;
    private JButton validateButton;
    private JButton payButton;
    private JButton backButton;
    private JLabel statusLabel;

    private Map<String, String[]> studentData;

    public PaymentGUI() {
        studentData = StudentDataGUI.getStudentData(); // Mengambil data mahasiswa yang sudah dimasukkan

        frame = new JFrame("Pembayaran NIM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        JLabel nimLabel = new JLabel("Masukkan NIM:");
        nimLabel.setBounds(50, 30, 120, 25);
        frame.add(nimLabel);

        nimField = new JTextField();
        nimField.setBounds(180, 30, 150, 25);
        frame.add(nimField);

        JLabel majorLabel = new JLabel("Jurusan:");
        majorLabel.setBounds(50, 70, 120, 25);
        frame.add(majorLabel);

        majorField = new JTextField();
        majorField.setBounds(180, 70, 150, 25);
        frame.add(majorField);

        validateButton = new JButton("Validasi Data");
        validateButton.setBounds(50, 110, 280, 25);
        frame.add(validateButton);

        JLabel amountLabel = new JLabel("Jumlah Pembayaran:");
        amountLabel.setBounds(50, 150, 120, 25);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(180, 150, 150, 25);
        frame.add(amountField);
        amountField.setEnabled(false);

        payButton = new JButton("Bayar");
        payButton.setBounds(50, 190, 280, 25);
        payButton.setEnabled(false);
        frame.add(payButton);

        backButton = new JButton("Kembali ke Menu");
        backButton.setBounds(50, 230, 280, 25);
        frame.add(backButton);

        statusLabel = new JLabel("Status: Menunggu input...");
        statusLabel.setBounds(50, 270, 300, 25);
        frame.add(statusLabel);

        validateButton.addActionListener(new ValidateAction());
        payButton.addActionListener(new PayAction());
        backButton.addActionListener(new BackAction());

        frame.setVisible(true);
    }

    private class ValidateAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nim = nimField.getText();
            String major = majorField.getText();

            if (nim.isEmpty() || major.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "NIM dan Jurusan tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                boolean isValid = validateData(nim, major);
                if (isValid) {
                    statusLabel.setText("Status: Data valid.");
                    amountField.setEnabled(true);
                    payButton.setEnabled(true);
                } else {
                    statusLabel.setText("Status: Data tidak valid. Pastikan NIM dan Jurusan sesuai.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private boolean validateData(String nim, String major) {
            if (!studentData.containsKey(nim)) {
                return false;
            }
            String[] student = studentData.get(nim);
            return student[2].equals(major);
        }
    }

    private class PayAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nim = nimField.getText();
            String amountText = amountField.getText();
            try {
                double amount = Double.parseDouble(amountText);
                if (amount <= 0) {
                    throw new NumberFormatException("Jumlah harus lebih dari 0");
                }

                String[] student = studentData.get(nim);
                double currentBalance = Double.parseDouble(student[4]);
                if (amount > currentBalance) {
                    JOptionPane.showMessageDialog(frame, "Saldo tidak cukup untuk pembayaran!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                student[4] = String.valueOf(currentBalance - amount);  // Update saldo
                statusLabel.setText("Status: Pembayaran sebesar Rp " + amount + " berhasil.");
                JOptionPane.showMessageDialog(frame, "Pembayaran berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Menambahkan riwayat pembayaran
                PaymentHistory.addPayment(nim, student[0], student[2], student[3], amount);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Jumlah pembayaran tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class BackAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new MainMenu();  // Kembali ke menu utama
        }
    }
}
