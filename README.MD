# Fundraising Demo App

## Instruction to start the project
1. Clone repository
2. Use this command to start up the project (on Windows)
```bash
mvnw spring-boot:run
```

## Endpoints

### 1. Fundraising Controller
1.1 GET - `/api/v1/fundraising-event/` - Get financial report

1.2 POST - `/api/v1/fundraising-event/` - Register fundraising event 

    {
        "name":"name"
        "currency":"USD"
    }
### 2. Collection Box Controller
2.1 GET - `/api/v1/collection-box` - Get collection boxes

2.2 POST - `/api/v1/collection-box` - Register collection box

2.3 POST - `/api/v1/collection-box/transfer-box` - Transfer to collection box

    {
        "amount":"10.99"
        "currency":"USD"
        "collectionBox":""d4e9b7a2-9cec-4a31-aa7d-62bf72791ee8
    }
2.4 POST - `/api/v1/collection-box/transfer-event` - Transfer from collection box
to assigned fundraising event

    {
        "collectionBox":"d4e9b7a2-9cec-4a31-aa7d-62bf72791ee8"
    }

2.5 PUT - `/api/v1/collection-box/d4e9b7a2-9cec-4a31-aa7d-62bf72791ee8` - Assign collection box 
to fundraising event

    {
        "id":"601e772b-e980-4a45-8bc4-89a2094fba75"
    }

2.6 DELETE - `/api/v1/collection-box/d4e9b7a2-9cec-4a31-aa7d-62bf72791ee8` - Delete collection box


#### There are only 3 currencies - EUR, USD, PLN

    
