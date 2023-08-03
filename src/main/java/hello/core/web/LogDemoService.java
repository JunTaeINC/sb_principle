package hello.core.web;

import org.springframework.stereotype.Service;

import hello.core.common.MyLogger;
import jakarta.inject.Provider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {
	private final Provider<MyLogger> myLoggerProvider;

	public void logic(String id) {
		MyLogger myLogger = myLoggerProvider.get();
		myLogger.log("Service Id = " + id);
	}
}