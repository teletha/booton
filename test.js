boot.defineNative("Document",{
	
	// booton.translator.web.Document#<init>()
	$0:function(){
	},
	// booton.translator.web.Document#createElement(java.lang.String)
	createElement:function(A){
		return this.createElement(A);
	}
});
boot.define("R",{
	
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
	Y:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	Z:function(){
	},
	// booton.translator.web.jQuery$1#next()
	N:function(){
		return this.Y();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	Q:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	O:function(A){
		return this.Q("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	M:function(){
		return new boot.R(this,0);
	}
});
boot.define("O",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.L.U(this.a).V().M();
		l2:while (D.T()!=0) {
			C=D.N();
			if(this.a.R(C.W()).toLowerCase().indexOf(B) != -1==0){
				C.X().addClass("d");
				continue l2;
			}else{
				C.X().removeClass("d");
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
	v:function(){
		return this.u()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BJ:function(A,B,C,D){
		B=0;
		D=A.M();
		l2:while (D.T()!=0) {
			C=D.N();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BK:function(A,B,C,D){
		B=0;
		D=this.M();
		l2:while (D.T()!=0) {
			C=D.N();
			if(A.x(C)!=0){
			}else{
				B=this.BL(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BM:function(A,B,C,D){
		B=0;
		D=A.M();
		l2:while (D.T()!=0) {
			C=D.N();
			if(this.BL(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BN:function(A,B,C){
		C=A.M();
		l1:while (C.T()!=0) {
			B=C.N();
			if(this.x(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BO:function(){
		return this.BP(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BP:function(A,B,C,D,E){
		B=this.u();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.M();
		D=0;
		l6:while (C.T()!=0) {
			E=C.N();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("X",boot.Y,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
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
	N:function(){
		this.d=boot.T.BR(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	Z:function(){
		if(this.b<=0){
		}else{
			this.a.BL(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.Z.prototype.$1.call(this,A,B);
	}
});

boot.define("T",boot.X,{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.X.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	u:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	x:function(A){
		return this.BQ(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.BQ(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BL:function(A,B){
		B=this.BQ(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BG:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	M:function(){
		return new boot.Z(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	BQ:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	BB:function(A){
		return this.b[this.BQ(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	BC:function(A,B,C){
		B=null;
		C=this.BQ(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	BE:function(A,B,C){
		B=null;
		C=this.BQ(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_BR:function(A){
		return A.b;
	}
});

boot.define("u",{
	
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
	N:function(A){
		A=this.b.N();
		if(this.c==0){
			return A.X();
		}else{
			return A.W();
		}
	},
	// js.util.HashMap$View#remove()
	Z:function(){
		this.b.Z();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.u.prototype.$1.call(this,A,B,C);
	}
});

boot.define("W",boot.Y,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.Y.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	u:function(){
		return boot.N.BI(this.a).u();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	x:function(A){
		return this.a.y(A);
	},
	// js.util.HashMap$Values#iterator()
	M:function(){
		return new boot.u(this.a,boot.N.BI(this.a).M(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BL:function(A,B,C){
		B=this.M();
		l2:while (B.T()!=0) {
			C=B.N();
			if(C!=A){
			}else{
				B.Z();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BG:function(){
		boot.N.BI(this.a).BG();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.W.prototype.$1.call(this,A);
	}
});

boot.define("U",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	W:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	X:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	BS:function(A,B){
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
		boot.U.prototype.$1.call(this,A,B);
	}
});

boot.define("V",boot.X,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.X.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	u:function(){
		return boot.N.BI(this.a).u();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	x:function(A){
		return boot.N.BI(this.a).x(A);
	},
	// js.util.HashMap$Keys#iterator()
	M:function(){
		return new boot.u(this.a,boot.N.BI(this.a).M(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BL:function(A){
		return boot.N.BI(this.a).BL(A);
	},
	// js.util.HashMap$Keys#clear()
	BG:function(){
		boot.N.BI(this.a).BG();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.V.prototype.$1.call(this,A);
	}
});

boot.define("N",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.T(0);
	},
	// js.util.HashMap#size()
	u:function(){
		return this.a.u();
	},
	// js.util.HashMap#isEmpty()
	v:function(){
		return this.a.v();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	w:function(A){
		return this.a.x(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	y:function(A,B,C){
		C=this.z().M();
		l1:while (C.T()!=0) {
			B=C.N();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	BA:function(A,B){
		B=this.a.BB(A);
		return (B==null?null:B.X());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	S:function(A,B,C){
		C=this.a.BC(new boot.U(A,B,null,0));
		if(C!=null){
			return C.X();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	BD:function(A,B){
		B=this.a.BE(A);
		if(B!=null){
			return B.X();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	BF:function(A,B,C){
		C=A.V().M();
		l1:for (;
		C.T()!=0;
		this.S(B.W(),B.X())) {
			B=C.N();
		}
	},
	// js.util.HashMap#clear()
	BG:function(){
		this.a.BG();
	},
	// js.util.HashMap#keySet()
	BH:function(){
		return new boot.V(this,null,0);
	},
	// js.util.HashMap#values()
	z:function(){
		return new boot.W(this,null,0);
	},
	// js.util.HashMap#entrySet()
	V:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_BI:function(A){
		return A.a;
	}
});

boot.define("Q",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.BT(this.b);
	}
});

boot.define("M",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.M.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("L",boot.M,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.M.prototype.$0.call(this);
		this.b=new boot.N(0);
		this.c=this.L();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	K:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("a").css("display","block");
		B.keyup(new boot.O(this,B,0));
		D=this.c.M();
		l6:for (;
		D.T()!=0;
		this.b.S(C,E)) {
			C=D.N();
			E=this.a.O("b").css("background-image","url("+this.P(C)+")");
			E.Q("span").addClass("c").text(this.R(C));
			E.click(new boot.Q(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_U:function(A){
		return A.b;
	}
});

boot.define("F",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("v",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.v.b=new boot.N(0);
		boot.v.c=new boot.v("Ahri",0);
		boot.v.d=new boot.v("Akali",0);
		boot.v.e=new boot.v("Alistar",0);
		boot.v.f=new boot.v("Amumu",0);
		boot.v.g=new boot.v("Ashe",0);
		boot.v.h=new boot.v("Blitzcrank",0);
		boot.v.i=new boot.v("Brand",0);
		boot.v.j=new boot.v("Caitlyn",0);
		boot.v.k=new boot.v("Cassiopeia",0);
		boot.v.l=new boot.v("Chogath",0);
		boot.v.m=new boot.v("Corki",0);
		boot.v.n=new boot.v("Darius",0);
		boot.v.o=new boot.v("Diana",0);
		boot.v.p=new boot.v("Dr.Mundo",0);
		boot.v.ba=new boot.v("Elise",0);
		boot.v.bb=new boot.v("Evelynn",0);
		boot.v.bc=new boot.v("Ezreal",0);
		boot.v.bd=new boot.v("Fiddlesticks",0);
		boot.v.be=new boot.v("Fiora",0);
		boot.v.bf=new boot.v("Fizz",0);
		boot.v.bg=new boot.v("Galio",0);
		boot.v.bh=new boot.v("Gangplank",0);
		boot.v.bi=new boot.v("Garen",0);
		boot.v.bj=new boot.v("Gragas",0);
		boot.v.bk=new boot.v("Graves",0);
		boot.v.bl=new boot.v("Hecarim",0);
		boot.v.bm=new boot.v("Heimerdinger",0);
		boot.v.bn=new boot.v("Irelia",0);
		boot.v.bo=new boot.v("Janna",0);
		boot.v.bp=new boot.v("Jarvan IV",0);
		boot.v.ca=new boot.v("Jax",0);
		boot.v.cb=new boot.v("Jayce",0);
		boot.v.cc=new boot.v("Karma",0);
		boot.v.cd=new boot.v("Karthus",0);
		boot.v.ce=new boot.v("Kassadin",0);
		boot.v.cf=new boot.v("Katarina",0);
		boot.v.cg=new boot.v("Kayle",0);
		boot.v.ch=new boot.v("Kennen",0);
		boot.v.ci=new boot.v("Kha'zix",0);
		boot.v.cj=new boot.v("Kog'maw",0);
		boot.v.ck=new boot.v("LeBlanc",0);
		boot.v.cl=new boot.v("Lee Sin",0);
		boot.v.cm=new boot.v("Leona",0);
		boot.v.cn=new boot.v("Lulu",0);
		boot.v.co=new boot.v("Lux",0);
		boot.v.cp=new boot.v("Malphite",0);
		boot.v.da=new boot.v("Maokai",0);
		boot.v.db=new boot.v("Master Yi",0);
		boot.v.dc=new boot.v("Miss Fortune",0);
		boot.v.dd=new boot.v("Mordekaiser",0);
		boot.v.de=new boot.v("Morgana",0);
		boot.v.df=new boot.v("Nami",0);
		boot.v.dg=new boot.v("Nasus",0);
		boot.v.dh=new boot.v("Nautilus",0);
		boot.v.di=new boot.v("Nidalee",0);
		boot.v.dj=new boot.v("Nocturne",0);
		boot.v.dk=new boot.v("Nunu",0);
		boot.v.dl=new boot.v("Olaf",0);
		boot.v.dm=new boot.v("Orianna",0);
		boot.v.dn=new boot.v("Pantheon",0);
		boot.v.dp=new boot.v("Poppy",0);
		boot.v.ea=new boot.v("Rammus",0);
		boot.v.eb=new boot.v("Renekton",0);
		boot.v.ec=new boot.v("Rengar",0);
		boot.v.ed=new boot.v("Riven",0);
		boot.v.ee=new boot.v("Rumble",0);
		boot.v.ef=new boot.v("Ryze",0);
		boot.v.eg=new boot.v("Sejuani",0);
		boot.v.eh=new boot.v("Shaco",0);
		boot.v.ei=new boot.v("Shen",0);
		boot.v.ej=new boot.v("Shyvana",0);
		boot.v.ek=new boot.v("Singed",0);
		boot.v.el=new boot.v("Sion",0);
		boot.v.em=new boot.v("Sivir",0);
		boot.v.en=new boot.v("Skarner",0);
		boot.v.eo=new boot.v("Sona",0);
		boot.v.ep=new boot.v("Soraka",0);
		boot.v.fa=new boot.v("Swain",0);
		boot.v.fb=new boot.v("Syndra",0);
		boot.v.fc=new boot.v("Talon",0);
		boot.v.fd=new boot.v("Taric",0);
		boot.v.fe=new boot.v("Teemo",0);
		boot.v.ff=new boot.v("Tristana",0);
		boot.v.fg=new boot.v("Trundle",0);
		boot.v.fh=new boot.v("Tryndamere",0);
		boot.v.fi=new boot.v("Twisted Fate",0);
		boot.v.fj=new boot.v("Twitch",0);
		boot.v.fk=new boot.v("Udyr",0);
		boot.v.fl=new boot.v("Urgot",0);
		boot.v.fm=new boot.v("Varus",0);
		boot.v.fn=new boot.v("Vayne",0);
		boot.v.fo=new boot.v("Veigar",0);
		boot.v.fp=new boot.v("Vi",0);
		boot.v.ga=new boot.v("Viktor",0);
		boot.v.gb=new boot.v("Vladimir",0);
		boot.v.gc=new boot.v("Volibear",0);
		boot.v.gd=new boot.v("Warwick",0);
		boot.v.ge=new boot.v("Wukong",0);
		boot.v.gf=new boot.v("Xerath",0);
		boot.v.gg=new boot.v("Xin Zhao",0);
		boot.v.gh=new boot.v("Yorick",0);
		boot.v.gi=new boot.v("Zed",0);
		boot.v.gj=new boot.v("Ziggs",0);
		boot.v.gk=new boot.v("Zilean",0);
		boot.v.gl=new boot.v("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.gm=this.BZ().toLowerCase();
		boot.v.b.S(A,this);
	},
	// teemowork.model.Champion#getSystemName()
	BZ:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	Bu:function(){
		return "src/main/resources/teemowork/splash/"+this.BZ()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	BX:function(){
		return "src/main/resources/teemowork/icon/"+this.BZ()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_Bv:function(A){
		return boot.v.b.BA(A);
	},
	// teemowork.model.Champion#getAll()
	_BU:function(){
		return boot.v.b.z();
	}
});

boot.define("x",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.x.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.x.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.x.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.x.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	Bw:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	Bx:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	Bz:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	CA:function(){
		console.log(this.a);
	}
});

boot.define("w",boot.x,{
	
	// java.lang.Error#<init>()
	$0:function(){
		boot.x.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$1:function(A){
		boot.x.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.x.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$3:function(A){
		boot.x.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.x.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("G",boot.F,{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.G.prototype.$1.call(this,boot.v.Bv(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.F.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.w(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	J:function(A){
		console.log("detail page "+this.a+"  "+this.a.a);
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	}
});

boot.defineNative("History",{
	
	// booton.translator.web.History#<init>()
	$0:function(){
	}
});
boot.define("BD",boot.x,{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.x.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.x.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.x.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.x.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.x.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BC",boot.BD,{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.BD.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.BD.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.BD.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BD.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.BD.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BB",boot.BC,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.BC.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.BC.prototype.$1.call(this,A);
	}
});

boot.define("BA",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	T:function(){
		return this.b<boot.z.CP(this.a).length;
	},
	// js.util.ArrayList$View#next()
	N:function(){
		return boot.z.CP(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	Z:function(){
		if(this.b<=0){
		}else{
			boot.z.CP(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.BA.prototype.$1.call(this,A);
	}
});

boot.define("z",boot.Y,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	u:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	x:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	M:function(){
		return new boot.BA(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BL:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	CE:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BG:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	CF:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	CG:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	CH:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	CI:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	CJ:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	CK:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	CL:function(){
		throw new boot.w(0);
	},
	// js.util.ArrayList#listIterator(int)
	CM:function(A){
		throw new boot.w(0);
	},
	// js.util.ArrayList#subList(int, int)
	CN:function(A,B){
		throw new boot.w(0);
	},
	// js.util.ArrayList#checkRange(int)
	CO:function(A){
		if(A>=0){
			if(this.u()>A){
				return;
			}else{
				throw new boot.BB("Index is overflowed. Size: "+this.u()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BB("Negative index is unacceptable. Size: "+this.u()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_CP:function(A){
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
	CQ:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.z(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
			} catch ($) {
				if ($ instanceof boot.BD) {
					console.log(D);
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_CC:function(A,B){
		return A.CQ(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.E.prototype.$1.call(this,A,B);
	}
});

boot.define("BE",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("D",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.z(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.CB(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	CB:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.M();
		l3:while (C.T()!=0) {
			B=C.N();
			D=boot.E.CC(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.J(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	CD:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.J(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.D.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.CB(B);
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

boot.define("K",boot.L,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.L.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	L:function(){
		return boot.v.BU();
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
	R:function(A){
		return this.BV(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	P:function(A){
		return this.BW(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	BT:function(A){
		this.BY(A);
	}
});

boot.define("H",boot.F,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.F.prototype.$0.call(this);
		this.a=new boot.K(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	J:function(A){
		this.a.K(A);
	},
	// teemowork.ChampionSelect#getPageId()
	H:function(){
		return "";
	}
});

boot.define("J",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;;
		this.b=B.Q("ul").addClass("e");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.Q("li").addClass("f");
		C.Q("a").addClass("g").attr("href",B).text(A);
		return new boot.J(this.a,C,0);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
	$1:function(A,B,C){
		boot.J.prototype.$0.call(this,A,B);
	}
});

boot.define("I",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("h");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.a.Q("li").addClass("i");
		C.Q("a").addClass("g").attr("href",B).text(A);
		return new boot.J(this,C,null,1);
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
	}
});

try {new boot.A(0).A();} catch(e) {console.log(e)}