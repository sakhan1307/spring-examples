package com.springexample.sequence;

import org.springframework.beans.factory.annotation.Required;

public class SequenceGenerator {

	//private String prefix;
	
	private PrefixGenerator prefixGenerator;
	
	private String suffix;
	private int initial;
	private int counter;
	
	public SequenceGenerator() {}
	
	public SequenceGenerator(PrefixGenerator prefixGenerator, String suffix, int initial) {
		super();
		this.prefixGenerator = prefixGenerator;
		this.suffix = suffix;
		this.initial = initial;
		System.out.println("--Calling Constructor1--");
	}
	
/*	public SequenceGenerator(String prefix, String suffix) {
		super();
		this.prefix = prefix;
		this.suffix = suffix;
		System.out.println("--Calling Constructor2--");
	}
	
	public SequenceGenerator(String prefix, int initial) {
		super();
		this.prefix = prefix;
		this.initial = initial;
		System.out.println("--Calling Constructor3--");
	}
	*/
	
	public PrefixGenerator getPrefixGenerator() {
		return prefixGenerator;
	}
	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
		System.out.println("--Calling setPrefix--");
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
		System.out.println("--Calling setSuffix--");
	}
	public int getInitial() {
		return initial;
	}
	
	@Required
	public void setInitial(int initial) {
		this.initial = initial;
	}
	public int getCounter() {
		return counter;
	}
	
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public String getSequence(){
		StringBuffer buffer= new StringBuffer();
		
		buffer.append(prefixGenerator.getPrefix());
		buffer.append(initial+counter++);
		buffer.append(suffix);
		
		return buffer.toString();
	}
	
}
