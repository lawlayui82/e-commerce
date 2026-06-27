# Spring Boot E-Commerce Core (Monolith)
This project is an e-commerce core backend built using Spring Boot. The main focus of this project is Transaction Management (ACID) implementation, stock validation, and OAuth2 integration.

---

## Main Features
[] **Step 1:** Product Management & Database Synchronization (Product and Stock List)
[] **Step 2:** Secure Transaction Logic (`@Transactional`) for *Checkout* feature.
[] **Step 3:** Simple Admin/User Interface using Spring MVC + Thymeleaf.
[] **Step 4:** OAuth2 Client Integration (Login via Google/Facebook).
[] **Step 5:** REST Integration with E-Banking Simulation Application.

---

## Tech Stack
- **Framework:** Spring Boot 3.x
- **Language:** Java 17 / 21
- **Database:** MySQL
- **ORM:** Spring Data JPA + Hibernate
- **Template Engine:** Thymeleaf (HTML5)

---

## Database Schema

### 1. Product Entity
| Field | Type | Constraint | Information |
| :--- | :--- | :--- | :--- |
| `id` | Long | PK, Auto Increment | ID product |
| `name` | String | Not Null | Name Prodcut |
| `price` | BigDecimal | Not Null | Price product |
| `stock` | Integer | Not Null | Number of stocks available |

### 2. Order Entity
| Field | Type | Constraint | Information |
| :--- | :--- | :--- | :--- |
| `id` | Long | PK, Auto Increment | ID order |
| `product_id` | Long | FK to product | Refrence product |
| `quantity` | Integer | Not Null | Quantity purchased |
| `total_price` | BigDecimal | Not Null | `price` x `quantity` |
| `status` | enum(PENDING_PAYMENT, PAID, FILED) | current status |  

---

## Checkout Transaction Logic Flow (`OrderService.checkout()`)
When *Client* triggers *Checkout* function, the system is required to execute the following sequence of operations within a single transaction block:

[Start Transaction]
|
v
Check Product Existence?
|---> (Not Available) ---> Throw ProductNotFoundException -> [Rollback]
v (Yes)
Check Stock Sufficient?
|---> (Stock < Quantity) ---> Throw InsufficientStockException -> [Rollback]
v (Sufficient)
Reduce Product Stock & Save
|
v
Create New Order Record (Status: PENDING_PAYMENT) & Save
|
v
[Commit Transaction] -> Stock Changed in Database & Order Created

---

## How to Run the Project (Locally)
1. Clone this repository.
2. Adjust the database configuration in `src/main/resources/application.properties`.
3. Run the command `./mvnw spring-boot:run`.