/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.edu.ec;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 *
 * @author Vane
 */
@MessageDriven(mappedName = "jms/QueueTest", 
        activationConfig = {
    @ActivationConfigProperty(propertyName = 
        "acknowledgeMode", 
        propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = 
        "destinationType", 
        propertyValue = "javax.jms.Queue")
})

public class TestMessageBean implements MessageListener{

    @Override
    public void onMessage(Message message) {
    try { 
        System.out.println("read a text message:"+ ((TextMessage)message).getText()); 
    } 
    catch (JMSException ex) 
    { 
        System.out.println("Error mensaje"); 
    } 
    }
    
}
