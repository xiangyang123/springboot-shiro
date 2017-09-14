package com.zthz.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.domain.Page;

/**
 * Created by zouxiang on 2017/8/14.
 */
public class PageUtil {

    public static JSONObject page(Page list){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",list.getTotalElements());
        jsonObject.put("rows",list.getContent());
        return jsonObject;
    }
}
