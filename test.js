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

boot.define("T",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	BW:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	BQ:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	Bu:function(A,B){
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

boot.define("X",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	BL:function(){
		return this.BK()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	Bv:function(A,B,C,D){
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
	Bw:function(A,B,C,D){
		B=0;
		D=this.L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(A.BN(C)!=0){
			}else{
				B=this.Bx(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	Bz:function(A,B,C,D){
		B=0;
		D=A.L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.Bx(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	CA:function(A,B,C){
		C=A.L();
		l1:while (C.M()!=0) {
			B=C.P();
			if(this.BN(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	CB:function(){
		return this.CC(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	CC:function(A,B,C,D,E){
		B=this.BK();
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
			return A.BQ();
		}else{
			return A.BW();
		}
	},
	// js.util.HashMap$View#remove()
	O:function(){
		this.b.O();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.Y.prototype.$1.call(this,A,B,C);
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
	M:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	P:function(){
		this.d=boot.S.CE(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	O:function(){
		if(this.b<=0){
		}else{
			this.a.Bx(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.Z.prototype.$1.call(this,A,B);
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
	BK:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BN:function(A){
		return this.CD(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.CD(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	Bx:function(A,B){
		B=this.CD(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BX:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	L:function(){
		return new boot.Z(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	CD:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	BP:function(A){
		return this.b[this.CD(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	BR:function(A,B,C){
		B=null;
		C=this.CD(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	BT:function(A,B,C){
		B=null;
		C=this.CD(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_CE:function(A){
		return A.b;
	}
});

boot.define("U",boot.W,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.W.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	BK:function(){
		return boot.R.BZ(this.a).BK();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BN:function(A){
		return boot.R.BZ(this.a).BN(A);
	},
	// js.util.HashMap$Keys#iterator()
	L:function(){
		return new boot.Y(this.a,boot.R.BZ(this.a).L(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	Bx:function(A){
		return boot.R.BZ(this.a).Bx(A);
	},
	// js.util.HashMap$Keys#clear()
	BX:function(){
		boot.R.BZ(this.a).BX();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.U.prototype.$1.call(this,A);
	}
});

boot.define("V",boot.X,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.X.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BK:function(){
		return boot.R.BZ(this.a).BK();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BN:function(A){
		return this.a.BO(A);
	},
	// js.util.HashMap$Values#iterator()
	L:function(){
		return new boot.Y(this.a,boot.R.BZ(this.a).L(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	Bx:function(A,B,C){
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
	BX:function(){
		boot.R.BZ(this.a).BX();
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
	BK:function(){
		return this.a.BK();
	},
	// js.util.HashMap#isEmpty()
	BL:function(){
		return this.a.BL();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	BM:function(A){
		return this.a.BN(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	BO:function(A,B,C){
		C=this.BJ().L();
		l1:while (C.M()!=0) {
			B=C.P();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	BH:function(A,B){
		B=this.a.BP(A);
		return (B==null?null:B.BQ());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	BB:function(A,B,C){
		C=this.a.BR(new boot.T(A,B,null,0));
		if(C!=null){
			return C.BQ();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	BS:function(A,B){
		B=this.a.BT(A);
		if(B!=null){
			return B.BQ();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	BU:function(A,B,C){
		C=A.BV().L();
		l1:for (;
		C.M()!=0;
		this.BB(B.BW(),B.BQ())) {
			B=C.P();
		}
	},
	// js.util.HashMap#clear()
	BX:function(){
		this.a.BX();
	},
	// js.util.HashMap#keySet()
	BY:function(){
		return new boot.U(this,null,0);
	},
	// js.util.HashMap#values()
	BJ:function(){
		return new boot.V(this,null,0);
	},
	// js.util.HashMap#entrySet()
	BV:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_BZ:function(A){
		return A.a;
	}
});

boot.define("P",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.P.gp=new boot.R(0);
		boot.P.a=new boot.P("Ahri",0);
		boot.P.b=new boot.P("Akali",0);
		boot.P.c=new boot.P("Alistar",0);
		boot.P.d=new boot.P("Amumu",0);
		boot.P.e=new boot.P("Anivia",0);
		boot.P.f=new boot.P("Annie",0);
		boot.P.g=new boot.P("Ashe",0);
		boot.P.h=new boot.P("Blitzcrank",0);
		boot.P.i=new boot.P("Brand",0);
		boot.P.j=new boot.P("Caitlyn",0);
		boot.P.k=new boot.P("Cassiopeia",0);
		boot.P.l=new boot.P("Chogath",0);
		boot.P.m=new boot.P("Corki",0);
		boot.P.n=new boot.P("Darius",0);
		boot.P.o=new boot.P("Diana",0);
		boot.P.p=new boot.P("Dr.Mundo",0);
		boot.P.ba=new boot.P("Draven",0);
		boot.P.bb=new boot.P("Elise",0);
		boot.P.bc=new boot.P("Evelynn",0);
		boot.P.bd=new boot.P("Ezreal",0);
		boot.P.be=new boot.P("Fiddlesticks",0);
		boot.P.bf=new boot.P("Fiora",0);
		boot.P.bg=new boot.P("Fizz",0);
		boot.P.bh=new boot.P("Galio",0);
		boot.P.bi=new boot.P("Gangplank",0);
		boot.P.bj=new boot.P("Garen",0);
		boot.P.bk=new boot.P("Gragas",0);
		boot.P.bl=new boot.P("Graves",0);
		boot.P.bm=new boot.P("Hecarim",0);
		boot.P.bn=new boot.P("Heimerdinger",0);
		boot.P.bo=new boot.P("Irelia",0);
		boot.P.bp=new boot.P("Janna",0);
		boot.P.ca=new boot.P("Jarvan IV",0);
		boot.P.cb=new boot.P("Jax",0);
		boot.P.cc=new boot.P("Jayce",0);
		boot.P.cd=new boot.P("Karma",0);
		boot.P.ce=new boot.P("Karthus",0);
		boot.P.cf=new boot.P("Kassadin",0);
		boot.P.cg=new boot.P("Katarina",0);
		boot.P.ch=new boot.P("Kayle",0);
		boot.P.ci=new boot.P("Kennen",0);
		boot.P.cj=new boot.P("Kha'zix",0);
		boot.P.ck=new boot.P("Kog'maw",0);
		boot.P.cl=new boot.P("LeBlanc",0);
		boot.P.cm=new boot.P("Lee Sin",0);
		boot.P.cn=new boot.P("Leona",0);
		boot.P.co=new boot.P("Lulu",0);
		boot.P.cp=new boot.P("Lux",0);
		boot.P.da=new boot.P("Malphite",0);
		boot.P.db=new boot.P("Malzahar",0);
		boot.P.dc=new boot.P("Maokai",0);
		boot.P.dd=new boot.P("Master Yi",0);
		boot.P.de=new boot.P("Miss Fortune",0);
		boot.P.df=new boot.P("Mordekaiser",0);
		boot.P.dg=new boot.P("Morgana",0);
		boot.P.dh=new boot.P("Nami",0);
		boot.P.di=new boot.P("Nasus",0);
		boot.P.dj=new boot.P("Nautilus",0);
		boot.P.dk=new boot.P("Nidalee",0);
		boot.P.dl=new boot.P("Nocturne",0);
		boot.P.dm=new boot.P("Nunu",0);
		boot.P.dn=new boot.P("Olaf",0);
		boot.P.dp=new boot.P("Orianna",0);
		boot.P.ea=new boot.P("Pantheon",0);
		boot.P.eb=new boot.P("Poppy",0);
		boot.P.ec=new boot.P("Rammus",0);
		boot.P.ed=new boot.P("Renekton",0);
		boot.P.ee=new boot.P("Rengar",0);
		boot.P.ef=new boot.P("Riven",0);
		boot.P.eg=new boot.P("Rumble",0);
		boot.P.eh=new boot.P("Ryze",0);
		boot.P.ei=new boot.P("Sejuani",0);
		boot.P.ej=new boot.P("Shaco",0);
		boot.P.ek=new boot.P("Shen",0);
		boot.P.el=new boot.P("Shyvana",0);
		boot.P.em=new boot.P("Singed",0);
		boot.P.en=new boot.P("Sion",0);
		boot.P.eo=new boot.P("Sivir",0);
		boot.P.ep=new boot.P("Skarner",0);
		boot.P.fa=new boot.P("Sona",0);
		boot.P.fb=new boot.P("Soraka",0);
		boot.P.fc=new boot.P("Swain",0);
		boot.P.fd=new boot.P("Syndra",0);
		boot.P.fe=new boot.P("Talon",0);
		boot.P.ff=new boot.P("Taric",0);
		boot.P.fg=new boot.P("Teemo",0);
		boot.P.fh=new boot.P("Tristana",0);
		boot.P.fi=new boot.P("Trundle",0);
		boot.P.fj=new boot.P("Tryndamere",0);
		boot.P.fk=new boot.P("Twisted Fate",0);
		boot.P.fl=new boot.P("Twitch",0);
		boot.P.fm=new boot.P("Udyr",0);
		boot.P.fn=new boot.P("Urgot",0);
		boot.P.fo=new boot.P("Varus",0);
		boot.P.fp=new boot.P("Vayne",0);
		boot.P.ga=new boot.P("Veigar",0);
		boot.P.gb=new boot.P("Vi",0);
		boot.P.gc=new boot.P("Viktor",0);
		boot.P.gd=new boot.P("Vladimir",0);
		boot.P.ge=new boot.P("Volibear",0);
		boot.P.gf=new boot.P("Warwick",0);
		boot.P.gg=new boot.P("Wukong",0);
		boot.P.gh=new boot.P("Xerath",0);
		boot.P.gi=new boot.P("Xin Zhao",0);
		boot.P.gj=new boot.P("Yorick",0);
		boot.P.gk=new boot.P("Zed",0);
		boot.P.gl=new boot.P("Ziggs",0);
		boot.P.gm=new boot.P("Zilean",0);
		boot.P.gn=new boot.P("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.ha=A;
		this.hb=this.BC().toLowerCase();
		boot.P.gp.BB(A,this);
	},
	// teemowork.model.Champion#getStatus()
	BD:function(){
		return this.go;
	},
	// teemowork.model.Champion#getSystemName()
	BC:function(){
		return this.ha.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	BE:function(){
		return "src/main/resources/teemowork/splash/"+this.BC()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	BF:function(){
		return "src/main/resources/teemowork/icon/"+this.BC()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_BG:function(A){
		return boot.P.gp.BH(A);
	},
	// teemowork.model.Champion#getAll()
	_BI:function(){
		return boot.P.gp.BJ();
	}
});

boot.define("O",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.O.a=new boot.R(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.O.a.BH(A);
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
		boot.O.a.BB(A,this);
	},
	// teemowork.model.Item#cost()
	CF:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	R:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	CG:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	CH:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	CI:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	CJ:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	CK:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	CL:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	CM:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	CN:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	CO:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	CP:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	CQ:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	CR:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	CS:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	T:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	CT:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	CU:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	CV:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	CW:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	CX:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	CY:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	CZ:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	Cu:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	Cv:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	S:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	Cw:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	Cx:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	Cy:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	Cz:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	DA:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	DB:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	DC:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	DD:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	DE:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	DF:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	DG:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	DH:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_DI:function(A){
		return boot.O.a.BH(A);
	},
	// teemowork.model.Item#getAll()
	_BI:function(){
		return boot.O.a.BJ();
	}
});

boot.define("Q",{
	
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
	DJ:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	DK:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	V:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	DL:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DM:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	W:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DN:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DO:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	X:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DP:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DQ:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	Y:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DR:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DS:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	Z:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DT:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DU:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	u:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DV:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DW:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	v:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DX:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DY:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	w:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	DZ:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	x:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	Du:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	y:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	Dv:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	z:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	Dw:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	BA:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	Dx:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	Dy:function(A){
		return this.g+this.h*A;
	}
});

boot.define("K",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.K.b=new boot.K(1510,2012,11,13,"Initial",null,0);
		boot.K.b.Q("Ruby Crystal").R(475).S(180);
		boot.K.b.Q("Haunting Guise").S(200).T(25);
		boot.K.b.U(boot.P.a).V(380,80).W(5.5,0.6).X(230,50.0).Y(6.25,0.6).Z(50.0,3.0).u(0.668,2.0).v(10.0,3.5).w(30.0,0).x(550).y(330);
		boot.K.b.U(boot.P.b).V(445,85).W(7.25,0.65).z(200).BA(50).Z(53.0,3.2).u(0.694,3.1).v(16.5,3.5).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.c).V(442,102).W(7.25,0.85).X(215,38.0).Y(6.45,0.45).Z(55.03,3.62).u(0.625,3.62).v(14.5,3.5).w(30.0,1.25).x(125).y(325);
		boot.K.b.U(boot.P.d).V(472,84).W(7.45,0.85).X(220,40.0).Y(6.5,0.525).Z(47.0,3.8).u(0.638,2.18).v(18.0,3.3).w(30.0,1.25).x(125).y(335);
		boot.K.b.U(boot.P.e).V(350,70).W(4.65,0.55).X(257,53.0).Y(7.0,0.6).Z(48.0,3.2).u(0.625,1.68).v(10.5,4.0).w(30.0,0).x(600).y(325);
		boot.K.b.U(boot.P.f).V(384,76).W(4.5,0.55).X(250,50.0).Y(6.9,0.6).Z(49.0,2.625).u(0.579,1.36).v(12.5,4.0).w(30.0,0).x(625).y(335);
		boot.K.b.U(boot.P.g).V(395,79).W(4.5,0.55).X(173,35.0).Y(6.3,0.4).Z(46.3,2.85).u(0.658,3.34).v(11.5,3.4).w(30.0,0).x(600).y(325);
		boot.K.b.U(boot.P.h).V(423,95).W(7.25,0.75).X(260,40.0).Y(6.6,0.5).Z(55.66,3.5).u(0.625,1.13).v(14.5,3.5).w(30.0,1.25).x(125).y(325);
		boot.K.b.U(boot.P.i).V(380,76).W(4.5,0.55).X(250,45.0).Y(7.0,0.6).Z(51.66,3.0).u(0.625,1.36).v(12.0,3.5).w(30.0,0).x(550).y(340);
		boot.K.b.U(boot.P.j).V(390,80).W(4.75,0.55).X(255,35.0).Y(6.5,0.55).Z(47.0,3.0).u(0.668,3.0).v(13.0,3.5).w(30.0,0).x(650).y(325);
		boot.K.b.U(boot.P.k).V(380,75).W(4.85,0.5).X(250,50.0).Y(7.1,0.75).Z(47.0,3.2).u(0.644,1.68).v(11.5,4.0).w(30.0,0).x(550).y(335);
		boot.K.b.U(boot.P.l).V(440,80).W(7.5,0.85).X(205,40.0).Y(6.45,0.45).Z(54.1,4.2).u(0.625,1.44).v(19.0,3.5).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.m).V(375,82).W(4.5,0.55).X(243,37.0).Y(6.5,0.55).Z(48.2,3.0).u(0.658,2.3).v(13.5,3.5).w(30.0,0).x(550).y(325);
		boot.K.b.U(boot.P.n).V(426,93).W(8.25,0.95).X(200,37.5).Y(6.0,0.35).Z(50.0,3.5).u(0.679,2.6).v(20.0,3.5).w(30.0,1.25).x(125).y(340);
		boot.K.b.U(boot.P.o).V(438,90).W(7.0,0.85).X(230,40.0).Y(7.0,0.6).Z(48.0,3.0).u(0.625,2.25).v(16.0,3.6).w(30.0,1.25).x(150).y(345);
		boot.K.b.U(boot.P.p).V(433,89).W(6.5,0.75).Z(56.23,3.0).u(0.625,2.8).v(17.0,3.5).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.ba).V(420,82).W(5.0,0.7).X(240,42.0).Y(6.95,0.65).Z(46.5,3.5).u(0.679,2.6).v(16.0,3.3).w(30.0,0).x(550).y(330);
		boot.K.b.U(boot.P.bb).V(395,80).W(4.7,0.6).X(240,50.0).Y(6.8,0.65).Z(47.5,3.0).u(0.625,1.75).v(12.65,3.35).w(30.0,0).x(550).y(335);
		boot.K.b.U(boot.P.bc).V(414,86).W(6.95,0.55).X(180,42.0).Y(7.1,0.6).Z(48.0,3.3).u(0.658,3.84).v(12.5,4.0).w(30.0,1.25).x(125).y(340);
		boot.K.b.U(boot.P.bd).V(350,80).W(5.5,0.55).X(235,45.0).Y(7.0,0.65).Z(47.2,3.0).u(0.665,2.8).v(12.0,3.5).w(30.0,0).x(550).y(330);
		boot.K.b.U(boot.P.be).V(390,80).W(4.6,0.6).X(251,59.0).Y(6.9,0.65).Z(45.95,2.625).u(0.625,2.11).v(11.0,3.5).w(30.0,0).x(480).y(335);
		boot.K.b.U(boot.P.bf).V(450,85).W(6.3,0.8).X(220,40.0).Y(7.25,0.5).Z(54.5,3.2).u(0.672,3.0).v(15.5,3.5).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.bg).V(414,86).W(7.0,0.7).X(200,40.0).Y(6.15,0.45).Z(53.0,3.0).u(0.658,3.1).v(13.0,3.4).w(30.0,1.25).x(175).y(335);
		boot.K.b.U(boot.P.bh).V(435,85).W(7.45,0.75).X(235,50.0).Y(7.0,0.7).Z(56.3,3.375).u(0.638,1.2).v(17.0,3.5).w(30.0,0).x(125).y(335);
		boot.K.b.U(boot.P.bi).V(495,81).W(425.0,0.75).X(215,40.0).Y(6.5,0.7).Z(54.0,3.0).u(0.651,2.75).v(16.5,3.3).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.bj).V(455,96).W(7.5,0.75).Z(52.5,3.5).u(0.625,2.9).v(19.0,2.7).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.bk).V(434,89).W(7.25,0.85).X(221,47.0).Y(6.45,0.45).Z(55.78,3.375).u(0.651,2.05).v(16.0,3.6).w(30.0,0).x(125).y(340);
		boot.K.b.U(boot.P.bl).V(410,84).W(5.5,0.7).X(255,40.0).Y(6.75,0.7).Z(51.0,3.1).u(0.625,2.9).v(15.0,3.2).w(30.0,0).x(525).y(330);
		boot.K.b.U(boot.P.bm).V(440,95).W(8.0,0.75).X(210,40.0).Y(6.5,0.6).Z(56.0,3.2).u(0.67,2.5).v(16.0,4.0).w(30.0,1.25).x(175).y(345);
		boot.K.b.U(boot.P.bn).V(350,75).W(4.5,0.55).X(240,65.0).Y(7.0,0.65).Z(49.24,3.0).u(0.625,1.21).v(7.0,3.0).w(30.0,0).x(550).y(325);
		boot.K.b.U(boot.P.bo).V(456,90).W(7.5,0.65).X(230,35.0).Y(7.0,0.65).Z(56.0,3.3).u(0.665,3.2).v(15.0,3.75).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.bp).V(356,78).W(4.5,0.55).X(302,64.0).Y(6.9,0.6).Z(49.0,2.95).u(0.625,2.61).v(9.0,3.8).w(30.0,0).x(475).y(335);
		boot.K.b.U(boot.P.ca).V(420,90).W(7.0,0.7).X(235,40.0).Y(6.0,0.45).Z(50.0,3.4).u(0.658,2.5).v(14.0,3.0).w(30.0,1.25).x(175).y(340);
		boot.K.b.U(boot.P.cb).V(463,98).W(7.45,0.55).X(230,35.0).Y(6.4,0.7).Z(56.3,3.375).u(0.638,3.4).v(18.0,3.5).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.cc).V(420,90).W(6.0,0.8).X(240,40.0).Y(7.0,0.7).Z(46.5,3.5).u(0.658,3.0).v(12.5,3.5).w(30.0,0).x(125).y(335);
		boot.K.b.U(boot.P.cd).V(410,86).W(4.7,0.55).X(240,60.0).Y(6.8,0.65).Z(50.0,3.3).u(0.625,2.3).v(15.0,3.5).w(30.0,0).x(425).y(335);
		boot.K.b.U(boot.P.ce).V(390,75).W(5.5,0.55).X(270,61.0).Y(6.5,0.6).Z(42.2,3.25).u(0.625,2.11).v(11.0,3.5).w(30.0,0).x(450).y(335);
		boot.K.b.U(boot.P.cf).V(433,78).W(6.95,0.5).X(230,45.0).Y(6.9,0.6).Z(52.3,3.9).u(0.638,3.7).v(14.0,3.2).w(30.0,1.25).x(125).y(340);
		boot.K.b.U(boot.P.cg).V(395,83).W(6.95,0.55).Z(53.0,3.2).u(0.658,2.74).v(14.75,4.0).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.ch).V(418,93).W(7.0,0.75).X(255,40.0).Y(6.9,0.525).Z(53.3,2.8).u(0.638,2.5).v(17.0,3.5).w(30.0,0.75).x(125).y(335);
		boot.K.b.U(boot.P.ci).V(403,79).W(4.65,0.65).z(200).BA(50).Z(51.3,3.3).u(0.69,3.4).v(14.0,3.75).w(30.0,0).x(550).y(335);
		boot.K.b.U(boot.P.cj).V(430,85).W(6.25,0.75).X(260,40.0).Y(6.75,0.5).Z(50.0,3.1).u(0.665,2.7).v(15.0,3.0).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.ck).V(440,84).W(5.0,0.55).X(295,40.0).Y(7.5,0.7).Z(46.0,3.0).u(0.665,2.65).v(13.0,3.53).w(30.0,0).x(500).y(340);
		boot.K.b.U(boot.P.cl).V(390,75).W(4.5,0.55).X(250,50.0).Y(6.9,0.6).Z(51.0,3.1).u(0.625,1.4).v(12.0,3.5).w(30.0,0).x(525).y(335);
		boot.K.b.U(boot.P.cm).V(428,85).W(6.25,61.0).BA(200).BA(50).Z(55.8,3.2).u(0.651,3.0).v(16.0,3.7).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.cn).V(430,87).W(9.0,0.85).X(235,40.0).Y(8.0,0.7).Z(55.0,3.0).u(0.625,2.9).v(18.0,3.1).w(30.0,1.25).x(125).y(335);
		boot.K.b.U(boot.P.co).V(415,82).W(6.0,0.72).X(200,50.0).Y(6.0,0.6).Z(44.4,2.6).u(0.625,2.2).v(9.0,3.7).w(30.0,0).x(550).y(325);
		boot.K.b.U(boot.P.cp).V(345,79).W(4.5,0.55).X(250,50.0).Y(6.0,0.6).Z(50.0,3.3).u(0.625,1.36).v(8.0,4.0).w(30.0,0).x(550).y(340);
		boot.K.b.U(boot.P.da).V(423,90).W(7.45,0.55).X(215,40.0).Y(6.4,0.55).Z(56.3,3.375).u(0.638,3.4).v(18.0,3.75).w(30.0,1.25).x(125).y(335);
		boot.K.b.U(boot.P.db).V(380,80).W(4.5,0.55).X(250,45.0).Y(7.0,0.6).Z(51.66,3.0).u(0.625,1.36).v(15.0,3.5).w(30.0,0).x(550).y(340);
		boot.K.b.U(boot.P.dc).V(421,90).W(7.25,0.85).X(250,46.0).Y(6.45,0.45).Z(58.0,3.3).u(0.694,2.13).v(18.0,4.0).w(30.0,0).x(125).y(335);
		boot.K.b.U(boot.P.dd).V(444,86).W(6.75,0.65).X(199,36.0).Y(6.5,0.45).Z(55.12,3.1).u(0.679,2.98).v(16.3,3.7).w(30.0,1.25).x(125).y(355);
		boot.K.b.U(boot.P.de).V(435,85).W(5.1,0.65).X(212,38.0).Y(6.95,0.65).Z(46.5,3.0).u(0.658,3.01).v(15.0,3.0).w(30.0,0).x(550).y(325);
		boot.K.b.U(boot.P.df).V(421,80).W(7.45,0.55).Z(51.7,3.5).u(0.694,3.0).v(15.0,3.5).w(30.0,1.25).x(125).y(340);
		boot.K.b.U(boot.P.dg).V(403,86).W(4.7,0.6).X(240,60.0).Y(6.8,0.65).Z(51.58,3.5).u(0.579,1.53).v(15.0,3.8).w(30.0,0).x(425).y(335);
		boot.K.b.U(boot.P.dh).V(365,74).W(4.5,45.0).X(305,43.0).Y(6.9,0.6).Z(48.0,3.1).u(0.644,2.6).v(9.0,4.0).w(30.0,0).x(550).y(330);
		boot.K.b.U(boot.P.di).V(410,90).W(7.5,0.9).X(200,45.0).Y(6.6,0.5).Z(53.3,3.5).u(0.638,3.48).v(15.0,3.5).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.dj).V(432,86).W(7.45,0.55).X(200,50.0).Y(7.45,0.7).Z(52.0,3.3).u(0.613,0.98).v(12.0,3.25).w(30.0,1.25).x(175).y(325);
		boot.K.b.U(boot.P.dk).V(370,90).W(5.0,0.6).X(220,45.0).Y(7.0,0.5).Z(49.0,3.5).u(0.672,3.22).v(11.0,3.5).w(30.0,10.75).x(525).y(335);
		boot.K.b.U(boot.P.dl).V(430,85).W(7.0,0.75).X(215,35.0).Y(6.0,0.45).Z(54.0,3.1).u(0.668,2.7).v(17.0,3.5).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.dm).V(437,108).W(7.05,0.8).X(213,42.0).Y(6.6,0.5).Z(51.6,3.4).u(0.625,2.25).v(16.5,3.5).w(30.0,1.25).x(125).y(340);
		boot.K.b.U(boot.P.dn).V(441,93).W(7.0,0.9).X(225,45.0).Y(6.5,0.575).Z(54.1,3.5).u(0.694,2.7).v(17.0,3.0).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.dp).V(385,79).W(5.95,0.55).X(250,50.0).Y(7.0,0.5).Z(44.0,2.6).u(0.658,3.5).v(8.0,3.0).w(30.0,0).x(525).y(325);
		boot.K.b.U(boot.P.ea).V(433,87).W(6.75,0.65).X(210,34.0).Y(6.6,0.45).Z(50.7,2.9).u(0.679,2.95).v(17.1,3.9).w(30.0,1.25).x(155).y(355);
		boot.K.b.U(boot.P.eb).V(423,81).W(7.45,0.55).X(185,30.0).Y(6.4,0.45).Z(56.3,3.375).u(0.638,3.35).v(18.0,4.0).w(30.0,0).x(125).y(345);
		boot.K.b.U(boot.P.ec).V(420,86).W(8.0,0.55).X(255,33.0).Y(4.5,0.3).Z(50.0,3.5).u(0.625,2.22).v(21.0,3.8).w(30.0,1.25).x(125).y(335);
		boot.K.b.U(boot.P.ed).V(426,87).W(6.7,0.75).Z(53.12,3.1).u(0.665,2.65).v(15.2,3.8).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.ee).V(435,85).W(4.0,0.4).Z(55.0,3.0).u(0.679,2.85).v(16.0,3.5).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.ef).V(414,86).W(10.4,0.9).Z(54.0,2.75).u(0.625,3.5).v(15.0,3.1).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.eg).V(450,80).W(7.0,0.7).Z(55.32,3.2).u(0.644,1.85).v(16.0,3.5).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.eh).V(360,86).W(4.35,0.55).X(250,55.0).Y(7.0,0.6).Z(52.0,3.0).u(0.625,2.11).v(11.0,3.9).w(30.0,0).x(550).y(335);
		boot.K.b.U(boot.P.ei).V(450,85).W(7.35,0.85).X(220,40.0).Y(6.45,0.45).Z(54.0,3.4).u(0.67,1.45).v(20.5,3.5).w(30.0,1.25).x(125).y(340);
		boot.K.b.U(boot.P.ej).V(441,84).W(7.45,0.55).X(270,40.0).Y(6.4,0.45).Z(51.7,3.5).u(0.694,3.0).v(15.0,3.5).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.ek).V(428,85).W(7.45,0.55).z(200).BA(50).Z(54.5,3.375).u(0.651,3.4).v(15.0,4.0).w(30.0,0).x(125).y(335);
		boot.K.b.U(boot.P.el).V(435,95).W(7.2,0.8).Z(54.5,3.4).u(0.658,3.4).v(17.6,3.4).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.em).V(405,82).W(7.1,0.55).X(215,45.0).Y(6.6,0.55).Z(56.65,3.375).u(0.613,1.81).v(18.0,3.5).w(30.0,0).x(125).y(345);
		boot.K.b.U(boot.P.en).V(403,104).W(7.9,0.95).X(240,40.0).Y(6.3,0.4).Z(55.52,3.1875).u(0.625,1.63).v(17.75,3.25).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.eo).V(378,82).W(4.25,0.55).X(203,43.0).Y(6.5,0.5).Z(49.0,2.9).u(0.658,3.28).v(12.75,3.25).w(30.0,0).x(500).y(335);
		boot.K.b.U(boot.P.ep).V(440,96).W(7.5,0.85).X(205,40.0).Y(6.45,0.45).Z(54.1,4.2).u(0.625,2.1).v(19.0,3.8).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.fa).V(340,70).W(4.5,0.55).X(265,45.0).Y(7.0,0.65).Z(47.0,3.0).u(0.644,2.3).v(6.0,3.3).w(30.0,0).x(550).y(330);
		boot.K.b.U(boot.P.fb).V(375,71).W(4.5,0.55).X(240,60.0).Y(6.8,0.65).Z(48.8,3.0).u(0.625,2.14).v(7.4,3.8).w(30.0,0).x(550).y(335);
		boot.K.b.U(boot.P.fc).V(385,78).W(6.75,0.65).X(240,50.0).Y(6.8,0.65).Z(49.0,3.0).u(0.625,2.11).v(12.0,4.0).w(30.0,0).x(500).y(335);
		boot.K.b.U(boot.P.fd).V(380,78).W(5.5,0.6).X(250,50.0).Y(6.9,0.6).Z(51.0,2.9).u(0.625,2.0).v(15.0,3.4).w(30.0,0).x(550).y(330);
		boot.K.b.U(boot.P.fe).V(440,85).W(7.25,0.75).X(260,40.0).Y(6.75,0.5).Z(50.0,3.1).u(0.668,2.7).v(17.0,3.5).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.ff).V(468,90).W(7.1,0.5).X(255,56.0).Y(4.1,0.4).Z(58.0,3.5).u(0.625,2.02).v(16.5,3.2).w(30.0,1.25).x(125).y(340);
		boot.K.b.U(boot.P.fg).V(383,82).W(4.65,0.65).X(200,40.0).Y(6.45,0.45).Z(44.5,3.0).u(0.69,3.38).v(14.0,3.75).w(30.0,0).x(500).y(330);
		boot.K.b.U(boot.P.fh).V(415,82).W(5.1,0.65).X(193,32.0).Y(6.45,0.45).Z(46.5,3.0).u(0.658,3.01).v(15.0,3.0).w(30.0,0).x(550).y(325);
		boot.K.b.U(boot.P.fi).V(455,96).W(8.0,0.85).X(206,45.0).Y(6.9,0.6).Z(54.66,3.0).u(0.672,2.9).v(19.0,2.7).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.fj).V(461,98).W(7.9,0.9).Z(56.0,3.2).u(0.644,2.9).v(14.9,3.1).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.fk).V(384,82).W(4.5,0.6).X(202,38.0).Y(6.5,0.5).Z(46.61,3.3).u(0.651,3.22).v(111.25,3.15).w(30.0,0).x(525).y(330);
		boot.K.b.U(boot.P.fl).V(389,81).W(5.0,0.6).X(220,40.0).Y(6.5,0.45).Z(49.0,3.0).u(0.679,3.38).v(14.0,3.0).w(30.0,0).x(550).y(330);
		boot.K.b.U(boot.P.fm).V(427,99).W(7.45,0.75).X(220,30.0).Y(6.4,0.45).Z(52.91,3.2).u(0.658,2.67).v(14.75,4.0).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.fn).V(437,89).W(5.5,0.6).X(220,55.0).Y(7.5,0.65).Z(48.0,3.6).u(0.644,2.9).v(15.0,3.3).w(30.0,0).x(425).y(335);
		boot.K.b.U(boot.P.fo).V(400,82).W(4.5,0.55).X(250,36.0).Y(6.5,0.5).Z(46.0,3.0).u(0.658,2.65).v(13.5,3.4).w(30.0,0).x(575).y(335);
		boot.K.b.U(boot.P.fp).V(359,83).W(4.5,0.55).X(173,27.0).Y(6.3,0.4).Z(50.0,3.25).u(0.658,3.1).v(9.3,3.4).w(30.0,0).x(550).y(330);
		boot.K.b.U(boot.P.ga).V(355,82).W(4.5,0.55).X(250,55.0).Y(6.9,0.6).Z(48.3,2.625).u(0.625,2.24).v(12.25,3.75).w(30.0,0).x(525).y(340);
		boot.K.b.U(boot.P.gb).V(440,85).W(7.5,0.9).X(220,45.0).Y(7.0,0.65).Z(55.0,3.5).u(0.643,2.5).v(16.0,3.5).w(30.0,1.25).x(125).y(350);
		boot.K.b.U(boot.P.gc).V(385,78).W(6.75,0.65).X(240,50.0).Y(6.9,0.45).Z(49.0,3.0).u(0.625,2.11).v(12.0,4.0).w(30.0,0).x(525).y(335);
		boot.K.b.U(boot.P.gd).V(400,85).W(6.0,0.6).Z(45.0,3.0).u(0.6258,2.0).v(12.0,3.5).w(30.0,0).x(450).y(335);
		boot.K.b.U(boot.P.ge).V(440,86).W(7.0,0.65).X(220,30.0).Y(7.0,0.65).Z(54.0,3.3).u(0.625,2.9).v(16.5,3.5).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.gf).V(428,98).W(7.05,0.8).X(190,30.0).Y(7.1,0.6).Z(56.76,3.375).u(0.679,2.88).v(16.0,3.5).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.gg).V(435,85).W(5.1,0.65).X(202,38.0).Y(6.9,0.65).Z(54.0,3.2).u(0.658,3.0).v(15.0,3.5).w(30.0,1.25).x(175).y(345);
		boot.K.b.U(boot.P.gh).V(380,80).W(5.0,0.55).X(250,45.0).Y(8.0,0.6).Z(52.0,3.0).u(0.625,1.36).v(12.6,3.4).w(30.0,0).x(550).y(340);
		boot.K.b.U(boot.P.gi).V(445,87).W(7.0,0.7).X(213,31.0).Y(6.6,0.45).Z(52.0,3.3).u(0.672,2.7).v(16.2,3.7).w(30.0,1.25).x(175).y(345);
		boot.K.b.U(boot.P.gj).V(421,85).W(8.5,0.7).X(235,35.0).Y(6.5,0.45).Z(51.5,3.5).u(0.625,3.0).v(18.0,3.6).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.gk).V(445,85).W(6.0,0.65).z(20).BA(50).Z(48.6,3.4).u(0.658,3.1).v(17.5,3.5).w(30.0,1.25).x(125).y(345);
		boot.K.b.U(boot.P.gl).V(390,80).W(5.25,0.6).X(250,50.0).Y(6.75,0.6).Z(54.0,3.1).u(0.656,1.7).v(12.0,3.3).w(30.0,0).x(575).y(330);
		boot.K.b.U(boot.P.gm).V(380,71).W(4.6,0.5).X(260,60.0).Y(6.95,0.65).Z(48.6,3.0).u(0.625,2.13).v(6.75,3.8).w(30.0,0).x(600).y(335);
		boot.K.b.U(boot.P.gn).V(355,74).W(4.85,0.5).X(250,50.0).Y(7.1,0.75).Z(50.0,3.2).u(0.625,1.8).v(11.0,3.0).w(30.0,0).x(575).y(325);
		boot.K.c=new boot.K(1520,2012,12,3,"Preseason 3",boot.K.b,0);
		boot.K.c.Q("Shard of True Ice");
		boot.K.c.Q("Liandry's Torment");
		boot.K.c.Q("Haunting Guise");
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
	Q:function(A,B){
		B=new boot.O(A,this,0);
		this.e.BB(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	U:function(A){
		A.go=new boot.Q(this,A.go,0);
		return A.go;
	}
});

boot.defineNative("History",{
	
	// booton.translator.web.History#<init>()
	$0:function(){
	}
});
boot.define("w",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	M:function(){
		return this.b<boot.v.EQ(this.a).length;
	},
	// js.util.ArrayList$View#next()
	P:function(){
		return boot.v.EQ(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	O:function(){
		if(this.b<=0){
		}else{
			boot.v.EQ(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.w.prototype.$1.call(this,A);
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
	ER:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	ES:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	ET:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	EU:function(){
		console.log(this.a);
	}
});

boot.define("BA",boot.BB,{
	
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

boot.define("z",boot.BA,{
	
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

boot.define("y",boot.z,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.z.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.z.prototype.$1.call(this,A);
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

boot.define("v",boot.X,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.X.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	BK:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BN:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	L:function(){
		return new boot.w(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	Bx:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	ED:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BX:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	EE:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	EG:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	EH:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	EI:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	EJ:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	EK:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	EL:function(){
		throw new boot.x(0);
	},
	// js.util.ArrayList#listIterator(int)
	EM:function(A){
		throw new boot.x(0);
	},
	// js.util.ArrayList#subList(int, int)
	EO:function(A,B){
		throw new boot.x(0);
	},
	// js.util.ArrayList#checkRange(int)
	EP:function(A){
		if(A>=0){
			if(this.BK()>A){
				return;
			}else{
				throw new boot.y("Index is overflowed. Size: "+this.BK()+"  Index: "+A,0);
			}
		}else{
			throw new boot.y("Negative index is unacceptable. Size: "+this.BK()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_EQ:function(A){
		return A.a;
	}
});

boot.define("F",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("BC",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("E",{
	
	// js.Application$Route#<init>(java.lang.String, java.lang.Class)
	$1:function(A,B){
		this.a=new RegExp(A.replace(/\*/g,"([^/].+)"),"");
		this.b=B;
	},
	// js.Application$Route#match(java.lang.String)
	EV:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.v(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.CB());
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
	_EA:function(A,B){
		return A.EV(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.E.prototype.$1.call(this,A,B);
	}
});

boot.define("D",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.v(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.Dz(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	Dz:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.L();
		l3:while (C.M()!=0) {
			B=C.P();
			D=boot.E.EA(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.EB(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	EC:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.EB(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.D.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.Dz(B);
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

boot.define("I",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("d");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.a.J("li").addClass("e");
		C.J("a").addClass("c").attr("href",B).text(A);
		return new boot.J(this,C,null,1);
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("BD",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.G.EY(this.a,boot.G.EX(this.a)+1);
	}
});

boot.define("BE",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.G.EY(this.a,boot.G.EX(this.a)-1);
	}
});

boot.define("G",boot.F,{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.G.prototype.$1.call(this,boot.P.BG(A));
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
	EB:function(A,B,C){
		B=A.K("f").css("background-image","url('"+this.a.BE()+"')").K("g");
		C=B.K("h").css("background-image","url("+this.a.BF()+")").click(new boot.BD(this,0)).on("contextmenu",new boot.BE(this,0));
		this.b=C.K("i");
		this.c=B.K("j").text("Health").K("k");
		this.EW(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	EW:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.BD();
			this.c.text(""+B.Dx(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.ha;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_EX:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_EY:function(A,B){
		A.EW(B);
	}
});

boot.define("BI",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BI.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BK",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.FB(this.b);
	}
});

boot.define("BJ",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BH.Ex(this.a).BV().L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.a.Ew(C.BW()).toLowerCase().indexOf(B) != -1==0){
				C.BQ().addClass("o");
				continue l2;
			}else{
				C.BQ().removeClass("o");
				continue l2;
			}
		}
	}
});

boot.define("BH",boot.BI,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BI.prototype.$0.call(this);
		this.b=new boot.R(0);
		this.c=this.Eu();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	EZ:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("l").css("display","block");
		B.keyup(new boot.BJ(this,B,0));
		D=this.c.L();
		l6:for (;
		D.M()!=0;
		this.b.BB(C,E)) {
			C=D.P();
			E=this.a.K("m").css("background-image","url("+this.Ev(C)+")");
			E.J("span").addClass("n").text(this.Ew(C));
			E.click(new boot.BK(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_Ex:function(A){
		return A.b;
	}
});

boot.define("BG",boot.BH,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BH.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	Eu:function(){
		return boot.P.BI();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	Ey:function(A){
		return A.ha;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	Ez:function(A){
		return A.BF();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	FA:function(A){
		boot.B.G(new boot.G(A.ha,0));
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

boot.define("H",boot.F,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.F.prototype.$0.call(this);
		this.a=new boot.BG(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	EB:function(A){
		this.a.EZ(A);
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
	A:function(A,B,C){
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
		C=boot.K;
		console.log(C);
		console.log("boot."+C.className);
		console.log(C.className);
		console.log(C.getMethods());
	}
});

try {new boot.A(0).A();} catch(e) {console.log(e)}