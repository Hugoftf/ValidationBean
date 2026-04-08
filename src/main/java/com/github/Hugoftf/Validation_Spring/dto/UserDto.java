package com.github.Hugoftf.Validation_Spring.dto;

import com.github.Hugoftf.Validation_Spring.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDto(

        @NotBlank(message = "Name is mandatory")
        @Size(min = 3, max = 50, message = "The name must contain between 3 and 50 characters")
        String name,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Invalid email address")
        String email,

        @Min(value = 18, message = "Min age is 18!")
        Integer age

) {

    public User toEntity() {
        return new User(this.name, this.email, this.age);
    }
}