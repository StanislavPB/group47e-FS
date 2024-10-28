package org.testgroup47fs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddClientService addClientService;


    @Test
    public void whenAddNewClientWithValidationErrorAndReturnBadRequest() throws Exception {

        doThrow(new RuntimeException("Valid failed")).when(addClientService).addClient(any(Client.class));

        mockMvc.perform(
                post("/api/clients/addNewClient")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                                "\"name\" : \"\"," +
                                "\"email\" : \"invalid email\"" +
                        "}"))
                .andExpect(status().isBadRequest());
    }

}