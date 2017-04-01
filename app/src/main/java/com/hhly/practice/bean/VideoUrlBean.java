package com.hhly.practice.bean;

import java.util.List;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/2
 */
public class VideoUrlBean {

    /**
     * error : false
     * results : [{"_id":"57c6f954421aa9125fa3edc7","createdAt":"2016-08-31T23:35:48.389Z","desc":"很有爱的一段视频：这个世界上，你永远亏欠的人只有一个。[心]","publishedAt":"2016-09-01T11:31:19.288Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/230444aaf7d8f93001485a740e08d112779ac5","used":true,"who":"LHF"},{"_id":"57c5a45f421aa936f87936d9","createdAt":"2016-08-30T23:21:03.869Z","desc":"【敖厂长】打脸!魂斗罗水下八关存在","publishedAt":"2016-08-31T11:41:56.41Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av6018306/","used":true,"who":"LHF"},{"_id":"57c17b17421aa9126b1a15bf","createdAt":"2016-08-27T19:35:51.719Z","desc":"【C菌】这是我被吓最惨的一次! 那些最恐怖的游戏集合【第32期】","publishedAt":"2016-08-30T11:38:36.625Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av6031594/","used":true,"who":"LHF"},{"_id":"57c17dc9421aa91265f4a3eb","createdAt":"2016-08-27T19:47:21.447Z","desc":"【敖厂长】抢滩登陆你玩过吗","publishedAt":"2016-08-29T11:32:28.388Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av5953981/","used":true,"who":"LHF"},{"_id":"57beedd0421aa9125fa3ed88","createdAt":"2016-08-25T21:08:32.718Z","desc":"澳门赌王何鸿燊。","publishedAt":"2016-08-26T11:39:18.8Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/UzLtKdUoOAW9Dt03v5JvAA__.htm","used":true,"who":"daimajia"},{"_id":"57bc6b8e421aa9126b1a1597","createdAt":"2016-08-23T23:28:14.947Z","desc":"泰国搞笑反套路广 告，很有意义，创意超棒，每次都猜不到结局！小女孩分分钟可以做成表情包了[笑cry]","publishedAt":"2016-08-25T11:23:14.243Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/3QRcTnTQDtGy1f~j1PHReQ__.htm","used":true,"who":"LHF"},{"_id":"579c19a5421aa90d39e70999","createdAt":"2016-07-30T11:06:13.597Z","desc":"这位老师说得有理有据令人信服，要是每个老师都这样我也不会上课睡觉了","publishedAt":"2016-08-24T11:38:48.733Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/CUOk8FKkjOELHmKvSY9BcA__.htm","used":true,"who":"lxxself"},{"_id":"57baa163421aa91265f4a3b1","createdAt":"2016-08-22T14:53:23.799Z","desc":"字幕看得我尴尬症直犯。","publishedAt":"2016-08-23T11:29:45.813Z","source":"web","type":"休息视频","url":"http://www.miaopai.com/show/bJWgofJk3Fq0mXsdWQcPpg__.htm","used":true,"who":null},{"_id":"57b69303421aa93a804bea2b","createdAt":"2016-08-19T13:02:59.837Z","desc":"一个简单感人的动画短片，死神和鹿的故事。","publishedAt":"2016-08-22T11:29:37.164Z","source":"web","type":"休息视频","url":"http://www.bilibili.com/video/av4039606/","used":true,"who":null},{"_id":"57b26db0421aa93a804bea02","createdAt":"2016-08-16T09:34:40.465Z","desc":"他叫王德顺。44岁学英语，49岁北漂研究哑剧，50岁开始健身，57岁创造\u201c活雕塑\u201d，65岁学骑马，70岁练成腹肌，78岁骑摩托，79岁上T台。没有太晚，没有谁能阻止你奋斗，只要你下定决心。","publishedAt":"2016-08-19T11:26:30.163Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/230444b13215e629ce3ba1f6ac5a94a2d019c5","used":true,"who":"lxxself"}]
     */

    public boolean error;
    /**
     * _id : 57c6f954421aa9125fa3edc7
     * createdAt : 2016-08-31T23:35:48.389Z
     * desc : 很有爱的一段视频：这个世界上，你永远亏欠的人只有一个。[心]
     * publishedAt : 2016-09-01T11:31:19.288Z
     * source : chrome
     * type : 休息视频
     * url : http://weibo.com/p/230444aaf7d8f93001485a740e08d112779ac5
     * used : true
     * who : LHF
     */

    public List<ResultsBean> results;

    public static class ResultsBean {
        public String _id;
        public String createdAt;
        public String desc;
        public String publishedAt;
        public String source;
        public String type;
        public String url;
        public boolean used;
        public String who;
    }
}
