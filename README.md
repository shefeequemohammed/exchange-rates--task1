[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e498322bf14946a2a9198de379e519cd)](https://app.codacy.com/app/shefeequemohammed/exchange-rates--task1?utm_source=github.com&utm_medium=referral&utm_content=shefeequemohammed/exchange-rates--task1&utm_campaign=Badge_Grade_Dashboard)
[![Build Status](https://travis-ci.org/shefeequemohammed/exchange-rates--task1.svg?branch=master)](https://travis-ci.org/shefeequemohammed/exchange-rates--task1)

# exchange-rate-calculator

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
