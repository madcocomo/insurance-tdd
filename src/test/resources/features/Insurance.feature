# language: zh-CN
功能: 投保

  背景: 基础产品数据
    假如定义有保险组合:
    """
    {
      "portfolioCode": "XUEPING",
      "portfolioId": "XP01",
      "name": "基础版",
      "premiums": [
        {"ageMin": 0, "ageMax": 2, "premium": 28},
        {"ageMin": 3, "ageMax": 25, "premium": 9}
      ],
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
    并且定义有保险组合:
    """
    {
      "portfolioCode": "XUEPING",
      "portfolioId": "XP02",
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

  场景: ping
    当我连接服务
    那么服务将会响应


  场景: 显示保险组合
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

  场景: 保费试算
    当客户选择组合:
    """
    {"portfolioId": "XP01", "insurer":{"name": "张三", "birthday": "2020-04-10"}}
    """
    那么服务将会响应:
    """
    {
      premium: 28
    }
    """