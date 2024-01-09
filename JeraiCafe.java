public class JeraiCafe {
    private String drinkId, customerName, customerContactNumber;
    private int drinkAmount;
    private double totalPayment;
    private char preparationType, paymentType;

    public JeraiCafe(String drinkId, String customerName, char paymentType, char preparationType,
                     String customerContactNumber, int drinkAmount, double totalPayment) {
        this.drinkId = drinkId;
        this.customerName = customerName;
        this.paymentType = paymentType;
        this.preparationType = preparationType;
        this.customerContactNumber = customerContactNumber;
        this.drinkAmount = drinkAmount;
        this.totalPayment = totalPayment;
    }

    // Getters and Setters
    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
    }

    public char getPreparationType() {
        return preparationType;
    }

    public void setPreparationType(char preparationType) {
        this.preparationType = preparationType;
    }

    public int getDrinkAmount() {
        return drinkAmount;
    }

    public void setDrinkAmount(int drinkAmount) {
        this.drinkAmount = drinkAmount;
    }

    public double calculateTotalPrice() {
        // Add logic to calculate the total price based on drinkId, preparationType, and drinkAmount
        double unitPrice = 0.00;

        switch (drinkId.toUpperCase()) {
            case "1":
                unitPrice = (preparationType == 'H') ? 5.00 : 5.50;
                break;
            case "2":
                unitPrice = (preparationType == 'H') ? 4.00 : 4.50;
                break;
            case "3":
                unitPrice = (preparationType == 'H') ? 6.00 : 6.50;
                break;
            default:
                break;
        }

        return unitPrice * drinkAmount;
    }

    @Override
    public String toString() {
        return String.format("\t%s\t\t\t%s\t\t%s\t\t\t%s\t\t\t\t%d\t\t%s\t\t%.2f",
                drinkId, customerName, paymentType, preparationType, drinkAmount, customerContactNumber, calculateTotalPrice());
    }
}