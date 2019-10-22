package com.lingjun.colliery_android.module.my;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.SelectFileBean;
import com.lingjun.colliery_android.utils.ToastUtils;

import java.util.ArrayList;

/**
 * 作者: zengtao
 * 时间: 2019/3/12  11:24.
 * 注释:
 */
public class PersonalFoldersAdapter extends BaseExpandableListAdapter {
    private ArrayList<SelectFileBean.ResultMapsBean> mArray;
    private Context context;

    public PersonalFoldersAdapter(Context context, ArrayList<SelectFileBean.ResultMapsBean> mArray) {
        this.context = context;
        this.mArray = mArray;
    }

    //返回一级列表的个数
    @Override
    public int getGroupCount() {
        return mArray.size();
    }

    //返回每个二级列表的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return mArray.get(groupPosition).getFileList().size();
    }

    //返回一级列表的单个item（返回的是对象）
    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    //返回二级列表中的单个item（返回的是对象）
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

    //每个item的id是否是固定？一般为true
    @Override
    public boolean hasStableIds() {
        return true;
    }

    //【重要】填充一级列表
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_personal_folders, null);
        TextView tv_group_name = view.findViewById(R.id.tv_group_title);
        if (null == mArray) {
            tv_group_name.setText("无文件夹");
        } else {
            tv_group_name.setText(mArray.get(groupPosition).getPrivatefolderName());
        }
        return view;
    }

    //【重要】填充二级列表
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_personal_folders_child, null);
        TextView tv_child_name = view.findViewById(R.id.tv_child_title);
        ImageView iv_download = view.findViewById(R.id.iv_download);
        final SelectFileBean.ResultMapsBean.FileListBean personnelBean = mArray.get(groupPosition).getFileList().get(childPosition);
        tv_child_name.setText(personnelBean.getFilename());
        iv_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast(context, "" + personnelBean.getFilename());
            }
        });
        return view;
    }
    //二级列表中的item是否能够被选中？可以改为true
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
