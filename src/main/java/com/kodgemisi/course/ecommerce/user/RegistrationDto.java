package com.kodgemisi.course.ecommerce.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegistrationDto {

    @Size(min = 3)
    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @Email
    @NotBlank
    private String emailConfirmation;

    @Size(min = 6)
    @NotBlank
    private String password;

}
