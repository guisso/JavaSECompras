package io.github.guisso.carrinhocompras;

import java.math.BigDecimal;

/**
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 */
public class CarrinhoCompras {

    public static void main(String[] args) {

        Produto arroz
                = new Produto(
                        123L,
                        "Arroz Integral",
                        new BigDecimal("7.89"));

        Produto feijao
                = new Produto(
                        234L,
                        "Feijão Carioquinha",
                        new BigDecimal("8.90"));

        Produto macarrao
                = new Produto(
                        345L,
                        "Macarrão Integral",
                        new BigDecimal("9.01"));

        Compra compra = new Compra();
        compra.setNotaFiscal(987654321L);

        // Insere novos itens à compra
        compra.acrescentarItem(new Item(2, arroz));
        compra.acrescentarItem(new Item(4, feijao));
        compra.acrescentarItem(new Item(6, macarrao));

        System.out.println("1 > " + compra);

        // Remove um item da compra
        compra.removerItem(new Item(0, feijao));

        System.out.println("2 > " + compra);

        // Insere e depois altera um item da compra
        compra.acrescentarItem(new Item(1, feijao));
        compra.acrescentarItem(new Item(10, feijao));

        System.out.println("3 > " + compra);

    }
}
