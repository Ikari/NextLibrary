/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.next.nextlibrary.beans;

import br.next.nextlibrary.model.Usuario;
import br.next.nextlibrary.dal.UsuarioDAO;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author roger.roliveira
 */
@ManagedBean(name="LoginManagedBean")
@ViewScoped
public class LoginManagedBean implements Serializable {
    
    private UsuarioDAO dao = new UsuarioDAO();
    private Usuario usuario = new Usuario();
    
    public String envia(){
        
        usuario = dao.obterUsuario(usuario.getUserName(), usuario.getPassword());
        
        if (usuario == null)
        {
            usuario = new Usuario();
            FacesContext.getCurrentInstance()
                    .addMessage(null, 
                                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                "Usuário não encontrado!", 
                                                "Erro no login!"
                                                )
                                );
            return null;
        }
        else
        {
            return "/main";
        }        
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
