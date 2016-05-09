package pl.noiseapps.loggr;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ObjectLogger {

    private static final String NULL_MSG = "Object is null";
    private static final String PRIMITIVE_MSG = "%s = %s";

    static String getObjectRepresentation(Object object) {
        if (object == null) {
            return NULL_MSG;
        }
        final Class klass = object.getClass();
        if (klass.isPrimitive()) {
            return String.format(PRIMITIVE_MSG, klass.getSimpleName(), String.valueOf(klass));
        }
        final Field[] classFields = klass.getDeclaredFields();

        final StringBuilder builder = new StringBuilder(klass.getSimpleName()).append("={").append(System.getProperty("line.separator"));

        for (Field classField : classFields) {
            try {
                boolean isStatic = Modifier.isStatic(classField.getModifiers());
                boolean setAccessible = !Modifier.isPublic(classField.getModifiers());
                if (setAccessible) {
                    classField.setAccessible(true);
                }
                if (isStatic) {
                    builder.append("\t").append(classField.getName()).append("=").append(classField.get(null));
                } else {
                    builder.append("\t").append(classField.getName()).append("=").append(classField.get(object));
                }
            } catch (IllegalAccessException iae) {
                builder.append("\t").append(classField.getName()).append("=INVISIBLE");
            }
            builder.append(System.getProperty("line.separator"));
        }
        builder.append("}");
        return builder.toString();
    }
}