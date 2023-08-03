package hello.core.common;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(value = "request")
public class MyLogger {
	private String uuid;
	private String requestUrl;

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public void log(String msg) {
		System.out.printf("[%s] [%s] : %s\n", uuid, requestUrl, msg);
	}

	@PostConstruct
	public void init() {
		uuid = UUID.randomUUID().toString();
		System.out.println("Request scope bean create : " + this);
	}

	@PreDestroy
	public void close() {
		System.out.println("MyLogger.close : " + this);
	}
}
