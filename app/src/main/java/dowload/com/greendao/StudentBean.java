package dowload.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by BoBoZhu on 2017/8/25.
 */
@Entity
public class StudentBean {

    @Id
    Long _id;
//    Long tId;
    String name;
    String number;
    @Generated(hash = 1827819065)
    public StudentBean(Long _id, String name, String number) {
        this._id = _id;
        this.name = name;
        this.number = number;
    }
    @Generated(hash = 2097171990)
    public StudentBean() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }


}
