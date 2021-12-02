### 项目设计

#### architecture

![](./cora.svg)

#### model graph

+ coraNode
  + data model

+ coraIngress
  + graphql & restful api(curd)
  + custom ingress

#### parser
+ parser for json-schema & sdl


+ parse filter elements to sql

#### data Loader
+ dataloader for mongodb & postgres

#### query api filter support
+ graphql style
  

    {
        query_invoice_list(where:{
            _and:[
                {invoiceDate:{_eq:"2020-01-01"}},
                {invoiceCompany:{_eq:"公司2"}}
            ]
        }){
            _id
            isPaybackEnd
            invoiceDate
            invoiceCompany
        }
    }

#### cache (caffeine)
+ query string cache
  
+ nodeInstance cache

#### domain model management

#### auth 

#### workflow