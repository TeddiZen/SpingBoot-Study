package org.example.tliastest.pojo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsQueryParam {
    private String name;
    private Integer clazzId;
    private String degree;
    private Integer Page = 1;
    private Integer PageSize = 10;
}
