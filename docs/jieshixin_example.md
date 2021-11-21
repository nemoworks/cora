### 操作说明



+ postman api example

  <img src="./postman_example.png" alt="屏幕快照 2021-11-13 下午6.51.49" style="zoom:50%;" />

+ 所有的类型：

  Saler

  Bill

  CustomerExpenditure

  SalerExpenditure

  Deposit

  Cash

  GrossProfit

  CompanyPayment

  Margin

  CashSalary

  AdministrativeCost

  Payback

  

+ 规范 以GrossProfit为例

  + create_grossProfit(data:{

    ​	saler:"xxxxxxxxxxxx",//输入saler的_id

    ​	date:"2022-11-12"

    }){

    ​	_id  //id

    ​	date //返回值

    }

  + query_grossProfit(_id:"xxxxxxxxxx"){

    ​	saler{

    ​		name

    ​	}

    ​	date

    }

  + Query_grossProfit_list{

    ​	saler{

    ​		name

    ​	}

    ​	date

    }