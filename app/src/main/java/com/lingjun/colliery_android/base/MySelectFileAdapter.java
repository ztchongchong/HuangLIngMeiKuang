package com.lingjun.colliery_android.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.ResponsibleBean;
import com.lingjun.colliery_android.bean.SelectFileBean;

import java.util.ArrayList;

/**
 * 作者: zengtao
 * 时间: 2019/3/4  10:05.
 * 注释:
 */
public class MySelectFileAdapter extends BaseExpandableListAdapter {
    private ArrayList<SelectFileBean.ResultMapsBean> mArray;
    private Context context;

    public MySelectFileAdapter(Context context, ArrayList<SelectFileBean.ResultMapsBean> mArray) {
        this.context = context;
        this.mArray = mArray;
    }

    @Override
    public int getGroupCount() {
        return mArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mArray.get(groupPosition).getFileList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mArray.get(groupPosition).getFileList().get(childPosition);
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
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_select_personnel_group, null);
        TextView tv_group_name = view.findViewById(R.id.tv_group_title);
        if (null==mArray) {
            tv_group_name.setText("无文件夹");
        } else {
            tv_group_name.setText(mArray.get(groupPosition).getPrivatefolderName());
        }
        return view;
    }

    //获取子view
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_select_personnel_child, null);
        TextView tv_child_name = view.findViewById(R.id.tv_child_title);
        CheckBox checkBox = view.findViewById(R.id.cbox);
        SelectFileBean.ResultMapsBean.FileListBean personnelBean = mArray.get(groupPosition).getFileList().get(childPosition);
        checkBox.setChecked(personnelBean.isSelect());
        tv_child_name.setText(personnelBean.getFilename());
        return view;
    }


    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
