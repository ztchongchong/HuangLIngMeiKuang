package com.lingjun.colliery_android.module.siyuanliangzhang;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.bean.SylzCheckBean;
import com.necer.calendar.BaseCalendar;
import com.necer.calendar.MonthCalendar;
import com.necer.listener.OnCalendarChangedListener;
import com.necer.painter.InnerPainter;
import org.joda.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: ztcc
 * @Data： 2019/9/23 17:05
 * Describe:四员两长考核详情列表
 */
public class SylzCheckListActivity extends BaseActivity implements SylzlistInterface {
    @BindView(R.id.rlview)
    RecyclerView rlview;
    @BindView(R.id.tv_month)
    TextView tvMonth;
    @BindView(R.id.mclr)
    MonthCalendar mclr;
    @BindView(R.id.tv_shangxun)
    TextView tvShangxun;
    @BindView(R.id.tv_zhongxun)
    TextView tvZhongxun;
    @BindView(R.id.tv_xiaxun)
    TextView tvXiaxun;
    private SylzCheckListAdapter adapter;
    private ArrayList<SylzCheckBean> list = new ArrayList<>();


    @Override
    protected int getResourcesId() {
        return R.layout.activity_sylzchecklist;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月");
        Calendar c = Calendar.getInstance();
        String time = format.format(c.getTime());
        tvMonth.setText(time);
        String[] title = {"考勤", "上岗前精神状态及着装问题", "菜单填写", "出清数量", "培训学习"};
        String[] banci = {"零", "一", "二", "三", "四"};
        String[] koufen = {"1", "2", "3", "4", "5"};
        String[] denfen = {"6", "7", "8", "9", "10"};
        String[] shuoming = {"一血", "二杀", "三杀", "四杀", "五杀"};


        for (int i = 0; i < title.length; i++) {
            SylzCheckBean bean = new SylzCheckBean();
            bean.setTitle(title[i]);
            bean.setBanci(banci[i]);
            bean.setKoufen(koufen[i]);
            bean.setDefen(denfen[i]);
            bean.setShuoming(shuoming[i]);
            list.add(bean);
        }

        mclr.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarChange(BaseCalendar baseCalendar, int year, int month, LocalDate localDate) {
                int nian = year;
                int yue = month;
                LocalDate time = localDate;
                Log.e("测试时间", nian + "年" + yue + "月" + time + "什么鬼");
            }
        });
        List<String> pointList = Arrays.asList("2019-10-26", "2019-10-27", "2019-10-28", "2019-10-29", "2019-10-30");
        InnerPainter innerPainter = (InnerPainter) mclr.getCalendarPainter();
        innerPainter.setPointList(pointList);
        rlview.setNestedScrollingEnabled(false);
        adapter = new SylzCheckListAdapter(SylzCheckListActivity.this, R.layout.item_sylzcheck, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SylzCheckListActivity.this);
        linearLayoutManager.setAutoMeasureEnabled(true);
        rlview.setLayoutManager(linearLayoutManager);
        rlview.setAdapter(adapter);


    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @Override
    public void pingfen(int pos, int state) {

    }

    @Override
    public void koufen(int pos, int state) {

    }

    @Override
    public void shuoming(int pos, int state) {

    }


    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.tv_shangxun, R.id.tv_zhongxun, R.id.tv_xiaxun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_shangxun:
                tvShangxun.setTextColor(Color.parseColor("#2196F3"));
                tvZhongxun.setTextColor(Color.parseColor("#FFFFFF"));
                tvXiaxun.setTextColor(Color.parseColor("#FFFFFF"));
                tvShangxun.setBackgroundResource(R.drawable.early_days);
                tvZhongxun.setBackgroundResource(R.drawable.mid1);
                tvXiaxun.setBackgroundResource(R.drawable.last_ten_days1);
                break;
            case R.id.tv_zhongxun:
                tvShangxun.setTextColor(Color.parseColor("#FFFFFF"));
                tvZhongxun.setTextColor(Color.parseColor("#2196F3"));
                tvXiaxun.setTextColor(Color.parseColor("#FFFFFF"));
                tvShangxun.setBackgroundResource(R.drawable.early_days1);
                tvZhongxun.setBackgroundResource(R.drawable.mid);
                tvXiaxun.setBackgroundResource(R.drawable.last_ten_days1);
                break;
            case R.id.tv_xiaxun:
                tvShangxun.setTextColor(Color.parseColor("#FFFFFF"));
                tvZhongxun.setTextColor(Color.parseColor("#FFFFFF"));
                tvXiaxun.setTextColor(Color.parseColor("#2196F3"));
                tvShangxun.setBackgroundResource(R.drawable.early_days1);
                tvZhongxun.setBackgroundResource(R.drawable.mid1);
                tvXiaxun.setBackgroundResource(R.drawable.last_ten_days);
                break;
        }
    }
}
