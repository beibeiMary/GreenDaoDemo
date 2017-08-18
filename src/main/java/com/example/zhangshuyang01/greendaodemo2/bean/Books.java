package com.example.zhangshuyang01.greendaodemo2.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhangshuyang01 on 2017/8/17 0017.
 */

@Entity
public class Books{
    @Id
    private Long id;
    private String bookname;
    private String bookprice;
    public String getBookprice() {
        return this.bookprice;
    }
    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }
    public String getBookname() {
        return this.bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 728573000)
    public Books(Long id, String bookname, String bookprice) {
        this.id = id;
        this.bookname = bookname;
        this.bookprice = bookprice;
    }
    @Generated(hash = 2016280518)
    public Books() {
    }
}
