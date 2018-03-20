package shan.yan.redis;

public interface KeyPrefix {
	
	public int expireSeconds();
	
	public String getPrefix();
}
