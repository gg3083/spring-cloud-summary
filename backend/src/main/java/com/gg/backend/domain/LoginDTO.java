package com.gg.backend.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Gimi
 * @date 2020/4/20 17:43
 */
@Data
public class LoginDTO {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
