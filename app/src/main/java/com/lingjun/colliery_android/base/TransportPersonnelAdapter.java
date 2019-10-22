package com.lingjun.colliery_android.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.SelectFileBean;
import com.lingjun.colliery_android.bean.TransportPersonnelBean;

import java.util.ArrayList;

/**
 * 作者: zengtao
 * 时间: 2019/3/11  9:27.
 * 注释:
 */
public class TransportPersonnelAdapter extends BaseExpandableListAdapter {
    private ArrayList<TransportPersonnelBean.DataBean.DepartmentResultBean> mArray;
    private Context context;

    public TransportPersonnelAdapter(Context context,ArrayList<TransportPersonnelBean.DataBean.DepartmentResultBean> mArray){
        this.context = context;
        this.mArray = mArray;
    }

    @Override
    public int getGroupCount() {
        return mArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mArray.get(groupPosition).getUserlist().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mArray.get(groupPosition).getUserlist().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


    //获取组view
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup){
        view = View.inflate(context, R.layout.item_select_personnel_group,null);
        TextView tv_group_name = view.findViewById(R.id.tv_group_title);
        tv_group_name.setText(mArray.get(groupPosition).getDepartmentName());
        return view;
    }

    //获取子view
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup){
        view = View.inflate(context, R.layout.item_select_personnel_child,null);
        TextView tv_child_name = view.findViewById(R.id.tv_child_title);
        CheckBox checkBox = view.findViewById(R.id.cbox);
        TransportPersonnelBean.DataBean.DepartmentResultBean.UserlistBean personnelBean = mArray.get(groupPosition).getUserlist().get(childPosition);
        checkBox.setChecked(personnelBean.isSelect());
        tv_child_name.setText(personnelBean.getName());
        return view;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
