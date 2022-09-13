package ydzhao.weixin.tuisong.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import cn.hutool.core.date.DateUtil;

/**
 * @ClassName JiNianRi
 * @Description TODO
 * @Author ydzhao
 * @Date 2022/8/2 17:32
 */
public class JiNianRi {
    /**
     * 恋爱
     */
    static String lianAi = "2022-07-03";
    /**
     * 相识
     */
    static String xiangShi = "2022-05-07";
    /**
     * 你的生日
     */
    static String niShengRi = "1997-12-28";

    /**
     * 我的生日
     */
    static String woShengRi = "1996-08-08";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat monthDayDateFormat = new SimpleDateFormat("MM-dd");

    private static SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");

    /**
     * 距离date还有多少天
     * @param date
     * @return
     */
    public static int before(String date) {
        int day = 0;
        try {
            long time = simpleDateFormat.parse(date).getTime() - simpleDateFormat.parse(DateUtil.beginOfDay(new Date()).toDateStr()).getTime();
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 距离生日还有多少天
     * @param date
     * @return
     */
    public static int birthday(String date) {
        int day = 0;
        try {
            String now = monthDayDateFormat.format(new Date());
            String riqi = monthDayDateFormat.format(simpleDateFormat.parse(date));
            int nowMonth = Integer.parseInt(now.substring(0,2));
            int riqiMonth = Integer.parseInt(riqi.substring(0,2));
            int nowDay = Integer.parseInt(now.substring(3,5));
            int riqiDay = Integer.parseInt(riqi.substring(3,5));
            if (riqiMonth>nowMonth||(riqiMonth==nowMonth&&riqiDay>=nowDay)){
                date=simpleDateFormat.format(new Date()).substring(0,4)+date.substring(4);
            }else {
                String nextYear = String.valueOf(Integer.parseInt(yearDateFormat.format(new Date()))+1);
                date = nextYear+"-"+riqi;
            }
            long time = simpleDateFormat.parse(date).getTime()-simpleDateFormat.parse(DateUtil.beginOfDay(new Date()).toDateStr()).getTime();
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 多少岁的生日
     * @param date
     * @return
     */
    public static int birthdayAge(String date) {
        int year = 0;
        try {
            year = Integer.parseInt(yearDateFormat.format(new Date())) - Integer.parseInt(yearDateFormat.format(simpleDateFormat.parse(date)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return year;
    }


    /**
     * 已经过去date多少天
     * @param date
     * @return
     */
    public static int after(String date) {
        int day = 0;
        try {
            long time = simpleDateFormat.parse(DateUtil.beginOfDay(new Date()).toDateStr()).getTime() - simpleDateFormat.parse(date).getTime();
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    public static int getXiangShi() {
        return after(xiangShi);
    }

    public static int getLianAi() {
        return after(lianAi);
    }

    public static int getNiShengRi(){
        return birthday(niShengRi);
    }

    public static int getNiAge(){
        return birthdayAge(niShengRi);
    }

    public static int getWoAge(){
        return birthdayAge(woShengRi);
    }

    public static int getWoShengRi(){
        return birthday(woShengRi);
    }

    public static void main(String[] args) {}


}
