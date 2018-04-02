// teht 1

const laskePisteet = (Kpiste, lisapiste) => 
  pituus => 60 + (pituus - Kpiste) * lisapiste

const makiPisteet = laskePisteet(100, 2.0)

console.log("Teht 1:")
console.log(makiPisteet(100))
console.log(makiPisteet(120))
console.log(makiPisteet(90))
console.log()

// Teht 2

const Auto = (() => {
  const privateParams = new WeakMap()

  class Auto {
    constructor(tankki, matkaMittari) {
      this.tankki = tankki
      privateParams.set(this, {matkaMittari})
    }

    getTankki(){ return this.tankki}

    getMatkaMittari(){return privateParams.get(this).matkaMittari}

    lisaaPolttoaine(maara) {this.tankki += maara}
  }

  return Auto
})()

const auto = new Auto(100, 40)

console.log("Teht 2:")
console.log("Auton tankki:", auto.getTankki())
auto.tankki = 120
console.log("Suoraan muutettu auton tankki:", auto.tankki)
console.log("Suojattu matkamittarin arvo:", auto.getMatkaMittari())
console.log()

// Teht 3

const Auto2 = (_tankki, _matkaMittari) => {
  const tankki = _tankki
  const matkaMittari = _matkaMittari

  return ({
    getTankki: () => tankki,
    getMatkaMittari: () => matkaMittari,
    lisaaPolttoaine:(maara) => Auto2(tankki + maara, matkaMittari)
  })
}

const auto2 = Auto2(100, 40)

console.log("Teht 3:")
console.log("Auton tankki:", auto2.getTankki())
const auto3 = auto2.lisaaPolttoaine(10)
console.log("Uusi auton tankki polttoaineen lisäämisen jälkeen:", auto3.getTankki())
console.log("Alkuperäisen objektin tankki ei ole muuttunut:", auto2.getTankki())
console.log()

// Teht 4 

const Immutable = require('immutable')
const set1 = Immutable.Set(['punainen', 'vihreä', 'keltainen'])
const set2 = set1.add('ruskea')
const set3 = set2.add('ruskea')

console.log("Teht4: ")
console.log(set1 === set2)
console.log(set2 === set3) // samat
console.log()

// Teht5 

const arr = [1, 2, 3, 4, 5]

const neliot = arr => arr.map(x => {
  console.log(`Mapping value ${x}`)
  return x * x
})

console.log("Teht 5: ")
console.log("Ilman laiskaa evaluointia, kaikki arvot käydään läpi ennen kuin joku niistä palautetaan: ")

console.log(neliot(arr)[2])
console.log()

console.log("Laiska evaluointi, käydään läpi vain tarvittavat arvot: ")

const immutableArr = Immutable.Seq(arr)

console.log(neliot(immutableArr).get(2))
console.log()

