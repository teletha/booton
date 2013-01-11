boot.define("L",{
// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
$0:function(A){this.a=A;this.b=0;},
// booton.translator.web.jQuery$1#hasNext()
M:function(){return this.b<this.a.size();},
// booton.translator.web.jQuery$1#next()
N:function(){return $(this.a.get(this.b++));},
// booton.translator.web.jQuery$1#remove()
O:function(){},
// booton.translator.web.jQuery$1#next()
P:function(){return this.N();}});boot.defineNative("Document",{
// booton.translator.web.Document#<init>()
$0:function(){},
// booton.translator.web.Document#createElement(java.lang.String)
createElement:function(A){return this.createElement(A);}});boot.defineNative("jQuery",{
// booton.translator.web.jQuery#<init>()
$0:function(){},
// booton.translator.web.jQuery#child(java.lang.String)
J:function(A){return $(document.createElement(A)).appendTo(this);},
// booton.translator.web.jQuery#child(java.lang.Class)
K:function(A){return this.J("span").addClass(A);},
// booton.translator.web.jQuery#iterator()
L:function(){return new boot.L(this,0);}});boot.define("O",{
// booton.translator.js.JsError#<init>()
$0:function(){},
// booton.translator.js.JsError#<init>(java.lang.String)
$1:function(A){}});boot.define("F",{
// js.Page#<init>()
$0:function(){}});boot.define("W",{
// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
$1:function(A,B,C){this.a=A;;this.b=B;this.c=C;},
// js.util.HashMap$View#hasNext()
M:function(){return this.b.M();},
// js.util.HashMap$View#next()
P:function(A){A=this.b.P();if(this.c==0){return A.z();}else{return A.BF();}},
// js.util.HashMap$View#remove()
O:function(){this.b.O();},
// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
$0:function(A,B,C,D){boot.W.prototype.$1.call(this,A,B,C);}});boot.define("X",{
// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
$1:function(A,B){this.a=A;;this.b=0;this.c=B;},
// js.util.HashSet$View#hasNext()
M:function(){return this.b<this.c.length;},
// js.util.HashSet$View#next()
P:function(){this.d=boot.Q.BR(this.a)[this.c[this.b++]];return this.d;},
// js.util.HashSet$View#remove()
O:function(){if(this.b<=0){}else{this.a.BL(this.d);}},
// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
$0:function(A,B,C){boot.X.prototype.$1.call(this,A,B);}});boot.define("V",{
// js.util.AbstractCollection#<init>()
$0:function(){},
// js.util.AbstractCollection#isEmpty()
u:function(){return this.Z()==0;},
// js.util.AbstractCollection#addAll(java.util.Collection)
BJ:function(A,B,C,D){B=0;D=A.L();l2:while (D.M()!=0) {C=D.P();if(this.F(C)==0){}else{B=1;continue l2;}continue l2;}return B;},
// js.util.AbstractCollection#retainAll(java.util.Collection)
BK:function(A,B,C,D){B=0;D=this.L();l2:while (D.M()!=0) {C=D.P();if(A.w(C)!=0){}else{B=this.BL(C);continue l2;}continue l2;}return B;},
// js.util.AbstractCollection#removeAll(java.util.Collection)
BM:function(A,B,C,D){B=0;D=A.L();l2:while (D.M()!=0) {C=D.P();if(this.BL(C)==0){}else{B=1;continue l2;}continue l2;}return B;},
// js.util.AbstractCollection#containsAll(java.util.Collection)
BN:function(A,B,C){C=A.L();l1:while (C.M()!=0) {B=C.P();if(this.w(B)!=0){}else{return 0;}continue l1;}return 1;},
// js.util.AbstractCollection#toArray()
BO:function(){return this.BP(new Array(0));},
// js.util.AbstractCollection#toArray(java.lang.Object[])
BP:function(A,B,C,D,E){B=this.Z();if(A.length>=B){}else{A=[];}C=this.L();D=0;l6:while (C.M()!=0) {E=C.P();A[D]=E;++D;continue l6;}return A;}});boot.define("U",boot.V,{
// js.util.AbstractSet#<init>()
$0:function(){boot.V.prototype.$0.call(this);}});boot.define("Q",boot.U,{
// js.util.HashSet#<init>()
$0:function(){boot.U.prototype.$0.call(this);this.a=0;this.b={};},
// js.util.HashSet#size()
Z:function(){return this.a;},
// js.util.HashSet#contains(java.lang.Object)
w:function(A){return this.BQ(A) in this.b;},
// js.util.HashSet#add(java.lang.Object)
F:function(A,B){B=this.BQ(A);if(B in this.b==0){this.a=this.a+1;this.b[B]=A;return 1;}else{return 0;}},
// js.util.HashSet#remove(java.lang.Object)
BL:function(A,B){B=this.BQ(A);if(B in this.b!=0){this.a=this.a-1;delete this.b[B];return 1;}else{return 0;}},
// js.util.HashSet#clear()
BG:function(){this.a=0;this.b=[];},
// js.util.HashSet#iterator()
L:function(){return new boot.X(this,this.b.keys(),null,0);},
// js.util.HashSet#hash(java.lang.Object)
BQ:function(A){return (A==null?-1:A.hashCode());},
// js.util.HashSet#find(java.lang.Object)
y:function(A){return this.b[this.BQ(A)];},
// js.util.HashSet#push(java.lang.Object)
BA:function(A,B,C){B=null;C=this.BQ(A);if(C in this.b==0){this.a=this.a+1;}else{B=this.b[C];}this.b[C]=A;return B;},
// js.util.HashSet#pull(java.lang.Object)
BC:function(A,B,C){B=null;C=this.BQ(A);if(C in this.b==0){}else{B=this.b[C];this.a=this.a-1;delete this.b[C];}return B;},
// js.util.HashSet#access$0(js.util.HashSet)
_BR:function(A){return A.b;}});boot.define("S",boot.U,{
// js.util.HashMap$Keys#<init>(js.util.HashMap)
$1:function(A){this.a=A;boot.U.prototype.$0.call(this);},
// js.util.HashMap$Keys#size()
Z:function(){return boot.P.BI(this.a).Z();},
// js.util.HashMap$Keys#contains(java.lang.Object)
w:function(A){return boot.P.BI(this.a).w(A);},
// js.util.HashMap$Keys#iterator()
L:function(){return new boot.W(this.a,boot.P.BI(this.a).L(),1,null,0);},
// js.util.HashMap$Keys#add(java.lang.Object)
F:function(A){return 0;},
// js.util.HashMap$Keys#remove(java.lang.Object)
BL:function(A){return boot.P.BI(this.a).BL(A);},
// js.util.HashMap$Keys#clear()
BG:function(){boot.P.BI(this.a).BG();},
// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
$0:function(A,B){boot.S.prototype.$1.call(this,A);}});boot.define("T",boot.V,{
// js.util.HashMap$Values#<init>(js.util.HashMap)
$1:function(A){this.a=A;boot.V.prototype.$0.call(this);},
// js.util.HashMap$Values#size()
Z:function(){return boot.P.BI(this.a).Z();},
// js.util.HashMap$Values#contains(java.lang.Object)
w:function(A){return this.a.x(A);},
// js.util.HashMap$Values#iterator()
L:function(){return new boot.W(this.a,boot.P.BI(this.a).L(),0,null,0);},
// js.util.HashMap$Values#add(java.lang.Object)
F:function(A){return 0;},
// js.util.HashMap$Values#remove(java.lang.Object)
BL:function(A,B,C){B=this.L();l2:while (B.M()!=0) {C=B.P();if(C!=A){}else{B.O();return 1;}continue l2;}return 0;},
// js.util.HashMap$Values#clear()
BG:function(){boot.P.BI(this.a).BG();},
// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
$0:function(A,B){boot.T.prototype.$1.call(this,A);}});boot.define("R",{
// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
$1:function(A,B){this.a=A;this.b=B;},
// js.util.HashMap$SimpleEntry#getKey()
BF:function(){return this.a;},
// js.util.HashMap$SimpleEntry#getValue()
z:function(){return this.b;},
// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
BS:function(A,B){B=this.b;this.b=A;return B;},
// js.util.HashMap$SimpleEntry#hashCode()
hashCode:function(){return this.a.hashCode();},
// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object, js.util.HashMap$SimpleEntry)
$0:function(A,B,C){boot.R.prototype.$1.call(this,A,B);}});boot.define("P",{
// js.util.HashMap#<init>()
$0:function(){this.a=new boot.Q(0);},
// js.util.HashMap#size()
Z:function(){return this.a.Z();},
// js.util.HashMap#isEmpty()
u:function(){return this.a.u();},
// js.util.HashMap#containsKey(java.lang.Object)
v:function(A){return this.a.w(A);},
// js.util.HashMap#containsValue(java.lang.Object)
x:function(A,B,C){C=this.Y().L();l1:while (C.M()!=0) {B=C.P();if(B!=A){}else{return 1;}continue l1;}return 0;},
// js.util.HashMap#get(java.lang.Object)
W:function(A,B){B=this.a.y(A);return (B==null?null:B.z());},
// js.util.HashMap#put(java.lang.Object, java.lang.Object)
T:function(A,B,C){C=this.a.BA(new boot.R(A,B,null,0));if(C!=null){return C.z();}else{return null;}},
// js.util.HashMap#remove(java.lang.Object)
BB:function(A,B){B=this.a.BC(A);if(B!=null){return B.z();}else{return null;}},
// js.util.HashMap#putAll(java.util.Map)
BD:function(A,B,C){C=A.BE().L();l1:for (;C.M()!=0;this.T(B.BF(),B.z())) {B=C.P();}},
// js.util.HashMap#clear()
BG:function(){this.a.BG();},
// js.util.HashMap#keySet()
BH:function(){return new boot.S(this,null,0);},
// js.util.HashMap#values()
Y:function(){return new boot.T(this,null,0);},
// js.util.HashMap#entrySet()
BE:function(){return this.a;},
// js.util.HashMap#access$0(js.util.HashMap)
_BI:function(A){return A.a;}});boot.define("N",{
// teemowork.model.Champion#<clinit>()
_:function(){boot.N.b=new boot.P(0);boot.N.c=new boot.N("Ahri",0);boot.N.d=new boot.N("Akali",0);boot.N.e=new boot.N("Alistar",0);boot.N.f=new boot.N("Amumu",0);boot.N.g=new boot.N("Ashe",0);boot.N.h=new boot.N("Blitzcrank",0);boot.N.i=new boot.N("Brand",0);boot.N.j=new boot.N("Caitlyn",0);boot.N.k=new boot.N("Cassiopeia",0);boot.N.l=new boot.N("Chogath",0);boot.N.m=new boot.N("Corki",0);boot.N.n=new boot.N("Darius",0);boot.N.o=new boot.N("Diana",0);boot.N.p=new boot.N("Dr.Mundo",0);boot.N.ba=new boot.N("Elise",0);boot.N.bb=new boot.N("Evelynn",0);boot.N.bc=new boot.N("Ezreal",0);boot.N.bd=new boot.N("Fiddlesticks",0);boot.N.be=new boot.N("Fiora",0);boot.N.bf=new boot.N("Fizz",0);boot.N.bg=new boot.N("Galio",0);boot.N.bh=new boot.N("Gangplank",0);boot.N.bi=new boot.N("Garen",0);boot.N.bj=new boot.N("Gragas",0);boot.N.bk=new boot.N("Graves",0);boot.N.bl=new boot.N("Hecarim",0);boot.N.bm=new boot.N("Heimerdinger",0);boot.N.bn=new boot.N("Irelia",0);boot.N.bo=new boot.N("Janna",0);boot.N.bp=new boot.N("Jarvan IV",0);boot.N.ca=new boot.N("Jax",0);boot.N.cb=new boot.N("Jayce",0);boot.N.cc=new boot.N("Karma",0);boot.N.cd=new boot.N("Karthus",0);boot.N.ce=new boot.N("Kassadin",0);boot.N.cf=new boot.N("Katarina",0);boot.N.cg=new boot.N("Kayle",0);boot.N.ch=new boot.N("Kennen",0);boot.N.ci=new boot.N("Kha'zix",0);boot.N.cj=new boot.N("Kog'maw",0);boot.N.ck=new boot.N("LeBlanc",0);boot.N.cl=new boot.N("Lee Sin",0);boot.N.cm=new boot.N("Leona",0);boot.N.cn=new boot.N("Lulu",0);boot.N.co=new boot.N("Lux",0);boot.N.cp=new boot.N("Malphite",0);boot.N.da=new boot.N("Maokai",0);boot.N.db=new boot.N("Master Yi",0);boot.N.dc=new boot.N("Miss Fortune",0);boot.N.dd=new boot.N("Mordekaiser",0);boot.N.de=new boot.N("Morgana",0);boot.N.df=new boot.N("Nami",0);boot.N.dg=new boot.N("Nasus",0);boot.N.dh=new boot.N("Nautilus",0);boot.N.di=new boot.N("Nidalee",0);boot.N.dj=new boot.N("Nocturne",0);boot.N.dk=new boot.N("Nunu",0);boot.N.dl=new boot.N("Olaf",0);boot.N.dm=new boot.N("Orianna",0);boot.N.dn=new boot.N("Pantheon",0);boot.N.dp=new boot.N("Poppy",0);boot.N.ea=new boot.N("Rammus",0);boot.N.eb=new boot.N("Renekton",0);boot.N.ec=new boot.N("Rengar",0);boot.N.ed=new boot.N("Riven",0);boot.N.ee=new boot.N("Rumble",0);boot.N.ef=new boot.N("Ryze",0);boot.N.eg=new boot.N("Sejuani",0);boot.N.eh=new boot.N("Shaco",0);boot.N.ei=new boot.N("Shen",0);boot.N.ej=new boot.N("Shyvana",0);boot.N.ek=new boot.N("Singed",0);boot.N.el=new boot.N("Sion",0);boot.N.em=new boot.N("Sivir",0);boot.N.en=new boot.N("Skarner",0);boot.N.eo=new boot.N("Sona",0);boot.N.ep=new boot.N("Soraka",0);boot.N.fa=new boot.N("Swain",0);boot.N.fb=new boot.N("Syndra",0);boot.N.fc=new boot.N("Talon",0);boot.N.fd=new boot.N("Taric",0);boot.N.fe=new boot.N("Teemo",0);boot.N.ff=new boot.N("Tristana",0);boot.N.fg=new boot.N("Trundle",0);boot.N.fh=new boot.N("Tryndamere",0);boot.N.fi=new boot.N("Twisted Fate",0);boot.N.fj=new boot.N("Twitch",0);boot.N.fk=new boot.N("Udyr",0);boot.N.fl=new boot.N("Urgot",0);boot.N.fm=new boot.N("Varus",0);boot.N.fn=new boot.N("Vayne",0);boot.N.fo=new boot.N("Veigar",0);boot.N.fp=new boot.N("Vi",0);boot.N.ga=new boot.N("Viktor",0);boot.N.gb=new boot.N("Vladimir",0);boot.N.gc=new boot.N("Volibear",0);boot.N.gd=new boot.N("Warwick",0);boot.N.ge=new boot.N("Wukong",0);boot.N.gf=new boot.N("Xerath",0);boot.N.gg=new boot.N("Xin Zhao",0);boot.N.gh=new boot.N("Yorick",0);boot.N.gi=new boot.N("Zed",0);boot.N.gj=new boot.N("Ziggs",0);boot.N.gk=new boot.N("Zilean",0);boot.N.gl=new boot.N("Zyra",0);},
// teemowork.model.Champion#<init>(java.lang.String)
$0:function(A){this.a=A;this.gm=this.S().toLowerCase();boot.N.b.T(A,this);},
// teemowork.model.Champion#getSystemName()
S:function(){return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");},
// teemowork.model.Champion#getSplashArt()
U:function(){return "src/main/resources/teemowork/splash/"+this.S()+".jpg";},
// teemowork.model.Champion#getIcon()
V:function(){return "src/main/resources/teemowork/icon/"+this.S()+".png";},
// teemowork.model.Champion#getByName(java.lang.String)
_Q:function(A){return boot.N.b.W(A);},
// teemowork.model.Champion#getAll()
_X:function(){return boot.N.b.Y();}});boot.define("G",boot.F,{
// teemowork.ChampionDetail#<init>(java.lang.String)
$0:function(A){boot.G.prototype.$1.call(this,boot.N.Q(A));},
// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
$1:function(A){boot.F.prototype.$0.call(this);if(A!=null){this.a=A;return;}else{throw new boot.O(0);}},
// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
R:function(A){console.log("detail page "+this.a+"  "+this.a.a);},
// teemowork.ChampionDetail#getPageId()
H:function(){return "Champion/"+this.a.a;}});boot.define("u",{
// js.ui.UI#<init>()
$0:function(){boot.u.prototype.$1.call(this,"div");},
// js.ui.UI#<init>(java.lang.String)
$1:function(A){this.a=$("<"+A+">");}});boot.define("v",{
// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
$0:function(A,B){this.a=A;this.b=B;},
// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
handler:function(A,B,C,D){B=this.b.val().toLowerCase().replace(/\s/g,"");D=boot.Z.BX(this.a).BE().L();l2:while (D.M()!=0) {C=D.P();if(this.a.BW(C.BF()).toLowerCase().indexOf(B) != -1==0){C.z().addClass("d");continue l2;}else{C.z().removeClass("d");continue l2;}}}});boot.define("w",{
// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
$0:function(A,B){this.a=A;this.b=B;},
// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
handler:function(A){this.a.Bv(this.b);}});boot.define("Z",boot.u,{
// js.ui.ImageGrid#<init>()
$0:function(){boot.u.prototype.$0.call(this);this.b=new boot.P(0);this.c=this.BU();},
// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
BT:function(A,B,C,D,E){this.a.css("line-height","0").css("width","700px").css("margin","0 auto");B=$("<input type='text'>");B.appendTo(this.a);B.addClass("a").css("display","block");B.keyup(new boot.v(this,B,0));D=this.c.L();l6:for (;D.M()!=0;this.b.T(C,E)) {C=D.P();E=this.a.K("b").css("background-image","url("+this.BV(C)+")");E.J("span").addClass("c").text(this.BW(C));E.click(new boot.w(this,C,0));}A.append(this.a);},
// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
_BX:function(A){return A.b;}});boot.define("y",{
// js.util.ArrayList$View#<init>(js.util.ArrayList)
$1:function(A){this.a=A;;this.b=0;},
// js.util.ArrayList$View#hasNext()
M:function(){return this.b<boot.x.CL(this.a).length;},
// js.util.ArrayList$View#next()
P:function(){return boot.x.CL(this.a)[this.b++];},
// js.util.ArrayList$View#remove()
O:function(){if(this.b<=0){}else{boot.x.CL(this.a).splice(this.b-1,1)[0];}},
// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
$0:function(A,B){boot.y.prototype.$1.call(this,A);}});boot.define("x",boot.V,{
// js.util.ArrayList#<init>()
$0:function(){boot.V.prototype.$0.call(this);this.a=[];},
// js.util.ArrayList#size()
Z:function(){return this.a.length;},
// js.util.ArrayList#contains(java.lang.Object)
w:function(A){return this.a.indexOf(A)!=-1;},
// js.util.ArrayList#iterator()
L:function(){return new boot.y(this,null,0);},
// js.util.ArrayList#add(java.lang.Object)
F:function(A){this.a.push(A);return 1;},
// js.util.ArrayList#remove(java.lang.Object)
BL:function(A,B){B=this.a.indexOf(A);if(B!=-1){this.a.splice(B,1)[0];return 1;}else{return 0;}},
// js.util.ArrayList#addAll(int, java.util.Collection)
CA:function(A,B){return 0;},
// js.util.ArrayList#clear()
BG:function(){this.a=[];},
// js.util.ArrayList#get(int)
CB:function(A){return this.a[A];},
// js.util.ArrayList#set(int, java.lang.Object)
CC:function(A,B){return this.a[A]=B;},
// js.util.ArrayList#add(int, java.lang.Object)
CD:function(A,B){this.a.splice(A,0,B);},
// js.util.ArrayList#remove(int)
CE:function(A){return this.a.splice(A,1)[0];},
// js.util.ArrayList#indexOf(java.lang.Object)
CF:function(A){return this.a.indexOf(A);},
// js.util.ArrayList#lastIndexOf(java.lang.Object)
CG:function(A){return this.a.lastIndexOf(A);},
// js.util.ArrayList#listIterator()
CH:function(){throw new boot.O(0);},
// js.util.ArrayList#listIterator(int)
CI:function(A){throw new boot.O(0);},
// js.util.ArrayList#subList(int, int)
CJ:function(A,B){throw new boot.O(0);},
// js.util.ArrayList#checkRange(int)
CK:function(A){if(A>=0){if(this.Z()>A){return;}else{throw new boot.O("Index is overflowed. Size: "+this.Z()+"  Index: "+A,1);}}else{throw new boot.O("Negative index is unacceptable. Size: "+this.Z()+"  Index: "+A,1);}},
// js.util.ArrayList#access$0(js.util.ArrayList)
_CL:function(A){return A.a;}});boot.define("E",{
// js.Application$Route#<init>(java.lang.String, java.lang.Class)
$1:function(A,B){this.a=new RegExp(A.replace(/\*/g,"([^/].+)"),"");this.b=B;},
// js.Application$Route#match(java.lang.String)
CM:function(A,B,C,D,E){B=this.a.exec(A);if(B!=null!=0){C=new boot.x(0);D=0;l6:for (;D<B.length-1;++D) {C.F(B[D+1]);}D=this.b.newInstance(0,C.BO());E=$(document.createDocumentFragment());D.R(E);$("#Content").empty().append(E);return D;}else{return null;}},
// js.Application$Route#access$0(js.Application$Route, java.lang.String)
_Bx:function(A,B){return A.CM(B);},
// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
$0:function(A,B,C){boot.E.prototype.$1.call(this,A,B);}});boot.define("z",{
// booton.translator.web.Location#<init>()
$0:function(){}});boot.define("D",{
// js.Application$Router#<init>()
$1:function(){this.a=new boot.x(0);},
// js.Application$Router#handler(booton.translator.web.jQuery$Event)
handler:function(A){this.Bw(location.hash);},
// js.Application$Router#dispatch(java.lang.String)
Bw:function(A,B,C){if((A.length==0||A.startsWith("#")==0)){}else{A=A.substring(1);}C=this.a.L();l3:while (C.M()!=0) {B=C.P();if(boot.E.Bx(B,A)==null){}else{return;}continue l3;}},
// js.Application$Router#dispatch(js.Page)
Bz:function(A,B){B=$(document.createDocumentFragment());this.b=A;this.b.R(B);$("#Content").empty().append(B);},
// js.Application$Router#<init>(js.Application$Router)
$0:function(A){boot.D.prototype.$1.call(this);},
// js.Application$Router#access$1(js.Application$Router, java.lang.String)
_B:function(A,B){A.Bw(B);},
// js.Application$Router#access$2(js.Application$Router)
_E:function(A){return A.a;}});boot.defineNative("History",{
// booton.translator.web.History#<init>()
$0:function(){}});boot.define("B",{
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
_G:function(A){if(A==null){}else{boot.D.B(boot.B.a,A.H());history.pushState("","","#"+A.H());}}});boot.define("Y",boot.Z,{
// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
$0:function(A){this.d=A;boot.Z.prototype.$0.call(this);},
// teemowork.ChampionSelect$1#sources()
BU:function(){return boot.N.X();},
// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
BY:function(A){return A.a;},
// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
BZ:function(A){return A.V();},
// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
Bu:function(A){boot.B.G(new boot.G(A.a,0));},
// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
BW:function(A){return this.BY(A);},
// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
BV:function(A){return this.BZ(A);},
// teemowork.ChampionSelect$1#select(java.lang.Object)
Bv:function(A){this.Bu(A);}});boot.define("H",boot.F,{
// teemowork.ChampionSelect#<init>()
$0:function(){boot.F.prototype.$0.call(this);this.a=new boot.Y(this,0);},
// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
R:function(A){this.a.BT(A);},
// teemowork.ChampionSelect#getPageId()
H:function(){return "";}});boot.define("J",{
// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
$1:function(A,B){this.a=A;;this.b=B.J("ul").addClass("h");},
// js.application.Header$Menu#add(java.lang.String, java.lang.String)
I:function(A,B,C){C=this.b.J("li").addClass("i");C.J("a").addClass("g").attr("href",B).text(A);return new boot.J(this.a,C,1);},
// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
$0:function(A,B,C){boot.J.prototype.$1.call(this,A,B);}});boot.define("I",{
// js.application.Header#<init>()
$0:function(){this.a=$("#Header").addClass("e");},
// js.application.Header#add(java.lang.String, java.lang.String)
I:function(A,B,C){C=this.a.J("li").addClass("f");C.J("a").addClass("g").attr("href",B).text(A);return new boot.J(this,C,null,0);}});boot.define("A",boot.B,{
// teemowork.Teemowork#<init>()
$0:function(){boot.B.prototype.$0.call(this);},
// teemowork.Teemowork#jsmain()
A:function(A,B){this.D("Champion/*",boot.G);this.D("",boot.H);boot.B.prototype.A.call(this);$("body").css("padding","0px 10%");A=new boot.I(0);A.I("< ^ v ^ > Teemowork","test.html");A.I("Patch","#");B=A.I("Data","#");B.I("Champion","#");B.I("Item","#");B.I("Mastery","#");B.I("Rune","#");A.I("Builder","#");A.I("About","#");A.I("Contact","#");}});try {new boot.A(0).A();} catch(e) {console.log(e)}