/*
 * CC BY-NC-SA 4.0
 *
 * Copyright 2022 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;.
 *
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 *
 * You are free to:
 *   Share - copy and redistribute the material in any medium or format
 *   Adapt - remix, transform, and build upon the material
 *
 * Under the following terms:
 *   Attribution - You must give appropriate credit, provide 
 *   a link to the license, and indicate if changes were made.
 *   You may do so in any reasonable manner, but not in any 
 *   way that suggests the licensor endorses you or your use.
 *   NonCommercial - You may not use the material for commercial purposes.
 *   ShareAlike - If you remix, transform, or build upon the 
 *   material, you must distribute your contributions under 
 *   the same license as the original.
 *   No additional restrictions - You may not apply legal 
 *   terms or technological measures that legally restrict 
 *   others from doing anything the license permits.
 *
 * Notices:
 *   You do not have to comply with the license for elements 
 *   of the material in the public domain or where your use 
 *   is permitted by an applicable exception or limitation.
 *   No warranties are given. The license may not give you 
 *   all of the permissions necessary for your intended use. 
 *   For example, other rights such as publicity, privacy, 
 *   or moral rights may limit how you use the material.
 */
package io.github.guisso.carrinhocompras;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe Item
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-09-20
 */
public class Item {

    private double quantidade;
    private Produto produto;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Item() {
    }

    public Item(double quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    //</editor-fold>

    public BigDecimal calcularPreco() {
        // Passo a passo
//        BigDecimal quantidade = new BigDecimal(this.quantidade);
//        BigDecimal precoProduto = produto.getPreco();
//        return quantidade.multiply(precoProduto);
        
        // Resposta direta: preço do produto x quantidade
//        return produto.getPreco().multiply(new BigDecimal(quantidade));

        // Resposta direta: quantidade x preço do produto
        return new BigDecimal(quantidade).multiply(produto.getPreco());
    }

    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.produto.getCodigo());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "Item : {"
                + "quantidade : " + quantidade
                + ", produto : " + produto
                + ", preco :" + calcularPreco()
                + '}';
    }
    //</editor-fold>

}
