// singleton
const obj = {name: 'mlx', age: 24}

// factory
function Person1() {
    this.name = 'Person1'
}

function Animal() {
    this.name = 'Animal1'
}

function Factory() {
    Factory.prototype.getInstance = function (className) {
        return eval('new ' + className + '( )')
    }
}

const factory = new Factory()
const obj1 = factory.getInstance('Person1')
const obj2 = factory.getInstance('Animal')

console.log(obj1.name)
console.log(obj2.name)

// proxy
function Person2() { }
Person2.prototype.sayName = () => console.log('mlx')
Person2.prototype.sayAge = () => console.log(24)

function PersonProxy () {
    this.person = new Person2()
    const that = this
    this.callMethod = function(functionName) {
        console.log('before proxy: ', functionName)
        that.person[functionName]()
        console.log('after proxy: ', functionName)
    }
}

const pp = new PersonProxy()
pp.callMethod('sayName')
pp.callMethod('sayAge')
