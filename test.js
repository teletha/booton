boot.define("P","",{
	
	// js.lang.reflect.JSAnnotatedElement#<init>(java.lang.String, js.lang.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// js.lang.reflect.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	O:function(A){
		return this.E(A)!=null;
	},
	// js.lang.reflect.JSAnnotatedElement#getAnnotation(java.lang.Class)
	E:function(A,B,C){
		if(this.b==null){
		}else{
			B=0;
			l4:for (;
			B<this.b.length;
			++B) {
				C=this.b[B];
				if(C[0].equals(A.P())==0){
				}else{
					return C[1];
				}
			}
		}return null;
	},
	// js.lang.reflect.JSAnnotatedElement#getAnnotations()
	Q:function(){
		return null;
	},
	// js.lang.reflect.JSAnnotatedElement#getDeclaredAnnotations()
	R:function(){
		return this.Q();
	}
},{
	"$":[["Q",{
		S:function() {return boot.R.$;}
	}]]
});

boot.define("K","P",{
	
	// js.lang.reflect.JSConstructor#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeFunction, js.lang.NativeArray)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	},
	// js.lang.reflect.JSConstructor#newInstance(java.lang.Object[])
	Z:function(A,B){
		B=Object.create(this.c);
		this.d.apply(B,A);
		return B;
	}
},{
	"$":[["Q",{
		S:function() {return boot.K.$;}
	}]]
});

boot.define("S","P",{
	
	// js.lang.reflect.JSMethod#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeFunction, js.lang.NativeArray)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	}
},{
	"$":[["Q",{
		S:function() {return boot.S.$;}
	}]]
});

boot.define("V","",{
	
	// js.lang.JSThrowable#<init>()
	$0:function(){
		boot.V.prototype.$1.call(this,"",null);
	},
	// js.lang.JSThrowable#<init>(java.lang.String)
	$2:function(A){
		boot.V.prototype.$1.call(this,A,null);
	},
	// js.lang.JSThrowable#<init>(java.lang.Throwable)
	$3:function(A){
		boot.V.prototype.$1.call(this,"",A);
	},
	// js.lang.JSThrowable#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.lang.JSThrowable#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.V.prototype.$1.call(this,A,B);
	},
	// js.lang.JSThrowable#getMessage()
	w:function(){
		return this.a;
	},
	// js.lang.JSThrowable#getLocalizedMessage()
	x:function(){
		return this.a;
	},
	// js.lang.JSThrowable#getCause()
	y:function(){
		return this.b;
	},
	// js.lang.JSThrowable#toString()
	toString:function(){
		return this.a;
	},
	// js.lang.JSThrowable#printStackTrace()
	z:function(){
		console.log(this.a);
	}
},{
	"$":[["Q",{
		S:function() {return boot.V.$;}
	}]]
});

boot.define("U","V",{
	
	// java.lang.Error#<init>()
	$1:function(){
		boot.V.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$2:function(A){
		boot.V.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$3:function(A,B){
		boot.V.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$0:function(A){
		boot.V.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.V.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("A","P",{
	
	// js.lang.reflect.JSClass#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeObject, js.lang.reflect.JSClass)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,C["$"]);
		this.c=B;
		this.d=C;
		this.e=D;
	},
	// js.lang.reflect.JSClass#getConstructors()
	D:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")==0){
			}else{
				A.push(new boot.K(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getMethods()
	T:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")!=0){
			}else{
				A.push(new boot.S(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getDeclaredMethods()
	U:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")!=0){
			}else{
				A.push(new boot.S(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#isAssignableFrom(java.lang.Class)
	V:function(A){
		l1:for (;
		A!=null;
		A=A.W()) {
			if(this!=A){
			}else{
				return true;
			}
		}return false;
	},
	// js.lang.reflect.JSClass#getSuperclass()
	W:function(){
		return this.e;
	},
	// js.lang.reflect.JSClass#getName()
	X:function(){
		return "boot."+this.a;
	},
	// js.lang.reflect.JSClass#getSimpleName()
	P:function(){
		return this.a;
	},
	// js.lang.reflect.JSClass#newInstance()
	Y:function(A){
		try{
			return this.D()[0].Z(new Array(0));
		} catch ($) {
			if ($ instanceof boot.T) {
				throw new boot.U(A,0);
			}
		}
	},
	// js.lang.reflect.JSClass#getConstructor()
	u:function(){
		return null;
	},
	// js.lang.reflect.JSClass#forName(java.lang.String)
	_v:function(A){
		return null;
	}
},{
	"$":[["Q",{
		S:function() {return boot.A.$;}
	}]]
});

boot.define("F","",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("BA","",{
});

boot.define("I","",{
});

boot.define("BH","",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	BR:function(){
		return this.BQ()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	CB:function(A,B,C,D){
		B=0;
		D=A.B();
		l2:while (D.H()!=0) {
			C=D.C();
			if(this.G(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	CC:function(A,B,C,D){
		B=0;
		D=this.B();
		l2:while (D.H()!=0) {
			C=D.C();
			if(A.BT(C)!=0){
			}else{
				B=this.CD(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	CE:function(A,B,C,D){
		B=0;
		D=A.B();
		l2:while (D.H()!=0) {
			C=D.C();
			if(this.CD(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	CF:function(A,B,C){
		C=A.B();
		l1:while (C.H()!=0) {
			B=C.C();
			if(this.BT(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	CG:function(){
		return this.CH(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	CH:function(A,B,C,D,E){
		B=this.BQ();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.B();
		D=0;
		l6:while (C.H()!=0) {
			E=C.C();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("BG","BH",{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.BH.prototype.$0.call(this);
	}
});

boot.define("BI","",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, java.lang.String[])
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	H:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	C:function(){
		this.d=boot.z.CJ(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	CK:function(){
		if(this.b<=0){
		}else{
			this.a.CD(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, java.lang.String[], js.util.HashSet$View)
	$0:function(A,B,C){
		boot.BI.prototype.$1.call(this,A,B);
	}
});

boot.define("z","BG",{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.BG.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	BQ:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BT:function(A){
		return this.CI(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	G:function(A,B){
		B=this.CI(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	CD:function(A,B){
		B=this.CI(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	Bx:function(){
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#iterator()
	B:function(){
		return new boot.BI(this,Object.keys(this.b),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	CI:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	BV:function(A){
		return this.b[this.CI(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	BX:function(A,B,C){
		B=null;
		C=this.CI(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	BZ:function(A,B,C){
		B=null;
		C=this.CI(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_CJ:function(A){
		return A.b;
	}
});

boot.define("BB","",{
});

boot.define("BC","",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	Bw:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	BW:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	CL:function(A,B){
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
		boot.BC.prototype.$1.call(this,A,B);
	}
});

boot.define("y","",{
});

boot.define("BD","",{
});

boot.define("BJ","",{
	
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.a=A;;
		this.b=B;
		this.c=C;
	},
	// js.util.HashMap$View#hasNext()
	H:function(){
		return this.b.H();
	},
	// js.util.HashMap$View#next()
	C:function(A){
		A=this.b.C();
		if(this.c==0){
			return A.BW();
		}else{
			return A.Bw();
		}
	},
	// js.util.HashMap$View#remove()
	CK:function(){
		this.b.CK();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.BJ.prototype.$1.call(this,A,B,C);
	}
});

boot.define("BE","BG",{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.BG.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	BQ:function(){
		return boot.x.CA(this.a).BQ();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BT:function(A){
		return boot.x.CA(this.a).BT(A);
	},
	// js.util.HashMap$Keys#iterator()
	B:function(){
		return new boot.BJ(this.a,boot.x.CA(this.a).B(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	G:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	CD:function(A){
		return boot.x.CA(this.a).CD(A);
	},
	// js.util.HashMap$Keys#clear()
	Bx:function(){
		boot.x.CA(this.a).Bx();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.BE.prototype.$1.call(this,A);
	}
});

boot.define("BF","BH",{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.BH.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BQ:function(){
		return boot.x.CA(this.a).BQ();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BT:function(A){
		return this.a.BU(A);
	},
	// js.util.HashMap$Values#iterator()
	B:function(){
		return new boot.BJ(this.a,boot.x.CA(this.a).B(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	G:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	CD:function(A,B,C){
		B=this.B();
		l2:while (B.H()!=0) {
			C=B.C();
			if(C!=A){
			}else{
				B.CK();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	Bx:function(){
		boot.x.CA(this.a).Bx();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.BF.prototype.$1.call(this,A);
	}
});

boot.define("x","",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.z(0);
	},
	// js.util.HashMap#size()
	BQ:function(){
		return this.a.BQ();
	},
	// js.util.HashMap#isEmpty()
	BR:function(){
		return this.a.BR();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	BS:function(A){
		return this.a.BT(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	BU:function(A,B,C){
		C=this.BP().B();
		l1:while (C.H()!=0) {
			B=C.C();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	BN:function(A,B){
		B=this.a.BV(A);
		return (B==null?null:B.BW());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	BM:function(A,B,C){
		C=this.a.BX(new boot.BC(A,B,null,0));
		if(C!=null){
			return C.BW();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	BY:function(A,B){
		B=this.a.BZ(A);
		if(B!=null){
			return B.BW();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	Bu:function(A,B,C){
		C=A.Bv().B();
		l1:for (;
		C.H()!=0;
		this.BM(B.Bw(),B.BW())) {
			B=C.C();
		}
	},
	// js.util.HashMap#clear()
	Bx:function(){
		this.a.Bx();
	},
	// js.util.HashMap#keySet()
	Bz:function(){
		return new boot.BE(this,null,0);
	},
	// js.util.HashMap#values()
	BP:function(){
		return new boot.BF(this,null,0);
	},
	// js.util.HashMap#entrySet()
	Bv:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_CA:function(A){
		return A.a;
	}
});

boot.define("X","",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.X.b=new boot.x(0);
		boot.X.c=new boot.X("Ahri",0);
		boot.X.d=new boot.X("Akali",0);
		boot.X.e=new boot.X("Alistar",0);
		boot.X.f=new boot.X("Amumu",0);
		boot.X.g=new boot.X("Anivia",0);
		boot.X.h=new boot.X("Annie",0);
		boot.X.i=new boot.X("Ashe",0);
		boot.X.j=new boot.X("Blitzcrank",0);
		boot.X.k=new boot.X("Brand",0);
		boot.X.l=new boot.X("Caitlyn",0);
		boot.X.m=new boot.X("Cassiopeia",0);
		boot.X.n=new boot.X("Chogath",0);
		boot.X.o=new boot.X("Corki",0);
		boot.X.p=new boot.X("Darius",0);
		boot.X.ba=new boot.X("Diana",0);
		boot.X.bb=new boot.X("Dr.Mundo",0);
		boot.X.bc=new boot.X("Draven",0);
		boot.X.bd=new boot.X("Elise",0);
		boot.X.be=new boot.X("Evelynn",0);
		boot.X.bf=new boot.X("Ezreal",0);
		boot.X.bg=new boot.X("Fiddlesticks",0);
		boot.X.bh=new boot.X("Fiora",0);
		boot.X.bi=new boot.X("Fizz",0);
		boot.X.bj=new boot.X("Galio",0);
		boot.X.bk=new boot.X("Gangplank",0);
		boot.X.bl=new boot.X("Garen",0);
		boot.X.bm=new boot.X("Gragas",0);
		boot.X.bn=new boot.X("Graves",0);
		boot.X.bo=new boot.X("Hecarim",0);
		boot.X.bp=new boot.X("Heimerdinger",0);
		boot.X.ca=new boot.X("Irelia",0);
		boot.X.cb=new boot.X("Janna",0);
		boot.X.cc=new boot.X("Jarvan IV",0);
		boot.X.cd=new boot.X("Jax",0);
		boot.X.ce=new boot.X("Jayce",0);
		boot.X.cf=new boot.X("Karma",0);
		boot.X.cg=new boot.X("Karthus",0);
		boot.X.ch=new boot.X("Kassadin",0);
		boot.X.ci=new boot.X("Katarina",0);
		boot.X.cj=new boot.X("Kayle",0);
		boot.X.ck=new boot.X("Kennen",0);
		boot.X.cl=new boot.X("Kha'zix",0);
		boot.X.cm=new boot.X("Kog'maw",0);
		boot.X.cn=new boot.X("LeBlanc",0);
		boot.X.co=new boot.X("Lee Sin",0);
		boot.X.cp=new boot.X("Leona",0);
		boot.X.da=new boot.X("Lulu",0);
		boot.X.db=new boot.X("Lux",0);
		boot.X.dc=new boot.X("Malphite",0);
		boot.X.dd=new boot.X("Malzahar",0);
		boot.X.de=new boot.X("Maokai",0);
		boot.X.df=new boot.X("Master Yi",0);
		boot.X.dg=new boot.X("Miss Fortune",0);
		boot.X.dh=new boot.X("Mordekaiser",0);
		boot.X.di=new boot.X("Morgana",0);
		boot.X.dj=new boot.X("Nami",0);
		boot.X.dk=new boot.X("Nasus",0);
		boot.X.dl=new boot.X("Nautilus",0);
		boot.X.dm=new boot.X("Nidalee",0);
		boot.X.dn=new boot.X("Nocturne",0);
		boot.X.dp=new boot.X("Nunu",0);
		boot.X.ea=new boot.X("Olaf",0);
		boot.X.eb=new boot.X("Orianna",0);
		boot.X.ec=new boot.X("Pantheon",0);
		boot.X.ed=new boot.X("Poppy",0);
		boot.X.ee=new boot.X("Rammus",0);
		boot.X.ef=new boot.X("Renekton",0);
		boot.X.eg=new boot.X("Rengar",0);
		boot.X.eh=new boot.X("Riven",0);
		boot.X.ei=new boot.X("Rumble",0);
		boot.X.ej=new boot.X("Ryze",0);
		boot.X.ek=new boot.X("Sejuani",0);
		boot.X.el=new boot.X("Shaco",0);
		boot.X.em=new boot.X("Shen",0);
		boot.X.en=new boot.X("Shyvana",0);
		boot.X.eo=new boot.X("Singed",0);
		boot.X.ep=new boot.X("Sion",0);
		boot.X.fa=new boot.X("Sivir",0);
		boot.X.fb=new boot.X("Skarner",0);
		boot.X.fc=new boot.X("Sona",0);
		boot.X.fd=new boot.X("Soraka",0);
		boot.X.fe=new boot.X("Swain",0);
		boot.X.ff=new boot.X("Syndra",0);
		boot.X.fg=new boot.X("Talon",0);
		boot.X.fh=new boot.X("Taric",0);
		boot.X.fi=new boot.X("Teemo",0);
		boot.X.fj=new boot.X("Tristana",0);
		boot.X.fk=new boot.X("Trundle",0);
		boot.X.fl=new boot.X("Tryndamere",0);
		boot.X.fm=new boot.X("Twisted Fate",0);
		boot.X.fn=new boot.X("Twitch",0);
		boot.X.fo=new boot.X("Udyr",0);
		boot.X.fp=new boot.X("Urgot",0);
		boot.X.ga=new boot.X("Varus",0);
		boot.X.gb=new boot.X("Vayne",0);
		boot.X.gc=new boot.X("Veigar",0);
		boot.X.gd=new boot.X("Vi",0);
		boot.X.ge=new boot.X("Viktor",0);
		boot.X.gf=new boot.X("Vladimir",0);
		boot.X.gg=new boot.X("Volibear",0);
		boot.X.gh=new boot.X("Warwick",0);
		boot.X.gi=new boot.X("Wukong",0);
		boot.X.gj=new boot.X("Xerath",0);
		boot.X.gk=new boot.X("Xin Zhao",0);
		boot.X.gl=new boot.X("Yorick",0);
		boot.X.gm=new boot.X("Zed",0);
		boot.X.gn=new boot.X("Ziggs",0);
		boot.X.go=new boot.X("Zilean",0);
		boot.X.gp=new boot.X("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.BL().toLowerCase();
		boot.X.b.BM(A,this);
	},
	// teemowork.model.Champion#getStatus()
	BG:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	BL:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	BD:function(){
		return "src/main/resources/teemowork/splash/"+this.BL()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	BE:function(){
		return "src/main/resources/teemowork/icon/"+this.BL()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_BB:function(A){
		return boot.X.b.BN(A);
	},
	// teemowork.model.Champion#getAll()
	_BO:function(){
		return boot.X.b.BP();
	}
});

boot.defineNative("Document",{
	
	// js.dom.Document#<init>()
	$0:function(){
	},
	// js.dom.Document#createElement(java.lang.String)
	createElement:function(A){
		return this.createElement(A);
	}
});
boot.define("BK","",{
	
	// js.util.jQuery$1#<init>(js.util.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// js.util.jQuery$1#hasNext()
	H:function(){
		return this.b<this.a.size();
	},
	// js.util.jQuery$1#next()
	CN:function(){
		return $(this.a.get(this.b++));
	},
	// js.util.jQuery$1#remove()
	CK:function(){
	},
	// js.util.jQuery$1#next()
	C:function(){
		return this.CN();
	}
});

boot.defineNative("jQuery",{
	
	// js.util.jQuery#<init>()
	$0:function(){
	},
	// js.util.jQuery#child(java.lang.String)
	CM:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// js.util.jQuery#child(java.lang.Class)
	BC:function(A){
		return this.CM("span").addClass(A);
	},
	// js.util.jQuery#iterator()
	B:function(){
		return new boot.BK(this,0);
	}
});
boot.defineNative("Event",{
	
	// js.util.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("Z","",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(js.util.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.W.BJ(this.a,boot.W.BI(this.a)+1);
	}
});

boot.define("u","",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(js.util.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.W.BJ(this.a,boot.W.BI(this.a)-1);
	}
});

boot.define("v","",{
	
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
	CO:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	CP:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	CQ:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	CR:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	CS:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	CT:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	CU:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	CV:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	CW:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	CX:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	CY:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	CZ:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	Cu:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	Cv:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	Cw:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	Cx:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	Cy:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	Cz:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DA:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DB:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DC:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DD:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DE:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	DF:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	DG:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	DH:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	DI:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	DJ:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	DK:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	DL:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	DM:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	DN:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	BH:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	DO:function(A){
		return this.g+this.h*A;
	}
});

boot.define("W","F",{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.W.prototype.$1.call(this,boot.X.BB(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.F.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.U(1);
		}
	},
	// teemowork.ChampionDetail#load(js.util.jQuery)
	BA:function(A,B,C){
		B=A.BC("a").css("background-image","url('"+this.a.BD()+"')").BC("b");
		C=B.BC("c").css("background-image","url("+this.a.BE()+")").click(new boot.Z(this,0)).on("contextmenu",new boot.u(this,0));
		this.b=C.BC("d");
		this.c=B.BC("e").text("Health").BC("f");
		this.BF(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	BF:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.BG();
			this.c.text(""+B.BH(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	L:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_BI:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_BJ:function(A,B){
		A.BF(B);
	}
},{
	"$0":[["J",{
		BK:function() {return "Champion/*";}
	}]],"e":[["w",{
	}]]
});

boot.define("BQ","",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BQ.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BR","",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, js.util.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(js.util.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BP.DT(this.a).Bv().B();
		l2:while (D.H()!=0) {
			C=D.C();
			if(this.a.DS(C.Bw()).toLowerCase().indexOf(B) != -1==0){
				C.BW().addClass("j");
				continue l2;
			}else{
				C.BW().removeClass("j");
				continue l2;
			}
		}
	}
});

boot.define("BS","",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(js.util.jQuery$Event)
	handler:function(A){
		this.a.DU(this.b);
	}
});

boot.define("BP","BQ",{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BQ.prototype.$0.call(this);
		this.b=new boot.x(0);
		this.c=this.DQ();
	},
	// js.ui.ImageGrid#compose(js.util.jQuery)
	DP:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BR(this,B,0));
		D=this.c.B();
		l6:for (;
		D.H()!=0;
		this.b.BM(C,E)) {
			C=D.C();
			E=this.a.BC("h").css("background-image","url("+this.DR(C)+")");
			E.CM("span").addClass("i").text(this.DS(C));
			E.click(new boot.BS(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_DT:function(A){
		return A.b;
	}
});

boot.define("BV","",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	H:function(){
		return this.b<boot.BT.EH(this.a).length;
	},
	// js.util.ArrayList$View#next()
	C:function(){
		return boot.BT.EH(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	CK:function(){
		if(this.b<=0){
		}else{
			boot.BT.EH(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.BV.prototype.$1.call(this,A);
	}
});

boot.define("T","V",{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.V.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.V.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.V.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.V.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.V.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BX","T",{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.T.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.T.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.T.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.T.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.T.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BW","BX",{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.BX.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.BX.prototype.$1.call(this,A);
	}
});

boot.define("BT","BH",{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.BH.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	BQ:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BT:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	B:function(){
		return new boot.BV(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	G:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	CD:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	Dv:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	Bx:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	Dw:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	Dx:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	Dy:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	Dz:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	EA:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	EB:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	EC:function(){
		throw new boot.U(1);
	},
	// js.util.ArrayList#listIterator(int)
	ED:function(A){
		throw new boot.U(1);
	},
	// js.util.ArrayList#subList(int, int)
	EE:function(A,B){
		throw new boot.U(1);
	},
	// js.util.ArrayList#checkRange(int)
	EG:function(A){
		if(A>=0){
			if(this.BQ()>A){
				return;
			}else{
				throw new boot.BW("Index is overflowed. Size: "+this.BQ()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BW("Negative index is unacceptable. Size: "+this.BQ()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_EH:function(A){
		return A.a;
	}
});

boot.define("BY","",{
	
	// js.dom.Location#<init>()
	$0:function(){
	}
});

boot.define("H","",{
});

boot.define("J","",{
},{
	"$":[["BZ",{
	}],["Bu",{
		EJ:function() {return [CONSTRUCTOR,TYPE];}
	}],["Bv",{
		EK:function() {return RUNTIME;}
	}]]
});

boot.define("L","",{
	
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo)
	$1:function(A,B){
		this.a=A;
		this.b=new RegExp(B.BK().replace(/\*/g,"([^/].+)"),"");
	},
	// js.Application$Route#match(java.lang.String)
	EI:function(A,B,C,D){
		B=this.b.exec(A);
		if(B!=null!=0){
			C=new boot.BT(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.G(B[D+1]);
			}try{
				return this.a.Z(C.CG());
			} catch ($) {
				if ($ instanceof boot.T) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_DZ:function(A,B){
		return A.EI(B);
	},
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo, js.Application$Route)
	$0:function(A,B,C){
		boot.L.prototype.$1.call(this,A,B);
	}
});

boot.define("E","",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.BT(0);
	},
	// js.Application$Router#handler(js.util.jQuery$Event)
	handler:function(A){
		this.DY(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	DY:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.B();
		l3:while (C.H()!=0) {
			B=C.C();
			D=boot.L.DZ(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.BA(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	Du:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.BA(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router)
	_F:function(A){
		return A.a;
	},
	// js.Application$Router#access$2(js.Application$Router, java.lang.String)
	_I:function(A,B){
		A.DY(B);
	}
},{
	"Du":[["BU",{
	}]]
});

boot.define("G","",{
	
	// js.lang.Classes#<init>()
	$0:function(){
	},
	// js.lang.Classes#find(java.lang.Class)
	_A:function(A,B,C,D,E,F,G){
		B=new boot.BT(0);
		F=Object.keys(boot);E=F.length;D=0;
		l2:while (D<E) {
			C=F[D];
			G=boot[C]["$"];
			if((A==G||A.V(G)==0)){
			}else{
				B.G(G);
			}++D;
			continue l2;
		}return B;
	}
});

boot.defineNative("History",{
	
	// js.dom.History#<init>()
	$0:function(){
	}
});
boot.define("C","",{
	
	// js.Application#<clinit>()
	_:function(){
		boot.C.a=new boot.E(null,0);
	},
	// js.Application#<init>()
	$0:function(A,B,C,D,E){
		B=boot.G.A(boot.F.$).B();
		l2:while (B.H()!=0) {
			A=B.C();
			C=A.D();
			D=0;
			l7:while (D<C.length) {
				E=C[D].E(boot.J.$);
				if(E==null){
				}else{
					boot.E.F(boot.C.a).G(new boot.L(C[D],E,null,0));
				}++D;
				continue l7;
			}continue l2;
		}$(window).on("hashchange",boot.C.a);
		boot.E.I(boot.C.a,location.hash);
	},
	// js.Application#configure(js.application.Header)
	J:function(A){
	},
	// js.Application#show(js.Page)
	_K:function(A){
		if(A==null){
		}else{
			boot.E.I(boot.C.a,A.L());
			history.pushState("","","#"+A.L());
		}
	}
});

boot.define("BO","BP",{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BP.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	DQ:function(){
		return boot.X.BO();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	DV:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	DW:function(A){
		return A.BE();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	DX:function(A){
		boot.C.K(new boot.W(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	DS:function(A){
		return this.DV(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	DR:function(A){
		return this.DW(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	DU:function(A){
		this.DX(A);
	}
});

boot.define("BN","F",{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.F.prototype.$0.call(this);
		this.a=new boot.BO(this,0);
	},
	// teemowork.ChampionSelect#load(js.util.jQuery)
	BA:function(A){
		this.a.DP(A);
	},
	// teemowork.ChampionSelect#getPageId()
	L:function(){
		return "";
	}
},{
	"$0":[["J",{
		BK:function() {return "";}
	}]]
});

boot.define("N","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, js.util.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.CM("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	N:function(A,B,C){
		C=this.b.CM("li").addClass("o");
		C.CM("a").addClass("m").attr("href",B).text(A);
		return new boot.N(this.a,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, js.util.jQuery, js.application.Header$Menu)
	$0:function(A,B,C){
		boot.N.prototype.$1.call(this,A,B);
	}
});

boot.define("M","",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("k");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	N:function(A,B,C){
		C=this.a.CM("li").addClass("l");
		C.CM("a").addClass("m").attr("href",B).text(A);
		return new boot.N(this,C,null,0);
	}
});

boot.define("Bx","",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.Bx.a=new boot.x(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.Bx.a.BN(A);
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
		boot.Bx.a.BM(A,this);
	},
	// teemowork.model.Item#cost()
	ER:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	EM:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	ES:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	ET:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	EU:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	EV:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	EW:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	EX:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	EY:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	EZ:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	Eu:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	Ev:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	Ew:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	Ex:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	Ey:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	EP:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	Ez:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	FA:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	FB:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	FC:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	FD:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	FE:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	FF:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	FG:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	FH:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	EO:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	FI:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	FJ:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FK:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FL:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FM:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FN:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FO:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FP:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FQ:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FR:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FS:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FT:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FU:function(A){
		return boot.Bx.a.BN(A);
	},
	// teemowork.model.Item#getAll()
	_BO:function(){
		return boot.Bx.a.BP();
	}
});

boot.define("O","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.O.b=new boot.O(1510,2012,11,13,"Initial",null,0);
		boot.O.b.EL("Ruby Crystal").EM(475).EO(180);
		boot.O.b.EL("Haunting Guise").EO(200).EP(25);
		boot.O.b.EQ(boot.X.c).CQ(380,80).CT(5.5,0.6).CW(230,50.0).CZ(6.25,0.6).Cw(50.0,3.0).Cz(0.668,2.0).DC(10.0,3.5).DF(30.0,0).DH(550).DJ(330);
		boot.O.b.EQ(boot.X.d).CQ(445,85).CT(7.25,0.65).DL(200).DN(50).Cw(53.0,3.2).Cz(0.694,3.1).DC(16.5,3.5).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.e).CQ(442,102).CT(7.25,0.85).CW(215,38.0).CZ(6.45,0.45).Cw(55.03,3.62).Cz(0.625,3.62).DC(14.5,3.5).DF(30.0,1.25).DH(125).DJ(325);
		boot.O.b.EQ(boot.X.f).CQ(472,84).CT(7.45,0.85).CW(220,40.0).CZ(6.5,0.525).Cw(47.0,3.8).Cz(0.638,2.18).DC(18.0,3.3).DF(30.0,1.25).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.g).CQ(350,70).CT(4.65,0.55).CW(257,53.0).CZ(7.0,0.6).Cw(48.0,3.2).Cz(0.625,1.68).DC(10.5,4.0).DF(30.0,0).DH(600).DJ(325);
		boot.O.b.EQ(boot.X.h).CQ(384,76).CT(4.5,0.55).CW(250,50.0).CZ(6.9,0.6).Cw(49.0,2.625).Cz(0.579,1.36).DC(12.5,4.0).DF(30.0,0).DH(625).DJ(335);
		boot.O.b.EQ(boot.X.i).CQ(395,79).CT(4.5,0.55).CW(173,35.0).CZ(6.3,0.4).Cw(46.3,2.85).Cz(0.658,3.34).DC(11.5,3.4).DF(30.0,0).DH(600).DJ(325);
		boot.O.b.EQ(boot.X.j).CQ(423,95).CT(7.25,0.75).CW(260,40.0).CZ(6.6,0.5).Cw(55.66,3.5).Cz(0.625,1.13).DC(14.5,3.5).DF(30.0,1.25).DH(125).DJ(325);
		boot.O.b.EQ(boot.X.k).CQ(380,76).CT(4.5,0.55).CW(250,45.0).CZ(7.0,0.6).Cw(51.66,3.0).Cz(0.625,1.36).DC(12.0,3.5).DF(30.0,0).DH(550).DJ(340);
		boot.O.b.EQ(boot.X.l).CQ(390,80).CT(4.75,0.55).CW(255,35.0).CZ(6.5,0.55).Cw(47.0,3.0).Cz(0.668,3.0).DC(13.0,3.5).DF(30.0,0).DH(650).DJ(325);
		boot.O.b.EQ(boot.X.m).CQ(380,75).CT(4.85,0.5).CW(250,50.0).CZ(7.1,0.75).Cw(47.0,3.2).Cz(0.644,1.68).DC(11.5,4.0).DF(30.0,0).DH(550).DJ(335);
		boot.O.b.EQ(boot.X.n).CQ(440,80).CT(7.5,0.85).CW(205,40.0).CZ(6.45,0.45).Cw(54.1,4.2).Cz(0.625,1.44).DC(19.0,3.5).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.o).CQ(375,82).CT(4.5,0.55).CW(243,37.0).CZ(6.5,0.55).Cw(48.2,3.0).Cz(0.658,2.3).DC(13.5,3.5).DF(30.0,0).DH(550).DJ(325);
		boot.O.b.EQ(boot.X.p).CQ(426,93).CT(8.25,0.95).CW(200,37.5).CZ(6.0,0.35).Cw(50.0,3.5).Cz(0.679,2.6).DC(20.0,3.5).DF(30.0,1.25).DH(125).DJ(340);
		boot.O.b.EQ(boot.X.ba).CQ(438,90).CT(7.0,0.85).CW(230,40.0).CZ(7.0,0.6).Cw(48.0,3.0).Cz(0.625,2.25).DC(16.0,3.6).DF(30.0,1.25).DH(150).DJ(345);
		boot.O.b.EQ(boot.X.bb).CQ(433,89).CT(6.5,0.75).Cw(56.23,3.0).Cz(0.625,2.8).DC(17.0,3.5).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.bc).CQ(420,82).CT(5.0,0.7).CW(240,42.0).CZ(6.95,0.65).Cw(46.5,3.5).Cz(0.679,2.6).DC(16.0,3.3).DF(30.0,0).DH(550).DJ(330);
		boot.O.b.EQ(boot.X.bd).CQ(395,80).CT(4.7,0.6).CW(240,50.0).CZ(6.8,0.65).Cw(47.5,3.0).Cz(0.625,1.75).DC(12.65,3.35).DF(30.0,0).DH(550).DJ(335);
		boot.O.b.EQ(boot.X.be).CQ(414,86).CT(6.95,0.55).CW(180,42.0).CZ(7.1,0.6).Cw(48.0,3.3).Cz(0.658,3.84).DC(12.5,4.0).DF(30.0,1.25).DH(125).DJ(340);
		boot.O.b.EQ(boot.X.bf).CQ(350,80).CT(5.5,0.55).CW(235,45.0).CZ(7.0,0.65).Cw(47.2,3.0).Cz(0.665,2.8).DC(12.0,3.5).DF(30.0,0).DH(550).DJ(330);
		boot.O.b.EQ(boot.X.bg).CQ(390,80).CT(4.6,0.6).CW(251,59.0).CZ(6.9,0.65).Cw(45.95,2.625).Cz(0.625,2.11).DC(11.0,3.5).DF(30.0,0).DH(480).DJ(335);
		boot.O.b.EQ(boot.X.bh).CQ(450,85).CT(6.3,0.8).CW(220,40.0).CZ(7.25,0.5).Cw(54.5,3.2).Cz(0.672,3.0).DC(15.5,3.5).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.bi).CQ(414,86).CT(7.0,0.7).CW(200,40.0).CZ(6.15,0.45).Cw(53.0,3.0).Cz(0.658,3.1).DC(13.0,3.4).DF(30.0,1.25).DH(175).DJ(335);
		boot.O.b.EQ(boot.X.bj).CQ(435,85).CT(7.45,0.75).CW(235,50.0).CZ(7.0,0.7).Cw(56.3,3.375).Cz(0.638,1.2).DC(17.0,3.5).DF(30.0,0).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.bk).CQ(495,81).CT(425.0,0.75).CW(215,40.0).CZ(6.5,0.7).Cw(54.0,3.0).Cz(0.651,2.75).DC(16.5,3.3).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.bl).CQ(455,96).CT(7.5,0.75).Cw(52.5,3.5).Cz(0.625,2.9).DC(19.0,2.7).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.bm).CQ(434,89).CT(7.25,0.85).CW(221,47.0).CZ(6.45,0.45).Cw(55.78,3.375).Cz(0.651,2.05).DC(16.0,3.6).DF(30.0,0).DH(125).DJ(340);
		boot.O.b.EQ(boot.X.bn).CQ(410,84).CT(5.5,0.7).CW(255,40.0).CZ(6.75,0.7).Cw(51.0,3.1).Cz(0.625,2.9).DC(15.0,3.2).DF(30.0,0).DH(525).DJ(330);
		boot.O.b.EQ(boot.X.bo).CQ(440,95).CT(8.0,0.75).CW(210,40.0).CZ(6.5,0.6).Cw(56.0,3.2).Cz(0.67,2.5).DC(16.0,4.0).DF(30.0,1.25).DH(175).DJ(345);
		boot.O.b.EQ(boot.X.bp).CQ(350,75).CT(4.5,0.55).CW(240,65.0).CZ(7.0,0.65).Cw(49.24,3.0).Cz(0.625,1.21).DC(7.0,3.0).DF(30.0,0).DH(550).DJ(325);
		boot.O.b.EQ(boot.X.ca).CQ(456,90).CT(7.5,0.65).CW(230,35.0).CZ(7.0,0.65).Cw(56.0,3.3).Cz(0.665,3.2).DC(15.0,3.75).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.cb).CQ(356,78).CT(4.5,0.55).CW(302,64.0).CZ(6.9,0.6).Cw(49.0,2.95).Cz(0.625,2.61).DC(9.0,3.8).DF(30.0,0).DH(475).DJ(335);
		boot.O.b.EQ(boot.X.cc).CQ(420,90).CT(7.0,0.7).CW(235,40.0).CZ(6.0,0.45).Cw(50.0,3.4).Cz(0.658,2.5).DC(14.0,3.0).DF(30.0,1.25).DH(175).DJ(340);
		boot.O.b.EQ(boot.X.cd).CQ(463,98).CT(7.45,0.55).CW(230,35.0).CZ(6.4,0.7).Cw(56.3,3.375).Cz(0.638,3.4).DC(18.0,3.5).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.ce).CQ(420,90).CT(6.0,0.8).CW(240,40.0).CZ(7.0,0.7).Cw(46.5,3.5).Cz(0.658,3.0).DC(12.5,3.5).DF(30.0,0).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.cf).CQ(410,86).CT(4.7,0.55).CW(240,60.0).CZ(6.8,0.65).Cw(50.0,3.3).Cz(0.625,2.3).DC(15.0,3.5).DF(30.0,0).DH(425).DJ(335);
		boot.O.b.EQ(boot.X.cg).CQ(390,75).CT(5.5,0.55).CW(270,61.0).CZ(6.5,0.6).Cw(42.2,3.25).Cz(0.625,2.11).DC(11.0,3.5).DF(30.0,0).DH(450).DJ(335);
		boot.O.b.EQ(boot.X.ch).CQ(433,78).CT(6.95,0.5).CW(230,45.0).CZ(6.9,0.6).Cw(52.3,3.9).Cz(0.638,3.7).DC(14.0,3.2).DF(30.0,1.25).DH(125).DJ(340);
		boot.O.b.EQ(boot.X.ci).CQ(395,83).CT(6.95,0.55).Cw(53.0,3.2).Cz(0.658,2.74).DC(14.75,4.0).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.cj).CQ(418,93).CT(7.0,0.75).CW(255,40.0).CZ(6.9,0.525).Cw(53.3,2.8).Cz(0.638,2.5).DC(17.0,3.5).DF(30.0,0.75).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.ck).CQ(403,79).CT(4.65,0.65).DL(200).DN(50).Cw(51.3,3.3).Cz(0.69,3.4).DC(14.0,3.75).DF(30.0,0).DH(550).DJ(335);
		boot.O.b.EQ(boot.X.cl).CQ(430,85).CT(6.25,0.75).CW(260,40.0).CZ(6.75,0.5).Cw(50.0,3.1).Cz(0.665,2.7).DC(15.0,3.0).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.cm).CQ(440,84).CT(5.0,0.55).CW(295,40.0).CZ(7.5,0.7).Cw(46.0,3.0).Cz(0.665,2.65).DC(13.0,3.53).DF(30.0,0).DH(500).DJ(340);
		boot.O.b.EQ(boot.X.cn).CQ(390,75).CT(4.5,0.55).CW(250,50.0).CZ(6.9,0.6).Cw(51.0,3.1).Cz(0.625,1.4).DC(12.0,3.5).DF(30.0,0).DH(525).DJ(335);
		boot.O.b.EQ(boot.X.co).CQ(428,85).CT(6.25,61.0).DN(200).DN(50).Cw(55.8,3.2).Cz(0.651,3.0).DC(16.0,3.7).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.cp).CQ(430,87).CT(9.0,0.85).CW(235,40.0).CZ(8.0,0.7).Cw(55.0,3.0).Cz(0.625,2.9).DC(18.0,3.1).DF(30.0,1.25).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.da).CQ(415,82).CT(6.0,0.72).CW(200,50.0).CZ(6.0,0.6).Cw(44.4,2.6).Cz(0.625,2.2).DC(9.0,3.7).DF(30.0,0).DH(550).DJ(325);
		boot.O.b.EQ(boot.X.db).CQ(345,79).CT(4.5,0.55).CW(250,50.0).CZ(6.0,0.6).Cw(50.0,3.3).Cz(0.625,1.36).DC(8.0,4.0).DF(30.0,0).DH(550).DJ(340);
		boot.O.b.EQ(boot.X.dc).CQ(423,90).CT(7.45,0.55).CW(215,40.0).CZ(6.4,0.55).Cw(56.3,3.375).Cz(0.638,3.4).DC(18.0,3.75).DF(30.0,1.25).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.dd).CQ(380,80).CT(4.5,0.55).CW(250,45.0).CZ(7.0,0.6).Cw(51.66,3.0).Cz(0.625,1.36).DC(15.0,3.5).DF(30.0,0).DH(550).DJ(340);
		boot.O.b.EQ(boot.X.de).CQ(421,90).CT(7.25,0.85).CW(250,46.0).CZ(6.45,0.45).Cw(58.0,3.3).Cz(0.694,2.13).DC(18.0,4.0).DF(30.0,0).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.df).CQ(444,86).CT(6.75,0.65).CW(199,36.0).CZ(6.5,0.45).Cw(55.12,3.1).Cz(0.679,2.98).DC(16.3,3.7).DF(30.0,1.25).DH(125).DJ(355);
		boot.O.b.EQ(boot.X.dg).CQ(435,85).CT(5.1,0.65).CW(212,38.0).CZ(6.95,0.65).Cw(46.5,3.0).Cz(0.658,3.01).DC(15.0,3.0).DF(30.0,0).DH(550).DJ(325);
		boot.O.b.EQ(boot.X.dh).CQ(421,80).CT(7.45,0.55).Cw(51.7,3.5).Cz(0.694,3.0).DC(15.0,3.5).DF(30.0,1.25).DH(125).DJ(340);
		boot.O.b.EQ(boot.X.di).CQ(403,86).CT(4.7,0.6).CW(240,60.0).CZ(6.8,0.65).Cw(51.58,3.5).Cz(0.579,1.53).DC(15.0,3.8).DF(30.0,0).DH(425).DJ(335);
		boot.O.b.EQ(boot.X.dj).CQ(365,74).CT(4.5,45.0).CW(305,43.0).CZ(6.9,0.6).Cw(48.0,3.1).Cz(0.644,2.6).DC(9.0,4.0).DF(30.0,0).DH(550).DJ(330);
		boot.O.b.EQ(boot.X.dk).CQ(410,90).CT(7.5,0.9).CW(200,45.0).CZ(6.6,0.5).Cw(53.3,3.5).Cz(0.638,3.48).DC(15.0,3.5).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.dl).CQ(432,86).CT(7.45,0.55).CW(200,50.0).CZ(7.45,0.7).Cw(52.0,3.3).Cz(0.613,0.98).DC(12.0,3.25).DF(30.0,1.25).DH(175).DJ(325);
		boot.O.b.EQ(boot.X.dm).CQ(370,90).CT(5.0,0.6).CW(220,45.0).CZ(7.0,0.5).Cw(49.0,3.5).Cz(0.672,3.22).DC(11.0,3.5).DF(30.0,10.75).DH(525).DJ(335);
		boot.O.b.EQ(boot.X.dn).CQ(430,85).CT(7.0,0.75).CW(215,35.0).CZ(6.0,0.45).Cw(54.0,3.1).Cz(0.668,2.7).DC(17.0,3.5).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.dp).CQ(437,108).CT(7.05,0.8).CW(213,42.0).CZ(6.6,0.5).Cw(51.6,3.4).Cz(0.625,2.25).DC(16.5,3.5).DF(30.0,1.25).DH(125).DJ(340);
		boot.O.b.EQ(boot.X.ea).CQ(441,93).CT(7.0,0.9).CW(225,45.0).CZ(6.5,0.575).Cw(54.1,3.5).Cz(0.694,2.7).DC(17.0,3.0).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.eb).CQ(385,79).CT(5.95,0.55).CW(250,50.0).CZ(7.0,0.5).Cw(44.0,2.6).Cz(0.658,3.5).DC(8.0,3.0).DF(30.0,0).DH(525).DJ(325);
		boot.O.b.EQ(boot.X.ec).CQ(433,87).CT(6.75,0.65).CW(210,34.0).CZ(6.6,0.45).Cw(50.7,2.9).Cz(0.679,2.95).DC(17.1,3.9).DF(30.0,1.25).DH(155).DJ(355);
		boot.O.b.EQ(boot.X.ed).CQ(423,81).CT(7.45,0.55).CW(185,30.0).CZ(6.4,0.45).Cw(56.3,3.375).Cz(0.638,3.35).DC(18.0,4.0).DF(30.0,0).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.ee).CQ(420,86).CT(8.0,0.55).CW(255,33.0).CZ(4.5,0.3).Cw(50.0,3.5).Cz(0.625,2.22).DC(21.0,3.8).DF(30.0,1.25).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.ef).CQ(426,87).CT(6.7,0.75).Cw(53.12,3.1).Cz(0.665,2.65).DC(15.2,3.8).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.eg).CQ(435,85).CT(4.0,0.4).Cw(55.0,3.0).Cz(0.679,2.85).DC(16.0,3.5).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.eh).CQ(414,86).CT(10.4,0.9).Cw(54.0,2.75).Cz(0.625,3.5).DC(15.0,3.1).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.ei).CQ(450,80).CT(7.0,0.7).Cw(55.32,3.2).Cz(0.644,1.85).DC(16.0,3.5).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.ej).CQ(360,86).CT(4.35,0.55).CW(250,55.0).CZ(7.0,0.6).Cw(52.0,3.0).Cz(0.625,2.11).DC(11.0,3.9).DF(30.0,0).DH(550).DJ(335);
		boot.O.b.EQ(boot.X.ek).CQ(450,85).CT(7.35,0.85).CW(220,40.0).CZ(6.45,0.45).Cw(54.0,3.4).Cz(0.67,1.45).DC(20.5,3.5).DF(30.0,1.25).DH(125).DJ(340);
		boot.O.b.EQ(boot.X.el).CQ(441,84).CT(7.45,0.55).CW(270,40.0).CZ(6.4,0.45).Cw(51.7,3.5).Cz(0.694,3.0).DC(15.0,3.5).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.em).CQ(428,85).CT(7.45,0.55).DL(200).DN(50).Cw(54.5,3.375).Cz(0.651,3.4).DC(15.0,4.0).DF(30.0,0).DH(125).DJ(335);
		boot.O.b.EQ(boot.X.en).CQ(435,95).CT(7.2,0.8).Cw(54.5,3.4).Cz(0.658,3.4).DC(17.6,3.4).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.eo).CQ(405,82).CT(7.1,0.55).CW(215,45.0).CZ(6.6,0.55).Cw(56.65,3.375).Cz(0.613,1.81).DC(18.0,3.5).DF(30.0,0).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.ep).CQ(403,104).CT(7.9,0.95).CW(240,40.0).CZ(6.3,0.4).Cw(55.52,3.1875).Cz(0.625,1.63).DC(17.75,3.25).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.fa).CQ(378,82).CT(4.25,0.55).CW(203,43.0).CZ(6.5,0.5).Cw(49.0,2.9).Cz(0.658,3.28).DC(12.75,3.25).DF(30.0,0).DH(500).DJ(335);
		boot.O.b.EQ(boot.X.fb).CQ(440,96).CT(7.5,0.85).CW(205,40.0).CZ(6.45,0.45).Cw(54.1,4.2).Cz(0.625,2.1).DC(19.0,3.8).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.fc).CQ(340,70).CT(4.5,0.55).CW(265,45.0).CZ(7.0,0.65).Cw(47.0,3.0).Cz(0.644,2.3).DC(6.0,3.3).DF(30.0,0).DH(550).DJ(330);
		boot.O.b.EQ(boot.X.fd).CQ(375,71).CT(4.5,0.55).CW(240,60.0).CZ(6.8,0.65).Cw(48.8,3.0).Cz(0.625,2.14).DC(7.4,3.8).DF(30.0,0).DH(550).DJ(335);
		boot.O.b.EQ(boot.X.fe).CQ(385,78).CT(6.75,0.65).CW(240,50.0).CZ(6.8,0.65).Cw(49.0,3.0).Cz(0.625,2.11).DC(12.0,4.0).DF(30.0,0).DH(500).DJ(335);
		boot.O.b.EQ(boot.X.ff).CQ(380,78).CT(5.5,0.6).CW(250,50.0).CZ(6.9,0.6).Cw(51.0,2.9).Cz(0.625,2.0).DC(15.0,3.4).DF(30.0,0).DH(550).DJ(330);
		boot.O.b.EQ(boot.X.fg).CQ(440,85).CT(7.25,0.75).CW(260,40.0).CZ(6.75,0.5).Cw(50.0,3.1).Cz(0.668,2.7).DC(17.0,3.5).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.fh).CQ(468,90).CT(7.1,0.5).CW(255,56.0).CZ(4.1,0.4).Cw(58.0,3.5).Cz(0.625,2.02).DC(16.5,3.2).DF(30.0,1.25).DH(125).DJ(340);
		boot.O.b.EQ(boot.X.fi).CQ(383,82).CT(4.65,0.65).CW(200,40.0).CZ(6.45,0.45).Cw(44.5,3.0).Cz(0.69,3.38).DC(14.0,3.75).DF(30.0,0).DH(500).DJ(330);
		boot.O.b.EQ(boot.X.fj).CQ(415,82).CT(5.1,0.65).CW(193,32.0).CZ(6.45,0.45).Cw(46.5,3.0).Cz(0.658,3.01).DC(15.0,3.0).DF(30.0,0).DH(550).DJ(325);
		boot.O.b.EQ(boot.X.fk).CQ(455,96).CT(8.0,0.85).CW(206,45.0).CZ(6.9,0.6).Cw(54.66,3.0).Cz(0.672,2.9).DC(19.0,2.7).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.fl).CQ(461,98).CT(7.9,0.9).Cw(56.0,3.2).Cz(0.644,2.9).DC(14.9,3.1).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.fm).CQ(384,82).CT(4.5,0.6).CW(202,38.0).CZ(6.5,0.5).Cw(46.61,3.3).Cz(0.651,3.22).DC(111.25,3.15).DF(30.0,0).DH(525).DJ(330);
		boot.O.b.EQ(boot.X.fn).CQ(389,81).CT(5.0,0.6).CW(220,40.0).CZ(6.5,0.45).Cw(49.0,3.0).Cz(0.679,3.38).DC(14.0,3.0).DF(30.0,0).DH(550).DJ(330);
		boot.O.b.EQ(boot.X.fo).CQ(427,99).CT(7.45,0.75).CW(220,30.0).CZ(6.4,0.45).Cw(52.91,3.2).Cz(0.658,2.67).DC(14.75,4.0).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.fp).CQ(437,89).CT(5.5,0.6).CW(220,55.0).CZ(7.5,0.65).Cw(48.0,3.6).Cz(0.644,2.9).DC(15.0,3.3).DF(30.0,0).DH(425).DJ(335);
		boot.O.b.EQ(boot.X.ga).CQ(400,82).CT(4.5,0.55).CW(250,36.0).CZ(6.5,0.5).Cw(46.0,3.0).Cz(0.658,2.65).DC(13.5,3.4).DF(30.0,0).DH(575).DJ(335);
		boot.O.b.EQ(boot.X.gb).CQ(359,83).CT(4.5,0.55).CW(173,27.0).CZ(6.3,0.4).Cw(50.0,3.25).Cz(0.658,3.1).DC(9.3,3.4).DF(30.0,0).DH(550).DJ(330);
		boot.O.b.EQ(boot.X.gc).CQ(355,82).CT(4.5,0.55).CW(250,55.0).CZ(6.9,0.6).Cw(48.3,2.625).Cz(0.625,2.24).DC(12.25,3.75).DF(30.0,0).DH(525).DJ(340);
		boot.O.b.EQ(boot.X.gd).CQ(440,85).CT(7.5,0.9).CW(220,45.0).CZ(7.0,0.65).Cw(55.0,3.5).Cz(0.643,2.5).DC(16.0,3.5).DF(30.0,1.25).DH(125).DJ(350);
		boot.O.b.EQ(boot.X.ge).CQ(385,78).CT(6.75,0.65).CW(240,50.0).CZ(6.9,0.45).Cw(49.0,3.0).Cz(0.625,2.11).DC(12.0,4.0).DF(30.0,0).DH(525).DJ(335);
		boot.O.b.EQ(boot.X.gf).CQ(400,85).CT(6.0,0.6).Cw(45.0,3.0).Cz(0.6258,2.0).DC(12.0,3.5).DF(30.0,0).DH(450).DJ(335);
		boot.O.b.EQ(boot.X.gg).CQ(440,86).CT(7.0,0.65).CW(220,30.0).CZ(7.0,0.65).Cw(54.0,3.3).Cz(0.625,2.9).DC(16.5,3.5).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.gh).CQ(428,98).CT(7.05,0.8).CW(190,30.0).CZ(7.1,0.6).Cw(56.76,3.375).Cz(0.679,2.88).DC(16.0,3.5).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.gi).CQ(435,85).CT(5.1,0.65).CW(202,38.0).CZ(6.9,0.65).Cw(54.0,3.2).Cz(0.658,3.0).DC(15.0,3.5).DF(30.0,1.25).DH(175).DJ(345);
		boot.O.b.EQ(boot.X.gj).CQ(380,80).CT(5.0,0.55).CW(250,45.0).CZ(8.0,0.6).Cw(52.0,3.0).Cz(0.625,1.36).DC(12.6,3.4).DF(30.0,0).DH(550).DJ(340);
		boot.O.b.EQ(boot.X.gk).CQ(445,87).CT(7.0,0.7).CW(213,31.0).CZ(6.6,0.45).Cw(52.0,3.3).Cz(0.672,2.7).DC(16.2,3.7).DF(30.0,1.25).DH(175).DJ(345);
		boot.O.b.EQ(boot.X.gl).CQ(421,85).CT(8.5,0.7).CW(235,35.0).CZ(6.5,0.45).Cw(51.5,3.5).Cz(0.625,3.0).DC(18.0,3.6).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.gm).CQ(445,85).CT(6.0,0.65).DL(20).DN(50).Cw(48.6,3.4).Cz(0.658,3.1).DC(17.5,3.5).DF(30.0,1.25).DH(125).DJ(345);
		boot.O.b.EQ(boot.X.gn).CQ(390,80).CT(5.25,0.6).CW(250,50.0).CZ(6.75,0.6).Cw(54.0,3.1).Cz(0.656,1.7).DC(12.0,3.3).DF(30.0,0).DH(575).DJ(330);
		boot.O.b.EQ(boot.X.go).CQ(380,71).CT(4.6,0.5).CW(260,60.0).CZ(6.95,0.65).Cw(48.6,3.0).Cz(0.625,2.13).DC(6.75,3.8).DF(30.0,0).DH(600).DJ(335);
		boot.O.b.EQ(boot.X.gp).CQ(355,74).CT(4.85,0.5).CW(250,50.0).CZ(7.1,0.75).Cw(50.0,3.2).Cz(0.625,1.8).DC(11.0,3.0).DF(30.0,0).DH(575).DJ(325);
		boot.O.c=new boot.O(1520,2012,12,3,"Preseason 3",boot.O.b,0);
		boot.O.c.EL("Shard of True Ice");
		boot.O.c.EL("Liandry's Torment");
		boot.O.c.EL("Haunting Guise");
		boot.O.a=boot.O.c;
	},
	// teemowork.model.Patch#<init>(int, int, int, int, java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C,D,E,F){
		this.d=new boot.x(0);
		this.e=new boot.x(0);
		this.f=A;
		this.g=E;
		this.h=F;
	},
	// teemowork.model.Patch#updateItem(java.lang.String)
	EL:function(A,B){
		B=new boot.Bx(A,this,0);
		this.e.BM(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	EQ:function(A){
		A.hb=new boot.v(this,A.hb,0);
		return A.hb;
	}
});

boot.define("B","C",{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	M:function(A,B){
		$("body").css("padding","0px 10%");
		A=new boot.M(0);
		A.N("< ^ v ^ > Teemowork","test.html");
		A.N("Patch","#");
		B=A.N("Data","#");
		B.N("Champion","#");
		B.N("Item","#");
		B.N("Mastery","#");
		B.N("Rune","#");
		A.N("Builder","#");
		A.N("About","#");
		A.N("Contact","#");
		console.log(boot.O.a);
	}
});

try {new boot.B(0).M();} catch(e) {console.log(e)}