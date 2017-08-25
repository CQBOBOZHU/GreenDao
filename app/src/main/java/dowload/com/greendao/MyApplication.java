package dowload.com.greendao;

import android.app.Application;

import dowload.com.greendao.gen.DaoMaster;
import dowload.com.greendao.gen.DaoSession;
import dowload.com.greendao.gen.MySQLiteOpenHelper;

/**
 * Created by BoBoZhu on 2017/6/8.
 */

public class MyApplication extends Application {
    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(this, "test.db", null);
        DaoMaster daoMaster = new DaoMaster(mySQLiteOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();

        DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(this, "test.db", null);
        DaoMaster daoMaster1=new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();

    }
}
