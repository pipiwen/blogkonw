package com.ppw.blogknow.util;

import com.alibaba.druid.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间util
 * @author TC
 */
public class DateUtil {

	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * 历时
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String getLongTime(String startTime, String endTime) {
		if (StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)) {
			return "";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date startDate = simpleDateFormat.parse(startTime);
			Date endDate = simpleDateFormat.parse(endTime);
			boolean flag = startDate.getTime() >= endDate.getTime();
			if (flag) {
				return "";
			}
			long yy = 1000 * 24 * 60 * 60;// 一天的毫秒数
			long hh = 1000 * 60 * 60;// 一小时的毫秒数
			long mm = 1000 * 60;// 一分钟的毫秒数
			long ss = 1000;// 一秒钟的毫秒数
			long day = 0;
			long hour = 0;
			long min = 0;
			long sec = 0;
			long diff = endDate.getTime() - startDate.getTime();
			day = diff / yy;// 计算差多少天
			hour = (diff % yy) / hh;// 计算差多少小时
			min = (diff % yy % hh) / mm;// 计算差多少分钟
			sec = (diff % yy % hh % mm) / ss;// 计算差多少秒
			StringBuilder stringBuilder = new StringBuilder();
			if (day > 0L) {
				stringBuilder.append(day).append("天");
			}
			if (hour > 0L) {
				stringBuilder.append(hour).append("小时");
			}
			if (min > 0L) {
				stringBuilder.append(min).append("分");
			}
			if (sec > 0L) {
				stringBuilder.append(sec).append("秒");
			}
			return stringBuilder.toString();
		} catch (ParseException e) {
			logger.error("时间计算错误：" + e.getMessage());
			return "";
		}
	}
	
	/**
	 * data to string
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String datetoStr() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(new Date());
	}

	public static String datetoStr4Sql() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(new java.sql.Date(new Date().getTime()));
	}
	
	/**
	 * 格式化时间+随机四位数做版本
	 * @param date
	 * @return
	 */
	public static String dateVersion() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(new Date()) + (int)((Math.random()*9+1)*1000);
	}

	public static void main(String[] args) {
		System.out.println(new Date());
		System.out.println(new java.sql.Date(new Date().getTime()));
		System.out.println(datetoStr());
		System.out.println(DateUtil.datetoStr4Sql());

	}
}
