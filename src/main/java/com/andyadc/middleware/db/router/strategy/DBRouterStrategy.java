package com.andyadc.middleware.db.router.strategy;

/**
 * 路由策略
 */
public interface DBRouterStrategy {
    void doRouter(String dbKeyAttr);

    void clear();
}
