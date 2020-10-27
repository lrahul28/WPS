function cal(){
    var v= [0,0,0,0,0];
    var a=document.getElementById("1").value;
    v[0]=a;
    if(a==undefined){
        v[0]=0
    }
    a=document.getElementById("2").value;
    v[1]=a;
    if(a==undefined){
        v[0]=0
    }
    a=document.getElementById("3").value;
    v[2]=a;
    if(a==undefined){
        v[0]=0
    }
    a=document.getElementById("4").value;
    v[3]=a;
    if(a==undefined){
        v[0]=0
    }
    a=document.getElementById("5").value;
    v[4]=a;
    if(a==undefined){
        v[0]=0
    }
    var sum=0;
    var cost=[50,63,59,554,250]
    for(let i=0;i<5;i++){
        sum+=cost[i]*v[i];
    }
    var s;
    if(document.getElementById("1a").checked){
        s="Item 1"+"("+v[0]+")"+"<br>";
    }
    if(document.getElementById("2a").checked){
        s=s+"Item 2"+"("+v[1]+")"+"<br>";
    }
    if(document.getElementById("3a").checked){
        s=s+"Item 3"+"("+v[2]+")"+"<br>";
    }
    if(document.getElementById("4a").checked){
        s=s+"Item 4"+"("+v[3]+")"+"<br>";
    }
    if(document.getElementById("5a").checked){
        s=s+"Item 5"+"("+v[4]+")"+"<br>";
    }
    document.querySelector(".d").innerHTML="Selected Items are:-"+"<br>"+s+"<br>"+"Amount="+" "+sum;
}
function val(){
    p=/^[1-9]$/

 var a=document.getElementById("1").value; 
    if(!p.test(a)){
        document.querySelector(".e").innerHTML="Enter  Number Only";
    }
  var h=document.getElementById("2").value;   
 if(!p.test(h) ){
     document.querySelector(".e").innerHTML="Enter  Number Only";
 }
 var b=document.getElementById("3").value;   
 if(!p.test(b)){
     document.querySelector(".e").innerHTML="Enter  Number Only";
 }
 var c=document.getElementById("4").value;   
 if(!p.test(c)){
     document.querySelector(".e").innerHTML="Enter  Number Only";
 }
 var d=document.getElementById("5").value;   
 if(!p.test(d)){
     document.querySelector(".e").innerHTML="Enter Number Only";
 }
else{
    document.querySelector(".e").innerHTML="Check the Bill";

} 
}
