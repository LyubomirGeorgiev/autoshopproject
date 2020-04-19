package autoshop.shop.services.services;

import autoshop.shop.data.entities.Client;
import autoshop.shop.services.models.ClientRegisterServiceModel;
import autoshop.shop.services.models.ClientViewServiceModel;

import java.util.List;

public interface ClientService {

    ClientRegisterServiceModel register(ClientRegisterServiceModel clientRegisterServiceModel);

    List<ClientViewServiceModel> findAllClients();

    Client getClientByEmail(String email);
}
