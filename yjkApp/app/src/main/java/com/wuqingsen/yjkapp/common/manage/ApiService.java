package com.wuqingsen.yjkapp.common.manage;

/**
 * Name: 吴庆森
 * Date: 2019/10/9
 * Mailbox: 1243411677@qq.com
 * Describe:
 */
public class ApiService {
    //搜索
    public static String MusicSearch = "https://c.y.qq.com/soso/fcgi-bin/client_search_cp?aggr=1&cr=1&flag_qc=0&p=1&n=30&w=";

    //最火推荐
    public static String MusicNew = "https://c.y.qq.com/v8/fcg-bin/fcg_v8_toplist_cp.fcg?g_tk=5381&uin=0&format=json&inCharset=utf-8&outCharset=utf-8¬ice=0&platform=h5&needNewCode=1&tpl=3&page=detail&type=top&topid=27&_=1519963122923";

    //随机推荐：
    public static String MusicRandom = "https://c.y.qq.com/v8/fcg-bin/fcg_v8_toplist_cp.fcg?g_tk=5381&uin=0&format=json&inCharset=utf-8&outCharset=utf-8%C2%ACice=0&platform=h5&needNewCode=1&tpl=3&page=detail&type=top&topid=36&_=1520777874472";

    //音乐专辑图片
    public static String MusicImageUrl = "http://imgcache.qq.com/music/photo/album_300/&A/300_albumpic_&B_0.jpg";

    //获取token
    //token格式:https://c.y.qq.com/base/fcgi-bin/fcg_music_express_mobile3.fcg?format=json205361747&platform=yqq&cid=205361747&songmid=003lghpv0jfFXG&filename=C400 + 003lghpv0jfFXG + .m4a&guid=126548448
    public static String MusicTokenUrl = "https://c.y.qq.com/base/fcgi-bin/fcg_music_express_mobile3.fcg?format=json205361747&platform=yqq&cid=205361747&songmid=003lghpv0jfFXG&filename=C400";
    public static String MusicTokenUrlEnd = ".m4a&guid=126548448";

    //音乐播放连接
    public static String MusicPlayUrlHead = "http://ws.stream.qqmusic.qq.com/";
    public static String MusicPlayUrlMiddle ="?fromtag=0&guid=126548448&vkey=";
}
