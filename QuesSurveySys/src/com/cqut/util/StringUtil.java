package com.cqut.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author lxh
 *
 */
public class StringUtil {
	
	private static Random random = new Random();
	private static final int DEFAULT_MAX_NUM = 100;
	
	/**
	 * 将java.util.Date转换为java.sql.Date
	 * @param utilDate
	 * @return
	 */
	public static java.sql.Date changeToSqlDate(java.util.Date utilDate){
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	/**
	 * 将java.sql.Date转换为java.util.Date
	 * @param sqlDate
	 * @return
	 */
	public static java.util.Date changeToUtilDate(java.sql.Date sqlDate){
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}
	
	
	/**
	 * 将string类型的转换为date类型
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将date转换为yyyy-mm-dd格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date){
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");
        String time = format0.format(date.getTime());
        return time;
	}
	
	/**
	 * 生成当前纳秒值的字符串
	 * */
	public static String createTimestamp() {
	    return String.valueOf(System.nanoTime())
	    		.concat(String.valueOf(random.nextInt(DEFAULT_MAX_NUM)));
	}
}
