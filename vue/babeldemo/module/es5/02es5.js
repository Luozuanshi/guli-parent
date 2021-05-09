//引入模块，注意：当前路径必须写./
const m = require('./01es5.js')
console.log(m)

const result1 = m.sum(1,2)
const result2 = m.subtract(10,2)
console.log(result1,result2)