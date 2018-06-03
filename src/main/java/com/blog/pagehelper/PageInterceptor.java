package com.blog.pagehelper;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * author bebetter159
 * date  2018/6/1 22:57
 */
@Intercepts( {@Signature(method = "query", type = Executor.class,
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })})


public class PageInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("intercepts begin");
        Object result = invocation.proceed();
        System.out.println(result);
        System.out.println("intercepts end");
        return result;
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
