package com.lingjun.colliery_android.utils.code;

import java.util.List;

/**
 * @since 1.0
 * <p/>
 * SnowJun  2016/9/8
 */
public class ErrorBean {


    /**
     * result_code : 200
     * result_info : [{"Error":"CallError"}]
     */

    private int result_code;
    /**
     * Error : CallError
     */

    private List<ResultInfoBean> result_info;

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public List<ResultInfoBean> getResult_info() {
        return result_info;
    }

    public void setResult_info(List<ResultInfoBean> result_info) {
        this.result_info = result_info;
    }

    public static class ResultInfoBean {
        private String Error;
//        private String error;

        public String getError() {
            return Error;
        }

        public void setError(String Error) {
//            if (TextUtils.isEmpty(Error)){
//                return;
//            }
            this.Error = Error;
//            this.error = Error;
        }


    }


}
