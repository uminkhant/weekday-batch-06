package com.jdc.mkt.generic;

public class GenericDemoTwo {

	public static void main(String[] args) {

		Converter<Double> d = new Converter<>();
		String s = d.convertToString(34d);
		Double i = (Double) d.convertToNumber(s);
		System.out.println(i+30);

	}

}

class Converter<X> implements ConverterNumber<String>, ConverterString<X> {

	@Override
	public Double convertToNumber(String str) {		
			return Double.parseDouble(str);	
	}

	@Override
	public String convertToString(X t) {
		return String.valueOf(t);
	}
}

interface ConverterNumber<T> {
	Double convertToNumber(T t);
}

interface ConverterString<T> {
	String convertToString(T t);

}
