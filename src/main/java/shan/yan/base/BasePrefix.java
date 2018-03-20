package shan.yan.base;

import shan.yan.redis.KeyPrefix;

public abstract class BasePrefix implements KeyPrefix {

	private int expireSecond;
	private String prefix;
	
	public BasePrefix (String prefix) {
		this(0, prefix);
	}
	
	public BasePrefix (int expire,String prefix) {
		this.expireSecond = expire;
		this.prefix = prefix;
	}
	
	@Override
	public int expireSeconds() {
		return expireSecond;
	}

	@Override
	public String getPrefix() {
		String name = getClass().getName();
		return name+":"+prefix;
	}

}
