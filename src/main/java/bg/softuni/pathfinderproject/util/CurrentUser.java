package bg.softuni.pathfinderproject.util;

import bg.softuni.pathfinderproject.model.entity.RoleEntity;
import bg.softuni.pathfinderproject.model.enums.UserLevelEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component("currentUser")
@SessionScope
public class CurrentUser {

    private String email;

    private String username;

    private Integer age;

    private String fullName;

    private UserLevelEnum level;

    private List<RoleEntity> roles;

    private boolean isLogged;

    public CurrentUser() {
        this.roles = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public CurrentUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public CurrentUser setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public CurrentUser setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserLevelEnum getLevel() {
        return level;
    }

    public CurrentUser setLevel(UserLevelEnum level) {
        this.level = level;
        return this;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public CurrentUser setRoles(List<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public boolean isAdmin() {
        return this.roles.stream().anyMatch(r -> r.getName().name().equals("ADMIN"));
    }

    public void logout() {
        this.email = null;
        this.username = null;
        this.age = null;
        this.fullName = null;
        this.level = null;
        this.roles = null;
        this.isLogged = false;
    }

}