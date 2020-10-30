package com.wuqingsen.yjkapp.utils.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Name: 吴庆森
 * Date: 2019/7/29
 * Mailbox: 1243411677@qq.com
 * Describe:BaseActivity
 */
public class EventBusUtil {

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }

    // 其他
}
