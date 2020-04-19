package autoshop.shop.data.entities.enums;

public enum PaymentType {

    BANK_TRANSFER("Bank Transfer"),
    CREDIT_CARD("Credit Card"),
    CASH("Cash");

    private String displayValue;

    PaymentType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
