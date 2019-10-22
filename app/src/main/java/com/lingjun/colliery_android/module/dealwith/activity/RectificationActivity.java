package com.lingjun.colliery_android.module.dealwith.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.Result;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.PhotoPopupManager;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.shinichi.library.ImagePreview;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者: lihuan
 * 时间: 2018/11/22 10:40
 * 说明: 整改、验收
 */
public class RectificationActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_back)
    ImageView tvBack;
    @BindView(R.id.et_scheme_content)
    EditText etSchemeContent;
    @BindView(R.id.tv_upload)
    TextView tvUpload;
    @BindView(R.id.tv_head)
    TextView tvHead;
    @BindView(R.id.rv_related_file)
    RecyclerView rvRelatedFile;
    @BindView(R.id.btn_reject)
    Button btnReject;
    @BindView(R.id.btn_pass)
    Button btnPass;

    private int type = 0; //0表示整改 1表示验收
    private String taskId = ""; //任务id
    private String clauseMeasures;
    private String acceptreason;//验收多人迭代
    private TextView tv_iteration;

    private UserBeans.UserBean bean;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_rectification;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        bean = UserBeans.getInstance().getUser();
        tv_iteration = findViewById(R.id.tv_iteration);
        taskId = getIntent().getStringExtra("taskId");
        type = getIntent().getIntExtra("type", 0);
        clauseMeasures = getIntent().getStringExtra("clauseMeasures");
        acceptreason = getIntent().getStringExtra("acceptreason");
        if (type == 1) {
            tvHead.setText("验收说明");
            tvName.setText("验收");
            btnPass.setText("验收完成");
            btnReject.setVisibility(View.VISIBLE);
            btnReject.setText("驳回");
            if (acceptreason != null) {
                tv_iteration.setText(acceptreason);
            }
        } else {
            tvHead.setText("整改说明");
            tvName.setText("整改");
            btnPass.setText("整改完成");
            btnReject.setVisibility(View.GONE);
            tv_iteration.setVisibility(View.GONE);
        }

    }

    @OnClick(R.id.tv_back)
    public void onTvBackClicked() {
        finish();
    }

    @OnClick(R.id.btn_reject)
    public void onBtnRejectClicked() { //驳回
        String reason = etSchemeContent.getText().toString().trim();
        if (StringUtils.isEmpty(reason)) {
            ToastUtils.showShort("请输入驳回理由");
            return;
        }
        showLoadDialog();
        getTODOAcceptRefuseButton(taskId, reason);
    }

    @OnClick(R.id.btn_pass)
    public void onBtnPassClicked() { //整改完成 或者 验收完成

        String reason = etSchemeContent.getText().toString().trim();
        if (type == 0) {// 整改完成
            if (StringUtils.isEmpty(reason)) {
                ToastUtils.showShort("请输入整改依据");
                return;
            }
            showLoadDialog();
            rectifyIngButton(taskId, reason);
        } else { //验收完成
            if (StringUtils.isEmpty(reason)) {
                ToastUtils.showShort("请输入验收依据");
                return;
            }
            showLoadDialog();
            if (acceptreason == null) {
                String acceptreason = "";
                getTODOAcceptContentButton(taskId, acceptreason + "," + bean.getName() + ":" + reason);
            } else {
                getTODOAcceptContentButton(taskId, acceptreason + "," + bean.getName() + ":" + reason);
            }

        }
    }

    /**
     * 待办-->验收驳回
     */
    private void getTODOAcceptRefuseButton(String taskId, String reason) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("refuseReason", reason);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTODOAcceptRefuseButton);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("驳回->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    finish();
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                }
            }
        });
    }

    /**
     * 待办-->验收完成
     */
    private void getTODOAcceptContentButton(String taskId, String reason) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("acceptContent", reason);
        hashMap.put("savesState", "2");
        hashMap.put("acceptFileIdStr", (imgList.toString().substring(1, imgList.toString().length() - 1)).replace(" ", ""));
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTODOAcceptContentButton);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("验收完成->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                    finish();
                }
            }
        });
    }

    /**
     * 待办-->整改完成
     */
    private void rectifyIngButton(String taskId, String reason) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("solutionContent", reason);
        hashMap.put("rectifyFileIdStr", (imgList.toString().substring(1, imgList.toString().length() - 1)).replace(" ", ""));
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.rectifyIngButton);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("整改完成->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                    finish();
                }
            }
        });
    }


    private List<String> imgList = new ArrayList<>();
    private ArrayList<UpLoadImageBean.ResultMapsBean> imgUrlList = new ArrayList<>();

    @OnClick(R.id.tv_upload)
    public void onViewClicked() { //上传附件
        ArrayList<UpLoadImageBean.ResultMapsBean> mArray = new ArrayList<>();
        UpLoadImageBean.ResultMapsBean imgBean = new UpLoadImageBean.ResultMapsBean();
        imgBean.setCurCode(9999);
        mArray.add(imgBean);

        PhotoPopupManager.getInstance().show(RectificationActivity.this);
        PhotoPopupManager.getInstance().setOnPhotoSelectedListener(new PhotoPopupManager.OnPhotoSelectedListener() {
            @Override
            public void onPhotoSelected(String photoPath, int callBack_location) {
                //返回path
                LogUtils.e("返回Path:" + photoPath);
                if (TextUtils.isEmpty(photoPath)) {
                    return;
                }

                File file = new File(photoPath);
                showLoadDialog();
                HashMap<String, File> params = new HashMap<>();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getUpload);
                params.put("image", file);
                mRetrofit.upload(BaseLinkList.Base_Url, new HashMap<String, String>(), params, new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String str = "";
                        try {
                            str = new String(response.body().bytes());
                            LogUtils.e("上传成功->>" + str);
                        } catch (IOException e) {
                            e.printStackTrace();
                            LogUtils.e("转换出错->>" + e.getMessage());
                            return;
                        }

                        UpLoadImageBean uploadImageBean = FastJsonTools.getBean(str, UpLoadImageBean.class);
                        if (null != uploadImageBean.getResultMaps() && uploadImageBean.getResultMaps().size() != 0) {
                            imgUrlList.add(uploadImageBean.getResultMaps().get(0));
                            imgList.add(String.valueOf(uploadImageBean.getResultMaps().get(0).getFileId()));
                            RecyclerViewUtils.initGridNoSc(RectificationActivity.this, rvRelatedFile, R.layout.item_image, imgUrlList, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    UpLoadImageBean.ResultMapsBean data = (UpLoadImageBean.ResultMapsBean) item;
                                    ImageView iv_icon = helper.getView(R.id.iv_icon);
                                    TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                                    ImageView iv_delete = helper.getView(R.id.iv_delete);

                                    if (TextUtils.isEmpty(data.getUrl())) {
                                        tv_jiahao.setVisibility(View.VISIBLE);
                                        iv_delete.setVisibility(View.GONE);
                                    } else {
                                        tv_jiahao.setVisibility(View.GONE);
                                        Glide.with(RectificationActivity.this).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + "/upload/" + data.getFileName()).into(iv_icon);
                                        Log.e("黄泉买骨人", BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + "/upload/" + data.getFileName());
                                        iv_delete.setVisibility(View.VISIBLE);
                                    }

                                    helper.addOnClickListener(R.id.iv_delete);
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(final BaseQuickAdapter adapter, View view, final int position) {
                                    UpLoadImageBean.ResultMapsBean resultMapsBean = (UpLoadImageBean.ResultMapsBean) adapter.getData().get(position);
                                    ImagePreview
                                            .getInstance()
                                            // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                                            .setContext(RectificationActivity.this)
                                            // 有三种设置数据集合的方式，根据自己的需求进行选择：
                                            // 第一步生成的imageInfo List
//                                          .setImageInfoList(imageInfoList)
                                            // 直接传url List
                                            .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + "/upload/" + resultMapsBean.getFileName()))
                                            // 只有一张图片的情况，可以直接传入这张图片的url
                                            //.setImage(String image)
                                            // 是否显示下载按钮，在页面右下角。默认显示
                                            .setShowDownButton(false)
                                            // 是否显示关闭页面按钮，在页面左下角。默认不显示
                                            .setShowCloseButton(true)
                                            // 开启预览
                                            .start();
                                }
                            }, 4, new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(final BaseQuickAdapter adapter, View view, final int position) {
                                    //删除
                                    showLoadDialog();
                                    UpLoadImageBean.ResultMapsBean img = (UpLoadImageBean.ResultMapsBean) adapter.getData().get(position);
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("fileId", "" + img.getFileId());
                                    hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getDeletePic);
                                    mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                                        @Override
                                        public void onError(ExceptionHandle.ResponeThrowable e) {
                                            ToastUtils.showShort("删除失败,请保持网络通畅!");
                                            dismissDialog();
                                        }

                                        @Override
                                        public void onSuccess(JSONObject jsonObject) throws JSONException {
                                            LogUtils.e("删除接口返回->>" + jsonObject.toString());
                                            JSONObject json = jsonObject.getJSONObject("data");
                                            boolean flag = json.getBoolean("flag");
                                            if (flag) {
                                                LogUtils.e("成功");
                                                ((BaseQuickAdapter) rvRelatedFile.getAdapter()).remove(position);
                                                imgList.remove(position);
                                            } else {
                                                LogUtils.e("失败");
                                                ToastUtils.showShort("删除失败,请保持网络通畅!");
                                            }
                                            dismissDialog();
                                        }
                                    });
                                }
                            });
                        }

                        RectificationActivity.this.dismissDialog();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        LogUtils.e("上传失败->>" + t.getMessage());
                        RectificationActivity.this.dismissDialog();
                    }
                });
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoPopupManager.getInstance().onActivityResulted(this, requestCode, resultCode, data);
    }
}
