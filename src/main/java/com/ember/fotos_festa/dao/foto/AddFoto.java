/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.dao.foto;

import com.ember.fotos_festa.model.foto.tbFotos;

/**
 *
 * @author paulo.bezerra
 */
public class AddFoto {

    public Integer AddScorecard(tbFotos foto) {
        
        int id = 0;

        //GRAVAR NO BANCO
        //indica as configuracoes do banco
        //PODE SER USAR MAIS DE UMA CLASSE SEPARANDO POR VIRGULAS NO tbPauta.class,tb...
        //Configuration con = new Configuration().configure().addAnnotatedClass(tbFotos.class);
        //SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        //Session session = sf.openSession();
       
        try {

            //inicia a transacao com o banco
           /// Transaction tx = session.beginTransaction();
            //id = (Integer) session.save(foto);

            //comita as informacoes
            //tx.commit();

        } catch(Exception e){
            
            System.out.println("Error "+e);
            
        }finally {
            //if (session != null) {
              //  session.close();
                //sf.close();
           // }
        }
        
        return  id;

    }

}
