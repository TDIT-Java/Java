package org.SpringCore.SpringBeanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope // This scope by default is singleton so hashcode of this bean will be same
// if n no. of objects is there and here i can also change scope from singletone to prototype
// and in xml file also
public class TestAnnotation {

}
