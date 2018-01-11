/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prashantp.starter.cdise.annotationliteral;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

/**
 *
 * @author prashantp
 */
interface OrderProcessor {
    public void test();
}

@OrderPlaced
class OrderPlacedProcessor implements OrderProcessor {
    @Override public void test() { 
        System.out.println("OrderPlaced");
    }
}

@OrderCancelled
class OrderCancelledProcessor implements OrderProcessor {
    @Override public void test() { 
        System.out.println("OrderCancelled");
    }
}

@ApplicationScoped
public class Test {

    @Inject
    @OrderPlaced
    private OrderProcessor processorA;
    
    @Inject
    @OrderCancelled
    private OrderProcessor processorB;

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            Test appInstance = container
                    .select(Test.class)
                    .get();

            appInstance.doWork();
        }
    }

    public void doWork() {
        //Use Qualifier types to trigger the injected instance
        processorA.test(); //Invokes class having @OrderPlaced
        processorB.test(); //Invokes class having @OrderCancelled
    }

}
