package cn.shuangbofu.entity;

import lombok.Data;

/**
 * Created by ericfu on 2018/4/13.
 */
@Data
public class Profile {

    private Integer id;

    private String name;

    private String avatar;

    private String mottoCn;

    private String mottoEn;

    private String githubUrl;

    private String weiboUrl;

    private String weixinCodeUrl;

    private String emailUrl;
}
