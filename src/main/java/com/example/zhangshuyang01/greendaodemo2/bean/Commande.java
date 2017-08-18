package com.example.zhangshuyang01.greendaodemo2.bean;

import com.example.zhangshuyang01.greendaodemo2.bean.greendao.ClientDao;
import com.example.zhangshuyang01.greendaodemo2.bean.greendao.CommandeDao;
import com.example.zhangshuyang01.greendaodemo2.bean.greendao.DaoSession;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by zhangshuyang01 on 2017/8/17 0017.
 */
@Entity(
        active = true,
        nameInDb = "COMMANDES"
)
public class Commande {
    @Id(autoincrement = true)
    private long id;
    @NotNull
    private String libelle;
    @NotNull
    private long clientId;
    @NotNull
    @ToOne(joinProperty = "clientId")
    private Client client;
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
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1227513621)
public void setClient(@NotNull Client client) {
        if (client == null) {
                throw new DaoException(
                                "To-one property 'clientId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
                this.client = client;
                clientId = client.getId();
                client__resolvedKey = clientId;
        }
}
/** To-one relationship, resolved on first access. */
@Generated(hash = 1030060700)
public Client getClient() {
        long __key = this.clientId;
        if (client__resolvedKey == null || !client__resolvedKey.equals(__key)) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                        throw new DaoException(
                                        "Entity is detached from DAO context");
                }
                ClientDao targetDao = daoSession.getClientDao();
                Client clientNew = targetDao.load(__key);
                synchronized (this) {
                        client = clientNew;
                        client__resolvedKey = __key;
                }
        }
        return client;
}
@Generated(hash = 1636229693)
private transient Long client__resolvedKey;
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 937119593)
public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCommandeDao() : null;
}
/** Used for active entity operations. */
@Generated(hash = 1380010678)
private transient CommandeDao myDao;
/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
public long getClientId() {
        return this.clientId;
}
public void setClientId(long clientId) {
        this.clientId = clientId;
}
public String getLibelle() {
        return this.libelle;
}
public void setLibelle(String libelle) {
        this.libelle = libelle;
}
public long getId() {
        return this.id;
}
public void setId(long id) {
        this.id = id;
}
@Generated(hash = 1315727580)
public Commande(long id, @NotNull String libelle, long clientId) {
        this.id = id;
        this.libelle = libelle;
        this.clientId = clientId;
}
@Generated(hash = 320794920)
public Commande() {
}
}
