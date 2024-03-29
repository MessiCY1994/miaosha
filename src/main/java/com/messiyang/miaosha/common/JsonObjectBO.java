package com.messiyang.miaosha.common;

import com.alibaba.fastjson.JSONObject;

//import com.dhht.util.WebUtil;


public class JsonObjectBO {

    private int code;  //业务状态（编码）
    private String message;  //反馈信息
    private JSONObject data;  //业务数据
    private String exceptionMessage;

    // 成功
    public static final int SUCCESS = 1;
    // 成功
    public static final int EXCEPTION = 0;
    // 异常 失败
    public static final int FAIL = -1;

    public static final int Token = 2;


    public JsonObjectBO(int code, String message, JSONObject data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public JsonObjectBO() {
    }

    public static JsonObjectBO error(String msg) {
        JsonObjectBO ResponseBo = new JsonObjectBO();
        ResponseBo.setCode(FAIL);
        ResponseBo.setMessage(msg);
        return ResponseBo;
    }

    public static JsonObjectBO ok(String msg) {
        JsonObjectBO ResponseBo = new JsonObjectBO();
        ResponseBo.setCode(SUCCESS);
        ResponseBo.setMessage(msg);
        return ResponseBo;
    }
    public static JsonObjectBO success(String msg, JSONObject data) {
        JsonObjectBO ResponseBo = new JsonObjectBO();
        ResponseBo.setCode(SUCCESS);
        ResponseBo.setData(data);
        ResponseBo.setMessage(msg);
        return ResponseBo;
    }
    public static JsonObjectBO exception(String msg) {
        JsonObjectBO ResponseBo = new JsonObjectBO();
        ResponseBo.setCode(EXCEPTION);
        ResponseBo.setMessage(msg);
        return ResponseBo;
    }
    public static JsonObjectBO exceptionWithMessage(String msg,String exceptionMessage) {
        JsonObjectBO ResponseBo = new JsonObjectBO();
        ResponseBo.setCode(EXCEPTION);
        ResponseBo.setMessage(msg);
        ResponseBo.setExceptionMessage(exceptionMessage);
        return ResponseBo;
    }

    public static JsonObjectBO sessionLose(String msg) {
        JsonObjectBO ResponseBo = new JsonObjectBO();
        ResponseBo.setCode(Token);
        ResponseBo.setMessage(msg);
        return ResponseBo;
    }

    /**
     * 业务状态（编码）
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * 业务状态（编码）
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 反馈信息
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 反馈信息
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 业务数据
     * @return the data
     */
    public JSONObject getData() {
        return data;
    }

    /**
     * 业务数据
     * @param data the data to set
     */
    public void setData(JSONObject data) {
        this.data = data;
    }

    /**
     * 输出该对象的Json格式字符串
     */
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("message", message);

        if(data != null){
            json.put("data", data);
        }else{
            json.put("data", "");
        }

        return json.toString();
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
//    public void writeJson(Object object) {
//        WebUtil.writeJson(object);
//    }
}
