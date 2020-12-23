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
public class UpdateFotoDAO {

    public boolean Update(tbFotos foto) {
                
        //indica as configuracoes do banco
        Configuration con = new Configuration().configure().addAnnotatedClass(tbFotos.class);
        SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        Session session = sf.openSession();

        //abre sessao com o banco
        session = sf.openSession();

        //AQUI FAZ O UPDATE  NO BANCO COM OS DADOS NOVOS
        try {

            //inicia a transacao com o banco
            Transaction tx = session.beginTransaction();
            session.update(foto);

            //comita as informacoes
            tx.commit();

        } finally {
            if (session != null) {
                session.close();
                sf.close();
            }
        }
        return true;
    }

}
