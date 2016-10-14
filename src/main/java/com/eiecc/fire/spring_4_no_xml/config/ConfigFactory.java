package com.eiecc.fire.spring_4_no_xml.config;

public class ConfigFactory {
	
	private String ctx;
	
	public ConfigFactory(String ctx) {
		super();
		this.ctx = ctx;
	}

	public void SayHello() {
		System.out.println(" hello world!");

	}

	public ConfigFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCtx() {
		return ctx;
	}

	public void setCtx(String ctx) {
		this.ctx = ctx;
	}

}
