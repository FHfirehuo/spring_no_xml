package com.eiecc.fire.spring_4_no_xml.mvc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class PushService {

	private DeferredResult<String> deferredResult;

	public DeferredResult<String> getAsyncUpdate() {
		deferredResult = new DeferredResult<String>();
		return deferredResult;
	}

	@Scheduled(fixedDelay = 10000)
	public void refresh() {

		if (deferredResult != null) {
			deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
		}
	}
}
