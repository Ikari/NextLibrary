/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.next.nextlibrary.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.NoResultException;
import br.next.nextlibrary.model.Usuario;

/**
 *
 * @author roger.roliveira
 */
public class UsuarioDAO {
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("librarypu");
    private EntityManager manager = factory.createEntityManager();
    
    public Usuario obterUsuario(String username, String password){
        try
        {
            Usuario usuario = (Usuario)manager
                    .createQuery("select u from Usuario u where u.userName = :username and u.password = :password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            
            return usuario;
        }
        catch(NoResultException e){
            return null;
        }
    }
    
    public boolean inserirUsuario(Usuario usuario){
        try
        {
            manager.persist(usuario);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean excluirUsuario(Usuario usuario){
        try
        {
            manager.remove(usuario);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
