// teht1

const compare = () =>
  (a, b) => 
    a > b ? 1 :
      a < b ? -1 : 0 
     
console.log('Teht1: ')   
const compareFunc = compare()
console.log(compareFunc(2, 3)) // -1  
console.log(compareFunc(3, 2)) // 1
console.log(compareFunc(3, 3)) // 0
console.log()

// teht2

const tempComparison = (compFunc, arr_2015, arr_2016) => 
  arr_2016
    .filter((el, idx) => compFunc(el, arr_2015[idx]) === 1)
    .length

// teht 4

const powAccumulor = (x, n, acc) => 
  n === 0 ? acc : powAccumulor(x, n-1, x * acc)

const powTailRec = (x, n) => powAccumulor(x, n, 1)

console.log('Teht4: ')
console.log(powTailRec(5, 0)) // 1
console.log(powTailRec(5, 2)) // 25
console.log(powTailRec(2, 10)) // 1024
console.log()