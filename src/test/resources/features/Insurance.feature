# language: zh-CN
功能: 投保

  场景: ping
    当我连接服务
    那么服务将会响应

  场景: 保险计划试算
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