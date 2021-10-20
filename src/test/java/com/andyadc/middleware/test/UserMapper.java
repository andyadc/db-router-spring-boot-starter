package com.andyadc.middleware.test;

import com.andyadc.middleware.db.router.annotation.DBRouter;

public interface UserMapper {
    @DBRouter(key = "userId")
    void insertUser(String req);
}
