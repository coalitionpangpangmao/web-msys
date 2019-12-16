import Mock from "mockjs"
Mock.mock('http://localhost:8080/user',{
    'name':'@name',
    'email':'@email',
    'age|24-60':30
});
Mock.mock('http://localhost:8080/menu',{
    'id':'@increment',
    'name':'@menu',
    'order|10-20':12
});