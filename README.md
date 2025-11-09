# OrderSyncSoap

A Spring Boot application providing a SOAP-based API for creating orders, with persistence in PostgreSQL and event publishing via Kafka.

## Overview

`OrderSyncSoap` is a SOAP web service that allows clients to create orders through a `CreateOrder` operation. Orders are persisted in a PostgreSQL database using Spring Data JPA and published as events to a Kafka topic (`order-created`). The project uses Java 25, Spring Boot 3.3.4, and Spring Web Services.

### Features
- SOAP endpoint at `http://localhost:8080/ws` for order creation.
- Persists orders in PostgreSQL with Spring Data JPA.
- Publishes order creation events to Kafka.
- Configurable via `application.properties`.

## Prerequisites
- **Java 25** (or Java 21 as fallback)
- **Maven 3.9+**
- **PostgreSQL 14+** (running locally or via Docker)
- **Kafka and ZooKeeper** (via Docker Compose)
- **Postman** or SoapUI for testing SOAP requests

## Setup Instructions

### 1. Configure Dependencies
Ensure Maven resolves all dependencies in `pom.xml`:
```bash
mvn clean install
```

### 2. Run the Application
```bash
mvn spring-boot:run
```
The application starts on `http://localhost:8080`. The WSDL is available at `http://localhost:8080/ws/order-service.wsdl`.

## Usage

### Testing the SOAP API
Use Postman or SoapUI to send a SOAP request to `http://localhost:8080/ws`.

#### Example SOAP Request
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ord="http://example.com/orders">
    <soap:Header/>
    <soap:Body>
        <ord:CreateOrderRequest>
            <ord:customerName>John Doe</ord:customerName>
            <ord:totalAmount>100.0</ord:totalAmount>
        </ord:CreateOrderRequest>
    </soap:Body>
</soap:Envelope>
```

#### Postman Configuration
- **Method**: POST
- **URL**: `http://localhost:8080/ws`
- **Headers**:
    - `Content-Type: text/xml`
    - `SOAPAction: http://example.com/orders/CreateOrder`
- **Body**: Raw XML (above)

#### Expected Response
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Body>
        <ns2:CreateOrderResponse xmlns:ns2="http://example.com/orders">
            <ns2:orderId>1</ns2:orderId>
        </ns2:CreateOrderResponse>
    </soap:Body>
</soap:Envelope>
```

### Kafka Events
- Orders created are published to the `order-created` topic.
- The `OrderConsumer` logs events to the console (e.g., `Evento recebido: Order created: 1`).

## Troubleshooting
- **404 Error on `/ws`**: Ensure `WebServiceConfig.java` and `order-service.xsd` are present and correctly configured. Check `http://localhost:8080/ws/order-service.wsdl`.
- **Compilation Error**: Update Lombok to `1.18.34` and `maven-compiler-plugin` to `3.13.1` in `pom.xml`. Run `mvn clean install -e -X` for debug output.
- **Database Issues**: Verify PostgreSQL is running and credentials match `application.properties`.

## Contributing
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit changes (`git commit -m "Add your feature"`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

## License
This project is licensed under the MIT License.

---

### Notes
- **Project Name**: Used `OrderSyncSoap` as suggested in the previous response.
- **Content**: Covers setup, usage, and troubleshooting, addressing the 404 error and compilation issues you faced.
- **Assumptions**: Assumes the project is fully functional after your last message ("feito, tudo funcionando").
- **Customization**: If you want to adjust the project name, add more details (e.g., specific contributors, license), or include additional sections, let me know!
