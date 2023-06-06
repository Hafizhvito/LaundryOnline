
package code;
/**
 * Kelas LaundryType merepresentasikan jenis layanan laundry.
 * Setiap objek LaundryType memiliki ID, jenis laundry, dan harga.
 */
public class LaundryType {
    private int id;
    private String laundryType;
    private String price;

<<<<<<< HEAD
=======
    /**
     * Konstruktor untuk objek LaundryType dengan ID, jenis laundry, dan harga.
     * @param id ID dari jenis laundry
     * @param laundryType Jenis laundry
     * @param price Harga laundry
     */
>>>>>>> main
    public LaundryType(int id, String laundryType, String price) {
        this.id = id;
        this.laundryType = laundryType;
        this.price = price;
    }

<<<<<<< HEAD
=======
    /**
     * Konstruktor untuk objek LaundryType tanpa ID.
     * @param laundryType Jenis laundry
     * @param price Harga laundry
     */
>>>>>>> main
    public LaundryType(String laundryType, String price) {
        this.laundryType = laundryType;
        this.price = price;
    }

    /**
     * Mengembalikan ID dari jenis laundry.
     * @return ID jenis laundry
     */
    public int getId() {
        return id;
    }

    /**
     * Mengembalikan jenis laundry.
     * @return Jenis laundry
     */
    public String getLaundryType() {
        return laundryType;
    }

<<<<<<< HEAD
=======
    /**
     * Mengembalikan harga laundry.
     * @return Harga laundry
     */
>>>>>>> main
    public String getPrice() {
        return price;
    }

    /**
     * Mengatur ID untuk jenis laundry.
     * @param id ID jenis laundry
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Mengatur jenis laundry.
     * @param laundryType Jenis laundry
     */
    public void setLaundryType(String laundryType) {
        this.laundryType = laundryType;
    }

<<<<<<< HEAD
=======
    /**
     * Mengatur harga laundry.
     * @param price Harga laundry
     */
>>>>>>> main
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Mengembalikan representasi String dari objek LaundryType.
     * @return Representasi String dari objek LaundryType
     */
    @Override
    public String toString() {
        return "LaundryType{" +
                "id=" + id +
                ", laundryType='" + laundryType + '\'' +
                ", price=" + price +
                '}';
    }
}
