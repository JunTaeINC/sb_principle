package hello.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import jakarta.inject.Provider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	private final Provider<MyLogger> myLoggerProvider;
	private final LogDemoService logDemoService;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString();
		MyLogger myLogger = myLoggerProvider.get();

		myLogger.setRequestUrl(requestUrl);
		myLogger.log("Controller test");
		logDemoService.logic("test_id");
		return "OK";
	}
}