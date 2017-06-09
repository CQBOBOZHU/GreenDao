package dowload.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@Entity(nameInDb = "user")
public class UserBean {

    /**
     * id : 4
     * userAccound : 15803006150
     * userIdentity : GUARDIAN
     * userAuthentication : UNAUTHORIZED
     * students : []
     * evidences : []
     * roleList : []
     * locked : false
     * registerTime : 2017-06-07 15:55:33
     */
    @Id(autoincrement = true)
    private Long id;
    private String userAccound;
    private String userIdentity;
    private String userAuthentication;
    private boolean locked;
    private String registerTime;
    private String userName;
    @Transient
    private List<?> students;
    @Transient
    private List<?> evidences;
    @Transient
    private List<?> roleList;
    @Generated(hash = 1788101927)
    public UserBean(Long id, String userAccound, String userIdentity,
            String userAuthentication, boolean locked, String registerTime,
            String userName) {
        this.id = id;
        this.userAccound = userAccound;
        this.userIdentity = userIdentity;
        this.userAuthentication = userAuthentication;
        this.locked = locked;
        this.registerTime = registerTime;
        this.userName = userName;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserAccound() {
        return this.userAccound;
    }
    public void setUserAccound(String userAccound) {
        this.userAccound = userAccound;
    }
    public String getUserIdentity() {
        return this.userIdentity;
    }
    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }
    public String getUserAuthentication() {
        return this.userAuthentication;
    }
    public void setUserAuthentication(String userAuthentication) {
        this.userAuthentication = userAuthentication;
    }
    public boolean getLocked() {
        return this.locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public String getRegisterTime() {
        return this.registerTime;
    }
    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userAccound='" + userAccound + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                ", userAuthentication='" + userAuthentication + '\'' +
                ", locked=" + locked +
                ", registerTime='" + registerTime + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
