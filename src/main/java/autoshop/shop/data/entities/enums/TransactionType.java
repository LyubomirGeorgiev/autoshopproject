package autoshop.shop.data.entities.enums;

public enum TransactionType {

    INCOMING("Incoming"),
    OUTGOING("Outgoing");

    private String displayValue;

    TransactionType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
