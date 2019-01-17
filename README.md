# exchange-rate-calculator
https://github.com/shefeequemohammed/exchange-rates-task1

https://github.com/imamchishty/exchange-rates-challenge/

### How to run?
java -jar exchange-rate-shefeeque-0.0.1.jar

### How to access the end point?
http://localhost:8091/api/{source-currency}/{target-currency}/{amount}

eg:
http://localhost:8091/api/AED/INR/10

### Sample output
The above endpoint will give the following JSON response:-

{ "fromCurrency": "AED", "toCurrency": "INR", "fromAmount": 10.0, "toAmount": 195.42894, "exchangeRate": 19.542894 }

### Design :
API used :- https://free.currencyconverterapi.com/api/v6/convert?q=AED_INR --eg:

Cache used : Google guava with expiry time of 1 hour.

Port used : 8091
