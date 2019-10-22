package com.lingjun.colliery_android.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.UserBean;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerContentActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.TransportPersonnelActivity;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 文件传输
 * Created by nefa on 2018/10/22.
 */
public class FileTransferActivity extends BaseActivity {

    private TextView tv_username;//发送人
    private TextView tv_time;//当前时间
    private TextView tv_transfer_type;//传输类型
    private CardView cv_select_object;//选择接收人
    private CardView cv_select_file;//选择要发送的文件
    private EditText et_text;//备注
    private TextView tv_count;//输入的文字数量
    private Button bt_shenyue;//审阅
    private ImageView iv_back;//返回
    private TextView tv_file;
    private TextView tv_people;

    private String privatefolderName;
    private String filename;
    private String fileId;
    private String userid;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_file_transfer;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_username = findViewById(R.id.tv_username);
        tv_time = findViewById(R.id.tv_time);
//        tv_transfer_type = findViewById(R.id.tv_transfer_type);
        cv_select_object = findViewById(R.id.cv_select_object);
        cv_select_file = findViewById(R.id.cv_select_file);
        et_text = findViewById(R.id.et_text);
        tv_count = findViewById(R.id.tv_count);
        bt_shenyue = findViewById(R.id.bt_shenyue);
        iv_back = findViewById(R.id.iv_back);
        tv_file = findViewById(R.id.tv_file);
        tv_people = findViewById(R.id.tv_people);

        UserBeans.UserBean dataBean = UserBeans.getInstance().getUser();
        tv_username.setText(dataBean.getName());
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        tv_time.setText(format.format(date));

        et_text.addTextChangedListener(new TextWatcher() {
            //输入前
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //输入中
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(charSequence)) {
                    tv_count.setText("0/500");
                } else {
                    int length = charSequence.length();
                    tv_count.setText(length + "/500");
                }
            }

            //输入后
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //选择接收人
        cv_select_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(FileTransferActivity.this, SelectPersonnelActivity.class);
//                intent.putExtra("type", "0");
//                intent.putExtra("jumpCode", 1);
//                startActivityForResult(intent, SelectPersonnelActivity.RectifyingCode);
                startActivityForResult(new Intent(FileTransferActivity.this, TransportPersonnelActivity.class), TransportPersonnelActivity.RectifyingCode);
            }
        });

        //选择文件
        cv_select_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(FileTransferActivity.this, SelectFileActivity.class), SelectFileActivity.RectifyingCode);
            }
        });
        bt_shenyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null == fileId) {
                    com.blankj.utilcode.util.ToastUtils.showShort("无文件!");
                } else {
                    refreshView();
                }
            }
        });
    }

    private void refreshView() {
        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();
        String newuserid = userid.replace("[", "").replace("]", "").replace(" ", "");
        hashMap.put("userIdstr", newuserid + "");//接收人ID
        hashMap.put("fileId", fileId + "");//文件ID
        hashMap.put("remark", "" + et_text.getText().toString().trim());//备注说明
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.filetransferButton);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
                com.blankj.utilcode.util.ToastUtils.showShort("传输失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                dismissDialog();
                LogUtils.e("隐患->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    com.blankj.utilcode.util.ToastUtils.showShort("传输成功!");
                    FileTransferActivity.this.finish();
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SelectFileActivity.RectifyingCode:
                if (null != data) {
                    filename = data.getStringExtra("filename");
                    fileId = data.getStringExtra("id");
                    tv_file.setText(filename);
                } else {
                    tv_file.setText("无文件");
                }
                break;
            case TransportPersonnelActivity.RectifyingCode:
                if (null != data) {
                    userid = data.getStringExtra("userid");
                    String name = data.getStringExtra("name");
                    String id = name.replace("[", "").replace("]", "").replace(" ", "");
                    tv_people.setText(id);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
