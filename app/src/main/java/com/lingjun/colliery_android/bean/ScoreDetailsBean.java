package com.lingjun.colliery_android.bean;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者: zengtao
 * 时间: 2019/8/23  15:53.
 * 注释:
 */
@NoArgsConstructor
@Data
public class ScoreDetailsBean {

    private List<DataBean> data;

    @NoArgsConstructor
    @Data
    public static class DataBean {
        /**
         * totalitem : 41
         * score : 100.0
         * catname : 采煤
         * compRate : 100%
         * state : 检查完
         * resScore : 93.0
         * jianScore : 7.0
         * currentitem : 41
         */

        private String totalitem;
        private String score;
        private String catname;
        private String compRate;
        private String state;
        private String resScore;
        private String jianScore;
        private String currentitem;
    }
}
