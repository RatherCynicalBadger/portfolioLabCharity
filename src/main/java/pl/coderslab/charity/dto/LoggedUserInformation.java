package pl.coderslab.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoggedUserInformation {
    private String email;
    private String firstName;
    private String lastName;
}
