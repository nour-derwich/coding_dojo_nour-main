
var p={
    name:"test",
    age:5,
    favFood:"pizza"
}
var n1={
    value:"test",
    next:null,
   
}
var n2={
    value:22,
    next:null,
   
}
var n3={
    value:33,
    next:null,
   
}
console.log(n1,n2);
class Node{
    constructor(val)
   { this.value=val;
    this.next=null}
}
 n=new Node(11);
 console.log(n);
 class SLL{
    constructor(){
this.head=null;
    }
 }
  list=new SLL();
  isEmpty(){
    // if(this.head===null)
    // return true;
    // else
    return this.head===null
  }
