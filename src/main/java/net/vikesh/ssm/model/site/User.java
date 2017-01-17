package net.vikesh.ssm.model.site;

import com.google.common.base.Strings;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Vikesh on 23-Dec-16.
 */
@Entity
@Validated
@Table(name = "DUSER")
public class User {
    /**
     * All instance variable names that identify STATE.
     */
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String RECOVERY_EMAIL = "recoveryEmail";
    public static final String PASSWORD = "password";
    public static final String SALT = "salt";
    public static final String PREFERENCES = "preferences";
    public static final String ID = "id";
    public static final String ENABLED = "enabled";
    public static final String LOCKED = "accountLocked";
    public static final String PASSWORD_EXPIRED = "passwordExpired";
    public static final String AUTHORITIES = "authorities";

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "RECOVERY_EMAIL", nullable = false)
    private String recoveryEmail;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private char[] password;

    @Column(name = "SALT", nullable = false)
    private char[] salt;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "LOCKED")
    private boolean accountLocked;

    @Column(name = "PASSWORD_EXPIRED")
    private boolean passwordExpired;

    @Column(name = "ACCOUNT_EXPIRED")
    private boolean accountExpired;

    @Embedded
    private Preferences preferences;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(
            name = "USER_GROUPS",
            joinColumns = @JoinColumn(name = "USER"),
            inverseJoinColumns = @JoinColumn(name = "GROUP")
    )
    private List<UserGroup> userGroups;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public char[] getSalt() {
        return salt;
    }

    public void setSalt(char[] salt) {
        this.salt = salt;
    }

    @PrePersist
    public void setId() {
        if (Strings.isNullOrEmpty(id)) {
            id = UUID.randomUUID().toString();
        }
    }

    public String getRecoveryEmail() {
        return recoveryEmail;
    }

    public void setRecoveryEmail(String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public void addUserGroup(UserGroup group) {
        this.userGroups.add(group);
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void removeAuthority(UserGroup group) {
        this.userGroups.remove(group);
    }
}
