package autoshop.shop.data.entities.enums;

public enum PartStatus {

    AVAILABLE("Available"),
    SOLD("Sold"),
    RETURNED("Returned"),
    WASTE("Waste");

    private String displayValue;

    PartStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
