/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.dao.foto;

import com.ember.fotos_festa.model.foto.tbFotos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author paulo.bezerra
 */
public class AddFotoDAO {

    public Integer AddFoto(tbFotos foto) {
        
        int id = 0;

        //GRAVAR NO BANCO
        //indica as configuracoes do banco
        //PODE SER USAR MAIS DE UMA CLASSE SEPARANDO POR VIRGULAS NO tbPauta.class,tb...
        Configuration con = new Configuration().configure().addAnnotatedClass(tbFotos.class);
        SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        Session session = sf.openSession();
       
        try {

            //inicia a transacao com o banco
            Transaction tx = session.beginTransaction();
            id = (Integer) session.save(foto);

            //comita as informacoes
            tx.commit();

        } catch(Exception e){
            
            System.out.println("Error uploading image: "+e);
            
        }finally {
            if (session != null) {
                session.close();
                sf.close();
            }
        }
       
        
        return  id;

    }

}
