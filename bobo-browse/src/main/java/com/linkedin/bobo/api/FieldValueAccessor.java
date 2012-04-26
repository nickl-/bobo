package com.linkedin.bobo.api;

public interface FieldValueAccessor {
	String getFormatedValue(int index);
	Object getRawValue(int index);
}
