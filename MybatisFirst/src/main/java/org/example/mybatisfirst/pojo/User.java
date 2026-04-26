package org.example.mybatisfirst.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 10,冯丽,女,29,市场部,品牌专员,本科,2022-02-14,13611223310
    // 根据以上格式，定义User类的属性
    private String id;
    private String name;
    private Integer age;
    private String gender;
    private String department;
    private String position;
    private String education;
    private String hireDate;
    private String joinTime;
    private String phone;
}
