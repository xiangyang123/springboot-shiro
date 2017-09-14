package com.zthz.controller;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zouxiang on 2017/9/11.
 */
public class BaseController {
    /**
     * 组装返回jsonObject
     * @return
     */
    public JSONObject assemblyJson(Object retData, String status, String msg){
        JSONObject jsonObject = new JSONObject();
        if(retData != null){
            jsonObject.put("retData",retData);
        }
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("status",status);
        retMap.put("msg",msg);
        jsonObject.put("ret",retMap);
        return jsonObject;
    }
}
