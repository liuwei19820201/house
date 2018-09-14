package com.jzfq.house.util;


/**
 * SQL注入攻击防护
 *
 * @author Garen Gosling
 * @create 2017-09-08 18:01
 * @since v1.0
 */
public class EsapiUtil {

	/**
	 * 这个可以简单防护，但还不够，只是抛砖引玉
	 *
	 * @param str
	 * @return
	 */
	public static String sql(String str) {
		return str;
	}

}
