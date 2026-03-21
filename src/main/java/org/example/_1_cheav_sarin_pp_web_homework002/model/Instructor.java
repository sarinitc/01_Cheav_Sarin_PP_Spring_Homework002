package org.example._1_cheav_sarin_pp_web_homework002.model;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    private Integer instructorId;
    private String instructorName;
    private String email;

}
