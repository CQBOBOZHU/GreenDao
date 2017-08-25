package dowload.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by BoBoZhu on 2017/8/25.
 */
@Entity
public class MaBean {
    int age;
    @Id
    Long id;
    String name;
    @Unique
    Long mId;

    @Generated(hash = 1396748423)
    public MaBean(int age, Long id, String name, Long mId) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.mId = mId;
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
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }

}
