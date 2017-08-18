package com.example.zhangshuyang01.greendaodemo2.bean;

import com.example.zhangshuyang01.greendaodemo2.bean.greendao.ClientDao;
import com.example.zhangshuyang01.greendaodemo2.bean.greendao.CommandeDao;
import com.example.zhangshuyang01.greendaodemo2.bean.greendao.DaoSession;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by zhangshuyang01 on 2017/8/17 0017.
 */
@Entity(
        active = true,
        nameInDb = "CLIENTS"
)
public class Client {
    @Id(autoincrement = true)
    private long id;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @ToMany(referencedJoinProperty = "clientId")
    private List<Commande> listeCommandes;
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
/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1251748282)
public synchronized void resetListeCommandes() {
        listeCommandes = null;
}
/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1243598648)
public List<Commande> getListeCommandes() {
    if (listeCommandes == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        CommandeDao targetDao = daoSession.getCommandeDao();
        List<Commande> listeCommandesNew = targetDao._queryClient_ListeCommandes(id);
        synchronized (this) {
            if(listeCommandes == null) {
                listeCommandes = listeCommandesNew;
            }
        }
    }
    return listeCommandes;
}
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 2049572258)
public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getClientDao() : null;
}
/** Used for active entity operations. */
@Generated(hash = 883866064)
private transient ClientDao myDao;
/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;
public String getPrenom() {
        return this.prenom;
}
public void setPrenom(String prenom) {
        this.prenom = prenom;
}
public String getNom() {
        return this.nom;
}
public void setNom(String nom) {
        this.nom = nom;
}
public long getId() {
        return this.id;
}
public void setId(long id) {
        this.id = id;
}
@Generated(hash = 1233783670)
public Client(long id, @NotNull String nom, @NotNull String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
}
@Generated(hash = 1485887936)
public Client() {
}
}
