boot.define("N",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	N:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	O:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	P:function(){
	},
	// booton.translator.web.jQuery$1#next()
	Q:function(){
		return this.O();
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
boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	K:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	L:function(A){
		return this.K("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	M:function(){
		return new boot.N(this,0);
	}
});
boot.define("K",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.K("ul").addClass("d");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.K("li").addClass("e");
		C.K("a").addClass("c").attr("href",B).text(A);
		return new boot.K(this.a,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
	$0:function(A,B,C){
		boot.K.prototype.$1.call(this,A,B);
	}
});

boot.define("J",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("a");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.a.K("li").addClass("b");
		C.K("a").addClass("c").attr("href",B).text(A);
		return new boot.K(this,C,null,0);
	}
});

boot.define("T",{
	
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
	u:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	v:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	w:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	x:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	y:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	z:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	BA:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	BB:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	BC:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	BD:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	BE:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	BF:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	BG:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	BH:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	BI:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	BJ:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	BK:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	BL:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	BM:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	BN:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	BO:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	BP:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	BQ:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	BR:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	BS:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	BT:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	BU:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	BV:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	BW:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	BX:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	BY:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	BZ:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	X:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	Bu:function(A){
		return this.g+this.h*A;
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("R",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.H.Z(this.a,boot.H.Y(this.a)+1);
	}
});

boot.define("x",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	N:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	Q:function(){
		this.d=boot.W.CZ(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	P:function(){
		if(this.b<=0){
		}else{
			this.a.CT(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.x.prototype.$1.call(this,A,B);
	}
});

boot.define("u",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	CC:function(){
		return this.CB()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	CR:function(A,B,C,D){
		B=0;
		D=A.M();
		l2:while (D.N()!=0) {
			C=D.Q();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	CS:function(A,B,C,D){
		B=0;
		D=this.M();
		l2:while (D.N()!=0) {
			C=D.Q();
			if(A.CE(C)!=0){
			}else{
				B=this.CT(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	CU:function(A,B,C,D){
		B=0;
		D=A.M();
		l2:while (D.N()!=0) {
			C=D.Q();
			if(this.CT(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	CV:function(A,B,C){
		C=A.M();
		l1:while (C.N()!=0) {
			B=C.Q();
			if(this.CE(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	CW:function(){
		return this.CX(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	CX:function(A,B,C,D,E){
		B=this.CB();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.M();
		D=0;
		l6:while (C.N()!=0) {
			E=C.Q();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("w",boot.u,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.u.prototype.$0.call(this);
	}
});

boot.define("W",boot.w,{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.w.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	CB:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	CE:function(A){
		return this.CY(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.CY(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	CT:function(A,B){
		B=this.CY(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	CO:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	M:function(){
		return new boot.x(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	CY:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CG:function(A){
		return this.b[this.CY(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CI:function(A,B,C){
		B=null;
		C=this.CY(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	CK:function(A,B,C){
		B=null;
		C=this.CY(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_CZ:function(A){
		return A.b;
	}
});

boot.define("v",{
	
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.a=A;;
		this.b=B;
		this.c=C;
	},
	// js.util.HashMap$View#hasNext()
	N:function(){
		return this.b.N();
	},
	// js.util.HashMap$View#next()
	Q:function(A){
		A=this.b.Q();
		if(this.c==0){
			return A.CH();
		}else{
			return A.CN();
		}
	},
	// js.util.HashMap$View#remove()
	P:function(){
		this.b.P();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.v.prototype.$1.call(this,A,B,C);
	}
});

boot.define("Z",boot.u,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.u.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	CB:function(){
		return boot.V.CQ(this.a).CB();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	CE:function(A){
		return this.a.CF(A);
	},
	// js.util.HashMap$Values#iterator()
	M:function(){
		return new boot.v(this.a,boot.V.CQ(this.a).M(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	CT:function(A,B,C){
		B=this.M();
		l2:while (B.N()!=0) {
			C=B.Q();
			if(C!=A){
			}else{
				B.P();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	CO:function(){
		boot.V.CQ(this.a).CO();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.Z.prototype.$1.call(this,A);
	}
});

boot.define("X",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	CN:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CH:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	Cu:function(A,B){
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
		boot.X.prototype.$1.call(this,A,B);
	}
});

boot.define("Y",boot.w,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.w.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	CB:function(){
		return boot.V.CQ(this.a).CB();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	CE:function(A){
		return boot.V.CQ(this.a).CE(A);
	},
	// js.util.HashMap$Keys#iterator()
	M:function(){
		return new boot.v(this.a,boot.V.CQ(this.a).M(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	CT:function(A){
		return boot.V.CQ(this.a).CT(A);
	},
	// js.util.HashMap$Keys#clear()
	CO:function(){
		boot.V.CQ(this.a).CO();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.Y.prototype.$1.call(this,A);
	}
});

boot.define("V",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.W(0);
	},
	// js.util.HashMap#size()
	CB:function(){
		return this.a.CB();
	},
	// js.util.HashMap#isEmpty()
	CC:function(){
		return this.a.CC();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	CD:function(A){
		return this.a.CE(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CF:function(A,B,C){
		C=this.CA().M();
		l1:while (C.N()!=0) {
			B=C.Q();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	Bx:function(A,B){
		B=this.a.CG(A);
		return (B==null?null:B.CH());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	Bw:function(A,B,C){
		C=this.a.CI(new boot.X(A,B,null,0));
		if(C!=null){
			return C.CH();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	CJ:function(A,B){
		B=this.a.CK(A);
		if(B!=null){
			return B.CH();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	CL:function(A,B,C){
		C=A.CM().M();
		l1:for (;
		C.N()!=0;
		this.Bw(B.CN(),B.CH())) {
			B=C.Q();
		}
	},
	// js.util.HashMap#clear()
	CO:function(){
		this.a.CO();
	},
	// js.util.HashMap#keySet()
	CP:function(){
		return new boot.Y(this,null,0);
	},
	// js.util.HashMap#values()
	CA:function(){
		return new boot.Z(this,null,0);
	},
	// js.util.HashMap#entrySet()
	CM:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_CQ:function(A){
		return A.a;
	}
});

boot.define("P",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.P.b=new boot.V(0);
		boot.P.c=new boot.P("Ahri",0);
		boot.P.d=new boot.P("Akali",0);
		boot.P.e=new boot.P("Alistar",0);
		boot.P.f=new boot.P("Amumu",0);
		boot.P.g=new boot.P("Anivia",0);
		boot.P.h=new boot.P("Annie",0);
		boot.P.i=new boot.P("Ashe",0);
		boot.P.j=new boot.P("Blitzcrank",0);
		boot.P.k=new boot.P("Brand",0);
		boot.P.l=new boot.P("Caitlyn",0);
		boot.P.m=new boot.P("Cassiopeia",0);
		boot.P.n=new boot.P("Chogath",0);
		boot.P.o=new boot.P("Corki",0);
		boot.P.p=new boot.P("Darius",0);
		boot.P.ba=new boot.P("Diana",0);
		boot.P.bb=new boot.P("Dr.Mundo",0);
		boot.P.bc=new boot.P("Draven",0);
		boot.P.bd=new boot.P("Elise",0);
		boot.P.be=new boot.P("Evelynn",0);
		boot.P.bf=new boot.P("Ezreal",0);
		boot.P.bg=new boot.P("Fiddlesticks",0);
		boot.P.bh=new boot.P("Fiora",0);
		boot.P.bi=new boot.P("Fizz",0);
		boot.P.bj=new boot.P("Galio",0);
		boot.P.bk=new boot.P("Gangplank",0);
		boot.P.bl=new boot.P("Garen",0);
		boot.P.bm=new boot.P("Gragas",0);
		boot.P.bn=new boot.P("Graves",0);
		boot.P.bo=new boot.P("Hecarim",0);
		boot.P.bp=new boot.P("Heimerdinger",0);
		boot.P.ca=new boot.P("Irelia",0);
		boot.P.cb=new boot.P("Janna",0);
		boot.P.cc=new boot.P("Jarvan IV",0);
		boot.P.cd=new boot.P("Jax",0);
		boot.P.ce=new boot.P("Jayce",0);
		boot.P.cf=new boot.P("Karma",0);
		boot.P.cg=new boot.P("Karthus",0);
		boot.P.ch=new boot.P("Kassadin",0);
		boot.P.ci=new boot.P("Katarina",0);
		boot.P.cj=new boot.P("Kayle",0);
		boot.P.ck=new boot.P("Kennen",0);
		boot.P.cl=new boot.P("Kha'zix",0);
		boot.P.cm=new boot.P("Kog'maw",0);
		boot.P.cn=new boot.P("LeBlanc",0);
		boot.P.co=new boot.P("Lee Sin",0);
		boot.P.cp=new boot.P("Leona",0);
		boot.P.da=new boot.P("Lulu",0);
		boot.P.db=new boot.P("Lux",0);
		boot.P.dc=new boot.P("Malphite",0);
		boot.P.dd=new boot.P("Malzahar",0);
		boot.P.de=new boot.P("Maokai",0);
		boot.P.df=new boot.P("Master Yi",0);
		boot.P.dg=new boot.P("Miss Fortune",0);
		boot.P.dh=new boot.P("Mordekaiser",0);
		boot.P.di=new boot.P("Morgana",0);
		boot.P.dj=new boot.P("Nami",0);
		boot.P.dk=new boot.P("Nasus",0);
		boot.P.dl=new boot.P("Nautilus",0);
		boot.P.dm=new boot.P("Nidalee",0);
		boot.P.dn=new boot.P("Nocturne",0);
		boot.P.dp=new boot.P("Nunu",0);
		boot.P.ea=new boot.P("Olaf",0);
		boot.P.eb=new boot.P("Orianna",0);
		boot.P.ec=new boot.P("Pantheon",0);
		boot.P.ed=new boot.P("Poppy",0);
		boot.P.ee=new boot.P("Rammus",0);
		boot.P.ef=new boot.P("Renekton",0);
		boot.P.eg=new boot.P("Rengar",0);
		boot.P.eh=new boot.P("Riven",0);
		boot.P.ei=new boot.P("Rumble",0);
		boot.P.ej=new boot.P("Ryze",0);
		boot.P.ek=new boot.P("Sejuani",0);
		boot.P.el=new boot.P("Shaco",0);
		boot.P.em=new boot.P("Shen",0);
		boot.P.en=new boot.P("Shyvana",0);
		boot.P.eo=new boot.P("Singed",0);
		boot.P.ep=new boot.P("Sion",0);
		boot.P.fa=new boot.P("Sivir",0);
		boot.P.fb=new boot.P("Skarner",0);
		boot.P.fc=new boot.P("Sona",0);
		boot.P.fd=new boot.P("Soraka",0);
		boot.P.fe=new boot.P("Swain",0);
		boot.P.ff=new boot.P("Syndra",0);
		boot.P.fg=new boot.P("Talon",0);
		boot.P.fh=new boot.P("Taric",0);
		boot.P.fi=new boot.P("Teemo",0);
		boot.P.fj=new boot.P("Tristana",0);
		boot.P.fk=new boot.P("Trundle",0);
		boot.P.fl=new boot.P("Tryndamere",0);
		boot.P.fm=new boot.P("Twisted Fate",0);
		boot.P.fn=new boot.P("Twitch",0);
		boot.P.fo=new boot.P("Udyr",0);
		boot.P.fp=new boot.P("Urgot",0);
		boot.P.ga=new boot.P("Varus",0);
		boot.P.gb=new boot.P("Vayne",0);
		boot.P.gc=new boot.P("Veigar",0);
		boot.P.gd=new boot.P("Vi",0);
		boot.P.ge=new boot.P("Viktor",0);
		boot.P.gf=new boot.P("Vladimir",0);
		boot.P.gg=new boot.P("Volibear",0);
		boot.P.gh=new boot.P("Warwick",0);
		boot.P.gi=new boot.P("Wukong",0);
		boot.P.gj=new boot.P("Xerath",0);
		boot.P.gk=new boot.P("Xin Zhao",0);
		boot.P.gl=new boot.P("Yorick",0);
		boot.P.gm=new boot.P("Zed",0);
		boot.P.gn=new boot.P("Ziggs",0);
		boot.P.go=new boot.P("Zilean",0);
		boot.P.gp=new boot.P("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.Bv().toLowerCase();
		boot.P.b.Bw(A,this);
	},
	// teemowork.model.Champion#getStatus()
	W:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	Bv:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	T:function(){
		return "src/main/resources/teemowork/splash/"+this.Bv()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	U:function(){
		return "src/main/resources/teemowork/icon/"+this.Bv()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_R:function(A){
		return boot.P.b.Bx(A);
	},
	// teemowork.model.Champion#getAll()
	_Bz:function(){
		return boot.P.b.CA();
	}
});

boot.define("S",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.H.Z(this.a,boot.H.Y(this.a)-1);
	}
});

boot.define("y",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.y.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.y.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.y.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.y.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	Cv:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	Cw:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	Cx:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	Cy:function(){
		console.log(this.a);
	}
});

boot.define("Q",boot.y,{
	
	// java.lang.Error#<init>()
	$0:function(){
		boot.y.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$1:function(A){
		boot.y.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.y.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$3:function(A){
		boot.y.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.y.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("G",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("H",boot.G,{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.H.prototype.$1.call(this,boot.P.R(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.G.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.Q(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	S:function(A,B,C){
		B=A.L("f").css("background-image","url('"+this.a.T()+"')").L("g");
		C=B.L("h").css("background-image","url("+this.a.U()+")").click(new boot.R(this,0)).on("contextmenu",new boot.S(this,0));
		this.b=C.L("i");
		this.c=B.L("j").text("Health").L("k");
		this.V(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	V:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.W();
			this.c.text(""+B.X(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_Y:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_Z:function(A,B){
		A.V(B);
	}
});

boot.defineNative("History",{
	
	// booton.translator.web.History#<init>()
	$0:function(){
	}
});
boot.define("BA",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("BF",boot.y,{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.y.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.y.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.y.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.y.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.y.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BE",boot.BF,{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.BF.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.BF.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.BF.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BF.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.BF.prototype.$4.call(this,A,B,C,D);
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
	N:function(){
		return this.b<boot.BB.DN(this.a).length;
	},
	// js.util.ArrayList$View#next()
	Q:function(){
		return boot.BB.DN(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	P:function(){
		if(this.b<=0){
		}else{
			boot.BB.DN(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.BC.prototype.$1.call(this,A);
	}
});

boot.define("BB",boot.u,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.u.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	CB:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	CE:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	M:function(){
		return new boot.BC(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	CT:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	DC:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	CO:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	DD:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	DE:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	DF:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	DG:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	DH:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	DI:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	DJ:function(){
		throw new boot.Q(0);
	},
	// js.util.ArrayList#listIterator(int)
	DK:function(A){
		throw new boot.Q(0);
	},
	// js.util.ArrayList#subList(int, int)
	DL:function(A,B){
		throw new boot.Q(0);
	},
	// js.util.ArrayList#checkRange(int)
	DM:function(A){
		if(A>=0){
			if(this.CB()>A){
				return;
			}else{
				throw new boot.BD("Index is overflowed. Size: "+this.CB()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BD("Negative index is unacceptable. Size: "+this.CB()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_DN:function(A){
		return A.a;
	}
});

boot.define("F",{
	
	// js.Application$Route#<init>(java.lang.String, java.lang.Class)
	$1:function(A,B){
		this.a=new RegExp(A.replace(/\*/g,"([^/].+)"),"");
		this.b=B;
	},
	// js.Application$Route#match(java.lang.String)
	DO:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.BB(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.CW());
			} catch ($) {
				if ($ instanceof boot.BF) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_DA:function(A,B){
		return A.DO(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.F.prototype.$1.call(this,A,B);
	}
});

boot.define("E",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.BB(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.Cz(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	Cz:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.M();
		l3:while (C.N()!=0) {
			B=C.Q();
			D=boot.F.DA(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.S(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	DB:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.S(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.Cz(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_E:function(A){
		return A.a;
	}
});

boot.define("C",{
	
	// js.Application#<clinit>()
	_:function(){
		boot.C.a=new boot.E(null,0);
	},
	// js.Application#<init>()
	$0:function(){
	},
	// js.Application#jsmain()
	A:function(){
		$(window).on("hashchange",boot.C.a);
		boot.E.B(boot.C.a,location.hash);
	},
	// js.Application#configure(js.application.Header)
	C:function(A){
	},
	// js.Application#register(java.lang.String, java.lang.Class)
	D:function(A,B){
		boot.E.E(boot.C.a).F(new boot.F(A,B,null,0));
	},
	// js.Application#show(js.Page)
	_G:function(A){
		if(A==null){
		}else{
			boot.E.B(boot.C.a,A.H());
			history.pushState("","","#"+A.H());
		}
	}
});

boot.define("BG",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.BG.a=new boot.V(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.BG.a.Bx(A);
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
		boot.BG.a.Bw(A,this);
	},
	// teemowork.model.Item#cost()
	DU:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	DQ:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	DV:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	DW:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	DX:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	DY:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	DZ:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	Du:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	Dv:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	Dw:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	Dx:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	Dy:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	Dz:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	EA:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	EB:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	DS:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	EC:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	ED:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	EE:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	EG:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	EH:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	EI:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	EJ:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	EK:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	EL:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	DR:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	EM:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	EO:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	EP:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	EQ:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	ER:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	ES:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	ET:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	EU:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	EV:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	EW:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	EX:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	EY:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_EZ:function(A){
		return boot.BG.a.Bx(A);
	},
	// teemowork.model.Item#getAll()
	_Bz:function(){
		return boot.BG.a.CA();
	}
});

boot.define("L",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.L.b=new boot.L(1510,2012,11,13,"Initial",null,0);
		boot.L.b.DP("Ruby Crystal").DQ(475).DR(180);
		boot.L.b.DP("Haunting Guise").DR(200).DS(25);
		boot.L.b.DT(boot.P.c).w(380,80).z(5.5,0.6).BC(230,50.0).BF(6.25,0.6).BI(50.0,3.0).BL(0.668,2.0).BO(10.0,3.5).BR(30.0,0).BT(550).BV(330);
		boot.L.b.DT(boot.P.d).w(445,85).z(7.25,0.65).BX(200).BZ(50).BI(53.0,3.2).BL(0.694,3.1).BO(16.5,3.5).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.e).w(442,102).z(7.25,0.85).BC(215,38.0).BF(6.45,0.45).BI(55.03,3.62).BL(0.625,3.62).BO(14.5,3.5).BR(30.0,1.25).BT(125).BV(325);
		boot.L.b.DT(boot.P.f).w(472,84).z(7.45,0.85).BC(220,40.0).BF(6.5,0.525).BI(47.0,3.8).BL(0.638,2.18).BO(18.0,3.3).BR(30.0,1.25).BT(125).BV(335);
		boot.L.b.DT(boot.P.g).w(350,70).z(4.65,0.55).BC(257,53.0).BF(7.0,0.6).BI(48.0,3.2).BL(0.625,1.68).BO(10.5,4.0).BR(30.0,0).BT(600).BV(325);
		boot.L.b.DT(boot.P.h).w(384,76).z(4.5,0.55).BC(250,50.0).BF(6.9,0.6).BI(49.0,2.625).BL(0.579,1.36).BO(12.5,4.0).BR(30.0,0).BT(625).BV(335);
		boot.L.b.DT(boot.P.i).w(395,79).z(4.5,0.55).BC(173,35.0).BF(6.3,0.4).BI(46.3,2.85).BL(0.658,3.34).BO(11.5,3.4).BR(30.0,0).BT(600).BV(325);
		boot.L.b.DT(boot.P.j).w(423,95).z(7.25,0.75).BC(260,40.0).BF(6.6,0.5).BI(55.66,3.5).BL(0.625,1.13).BO(14.5,3.5).BR(30.0,1.25).BT(125).BV(325);
		boot.L.b.DT(boot.P.k).w(380,76).z(4.5,0.55).BC(250,45.0).BF(7.0,0.6).BI(51.66,3.0).BL(0.625,1.36).BO(12.0,3.5).BR(30.0,0).BT(550).BV(340);
		boot.L.b.DT(boot.P.l).w(390,80).z(4.75,0.55).BC(255,35.0).BF(6.5,0.55).BI(47.0,3.0).BL(0.668,3.0).BO(13.0,3.5).BR(30.0,0).BT(650).BV(325);
		boot.L.b.DT(boot.P.m).w(380,75).z(4.85,0.5).BC(250,50.0).BF(7.1,0.75).BI(47.0,3.2).BL(0.644,1.68).BO(11.5,4.0).BR(30.0,0).BT(550).BV(335);
		boot.L.b.DT(boot.P.n).w(440,80).z(7.5,0.85).BC(205,40.0).BF(6.45,0.45).BI(54.1,4.2).BL(0.625,1.44).BO(19.0,3.5).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.o).w(375,82).z(4.5,0.55).BC(243,37.0).BF(6.5,0.55).BI(48.2,3.0).BL(0.658,2.3).BO(13.5,3.5).BR(30.0,0).BT(550).BV(325);
		boot.L.b.DT(boot.P.p).w(426,93).z(8.25,0.95).BC(200,37.5).BF(6.0,0.35).BI(50.0,3.5).BL(0.679,2.6).BO(20.0,3.5).BR(30.0,1.25).BT(125).BV(340);
		boot.L.b.DT(boot.P.ba).w(438,90).z(7.0,0.85).BC(230,40.0).BF(7.0,0.6).BI(48.0,3.0).BL(0.625,2.25).BO(16.0,3.6).BR(30.0,1.25).BT(150).BV(345);
		boot.L.b.DT(boot.P.bb).w(433,89).z(6.5,0.75).BI(56.23,3.0).BL(0.625,2.8).BO(17.0,3.5).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.bc).w(420,82).z(5.0,0.7).BC(240,42.0).BF(6.95,0.65).BI(46.5,3.5).BL(0.679,2.6).BO(16.0,3.3).BR(30.0,0).BT(550).BV(330);
		boot.L.b.DT(boot.P.bd).w(395,80).z(4.7,0.6).BC(240,50.0).BF(6.8,0.65).BI(47.5,3.0).BL(0.625,1.75).BO(12.65,3.35).BR(30.0,0).BT(550).BV(335);
		boot.L.b.DT(boot.P.be).w(414,86).z(6.95,0.55).BC(180,42.0).BF(7.1,0.6).BI(48.0,3.3).BL(0.658,3.84).BO(12.5,4.0).BR(30.0,1.25).BT(125).BV(340);
		boot.L.b.DT(boot.P.bf).w(350,80).z(5.5,0.55).BC(235,45.0).BF(7.0,0.65).BI(47.2,3.0).BL(0.665,2.8).BO(12.0,3.5).BR(30.0,0).BT(550).BV(330);
		boot.L.b.DT(boot.P.bg).w(390,80).z(4.6,0.6).BC(251,59.0).BF(6.9,0.65).BI(45.95,2.625).BL(0.625,2.11).BO(11.0,3.5).BR(30.0,0).BT(480).BV(335);
		boot.L.b.DT(boot.P.bh).w(450,85).z(6.3,0.8).BC(220,40.0).BF(7.25,0.5).BI(54.5,3.2).BL(0.672,3.0).BO(15.5,3.5).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.bi).w(414,86).z(7.0,0.7).BC(200,40.0).BF(6.15,0.45).BI(53.0,3.0).BL(0.658,3.1).BO(13.0,3.4).BR(30.0,1.25).BT(175).BV(335);
		boot.L.b.DT(boot.P.bj).w(435,85).z(7.45,0.75).BC(235,50.0).BF(7.0,0.7).BI(56.3,3.375).BL(0.638,1.2).BO(17.0,3.5).BR(30.0,0).BT(125).BV(335);
		boot.L.b.DT(boot.P.bk).w(495,81).z(425.0,0.75).BC(215,40.0).BF(6.5,0.7).BI(54.0,3.0).BL(0.651,2.75).BO(16.5,3.3).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.bl).w(455,96).z(7.5,0.75).BI(52.5,3.5).BL(0.625,2.9).BO(19.0,2.7).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.bm).w(434,89).z(7.25,0.85).BC(221,47.0).BF(6.45,0.45).BI(55.78,3.375).BL(0.651,2.05).BO(16.0,3.6).BR(30.0,0).BT(125).BV(340);
		boot.L.b.DT(boot.P.bn).w(410,84).z(5.5,0.7).BC(255,40.0).BF(6.75,0.7).BI(51.0,3.1).BL(0.625,2.9).BO(15.0,3.2).BR(30.0,0).BT(525).BV(330);
		boot.L.b.DT(boot.P.bo).w(440,95).z(8.0,0.75).BC(210,40.0).BF(6.5,0.6).BI(56.0,3.2).BL(0.67,2.5).BO(16.0,4.0).BR(30.0,1.25).BT(175).BV(345);
		boot.L.b.DT(boot.P.bp).w(350,75).z(4.5,0.55).BC(240,65.0).BF(7.0,0.65).BI(49.24,3.0).BL(0.625,1.21).BO(7.0,3.0).BR(30.0,0).BT(550).BV(325);
		boot.L.b.DT(boot.P.ca).w(456,90).z(7.5,0.65).BC(230,35.0).BF(7.0,0.65).BI(56.0,3.3).BL(0.665,3.2).BO(15.0,3.75).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.cb).w(356,78).z(4.5,0.55).BC(302,64.0).BF(6.9,0.6).BI(49.0,2.95).BL(0.625,2.61).BO(9.0,3.8).BR(30.0,0).BT(475).BV(335);
		boot.L.b.DT(boot.P.cc).w(420,90).z(7.0,0.7).BC(235,40.0).BF(6.0,0.45).BI(50.0,3.4).BL(0.658,2.5).BO(14.0,3.0).BR(30.0,1.25).BT(175).BV(340);
		boot.L.b.DT(boot.P.cd).w(463,98).z(7.45,0.55).BC(230,35.0).BF(6.4,0.7).BI(56.3,3.375).BL(0.638,3.4).BO(18.0,3.5).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.ce).w(420,90).z(6.0,0.8).BC(240,40.0).BF(7.0,0.7).BI(46.5,3.5).BL(0.658,3.0).BO(12.5,3.5).BR(30.0,0).BT(125).BV(335);
		boot.L.b.DT(boot.P.cf).w(410,86).z(4.7,0.55).BC(240,60.0).BF(6.8,0.65).BI(50.0,3.3).BL(0.625,2.3).BO(15.0,3.5).BR(30.0,0).BT(425).BV(335);
		boot.L.b.DT(boot.P.cg).w(390,75).z(5.5,0.55).BC(270,61.0).BF(6.5,0.6).BI(42.2,3.25).BL(0.625,2.11).BO(11.0,3.5).BR(30.0,0).BT(450).BV(335);
		boot.L.b.DT(boot.P.ch).w(433,78).z(6.95,0.5).BC(230,45.0).BF(6.9,0.6).BI(52.3,3.9).BL(0.638,3.7).BO(14.0,3.2).BR(30.0,1.25).BT(125).BV(340);
		boot.L.b.DT(boot.P.ci).w(395,83).z(6.95,0.55).BI(53.0,3.2).BL(0.658,2.74).BO(14.75,4.0).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.cj).w(418,93).z(7.0,0.75).BC(255,40.0).BF(6.9,0.525).BI(53.3,2.8).BL(0.638,2.5).BO(17.0,3.5).BR(30.0,0.75).BT(125).BV(335);
		boot.L.b.DT(boot.P.ck).w(403,79).z(4.65,0.65).BX(200).BZ(50).BI(51.3,3.3).BL(0.69,3.4).BO(14.0,3.75).BR(30.0,0).BT(550).BV(335);
		boot.L.b.DT(boot.P.cl).w(430,85).z(6.25,0.75).BC(260,40.0).BF(6.75,0.5).BI(50.0,3.1).BL(0.665,2.7).BO(15.0,3.0).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.cm).w(440,84).z(5.0,0.55).BC(295,40.0).BF(7.5,0.7).BI(46.0,3.0).BL(0.665,2.65).BO(13.0,3.53).BR(30.0,0).BT(500).BV(340);
		boot.L.b.DT(boot.P.cn).w(390,75).z(4.5,0.55).BC(250,50.0).BF(6.9,0.6).BI(51.0,3.1).BL(0.625,1.4).BO(12.0,3.5).BR(30.0,0).BT(525).BV(335);
		boot.L.b.DT(boot.P.co).w(428,85).z(6.25,61.0).BZ(200).BZ(50).BI(55.8,3.2).BL(0.651,3.0).BO(16.0,3.7).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.cp).w(430,87).z(9.0,0.85).BC(235,40.0).BF(8.0,0.7).BI(55.0,3.0).BL(0.625,2.9).BO(18.0,3.1).BR(30.0,1.25).BT(125).BV(335);
		boot.L.b.DT(boot.P.da).w(415,82).z(6.0,0.72).BC(200,50.0).BF(6.0,0.6).BI(44.4,2.6).BL(0.625,2.2).BO(9.0,3.7).BR(30.0,0).BT(550).BV(325);
		boot.L.b.DT(boot.P.db).w(345,79).z(4.5,0.55).BC(250,50.0).BF(6.0,0.6).BI(50.0,3.3).BL(0.625,1.36).BO(8.0,4.0).BR(30.0,0).BT(550).BV(340);
		boot.L.b.DT(boot.P.dc).w(423,90).z(7.45,0.55).BC(215,40.0).BF(6.4,0.55).BI(56.3,3.375).BL(0.638,3.4).BO(18.0,3.75).BR(30.0,1.25).BT(125).BV(335);
		boot.L.b.DT(boot.P.dd).w(380,80).z(4.5,0.55).BC(250,45.0).BF(7.0,0.6).BI(51.66,3.0).BL(0.625,1.36).BO(15.0,3.5).BR(30.0,0).BT(550).BV(340);
		boot.L.b.DT(boot.P.de).w(421,90).z(7.25,0.85).BC(250,46.0).BF(6.45,0.45).BI(58.0,3.3).BL(0.694,2.13).BO(18.0,4.0).BR(30.0,0).BT(125).BV(335);
		boot.L.b.DT(boot.P.df).w(444,86).z(6.75,0.65).BC(199,36.0).BF(6.5,0.45).BI(55.12,3.1).BL(0.679,2.98).BO(16.3,3.7).BR(30.0,1.25).BT(125).BV(355);
		boot.L.b.DT(boot.P.dg).w(435,85).z(5.1,0.65).BC(212,38.0).BF(6.95,0.65).BI(46.5,3.0).BL(0.658,3.01).BO(15.0,3.0).BR(30.0,0).BT(550).BV(325);
		boot.L.b.DT(boot.P.dh).w(421,80).z(7.45,0.55).BI(51.7,3.5).BL(0.694,3.0).BO(15.0,3.5).BR(30.0,1.25).BT(125).BV(340);
		boot.L.b.DT(boot.P.di).w(403,86).z(4.7,0.6).BC(240,60.0).BF(6.8,0.65).BI(51.58,3.5).BL(0.579,1.53).BO(15.0,3.8).BR(30.0,0).BT(425).BV(335);
		boot.L.b.DT(boot.P.dj).w(365,74).z(4.5,45.0).BC(305,43.0).BF(6.9,0.6).BI(48.0,3.1).BL(0.644,2.6).BO(9.0,4.0).BR(30.0,0).BT(550).BV(330);
		boot.L.b.DT(boot.P.dk).w(410,90).z(7.5,0.9).BC(200,45.0).BF(6.6,0.5).BI(53.3,3.5).BL(0.638,3.48).BO(15.0,3.5).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.dl).w(432,86).z(7.45,0.55).BC(200,50.0).BF(7.45,0.7).BI(52.0,3.3).BL(0.613,0.98).BO(12.0,3.25).BR(30.0,1.25).BT(175).BV(325);
		boot.L.b.DT(boot.P.dm).w(370,90).z(5.0,0.6).BC(220,45.0).BF(7.0,0.5).BI(49.0,3.5).BL(0.672,3.22).BO(11.0,3.5).BR(30.0,10.75).BT(525).BV(335);
		boot.L.b.DT(boot.P.dn).w(430,85).z(7.0,0.75).BC(215,35.0).BF(6.0,0.45).BI(54.0,3.1).BL(0.668,2.7).BO(17.0,3.5).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.dp).w(437,108).z(7.05,0.8).BC(213,42.0).BF(6.6,0.5).BI(51.6,3.4).BL(0.625,2.25).BO(16.5,3.5).BR(30.0,1.25).BT(125).BV(340);
		boot.L.b.DT(boot.P.ea).w(441,93).z(7.0,0.9).BC(225,45.0).BF(6.5,0.575).BI(54.1,3.5).BL(0.694,2.7).BO(17.0,3.0).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.eb).w(385,79).z(5.95,0.55).BC(250,50.0).BF(7.0,0.5).BI(44.0,2.6).BL(0.658,3.5).BO(8.0,3.0).BR(30.0,0).BT(525).BV(325);
		boot.L.b.DT(boot.P.ec).w(433,87).z(6.75,0.65).BC(210,34.0).BF(6.6,0.45).BI(50.7,2.9).BL(0.679,2.95).BO(17.1,3.9).BR(30.0,1.25).BT(155).BV(355);
		boot.L.b.DT(boot.P.ed).w(423,81).z(7.45,0.55).BC(185,30.0).BF(6.4,0.45).BI(56.3,3.375).BL(0.638,3.35).BO(18.0,4.0).BR(30.0,0).BT(125).BV(345);
		boot.L.b.DT(boot.P.ee).w(420,86).z(8.0,0.55).BC(255,33.0).BF(4.5,0.3).BI(50.0,3.5).BL(0.625,2.22).BO(21.0,3.8).BR(30.0,1.25).BT(125).BV(335);
		boot.L.b.DT(boot.P.ef).w(426,87).z(6.7,0.75).BI(53.12,3.1).BL(0.665,2.65).BO(15.2,3.8).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.eg).w(435,85).z(4.0,0.4).BI(55.0,3.0).BL(0.679,2.85).BO(16.0,3.5).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.eh).w(414,86).z(10.4,0.9).BI(54.0,2.75).BL(0.625,3.5).BO(15.0,3.1).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.ei).w(450,80).z(7.0,0.7).BI(55.32,3.2).BL(0.644,1.85).BO(16.0,3.5).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.ej).w(360,86).z(4.35,0.55).BC(250,55.0).BF(7.0,0.6).BI(52.0,3.0).BL(0.625,2.11).BO(11.0,3.9).BR(30.0,0).BT(550).BV(335);
		boot.L.b.DT(boot.P.ek).w(450,85).z(7.35,0.85).BC(220,40.0).BF(6.45,0.45).BI(54.0,3.4).BL(0.67,1.45).BO(20.5,3.5).BR(30.0,1.25).BT(125).BV(340);
		boot.L.b.DT(boot.P.el).w(441,84).z(7.45,0.55).BC(270,40.0).BF(6.4,0.45).BI(51.7,3.5).BL(0.694,3.0).BO(15.0,3.5).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.em).w(428,85).z(7.45,0.55).BX(200).BZ(50).BI(54.5,3.375).BL(0.651,3.4).BO(15.0,4.0).BR(30.0,0).BT(125).BV(335);
		boot.L.b.DT(boot.P.en).w(435,95).z(7.2,0.8).BI(54.5,3.4).BL(0.658,3.4).BO(17.6,3.4).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.eo).w(405,82).z(7.1,0.55).BC(215,45.0).BF(6.6,0.55).BI(56.65,3.375).BL(0.613,1.81).BO(18.0,3.5).BR(30.0,0).BT(125).BV(345);
		boot.L.b.DT(boot.P.ep).w(403,104).z(7.9,0.95).BC(240,40.0).BF(6.3,0.4).BI(55.52,3.1875).BL(0.625,1.63).BO(17.75,3.25).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.fa).w(378,82).z(4.25,0.55).BC(203,43.0).BF(6.5,0.5).BI(49.0,2.9).BL(0.658,3.28).BO(12.75,3.25).BR(30.0,0).BT(500).BV(335);
		boot.L.b.DT(boot.P.fb).w(440,96).z(7.5,0.85).BC(205,40.0).BF(6.45,0.45).BI(54.1,4.2).BL(0.625,2.1).BO(19.0,3.8).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.fc).w(340,70).z(4.5,0.55).BC(265,45.0).BF(7.0,0.65).BI(47.0,3.0).BL(0.644,2.3).BO(6.0,3.3).BR(30.0,0).BT(550).BV(330);
		boot.L.b.DT(boot.P.fd).w(375,71).z(4.5,0.55).BC(240,60.0).BF(6.8,0.65).BI(48.8,3.0).BL(0.625,2.14).BO(7.4,3.8).BR(30.0,0).BT(550).BV(335);
		boot.L.b.DT(boot.P.fe).w(385,78).z(6.75,0.65).BC(240,50.0).BF(6.8,0.65).BI(49.0,3.0).BL(0.625,2.11).BO(12.0,4.0).BR(30.0,0).BT(500).BV(335);
		boot.L.b.DT(boot.P.ff).w(380,78).z(5.5,0.6).BC(250,50.0).BF(6.9,0.6).BI(51.0,2.9).BL(0.625,2.0).BO(15.0,3.4).BR(30.0,0).BT(550).BV(330);
		boot.L.b.DT(boot.P.fg).w(440,85).z(7.25,0.75).BC(260,40.0).BF(6.75,0.5).BI(50.0,3.1).BL(0.668,2.7).BO(17.0,3.5).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.fh).w(468,90).z(7.1,0.5).BC(255,56.0).BF(4.1,0.4).BI(58.0,3.5).BL(0.625,2.02).BO(16.5,3.2).BR(30.0,1.25).BT(125).BV(340);
		boot.L.b.DT(boot.P.fi).w(383,82).z(4.65,0.65).BC(200,40.0).BF(6.45,0.45).BI(44.5,3.0).BL(0.69,3.38).BO(14.0,3.75).BR(30.0,0).BT(500).BV(330);
		boot.L.b.DT(boot.P.fj).w(415,82).z(5.1,0.65).BC(193,32.0).BF(6.45,0.45).BI(46.5,3.0).BL(0.658,3.01).BO(15.0,3.0).BR(30.0,0).BT(550).BV(325);
		boot.L.b.DT(boot.P.fk).w(455,96).z(8.0,0.85).BC(206,45.0).BF(6.9,0.6).BI(54.66,3.0).BL(0.672,2.9).BO(19.0,2.7).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.fl).w(461,98).z(7.9,0.9).BI(56.0,3.2).BL(0.644,2.9).BO(14.9,3.1).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.fm).w(384,82).z(4.5,0.6).BC(202,38.0).BF(6.5,0.5).BI(46.61,3.3).BL(0.651,3.22).BO(111.25,3.15).BR(30.0,0).BT(525).BV(330);
		boot.L.b.DT(boot.P.fn).w(389,81).z(5.0,0.6).BC(220,40.0).BF(6.5,0.45).BI(49.0,3.0).BL(0.679,3.38).BO(14.0,3.0).BR(30.0,0).BT(550).BV(330);
		boot.L.b.DT(boot.P.fo).w(427,99).z(7.45,0.75).BC(220,30.0).BF(6.4,0.45).BI(52.91,3.2).BL(0.658,2.67).BO(14.75,4.0).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.fp).w(437,89).z(5.5,0.6).BC(220,55.0).BF(7.5,0.65).BI(48.0,3.6).BL(0.644,2.9).BO(15.0,3.3).BR(30.0,0).BT(425).BV(335);
		boot.L.b.DT(boot.P.ga).w(400,82).z(4.5,0.55).BC(250,36.0).BF(6.5,0.5).BI(46.0,3.0).BL(0.658,2.65).BO(13.5,3.4).BR(30.0,0).BT(575).BV(335);
		boot.L.b.DT(boot.P.gb).w(359,83).z(4.5,0.55).BC(173,27.0).BF(6.3,0.4).BI(50.0,3.25).BL(0.658,3.1).BO(9.3,3.4).BR(30.0,0).BT(550).BV(330);
		boot.L.b.DT(boot.P.gc).w(355,82).z(4.5,0.55).BC(250,55.0).BF(6.9,0.6).BI(48.3,2.625).BL(0.625,2.24).BO(12.25,3.75).BR(30.0,0).BT(525).BV(340);
		boot.L.b.DT(boot.P.gd).w(440,85).z(7.5,0.9).BC(220,45.0).BF(7.0,0.65).BI(55.0,3.5).BL(0.643,2.5).BO(16.0,3.5).BR(30.0,1.25).BT(125).BV(350);
		boot.L.b.DT(boot.P.ge).w(385,78).z(6.75,0.65).BC(240,50.0).BF(6.9,0.45).BI(49.0,3.0).BL(0.625,2.11).BO(12.0,4.0).BR(30.0,0).BT(525).BV(335);
		boot.L.b.DT(boot.P.gf).w(400,85).z(6.0,0.6).BI(45.0,3.0).BL(0.6258,2.0).BO(12.0,3.5).BR(30.0,0).BT(450).BV(335);
		boot.L.b.DT(boot.P.gg).w(440,86).z(7.0,0.65).BC(220,30.0).BF(7.0,0.65).BI(54.0,3.3).BL(0.625,2.9).BO(16.5,3.5).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.gh).w(428,98).z(7.05,0.8).BC(190,30.0).BF(7.1,0.6).BI(56.76,3.375).BL(0.679,2.88).BO(16.0,3.5).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.gi).w(435,85).z(5.1,0.65).BC(202,38.0).BF(6.9,0.65).BI(54.0,3.2).BL(0.658,3.0).BO(15.0,3.5).BR(30.0,1.25).BT(175).BV(345);
		boot.L.b.DT(boot.P.gj).w(380,80).z(5.0,0.55).BC(250,45.0).BF(8.0,0.6).BI(52.0,3.0).BL(0.625,1.36).BO(12.6,3.4).BR(30.0,0).BT(550).BV(340);
		boot.L.b.DT(boot.P.gk).w(445,87).z(7.0,0.7).BC(213,31.0).BF(6.6,0.45).BI(52.0,3.3).BL(0.672,2.7).BO(16.2,3.7).BR(30.0,1.25).BT(175).BV(345);
		boot.L.b.DT(boot.P.gl).w(421,85).z(8.5,0.7).BC(235,35.0).BF(6.5,0.45).BI(51.5,3.5).BL(0.625,3.0).BO(18.0,3.6).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.gm).w(445,85).z(6.0,0.65).BX(20).BZ(50).BI(48.6,3.4).BL(0.658,3.1).BO(17.5,3.5).BR(30.0,1.25).BT(125).BV(345);
		boot.L.b.DT(boot.P.gn).w(390,80).z(5.25,0.6).BC(250,50.0).BF(6.75,0.6).BI(54.0,3.1).BL(0.656,1.7).BO(12.0,3.3).BR(30.0,0).BT(575).BV(330);
		boot.L.b.DT(boot.P.go).w(380,71).z(4.6,0.5).BC(260,60.0).BF(6.95,0.65).BI(48.6,3.0).BL(0.625,2.13).BO(6.75,3.8).BR(30.0,0).BT(600).BV(335);
		boot.L.b.DT(boot.P.gp).w(355,74).z(4.85,0.5).BC(250,50.0).BF(7.1,0.75).BI(50.0,3.2).BL(0.625,1.8).BO(11.0,3.0).BR(30.0,0).BT(575).BV(325);
		boot.L.c=new boot.L(1520,2012,12,3,"Preseason 3",boot.L.b,0);
		boot.L.c.DP("Shard of True Ice");
		boot.L.c.DP("Liandry's Torment");
		boot.L.c.DP("Haunting Guise");
		boot.L.a=boot.L.c;
	},
	// teemowork.model.Patch#<init>(int, int, int, int, java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C,D,E,F){
		this.d=new boot.V(0);
		this.e=new boot.V(0);
		this.f=A;
		this.g=E;
		this.h=F;
	},
	// teemowork.model.Patch#updateItem(java.lang.String)
	DP:function(A,B){
		B=new boot.BG(A,this,0);
		this.e.Bw(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	DT:function(A){
		A.hb=new boot.T(this,A.hb,0);
		return A.hb;
	}
});

boot.define("BL",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.Ez(this.b);
	}
});

boot.define("BK",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BI.Ey(this.a).CM().M();
		l2:while (D.N()!=0) {
			C=D.Q();
			if(this.a.Ex(C.CN()).toLowerCase().indexOf(B) != -1==0){
				C.CH().addClass("o");
				continue l2;
			}else{
				C.CH().removeClass("o");
				continue l2;
			}
		}
	}
});

boot.define("BJ",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BJ.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BI",boot.BJ,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BJ.prototype.$0.call(this);
		this.b=new boot.V(0);
		this.c=this.Ev();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	Eu:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("l").css("display","block");
		B.keyup(new boot.BK(this,B,0));
		D=this.c.M();
		l6:for (;
		D.N()!=0;
		this.b.Bw(C,E)) {
			C=D.Q();
			E=this.a.L("m").css("background-image","url("+this.Ew(C)+")");
			E.K("span").addClass("n").text(this.Ex(C));
			E.click(new boot.BL(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_Ey:function(A){
		return A.b;
	}
});

boot.define("BH",boot.BI,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BI.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	Ev:function(){
		return boot.P.Bz();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	FA:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	FB:function(A){
		return A.U();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	FC:function(A){
		boot.C.G(new boot.H(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	Ex:function(A){
		return this.FA(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	Ew:function(A){
		return this.FB(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	Ez:function(A){
		this.FC(A);
	}
});

boot.define("I",boot.G,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.G.prototype.$0.call(this);
		this.a=new boot.BH(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	S:function(A){
		this.a.Eu(A);
	},
	// teemowork.ChampionSelect#getPageId()
	H:function(){
		return "";
	}
});

boot.define("B",boot.C,{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B,C){
		this.D("Champion/*",boot.H);
		this.D("",boot.I);
		boot.C.prototype.A.call(this);
		$("body").css("padding","0px 10%");
		A=new boot.J(0);
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
		console.log(boot.L.a);
		C=boot.B;
		console.log(C);
	},
	// teemowork.Teemowork#test()
	J:function(){
		console.log("called");
	}
});

try {new boot.B(0).A();} catch(e) {console.log(e)}