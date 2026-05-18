package org.example.tliastest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginObjective {
    private Integer id;
    private String username;
    private String name;
    private String token;
}
