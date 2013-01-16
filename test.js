boot.define("A",{
	
	// booton.translator.Javascript$ClassReplacement#<init>()
	$0:function(){
	},
	// booton.translator.Javascript$ClassReplacement#isAnnotationPresent(java.lang.Class)
	L:function(A){
		return false;
	},
	// booton.translator.Javascript$ClassReplacement#getName()
	J:function(){
		return "aaa";
	}
});

boot.define("O",{
	
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
	y:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	z:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	R:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	BA:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	BB:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	S:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	BC:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	BD:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	T:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	BE:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	BF:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	U:function(A,B,C,D){
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
	V:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	BI:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	BJ:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	W:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	BK:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	BL:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	X:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	BM:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	BN:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	Y:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	BO:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	Z:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	BP:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	u:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	BQ:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	v:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	BR:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	w:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	BS:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	BT:function(A){
		return this.g+this.h*A;
	}
});

boot.define("R",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	CM:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CG:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	CQ:function(A,B){
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
		boot.R.prototype.$1.call(this,A,B);
	}
});

boot.define("V",{
	
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.a=A;;
		this.b=B;
		this.c=C;
	},
	// js.util.HashMap$View#hasNext()
	CE:function(){
		return this.b.CE();
	},
	// js.util.HashMap$View#next()
	CD:function(A){
		A=this.b.CD();
		if(this.c==0){
			return A.CG();
		}else{
			return A.CM();
		}
	},
	// js.util.HashMap$View#remove()
	CY:function(){
		this.b.CY();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.V.prototype.$1.call(this,A,B,C);
	}
});

boot.define("U",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	Bx:function(){
		return this.Bw()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	CR:function(A,B,C,D){
		B=0;
		D=A.CC();
		l2:while (D.CE()!=0) {
			C=D.CD();
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
		D=this.CC();
		l2:while (D.CE()!=0) {
			C=D.CD();
			if(A.CA(C)!=0){
			}else{
				B=this.CT(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	CU:function(A,B,C,D){
		B=0;
		D=A.CC();
		l2:while (D.CE()!=0) {
			C=D.CD();
			if(this.CT(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	CV:function(A,B,C){
		C=A.CC();
		l1:while (C.CE()!=0) {
			B=C.CD();
			if(this.CA(B)!=0){
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
		B=this.Bw();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.CC();
		D=0;
		l6:while (C.CE()!=0) {
			E=C.CD();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("X",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	CE:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	CD:function(){
		this.d=boot.Q.Cu(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	CY:function(){
		if(this.b<=0){
		}else{
			this.a.CT(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.X.prototype.$1.call(this,A,B);
	}
});

boot.define("W",boot.U,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.U.prototype.$0.call(this);
	}
});

boot.define("Q",boot.W,{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.W.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	Bw:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	CA:function(A){
		return this.CZ(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.CZ(A);
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
		B=this.CZ(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	CN:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	CC:function(){
		return new boot.X(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	CZ:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CF:function(A){
		return this.b[this.CZ(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CH:function(A,B,C){
		B=null;
		C=this.CZ(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	CJ:function(A,B,C){
		B=null;
		C=this.CZ(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_Cu:function(A){
		return A.b;
	}
});

boot.define("T",boot.U,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.U.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	Bw:function(){
		return boot.P.CP(this.a).Bw();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	CA:function(A){
		return this.a.CB(A);
	},
	// js.util.HashMap$Values#iterator()
	CC:function(){
		return new boot.V(this.a,boot.P.CP(this.a).CC(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	CT:function(A,B,C){
		B=this.CC();
		l2:while (B.CE()!=0) {
			C=B.CD();
			if(C!=A){
			}else{
				B.CY();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	CN:function(){
		boot.P.CP(this.a).CN();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.T.prototype.$1.call(this,A);
	}
});

boot.define("S",boot.W,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.W.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	Bw:function(){
		return boot.P.CP(this.a).Bw();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	CA:function(A){
		return boot.P.CP(this.a).CA(A);
	},
	// js.util.HashMap$Keys#iterator()
	CC:function(){
		return new boot.V(this.a,boot.P.CP(this.a).CC(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	CT:function(A){
		return boot.P.CP(this.a).CT(A);
	},
	// js.util.HashMap$Keys#clear()
	CN:function(){
		boot.P.CP(this.a).CN();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.S.prototype.$1.call(this,A);
	}
});

boot.define("P",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.Q(0);
	},
	// js.util.HashMap#size()
	Bw:function(){
		return this.a.Bw();
	},
	// js.util.HashMap#isEmpty()
	Bx:function(){
		return this.a.Bx();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	Bz:function(A){
		return this.a.CA(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CB:function(A,B,C){
		C=this.Bv().CC();
		l1:while (C.CE()!=0) {
			B=C.CD();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	BZ:function(A,B){
		B=this.a.CF(A);
		return (B==null?null:B.CG());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	x:function(A,B,C){
		C=this.a.CH(new boot.R(A,B,null,0));
		if(C!=null){
			return C.CG();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	CI:function(A,B){
		B=this.a.CJ(A);
		if(B!=null){
			return B.CG();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	CK:function(A,B,C){
		C=A.CL().CC();
		l1:for (;
		C.CE()!=0;
		this.x(B.CM(),B.CG())) {
			B=C.CD();
		}
	},
	// js.util.HashMap#clear()
	CN:function(){
		this.a.CN();
	},
	// js.util.HashMap#keySet()
	CO:function(){
		return new boot.S(this,null,0);
	},
	// js.util.HashMap#values()
	Bv:function(){
		return new boot.T(this,null,0);
	},
	// js.util.HashMap#entrySet()
	CL:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_CP:function(A){
		return A.a;
	}
});

boot.define("N",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.N.gp=new boot.P(0);
		boot.N.a=new boot.N("Ahri",0);
		boot.N.b=new boot.N("Akali",0);
		boot.N.c=new boot.N("Alistar",0);
		boot.N.d=new boot.N("Amumu",0);
		boot.N.e=new boot.N("Anivia",0);
		boot.N.f=new boot.N("Annie",0);
		boot.N.g=new boot.N("Ashe",0);
		boot.N.h=new boot.N("Blitzcrank",0);
		boot.N.i=new boot.N("Brand",0);
		boot.N.j=new boot.N("Caitlyn",0);
		boot.N.k=new boot.N("Cassiopeia",0);
		boot.N.l=new boot.N("Chogath",0);
		boot.N.m=new boot.N("Corki",0);
		boot.N.n=new boot.N("Darius",0);
		boot.N.o=new boot.N("Diana",0);
		boot.N.p=new boot.N("Dr.Mundo",0);
		boot.N.ba=new boot.N("Draven",0);
		boot.N.bb=new boot.N("Elise",0);
		boot.N.bc=new boot.N("Evelynn",0);
		boot.N.bd=new boot.N("Ezreal",0);
		boot.N.be=new boot.N("Fiddlesticks",0);
		boot.N.bf=new boot.N("Fiora",0);
		boot.N.bg=new boot.N("Fizz",0);
		boot.N.bh=new boot.N("Galio",0);
		boot.N.bi=new boot.N("Gangplank",0);
		boot.N.bj=new boot.N("Garen",0);
		boot.N.bk=new boot.N("Gragas",0);
		boot.N.bl=new boot.N("Graves",0);
		boot.N.bm=new boot.N("Hecarim",0);
		boot.N.bn=new boot.N("Heimerdinger",0);
		boot.N.bo=new boot.N("Irelia",0);
		boot.N.bp=new boot.N("Janna",0);
		boot.N.ca=new boot.N("Jarvan IV",0);
		boot.N.cb=new boot.N("Jax",0);
		boot.N.cc=new boot.N("Jayce",0);
		boot.N.cd=new boot.N("Karma",0);
		boot.N.ce=new boot.N("Karthus",0);
		boot.N.cf=new boot.N("Kassadin",0);
		boot.N.cg=new boot.N("Katarina",0);
		boot.N.ch=new boot.N("Kayle",0);
		boot.N.ci=new boot.N("Kennen",0);
		boot.N.cj=new boot.N("Kha'zix",0);
		boot.N.ck=new boot.N("Kog'maw",0);
		boot.N.cl=new boot.N("LeBlanc",0);
		boot.N.cm=new boot.N("Lee Sin",0);
		boot.N.cn=new boot.N("Leona",0);
		boot.N.co=new boot.N("Lulu",0);
		boot.N.cp=new boot.N("Lux",0);
		boot.N.da=new boot.N("Malphite",0);
		boot.N.db=new boot.N("Malzahar",0);
		boot.N.dc=new boot.N("Maokai",0);
		boot.N.dd=new boot.N("Master Yi",0);
		boot.N.de=new boot.N("Miss Fortune",0);
		boot.N.df=new boot.N("Mordekaiser",0);
		boot.N.dg=new boot.N("Morgana",0);
		boot.N.dh=new boot.N("Nami",0);
		boot.N.di=new boot.N("Nasus",0);
		boot.N.dj=new boot.N("Nautilus",0);
		boot.N.dk=new boot.N("Nidalee",0);
		boot.N.dl=new boot.N("Nocturne",0);
		boot.N.dm=new boot.N("Nunu",0);
		boot.N.dn=new boot.N("Olaf",0);
		boot.N.dp=new boot.N("Orianna",0);
		boot.N.ea=new boot.N("Pantheon",0);
		boot.N.eb=new boot.N("Poppy",0);
		boot.N.ec=new boot.N("Rammus",0);
		boot.N.ed=new boot.N("Renekton",0);
		boot.N.ee=new boot.N("Rengar",0);
		boot.N.ef=new boot.N("Riven",0);
		boot.N.eg=new boot.N("Rumble",0);
		boot.N.eh=new boot.N("Ryze",0);
		boot.N.ei=new boot.N("Sejuani",0);
		boot.N.ej=new boot.N("Shaco",0);
		boot.N.ek=new boot.N("Shen",0);
		boot.N.el=new boot.N("Shyvana",0);
		boot.N.em=new boot.N("Singed",0);
		boot.N.en=new boot.N("Sion",0);
		boot.N.eo=new boot.N("Sivir",0);
		boot.N.ep=new boot.N("Skarner",0);
		boot.N.fa=new boot.N("Sona",0);
		boot.N.fb=new boot.N("Soraka",0);
		boot.N.fc=new boot.N("Swain",0);
		boot.N.fd=new boot.N("Syndra",0);
		boot.N.fe=new boot.N("Talon",0);
		boot.N.ff=new boot.N("Taric",0);
		boot.N.fg=new boot.N("Teemo",0);
		boot.N.fh=new boot.N("Tristana",0);
		boot.N.fi=new boot.N("Trundle",0);
		boot.N.fj=new boot.N("Tryndamere",0);
		boot.N.fk=new boot.N("Twisted Fate",0);
		boot.N.fl=new boot.N("Twitch",0);
		boot.N.fm=new boot.N("Udyr",0);
		boot.N.fn=new boot.N("Urgot",0);
		boot.N.fo=new boot.N("Varus",0);
		boot.N.fp=new boot.N("Vayne",0);
		boot.N.ga=new boot.N("Veigar",0);
		boot.N.gb=new boot.N("Vi",0);
		boot.N.gc=new boot.N("Viktor",0);
		boot.N.gd=new boot.N("Vladimir",0);
		boot.N.ge=new boot.N("Volibear",0);
		boot.N.gf=new boot.N("Warwick",0);
		boot.N.gg=new boot.N("Wukong",0);
		boot.N.gh=new boot.N("Xerath",0);
		boot.N.gi=new boot.N("Xin Zhao",0);
		boot.N.gj=new boot.N("Yorick",0);
		boot.N.gk=new boot.N("Zed",0);
		boot.N.gl=new boot.N("Ziggs",0);
		boot.N.gm=new boot.N("Zilean",0);
		boot.N.gn=new boot.N("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.ha=A;
		this.hb=this.BU().toLowerCase();
		boot.N.gp.x(A,this);
	},
	// teemowork.model.Champion#getStatus()
	BV:function(){
		return this.go;
	},
	// teemowork.model.Champion#getSystemName()
	BU:function(){
		return this.ha.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	BW:function(){
		return "src/main/resources/teemowork/splash/"+this.BU()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	BX:function(){
		return "src/main/resources/teemowork/icon/"+this.BU()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_BY:function(A){
		return boot.N.gp.BZ(A);
	},
	// teemowork.model.Champion#getAll()
	_Bu:function(){
		return boot.N.gp.Bv();
	}
});

boot.define("M",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.M.a=new boot.P(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.M.a.BZ(A);
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
		boot.M.a.x(A,this);
	},
	// teemowork.model.Item#cost()
	Cv:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	N:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	Cw:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	Cx:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	Cy:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	Cz:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	DA:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	DB:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	DC:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	DD:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	DE:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	DF:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	DG:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	DH:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	DI:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	P:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	DJ:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	DK:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	DL:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	DM:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	DN:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	DO:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	DP:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	DQ:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	DR:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	O:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	DS:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	DT:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	DU:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	DV:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	DW:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	DX:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	DY:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	DZ:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	Du:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	Dv:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	Dw:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	Dx:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_Dy:function(A){
		return boot.M.a.BZ(A);
	},
	// teemowork.model.Item#getAll()
	_Bu:function(){
		return boot.M.a.Bv();
	}
});

boot.define("L",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.L.b=new boot.L(1510,2012,11,13,"Initial",null,0);
		boot.L.b.M("Ruby Crystal").N(475).O(180);
		boot.L.b.M("Haunting Guise").O(200).P(25);
		boot.L.b.Q(boot.N.a).R(380,80).S(5.5,0.6).T(230,50.0).U(6.25,0.6).V(50.0,3.0).W(0.668,2.0).X(10.0,3.5).Y(30.0,0).Z(550).u(330);
		boot.L.b.Q(boot.N.b).R(445,85).S(7.25,0.65).v(200).w(50).V(53.0,3.2).W(0.694,3.1).X(16.5,3.5).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.c).R(442,102).S(7.25,0.85).T(215,38.0).U(6.45,0.45).V(55.03,3.62).W(0.625,3.62).X(14.5,3.5).Y(30.0,1.25).Z(125).u(325);
		boot.L.b.Q(boot.N.d).R(472,84).S(7.45,0.85).T(220,40.0).U(6.5,0.525).V(47.0,3.8).W(0.638,2.18).X(18.0,3.3).Y(30.0,1.25).Z(125).u(335);
		boot.L.b.Q(boot.N.e).R(350,70).S(4.65,0.55).T(257,53.0).U(7.0,0.6).V(48.0,3.2).W(0.625,1.68).X(10.5,4.0).Y(30.0,0).Z(600).u(325);
		boot.L.b.Q(boot.N.f).R(384,76).S(4.5,0.55).T(250,50.0).U(6.9,0.6).V(49.0,2.625).W(0.579,1.36).X(12.5,4.0).Y(30.0,0).Z(625).u(335);
		boot.L.b.Q(boot.N.g).R(395,79).S(4.5,0.55).T(173,35.0).U(6.3,0.4).V(46.3,2.85).W(0.658,3.34).X(11.5,3.4).Y(30.0,0).Z(600).u(325);
		boot.L.b.Q(boot.N.h).R(423,95).S(7.25,0.75).T(260,40.0).U(6.6,0.5).V(55.66,3.5).W(0.625,1.13).X(14.5,3.5).Y(30.0,1.25).Z(125).u(325);
		boot.L.b.Q(boot.N.i).R(380,76).S(4.5,0.55).T(250,45.0).U(7.0,0.6).V(51.66,3.0).W(0.625,1.36).X(12.0,3.5).Y(30.0,0).Z(550).u(340);
		boot.L.b.Q(boot.N.j).R(390,80).S(4.75,0.55).T(255,35.0).U(6.5,0.55).V(47.0,3.0).W(0.668,3.0).X(13.0,3.5).Y(30.0,0).Z(650).u(325);
		boot.L.b.Q(boot.N.k).R(380,75).S(4.85,0.5).T(250,50.0).U(7.1,0.75).V(47.0,3.2).W(0.644,1.68).X(11.5,4.0).Y(30.0,0).Z(550).u(335);
		boot.L.b.Q(boot.N.l).R(440,80).S(7.5,0.85).T(205,40.0).U(6.45,0.45).V(54.1,4.2).W(0.625,1.44).X(19.0,3.5).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.m).R(375,82).S(4.5,0.55).T(243,37.0).U(6.5,0.55).V(48.2,3.0).W(0.658,2.3).X(13.5,3.5).Y(30.0,0).Z(550).u(325);
		boot.L.b.Q(boot.N.n).R(426,93).S(8.25,0.95).T(200,37.5).U(6.0,0.35).V(50.0,3.5).W(0.679,2.6).X(20.0,3.5).Y(30.0,1.25).Z(125).u(340);
		boot.L.b.Q(boot.N.o).R(438,90).S(7.0,0.85).T(230,40.0).U(7.0,0.6).V(48.0,3.0).W(0.625,2.25).X(16.0,3.6).Y(30.0,1.25).Z(150).u(345);
		boot.L.b.Q(boot.N.p).R(433,89).S(6.5,0.75).V(56.23,3.0).W(0.625,2.8).X(17.0,3.5).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.ba).R(420,82).S(5.0,0.7).T(240,42.0).U(6.95,0.65).V(46.5,3.5).W(0.679,2.6).X(16.0,3.3).Y(30.0,0).Z(550).u(330);
		boot.L.b.Q(boot.N.bb).R(395,80).S(4.7,0.6).T(240,50.0).U(6.8,0.65).V(47.5,3.0).W(0.625,1.75).X(12.65,3.35).Y(30.0,0).Z(550).u(335);
		boot.L.b.Q(boot.N.bc).R(414,86).S(6.95,0.55).T(180,42.0).U(7.1,0.6).V(48.0,3.3).W(0.658,3.84).X(12.5,4.0).Y(30.0,1.25).Z(125).u(340);
		boot.L.b.Q(boot.N.bd).R(350,80).S(5.5,0.55).T(235,45.0).U(7.0,0.65).V(47.2,3.0).W(0.665,2.8).X(12.0,3.5).Y(30.0,0).Z(550).u(330);
		boot.L.b.Q(boot.N.be).R(390,80).S(4.6,0.6).T(251,59.0).U(6.9,0.65).V(45.95,2.625).W(0.625,2.11).X(11.0,3.5).Y(30.0,0).Z(480).u(335);
		boot.L.b.Q(boot.N.bf).R(450,85).S(6.3,0.8).T(220,40.0).U(7.25,0.5).V(54.5,3.2).W(0.672,3.0).X(15.5,3.5).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.bg).R(414,86).S(7.0,0.7).T(200,40.0).U(6.15,0.45).V(53.0,3.0).W(0.658,3.1).X(13.0,3.4).Y(30.0,1.25).Z(175).u(335);
		boot.L.b.Q(boot.N.bh).R(435,85).S(7.45,0.75).T(235,50.0).U(7.0,0.7).V(56.3,3.375).W(0.638,1.2).X(17.0,3.5).Y(30.0,0).Z(125).u(335);
		boot.L.b.Q(boot.N.bi).R(495,81).S(425.0,0.75).T(215,40.0).U(6.5,0.7).V(54.0,3.0).W(0.651,2.75).X(16.5,3.3).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.bj).R(455,96).S(7.5,0.75).V(52.5,3.5).W(0.625,2.9).X(19.0,2.7).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.bk).R(434,89).S(7.25,0.85).T(221,47.0).U(6.45,0.45).V(55.78,3.375).W(0.651,2.05).X(16.0,3.6).Y(30.0,0).Z(125).u(340);
		boot.L.b.Q(boot.N.bl).R(410,84).S(5.5,0.7).T(255,40.0).U(6.75,0.7).V(51.0,3.1).W(0.625,2.9).X(15.0,3.2).Y(30.0,0).Z(525).u(330);
		boot.L.b.Q(boot.N.bm).R(440,95).S(8.0,0.75).T(210,40.0).U(6.5,0.6).V(56.0,3.2).W(0.67,2.5).X(16.0,4.0).Y(30.0,1.25).Z(175).u(345);
		boot.L.b.Q(boot.N.bn).R(350,75).S(4.5,0.55).T(240,65.0).U(7.0,0.65).V(49.24,3.0).W(0.625,1.21).X(7.0,3.0).Y(30.0,0).Z(550).u(325);
		boot.L.b.Q(boot.N.bo).R(456,90).S(7.5,0.65).T(230,35.0).U(7.0,0.65).V(56.0,3.3).W(0.665,3.2).X(15.0,3.75).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.bp).R(356,78).S(4.5,0.55).T(302,64.0).U(6.9,0.6).V(49.0,2.95).W(0.625,2.61).X(9.0,3.8).Y(30.0,0).Z(475).u(335);
		boot.L.b.Q(boot.N.ca).R(420,90).S(7.0,0.7).T(235,40.0).U(6.0,0.45).V(50.0,3.4).W(0.658,2.5).X(14.0,3.0).Y(30.0,1.25).Z(175).u(340);
		boot.L.b.Q(boot.N.cb).R(463,98).S(7.45,0.55).T(230,35.0).U(6.4,0.7).V(56.3,3.375).W(0.638,3.4).X(18.0,3.5).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.cc).R(420,90).S(6.0,0.8).T(240,40.0).U(7.0,0.7).V(46.5,3.5).W(0.658,3.0).X(12.5,3.5).Y(30.0,0).Z(125).u(335);
		boot.L.b.Q(boot.N.cd).R(410,86).S(4.7,0.55).T(240,60.0).U(6.8,0.65).V(50.0,3.3).W(0.625,2.3).X(15.0,3.5).Y(30.0,0).Z(425).u(335);
		boot.L.b.Q(boot.N.ce).R(390,75).S(5.5,0.55).T(270,61.0).U(6.5,0.6).V(42.2,3.25).W(0.625,2.11).X(11.0,3.5).Y(30.0,0).Z(450).u(335);
		boot.L.b.Q(boot.N.cf).R(433,78).S(6.95,0.5).T(230,45.0).U(6.9,0.6).V(52.3,3.9).W(0.638,3.7).X(14.0,3.2).Y(30.0,1.25).Z(125).u(340);
		boot.L.b.Q(boot.N.cg).R(395,83).S(6.95,0.55).V(53.0,3.2).W(0.658,2.74).X(14.75,4.0).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.ch).R(418,93).S(7.0,0.75).T(255,40.0).U(6.9,0.525).V(53.3,2.8).W(0.638,2.5).X(17.0,3.5).Y(30.0,0.75).Z(125).u(335);
		boot.L.b.Q(boot.N.ci).R(403,79).S(4.65,0.65).v(200).w(50).V(51.3,3.3).W(0.69,3.4).X(14.0,3.75).Y(30.0,0).Z(550).u(335);
		boot.L.b.Q(boot.N.cj).R(430,85).S(6.25,0.75).T(260,40.0).U(6.75,0.5).V(50.0,3.1).W(0.665,2.7).X(15.0,3.0).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.ck).R(440,84).S(5.0,0.55).T(295,40.0).U(7.5,0.7).V(46.0,3.0).W(0.665,2.65).X(13.0,3.53).Y(30.0,0).Z(500).u(340);
		boot.L.b.Q(boot.N.cl).R(390,75).S(4.5,0.55).T(250,50.0).U(6.9,0.6).V(51.0,3.1).W(0.625,1.4).X(12.0,3.5).Y(30.0,0).Z(525).u(335);
		boot.L.b.Q(boot.N.cm).R(428,85).S(6.25,61.0).w(200).w(50).V(55.8,3.2).W(0.651,3.0).X(16.0,3.7).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.cn).R(430,87).S(9.0,0.85).T(235,40.0).U(8.0,0.7).V(55.0,3.0).W(0.625,2.9).X(18.0,3.1).Y(30.0,1.25).Z(125).u(335);
		boot.L.b.Q(boot.N.co).R(415,82).S(6.0,0.72).T(200,50.0).U(6.0,0.6).V(44.4,2.6).W(0.625,2.2).X(9.0,3.7).Y(30.0,0).Z(550).u(325);
		boot.L.b.Q(boot.N.cp).R(345,79).S(4.5,0.55).T(250,50.0).U(6.0,0.6).V(50.0,3.3).W(0.625,1.36).X(8.0,4.0).Y(30.0,0).Z(550).u(340);
		boot.L.b.Q(boot.N.da).R(423,90).S(7.45,0.55).T(215,40.0).U(6.4,0.55).V(56.3,3.375).W(0.638,3.4).X(18.0,3.75).Y(30.0,1.25).Z(125).u(335);
		boot.L.b.Q(boot.N.db).R(380,80).S(4.5,0.55).T(250,45.0).U(7.0,0.6).V(51.66,3.0).W(0.625,1.36).X(15.0,3.5).Y(30.0,0).Z(550).u(340);
		boot.L.b.Q(boot.N.dc).R(421,90).S(7.25,0.85).T(250,46.0).U(6.45,0.45).V(58.0,3.3).W(0.694,2.13).X(18.0,4.0).Y(30.0,0).Z(125).u(335);
		boot.L.b.Q(boot.N.dd).R(444,86).S(6.75,0.65).T(199,36.0).U(6.5,0.45).V(55.12,3.1).W(0.679,2.98).X(16.3,3.7).Y(30.0,1.25).Z(125).u(355);
		boot.L.b.Q(boot.N.de).R(435,85).S(5.1,0.65).T(212,38.0).U(6.95,0.65).V(46.5,3.0).W(0.658,3.01).X(15.0,3.0).Y(30.0,0).Z(550).u(325);
		boot.L.b.Q(boot.N.df).R(421,80).S(7.45,0.55).V(51.7,3.5).W(0.694,3.0).X(15.0,3.5).Y(30.0,1.25).Z(125).u(340);
		boot.L.b.Q(boot.N.dg).R(403,86).S(4.7,0.6).T(240,60.0).U(6.8,0.65).V(51.58,3.5).W(0.579,1.53).X(15.0,3.8).Y(30.0,0).Z(425).u(335);
		boot.L.b.Q(boot.N.dh).R(365,74).S(4.5,45.0).T(305,43.0).U(6.9,0.6).V(48.0,3.1).W(0.644,2.6).X(9.0,4.0).Y(30.0,0).Z(550).u(330);
		boot.L.b.Q(boot.N.di).R(410,90).S(7.5,0.9).T(200,45.0).U(6.6,0.5).V(53.3,3.5).W(0.638,3.48).X(15.0,3.5).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.dj).R(432,86).S(7.45,0.55).T(200,50.0).U(7.45,0.7).V(52.0,3.3).W(0.613,0.98).X(12.0,3.25).Y(30.0,1.25).Z(175).u(325);
		boot.L.b.Q(boot.N.dk).R(370,90).S(5.0,0.6).T(220,45.0).U(7.0,0.5).V(49.0,3.5).W(0.672,3.22).X(11.0,3.5).Y(30.0,10.75).Z(525).u(335);
		boot.L.b.Q(boot.N.dl).R(430,85).S(7.0,0.75).T(215,35.0).U(6.0,0.45).V(54.0,3.1).W(0.668,2.7).X(17.0,3.5).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.dm).R(437,108).S(7.05,0.8).T(213,42.0).U(6.6,0.5).V(51.6,3.4).W(0.625,2.25).X(16.5,3.5).Y(30.0,1.25).Z(125).u(340);
		boot.L.b.Q(boot.N.dn).R(441,93).S(7.0,0.9).T(225,45.0).U(6.5,0.575).V(54.1,3.5).W(0.694,2.7).X(17.0,3.0).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.dp).R(385,79).S(5.95,0.55).T(250,50.0).U(7.0,0.5).V(44.0,2.6).W(0.658,3.5).X(8.0,3.0).Y(30.0,0).Z(525).u(325);
		boot.L.b.Q(boot.N.ea).R(433,87).S(6.75,0.65).T(210,34.0).U(6.6,0.45).V(50.7,2.9).W(0.679,2.95).X(17.1,3.9).Y(30.0,1.25).Z(155).u(355);
		boot.L.b.Q(boot.N.eb).R(423,81).S(7.45,0.55).T(185,30.0).U(6.4,0.45).V(56.3,3.375).W(0.638,3.35).X(18.0,4.0).Y(30.0,0).Z(125).u(345);
		boot.L.b.Q(boot.N.ec).R(420,86).S(8.0,0.55).T(255,33.0).U(4.5,0.3).V(50.0,3.5).W(0.625,2.22).X(21.0,3.8).Y(30.0,1.25).Z(125).u(335);
		boot.L.b.Q(boot.N.ed).R(426,87).S(6.7,0.75).V(53.12,3.1).W(0.665,2.65).X(15.2,3.8).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.ee).R(435,85).S(4.0,0.4).V(55.0,3.0).W(0.679,2.85).X(16.0,3.5).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.ef).R(414,86).S(10.4,0.9).V(54.0,2.75).W(0.625,3.5).X(15.0,3.1).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.eg).R(450,80).S(7.0,0.7).V(55.32,3.2).W(0.644,1.85).X(16.0,3.5).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.eh).R(360,86).S(4.35,0.55).T(250,55.0).U(7.0,0.6).V(52.0,3.0).W(0.625,2.11).X(11.0,3.9).Y(30.0,0).Z(550).u(335);
		boot.L.b.Q(boot.N.ei).R(450,85).S(7.35,0.85).T(220,40.0).U(6.45,0.45).V(54.0,3.4).W(0.67,1.45).X(20.5,3.5).Y(30.0,1.25).Z(125).u(340);
		boot.L.b.Q(boot.N.ej).R(441,84).S(7.45,0.55).T(270,40.0).U(6.4,0.45).V(51.7,3.5).W(0.694,3.0).X(15.0,3.5).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.ek).R(428,85).S(7.45,0.55).v(200).w(50).V(54.5,3.375).W(0.651,3.4).X(15.0,4.0).Y(30.0,0).Z(125).u(335);
		boot.L.b.Q(boot.N.el).R(435,95).S(7.2,0.8).V(54.5,3.4).W(0.658,3.4).X(17.6,3.4).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.em).R(405,82).S(7.1,0.55).T(215,45.0).U(6.6,0.55).V(56.65,3.375).W(0.613,1.81).X(18.0,3.5).Y(30.0,0).Z(125).u(345);
		boot.L.b.Q(boot.N.en).R(403,104).S(7.9,0.95).T(240,40.0).U(6.3,0.4).V(55.52,3.1875).W(0.625,1.63).X(17.75,3.25).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.eo).R(378,82).S(4.25,0.55).T(203,43.0).U(6.5,0.5).V(49.0,2.9).W(0.658,3.28).X(12.75,3.25).Y(30.0,0).Z(500).u(335);
		boot.L.b.Q(boot.N.ep).R(440,96).S(7.5,0.85).T(205,40.0).U(6.45,0.45).V(54.1,4.2).W(0.625,2.1).X(19.0,3.8).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.fa).R(340,70).S(4.5,0.55).T(265,45.0).U(7.0,0.65).V(47.0,3.0).W(0.644,2.3).X(6.0,3.3).Y(30.0,0).Z(550).u(330);
		boot.L.b.Q(boot.N.fb).R(375,71).S(4.5,0.55).T(240,60.0).U(6.8,0.65).V(48.8,3.0).W(0.625,2.14).X(7.4,3.8).Y(30.0,0).Z(550).u(335);
		boot.L.b.Q(boot.N.fc).R(385,78).S(6.75,0.65).T(240,50.0).U(6.8,0.65).V(49.0,3.0).W(0.625,2.11).X(12.0,4.0).Y(30.0,0).Z(500).u(335);
		boot.L.b.Q(boot.N.fd).R(380,78).S(5.5,0.6).T(250,50.0).U(6.9,0.6).V(51.0,2.9).W(0.625,2.0).X(15.0,3.4).Y(30.0,0).Z(550).u(330);
		boot.L.b.Q(boot.N.fe).R(440,85).S(7.25,0.75).T(260,40.0).U(6.75,0.5).V(50.0,3.1).W(0.668,2.7).X(17.0,3.5).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.ff).R(468,90).S(7.1,0.5).T(255,56.0).U(4.1,0.4).V(58.0,3.5).W(0.625,2.02).X(16.5,3.2).Y(30.0,1.25).Z(125).u(340);
		boot.L.b.Q(boot.N.fg).R(383,82).S(4.65,0.65).T(200,40.0).U(6.45,0.45).V(44.5,3.0).W(0.69,3.38).X(14.0,3.75).Y(30.0,0).Z(500).u(330);
		boot.L.b.Q(boot.N.fh).R(415,82).S(5.1,0.65).T(193,32.0).U(6.45,0.45).V(46.5,3.0).W(0.658,3.01).X(15.0,3.0).Y(30.0,0).Z(550).u(325);
		boot.L.b.Q(boot.N.fi).R(455,96).S(8.0,0.85).T(206,45.0).U(6.9,0.6).V(54.66,3.0).W(0.672,2.9).X(19.0,2.7).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.fj).R(461,98).S(7.9,0.9).V(56.0,3.2).W(0.644,2.9).X(14.9,3.1).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.fk).R(384,82).S(4.5,0.6).T(202,38.0).U(6.5,0.5).V(46.61,3.3).W(0.651,3.22).X(111.25,3.15).Y(30.0,0).Z(525).u(330);
		boot.L.b.Q(boot.N.fl).R(389,81).S(5.0,0.6).T(220,40.0).U(6.5,0.45).V(49.0,3.0).W(0.679,3.38).X(14.0,3.0).Y(30.0,0).Z(550).u(330);
		boot.L.b.Q(boot.N.fm).R(427,99).S(7.45,0.75).T(220,30.0).U(6.4,0.45).V(52.91,3.2).W(0.658,2.67).X(14.75,4.0).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.fn).R(437,89).S(5.5,0.6).T(220,55.0).U(7.5,0.65).V(48.0,3.6).W(0.644,2.9).X(15.0,3.3).Y(30.0,0).Z(425).u(335);
		boot.L.b.Q(boot.N.fo).R(400,82).S(4.5,0.55).T(250,36.0).U(6.5,0.5).V(46.0,3.0).W(0.658,2.65).X(13.5,3.4).Y(30.0,0).Z(575).u(335);
		boot.L.b.Q(boot.N.fp).R(359,83).S(4.5,0.55).T(173,27.0).U(6.3,0.4).V(50.0,3.25).W(0.658,3.1).X(9.3,3.4).Y(30.0,0).Z(550).u(330);
		boot.L.b.Q(boot.N.ga).R(355,82).S(4.5,0.55).T(250,55.0).U(6.9,0.6).V(48.3,2.625).W(0.625,2.24).X(12.25,3.75).Y(30.0,0).Z(525).u(340);
		boot.L.b.Q(boot.N.gb).R(440,85).S(7.5,0.9).T(220,45.0).U(7.0,0.65).V(55.0,3.5).W(0.643,2.5).X(16.0,3.5).Y(30.0,1.25).Z(125).u(350);
		boot.L.b.Q(boot.N.gc).R(385,78).S(6.75,0.65).T(240,50.0).U(6.9,0.45).V(49.0,3.0).W(0.625,2.11).X(12.0,4.0).Y(30.0,0).Z(525).u(335);
		boot.L.b.Q(boot.N.gd).R(400,85).S(6.0,0.6).V(45.0,3.0).W(0.6258,2.0).X(12.0,3.5).Y(30.0,0).Z(450).u(335);
		boot.L.b.Q(boot.N.ge).R(440,86).S(7.0,0.65).T(220,30.0).U(7.0,0.65).V(54.0,3.3).W(0.625,2.9).X(16.5,3.5).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.gf).R(428,98).S(7.05,0.8).T(190,30.0).U(7.1,0.6).V(56.76,3.375).W(0.679,2.88).X(16.0,3.5).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.gg).R(435,85).S(5.1,0.65).T(202,38.0).U(6.9,0.65).V(54.0,3.2).W(0.658,3.0).X(15.0,3.5).Y(30.0,1.25).Z(175).u(345);
		boot.L.b.Q(boot.N.gh).R(380,80).S(5.0,0.55).T(250,45.0).U(8.0,0.6).V(52.0,3.0).W(0.625,1.36).X(12.6,3.4).Y(30.0,0).Z(550).u(340);
		boot.L.b.Q(boot.N.gi).R(445,87).S(7.0,0.7).T(213,31.0).U(6.6,0.45).V(52.0,3.3).W(0.672,2.7).X(16.2,3.7).Y(30.0,1.25).Z(175).u(345);
		boot.L.b.Q(boot.N.gj).R(421,85).S(8.5,0.7).T(235,35.0).U(6.5,0.45).V(51.5,3.5).W(0.625,3.0).X(18.0,3.6).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.gk).R(445,85).S(6.0,0.65).v(20).w(50).V(48.6,3.4).W(0.658,3.1).X(17.5,3.5).Y(30.0,1.25).Z(125).u(345);
		boot.L.b.Q(boot.N.gl).R(390,80).S(5.25,0.6).T(250,50.0).U(6.75,0.6).V(54.0,3.1).W(0.656,1.7).X(12.0,3.3).Y(30.0,0).Z(575).u(330);
		boot.L.b.Q(boot.N.gm).R(380,71).S(4.6,0.5).T(260,60.0).U(6.95,0.65).V(48.6,3.0).W(0.625,2.13).X(6.75,3.8).Y(30.0,0).Z(600).u(335);
		boot.L.b.Q(boot.N.gn).R(355,74).S(4.85,0.5).T(250,50.0).U(7.1,0.75).V(50.0,3.2).W(0.625,1.8).X(11.0,3.0).Y(30.0,0).Z(575).u(325);
		boot.L.c=new boot.L(1520,2012,12,3,"Preseason 3",boot.L.b,0);
		boot.L.c.M("Shard of True Ice");
		boot.L.c.M("Liandry's Torment");
		boot.L.c.M("Haunting Guise");
		boot.L.a=boot.L.c;
	},
	// teemowork.model.Patch#<init>(int, int, int, int, java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C,D,E,F){
		this.d=new boot.P(0);
		this.e=new boot.P(0);
		this.f=A;
		this.g=E;
		this.h=F;
	},
	// teemowork.model.Patch#updateItem(java.lang.String)
	M:function(A,B){
		B=new boot.M(A,this,0);
		this.e.x(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	Q:function(A){
		A.go=new boot.O(this,A.go,0);
		return A.go;
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
boot.define("Z",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	CE:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	EB:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	CY:function(){
	},
	// booton.translator.web.jQuery$1#next()
	CD:function(){
		return this.EB();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	Dz:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	EA:function(A){
		return this.Dz("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	CC:function(){
		return new boot.Z(this,0);
	}
});
boot.define("K",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.Dz("ul").addClass("d");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.Dz("li").addClass("e");
		C.Dz("a").addClass("c").attr("href",B).text(A);
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
		C=this.a.Dz("li").addClass("b");
		C.Dz("a").addClass("c").attr("href",B).text(A);
		return new boot.K(this,C,null,0);
	}
});

boot.define("G",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("v",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
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
	EV:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	EW:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	EX:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	EY:function(){
		console.log(this.a);
	}
});

boot.define("z",boot.BB,{
	
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

boot.define("x",boot.BB,{
	
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

boot.define("BC",boot.x,{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.x.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.x.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.x.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.x.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.x.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BA",boot.BC,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.BC.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.BC.prototype.$1.call(this,A);
	}
});

boot.define("y",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	CE:function(){
		return this.b<boot.w.EU(this.a).length;
	},
	// js.util.ArrayList$View#next()
	CD:function(){
		return boot.w.EU(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	CY:function(){
		if(this.b<=0){
		}else{
			boot.w.EU(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.y.prototype.$1.call(this,A);
	}
});

boot.define("w",boot.U,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.U.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	Bw:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	CA:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	CC:function(){
		return new boot.y(this,null,0);
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
	EI:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	CN:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	EJ:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	EK:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	EL:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	EM:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	EO:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	EP:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	EQ:function(){
		throw new boot.z(0);
	},
	// js.util.ArrayList#listIterator(int)
	ER:function(A){
		throw new boot.z(0);
	},
	// js.util.ArrayList#subList(int, int)
	ES:function(A,B){
		throw new boot.z(0);
	},
	// js.util.ArrayList#checkRange(int)
	ET:function(A){
		if(A>=0){
			if(this.Bw()>A){
				return;
			}else{
				throw new boot.BA("Index is overflowed. Size: "+this.Bw()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BA("Negative index is unacceptable. Size: "+this.Bw()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_EU:function(A){
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
	EH:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.w(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.CW());
			} catch ($) {
				if ($ instanceof boot.x) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_ED:function(A,B){
		return A.EH(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.F.prototype.$1.call(this,A,B);
	}
});

boot.define("E",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.w(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.EC(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	EC:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.CC();
		l3:while (C.CE()!=0) {
			B=C.CD();
			D=boot.F.ED(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.EE(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	EG:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.EE(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.EC(B);
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

boot.define("BI",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.FB(this.b);
	}
});

boot.define("BH",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BF.Ex(this.a).CL().CC();
		l2:while (D.CE()!=0) {
			C=D.CD();
			if(this.a.Ew(C.CM()).toLowerCase().indexOf(B) != -1==0){
				C.CG().addClass("i");
				continue l2;
			}else{
				C.CG().removeClass("i");
				continue l2;
			}
		}
	}
});

boot.define("BG",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BG.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BF",boot.BG,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BG.prototype.$0.call(this);
		this.b=new boot.P(0);
		this.c=this.Eu();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	EZ:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("f").css("display","block");
		B.keyup(new boot.BH(this,B,0));
		D=this.c.CC();
		l6:for (;
		D.CE()!=0;
		this.b.x(C,E)) {
			C=D.CD();
			E=this.a.EA("g").css("background-image","url("+this.Ev(C)+")");
			E.Dz("span").addClass("h").text(this.Ew(C));
			E.click(new boot.BI(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_Ex:function(A){
		return A.b;
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("BJ",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.H.FE(this.a,boot.H.FD(this.a)+1);
	}
});

boot.define("BK",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.H.FE(this.a,boot.H.FD(this.a)-1);
	}
});

boot.define("H",boot.G,{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.H.prototype.$1.call(this,boot.N.BY(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.G.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.z(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	EE:function(A,B,C){
		B=A.EA("j").css("background-image","url('"+this.a.BW()+"')").EA("k");
		C=B.EA("l").css("background-image","url("+this.a.BX()+")").click(new boot.BJ(this,0)).on("contextmenu",new boot.BK(this,0));
		this.b=C.EA("m");
		this.c=B.EA("n").text("Health").EA("o");
		this.FC(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	FC:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.BV();
			this.c.text(""+B.BS(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.ha;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_FD:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_FE:function(A,B){
		A.FC(B);
	}
});

boot.define("BE",boot.BF,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BF.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	Eu:function(){
		return boot.N.Bu();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	Ey:function(A){
		return A.ha;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	Ez:function(A){
		return A.BX();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	FA:function(A){
		boot.C.G(new boot.H(A.ha,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	Ew:function(A){
		return this.Ey(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	Ev:function(A){
		return this.Ez(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	FB:function(A){
		this.FA(A);
	}
});

boot.define("I",boot.G,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.G.prototype.$0.call(this);
		this.a=new boot.BE(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	EE:function(A){
		this.a.EZ(A);
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
		console.log(C.J());
	},
	// teemowork.Teemowork#test()
	K:function(){
		console.log("called");
	}
});

try {new boot.B(0).A();} catch(e) {console.log(e)}