package com.wt.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ping {
    
	public static String ping(String ipAddress) throws Exception {
        String result = "";
        String line = "";
        try {
            Process pro = Runtime.getRuntime().exec("ping " + ipAddress+" -n " + 5);
            BufferedReader buf = new BufferedReader(new InputStreamReader(
                    pro.getInputStream()));
            while ((line = buf.readLine()) != null)
            	result+=line;
            if(getCheckResult(result)){
            	int indexMs=result.lastIndexOf("ms");
                int indexEqual=result.lastIndexOf("=");
                String temp=result.substring(indexEqual+2,indexMs);
                int average=Integer.parseInt(temp);
                result=result.substring(0,indexEqual);
                indexMs=result.lastIndexOf("ms");
                indexEqual=result.lastIndexOf("=");
                temp=result.substring(indexEqual+2,indexMs);
                int Max=Integer.parseInt(temp);
                result=result.substring(0,indexEqual);
                indexMs=result.lastIndexOf("ms");
                indexEqual=result.lastIndexOf("=");
                temp=result.substring(indexEqual+2,indexMs);
                int Min=Integer.parseInt(temp);
                System.out.println("average"+average+"Max"+Max+"Min"+Min);
                return average+","+Max+","+Min;
            }else{
            	System.out.println("unreachable");
            	return "-1,-1,-1";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "-1,-1,-1";
        }
    }
    //若line含有=18ms TTL=16字样,说明已经ping通,返回1,否則返回0.
    private static boolean getCheckResult(String line) {  // System.out.println("控制台输出的结果为:"+line);  
        Pattern pattern = Pattern.compile("(\\d+ms)(\\s+)(TTL=\\d+)",    Pattern.CASE_INSENSITIVE);  
        Matcher matcher = pattern.matcher(line);  
        while (matcher.find()) {
            return true;
        }
        return false; 
    }
}
