boot.defineNative("Document",{
	
	// booton.translator.web.Document#<init>()
	$0:function(){
	},
	// booton.translator.web.Document#createElement(java.lang.String)
	createElement:function(A){
		return this.createElement(A);
	}
});
boot.define("L",{
	
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
		return new boot.L(this,0);
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

boot.define("F",{
	
	// js.Page#<init>()
	$0:function(){
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
		this.d=boot.U.Bu(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	O:function(){
		if(this.b<=0){
		}else{
			this.a.BU(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.v.prototype.$1.call(this,A,B);
	}
});

boot.define("Z",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	BD:function(){
		return this.BC()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BS:function(A,B,C,D){
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
	BT:function(A,B,C,D){
		B=0;
		D=this.L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(A.BF(C)!=0){
			}else{
				B=this.BU(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BV:function(A,B,C,D){
		B=0;
		D=A.L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.BU(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BW:function(A,B,C){
		C=A.L();
		l1:while (C.M()!=0) {
			B=C.P();
			if(this.BF(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BX:function(){
		return this.BY(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BY:function(A,B,C,D,E){
		B=this.BC();
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

boot.define("Y",boot.Z,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.Z.prototype.$0.call(this);
	}
});

boot.define("U",boot.Y,{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	BC:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BF:function(A){
		return this.BZ(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.BZ(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BU:function(A,B){
		B=this.BZ(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BP:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	L:function(){
		return new boot.v(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	BZ:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	BH:function(A){
		return this.b[this.BZ(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	BJ:function(A,B,C){
		B=null;
		C=this.BZ(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	BL:function(A,B,C){
		B=null;
		C=this.BZ(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_Bu:function(A){
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
	M:function(){
		return this.b.M();
	},
	// js.util.HashMap$View#next()
	P:function(A){
		A=this.b.P();
		if(this.c==0){
			return A.BI();
		}else{
			return A.BO();
		}
	},
	// js.util.HashMap$View#remove()
	O:function(){
		this.b.O();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.u.prototype.$1.call(this,A,B,C);
	}
});

boot.define("W",boot.Y,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.Y.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	BC:function(){
		return boot.Q.BR(this.a).BC();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BF:function(A){
		return boot.Q.BR(this.a).BF(A);
	},
	// js.util.HashMap$Keys#iterator()
	L:function(){
		return new boot.u(this.a,boot.Q.BR(this.a).L(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BU:function(A){
		return boot.Q.BR(this.a).BU(A);
	},
	// js.util.HashMap$Keys#clear()
	BP:function(){
		boot.Q.BR(this.a).BP();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.W.prototype.$1.call(this,A);
	}
});

boot.define("V",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	BO:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	BI:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	Bv:function(A,B){
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

boot.define("X",boot.Z,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.Z.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BC:function(){
		return boot.Q.BR(this.a).BC();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BF:function(A){
		return this.a.BG(A);
	},
	// js.util.HashMap$Values#iterator()
	L:function(){
		return new boot.u(this.a,boot.Q.BR(this.a).L(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BU:function(A,B,C){
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
	BP:function(){
		boot.Q.BR(this.a).BP();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.X.prototype.$1.call(this,A);
	}
});

boot.define("Q",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.U(0);
	},
	// js.util.HashMap#size()
	BC:function(){
		return this.a.BC();
	},
	// js.util.HashMap#isEmpty()
	BD:function(){
		return this.a.BD();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	BE:function(A){
		return this.a.BF(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	BG:function(A,B,C){
		C=this.BB().L();
		l1:while (C.M()!=0) {
			B=C.P();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	BA:function(A,B){
		B=this.a.BH(A);
		return (B==null?null:B.BI());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	V:function(A,B,C){
		C=this.a.BJ(new boot.V(A,B,null,0));
		if(C!=null){
			return C.BI();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	BK:function(A,B){
		B=this.a.BL(A);
		if(B!=null){
			return B.BI();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	BM:function(A,B,C){
		C=A.BN().L();
		l1:for (;
		C.M()!=0;
		this.V(B.BO(),B.BI())) {
			B=C.P();
		}
	},
	// js.util.HashMap#clear()
	BP:function(){
		this.a.BP();
	},
	// js.util.HashMap#keySet()
	BQ:function(){
		return new boot.W(this,null,0);
	},
	// js.util.HashMap#values()
	BB:function(){
		return new boot.X(this,null,0);
	},
	// js.util.HashMap#entrySet()
	BN:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_BR:function(A){
		return A.a;
	}
});

boot.define("T",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.T.b=new boot.Q(0);
		boot.T.c=new boot.T("Ahri",0);
		boot.T.d=new boot.T("Akali",0);
		boot.T.e=new boot.T("Alistar",0);
		boot.T.f=new boot.T("Amumu",0);
		boot.T.g=new boot.T("Ashe",0);
		boot.T.h=new boot.T("Blitzcrank",0);
		boot.T.i=new boot.T("Brand",0);
		boot.T.j=new boot.T("Caitlyn",0);
		boot.T.k=new boot.T("Cassiopeia",0);
		boot.T.l=new boot.T("Chogath",0);
		boot.T.m=new boot.T("Corki",0);
		boot.T.n=new boot.T("Darius",0);
		boot.T.o=new boot.T("Diana",0);
		boot.T.p=new boot.T("Dr.Mundo",0);
		boot.T.ba=new boot.T("Elise",0);
		boot.T.bb=new boot.T("Evelynn",0);
		boot.T.bc=new boot.T("Ezreal",0);
		boot.T.bd=new boot.T("Fiddlesticks",0);
		boot.T.be=new boot.T("Fiora",0);
		boot.T.bf=new boot.T("Fizz",0);
		boot.T.bg=new boot.T("Galio",0);
		boot.T.bh=new boot.T("Gangplank",0);
		boot.T.bi=new boot.T("Garen",0);
		boot.T.bj=new boot.T("Gragas",0);
		boot.T.bk=new boot.T("Graves",0);
		boot.T.bl=new boot.T("Hecarim",0);
		boot.T.bm=new boot.T("Heimerdinger",0);
		boot.T.bn=new boot.T("Irelia",0);
		boot.T.bo=new boot.T("Janna",0);
		boot.T.bp=new boot.T("Jarvan IV",0);
		boot.T.ca=new boot.T("Jax",0);
		boot.T.cb=new boot.T("Jayce",0);
		boot.T.cc=new boot.T("Karma",0);
		boot.T.cd=new boot.T("Karthus",0);
		boot.T.ce=new boot.T("Kassadin",0);
		boot.T.cf=new boot.T("Katarina",0);
		boot.T.cg=new boot.T("Kayle",0);
		boot.T.ch=new boot.T("Kennen",0);
		boot.T.ci=new boot.T("Kha'zix",0);
		boot.T.cj=new boot.T("Kog'maw",0);
		boot.T.ck=new boot.T("LeBlanc",0);
		boot.T.cl=new boot.T("Lee Sin",0);
		boot.T.cm=new boot.T("Leona",0);
		boot.T.cn=new boot.T("Lulu",0);
		boot.T.co=new boot.T("Lux",0);
		boot.T.cp=new boot.T("Malphite",0);
		boot.T.da=new boot.T("Maokai",0);
		boot.T.db=new boot.T("Master Yi",0);
		boot.T.dc=new boot.T("Miss Fortune",0);
		boot.T.dd=new boot.T("Mordekaiser",0);
		boot.T.de=new boot.T("Morgana",0);
		boot.T.df=new boot.T("Nami",0);
		boot.T.dg=new boot.T("Nasus",0);
		boot.T.dh=new boot.T("Nautilus",0);
		boot.T.di=new boot.T("Nidalee",0);
		boot.T.dj=new boot.T("Nocturne",0);
		boot.T.dk=new boot.T("Nunu",0);
		boot.T.dl=new boot.T("Olaf",0);
		boot.T.dm=new boot.T("Orianna",0);
		boot.T.dn=new boot.T("Pantheon",0);
		boot.T.dp=new boot.T("Poppy",0);
		boot.T.ea=new boot.T("Rammus",0);
		boot.T.eb=new boot.T("Renekton",0);
		boot.T.ec=new boot.T("Rengar",0);
		boot.T.ed=new boot.T("Riven",0);
		boot.T.ee=new boot.T("Rumble",0);
		boot.T.ef=new boot.T("Ryze",0);
		boot.T.eg=new boot.T("Sejuani",0);
		boot.T.eh=new boot.T("Shaco",0);
		boot.T.ei=new boot.T("Shen",0);
		boot.T.ej=new boot.T("Shyvana",0);
		boot.T.ek=new boot.T("Singed",0);
		boot.T.el=new boot.T("Sion",0);
		boot.T.em=new boot.T("Sivir",0);
		boot.T.en=new boot.T("Skarner",0);
		boot.T.eo=new boot.T("Sona",0);
		boot.T.ep=new boot.T("Soraka",0);
		boot.T.fa=new boot.T("Swain",0);
		boot.T.fb=new boot.T("Syndra",0);
		boot.T.fc=new boot.T("Talon",0);
		boot.T.fd=new boot.T("Taric",0);
		boot.T.fe=new boot.T("Teemo",0);
		boot.T.ff=new boot.T("Tristana",0);
		boot.T.fg=new boot.T("Trundle",0);
		boot.T.fh=new boot.T("Tryndamere",0);
		boot.T.fi=new boot.T("Twisted Fate",0);
		boot.T.fj=new boot.T("Twitch",0);
		boot.T.fk=new boot.T("Udyr",0);
		boot.T.fl=new boot.T("Urgot",0);
		boot.T.fm=new boot.T("Varus",0);
		boot.T.fn=new boot.T("Vayne",0);
		boot.T.fo=new boot.T("Veigar",0);
		boot.T.fp=new boot.T("Vi",0);
		boot.T.ga=new boot.T("Viktor",0);
		boot.T.gb=new boot.T("Vladimir",0);
		boot.T.gc=new boot.T("Volibear",0);
		boot.T.gd=new boot.T("Warwick",0);
		boot.T.ge=new boot.T("Wukong",0);
		boot.T.gf=new boot.T("Xerath",0);
		boot.T.gg=new boot.T("Xin Zhao",0);
		boot.T.gh=new boot.T("Yorick",0);
		boot.T.gi=new boot.T("Zed",0);
		boot.T.gj=new boot.T("Ziggs",0);
		boot.T.gk=new boot.T("Zilean",0);
		boot.T.gl=new boot.T("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.gm=this.x().toLowerCase();
		boot.T.b.V(A,this);
	},
	// teemowork.model.Champion#getSystemName()
	x:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	y:function(){
		return "src/main/resources/teemowork/splash/"+this.x()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	u:function(){
		return "src/main/resources/teemowork/icon/"+this.x()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_z:function(A){
		return boot.T.b.BA(A);
	},
	// teemowork.model.Champion#getAll()
	_X:function(){
		return boot.T.b.BB();
	}
});

boot.define("R",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.O.W(this.a).BN().L();
		l2:while (D.M()!=0) {
			C=D.P();
			if(this.a.U(C.BO()).toLowerCase().indexOf(B) != -1==0){
				C.BI().addClass("i");
				continue l2;
			}else{
				C.BI().removeClass("i");
				continue l2;
			}
		}
	}
});

boot.define("P",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.P.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("S",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.w(this.b);
	}
});

boot.define("O",boot.P,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.P.prototype.$0.call(this);
		this.b=new boot.Q(0);
		this.c=this.S();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	R:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("f").css("display","block");
		B.keyup(new boot.R(this,B,0));
		D=this.c.L();
		l6:for (;
		D.M()!=0;
		this.b.V(C,E)) {
			C=D.P();
			E=this.a.K("g").css("background-image","url("+this.T(C)+")");
			E.J("span").addClass("h").text(this.U(C));
			E.click(new boot.S(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_W:function(A){
		return A.b;
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
		boot.G.prototype.$1.call(this,boot.T.z(A));
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
	Q:function(A){
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
boot.define("z",boot.x,{
	
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

boot.define("BD",boot.z,{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.z.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.z.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.z.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.z.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.z.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BC",boot.BD,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.BD.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.BD.prototype.$1.call(this,A);
	}
});

boot.define("BB",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	M:function(){
		return this.b<boot.BA.CO(this.a).length;
	},
	// js.util.ArrayList$View#next()
	P:function(){
		return boot.BA.CO(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	O:function(){
		if(this.b<=0){
		}else{
			boot.BA.CO(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.BB.prototype.$1.call(this,A);
	}
});

boot.define("BA",boot.Z,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.Z.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	BC:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BF:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	L:function(){
		return new boot.BB(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BU:function(A,B){
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
	BP:function(){
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
		throw new boot.w(0);
	},
	// js.util.ArrayList#listIterator(int)
	CL:function(A){
		throw new boot.w(0);
	},
	// js.util.ArrayList#subList(int, int)
	CM:function(A,B){
		throw new boot.w(0);
	},
	// js.util.ArrayList#checkRange(int)
	CN:function(A){
		if(A>=0){
			if(this.BC()>A){
				return;
			}else{
				throw new boot.BC("Index is overflowed. Size: "+this.BC()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BC("Negative index is unacceptable. Size: "+this.BC()+"  Index: "+A,0);
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
			C=new boot.BA(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
			} catch ($) {
				if ($ instanceof boot.z) {
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
		return A.CB(B);
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
		this.a=new boot.BA(0);
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
				D.Q(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	CQ:function(A,B){
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

boot.define("N",boot.O,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.O.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	S:function(){
		return boot.T.X();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	Y:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	Z:function(A){
		return A.u();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	v:function(A){
		boot.B.G(new boot.G(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	U:function(A){
		return this.Y(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	T:function(A){
		return this.Z(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	w:function(A){
		this.v(A);
	}
});

boot.define("H",boot.F,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.F.prototype.$0.call(this);
		this.a=new boot.N(this,0);
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