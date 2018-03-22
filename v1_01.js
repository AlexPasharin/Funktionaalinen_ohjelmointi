// Huomautus - käytän ES6:n syntaksia
// ajaa vaikka node.js:llä jos kiinnostaa

// teht1

const onPalindromi = str => {
  const {length} = str
  if (length <= 1) return true

  if (str.charAt(0) !== str.charAt(length - 1)) return false 

  return onPalindromi(str.substring(1, length - 1)) 
}

console.log('Teht1: ')
console.log(onPalindromi('')) // true
console.log(onPalindromi('a')) // true
console.log(onPalindromi('sokos')) // true
console.log(onPalindromi('alex')) // false
console.log(onPalindromi('alea')) // false
console.log()

// teht2

const syt = (p, q) => 
  q === 0 ? p : syt(q, p%q)

console.log('Teht2: ')
console.log(syt(5, 0)) // 5
console.log(syt(2, 3)) // 1
console.log(syt(102, 68)) // 34
console.log(syt(12, 15)) // 3
console.log()

// teht3

const relPrimes = (p, q) => 
  q === 0 ? p === 1 : relPrimes(q, p%q)

console.log('Teht3: ')
console.log(relPrimes(5, 0)) // false
console.log(relPrimes(1, 0)) // true
console.log(relPrimes(2, 3)) // true
console.log(relPrimes(102, 68)) // false
console.log(relPrimes(21, 12)) // true
console.log()

// tai tietysti yhtä hyvin voidaan käyttää edellisen tehtävän funktiota
const relPrimes2 = (p, q) => syt(p, q) === 1
// mutta tässä kai tarkoitettiin 'from the scratch samalla algoritmilla'

// teht4

const pow = (x, n) => 
  n === 0 ? 1 : x * pow(x, n - 1) 

console.log('Teht4: ')
console.log(pow(5, 0)) // 1
console.log(pow(5, 2)) // 25
console.log(pow(2, 10)) // 1024
console.log()

// teht5

const reverseArr = arr =>
  arr.length <= 1 ? arr : reverseArr(arr.slice(1)).concat(arr[0])

console.log('Teht4: ')
console.log(reverseArr([])) // []
console.log(reverseArr([0])) // [0]
console.log(reverseArr([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])) // [ 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 ]
console.log()