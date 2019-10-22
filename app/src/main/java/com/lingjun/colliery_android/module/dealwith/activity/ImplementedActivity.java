package com.lingjun.colliery_android.module.dealwith.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.ImplementedBean;
import com.lingjun.colliery_android.bean.BureauLeaderBean;
import com.lingjun.colliery_android.bean.MineLeadershipBean;
import com.lingjun.colliery_android.module.dealwith.fragment.ControlRequirementsFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.ControlSituationFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2018/12/4  16:03.
 * 注释: 管控落实
 */
public class ImplementedActivity extends BaseActivity implements View.OnClickListener {
    public static String[] tabTitle = new String[2];
    private NoScrollViewpager vp_content;
    private TabLayout tb_title;
    private String taskId;
    private TextView tv_unqualified;//不合格
    private TextView tv_qualified;//合格
    private TextView tv_riskreporting;//风险上报
    private TextView tv_submission;//提交并转入隐患
    private LinearLayout ll_bottom_button;

    private ImageView delete;
    private TextView title;
    private EditText dialog_edit;
    private TextView tv_cancel;
    private TextView tv_comfirm;
    private TextView tv_direct;

    private View dialogview;
    private AlertDialog dialog;

    private CheckBox checkBox;

    private int measuresId = 0;
    private ArrayList<String> bureauleaderidlist = new ArrayList<>();
    private ArrayList<String> bureauleadernamelist = new ArrayList<>();
    private ArrayList<String> mineLeadershipidlist = new ArrayList<>();
    private ArrayList<String> mineLeadershipnamelist = new ArrayList<>();

    private RecyclerView rl_view;
    private int leadertype = 0;

    private ArrayList<BureauLeaderBean.DataBean.ResultsBean> bureaulist = new ArrayList<>();
    private ArrayList<MineLeadershipBean.DataBean.UserpageBean.ResultsBean> minelist = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_implemented;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        vp_content = findViewById(R.id.vp_content);
        tb_title = findViewById(R.id.tb_title);
        tv_unqualified = findViewById(R.id.tv_unqualified);
        tv_qualified = findViewById(R.id.tv_qualified);
        tv_riskreporting = findViewById(R.id.tv_riskreporting);
        tv_submission = findViewById(R.id.tv_submission);
        ll_bottom_button = findViewById(R.id.ll_bottom_button);
        tv_direct = findViewById(R.id.tv_direct);
        tv_unqualified.setOnClickListener(this);
        tv_qualified.setOnClickListener(this);
        tv_riskreporting.setOnClickListener(this);
        tv_submission.setOnClickListener(this);
        tv_direct.setOnClickListener(this);
        taskId = getIntent().getStringExtra("taskId");
        refreshView();


    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("taskId", "" + taskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.risktodotask);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("风险管控->>" + jsonObject.toString());
                final ImplementedBean implementedBean = FastJsonTools.getBean(jsonObject.toString(), ImplementedBean.class);
                if (implementedBean.getData() != null && implementedBean != null) {
                    tabTitle[0] = "管控要求";
                    tabTitle[1] = "现场情况";

                    measuresId = implementedBean.getData().getRiskcontrolTrouble().getId();
                    ArrayList<Fragment> mList = new ArrayList<>();
                    ControlRequirementsFragment controlRequirementsFragment = ControlRequirementsFragment.newInstance(implementedBean);
                    ControlSituationFragment controlSituationFragment = ControlSituationFragment.newInstance(implementedBean);

                    mList.add(controlRequirementsFragment);
                    mList.add(controlSituationFragment);

                    CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
                    vp_content.setAdapter(adapter);
                    tb_title.setupWithViewPager(vp_content);
                    tb_title.setTabMode(TabLayout.MODE_FIXED);
                    vp_content.setScroll(false);
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
//        if (leadertype == 0) {
//            return new BaseRefreshLoadMoreInterface() {
//                @Override
//                public void onLoadMore() {
//                    BureauLeader();
//                }
//
//                @Override
//                public void onRefresh() {
//                    BureauLeader();
//                }
//            };
//        } else {
//            return new BaseRefreshLoadMoreInterface() {
//                @Override
//                public void onLoadMore() {
//                    MineLeadership();
//                }
//
//                @Override
//                public void onRefresh() {
//                    MineLeadership();
//                }
//            };
//        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_unqualified: //不合格
                ll_bottom_button.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_qualified://合格
                AlertDialog.Builder builder11 = new AlertDialog.Builder(ImplementedActivity.this);
                dialogview = View.inflate(ImplementedActivity.this, R.layout.alertdialog_implemented, null);
                builder11.setView(dialogview);
                builder11.setCancelable(true);
                delete = dialogview.findViewById(R.id.iv_delete);//删除
                title = dialogview.findViewById(R.id.title);//设置标题
                title.setText("合格");
                dialog_edit = dialogview.findViewById(R.id.dialog_edit);//输入内容
                tv_cancel = dialogview.findViewById(R.id.tv_cancel);//取消按钮
                tv_comfirm = dialogview.findViewById(R.id.tv_comfirm);//确定按钮
                //取消或确定按钮监听事件处理
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_comfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(dialog_edit.getText().toString().trim())) {
                            qualified();
                            dialog.dismiss();
                        } else {
                            ToastUtils.showShort("请输入理由!");
                            return;
                        }
                    }
                });
                dialog = builder11.create();
                dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                dialog.show();
                break;
            case R.id.tv_riskreporting://风险上报
                AlertDialog.Builder builder12 = new AlertDialog.Builder(ImplementedActivity.this);
                dialogview = View.inflate(ImplementedActivity.this, R.layout.alertdialog_leadership_choice, null);
                builder12.setView(dialogview);
                builder12.setCancelable(true);
                rl_view = dialogview.findViewById(R.id.rl_view);
                final RelativeLayout rl_bureau = dialogview.findViewById(R.id.rl_bureau);//局领导
                final RelativeLayout rl_mine = dialogview.findViewById(R.id.rl_mine);//局领导
                final TextView bureau = dialogview.findViewById(R.id.bureau);//局领导
                final TextView mine = dialogview.findViewById(R.id.mine);//矿领导

                BureauLeader();
                bureau.setTextColor(ImplementedActivity.this.getColor(R.color.bule));
                //局领导
                rl_bureau.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bureaulist.clear();
                        minelist.clear();
                        leadertype = 0;
                        bureau.setTextColor(ImplementedActivity.this.getColor(R.color.bule));
                        mine.setTextColor(ImplementedActivity.this.getColor(R.color.black));
                        BureauLeader();
                    }
                });
                //矿领导
                rl_mine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bureaulist.clear();
                        minelist.clear();
                        leadertype = 1;
                        bureau.setTextColor(ImplementedActivity.this.getColor(R.color.black));
                        mine.setTextColor(ImplementedActivity.this.getColor(R.color.bule));
                        MineLeadership();
                    }
                });
                //取消按钮
                tv_cancel = dialogview.findViewById(R.id.tv_cancel);
                //提交按钮
                tv_comfirm = dialogview.findViewById(R.id.tv_comfirm);
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_comfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (leadertype == 0) {
                            if (bureauleaderidlist.size() == 0) {
                                ToastUtils.showShort("最少选择一个局领导!");
                                return;
                            }
                        } else {
                            if (mineLeadershipidlist.size() == 0) {
                                ToastUtils.showShort("最少选择一个矿领导!");
                                return;
                            }
                        }
                        unqualified(2);
                        LeadershipChoice(leadertype);
                        dialog.dismiss();
                    }
                });
                dialog = builder12.create();
                dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                dialog.show();
                break;
            case R.id.tv_submission://提交并转入隐患
                AlertDialog.Builder builder13 = new AlertDialog.Builder(ImplementedActivity.this);
                dialogview = View.inflate(ImplementedActivity.this, R.layout.alertdialog_submission, null);
                builder13.setView(dialogview);
                builder13.setCancelable(true);
                tv_cancel = dialogview.findViewById(R.id.tv_cancel);//取消按钮
                tv_comfirm = dialogview.findViewById(R.id.tv_comfirm);//提交按钮
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_comfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        unqualified(3);
                        dialog.dismiss();
                    }
                });
                dialog = builder13.create();
                dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                dialog.show();
                break;
            case R.id.tv_direct:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ImplementedActivity.this);
                dialogview = View.inflate(ImplementedActivity.this, R.layout.alertdialog_implemented, null);
                builder1.setView(dialogview);
                builder1.setCancelable(true);

                delete = dialogview.findViewById(R.id.iv_delete);//删除
                title = dialogview.findViewById(R.id.title);//设置标题
                title.setText("不合格");
                dialog_edit = dialogview.findViewById(R.id.dialog_edit);//输入内容
                tv_cancel = dialogview.findViewById(R.id.tv_cancel);//取消按钮
                tv_comfirm = dialogview.findViewById(R.id.tv_comfirm);//确定按钮
                //取消或确定按钮监听事件处理
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_comfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(dialog_edit.getText().toString().trim())) {
                            unqualified(1);
                            dialog.dismiss();
                        } else {
                            ToastUtils.showShort("请输入理由!");
                            return;
                        }
                    }
                });
                dialog = builder1.create();
                dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                dialog.show();
                break;
            default:
        }
    }

    String id = "";
    String name = "";

    //上报矿领导or局领导
    private void LeadershipChoice(final int leadertype) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("implementId", "" + taskId);//任务id
//        JSONArray array = new JSONArray();
//        if (leadertype == 0) {
//            for (int i = 1; i < bureauleaderidlist.size(); i++) {
//                array.put(bureauleaderidlist.get(i));
//            }
//        } else {
//            for (int i = 1; i < mineLeadershipidlist.size(); i++) {
//                array.put(mineLeadershipidlist.get(i));
//            }
//        }
//        String id = array.toString().substring(1, array.toString().length() - 1);
//        JSONArray array1 = new JSONArray();
//        if (leadertype == 0) {
//            for (int i = 1; i < bureauleadernamelist.size(); i++) {
//                array1.put(bureauleadernamelist.get(i));
//            }
//        } else {
//            for (int i = 1; i < mineLeadershipnamelist.size(); i++) {
//                array1.put(mineLeadershipnamelist.get(i));
//            }
//        }
//        String name = array1.toString().substring(1, array1.toString().length() - 1);
        if (leadertype == 0) {
            id = String.valueOf(bureauleaderidlist).replace("[", "").replace("]", "").replace(" ", "");
            name = String.valueOf(bureauleadernamelist).replace("[", "").replace("]", "").replace(" ", "");
        } else {
            id = String.valueOf(mineLeadershipidlist).replace("[", "").replace("]", "").replace(" ", "");
            name = String.valueOf(mineLeadershipnamelist).replace("[", "").replace("]", "").replace(" ", "");
        }
        hashMap.put("userIdStr", "" + id);//措施ID
        hashMap.put("userNameStr", "" + name);//措施名称
        hashMap.put("indextype", "" + leadertype);//0局领导 1矿领导
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getRiskMeasses);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("上报领导提交->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("提交成功!");
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    //不合格
    private void unqualified(final int type) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", "" + taskId);//任务id
        hashMap.put("measuresId", "" + measuresId);//措施ID
        hashMap.put("implementState", "2");//落实状态 1合格 2不合格
        if (type == 1) {
            hashMap.put("implementRemark", "" + dialog_edit.getText().toString().trim());//合格月何不合格的理由
        } else {
            hashMap.put("implementRemark", "");//合格月何不合格的理由
        }
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.submitriskbutton);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("不合格->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    if (type == 1) {//不合格
                        ToastUtils.showShort("提交成功!");
                        finish();
                    } else if (type == 2) {//风险上报
                        ToastUtils.showShort("提交成功!");
                    } else if (type == 3) {//提交并转入隐患
                        ToastUtils.showShort("提交成功!");
                        startActivity(new Intent(ImplementedActivity.this, HiddenDangerNtryActivity.class));
                        finish();
                    }

                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    //合格
    private void qualified() {
        HashMap<String, String> hashMap = new HashMap<>();
        //任务id
        hashMap.put("taskId", "" + taskId);
        //措施ID
        hashMap.put("measuresId", "" + measuresId);
        //落实状态 1合格 2不合格
        hashMap.put("implementState", "1");
        //合格月何不合格的理由
        hashMap.put("implementRemark", "" + dialog_edit.getText().toString().trim());
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.submitriskbutton);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("合格->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("提交成功!");
                    finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    //局领导
    private void BureauLeader() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", pageIndex + "");
        hashMap.put("pageSize", "20");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getCoalLeaderApp);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("领导->>" + jsonObject.toString());
                final BureauLeaderBean leadershipChoiceBean = FastJsonTools.getBean(jsonObject.toString(), BureauLeaderBean.class);
                if (null != leadershipChoiceBean.getData() && null != leadershipChoiceBean.getCode() && null != leadershipChoiceBean.getMsg()) {
                    bureaulist = leadershipChoiceBean.getData().getResults();
                    RecyclerViewUtils.initLiner(ImplementedActivity.this, rl_view, R.layout.item_punish, bureaulist, new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            BureauLeaderBean.DataBean.ResultsBean resultsBean = (BureauLeaderBean.DataBean.ResultsBean) item;
                            checkBox = helper.getView(R.id.tv_name);
                            checkBox.setText(resultsBean.getName());
                            checkBox.setChecked(resultsBean.isType());
                            helper.addOnClickListener(R.id.tv_name);

                            if (resultsBean.isType()) {
                                bureauleaderidlist.add(resultsBean.getId() + "");
                                bureauleadernamelist.add(resultsBean.getName());
                            } else if (!resultsBean.isType()) {
                                bureauleaderidlist.remove(resultsBean.getId() + "");
                                bureauleadernamelist.remove(resultsBean.getName());
                            }
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                        }
                    }, new BaseQuickAdapter.OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                            if (((BureauLeaderBean.DataBean.ResultsBean) adapter.getData().get(position)).isType()) {
                                ((BureauLeaderBean.DataBean.ResultsBean) adapter.getData().get(position)).setType(false);
                            } else {
                                ((BureauLeaderBean.DataBean.ResultsBean) adapter.getData().get(position)).setType(true);
                            }
                            adapter.notifyItemChanged(position);
                        }
                    });

                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    //矿领导
    private void MineLeadership() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", pageIndex + "");
        hashMap.put("pageSize", "20");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getMineLeaderApp);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("领导->>" + jsonObject.toString());
                final MineLeadershipBean mineLeadershipBean = FastJsonTools.getBean(jsonObject.toString(), MineLeadershipBean.class);
                if (null != mineLeadershipBean.getData() && null != mineLeadershipBean.getCode() && null != mineLeadershipBean.getMsg()) {
                    minelist = mineLeadershipBean.getData().getUserpage().getResults();
                    RecyclerViewUtils.initLiner(ImplementedActivity.this, rl_view, R.layout.item_punish, minelist, new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            MineLeadershipBean.DataBean.UserpageBean.ResultsBean resultsBean = (MineLeadershipBean.DataBean.UserpageBean.ResultsBean) item;
                            checkBox = helper.getView(R.id.tv_name);
                            checkBox.setText(resultsBean.getName());
                            checkBox.setChecked(resultsBean.isType());
                            helper.addOnClickListener(R.id.tv_name);

                            if (resultsBean.isType()) {
                                mineLeadershipidlist.add(resultsBean.getUserid() + "");
                                mineLeadershipnamelist.add(resultsBean.getName() + "");
                            } else if (!resultsBean.isType()) {
                                mineLeadershipidlist.remove(resultsBean.getUserid() + "");
                                mineLeadershipnamelist.remove(resultsBean.getName() + "");
                            }
                            Log.e("mingzi", mineLeadershipnamelist + "");
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                        }
                    }, new BaseQuickAdapter.OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                            if (((MineLeadershipBean.DataBean.UserpageBean.ResultsBean) adapter.getData().get(position)).isType()) {
                                ((MineLeadershipBean.DataBean.UserpageBean.ResultsBean) adapter.getData().get(position)).setType(false);
                            } else {
                                ((MineLeadershipBean.DataBean.UserpageBean.ResultsBean) adapter.getData().get(position)).setType(true);
                            }
                            adapter.notifyItemChanged(position);
                        }
                    });

                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });


    }

    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;

        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return ImplementedActivity.tabTitle[position];
        }
    }
}
