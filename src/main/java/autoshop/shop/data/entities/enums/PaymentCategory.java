package autoshop.shop.data.entities.enums;

public enum PaymentCategory {

    PARTS("Parts"),
    SALARIES("Salaries"),
    SUPPLIES("Supplies"),
    RENT("Rent"),
    OTHER("Other");

    private String displayValue;

    PaymentCategory(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
