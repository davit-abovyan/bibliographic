package am.bibliographic.entity;

import java.util.Objects;

public class UserEntity implements NoIdEntity{

    private String username;
    private String password;
    private String role;
    private boolean enabled;

    public UserEntity() {}

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserEntity setRole(String role) {
        this.role = role;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public UserEntity setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public boolean equals(Object object){
        if(object == null) return false;
        if(object == this) return true;
        if(!(object instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) object;
        return Objects.equals(username, that.getUsername()) &&
                Objects.equals(password, that.getPassword()) &&
                Objects.equals(role, that.getRole()) &&
                Objects.equals(enabled, that.isEnabled());
    }
}
