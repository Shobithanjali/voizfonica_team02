package com.example.voiz_team02.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Login {


    @NotBlank
  /*  @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\.\\-]+)\\.([a-zA-Z]{2,5})$ ")*/

    private  String emailAddress;
    @NotBlank
    @Size(min=6, message = "invalid password")
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }


}
