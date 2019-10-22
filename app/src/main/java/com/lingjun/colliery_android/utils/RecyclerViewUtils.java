package com.lingjun.colliery_android.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lingjun.colliery_android.base.GlobalAdapter;
import com.lingjun.colliery_android.base.OnGlobalListener;
import java.util.ArrayList;
import java.util.List;
import me.majiajie.pagerbottomtabstrip.NavigationController;

/**
 * Created by nefa on 2017/12/27.
 */

public class RecyclerViewUtils {

    public static <T> LinearLayoutManager initLiner(Context context, RecyclerView recyclerView, int resId, ArrayList<T> mList, OnGlobalListener onGlobalListener, @Nullable BaseQuickAdapter.OnItemClickListener onItemClickListener, @Nullable BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener){
        GlobalAdapter adapter = new GlobalAdapter(resId, mList, onGlobalListener);
        if (null != onItemClickListener){
            adapter.setOnItemClickListener(onItemClickListener);
        }
        LinearLayoutManager liner = new LinearLayoutManager(context);
        liner.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(liner);
        if (null != onItemChildClickListener){
            adapter.setOnItemChildClickListener(onItemChildClickListener);
        }
        recyclerView.setAdapter(adapter);
        return liner;
    }

    public static <T> GlobalAdapter initLinerToAdapter(Context context, RecyclerView recyclerView, int resId, ArrayList<T> mList, OnGlobalListener onGlobalListener, @Nullable BaseQuickAdapter.OnItemClickListener onItemClickListener, @Nullable BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener){
        GlobalAdapter adapter = new GlobalAdapter(resId, mList, onGlobalListener);
        if (null != onItemClickListener){
            adapter.setOnItemClickListener(onItemClickListener);
        }
        LinearLayoutManager liner = new LinearLayoutManager(context);
        liner.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(liner);
        if (null != onItemChildClickListener){
            adapter.setOnItemChildClickListener(onItemChildClickListener);
        }
        recyclerView.setAdapter(adapter);
        return adapter;
    }

    public static <T> GlobalAdapter initLinerNoSc(Context context, RecyclerView recyclerView, int resId, ArrayList<T> mList, OnGlobalListener onGlobalListener, @Nullable BaseQuickAdapter.OnItemClickListener onItemClickListener, @Nullable BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener){
        GlobalAdapter adapter = new GlobalAdapter(resId, mList, onGlobalListener);
        if (null != onItemClickListener){
            adapter.setOnItemClickListener(onItemClickListener);
        }
        LinearLayoutManager liner = new LinearLayoutManager(context){
            public boolean canScrollVertically() {
                return false;
            }
        };
        liner.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(liner);
        if (null != onItemChildClickListener){
            adapter.setOnItemChildClickListener(onItemChildClickListener);
        }
        recyclerView.setAdapter(adapter);
        return adapter;
    }

    public static <T> void initLinerNoScTofooter(Context context, RecyclerView recyclerView, int resId, ArrayList<T> mList, OnGlobalListener onGlobalListener, @Nullable BaseQuickAdapter.OnItemClickListener onItemClickListener, View footerView){
        GlobalAdapter adapter = new GlobalAdapter(resId, mList, onGlobalListener);
        adapter.setFooterView(footerView);
        if (null != onItemClickListener){
            adapter.setOnItemClickListener(onItemClickListener);
        }
        LinearLayoutManager liner = new LinearLayoutManager(context){
            public boolean canScrollVertically() {
                return false;
            }
        };
        liner.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(liner);
        recyclerView.setAdapter(adapter);

    }

    public static <T> void initGrid(Context context, RecyclerView recyclerView, int resId, ArrayList<T> mList, OnGlobalListener onGlobalListener, @Nullable BaseQuickAdapter.OnItemClickListener onItemClickListener, int spanCount){
        int spacing = 20;
        boolean includeEdge = true;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,spanCount);
        gridLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        GlobalAdapter adapter = new GlobalAdapter(resId,mList,onGlobalListener);
        if (null != onItemClickListener){
            adapter.setOnItemClickListener(onItemClickListener);
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setFocusable(false);
    }

    public static <T> GlobalAdapter initGridNoSc(Context context, RecyclerView recyclerView, int resId, ArrayList<T> mList, OnGlobalListener onGlobalListener, @Nullable BaseQuickAdapter.OnItemClickListener onItemClickListener, int spanCount, BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener){
        int spacing = 35;
        boolean includeEdge = true;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,spanCount){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        gridLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        GlobalAdapter adapter = new GlobalAdapter(resId,mList,onGlobalListener);
        if (null != onItemClickListener){
            adapter.setOnItemClickListener(onItemClickListener);
        }

        if (null != onItemChildClickListener){
            adapter.setOnItemChildClickListener(onItemChildClickListener);
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setFocusable(false);
        return adapter;
    }


    public static void initFtagmentViewPager(ViewPager viewPager, List<Fragment> fragments, FragmentManager fm, NavigationController mNavigationController){
        viewPager.setAdapter(new PagerTabAdapter(fm,fragments));
        mNavigationController.setupWithViewPager(viewPager);
    }

    public static PagerTabAdapter initFtagmentViewPagerNoBottom(ViewPager viewPager, List<Fragment> fragments, FragmentManager fm){
        PagerTabAdapter adapter = new PagerTabAdapter(fm,fragments);
        viewPager.setAdapter(adapter);
        return adapter;
    }


    static class PagerTabAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> fragments;

        public PagerTabAdapter(FragmentManager fm, List<Fragment> fragments) {
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

    }

    interface PageTitleInterface {
        CharSequence getPageTitle(int position);
    }

    //Recycler中线间隔
    static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge){
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}
