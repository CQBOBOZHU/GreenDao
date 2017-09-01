package dowload.com.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.ToOne;

import dowload.com.greendao.gen.DaoSession;
import dowload.com.greendao.gen.WomenBeanDao;
import dowload.com.greendao.gen.ManBeanDao;
import dowload.com.greendao.gen.MaBeanDao;

/**
 * Created by BoBoZhu on 2017/8/25.
 */
@Entity
public class ManBean {

    @Id
    Long id;
    String name;
    String age;
    @ToMany(referencedJoinProperty = "wId")
    List<WomenBean> womenBeanList;
    Long mId;
    @ToOne(joinProperty="mId")
    MaBean maBean;



    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1097394224)
    private transient ManBeanDao myDao;
    @Generated(hash = 1500101729)
    private transient Long maBean__resolvedKey;
    @Generated(hash = 2117826989)
    public ManBean(Long id, String name, String age, Long mId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mId = mId;
    }
    @Generated(hash = 907774723)
    public ManBean() {
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
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 694424596)
    public List<WomenBean> getWomenBeanList() {
        if (womenBeanList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WomenBeanDao targetDao = daoSession.getWomenBeanDao();
            List<WomenBean> womenBeanListNew = targetDao
                    ._queryManBean_WomenBeanList(id);
            synchronized (this) {
                if (womenBeanList == null) {
                    womenBeanList = womenBeanListNew;
                }
            }
        }
        return womenBeanList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2047216793)
    public synchronized void resetWomenBeanList() {
        womenBeanList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1826092674)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getManBeanDao() : null;
    }
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 394108644)
    public MaBean getMaBean() {
        Long __key = this.mId;
        if (maBean__resolvedKey == null || !maBean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MaBeanDao targetDao = daoSession.getMaBeanDao();
            MaBean maBeanNew = targetDao.load(__key);
            synchronized (this) {
                maBean = maBeanNew;
                maBean__resolvedKey = __key;
            }
        }
        return maBean;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 873246165)
    public void setMaBean(MaBean maBean) {
        synchronized (this) {
            this.maBean = maBean;
            mId = maBean == null ? null : maBean.getMId();
            maBean__resolvedKey = mId;
        }
    }
}
