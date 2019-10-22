package com.lingjun.colliery_android.module.message;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
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
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.MainMessageBean;
import com.lingjun.colliery_android.bean.RiskAbnormalityBean;
import com.lingjun.colliery_android.bean.XiaoXiBean;
import com.lingjun.colliery_android.module.dealwith.activity.ImplementedActivity;
import com.lingjun.colliery_android.module.dealwith.fragment.DealWithTaskFragment;
import com.lingjun.colliery_android.module.document.activity.LoanApplicationActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.MessageEvent;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by nefa on 2018/10/18.
 */

public class MessageFragment extends BaseFragment {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.et_daiban)
    EditText etDaiban;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.ll_3)
    LinearLayout ll3;
    @BindView(R.id.ll_4)
    LinearLayout ll4;
    @BindView(R.id.ll_5)
    LinearLayout ll5;
    @BindView(R.id.ll_7)
    LinearLayout ll7;
    @BindView(R.id.ll_daiban)
    LinearLayout llDaiban;

    private RecyclerView rv_list;

    private TextView tv_message_title;

    private View dialogview;
    private AlertDialog dialog;

    private LinearLayout ll_toobar1, ll_toobar2, ll_cancel, ll_beijing;
    private RelativeLayout rl_daiban;
    private ArrayList<MainMessageBean.ResultMapsBean> mNewList = new ArrayList<>();
    private ArrayList<MainMessageBean.ResultMapsBean> resultMaps = new ArrayList<>();

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_message;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = mRootView.findViewById(R.id.rv_list);
        ll_toobar1 = mRootView.findViewById(R.id.ll_toobar1);
        ll_toobar2 = mRootView.findViewById(R.id.ll_toobar2);
        ll_cancel = mRootView.findViewById(R.id.ll_cancel);
        ll_beijing = mRootView.findViewById(R.id.ll_beijing);
        rl_daiban = mRootView.findViewById(R.id.rl_daiban);


        ll_toobar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_toobar1.setVisibility(View.GONE);
                ll_toobar2.setVisibility(View.VISIBLE);
                rl_daiban.setVisibility(View.GONE);
                llDaiban.setVisibility(View.VISIBLE);
            }
        });

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etDaiban.setText("");
            }
        });

        etDaiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_daiban.setVisibility(View.GONE);
                llDaiban.setVisibility(View.VISIBLE);
                etDaiban.setText("");
            }
        });

        etDaiban.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    //先隐藏键盘
                    DealWithTaskFragment.SoftKeyboardUtils.closeInoutDecorView(getActivity());
                    rl_daiban.setVisibility(View.VISIBLE);
                    llDaiban.setVisibility(View.GONE);
                    refreshView(null, etDaiban.getText().toString().trim());
                    etDaiban.setText("");

                }
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    if (etDaiban.getKeyListener().getInputType() == 0) {
                        return false;
                    }
                    return false;
                }
                return true;
            }
        });

        ll_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_daiban.setVisibility(View.VISIBLE);
                llDaiban.setVisibility(View.GONE);
                ll_toobar1.setVisibility(View.VISIBLE);
                ll_toobar2.setVisibility(View.GONE);
                refreshLayout.autoRefresh();
            }
        });

        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
                ll_beijing.setVisibility(View.GONE);
                refreshLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView(null, null);
            }

            @Override
            public void onRefresh() {
                refreshView(null, null);
            }
        };
    }

    //刷新
    private void refreshView(@Nullable String messageType, @Nullable String searchstr) {
        HashMap<String, String> hashMap = new HashMap<>();
        //是否有消息类型
        if (!TextUtils.isEmpty(messageType)) {
            hashMap.put("messageType", messageType);
        }
        //是否有关键字
        if (!TextUtils.isEmpty(searchstr)) {
            hashMap.put("searchstr", searchstr);
        }

        if (!TextUtils.isEmpty(messageType) || !TextUtils.isEmpty(searchstr)) {
            pageIndex = 1;
            hashMap.put("pageNum", "" + pageIndex);
            hashMap.put("pageSize", "500");
        } else {
            hashMap.put("pageSize", "10");
            hashMap.put("pageNum", "" + pageIndex);
        }
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getMessageList);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("消息->>" + jsonObject.toString());
                final MainMessageBean messageBean = FastJsonTools.getBean(jsonObject.toString(), MainMessageBean.class);
                if (null != messageBean && null != messageBean.getMsg() && null != messageBean.getData() && null != messageBean.getCode() && null != messageBean.getResultMaps()) {
                    xiaoxiuodate(messageBean.getResultMaps().size());
                    ll_beijing.setVisibility(View.GONE);
                    refreshLayout.setVisibility(View.VISIBLE);
                    if (pageIndex > 1) {
                        if (null != messageBean.getResultMaps() && messageBean.getResultMaps().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            resultMaps.addAll(messageBean.getResultMaps());
                            adapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (resultMaps.size() != 0) {
                            resultMaps.clear();
                        }
                        if (messageBean.getResultMaps().size() != 0) {
                            resultMaps.addAll(messageBean.getResultMaps());
                            RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_message, resultMaps, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    MainMessageBean.ResultMapsBean resultMapsBean = (MainMessageBean.ResultMapsBean) item;
                                    if (null != resultMapsBean) {
                                        tv_message_title = helper.getView(R.id.tv_message_title);
                                        TextView tv_message_content = helper.getView(R.id.tv_message_content);
                                        TextView tv_time = helper.getView(R.id.tv_time);
                                        ImageView iv_icon = helper.getView(R.id.iv_icon);

                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        Date date = new Date();
                                        date.setTime(resultMapsBean.getSend_time());
                                        String time = simpleDateFormat.format(date);

                                        tv_time.setText(time);
                                        tv_message_title.setText(resultMapsBean.getTitle());
                                        if (null != resultMapsBean.getContent() && !TextUtils.isEmpty(resultMapsBean.getContent())) {
                                            tv_message_content.setText(Html.fromHtml(resultMapsBean.getContent()));
                                        } else {
                                            tv_message_content.setText("你有一条消息，点击查看详情");
                                        }

                                        checkTaskTypeToView(resultMapsBean, iv_icon);
                                    }
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    MainMessageBean.ResultMapsBean resultsBean = (MainMessageBean.ResultMapsBean) adapter.getData().get(position);
                                    checkTaskType(resultsBean);
                                }
                            }, null);
                        } else {
                            ll_beijing.setVisibility(View.VISIBLE);
                            refreshLayout.setVisibility(View.GONE);
                        }
                    }
                }
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }
        });
    }

    private void xiaoxiuodate(int size) {
        int xiaoxi = size;
        EventBus.getDefault().postSticky(new XiaoXiBean(xiaoxi));
    }

    private void checkTaskTypeToView(MainMessageBean.ResultMapsBean resultMapsBean, ImageView iv_icon) {
        switch (resultMapsBean.getMessage_type()) {
            case 131:
                iv_icon.setImageResource(R.drawable.xiaoxi_jw_zrr);
                tv_message_title.setText("三违责任人通知");
                break;
            case 132:
                iv_icon.setImageResource(R.drawable.xiaoxi_jw_ld);
                tv_message_title.setText("三违领导通知");
                break;
            case 133:
                iv_icon.setImageResource(R.drawable.xiaoxi_jw_cs);
                tv_message_title.setText("三违超时通知");
                break;
            case 134:
                iv_icon.setImageResource(R.drawable.xiaoxi_jw_xh);
                tv_message_title.setText("三违销号通知");
                break;
            case 6:
                iv_icon.setImageResource(R.drawable.xiaoxi_zg);
                tv_message_title.setText("整改超时");
                break;
            case 7:
                iv_icon.setImageResource(R.drawable.xiaoxi_zg);
                tv_message_title.setText("整改超时");
                break;
            case 8:
                iv_icon.setImageResource(R.drawable.xiaoxi_zg);
                tv_message_title.setText("整改超时");
                break;
            case 0:
                iv_icon.setImageResource(R.drawable.xiaoxi_jy);
                tv_message_title.setText("借阅结果通知");
                break;
            case 151:
                iv_icon.setImageResource(R.drawable.xiaoxi_yctz);
                tv_message_title.setText("风险异常通知");
                break;
            case 16:
                iv_icon.setImageResource(R.drawable.xiaoxi_yctz);
                tv_message_title.setText("标准化检查");
                break;
            default:
        }
    }

    private void checkTaskType(MainMessageBean.ResultMapsBean resultsBean) {
        switch (resultsBean.getMessage_type()) {
            case 1://标准化检查
                break;
            case 131://三违(责任人通知)
                Intent intent = new Intent(getActivity(), PenaltySheetActivity.class);
                intent.putExtra("task_id", "" + resultsBean.getTask_id());
                intent.putExtra("message_type", "" + resultsBean.getMessage_type());
                startActivity(intent);
                updateMessageState("" + resultsBean.getId());
                break;
            case 132://三违(领导通知)
                Intent intent1 = new Intent(getActivity(), PenaltySheetActivity.class);
                intent1.putExtra("task_id", "" + resultsBean.getTask_id());
                intent1.putExtra("message_type", "" + resultsBean.getMessage_type());
                startActivity(intent1);
                updateMessageState("" + resultsBean.getId());
                break;
            case 133://三违(超时通知)
                Intent intent2 = new Intent(getActivity(), MessageActivity.class);
                intent2.putExtra("task_id", "" + resultsBean.getTask_id());
                intent2.putExtra("message_type", "3");
                startActivity(intent2);
                updateMessageState("" + resultsBean.getId());
                break;
            case 134://三违(销号通知)
                Intent intent3 = new Intent(getActivity(), MessageActivity.class);
                intent3.putExtra("task_id", "" + resultsBean.getTask_id());
                intent3.putExtra("message_type", "4");
                startActivity(intent3);
                updateMessageState("" + resultsBean.getId());
                break;
            case 6://整改超时 （包含限时整改和挂牌督办）
                Intent intent6 = new Intent(getActivity(), MessageActivity.class);
                intent6.putExtra("task_id", "" + resultsBean.getTask_id());
                intent6.putExtra("message_type", "6");
                startActivity(intent6);
                updateMessageState("" + resultsBean.getId());
                break;
            case 7://整改超时 (限时整改超时升级为挂牌督办)
                Intent intent7 = new Intent(getActivity(), MessageActivity.class);
                intent7.putExtra("task_id", "" + resultsBean.getTask_id());
                intent7.putExtra("message_type", "7");
                startActivity(intent7);
                updateMessageState("" + resultsBean.getId());
                break;
            case 8://整改超时 汇报通知--挂牌督办
                Intent intent8 = new Intent(getActivity(), MessageActivity.class);
                intent8.putExtra("task_id", "" + resultsBean.getTask_id());
                intent8.putExtra("message_type", "7");
                startActivity(intent8);
                updateMessageState("" + resultsBean.getId());
                break;
            case 0://借阅
                Intent intent0 = new Intent(getActivity(), LoanApplicationActivity.class);
                intent0.putExtra("task_id", "" + resultsBean.getTask_id());
                intent0.putExtra("message_type", "0");
                startActivity(intent0);
                updateMessageState("" + resultsBean.getId());
                break;
            case 151://风险异常
                Intent intent9 = new Intent(getActivity(), RiskAbnormalityActivity.class);
                intent9.putExtra("implementId", "" + resultsBean.getTask_id());
                startActivity(intent9);
                updateMessageState("" + resultsBean.getId());
                break;
            case 16:
                AlertDialog.Builder builder11 = new AlertDialog.Builder(getActivity());
                dialogview = View.inflate(getActivity(), R.layout.alertdialog_jurisdiction, null);
                builder11.setView(dialogview);
                builder11.setCancelable(true);
                TextView tv_content;
                TextView tv_comfirm;
                tv_content = dialogview.findViewById(R.id.tv_content);//
                tv_comfirm = dialogview.findViewById(R.id.tv_comfirm);//确定按钮

                tv_content.setText("你有一个标准化检查需要配合");

                tv_comfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        refreshLayout.autoRefresh();
                    }
                });
                dialog = builder11.create();
                dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                dialog.show();
                updateMessageState("" + resultsBean.getId());
                break;
            default:
        }
    }

    private void updateMessageState(String messageId) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageId", messageId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.updateMessageState);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("消息点开后消失->>" + jsonObject.toString());
            }
        });
    }

    @OnClick({R.id.ll_1, R.id.ll_2, R.id.ll_3, R.id.ll_4, R.id.ll_5, R.id.ll_7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_1://三违领导
                rl_daiban.setVisibility(View.VISIBLE);
                llDaiban.setVisibility(View.GONE);
                refreshView(132 + "", null);
                break;
            case R.id.ll_2://三违超时
                rl_daiban.setVisibility(View.VISIBLE);
                llDaiban.setVisibility(View.GONE);
                refreshView(133 + "", null);
                break;
            case R.id.ll_3://三违销号
                rl_daiban.setVisibility(View.VISIBLE);
                llDaiban.setVisibility(View.GONE);
                refreshView(134 + "", null);
                break;
            case R.id.ll_4:
                rl_daiban.setVisibility(View.VISIBLE);
                llDaiban.setVisibility(View.GONE);
                refreshView(6 + "", null);
                break;
            case R.id.ll_5:
                rl_daiban.setVisibility(View.VISIBLE);
                llDaiban.setVisibility(View.GONE);
                refreshView(131 + "", null);
                break;
            case R.id.ll_7:
                rl_daiban.setVisibility(View.VISIBLE);
                llDaiban.setVisibility(View.GONE);
                refreshView(151 + "", null);
                break;
            default:
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshLayout.autoRefresh();
    }
}
