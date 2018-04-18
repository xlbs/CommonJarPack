package com.tool.utils;


import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

//        System.out.println(CalendarUtils.isValidDate("2004-2-29"));
//        System.out.println(CalendarUtils.isValidTime("2015-9-30 00:09:60"));
//
//        String str = "2.52541";
//        String pattern="0";
//       Object aa =  FormatUtils.formaterData(str,pattern);
//       System.out.println(aa);
//        Calendar cal = Calendar.getInstance();
//        cal.set(2018,4,2);
//        cal.set(Calendar.YEAR,2008);
//        cal.set(Calendar.MONTH,2);
//        cal.set(Calendar.DAY_OF_MONTH,0);
//        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

//        String stime = "2017-08-23 6:32:25";
        Calendar cal = Calendar.getInstance();
        Date date = CalendarUtils.dateToCalendar(cal);
//        Calendar clasdd = (Calendar)cal.clone();
//        cal.add(Calendar.MONTH,-1);
        String path = "E:/智慧能源云平台/power-icon.xml";
        System.out.println(StringUtils.getFilename(path));
        System.out.println(StringUtils.getFilenameExtension(path));
        System.out.println(StringUtils.stripFilenameExtension(path));
//        System.out.println(StringUtils.cleanPath(path));
        System.out.println(StringUtils.delete(path,"o"));
        String aa = "gjjdhDSb";
        System.out.println(StringUtils.toLowerCase(aa));
        System.out.println(StringUtils.deleteStart(aa));
        System.out.println(StringUtils.deleteEnd(aa));
        Set<Integer> set  = new HashSet<>();
        set.add(0);
        set.add(3);
        System.out.println(StringUtils.delete(aa,set));
        System.out.println(StringUtils.delete(aa,0));

    }

}
