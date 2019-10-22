package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.UpgradeAuditorActivity;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.tencent.mm.opensdk.utils.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 隐患升级（处理方案）
 */
public class HiddenDangerFourFragment extends BaseFragment {
    private TextView tv_fg_submission, tv_major;
    private RelativeLayout rl_hidden_danger_ntry;//隐患升级审核人
    private EditText et_major;
    private String taskid;
    private String bohui;
    private String upgrade;//隐患升级申请人返回的人名
    private String upgrade_id;//隐患升级申请人返回的人名ID
    private TextView tv_upgrade;//审核人
    private String bohuitaskId;
    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_hiddendangerfour;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        final Intent getIntent = getActivity().getIntent();
        taskid = getIntent.getStringExtra("task_id");
//        bohui=getIntent.getStringExtra("beibohui");
        tv_upgrade = mRootView.findViewById(R.id.tv_upgrade);
        rl_hidden_danger_ntry = mRootView.findViewById(R.id.rl_hidden_danger_ntry);
        tv_fg_submission = mRootView.findViewById(R.id.tv_fg_submission);
        tv_fg_submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //提交重大隐患理由
                if (TextUtils.isEmpty(et_major.getText().toString()) ||
                        TextUtils.isEmpty(upgrade)
                        ) {
                    Toast.makeText(getActivity(), "请输入升级理由选择审核人", Toast.LENGTH_SHORT).show();
                    return;
                }
                fg_submission();
            }
        });
        rl_hidden_danger_ntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), UpgradeAuditorActivity.class), UpgradeAuditorActivity.RectifyingCode);
            }
        });
        et_major = mRootView.findViewById(R.id.et_major);
        et_major.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tv_major.setText(String.valueOf(s.length()) + "/500");
                if (s.length() >= 50) {
                    Toast.makeText(getActivity(), "字数上限", Toast.LENGTH_SHORT);
                }

            }
        });
        tv_major = mRootView.findViewById(R.id.tv_major);
        bohuitaskId = getIntent.getStringExtra("bohuitaskId");
    }

    //提交重大隐患理由
    private void fg_submission() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(taskid)){
            hashMap.put("taskId", "" + taskid);//子任务ID
        } else if (!TextUtils.isEmpty(bohuitaskId)) {
            hashMap.put("taskId", "" + bohuitaskId);//子任务ID
        }
        hashMap.put("fatalReason", "" + et_major.getText().toString().trim());//升级隐患内容
        hashMap.put("id", "" + upgrade_id);
        hashMap.put("name", "" + upgrade);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.fg_four);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("重大隐患->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("提交成功!");
                    getActivity().finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case UpgradeAuditorActivity.RectifyingCode:
                if (data != null) {
                    upgrade_id = data.getStringExtra("upgrade_id");//审核人ID
                    upgrade = data.getStringExtra("upgrade");//审核人
                    tv_upgrade.setText(upgrade);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
