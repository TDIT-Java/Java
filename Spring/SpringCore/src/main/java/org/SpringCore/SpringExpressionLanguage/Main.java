package org.SpringCore.SpringExpressionLanguage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringExpressionLanguageConfig.xml");

        Test test = context.getBean("test", Test.class);
        System.out.println(test);

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("100+10");
        System.out.println(expression.getValue(test));
    }
}
