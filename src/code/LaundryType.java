package code;

import java.text.DecimalFormat;

public class LaundryType {
    private int id;
    private String laundryType;
    private double price;

    public LaundryType(int id, String laundryType, double price) {
        this.id = id;
        this.laundryType = laundryType;
        this.price = price;
    }

    public LaundryType(String laundryType, double price) {
        this.laundryType = laundryType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getLaundryType() {
        return laundryType;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLaundryType(String laundryType) {
        this.laundryType = laundryType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return "LaundryType{" +
                "id=" + id +
                ", laundryType='" + laundryType + '\'' +
                ", price=" + decimalFormat.format(price) +
                '}';
    }
}
