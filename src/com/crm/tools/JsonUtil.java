package com.crm.tools;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class JsonUtil {
	public static String toJson(Object obj) {
		StringBuffer json=new StringBuffer();
		if(obj instanceof Collection) {
			json.append("[");
			Collection objColl=(Collection) obj;
			Iterator iterator = objColl.iterator();
			while(iterator.hasNext()){
				Object subObj = iterator.next();
				json.append(toJson(subObj)).append(",");
			}
			if(json.charAt(json.length() -1) ==','){
				json.deleteCharAt(json.length() -1);
			}
			json.append("]");
		}else{
			json.append("{");
			Class objClass = obj.getClass();
			Field[] fields =objClass.getDeclaredFields();
			for(Field field : fields){
				field.setAccessible(true);
				Object fieldObj =null;
			try{
				fieldObj = field.get(obj);
			}catch(IllegalArgumentException e) {
				e.printStackTrace();
			}catch(IllegalAccessException e) {
				e.printStackTrace();
			}
			if(fieldObj !=null){
				if(fieldObj instanceof Collection){
					continue;
			}
				json.append("\"").append(field.getName()).append("\":\"").append(fieldObj).append("\"").append(",");
			}else{
				json.append("\"").append(field.getName()).append("\":null").append(",");
			}
			}
			if(json.charAt(json.length() -1) ==','){
				json.deleteCharAt(json.length() -1);
			}
			json.append("}");
		}
		return json.toString();
	}
	
	public static void  format(String json) throws IOException {

        StringBuilder indent = new StringBuilder();//缩进
        StringBuilder sb = new StringBuilder();

        for (char c : json.toCharArray()) {
            switch (c) {
                case '{':
                    indent.append(" ");
                    sb.append("{\n").append(indent);
                    break;
                case '}':
                    indent.deleteCharAt(indent.length() - 1);
                    sb.append("\n").append(indent).append("}");
                    break;
                case '[':
                    indent.append(" ");
                    sb.append("[\n").append(indent);
                    break;
                case ']':
                    indent.deleteCharAt(indent.length() - 1);
                    sb.append("\n").append(indent).append("]");
                    break;
                case ',':
                    sb.append(",\n").append(indent);
                    break;
                default:
                    sb.append(c);
            }
        }
        HttpServletResponse response = ServletActionContext.getResponse();
		//response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(sb);
		out.flush();
		out.close();
    }
}


