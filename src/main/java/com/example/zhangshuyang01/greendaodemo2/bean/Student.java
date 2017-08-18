package com.example.zhangshuyang01.greendaodemo2.bean;

import com.example.zhangshuyang01.greendaodemo2.bean.greendao.BooksDao;
import com.example.zhangshuyang01.greendaodemo2.bean.greendao.DaoSession;
import com.example.zhangshuyang01.greendaodemo2.bean.greendao.StudentDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by zhangshuyang01 on 2017/8/17 0017.
 */
@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String age;
    private String sex;
    private String salary;
    private Long bookId;
    @ToOne(joinProperty = "bookId")
    private Books booklist;
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
    @Generated(hash = 315884872)
    public void setBooklist(Books booklist) {
        synchronized (this) {
            this.booklist = booklist;
            bookId = booklist == null ? null : booklist.getId();
            booklist__resolvedKey = bookId;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 215143199)
    public Books getBooklist() {
        Long __key = this.bookId;
        if (booklist__resolvedKey == null || !booklist__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BooksDao targetDao = daoSession.getBooksDao();
            Books booklistNew = targetDao.load(__key);
            synchronized (this) {
                booklist = booklistNew;
                booklist__resolvedKey = __key;
            }
        }
        return booklist;
    }
    @Generated(hash = 697548917)
    private transient Long booklist__resolvedKey;
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    public Long getBookId() {
        return this.bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getSalary() {
        return this.salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1723589044)
    public Student(Long id, String name, String age, String sex, String salary,
            Long bookId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.bookId = bookId;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
}


