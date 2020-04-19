package autoshop.shop.services.services;

import autoshop.shop.data.entities.Client;
import autoshop.shop.data.repositories.ClientRepository;
import autoshop.shop.services.models.ClientRegisterServiceModel;
import autoshop.shop.services.models.ClientViewServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientRegisterServiceModel register(ClientRegisterServiceModel clientRegisterServiceModel) {

        clientRegisterServiceModel.setCustomerNumber(this.clientRepository.count() + 1);
        clientRegisterServiceModel.setRegisteredDate(new Date());

        Client client = this.modelMapper.map(clientRegisterServiceModel, Client.class);

        return this.modelMapper.map(this.clientRepository.saveAndFlush(client), ClientRegisterServiceModel.class);
    }

    @Override
    public List<ClientViewServiceModel> findAllClients() {

        List<ClientViewServiceModel> clientViewServiceModelList =
                this.clientRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, ClientViewServiceModel.class))
                .collect(Collectors.toList());

        return clientViewServiceModelList;
    }

    @Override
    public Client getClientByEmail(String email) {

        return this.clientRepository.findByEmail(email);
    }
}
