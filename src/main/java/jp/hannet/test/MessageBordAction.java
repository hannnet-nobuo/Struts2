/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.hannet.test;


import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;
import jp.hannet.test.beans.DataList;

public class MessageBordAction extends ActionSupport implements ServletContextAware {
    
	private static final long serialVersionUID = -6928196015143542873L;

	private DataList bordData ;
	private String title;
	private String msg;
	private ServletContext context;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public DataList getBordData() {
		return bordData;
	}

	public void setBordData(DataList dataList) {
		this.bordData = dataList;
	}
    
    public String execute() throws Exception {
    	bordData = (DataList) context.getAttribute("bordData");
    	if (bordData == null) {
    		bordData = new DataList();
    	} else {   		
    		bordData.add(title, msg);
    	}
    	title = "";
    	msg = "";
        return SUCCESS;
    }

	public void setServletContext(ServletContext context) {
		this.context = context;
		
	}
}
