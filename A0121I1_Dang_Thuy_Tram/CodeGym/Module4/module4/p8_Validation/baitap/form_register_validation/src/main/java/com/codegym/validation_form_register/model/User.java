package com.codegym.validation_form_register.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull(message = "Firstname không được bỏ trống")
    @Size(min = 5, max = 42, message = "Độ dài yêu cầu >=5 & <=42")
    private String firstName;

    @NotNull(message = "Lastname không được bỏ trống")
    @Size(min = 5, max = 42, message = "Độ dài yêu cầu >=5 & <=42")
    private String lastName;

    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$", message = "Số điện thoại không hợp lệ!")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    private int age;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email không đúng định dạng abc@xyz.jqk")
    private String email;


}
