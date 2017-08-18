package com.example.zhangshuyang01.greendaodemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhangshuyang01.greendaodemo2.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshuyang01 on 2017/8/17 0017.
 */

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<User> users;
    public UserAdapter(Context context, List<User> users){
        this.context = context;
        if(users ==null){
            users = new ArrayList<User>();
        }
        this.users = users;
    }
    public void addData(User datas ){
        this.users.add(datas);
        notifyDataSetChanged();
    }
    public void setData(List<User> data) {
        if (data != null) {
            users.clear();
            users.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView ==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            holder.name = (TextView)convertView.findViewById(R.id.tv_name);
            holder.age = (TextView)convertView.findViewById(R.id.tv_age);
            holder.sex = (TextView)convertView.findViewById(R.id.tv_sex);
            holder.salary = (TextView)convertView.findViewById(R.id.tv_salary);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        if(users !=null) {
            User data = users.get(i);
            holder.name.setText(data.getName());
            holder.age.setText(data.getAge() + "");
            holder.sex.setText(data.getSex());
            holder.salary.setText(data.getSalary());
        }
        return convertView;
    }
    class ViewHolder{
        TextView name,age,sex,salary;

    }
}
