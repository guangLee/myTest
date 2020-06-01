package com.lombok;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class Person implements Serializable {

    private String name;

    private int age;

    private Boolean isOnSale;

    private Boolean isHidden;

    private List<Human> humanList;


}
