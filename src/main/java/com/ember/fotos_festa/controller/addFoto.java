/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.controller;

import org.json.JSONObject;
import com.ember.fotos_festa.dao.foto.AddFotoDAO;
import com.ember.fotos_festa.model.foto.tbFotos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "addFotos", urlPatterns = {"/API/addFoto"})
public class addFoto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("token").equals("9ember_2020")) {
            
            String name = request.getParameter("name");
            
            String email = request.getParameter("email");
            
            String message = request.getParameter("message");

            String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

            tbFotos foto = new tbFotos(1, name, email, message, "/home/documents", date);
            
            AddFotoDAO add = new AddFotoDAO();
            
            add.AddFoto(foto);
            
            JSONObject status = new JSONObject();
            
            status.put("status", "success");

            //String projectJsonString = this.gson.toJson(projeto);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(message);
            out.flush();

        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print("Bad Token Code");
            out.flush();

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("entrei no post API");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
