package org.general;

import org.eclipse.paho.client.mqttv3.*;

/**
 * This class is a simple MQTT subscriber that listens to updates on the circle's position
 *
 * @author lucalini
 * @version 1.0
 */
public class Subscriber implements MqttCallback {

    private final static String BROKER = "tcp://broker.hivemq.com:1883";
    private final static String TOPIC = "software/360";
    private final static String CLIENT_ID = "ASU-subscriber";

    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient(BROKER, CLIENT_ID);
            Subscriber subscriber = new Subscriber();
            client.setCallback(subscriber);
            client.connect();
            System.out.println("Connected to BROKER: " + BROKER);
            client.subscribe(TOPIC);
            System.out.println("Subscribed to TOPIC: " + TOPIC);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection lost: " + throwable.getMessage());
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) {
        System.out.println("Message arrived. Topic: " + s +
                " Message: " + new String(mqttMessage.getPayload()));
        String payload = new String(mqttMessage.getPayload());
        String[] coordinates = payload.split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        System.out.printf("%d %d", x, y);
        Repository.getInstance().updateValue(x, y);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("Delivered complete: " + iMqttDeliveryToken.getMessageId());
    }

}
