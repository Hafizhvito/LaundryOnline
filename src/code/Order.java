package code;

public class Order {
    private int id;
    private String customer;
    private String laundryType;
    private String weight;
    private String total;
    private String payment;
    private String remainingBalance;
    private String status;
    private int customerId;

    public Order(String customer, String laundryType, String weight, String total, String payment, String remainingBalance, String status) {
        this.customer = customer;
        this.laundryType = laundryType;
        this.weight = weight;
        this.total = total;
        this.payment = payment;
        this.remainingBalance = remainingBalance;
        this.status = status;
    }

    public Order(int id, String customer, String laundryType, String weight, String total, String payment, String remainingBalance, String status) {
        this.id = id;
        this.customer = customer;
        this.laundryType = laundryType;
        this.weight = weight;
        this.total = total;
        this.payment = payment;
        this.remainingBalance = remainingBalance;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getLaundryType() {
        return laundryType;
    }

    public void setLaundryType(String laundryType) {
        this.laundryType = laundryType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(String remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
