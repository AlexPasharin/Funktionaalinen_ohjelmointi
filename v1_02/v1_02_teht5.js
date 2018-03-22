const foo = (() => {
  let x = 1

  return ({
    f: () => ++x,
    g: () => --x
  })
})()

console.log('call to f(): ' + foo.f()) 
console.log('call to g(): ' + foo.g())
console.log('call to f(): ' + foo.f()) 