package com.booleanuk.giagkinis.hospital.dtos;

public class UserDTO {

    private long id;
    private String userType;

    public UserDTO() {
    }

    public UserDTO(long id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
