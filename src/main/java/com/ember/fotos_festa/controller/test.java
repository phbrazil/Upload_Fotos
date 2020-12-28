/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.controller;

/**
 *
 * @author killuminatti08
 */
public class test {

    public static void main(String[] args) throws InterruptedException {

        long t = System.currentTimeMillis();
        
        System.out.println("t: "+t);
        long end = t + 3600000;
        System.out.println("end: "+end);
        while (System.currentTimeMillis() < end) {
            System.out.println(System.currentTimeMillis());
            System.out.println("reading");
            // do something
            // pause to avoid churning
            Thread.sleep(5000);
        }

    }

}
