package ecommerce.filasqs.service;


import ecommerce.filasqs.Contract.Pedido;

public interface EnviaPedidoDeCompra {

    boolean enviaPedido(Pedido pedido);
}
