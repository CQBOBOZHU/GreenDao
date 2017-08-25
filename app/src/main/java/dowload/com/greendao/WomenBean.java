package dowload.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by BoBoZhu on 2017/8/25.
 */
@Entity
public class WomenBean {
    @Id
    Long id;
    String name;
    String age;
    Long wId;
    @Generated(hash = 851723903)
    public WomenBean(Long id, String name, String age, Long wId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wId = wId;
    }
    @Generated(hash = 830677586)
    public WomenBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public Long getWId() {
        return this.wId;
    }
    public void setWId(Long wId) {
        this.wId = wId;
    }
}
