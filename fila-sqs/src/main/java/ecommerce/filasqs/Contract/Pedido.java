package ecommerce.filasqs.Contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Pedido {

    @JsonProperty("numero_pedido")
    private int numeroPedido;

    @JsonProperty("nome_cliente")
    private String nomeCliente;

    @JsonProperty("nome_produto")
    private String nomeProduto;

    @JsonProperty("qtd_produto")
    private int qtdProduto;

    @JsonProperty("endereco_entrega")
    private String endEntrega;

}
