package com.wt.action;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Dataflow;
import com.wt.po.DataflowDAO;
import com.wt.po.TblSwitchsnmpDAO;
public class TimeAction {
	static ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	static DataflowDAO dataflowdao=DataflowDAO.getFromApplicationContext(ctx);
	TblSwitchsnmpDAO switchsnmpdao=TblSwitchsnmpDAO.getFromApplicationContext(ctx);
	
	static String filepath="C:/Users/chwangteng/Desktop/data/";
	
	//第一次启动时先扫描目录下的所有文件，把没读完的（前几天的）读取到数据库。
	//以后每次就是读取当天的文件。但是前一天的也应该检查一下，因为可能采集的时候刚好和写入的错开了

	
	static File file = new File(filepath);//File类型可以是文件也可以是文件夹
	static String[] fileNameList;//将该目录下的所有文件放置在一个File类型的数组中
	
	static int currentIndex=0;
	
	
	@SuppressWarnings("deprecation")
	public void dotime() throws Exception{
    	fileNameList = file.list();//将该目录下的所有文件放置在一个File类型的数组中
    	Arrays.sort(fileNameList);//直接按照ASCII排序即可，就是能获取文件名的顺序了
    	if(dataflowdao.countAll()==0){//以后想换成更高效的判断，获取计数太麻烦了，但是数据库会不会有保存这个值？
    		//如果是第一次部署工程，数据库表为空，需要将已经存在的所有csv都读取进入数据库。
    		System.out.println("gotoif");
    	    for(int index=0;index<fileNameList.length;index++){
    	    	String csvpath=filepath+fileNameList[index];
    	    	//将整个文件内容复制到数据库
    	        FileInputStream inputStream = new FileInputStream(csvpath);  
    	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));      
    	        String str = null;  
    	        while((str = bufferedReader.readLine()) != null)  
    	        {  
    	            String singleobj[]=str.split(",");
    	            if(switchsnmpdao.findByDevicename(singleobj[0]).size()>0){
    	            	Dataflow insertItem=new Dataflow(null,singleobj[0],singleobj[1],singleobj[2],singleobj[3],Timestamp.valueOf(singleobj[4]+" "+singleobj[5]));
        	            dataflowdao.save(insertItem);
    	            }
    	            
    	        }  
    	        //close  
    	        inputStream.close();  
    	        bufferedReader.close();
    	    }
    	}else{
    		System.out.println("gotoelse");
    		//根据文件指针读取最新的一行（或者说是直至文件末尾）!!!没办法用文件指针，只能按行读取，因为这个文件里面数据长度都是不固定的。
    		//有可能是服务器被关闭了一段时间，也有可能是正常读取
    	    for(int index=0;index<fileNameList.length;index++){
    	    	String csvpath=filepath+fileNameList[index];
    	    	
    	    	ArrayList<Dataflow> last=(ArrayList<Dataflow>) dataflowdao.getLastItem();
    	    	Dataflow lastItem=last.get(0);
    	    	
    	    	Timestamp ts = lastItem.getTime();
    	        String tsStr = "";  
    	        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
    	        
    	        tsStr = sdf.format(ts);  
    	        System.out.println(tsStr);  

    	    	
    	    	if((tsStr+"cal.csv").compareTo(fileNameList[index])>0)
    	    		continue;
    	    	
    	    	
    	    	//将剩余内容复制到数据库
    	        FileInputStream inputStream = new FileInputStream(csvpath);  
    	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));      
    	        String str = null;  
    	        while((str = bufferedReader.readLine()) != null)  
    	        {  
    	            String singleobj[]=str.split(",");
    	            Timestamp csvts=Timestamp.valueOf(singleobj[4]+" "+singleobj[5]);
    	            if(csvts.getTime()<=ts.getTime())
    	            	continue;
    	            if(switchsnmpdao.findByDevicename(singleobj[0]).size()>0){
    	            	Dataflow insertItem=new Dataflow(null,singleobj[0],singleobj[1],singleobj[2],singleobj[3],Timestamp.valueOf(singleobj[4]+" "+singleobj[5]));
        	            dataflowdao.save(insertItem);
    	            }
    	        }  
    	        //close  
    	        inputStream.close();  
    	        bufferedReader.close();
    	    }
    	}

	}
	
}
