package com.wuqingsen.yjkapp.utils.eventbus;

/**
 * Name: 吴庆森
 * Date: 2019/7/29
 * Mailbox: 1243411677@qq.com
 * Describe:BaseActivity
 */
public class Event<T> {
    private int code;
    private T data;

    public Event(int code) {
        this.code = code;
    }

    public Event(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
