class Ninja {
    constructor ( name ,health ){
        this.speed = 3;
        this.strength = 3;
        this.name = name ;
        this.health = health ;
    }
    sayName()
    {
        console.log(this.name );
    }
    showStats()
    {
        console.log(`${ this.name}`);
        console.log(`${ this.health}`);
        console.log(`${  this.strength}`);
        console.log(`${ this.speed}`);
       
    }
    drinkSake() {
        console.log(`${this.name} `);
        this.health += 10;
        return this;
    }

}
const alex= new Ninja("alex"); 
alex.sayName().showStats().drinkSake()