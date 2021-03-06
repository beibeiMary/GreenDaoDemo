package com.example.zhangshuyang01.greendaodemo2.bean.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.example.zhangshuyang01.greendaodemo2.bean.Client;

import com.example.zhangshuyang01.greendaodemo2.bean.Commande;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "COMMANDES".
*/
public class CommandeDao extends AbstractDao<Commande, Long> {

    public static final String TABLENAME = "COMMANDES";

    /**
     * Properties of entity Commande.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Libelle = new Property(1, String.class, "libelle", false, "LIBELLE");
        public final static Property ClientId = new Property(2, long.class, "clientId", false, "CLIENT_ID");
    }

    private DaoSession daoSession;

    private Query<Commande> client_ListeCommandesQuery;

    public CommandeDao(DaoConfig config) {
        super(config);
    }
    
    public CommandeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COMMANDES\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"LIBELLE\" TEXT NOT NULL ," + // 1: libelle
                "\"CLIENT_ID\" INTEGER NOT NULL );"); // 2: clientId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COMMANDES\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Commande entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getLibelle());
        stmt.bindLong(3, entity.getClientId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Commande entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getLibelle());
        stmt.bindLong(3, entity.getClientId());
    }

    @Override
    protected final void attachEntity(Commande entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Commande readEntity(Cursor cursor, int offset) {
        Commande entity = new Commande( //
            cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // libelle
            cursor.getLong(offset + 2) // clientId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Commande entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setLibelle(cursor.getString(offset + 1));
        entity.setClientId(cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Commande entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Commande entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Commande entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "listeCommandes" to-many relationship of Client. */
    public List<Commande> _queryClient_ListeCommandes(long clientId) {
        synchronized (this) {
            if (client_ListeCommandesQuery == null) {
                QueryBuilder<Commande> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ClientId.eq(null));
                client_ListeCommandesQuery = queryBuilder.build();
            }
        }
        Query<Commande> query = client_ListeCommandesQuery.forCurrentThread();
        query.setParameter(0, clientId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getClientDao().getAllColumns());
            builder.append(" FROM COMMANDES T");
            builder.append(" LEFT JOIN CLIENTS T0 ON T.\"CLIENT_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Commande loadCurrentDeep(Cursor cursor, boolean lock) {
        Commande entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Client client = loadCurrentOther(daoSession.getClientDao(), cursor, offset);
         if(client != null) {
            entity.setClient(client);
        }

        return entity;    
    }

    public Commande loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Commande> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Commande> list = new ArrayList<Commande>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Commande> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Commande> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
