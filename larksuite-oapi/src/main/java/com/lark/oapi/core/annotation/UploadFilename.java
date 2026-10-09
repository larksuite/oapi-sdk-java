package com.lark.oapi.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Associates a multipart file with the body field that explicitly overrides its filename. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UploadFilename {
    String value();
}
