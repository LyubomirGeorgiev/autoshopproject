package autoshop.shop.data.entities.enums;

public enum ClientType {
    INDIVIDUAL("Individual"),
    CORPORATE("Corporate");

    private String displayValue;

    private ClientType(String displayValue){
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
