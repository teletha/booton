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
	$0:function(A,B){
		this.a=A;;
		this.b=B.J("ul").addClass("a");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.J("li").addClass("b");
		C.J("a").addClass("c").attr("href",B).text(A);
		return new boot.J(this.a,C,0);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
	$1:function(A,B,C){
		boot.J.prototype.$0.call(this,A,B);
	}
});

boot.define("Q",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.Q.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.Q.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.Q.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.Q.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	T:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	U:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	V:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	W:function(){
		console.log(this.a);
	}
});

boot.define("P",boot.Q,{
	
	// java.lang.Error#<init>()
	$0:function(){
		boot.Q.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$1:function(A){
		boot.Q.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.Q.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$3:function(A){
		boot.Q.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.Q.prototype.$4.call(this,A,B,C,D);
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
	BO:function(A,B,C,D){
		B=0;
		D=this.L();
		l2:while (D.M()!=0) {
			C=D.P();
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
		D=A.L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.BP(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BR:function(A,B,C){
		C=A.L();
		l1:while (C.M()!=0) {
			B=C.P();
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

boot.define("W",boot.X,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.X.prototype.$0.call(this);
	}
});

boot.define("Y",{
	
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
		this.d=boot.S.BV(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	O:function(){
		if(this.b<=0){
		}else{
			this.a.BP(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.Y.prototype.$1.call(this,A,B);
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
	L:function(){
		return new boot.Y(this,this.b.keys(),null,0);
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
			return A.BD();
		}else{
			return A.BJ();
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
	L:function(){
		return new boot.Z(this.a,boot.R.BM(this.a).L(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BP:function(A,B,C){
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
	BK:function(){
		boot.R.BM(this.a).BK();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.V.prototype.$1.call(this,A);
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
	L:function(){
		return new boot.Z(this.a,boot.R.BM(this.a).L(),1,null,0);
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
		C=this.w().L();
		l1:while (C.M()!=0) {
			B=C.P();
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
		C=A.BI().L();
		l1:for (;
		C.M()!=0;
		this.Y(B.BJ(),B.BD())) {
			B=C.P();
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

boot.define("O",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.O.b=new boot.R(0);
		boot.O.c=new boot.O("Ahri",0);
		boot.O.d=new boot.O("Akali",0);
		boot.O.e=new boot.O("Alistar",0);
		boot.O.f=new boot.O("Amumu",0);
		boot.O.g=new boot.O("Anivia",0);
		boot.O.h=new boot.O("Annie",0);
		boot.O.i=new boot.O("Ashe",0);
		boot.O.j=new boot.O("Blitzcrank",0);
		boot.O.k=new boot.O("Brand",0);
		boot.O.l=new boot.O("Caitlyn",0);
		boot.O.m=new boot.O("Cassiopeia",0);
		boot.O.n=new boot.O("Chogath",0);
		boot.O.o=new boot.O("Corki",0);
		boot.O.p=new boot.O("Darius",0);
		boot.O.ba=new boot.O("Diana",0);
		boot.O.bb=new boot.O("Dr.Mundo",0);
		boot.O.bc=new boot.O("Draven",0);
		boot.O.bd=new boot.O("Elise",0);
		boot.O.be=new boot.O("Evelynn",0);
		boot.O.bf=new boot.O("Ezreal",0);
		boot.O.bg=new boot.O("Fiddlesticks",0);
		boot.O.bh=new boot.O("Fiora",0);
		boot.O.bi=new boot.O("Fizz",0);
		boot.O.bj=new boot.O("Galio",0);
		boot.O.bk=new boot.O("Gangplank",0);
		boot.O.bl=new boot.O("Garen",0);
		boot.O.bm=new boot.O("Gragas",0);
		boot.O.bn=new boot.O("Graves",0);
		boot.O.bo=new boot.O("Hecarim",0);
		boot.O.bp=new boot.O("Heimerdinger",0);
		boot.O.ca=new boot.O("Irelia",0);
		boot.O.cb=new boot.O("Janna",0);
		boot.O.cc=new boot.O("Jarvan IV",0);
		boot.O.cd=new boot.O("Jax",0);
		boot.O.ce=new boot.O("Jayce",0);
		boot.O.cf=new boot.O("Karma",0);
		boot.O.cg=new boot.O("Karthus",0);
		boot.O.ch=new boot.O("Kassadin",0);
		boot.O.ci=new boot.O("Katarina",0);
		boot.O.cj=new boot.O("Kayle",0);
		boot.O.ck=new boot.O("Kennen",0);
		boot.O.cl=new boot.O("Kha'zix",0);
		boot.O.cm=new boot.O("Kog'maw",0);
		boot.O.cn=new boot.O("LeBlanc",0);
		boot.O.co=new boot.O("Lee Sin",0);
		boot.O.cp=new boot.O("Leona",0);
		boot.O.da=new boot.O("Lulu",0);
		boot.O.db=new boot.O("Lux",0);
		boot.O.dc=new boot.O("Malphite",0);
		boot.O.dd=new boot.O("Malzahar",0);
		boot.O.de=new boot.O("Maokai",0);
		boot.O.df=new boot.O("Master Yi",0);
		boot.O.dg=new boot.O("Miss Fortune",0);
		boot.O.dh=new boot.O("Mordekaiser",0);
		boot.O.di=new boot.O("Morgana",0);
		boot.O.dj=new boot.O("Nami",0);
		boot.O.dk=new boot.O("Nasus",0);
		boot.O.dl=new boot.O("Nautilus",0);
		boot.O.dm=new boot.O("Nidalee",0);
		boot.O.dn=new boot.O("Nocturne",0);
		boot.O.dp=new boot.O("Nunu",0);
		boot.O.ea=new boot.O("Olaf",0);
		boot.O.eb=new boot.O("Orianna",0);
		boot.O.ec=new boot.O("Pantheon",0);
		boot.O.ed=new boot.O("Poppy",0);
		boot.O.ee=new boot.O("Rammus",0);
		boot.O.ef=new boot.O("Renekton",0);
		boot.O.eg=new boot.O("Rengar",0);
		boot.O.eh=new boot.O("Riven",0);
		boot.O.ei=new boot.O("Rumble",0);
		boot.O.ej=new boot.O("Ryze",0);
		boot.O.ek=new boot.O("Sejuani",0);
		boot.O.el=new boot.O("Shaco",0);
		boot.O.em=new boot.O("Shen",0);
		boot.O.en=new boot.O("Shyvana",0);
		boot.O.eo=new boot.O("Singed",0);
		boot.O.ep=new boot.O("Sion",0);
		boot.O.fa=new boot.O("Sivir",0);
		boot.O.fb=new boot.O("Skarner",0);
		boot.O.fc=new boot.O("Sona",0);
		boot.O.fd=new boot.O("Soraka",0);
		boot.O.fe=new boot.O("Swain",0);
		boot.O.ff=new boot.O("Syndra",0);
		boot.O.fg=new boot.O("Talon",0);
		boot.O.fh=new boot.O("Taric",0);
		boot.O.fi=new boot.O("Teemo",0);
		boot.O.fj=new boot.O("Tristana",0);
		boot.O.fk=new boot.O("Trundle",0);
		boot.O.fl=new boot.O("Tryndamere",0);
		boot.O.fm=new boot.O("Twisted Fate",0);
		boot.O.fn=new boot.O("Twitch",0);
		boot.O.fo=new boot.O("Udyr",0);
		boot.O.fp=new boot.O("Urgot",0);
		boot.O.ga=new boot.O("Varus",0);
		boot.O.gb=new boot.O("Vayne",0);
		boot.O.gc=new boot.O("Veigar",0);
		boot.O.gd=new boot.O("Vi",0);
		boot.O.ge=new boot.O("Viktor",0);
		boot.O.gf=new boot.O("Vladimir",0);
		boot.O.gg=new boot.O("Volibear",0);
		boot.O.gh=new boot.O("Warwick",0);
		boot.O.gi=new boot.O("Wukong",0);
		boot.O.gj=new boot.O("Xerath",0);
		boot.O.gk=new boot.O("Xin Zhao",0);
		boot.O.gl=new boot.O("Yorick",0);
		boot.O.gm=new boot.O("Zed",0);
		boot.O.gn=new boot.O("Ziggs",0);
		boot.O.go=new boot.O("Zilean",0);
		boot.O.gp=new boot.O("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.X().toLowerCase();
		boot.O.b.Y(A,this);
	},
	// teemowork.model.Champion#getSystemName()
	X:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	S:function(){
		return "src/main/resources/teemowork/splash/"+this.X()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	Z:function(){
		return "src/main/resources/teemowork/icon/"+this.X()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_Q:function(A){
		return boot.O.b.u(A);
	},
	// teemowork.model.Champion#getAll()
	_v:function(){
		return boot.O.b.w();
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
		boot.G.prototype.$1.call(this,boot.O.Q(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.F.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.P(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	R:function(A,B){
		B=A.K("d").css("background-image","url("+this.a.S()+")").K("e");
		B.K("f").text(this.a.a);
		B.K("g").text("ad");
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	}
});

boot.define("I",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("h");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.a.J("li").addClass("i");
		C.J("a").addClass("c").attr("href",B).text(A);
		return new boot.J(this,C,null,1);
	}
});

boot.define("y",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.CA(this.b);
	}
});

boot.define("x",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.v.Bv(this.a).BI().L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.a.Bu(C.BJ()).toLowerCase().indexOf(B) != -1==0){
				C.BD().addClass("m");
				continue l2;
			}else{
				C.BD().removeClass("m");
				continue l2;
			}
		}
	}
});

boot.define("w",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.w.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("v",boot.w,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.w.prototype.$0.call(this);
		this.b=new boot.R(0);
		this.c=this.BY();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	BX:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("j").css("display","block");
		B.keyup(new boot.x(this,B,0));
		D=this.c.L();
		l6:for (;
		D.M()!=0;
		this.b.Y(C,E)) {
			C=D.P();
			E=this.a.K("k").css("background-image","url("+this.BZ(C)+")");
			E.J("span").addClass("l").text(this.Bu(C));
			E.click(new boot.y(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_Bv:function(A){
		return A.b;
	}
});

boot.define("z",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("BA",boot.Q,{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.Q.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.Q.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.Q.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.Q.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.Q.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BE",boot.BA,{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.BA.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.BA.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.BA.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BA.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.BA.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BD",boot.BE,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.BE.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.BE.prototype.$1.call(this,A);
	}
});

boot.define("BC",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	M:function(){
		return this.b<boot.BB.CO(this.a).length;
	},
	// js.util.ArrayList$View#next()
	P:function(){
		return boot.BB.CO(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	O:function(){
		if(this.b<=0){
		}else{
			boot.BB.CO(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.BC.prototype.$1.call(this,A);
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
	L:function(){
		return new boot.BC(this,null,0);
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
	CD:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BK:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	CE:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	CF:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	CG:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	CH:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	CI:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	CJ:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	CK:function(){
		throw new boot.P(0);
	},
	// js.util.ArrayList#listIterator(int)
	CL:function(A){
		throw new boot.P(0);
	},
	// js.util.ArrayList#subList(int, int)
	CM:function(A,B){
		throw new boot.P(0);
	},
	// js.util.ArrayList#checkRange(int)
	CN:function(A){
		if(A>=0){
			if(this.x()>A){
				return;
			}else{
				throw new boot.BD("Index is overflowed. Size: "+this.x()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BD("Negative index is unacceptable. Size: "+this.x()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_CO:function(A){
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
	CB:function(A,B,C,D){
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
				if ($ instanceof boot.BA) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_CC:function(A,B){
		return A.CB(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.E.prototype.$1.call(this,A,B);
	}
});

boot.defineNative("History",{
	
	// booton.translator.web.History#<init>()
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
		this.CP(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	CP:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.L();
		l3:while (C.M()!=0) {
			B=C.P();
			D=boot.E.CC(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.R(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	CQ:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.R(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.D.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.CP(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_E:function(A){
		return A.a;
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

boot.define("u",boot.v,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.v.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	BY:function(){
		return boot.O.v();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	Bw:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	Bx:function(A){
		return A.Z();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	Bz:function(A){
		boot.B.G(new boot.G(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	Bu:function(A){
		return this.Bw(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	BZ:function(A){
		return this.Bx(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	CA:function(A){
		this.Bz(A);
	}
});

boot.define("H",boot.F,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.F.prototype.$0.call(this);
		this.a=new boot.u(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	R:function(A){
		this.a.BX(A);
	},
	// teemowork.ChampionSelect#getPageId()
	H:function(){
		return "";
	}
});

boot.define("BH",{
	
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
	DC:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	DD:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	CW:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	DE:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DF:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	CX:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DG:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DH:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	CY:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DI:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DJ:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	CZ:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DK:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DL:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	Cu:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DM:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DN:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	Cv:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DO:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DP:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	Cw:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DQ:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DR:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	Cx:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	DS:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	Cy:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	DT:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	Cz:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	DU:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	DA:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	DV:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	DB:function(A){
		this.bf=A;
		return this;
	}
});

boot.define("BG",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.BG.a=new boot.R(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.BG.a.u(A);
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
		boot.BG.a.Y(A,this);
	},
	// teemowork.model.Item#cost()
	DW:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	CS:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	DX:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	DY:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	DZ:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	Du:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	Dv:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	Dw:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	Dx:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	Dy:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	Dz:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	EA:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	EB:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	EC:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	ED:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	CU:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	EE:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	EG:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	EH:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	EI:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	EJ:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	EK:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	EL:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	EM:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	EO:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	CT:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	EP:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	EQ:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	ER:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	ES:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	ET:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	EU:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	EV:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	EW:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	EX:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	EY:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	EZ:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	Eu:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_Ev:function(A){
		return boot.BG.a.u(A);
	},
	// teemowork.model.Item#getAll()
	_v:function(){
		return boot.BG.a.w();
	}
});

boot.define("K",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.K.b=new boot.K(1510,2012,11,13,"Initial",null,0);
		boot.K.b.CR("Ruby Crystal").CS(475).CT(180);
		boot.K.b.CR("Haunting Guise").CT(200).CU(25);
		boot.K.b.CV(boot.O.c).CW(380,80).CX(5.5,0.6).CY(230,50.0).CZ(6.25,0.6).Cu(50.0,3.0).Cv(0.668,2.0).Cw(10.0,3.5).Cx(30.0,0).Cy(550).Cz(330);
		boot.K.b.CV(boot.O.d).CW(445,85).CX(7.25,0.65).DA(200).DB(50).Cu(53.0,3.2).Cv(0.694,3.1).Cw(16.5,3.5).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.e).CW(442,102).CX(7.25,0.85).CY(215,38.0).CZ(6.45,0.45).Cu(55.03,3.62).Cv(0.625,3.62).Cw(14.5,3.5).Cx(30.0,1.25).Cy(125).Cz(325);
		boot.K.b.CV(boot.O.f).CW(472,84).CX(7.45,0.85).CY(220,40.0).CZ(6.5,0.525).Cu(47.0,3.8).Cv(0.638,2.18).Cw(18.0,3.3).Cx(30.0,1.25).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.g).CW(350,70).CX(4.65,0.55).CY(257,53.0).CZ(7.0,0.6).Cu(48.0,3.2).Cv(0.625,1.68).Cw(10.5,4.0).Cx(30.0,0).Cy(600).Cz(325);
		boot.K.b.CV(boot.O.h).CW(384,76).CX(4.5,0.55).CY(250,50.0).CZ(6.9,0.6).Cu(49.0,2.625).Cv(0.579,1.36).Cw(12.5,4.0).Cx(30.0,0).Cy(625).Cz(335);
		boot.K.b.CV(boot.O.i).CW(395,79).CX(4.5,0.55).CY(173,35.0).CZ(6.3,0.4).Cu(46.3,2.85).Cv(0.658,3.34).Cw(11.5,3.4).Cx(30.0,0).Cy(600).Cz(325);
		boot.K.b.CV(boot.O.j).CW(423,95).CX(7.25,0.75).CY(260,40.0).CZ(6.6,0.5).Cu(55.66,3.5).Cv(0.625,1.13).Cw(14.5,3.5).Cx(30.0,1.25).Cy(125).Cz(325);
		boot.K.b.CV(boot.O.k).CW(380,76).CX(4.5,0.55).CY(250,45.0).CZ(7.0,0.6).Cu(51.66,3.0).Cv(0.625,1.36).Cw(12.0,3.5).Cx(30.0,0).Cy(550).Cz(340);
		boot.K.b.CV(boot.O.l).CW(390,80).CX(4.75,0.55).CY(255,35.0).CZ(6.5,0.55).Cu(47.0,3.0).Cv(0.668,3.0).Cw(13.0,3.5).Cx(30.0,0).Cy(650).Cz(325);
		boot.K.b.CV(boot.O.m).CW(380,75).CX(4.85,0.5).CY(250,50.0).CZ(7.1,0.75).Cu(47.0,3.2).Cv(0.644,1.68).Cw(11.5,4.0).Cx(30.0,0).Cy(550).Cz(335);
		boot.K.b.CV(boot.O.n).CW(440,80).CX(7.5,0.85).CY(205,40.0).CZ(6.45,0.45).Cu(54.1,4.2).Cv(0.625,1.44).Cw(19.0,3.5).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.o).CW(375,82).CX(4.5,0.55).CY(243,37.0).CZ(6.5,0.55).Cu(48.2,3.0).Cv(0.658,2.3).Cw(13.5,3.5).Cx(30.0,0).Cy(550).Cz(325);
		boot.K.b.CV(boot.O.p).CW(426,93).CX(8.25,0.95).CY(200,37.5).CZ(6.0,0.35).Cu(50.0,3.5).Cv(0.679,2.6).Cw(20.0,3.5).Cx(30.0,1.25).Cy(125).Cz(340);
		boot.K.b.CV(boot.O.ba).CW(438,90).CX(7.0,0.85).CY(230,40.0).CZ(7.0,0.6).Cu(48.0,3.0).Cv(0.625,2.25).Cw(16.0,3.6).Cx(30.0,1.25).Cy(150).Cz(345);
		boot.K.b.CV(boot.O.bb).CW(433,89).CX(6.5,0.75).Cu(56.23,3.0).Cv(0.625,2.8).Cw(17.0,3.5).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.bc).CW(420,82).CX(5.0,0.7).CY(240,42.0).CZ(6.95,0.65).Cu(46.5,3.5).Cv(0.679,2.6).Cw(16.0,3.3).Cx(30.0,0).Cy(550).Cz(330);
		boot.K.b.CV(boot.O.bd).CW(395,80).CX(4.7,0.6).CY(240,50.0).CZ(6.8,0.65).Cu(47.5,3.0).Cv(0.625,1.75).Cw(12.65,3.35).Cx(30.0,0).Cy(550).Cz(335);
		boot.K.b.CV(boot.O.be).CW(414,86).CX(6.95,0.55).CY(180,42.0).CZ(7.1,0.6).Cu(48.0,3.3).Cv(0.658,3.84).Cw(12.5,4.0).Cx(30.0,1.25).Cy(125).Cz(340);
		boot.K.b.CV(boot.O.bf).CW(350,80).CX(5.5,0.55).CY(235,45.0).CZ(7.0,0.65).Cu(47.2,3.0).Cv(0.665,2.8).Cw(12.0,3.5).Cx(30.0,0).Cy(550).Cz(330);
		boot.K.b.CV(boot.O.bg).CW(390,80).CX(4.6,0.6).CY(251,59.0).CZ(6.9,0.65).Cu(45.95,2.625).Cv(0.625,2.11).Cw(11.0,3.5).Cx(30.0,0).Cy(480).Cz(335);
		boot.K.b.CV(boot.O.bh).CW(450,85).CX(6.3,0.8).CY(220,40.0).CZ(7.25,0.5).Cu(54.5,3.2).Cv(0.672,3.0).Cw(15.5,3.5).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.bi).CW(414,86).CX(7.0,0.7).CY(200,40.0).CZ(6.15,0.45).Cu(53.0,3.0).Cv(0.658,3.1).Cw(13.0,3.4).Cx(30.0,1.25).Cy(175).Cz(335);
		boot.K.b.CV(boot.O.bj).CW(435,85).CX(7.45,0.75).CY(235,50.0).CZ(7.0,0.7).Cu(56.3,3.375).Cv(0.638,1.2).Cw(17.0,3.5).Cx(30.0,0).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.bk).CW(495,81).CX(425.0,0.75).CY(215,40.0).CZ(6.5,0.7).Cu(54.0,3.0).Cv(0.651,2.75).Cw(16.5,3.3).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.bl).CW(455,96).CX(7.5,0.75).Cu(52.5,3.5).Cv(0.625,2.9).Cw(19.0,2.7).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.bm).CW(434,89).CX(7.25,0.85).CY(221,47.0).CZ(6.45,0.45).Cu(55.78,3.375).Cv(0.651,2.05).Cw(16.0,3.6).Cx(30.0,0).Cy(125).Cz(340);
		boot.K.b.CV(boot.O.bn).CW(410,84).CX(5.5,0.7).CY(255,40.0).CZ(6.75,0.7).Cu(51.0,3.1).Cv(0.625,2.9).Cw(15.0,3.2).Cx(30.0,0).Cy(525).Cz(330);
		boot.K.b.CV(boot.O.bo).CW(440,95).CX(8.0,0.75).CY(210,40.0).CZ(6.5,0.6).Cu(56.0,3.2).Cv(0.67,2.5).Cw(16.0,4.0).Cx(30.0,1.25).Cy(175).Cz(345);
		boot.K.b.CV(boot.O.bp).CW(350,75).CX(4.5,0.55).CY(240,65.0).CZ(7.0,0.65).Cu(49.24,3.0).Cv(0.625,1.21).Cw(7.0,3.0).Cx(30.0,0).Cy(550).Cz(325);
		boot.K.b.CV(boot.O.ca).CW(456,90).CX(7.5,0.65).CY(230,35.0).CZ(7.0,0.65).Cu(56.0,3.3).Cv(0.665,3.2).Cw(15.0,3.75).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.cb).CW(356,78).CX(4.5,0.55).CY(302,64.0).CZ(6.9,0.6).Cu(49.0,2.95).Cv(0.625,2.61).Cw(9.0,3.8).Cx(30.0,0).Cy(475).Cz(335);
		boot.K.b.CV(boot.O.cc).CW(420,90).CX(7.0,0.7).CY(235,40.0).CZ(6.0,0.45).Cu(50.0,3.4).Cv(0.658,2.5).Cw(14.0,3.0).Cx(30.0,1.25).Cy(175).Cz(340);
		boot.K.b.CV(boot.O.cd).CW(463,98).CX(7.45,0.55).CY(230,35.0).CZ(6.4,0.7).Cu(56.3,3.375).Cv(0.638,3.4).Cw(18.0,3.5).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.ce).CW(420,90).CX(6.0,0.8).CY(240,40.0).CZ(7.0,0.7).Cu(46.5,3.5).Cv(0.658,3.0).Cw(12.5,3.5).Cx(30.0,0).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.cf).CW(410,86).CX(4.7,0.55).CY(240,60.0).CZ(6.8,0.65).Cu(50.0,3.3).Cv(0.625,2.3).Cw(15.0,3.5).Cx(30.0,0).Cy(425).Cz(335);
		boot.K.b.CV(boot.O.cg).CW(390,75).CX(5.5,0.55).CY(270,61.0).CZ(6.5,0.6).Cu(42.2,3.25).Cv(0.625,2.11).Cw(11.0,3.5).Cx(30.0,0).Cy(450).Cz(335);
		boot.K.b.CV(boot.O.ch).CW(433,78).CX(6.95,0.5).CY(230,45.0).CZ(6.9,0.6).Cu(52.3,3.9).Cv(0.638,3.7).Cw(14.0,3.2).Cx(30.0,1.25).Cy(125).Cz(340);
		boot.K.b.CV(boot.O.ci).CW(395,83).CX(6.95,0.55).Cu(53.0,3.2).Cv(0.658,2.74).Cw(14.75,4.0).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.cj).CW(418,93).CX(7.0,0.75).CY(255,40.0).CZ(6.9,0.525).Cu(53.3,2.8).Cv(0.638,2.5).Cw(17.0,3.5).Cx(30.0,0.75).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.ck).CW(403,79).CX(4.65,0.65).DA(200).DB(50).Cu(51.3,3.3).Cv(0.69,3.4).Cw(14.0,3.75).Cx(30.0,0).Cy(550).Cz(335);
		boot.K.b.CV(boot.O.cl).CW(430,85).CX(6.25,0.75).CY(260,40.0).CZ(6.75,0.5).Cu(50.0,3.1).Cv(0.665,2.7).Cw(15.0,3.0).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.cm).CW(440,84).CX(5.0,0.55).CY(295,40.0).CZ(7.5,0.7).Cu(46.0,3.0).Cv(0.665,2.65).Cw(13.0,3.53).Cx(30.0,0).Cy(500).Cz(340);
		boot.K.b.CV(boot.O.cn).CW(390,75).CX(4.5,0.55).CY(250,50.0).CZ(6.9,0.6).Cu(51.0,3.1).Cv(0.625,1.4).Cw(12.0,3.5).Cx(30.0,0).Cy(525).Cz(335);
		boot.K.b.CV(boot.O.co).CW(428,85).CX(6.25,61.0).DB(200).DB(50).Cu(55.8,3.2).Cv(0.651,3.0).Cw(16.0,3.7).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.cp).CW(430,87).CX(9.0,0.85).CY(235,40.0).CZ(8.0,0.7).Cu(55.0,3.0).Cv(0.625,2.9).Cw(18.0,3.1).Cx(30.0,1.25).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.da).CW(415,82).CX(6.0,0.72).CY(200,50.0).CZ(6.0,0.6).Cu(44.4,2.6).Cv(0.625,2.2).Cw(9.0,3.7).Cx(30.0,0).Cy(550).Cz(325);
		boot.K.b.CV(boot.O.db).CW(345,79).CX(4.5,0.55).CY(250,50.0).CZ(6.0,0.6).Cu(50.0,3.3).Cv(0.625,1.36).Cw(8.0,4.0).Cx(30.0,0).Cy(550).Cz(340);
		boot.K.b.CV(boot.O.dc).CW(423,90).CX(7.45,0.55).CY(215,40.0).CZ(6.4,0.55).Cu(56.3,3.375).Cv(0.638,3.4).Cw(18.0,3.75).Cx(30.0,1.25).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.dd).CW(380,80).CX(4.5,0.55).CY(250,45.0).CZ(7.0,0.6).Cu(51.66,3.0).Cv(0.625,1.36).Cw(15.0,3.5).Cx(30.0,0).Cy(550).Cz(340);
		boot.K.b.CV(boot.O.de).CW(421,90).CX(7.25,0.85).CY(250,46.0).CZ(6.45,0.45).Cu(58.0,3.3).Cv(0.694,2.13).Cw(18.0,4.0).Cx(30.0,0).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.df).CW(444,86).CX(6.75,0.65).CY(199,36.0).CZ(6.5,0.45).Cu(55.12,3.1).Cv(0.679,2.98).Cw(16.3,3.7).Cx(30.0,1.25).Cy(125).Cz(355);
		boot.K.b.CV(boot.O.dg).CW(435,85).CX(5.1,0.65).CY(212,38.0).CZ(6.95,0.65).Cu(46.5,3.0).Cv(0.658,3.01).Cw(15.0,3.0).Cx(30.0,0).Cy(550).Cz(325);
		boot.K.b.CV(boot.O.dh).CW(421,80).CX(7.45,0.55).Cu(51.7,3.5).Cv(0.694,3.0).Cw(15.0,3.5).Cx(30.0,1.25).Cy(125).Cz(340);
		boot.K.b.CV(boot.O.di).CW(403,86).CX(4.7,0.6).CY(240,60.0).CZ(6.8,0.65).Cu(51.58,3.5).Cv(0.579,1.53).Cw(15.0,3.8).Cx(30.0,0).Cy(425).Cz(335);
		boot.K.b.CV(boot.O.dj).CW(365,74).CX(4.5,45.0).CY(305,43.0).CZ(6.9,0.6).Cu(48.0,3.1).Cv(0.644,2.6).Cw(9.0,4.0).Cx(30.0,0).Cy(550).Cz(330);
		boot.K.b.CV(boot.O.dk).CW(410,90).CX(7.5,0.9).CY(200,45.0).CZ(6.6,0.5).Cu(53.3,3.5).Cv(0.638,3.48).Cw(15.0,3.5).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.dl).CW(432,86).CX(7.45,0.55).CY(200,50.0).CZ(7.45,0.7).Cu(52.0,3.3).Cv(0.613,0.98).Cw(12.0,3.25).Cx(30.0,1.25).Cy(175).Cz(325);
		boot.K.b.CV(boot.O.dm).CW(370,90).CX(5.0,0.6).CY(220,45.0).CZ(7.0,0.5).Cu(49.0,3.5).Cv(0.672,3.22).Cw(11.0,3.5).Cx(30.0,10.75).Cy(525).Cz(335);
		boot.K.b.CV(boot.O.dn).CW(430,85).CX(7.0,0.75).CY(215,35.0).CZ(6.0,0.45).Cu(54.0,3.1).Cv(0.668,2.7).Cw(17.0,3.5).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.dp).CW(437,108).CX(7.05,0.8).CY(213,42.0).CZ(6.6,0.5).Cu(51.6,3.4).Cv(0.625,2.25).Cw(16.5,3.5).Cx(30.0,1.25).Cy(125).Cz(340);
		boot.K.b.CV(boot.O.ea).CW(441,93).CX(7.0,0.9).CY(225,45.0).CZ(6.5,0.575).Cu(54.1,3.5).Cv(0.694,2.7).Cw(17.0,3.0).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.eb).CW(385,79).CX(5.95,0.55).CY(250,50.0).CZ(7.0,0.5).Cu(44.0,2.6).Cv(0.658,3.5).Cw(8.0,3.0).Cx(30.0,0).Cy(525).Cz(325);
		boot.K.b.CV(boot.O.ec).CW(433,87).CX(6.75,0.65).CY(210,34.0).CZ(6.6,0.45).Cu(50.7,2.9).Cv(0.679,2.95).Cw(17.1,3.9).Cx(30.0,1.25).Cy(155).Cz(355);
		boot.K.b.CV(boot.O.ed).CW(423,81).CX(7.45,0.55).CY(185,30.0).CZ(6.4,0.45).Cu(56.3,3.375).Cv(0.638,3.35).Cw(18.0,4.0).Cx(30.0,0).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.ee).CW(420,86).CX(8.0,0.55).CY(255,33.0).CZ(4.5,0.3).Cu(50.0,3.5).Cv(0.625,2.22).Cw(21.0,3.8).Cx(30.0,1.25).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.ef).CW(426,87).CX(6.7,0.75).Cu(53.12,3.1).Cv(0.665,2.65).Cw(15.2,3.8).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.eg).CW(435,85).CX(4.0,0.4).Cu(55.0,3.0).Cv(0.679,2.85).Cw(16.0,3.5).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.eh).CW(414,86).CX(10.4,0.9).Cu(54.0,2.75).Cv(0.625,3.5).Cw(15.0,3.1).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.ei).CW(450,80).CX(7.0,0.7).Cu(55.32,3.2).Cv(0.644,1.85).Cw(16.0,3.5).Cx(30.0,1.25).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.ej).CW(360,86).CX(4.35,0.55).CY(250,55.0).CZ(7.0,0.6).Cu(52.0,3.0).Cv(0.625,2.11).Cw(11.0,3.9).Cx(30.0,0).Cy(550).Cz(335);
		boot.K.b.CV(boot.O.ek).CW(450,85).CX(7.35,0.85).CY(220,40.0).CZ(6.45,0.45).Cu(54.0,3.4).Cv(0.67,1.45).Cw(20.5,3.5).Cx(30.0,1.25).Cy(125).Cz(340);
		boot.K.b.CV(boot.O.el).CW(441,84).CX(7.45,0.55).CY(270,40.0).CZ(6.4,0.45).Cu(51.7,3.5).Cv(0.694,3.0).Cw(15.0,3.5).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.em).CW(428,85).CX(7.45,0.55).DA(200).DB(50).Cu(54.5,3.375).Cv(0.651,3.4).Cw(15.0,4.0).Cx(30.0,0).Cy(125).Cz(335);
		boot.K.b.CV(boot.O.en).CW(435,95).CX(7.2,0.8).Cu(54.5,3.4).Cv(0.658,3.4).Cw(17.6,3.4).Cx(30.0,1.25).Cy(125).Cz(350);
		boot.K.b.CV(boot.O.eo).CW(405,82).CX(7.1,0.55).CY(215,45.0).CZ(6.6,0.55).Cu(56.65,3.375).Cv(0.613,1.81).Cw(18.0,3.5).Cx(30.0,0).Cy(125).Cz(345);
		boot.K.b.CV(boot.O.ep);
		boot.K.b.CV(boot.O.fa);
		boot.K.b.CV(boot.O.fb);
		boot.K.b.CV(boot.O.fc);
		boot.K.b.CV(boot.O.fd);
		boot.K.b.CV(boot.O.fe);
		boot.K.b.CV(boot.O.ff);
		boot.K.b.CV(boot.O.fg);
		boot.K.b.CV(boot.O.fh);
		boot.K.b.CV(boot.O.fi);
		boot.K.b.CV(boot.O.fj);
		boot.K.b.CV(boot.O.fk);
		boot.K.b.CV(boot.O.fl);
		boot.K.b.CV(boot.O.fm);
		boot.K.b.CV(boot.O.fn);
		boot.K.b.CV(boot.O.fo);
		boot.K.b.CV(boot.O.fp);
		boot.K.b.CV(boot.O.ga);
		boot.K.b.CV(boot.O.gb);
		boot.K.b.CV(boot.O.gc);
		boot.K.b.CV(boot.O.ge);
		boot.K.b.CV(boot.O.gf);
		boot.K.b.CV(boot.O.gg);
		boot.K.b.CV(boot.O.gh);
		boot.K.b.CV(boot.O.gi);
		boot.K.b.CV(boot.O.gj);
		boot.K.b.CV(boot.O.gk);
		boot.K.b.CV(boot.O.gl);
		boot.K.b.CV(boot.O.gm);
		boot.K.b.CV(boot.O.gn);
		boot.K.b.CV(boot.O.go);
		boot.K.b.CV(boot.O.gp);
		boot.K.c=new boot.K(1520,2012,12,3,"Preseason 3",boot.K.b,0);
		boot.K.c.CR("Shard of True Ice");
		boot.K.c.CR("Liandry's Torment");
		boot.K.c.CR("Haunting Guise");
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
	CR:function(A,B){
		B=new boot.BG(A,this,0);
		this.e.Y(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	CV:function(A){
		A.hb=new boot.BH(this,A.hb,0);
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