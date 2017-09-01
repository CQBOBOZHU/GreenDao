package dowload.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by BoBoZhu on 2017/8/25.
 */
@Entity
public class MaBean {
    int age;
    @Id
    Long mId;
    String name;
    @Generated(hash = 1659420788)
    public MaBean(int age, Long mId, String name) {
        this.age = age;
        this.mId = mId;
        this.name = name;
    }
    @Generated(hash = 301176318)
    public MaBean() {
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
