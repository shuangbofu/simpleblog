package cn.shuangbofu.dto;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ericfu on 2018/3/22.
 */
@Data()
public class ArchiveBlog {

    private Long blogId;

    private String title;

    private Date createTime;

    private int year;

    private int month;

    public void setData() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createTime);
        year = calendar.get(Calendar.DAY_OF_YEAR);
        month = calendar.get(Calendar.DAY_OF_MONTH);
    }
}
