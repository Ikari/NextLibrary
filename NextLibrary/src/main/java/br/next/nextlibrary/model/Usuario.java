/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.next.nextlibrary.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author roger.roliveira
 */
@Entity
public class Usuario {
    @Id
    @Column(name="id", nullable=false, unique=true)
    private int id;
    
    @Column(name="username", nullable=false, unique=true)
    private String userName;
    
    @Column(name="password", nullable=false)
    private String password;
    
    @Column(name="ultimoacesso")
    @Temporal(TemporalType.DATE)
    private Date ultimoAcesso;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the ultimoAcesso
     */
    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    /**
     * @param ultimoAcesso the ultimoAcesso to set
     */
    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
}
