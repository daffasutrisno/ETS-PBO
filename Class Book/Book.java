public class Book {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private String namaPenerbit;
    private String kategori;

    public Book(String judul, String penulis, int tahunTerbit, String namaPenerbit, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.namaPenerbit = namaPenerbit;
        this.kategori = kategori;
    }

    public void printDetails() {
        System.out.println("Judul : " + this.judul);
        System.out.println("Penulis : " + this.penulis);
        System.out.println("Tahun Terbit : " + this.tahunTerbit);
        System.out.println("Penerbit : " + this.namaPenerbit);
        System.out.println("Kategori : " + this.kategori);
    }

    public static void main(String[] args) {
        Book buku = new Book("Petarung", "Dose", 2045, "Unimedia", "Inspirasi");
        buku.printDetails();
    }
}
