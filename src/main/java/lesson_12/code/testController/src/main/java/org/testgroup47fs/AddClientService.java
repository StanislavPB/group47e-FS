package org.testgroup47fs;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddClientService {

    private final ClientRepository clientRepository;

    public Client addClient(Client client){
        return clientRepository.save(client);
    }
}
