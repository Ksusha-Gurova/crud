package ru.neoflex.crud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private Long id;

    @Pattern(regexp = "[a-zA-Z]{2,} [a-zA-Z]{2,}", message = "Поле fullname должно содержать имя и фамилию латинскими буквами и не менее двух символов в каждом слове")
    @NotBlank(message = "Поле fullname не может быть пустым")
    @Column(name = "fullname", nullable = false)
    private String fullname;

    @NotBlank(message = "Поле email не может быть пустым")
    private String email;

    @NotBlank(message = "Поле phone не может быть пустым")

    @Pattern(regexp = "[0-9]{10}", message = "Поле phone должно содержать 10 символов")
    private String phone;

    @NotBlank(message = "Поле address не может быть пустым")
    private String address;

    @NotNull(message = "Поле dateOfBirth не может быть пустым")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

}
