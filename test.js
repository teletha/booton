boot.define("O",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.O.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.O.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.O.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.O.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	N:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	O:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	P:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	Q:function(){
		console.log(this.a);
	}
});

boot.define("M",boot.O,{
	
	// java.lang.Error#<init>()
	$0:function(){
		boot.O.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$1:function(A){
		boot.O.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.O.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$3:function(A){
		boot.O.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.O.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("F",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.defineNative("Document",{
	
	// booton.translator.web.Document#<init>()
	$0:function(){
	},
	// booton.translator.web.Document#createElement(java.lang.String)
	createElement:function(A){
		return this.createElement(A);
	}
});
boot.define("P",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	T:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	U:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	V:function(){
	},
	// booton.translator.web.jQuery$1#next()
	W:function(){
		return this.U();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	R:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	L:function(A){
		return this.R("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	S:function(){
		return new boot.P(this,0);
	}
});
boot.define("Z",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	T:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	W:function(){
		this.d=boot.S.BV(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	V:function(){
		if(this.b<=0){
		}else{
			this.a.BP(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.Z.prototype.$1.call(this,A,B);
	}
});

boot.define("X",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	y:function(){
		return this.x()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BN:function(A,B,C,D){
		B=0;
		D=A.S();
		l2:while (D.T()!=0) {
			C=D.W();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BO:function(A,B,C,D){
		B=0;
		D=this.S();
		l2:while (D.T()!=0) {
			C=D.W();
			if(A.BA(C)!=0){
			}else{
				B=this.BP(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BQ:function(A,B,C,D){
		B=0;
		D=A.S();
		l2:while (D.T()!=0) {
			C=D.W();
			if(this.BP(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BR:function(A,B,C){
		C=A.S();
		l1:while (C.T()!=0) {
			B=C.W();
			if(this.BA(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BS:function(){
		return this.BT(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BT:function(A,B,C,D,E){
		B=this.x();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.S();
		D=0;
		l6:while (C.T()!=0) {
			E=C.W();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("W",boot.X,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.X.prototype.$0.call(this);
	}
});

boot.define("S",boot.W,{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.W.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	x:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BA:function(A){
		return this.BU(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.BU(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BP:function(A,B){
		B=this.BU(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BK:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	S:function(){
		return new boot.Z(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	BU:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	BC:function(A){
		return this.b[this.BU(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	BE:function(A,B,C){
		B=null;
		C=this.BU(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	BG:function(A,B,C){
		B=null;
		C=this.BU(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_BV:function(A){
		return A.b;
	}
});

boot.define("Y",{
	
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.a=A;;
		this.b=B;
		this.c=C;
	},
	// js.util.HashMap$View#hasNext()
	T:function(){
		return this.b.T();
	},
	// js.util.HashMap$View#next()
	W:function(A){
		A=this.b.W();
		if(this.c==0){
			return A.BD();
		}else{
			return A.BJ();
		}
	},
	// js.util.HashMap$View#remove()
	V:function(){
		this.b.V();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.Y.prototype.$1.call(this,A,B,C);
	}
});

boot.define("U",boot.W,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.W.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	x:function(){
		return boot.R.BM(this.a).x();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BA:function(A){
		return boot.R.BM(this.a).BA(A);
	},
	// js.util.HashMap$Keys#iterator()
	S:function(){
		return new boot.Y(this.a,boot.R.BM(this.a).S(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BP:function(A){
		return boot.R.BM(this.a).BP(A);
	},
	// js.util.HashMap$Keys#clear()
	BK:function(){
		boot.R.BM(this.a).BK();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.U.prototype.$1.call(this,A);
	}
});

boot.define("T",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	BJ:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	BD:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	BW:function(A,B){
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
		boot.T.prototype.$1.call(this,A,B);
	}
});

boot.define("V",boot.X,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.X.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	x:function(){
		return boot.R.BM(this.a).x();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BA:function(A){
		return this.a.BB(A);
	},
	// js.util.HashMap$Values#iterator()
	S:function(){
		return new boot.Y(this.a,boot.R.BM(this.a).S(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BP:function(A,B,C){
		B=this.S();
		l2:while (B.T()!=0) {
			C=B.W();
			if(C!=A){
			}else{
				B.V();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BK:function(){
		boot.R.BM(this.a).BK();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.V.prototype.$1.call(this,A);
	}
});

boot.define("R",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.S(0);
	},
	// js.util.HashMap#size()
	x:function(){
		return this.a.x();
	},
	// js.util.HashMap#isEmpty()
	y:function(){
		return this.a.y();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	z:function(A){
		return this.a.BA(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	BB:function(A,B,C){
		C=this.w().S();
		l1:while (C.T()!=0) {
			B=C.W();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	u:function(A,B){
		B=this.a.BC(A);
		return (B==null?null:B.BD());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	Y:function(A,B,C){
		C=this.a.BE(new boot.T(A,B,null,0));
		if(C!=null){
			return C.BD();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	BF:function(A,B){
		B=this.a.BG(A);
		if(B!=null){
			return B.BD();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	BH:function(A,B,C){
		C=A.BI().S();
		l1:for (;
		C.T()!=0;
		this.Y(B.BJ(),B.BD())) {
			B=C.W();
		}
	},
	// js.util.HashMap#clear()
	BK:function(){
		this.a.BK();
	},
	// js.util.HashMap#keySet()
	BL:function(){
		return new boot.U(this,null,0);
	},
	// js.util.HashMap#values()
	w:function(){
		return new boot.V(this,null,0);
	},
	// js.util.HashMap#entrySet()
	BI:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_BM:function(A){
		return A.a;
	}
});

boot.define("L",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.L.b=new boot.R(0);
		boot.L.c=new boot.L("Ahri",0);
		boot.L.d=new boot.L("Akali",0);
		boot.L.e=new boot.L("Alistar",0);
		boot.L.f=new boot.L("Amumu",0);
		boot.L.g=new boot.L("Anivia",0);
		boot.L.h=new boot.L("Annie",0);
		boot.L.i=new boot.L("Ashe",0);
		boot.L.j=new boot.L("Blitzcrank",0);
		boot.L.k=new boot.L("Brand",0);
		boot.L.l=new boot.L("Caitlyn",0);
		boot.L.m=new boot.L("Cassiopeia",0);
		boot.L.n=new boot.L("Chogath",0);
		boot.L.o=new boot.L("Corki",0);
		boot.L.p=new boot.L("Darius",0);
		boot.L.ba=new boot.L("Diana",0);
		boot.L.bb=new boot.L("Dr.Mundo",0);
		boot.L.bc=new boot.L("Draven",0);
		boot.L.bd=new boot.L("Elise",0);
		boot.L.be=new boot.L("Evelynn",0);
		boot.L.bf=new boot.L("Ezreal",0);
		boot.L.bg=new boot.L("Fiddlesticks",0);
		boot.L.bh=new boot.L("Fiora",0);
		boot.L.bi=new boot.L("Fizz",0);
		boot.L.bj=new boot.L("Galio",0);
		boot.L.bk=new boot.L("Gangplank",0);
		boot.L.bl=new boot.L("Garen",0);
		boot.L.bm=new boot.L("Gragas",0);
		boot.L.bn=new boot.L("Graves",0);
		boot.L.bo=new boot.L("Hecarim",0);
		boot.L.bp=new boot.L("Heimerdinger",0);
		boot.L.ca=new boot.L("Irelia",0);
		boot.L.cb=new boot.L("Janna",0);
		boot.L.cc=new boot.L("Jarvan IV",0);
		boot.L.cd=new boot.L("Jax",0);
		boot.L.ce=new boot.L("Jayce",0);
		boot.L.cf=new boot.L("Karma",0);
		boot.L.cg=new boot.L("Karthus",0);
		boot.L.ch=new boot.L("Kassadin",0);
		boot.L.ci=new boot.L("Katarina",0);
		boot.L.cj=new boot.L("Kayle",0);
		boot.L.ck=new boot.L("Kennen",0);
		boot.L.cl=new boot.L("Kha'zix",0);
		boot.L.cm=new boot.L("Kog'maw",0);
		boot.L.cn=new boot.L("LeBlanc",0);
		boot.L.co=new boot.L("Lee Sin",0);
		boot.L.cp=new boot.L("Leona",0);
		boot.L.da=new boot.L("Lulu",0);
		boot.L.db=new boot.L("Lux",0);
		boot.L.dc=new boot.L("Malphite",0);
		boot.L.dd=new boot.L("Malzahar",0);
		boot.L.de=new boot.L("Maokai",0);
		boot.L.df=new boot.L("Master Yi",0);
		boot.L.dg=new boot.L("Miss Fortune",0);
		boot.L.dh=new boot.L("Mordekaiser",0);
		boot.L.di=new boot.L("Morgana",0);
		boot.L.dj=new boot.L("Nami",0);
		boot.L.dk=new boot.L("Nasus",0);
		boot.L.dl=new boot.L("Nautilus",0);
		boot.L.dm=new boot.L("Nidalee",0);
		boot.L.dn=new boot.L("Nocturne",0);
		boot.L.dp=new boot.L("Nunu",0);
		boot.L.ea=new boot.L("Olaf",0);
		boot.L.eb=new boot.L("Orianna",0);
		boot.L.ec=new boot.L("Pantheon",0);
		boot.L.ed=new boot.L("Poppy",0);
		boot.L.ee=new boot.L("Rammus",0);
		boot.L.ef=new boot.L("Renekton",0);
		boot.L.eg=new boot.L("Rengar",0);
		boot.L.eh=new boot.L("Riven",0);
		boot.L.ei=new boot.L("Rumble",0);
		boot.L.ej=new boot.L("Ryze",0);
		boot.L.ek=new boot.L("Sejuani",0);
		boot.L.el=new boot.L("Shaco",0);
		boot.L.em=new boot.L("Shen",0);
		boot.L.en=new boot.L("Shyvana",0);
		boot.L.eo=new boot.L("Singed",0);
		boot.L.ep=new boot.L("Sion",0);
		boot.L.fa=new boot.L("Sivir",0);
		boot.L.fb=new boot.L("Skarner",0);
		boot.L.fc=new boot.L("Sona",0);
		boot.L.fd=new boot.L("Soraka",0);
		boot.L.fe=new boot.L("Swain",0);
		boot.L.ff=new boot.L("Syndra",0);
		boot.L.fg=new boot.L("Talon",0);
		boot.L.fh=new boot.L("Taric",0);
		boot.L.fi=new boot.L("Teemo",0);
		boot.L.fj=new boot.L("Tristana",0);
		boot.L.fk=new boot.L("Trundle",0);
		boot.L.fl=new boot.L("Tryndamere",0);
		boot.L.fm=new boot.L("Twisted Fate",0);
		boot.L.fn=new boot.L("Twitch",0);
		boot.L.fo=new boot.L("Udyr",0);
		boot.L.fp=new boot.L("Urgot",0);
		boot.L.ga=new boot.L("Varus",0);
		boot.L.gb=new boot.L("Vayne",0);
		boot.L.gc=new boot.L("Veigar",0);
		boot.L.gd=new boot.L("Vi",0);
		boot.L.ge=new boot.L("Viktor",0);
		boot.L.gf=new boot.L("Vladimir",0);
		boot.L.gg=new boot.L("Volibear",0);
		boot.L.gh=new boot.L("Warwick",0);
		boot.L.gi=new boot.L("Wukong",0);
		boot.L.gj=new boot.L("Xerath",0);
		boot.L.gk=new boot.L("Xin Zhao",0);
		boot.L.gl=new boot.L("Yorick",0);
		boot.L.gm=new boot.L("Zed",0);
		boot.L.gn=new boot.L("Ziggs",0);
		boot.L.go=new boot.L("Zilean",0);
		boot.L.gp=new boot.L("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.X().toLowerCase();
		boot.L.b.Y(A,this);
	},
	// teemowork.model.Champion#getSystemName()
	X:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	M:function(){
		return "src/main/resources/teemowork/splash/"+this.X()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	Z:function(){
		return "src/main/resources/teemowork/icon/"+this.X()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_J:function(A){
		return boot.L.b.u(A);
	},
	// teemowork.model.Champion#getAll()
	_v:function(){
		return boot.L.b.w();
	}
});

boot.define("G",boot.F,{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.G.prototype.$1.call(this,boot.L.J(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.F.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.M(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	K:function(A,B){
		B=A.L("a").css("background-image","url("+this.a.M()+")").L("b");
		B.L("c").text(this.a.a);
		B.L("d").text("ad");
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	}
});

boot.define("J",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;;
		this.b=B.R("ul").addClass("e");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.R("li").addClass("f");
		C.R("a").addClass("g").attr("href",B).text(A);
		return new boot.J(this.a,C,0);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
	$1:function(A,B,C){
		boot.J.prototype.$0.call(this,A,B);
	}
});

boot.define("u",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.u.a=new boot.R(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.u.a.u(A);
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
		boot.u.a.Y(A,this);
	},
	// teemowork.model.Item#cost()
	CJ:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	BY:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	CK:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	CL:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	CM:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	CN:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	CO:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	CP:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	CQ:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	CR:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	CS:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	CT:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	CU:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	CV:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	CW:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	Bu:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	CX:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	CY:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	CZ:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	Cu:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	Cv:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	Cw:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	Cx:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	Cy:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	Cz:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	BZ:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	DA:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	DB:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	DC:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	DD:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	DE:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	DF:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	DG:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	DH:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	DI:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	DJ:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	DK:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	DL:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_DM:function(A){
		return boot.u.a.u(A);
	},
	// teemowork.model.Item#getAll()
	_v:function(){
		return boot.u.a.w();
	}
});

boot.define("v",{
	
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
	DN:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	DO:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	Bw:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	DP:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DQ:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	Bx:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DR:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DS:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	Bz:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DT:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DU:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	CA:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DV:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DW:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	CB:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DX:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DY:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	CC:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DZ:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	Du:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	CD:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	Dv:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	Dw:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	CE:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	Dx:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	CF:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	Dy:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	CG:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	Dz:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	CH:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	EA:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	CI:function(A){
		this.bf=A;
		return this;
	}
});

boot.define("K",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.K.b=new boot.K(1510,2012,11,13,"Initial",null,0);
		boot.K.b.BX("Ruby Crystal").BY(475).BZ(180);
		boot.K.b.BX("Haunting Guise").BZ(200).Bu(25);
		boot.K.b.Bv(boot.L.c).Bw(380,80).Bx(5.5,0.6).Bz(230,50.0).CA(6.25,0.6).CB(50.0,3.0).CC(0.668,2.0).CD(10.0,3.5).CE(30.0,0).CF(550).CG(330);
		boot.K.b.Bv(boot.L.d).Bw(445,85).Bx(7.25,0.65).CH(200).CI(50).CB(53.0,3.2).CC(0.694,3.1).CD(16.5,3.5).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.e).Bw(442,102).Bx(7.25,0.85).Bz(215,38.0).CA(6.45,0.45).CB(55.03,3.62).CC(0.625,3.62).CD(14.5,3.5).CE(30.0,1.25).CF(125).CG(325);
		boot.K.b.Bv(boot.L.f).Bw(472,84).Bx(7.45,0.85).Bz(220,40.0).CA(6.5,0.525).CB(47.0,3.8).CC(0.638,2.18).CD(18.0,3.3).CE(30.0,1.25).CF(125).CG(335);
		boot.K.b.Bv(boot.L.g).Bw(350,70).Bx(4.65,0.55).Bz(257,53.0).CA(7.0,0.6).CB(48.0,3.2).CC(0.625,1.68).CD(10.5,4.0).CE(30.0,0).CF(600).CG(325);
		boot.K.b.Bv(boot.L.h).Bw(384,76).Bx(4.5,0.55).Bz(250,50.0).CA(6.9,0.6).CB(49.0,2.625).CC(0.579,1.36).CD(12.5,4.0).CE(30.0,0).CF(625).CG(335);
		boot.K.b.Bv(boot.L.i).Bw(395,79).Bx(4.5,0.55).Bz(173,35.0).CA(6.3,0.4).CB(46.3,2.85).CC(0.658,3.34).CD(11.5,3.4).CE(30.0,0).CF(600).CG(325);
		boot.K.b.Bv(boot.L.j).Bw(423,95).Bx(7.25,0.75).Bz(260,40.0).CA(6.6,0.5).CB(55.66,3.5).CC(0.625,1.13).CD(14.5,3.5).CE(30.0,1.25).CF(125).CG(325);
		boot.K.b.Bv(boot.L.k).Bw(380,76).Bx(4.5,0.55).Bz(250,45.0).CA(7.0,0.6).CB(51.66,3.0).CC(0.625,1.36).CD(12.0,3.5).CE(30.0,0).CF(550).CG(340);
		boot.K.b.Bv(boot.L.l).Bw(390,80).Bx(4.75,0.55).Bz(255,35.0).CA(6.5,0.55).CB(47.0,3.0).CC(0.668,3.0).CD(13.0,3.5).CE(30.0,0).CF(650).CG(325);
		boot.K.b.Bv(boot.L.m).Bw(380,75).Bx(4.85,0.5).Bz(250,50.0).CA(7.1,0.75).CB(47.0,3.2).CC(0.644,1.68).CD(11.5,4.0).CE(30.0,0).CF(550).CG(335);
		boot.K.b.Bv(boot.L.n).Bw(440,80).Bx(7.5,0.85).Bz(205,40.0).CA(6.45,0.45).CB(54.1,4.2).CC(0.625,1.44).CD(19.0,3.5).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.o).Bw(375,82).Bx(4.5,0.55).Bz(243,37.0).CA(6.5,0.55).CB(48.2,3.0).CC(0.658,2.3).CD(13.5,3.5).CE(30.0,0).CF(550).CG(325);
		boot.K.b.Bv(boot.L.p).Bw(426,93).Bx(8.25,0.95).Bz(200,37.5).CA(6.0,0.35).CB(50.0,3.5).CC(0.679,2.6).CD(20.0,3.5).CE(30.0,1.25).CF(125).CG(340);
		boot.K.b.Bv(boot.L.ba).Bw(438,90).Bx(7.0,0.85).Bz(230,40.0).CA(7.0,0.6).CB(48.0,3.0).CC(0.625,2.25).CD(16.0,3.6).CE(30.0,1.25).CF(150).CG(345);
		boot.K.b.Bv(boot.L.bb).Bw(433,89).Bx(6.5,0.75).CB(56.23,3.0).CC(0.625,2.8).CD(17.0,3.5).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.bc).Bw(420,82).Bx(5.0,0.7).Bz(240,42.0).CA(6.95,0.65).CB(46.5,3.5).CC(0.679,2.6).CD(16.0,3.3).CE(30.0,0).CF(550).CG(330);
		boot.K.b.Bv(boot.L.bd).Bw(395,80).Bx(4.7,0.6).Bz(240,50.0).CA(6.8,0.65).CB(47.5,3.0).CC(0.625,1.75).CD(12.65,3.35).CE(30.0,0).CF(550).CG(335);
		boot.K.b.Bv(boot.L.be).Bw(414,86).Bx(6.95,0.55).Bz(180,42.0).CA(7.1,0.6).CB(48.0,3.3).CC(0.658,3.84).CD(12.5,4.0).CE(30.0,1.25).CF(125).CG(340);
		boot.K.b.Bv(boot.L.bf).Bw(350,80).Bx(5.5,0.55).Bz(235,45.0).CA(7.0,0.65).CB(47.2,3.0).CC(0.665,2.8).CD(12.0,3.5).CE(30.0,0).CF(550).CG(330);
		boot.K.b.Bv(boot.L.bg).Bw(390,80).Bx(4.6,0.6).Bz(251,59.0).CA(6.9,0.65).CB(45.95,2.625).CC(0.625,2.11).CD(11.0,3.5).CE(30.0,0).CF(480).CG(335);
		boot.K.b.Bv(boot.L.bh).Bw(450,85).Bx(6.3,0.8).Bz(220,40.0).CA(7.25,0.5).CB(54.5,3.2).CC(0.672,3.0).CD(15.5,3.5).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.bi).Bw(414,86).Bx(7.0,0.7).Bz(200,40.0).CA(6.15,0.45).CB(53.0,3.0).CC(0.658,3.1).CD(13.0,3.4).CE(30.0,1.25).CF(175).CG(335);
		boot.K.b.Bv(boot.L.bj).Bw(435,85).Bx(7.45,0.75).Bz(235,50.0).CA(7.0,0.7).CB(56.3,3.375).CC(0.638,1.2).CD(17.0,3.5).CE(30.0,0).CF(125).CG(335);
		boot.K.b.Bv(boot.L.bk).Bw(495,81).Bx(425.0,0.75).Bz(215,40.0).CA(6.5,0.7).CB(54.0,3.0).CC(0.651,2.75).CD(16.5,3.3).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.bl).Bw(455,96).Bx(7.5,0.75).CB(52.5,3.5).CC(0.625,2.9).CD(19.0,2.7).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.bm).Bw(434,89).Bx(7.25,0.85).Bz(221,47.0).CA(6.45,0.45).CB(55.78,3.375).CC(0.651,2.05).CD(16.0,3.6).CE(30.0,0).CF(125).CG(340);
		boot.K.b.Bv(boot.L.bn).Bw(410,84).Bx(5.5,0.7).Bz(255,40.0).CA(6.75,0.7).CB(51.0,3.1).CC(0.625,2.9).CD(15.0,3.2).CE(30.0,0).CF(525).CG(330);
		boot.K.b.Bv(boot.L.bo).Bw(440,95).Bx(8.0,0.75).Bz(210,40.0).CA(6.5,0.6).CB(56.0,3.2).CC(0.67,2.5).CD(16.0,4.0).CE(30.0,1.25).CF(175).CG(345);
		boot.K.b.Bv(boot.L.bp).Bw(350,75).Bx(4.5,0.55).Bz(240,65.0).CA(7.0,0.65).CB(49.24,3.0).CC(0.625,1.21).CD(7.0,3.0).CE(30.0,0).CF(550).CG(325);
		boot.K.b.Bv(boot.L.ca).Bw(456,90).Bx(7.5,0.65).Bz(230,35.0).CA(7.0,0.65).CB(56.0,3.3).CC(0.665,3.2).CD(15.0,3.75).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.cb).Bw(356,78).Bx(4.5,0.55).Bz(302,64.0).CA(6.9,0.6).CB(49.0,2.95).CC(0.625,2.61).CD(9.0,3.8).CE(30.0,0).CF(475).CG(335);
		boot.K.b.Bv(boot.L.cc).Bw(420,90).Bx(7.0,0.7).Bz(235,40.0).CA(6.0,0.45).CB(50.0,3.4).CC(0.658,2.5).CD(14.0,3.0).CE(30.0,1.25).CF(175).CG(340);
		boot.K.b.Bv(boot.L.cd).Bw(463,98).Bx(7.45,0.55).Bz(230,35.0).CA(6.4,0.7).CB(56.3,3.375).CC(0.638,3.4).CD(18.0,3.5).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.ce).Bw(420,90).Bx(6.0,0.8).Bz(240,40.0).CA(7.0,0.7).CB(46.5,3.5).CC(0.658,3.0).CD(12.5,3.5).CE(30.0,0).CF(125).CG(335);
		boot.K.b.Bv(boot.L.cf).Bw(410,86).Bx(4.7,0.55).Bz(240,60.0).CA(6.8,0.65).CB(50.0,3.3).CC(0.625,2.3).CD(15.0,3.5).CE(30.0,0).CF(425).CG(335);
		boot.K.b.Bv(boot.L.cg).Bw(390,75).Bx(5.5,0.55).Bz(270,61.0).CA(6.5,0.6).CB(42.2,3.25).CC(0.625,2.11).CD(11.0,3.5).CE(30.0,0).CF(450).CG(335);
		boot.K.b.Bv(boot.L.ch).Bw(433,78).Bx(6.95,0.5).Bz(230,45.0).CA(6.9,0.6).CB(52.3,3.9).CC(0.638,3.7).CD(14.0,3.2).CE(30.0,1.25).CF(125).CG(340);
		boot.K.b.Bv(boot.L.ci).Bw(395,83).Bx(6.95,0.55).CB(53.0,3.2).CC(0.658,2.74).CD(14.75,4.0).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.cj).Bw(418,93).Bx(7.0,0.75).Bz(255,40.0).CA(6.9,0.525).CB(53.3,2.8).CC(0.638,2.5).CD(17.0,3.5).CE(30.0,0.75).CF(125).CG(335);
		boot.K.b.Bv(boot.L.ck).Bw(403,79).Bx(4.65,0.65).CH(200).CI(50).CB(51.3,3.3).CC(0.69,3.4).CD(14.0,3.75).CE(30.0,0).CF(550).CG(335);
		boot.K.b.Bv(boot.L.cl).Bw(430,85).Bx(6.25,0.75).Bz(260,40.0).CA(6.75,0.5).CB(50.0,3.1).CC(0.665,2.7).CD(15.0,3.0).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.cm).Bw(440,84).Bx(5.0,0.55).Bz(295,40.0).CA(7.5,0.7).CB(46.0,3.0).CC(0.665,2.65).CD(13.0,3.53).CE(30.0,0).CF(500).CG(340);
		boot.K.b.Bv(boot.L.cn).Bw(390,75).Bx(4.5,0.55).Bz(250,50.0).CA(6.9,0.6).CB(51.0,3.1).CC(0.625,1.4).CD(12.0,3.5).CE(30.0,0).CF(525).CG(335);
		boot.K.b.Bv(boot.L.co).Bw(428,85).Bx(6.25,61.0).CI(200).CI(50).CB(55.8,3.2).CC(0.651,3.0).CD(16.0,3.7).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.cp).Bw(430,87).Bx(9.0,0.85).Bz(235,40.0).CA(8.0,0.7).CB(55.0,3.0).CC(0.625,2.9).CD(18.0,3.1).CE(30.0,1.25).CF(125).CG(335);
		boot.K.b.Bv(boot.L.da).Bw(415,82).Bx(6.0,0.72).Bz(200,50.0).CA(6.0,0.6).CB(44.4,2.6).CC(0.625,2.2).CD(9.0,3.7).CE(30.0,0).CF(550).CG(325);
		boot.K.b.Bv(boot.L.db).Bw(345,79).Bx(4.5,0.55).Bz(250,50.0).CA(6.0,0.6).CB(50.0,3.3).CC(0.625,1.36).CD(8.0,4.0).CE(30.0,0).CF(550).CG(340);
		boot.K.b.Bv(boot.L.dc).Bw(423,90).Bx(7.45,0.55).Bz(215,40.0).CA(6.4,0.55).CB(56.3,3.375).CC(0.638,3.4).CD(18.0,3.75).CE(30.0,1.25).CF(125).CG(335);
		boot.K.b.Bv(boot.L.dd).Bw(380,80).Bx(4.5,0.55).Bz(250,45.0).CA(7.0,0.6).CB(51.66,3.0).CC(0.625,1.36).CD(15.0,3.5).CE(30.0,0).CF(550).CG(340);
		boot.K.b.Bv(boot.L.de).Bw(421,90).Bx(7.25,0.85).Bz(250,46.0).CA(6.45,0.45).CB(58.0,3.3).CC(0.694,2.13).CD(18.0,4.0).CE(30.0,0).CF(125).CG(335);
		boot.K.b.Bv(boot.L.df).Bw(444,86).Bx(6.75,0.65).Bz(199,36.0).CA(6.5,0.45).CB(55.12,3.1).CC(0.679,2.98).CD(16.3,3.7).CE(30.0,1.25).CF(125).CG(355);
		boot.K.b.Bv(boot.L.dg).Bw(435,85).Bx(5.1,0.65).Bz(212,38.0).CA(6.95,0.65).CB(46.5,3.0).CC(0.658,3.01).CD(15.0,3.0).CE(30.0,0).CF(550).CG(325);
		boot.K.b.Bv(boot.L.dh).Bw(421,80).Bx(7.45,0.55).CB(51.7,3.5).CC(0.694,3.0).CD(15.0,3.5).CE(30.0,1.25).CF(125).CG(340);
		boot.K.b.Bv(boot.L.di).Bw(403,86).Bx(4.7,0.6).Bz(240,60.0).CA(6.8,0.65).CB(51.58,3.5).CC(0.579,1.53).CD(15.0,3.8).CE(30.0,0).CF(425).CG(335);
		boot.K.b.Bv(boot.L.dj).Bw(365,74).Bx(4.5,45.0).Bz(305,43.0).CA(6.9,0.6).CB(48.0,3.1).CC(0.644,2.6).CD(9.0,4.0).CE(30.0,0).CF(550).CG(330);
		boot.K.b.Bv(boot.L.dk).Bw(410,90).Bx(7.5,0.9).Bz(200,45.0).CA(6.6,0.5).CB(53.3,3.5).CC(0.638,3.48).CD(15.0,3.5).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.dl).Bw(432,86).Bx(7.45,0.55).Bz(200,50.0).CA(7.45,0.7).CB(52.0,3.3).CC(0.613,0.98).CD(12.0,3.25).CE(30.0,1.25).CF(175).CG(325);
		boot.K.b.Bv(boot.L.dm).Bw(370,90).Bx(5.0,0.6).Bz(220,45.0).CA(7.0,0.5).CB(49.0,3.5).CC(0.672,3.22).CD(11.0,3.5).CE(30.0,10.75).CF(525).CG(335);
		boot.K.b.Bv(boot.L.dn).Bw(430,85).Bx(7.0,0.75).Bz(215,35.0).CA(6.0,0.45).CB(54.0,3.1).CC(0.668,2.7).CD(17.0,3.5).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.dp).Bw(437,108).Bx(7.05,0.8).Bz(213,42.0).CA(6.6,0.5).CB(51.6,3.4).CC(0.625,2.25).CD(16.5,3.5).CE(30.0,1.25).CF(125).CG(340);
		boot.K.b.Bv(boot.L.ea).Bw(441,93).Bx(7.0,0.9).Bz(225,45.0).CA(6.5,0.575).CB(54.1,3.5).CC(0.694,2.7).CD(17.0,3.0).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.eb).Bw(385,79).Bx(5.95,0.55).Bz(250,50.0).CA(7.0,0.5).CB(44.0,2.6).CC(0.658,3.5).CD(8.0,3.0).CE(30.0,0).CF(525).CG(325);
		boot.K.b.Bv(boot.L.ec).Bw(433,87).Bx(6.75,0.65).Bz(210,34.0).CA(6.6,0.45).CB(50.7,2.9).CC(0.679,2.95).CD(17.1,3.9).CE(30.0,1.25).CF(155).CG(355);
		boot.K.b.Bv(boot.L.ed).Bw(423,81).Bx(7.45,0.55).Bz(185,30.0).CA(6.4,0.45).CB(56.3,3.375).CC(0.638,3.35).CD(18.0,4.0).CE(30.0,0).CF(125).CG(345);
		boot.K.b.Bv(boot.L.ee).Bw(420,86).Bx(8.0,0.55).Bz(255,33.0).CA(4.5,0.3).CB(50.0,3.5).CC(0.625,2.22).CD(21.0,3.8).CE(30.0,1.25).CF(125).CG(335);
		boot.K.b.Bv(boot.L.ef).Bw(426,87).Bx(6.7,0.75).CB(53.12,3.1).CC(0.665,2.65).CD(15.2,3.8).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.eg).Bw(435,85).Bx(4.0,0.4).CB(55.0,3.0).CC(0.679,2.85).CD(16.0,3.5).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.eh).Bw(414,86).Bx(10.4,0.9).CB(54.0,2.75).CC(0.625,3.5).CD(15.0,3.1).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.ei).Bw(450,80).Bx(7.0,0.7).CB(55.32,3.2).CC(0.644,1.85).CD(16.0,3.5).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.ej).Bw(360,86).Bx(4.35,0.55).Bz(250,55.0).CA(7.0,0.6).CB(52.0,3.0).CC(0.625,2.11).CD(11.0,3.9).CE(30.0,0).CF(550).CG(335);
		boot.K.b.Bv(boot.L.ek).Bw(450,85).Bx(7.35,0.85).Bz(220,40.0).CA(6.45,0.45).CB(54.0,3.4).CC(0.67,1.45).CD(20.5,3.5).CE(30.0,1.25).CF(125).CG(340);
		boot.K.b.Bv(boot.L.el).Bw(441,84).Bx(7.45,0.55).Bz(270,40.0).CA(6.4,0.45).CB(51.7,3.5).CC(0.694,3.0).CD(15.0,3.5).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.em).Bw(428,85).Bx(7.45,0.55).CH(200).CI(50).CB(54.5,3.375).CC(0.651,3.4).CD(15.0,4.0).CE(30.0,0).CF(125).CG(335);
		boot.K.b.Bv(boot.L.en).Bw(435,95).Bx(7.2,0.8).CB(54.5,3.4).CC(0.658,3.4).CD(17.6,3.4).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.eo).Bw(405,82).Bx(7.1,0.55).Bz(215,45.0).CA(6.6,0.55).CB(56.65,3.375).CC(0.613,1.81).CD(18.0,3.5).CE(30.0,0).CF(125).CG(345);
		boot.K.b.Bv(boot.L.ep).Bw(403,104).Bx(7.9,0.95).Bz(240,40.0).CA(6.3,0.4).CB(55.52,3.1875).CC(0.625,1.63).CD(17.75,3.25).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.fa).Bw(378,82).Bx(4.25,0.55).Bz(203,43.0).CA(6.5,0.5).CB(49.0,2.9).CC(0.658,3.28).CD(12.75,3.25).CE(30.0,0).CF(500).CG(335);
		boot.K.b.Bv(boot.L.fb).Bw(440,96).Bx(7.5,0.85).Bz(205,40.0).CA(6.45,0.45).CB(54.1,4.2).CC(0.625,2.1).CD(19.0,3.8).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.fc).Bw(340,70).Bx(4.5,0.55).Bz(265,45.0).CA(7.0,0.65).CB(47.0,3.0).CC(0.644,2.3).CD(6.0,3.3).CE(30.0,0).CF(550).CG(330);
		boot.K.b.Bv(boot.L.fd).Bw(375,71).Bx(4.5,0.55).Bz(240,60.0).CA(6.8,0.65).CB(48.8,3.0).CC(0.625,2.14).CD(7.4,3.8).CE(30.0,0).CF(550).CG(335);
		boot.K.b.Bv(boot.L.fe).Bw(385,78).Bx(6.75,0.65).Bz(240,50.0).CA(6.8,0.65).CB(49.0,3.0).CC(0.625,2.11).CD(12.0,4.0).CE(30.0,0).CF(500).CG(335);
		boot.K.b.Bv(boot.L.ff).Bw(380,78).Bx(5.5,0.6).Bz(250,50.0).CA(6.9,0.6).CB(51.0,2.9).CC(0.625,2.0).CD(15.0,3.4).CE(30.0,0).CF(550).CG(330);
		boot.K.b.Bv(boot.L.fg).Bw(440,85).Bx(7.25,0.75).Bz(260,40.0).CA(6.75,0.5).CB(50.0,3.1).CC(0.668,2.7).CD(17.0,3.5).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.fh).Bw(468,90).Bx(7.1,0.5).Bz(255,56.0).CA(4.1,0.4).CB(58.0,3.5).CC(0.625,2.02).CD(16.5,3.2).CE(30.0,1.25).CF(125).CG(340);
		boot.K.b.Bv(boot.L.fi).Bw(383,82).Bx(4.65,0.65).Bz(200,40.0).CA(6.45,0.45).CB(44.5,3.0).CC(0.69,3.38).CD(14.0,3.75).CE(30.0,0).CF(500).CG(330);
		boot.K.b.Bv(boot.L.fj).Bw(415,82).Bx(5.1,0.65).Bz(193,32.0).CA(6.45,0.45).CB(46.5,3.0).CC(0.658,3.01).CD(15.0,3.0).CE(30.0,0).CF(550).CG(325);
		boot.K.b.Bv(boot.L.fk).Bw(455,96).Bx(8.0,0.85).Bz(206,45.0).CA(6.9,0.6).CB(54.66,3.0).CC(0.672,2.9).CD(19.0,2.7).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.fl).Bw(461,98).Bx(7.9,0.9).CB(56.0,3.2).CC(0.644,2.9).CD(14.9,3.1).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.fm).Bw(384,82).Bx(4.5,0.6).Bz(202,38.0).CA(6.5,0.5).CB(46.61,3.3).CC(0.651,3.22).CD(111.25,3.15).CE(30.0,0).CF(525).CG(330);
		boot.K.b.Bv(boot.L.fn).Bw(389,81).Bx(5.0,0.6).Bz(220,40.0).CA(6.5,0.45).CB(49.0,3.0).CC(0.679,3.38).CD(14.0,3.0).CE(30.0,0).CF(550).CG(330);
		boot.K.b.Bv(boot.L.fo).Bw(427,99).Bx(7.45,0.75).Bz(220,30.0).CA(6.4,0.45).CB(52.91,3.2).CC(0.658,2.67).CD(14.75,4.0).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.fp).Bw(437,89).Bx(5.5,0.6).Bz(220,55.0).CA(7.5,0.65).CB(48.0,3.6).CC(0.644,2.9).CD(15.0,3.3).CE(30.0,0).CF(425).CG(335);
		boot.K.b.Bv(boot.L.ga).Bw(400,82).Bx(4.5,0.55).Bz(250,36.0).CA(6.5,0.5).CB(46.0,3.0).CC(0.658,2.65).CD(13.5,3.4).CE(30.0,0).CF(575).CG(335);
		boot.K.b.Bv(boot.L.gb).Bw(359,83).Bx(4.5,0.55).Bz(173,27.0).CA(6.3,0.4).CB(50.0,3.25).CC(0.658,3.1).CD(9.3,3.4).CE(30.0,0).CF(550).CG(330);
		boot.K.b.Bv(boot.L.gc).Bw(355,82).Bx(4.5,0.55).Bz(250,55.0).CA(6.9,0.6).CB(48.3,2.625).CC(0.625,2.24).CD(12.25,3.75).CE(30.0,0).CF(525).CG(340);
		boot.K.b.Bv(boot.L.gd).Bw(440,85).Bx(7.5,0.9).Bz(220,45.0).CA(7.0,0.65).CB(55.0,3.5).CC(0.643,2.5).CD(16.0,3.5).CE(30.0,1.25).CF(125).CG(350);
		boot.K.b.Bv(boot.L.ge).Bw(385,78).Bx(6.75,0.65).Bz(240,50.0).CA(6.9,0.45).CB(49.0,3.0).CC(0.625,2.11).CD(12.0,4.0).CE(30.0,0).CF(525).CG(335);
		boot.K.b.Bv(boot.L.gf).Bw(400,85).Bx(6.0,0.6).CB(45.0,3.0).CC(0.6258,2.0).CD(12.0,3.5).CE(30.0,0).CF(450).CG(335);
		boot.K.b.Bv(boot.L.gg).Bw(440,86).Bx(7.0,0.65).Bz(220,30.0).CA(7.0,0.65).CB(54.0,3.3).CC(0.625,2.9).CD(16.5,3.5).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.gh).Bw(428,98).Bx(7.05,0.8).Bz(190,30.0).CA(7.1,0.6).CB(56.76,3.375).CC(0.679,2.88).CD(16.0,3.5).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.gi).Bw(435,85).Bx(5.1,0.65).Bz(202,38.0).CA(6.9,0.65).CB(54.0,3.2).CC(0.658,3.0).CD(15.0,3.5).CE(30.0,1.25).CF(175).CG(345);
		boot.K.b.Bv(boot.L.gj).Bw(380,80).Bx(5.0,0.55).Bz(250,45.0).CA(8.0,0.6).CB(52.0,3.0).CC(0.625,1.36).CD(12.6,3.4).CE(30.0,0).CF(550).CG(340);
		boot.K.b.Bv(boot.L.gk).Bw(445,87).Bx(7.0,0.7).Bz(213,31.0).CA(6.6,0.45).CB(52.0,3.3).CC(0.672,2.7).CD(16.2,3.7).CE(30.0,1.25).CF(175).CG(345);
		boot.K.b.Bv(boot.L.gl).Bw(421,85).Bx(8.5,0.7).Bz(235,35.0).CA(6.5,0.45).CB(51.5,3.5).CC(0.625,3.0).CD(18.0,3.6).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.gm).Bw(445,85).Bx(6.0,0.65).CH(20).CI(50).CB(48.6,3.4).CC(0.658,3.1).CD(17.5,3.5).CE(30.0,1.25).CF(125).CG(345);
		boot.K.b.Bv(boot.L.gn).Bw(390,80).Bx(5.25,0.6).Bz(250,50.0).CA(6.75,0.6).CB(54.0,3.1).CC(0.656,1.7).CD(12.0,3.3).CE(30.0,0).CF(575).CG(330);
		boot.K.b.Bv(boot.L.go).Bw(380,71).Bx(4.6,0.5).Bz(260,60.0).CA(6.95,0.65).CB(48.6,3.0).CC(0.625,2.13).CD(6.75,3.8).CE(30.0,0).CF(600).CG(335);
		boot.K.b.Bv(boot.L.gp).Bw(355,74).Bx(4.85,0.5).Bz(250,50.0).CA(7.1,0.75).CB(50.0,3.2).CC(0.625,1.8).CD(11.0,3.0).CE(30.0,0).CF(575).CG(325);
		boot.K.c=new boot.K(1520,2012,12,3,"Preseason 3",boot.K.b,0);
		boot.K.c.BX("Shard of True Ice");
		boot.K.c.BX("Liandry's Torment");
		boot.K.c.BX("Haunting Guise");
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
	BX:function(A,B){
		B=new boot.u(A,this,0);
		this.e.Y(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	Bv:function(A){
		A.hb=new boot.v(this,A.hb,0);
		return A.hb;
	}
});

boot.define("I",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("h");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.a.R("li").addClass("i");
		C.R("a").addClass("g").attr("href",B).text(A);
		return new boot.J(this,C,null,1);
	}
});

boot.define("BA",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.EH(this.b);
	}
});

boot.define("z",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.x.EG(this.a).BI().S();
		l2:while (D.T()!=0) {
			C=D.W();
			if(this.a.EE(C.BJ()).toLowerCase().indexOf(B) != -1==0){
				C.BD().addClass("m");
				continue l2;
			}else{
				C.BD().removeClass("m");
				continue l2;
			}
		}
	}
});

boot.define("y",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.y.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("x",boot.y,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.y.prototype.$0.call(this);
		this.b=new boot.R(0);
		this.c=this.EC();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	EB:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("j").css("display","block");
		B.keyup(new boot.z(this,B,0));
		D=this.c.S();
		l6:for (;
		D.T()!=0;
		this.b.Y(C,E)) {
			C=D.W();
			E=this.a.L("k").css("background-image","url("+this.ED(C)+")");
			E.R("span").addClass("l").text(this.EE(C));
			E.click(new boot.BA(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_EG:function(A){
		return A.b;
	}
});

boot.define("BC",boot.O,{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.O.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.O.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.O.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.O.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.O.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BF",boot.BC,{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.BC.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.BC.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.BC.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BC.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.BC.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BE",boot.BF,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.BF.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.BF.prototype.$1.call(this,A);
	}
});

boot.define("BD",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	T:function(){
		return this.b<boot.BB.Ev(this.a).length;
	},
	// js.util.ArrayList$View#next()
	W:function(){
		return boot.BB.Ev(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	V:function(){
		if(this.b<=0){
		}else{
			boot.BB.Ev(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.BD.prototype.$1.call(this,A);
	}
});

boot.define("BB",boot.X,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.X.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	x:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BA:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	S:function(){
		return new boot.BD(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BP:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	EQ:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BK:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	ER:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	ES:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	ET:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	EU:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	EV:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	EW:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	EX:function(){
		throw new boot.M(0);
	},
	// js.util.ArrayList#listIterator(int)
	EY:function(A){
		throw new boot.M(0);
	},
	// js.util.ArrayList#subList(int, int)
	EZ:function(A,B){
		throw new boot.M(0);
	},
	// js.util.ArrayList#checkRange(int)
	Eu:function(A){
		if(A>=0){
			if(this.x()>A){
				return;
			}else{
				throw new boot.BE("Index is overflowed. Size: "+this.x()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BE("Negative index is unacceptable. Size: "+this.x()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_Ev:function(A){
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
	EP:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.BB(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.BS());
			} catch ($) {
				if ($ instanceof boot.BC) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_EM:function(A,B){
		return A.EP(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.E.prototype.$1.call(this,A,B);
	}
});

boot.define("BG",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("D",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.BB(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.EL(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	EL:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.S();
		l3:while (C.T()!=0) {
			B=C.W();
			D=boot.E.EM(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.K(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	EO:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.K(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.D.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.EL(B);
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

boot.define("w",boot.x,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.x.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	EC:function(){
		return boot.L.v();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	EI:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	EJ:function(A){
		return A.Z();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	EK:function(A){
		boot.B.G(new boot.G(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	EE:function(A){
		return this.EI(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	ED:function(A){
		return this.EJ(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	EH:function(A){
		this.EK(A);
	}
});

boot.define("H",boot.F,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.F.prototype.$0.call(this);
		this.a=new boot.w(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	K:function(A){
		this.a.EB(A);
	},
	// teemowork.ChampionSelect#getPageId()
	H:function(){
		return "";
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