import java.util.ArrayList;
import java.util.Scanner;

public class FoodOrderSystem {
    private FoodOrder currentOrder;
    private ArrayList<MenuItem> menuList;

    public FoodOrderSystem() {
        menuList = new ArrayList<>();
        menuList.add(new MenuItem("Sop Sigma", 25000));
        menuList.add(new MenuItem("Fanum Goreng", 15000));
        menuList.add(new MenuItem("Skibidi Bakpao", 20000));
        menuList.add(new MenuItem("Nasi Fufufafa", 28000));
        menuList.add(new MenuItem("Es Mulyono", 5000));
        menuList.add(new MenuItem("Jus Hitam", 7000));
    }

    public void startOrder() {
        currentOrder = new FoodOrder();
        System.out.println("Pesanan baru dimulai.");
    }

    public void displayMenu() {
        System.out.println("\n=== Menu ===");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i));
        }
    }

    public void processMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Food Order System ===");
            System.out.println("1. Lihat Menu dan Tambah Item ke Pesanan");
            System.out.println("2. Hapus Item dari Pesanan");
            System.out.println("3. Lihat Total Pesanan");
            System.out.println("4. Bayar Pesanan");
            System.out.println("5. Lihat Detail Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayMenu();
                    System.out.print("\nPilih item (nomor) : ");
                    int menuChoice = scanner.nextInt();
                    if (menuChoice > 0 && menuChoice <= menuList.size()) {
                        System.out.print("Masukkan jumlah : ");
                        int quantity = scanner.nextInt();
                        currentOrder.addItem(menuList.get(menuChoice - 1), quantity);
                    } else {
                        System.out.println("\nPilihan tidak valid.");
                    }
                    break;
                case 2:
                    System.out.print("\nMasukkan nama item yang ingin dihapus : ");
                    String removeItem = scanner.nextLine();
                    System.out.print("Masukkan jumlah item yang ingin dihapus : ");
                    int removeQuantity = scanner.nextInt();
                    currentOrder.removeItem(removeItem, removeQuantity);
                    break;
                case 3:
                    System.out.println("\nTotal harga pesanan : Rp " + currentOrder.calculateTotalPrice());
                    break;
                case 4:
                    currentOrder.pay();
                    break;
                case 5:
                    currentOrder.viewOrder();
                    break;
                case 0:
                    System.out.println("\nKeluar dari sistem.");
                    break;
                default:
                    System.out.println("\nOpsi tidak valid.");
            }
        } while (choice != 0);
    }
}
