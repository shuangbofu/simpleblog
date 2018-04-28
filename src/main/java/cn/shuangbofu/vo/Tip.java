package cn.shuangbofu.vo;

import cn.shuangbofu.enums.TipEnum;
import lombok.Data;

/**
 * Created by ericfu on 2018/4/4.
 */
@Data
public class Tip {

    private String path;

    private String data;

    private String title;

    public Tip(TipEnum tipEnum, String data) {
        this.data = data;
        this.path = tipEnum.getPath() + data;
        this.title = tipEnum.getTitle();
    }

    public Tip(TipEnum tipEnum, String data, Integer id) {
        this.data = data;
        this.title = tipEnum.getTitle();
        this.path = tipEnum.getPath() + id;
    }

    public Tip(TipEnum tipEnum) {
        this.data = "";
        this.title = tipEnum.getTitle();
        this.path = tipEnum.getPath();
    }

    public Tip(String path) {
        this.path = path;
    }
}
