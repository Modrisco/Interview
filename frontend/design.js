// singleton
const obj = {name: 'mlx', age: 24}
console.log(obj)


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


// Observer
function Publisher() {
    this.listeners = []
}

Publisher.prototype = {
    'addListener': function (listener) {
        this.listeners.push(listener)
    },

    'removeListener': function (listener) {
        delete this.listeners[this.listeners.indexOf(listener)]
    },

    'notify': function (obj) {
        for (let i = 0; i < this.listeners.length; i++) {
            const listener = this.listeners[i]
            if (typeof listener !== 'undefined') {
                listener.process(obj)
            }
        }
    }
}

function Subscriber() {

}

Subscriber.prototype = {
    'process': function (obj) {
        console.log(obj)
    }
}

const publisher = new Publisher()
publisher.addListener(new Subscriber())
publisher.addListener(new Subscriber())
publisher.notify({name: 'mlx', age: 24})
publisher.notify('2 subscribers will both perform process')

