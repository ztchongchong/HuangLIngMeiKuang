package com.lingjun.colliery_android.base;

import java.io.Serializable;

/**
 * Created by nefa on 2018/9/9.
 */

public class EventMessageBean implements Serializable{
    private String message;

    public EventMessageBean(String str){
        message = str;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
