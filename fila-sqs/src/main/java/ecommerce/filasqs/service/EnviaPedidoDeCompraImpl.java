package ecommerce.filasqs.service;

import ecommerce.filasqs.Contract.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EnviaPedidoDeCompraImpl implements EnviaPedidoDeCompra{

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    public boolean enviaPedido(Pedido pedido){

        this.queueMessagingTemplate.
                send("testeDiego", MessageBuilder.withPayload(pedido).build());

        return true;
    }
}
