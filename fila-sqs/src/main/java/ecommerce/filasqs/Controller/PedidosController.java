package ecommerce.filasqs.Controller;



import ecommerce.filasqs.Contract.Pedido;
import ecommerce.filasqs.service.EnviaPedidoDeCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class PedidosController {

    @Autowired
    EnviaPedidoDeCompra enviaPedidoDeCompra;

    @PostMapping("/pedidos")
    public ResponseEntity<Object> realizaPedido(
            @RequestBody Pedido pedido) {

        enviaPedidoDeCompra.enviaPedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
