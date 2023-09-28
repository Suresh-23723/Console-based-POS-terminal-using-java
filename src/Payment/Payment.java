package Payment;

public class Payment {
    private int paymentId;
    private int orderId;
    private double amount;
    private String paymentMode;
    private boolean isPaid;

    public Payment(int paymentId, int orderId, double amount, String paymentMode) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMode = paymentMode;
    }

    public Payment(int orderId, double amount, String paymentMode) {
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMode = paymentMode;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
