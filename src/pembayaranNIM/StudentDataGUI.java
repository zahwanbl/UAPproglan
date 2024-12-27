package pembayaranNIM;
import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;


class StudentDataGUI {
    private JFrame frame;
    private static Map<String, String[]> studentData = new HashMap<>(); // Data mahasiswa
    private JTextField nimField, nameField, facultyField, majorField, yearField, balanceField;
    private DefaultTableModel tableModel;
    private JTable table;

    public StudentDataGUI() {
        frame = new JFrame("Data Mahasiswa");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nimLabel = new JLabel("NIM:");
        nimLabel.setBounds(50, 30, 100, 25);
        frame.add(nimLabel);

        nimField = new JTextField();
        nimField.setBounds(150, 30, 200, 25);
        frame.add(nimField);

        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setBounds(50, 70, 100, 25);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 70, 200, 25);
        frame.add(nameField);

        JLabel facultyLabel = new JLabel("Fakultas:");
        facultyLabel.setBounds(400, 30, 100, 25);
        frame.add(facultyLabel);

        facultyField = new JTextField();
        facultyField.setBounds(500, 30, 200, 25);
        frame.add(facultyField);

        JLabel majorLabel = new JLabel("Jurusan:");
        majorLabel.setBounds(400, 70, 100, 25);
        frame.add(majorLabel);

        majorField = new JTextField();
        majorField.setBounds(500, 70, 200, 25);
        frame.add(majorField);

        JLabel yearLabel = new JLabel("Angkatan:");
        yearLabel.setBounds(50, 110, 100, 25);
        frame.add(yearLabel);

        yearField = new JTextField();
        yearField.setBounds(150, 110, 200, 25);
        frame.add(yearField);

        JLabel balanceLabel = new JLabel("Saldo:");
        balanceLabel.setBounds(400, 110, 100, 25);
        frame.add(balanceLabel);

        balanceField = new JTextField();
        balanceField.setBounds(500, 110, 200, 25);
        frame.add(balanceField);

        JButton addButton = new JButton("Tambah Mahasiswa");
        addButton.setBounds(300, 150, 200, 30);
        frame.add(addButton);

        JButton backButton = new JButton("Kembali ke Menu");
        backButton.setBounds(50, 520, 150, 30);
        frame.add(backButton);

        tableModel = new DefaultTableModel(new String[]{"NIM", "Nama", "Fakultas", "Jurusan", "Angkatan", "Saldo"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 200, 700, 300);
        frame.add(scrollPane);

        addButton.addActionListener(e -> addStudent());

        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });

        displayStudentData();

        frame.setVisible(true);
    }

    private void addStudent() {
        String nim = nimField.getText();
        String nama = nameField.getText();
        String fakultas = facultyField.getText();
        String jurusan = majorField.getText();
        String angkatan = yearField.getText();
        String saldo = balanceField.getText();

        if (!nim.isEmpty() && !nama.isEmpty() && !fakultas.isEmpty() && !jurusan.isEmpty() && !angkatan.isEmpty() && !saldo.isEmpty()) {
            studentData.put(nim, new String[]{nama, fakultas, jurusan, angkatan, saldo});
            tableModel.addRow(new Object[]{nim, nama, fakultas, jurusan, angkatan, saldo});
            JOptionPane.showMessageDialog(frame, "Data Mahasiswa Ditambahkan");
        } else {
            JOptionPane.showMessageDialog(frame, "Semua field harus diisi!");
        }
    }
    private void displayStudentData() {
        for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
            String[] data = entry.getValue();
            tableModel.addRow(new Object[]{entry.getKey(), data[0], data[1], data[2], data[3], data[4]});
        }
    }

    public static Map<String, String[]> getStudentData() {
        return studentData; // Mengembalikan data mahasiswa untuk digunakan di menu pembayaran
    }
}
