package com.lingjun.colliery_android.base;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 *
 * Created by nefa on 2018/8/6.
 */

public class BaseService extends IntentService {

    public BaseService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
