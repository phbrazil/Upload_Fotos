package com.ember.fotos_festa.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * @author Paulo
 */
@SuppressWarnings("serial")
@WebServlet(name = "ListenerFotoStarter")
public class ListenerFotoStarter extends HttpServlet {
    

    public void init(HttpSession sessao) throws ServletException {

        ListenerFotoRoutine rotina = new ListenerFotoRoutine(1);
        
        sessao.setAttribute("qtd", 1);
        
        System.out.println("started");
    }

}
