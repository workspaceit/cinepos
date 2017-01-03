package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mi on 1/3/17.
 */
@Entity
@Table(name = "auth_credential")
public class AuthCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_inf_id", referencedColumnName = "id", nullable = true)
    private UserInf userInf;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",referencedColumnName = "id", nullable = true)
    private UserRole userRole;

    @Basic
    @Column(name = "username")
    private String userName;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "activate")
    private boolean isActivated;

    @Basic
    @Column(name = "email_confirmed")
    private boolean isEmailConfirmed;

    @Basic
    @Column(name = "changed_defult_password")
    private boolean changedDefultPassword;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public UserInf getUserInf() {
        return userInf;
    }

    public void setUserInf(UserInf userInf) {
        this.userInf = userInf;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEmailConfirmed() {
        return isEmailConfirmed;
    }

    public void setIsEmailConfirmed(boolean isEmailConfirmed) {
        this.isEmailConfirmed = isEmailConfirmed;
    }




    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public boolean getChangedDefultPassword() {
        return changedDefultPassword;
    }

    public void setChangedDefultPassword(boolean changedDefultPassword) {
        this.changedDefultPassword = changedDefultPassword;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AuthCredential{" +
                "id=" + id +
                ", isAdmin=" + isAdmin +
                ", userInf=" + userInf +
                ", userRole=" + userRole +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isActivated=" + isActivated +
                ", isEmailConfirmed=" + isEmailConfirmed +
                ", changedDefultPassword=" + changedDefultPassword +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthCredential that = (AuthCredential) o;

        if (id != that.id) return false;
        if (isAdmin != that.isAdmin) return false;
        if (isActivated != that.isActivated) return false;
        if (isEmailConfirmed != that.isEmailConfirmed) return false;
        if (changedDefultPassword != that.changedDefultPassword) return false;
        if (userInf != null ? !userInf.equals(that.userInf) : that.userInf != null) return false;
        if (userRole != null ? !userRole.equals(that.userRole) : that.userRole != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return !(createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isAdmin ? 1 : 0);
        result = 31 * result + (userInf != null ? userInf.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isActivated ? 1 : 0);
        result = 31 * result + (isEmailConfirmed ? 1 : 0);
        result = 31 * result + (changedDefultPassword ? 1 : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}