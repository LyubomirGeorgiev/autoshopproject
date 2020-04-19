package autoshop.shop.services.models;

import autoshop.shop.data.entities.enums.ClientType;

public class UserTypeInfoServiceModel {

    private ClientType clientType;

    public UserTypeInfoServiceModel() {
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
}
