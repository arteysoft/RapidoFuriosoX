let miArr = [1, 2, 3, 4, 10]

let otroArr = miArr.filter(z => z % 2 == 0)

let resultadoMap = miArr
.map(z => {
    return z + 1
})
.map(z => {
    return z * 2
})
.map(z => {
    return '<row>' + '<h1>' + z + '</h1>' + '</row>'
})

console.log(miArr)
console.log('<Table>')
console.log(resultadoMap)
console.log('</Table>')

