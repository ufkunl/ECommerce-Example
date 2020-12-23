# E-COMMERCE

# Description and Tech Stack
This project has been created for a e-commerce whose name is Trendyol. Admin will manage products and catogories. Customer will view products by category and categories.

You should be able to start the example application by executing com.ecommerce.ECommerceApplication,
which starts a webserver on port 8080 (http://localhost:8080) and serves SwaggerUI where can inspect and try existing endpoints.

The project is based on a web service which uses the following technologies:

* Java 11
* Spring Boot
* Database H2 (In-Memory)
* Maven


To solve demands of E-Commerce this;

4 REST API has been designed.

#REST APIs

* /category (GET)
* /product (POST)
* /product (PUT)
* /product/{productId} (DELETE) 
* /product/by-category/{categoryId} (GET) 


## /category
method: GET

Customers can list categories.

## /product
method: POST
request:
{
    "name":"Kazak",
    "category":  {
        "id": 2,
        "creationDate": "2020-12-20T18:39:27.211596"
    },
    "price":90.50
}

Admin can create product. Generates product code which random number and alphanumeric 

## /product
method: PUT
request: 
{
    "id":1,
    "name":"Kazak",
    "category":  {
        "id": 2,
        "creationDate": "2020-12-20T18:39:27.211596"
    },
    "price":90.50
}

Admin can update product.

## /product/{productId}
method: DELETE

Admin can delete product by id.

## /product/by-category/{categoryId}
method: GET

Customers can list products by category.

# Build and Run It
After you download the project you can maven clean install and run e-commerce.java class

OR

you can also run it in a docker container with the commands below:

* docker build -it commerce-image .
* docker run -p 8080:8080 --name e-commerce e-commerce-image


