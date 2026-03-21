package org.example._1_cheav_sarin_pp_web_homework002.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import java.time.LocalDateTime;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class ApiResponse<T> {
    private Boolean success;
    private  String status;
    private String message;
    private  T payload;
    private LocalDateTime timestamp ;
//    = LocalDateTime.now();
}
