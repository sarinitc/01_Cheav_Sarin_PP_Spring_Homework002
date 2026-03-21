package org.example._1_cheav_sarin_pp_web_homework002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
}
