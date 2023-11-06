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
2. Create mysql database by sql file.
3. Open project from an ide.
4. Run project from BulutmdApplication.java

## Rest API's
### Food Service
Add food to database
```
GET localhost:8080/api/foods/addFood
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
GET localhost:8080/api/orders/createOrder
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
