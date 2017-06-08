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
    private long id;
    @Unique
    @Id(autoincrement = true)
    private long _id;
    private String userAccound;
    private String userIdentity;
    private String userAuthentication;
    private boolean locked;
    private String registerTime;
    @Transient
    private List<?> students;
    @Transient
    private List<?> evidences;
    @Transient
    private List<?> roleList;

    @Generated(hash = 1140818872)
    public UserBean(long id, long _id, String userAccound, String userIdentity,
                    String userAuthentication, boolean locked, String registerTime) {
        this.id = id;
        this._id = _id;
        this.userAccound = userAccound;
        this.userIdentity = userIdentity;
        this.userAuthentication = userAuthentication;
        this.locked = locked;
        this.registerTime = registerTime;
    }

    public UserBean(long id, String userAccound, String userIdentity,
                    String userAuthentication, boolean locked, String registerTime) {
        this.id = id;
        this.userAccound = userAccound;
        this.userIdentity = userIdentity;
        this.userAuthentication = userAuthentication;
        this.locked = locked;
        this.registerTime = registerTime;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserAccound() {
        return userAccound;
    }

    public void setUserAccound(String userAccound) {
        this.userAccound = userAccound;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserAuthentication() {
        return userAuthentication;
    }

    public void setUserAuthentication(String userAuthentication) {
        this.userAuthentication = userAuthentication;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public List<?> getStudents() {
        return students;
    }

    public void setStudents(List<?> students) {
        this.students = students;
    }

    public List<?> getEvidences() {
        return evidences;
    }

    public void setEvidences(List<?> evidences) {
        this.evidences = evidences;
    }

    public List<?> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<?> roleList) {
        this.roleList = roleList;
    }

    public boolean getLocked() {
        return this.locked;
    }


    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", _id=" + _id +
                ", userAccound='" + userAccound + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                ", userAuthentication='" + userAuthentication + '\'' +
                ", locked=" + locked +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
