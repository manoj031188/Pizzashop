# Pizzashop
demo project

It's a spring boot project.

Documentation
http://localhost:9090/swagger-ui.html  provide documentation of rest apis.

Api Security
Username=manoj,Password=manoj


Below are the sample requests

1) Order service

http://localhost:9090/pizzashop/order 
Method=POST
-H 'Authorization: Basic bWFub2o6bWFub2o=' \
Username=manoj,Password=manoj
-H 'Content-Type: application/json' \
-H 'cache-control: no-cache'

RequestBody:

{
    "userId": 1,
    "pizzaList": [
        {
            "id": 2,
            "name": "Double Cheese extra",
            "price": 2010,
            "category": "Veg",
            "createdBy": null,
            "creationTime": null,
            "updatedBy": null,
            "updationTime": null
        },
        {
            "id": 3,
            "name": "Barbecue Chicken extra",
            "price": 3000,
            "category": "Non Veg",
            "createdBy": null,
            "creationTime": null,
            "updatedBy": null,
            "updationTime": null
        }
    ],
    "totalAmount": 200,
    "payby": "cash"
}

2) Add Pizza service

http://localhost:9090/pizzashop/add 
Method=POST
-H 'Authorization: Basic bWFub2o6bWFub2o=' \
Username=manoj,Password=manoj
-H 'Content-Type: application/json' \
-H 'cache-control: no-cache'

RequestBody:

{
  "name": "Cicken extra",
  "price": 2010,
  "category": "Non Veg",
  "createdBy": null,
  "creationTime": null,
  "updatedBy": null,
  "updationTime": null
}
 
3) Show Menu service      

http://localhost:9090/pizzashop/showMenu 
Method=GET
-H 'Authorization: Basic bWFub2o6bWFub2o=' \
Username=manoj,Password=manoj
-H 'Content-Type: application/json' \
-H 'cache-control: no-cache'


4) get Bill service  
    
http://localhost:9090/pizzashop/bill?userId=1
Method=GET
-H 'Authorization: Basic bWFub2o6bWFub2o=' \
Username=manoj,Password=manoj
-H 'Content-Type: application/json' \
-H 'cache-control: no-cache'



5) update pizza service      

http://localhost:9090/pizzashop/update 
Method=PUT
-H 'Authorization: Basic bWFub2o6bWFub2o=' \
Username=manoj,Password=manoj
-H 'Content-Type: application/json' \
-H 'cache-control: no-cache'

RequestBody:
{
            "id": 4,
            "name": "Cicken extra 1",
            "price": 2010,
            "category": "Non Veg",
            "createdBy": null,
            "creationTime": null,
            "updatedBy": null,
            "updationTime": null
        }


6) delete pizza service      

http://localhost:9090/pizzashop/delete?pizzaId=5
Method=PUT
-H 'Authorization: Basic bWFub2o6bWFub2o=' \
Username=manoj,Password=manoj
-H 'Content-Type: application/json' \
-H 'cache-control: no-cache'
       
