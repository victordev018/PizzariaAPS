package com.aps.pizzariaapi.service;

import com.aps.pizzariaapi.entity.Client;
import com.aps.pizzariaapi.repository.ClientRepository;
import com.aps.pizzariaapi.service.exception.ClientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        client = this.clientRepository.save(client);
        return client;
    }

    public Client findById(Long id) throws ClientNotFoundException {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }
}
