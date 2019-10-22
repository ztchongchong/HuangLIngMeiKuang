package com.lingjun.colliery_android.module.siyuanliangzhang;


import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.SylzCheckBean;
import java.util.List;

/**
 * @author: ztcc
 * @Data： 2019/9/24 14:57
 * Describe:
 */
public class SylzCheckListAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private Context mcontext;
    private View dialogview;
    private AlertDialog dialog;

    public SylzCheckListAdapter(Context context, int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
        this.mcontext = context;
    }

    public SylzCheckListAdapter(@Nullable List<T> data) {
        super(data);
    }

    public SylzCheckListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, final T item) {
        final SylzCheckBean bean = (SylzCheckBean) item;
        //项目内容
        TextView tv_title = helper.getView(R.id.tv_title);
        tv_title.setText(bean.getTitle());
        //评分方法
        TextView tv_comment = helper.getView(R.id.tv_comment);
        //班次
        RelativeLayout rl_banci = helper.getView(R.id.rl_banci);
        TextView tv_banci = helper.getView(R.id.tv_banci);
        tv_banci.setText(bean.getBanci());
        //扣分
        RelativeLayout rl_koufen = helper.getView(R.id.rl_koufen);
        EditText et_koufen = helper.getView(R.id.et_koufen);
        et_koufen.setText(bean.getKoufen());
        //得分
        TextView tv_defen = helper.getView(R.id.tv_defen);
        tv_defen.setText(bean.getDefen());
        //说明
        TextView et_shuoming = helper.getView(R.id.et_shuoming);
        et_shuoming.setText(bean.getShuoming());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tv_comment:
                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        dialogview = View.inflate(mcontext, R.layout.alertdialog_score, null);
                        builder.setView(dialogview);
                        builder.setCancelable(true);
                        TextView score_content = dialogview.findViewById(R.id.score_content);
                        LinearLayout ll_iknow = dialogview.findViewById(R.id.ll_iknow);
                        ll_iknow.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog = builder.create();
                        dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                        dialog.show();
                        break;
                    case R.id.rl_banci:
                        com.blankj.utilcode.util.ToastUtils.showLong("班次");
                        break;
                }
            }
        };
        tv_comment.setOnClickListener(listener);
        rl_banci.setOnClickListener(listener);
        rl_koufen.setOnClickListener(listener);
    }
}
