boot.b=boot.defineClass({$0:function(){}});boot.b=boot.defineClass({$0:function(){}});boot.c=boot.defineClass({$0:function(){},handler:function(a){console.log(a);console.log(a.target);}});boot.d=boot.defineClass({$0:function(){}});boot.a=boot.defineClass({$0:function(a,b,c){this.aa=a;this.ab=b;this.ac=c;},equals:function(a){if (a instanceof boot.a==0) {return 0;} else {return this.aa.equals(a.aa);}},A:function(a){return this.ab+this.ac*a;},_B:function(a,b){a=new boot.a("Teemo",100,10,0);b=a;console.log(""+a.aa+"  "+a.A(7));console.log($("p").after("<p/>").next().text("test").attr("class","new").css("color","red"));console.log(a.hashCode());console.log(a.hashCode());console.log(b.equals(a));console.log(new boot.a("Teemso",0,0,0).equals(a));$("p").click(new boot.c(0));}});