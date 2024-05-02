package bg.softuni.pathfinderproject.model.dto;

import bg.softuni.pathfinderproject.model.enums.UserLevelEnum;

public class UserProfileDTO {

    private String username;

    private String fullName;

    private Integer age;

    private UserLevelEnum level;

    public UserProfileDTO() {

    }

    public String getUsername() {
        return username;
    }

    public UserProfileDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserProfileDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserLevelEnum getLevel() {
        return level;
    }

    public UserProfileDTO setLevel(UserLevelEnum level) {
        this.level = level;
        return this;
    }
}