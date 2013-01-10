boot.defineNative("Document",{
// booton.translator.web.Document#<init>()
$0:function(){},
// booton.translator.web.Document#createElement(java.lang.String)
createElement:function(A){return this.createElement(A);}});boot.define("L",{
// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
$0:function(A){this.a=A;this.b=0;},
// booton.translator.web.jQuery$1#hasNext()
N:function(){return this.b<this.a.size();},
// booton.translator.web.jQuery$1#next()
O:function(){return $(this.a.get(this.b++));},
// booton.translator.web.jQuery$1#remove()
P:function(){},
// booton.translator.web.jQuery$1#next()
Q:function(){return this.O();}});boot.defineNative("jQuery",{
// booton.translator.web.jQuery#<init>()
$0:function(){},
// booton.translator.web.jQuery#child(java.lang.String)
K:function(A){return $(document.createElement(A)).appendTo(this);},
// booton.translator.web.jQuery#child(java.lang.Class)
L:function(A){return this.K("span").addClass(A);},
// booton.translator.web.jQuery#iterator()
M:function(){return new boot.L(this,0);}});boot.define("J",{
// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
$0:function(A,B){this.a=A;;this.b=B.K("ul").addClass("a");},
// js.application.Header$Menu#add(java.lang.String, java.lang.String)
J:function(A,B,C){C=this.b.K("li").addClass("b");C.K("a").addClass("c").attr("href",B).text(A);return new boot.J(this.a,C,0);},
// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
$1:function(A,B,C){boot.J.prototype.$0.call(this,A,B);}});boot.define("Q",{
// js.util.ArrayList$View#<init>(js.util.ArrayList)
$1:function(A){this.a=A;;this.b=0;},
// js.util.ArrayList$View#hasNext()
N:function(){return this.b<boot.N.BL(this.a).length;},
// js.util.ArrayList$View#next()
Q:function(){return boot.N.BL(this.a)[this.b++];},
// js.util.ArrayList$View#remove()
P:function(){if(this.b<=0){}else{boot.N.BL(this.a).splice(this.b-1,1)[0];}},
// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
$0:function(A,B){boot.Q.prototype.$1.call(this,A);}});boot.define("P",{
// java.lang.reflect.Array#<init>()
$0:function(){},
// java.lang.reflect.Array#newInstance(java.lang.Class, int)
_y:function(A,B){return boot.P.BM(A,B);},
// java.lang.reflect.Array#newInstance(java.lang.Class, int[])
_BN:function(A,B){return boot.P.BO(A,B);}});boot.define("O",{
// js.util.AbstractCollection#<init>()
$0:function(){},
// js.util.AbstractCollection#isEmpty()
U:function(){return this.V()==0;},
// js.util.AbstractCollection#addAll(java.util.Collection)
W:function(A,B,C,D){B=0;D=A.M();l2:while (D.N()!=0) {C=D.Q();if(this.F(C)==0){}else{B=1;continue l2;}continue l2;}return B;},
// js.util.AbstractCollection#retainAll(java.util.Collection)
X:function(A,B,C,D){B=0;D=this.M();l2:while (D.N()!=0) {C=D.Q();if(A.Y(C)!=0){}else{B=this.Z(C);continue l2;}continue l2;}return B;},
// js.util.AbstractCollection#removeAll(java.util.Collection)
u:function(A,B,C,D){B=0;D=A.M();l2:while (D.N()!=0) {C=D.Q();if(this.Z(C)==0){}else{B=1;continue l2;}continue l2;}return B;},
// js.util.AbstractCollection#containsAll(java.util.Collection)
v:function(A,B,C){C=A.M();l1:while (C.N()!=0) {B=C.Q();if(this.Y(B)!=0){}else{return 0;}continue l1;}return 1;},
// js.util.AbstractCollection#toArray()
w:function(){return this.x(new Array(0));},
// js.util.AbstractCollection#toArray(java.lang.Object[])
x:function(A,B,C,D,E){B=this.V();if(A.length>=B){}else{A=boot.P.y(A.getClass(),B);}C=this.M();D=0;l6:while (C.N()!=0) {E=C.Q();A[D]=E;++D;continue l6;}return A;}});boot.define("R",{
// booton.translator.js.JsError#<init>()
$0:function(){},
// booton.translator.js.JsError#<init>(java.lang.String)
$1:function(A){}});boot.define("N",boot.O,{
// js.util.ArrayList#<init>()
$0:function(){boot.O.prototype.$0.call(this);this.a=[];},
// js.util.ArrayList#size()
V:function(){return this.a.length;},
// js.util.ArrayList#contains(java.lang.Object)
Y:function(A){return this.a.indexOf(A)!=-1;},
// js.util.ArrayList#iterator()
M:function(){return new boot.Q(this,null,0);},
// js.util.ArrayList#add(java.lang.Object)
F:function(A){this.a.push(A);return 1;},
// js.util.ArrayList#remove(java.lang.Object)
Z:function(A,B){B=this.a.indexOf(A);if(B!=-1){this.a.splice(B,1)[0];return 1;}else{return 0;}},
// js.util.ArrayList#addAll(int, java.util.Collection)
z:function(A,B){return 0;},
// js.util.ArrayList#clear()
BA:function(){this.a=[];},
// js.util.ArrayList#get(int)
BB:function(A){return this.a[A];},
// js.util.ArrayList#set(int, java.lang.Object)
BC:function(A,B){return this.a[A]=B;},
// js.util.ArrayList#add(int, java.lang.Object)
BD:function(A,B){this.a.splice(A,0,B);},
// js.util.ArrayList#remove(int)
BE:function(A){return this.a.splice(A,1)[0];},
// js.util.ArrayList#indexOf(java.lang.Object)
BF:function(A){return this.a.indexOf(A);},
// js.util.ArrayList#lastIndexOf(java.lang.Object)
BG:function(A){return this.a.lastIndexOf(A);},
// js.util.ArrayList#listIterator()
BH:function(){throw new boot.R(0);},
// js.util.ArrayList#listIterator(int)
BI:function(A){throw new boot.R(0);},
// js.util.ArrayList#subList(int, int)
BJ:function(A,B){throw new boot.R(0);},
// js.util.ArrayList#checkRange(int)
BK:function(A){if(A>=0){if(this.V()>A){return;}else{throw new boot.R("Index is overflowed. Size: "+this.V()+"  Index: "+A,1);}}else{throw new boot.R("Negative index is unacceptable. Size: "+this.V()+"  Index: "+A,1);}},
// js.util.ArrayList#access$0(js.util.ArrayList)
_BL:function(A){return A.a;}});boot.define("E",{
// js.Application$Route#<init>(java.lang.String, java.lang.Class)
$1:function(A,B){this.a=new RegExp(A.replace(/\*/g,"([^/].+)"),"");this.b=B;},
// js.Application$Route#match(java.lang.String)
R:function(A,B,C,D){B=this.a.exec(A);if(B!=null!=0){C=new boot.N(0);D=0;l6:for (;D<B.length-1;++D) {C.F(B[D+1]);}this.b.newInstance();return B!=null;}else{return 0;}},
// js.Application$Route#access$0(js.Application$Route, java.lang.String)
_S:function(A,B){return A.R(B);},
// js.Application$Route#access$1(js.Application$Route)
_T:function(A){return A.b;},
// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
$0:function(A,B,C){boot.E.prototype.$1.call(this,A,B);}});boot.define("S",{
// booton.translator.web.Location#<init>()
$0:function(){}});boot.define("F",{
// js.Page#<init>()
$0:function(){}});boot.defineNative("History",{
// booton.translator.web.History#<init>()
$0:function(){}});boot.define("D",{
// js.Application$Router#<init>()
$1:function(){this.a=new boot.N(0);},
// js.Application$Router#handler(booton.translator.web.jQuery$Event)
handler:function(A){this.BP(location.hash);},
// js.Application$Router#dispatch(java.lang.String)
BP:function(A,B,C){if((A.length==0||A.startsWith("#")==0)){}else{A=A.substring(1);}C=this.a.M();l3:while (C.N()!=0) {B=C.Q();if(boot.E.S(B,A)==0){}else{this.BQ(boot.E.T(B).newInstance());return;}continue l3;}},
// js.Application$Router#dispatch(js.Page)
BQ:function(A,B){B=$(document.createDocumentFragment());this.b=A;this.b.BR(B);$("#Content").empty().append(B);},
// js.Application$Router#<init>(js.Application$Router)
$0:function(A){boot.D.prototype.$1.call(this);},
// js.Application$Router#access$1(js.Application$Router, java.lang.String)
_B:function(A,B){A.BP(B);},
// js.Application$Router#access$2(js.Application$Router)
_E:function(A){return A.a;},
// js.Application$Router#access$3(js.Application$Router, js.Page)
_H:function(A,B){A.BQ(B);}});boot.define("B",{
// js.Application#<clinit>()
_:function(){boot.B.a=new boot.D(null,0);},
// js.Application#<init>()
$0:function(){},
// js.Application#jsmain()
A:function(){$(window).on("hashchange",boot.B.a);boot.D.B(boot.B.a,location.hash);},
// js.Application#configure(js.application.Header)
C:function(A){},
// js.Application#register(java.lang.String, java.lang.Class)
D:function(A,B){boot.D.E(boot.B.a).F(new boot.E(A,B,null,0));},
// js.Application#show(js.Page)
_G:function(A){if(A==null){}else{boot.D.H(boot.B.a,A);history.pushState("","","#"+A.I());}}});boot.define("v",{
// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
$1:function(A,B){this.a=A;this.b=B;},
// js.util.HashMap$SimpleEntry#getKey()
CE:function(){return this.a;},
// js.util.HashMap$SimpleEntry#getValue()
Bx:function(){return this.b;},
// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
CH:function(A,B){B=this.b;this.b=A;return B;},
// js.util.HashMap$SimpleEntry#hashCode()
hashCode:function(){return this.a.hashCode();},
// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object, js.util.HashMap$SimpleEntry)
$0:function(A,B,C){boot.v.prototype.$1.call(this,A,B);}});boot.define("z",{
// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
$1:function(A,B,C){this.a=A;;this.b=B;this.c=C;},
// js.util.HashMap$View#hasNext()
N:function(){return this.b.N();},
// js.util.HashMap$View#next()
Q:function(A){A=this.b.Q();if(this.c==0){return A.Bx();}else{return A.CE();}},
// js.util.HashMap$View#remove()
P:function(){this.b.P();},
// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
$0:function(A,B,C,D){boot.z.prototype.$1.call(this,A,B,C);}});boot.define("y",boot.O,{
// js.util.AbstractSet#<init>()
$0:function(){boot.O.prototype.$0.call(this);}});boot.define("BA",{
// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
$1:function(A,B){this.a=A;;this.b=0;this.c=B;},
// js.util.HashSet$View#hasNext()
N:function(){return this.b<this.c.length;},
// js.util.HashSet$View#next()
Q:function(){this.d=boot.u.CJ(this.a)[this.c[this.b++]];return this.d;},
// js.util.HashSet$View#remove()
P:function(){if(this.b<=0){}else{this.a.Z(this.d);}},
// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
$0:function(A,B,C){boot.BA.prototype.$1.call(this,A,B);}});boot.define("u",boot.y,{
// js.util.HashSet#<init>()
$0:function(){boot.y.prototype.$0.call(this);this.a=0;this.b={};},
// js.util.HashSet#size()
V:function(){return this.a;},
// js.util.HashSet#contains(java.lang.Object)
Y:function(A){return this.CI(A) in this.b;},
// js.util.HashSet#add(java.lang.Object)
F:function(A,B){B=this.CI(A);if(B in this.b==0){this.a=this.a+1;this.b[B]=A;return 1;}else{return 0;}},
// js.util.HashSet#remove(java.lang.Object)
Z:function(A,B){B=this.CI(A);if(B in this.b!=0){this.a=this.a-1;delete this.b[B];return 1;}else{return 0;}},
// js.util.HashSet#clear()
BA:function(){this.a=0;this.b=[];},
// js.util.HashSet#iterator()
M:function(){return new boot.BA(this,this.b.keys(),null,0);},
// js.util.HashSet#hash(java.lang.Object)
CI:function(A){return (A==null?-1:A.hashCode());},
// js.util.HashSet#find(java.lang.Object)
Bw:function(A){return this.b[this.CI(A)];},
// js.util.HashSet#push(java.lang.Object)
Bz:function(A,B,C){B=null;C=this.CI(A);if(C in this.b==0){this.a=this.a+1;}else{B=this.b[C];}this.b[C]=A;return B;},
// js.util.HashSet#pull(java.lang.Object)
CB:function(A,B,C){B=null;C=this.CI(A);if(C in this.b==0){}else{B=this.b[C];this.a=this.a-1;delete this.b[C];}return B;},
// js.util.HashSet#access$0(js.util.HashSet)
_CJ:function(A){return A.b;}});boot.define("w",boot.y,{
// js.util.HashMap$Keys#<init>(js.util.HashMap)
$1:function(A){this.a=A;boot.y.prototype.$0.call(this);},
// js.util.HashMap$Keys#size()
V:function(){return boot.X.CG(this.a).V();},
// js.util.HashMap$Keys#contains(java.lang.Object)
Y:function(A){return boot.X.CG(this.a).Y(A);},
// js.util.HashMap$Keys#iterator()
M:function(){return new boot.z(this.a,boot.X.CG(this.a).M(),1,null,0);},
// js.util.HashMap$Keys#add(java.lang.Object)
F:function(A){return 0;},
// js.util.HashMap$Keys#remove(java.lang.Object)
Z:function(A){return boot.X.CG(this.a).Z(A);},
// js.util.HashMap$Keys#clear()
BA:function(){boot.X.CG(this.a).BA();},
// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
$0:function(A,B){boot.w.prototype.$1.call(this,A);}});boot.define("x",boot.O,{
// js.util.HashMap$Values#<init>(js.util.HashMap)
$1:function(A){this.a=A;boot.O.prototype.$0.call(this);},
// js.util.HashMap$Values#size()
V:function(){return boot.X.CG(this.a).V();},
// js.util.HashMap$Values#contains(java.lang.Object)
Y:function(A){return this.a.BZ(A);},
// js.util.HashMap$Values#iterator()
M:function(){return new boot.z(this.a,boot.X.CG(this.a).M(),0,null,0);},
// js.util.HashMap$Values#add(java.lang.Object)
F:function(A){return 0;},
// js.util.HashMap$Values#remove(java.lang.Object)
Z:function(A,B,C){B=this.M();l2:while (B.N()!=0) {C=B.Q();if(C!=A){}else{B.P();return 1;}continue l2;}return 0;},
// js.util.HashMap$Values#clear()
BA:function(){boot.X.CG(this.a).BA();},
// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
$0:function(A,B){boot.x.prototype.$1.call(this,A);}});boot.define("X",{
// js.util.HashMap#<init>()
$0:function(){this.a=new boot.u(0);},
// js.util.HashMap#size()
V:function(){return this.a.V();},
// js.util.HashMap#isEmpty()
U:function(){return this.a.U();},
// js.util.HashMap#containsKey(java.lang.Object)
BY:function(A){return this.a.Y(A);},
// js.util.HashMap#containsValue(java.lang.Object)
BZ:function(A,B,C){C=this.Bu().M();l1:while (C.N()!=0) {B=C.Q();if(B!=A){}else{return 1;}continue l1;}return 0;},
// js.util.HashMap#get(java.lang.Object)
Bv:function(A,B){B=this.a.Bw(A);return (B==null?null:B.Bx());},
// js.util.HashMap#put(java.lang.Object, java.lang.Object)
BW:function(A,B,C){C=this.a.Bz(new boot.v(A,B,null,0));if(C!=null){return C.Bx();}else{return null;}},
// js.util.HashMap#remove(java.lang.Object)
CA:function(A,B){B=this.a.CB(A);if(B!=null){return B.Bx();}else{return null;}},
// js.util.HashMap#putAll(java.util.Map)
CC:function(A,B,C){C=A.CD().M();l1:for (;C.N()!=0;this.BW(B.CE(),B.Bx())) {B=C.Q();}},
// js.util.HashMap#clear()
BA:function(){this.a.BA();},
// js.util.HashMap#keySet()
CF:function(){return new boot.w(this,null,0);},
// js.util.HashMap#values()
Bu:function(){return new boot.x(this,null,0);},
// js.util.HashMap#entrySet()
CD:function(){return this.a;},
// js.util.HashMap#access$0(js.util.HashMap)
_CG:function(A){return A.a;}});boot.define("W",{
// js.ui.UI#<init>()
$0:function(){boot.W.prototype.$1.call(this,"div");},
// js.ui.UI#<init>(java.lang.String)
$1:function(A){this.a=$("<"+A+">");}});boot.define("Y",{
// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
$0:function(A,B){this.a=A;this.b=B;},
// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
handler:function(A,B,C,D){B=this.b.val().toLowerCase().replace(/\s/g,"");D=boot.V.BX(this.a).CD().M();l2:while (D.N()!=0) {C=D.Q();if(this.a.BV(C.CE()).toLowerCase().indexOf(B) != -1==0){C.Bx().addClass("g");continue l2;}else{C.Bx().removeClass("g");continue l2;}}}});boot.define("Z",{
// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
$0:function(A,B){this.a=A;this.b=B;},
// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
handler:function(A){this.a.CK(this.b);}});boot.define("V",boot.W,{
// js.ui.ImageGrid#<init>()
$0:function(){boot.W.prototype.$0.call(this);this.b=new boot.X(0);this.c=this.BT();},
// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
BS:function(A,B,C,D,E){this.a.css("line-height","0").css("width","700px").css("margin","0 auto");B=$("<input type='text'>");B.appendTo(this.a);B.addClass("d").css("display","block");B.keyup(new boot.Y(this,B,0));D=this.c.M();l6:for (;D.N()!=0;this.b.BW(C,E)) {C=D.Q();E=this.a.L("e").css("background-image","url("+this.BU(C)+")");E.K("span").addClass("f").text(this.BV(C));E.click(new boot.Z(this,C,0));}A.append(this.a);},
// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
_BX:function(A){return A.b;}});boot.define("BB",{
// teemowork.model.Champion#<clinit>()
_:function(){boot.BB.b=new boot.X(0);boot.BB.c=new boot.BB("Ahri",0);boot.BB.d=new boot.BB("Akali",0);boot.BB.e=new boot.BB("Alistar",0);boot.BB.f=new boot.BB("Amumu",0);boot.BB.g=new boot.BB("Ashe",0);boot.BB.h=new boot.BB("Blitzcrank",0);boot.BB.i=new boot.BB("Brand",0);boot.BB.j=new boot.BB("Caitlyn",0);boot.BB.k=new boot.BB("Cassiopeia",0);boot.BB.l=new boot.BB("Chogath",0);boot.BB.m=new boot.BB("Corki",0);boot.BB.n=new boot.BB("Darius",0);boot.BB.o=new boot.BB("Diana",0);boot.BB.p=new boot.BB("Dr.Mundo",0);boot.BB.ba=new boot.BB("Elise",0);boot.BB.bb=new boot.BB("Evelynn",0);boot.BB.bc=new boot.BB("Ezreal",0);boot.BB.bd=new boot.BB("Fiddlesticks",0);boot.BB.be=new boot.BB("Fiora",0);boot.BB.bf=new boot.BB("Fizz",0);boot.BB.bg=new boot.BB("Galio",0);boot.BB.bh=new boot.BB("Gangplank",0);boot.BB.bi=new boot.BB("Garen",0);boot.BB.bj=new boot.BB("Gragas",0);boot.BB.bk=new boot.BB("Graves",0);boot.BB.bl=new boot.BB("Hecarim",0);boot.BB.bm=new boot.BB("Heimerdinger",0);boot.BB.bn=new boot.BB("Irelia",0);boot.BB.bo=new boot.BB("Janna",0);boot.BB.bp=new boot.BB("Jarvan IV",0);boot.BB.ca=new boot.BB("Jax",0);boot.BB.cb=new boot.BB("Jayce",0);boot.BB.cc=new boot.BB("Karma",0);boot.BB.cd=new boot.BB("Karthus",0);boot.BB.ce=new boot.BB("Kassadin",0);boot.BB.cf=new boot.BB("Katarina",0);boot.BB.cg=new boot.BB("Kayle",0);boot.BB.ch=new boot.BB("Kennen",0);boot.BB.ci=new boot.BB("Kha'zix",0);boot.BB.cj=new boot.BB("Kog'maw",0);boot.BB.ck=new boot.BB("LeBlanc",0);boot.BB.cl=new boot.BB("Lee Sin",0);boot.BB.cm=new boot.BB("Leona",0);boot.BB.cn=new boot.BB("Lulu",0);boot.BB.co=new boot.BB("Lux",0);boot.BB.cp=new boot.BB("Malphite",0);boot.BB.da=new boot.BB("Maokai",0);boot.BB.db=new boot.BB("Master Yi",0);boot.BB.dc=new boot.BB("Miss Fortune",0);boot.BB.dd=new boot.BB("Mordekaiser",0);boot.BB.de=new boot.BB("Morgana",0);boot.BB.df=new boot.BB("Nami",0);boot.BB.dg=new boot.BB("Nasus",0);boot.BB.dh=new boot.BB("Nautilus",0);boot.BB.di=new boot.BB("Nidalee",0);boot.BB.dj=new boot.BB("Nocturne",0);boot.BB.dk=new boot.BB("Nunu",0);boot.BB.dl=new boot.BB("Olaf",0);boot.BB.dm=new boot.BB("Orianna",0);boot.BB.dn=new boot.BB("Pantheon",0);boot.BB.dp=new boot.BB("Poppy",0);boot.BB.ea=new boot.BB("Rammus",0);boot.BB.eb=new boot.BB("Renekton",0);boot.BB.ec=new boot.BB("Rengar",0);boot.BB.ed=new boot.BB("Riven",0);boot.BB.ee=new boot.BB("Rumble",0);boot.BB.ef=new boot.BB("Ryze",0);boot.BB.eg=new boot.BB("Sejuani",0);boot.BB.eh=new boot.BB("Shaco",0);boot.BB.ei=new boot.BB("Shen",0);boot.BB.ej=new boot.BB("Shyvana",0);boot.BB.ek=new boot.BB("Singed",0);boot.BB.el=new boot.BB("Sion",0);boot.BB.em=new boot.BB("Sivir",0);boot.BB.en=new boot.BB("Skarner",0);boot.BB.eo=new boot.BB("Sona",0);boot.BB.ep=new boot.BB("Soraka",0);boot.BB.fa=new boot.BB("Swain",0);boot.BB.fb=new boot.BB("Syndra",0);boot.BB.fc=new boot.BB("Talon",0);boot.BB.fd=new boot.BB("Taric",0);boot.BB.fe=new boot.BB("Teemo",0);boot.BB.ff=new boot.BB("Tristana",0);boot.BB.fg=new boot.BB("Trundle",0);boot.BB.fh=new boot.BB("Tryndamere",0);boot.BB.fi=new boot.BB("Twisted Fate",0);boot.BB.fj=new boot.BB("Twitch",0);boot.BB.fk=new boot.BB("Udyr",0);boot.BB.fl=new boot.BB("Urgot",0);boot.BB.fm=new boot.BB("Varus",0);boot.BB.fn=new boot.BB("Vayne",0);boot.BB.fo=new boot.BB("Veigar",0);boot.BB.fp=new boot.BB("Vi",0);boot.BB.ga=new boot.BB("Viktor",0);boot.BB.gb=new boot.BB("Vladimir",0);boot.BB.gc=new boot.BB("Volibear",0);boot.BB.gd=new boot.BB("Warwick",0);boot.BB.ge=new boot.BB("Wukong",0);boot.BB.gf=new boot.BB("Xerath",0);boot.BB.gg=new boot.BB("Xin Zhao",0);boot.BB.gh=new boot.BB("Yorick",0);boot.BB.gi=new boot.BB("Zed",0);boot.BB.gj=new boot.BB("Ziggs",0);boot.BB.gk=new boot.BB("Zilean",0);boot.BB.gl=new boot.BB("Zyra",0);},
// teemowork.model.Champion#<init>(java.lang.String)
$0:function(A){this.a=A;this.gm=this.CQ().toLowerCase();boot.BB.b.BW(A,this);},
// teemowork.model.Champion#getSystemName()
CQ:function(){return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");},
// teemowork.model.Champion#getSplashArt()
CR:function(){return "src/main/resources/teemowork/splash/"+this.CQ()+".jpg";},
// teemowork.model.Champion#getIcon()
CO:function(){return "src/main/resources/teemowork/icon/"+this.CQ()+".png";},
// teemowork.model.Champion#getByName(java.lang.String)
_CS:function(A){return boot.BB.b.Bv(A);},
// teemowork.model.Champion#getAll()
_CL:function(){return boot.BB.b.Bu();}});boot.define("G",boot.F,{
// teemowork.ChampionDetail#<init>(java.lang.String)
$0:function(A){boot.F.prototype.$0.call(this);this.a=boot.BB.CS(A);},
// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
BR:function(A){console.log("detail page "+this.a);},
// teemowork.ChampionDetail#getPageId()
I:function(){return "Champion/"+this.a.a;}});boot.define("U",boot.V,{
// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
$0:function(A){this.d=A;boot.V.prototype.$0.call(this);},
// teemowork.ChampionSelect$1#sources()
BT:function(){return boot.BB.CL();},
// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
CM:function(A){return A.a;},
// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
CN:function(A){return A.CO();},
// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
CP:function(A){boot.B.G(new boot.G(A.a,0));},
// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
BV:function(A){return this.CM(A);},
// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
BU:function(A){return this.CN(A);},
// teemowork.ChampionSelect$1#select(java.lang.Object)
CK:function(A){this.CP(A);}});boot.define("H",boot.F,{
// teemowork.ChampionSelect#<init>()
$0:function(){boot.F.prototype.$0.call(this);this.a=new boot.U(this,0);},
// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
BR:function(A){this.a.BS(A);},
// teemowork.ChampionSelect#getPageId()
I:function(){return "";}});boot.define("I",{
// js.application.Header#<init>()
$0:function(){this.a=$("#Header").addClass("h");},
// js.application.Header#add(java.lang.String, java.lang.String)
J:function(A,B,C){C=this.a.K("li").addClass("i");C.K("a").addClass("c").attr("href",B).text(A);return new boot.J(this,C,null,1);}});boot.define("A",boot.B,{
// teemowork.Teemowork#<init>()
$0:function(){boot.B.prototype.$0.call(this);},
// teemowork.Teemowork#jsmain()
A:function(A,B){this.D("Champion/*",boot.G);this.D("",boot.H);boot.B.prototype.A.call(this);$("body").css("padding","0px 10%");A=new boot.I(0);A.J("< ^ v ^ > Teemowork","test.html");A.J("Patch","#");B=A.J("Data","#");B.J("Champion","#");B.J("Item","#");B.J("Mastery","#");B.J("Rune","#");A.J("Builder","#");A.J("About","#");A.J("Contact","#");}});try {new boot.A(0).A();} catch(e) {console.log(e)}