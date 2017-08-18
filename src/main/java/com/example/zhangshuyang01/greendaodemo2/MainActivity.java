package com.example.zhangshuyang01.greendaodemo2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhangshuyang01.greendaodemo2.bean.User;
import com.example.zhangshuyang01.greendaodemo2.bean.greendao.UserDao;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private BaseApplication app;
    private ListView listView;
    private EditText et_Name,et_age,et_sex,et_Salary;
    private String name,sex,salary,age;
    private UserAdapter adapter;
    private List<User>  listUser;
    private UserDao dao;
    private User user;
    private Button btninsert,btnsearch,btnall,btnupdate,btndelete;
    private ListAdapter listAdapter;
    private User insertData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao =BaseApplication.getApplication().getDaoSession().getUserDao();
        initView();
        listUser = new ArrayList<>();
    }
    private void initView(){
        btninsert = (Button) findViewById(R.id.btn_insert);
        btnsearch = (Button) findViewById(R.id.btn_search);
        btnall = (Button) findViewById(R.id.btn_all);
        btnupdate = (Button) findViewById(R.id.btn_update);
        btndelete = (Button) findViewById(R.id.btn_delete);
        et_Name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        et_sex = (EditText) findViewById(R.id.et_sex);
        et_Salary = (EditText) findViewById(R.id.et_salary);
        listView = (ListView) findViewById(R.id.list_view);
        btninsert.setOnClickListener(this);
        btnsearch.setOnClickListener(this);
        btnall.setOnClickListener(this);
        btnupdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        listView.setOnItemLongClickListener(new MyOnItemLongClickListener());
        listUser = dao.loadAll();
        adapter = new UserAdapter(this, listUser);
        listView.setAdapter(adapter);
    }

    //增

    private void insertData() {
        name = et_Name.getText().toString().trim();
        age = et_age.getText().toString();
        sex = et_sex.getText().toString().trim();
        salary = et_Salary.getText().toString().trim();
        User insertData = new User(null, name, age, sex, salary);
        dao.insert(insertData);
        listUser = dao.loadAll();
        adapter.addData(insertData);
    }
    //删
    private void deleteData(int i) {
        User listbox = listUser.get(i);
        dao.delete(listbox);

    }
    //改

    private void updateData(int i) {
        name = et_Name.getText().toString().trim();
        age = et_age.getText().toString();
        sex = et_sex.getText().toString().trim();
        salary = et_Salary.getText().toString().trim();
        User updateData = new User(listUser.get(i).getId(), name, age, sex, salary);
        dao.update(updateData);
    }
    private void updateData() {
        name = et_Name.getText().toString().trim();
        age = et_age.getText().toString();
        sex = et_sex.getText().toString().trim();
        salary = et_Salary.getText().toString().trim();
    }
    //查
    private void query() {
        Query query = dao.queryBuilder().where(UserDao.Properties.Name.eq(et_Name.getText().toString().trim())).build();
        Toast.makeText(this, "查询的结果是：" + query.list().toString(), Toast.LENGTH_LONG).show();

    }
    private void queryData() {
        List<User> users = dao.loadAll();
        String userName = "";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getName() + ",";
        }
        Toast.makeText(this, "查询全部数据==>" + userName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_insert:
                insertData();

                break;
            case R.id.btn_search:
                    query();
                break;
            case R.id.btn_all:
                queryData();
                break;
            case R.id.btn_update:
                    updateData();
                break;
            case R.id.btn_delete:
                dao.deleteAll();
                adapter.setData(dao.loadAll());
                break;
        }
    }
    class MyOnItemLongClickListener implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
            AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alerDialogBuilder.setPositiveButton("修改", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    updateData(i);
                    adapter.setData(dao.loadAll());
                    dialog.dismiss();

                }
            });
            alerDialogBuilder.setNegativeButton("删除", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    User listbox = listUser.get(i);
                    dao.delete(listbox);
                    Log.i("zhsy", "listsBox=" + listUser.toString());
                    adapter.setData(dao.loadAll());
                    dialog.dismiss();
                }
            });
            alerDialogBuilder.create();
            alerDialogBuilder.show();
            return false;

        }
    }
}
