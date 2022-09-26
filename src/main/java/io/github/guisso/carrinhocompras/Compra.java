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
import java.util.ArrayList;

/**
 * Classe Compra
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-09-20
 */
public class Compra {

    private long notaFiscal;
    
    // NetBeans sugere que esta propriedade pode final, ou seja,
    // imutável após a inicialização. Isto ocorre porque o único
    // objeto possível de ser atribuído a "itens" é definido no
    // construtor. E não há métodos getter/setter para "itens".
    // private final ArrayList<Item> itens;
    private ArrayList<Item> itens;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Compra() {
        itens = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public long getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(long notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    //</editor-fold>

    public void acrescentarItem(Item item) {
        // OPÇÃO A
//        // Item já existe (mesmo produto já incluído) ...
//        if (itens.contains(item)) {
//            // ... substitui o item anterior pelo atual
//            itens.set(itens.indexOf(item), item);
//        } else {
//            // ... ou apenas inclui o novo item
//            itens.add(item);
//        }
//
        // OPÇÃO B
        // Localiza a potencial posição do item a ser incluído
        // Emprega equals() de Item, ou seja, atualmente compara
        // os códigos dos produtos entre si
        int idx = itens.indexOf(item);
        // Se o item já existe (mesmo produto já incluído) ...
        if (idx > -1) {
            // ... substitui o item anterior pelo atual
            itens.set(idx, item);
            // ... OU acrescenta a nova quantidade ao atual
//            itens.set(idx, new Item(
//                    itens.get(idx).getQuantidade()
//                    + item.getQuantidade(),
//                    item.getProduto()));
        } else {
            // ... ou apenas inclui o novo item
            itens.add(item);
        }

        // OPÇÃO C
        //
        // No algoritmo A havia uma consulta (contains) anterior
        // à potencial substituição gerando processamento extra
        //
        // No próximo algoritmo a substituição é tentada a priori 
        // ou a inclusão é executada caso a substituição falhe
        //
//        try {
//            itens.set(itens.indexOf(item), item);
//        } catch (Exception e) {
//            itens.add(item);
//        }
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }
    
    public void removerItem(int indice) {
        itens.remove(indice);
    }

    public BigDecimal calcularTotal() {
        // ... = new BigDecimal(0)
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : itens) {
            total = total.add(item.calcularPreco());
        }
        return total;
    }

    //<editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "Compra : {"
                + "notaFiscal : " + notaFiscal
                // toString() de cada Item no arranjo-lista é invocado
                + ", itens : " + itens
                + ", total : " + calcularTotal()
                + '}';
    }
    //</editor-fold>

}
