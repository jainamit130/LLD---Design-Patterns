package BehavioralPatterns.StatePattern;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        JButton home = new JButton("Home");
        home.addActionListener(e -> System.out.println(phone.getState().onHome()));
        JButton onOff = new JButton("On/Off");
        onOff.addActionListener(e -> System.out.println(phone.getState().onPower()));
        home.doClick();
        onOff.doClick();


    }
}
