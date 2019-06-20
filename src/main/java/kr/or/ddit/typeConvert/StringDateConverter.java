package kr.or.ddit.typeConvert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringDateConverter implements Converter<String, Date>{

	private String pattern = "yyyy-MM-dd";
	
	@Override
	public Date convert(String source) {
		//source : 2019-08-08 --> date으로 우째?
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public void setPattern (String pattern) {
		this.pattern = pattern;
	}
	
}
