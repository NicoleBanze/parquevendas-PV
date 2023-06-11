/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Viatura;

/**
 *
 * @author 25885
 */
@Stateless
public class ViaturaFacade extends AbstractFacade<Viatura> {
    @PersistenceContext(unitName = "parquePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViaturaFacade() {
        super(Viatura.class);
    }
    
}
