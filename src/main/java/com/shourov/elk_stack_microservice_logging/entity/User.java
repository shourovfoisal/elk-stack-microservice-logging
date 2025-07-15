package com.shourov.elk_stack_microservice_logging.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
    private int id;
    private String name;
}
