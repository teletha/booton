boot.defineNative("Document",{
	
	// booton.translator.web.Document#<init>()
	$0:function(){
	},
	// booton.translator.web.Document#createElement(java.lang.String)
	createElement:function(A){
		return this.createElement(A);
	}
});
boot.define("M",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	M:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	N:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	O:function(){
	},
	// booton.translator.web.jQuery$1#next()
	P:function(){
		return this.N();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	J:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	K:function(A){
		return this.J("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	L:function(){
		return new boot.M(this,0);
	}
});
boot.define("J",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.J("ul").addClass("d");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.J("li").addClass("e");
		C.J("a").addClass("c").attr("href",B).text(A);
		return new boot.J(this.a,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
	$0:function(A,B,C){
		boot.J.prototype.$1.call(this,A,B);
	}
});

boot.define("I",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("a");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.a.J("li").addClass("b");
		C.J("a").addClass("c").attr("href",B).text(A);
		return new boot.J(this,C,null,0);
	}
});

boot.define("Q",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.Q.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("T",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.X(this.b);
	}
});

boot.define("S",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.P.W(this.a).Y().L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.a.U(C.Z()).toLowerCase().indexOf(B) != -1==0){
				C.u().addClass("i");
				continue l2;
			}else{
				C.u().removeClass("i");
				continue l2;
			}
		}
	}
});

boot.define("Y",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	w:function(){
		return this.v()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BK:function(A,B,C,D){
		B=0;
		D=A.L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BL:function(A,B,C,D){
		B=0;
		D=this.L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(A.y(C)!=0){
			}else{
				B=this.BM(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BN:function(A,B,C,D){
		B=0;
		D=A.L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.BM(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BO:function(A,B,C){
		C=A.L();
		l1:while (C.M()!=0) {
			B=C.P();
			if(this.y(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BP:function(){
		return this.BQ(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BQ:function(A,B,C,D,E){
		B=this.v();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.L();
		D=0;
		l6:while (C.M()!=0) {
			E=C.P();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("Z",{
	
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.a=A;;
		this.b=B;
		this.c=C;
	},
	// js.util.HashMap$View#hasNext()
	M:function(){
		return this.b.M();
	},
	// js.util.HashMap$View#next()
	P:function(A){
		A=this.b.P();
		if(this.c==0){
			return A.u();
		}else{
			return A.Z();
		}
	},
	// js.util.HashMap$View#remove()
	O:function(){
		this.b.O();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.Z.prototype.$1.call(this,A,B,C);
	}
});

boot.define("u",boot.Y,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
	}
});

boot.define("v",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	M:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	P:function(){
		this.d=boot.U.BS(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	O:function(){
		if(this.b<=0){
		}else{
			this.a.BM(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.v.prototype.$1.call(this,A,B);
	}
});

boot.define("U",boot.u,{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.u.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	v:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	y:function(A){
		return this.BR(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.BR(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BM:function(A,B){
		B=this.BR(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BH:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	L:function(){
		return new boot.v(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	BR:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	BC:function(A){
		return this.b[this.BR(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	BD:function(A,B,C){
		B=null;
		C=this.BR(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	BF:function(A,B,C){
		B=null;
		C=this.BR(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_BS:function(A){
		return A.b;
	}
});

boot.define("X",boot.Y,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.Y.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	v:function(){
		return boot.R.BJ(this.a).v();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	y:function(A){
		return this.a.z(A);
	},
	// js.util.HashMap$Values#iterator()
	L:function(){
		return new boot.Z(this.a,boot.R.BJ(this.a).L(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BM:function(A,B,C){
		B=this.L();
		l2:while (B.M()!=0) {
			C=B.P();
			if(C!=A){
			}else{
				B.O();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BH:function(){
		boot.R.BJ(this.a).BH();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.X.prototype.$1.call(this,A);
	}
});

boot.define("V",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	Z:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	u:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	BT:function(A,B){
		B=this.b;
		this.b=A;
		return B;
	},
	// js.util.HashMap$SimpleEntry#hashCode()
	hashCode:function(){
		return this.a.hashCode();
	},
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object, js.util.HashMap$SimpleEntry)
	$0:function(A,B,C){
		boot.V.prototype.$1.call(this,A,B);
	}
});

boot.define("W",boot.u,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.u.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	v:function(){
		return boot.R.BJ(this.a).v();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	y:function(A){
		return boot.R.BJ(this.a).y(A);
	},
	// js.util.HashMap$Keys#iterator()
	L:function(){
		return new boot.Z(this.a,boot.R.BJ(this.a).L(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BM:function(A){
		return boot.R.BJ(this.a).BM(A);
	},
	// js.util.HashMap$Keys#clear()
	BH:function(){
		boot.R.BJ(this.a).BH();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.W.prototype.$1.call(this,A);
	}
});

boot.define("R",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.U(0);
	},
	// js.util.HashMap#size()
	v:function(){
		return this.a.v();
	},
	// js.util.HashMap#isEmpty()
	w:function(){
		return this.a.w();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	x:function(A){
		return this.a.y(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	z:function(A,B,C){
		C=this.BA().L();
		l1:while (C.M()!=0) {
			B=C.P();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	BB:function(A,B){
		B=this.a.BC(A);
		return (B==null?null:B.u());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	V:function(A,B,C){
		C=this.a.BD(new boot.V(A,B,null,0));
		if(C!=null){
			return C.u();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	BE:function(A,B){
		B=this.a.BF(A);
		if(B!=null){
			return B.u();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	BG:function(A,B,C){
		C=A.Y().L();
		l1:for (;
		C.M()!=0;
		this.V(B.Z(),B.u())) {
			B=C.P();
		}
	},
	// js.util.HashMap#clear()
	BH:function(){
		this.a.BH();
	},
	// js.util.HashMap#keySet()
	BI:function(){
		return new boot.W(this,null,0);
	},
	// js.util.HashMap#values()
	BA:function(){
		return new boot.X(this,null,0);
	},
	// js.util.HashMap#entrySet()
	Y:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_BJ:function(A){
		return A.a;
	}
});

boot.define("P",boot.Q,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.Q.prototype.$0.call(this);
		this.b=new boot.R(0);
		this.c=this.S();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	R:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("f").css("display","block");
		B.keyup(new boot.S(this,B,0));
		D=this.c.L();
		l6:for (;
		D.M()!=0;
		this.b.V(C,E)) {
			C=D.P();
			E=this.a.K("g").css("background-image","url("+this.T(C)+")");
			E.J("span").addClass("h").text(this.U(C));
			E.click(new boot.T(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_W:function(A){
		return A.b;
	}
});

boot.define("w",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.w.b=new boot.R(0);
		boot.w.c=new boot.w("Ahri",0);
		boot.w.d=new boot.w("Akali",0);
		boot.w.e=new boot.w("Alistar",0);
		boot.w.f=new boot.w("Amumu",0);
		boot.w.g=new boot.w("Anivia",0);
		boot.w.h=new boot.w("Annie",0);
		boot.w.i=new boot.w("Ashe",0);
		boot.w.j=new boot.w("Blitzcrank",0);
		boot.w.k=new boot.w("Brand",0);
		boot.w.l=new boot.w("Caitlyn",0);
		boot.w.m=new boot.w("Cassiopeia",0);
		boot.w.n=new boot.w("Chogath",0);
		boot.w.o=new boot.w("Corki",0);
		boot.w.p=new boot.w("Darius",0);
		boot.w.ba=new boot.w("Diana",0);
		boot.w.bb=new boot.w("Dr.Mundo",0);
		boot.w.bc=new boot.w("Draven",0);
		boot.w.bd=new boot.w("Elise",0);
		boot.w.be=new boot.w("Evelynn",0);
		boot.w.bf=new boot.w("Ezreal",0);
		boot.w.bg=new boot.w("Fiddlesticks",0);
		boot.w.bh=new boot.w("Fiora",0);
		boot.w.bi=new boot.w("Fizz",0);
		boot.w.bj=new boot.w("Galio",0);
		boot.w.bk=new boot.w("Gangplank",0);
		boot.w.bl=new boot.w("Garen",0);
		boot.w.bm=new boot.w("Gragas",0);
		boot.w.bn=new boot.w("Graves",0);
		boot.w.bo=new boot.w("Hecarim",0);
		boot.w.bp=new boot.w("Heimerdinger",0);
		boot.w.ca=new boot.w("Irelia",0);
		boot.w.cb=new boot.w("Janna",0);
		boot.w.cc=new boot.w("Jarvan IV",0);
		boot.w.cd=new boot.w("Jax",0);
		boot.w.ce=new boot.w("Jayce",0);
		boot.w.cf=new boot.w("Karma",0);
		boot.w.cg=new boot.w("Karthus",0);
		boot.w.ch=new boot.w("Kassadin",0);
		boot.w.ci=new boot.w("Katarina",0);
		boot.w.cj=new boot.w("Kayle",0);
		boot.w.ck=new boot.w("Kennen",0);
		boot.w.cl=new boot.w("Kha'zix",0);
		boot.w.cm=new boot.w("Kog'maw",0);
		boot.w.cn=new boot.w("LeBlanc",0);
		boot.w.co=new boot.w("Lee Sin",0);
		boot.w.cp=new boot.w("Leona",0);
		boot.w.da=new boot.w("Lulu",0);
		boot.w.db=new boot.w("Lux",0);
		boot.w.dc=new boot.w("Malphite",0);
		boot.w.dd=new boot.w("Malzahar",0);
		boot.w.de=new boot.w("Maokai",0);
		boot.w.df=new boot.w("Master Yi",0);
		boot.w.dg=new boot.w("Miss Fortune",0);
		boot.w.dh=new boot.w("Mordekaiser",0);
		boot.w.di=new boot.w("Morgana",0);
		boot.w.dj=new boot.w("Nami",0);
		boot.w.dk=new boot.w("Nasus",0);
		boot.w.dl=new boot.w("Nautilus",0);
		boot.w.dm=new boot.w("Nidalee",0);
		boot.w.dn=new boot.w("Nocturne",0);
		boot.w.dp=new boot.w("Nunu",0);
		boot.w.ea=new boot.w("Olaf",0);
		boot.w.eb=new boot.w("Orianna",0);
		boot.w.ec=new boot.w("Pantheon",0);
		boot.w.ed=new boot.w("Poppy",0);
		boot.w.ee=new boot.w("Rammus",0);
		boot.w.ef=new boot.w("Renekton",0);
		boot.w.eg=new boot.w("Rengar",0);
		boot.w.eh=new boot.w("Riven",0);
		boot.w.ei=new boot.w("Rumble",0);
		boot.w.ej=new boot.w("Ryze",0);
		boot.w.ek=new boot.w("Sejuani",0);
		boot.w.el=new boot.w("Shaco",0);
		boot.w.em=new boot.w("Shen",0);
		boot.w.en=new boot.w("Shyvana",0);
		boot.w.eo=new boot.w("Singed",0);
		boot.w.ep=new boot.w("Sion",0);
		boot.w.fa=new boot.w("Sivir",0);
		boot.w.fb=new boot.w("Skarner",0);
		boot.w.fc=new boot.w("Sona",0);
		boot.w.fd=new boot.w("Soraka",0);
		boot.w.fe=new boot.w("Swain",0);
		boot.w.ff=new boot.w("Syndra",0);
		boot.w.fg=new boot.w("Talon",0);
		boot.w.fh=new boot.w("Taric",0);
		boot.w.fi=new boot.w("Teemo",0);
		boot.w.fj=new boot.w("Tristana",0);
		boot.w.fk=new boot.w("Trundle",0);
		boot.w.fl=new boot.w("Tryndamere",0);
		boot.w.fm=new boot.w("Twisted Fate",0);
		boot.w.fn=new boot.w("Twitch",0);
		boot.w.fo=new boot.w("Udyr",0);
		boot.w.fp=new boot.w("Urgot",0);
		boot.w.ga=new boot.w("Varus",0);
		boot.w.gb=new boot.w("Vayne",0);
		boot.w.gc=new boot.w("Veigar",0);
		boot.w.gd=new boot.w("Vi",0);
		boot.w.ge=new boot.w("Viktor",0);
		boot.w.gf=new boot.w("Vladimir",0);
		boot.w.gg=new boot.w("Volibear",0);
		boot.w.gh=new boot.w("Warwick",0);
		boot.w.gi=new boot.w("Wukong",0);
		boot.w.gj=new boot.w("Xerath",0);
		boot.w.gk=new boot.w("Xin Zhao",0);
		boot.w.gl=new boot.w("Yorick",0);
		boot.w.gm=new boot.w("Zed",0);
		boot.w.gn=new boot.w("Ziggs",0);
		boot.w.go=new boot.w("Zilean",0);
		boot.w.gp=new boot.w("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.CC().toLowerCase();
		boot.w.b.V(A,this);
	},
	// teemowork.model.Champion#getStatus()
	Bw:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CC:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	Bu:function(){
		return "src/main/resources/teemowork/splash/"+this.CC()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	BX:function(){
		return "src/main/resources/teemowork/icon/"+this.CC()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_BZ:function(A){
		return boot.w.b.BB(A);
	},
	// teemowork.model.Champion#getAll()
	_BU:function(){
		return boot.w.b.BA();
	}
});

boot.define("BB",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.BB.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.BB.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BB.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.BB.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	CD:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	CE:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	CF:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	CG:function(){
		console.log(this.a);
	}
});

boot.define("x",boot.BB,{
	
	// java.lang.Error#<init>()
	$0:function(){
		boot.BB.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$1:function(A){
		boot.BB.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.BB.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BB.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.BB.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BA",{
	
	// teemowork.model.ChampionStatus#<init>(teemowork.model.Patch, teemowork.model.ChampionStatus)
	$0:function(A,B){
		this.a=A;
		this.b=B;
		if(B==null){
		}else{
			this.c=B.c;
			this.d=B.d;
		}
	},
	// teemowork.model.ChampionStatus#healthInitial()
	CH:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	CI:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	CJ:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	CK:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	CL:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	CM:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	CN:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	CO:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	CP:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	CQ:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	CR:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	CS:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	CT:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	CU:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	CV:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	CW:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	CX:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	CY:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	CZ:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	Cu:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	Cv:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	Cw:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	Cx:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	Cy:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	Cz:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	DA:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	DB:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	DC:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	DD:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	DE:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	DF:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	DG:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	Bx:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	Bz:function(A){
		return this.g+this.h*A;
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("z",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.G.CB(this.a,boot.G.CA(this.a)-1);
	}
});

boot.define("y",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.G.CB(this.a,boot.G.CA(this.a)+1);
	}
});

boot.define("F",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("G",boot.F,{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.G.prototype.$1.call(this,boot.w.BZ(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.F.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.x(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	Q:function(A,B,C){
		B=A.K("j").css("background-image","url('"+this.a.Bu()+"')").K("k");
		C=B.K("l").css("background-image","url("+this.a.BX()+")").click(new boot.y(this,0)).on("contextmenu",new boot.z(this,0));
		this.b=C.K("m");
		this.c=B.K("n").text("Health").K("o");
		this.d=B.K("n").text("Mana").K("o");
		this.Bv(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	Bv:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.e=A;
			this.b.text(""+A);
			B=this.a.Bw();
			this.c.text(""+B.Bx(A));
			this.d.text(""+B.Bz(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_CA:function(A){
		return A.e;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CB:function(A,B){
		A.Bv(B);
	}
});

boot.define("BF",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	M:function(){
		return this.b<boot.BD.DW(this.a).length;
	},
	// js.util.ArrayList$View#next()
	P:function(){
		return boot.BD.DW(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	O:function(){
		if(this.b<=0){
		}else{
			boot.BD.DW(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.BF.prototype.$1.call(this,A);
	}
});

boot.define("BE",boot.BB,{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.BB.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.BB.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.BB.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BB.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.BB.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BH",boot.BE,{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.BE.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.BE.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.BE.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BE.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.BE.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BG",boot.BH,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.BH.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.BH.prototype.$1.call(this,A);
	}
});

boot.define("BD",boot.Y,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	v:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	y:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	L:function(){
		return new boot.BF(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BM:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	DL:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BH:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	DM:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	DN:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	DO:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	DP:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	DQ:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	DR:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	DS:function(){
		throw new boot.x(0);
	},
	// js.util.ArrayList#listIterator(int)
	DT:function(A){
		throw new boot.x(0);
	},
	// js.util.ArrayList#subList(int, int)
	DU:function(A,B){
		throw new boot.x(0);
	},
	// js.util.ArrayList#checkRange(int)
	DV:function(A){
		if(A>=0){
			if(this.v()>A){
				return;
			}else{
				throw new boot.BG("Index is overflowed. Size: "+this.v()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BG("Negative index is unacceptable. Size: "+this.v()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_DW:function(A){
		return A.a;
	}
});

boot.define("E",{
	
	// js.Application$Route#<init>(java.lang.String, java.lang.Class)
	$1:function(A,B){
		this.a=new RegExp(A.replace(/\*/g,"([^/].+)"),"");
		this.b=B;
	},
	// js.Application$Route#match(java.lang.String)
	DK:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.BD(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.BP());
			} catch ($) {
				if ($ instanceof boot.BE) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_DI:function(A,B){
		return A.DK(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.E.prototype.$1.call(this,A,B);
	}
});

boot.define("BI",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("D",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.BD(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.DH(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	DH:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.L();
		l3:while (C.M()!=0) {
			B=C.P();
			D=boot.E.DI(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.Q(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	DJ:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.Q(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.D.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.DH(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_E:function(A){
		return A.a;
	}
});

boot.defineNative("History",{
	
	// booton.translator.web.History#<init>()
	$0:function(){
	}
});
boot.define("B",{
	
	// js.Application#<clinit>()
	_:function(){
		boot.B.a=new boot.D(null,0);
	},
	// js.Application#<init>()
	$0:function(){
	},
	// js.Application#jsmain()
	A:function(){
		$(window).on("hashchange",boot.B.a);
		boot.D.B(boot.B.a,location.hash);
	},
	// js.Application#configure(js.application.Header)
	C:function(A){
	},
	// js.Application#register(java.lang.String, java.lang.Class)
	D:function(A,B){
		boot.D.E(boot.B.a).F(new boot.E(A,B,null,0));
	},
	// js.Application#show(js.Page)
	_G:function(A){
		if(A==null){
		}else{
			boot.D.B(boot.B.a,A.H());
			history.pushState("","","#"+A.H());
		}
	}
});

boot.define("O",boot.P,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.P.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	S:function(){
		return boot.w.BU();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	BV:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	BW:function(A){
		return A.BX();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	BY:function(A){
		boot.B.G(new boot.G(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	U:function(A){
		return this.BV(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	T:function(A){
		return this.BW(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	X:function(A){
		this.BY(A);
	}
});

boot.define("H",boot.F,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.F.prototype.$0.call(this);
		this.a=new boot.O(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	Q:function(A){
		this.a.R(A);
	},
	// teemowork.ChampionSelect#getPageId()
	H:function(){
		return "";
	}
});

boot.define("BK",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.BK.a=new boot.R(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.BK.a.BB(A);
		if(C==null){
		}else{
			this.d=C.d;
			this.e=C.e;
			this.f=C.f;
			this.g=C.g;
			this.h=C.h;
			this.i=C.i;
			this.j=C.j;
			this.k=C.k;
			this.l=C.l;
			this.m=C.m;
			this.n=C.n;
			this.o=C.o;
			this.p=C.p;
			this.ba=C.ba;
			this.bb=C.bb;
			this.bc=C.bc;
			this.bd=C.bd;
			this.be=C.be;
			this.bf=C.bf;
		}this.bg=C;
		boot.BK.a.V(A,this);
	},
	// teemowork.model.Item#cost()
	Dw:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	DY:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	Dx:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	Dy:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	Dz:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	EA:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	EB:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	EC:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	ED:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	EE:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	EG:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	EH:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	EI:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	EJ:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	EK:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	Du:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	EL:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	EM:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	EO:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	EP:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	EQ:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	ER:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	ES:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	ET:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	EU:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	DZ:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	EV:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	EW:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	EX:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	EY:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	EZ:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	Eu:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	Ev:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	Ew:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	Ex:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	Ey:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	Ez:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FA:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FB:function(A){
		return boot.BK.a.BB(A);
	},
	// teemowork.model.Item#getAll()
	_BU:function(){
		return boot.BK.a.BA();
	}
});

boot.define("K",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.K.b=new boot.K(1510,2012,11,13,"Initial",null,0);
		boot.K.b.DX("Ruby Crystal").DY(475).DZ(180);
		boot.K.b.DX("Haunting Guise").DZ(200).Du(25);
		boot.K.b.Dv(boot.w.c).CJ(380,80).CM(5.5,0.6).CP(230,50.0).CS(6.25,0.6).CV(50.0,3.0).CY(0.668,2.0).Cv(10.0,3.5).Cy(30.0,0).DA(550).DC(330);
		boot.K.b.Dv(boot.w.d).CJ(445,85).CM(7.25,0.65).DE(200).DG(50).CV(53.0,3.2).CY(0.694,3.1).Cv(16.5,3.5).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.e).CJ(442,102).CM(7.25,0.85).CP(215,38.0).CS(6.45,0.45).CV(55.03,3.62).CY(0.625,3.62).Cv(14.5,3.5).Cy(30.0,1.25).DA(125).DC(325);
		boot.K.b.Dv(boot.w.f).CJ(472,84).CM(7.45,0.85).CP(220,40.0).CS(6.5,0.525).CV(47.0,3.8).CY(0.638,2.18).Cv(18.0,3.3).Cy(30.0,1.25).DA(125).DC(335);
		boot.K.b.Dv(boot.w.g).CJ(350,70).CM(4.65,0.55).CP(257,53.0).CS(7.0,0.6).CV(48.0,3.2).CY(0.625,1.68).Cv(10.5,4.0).Cy(30.0,0).DA(600).DC(325);
		boot.K.b.Dv(boot.w.h).CJ(384,76).CM(4.5,0.55).CP(250,50.0).CS(6.9,0.6).CV(49.0,2.625).CY(0.579,1.36).Cv(12.5,4.0).Cy(30.0,0).DA(625).DC(335);
		boot.K.b.Dv(boot.w.i).CJ(395,79).CM(4.5,0.55).CP(173,35.0).CS(6.3,0.4).CV(46.3,2.85).CY(0.658,3.34).Cv(11.5,3.4).Cy(30.0,0).DA(600).DC(325);
		boot.K.b.Dv(boot.w.j).CJ(423,95).CM(7.25,0.75).CP(260,40.0).CS(6.6,0.5).CV(55.66,3.5).CY(0.625,1.13).Cv(14.5,3.5).Cy(30.0,1.25).DA(125).DC(325);
		boot.K.b.Dv(boot.w.k).CJ(380,76).CM(4.5,0.55).CP(250,45.0).CS(7.0,0.6).CV(51.66,3.0).CY(0.625,1.36).Cv(12.0,3.5).Cy(30.0,0).DA(550).DC(340);
		boot.K.b.Dv(boot.w.l).CJ(390,80).CM(4.75,0.55).CP(255,35.0).CS(6.5,0.55).CV(47.0,3.0).CY(0.668,3.0).Cv(13.0,3.5).Cy(30.0,0).DA(650).DC(325);
		boot.K.b.Dv(boot.w.m).CJ(380,75).CM(4.85,0.5).CP(250,50.0).CS(7.1,0.75).CV(47.0,3.2).CY(0.644,1.68).Cv(11.5,4.0).Cy(30.0,0).DA(550).DC(335);
		boot.K.b.Dv(boot.w.n).CJ(440,80).CM(7.5,0.85).CP(205,40.0).CS(6.45,0.45).CV(54.1,4.2).CY(0.625,1.44).Cv(19.0,3.5).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.o).CJ(375,82).CM(4.5,0.55).CP(243,37.0).CS(6.5,0.55).CV(48.2,3.0).CY(0.658,2.3).Cv(13.5,3.5).Cy(30.0,0).DA(550).DC(325);
		boot.K.b.Dv(boot.w.p).CJ(426,93).CM(8.25,0.95).CP(200,37.5).CS(6.0,0.35).CV(50.0,3.5).CY(0.679,2.6).Cv(20.0,3.5).Cy(30.0,1.25).DA(125).DC(340);
		boot.K.b.Dv(boot.w.ba).CJ(438,90).CM(7.0,0.85).CP(230,40.0).CS(7.0,0.6).CV(48.0,3.0).CY(0.625,2.25).Cv(16.0,3.6).Cy(30.0,1.25).DA(150).DC(345);
		boot.K.b.Dv(boot.w.bb).CJ(433,89).CM(6.5,0.75).CV(56.23,3.0).CY(0.625,2.8).Cv(17.0,3.5).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.bc).CJ(420,82).CM(5.0,0.7).CP(240,42.0).CS(6.95,0.65).CV(46.5,3.5).CY(0.679,2.6).Cv(16.0,3.3).Cy(30.0,0).DA(550).DC(330);
		boot.K.b.Dv(boot.w.bd).CJ(395,80).CM(4.7,0.6).CP(240,50.0).CS(6.8,0.65).CV(47.5,3.0).CY(0.625,1.75).Cv(12.65,3.35).Cy(30.0,0).DA(550).DC(335);
		boot.K.b.Dv(boot.w.be).CJ(414,86).CM(6.95,0.55).CP(180,42.0).CS(7.1,0.6).CV(48.0,3.3).CY(0.658,3.84).Cv(12.5,4.0).Cy(30.0,1.25).DA(125).DC(340);
		boot.K.b.Dv(boot.w.bf).CJ(350,80).CM(5.5,0.55).CP(235,45.0).CS(7.0,0.65).CV(47.2,3.0).CY(0.665,2.8).Cv(12.0,3.5).Cy(30.0,0).DA(550).DC(330);
		boot.K.b.Dv(boot.w.bg).CJ(390,80).CM(4.6,0.6).CP(251,59.0).CS(6.9,0.65).CV(45.95,2.625).CY(0.625,2.11).Cv(11.0,3.5).Cy(30.0,0).DA(480).DC(335);
		boot.K.b.Dv(boot.w.bh).CJ(450,85).CM(6.3,0.8).CP(220,40.0).CS(7.25,0.5).CV(54.5,3.2).CY(0.672,3.0).Cv(15.5,3.5).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.bi).CJ(414,86).CM(7.0,0.7).CP(200,40.0).CS(6.15,0.45).CV(53.0,3.0).CY(0.658,3.1).Cv(13.0,3.4).Cy(30.0,1.25).DA(175).DC(335);
		boot.K.b.Dv(boot.w.bj).CJ(435,85).CM(7.45,0.75).CP(235,50.0).CS(7.0,0.7).CV(56.3,3.375).CY(0.638,1.2).Cv(17.0,3.5).Cy(30.0,0).DA(125).DC(335);
		boot.K.b.Dv(boot.w.bk).CJ(495,81).CM(425.0,0.75).CP(215,40.0).CS(6.5,0.7).CV(54.0,3.0).CY(0.651,2.75).Cv(16.5,3.3).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.bl).CJ(455,96).CM(7.5,0.75).CV(52.5,3.5).CY(0.625,2.9).Cv(19.0,2.7).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.bm).CJ(434,89).CM(7.25,0.85).CP(221,47.0).CS(6.45,0.45).CV(55.78,3.375).CY(0.651,2.05).Cv(16.0,3.6).Cy(30.0,0).DA(125).DC(340);
		boot.K.b.Dv(boot.w.bn).CJ(410,84).CM(5.5,0.7).CP(255,40.0).CS(6.75,0.7).CV(51.0,3.1).CY(0.625,2.9).Cv(15.0,3.2).Cy(30.0,0).DA(525).DC(330);
		boot.K.b.Dv(boot.w.bo).CJ(440,95).CM(8.0,0.75).CP(210,40.0).CS(6.5,0.6).CV(56.0,3.2).CY(0.67,2.5).Cv(16.0,4.0).Cy(30.0,1.25).DA(175).DC(345);
		boot.K.b.Dv(boot.w.bp).CJ(350,75).CM(4.5,0.55).CP(240,65.0).CS(7.0,0.65).CV(49.24,3.0).CY(0.625,1.21).Cv(7.0,3.0).Cy(30.0,0).DA(550).DC(325);
		boot.K.b.Dv(boot.w.ca).CJ(456,90).CM(7.5,0.65).CP(230,35.0).CS(7.0,0.65).CV(56.0,3.3).CY(0.665,3.2).Cv(15.0,3.75).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.cb).CJ(356,78).CM(4.5,0.55).CP(302,64.0).CS(6.9,0.6).CV(49.0,2.95).CY(0.625,2.61).Cv(9.0,3.8).Cy(30.0,0).DA(475).DC(335);
		boot.K.b.Dv(boot.w.cc).CJ(420,90).CM(7.0,0.7).CP(235,40.0).CS(6.0,0.45).CV(50.0,3.4).CY(0.658,2.5).Cv(14.0,3.0).Cy(30.0,1.25).DA(175).DC(340);
		boot.K.b.Dv(boot.w.cd).CJ(463,98).CM(7.45,0.55).CP(230,35.0).CS(6.4,0.7).CV(56.3,3.375).CY(0.638,3.4).Cv(18.0,3.5).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.ce).CJ(420,90).CM(6.0,0.8).CP(240,40.0).CS(7.0,0.7).CV(46.5,3.5).CY(0.658,3.0).Cv(12.5,3.5).Cy(30.0,0).DA(125).DC(335);
		boot.K.b.Dv(boot.w.cf).CJ(410,86).CM(4.7,0.55).CP(240,60.0).CS(6.8,0.65).CV(50.0,3.3).CY(0.625,2.3).Cv(15.0,3.5).Cy(30.0,0).DA(425).DC(335);
		boot.K.b.Dv(boot.w.cg).CJ(390,75).CM(5.5,0.55).CP(270,61.0).CS(6.5,0.6).CV(42.2,3.25).CY(0.625,2.11).Cv(11.0,3.5).Cy(30.0,0).DA(450).DC(335);
		boot.K.b.Dv(boot.w.ch).CJ(433,78).CM(6.95,0.5).CP(230,45.0).CS(6.9,0.6).CV(52.3,3.9).CY(0.638,3.7).Cv(14.0,3.2).Cy(30.0,1.25).DA(125).DC(340);
		boot.K.b.Dv(boot.w.ci).CJ(395,83).CM(6.95,0.55).CV(53.0,3.2).CY(0.658,2.74).Cv(14.75,4.0).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.cj).CJ(418,93).CM(7.0,0.75).CP(255,40.0).CS(6.9,0.525).CV(53.3,2.8).CY(0.638,2.5).Cv(17.0,3.5).Cy(30.0,0.75).DA(125).DC(335);
		boot.K.b.Dv(boot.w.ck).CJ(403,79).CM(4.65,0.65).DE(200).DG(50).CV(51.3,3.3).CY(0.69,3.4).Cv(14.0,3.75).Cy(30.0,0).DA(550).DC(335);
		boot.K.b.Dv(boot.w.cl).CJ(430,85).CM(6.25,0.75).CP(260,40.0).CS(6.75,0.5).CV(50.0,3.1).CY(0.665,2.7).Cv(15.0,3.0).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.cm).CJ(440,84).CM(5.0,0.55).CP(295,40.0).CS(7.5,0.7).CV(46.0,3.0).CY(0.665,2.65).Cv(13.0,3.53).Cy(30.0,0).DA(500).DC(340);
		boot.K.b.Dv(boot.w.cn).CJ(390,75).CM(4.5,0.55).CP(250,50.0).CS(6.9,0.6).CV(51.0,3.1).CY(0.625,1.4).Cv(12.0,3.5).Cy(30.0,0).DA(525).DC(335);
		boot.K.b.Dv(boot.w.co).CJ(428,85).CM(6.25,61.0).DG(200).DG(50).CV(55.8,3.2).CY(0.651,3.0).Cv(16.0,3.7).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.cp).CJ(430,87).CM(9.0,0.85).CP(235,40.0).CS(8.0,0.7).CV(55.0,3.0).CY(0.625,2.9).Cv(18.0,3.1).Cy(30.0,1.25).DA(125).DC(335);
		boot.K.b.Dv(boot.w.da).CJ(415,82).CM(6.0,0.72).CP(200,50.0).CS(6.0,0.6).CV(44.4,2.6).CY(0.625,2.2).Cv(9.0,3.7).Cy(30.0,0).DA(550).DC(325);
		boot.K.b.Dv(boot.w.db).CJ(345,79).CM(4.5,0.55).CP(250,50.0).CS(6.0,0.6).CV(50.0,3.3).CY(0.625,1.36).Cv(8.0,4.0).Cy(30.0,0).DA(550).DC(340);
		boot.K.b.Dv(boot.w.dc).CJ(423,90).CM(7.45,0.55).CP(215,40.0).CS(6.4,0.55).CV(56.3,3.375).CY(0.638,3.4).Cv(18.0,3.75).Cy(30.0,1.25).DA(125).DC(335);
		boot.K.b.Dv(boot.w.dd).CJ(380,80).CM(4.5,0.55).CP(250,45.0).CS(7.0,0.6).CV(51.66,3.0).CY(0.625,1.36).Cv(15.0,3.5).Cy(30.0,0).DA(550).DC(340);
		boot.K.b.Dv(boot.w.de).CJ(421,90).CM(7.25,0.85).CP(250,46.0).CS(6.45,0.45).CV(58.0,3.3).CY(0.694,2.13).Cv(18.0,4.0).Cy(30.0,0).DA(125).DC(335);
		boot.K.b.Dv(boot.w.df).CJ(444,86).CM(6.75,0.65).CP(199,36.0).CS(6.5,0.45).CV(55.12,3.1).CY(0.679,2.98).Cv(16.3,3.7).Cy(30.0,1.25).DA(125).DC(355);
		boot.K.b.Dv(boot.w.dg).CJ(435,85).CM(5.1,0.65).CP(212,38.0).CS(6.95,0.65).CV(46.5,3.0).CY(0.658,3.01).Cv(15.0,3.0).Cy(30.0,0).DA(550).DC(325);
		boot.K.b.Dv(boot.w.dh).CJ(421,80).CM(7.45,0.55).CV(51.7,3.5).CY(0.694,3.0).Cv(15.0,3.5).Cy(30.0,1.25).DA(125).DC(340);
		boot.K.b.Dv(boot.w.di).CJ(403,86).CM(4.7,0.6).CP(240,60.0).CS(6.8,0.65).CV(51.58,3.5).CY(0.579,1.53).Cv(15.0,3.8).Cy(30.0,0).DA(425).DC(335);
		boot.K.b.Dv(boot.w.dj).CJ(365,74).CM(4.5,45.0).CP(305,43.0).CS(6.9,0.6).CV(48.0,3.1).CY(0.644,2.6).Cv(9.0,4.0).Cy(30.0,0).DA(550).DC(330);
		boot.K.b.Dv(boot.w.dk).CJ(410,90).CM(7.5,0.9).CP(200,45.0).CS(6.6,0.5).CV(53.3,3.5).CY(0.638,3.48).Cv(15.0,3.5).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.dl).CJ(432,86).CM(7.45,0.55).CP(200,50.0).CS(7.45,0.7).CV(52.0,3.3).CY(0.613,0.98).Cv(12.0,3.25).Cy(30.0,1.25).DA(175).DC(325);
		boot.K.b.Dv(boot.w.dm).CJ(370,90).CM(5.0,0.6).CP(220,45.0).CS(7.0,0.5).CV(49.0,3.5).CY(0.672,3.22).Cv(11.0,3.5).Cy(30.0,10.75).DA(525).DC(335);
		boot.K.b.Dv(boot.w.dn).CJ(430,85).CM(7.0,0.75).CP(215,35.0).CS(6.0,0.45).CV(54.0,3.1).CY(0.668,2.7).Cv(17.0,3.5).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.dp).CJ(437,108).CM(7.05,0.8).CP(213,42.0).CS(6.6,0.5).CV(51.6,3.4).CY(0.625,2.25).Cv(16.5,3.5).Cy(30.0,1.25).DA(125).DC(340);
		boot.K.b.Dv(boot.w.ea).CJ(441,93).CM(7.0,0.9).CP(225,45.0).CS(6.5,0.575).CV(54.1,3.5).CY(0.694,2.7).Cv(17.0,3.0).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.eb).CJ(385,79).CM(5.95,0.55).CP(250,50.0).CS(7.0,0.5).CV(44.0,2.6).CY(0.658,3.5).Cv(8.0,3.0).Cy(30.0,0).DA(525).DC(325);
		boot.K.b.Dv(boot.w.ec).CJ(433,87).CM(6.75,0.65).CP(210,34.0).CS(6.6,0.45).CV(50.7,2.9).CY(0.679,2.95).Cv(17.1,3.9).Cy(30.0,1.25).DA(155).DC(355);
		boot.K.b.Dv(boot.w.ed).CJ(423,81).CM(7.45,0.55).CP(185,30.0).CS(6.4,0.45).CV(56.3,3.375).CY(0.638,3.35).Cv(18.0,4.0).Cy(30.0,0).DA(125).DC(345);
		boot.K.b.Dv(boot.w.ee).CJ(420,86).CM(8.0,0.55).CP(255,33.0).CS(4.5,0.3).CV(50.0,3.5).CY(0.625,2.22).Cv(21.0,3.8).Cy(30.0,1.25).DA(125).DC(335);
		boot.K.b.Dv(boot.w.ef).CJ(426,87).CM(6.7,0.75).CV(53.12,3.1).CY(0.665,2.65).Cv(15.2,3.8).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.eg).CJ(435,85).CM(4.0,0.4).CV(55.0,3.0).CY(0.679,2.85).Cv(16.0,3.5).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.eh).CJ(414,86).CM(10.4,0.9).CV(54.0,2.75).CY(0.625,3.5).Cv(15.0,3.1).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.ei).CJ(450,80).CM(7.0,0.7).CV(55.32,3.2).CY(0.644,1.85).Cv(16.0,3.5).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.ej).CJ(360,86).CM(4.35,0.55).CP(250,55.0).CS(7.0,0.6).CV(52.0,3.0).CY(0.625,2.11).Cv(11.0,3.9).Cy(30.0,0).DA(550).DC(335);
		boot.K.b.Dv(boot.w.ek).CJ(450,85).CM(7.35,0.85).CP(220,40.0).CS(6.45,0.45).CV(54.0,3.4).CY(0.67,1.45).Cv(20.5,3.5).Cy(30.0,1.25).DA(125).DC(340);
		boot.K.b.Dv(boot.w.el).CJ(441,84).CM(7.45,0.55).CP(270,40.0).CS(6.4,0.45).CV(51.7,3.5).CY(0.694,3.0).Cv(15.0,3.5).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.em).CJ(428,85).CM(7.45,0.55).DE(200).DG(50).CV(54.5,3.375).CY(0.651,3.4).Cv(15.0,4.0).Cy(30.0,0).DA(125).DC(335);
		boot.K.b.Dv(boot.w.en).CJ(435,95).CM(7.2,0.8).CV(54.5,3.4).CY(0.658,3.4).Cv(17.6,3.4).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.eo).CJ(405,82).CM(7.1,0.55).CP(215,45.0).CS(6.6,0.55).CV(56.65,3.375).CY(0.613,1.81).Cv(18.0,3.5).Cy(30.0,0).DA(125).DC(345);
		boot.K.b.Dv(boot.w.ep).CJ(403,104).CM(7.9,0.95).CP(240,40.0).CS(6.3,0.4).CV(55.52,3.1875).CY(0.625,1.63).Cv(17.75,3.25).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.fa).CJ(378,82).CM(4.25,0.55).CP(203,43.0).CS(6.5,0.5).CV(49.0,2.9).CY(0.658,3.28).Cv(12.75,3.25).Cy(30.0,0).DA(500).DC(335);
		boot.K.b.Dv(boot.w.fb).CJ(440,96).CM(7.5,0.85).CP(205,40.0).CS(6.45,0.45).CV(54.1,4.2).CY(0.625,2.1).Cv(19.0,3.8).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.fc).CJ(340,70).CM(4.5,0.55).CP(265,45.0).CS(7.0,0.65).CV(47.0,3.0).CY(0.644,2.3).Cv(6.0,3.3).Cy(30.0,0).DA(550).DC(330);
		boot.K.b.Dv(boot.w.fd).CJ(375,71).CM(4.5,0.55).CP(240,60.0).CS(6.8,0.65).CV(48.8,3.0).CY(0.625,2.14).Cv(7.4,3.8).Cy(30.0,0).DA(550).DC(335);
		boot.K.b.Dv(boot.w.fe).CJ(385,78).CM(6.75,0.65).CP(240,50.0).CS(6.8,0.65).CV(49.0,3.0).CY(0.625,2.11).Cv(12.0,4.0).Cy(30.0,0).DA(500).DC(335);
		boot.K.b.Dv(boot.w.ff).CJ(380,78).CM(5.5,0.6).CP(250,50.0).CS(6.9,0.6).CV(51.0,2.9).CY(0.625,2.0).Cv(15.0,3.4).Cy(30.0,0).DA(550).DC(330);
		boot.K.b.Dv(boot.w.fg).CJ(440,85).CM(7.25,0.75).CP(260,40.0).CS(6.75,0.5).CV(50.0,3.1).CY(0.668,2.7).Cv(17.0,3.5).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.fh).CJ(468,90).CM(7.1,0.5).CP(255,56.0).CS(4.1,0.4).CV(58.0,3.5).CY(0.625,2.02).Cv(16.5,3.2).Cy(30.0,1.25).DA(125).DC(340);
		boot.K.b.Dv(boot.w.fi).CJ(383,82).CM(4.65,0.65).CP(200,40.0).CS(6.45,0.45).CV(44.5,3.0).CY(0.69,3.38).Cv(14.0,3.75).Cy(30.0,0).DA(500).DC(330);
		boot.K.b.Dv(boot.w.fj).CJ(415,82).CM(5.1,0.65).CP(193,32.0).CS(6.45,0.45).CV(46.5,3.0).CY(0.658,3.01).Cv(15.0,3.0).Cy(30.0,0).DA(550).DC(325);
		boot.K.b.Dv(boot.w.fk).CJ(455,96).CM(8.0,0.85).CP(206,45.0).CS(6.9,0.6).CV(54.66,3.0).CY(0.672,2.9).Cv(19.0,2.7).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.fl).CJ(461,98).CM(7.9,0.9).CV(56.0,3.2).CY(0.644,2.9).Cv(14.9,3.1).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.fm).CJ(384,82).CM(4.5,0.6).CP(202,38.0).CS(6.5,0.5).CV(46.61,3.3).CY(0.651,3.22).Cv(111.25,3.15).Cy(30.0,0).DA(525).DC(330);
		boot.K.b.Dv(boot.w.fn).CJ(389,81).CM(5.0,0.6).CP(220,40.0).CS(6.5,0.45).CV(49.0,3.0).CY(0.679,3.38).Cv(14.0,3.0).Cy(30.0,0).DA(550).DC(330);
		boot.K.b.Dv(boot.w.fo).CJ(427,99).CM(7.45,0.75).CP(220,30.0).CS(6.4,0.45).CV(52.91,3.2).CY(0.658,2.67).Cv(14.75,4.0).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.fp).CJ(437,89).CM(5.5,0.6).CP(220,55.0).CS(7.5,0.65).CV(48.0,3.6).CY(0.644,2.9).Cv(15.0,3.3).Cy(30.0,0).DA(425).DC(335);
		boot.K.b.Dv(boot.w.ga).CJ(400,82).CM(4.5,0.55).CP(250,36.0).CS(6.5,0.5).CV(46.0,3.0).CY(0.658,2.65).Cv(13.5,3.4).Cy(30.0,0).DA(575).DC(335);
		boot.K.b.Dv(boot.w.gb).CJ(359,83).CM(4.5,0.55).CP(173,27.0).CS(6.3,0.4).CV(50.0,3.25).CY(0.658,3.1).Cv(9.3,3.4).Cy(30.0,0).DA(550).DC(330);
		boot.K.b.Dv(boot.w.gc).CJ(355,82).CM(4.5,0.55).CP(250,55.0).CS(6.9,0.6).CV(48.3,2.625).CY(0.625,2.24).Cv(12.25,3.75).Cy(30.0,0).DA(525).DC(340);
		boot.K.b.Dv(boot.w.gd).CJ(440,85).CM(7.5,0.9).CP(220,45.0).CS(7.0,0.65).CV(55.0,3.5).CY(0.643,2.5).Cv(16.0,3.5).Cy(30.0,1.25).DA(125).DC(350);
		boot.K.b.Dv(boot.w.ge).CJ(385,78).CM(6.75,0.65).CP(240,50.0).CS(6.9,0.45).CV(49.0,3.0).CY(0.625,2.11).Cv(12.0,4.0).Cy(30.0,0).DA(525).DC(335);
		boot.K.b.Dv(boot.w.gf).CJ(400,85).CM(6.0,0.6).CV(45.0,3.0).CY(0.6258,2.0).Cv(12.0,3.5).Cy(30.0,0).DA(450).DC(335);
		boot.K.b.Dv(boot.w.gg).CJ(440,86).CM(7.0,0.65).CP(220,30.0).CS(7.0,0.65).CV(54.0,3.3).CY(0.625,2.9).Cv(16.5,3.5).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.gh).CJ(428,98).CM(7.05,0.8).CP(190,30.0).CS(7.1,0.6).CV(56.76,3.375).CY(0.679,2.88).Cv(16.0,3.5).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.gi).CJ(435,85).CM(5.1,0.65).CP(202,38.0).CS(6.9,0.65).CV(54.0,3.2).CY(0.658,3.0).Cv(15.0,3.5).Cy(30.0,1.25).DA(175).DC(345);
		boot.K.b.Dv(boot.w.gj).CJ(380,80).CM(5.0,0.55).CP(250,45.0).CS(8.0,0.6).CV(52.0,3.0).CY(0.625,1.36).Cv(12.6,3.4).Cy(30.0,0).DA(550).DC(340);
		boot.K.b.Dv(boot.w.gk).CJ(445,87).CM(7.0,0.7).CP(213,31.0).CS(6.6,0.45).CV(52.0,3.3).CY(0.672,2.7).Cv(16.2,3.7).Cy(30.0,1.25).DA(175).DC(345);
		boot.K.b.Dv(boot.w.gl).CJ(421,85).CM(8.5,0.7).CP(235,35.0).CS(6.5,0.45).CV(51.5,3.5).CY(0.625,3.0).Cv(18.0,3.6).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.gm).CJ(445,85).CM(6.0,0.65).DE(20).DG(50).CV(48.6,3.4).CY(0.658,3.1).Cv(17.5,3.5).Cy(30.0,1.25).DA(125).DC(345);
		boot.K.b.Dv(boot.w.gn).CJ(390,80).CM(5.25,0.6).CP(250,50.0).CS(6.75,0.6).CV(54.0,3.1).CY(0.656,1.7).Cv(12.0,3.3).Cy(30.0,0).DA(575).DC(330);
		boot.K.b.Dv(boot.w.go).CJ(380,71).CM(4.6,0.5).CP(260,60.0).CS(6.95,0.65).CV(48.6,3.0).CY(0.625,2.13).Cv(6.75,3.8).Cy(30.0,0).DA(600).DC(335);
		boot.K.b.Dv(boot.w.gp).CJ(355,74).CM(4.85,0.5).CP(250,50.0).CS(7.1,0.75).CV(50.0,3.2).CY(0.625,1.8).Cv(11.0,3.0).Cy(30.0,0).DA(575).DC(325);
		boot.K.c=new boot.K(1520,2012,12,3,"Preseason 3",boot.K.b,0);
		boot.K.c.DX("Shard of True Ice");
		boot.K.c.DX("Liandry's Torment");
		boot.K.c.DX("Haunting Guise");
		boot.K.a=boot.K.c;
	},
	// teemowork.model.Patch#<init>(int, int, int, int, java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C,D,E,F){
		this.d=new boot.R(0);
		this.e=new boot.R(0);
		this.f=A;
		this.g=E;
		this.h=F;
	},
	// teemowork.model.Patch#updateItem(java.lang.String)
	DX:function(A,B){
		B=new boot.BK(A,this,0);
		this.e.V(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	Dv:function(A){
		A.hb=new boot.BA(this,A.hb,0);
		return A.hb;
	}
});

boot.define("A",boot.B,{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.B.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B){
		this.D("Champion/*",boot.G);
		this.D("",boot.H);
		boot.B.prototype.A.call(this);
		$("body").css("padding","0px 10%");
		A=new boot.I(0);
		A.I("< ^ v ^ > Teemowork","test.html");
		A.I("Patch","#");
		B=A.I("Data","#");
		B.I("Champion","#");
		B.I("Item","#");
		B.I("Mastery","#");
		B.I("Rune","#");
		A.I("Builder","#");
		A.I("About","#");
		A.I("Contact","#");
		console.log(boot.K.a);
	}
});

try {new boot.A(0).A();} catch(e) {console.log(e)}