package code;

import java.text.DecimalFormat;

public class LaundryType {
    private int id;
    private String laundryType;
    private String price;

    public LaundryType(int id, String laundryType, String price) {
        this.id = id;
        this.laundryType = laundryType;
        this.price = price;
    }

    public LaundryType(String laundryType, String price) {
        this.laundryType = laundryType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getLaundryType() {
        return laundryType;
    }

    public String getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLaundryType(String laundryType) {
        this.laundryType = laundryType;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return "LaundryType{" +
                "id=" + id +
                ", laundryType='" + laundryType + '\'' +
                ", price=" + price +
                '}';
    }
}
