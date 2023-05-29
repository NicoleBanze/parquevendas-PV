/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Funcionario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persist.HibernateUtil;

/**
 *
 * @author 25885
 */
public class FuncionarioDAO {
    public void inserirFuncionario(Funcionario funcionario) {
        Session sessao=null;
        try{
            sessao=HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.save(funcionario);
            sessao.getTransaction().commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            sessao.getTransaction().rollback();
        }finally{
            if(sessao!=null){
                sessao.close();
            }
        }
    }

    public void actualizarFuncionario(Funcionario funcionario) {
                Session sessao=null;
        try{
            sessao=HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.update(funcionario);
            sessao.getTransaction().commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            sessao.getTransaction().rollback();
        }finally{
            if(sessao!=null){
                sessao.close();
            }
        }
    }

    public void apagarFuncionario(Funcionario funcionario) {
               Session sessao=null;
        try{
            sessao=HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.delete(funcionario);
            sessao.getTransaction().commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            sessao.getTransaction().rollback();
        }finally{
            if(sessao!=null){
                sessao.close();
            }
        }
    }

    public List<Funcionario> apresentarFuncionario() {
        Session sessao=null;
        List<Funcionario>listaFuncionarios=null;
        try {
            sessao=HibernateUtil.getSessionFactory().openSession();
            Query query=sessao.createQuery("from Funcionario");
            listaFuncionarios=(List<Funcionario>)query.list();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        finally{
            if(sessao!=null){
                sessao.close();
            }
        } 
        return listaFuncionarios;
    }
}
