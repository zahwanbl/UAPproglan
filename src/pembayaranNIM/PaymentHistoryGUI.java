package pembayaranNIM;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

class PaymentHistoryGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<String[]> paymentHistory;

    public PaymentHistoryGUI() {
        // Inisialisasi riwayat pembayaran
        paymentHistory = PaymentHistory.getPaymentHistory();  // Mengambil riwayat pembayaran

        frame = new JFrame("Riwayat Pembayaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        // Membuat tabel untuk menampilkan riwayat pembayaran
        String[] columnNames = {"NIM", "Nama", "Jurusan", "Angkatan", "Jumlah Pembayaran"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 500, 200);
        frame.add(scrollPane);

        JButton backButton = new JButton("Kembali ke Menu Utama");
        backButton.setBounds(50, 300, 200, 25);
        frame.add(backButton);

        for (String[] payment : paymentHistory) {
            tableModel.addRow(payment);
        }

        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });

        frame.setVisible(true);
    }
}
