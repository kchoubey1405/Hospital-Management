package com.myproject.persistent.util;

public abstract class BaseDto {

	protected boolean isNullable = true;

	public abstract Boolean getValidForUsage();
}
