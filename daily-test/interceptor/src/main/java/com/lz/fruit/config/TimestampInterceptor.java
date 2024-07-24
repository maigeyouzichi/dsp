package com.lz.fruit.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

@Intercepts({
    @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class TimestampInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];
        
        if (parameter != null) {
            if (mappedStatement.getSqlCommandType() == SqlCommandType.INSERT) {
                handleInsert(parameter);
            } else if (mappedStatement.getSqlCommandType() == SqlCommandType.UPDATE) {
                handleUpdate(parameter);
            }
        }

        return invocation.proceed();
    }

    private void handleInsert(Object parameter) {
        setFieldValue(parameter, "createTime", getCurrentTime(parameter.getClass(), "createTime"));
        setFieldValue(parameter, "updateTime", getCurrentTime(parameter.getClass(), "updateTime"));
    }

    private void handleUpdate(Object parameter) {
        setFieldValue(parameter, "updateTime", getCurrentTime(parameter.getClass(), "updateTime"));
    }

    private Object getCurrentTime(Class<?> parameterClass, String fieldName) {
        try {
            Field field = parameterClass.getDeclaredField(fieldName);
            if (field != null) {
                if (field.getType() == Long.class || field.getType() == long.class) {
                    return System.currentTimeMillis();
                } else if (field.getType() == Timestamp.class) {
                    return new Timestamp(System.currentTimeMillis());
                } else if (field.getType() == Date.class) {
                    return new Date();
                }
            }
        } catch (NoSuchFieldException e) {
            // Field not found, return null
        }
        return null;
    }

    private void setFieldValue(Object parameter, String fieldName, Object value) {
        if (value == null) {
            return;
        }
        try {
            Field field = parameter.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object existingValue = field.get(parameter);
            if (existingValue == null) { // Only set value if it's not already set
                field.set(parameter, value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Ignore if field not found or not accessible
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // No properties to set
    }
}
