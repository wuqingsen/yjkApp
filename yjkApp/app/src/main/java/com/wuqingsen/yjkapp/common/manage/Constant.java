package com.wuqingsen.yjkapp.common.manage;

/**
 * Name: 吴庆森
 * Date: 2019/7/29
 * Mailbox: 1243411677@qq.com
 * Describe:app常量
 */

public final class Constant {
    /**
     * 测试环境
     */
    public static final String URL = "http://266n2658e0.zicp.vip/";//网络连接域名(测试域名)

    /**
     * 正式环境
     */
    /*public static final String URL = "";//网络连接域名(正式域名)

    /**
     * HTTP网络请求相关常量
     */
    public static final class HttpCode {
        public static final String HTTP_SEVICE_ERROR = "服务器开小差了，请稍后再试吧~";
        public static final String HTTP_NETWORK_ERROR = "呀，网络出了问题    请检查网络连接";
    }

    /**
     * 偏好设置常量
     */
    public static final class SpCode {
        //音乐歌单
        public static final String SP_Music = "MyMusicList";
        //音乐当前歌单Key
        public static final String SP_MusicBebingKey = "SP_MusicBebingKey";
        //音乐当前播放序号
        public static final String SP_MusicBebingPosition = "SP_MusicBebingPosition";
        //音乐当前播放musicId
        public static final String SP_MusicBebingId = "SP_MusicBebingId";
        //音乐播放状态：true播放状态；false暂停状态
        public static final boolean SP_MusicIsPlay = false;
    }

    /**
     * EventBus事件常量
     */
    public static final class EventCode {
        //百度定位
        public static final int EventAttentionLOCATION = 0x100002;//位置获取回调

        //音乐
        public static final int EventPlayMusic = 0x100003;//音乐点击播放
        public static final int EventStopMusic = 0x100004;//暂停播放
        public static final int EventStartMusic = 0x100005;//继续播放
        public static final int EventBeforeMusic = 0x100006;//上一曲
        public static final int EventLaterMusic = 0x100007;//下一曲

        //环信
        public static final int EventExitLogin = 0x100008;//退出登录
        public static final int EventHXAddFriend = 0x100009;//收到好友邀请
        public static final int EventHXAddFriendSucess = 0x1000010;//好友请求被同意
    }

    //聊天常量
    public static final int CHAT_ADD_ID = -101;//添加好友ID
    public static final int CHAT_ADDAGREE_ID = -102;//同意添加好友


    //bugly AppId
    public static final String BuglyAppId = "a7576c304c";

    /**
     * EventBus事件常量
     */
    public static final class Permission {
        public static final int RESULT_CODE_LOCATION = 0x001;
    }

    //用户基本常量
    public static final class UserInfo {
        public static final String USER_ID = "user_id";
        public static final String USER_Name = "user_name";
        public static final String USER_PASSWORD = "user_password";
    }
}