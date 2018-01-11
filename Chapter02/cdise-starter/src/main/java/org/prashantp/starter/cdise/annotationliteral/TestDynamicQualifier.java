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
@ApplicationScoped
public class TestDynamicQualifier {
    
    @Inject
    private Event<ShopOrder> noQualifierEvent;
    
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
        ShopOrder shopOrder = new ShopOrder();
        //Selection of Qualifier at runtime
        noQualifierEvent.select(new AnnotationLiteral<OrderPlaced>() {
        }).fire(shopOrder);
        
        noQualifierEvent.select(new AnnotationLiteral<OrderCancelled>() {
        }).fire(shopOrder);
    }
    
    public void orderPlaced(@Observes @OrderPlaced ShopOrder newOrder) {
        System.out.println("OrderPlaced");
    }
    
    public void orderCancelled(@Observes @OrderCancelled ShopOrder newOrder) {
        System.out.println("OrderCancelled");
    }
}
