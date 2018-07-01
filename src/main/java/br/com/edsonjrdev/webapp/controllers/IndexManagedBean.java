/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonjrdev.webapp.controllers;

import br.com.edsonjrdev.webapp.entities.Product;
import br.com.edsonjrdev.webapp.model.ProductFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author junior
 */
@Named(value = "indexMB")
@SessionScoped
public class IndexManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProductFacade productFacade;

    /**
     * Creates a new instance of IndexManagedBean
     */
    public IndexManagedBean() {
    }
    
    
    public List<Product> allProducts(){
        return this.productFacade.findAll();
    }
}
