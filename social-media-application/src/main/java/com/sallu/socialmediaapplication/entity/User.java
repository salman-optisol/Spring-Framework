package com.sallu.socialmediaapplication.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    @JsonProperty("user-id")
    private long id;

    @NotEmpty(message = "Username cannot be empty")
    @JsonProperty("user-name")
    private String username;

    @JsonProperty("user-birth-date")
    private LocalDate birthdate;

//    @JsonIgnore
//    private String password; // This is static filtering, means this field will always get filtered out

    static long idGenerator = 1;

    public User(User user) {
        this.id = idGenerator++;
        this.username = user.username;
        this.birthdate = user.birthdate;
    }

    public User() {}
}


