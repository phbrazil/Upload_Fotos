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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        //API JSON
        ListFotosDAO list = new ListFotosDAO();

        List<tbFotos> fotos = list.List();

        request.setAttribute("fotos", fotos);
        List<String> current = new ArrayList<>();

                
        for (int i = 0; i < fotos.size(); i++) {

            current.add(fotos.get(i).getId().toString());
        }

        request.setAttribute("current", current);

        sessao.setAttribute("qtd", fotos.size());

        request.getRequestDispatcher("mensagem.jsp").forward(request, response);
        //request.getRequestDispatcher("carrousel.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
