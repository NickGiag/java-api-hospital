package com.booleanuk.giagkinis.hospital.dtos;

public class UserDTO {

    private long id;
    private String userType;
    private String fullName;

    public UserDTO() {
    }

    public UserDTO(long id, String userType, String fullName) {
        this.id = id;
        this.userType = userType;
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
