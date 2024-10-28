package org.testgroup47fs;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {

    private final AddClientService addClientService;

    @PostMapping("/addNewClient")
    public ResponseEntity<Client> addNewClient(@RequestBody @Valid ClientRequestDto request){
        Client client = new Client();
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        Client savedClient = addClientService.addClient(client);
        return ResponseEntity.ok(savedClient);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerValidationException(MethodArgumentNotValidException e){
        Map<String, Object> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(Map.of("errors",errors));
    }


}
