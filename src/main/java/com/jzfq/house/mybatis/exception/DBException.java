package com.jzfq.house.mybatis.exception;

/**
 *
 * <B>文件名称：</B>DBException.java<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2015-2017<BR>
 * <B>公司部门：</B>smartscity 研究中心 <BR>
 * <B>创建时间：</B>2015年8月3日 下午7:25:52<BR>
 *
 * @author liyunlong lyl2008dsg@163.com
 * @version
 */
public class DBException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DBException(String msg)
    {
        super(msg);
    }
}

