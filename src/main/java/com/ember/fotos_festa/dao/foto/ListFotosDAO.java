/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ember.fotos_festa.dao.foto;

import com.ember.fotos_festa.model.foto.tbFotos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author paulo.bezerra
 */
public class ListFotosDAO {

    public  List<tbFotos> List() {
        
        //indica as configuracoes do banco
        Configuration con = new Configuration().configure().addAnnotatedClass(tbFotos.class);
        SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        Session session = sf.openSession();
        List<tbFotos> fotos;

        try {
            

            Transaction tx = session.beginTransaction();

            String hql = "from tbFotos";

            fotos = session.createQuery(hql).list();

            //comita as informacoes
            tx.commit();
            
        } finally {
            if (session != null) {
                session.close();
                sf.close();
            }

        }
        

        return fotos;
    }

}
