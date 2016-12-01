package com.eiecc.fire.spring_4_no_xml.mvc.messageconverter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.eiecc.fire.spring_4_no_xml.mvc.domain.DemoObj;

/***
 * 
 * @author fire
 *
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {// 继承AbstractHttpMessageConverter接口来实现自定义的HttpMessageConverter

	public MyMessageConverter() {
		
		super(new MediaType("appliacation", "x-wisely", Charset.forName("UTF-8"))); // 新建一个自定义的媒体类型appliacation/x-wisely
	}

	/***
	 * 表明本HttpMessageConverter只处理DemoObj这个类
	 */
	@Override
	protected boolean supports(Class<?> clazz) {
		System.out.println("111111");
		return DemoObj.class.isAssignableFrom(clazz);
	}

	/***
	 * 重写readInternal方法，处理请求的数据，代码表明我们处理由“-”给开的数据，并转成DemoObj的对象
	 */
	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		System.out.println("???????????????????????2222222");
		String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");

		return new DemoObj(new Long(tempArr[0]), tempArr[1]);
	}

	/***
	 * 重写writeInternal，处理如何输出数据到response.此例中，我们在原样输出前面加上“hello：”
	 */
	@Override
	protected void writeInternal(DemoObj t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		System.out.println("???????????????????????44444444");
		String out = "hello:" + t.getId() + "-" + t.getName();
		outputMessage.getBody().write(out.getBytes());

	}

}
