package jp.co.kin.common.context;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceComponent {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String key) {
		return this.getMessageByLocale(key, Locale.getDefault());
	}

	public String getMessageByLocale(String key, Locale locale) {
		return messageSource.getMessage(key, null, locale);
	}

}
