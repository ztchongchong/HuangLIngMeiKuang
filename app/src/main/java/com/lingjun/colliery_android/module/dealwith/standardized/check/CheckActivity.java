package com.lingjun.colliery_android.module.dealwith.standardized.check;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.ResultBean;
import com.lingjun.colliery_android.bean.ToCheckBean;
import com.lingjun.colliery_android.module.dealwith.activity.DivideWorkActivity;
import com.lingjun.colliery_android.module.dealwith.adapter.ToBeCheckAdapter;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 检查Activity
 * Created by nefa on 2018/11/2.
 */

public class CheckActivity extends BaseActivity {

    private LinearLayout ll_button;
    private RecyclerView rv_list;
    private String taskid;
    private List<ToCheckBean.DataBean.PageBean.ParamsBean.ItemlistBean> list = new ArrayList<>();
    private ToBeCheckAdapter adapter;
    private List<ToCheckBean.DataBean.PageBean.ParamsBean.ItemlistBean> datalist = new ArrayList<>();
    private List<JSONObject> upList = new ArrayList<>();
    private Dialog dialog;
    private Button btn_through;
    private Button btn_rejected;
    private Button btn_temporary_storage;
    private int page = 1;

    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_creatorname;
    private TextView tv_createtime;
    private TextView tv_modifytime;

    private ArrayList<CheckActivityBean> checkActivityBeanArrayList = new ArrayList<>();
    private ArrayList<StdcheckTipBean.ResultMapsBean> stlist = new ArrayList<>();
    private String jianfen;
    private String defen;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_check;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        rv_list = findViewById(R.id.rv_list);
        ll_button = findViewById(R.id.ll_button);
        btn_through = findViewById(R.id.btn_through);
        btn_rejected = findViewById(R.id.btn_rejected);
        btn_temporary_storage = findViewById(R.id.btn_temporary_storage);
        tv_title = findViewById(R.id.tv_title);
        tv_content = findViewById(R.id.tv_content);
        tv_creatorname = findViewById(R.id.tv_creatorname);
        tv_createtime = findViewById(R.id.tv_createtime);
        tv_modifytime = findViewById(R.id.tv_modifytime);
        initAdapter();
        refreshView();
    }

    private void initAdapter() {
        adapter = new ToBeCheckAdapter(R.layout.item_check_entry);
        rv_list.setLayoutManager(new LinearLayoutManager(CheckActivity.this));
        rv_list.setAdapter(adapter);
        rv_list.setNestedScrollingEnabled(false);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.setClass(CheckActivity.this, DivideWorkActivity.class);
                intent.putExtra("pos", position);
                intent.putExtra("zongfen", list.get(position).getScore());
//                if (list.get(position).getType() == 0) {
//                    intent.putExtra("defen", list.get(position).getScore());
//                } else {
//                    intent.putExtra("defen", list.get(position).getResultscore());
//                }
                intent.putExtra("jianfen", list.get(position).getResultscore());
                intent.putExtra("defen", list.get(position).getScore() - list.get(position).getResultscore());
                Log.d("zf1111", list.get(position).getScore() + "," + list.get(position).getResultscore());
                intent.putExtra("taskid", list.get(position).getTaskId() + "");
                intent.putExtra("title", list.get(position).getSerialno() + list.get(position).getCategoryname());
                intent.putExtra("itemid", list.get(position).getItemId() + "");
                startActivityForResult(intent, 1);
            }
        });
        btn_through.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setdata();
            }
        });
        btn_rejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshView();
                upList.clear();
            }
        });
        btn_temporary_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Temporarystorage();
            }
        });
    }

    private void setdata() {
        try {
            List<JSONObject> uplists = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                JSONObject bean = new JSONObject();
                bean.put("taskid", list.get(i).getTaskId());
                bean.put("jian", list.get(i).getResultscore());
                bean.put("remarks", list.get(i).getResultremark() + "");
                bean.put("categoryname", list.get(i).getCategoryname() + "");
                if (list.get(i).isSetState()) {
                    bean.put("flag", "1");
                } else {
                    bean.put("flag", "0");
                }
                Log.d("adada", "adada");
                uplists.add(bean);
            }
            Log.d("size", uplists.size() + "");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("projectList", uplists.toString());
            hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.GetStdcheckTip);
            Log.d("map", hashMap.toString());
            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                @Override
                public void onError(ExceptionHandle.ResponeThrowable e) {
                    dismissDialog();

                }

                @Override
                public void onSuccess(JSONObject jsonObject) throws JSONException {
                    Log.d("json", jsonObject.toString());
                    StdcheckTipBean stdcheckTipBean = FastJsonTools.getBean(jsonObject.toString(), StdcheckTipBean.class);
                    stlist = stdcheckTipBean.getResultMaps();
                    showdeldialog(CheckActivity.this, stlist);
                }
            });
        } catch (Exception e) {
            dismissDialog();
        }
    }

    /**
     * 暂存接口
     */
    private void Temporarystorage() {
        try {
            for (int i = 0; i < list.size(); i++) {
                JSONObject bean = new JSONObject();
                bean.put("taskid", list.get(i).getTaskId());
//                if (list.get(i).getType() == 0) {
//                    bean.put("jian", 0 + "");
//                } else {
//                    bean.put("jian", String.valueOf(list.get(i).getScore() - list.get(i).getResultscore()));
//                }
//                bean.put("jian", String.valueOf(list.get(i).getScore() - list.get(i).getResultscore()));
                bean.put("jian", list.get(i).getResultscore());
                bean.put("remarks", list.get(i).getResultremark() + "");
                Log.d("adada", "adada");
                upList.add(bean);
            }
            Log.d("size", upList.size() + "");
            Temporarystoragetask(upList);
        } catch (Exception e) {
            dismissDialog();
        }
    }

    private void Temporarystoragetask(List<JSONObject> upList) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectList", upList.toString());
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.savecheck);
        Log.d("map", hashMap.toString());
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json", jsonObject.toString());
                ResultBean bean = FastJsonTools.getBean(jsonObject.toString(), ResultBean.class);
                dismissDialog();
                if (null != bean) {
                    ToastUtils.showShort("暂存成功");
                    finish();
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
//        return new BaseRefreshLoadMoreInterface() {
//            @Override
//            public void onLoadMore() {
//                page++;
//                refreshView();
//            }
//
//            @Override
//            public void onRefresh() {
//                page = 1;
//                refreshView();
//            }
//        };
        return null;
    }

    private void refreshView() {
        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("page", page + "");
        hashMap.put("pageSize", "500");
        hashMap.put("taskid", taskid);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETSTADCHK);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                dismissDialog();
                Log.d("json", jsonObject.toString());
                ToCheckBean bean = FastJsonTools.getBean(jsonObject.toString(), ToCheckBean.class);
                tv_title.setText(bean.getData().getPage().getParams().getTitle());
                tv_content.setText(bean.getData().getPage().getParams().getDescription());
                tv_creatorname.setText(bean.getData().getPage().getParams().getCreator());
                String createtime = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(bean.getData().getPage().getParams().getCreatetime()));
                tv_createtime.setText(createtime);
                String modifytime = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(bean.getData().getPage().getParams().getFinishtime()));
                tv_modifytime.setText("期限:" + modifytime);
                if (page == 1) {
                    if (null != bean) {
                        if (list.size() != 0) {
                            list.clear();
                        }
                        if (bean.getData().getPage().getParams().getItemlist().size() != 0) {
                            list = bean.getData().getPage().getParams().getItemlist();
                        } else {
                            ToastUtils.showShort("暂无数据");
                        }
                        datalist = list;
                        adapter.setNewData(list);
                    }
                } else {
                    if (null != bean) {
                        if (bean.getData().getPage().getParams().getItemlist().size() != 0) {
                            list.addAll(bean.getData().getPage().getParams().getItemlist());
                            adapter.setNewData(list);
                        } else {
                            ToastUtils.showShort("没有查到新的数据");
                        }
                    }
                }

                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });

        ll_button.setVisibility(View.VISIBLE);
        if (null != refreshLayout) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            switch (requestCode) {
                case 1:
                    switch (resultCode) {
                        case 1:
                            int pos = data.getIntExtra("pos", -1);
                            list.get(pos).setResultremark(data.getStringExtra("liyou"));
                            list.get(pos).setResultscore(Integer.valueOf(data.getStringExtra("jianfen")));
                            list.get(pos).setType(1);
                            list.get(pos).setSetState(true);
                            adapter.notifyItemChanged(pos);

                            String name = data.getStringExtra("name");
                            jianfen = data.getStringExtra("jianfen");
                            defen = data.getStringExtra("defen");
                            for (int i = 0; i < checkActivityBeanArrayList.size(); i++) {
                                if (checkActivityBeanArrayList.get(i).getName().contains(name)) {
                                    checkActivityBeanArrayList.remove(checkActivityBeanArrayList.get(i));
                                }
                            }
                            CheckActivityBean checkActivityBean = new CheckActivityBean();
                            checkActivityBean.setName(name);
                            checkActivityBean.setJianfen(jianfen);
                            checkActivityBeanArrayList.add(checkActivityBean);
//                        list.get(pos).setResultscore(Integer.valueOf(jianfen));
//                        adapter.notifyItemChanged(pos);
                            break;
                        default:
                    }
                    break;
                default:
            }
        }
    }


    private void showdeldialog(Context context, ArrayList<StdcheckTipBean.ResultMapsBean> stlist) {
        if (dialog == null) {
            dialog = new Dialog(context, R.style.dialog);
        }
        dialog.getWindow().setContentView(R.layout.dialog_submit_result);
        dialog.setCanceledOnTouchOutside(true);
        RecyclerView rl_view = dialog.findViewById(R.id.rl_view);
        RecyclerViewUtils.initLiner(this, rl_view, R.layout.item_checkactivity_submission, stlist, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                StdcheckTipBean.ResultMapsBean checkActivityBean = (StdcheckTipBean.ResultMapsBean) item;
                TextView tv_name = helper.getView(R.id.tv_name);
                TextView tv_jianfen = helper.getView(R.id.tv_jianfen);
                tv_name.setText(checkActivityBean.getCateName() + "专业：");
                tv_jianfen.setText("总扣分:" + checkActivityBean.getResultscore() + "分" + ",扣分后得分" + checkActivityBean.getCateScore() + "分");

            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {


            }
        }, null);
        TextView title = dialog.findViewById(R.id.title);
        TextView confirm = dialog.findViewById(R.id.confirm);
        TextView cancel = dialog.findViewById(R.id.cancel);
        title.setText("是否提交检查结果");
        if (!dialog.isShowing()) {
            dialog.show();
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogs) {
                dialog = null;
            }
        });

        //提交确定
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                showLoadDialog();
                try {
                    List<JSONObject> lists = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {

                        JSONObject bean = new JSONObject();
                        bean.put("taskid", list.get(i).getTaskId());
                        bean.put("jian", list.get(i).getResultscore());
                        bean.put("remarks", list.get(i).getResultremark() + "");
                        Log.d("adada", "adada");
                        lists.add(bean);

                    }
                    Log.d("size", lists.size() + "");
                    CommedCheckTask(lists);
                } catch (Exception e) {
                    dismissDialog();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void CommedCheckTask(List<JSONObject> upList) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectList", upList.toString());
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_SUBMITCHECK);
        Log.d("map", hashMap.toString());
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json", jsonObject.toString());
                ResultBean bean = FastJsonTools.getBean(jsonObject.toString(), ResultBean.class);
                dismissDialog();
                if (null != bean) {
                    ToastUtils.showShort("提交成功");
                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (list.size() != 0) {
            list.clear();
            list = null;
        }
    }

    public class CheckActivityBean {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJianfen() {
            return jianfen;
        }

        public void setJianfen(String jianfen) {
            this.jianfen = jianfen;
        }

        private String name;
        private String jianfen;
    }

    @lombok.NoArgsConstructor
    @lombok.Data
    public static final class StdcheckTipBean {

        /**
         * msg : 成功
         * code : 200
         * data : null
         * resultMaps : [{"cateScore":"100.0","resultscore":0,"id":"1","cateName":"安全风险分级管控"}]
         */

        private String msg;
        private String code;
        private Object data;
        private ArrayList<ResultMapsBean> resultMaps;

        @lombok.NoArgsConstructor
        @lombok.Data
        public static final class ResultMapsBean {
            /**
             * cateScore : 100.0
             * resultscore : 0.0
             * id : 1
             * cateName : 安全风险分级管控
             */

            private String cateScore;
            private double resultscore;
            private String id;
            private String cateName;
        }
    }

}
