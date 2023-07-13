
# TechnicalTest

TechnicalTest for Capitole


## API Reference

#### Get all items

```http
  GET /priceData/{date}/{brandId}/{productId}
```

| Parameter   | Type      | Description                       |
|:------------|:----------|:----------------------------------|
| `date`      | `string`  | **Required**. Price Date          |
| `brandId`   | `Integer` | **Required**. Product Foreign key |
| `productId` | `Long`    | **Required**. Product Id key      |

## Appendix

Request proof for test the api
http://localhost:8080/priceData/15-06-2020-00.00.00/1/35455

Open-api and swagger url
http://localhost:8080/swagger-ui/index.html
http://localhost:8080/api-docs

## Authors

- [@fjvica](https://www.github.com/fjvica)



