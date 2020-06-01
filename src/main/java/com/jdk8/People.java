package com.jdk8;

import lombok.Data;
import java.util.Optional;

@Data
public class People {

    private String head ;
    private Optional<String> hat;
}
