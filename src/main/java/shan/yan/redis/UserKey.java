package shan.yan.redis;

import shan.yan.base.BasePrefix;

public class UserKey extends BasePrefix {

	public UserKey(String prefix) {
		super(prefix);
		
	}

	public static UserKey getById = new UserKey("id");
	public static UserKey getByName = new UserKey("name");
	

}
