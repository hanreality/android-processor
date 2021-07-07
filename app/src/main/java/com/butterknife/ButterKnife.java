package com.butterknife;

import android.app.Activity;

import java.lang.reflect.Constructor;

public class ButterKnife {
    public static Unbinder bind(Activity activity) {
        // xxxActivity_ViewBinding viewBinding = new xxxActivity_ViewBinding(this);
        try {
            Class<? extends Unbinder> bindClassName = (Class<? extends Unbinder>)
                    Class.forName(activity.getClass().getName() + "_ViewBinding");
            // 构造函数
            Constructor<? extends Unbinder> bindConstructor = bindClassName.getDeclaredConstructor(activity.getClass());
            //创建的时候就把字段findViewById了
            Unbinder unbinder = bindConstructor.newInstance(activity);
            // 返回 Unbinder
            return unbinder;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Unbinder.EMPTY;
    }
}
