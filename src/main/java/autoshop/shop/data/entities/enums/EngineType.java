package autoshop.shop.data.entities.enums;

public enum EngineType {
    DIESEL("Diesel"),
    GASOLINE("Gasoline");

    private String displayValue;

    EngineType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
