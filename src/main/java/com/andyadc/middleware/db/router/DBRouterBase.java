package com.andyadc.middleware.db.router;

/**
 * 数据源基础配置
 */
public class DBRouterBase {
    private String tbIdx;

    public String getTbIdx() {
        return DBContextHolder.getTBKey();
    }
}
