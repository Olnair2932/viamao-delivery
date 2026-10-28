VIAMÃO DELIVERY API


API REST para gestão de pedidos e entregas de delivery.

Base URL: https://viamao-delivery-api.onrender.com

AVISO: O Render (plano gratuito) dorme após ~15 min sem uso.
Antes de testar, acorde a API:
  curl https://viamao-delivery-api.onrender.com/actuator/health

ORDERS (PEDIDOS)


1. CRIAR PEDIDO
   POST /orders

   curl:
   curl -X POST https://viamao-delivery-api.onrender.com/orders \
     -H "Content-Type: application/json" \
     -d '{"customerName":"Maria Silva","deliveryAddress":"Rua ABC, 123 - Viamão","totalAmount":59.90}'

   Body JSON:
   {
     "customerName": "Maria Silva",
     "deliveryAddress": "Rua ABC, 123 - Viamão",
     "totalAmount": 59.90
   }

2. BUSCAR PEDIDO POR ID
   GET /orders/{id}

   curl:
   curl https://viamao-delivery-api.onrender.com/orders/{id}

3. LISTAR TODOS OS PEDIDOS
   GET /orders

   curl:
   curl https://viamao-delivery-api.onrender.com/orders

4. FILTRAR POR STATUS
   GET /orders?status=EM_PREPARO

   curl:
   curl "https://viamao-delivery-api.onrender.com/orders?status=EM_PREPARO"

5. ATUALIZAR STATUS DO PEDIDO
   PUT /orders/{id}/status

   curl:
   curl -X PUT https://viamao-delivery-api.onrender.com/orders/{id}/status \
     -H "Content-Type: application/json" \
     -d '{"status":"EM_PREPARO"}'

   Status possíveis:
   CRIADO, AGUARDANDO_PAGAMENTO, PROCESSANDO_RECONCILIACAO,
   AGUARDANDO_ACEITE_LOJA, EM_PREPARO, PRONTO_PARA_ENVIO,
   AGUARDANDO_ENTREGADOR, EM_TRANSITO, ENTREGUE, CANCELADO,
   CANCELADO_COM_COMPENSACAO, EM_CONTESTE

DELIVERIES (ENTREGAS)


1. CRIAR ENTREGA
   POST /deliveries

   curl:
   curl -X POST https://viamao-delivery-api.onrender.com/deliveries \
     -H "Content-Type: application/json" \
     -d '{"orderId":"d93a3484-f80a-419b-a3bf-adc92e1cae4f","courierName":"Carlos Entregador"}'

2. BUSCAR ENTREGA POR ID
   GET /deliveries/{id}

3. BUSCAR ENTREGA POR PEDIDO
   GET /deliveries/by-order/{orderId}

   curl:
   curl https://viamao-delivery-api.onrender.com/deliveries/by-order/{orderId}

4. LISTAR TODAS AS ENTREGAS
   GET /deliveries

   curl:
   curl https://viamao-delivery-api.onrender.com/deliveries

5. ATUALIZAR STATUS DA ENTREGA
   PUT /deliveries/{id}/status

   curl:
   curl -X PUT https://viamao-delivery-api.onrender.com/deliveries/{id}/status \
     -H "Content-Type: application/json" \
     -d '{"status":"EM_TRANSITO"}'

   Status possíveis:
   PENDENTE, AGUARDANDO_ENTREGADOR, EM_TRANSITO, ENTREGUE, CANCELADA

HEALTH CHECK


GET /actuator/health

curl:
curl https://viamao-delivery-api.onrender.com/actuator/health

INTEGRAÇÃO COM AGENTECRAFT


  #1  Listar Pedidos | GET
      https://viamao-delivery-api.onrender.com/orders

  #2  Buscar Pedido | GET
      https://viamao-delivery-api.onrender.com/orders/{id}

  #3  Criar Pedido | POST
      https://viamao-delivery-api.onrender.com/orders

  #4  Atualizar Status | PUT
      https://viamao-delivery-api.onrender.com/orders/{id}/status

STACK


- Java 17 + Spring Boot 3.2
- PostgreSQL (Render) + Flyway
- Redis (Render)
- RabbitMQ (CloudAMQP)
- Resilience4j
- Hibernate Spatial
