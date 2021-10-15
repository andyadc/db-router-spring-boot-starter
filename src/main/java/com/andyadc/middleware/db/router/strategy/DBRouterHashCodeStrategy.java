package com.andyadc.middleware.db.router.strategy;

import com.andyadc.middleware.db.router.DBContextHolder;
import com.andyadc.middleware.db.router.DBRouterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 哈希路由
 */
public class DBRouterHashCodeStrategy implements DBRouterStrategy {

    private static final Logger logger = LoggerFactory.getLogger(DBRouterHashCodeStrategy.class);

    private final DBRouterConfig dbRouterConfig;

    public DBRouterHashCodeStrategy(DBRouterConfig dbRouterConfig) {
        this.dbRouterConfig = dbRouterConfig;
    }

    @Override
    public void doRouter(String dbKeyAttr) {
        int size = dbRouterConfig.getDbCount() * dbRouterConfig.getTbCount();

        // 扰动函数
        int idx = (size - 1) & (dbKeyAttr.hashCode() ^ (dbKeyAttr.hashCode() >>> 16));

        // 库表索引
        int dbIdx = idx / dbRouterConfig.getTbCount() + 1;
        int tbIdx = idx - dbRouterConfig.getTbCount() * (dbIdx - 1);

        // 设置到 ThreadLocal
        DBContextHolder.setDBKey(String.format("%02d", dbIdx));
        DBContextHolder.setTBKey(String.format("%03d", tbIdx));
        logger.info("数据库路由 dbIdx：{} tbIdx：{}", dbIdx, tbIdx);
    }

    @Override
    public void clear() {
        DBContextHolder.clearDBKey();
        DBContextHolder.clearTBKey();
    }
}
