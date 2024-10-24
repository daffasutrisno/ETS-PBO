import java.util.ArrayList;

public class FoodOrder {
    private ArrayList<MenuItem> menuItems;
    private ArrayList<Integer> itemQuantities;
    private double totalPrice;
    private boolean isPaid;

    public FoodOrder() {
        this.menuItems = new ArrayList<>();
        this.itemQuantities = new ArrayList<>();
        this.totalPrice = 0.0;
        this.isPaid = false;
    }

    public void addItem(MenuItem item, int quantity) {
        menuItems.add(item);
        itemQuantities.add(quantity);
        totalPrice += item.getPrice() * quantity;
        System.out.println(quantity + " unit " + item.getName() + " telah ditambahkan ke pesanan.");
    }

    public void removeItem(String itemName, int quantity) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getName().equalsIgnoreCase(itemName)) {
                int currentQuantity = itemQuantities.get(i);
                if (quantity > currentQuantity) {
                    System.out.println("Jumlah yang ingin dihapus melebihi jumlah yang dipesan.");
                } else {
                    itemQuantities.set(i, currentQuantity - quantity);
                    totalPrice -= menuItems.get(i).getPrice() * quantity;
                    System.out.println(quantity + " unit " + itemName + " telah dihapus dari pesanan.");
                    
                    if (itemQuantities.get(i) == 0) {
                        menuItems.remove(i);
                        itemQuantities.remove(i);
                    }
                }
                return;
            }
        }
        System.out.println("Item tidak ditemukan di pesanan.");
    }

    public double calculateTotalPrice() {
        return totalPrice;
    }

    public void pay() {
        if (!isPaid) {
            isPaid = true;
            System.out.println("\nPesanan telah dibayar. Total : Rp " + totalPrice);
        } else {
            System.out.println("\nPesanan sudah dibayar.");
        }
    }

    public void viewOrder() {
        System.out.println("\nPesanan saat ini :");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i).getName() + " : " + itemQuantities.get(i) + " unit");
        }
        System.out.println("Total harga : Rp " + totalPrice);
        System.out.println("Status pembayaran : " + (isPaid ? "Sudah Dibayar" : "Belum Dibayar"));
    }
}
