package com.marcecuevas.mltest_core.model.login;

public class UserDTO {

    private String name;

    public UserDTO(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
