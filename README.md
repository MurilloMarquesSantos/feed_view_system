# Product Feed View System

This project is being developed to test how much Kafka combined with Redis caching can improve system performance in percentage terms.

**Status:** In development

**Tests without redis and kafka:** 

![image](img/msWithoutRedis.png)

**Tests with redis + kafka:**
![image](img/msWithRedis.png)
We can see that we got an increase of ~73% on the response time this is a test with just 300 products,
now imagine how it could increase performance in a larger system

**Tests with redis + kafka returning String**
![image](img/msWithRedisString.png)
Here, without converting the payload to object and returning the String, we have got an 80 % increase in response time


Here is with 2000 products:


