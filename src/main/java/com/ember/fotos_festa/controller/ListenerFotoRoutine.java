/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.controller;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 * Simple demo that uses java.util.Timer to schedule a task to execute once 5
 * seconds have passed.
 *
 */
public class ListenerFotoRoutine {

    Timer timer;

    int i = 0;

    public ListenerFotoRoutine(int seconds) {

        //timer.cancel();
        timer = new Timer();

        timer.schedule(new RemindTask(), seconds * 1000);

    }

    class RemindTask extends TimerTask {

        private boolean hasStarted = false;

        @Override
        public void run() {
            this.hasStarted = true;

            timer.cancel();
            timer = new Timer();

            String dataatual = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

            //DEFINE A CADA QUANTOS SEGUNDOS ATUALIZA
            timer.schedule(new RemindTask(), 10*1000);


            String horaAtual = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());

            // DIA DA SEMANA
            Calendar calendar = Calendar.getInstance();
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            // Get weekday name
            DateFormatSymbols dfs = new DateFormatSymbols();

            System.out.println(dataatual);

        }

    }
    
    public static void main(String[] args) {
          
          
          
        
    }

}
