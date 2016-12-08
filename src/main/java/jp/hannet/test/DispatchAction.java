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

import com.opensymphony.xwork2.ActionSupport;

public class DispatchAction extends ActionSupport {
    
	private static final long serialVersionUID = -2295561907542607361L;

	private String text;
	
	public String getText() {
		return text;
	}

	public String action1() throws Exception {
		
		text = "action1";
        return SUCCESS;
    }

	public String action2() throws Exception {
		
		text = "action2";
        return SUCCESS;
    }

}
