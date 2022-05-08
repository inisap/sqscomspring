package ecommerce.filasqs.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ecommerce.filasqs.Contract.Pedido;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EnviaPedidoDeCompraImpl implements EnviaPedidoDeCompra{

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @Value("${aws.queue.name}")
    private String queueName;

    public boolean enviaPedido(Pedido pedido){

        ObjectMapper mapper = new ObjectMapper();
        String stringJson = null;
        try {
            stringJson = mapper.writeValueAsString(pedido);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Message<String> msg = MessageBuilder.withPayload(stringJson)
                .setHeader("TransactionId", "123")
                .setHeaderIfAbsent("country", "BR")
                .build();

        // Enviando a mensagem criada para o a fila "testQueue"
        queueMessagingTemplate.convertAndSend(queueName, msg);

        return true;
    }
}
