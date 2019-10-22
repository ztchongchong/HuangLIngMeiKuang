package com.lingjun.colliery_android.module.dealwith.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.CheckFileBean;
import com.lingjun.colliery_android.bean.EditionCataLogInListAPPBean;
import com.lingjun.colliery_android.bean.KeyWordBean;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.PhotoPopupManager;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cc.shinichi.library.ImagePreview;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者: zengtao
 * 时间: 2019/2/18  14:59.
 * 注释: 标准化 资料编辑
 */
public class DataEditingActivity extends BaseActivity {
    @BindView(R.id.et_data_name)//资料名称
            EditText etDataName;
    @BindView(R.id.et_data_number)//资料编号
            EditText etDataNumber;
    @BindView(R.id.et_standard_name)//规范名称
            EditText etStandardName;
    @BindView(R.id.tv_Keyword)//关键词
            TextView tvKeyword;
    @BindView(R.id.et_remarks)//备注
            EditText etRemarks;
    @BindView(R.id.rl_view)
    RecyclerView rlView;
    @BindView(R.id.ll_upload)//上传资料
            LinearLayout llUpload;
    @BindView(R.id.tv_preservation)//保存
            TextView tvPreservation;
    private EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean resultsBean;
    private ArrayList<EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean> results;
    private ArrayList<EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.EditionKeysNameBean> keyword;
    private ArrayList<String> id = new ArrayList<>();
    private AlertDialog dialog;
    private View dialogview;

    private ImageView delete;
    private TextView title;
    private EditText dialog_edit;
    private TextView tv_cancel;
    private TextView tv_comfirm;
    private String judge;
    private String newid;
    private ArrayList<String> keywordname = new ArrayList<>();

    protected int getResourcesId() {
        return R.layout.activity_dataediting;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        Intent intent = getIntent();
        judge = intent.getStringExtra("judge");
        newid = intent.getStringExtra("id");
        if (judge.equals("1")) {

        } else if (judge.equals("2")) {
            resultsBean = (EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean) getIntent().getSerializableExtra("bean");
            etDataName.setText(resultsBean.getName());
            etDataNumber.setText(resultsBean.getNumber());
            etStandardName.setText(resultsBean.getStdname());
            results = (ArrayList<EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean>) resultsBean.getFileData().getFileList();
            keyword = (ArrayList<EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.EditionKeysNameBean>) resultsBean.getEditionKeysName();

            Log.e("results==========>", results.size() + "");
            if (!TextUtils.isEmpty(keyword + "") && null != keyword) {
                for (int i = 0; i < keyword.size(); i++) {
                    keywordname.add(keyword.get(i).getName());

                    tvKeyword.setText(keywordname + "");


                }
            }
            RecyclerViewUtils.initLiner(DataEditingActivity.this, rlView, R.layout.item_dataediting, results, new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean listBean = (EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean) item;
                    TextView tv_name = helper.getView(R.id.tv_name);
                    ImageView iv_delete = helper.getView(R.id.iv_delete);
                    tv_name.setText(listBean.getSysFiles().getFilename());
                    helper.addOnClickListener(R.id.iv_delete);

                }

            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean listBean = (EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean) adapter.getData().get(position);
                }
            }, new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    //删除
                    adapter.remove(position);
                }
            });

        }

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @OnClick({R.id.iv_back, R.id.tv_Keyword, R.id.ll_upload, R.id.tv_preservation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_Keyword://关键词
                startActivityForResult(new Intent(DataEditingActivity.this, KeyWordActivity.class), KeyWordActivity.HiddenDangerCode);
                break;
            case R.id.ll_upload://上传资料
                upload();
                break;
            case R.id.tv_preservation://保存

                if (judge.equals("1")) {
                    if (!TextUtils.isEmpty(etDataName.getText().toString().trim()) &&
                            !TextUtils.isEmpty(etDataNumber.getText().toString().trim()) &&
                            !TextUtils.isEmpty(etStandardName.getText().toString().trim())) {
                        neweditor();
                    } else {
                        com.blankj.utilcode.util.ToastUtils.showShort("资料请填写全");
                        return;
                    }
                } else if (judge.equals("2")) {
                    if (!TextUtils.isEmpty(etDataName.getText().toString().trim()) &&
                            !TextUtils.isEmpty(etDataNumber.getText().toString().trim()) &&
                            !TextUtils.isEmpty(etStandardName.getText().toString().trim())) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(DataEditingActivity.this);
                        dialogview = View.inflate(DataEditingActivity.this, R.layout.alertdialog_implemented, null);
                        builder1.setView(dialogview);
                        builder1.setCancelable(true);

                        delete = dialogview.findViewById(R.id.iv_delete);//删除
                        title = dialogview.findViewById(R.id.title);//设置标题
                        title.setText("修改理由");
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
                                    preservation();
                                    dialog.dismiss();
                                } else {
                                    com.blankj.utilcode.util.ToastUtils.showShort("请输入理由!");
                                    return;
                                }
                            }
                        });
                        dialog = builder1.create();
                        dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                        dialog.show();
                        break;
                    } else {
                        com.blankj.utilcode.util.ToastUtils.showShort("资料请填写全");
                        return;
                    }
                }
        }
    }

    //上传新资料
    private void neweditor() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("editionName", etDataName.getText().toString().trim());//资料名称
        hashMap.put("editionStand", etStandardName.getText().toString().trim());//资料编号
        hashMap.put("editionCode", etDataNumber.getText().toString().trim());//规范名称
        hashMap.put("editionDescription", etRemarks.getText().toString().trim());//资料说明
        String symbol = imgList + "";
        String fileIds = symbol.replace(",", ";").replace("[", "").replace("]", "").replace(" ", "");
        String symbol1 = id + "";
        String keystr = symbol1.replace(",", ";").replace("[", "").replace("]", "").replace(" ", "");
        hashMap.put("fileIds", fileIds + "");//上传文件
        hashMap.put("keystr", keystr + "");//关键字
        hashMap.put("cataLogId", newid);//目录id
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.saveEdition);


        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                com.blankj.utilcode.util.ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("隐患->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    com.blankj.utilcode.util.ToastUtils.showShort("提交成功!");
                    DataEditingActivity.this.finish();
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    //编辑资料
    private void preservation() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("editionName", etDataName.getText().toString().trim());//资料名称
        hashMap.put("editionStand", etStandardName.getText().toString().trim());//资料编号
        hashMap.put("editionCode", etDataNumber.getText().toString().trim());//规范名称
        hashMap.put("editionDescription", etRemarks.getText().toString().trim());//资料说明
        StringBuffer sb = new StringBuffer();
        String fileIds = "";
        for (int i = 0; i < results.size(); i++) {
            sb.append(results.get(i).getSysFiles().getId()).append(";");
        }
        if (sb.length() != 0) {
            fileIds = sb.substring(0, sb.length() - 1);
        }
        hashMap.put("fileIds", fileIds);//上传文件
        if (!TextUtils.isEmpty(id + "")) {
            String symbol = id + "";
            String keystr = symbol.replace(",", ";").replace("[", "").replace("]", "").replace(" ", "");
            hashMap.put("keystr", keystr);//关键字
        } else {
            hashMap.put("keystr", "");//关键字
        }

        hashMap.put("editionId", resultsBean.getId() + "");//目录id
        if (!TextUtils.isEmpty(dialog_edit.getText().toString().trim())) {
            hashMap.put("editionRemark", dialog_edit.getText().toString().trim());//编辑原因
        } else {
            hashMap.put("editionRemark", "");//编辑原因
        }

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.updateEdition);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                com.blankj.utilcode.util.ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("隐患->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    com.blankj.utilcode.util.ToastUtils.showShort("提交成功!");
                    DataEditingActivity.this.finish();
                } else {
                    com.blankj.utilcode.util.ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });

    }

    private List<String> imgList = new ArrayList<>();
    private ArrayList<UpLoadImageBean.ResultMapsBean> imgUrlList = new ArrayList<>();

    private void upload() {
        ArrayList<UpLoadImageBean.ResultMapsBean> mArray = new ArrayList<>();
        final UpLoadImageBean.ResultMapsBean imgBean = new UpLoadImageBean.ResultMapsBean();
        imgBean.setCurCode(9999);
        mArray.add(imgBean);

        PhotoPopupManager.getInstance().showvideo(DataEditingActivity.this);
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

                            EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean bean = new EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean();
                            EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean.SysFilesBean bean1 = new EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean.SysFilesBean();

                            bean1.setId(uploadImageBean.getResultMaps().get(0).getFileId());
                            bean1.setFilename(uploadImageBean.getResultMaps().get(0).getFileName());
                            bean.setSysFiles(bean1);
                            if (results != null) {
                                results.add(bean);
                            } else {
                                results = new ArrayList<>();
                                results.add(bean);
                            }
                            if (imgList.size() > 0 && imgList != null) {
                                imgList.clear();
                            }
                            for (EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean s : results) {
                                imgList.add(s.getSysFiles().getId() + "");
                            }
//                            imgUrlList.add(uploadImageBean.getResultMaps().get(0));
//                            imgList.add(String.valueOf(uploadImageBean.getResultMaps().get(0).getFileId()));
                            RecyclerViewUtils.initLiner(DataEditingActivity.this, rlView, R.layout.item_dataediting, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean data = (EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean) item;

                                    TextView tv_name = helper.getView(R.id.tv_name);
                                    tv_name.setText(data.getSysFiles().getFilename());


//                                        Glide.with(DataEditingActivity.this).load(BaseLinkList.Base_Url+"?"+BaseLinkList.apiurl+"="+BaseLinkList.coal_mine+"/upload/"+data.getFileName()).into(iv_icon);

                                    helper.addOnClickListener(R.id.iv_delete);
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(final BaseQuickAdapter adapter, View view, final int position) {

                                    EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean data = (EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean) adapter.getData().get(position);
                                    ToastUtils.showToast(DataEditingActivity.this, data.getSysFiles().getFilename());
//                                    EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean data= ( EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean) adapter.getData().get(position);
//                                    ImagePreview
//                                            .getInstance()
//                                            // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
//                                            .setContext(DataEditingActivity.this)
//                                            // 有三种设置数据集合的方式，根据自己的需求进行选择：
//                                            // 第一步生成的imageInfo List
////                                          .setImageInfoList(imageInfoList)
//                                            // 直接传url List
//                                            .setImageList(Collections.singletonList(BaseLinkList.Base_Url+"?"+BaseLinkList.apiurl+"="+BaseLinkList.coal_mine+data.getSysFiles().getUri()))
//                                            // 只有一张图片的情况，可以直接传入这张图片的url
//                                            //.setImage(String image)
//                                            // 是否显示下载按钮，在页面右下角。默认显示
//                                            .setShowDownButton(false)
//                                            // 是否显示关闭页面按钮，在页面左下角。默认不显示
//                                            .setShowCloseButton(true)
//                                            // 开启预览
//                                            .start();
//                                    Log.e("黄泉买骨人",BaseLinkList.Base_Url+"?"+BaseLinkList.apiurl+"="+BaseLinkList.coal_mine+data.getSysFiles().getUri());
                                }
                            }, new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(final BaseQuickAdapter adapter, View view, final int position) {
//                                    //删除
//                                    adapter.remove(position);
                                    //删除
//                                    showLoadDialog();
                                    EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean img = (EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean) adapter.getData().get(position);
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("fileId", "" + img.getSysFiles().getId());
                                    hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getDeletePic);
                                    mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                                        @Override
                                        public void onError(ExceptionHandle.ResponeThrowable e) {
                                            com.blankj.utilcode.util.ToastUtils.showShort("删除失败,请保持网络通畅!");
//                                            dismissDialog();
                                        }

                                        @Override
                                        public void onSuccess(JSONObject jsonObject) throws JSONException {
                                            LogUtils.e("删除接口返回->>" + jsonObject.toString());
                                            JSONObject json = jsonObject.getJSONObject("data");
                                            boolean flag = json.getBoolean("flag");
                                            if (flag) {
                                                LogUtils.e("成功");
                                                ((BaseQuickAdapter) rlView.getAdapter()).remove(position);
                                                imgList.remove(position);
                                            } else {
                                                LogUtils.e("失败");
                                                com.blankj.utilcode.util.ToastUtils.showShort("删除失败,请保持网络通畅!");
                                            }
//                                            dismissDialog();
                                        }
                                    });
                                }
                            });
                        }

                        DataEditingActivity.this.dismissDialog();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        LogUtils.e("上传失败->>" + t.getMessage());
                        DataEditingActivity.this.dismissDialog();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case KeyWordActivity.HiddenDangerCode:
                Bundle bundle = data.getBundleExtra("bundle");
                KeyWordActivity.TestBean testBean = (KeyWordActivity.TestBean) bundle.getSerializable("keyword");
                ArrayList<KeyWordBean.DataBean.KeylistBean> keylistBeans = testBean.arrayList;
                ArrayList<String> name = new ArrayList<>();
                if (id.size() > 0 && id != null) {
                    id.clear();
                }
                for (int i = 0; i < keylistBeans.size(); i++) {
                    name.add(keylistBeans.get(i).getName());
                    id.add(keylistBeans.get(i).getId() + "");
                    tvKeyword.setText(name + "");
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
        PhotoPopupManager.getInstance().onActivityResulted(DataEditingActivity.this, requestCode, resultCode, data);
    }
}
