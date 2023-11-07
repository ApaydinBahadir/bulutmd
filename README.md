# BulutMD Backend Project

## Overview
This demo project contains pure backend food application for BulutMD.

## Development Environment
- MySQL
- Spring Boot
- Spring Boot JPA
- ModelMapper
- Lombok

## How To Run
1. Clone this repository.
2. Use script on files for crate your database or after running project database will be created by hibernate automatically.
3. Change application.properties files for your MySQL.
4. Open project from an ide.
5. Run project from BulutmdApplication.java.

## Rest API's
### Food Service
Add food to database
```
POST localhost:8080/api/foods/addFood
Request Body
{
    "name": <food_name>
    "price": <food_price>
}

Return
{
    "success": <success>
    "message": <message>
}
```

Get all food data
```
GET localhost:8080/api/foods/getFoods

Return
{
    "success": <success>
    "data"   : <food_data>
    "message": <message>
}
```

### Order Service
Create order
```
POST localhost:8080/api/orders/createOrder
Request Body
{
    "name"    : <customer_name>
    "foodName": <food_name>
}

Return
{
    "success": <success>
    "message": <message>
}
```

Get order by customer name
```
GET localhost:8080/api/orders/getOrdersByName?customerName={customerName}
Return
{
    "success": <success>
    "data"   : <order_data>
    "message": <message>
}
```

Get all orders
```
GET localhost:8080/api/orders/getAllOrder
Return
{
    "success": <success>
    "data"   : <order_data>
    "message": <message>
}
```
## Postman Collection
Postman collection in files as BulutMDPostman.json. You can import to Postman directly.