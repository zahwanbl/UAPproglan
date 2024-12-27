package pembayaranNIM;
import java.util.ArrayList;
import java.util.List;

class PaymentHistory {
    // Menyimpan riwayat pembayaran
    private static List<String[]> paymentHistory = new ArrayList<>();

    // Method untuk mendapatkan riwayat pembayaran
    public static List<String[]> getPaymentHistory() {
        return paymentHistory;
    }

    // Method untuk menambahkan pembayaran ke riwayat
    public static void addPayment(String nim, String name, String major, String year, double amount) {
        String[] payment = new String[]{nim, name, major, year, String.valueOf(amount)};
        paymentHistory.add(payment);
    }
}
