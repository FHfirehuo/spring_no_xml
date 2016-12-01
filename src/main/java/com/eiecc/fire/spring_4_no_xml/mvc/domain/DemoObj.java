package com.eiecc.fire.spring_4_no_xml.mvc.domain;

public class DemoObj {

	private Long id;
	private String name;

	public DemoObj(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public DemoObj() {
		super();
		// jackson 对对象和json做转换时一定需要此空构造
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DemoObj [id=").append(id).append(", name=").append(name).append("]");
		return builder.toString();
	}
}
