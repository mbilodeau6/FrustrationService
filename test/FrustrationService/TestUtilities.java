package FrustrationService;

import java.lang.reflect.Field;

public class TestUtilities {
	@SuppressWarnings("unchecked")
	public static <T> T getPrivateFieldValue(Object object, String privateFieldName) {
		try {
		Field privateField = object.getClass().getDeclaredField(privateFieldName);
		privateField.setAccessible(true);
	
		return (T) privateField.get(object);
		}
		catch (IllegalAccessException | NoSuchFieldException e)
		{
			System.out.println("UNEXPECTED EXCEPTION: " + e.getMessage());
			return null;
		}
	}
}
