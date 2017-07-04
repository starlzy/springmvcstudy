package com.imooc.mvcdemo.db;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * Created by lzy on 02/07/17.
 */
public interface DBAccessInterface {
    public SqlSession getSqlSession() throws IOException;
}
