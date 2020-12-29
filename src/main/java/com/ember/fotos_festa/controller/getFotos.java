/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.controller;

//import com.google.gson.Gson;
import com.ember.fotos_festa.dao.foto.ListFotosDAO;
import com.ember.fotos_festa.model.foto.tbFotos;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "getFotos", urlPatterns = {"/API/getFotos"})
public class getFotos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //API JSON
        if (request.getParameter("token").equals("9ember_2020")) {

            Gson gson = new Gson();

            ListFotosDAO list = new ListFotosDAO();
            List<tbFotos> fotos = list.List();

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
            response.setCharacterEncoding("UTF-8");
            out.print(gson.toJson(fotos));
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

        //API JSON
        if (request.getParameter("token").equals("9ember_2020")) {

            Gson gson = new Gson();

            ListFotosDAO list = new ListFotosDAO();
            List<tbFotos> fotos = list.List();

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
            response.setCharacterEncoding("UTF-8");
            out.print(gson.toJson(fotos));
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
