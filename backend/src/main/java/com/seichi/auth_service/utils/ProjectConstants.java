package com.seichi.auth_service.utils;

import java.util.Locale;

/**
 * Created on October 2024
 *
 * @author Seichi
 */
public final class ProjectConstants {

	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final Locale ENGLISH_LOCALE = new Locale.Builder().setLanguage("en").setRegion("US").build();

	private ProjectConstants() {
		throw new UnsupportedOperationException();
	}
}
