package ecommerce.filasqs.Controller;



import ecommerce.filasqs.Contract.Pedido;
import ecommerce.filasqs.service.EnviaPedidoDeCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
public class PedidosController {

    @Autowired
    EnviaPedidoDeCompra enviaPedidoDeCompra;

    @PostMapping("/{numero_pedido}")
    public Pedido realizaPedido(
            @PathVariable int numero_pedido,
            @RequestBody Pedido pedido) {

        enviaPedidoDeCompra.enviaPedido(pedido);

        return null;
    }

}
