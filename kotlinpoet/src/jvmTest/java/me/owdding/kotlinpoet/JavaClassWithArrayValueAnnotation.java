package me.owdding.kotlinpoet;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static me.owdding.kotlinpoet.JavaClassWithArrayValueAnnotation.AnnotationWithArrayValue;

@AnnotationWithArrayValue({
    Object.class, Boolean.class
})
public class JavaClassWithArrayValueAnnotation {

  @Retention(RetentionPolicy.RUNTIME)
  @interface AnnotationWithArrayValue {
    Class[] value();
  }

}
