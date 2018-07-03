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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author junior
 */
@Named(value = "indexMB")
@ViewScoped
public class IndexManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ProductFacade productFacade;
    private Product product;
    private List<Product> products;
    
    /**
     * Creates a new instance of IndexManagedBean
     */
    public IndexManagedBean() {
    }
    
    @PostConstruct
    void init(){
        product = new Product();
        products = productFacade.findAll();
    }
    
    public String saveProduct(){
        productFacade.create(product);
        return "index.xhtml?faces-redirect=true";
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
