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
import jp.hannet.test.beans.MyMapping;
import jp.hannet.test.dao.MyMappingDao;

public class HiNewAction extends ActionSupport {

	private static final long serialVersionUID = 5294876177832560670L;
	private String id;
	private String name;
	private String memo;
	private String insert;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String execute() throws Exception {
		msg = "";
		MyMappingDao dao = new MyMappingDao();
		if (id != null) {
			// セッション取得
			if (!dao.existById(id)) {
				MyMapping map = new MyMapping();
				map.setId(id);
				map.setName(name);
				map.setMemo(memo);
				dao.save(map);
				msg = "書き込みました";
			} else {
				msg = "すでに存在するIDです";
			}
		}
		return SUCCESS;
	}
}
