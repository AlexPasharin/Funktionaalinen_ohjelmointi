// teht1 

const toCelsius = fahrenheit =>  
  (5/9) * (fahrenheit-32)

const area = radius =>   
   Math.PI * radius * radius
   
// teht2 

const movies = require('./data/movies')

console.log("Teht2: ")
console.log(
  movies.map(
    movie => ({
      title: movie.title,
      release: movie.release,
    })
  )
)
console.log()

// teht3 

console.log("Teht3: ")
console.log(
  movies.filter(
    movie => movie.release > 2011
  )
)
console.log()

// teht4

const monthlyAverageTemps = (temps2015, temps2016) => 
  temps2015.map((temp2015, idx) => (temp2015 + temps2016[idx])/2)

const yearAveragePositiveAverageTemps = (temps2015, temps2016) => {
  const posMonthlyAverageTemps = monthlyAverageTemps(temps2015, temps2016)
    .filter(temp => temp > 0)

  // oletetaan, että posMonthlyAverageTemps ei ole tyhjä taulukko...
  return (posMonthlyAverageTemps.reduce((acc, curVal) => acc + curVal))/posMonthlyAverageTemp.length    
}    

// teht 5

const fs = require('fs')

const appearanceList = text => {
  const regEx = /[a-zäöå']+/g
  // kai nyt toLowerCase funktiota saa käyttää kans
  const list = text
    .toLowerCase()
    .match(regEx)
    .reduce((acc, curVal) => {
      if (!acc[curVal]) acc[curVal] = 1
      else acc[curVal]++

      return acc
    }, {})

    // järjestetään avaimen mukaan
    return Object.keys(list)
      .sort()
      .reduce((acc, curVal)=> {
        acc[curVal] = list[curVal]
        return acc
      }, {})
}

console.log("Teht 5: ")
console.log(appearanceList('This is  a test.  This is only a test.'))
console.log()
console.log("Kalevala sanojen esiintymislista:")

fs.readFile(
  './data/kalevala.txt', 
  'utf8', 
  (err, text) => {
    if (err) {
      console.log("Error while reading file:", err)
      return
    }

    console.log(appearanceList(text))
  }
)

