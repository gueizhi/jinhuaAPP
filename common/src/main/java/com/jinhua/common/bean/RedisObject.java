package com.jinhua.common.bean;



import java.io.Serializable;

/**
 * Redis传输对象
 * @author ljx
 */
public class RedisObject implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 扩展对象
	 */
	private Object extObject;

	public Object getExtObject() {
		return extObject;
	}

	public void setExtObject(Object extObject) {
		this.extObject = extObject;
	}
}
