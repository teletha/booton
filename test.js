boot.define("P","",{
	
	// booton.translator.js.JSAnnotatedElement#<init>(java.lang.String, booton.translator.js.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// booton.translator.js.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	P:function(A){
		return this.F(A)!=null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotation(java.lang.Class)
	F:function(A,B,C){
		if(this.b==null){
		}else{
			B=0;
			l4:for (;
			B<this.b.length;
			++B) {
				C=this.b[B];
				if(C[0].equals(A.Q())==0){
				}else{
					return C[1];
				}
			}
		}return null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotations()
	R:function(){
		return null;
	},
	// booton.translator.js.JSAnnotatedElement#getDeclaredAnnotations()
	S:function(){
		return this.R();
	}
});

boot.define("G","P",{
	
	// booton.translator.js.JSConstructor#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	},
	// booton.translator.js.JSConstructor#newInstance(java.lang.Object[])
	Z:function(A,B){
		B=Object.create(this.c);
		this.d.apply(B,A);
		return B;
	}
});

boot.define("Q","P",{
	
	// booton.translator.js.JSMethod#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	}
});

boot.define("T","",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.T.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.T.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.T.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.T.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	w:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	x:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	y:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	z:function(){
		console.log(this.a);
	}
});

boot.define("S","T",{
	
	// java.lang.Error#<init>()
	$1:function(){
		boot.T.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$2:function(A){
		boot.T.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$3:function(A,B){
		boot.T.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$0:function(A){
		boot.T.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.T.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("A","P",{
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject, booton.translator.js.JSClass)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,C["$"]);
		this.c=B;
		this.d=C;
		this.e=D;
	},
	// booton.translator.js.JSClass#getConstructors()
	E:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")==0){
			}else{
				A.push(new boot.G(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// booton.translator.js.JSClass#getMethods()
	T:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")!=0){
			}else{
				A.push(new boot.Q(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// booton.translator.js.JSClass#getDeclaredMethods()
	U:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")!=0){
			}else{
				A.push(new boot.Q(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// booton.translator.js.JSClass#isAssignableFrom(java.lang.Class)
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
	// booton.translator.js.JSClass#getSuperclass()
	W:function(){
		return this.e;
	},
	// booton.translator.js.JSClass#getName()
	X:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	Q:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	Y:function(A){
		try{
			return this.E()[0].Z(new Array(0));
		} catch ($) {
			if ($ instanceof boot.R) {
				throw new boot.S(A,0);
			}
		}
	},
	// booton.translator.js.JSClass#getConstructor()
	u:function(){
		return null;
	},
	// booton.translator.js.JSClass#forName(java.lang.String)
	_v:function(A){
		return null;
	}
});

boot.define("X","",{
});

boot.define("L","",{
});

boot.define("W","",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	BE:function(){
		return this.BF()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BG:function(A,B,C,D){
		B=0;
		D=A.L();
		l2:while (D.N()!=0) {
			C=D.M();
			if(this.H(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BH:function(A,B,C,D){
		B=0;
		D=this.L();
		l2:while (D.N()!=0) {
			C=D.M();
			if(A.BI(C)!=0){
			}else{
				B=this.BJ(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BK:function(A,B,C,D){
		B=0;
		D=A.L();
		l2:while (D.N()!=0) {
			C=D.M();
			if(this.BJ(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BL:function(A,B,C){
		C=A.L();
		l1:while (C.N()!=0) {
			B=C.M();
			if(this.BI(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BM:function(){
		return this.BN(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BN:function(A,B,C,D,E){
		B=this.BF();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.L();
		D=0;
		l6:while (C.N()!=0) {
			E=C.M();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("Y","",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	N:function(){
		return this.b<boot.U.Bu(this.a).length;
	},
	// js.util.ArrayList$View#next()
	M:function(){
		return boot.U.Bu(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	Bv:function(){
		if(this.b<=0){
		}else{
			boot.U.Bu(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.Y.prototype.$1.call(this,A);
	}
});

boot.define("R","T",{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.T.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.T.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.T.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.T.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.T.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("u","R",{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.R.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.R.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.R.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.R.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.R.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("Z","u",{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.u.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.u.prototype.$1.call(this,A);
	}
});

boot.define("U","W",{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.W.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	BF:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BI:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	L:function(){
		return new boot.Y(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	H:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BJ:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	BO:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BP:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	BQ:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	BR:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	BS:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	BT:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	BU:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	BV:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	BW:function(){
		throw new boot.S(1);
	},
	// js.util.ArrayList#listIterator(int)
	BX:function(A){
		throw new boot.S(1);
	},
	// js.util.ArrayList#subList(int, int)
	BY:function(A,B){
		throw new boot.S(1);
	},
	// js.util.ArrayList#checkRange(int)
	BZ:function(A){
		if(A>=0){
			if(this.BF()>A){
				return;
			}else{
				throw new boot.Z("Index is overflowed. Size: "+this.BF()+"  Index: "+A,0);
			}
		}else{
			throw new boot.Z("Negative index is unacceptable. Size: "+this.BF()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_Bu:function(A){
		return A.a;
	}
});

boot.define("v","",{
	
	// js.dom.Location#<init>()
	$0:function(){
	}
});

boot.define("I","",{
});

boot.define("F","",{
},{
	"$":[["w",{
	}],["x",{
		Bz:function() {return [CONSTRUCTOR,TYPE];}
	}],["y",{
		CA:function() {return RUNTIME;}
	}]]
});

boot.define("H","",{
	
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo)
	$1:function(A,B){
		this.a=A;
		this.b=new RegExp(B.Bw().replace(/\*/g,"([^/].+)"),"");
	},
	// js.Application$Route#match(java.lang.String)
	Bx:function(A,B,C,D){
		B=this.b.exec(A);
		if(B!=null!=0){
			C=new boot.U(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.H(B[D+1]);
			}try{
				return this.a.Z(C.BM());
			} catch ($) {
				if ($ instanceof boot.R) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_BB:function(A,B){
		return A.Bx(B);
	},
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo, js.Application$Route)
	$0:function(A,B,C){
		boot.H.prototype.$1.call(this,A,B);
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
boot.define("J","",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("BB","",{
	
	// js.util.jQuery$1#<init>(js.util.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// js.util.jQuery$1#hasNext()
	N:function(){
		return this.b<this.a.size();
	},
	// js.util.jQuery$1#next()
	CD:function(){
		return $(this.a.get(this.b++));
	},
	// js.util.jQuery$1#remove()
	Bv:function(){
	},
	// js.util.jQuery$1#next()
	M:function(){
		return this.CD();
	}
});

boot.defineNative("jQuery",{
	
	// js.util.jQuery#<init>()
	$0:function(){
	},
	// js.util.jQuery#child(java.lang.String)
	CB:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// js.util.jQuery#child(java.lang.Class)
	CC:function(A){
		return this.CB("span").addClass(A);
	},
	// js.util.jQuery#iterator()
	L:function(){
		return new boot.BB(this,0);
	}
});
boot.define("E","",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.U(0);
	},
	// js.Application$Router#handler(js.util.jQuery$Event)
	handler:function(A){
		this.BA(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	BA:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.L();
		l3:while (C.N()!=0) {
			B=C.M();
			D=boot.H.BB(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.BC(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	BD:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.BC(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.BA(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_G:function(A){
		return A.a;
	}
},{
	"BD":[["V",{
	}]]
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
	// js.Application#register(java.lang.Class)
	D:function(A,B,C,D){
		B=A.E();
		C=0;
		l3:while (C<B.length) {
			D=B[C].F(boot.F.$);
			if(D==null){
			}else{
				boot.E.G(boot.C.a).H(new boot.H(B[C],D,null,0));
			}++C;
			continue l3;
		}
	},
	// js.Application#show(js.Page)
	_I:function(A){
		if(A==null){
		}else{
			boot.E.B(boot.C.a,A.J());
			history.pushState("","","#"+A.J());
		}
	}
});

boot.define("K","",{
	
	// js.lang.Classes#<init>()
	$0:function(){
	},
	// js.lang.Classes#find(java.lang.Class)
	_K:function(A,B,C,D,E,F,G){
		B=new boot.U(0);
		F=Object.keys(boot);E=F.length;D=0;
		l2:while (D<E) {
			C=F[D];
			G=boot[C]["$"];
			if((A==G||A.V(G)==0)){
			}else{
				B.H(G);
			}++D;
			continue l2;
		}return B;
	}
});

boot.define("N","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, js.util.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.CB("ul").addClass("d");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	O:function(A,B,C){
		C=this.b.CB("li").addClass("e");
		C.CB("a").addClass("c").attr("href",B).text(A);
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
		this.a=$("#Header").addClass("a");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	O:function(A,B,C){
		C=this.a.CB("li").addClass("b");
		C.CB("a").addClass("c").attr("href",B).text(A);
		return new boot.N(this,C,null,0);
	}
});

boot.define("BO","W",{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.W.prototype.$0.call(this);
	}
});

boot.define("BP","",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, java.lang.String[])
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
	M:function(){
		this.d=boot.BI.EL(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	Bv:function(){
		if(this.b<=0){
		}else{
			this.a.BJ(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, java.lang.String[], js.util.HashSet$View)
	$0:function(A,B,C){
		boot.BP.prototype.$1.call(this,A,B);
	}
});

boot.define("BI","BO",{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.BO.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	BF:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BI:function(A){
		return this.EK(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	H:function(A,B){
		B=this.EK(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BJ:function(A,B){
		B=this.EK(A);
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
		this.b={};
	},
	// js.util.HashSet#iterator()
	L:function(){
		return new boot.BP(this,Object.keys(this.b),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	EK:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	Dz:function(A){
		return this.b[this.EK(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	EB:function(A,B,C){
		B=null;
		C=this.EK(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	ED:function(A,B,C){
		B=null;
		C=this.EK(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_EL:function(A){
		return A.b;
	}
});

boot.define("BJ","",{
});

boot.define("BK","",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	EH:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	EA:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	EM:function(A,B){
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
		boot.BK.prototype.$1.call(this,A,B);
	}
});

boot.define("BH","",{
});

boot.define("BL","",{
});

boot.define("BQ","",{
	
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
	M:function(A){
		A=this.b.M();
		if(this.c==0){
			return A.EA();
		}else{
			return A.EH();
		}
	},
	// js.util.HashMap$View#remove()
	Bv:function(){
		this.b.Bv();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.BQ.prototype.$1.call(this,A,B,C);
	}
});

boot.define("BM","BO",{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.BO.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	BF:function(){
		return boot.BG.EJ(this.a).BF();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BI:function(A){
		return boot.BG.EJ(this.a).BI(A);
	},
	// js.util.HashMap$Keys#iterator()
	L:function(){
		return new boot.BQ(this.a,boot.BG.EJ(this.a).L(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BJ:function(A){
		return boot.BG.EJ(this.a).BJ(A);
	},
	// js.util.HashMap$Keys#clear()
	BP:function(){
		boot.BG.EJ(this.a).BP();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.BM.prototype.$1.call(this,A);
	}
});

boot.define("BN","W",{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.W.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BF:function(){
		return boot.BG.EJ(this.a).BF();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BI:function(A){
		return this.a.Dy(A);
	},
	// js.util.HashMap$Values#iterator()
	L:function(){
		return new boot.BQ(this.a,boot.BG.EJ(this.a).L(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BJ:function(A,B,C){
		B=this.L();
		l2:while (B.N()!=0) {
			C=B.M();
			if(C!=A){
			}else{
				B.Bv();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BP:function(){
		boot.BG.EJ(this.a).BP();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.BN.prototype.$1.call(this,A);
	}
});

boot.define("BG","",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.BI(0);
	},
	// js.util.HashMap#size()
	BF:function(){
		return this.a.BF();
	},
	// js.util.HashMap#isEmpty()
	BE:function(){
		return this.a.BE();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	Dx:function(A){
		return this.a.BI(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	Dy:function(A,B,C){
		C=this.Dw().L();
		l1:while (C.N()!=0) {
			B=C.M();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CW:function(A,B){
		B=this.a.Dz(A);
		return (B==null?null:B.EA());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CV:function(A,B,C){
		C=this.a.EB(new boot.BK(A,B,null,0));
		if(C!=null){
			return C.EA();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	EC:function(A,B){
		B=this.a.ED(A);
		if(B!=null){
			return B.EA();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	EE:function(A,B,C){
		C=A.EG().L();
		l1:for (;
		C.N()!=0;
		this.CV(B.EH(),B.EA())) {
			B=C.M();
		}
	},
	// js.util.HashMap#clear()
	BP:function(){
		this.a.BP();
	},
	// js.util.HashMap#keySet()
	EI:function(){
		return new boot.BM(this,null,0);
	},
	// js.util.HashMap#values()
	Dw:function(){
		return new boot.BN(this,null,0);
	},
	// js.util.HashMap#entrySet()
	EG:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_EJ:function(A){
		return A.a;
	}
});

boot.define("BD","",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.BD.a=new boot.BG(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.BD.a.CW(A);
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
		boot.BD.a.CV(A,this);
	},
	// teemowork.model.Item#cost()
	CX:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	CF:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	CY:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	CZ:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	Cu:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	Cv:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	Cw:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	Cx:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	Cy:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	Cz:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	DA:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	DB:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	DC:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	DD:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	DE:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	CH:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	DF:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	DG:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	DH:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	DI:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	DJ:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	DK:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	DL:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	DM:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	DN:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	CG:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	DO:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	DP:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	DQ:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	DR:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	DS:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	DT:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	DU:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	DV:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	DW:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	DX:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	DY:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	DZ:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_Du:function(A){
		return boot.BD.a.CW(A);
	},
	// teemowork.model.Item#getAll()
	_Dv:function(){
		return boot.BD.a.Dw();
	}
});

boot.define("BE","",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.BE.gp=new boot.BG(0);
		boot.BE.a=new boot.BE("Ahri",0);
		boot.BE.b=new boot.BE("Akali",0);
		boot.BE.c=new boot.BE("Alistar",0);
		boot.BE.d=new boot.BE("Amumu",0);
		boot.BE.e=new boot.BE("Anivia",0);
		boot.BE.f=new boot.BE("Annie",0);
		boot.BE.g=new boot.BE("Ashe",0);
		boot.BE.h=new boot.BE("Blitzcrank",0);
		boot.BE.i=new boot.BE("Brand",0);
		boot.BE.j=new boot.BE("Caitlyn",0);
		boot.BE.k=new boot.BE("Cassiopeia",0);
		boot.BE.l=new boot.BE("Chogath",0);
		boot.BE.m=new boot.BE("Corki",0);
		boot.BE.n=new boot.BE("Darius",0);
		boot.BE.o=new boot.BE("Diana",0);
		boot.BE.p=new boot.BE("Dr.Mundo",0);
		boot.BE.ba=new boot.BE("Draven",0);
		boot.BE.bb=new boot.BE("Elise",0);
		boot.BE.bc=new boot.BE("Evelynn",0);
		boot.BE.bd=new boot.BE("Ezreal",0);
		boot.BE.be=new boot.BE("Fiddlesticks",0);
		boot.BE.bf=new boot.BE("Fiora",0);
		boot.BE.bg=new boot.BE("Fizz",0);
		boot.BE.bh=new boot.BE("Galio",0);
		boot.BE.bi=new boot.BE("Gangplank",0);
		boot.BE.bj=new boot.BE("Garen",0);
		boot.BE.bk=new boot.BE("Gragas",0);
		boot.BE.bl=new boot.BE("Graves",0);
		boot.BE.bm=new boot.BE("Hecarim",0);
		boot.BE.bn=new boot.BE("Heimerdinger",0);
		boot.BE.bo=new boot.BE("Irelia",0);
		boot.BE.bp=new boot.BE("Janna",0);
		boot.BE.ca=new boot.BE("Jarvan IV",0);
		boot.BE.cb=new boot.BE("Jax",0);
		boot.BE.cc=new boot.BE("Jayce",0);
		boot.BE.cd=new boot.BE("Karma",0);
		boot.BE.ce=new boot.BE("Karthus",0);
		boot.BE.cf=new boot.BE("Kassadin",0);
		boot.BE.cg=new boot.BE("Katarina",0);
		boot.BE.ch=new boot.BE("Kayle",0);
		boot.BE.ci=new boot.BE("Kennen",0);
		boot.BE.cj=new boot.BE("Kha'zix",0);
		boot.BE.ck=new boot.BE("Kog'maw",0);
		boot.BE.cl=new boot.BE("LeBlanc",0);
		boot.BE.cm=new boot.BE("Lee Sin",0);
		boot.BE.cn=new boot.BE("Leona",0);
		boot.BE.co=new boot.BE("Lulu",0);
		boot.BE.cp=new boot.BE("Lux",0);
		boot.BE.da=new boot.BE("Malphite",0);
		boot.BE.db=new boot.BE("Malzahar",0);
		boot.BE.dc=new boot.BE("Maokai",0);
		boot.BE.dd=new boot.BE("Master Yi",0);
		boot.BE.de=new boot.BE("Miss Fortune",0);
		boot.BE.df=new boot.BE("Mordekaiser",0);
		boot.BE.dg=new boot.BE("Morgana",0);
		boot.BE.dh=new boot.BE("Nami",0);
		boot.BE.di=new boot.BE("Nasus",0);
		boot.BE.dj=new boot.BE("Nautilus",0);
		boot.BE.dk=new boot.BE("Nidalee",0);
		boot.BE.dl=new boot.BE("Nocturne",0);
		boot.BE.dm=new boot.BE("Nunu",0);
		boot.BE.dn=new boot.BE("Olaf",0);
		boot.BE.dp=new boot.BE("Orianna",0);
		boot.BE.ea=new boot.BE("Pantheon",0);
		boot.BE.eb=new boot.BE("Poppy",0);
		boot.BE.ec=new boot.BE("Rammus",0);
		boot.BE.ed=new boot.BE("Renekton",0);
		boot.BE.ee=new boot.BE("Rengar",0);
		boot.BE.ef=new boot.BE("Riven",0);
		boot.BE.eg=new boot.BE("Rumble",0);
		boot.BE.eh=new boot.BE("Ryze",0);
		boot.BE.ei=new boot.BE("Sejuani",0);
		boot.BE.ej=new boot.BE("Shaco",0);
		boot.BE.ek=new boot.BE("Shen",0);
		boot.BE.el=new boot.BE("Shyvana",0);
		boot.BE.em=new boot.BE("Singed",0);
		boot.BE.en=new boot.BE("Sion",0);
		boot.BE.eo=new boot.BE("Sivir",0);
		boot.BE.ep=new boot.BE("Skarner",0);
		boot.BE.fa=new boot.BE("Sona",0);
		boot.BE.fb=new boot.BE("Soraka",0);
		boot.BE.fc=new boot.BE("Swain",0);
		boot.BE.fd=new boot.BE("Syndra",0);
		boot.BE.fe=new boot.BE("Talon",0);
		boot.BE.ff=new boot.BE("Taric",0);
		boot.BE.fg=new boot.BE("Teemo",0);
		boot.BE.fh=new boot.BE("Tristana",0);
		boot.BE.fi=new boot.BE("Trundle",0);
		boot.BE.fj=new boot.BE("Tryndamere",0);
		boot.BE.fk=new boot.BE("Twisted Fate",0);
		boot.BE.fl=new boot.BE("Twitch",0);
		boot.BE.fm=new boot.BE("Udyr",0);
		boot.BE.fn=new boot.BE("Urgot",0);
		boot.BE.fo=new boot.BE("Varus",0);
		boot.BE.fp=new boot.BE("Vayne",0);
		boot.BE.ga=new boot.BE("Veigar",0);
		boot.BE.gb=new boot.BE("Vi",0);
		boot.BE.gc=new boot.BE("Viktor",0);
		boot.BE.gd=new boot.BE("Vladimir",0);
		boot.BE.ge=new boot.BE("Volibear",0);
		boot.BE.gf=new boot.BE("Warwick",0);
		boot.BE.gg=new boot.BE("Wukong",0);
		boot.BE.gh=new boot.BE("Xerath",0);
		boot.BE.gi=new boot.BE("Xin Zhao",0);
		boot.BE.gj=new boot.BE("Yorick",0);
		boot.BE.gk=new boot.BE("Zed",0);
		boot.BE.gl=new boot.BE("Ziggs",0);
		boot.BE.gm=new boot.BE("Zilean",0);
		boot.BE.gn=new boot.BE("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.ha=A;
		this.hb=this.EO().toLowerCase();
		boot.BE.gp.CV(A,this);
	},
	// teemowork.model.Champion#getStatus()
	EP:function(){
		return this.go;
	},
	// teemowork.model.Champion#getSystemName()
	EO:function(){
		return this.ha.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	EQ:function(){
		return "src/main/resources/teemowork/splash/"+this.EO()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	ER:function(){
		return "src/main/resources/teemowork/icon/"+this.EO()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_ES:function(A){
		return boot.BE.gp.CW(A);
	},
	// teemowork.model.Champion#getAll()
	_Dv:function(){
		return boot.BE.gp.Dw();
	}
});

boot.define("BF","",{
	
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
	ET:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	EU:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	CJ:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	EV:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	EW:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	CK:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	EX:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	EY:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	CL:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	EZ:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	Eu:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	CM:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	Ev:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	Ew:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	CN:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	Ex:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	Ey:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	CO:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	Ez:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	FA:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	CP:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	FB:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	FC:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	CQ:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	FD:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	CR:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	FE:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	CS:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	FF:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	CT:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	FG:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	CU:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	FH:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	FI:function(A){
		return this.g+this.h*A;
	}
});

boot.define("O","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.O.b=new boot.O(1510,2012,11,13,"Initial",null,0);
		boot.O.b.CE("Ruby Crystal").CF(475).CG(180);
		boot.O.b.CE("Haunting Guise").CG(200).CH(25);
		boot.O.b.CI(boot.BE.a).CJ(380,80).CK(5.5,0.6).CL(230,50.0).CM(6.25,0.6).CN(50.0,3.0).CO(0.668,2.0).CP(10.0,3.5).CQ(30.0,0).CR(550).CS(330);
		boot.O.b.CI(boot.BE.b).CJ(445,85).CK(7.25,0.65).CT(200).CU(50).CN(53.0,3.2).CO(0.694,3.1).CP(16.5,3.5).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.c).CJ(442,102).CK(7.25,0.85).CL(215,38.0).CM(6.45,0.45).CN(55.03,3.62).CO(0.625,3.62).CP(14.5,3.5).CQ(30.0,1.25).CR(125).CS(325);
		boot.O.b.CI(boot.BE.d).CJ(472,84).CK(7.45,0.85).CL(220,40.0).CM(6.5,0.525).CN(47.0,3.8).CO(0.638,2.18).CP(18.0,3.3).CQ(30.0,1.25).CR(125).CS(335);
		boot.O.b.CI(boot.BE.e).CJ(350,70).CK(4.65,0.55).CL(257,53.0).CM(7.0,0.6).CN(48.0,3.2).CO(0.625,1.68).CP(10.5,4.0).CQ(30.0,0).CR(600).CS(325);
		boot.O.b.CI(boot.BE.f).CJ(384,76).CK(4.5,0.55).CL(250,50.0).CM(6.9,0.6).CN(49.0,2.625).CO(0.579,1.36).CP(12.5,4.0).CQ(30.0,0).CR(625).CS(335);
		boot.O.b.CI(boot.BE.g).CJ(395,79).CK(4.5,0.55).CL(173,35.0).CM(6.3,0.4).CN(46.3,2.85).CO(0.658,3.34).CP(11.5,3.4).CQ(30.0,0).CR(600).CS(325);
		boot.O.b.CI(boot.BE.h).CJ(423,95).CK(7.25,0.75).CL(260,40.0).CM(6.6,0.5).CN(55.66,3.5).CO(0.625,1.13).CP(14.5,3.5).CQ(30.0,1.25).CR(125).CS(325);
		boot.O.b.CI(boot.BE.i).CJ(380,76).CK(4.5,0.55).CL(250,45.0).CM(7.0,0.6).CN(51.66,3.0).CO(0.625,1.36).CP(12.0,3.5).CQ(30.0,0).CR(550).CS(340);
		boot.O.b.CI(boot.BE.j).CJ(390,80).CK(4.75,0.55).CL(255,35.0).CM(6.5,0.55).CN(47.0,3.0).CO(0.668,3.0).CP(13.0,3.5).CQ(30.0,0).CR(650).CS(325);
		boot.O.b.CI(boot.BE.k).CJ(380,75).CK(4.85,0.5).CL(250,50.0).CM(7.1,0.75).CN(47.0,3.2).CO(0.644,1.68).CP(11.5,4.0).CQ(30.0,0).CR(550).CS(335);
		boot.O.b.CI(boot.BE.l).CJ(440,80).CK(7.5,0.85).CL(205,40.0).CM(6.45,0.45).CN(54.1,4.2).CO(0.625,1.44).CP(19.0,3.5).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.m).CJ(375,82).CK(4.5,0.55).CL(243,37.0).CM(6.5,0.55).CN(48.2,3.0).CO(0.658,2.3).CP(13.5,3.5).CQ(30.0,0).CR(550).CS(325);
		boot.O.b.CI(boot.BE.n).CJ(426,93).CK(8.25,0.95).CL(200,37.5).CM(6.0,0.35).CN(50.0,3.5).CO(0.679,2.6).CP(20.0,3.5).CQ(30.0,1.25).CR(125).CS(340);
		boot.O.b.CI(boot.BE.o).CJ(438,90).CK(7.0,0.85).CL(230,40.0).CM(7.0,0.6).CN(48.0,3.0).CO(0.625,2.25).CP(16.0,3.6).CQ(30.0,1.25).CR(150).CS(345);
		boot.O.b.CI(boot.BE.p).CJ(433,89).CK(6.5,0.75).CN(56.23,3.0).CO(0.625,2.8).CP(17.0,3.5).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.ba).CJ(420,82).CK(5.0,0.7).CL(240,42.0).CM(6.95,0.65).CN(46.5,3.5).CO(0.679,2.6).CP(16.0,3.3).CQ(30.0,0).CR(550).CS(330);
		boot.O.b.CI(boot.BE.bb).CJ(395,80).CK(4.7,0.6).CL(240,50.0).CM(6.8,0.65).CN(47.5,3.0).CO(0.625,1.75).CP(12.65,3.35).CQ(30.0,0).CR(550).CS(335);
		boot.O.b.CI(boot.BE.bc).CJ(414,86).CK(6.95,0.55).CL(180,42.0).CM(7.1,0.6).CN(48.0,3.3).CO(0.658,3.84).CP(12.5,4.0).CQ(30.0,1.25).CR(125).CS(340);
		boot.O.b.CI(boot.BE.bd).CJ(350,80).CK(5.5,0.55).CL(235,45.0).CM(7.0,0.65).CN(47.2,3.0).CO(0.665,2.8).CP(12.0,3.5).CQ(30.0,0).CR(550).CS(330);
		boot.O.b.CI(boot.BE.be).CJ(390,80).CK(4.6,0.6).CL(251,59.0).CM(6.9,0.65).CN(45.95,2.625).CO(0.625,2.11).CP(11.0,3.5).CQ(30.0,0).CR(480).CS(335);
		boot.O.b.CI(boot.BE.bf).CJ(450,85).CK(6.3,0.8).CL(220,40.0).CM(7.25,0.5).CN(54.5,3.2).CO(0.672,3.0).CP(15.5,3.5).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.bg).CJ(414,86).CK(7.0,0.7).CL(200,40.0).CM(6.15,0.45).CN(53.0,3.0).CO(0.658,3.1).CP(13.0,3.4).CQ(30.0,1.25).CR(175).CS(335);
		boot.O.b.CI(boot.BE.bh).CJ(435,85).CK(7.45,0.75).CL(235,50.0).CM(7.0,0.7).CN(56.3,3.375).CO(0.638,1.2).CP(17.0,3.5).CQ(30.0,0).CR(125).CS(335);
		boot.O.b.CI(boot.BE.bi).CJ(495,81).CK(425.0,0.75).CL(215,40.0).CM(6.5,0.7).CN(54.0,3.0).CO(0.651,2.75).CP(16.5,3.3).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.bj).CJ(455,96).CK(7.5,0.75).CN(52.5,3.5).CO(0.625,2.9).CP(19.0,2.7).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.bk).CJ(434,89).CK(7.25,0.85).CL(221,47.0).CM(6.45,0.45).CN(55.78,3.375).CO(0.651,2.05).CP(16.0,3.6).CQ(30.0,0).CR(125).CS(340);
		boot.O.b.CI(boot.BE.bl).CJ(410,84).CK(5.5,0.7).CL(255,40.0).CM(6.75,0.7).CN(51.0,3.1).CO(0.625,2.9).CP(15.0,3.2).CQ(30.0,0).CR(525).CS(330);
		boot.O.b.CI(boot.BE.bm).CJ(440,95).CK(8.0,0.75).CL(210,40.0).CM(6.5,0.6).CN(56.0,3.2).CO(0.67,2.5).CP(16.0,4.0).CQ(30.0,1.25).CR(175).CS(345);
		boot.O.b.CI(boot.BE.bn).CJ(350,75).CK(4.5,0.55).CL(240,65.0).CM(7.0,0.65).CN(49.24,3.0).CO(0.625,1.21).CP(7.0,3.0).CQ(30.0,0).CR(550).CS(325);
		boot.O.b.CI(boot.BE.bo).CJ(456,90).CK(7.5,0.65).CL(230,35.0).CM(7.0,0.65).CN(56.0,3.3).CO(0.665,3.2).CP(15.0,3.75).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.bp).CJ(356,78).CK(4.5,0.55).CL(302,64.0).CM(6.9,0.6).CN(49.0,2.95).CO(0.625,2.61).CP(9.0,3.8).CQ(30.0,0).CR(475).CS(335);
		boot.O.b.CI(boot.BE.ca).CJ(420,90).CK(7.0,0.7).CL(235,40.0).CM(6.0,0.45).CN(50.0,3.4).CO(0.658,2.5).CP(14.0,3.0).CQ(30.0,1.25).CR(175).CS(340);
		boot.O.b.CI(boot.BE.cb).CJ(463,98).CK(7.45,0.55).CL(230,35.0).CM(6.4,0.7).CN(56.3,3.375).CO(0.638,3.4).CP(18.0,3.5).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.cc).CJ(420,90).CK(6.0,0.8).CL(240,40.0).CM(7.0,0.7).CN(46.5,3.5).CO(0.658,3.0).CP(12.5,3.5).CQ(30.0,0).CR(125).CS(335);
		boot.O.b.CI(boot.BE.cd).CJ(410,86).CK(4.7,0.55).CL(240,60.0).CM(6.8,0.65).CN(50.0,3.3).CO(0.625,2.3).CP(15.0,3.5).CQ(30.0,0).CR(425).CS(335);
		boot.O.b.CI(boot.BE.ce).CJ(390,75).CK(5.5,0.55).CL(270,61.0).CM(6.5,0.6).CN(42.2,3.25).CO(0.625,2.11).CP(11.0,3.5).CQ(30.0,0).CR(450).CS(335);
		boot.O.b.CI(boot.BE.cf).CJ(433,78).CK(6.95,0.5).CL(230,45.0).CM(6.9,0.6).CN(52.3,3.9).CO(0.638,3.7).CP(14.0,3.2).CQ(30.0,1.25).CR(125).CS(340);
		boot.O.b.CI(boot.BE.cg).CJ(395,83).CK(6.95,0.55).CN(53.0,3.2).CO(0.658,2.74).CP(14.75,4.0).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.ch).CJ(418,93).CK(7.0,0.75).CL(255,40.0).CM(6.9,0.525).CN(53.3,2.8).CO(0.638,2.5).CP(17.0,3.5).CQ(30.0,0.75).CR(125).CS(335);
		boot.O.b.CI(boot.BE.ci).CJ(403,79).CK(4.65,0.65).CT(200).CU(50).CN(51.3,3.3).CO(0.69,3.4).CP(14.0,3.75).CQ(30.0,0).CR(550).CS(335);
		boot.O.b.CI(boot.BE.cj).CJ(430,85).CK(6.25,0.75).CL(260,40.0).CM(6.75,0.5).CN(50.0,3.1).CO(0.665,2.7).CP(15.0,3.0).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.ck).CJ(440,84).CK(5.0,0.55).CL(295,40.0).CM(7.5,0.7).CN(46.0,3.0).CO(0.665,2.65).CP(13.0,3.53).CQ(30.0,0).CR(500).CS(340);
		boot.O.b.CI(boot.BE.cl).CJ(390,75).CK(4.5,0.55).CL(250,50.0).CM(6.9,0.6).CN(51.0,3.1).CO(0.625,1.4).CP(12.0,3.5).CQ(30.0,0).CR(525).CS(335);
		boot.O.b.CI(boot.BE.cm).CJ(428,85).CK(6.25,61.0).CU(200).CU(50).CN(55.8,3.2).CO(0.651,3.0).CP(16.0,3.7).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.cn).CJ(430,87).CK(9.0,0.85).CL(235,40.0).CM(8.0,0.7).CN(55.0,3.0).CO(0.625,2.9).CP(18.0,3.1).CQ(30.0,1.25).CR(125).CS(335);
		boot.O.b.CI(boot.BE.co).CJ(415,82).CK(6.0,0.72).CL(200,50.0).CM(6.0,0.6).CN(44.4,2.6).CO(0.625,2.2).CP(9.0,3.7).CQ(30.0,0).CR(550).CS(325);
		boot.O.b.CI(boot.BE.cp).CJ(345,79).CK(4.5,0.55).CL(250,50.0).CM(6.0,0.6).CN(50.0,3.3).CO(0.625,1.36).CP(8.0,4.0).CQ(30.0,0).CR(550).CS(340);
		boot.O.b.CI(boot.BE.da).CJ(423,90).CK(7.45,0.55).CL(215,40.0).CM(6.4,0.55).CN(56.3,3.375).CO(0.638,3.4).CP(18.0,3.75).CQ(30.0,1.25).CR(125).CS(335);
		boot.O.b.CI(boot.BE.db).CJ(380,80).CK(4.5,0.55).CL(250,45.0).CM(7.0,0.6).CN(51.66,3.0).CO(0.625,1.36).CP(15.0,3.5).CQ(30.0,0).CR(550).CS(340);
		boot.O.b.CI(boot.BE.dc).CJ(421,90).CK(7.25,0.85).CL(250,46.0).CM(6.45,0.45).CN(58.0,3.3).CO(0.694,2.13).CP(18.0,4.0).CQ(30.0,0).CR(125).CS(335);
		boot.O.b.CI(boot.BE.dd).CJ(444,86).CK(6.75,0.65).CL(199,36.0).CM(6.5,0.45).CN(55.12,3.1).CO(0.679,2.98).CP(16.3,3.7).CQ(30.0,1.25).CR(125).CS(355);
		boot.O.b.CI(boot.BE.de).CJ(435,85).CK(5.1,0.65).CL(212,38.0).CM(6.95,0.65).CN(46.5,3.0).CO(0.658,3.01).CP(15.0,3.0).CQ(30.0,0).CR(550).CS(325);
		boot.O.b.CI(boot.BE.df).CJ(421,80).CK(7.45,0.55).CN(51.7,3.5).CO(0.694,3.0).CP(15.0,3.5).CQ(30.0,1.25).CR(125).CS(340);
		boot.O.b.CI(boot.BE.dg).CJ(403,86).CK(4.7,0.6).CL(240,60.0).CM(6.8,0.65).CN(51.58,3.5).CO(0.579,1.53).CP(15.0,3.8).CQ(30.0,0).CR(425).CS(335);
		boot.O.b.CI(boot.BE.dh).CJ(365,74).CK(4.5,45.0).CL(305,43.0).CM(6.9,0.6).CN(48.0,3.1).CO(0.644,2.6).CP(9.0,4.0).CQ(30.0,0).CR(550).CS(330);
		boot.O.b.CI(boot.BE.di).CJ(410,90).CK(7.5,0.9).CL(200,45.0).CM(6.6,0.5).CN(53.3,3.5).CO(0.638,3.48).CP(15.0,3.5).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.dj).CJ(432,86).CK(7.45,0.55).CL(200,50.0).CM(7.45,0.7).CN(52.0,3.3).CO(0.613,0.98).CP(12.0,3.25).CQ(30.0,1.25).CR(175).CS(325);
		boot.O.b.CI(boot.BE.dk).CJ(370,90).CK(5.0,0.6).CL(220,45.0).CM(7.0,0.5).CN(49.0,3.5).CO(0.672,3.22).CP(11.0,3.5).CQ(30.0,10.75).CR(525).CS(335);
		boot.O.b.CI(boot.BE.dl).CJ(430,85).CK(7.0,0.75).CL(215,35.0).CM(6.0,0.45).CN(54.0,3.1).CO(0.668,2.7).CP(17.0,3.5).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.dm).CJ(437,108).CK(7.05,0.8).CL(213,42.0).CM(6.6,0.5).CN(51.6,3.4).CO(0.625,2.25).CP(16.5,3.5).CQ(30.0,1.25).CR(125).CS(340);
		boot.O.b.CI(boot.BE.dn).CJ(441,93).CK(7.0,0.9).CL(225,45.0).CM(6.5,0.575).CN(54.1,3.5).CO(0.694,2.7).CP(17.0,3.0).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.dp).CJ(385,79).CK(5.95,0.55).CL(250,50.0).CM(7.0,0.5).CN(44.0,2.6).CO(0.658,3.5).CP(8.0,3.0).CQ(30.0,0).CR(525).CS(325);
		boot.O.b.CI(boot.BE.ea).CJ(433,87).CK(6.75,0.65).CL(210,34.0).CM(6.6,0.45).CN(50.7,2.9).CO(0.679,2.95).CP(17.1,3.9).CQ(30.0,1.25).CR(155).CS(355);
		boot.O.b.CI(boot.BE.eb).CJ(423,81).CK(7.45,0.55).CL(185,30.0).CM(6.4,0.45).CN(56.3,3.375).CO(0.638,3.35).CP(18.0,4.0).CQ(30.0,0).CR(125).CS(345);
		boot.O.b.CI(boot.BE.ec).CJ(420,86).CK(8.0,0.55).CL(255,33.0).CM(4.5,0.3).CN(50.0,3.5).CO(0.625,2.22).CP(21.0,3.8).CQ(30.0,1.25).CR(125).CS(335);
		boot.O.b.CI(boot.BE.ed).CJ(426,87).CK(6.7,0.75).CN(53.12,3.1).CO(0.665,2.65).CP(15.2,3.8).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.ee).CJ(435,85).CK(4.0,0.4).CN(55.0,3.0).CO(0.679,2.85).CP(16.0,3.5).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.ef).CJ(414,86).CK(10.4,0.9).CN(54.0,2.75).CO(0.625,3.5).CP(15.0,3.1).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.eg).CJ(450,80).CK(7.0,0.7).CN(55.32,3.2).CO(0.644,1.85).CP(16.0,3.5).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.eh).CJ(360,86).CK(4.35,0.55).CL(250,55.0).CM(7.0,0.6).CN(52.0,3.0).CO(0.625,2.11).CP(11.0,3.9).CQ(30.0,0).CR(550).CS(335);
		boot.O.b.CI(boot.BE.ei).CJ(450,85).CK(7.35,0.85).CL(220,40.0).CM(6.45,0.45).CN(54.0,3.4).CO(0.67,1.45).CP(20.5,3.5).CQ(30.0,1.25).CR(125).CS(340);
		boot.O.b.CI(boot.BE.ej).CJ(441,84).CK(7.45,0.55).CL(270,40.0).CM(6.4,0.45).CN(51.7,3.5).CO(0.694,3.0).CP(15.0,3.5).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.ek).CJ(428,85).CK(7.45,0.55).CT(200).CU(50).CN(54.5,3.375).CO(0.651,3.4).CP(15.0,4.0).CQ(30.0,0).CR(125).CS(335);
		boot.O.b.CI(boot.BE.el).CJ(435,95).CK(7.2,0.8).CN(54.5,3.4).CO(0.658,3.4).CP(17.6,3.4).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.em).CJ(405,82).CK(7.1,0.55).CL(215,45.0).CM(6.6,0.55).CN(56.65,3.375).CO(0.613,1.81).CP(18.0,3.5).CQ(30.0,0).CR(125).CS(345);
		boot.O.b.CI(boot.BE.en).CJ(403,104).CK(7.9,0.95).CL(240,40.0).CM(6.3,0.4).CN(55.52,3.1875).CO(0.625,1.63).CP(17.75,3.25).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.eo).CJ(378,82).CK(4.25,0.55).CL(203,43.0).CM(6.5,0.5).CN(49.0,2.9).CO(0.658,3.28).CP(12.75,3.25).CQ(30.0,0).CR(500).CS(335);
		boot.O.b.CI(boot.BE.ep).CJ(440,96).CK(7.5,0.85).CL(205,40.0).CM(6.45,0.45).CN(54.1,4.2).CO(0.625,2.1).CP(19.0,3.8).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.fa).CJ(340,70).CK(4.5,0.55).CL(265,45.0).CM(7.0,0.65).CN(47.0,3.0).CO(0.644,2.3).CP(6.0,3.3).CQ(30.0,0).CR(550).CS(330);
		boot.O.b.CI(boot.BE.fb).CJ(375,71).CK(4.5,0.55).CL(240,60.0).CM(6.8,0.65).CN(48.8,3.0).CO(0.625,2.14).CP(7.4,3.8).CQ(30.0,0).CR(550).CS(335);
		boot.O.b.CI(boot.BE.fc).CJ(385,78).CK(6.75,0.65).CL(240,50.0).CM(6.8,0.65).CN(49.0,3.0).CO(0.625,2.11).CP(12.0,4.0).CQ(30.0,0).CR(500).CS(335);
		boot.O.b.CI(boot.BE.fd).CJ(380,78).CK(5.5,0.6).CL(250,50.0).CM(6.9,0.6).CN(51.0,2.9).CO(0.625,2.0).CP(15.0,3.4).CQ(30.0,0).CR(550).CS(330);
		boot.O.b.CI(boot.BE.fe).CJ(440,85).CK(7.25,0.75).CL(260,40.0).CM(6.75,0.5).CN(50.0,3.1).CO(0.668,2.7).CP(17.0,3.5).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.ff).CJ(468,90).CK(7.1,0.5).CL(255,56.0).CM(4.1,0.4).CN(58.0,3.5).CO(0.625,2.02).CP(16.5,3.2).CQ(30.0,1.25).CR(125).CS(340);
		boot.O.b.CI(boot.BE.fg).CJ(383,82).CK(4.65,0.65).CL(200,40.0).CM(6.45,0.45).CN(44.5,3.0).CO(0.69,3.38).CP(14.0,3.75).CQ(30.0,0).CR(500).CS(330);
		boot.O.b.CI(boot.BE.fh).CJ(415,82).CK(5.1,0.65).CL(193,32.0).CM(6.45,0.45).CN(46.5,3.0).CO(0.658,3.01).CP(15.0,3.0).CQ(30.0,0).CR(550).CS(325);
		boot.O.b.CI(boot.BE.fi).CJ(455,96).CK(8.0,0.85).CL(206,45.0).CM(6.9,0.6).CN(54.66,3.0).CO(0.672,2.9).CP(19.0,2.7).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.fj).CJ(461,98).CK(7.9,0.9).CN(56.0,3.2).CO(0.644,2.9).CP(14.9,3.1).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.fk).CJ(384,82).CK(4.5,0.6).CL(202,38.0).CM(6.5,0.5).CN(46.61,3.3).CO(0.651,3.22).CP(111.25,3.15).CQ(30.0,0).CR(525).CS(330);
		boot.O.b.CI(boot.BE.fl).CJ(389,81).CK(5.0,0.6).CL(220,40.0).CM(6.5,0.45).CN(49.0,3.0).CO(0.679,3.38).CP(14.0,3.0).CQ(30.0,0).CR(550).CS(330);
		boot.O.b.CI(boot.BE.fm).CJ(427,99).CK(7.45,0.75).CL(220,30.0).CM(6.4,0.45).CN(52.91,3.2).CO(0.658,2.67).CP(14.75,4.0).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.fn).CJ(437,89).CK(5.5,0.6).CL(220,55.0).CM(7.5,0.65).CN(48.0,3.6).CO(0.644,2.9).CP(15.0,3.3).CQ(30.0,0).CR(425).CS(335);
		boot.O.b.CI(boot.BE.fo).CJ(400,82).CK(4.5,0.55).CL(250,36.0).CM(6.5,0.5).CN(46.0,3.0).CO(0.658,2.65).CP(13.5,3.4).CQ(30.0,0).CR(575).CS(335);
		boot.O.b.CI(boot.BE.fp).CJ(359,83).CK(4.5,0.55).CL(173,27.0).CM(6.3,0.4).CN(50.0,3.25).CO(0.658,3.1).CP(9.3,3.4).CQ(30.0,0).CR(550).CS(330);
		boot.O.b.CI(boot.BE.ga).CJ(355,82).CK(4.5,0.55).CL(250,55.0).CM(6.9,0.6).CN(48.3,2.625).CO(0.625,2.24).CP(12.25,3.75).CQ(30.0,0).CR(525).CS(340);
		boot.O.b.CI(boot.BE.gb).CJ(440,85).CK(7.5,0.9).CL(220,45.0).CM(7.0,0.65).CN(55.0,3.5).CO(0.643,2.5).CP(16.0,3.5).CQ(30.0,1.25).CR(125).CS(350);
		boot.O.b.CI(boot.BE.gc).CJ(385,78).CK(6.75,0.65).CL(240,50.0).CM(6.9,0.45).CN(49.0,3.0).CO(0.625,2.11).CP(12.0,4.0).CQ(30.0,0).CR(525).CS(335);
		boot.O.b.CI(boot.BE.gd).CJ(400,85).CK(6.0,0.6).CN(45.0,3.0).CO(0.6258,2.0).CP(12.0,3.5).CQ(30.0,0).CR(450).CS(335);
		boot.O.b.CI(boot.BE.ge).CJ(440,86).CK(7.0,0.65).CL(220,30.0).CM(7.0,0.65).CN(54.0,3.3).CO(0.625,2.9).CP(16.5,3.5).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.gf).CJ(428,98).CK(7.05,0.8).CL(190,30.0).CM(7.1,0.6).CN(56.76,3.375).CO(0.679,2.88).CP(16.0,3.5).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.gg).CJ(435,85).CK(5.1,0.65).CL(202,38.0).CM(6.9,0.65).CN(54.0,3.2).CO(0.658,3.0).CP(15.0,3.5).CQ(30.0,1.25).CR(175).CS(345);
		boot.O.b.CI(boot.BE.gh).CJ(380,80).CK(5.0,0.55).CL(250,45.0).CM(8.0,0.6).CN(52.0,3.0).CO(0.625,1.36).CP(12.6,3.4).CQ(30.0,0).CR(550).CS(340);
		boot.O.b.CI(boot.BE.gi).CJ(445,87).CK(7.0,0.7).CL(213,31.0).CM(6.6,0.45).CN(52.0,3.3).CO(0.672,2.7).CP(16.2,3.7).CQ(30.0,1.25).CR(175).CS(345);
		boot.O.b.CI(boot.BE.gj).CJ(421,85).CK(8.5,0.7).CL(235,35.0).CM(6.5,0.45).CN(51.5,3.5).CO(0.625,3.0).CP(18.0,3.6).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.gk).CJ(445,85).CK(6.0,0.65).CT(20).CU(50).CN(48.6,3.4).CO(0.658,3.1).CP(17.5,3.5).CQ(30.0,1.25).CR(125).CS(345);
		boot.O.b.CI(boot.BE.gl).CJ(390,80).CK(5.25,0.6).CL(250,50.0).CM(6.75,0.6).CN(54.0,3.1).CO(0.656,1.7).CP(12.0,3.3).CQ(30.0,0).CR(575).CS(330);
		boot.O.b.CI(boot.BE.gm).CJ(380,71).CK(4.6,0.5).CL(260,60.0).CM(6.95,0.65).CN(48.6,3.0).CO(0.625,2.13).CP(6.75,3.8).CQ(30.0,0).CR(600).CS(335);
		boot.O.b.CI(boot.BE.gn).CJ(355,74).CK(4.85,0.5).CL(250,50.0).CM(7.1,0.75).CN(50.0,3.2).CO(0.625,1.8).CP(11.0,3.0).CQ(30.0,0).CR(575).CS(325);
		boot.O.c=new boot.O(1520,2012,12,3,"Preseason 3",boot.O.b,0);
		boot.O.c.CE("Shard of True Ice");
		boot.O.c.CE("Liandry's Torment");
		boot.O.c.CE("Haunting Guise");
		boot.O.a=boot.O.c;
	},
	// teemowork.model.Patch#<init>(int, int, int, int, java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C,D,E,F){
		this.d=new boot.BG(0);
		this.e=new boot.BG(0);
		this.f=A;
		this.g=E;
		this.h=F;
	},
	// teemowork.model.Patch#updateItem(java.lang.String)
	CE:function(A,B){
		B=new boot.BD(A,this,0);
		this.e.CV(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	CI:function(A){
		A.go=new boot.BF(this,A.go,0);
		return A.go;
	}
});

boot.define("B","C",{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B){
		B=boot.K.K(boot.J.$).L();
		l1:for (;
		B.N()!=0;
		this.D(A)) {
			A=B.M();
		}boot.C.prototype.A.call(this);
		$("body").css("padding","0px 10%");
		A=new boot.M(0);
		A.O("< ^ v ^ > Teemowork","test.html");
		A.O("Patch","#");
		B=A.O("Data","#");
		B.O("Champion","#");
		B.O("Item","#");
		B.O("Mastery","#");
		B.O("Rune","#");
		A.O("Builder","#");
		A.O("About","#");
		A.O("Contact","#");
		console.log(boot.O.a);
	}
});

try {new boot.B(0).A();} catch(e) {console.log(e)}