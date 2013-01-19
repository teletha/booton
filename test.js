boot.define("R","",{
	
	// booton.translator.js.JSAnnotatedElement#<init>(java.lang.String, booton.translator.js.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// booton.translator.js.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	Q:function(A){
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
				if(C[0].equals(A.R())==0){
				}else{
					return C[1];
				}
			}
		}return null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotations()
	S:function(){
		return null;
	},
	// booton.translator.js.JSAnnotatedElement#getDeclaredAnnotations()
	T:function(){
		return this.S();
	}
});

boot.define("G","R",{
	
	// booton.translator.js.JSConstructor#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.R.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	},
	// booton.translator.js.JSConstructor#newInstance(java.lang.Object[])
	u:function(A,B){
		B=Object.create(this.c);
		this.d.apply(B,A);
		return B;
	}
});

boot.define("S","R",{
	
	// booton.translator.js.JSMethod#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.R.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	}
});

boot.define("V","",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.V.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.V.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.V.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.V.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	x:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	y:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	z:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	BA:function(){
		console.log(this.a);
	}
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

boot.define("A","R",{
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject, booton.translator.js.JSClass)
	$0:function(A,B,C,D){
		boot.R.prototype.$0.call(this,A,C["$"]);
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
	// booton.translator.js.JSClass#getDeclaredMethods()
	V:function(A,B,C,D,E){
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
	// booton.translator.js.JSClass#isAssignableFrom(java.lang.Class)
	W:function(A){
		l1:for (;
		A!=null;
		A=A.X()) {
			if(this!=A){
			}else{
				return true;
			}
		}return false;
	},
	// booton.translator.js.JSClass#getSuperclass()
	X:function(){
		return this.e;
	},
	// booton.translator.js.JSClass#getName()
	Y:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	R:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	Z:function(A){
		try{
			return this.E()[0].u(new Array(0));
		} catch ($) {
			if ($ instanceof boot.T) {
				throw new boot.U(A,0);
			}
		}
	},
	// booton.translator.js.JSClass#getConstructor()
	v:function(){
		return null;
	},
	// booton.translator.js.JSClass#forName(java.lang.String)
	_w:function(A){
		return null;
	}
});

boot.define("Z","",{
});

boot.define("N","",{
});

boot.define("Y","",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	BF:function(){
		return this.BG()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BH:function(A,B,C,D){
		B=0;
		D=A.M();
		l2:while (D.O()!=0) {
			C=D.N();
			if(this.H(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BI:function(A,B,C,D){
		B=0;
		D=this.M();
		l2:while (D.O()!=0) {
			C=D.N();
			if(A.BJ(C)!=0){
			}else{
				B=this.BK(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BL:function(A,B,C,D){
		B=0;
		D=A.M();
		l2:while (D.O()!=0) {
			C=D.N();
			if(this.BK(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BM:function(A,B,C){
		C=A.M();
		l1:while (C.O()!=0) {
			B=C.N();
			if(this.BJ(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BN:function(){
		return this.BO(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BO:function(A,B,C,D,E){
		B=this.BG();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.M();
		D=0;
		l6:while (C.O()!=0) {
			E=C.N();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("u","",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	O:function(){
		return this.b<boot.W.Bv(this.a).length;
	},
	// js.util.ArrayList$View#next()
	N:function(){
		return boot.W.Bv(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	Bw:function(){
		if(this.b<=0){
		}else{
			boot.W.Bv(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.u.prototype.$1.call(this,A);
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

boot.define("w","T",{
	
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

boot.define("v","w",{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.w.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.w.prototype.$1.call(this,A);
	}
});

boot.define("W","Y",{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	BG:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BJ:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	M:function(){
		return new boot.u(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	H:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BK:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	BP:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BQ:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	BR:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	BS:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	BT:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	BU:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	BV:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	BW:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	BX:function(){
		throw new boot.U(1);
	},
	// js.util.ArrayList#listIterator(int)
	BY:function(A){
		throw new boot.U(1);
	},
	// js.util.ArrayList#subList(int, int)
	BZ:function(A,B){
		throw new boot.U(1);
	},
	// js.util.ArrayList#checkRange(int)
	Bu:function(A){
		if(A>=0){
			if(this.BG()>A){
				return;
			}else{
				throw new boot.v("Index is overflowed. Size: "+this.BG()+"  Index: "+A,0);
			}
		}else{
			throw new boot.v("Negative index is unacceptable. Size: "+this.BG()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_Bv:function(A){
		return A.a;
	}
});

boot.define("x","",{
	
	// js.dom.Location#<init>()
	$0:function(){
	}
});

boot.define("I","",{
});

boot.define("F","",{
},{
	"$":[["y",{
	}],["z",{
		CA:function() {return [CONSTRUCTOR,TYPE];}
	}],["BA",{
		CB:function() {return RUNTIME;}
	}]]
});

boot.define("H","",{
	
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo)
	$1:function(A,B){
		this.a=A;
		this.b=new RegExp(B.Bx().replace(/\*/g,"([^/].+)"),"");
	},
	// js.Application$Route#match(java.lang.String)
	Bz:function(A,B,C,D){
		B=this.b.exec(A);
		if(B!=null!=0){
			C=new boot.W(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.H(B[D+1]);
			}try{
				return this.a.u(C.BN());
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
	_BC:function(A,B){
		return A.Bz(B);
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

boot.define("BD","",{
	
	// js.util.jQuery$1#<init>(js.util.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// js.util.jQuery$1#hasNext()
	O:function(){
		return this.b<this.a.size();
	},
	// js.util.jQuery$1#next()
	CE:function(){
		return $(this.a.get(this.b++));
	},
	// js.util.jQuery$1#remove()
	Bw:function(){
	},
	// js.util.jQuery$1#next()
	N:function(){
		return this.CE();
	}
});

boot.defineNative("jQuery",{
	
	// js.util.jQuery#<init>()
	$0:function(){
	},
	// js.util.jQuery#child(java.lang.String)
	CC:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// js.util.jQuery#child(java.lang.Class)
	CD:function(A){
		return this.CC("span").addClass(A);
	},
	// js.util.jQuery#iterator()
	M:function(){
		return new boot.BD(this,0);
	}
});
boot.define("E","",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.W(0);
	},
	// js.Application$Router#handler(js.util.jQuery$Event)
	handler:function(A){
		this.BB(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	BB:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.M();
		l3:while (C.O()!=0) {
			B=C.N();
			D=boot.H.BC(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.BD(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	BE:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.BD(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.BB(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_G:function(A){
		return A.a;
	}
},{
	"BE":[["X",{
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

boot.define("BS","Y",{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
	}
});

boot.define("BT","",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, java.lang.String[])
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	O:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	N:function(){
		this.d=boot.BM.Cz(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	Bw:function(){
		if(this.b<=0){
		}else{
			this.a.BK(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, java.lang.String[], js.util.HashSet$View)
	$0:function(A,B,C){
		boot.BT.prototype.$1.call(this,A,B);
	}
});

boot.define("BM","BS",{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.BS.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	BG:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BJ:function(A){
		return this.Cy(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	H:function(A,B){
		B=this.Cy(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BK:function(A,B){
		B=this.Cy(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BQ:function(){
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#iterator()
	M:function(){
		return new boot.BT(this,Object.keys(this.b),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	Cy:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CU:function(A){
		return this.b[this.Cy(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CW:function(A,B,C){
		B=null;
		C=this.Cy(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	CY:function(A,B,C){
		B=null;
		C=this.Cy(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_Cz:function(A){
		return A.b;
	}
});

boot.define("BN","",{
});

boot.define("BO","",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	Cv:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CV:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	DA:function(A,B){
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
		boot.BO.prototype.$1.call(this,A,B);
	}
});

boot.define("BL","",{
});

boot.define("BP","",{
});

boot.define("BU","",{
	
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.a=A;;
		this.b=B;
		this.c=C;
	},
	// js.util.HashMap$View#hasNext()
	O:function(){
		return this.b.O();
	},
	// js.util.HashMap$View#next()
	N:function(A){
		A=this.b.N();
		if(this.c==0){
			return A.CV();
		}else{
			return A.Cv();
		}
	},
	// js.util.HashMap$View#remove()
	Bw:function(){
		this.b.Bw();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.BU.prototype.$1.call(this,A,B,C);
	}
});

boot.define("BQ","BS",{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.BS.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	BG:function(){
		return boot.BK.Cx(this.a).BG();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BJ:function(A){
		return boot.BK.Cx(this.a).BJ(A);
	},
	// js.util.HashMap$Keys#iterator()
	M:function(){
		return new boot.BU(this.a,boot.BK.Cx(this.a).M(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BK:function(A){
		return boot.BK.Cx(this.a).BK(A);
	},
	// js.util.HashMap$Keys#clear()
	BQ:function(){
		boot.BK.Cx(this.a).BQ();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.BQ.prototype.$1.call(this,A);
	}
});

boot.define("BR","Y",{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.Y.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BG:function(){
		return boot.BK.Cx(this.a).BG();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BJ:function(A){
		return this.a.CT(A);
	},
	// js.util.HashMap$Values#iterator()
	M:function(){
		return new boot.BU(this.a,boot.BK.Cx(this.a).M(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BK:function(A,B,C){
		B=this.M();
		l2:while (B.O()!=0) {
			C=B.N();
			if(C!=A){
			}else{
				B.Bw();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BQ:function(){
		boot.BK.Cx(this.a).BQ();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.BR.prototype.$1.call(this,A);
	}
});

boot.define("BK","",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.BM(0);
	},
	// js.util.HashMap#size()
	BG:function(){
		return this.a.BG();
	},
	// js.util.HashMap#isEmpty()
	BF:function(){
		return this.a.BF();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	CS:function(A){
		return this.a.BJ(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CT:function(A,B,C){
		C=this.CR().M();
		l1:while (C.O()!=0) {
			B=C.N();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CP:function(A,B){
		B=this.a.CU(A);
		return (B==null?null:B.CV());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CO:function(A,B,C){
		C=this.a.CW(new boot.BO(A,B,null,0));
		if(C!=null){
			return C.CV();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	CX:function(A,B){
		B=this.a.CY(A);
		if(B!=null){
			return B.CV();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	CZ:function(A,B,C){
		C=A.Cu().M();
		l1:for (;
		C.O()!=0;
		this.CO(B.Cv(),B.CV())) {
			B=C.N();
		}
	},
	// js.util.HashMap#clear()
	BQ:function(){
		this.a.BQ();
	},
	// js.util.HashMap#keySet()
	Cw:function(){
		return new boot.BQ(this,null,0);
	},
	// js.util.HashMap#values()
	CR:function(){
		return new boot.BR(this,null,0);
	},
	// js.util.HashMap#entrySet()
	Cu:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_Cx:function(A){
		return A.a;
	}
});

boot.define("BF","",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.BF.b=new boot.BK(0);
		boot.BF.c=new boot.BF("Ahri",0);
		boot.BF.d=new boot.BF("Akali",0);
		boot.BF.e=new boot.BF("Alistar",0);
		boot.BF.f=new boot.BF("Amumu",0);
		boot.BF.g=new boot.BF("Anivia",0);
		boot.BF.h=new boot.BF("Annie",0);
		boot.BF.i=new boot.BF("Ashe",0);
		boot.BF.j=new boot.BF("Blitzcrank",0);
		boot.BF.k=new boot.BF("Brand",0);
		boot.BF.l=new boot.BF("Caitlyn",0);
		boot.BF.m=new boot.BF("Cassiopeia",0);
		boot.BF.n=new boot.BF("Chogath",0);
		boot.BF.o=new boot.BF("Corki",0);
		boot.BF.p=new boot.BF("Darius",0);
		boot.BF.ba=new boot.BF("Diana",0);
		boot.BF.bb=new boot.BF("Dr.Mundo",0);
		boot.BF.bc=new boot.BF("Draven",0);
		boot.BF.bd=new boot.BF("Elise",0);
		boot.BF.be=new boot.BF("Evelynn",0);
		boot.BF.bf=new boot.BF("Ezreal",0);
		boot.BF.bg=new boot.BF("Fiddlesticks",0);
		boot.BF.bh=new boot.BF("Fiora",0);
		boot.BF.bi=new boot.BF("Fizz",0);
		boot.BF.bj=new boot.BF("Galio",0);
		boot.BF.bk=new boot.BF("Gangplank",0);
		boot.BF.bl=new boot.BF("Garen",0);
		boot.BF.bm=new boot.BF("Gragas",0);
		boot.BF.bn=new boot.BF("Graves",0);
		boot.BF.bo=new boot.BF("Hecarim",0);
		boot.BF.bp=new boot.BF("Heimerdinger",0);
		boot.BF.ca=new boot.BF("Irelia",0);
		boot.BF.cb=new boot.BF("Janna",0);
		boot.BF.cc=new boot.BF("Jarvan IV",0);
		boot.BF.cd=new boot.BF("Jax",0);
		boot.BF.ce=new boot.BF("Jayce",0);
		boot.BF.cf=new boot.BF("Karma",0);
		boot.BF.cg=new boot.BF("Karthus",0);
		boot.BF.ch=new boot.BF("Kassadin",0);
		boot.BF.ci=new boot.BF("Katarina",0);
		boot.BF.cj=new boot.BF("Kayle",0);
		boot.BF.ck=new boot.BF("Kennen",0);
		boot.BF.cl=new boot.BF("Kha'zix",0);
		boot.BF.cm=new boot.BF("Kog'maw",0);
		boot.BF.cn=new boot.BF("LeBlanc",0);
		boot.BF.co=new boot.BF("Lee Sin",0);
		boot.BF.cp=new boot.BF("Leona",0);
		boot.BF.da=new boot.BF("Lulu",0);
		boot.BF.db=new boot.BF("Lux",0);
		boot.BF.dc=new boot.BF("Malphite",0);
		boot.BF.dd=new boot.BF("Malzahar",0);
		boot.BF.de=new boot.BF("Maokai",0);
		boot.BF.df=new boot.BF("Master Yi",0);
		boot.BF.dg=new boot.BF("Miss Fortune",0);
		boot.BF.dh=new boot.BF("Mordekaiser",0);
		boot.BF.di=new boot.BF("Morgana",0);
		boot.BF.dj=new boot.BF("Nami",0);
		boot.BF.dk=new boot.BF("Nasus",0);
		boot.BF.dl=new boot.BF("Nautilus",0);
		boot.BF.dm=new boot.BF("Nidalee",0);
		boot.BF.dn=new boot.BF("Nocturne",0);
		boot.BF.dp=new boot.BF("Nunu",0);
		boot.BF.ea=new boot.BF("Olaf",0);
		boot.BF.eb=new boot.BF("Orianna",0);
		boot.BF.ec=new boot.BF("Pantheon",0);
		boot.BF.ed=new boot.BF("Poppy",0);
		boot.BF.ee=new boot.BF("Rammus",0);
		boot.BF.ef=new boot.BF("Renekton",0);
		boot.BF.eg=new boot.BF("Rengar",0);
		boot.BF.eh=new boot.BF("Riven",0);
		boot.BF.ei=new boot.BF("Rumble",0);
		boot.BF.ej=new boot.BF("Ryze",0);
		boot.BF.ek=new boot.BF("Sejuani",0);
		boot.BF.el=new boot.BF("Shaco",0);
		boot.BF.em=new boot.BF("Shen",0);
		boot.BF.en=new boot.BF("Shyvana",0);
		boot.BF.eo=new boot.BF("Singed",0);
		boot.BF.ep=new boot.BF("Sion",0);
		boot.BF.fa=new boot.BF("Sivir",0);
		boot.BF.fb=new boot.BF("Skarner",0);
		boot.BF.fc=new boot.BF("Sona",0);
		boot.BF.fd=new boot.BF("Soraka",0);
		boot.BF.fe=new boot.BF("Swain",0);
		boot.BF.ff=new boot.BF("Syndra",0);
		boot.BF.fg=new boot.BF("Talon",0);
		boot.BF.fh=new boot.BF("Taric",0);
		boot.BF.fi=new boot.BF("Teemo",0);
		boot.BF.fj=new boot.BF("Tristana",0);
		boot.BF.fk=new boot.BF("Trundle",0);
		boot.BF.fl=new boot.BF("Tryndamere",0);
		boot.BF.fm=new boot.BF("Twisted Fate",0);
		boot.BF.fn=new boot.BF("Twitch",0);
		boot.BF.fo=new boot.BF("Udyr",0);
		boot.BF.fp=new boot.BF("Urgot",0);
		boot.BF.ga=new boot.BF("Varus",0);
		boot.BF.gb=new boot.BF("Vayne",0);
		boot.BF.gc=new boot.BF("Veigar",0);
		boot.BF.gd=new boot.BF("Vi",0);
		boot.BF.ge=new boot.BF("Viktor",0);
		boot.BF.gf=new boot.BF("Vladimir",0);
		boot.BF.gg=new boot.BF("Volibear",0);
		boot.BF.gh=new boot.BF("Warwick",0);
		boot.BF.gi=new boot.BF("Wukong",0);
		boot.BF.gj=new boot.BF("Xerath",0);
		boot.BF.gk=new boot.BF("Xin Zhao",0);
		boot.BF.gl=new boot.BF("Yorick",0);
		boot.BF.gm=new boot.BF("Zed",0);
		boot.BF.gn=new boot.BF("Ziggs",0);
		boot.BF.go=new boot.BF("Zilean",0);
		boot.BF.gp=new boot.BF("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.CN().toLowerCase();
		boot.BF.b.CO(A,this);
	},
	// teemowork.model.Champion#getStatus()
	CJ:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CN:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	CG:function(){
		return "src/main/resources/teemowork/splash/"+this.CN()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	CH:function(){
		return "src/main/resources/teemowork/icon/"+this.CN()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_CF:function(A){
		return boot.BF.b.CP(A);
	},
	// teemowork.model.Champion#getAll()
	_CQ:function(){
		return boot.BF.b.CR();
	}
});

boot.defineNative("Event",{
	
	// js.util.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("BG","",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(js.util.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.K.CM(this.a,boot.K.CL(this.a)+1);
	}
});

boot.define("BH","",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(js.util.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.K.CM(this.a,boot.K.CL(this.a)-1);
	}
});

boot.define("BI","",{
	
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
	DB:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	DC:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	DD:function(A,B){
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
	DG:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DH:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DI:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	DJ:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DK:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DL:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	DM:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DN:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DO:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	DP:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DQ:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DR:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	DS:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DT:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DU:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DV:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DW:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DX:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	DY:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	DZ:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	Du:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	Dv:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	Dw:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	Dx:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	Dy:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	Dz:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	EA:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	CK:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	EB:function(A){
		return this.g+this.h*A;
	}
});

boot.define("K","J",{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.K.prototype.$1.call(this,boot.BF.CF(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.J.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.U(1);
		}
	},
	// teemowork.ChampionDetail#load(js.util.jQuery)
	BD:function(A,B,C){
		B=A.CD("a").css("background-image","url('"+this.a.CG()+"')").CD("b");
		C=B.CD("c").css("background-image","url("+this.a.CH()+")").click(new boot.BG(this,0)).on("contextmenu",new boot.BH(this,0));
		this.b=C.CD("d");
		this.c=B.CD("e").text("Health").CD("f");
		this.CI(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	CI:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.CJ();
			this.c.text(""+B.CK(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	J:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_CL:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CM:function(A,B){
		A.CI(B);
	}
},{
	"$0":[["F",{
		Bx:function() {return "Champion/*";}
	}]],"e":[["BJ",{
	}]]
});

boot.define("BY","",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BY.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BZ","",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, js.util.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(js.util.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BX.EH(this.a).Cu().M();
		l2:while (D.O()!=0) {
			C=D.N();
			if(this.a.EG(C.Cv()).toLowerCase().indexOf(B) != -1==0){
				C.CV().addClass("j");
				continue l2;
			}else{
				C.CV().removeClass("j");
				continue l2;
			}
		}
	}
});

boot.define("Bu","",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(js.util.jQuery$Event)
	handler:function(A){
		this.a.EI(this.b);
	}
});

boot.define("BX","BY",{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BY.prototype.$0.call(this);
		this.b=new boot.BK(0);
		this.c=this.ED();
	},
	// js.ui.ImageGrid#compose(js.util.jQuery)
	EC:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BZ(this,B,0));
		D=this.c.M();
		l6:for (;
		D.O()!=0;
		this.b.CO(C,E)) {
			C=D.N();
			E=this.a.CD("h").css("background-image","url("+this.EE(C)+")");
			E.CC("span").addClass("i").text(this.EG(C));
			E.click(new boot.Bu(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_EH:function(A){
		return A.b;
	}
});

boot.define("BW","BX",{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BX.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	ED:function(){
		return boot.BF.CQ();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	EJ:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	EK:function(A){
		return A.CH();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	EL:function(A){
		boot.C.I(new boot.K(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	EG:function(A){
		return this.EJ(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	EE:function(A){
		return this.EK(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	EI:function(A){
		this.EL(A);
	}
});

boot.define("L","J",{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.J.prototype.$0.call(this);
		this.a=new boot.BW(this,0);
	},
	// teemowork.ChampionSelect#load(js.util.jQuery)
	BD:function(A){
		this.a.EC(A);
	},
	// teemowork.ChampionSelect#getPageId()
	J:function(){
		return "";
	}
},{
	"$0":[["F",{
		Bx:function() {return "";}
	}]]
});

boot.define("M","",{
	
	// js.lang.Classes#<init>()
	$0:function(){
	},
	// js.lang.Classes#find(java.lang.Class)
	_L:function(A,B,C,D,E,F,G){
		B=new boot.W(0);
		F=Object.keys(boot);E=F.length;D=0;
		l2:while (D<E) {
			C=F[D];
			G=boot[C]["$"];
			if((A==G||A.W(G)==0)){
			}else{
				B.H(G);
			}++D;
			continue l2;
		}return B;
	}
});

boot.define("P","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, js.util.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.CC("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	P:function(A,B,C){
		C=this.b.CC("li").addClass("o");
		C.CC("a").addClass("m").attr("href",B).text(A);
		return new boot.P(this.a,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, js.util.jQuery, js.application.Header$Menu)
	$0:function(A,B,C){
		boot.P.prototype.$1.call(this,A,B);
	}
});

boot.define("O","",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("k");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	P:function(A,B,C){
		C=this.a.CC("li").addClass("l");
		C.CC("a").addClass("m").attr("href",B).text(A);
		return new boot.P(this,C,null,0);
	}
});

boot.define("Bv","",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.Bv.a=new boot.BK(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.Bv.a.CP(A);
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
		boot.Bv.a.CO(A,this);
	},
	// teemowork.model.Item#cost()
	ES:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	EO:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	ET:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	EU:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	EV:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	EW:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	EX:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	EY:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	EZ:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	Eu:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	Ev:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	Ew:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	Ex:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	Ey:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	Ez:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	EQ:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	FA:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	FB:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	FC:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	FD:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	FE:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	FF:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	FG:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	FH:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	FI:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	EP:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	FJ:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	FK:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FL:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FM:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FN:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FO:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FP:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FQ:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FR:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FS:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FT:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FU:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FV:function(A){
		return boot.Bv.a.CP(A);
	},
	// teemowork.model.Item#getAll()
	_CQ:function(){
		return boot.Bv.a.CR();
	}
});

boot.define("Q","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.Q.b=new boot.Q(1510,2012,11,13,"Initial",null,0);
		boot.Q.b.EM("Ruby Crystal").EO(475).EP(180);
		boot.Q.b.EM("Haunting Guise").EP(200).EQ(25);
		boot.Q.b.ER(boot.BF.c).DD(380,80).DG(5.5,0.6).DJ(230,50.0).DM(6.25,0.6).DP(50.0,3.0).DS(0.668,2.0).DV(10.0,3.5).DY(30.0,0).Du(550).Dw(330);
		boot.Q.b.ER(boot.BF.d).DD(445,85).DG(7.25,0.65).Dy(200).EA(50).DP(53.0,3.2).DS(0.694,3.1).DV(16.5,3.5).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.e).DD(442,102).DG(7.25,0.85).DJ(215,38.0).DM(6.45,0.45).DP(55.03,3.62).DS(0.625,3.62).DV(14.5,3.5).DY(30.0,1.25).Du(125).Dw(325);
		boot.Q.b.ER(boot.BF.f).DD(472,84).DG(7.45,0.85).DJ(220,40.0).DM(6.5,0.525).DP(47.0,3.8).DS(0.638,2.18).DV(18.0,3.3).DY(30.0,1.25).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.g).DD(350,70).DG(4.65,0.55).DJ(257,53.0).DM(7.0,0.6).DP(48.0,3.2).DS(0.625,1.68).DV(10.5,4.0).DY(30.0,0).Du(600).Dw(325);
		boot.Q.b.ER(boot.BF.h).DD(384,76).DG(4.5,0.55).DJ(250,50.0).DM(6.9,0.6).DP(49.0,2.625).DS(0.579,1.36).DV(12.5,4.0).DY(30.0,0).Du(625).Dw(335);
		boot.Q.b.ER(boot.BF.i).DD(395,79).DG(4.5,0.55).DJ(173,35.0).DM(6.3,0.4).DP(46.3,2.85).DS(0.658,3.34).DV(11.5,3.4).DY(30.0,0).Du(600).Dw(325);
		boot.Q.b.ER(boot.BF.j).DD(423,95).DG(7.25,0.75).DJ(260,40.0).DM(6.6,0.5).DP(55.66,3.5).DS(0.625,1.13).DV(14.5,3.5).DY(30.0,1.25).Du(125).Dw(325);
		boot.Q.b.ER(boot.BF.k).DD(380,76).DG(4.5,0.55).DJ(250,45.0).DM(7.0,0.6).DP(51.66,3.0).DS(0.625,1.36).DV(12.0,3.5).DY(30.0,0).Du(550).Dw(340);
		boot.Q.b.ER(boot.BF.l).DD(390,80).DG(4.75,0.55).DJ(255,35.0).DM(6.5,0.55).DP(47.0,3.0).DS(0.668,3.0).DV(13.0,3.5).DY(30.0,0).Du(650).Dw(325);
		boot.Q.b.ER(boot.BF.m).DD(380,75).DG(4.85,0.5).DJ(250,50.0).DM(7.1,0.75).DP(47.0,3.2).DS(0.644,1.68).DV(11.5,4.0).DY(30.0,0).Du(550).Dw(335);
		boot.Q.b.ER(boot.BF.n).DD(440,80).DG(7.5,0.85).DJ(205,40.0).DM(6.45,0.45).DP(54.1,4.2).DS(0.625,1.44).DV(19.0,3.5).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.o).DD(375,82).DG(4.5,0.55).DJ(243,37.0).DM(6.5,0.55).DP(48.2,3.0).DS(0.658,2.3).DV(13.5,3.5).DY(30.0,0).Du(550).Dw(325);
		boot.Q.b.ER(boot.BF.p).DD(426,93).DG(8.25,0.95).DJ(200,37.5).DM(6.0,0.35).DP(50.0,3.5).DS(0.679,2.6).DV(20.0,3.5).DY(30.0,1.25).Du(125).Dw(340);
		boot.Q.b.ER(boot.BF.ba).DD(438,90).DG(7.0,0.85).DJ(230,40.0).DM(7.0,0.6).DP(48.0,3.0).DS(0.625,2.25).DV(16.0,3.6).DY(30.0,1.25).Du(150).Dw(345);
		boot.Q.b.ER(boot.BF.bb).DD(433,89).DG(6.5,0.75).DP(56.23,3.0).DS(0.625,2.8).DV(17.0,3.5).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.bc).DD(420,82).DG(5.0,0.7).DJ(240,42.0).DM(6.95,0.65).DP(46.5,3.5).DS(0.679,2.6).DV(16.0,3.3).DY(30.0,0).Du(550).Dw(330);
		boot.Q.b.ER(boot.BF.bd).DD(395,80).DG(4.7,0.6).DJ(240,50.0).DM(6.8,0.65).DP(47.5,3.0).DS(0.625,1.75).DV(12.65,3.35).DY(30.0,0).Du(550).Dw(335);
		boot.Q.b.ER(boot.BF.be).DD(414,86).DG(6.95,0.55).DJ(180,42.0).DM(7.1,0.6).DP(48.0,3.3).DS(0.658,3.84).DV(12.5,4.0).DY(30.0,1.25).Du(125).Dw(340);
		boot.Q.b.ER(boot.BF.bf).DD(350,80).DG(5.5,0.55).DJ(235,45.0).DM(7.0,0.65).DP(47.2,3.0).DS(0.665,2.8).DV(12.0,3.5).DY(30.0,0).Du(550).Dw(330);
		boot.Q.b.ER(boot.BF.bg).DD(390,80).DG(4.6,0.6).DJ(251,59.0).DM(6.9,0.65).DP(45.95,2.625).DS(0.625,2.11).DV(11.0,3.5).DY(30.0,0).Du(480).Dw(335);
		boot.Q.b.ER(boot.BF.bh).DD(450,85).DG(6.3,0.8).DJ(220,40.0).DM(7.25,0.5).DP(54.5,3.2).DS(0.672,3.0).DV(15.5,3.5).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.bi).DD(414,86).DG(7.0,0.7).DJ(200,40.0).DM(6.15,0.45).DP(53.0,3.0).DS(0.658,3.1).DV(13.0,3.4).DY(30.0,1.25).Du(175).Dw(335);
		boot.Q.b.ER(boot.BF.bj).DD(435,85).DG(7.45,0.75).DJ(235,50.0).DM(7.0,0.7).DP(56.3,3.375).DS(0.638,1.2).DV(17.0,3.5).DY(30.0,0).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.bk).DD(495,81).DG(425.0,0.75).DJ(215,40.0).DM(6.5,0.7).DP(54.0,3.0).DS(0.651,2.75).DV(16.5,3.3).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.bl).DD(455,96).DG(7.5,0.75).DP(52.5,3.5).DS(0.625,2.9).DV(19.0,2.7).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.bm).DD(434,89).DG(7.25,0.85).DJ(221,47.0).DM(6.45,0.45).DP(55.78,3.375).DS(0.651,2.05).DV(16.0,3.6).DY(30.0,0).Du(125).Dw(340);
		boot.Q.b.ER(boot.BF.bn).DD(410,84).DG(5.5,0.7).DJ(255,40.0).DM(6.75,0.7).DP(51.0,3.1).DS(0.625,2.9).DV(15.0,3.2).DY(30.0,0).Du(525).Dw(330);
		boot.Q.b.ER(boot.BF.bo).DD(440,95).DG(8.0,0.75).DJ(210,40.0).DM(6.5,0.6).DP(56.0,3.2).DS(0.67,2.5).DV(16.0,4.0).DY(30.0,1.25).Du(175).Dw(345);
		boot.Q.b.ER(boot.BF.bp).DD(350,75).DG(4.5,0.55).DJ(240,65.0).DM(7.0,0.65).DP(49.24,3.0).DS(0.625,1.21).DV(7.0,3.0).DY(30.0,0).Du(550).Dw(325);
		boot.Q.b.ER(boot.BF.ca).DD(456,90).DG(7.5,0.65).DJ(230,35.0).DM(7.0,0.65).DP(56.0,3.3).DS(0.665,3.2).DV(15.0,3.75).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.cb).DD(356,78).DG(4.5,0.55).DJ(302,64.0).DM(6.9,0.6).DP(49.0,2.95).DS(0.625,2.61).DV(9.0,3.8).DY(30.0,0).Du(475).Dw(335);
		boot.Q.b.ER(boot.BF.cc).DD(420,90).DG(7.0,0.7).DJ(235,40.0).DM(6.0,0.45).DP(50.0,3.4).DS(0.658,2.5).DV(14.0,3.0).DY(30.0,1.25).Du(175).Dw(340);
		boot.Q.b.ER(boot.BF.cd).DD(463,98).DG(7.45,0.55).DJ(230,35.0).DM(6.4,0.7).DP(56.3,3.375).DS(0.638,3.4).DV(18.0,3.5).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.ce).DD(420,90).DG(6.0,0.8).DJ(240,40.0).DM(7.0,0.7).DP(46.5,3.5).DS(0.658,3.0).DV(12.5,3.5).DY(30.0,0).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.cf).DD(410,86).DG(4.7,0.55).DJ(240,60.0).DM(6.8,0.65).DP(50.0,3.3).DS(0.625,2.3).DV(15.0,3.5).DY(30.0,0).Du(425).Dw(335);
		boot.Q.b.ER(boot.BF.cg).DD(390,75).DG(5.5,0.55).DJ(270,61.0).DM(6.5,0.6).DP(42.2,3.25).DS(0.625,2.11).DV(11.0,3.5).DY(30.0,0).Du(450).Dw(335);
		boot.Q.b.ER(boot.BF.ch).DD(433,78).DG(6.95,0.5).DJ(230,45.0).DM(6.9,0.6).DP(52.3,3.9).DS(0.638,3.7).DV(14.0,3.2).DY(30.0,1.25).Du(125).Dw(340);
		boot.Q.b.ER(boot.BF.ci).DD(395,83).DG(6.95,0.55).DP(53.0,3.2).DS(0.658,2.74).DV(14.75,4.0).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.cj).DD(418,93).DG(7.0,0.75).DJ(255,40.0).DM(6.9,0.525).DP(53.3,2.8).DS(0.638,2.5).DV(17.0,3.5).DY(30.0,0.75).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.ck).DD(403,79).DG(4.65,0.65).Dy(200).EA(50).DP(51.3,3.3).DS(0.69,3.4).DV(14.0,3.75).DY(30.0,0).Du(550).Dw(335);
		boot.Q.b.ER(boot.BF.cl).DD(430,85).DG(6.25,0.75).DJ(260,40.0).DM(6.75,0.5).DP(50.0,3.1).DS(0.665,2.7).DV(15.0,3.0).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.cm).DD(440,84).DG(5.0,0.55).DJ(295,40.0).DM(7.5,0.7).DP(46.0,3.0).DS(0.665,2.65).DV(13.0,3.53).DY(30.0,0).Du(500).Dw(340);
		boot.Q.b.ER(boot.BF.cn).DD(390,75).DG(4.5,0.55).DJ(250,50.0).DM(6.9,0.6).DP(51.0,3.1).DS(0.625,1.4).DV(12.0,3.5).DY(30.0,0).Du(525).Dw(335);
		boot.Q.b.ER(boot.BF.co).DD(428,85).DG(6.25,61.0).EA(200).EA(50).DP(55.8,3.2).DS(0.651,3.0).DV(16.0,3.7).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.cp).DD(430,87).DG(9.0,0.85).DJ(235,40.0).DM(8.0,0.7).DP(55.0,3.0).DS(0.625,2.9).DV(18.0,3.1).DY(30.0,1.25).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.da).DD(415,82).DG(6.0,0.72).DJ(200,50.0).DM(6.0,0.6).DP(44.4,2.6).DS(0.625,2.2).DV(9.0,3.7).DY(30.0,0).Du(550).Dw(325);
		boot.Q.b.ER(boot.BF.db).DD(345,79).DG(4.5,0.55).DJ(250,50.0).DM(6.0,0.6).DP(50.0,3.3).DS(0.625,1.36).DV(8.0,4.0).DY(30.0,0).Du(550).Dw(340);
		boot.Q.b.ER(boot.BF.dc).DD(423,90).DG(7.45,0.55).DJ(215,40.0).DM(6.4,0.55).DP(56.3,3.375).DS(0.638,3.4).DV(18.0,3.75).DY(30.0,1.25).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.dd).DD(380,80).DG(4.5,0.55).DJ(250,45.0).DM(7.0,0.6).DP(51.66,3.0).DS(0.625,1.36).DV(15.0,3.5).DY(30.0,0).Du(550).Dw(340);
		boot.Q.b.ER(boot.BF.de).DD(421,90).DG(7.25,0.85).DJ(250,46.0).DM(6.45,0.45).DP(58.0,3.3).DS(0.694,2.13).DV(18.0,4.0).DY(30.0,0).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.df).DD(444,86).DG(6.75,0.65).DJ(199,36.0).DM(6.5,0.45).DP(55.12,3.1).DS(0.679,2.98).DV(16.3,3.7).DY(30.0,1.25).Du(125).Dw(355);
		boot.Q.b.ER(boot.BF.dg).DD(435,85).DG(5.1,0.65).DJ(212,38.0).DM(6.95,0.65).DP(46.5,3.0).DS(0.658,3.01).DV(15.0,3.0).DY(30.0,0).Du(550).Dw(325);
		boot.Q.b.ER(boot.BF.dh).DD(421,80).DG(7.45,0.55).DP(51.7,3.5).DS(0.694,3.0).DV(15.0,3.5).DY(30.0,1.25).Du(125).Dw(340);
		boot.Q.b.ER(boot.BF.di).DD(403,86).DG(4.7,0.6).DJ(240,60.0).DM(6.8,0.65).DP(51.58,3.5).DS(0.579,1.53).DV(15.0,3.8).DY(30.0,0).Du(425).Dw(335);
		boot.Q.b.ER(boot.BF.dj).DD(365,74).DG(4.5,45.0).DJ(305,43.0).DM(6.9,0.6).DP(48.0,3.1).DS(0.644,2.6).DV(9.0,4.0).DY(30.0,0).Du(550).Dw(330);
		boot.Q.b.ER(boot.BF.dk).DD(410,90).DG(7.5,0.9).DJ(200,45.0).DM(6.6,0.5).DP(53.3,3.5).DS(0.638,3.48).DV(15.0,3.5).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.dl).DD(432,86).DG(7.45,0.55).DJ(200,50.0).DM(7.45,0.7).DP(52.0,3.3).DS(0.613,0.98).DV(12.0,3.25).DY(30.0,1.25).Du(175).Dw(325);
		boot.Q.b.ER(boot.BF.dm).DD(370,90).DG(5.0,0.6).DJ(220,45.0).DM(7.0,0.5).DP(49.0,3.5).DS(0.672,3.22).DV(11.0,3.5).DY(30.0,10.75).Du(525).Dw(335);
		boot.Q.b.ER(boot.BF.dn).DD(430,85).DG(7.0,0.75).DJ(215,35.0).DM(6.0,0.45).DP(54.0,3.1).DS(0.668,2.7).DV(17.0,3.5).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.dp).DD(437,108).DG(7.05,0.8).DJ(213,42.0).DM(6.6,0.5).DP(51.6,3.4).DS(0.625,2.25).DV(16.5,3.5).DY(30.0,1.25).Du(125).Dw(340);
		boot.Q.b.ER(boot.BF.ea).DD(441,93).DG(7.0,0.9).DJ(225,45.0).DM(6.5,0.575).DP(54.1,3.5).DS(0.694,2.7).DV(17.0,3.0).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.eb).DD(385,79).DG(5.95,0.55).DJ(250,50.0).DM(7.0,0.5).DP(44.0,2.6).DS(0.658,3.5).DV(8.0,3.0).DY(30.0,0).Du(525).Dw(325);
		boot.Q.b.ER(boot.BF.ec).DD(433,87).DG(6.75,0.65).DJ(210,34.0).DM(6.6,0.45).DP(50.7,2.9).DS(0.679,2.95).DV(17.1,3.9).DY(30.0,1.25).Du(155).Dw(355);
		boot.Q.b.ER(boot.BF.ed).DD(423,81).DG(7.45,0.55).DJ(185,30.0).DM(6.4,0.45).DP(56.3,3.375).DS(0.638,3.35).DV(18.0,4.0).DY(30.0,0).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.ee).DD(420,86).DG(8.0,0.55).DJ(255,33.0).DM(4.5,0.3).DP(50.0,3.5).DS(0.625,2.22).DV(21.0,3.8).DY(30.0,1.25).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.ef).DD(426,87).DG(6.7,0.75).DP(53.12,3.1).DS(0.665,2.65).DV(15.2,3.8).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.eg).DD(435,85).DG(4.0,0.4).DP(55.0,3.0).DS(0.679,2.85).DV(16.0,3.5).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.eh).DD(414,86).DG(10.4,0.9).DP(54.0,2.75).DS(0.625,3.5).DV(15.0,3.1).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.ei).DD(450,80).DG(7.0,0.7).DP(55.32,3.2).DS(0.644,1.85).DV(16.0,3.5).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.ej).DD(360,86).DG(4.35,0.55).DJ(250,55.0).DM(7.0,0.6).DP(52.0,3.0).DS(0.625,2.11).DV(11.0,3.9).DY(30.0,0).Du(550).Dw(335);
		boot.Q.b.ER(boot.BF.ek).DD(450,85).DG(7.35,0.85).DJ(220,40.0).DM(6.45,0.45).DP(54.0,3.4).DS(0.67,1.45).DV(20.5,3.5).DY(30.0,1.25).Du(125).Dw(340);
		boot.Q.b.ER(boot.BF.el).DD(441,84).DG(7.45,0.55).DJ(270,40.0).DM(6.4,0.45).DP(51.7,3.5).DS(0.694,3.0).DV(15.0,3.5).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.em).DD(428,85).DG(7.45,0.55).Dy(200).EA(50).DP(54.5,3.375).DS(0.651,3.4).DV(15.0,4.0).DY(30.0,0).Du(125).Dw(335);
		boot.Q.b.ER(boot.BF.en).DD(435,95).DG(7.2,0.8).DP(54.5,3.4).DS(0.658,3.4).DV(17.6,3.4).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.eo).DD(405,82).DG(7.1,0.55).DJ(215,45.0).DM(6.6,0.55).DP(56.65,3.375).DS(0.613,1.81).DV(18.0,3.5).DY(30.0,0).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.ep).DD(403,104).DG(7.9,0.95).DJ(240,40.0).DM(6.3,0.4).DP(55.52,3.1875).DS(0.625,1.63).DV(17.75,3.25).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.fa).DD(378,82).DG(4.25,0.55).DJ(203,43.0).DM(6.5,0.5).DP(49.0,2.9).DS(0.658,3.28).DV(12.75,3.25).DY(30.0,0).Du(500).Dw(335);
		boot.Q.b.ER(boot.BF.fb).DD(440,96).DG(7.5,0.85).DJ(205,40.0).DM(6.45,0.45).DP(54.1,4.2).DS(0.625,2.1).DV(19.0,3.8).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.fc).DD(340,70).DG(4.5,0.55).DJ(265,45.0).DM(7.0,0.65).DP(47.0,3.0).DS(0.644,2.3).DV(6.0,3.3).DY(30.0,0).Du(550).Dw(330);
		boot.Q.b.ER(boot.BF.fd).DD(375,71).DG(4.5,0.55).DJ(240,60.0).DM(6.8,0.65).DP(48.8,3.0).DS(0.625,2.14).DV(7.4,3.8).DY(30.0,0).Du(550).Dw(335);
		boot.Q.b.ER(boot.BF.fe).DD(385,78).DG(6.75,0.65).DJ(240,50.0).DM(6.8,0.65).DP(49.0,3.0).DS(0.625,2.11).DV(12.0,4.0).DY(30.0,0).Du(500).Dw(335);
		boot.Q.b.ER(boot.BF.ff).DD(380,78).DG(5.5,0.6).DJ(250,50.0).DM(6.9,0.6).DP(51.0,2.9).DS(0.625,2.0).DV(15.0,3.4).DY(30.0,0).Du(550).Dw(330);
		boot.Q.b.ER(boot.BF.fg).DD(440,85).DG(7.25,0.75).DJ(260,40.0).DM(6.75,0.5).DP(50.0,3.1).DS(0.668,2.7).DV(17.0,3.5).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.fh).DD(468,90).DG(7.1,0.5).DJ(255,56.0).DM(4.1,0.4).DP(58.0,3.5).DS(0.625,2.02).DV(16.5,3.2).DY(30.0,1.25).Du(125).Dw(340);
		boot.Q.b.ER(boot.BF.fi).DD(383,82).DG(4.65,0.65).DJ(200,40.0).DM(6.45,0.45).DP(44.5,3.0).DS(0.69,3.38).DV(14.0,3.75).DY(30.0,0).Du(500).Dw(330);
		boot.Q.b.ER(boot.BF.fj).DD(415,82).DG(5.1,0.65).DJ(193,32.0).DM(6.45,0.45).DP(46.5,3.0).DS(0.658,3.01).DV(15.0,3.0).DY(30.0,0).Du(550).Dw(325);
		boot.Q.b.ER(boot.BF.fk).DD(455,96).DG(8.0,0.85).DJ(206,45.0).DM(6.9,0.6).DP(54.66,3.0).DS(0.672,2.9).DV(19.0,2.7).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.fl).DD(461,98).DG(7.9,0.9).DP(56.0,3.2).DS(0.644,2.9).DV(14.9,3.1).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.fm).DD(384,82).DG(4.5,0.6).DJ(202,38.0).DM(6.5,0.5).DP(46.61,3.3).DS(0.651,3.22).DV(111.25,3.15).DY(30.0,0).Du(525).Dw(330);
		boot.Q.b.ER(boot.BF.fn).DD(389,81).DG(5.0,0.6).DJ(220,40.0).DM(6.5,0.45).DP(49.0,3.0).DS(0.679,3.38).DV(14.0,3.0).DY(30.0,0).Du(550).Dw(330);
		boot.Q.b.ER(boot.BF.fo).DD(427,99).DG(7.45,0.75).DJ(220,30.0).DM(6.4,0.45).DP(52.91,3.2).DS(0.658,2.67).DV(14.75,4.0).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.fp).DD(437,89).DG(5.5,0.6).DJ(220,55.0).DM(7.5,0.65).DP(48.0,3.6).DS(0.644,2.9).DV(15.0,3.3).DY(30.0,0).Du(425).Dw(335);
		boot.Q.b.ER(boot.BF.ga).DD(400,82).DG(4.5,0.55).DJ(250,36.0).DM(6.5,0.5).DP(46.0,3.0).DS(0.658,2.65).DV(13.5,3.4).DY(30.0,0).Du(575).Dw(335);
		boot.Q.b.ER(boot.BF.gb).DD(359,83).DG(4.5,0.55).DJ(173,27.0).DM(6.3,0.4).DP(50.0,3.25).DS(0.658,3.1).DV(9.3,3.4).DY(30.0,0).Du(550).Dw(330);
		boot.Q.b.ER(boot.BF.gc).DD(355,82).DG(4.5,0.55).DJ(250,55.0).DM(6.9,0.6).DP(48.3,2.625).DS(0.625,2.24).DV(12.25,3.75).DY(30.0,0).Du(525).Dw(340);
		boot.Q.b.ER(boot.BF.gd).DD(440,85).DG(7.5,0.9).DJ(220,45.0).DM(7.0,0.65).DP(55.0,3.5).DS(0.643,2.5).DV(16.0,3.5).DY(30.0,1.25).Du(125).Dw(350);
		boot.Q.b.ER(boot.BF.ge).DD(385,78).DG(6.75,0.65).DJ(240,50.0).DM(6.9,0.45).DP(49.0,3.0).DS(0.625,2.11).DV(12.0,4.0).DY(30.0,0).Du(525).Dw(335);
		boot.Q.b.ER(boot.BF.gf).DD(400,85).DG(6.0,0.6).DP(45.0,3.0).DS(0.6258,2.0).DV(12.0,3.5).DY(30.0,0).Du(450).Dw(335);
		boot.Q.b.ER(boot.BF.gg).DD(440,86).DG(7.0,0.65).DJ(220,30.0).DM(7.0,0.65).DP(54.0,3.3).DS(0.625,2.9).DV(16.5,3.5).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.gh).DD(428,98).DG(7.05,0.8).DJ(190,30.0).DM(7.1,0.6).DP(56.76,3.375).DS(0.679,2.88).DV(16.0,3.5).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.gi).DD(435,85).DG(5.1,0.65).DJ(202,38.0).DM(6.9,0.65).DP(54.0,3.2).DS(0.658,3.0).DV(15.0,3.5).DY(30.0,1.25).Du(175).Dw(345);
		boot.Q.b.ER(boot.BF.gj).DD(380,80).DG(5.0,0.55).DJ(250,45.0).DM(8.0,0.6).DP(52.0,3.0).DS(0.625,1.36).DV(12.6,3.4).DY(30.0,0).Du(550).Dw(340);
		boot.Q.b.ER(boot.BF.gk).DD(445,87).DG(7.0,0.7).DJ(213,31.0).DM(6.6,0.45).DP(52.0,3.3).DS(0.672,2.7).DV(16.2,3.7).DY(30.0,1.25).Du(175).Dw(345);
		boot.Q.b.ER(boot.BF.gl).DD(421,85).DG(8.5,0.7).DJ(235,35.0).DM(6.5,0.45).DP(51.5,3.5).DS(0.625,3.0).DV(18.0,3.6).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.gm).DD(445,85).DG(6.0,0.65).Dy(20).EA(50).DP(48.6,3.4).DS(0.658,3.1).DV(17.5,3.5).DY(30.0,1.25).Du(125).Dw(345);
		boot.Q.b.ER(boot.BF.gn).DD(390,80).DG(5.25,0.6).DJ(250,50.0).DM(6.75,0.6).DP(54.0,3.1).DS(0.656,1.7).DV(12.0,3.3).DY(30.0,0).Du(575).Dw(330);
		boot.Q.b.ER(boot.BF.go).DD(380,71).DG(4.6,0.5).DJ(260,60.0).DM(6.95,0.65).DP(48.6,3.0).DS(0.625,2.13).DV(6.75,3.8).DY(30.0,0).Du(600).Dw(335);
		boot.Q.b.ER(boot.BF.gp).DD(355,74).DG(4.85,0.5).DJ(250,50.0).DM(7.1,0.75).DP(50.0,3.2).DS(0.625,1.8).DV(11.0,3.0).DY(30.0,0).Du(575).Dw(325);
		boot.Q.c=new boot.Q(1520,2012,12,3,"Preseason 3",boot.Q.b,0);
		boot.Q.c.EM("Shard of True Ice");
		boot.Q.c.EM("Liandry's Torment");
		boot.Q.c.EM("Haunting Guise");
		boot.Q.a=boot.Q.c;
	},
	// teemowork.model.Patch#<init>(int, int, int, int, java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C,D,E,F){
		this.d=new boot.BK(0);
		this.e=new boot.BK(0);
		this.f=A;
		this.g=E;
		this.h=F;
	},
	// teemowork.model.Patch#updateItem(java.lang.String)
	EM:function(A,B){
		B=new boot.Bv(A,this,0);
		this.e.CO(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	ER:function(A){
		A.hb=new boot.BI(this,A.hb,0);
		return A.hb;
	}
});

boot.define("B","C",{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#register()
	K:function(){
		this.D(boot.K.$);
		this.D(boot.L.$);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B){
		B=boot.M.L(boot.J.$).M();
		l1:for (;
		B.O()!=0;
		this.D(A)) {
			A=B.N();
		}boot.C.prototype.A.call(this);
		$("body").css("padding","0px 10%");
		A=new boot.O(0);
		A.P("< ^ v ^ > Teemowork","test.html");
		A.P("Patch","#");
		B=A.P("Data","#");
		B.P("Champion","#");
		B.P("Item","#");
		B.P("Mastery","#");
		B.P("Rune","#");
		A.P("Builder","#");
		A.P("About","#");
		A.P("Contact","#");
		console.log(boot.Q.a);
	}
});

try {new boot.B(0).A();} catch(e) {console.log(e)}