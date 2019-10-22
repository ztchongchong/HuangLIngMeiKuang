package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.AmendmentPenaltyBean;
import com.lingjun.colliery_android.bean.HiddenDangerPositionBean;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.CustomInputActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerContentActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPositionActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerRegionActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.PreviewViolationInformationActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: zengtao
 * 时间: 2019/5/23  11:39.
 * 注释:三违修改处罚
 */
public class AmendmentPenaltyActivity extends BaseActivity {
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.tv_cancel)//取消
            TextView tvCancel;
    @BindView(R.id.tv_sure)//确定
            TextView tvSure;
    private String id;
    private TextView tv_name;
    private String clauseid;
    private ArrayList<AmendmentPenaltyBean.DataBean.TaskclauselistBean> results;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_amendmentpenalty;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        id = getIntent().getStringExtra("id");

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView();
            }

            @Override
            public void onRefresh() {
                refreshView();
            }
        };
    }

    private void refreshView() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeymodifylevelinit);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final AmendmentPenaltyBean amendmentPenaltyBean = FastJsonTools.getBean(jsonObject.toString(), AmendmentPenaltyBean.class);
                if (null != amendmentPenaltyBean && null != amendmentPenaltyBean.getMsg() && null != amendmentPenaltyBean.getCode() && null != amendmentPenaltyBean.getData()) {

                    JSONArray array = new JSONArray();
                    for (int i = 0; i < amendmentPenaltyBean.getData().getTaskclauselist().size(); i++) {
                        array.put(amendmentPenaltyBean.getData().getTaskclauselist().get(i).getId());
                    }
                    final String id = array.toString();
                    clauseid = id.substring(1, id.length() - 1);

                    refreshLayout.setVisibility(View.VISIBLE);
                    results = amendmentPenaltyBean.getData().getTaskclauselist();
                    RecyclerViewUtils.initLiner(AmendmentPenaltyActivity.this, rvList, R.layout.item_amendmentpenalty, results, new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            AmendmentPenaltyBean.DataBean.TaskclauselistBean taskclauselistBean = (AmendmentPenaltyBean.DataBean.TaskclauselistBean) item;
                            TextView tv_tab = helper.getView(R.id.tv_tab);
                            tv_name = helper.getView(R.id.tv_name);
                            tv_name.setText(taskclauselistBean.getLevelName());
                            for (int i = 0; i < results.size(); i++) {
                                        tv_tab.setText("不安全行为"+(helper.getAdapterPosition()+1));
                            }
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            AmendmentPenaltyBean.DataBean.TaskclauselistBean taskclauselistBean = (AmendmentPenaltyBean.DataBean.TaskclauselistBean) adapter.getData().get(position);

//                            startActivityForResult(new Intent(AmendmentPenaltyActivity.this, AmendmentPenaltyItemActivity.class), AmendmentPenaltyItemActivity.HiddenDangerCode);
                            Intent intent = new Intent(AmendmentPenaltyActivity.this, AmendmentPenaltyItemActivity.class);
                            intent.putExtra("position", position);
                            intent.putExtra("unsafeid", taskclauselistBean.getId() + "");
                            startActivityForResult(intent, AmendmentPenaltyItemActivity.HiddenDangerCode);


                        }
                    }, null);
                } else {
                    refreshLayout.setVisibility(View.GONE);

                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    @OnClick({R.id.tv_cancel, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.tv_sure:
                submission();
                break;
        }
    }

    //提交
    private void submission() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("clauseid", clauseid);
        if (results.size() != 0) {
            for (int i = 0; i < results.size(); i++) {
                hashMap.put("levelId" + results.get(i).getId(), results.get(i).getLevelId() + "");
                if (results.get(i).getLevelId()==1) {
                    hashMap.put("levelName" + results.get(i).getId(), "轻微");
                } else if (results.get(i).getLevelId()==2) {
                    hashMap.put("levelName" + results.get(i).getId(), "一般");
                } else {
                    hashMap.put("levelName" + results.get(i).getId(), "重大");
                }

            }
        }
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeymodifylevel);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("三违申诉返回->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("提交成功!");
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                    finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case AmendmentPenaltyItemActivity.HiddenDangerCode:
                //带回数据
                if (null != data) {
                    data.getStringExtra("levelId");
                    Log.e("levelId=====>", data.getStringExtra("levelId"));
                    data.getStringExtra("unsafeid");
                    Log.e("unsafeid=====>", data.getStringExtra("unsafeid"));
                    data.getStringExtra("position");
                    int pos = data.getIntExtra("position",-1);
                    results.get(pos).setLevelId(Integer.parseInt(data.getStringExtra("levelId")));

                    if (data.getStringExtra("levelId").equals("1")) {
                        results.get(pos).setLevelName("轻微");
                    } else if (data.getStringExtra("levelId").equals("2")) {
                        results.get(pos).setLevelName("一般");
                    } else if (data.getStringExtra("levelId").equals("3")) {
                        results.get(pos).setLevelName("重大");
                    }

                    rvList.getAdapter().notifyItemChanged(pos);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
