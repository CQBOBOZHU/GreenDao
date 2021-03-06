package dowload.com.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import dowload.com.greendao.MaBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MA_BEAN".
*/
public class MaBeanDao extends AbstractDao<MaBean, Long> {

    public static final String TABLENAME = "MA_BEAN";

    /**
     * Properties of entity MaBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Age = new Property(0, int.class, "age", false, "AGE");
        public final static Property MId = new Property(1, Long.class, "mId", true, "_id");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
    }


    public MaBeanDao(DaoConfig config) {
        super(config);
    }
    
    public MaBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MA_BEAN\" (" + //
                "\"AGE\" INTEGER NOT NULL ," + // 0: age
                "\"_id\" INTEGER PRIMARY KEY ," + // 1: mId
                "\"NAME\" TEXT);"); // 2: name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MA_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MaBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getAge());
 
        Long mId = entity.getMId();
        if (mId != null) {
            stmt.bindLong(2, mId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MaBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getAge());
 
        Long mId = entity.getMId();
        if (mId != null) {
            stmt.bindLong(2, mId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1);
    }    

    @Override
    public MaBean readEntity(Cursor cursor, int offset) {
        MaBean entity = new MaBean( //
            cursor.getInt(offset + 0), // age
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // mId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MaBean entity, int offset) {
        entity.setAge(cursor.getInt(offset + 0));
        entity.setMId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MaBean entity, long rowId) {
        entity.setMId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MaBean entity) {
        if(entity != null) {
            return entity.getMId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MaBean entity) {
        return entity.getMId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
