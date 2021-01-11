/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.controller;

import org.json.JSONObject;
import com.ember.fotos_festa.dao.foto.AddFotoDAO;
import com.ember.fotos_festa.dao.foto.UpdateFotoDAO;
import com.ember.fotos_festa.dao.foto.getFotoDAO;
import com.ember.fotos_festa.model.foto.tbFotos;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
//import com.oreilly.servlet.MultipartRequest;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "addFotos", urlPatterns = {"/addFoto"})
public class addFoto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tempPath = "/home/opportunity/tempFotos/";
        //String tempPath = "/Users/Paulo/NetBeansProjects/Fotos_Festa/tempFotos/";
        //String tempPath = "/Users/killuminatti08/NetBeansProjects/Fotos_Festa/tempFotos/";

        MultipartRequest m = new MultipartRequest(request, tempPath, 26214400, "UTF-8");

        if (m.getParameter("token").equals("9ember_2020")) {

            String name = m.getParameter("name");

            String email = m.getParameter("email");

            String message = m.getParameter("message");

            String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

            tbFotos foto = new tbFotos(1, name, email, message, "", date);

            String destPath = "/opt/tomcat/apache-tomee-webprofile-7.0.2/webapps/fotosFesta/";
            //String destPath = "/Users/Paulo/NetBeansProjects/Fotos_Festa/src/main/webapp/fotosFesta/";
            //String destPath = "/Users/killuminatti08/NetBeansProjects/Fotos_Festa/src/main/webapp/fotosFesta/";

            AddFotoDAO add = new AddFotoDAO();

            int id = add.AddFoto(foto);

            getFotoDAO getFoto = new getFotoDAO();

            foto = getFoto.getFoto(id);

            if (foto != null) {

                //String slash = "\\";
                String slash = "/";

                //GRAVAR ANEXOS
                File destFile = new File(destPath + String.valueOf(foto.getId()));

                if (!destFile.exists()) {
                    if (destFile.mkdir()) {
                        System.out.println("Diretório criado no caminho " + String.valueOf(destFile));
                    } else {
                        System.out.println("Falha ao criar o diretório " + String.valueOf(destFile));
                    }
                }
                File tempFile = new File(tempPath);

                try {

                    FileUtils.copyDirectory(tempFile, destFile);
                    System.out.println("Arquivo copiado da temp para arquivos");

                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    FileUtils.deleteDirectory(tempFile);
                    System.out.println("Pasta temp deletada");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                tempFile.mkdir();
                System.out.println("Pasta temp criada novamente");

                List<String> fileNames = new ArrayList<>();

                // gravar nomes dos arquivos
                String[] files = destFile.list();
                if (files.length == 0) {
                    System.out.println("Pasta de arquivos vazia");
                } else {
                    for (String aFile : files) {
                        fileNames.add(String.valueOf(aFile));
                        System.out.println("arquivo " + aFile + " adicionado na lista");

                        foto.setPath("/fotosFesta/" + foto.getId() + slash + aFile);

                    }
                }

                UpdateFotoDAO update = new UpdateFotoDAO();

                update.Update(foto);

                JSONObject status = new JSONObject();

                status.put("status", "success");

                response.sendRedirect("index.html#post-images");
                //response.sendRedirect("messages/success.html");

            } else {
                response.sendRedirect("index.html#post-images");
                //response.sendRedirect("messages/success.html");

            }

            //String projectJsonString = this.gson.toJson(projeto);
            /*PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(status);
            out.flush();*/
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
