package com.example.demo.api.VO.Notification;

import lombok.Data;

@Data
public class NotiVO {
    public String nid;

    public String pid;

    public String noti_type;

    public String title;

    public String content;

    public String update_time;

    public int is_read;


}
