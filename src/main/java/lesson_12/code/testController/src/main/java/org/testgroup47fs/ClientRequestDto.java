package org.testgroup47fs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

    @NotBlank(message = "Name is required and cannot be empty")
    @Size(min = 2, max = 100,message = "Name length must be between 2 - 100 characters long")
    private String name;

    @NotBlank(message = "Email must be not blank")
    @Email(message = "Email should be valid")
    private String email;
}
