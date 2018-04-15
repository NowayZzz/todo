package com.pc.core.action;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pc.core.util.DateUtils;
@Component("ExtjsAction")
@Scope("prototype")
public class ExtjsLesson extends BaseAction{
	private static final long serialVersionUID = 10101010101010L;
	protected static Logger logger = Logger.getLogger(DoAction.class);
	public void getTime() throws IOException {
		response.setCharacterEncoding("utf-8");
		Writer writer =  response.getWriter();
		writer.write(DateUtils.getFormatStringDate(new Date()));
		writer.close();	
	}
	private static int i = 0;
	public void getI() throws IOException {
		response.setCharacterEncoding("utf-8");
		Writer writer =  response.getWriter();
		i = i+1;
		writer.write("计数器:"+i);
		writer.close();	
	}	
	//menu
	public static String beij = "[{name:'海淀',value:'01'},{name:'东城',value:'02'},{name:'顺义',value:'03'}]";
	 
	public void menu() throws IOException {
		/**
		 * if 静态变量中有那么就从变量中拿,没有从数据库中拿,然后在放到静态变量中
		 */
		String beij = "[{name:'海淀',value:'01'},{name:'东城',value:'02'},{name:'顺义',value:'03'}]";
		String tianj = "[{name:'和平',value:'01'},{name:'河西',value:'02'},{name:'河东',value:'03'}]";
		response.setCharacterEncoding("utf-8");
		Writer writer =  response.getWriter();
		if(getIds().equals("beij")){
			writer.write(beij);
		}else if(getIds().equals("tianj")){
			writer.write(tianj);
		}
		writer.close();	
	}	
}
