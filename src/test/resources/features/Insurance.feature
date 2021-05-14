# language: zh-CN
功能: 投保

  场景: ping
    当我连接服务
    那么服务将会响应

  场景: 显示保险组合
    假如定义有保险计划:
    """
    {
      "portfolioCode": "XUEPING",
      "name": "基础版",
      "products": [
        {
          "code": 787,
          "name": "学生平安综合保险条款",
          "liabilities": [
            { "name": "疾病身故", "amount": 60000 },
            { "name": "校外意外身故/残疾", "amount": 60000 },
            { "name": "校内意外身故/残疾", "amount": 200000 }
          ]
        },
        {
          "code": 784,
          "name": "附加学生意外伤害医疗费用补偿保险条款",
          "liabilities": [
            { "name": "意外医疗", "amount": 10000 }
          ]
        },
        {
          "code": 788,
          "name": "附加学生补充住院医疗保险条款",
          "liabilities": [
            { "name": "疾病住院医疗", "amount": 20000 }
          ]
        }
      ]
    }
    """
    并且定义有保险计划:
    """
    {
      "portfolioCode": "XUEPING",
      "name": "经典版",
      "products": [
        {
          "code": 787,
          "name": "学生平安综合保险条款",
          "liabilities": [
            { "name": "疾病身故", "amount": 150000.0 },
            { "name": "校外意外身故/残疾", "amount": 150000.0 },
            { "name": "校内意外身故/残疾", "amount": 300000.0 }
          ]
        },
        {
          "code": 784,
          "name": "附加学生意外伤害医疗费用补偿保险条款",
          "liabilities": [
            { "name": "意外医疗", "amount": 30000.0 }
          ]
        },
        {
          "code": 788,
          "name": "附加学生补充住院医疗保险条款",
          "liabilities": [
            { "name": "疾病住院医疗", "amount": 50000.0 }
          ]
        }
      ]
    }
    """

    当为客户展示保险组合"XUEPING"
    那么服务将会响应:
    """
    {
      "plans": [
        {
          "name": "基础版",
          "products": [
            {
              "code": "787",
              "name": "学生平安综合保险条款",
              "liabilities": [
                { "name": "疾病身故", "amount": 60000.0 },
                { "name": "校外意外身故/残疾", "amount": 60000.0 },
                { "name": "校内意外身故/残疾", "amount": 200000.0 }
              ]
            },
            {
              "code": "784",
              "name": "附加学生意外伤害医疗费用补偿保险条款",
              "liabilities": [
                { "name": "意外医疗", "amount": 10000.0 }
              ]
            },
            {
              "code": "788",
              "name": "附加学生补充住院医疗保险条款",
              "liabilities": [
                { "name": "疾病住院医疗", "amount": 20000.0 }
              ]
            }
          ]
        },
        {
          "name": "经典版",
          "products": [
            {
              "code": "787",
              "name": "学生平安综合保险条款",
              "liabilities": [
                { "name": "疾病身故", "amount": 150000.0 },
                { "name": "校外意外身故/残疾", "amount": 150000.0 },
                { "name": "校内意外身故/残疾", "amount": 300000.0 }
              ]
            },
            {
              "code": "784",
              "name": "附加学生意外伤害医疗费用补偿保险条款",
              "liabilities": [
                { "name": "意外医疗", "amount": 30000.0 }
              ]
            },
            {
              "code": "788",
              "name": "附加学生补充住院医疗保险条款",
              "liabilities": [
                { "name": "疾病住院医疗", "amount": 50000.0 }
              ]
            }
          ]
        }
      ]
    }
    """

  场景: 保险计划试算
    假如存在被保险人:
      | name | age |
      | 张三  | 1   |
    当客户选择计划:
    """
    {"planId": "78701"}
    """
    那么服务将会响应:
    """
    {
      benefits: [
        { prodId: "787", fee: 5, insured: 60000},
        { prodId: "784", fee: 1, insured: 10000},
        { prodId: "788", fee: 22, insured: 20000}
      ],
      summary: {fee: 28}
    }
    """