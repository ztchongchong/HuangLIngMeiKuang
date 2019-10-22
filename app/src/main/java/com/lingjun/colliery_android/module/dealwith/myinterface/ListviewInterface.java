package com.lingjun.colliery_android.module.dealwith.myinterface;

import android.view.View;

/**
 * Created by shurrikann on 2018/3/21.
 */

public interface ListviewInterface {
    void btnClick(View v, int pos, boolean type);

    void btnsClick(View v, int pos, int state, boolean type);

    void btnsClicks(View v, int pos, boolean state, int type);


}
