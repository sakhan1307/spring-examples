package com.springexample.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UtilClass {
/*	private Set<Object> objects;

		
	public Set<Object> getObjects() {
		return objects;
	}

	public void setObjects(Set<Object> objects) {
		this.objects = objects;
	}
	
	public String getMerge(){
		StringBuffer buffer = new StringBuffer();
		for (Object objs : objects) {
		buffer.append("-");
		buffer.append(objs);
		}
		return buffer.toString();
	}*/
	
	private Map<Object,Object> objects;

	
	public Map<Object,Object> getObjects() {
		return objects;
	}

	public void setObjects(Map<Object,Object> objects) {
		this.objects = objects;
	}
	
	public String getMerge(){
		StringBuffer buffer = new StringBuffer();
		for (Map.Entry entry : objects.entrySet()) {
				buffer.append("-");
				buffer.append(entry.getKey());
				buffer.append("@");
				buffer.append(entry.getValue());
			}
		return buffer.toString();
	}
	
}
