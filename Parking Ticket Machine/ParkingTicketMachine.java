import java.util.Scanner;

public class ParkingTicketMachine {
    private int balance;
    private int ticketPrice;
    private int ticketTime;

    public ParkingTicketMachine(int ticketPrice) {
        this.ticketPrice = ticketPrice;
        this.balance = 0;
        this.ticketTime = 0;
    }

    public void insertMoney(int amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Uang dimasukkan sebanyak : Rp " + amount);
        } else {
            System.out.println("Jumlah uang invalid.");
        }
    }

    public void issueTicket() {
        if (balance >= ticketPrice) {
            int ticketAmount = balance / ticketPrice;
            ticketTime += ticketAmount;
            balance = balance % ticketPrice;
            System.out.println("\nBerhasil membeli tiket sebanyak : " + ticketAmount);
        } else {
            System.out.println("\nSaldo tidak mencukupi untuk membeli tiket.");
        }
    }

    public int getTimePurchased() {
        return ticketTime;
    }

    public void menuOptions() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Parking Ticket Machine (Rp 10.000 / Jam) ===");
            System.out.println("1. Masukkan uang");
            System.out.println("2. Keluarkan tiket");
            System.out.println("3. Lihat waktu parkir yang dibeli");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nMasukkan jumlah uang (Rp) : ");
                    int amount = scanner.nextInt();
                    insertMoney(amount);
                    break;
                case 2:
                    issueTicket();
                    break;
                case 3:
                    System.out.println("\nWaktu parkir yang telah dibeli: " + getTimePurchased() + " jam");
                    break;
                case 4:
                    System.out.println("\nTerima kasih telah menggunakan mesin tiket parkir.");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid.");
            }
        } while (choice != 4);
        scanner.close();
    }

    public static void main(String[] args) {
        ParkingTicketMachine machine = new ParkingTicketMachine(10000);
        machine.menuOptions();
    }
}
