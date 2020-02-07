package com.wang.ssmtest.bean;
/**
 * ͨ�õķ��ص���
 * @author 24719
 *
 */

import java.util.HashMap;
import java.util.Map;

public class Msg {
	
	private int code;//״̬��
	private String msg;//��ʾ��Ϣ
	
	private Map<String, Object> extend = new HashMap<String, Object>();//�û�Ҫ���ظ������������

	public static Msg success() {
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("����ɹ���");
		return result;
	}
	public static Msg fail() {
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("����ʧ�ܣ�");
		return result;
	}
	
	public Msg add(String key,Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
	
}
