/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserListDAO;
import entity.UserList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author said
 */
@Named(value = "userListController")
@SessionScoped
public class UserListController implements Serializable {
    
    private UserListDAO ul_doa = new UserListDAO();
    private UserList ul = new UserList();
    
    public UserListController() {
    }

    public UserListDAO getUl_doa() {
        return ul_doa;
    }

    public void setUl_doa(UserListDAO ul_doa) {
        this.ul_doa = ul_doa;
    }

    public UserList getUl() {
        return ul;
    }

    public void setUl(UserList ul) {
        this.ul = ul;
    }
    
    public String enter() {
        if("admin".equals(this.ul.getUsername()) && "admin".equals(this.ul.getPassword())) {
    		return "main";
    	} else {	
    		return "index";
    	}
    }
}
