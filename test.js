boot.define("Q","",{
	
	// booton.translator.js.JSAnnotatedElement#<init>(java.lang.String, booton.translator.js.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// booton.translator.js.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	O:function(A){
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
				if(C[0].equals(A.P())==0){
				}else{
					return C[1];
				}
			}
		}return null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotations()
	Q:function(){
		return null;
	},
	// booton.translator.js.JSAnnotatedElement#getDeclaredAnnotations()
	R:function(){
		return this.Q();
	}
});

boot.define("G","Q",{
	
	// booton.translator.js.JSConstructor#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.Q.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	},
	// booton.translator.js.JSConstructor#newInstance(java.lang.Object[])
	Y:function(A,B){
		B=Object.create(this.c);
		this.d.apply(B,A);
		return B;
	}
});

boot.define("R","Q",{
	
	// booton.translator.js.JSMethod#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.Q.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	}
});

boot.define("U","",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.U.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.U.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.U.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.U.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	v:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	w:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	x:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	y:function(){
		console.log(this.a);
	}
});

boot.define("T","U",{
	
	// java.lang.Error#<init>()
	$1:function(){
		boot.U.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$2:function(A){
		boot.U.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$3:function(A,B){
		boot.U.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$0:function(A){
		boot.U.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.U.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("A","Q",{
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject, booton.translator.js.JSClass)
	$0:function(A,B,C,D){
		boot.Q.prototype.$0.call(this,A,C["$"]);
		this.c=B;
		this.d=C;
		this.e=D;
	},
	// booton.translator.js.JSClass#getConstructors()
	E:function(A,B,C,D){
		A=[];
		B=Object.keys(this.c);
		C=0;
		l4:while (C<B.length) {
			D=B[C];
			if(D.startsWith("$")==0){
			}else{
				A.push(new boot.G(D,this.c,this.c[D],this.d[D],0));
			}++C;
			continue l4;
		}return A;
	},
	// booton.translator.js.JSClass#getMethods()
	S:function(A,B,C,D){
		A=[];
		B=Object.keys(this.c);
		C=0;
		l4:while (C<B.length) {
			D=B[C];
			if(D.startsWith("$")!=0){
			}else{
				A.push(new boot.R(D,this.c,this.c[D],this.d[D],0));
			}++C;
			continue l4;
		}return A;
	},
	// booton.translator.js.JSClass#getDeclaredMethods()
	T:function(A,B,C,D){
		A=[];
		B=Object.keys(this.c);
		C=0;
		l4:while (C<B.length) {
			D=B[C];
			if(D.startsWith("$")!=0){
			}else{
				A.push(new boot.R(D,this.c,this.c[D],this.d[D],0));
			}++C;
			continue l4;
		}return A;
	},
	// booton.translator.js.JSClass#isAssignableFrom(java.lang.Class)
	U:function(A){
		l1:for (;
		A!=null;
		A=this.V()) {
			if(this!=A){
			}else{
				return true;
			}
		}return false;
	},
	// booton.translator.js.JSClass#getSuperclass()
	V:function(){
		return this.e;
	},
	// booton.translator.js.JSClass#getName()
	W:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	P:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	X:function(A){
		try{
			return this.E()[0].Y(new Array(0));
		} catch ($) {
			if ($ instanceof boot.S) {
				throw new boot.T(A,0);
			}
		}
	},
	// booton.translator.js.JSClass#getConstructor()
	Z:function(){
		return null;
	},
	// booton.translator.js.JSClass#forName(java.lang.String)
	_u:function(A){
		return null;
	}
});

boot.define("Y","",{
});

boot.define("K","",{
});

boot.define("X","",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	BD:function(){
		return this.BE()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BF:function(A,B,C,D){
		B=0;
		D=A.K();
		l2:while (D.M()!=0) {
			C=D.L();
			if(this.H(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BG:function(A,B,C,D){
		B=0;
		D=this.K();
		l2:while (D.M()!=0) {
			C=D.L();
			if(A.BH(C)!=0){
			}else{
				B=this.BI(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BJ:function(A,B,C,D){
		B=0;
		D=A.K();
		l2:while (D.M()!=0) {
			C=D.L();
			if(this.BI(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BK:function(A,B,C){
		C=A.K();
		l1:while (C.M()!=0) {
			B=C.L();
			if(this.BH(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BL:function(){
		return this.BM(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BM:function(A,B,C,D,E){
		B=this.BE();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.K();
		D=0;
		l6:while (C.M()!=0) {
			E=C.L();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("Z","",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	M:function(){
		return this.b<boot.V.BZ(this.a).length;
	},
	// js.util.ArrayList$View#next()
	L:function(){
		return boot.V.BZ(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	Bu:function(){
		if(this.b<=0){
		}else{
			boot.V.BZ(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.Z.prototype.$1.call(this,A);
	}
});

boot.define("S","U",{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.U.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.U.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.U.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.U.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.U.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("v","S",{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.S.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.S.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.S.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.S.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.S.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("u","v",{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.v.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.v.prototype.$1.call(this,A);
	}
});

boot.define("V","X",{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.X.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	BE:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BH:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	K:function(){
		return new boot.Z(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	H:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BI:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	BN:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BO:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	BP:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	BQ:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	BR:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	BS:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	BT:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	BU:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	BV:function(){
		throw new boot.T(1);
	},
	// js.util.ArrayList#listIterator(int)
	BW:function(A){
		throw new boot.T(1);
	},
	// js.util.ArrayList#subList(int, int)
	BX:function(A,B){
		throw new boot.T(1);
	},
	// js.util.ArrayList#checkRange(int)
	BY:function(A){
		if(A>=0){
			if(this.BE()>A){
				return;
			}else{
				throw new boot.u("Index is overflowed. Size: "+this.BE()+"  Index: "+A,0);
			}
		}else{
			throw new boot.u("Negative index is unacceptable. Size: "+this.BE()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_BZ:function(A){
		return A.a;
	}
});

boot.define("w","",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("I","",{
});

boot.define("F","",{
},{
	"$":[["x",{
	}],["y",{
		Bx:function() {return [CONSTRUCTOR,TYPE];}
	}],["z",{
		Bz:function() {return RUNTIME;}
	}]]
});

boot.define("H","",{
	
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo)
	$1:function(A,B){
		this.a=A;
		this.b=new RegExp(B.Bv().replace(/\*/g,"([^/].+)"),"");
	},
	// js.Application$Route#match(java.lang.String)
	Bw:function(A,B,C,D){
		B=this.b.exec(A);
		if(B!=null!=0){
			C=new boot.V(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.H(B[D+1]);
			}try{
				return this.a.Y(C.BL());
			} catch ($) {
				if ($ instanceof boot.S) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_BA:function(A,B){
		return A.Bw(B);
	},
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo, js.Application$Route)
	$0:function(A,B,C){
		boot.H.prototype.$1.call(this,A,B);
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
boot.define("J","",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("BC","",{
	
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
	CC:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	Bu:function(){
	},
	// booton.translator.web.jQuery$1#next()
	L:function(){
		return this.CC();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	CA:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	CB:function(A){
		return this.CA("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	K:function(){
		return new boot.BC(this,0);
	}
});
boot.define("E","",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.V(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.z(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	z:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.K();
		l3:while (C.M()!=0) {
			B=C.L();
			D=boot.H.BA(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.BB(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	BC:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.BB(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.z(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_G:function(A){
		return A.a;
	}
},{
	"BC":[["W",{
	}]]
});

boot.defineNative("History",{
	
	// booton.translator.web.History#<init>()
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

boot.define("BR","X",{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.X.prototype.$0.call(this);
	}
});

boot.define("BS","",{
	
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
	L:function(){
		this.d=boot.BL.Cx(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	Bu:function(){
		if(this.b<=0){
		}else{
			this.a.BI(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.BS.prototype.$1.call(this,A,B);
	}
});

boot.define("BL","BR",{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.BR.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	BE:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BH:function(A){
		return this.Cw(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	H:function(A,B){
		B=this.Cw(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BI:function(A,B){
		B=this.Cw(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BO:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	K:function(){
		return new boot.BS(this,Object.keys(this.b),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	Cw:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CS:function(A){
		return this.b[this.Cw(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CU:function(A,B,C){
		B=null;
		C=this.Cw(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	CW:function(A,B,C){
		B=null;
		C=this.Cw(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_Cx:function(A){
		return A.b;
	}
});

boot.define("BM","",{
});

boot.define("BN","",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	CZ:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CT:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	Cy:function(A,B){
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
		boot.BN.prototype.$1.call(this,A,B);
	}
});

boot.define("BK","",{
});

boot.define("BO","",{
});

boot.define("BT","",{
	
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
	L:function(A){
		A=this.b.L();
		if(this.c==0){
			return A.CT();
		}else{
			return A.CZ();
		}
	},
	// js.util.HashMap$View#remove()
	Bu:function(){
		this.b.Bu();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.BT.prototype.$1.call(this,A,B,C);
	}
});

boot.define("BP","BR",{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.BR.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	BE:function(){
		return boot.BJ.Cv(this.a).BE();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BH:function(A){
		return boot.BJ.Cv(this.a).BH(A);
	},
	// js.util.HashMap$Keys#iterator()
	K:function(){
		return new boot.BT(this.a,boot.BJ.Cv(this.a).K(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BI:function(A){
		return boot.BJ.Cv(this.a).BI(A);
	},
	// js.util.HashMap$Keys#clear()
	BO:function(){
		boot.BJ.Cv(this.a).BO();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.BP.prototype.$1.call(this,A);
	}
});

boot.define("BQ","X",{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.X.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BE:function(){
		return boot.BJ.Cv(this.a).BE();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BH:function(A){
		return this.a.CR(A);
	},
	// js.util.HashMap$Values#iterator()
	K:function(){
		return new boot.BT(this.a,boot.BJ.Cv(this.a).K(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BI:function(A,B,C){
		B=this.K();
		l2:while (B.M()!=0) {
			C=B.L();
			if(C!=A){
			}else{
				B.Bu();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BO:function(){
		boot.BJ.Cv(this.a).BO();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.BQ.prototype.$1.call(this,A);
	}
});

boot.define("BJ","",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.BL(0);
	},
	// js.util.HashMap#size()
	BE:function(){
		return this.a.BE();
	},
	// js.util.HashMap#isEmpty()
	BD:function(){
		return this.a.BD();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	CQ:function(A){
		return this.a.BH(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CR:function(A,B,C){
		C=this.CP().K();
		l1:while (C.M()!=0) {
			B=C.L();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CN:function(A,B){
		B=this.a.CS(A);
		return (B==null?null:B.CT());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CM:function(A,B,C){
		C=this.a.CU(new boot.BN(A,B,null,0));
		if(C!=null){
			return C.CT();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	CV:function(A,B){
		B=this.a.CW(A);
		if(B!=null){
			return B.CT();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	CX:function(A,B,C){
		C=A.CY().K();
		l1:for (;
		C.M()!=0;
		this.CM(B.CZ(),B.CT())) {
			B=C.L();
		}
	},
	// js.util.HashMap#clear()
	BO:function(){
		this.a.BO();
	},
	// js.util.HashMap#keySet()
	Cu:function(){
		return new boot.BP(this,null,0);
	},
	// js.util.HashMap#values()
	CP:function(){
		return new boot.BQ(this,null,0);
	},
	// js.util.HashMap#entrySet()
	CY:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_Cv:function(A){
		return A.a;
	}
});

boot.define("BE","",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.BE.b=new boot.BJ(0);
		boot.BE.c=new boot.BE("Ahri",0);
		boot.BE.d=new boot.BE("Akali",0);
		boot.BE.e=new boot.BE("Alistar",0);
		boot.BE.f=new boot.BE("Amumu",0);
		boot.BE.g=new boot.BE("Anivia",0);
		boot.BE.h=new boot.BE("Annie",0);
		boot.BE.i=new boot.BE("Ashe",0);
		boot.BE.j=new boot.BE("Blitzcrank",0);
		boot.BE.k=new boot.BE("Brand",0);
		boot.BE.l=new boot.BE("Caitlyn",0);
		boot.BE.m=new boot.BE("Cassiopeia",0);
		boot.BE.n=new boot.BE("Chogath",0);
		boot.BE.o=new boot.BE("Corki",0);
		boot.BE.p=new boot.BE("Darius",0);
		boot.BE.ba=new boot.BE("Diana",0);
		boot.BE.bb=new boot.BE("Dr.Mundo",0);
		boot.BE.bc=new boot.BE("Draven",0);
		boot.BE.bd=new boot.BE("Elise",0);
		boot.BE.be=new boot.BE("Evelynn",0);
		boot.BE.bf=new boot.BE("Ezreal",0);
		boot.BE.bg=new boot.BE("Fiddlesticks",0);
		boot.BE.bh=new boot.BE("Fiora",0);
		boot.BE.bi=new boot.BE("Fizz",0);
		boot.BE.bj=new boot.BE("Galio",0);
		boot.BE.bk=new boot.BE("Gangplank",0);
		boot.BE.bl=new boot.BE("Garen",0);
		boot.BE.bm=new boot.BE("Gragas",0);
		boot.BE.bn=new boot.BE("Graves",0);
		boot.BE.bo=new boot.BE("Hecarim",0);
		boot.BE.bp=new boot.BE("Heimerdinger",0);
		boot.BE.ca=new boot.BE("Irelia",0);
		boot.BE.cb=new boot.BE("Janna",0);
		boot.BE.cc=new boot.BE("Jarvan IV",0);
		boot.BE.cd=new boot.BE("Jax",0);
		boot.BE.ce=new boot.BE("Jayce",0);
		boot.BE.cf=new boot.BE("Karma",0);
		boot.BE.cg=new boot.BE("Karthus",0);
		boot.BE.ch=new boot.BE("Kassadin",0);
		boot.BE.ci=new boot.BE("Katarina",0);
		boot.BE.cj=new boot.BE("Kayle",0);
		boot.BE.ck=new boot.BE("Kennen",0);
		boot.BE.cl=new boot.BE("Kha'zix",0);
		boot.BE.cm=new boot.BE("Kog'maw",0);
		boot.BE.cn=new boot.BE("LeBlanc",0);
		boot.BE.co=new boot.BE("Lee Sin",0);
		boot.BE.cp=new boot.BE("Leona",0);
		boot.BE.da=new boot.BE("Lulu",0);
		boot.BE.db=new boot.BE("Lux",0);
		boot.BE.dc=new boot.BE("Malphite",0);
		boot.BE.dd=new boot.BE("Malzahar",0);
		boot.BE.de=new boot.BE("Maokai",0);
		boot.BE.df=new boot.BE("Master Yi",0);
		boot.BE.dg=new boot.BE("Miss Fortune",0);
		boot.BE.dh=new boot.BE("Mordekaiser",0);
		boot.BE.di=new boot.BE("Morgana",0);
		boot.BE.dj=new boot.BE("Nami",0);
		boot.BE.dk=new boot.BE("Nasus",0);
		boot.BE.dl=new boot.BE("Nautilus",0);
		boot.BE.dm=new boot.BE("Nidalee",0);
		boot.BE.dn=new boot.BE("Nocturne",0);
		boot.BE.dp=new boot.BE("Nunu",0);
		boot.BE.ea=new boot.BE("Olaf",0);
		boot.BE.eb=new boot.BE("Orianna",0);
		boot.BE.ec=new boot.BE("Pantheon",0);
		boot.BE.ed=new boot.BE("Poppy",0);
		boot.BE.ee=new boot.BE("Rammus",0);
		boot.BE.ef=new boot.BE("Renekton",0);
		boot.BE.eg=new boot.BE("Rengar",0);
		boot.BE.eh=new boot.BE("Riven",0);
		boot.BE.ei=new boot.BE("Rumble",0);
		boot.BE.ej=new boot.BE("Ryze",0);
		boot.BE.ek=new boot.BE("Sejuani",0);
		boot.BE.el=new boot.BE("Shaco",0);
		boot.BE.em=new boot.BE("Shen",0);
		boot.BE.en=new boot.BE("Shyvana",0);
		boot.BE.eo=new boot.BE("Singed",0);
		boot.BE.ep=new boot.BE("Sion",0);
		boot.BE.fa=new boot.BE("Sivir",0);
		boot.BE.fb=new boot.BE("Skarner",0);
		boot.BE.fc=new boot.BE("Sona",0);
		boot.BE.fd=new boot.BE("Soraka",0);
		boot.BE.fe=new boot.BE("Swain",0);
		boot.BE.ff=new boot.BE("Syndra",0);
		boot.BE.fg=new boot.BE("Talon",0);
		boot.BE.fh=new boot.BE("Taric",0);
		boot.BE.fi=new boot.BE("Teemo",0);
		boot.BE.fj=new boot.BE("Tristana",0);
		boot.BE.fk=new boot.BE("Trundle",0);
		boot.BE.fl=new boot.BE("Tryndamere",0);
		boot.BE.fm=new boot.BE("Twisted Fate",0);
		boot.BE.fn=new boot.BE("Twitch",0);
		boot.BE.fo=new boot.BE("Udyr",0);
		boot.BE.fp=new boot.BE("Urgot",0);
		boot.BE.ga=new boot.BE("Varus",0);
		boot.BE.gb=new boot.BE("Vayne",0);
		boot.BE.gc=new boot.BE("Veigar",0);
		boot.BE.gd=new boot.BE("Vi",0);
		boot.BE.ge=new boot.BE("Viktor",0);
		boot.BE.gf=new boot.BE("Vladimir",0);
		boot.BE.gg=new boot.BE("Volibear",0);
		boot.BE.gh=new boot.BE("Warwick",0);
		boot.BE.gi=new boot.BE("Wukong",0);
		boot.BE.gj=new boot.BE("Xerath",0);
		boot.BE.gk=new boot.BE("Xin Zhao",0);
		boot.BE.gl=new boot.BE("Yorick",0);
		boot.BE.gm=new boot.BE("Zed",0);
		boot.BE.gn=new boot.BE("Ziggs",0);
		boot.BE.go=new boot.BE("Zilean",0);
		boot.BE.gp=new boot.BE("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.CL().toLowerCase();
		boot.BE.b.CM(A,this);
	},
	// teemowork.model.Champion#getStatus()
	CH:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CL:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	CE:function(){
		return "src/main/resources/teemowork/splash/"+this.CL()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	CF:function(){
		return "src/main/resources/teemowork/icon/"+this.CL()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_CD:function(A){
		return boot.BE.b.CN(A);
	},
	// teemowork.model.Champion#getAll()
	_CO:function(){
		return boot.BE.b.CP();
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("BF","",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.L.CK(this.a,boot.L.CJ(this.a)+1);
	}
});

boot.define("BG","",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.L.CK(this.a,boot.L.CJ(this.a)-1);
	}
});

boot.define("BH","",{
	
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
	Cz:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	DA:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	DB:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	DC:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DD:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	DE:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DF:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DG:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	DH:function(A,B,C){
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
	DK:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DL:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DM:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	DN:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DO:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DP:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	DQ:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DR:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DS:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DT:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DU:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DV:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	DW:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	DX:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	DY:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	DZ:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	Du:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	Dv:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	Dw:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	Dx:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	Dy:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	CI:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	Dz:function(A){
		return this.g+this.h*A;
	}
});

boot.define("L","J",{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.L.prototype.$1.call(this,boot.BE.CD(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.J.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.T(1);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	BB:function(A,B,C){
		B=A.CB("a").css("background-image","url('"+this.a.CE()+"')").CB("b");
		C=B.CB("c").css("background-image","url("+this.a.CF()+")").click(new boot.BF(this,0)).on("contextmenu",new boot.BG(this,0));
		this.b=C.CB("d");
		this.c=B.CB("e").text("Health").CB("f");
		this.CG(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	CG:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.CH();
			this.c.text(""+B.CI(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	J:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_CJ:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CK:function(A,B){
		A.CG(B);
	}
},{
	"$0":[["F",{
		Bv:function() {return "Champion/*";}
	}]],"e":[["BI",{
	}]]
});

boot.define("BX","",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BX.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BY","",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BW.EE(this.a).CY().K();
		l2:while (D.M()!=0) {
			C=D.L();
			if(this.a.ED(C.CZ()).toLowerCase().indexOf(B) != -1==0){
				C.CT().addClass("j");
				continue l2;
			}else{
				C.CT().removeClass("j");
				continue l2;
			}
		}
	}
});

boot.define("BZ","",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.EG(this.b);
	}
});

boot.define("BW","BX",{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BX.prototype.$0.call(this);
		this.b=new boot.BJ(0);
		this.c=this.EB();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	EA:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BY(this,B,0));
		D=this.c.K();
		l6:for (;
		D.M()!=0;
		this.b.CM(C,E)) {
			C=D.L();
			E=this.a.CB("h").css("background-image","url("+this.EC(C)+")");
			E.CA("span").addClass("i").text(this.ED(C));
			E.click(new boot.BZ(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_EE:function(A){
		return A.b;
	}
});

boot.define("BV","BW",{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BW.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	EB:function(){
		return boot.BE.CO();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	EH:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	EI:function(A){
		return A.CF();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	EJ:function(A){
		boot.C.I(new boot.L(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	ED:function(A){
		return this.EH(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	EC:function(A){
		return this.EI(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	EG:function(A){
		this.EJ(A);
	}
});

boot.define("M","J",{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.J.prototype.$0.call(this);
		this.a=new boot.BV(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	BB:function(A){
		this.a.EA(A);
	},
	// teemowork.ChampionSelect#getPageId()
	J:function(){
		return "";
	}
},{
	"$0":[["F",{
		Bv:function() {return "";}
	}]]
});

boot.define("O","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.CA("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	N:function(A,B,C){
		C=this.b.CA("li").addClass("o");
		C.CA("a").addClass("m").attr("href",B).text(A);
		return new boot.O(this.a,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
	$0:function(A,B,C){
		boot.O.prototype.$1.call(this,A,B);
	}
});

boot.define("N","",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("k");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	N:function(A,B,C){
		C=this.a.CA("li").addClass("l");
		C.CA("a").addClass("m").attr("href",B).text(A);
		return new boot.O(this,C,null,0);
	}
});

boot.define("Bu","",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.Bu.a=new boot.BJ(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.Bu.a.CN(A);
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
		boot.Bu.a.CM(A,this);
	},
	// teemowork.model.Item#cost()
	EQ:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	EL:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	ER:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	ES:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	ET:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	EU:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	EV:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	EW:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	EX:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	EY:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	EZ:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	Eu:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	Ev:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	Ew:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	Ex:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	EO:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	Ey:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	Ez:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	FA:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	FB:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	FC:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	FD:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	FE:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	FF:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	FG:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	EM:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	FH:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	FI:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FJ:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FK:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FL:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FM:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FN:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FO:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FP:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FQ:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FR:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FS:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FT:function(A){
		return boot.Bu.a.CN(A);
	},
	// teemowork.model.Item#getAll()
	_CO:function(){
		return boot.Bu.a.CP();
	}
});

boot.define("P","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.P.b=new boot.P(1510,2012,11,13,"Initial",null,0);
		boot.P.b.EK("Ruby Crystal").EL(475).EM(180);
		boot.P.b.EK("Haunting Guise").EM(200).EO(25);
		boot.P.b.EP(boot.BE.c).DB(380,80).DE(5.5,0.6).DH(230,50.0).DK(6.25,0.6).DN(50.0,3.0).DQ(0.668,2.0).DT(10.0,3.5).DW(30.0,0).DY(550).Du(330);
		boot.P.b.EP(boot.BE.d).DB(445,85).DE(7.25,0.65).Dw(200).Dy(50).DN(53.0,3.2).DQ(0.694,3.1).DT(16.5,3.5).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.e).DB(442,102).DE(7.25,0.85).DH(215,38.0).DK(6.45,0.45).DN(55.03,3.62).DQ(0.625,3.62).DT(14.5,3.5).DW(30.0,1.25).DY(125).Du(325);
		boot.P.b.EP(boot.BE.f).DB(472,84).DE(7.45,0.85).DH(220,40.0).DK(6.5,0.525).DN(47.0,3.8).DQ(0.638,2.18).DT(18.0,3.3).DW(30.0,1.25).DY(125).Du(335);
		boot.P.b.EP(boot.BE.g).DB(350,70).DE(4.65,0.55).DH(257,53.0).DK(7.0,0.6).DN(48.0,3.2).DQ(0.625,1.68).DT(10.5,4.0).DW(30.0,0).DY(600).Du(325);
		boot.P.b.EP(boot.BE.h).DB(384,76).DE(4.5,0.55).DH(250,50.0).DK(6.9,0.6).DN(49.0,2.625).DQ(0.579,1.36).DT(12.5,4.0).DW(30.0,0).DY(625).Du(335);
		boot.P.b.EP(boot.BE.i).DB(395,79).DE(4.5,0.55).DH(173,35.0).DK(6.3,0.4).DN(46.3,2.85).DQ(0.658,3.34).DT(11.5,3.4).DW(30.0,0).DY(600).Du(325);
		boot.P.b.EP(boot.BE.j).DB(423,95).DE(7.25,0.75).DH(260,40.0).DK(6.6,0.5).DN(55.66,3.5).DQ(0.625,1.13).DT(14.5,3.5).DW(30.0,1.25).DY(125).Du(325);
		boot.P.b.EP(boot.BE.k).DB(380,76).DE(4.5,0.55).DH(250,45.0).DK(7.0,0.6).DN(51.66,3.0).DQ(0.625,1.36).DT(12.0,3.5).DW(30.0,0).DY(550).Du(340);
		boot.P.b.EP(boot.BE.l).DB(390,80).DE(4.75,0.55).DH(255,35.0).DK(6.5,0.55).DN(47.0,3.0).DQ(0.668,3.0).DT(13.0,3.5).DW(30.0,0).DY(650).Du(325);
		boot.P.b.EP(boot.BE.m).DB(380,75).DE(4.85,0.5).DH(250,50.0).DK(7.1,0.75).DN(47.0,3.2).DQ(0.644,1.68).DT(11.5,4.0).DW(30.0,0).DY(550).Du(335);
		boot.P.b.EP(boot.BE.n).DB(440,80).DE(7.5,0.85).DH(205,40.0).DK(6.45,0.45).DN(54.1,4.2).DQ(0.625,1.44).DT(19.0,3.5).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.o).DB(375,82).DE(4.5,0.55).DH(243,37.0).DK(6.5,0.55).DN(48.2,3.0).DQ(0.658,2.3).DT(13.5,3.5).DW(30.0,0).DY(550).Du(325);
		boot.P.b.EP(boot.BE.p).DB(426,93).DE(8.25,0.95).DH(200,37.5).DK(6.0,0.35).DN(50.0,3.5).DQ(0.679,2.6).DT(20.0,3.5).DW(30.0,1.25).DY(125).Du(340);
		boot.P.b.EP(boot.BE.ba).DB(438,90).DE(7.0,0.85).DH(230,40.0).DK(7.0,0.6).DN(48.0,3.0).DQ(0.625,2.25).DT(16.0,3.6).DW(30.0,1.25).DY(150).Du(345);
		boot.P.b.EP(boot.BE.bb).DB(433,89).DE(6.5,0.75).DN(56.23,3.0).DQ(0.625,2.8).DT(17.0,3.5).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.bc).DB(420,82).DE(5.0,0.7).DH(240,42.0).DK(6.95,0.65).DN(46.5,3.5).DQ(0.679,2.6).DT(16.0,3.3).DW(30.0,0).DY(550).Du(330);
		boot.P.b.EP(boot.BE.bd).DB(395,80).DE(4.7,0.6).DH(240,50.0).DK(6.8,0.65).DN(47.5,3.0).DQ(0.625,1.75).DT(12.65,3.35).DW(30.0,0).DY(550).Du(335);
		boot.P.b.EP(boot.BE.be).DB(414,86).DE(6.95,0.55).DH(180,42.0).DK(7.1,0.6).DN(48.0,3.3).DQ(0.658,3.84).DT(12.5,4.0).DW(30.0,1.25).DY(125).Du(340);
		boot.P.b.EP(boot.BE.bf).DB(350,80).DE(5.5,0.55).DH(235,45.0).DK(7.0,0.65).DN(47.2,3.0).DQ(0.665,2.8).DT(12.0,3.5).DW(30.0,0).DY(550).Du(330);
		boot.P.b.EP(boot.BE.bg).DB(390,80).DE(4.6,0.6).DH(251,59.0).DK(6.9,0.65).DN(45.95,2.625).DQ(0.625,2.11).DT(11.0,3.5).DW(30.0,0).DY(480).Du(335);
		boot.P.b.EP(boot.BE.bh).DB(450,85).DE(6.3,0.8).DH(220,40.0).DK(7.25,0.5).DN(54.5,3.2).DQ(0.672,3.0).DT(15.5,3.5).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.bi).DB(414,86).DE(7.0,0.7).DH(200,40.0).DK(6.15,0.45).DN(53.0,3.0).DQ(0.658,3.1).DT(13.0,3.4).DW(30.0,1.25).DY(175).Du(335);
		boot.P.b.EP(boot.BE.bj).DB(435,85).DE(7.45,0.75).DH(235,50.0).DK(7.0,0.7).DN(56.3,3.375).DQ(0.638,1.2).DT(17.0,3.5).DW(30.0,0).DY(125).Du(335);
		boot.P.b.EP(boot.BE.bk).DB(495,81).DE(425.0,0.75).DH(215,40.0).DK(6.5,0.7).DN(54.0,3.0).DQ(0.651,2.75).DT(16.5,3.3).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.bl).DB(455,96).DE(7.5,0.75).DN(52.5,3.5).DQ(0.625,2.9).DT(19.0,2.7).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.bm).DB(434,89).DE(7.25,0.85).DH(221,47.0).DK(6.45,0.45).DN(55.78,3.375).DQ(0.651,2.05).DT(16.0,3.6).DW(30.0,0).DY(125).Du(340);
		boot.P.b.EP(boot.BE.bn).DB(410,84).DE(5.5,0.7).DH(255,40.0).DK(6.75,0.7).DN(51.0,3.1).DQ(0.625,2.9).DT(15.0,3.2).DW(30.0,0).DY(525).Du(330);
		boot.P.b.EP(boot.BE.bo).DB(440,95).DE(8.0,0.75).DH(210,40.0).DK(6.5,0.6).DN(56.0,3.2).DQ(0.67,2.5).DT(16.0,4.0).DW(30.0,1.25).DY(175).Du(345);
		boot.P.b.EP(boot.BE.bp).DB(350,75).DE(4.5,0.55).DH(240,65.0).DK(7.0,0.65).DN(49.24,3.0).DQ(0.625,1.21).DT(7.0,3.0).DW(30.0,0).DY(550).Du(325);
		boot.P.b.EP(boot.BE.ca).DB(456,90).DE(7.5,0.65).DH(230,35.0).DK(7.0,0.65).DN(56.0,3.3).DQ(0.665,3.2).DT(15.0,3.75).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.cb).DB(356,78).DE(4.5,0.55).DH(302,64.0).DK(6.9,0.6).DN(49.0,2.95).DQ(0.625,2.61).DT(9.0,3.8).DW(30.0,0).DY(475).Du(335);
		boot.P.b.EP(boot.BE.cc).DB(420,90).DE(7.0,0.7).DH(235,40.0).DK(6.0,0.45).DN(50.0,3.4).DQ(0.658,2.5).DT(14.0,3.0).DW(30.0,1.25).DY(175).Du(340);
		boot.P.b.EP(boot.BE.cd).DB(463,98).DE(7.45,0.55).DH(230,35.0).DK(6.4,0.7).DN(56.3,3.375).DQ(0.638,3.4).DT(18.0,3.5).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.ce).DB(420,90).DE(6.0,0.8).DH(240,40.0).DK(7.0,0.7).DN(46.5,3.5).DQ(0.658,3.0).DT(12.5,3.5).DW(30.0,0).DY(125).Du(335);
		boot.P.b.EP(boot.BE.cf).DB(410,86).DE(4.7,0.55).DH(240,60.0).DK(6.8,0.65).DN(50.0,3.3).DQ(0.625,2.3).DT(15.0,3.5).DW(30.0,0).DY(425).Du(335);
		boot.P.b.EP(boot.BE.cg).DB(390,75).DE(5.5,0.55).DH(270,61.0).DK(6.5,0.6).DN(42.2,3.25).DQ(0.625,2.11).DT(11.0,3.5).DW(30.0,0).DY(450).Du(335);
		boot.P.b.EP(boot.BE.ch).DB(433,78).DE(6.95,0.5).DH(230,45.0).DK(6.9,0.6).DN(52.3,3.9).DQ(0.638,3.7).DT(14.0,3.2).DW(30.0,1.25).DY(125).Du(340);
		boot.P.b.EP(boot.BE.ci).DB(395,83).DE(6.95,0.55).DN(53.0,3.2).DQ(0.658,2.74).DT(14.75,4.0).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.cj).DB(418,93).DE(7.0,0.75).DH(255,40.0).DK(6.9,0.525).DN(53.3,2.8).DQ(0.638,2.5).DT(17.0,3.5).DW(30.0,0.75).DY(125).Du(335);
		boot.P.b.EP(boot.BE.ck).DB(403,79).DE(4.65,0.65).Dw(200).Dy(50).DN(51.3,3.3).DQ(0.69,3.4).DT(14.0,3.75).DW(30.0,0).DY(550).Du(335);
		boot.P.b.EP(boot.BE.cl).DB(430,85).DE(6.25,0.75).DH(260,40.0).DK(6.75,0.5).DN(50.0,3.1).DQ(0.665,2.7).DT(15.0,3.0).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.cm).DB(440,84).DE(5.0,0.55).DH(295,40.0).DK(7.5,0.7).DN(46.0,3.0).DQ(0.665,2.65).DT(13.0,3.53).DW(30.0,0).DY(500).Du(340);
		boot.P.b.EP(boot.BE.cn).DB(390,75).DE(4.5,0.55).DH(250,50.0).DK(6.9,0.6).DN(51.0,3.1).DQ(0.625,1.4).DT(12.0,3.5).DW(30.0,0).DY(525).Du(335);
		boot.P.b.EP(boot.BE.co).DB(428,85).DE(6.25,61.0).Dy(200).Dy(50).DN(55.8,3.2).DQ(0.651,3.0).DT(16.0,3.7).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.cp).DB(430,87).DE(9.0,0.85).DH(235,40.0).DK(8.0,0.7).DN(55.0,3.0).DQ(0.625,2.9).DT(18.0,3.1).DW(30.0,1.25).DY(125).Du(335);
		boot.P.b.EP(boot.BE.da).DB(415,82).DE(6.0,0.72).DH(200,50.0).DK(6.0,0.6).DN(44.4,2.6).DQ(0.625,2.2).DT(9.0,3.7).DW(30.0,0).DY(550).Du(325);
		boot.P.b.EP(boot.BE.db).DB(345,79).DE(4.5,0.55).DH(250,50.0).DK(6.0,0.6).DN(50.0,3.3).DQ(0.625,1.36).DT(8.0,4.0).DW(30.0,0).DY(550).Du(340);
		boot.P.b.EP(boot.BE.dc).DB(423,90).DE(7.45,0.55).DH(215,40.0).DK(6.4,0.55).DN(56.3,3.375).DQ(0.638,3.4).DT(18.0,3.75).DW(30.0,1.25).DY(125).Du(335);
		boot.P.b.EP(boot.BE.dd).DB(380,80).DE(4.5,0.55).DH(250,45.0).DK(7.0,0.6).DN(51.66,3.0).DQ(0.625,1.36).DT(15.0,3.5).DW(30.0,0).DY(550).Du(340);
		boot.P.b.EP(boot.BE.de).DB(421,90).DE(7.25,0.85).DH(250,46.0).DK(6.45,0.45).DN(58.0,3.3).DQ(0.694,2.13).DT(18.0,4.0).DW(30.0,0).DY(125).Du(335);
		boot.P.b.EP(boot.BE.df).DB(444,86).DE(6.75,0.65).DH(199,36.0).DK(6.5,0.45).DN(55.12,3.1).DQ(0.679,2.98).DT(16.3,3.7).DW(30.0,1.25).DY(125).Du(355);
		boot.P.b.EP(boot.BE.dg).DB(435,85).DE(5.1,0.65).DH(212,38.0).DK(6.95,0.65).DN(46.5,3.0).DQ(0.658,3.01).DT(15.0,3.0).DW(30.0,0).DY(550).Du(325);
		boot.P.b.EP(boot.BE.dh).DB(421,80).DE(7.45,0.55).DN(51.7,3.5).DQ(0.694,3.0).DT(15.0,3.5).DW(30.0,1.25).DY(125).Du(340);
		boot.P.b.EP(boot.BE.di).DB(403,86).DE(4.7,0.6).DH(240,60.0).DK(6.8,0.65).DN(51.58,3.5).DQ(0.579,1.53).DT(15.0,3.8).DW(30.0,0).DY(425).Du(335);
		boot.P.b.EP(boot.BE.dj).DB(365,74).DE(4.5,45.0).DH(305,43.0).DK(6.9,0.6).DN(48.0,3.1).DQ(0.644,2.6).DT(9.0,4.0).DW(30.0,0).DY(550).Du(330);
		boot.P.b.EP(boot.BE.dk).DB(410,90).DE(7.5,0.9).DH(200,45.0).DK(6.6,0.5).DN(53.3,3.5).DQ(0.638,3.48).DT(15.0,3.5).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.dl).DB(432,86).DE(7.45,0.55).DH(200,50.0).DK(7.45,0.7).DN(52.0,3.3).DQ(0.613,0.98).DT(12.0,3.25).DW(30.0,1.25).DY(175).Du(325);
		boot.P.b.EP(boot.BE.dm).DB(370,90).DE(5.0,0.6).DH(220,45.0).DK(7.0,0.5).DN(49.0,3.5).DQ(0.672,3.22).DT(11.0,3.5).DW(30.0,10.75).DY(525).Du(335);
		boot.P.b.EP(boot.BE.dn).DB(430,85).DE(7.0,0.75).DH(215,35.0).DK(6.0,0.45).DN(54.0,3.1).DQ(0.668,2.7).DT(17.0,3.5).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.dp).DB(437,108).DE(7.05,0.8).DH(213,42.0).DK(6.6,0.5).DN(51.6,3.4).DQ(0.625,2.25).DT(16.5,3.5).DW(30.0,1.25).DY(125).Du(340);
		boot.P.b.EP(boot.BE.ea).DB(441,93).DE(7.0,0.9).DH(225,45.0).DK(6.5,0.575).DN(54.1,3.5).DQ(0.694,2.7).DT(17.0,3.0).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.eb).DB(385,79).DE(5.95,0.55).DH(250,50.0).DK(7.0,0.5).DN(44.0,2.6).DQ(0.658,3.5).DT(8.0,3.0).DW(30.0,0).DY(525).Du(325);
		boot.P.b.EP(boot.BE.ec).DB(433,87).DE(6.75,0.65).DH(210,34.0).DK(6.6,0.45).DN(50.7,2.9).DQ(0.679,2.95).DT(17.1,3.9).DW(30.0,1.25).DY(155).Du(355);
		boot.P.b.EP(boot.BE.ed).DB(423,81).DE(7.45,0.55).DH(185,30.0).DK(6.4,0.45).DN(56.3,3.375).DQ(0.638,3.35).DT(18.0,4.0).DW(30.0,0).DY(125).Du(345);
		boot.P.b.EP(boot.BE.ee).DB(420,86).DE(8.0,0.55).DH(255,33.0).DK(4.5,0.3).DN(50.0,3.5).DQ(0.625,2.22).DT(21.0,3.8).DW(30.0,1.25).DY(125).Du(335);
		boot.P.b.EP(boot.BE.ef).DB(426,87).DE(6.7,0.75).DN(53.12,3.1).DQ(0.665,2.65).DT(15.2,3.8).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.eg).DB(435,85).DE(4.0,0.4).DN(55.0,3.0).DQ(0.679,2.85).DT(16.0,3.5).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.eh).DB(414,86).DE(10.4,0.9).DN(54.0,2.75).DQ(0.625,3.5).DT(15.0,3.1).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.ei).DB(450,80).DE(7.0,0.7).DN(55.32,3.2).DQ(0.644,1.85).DT(16.0,3.5).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.ej).DB(360,86).DE(4.35,0.55).DH(250,55.0).DK(7.0,0.6).DN(52.0,3.0).DQ(0.625,2.11).DT(11.0,3.9).DW(30.0,0).DY(550).Du(335);
		boot.P.b.EP(boot.BE.ek).DB(450,85).DE(7.35,0.85).DH(220,40.0).DK(6.45,0.45).DN(54.0,3.4).DQ(0.67,1.45).DT(20.5,3.5).DW(30.0,1.25).DY(125).Du(340);
		boot.P.b.EP(boot.BE.el).DB(441,84).DE(7.45,0.55).DH(270,40.0).DK(6.4,0.45).DN(51.7,3.5).DQ(0.694,3.0).DT(15.0,3.5).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.em).DB(428,85).DE(7.45,0.55).Dw(200).Dy(50).DN(54.5,3.375).DQ(0.651,3.4).DT(15.0,4.0).DW(30.0,0).DY(125).Du(335);
		boot.P.b.EP(boot.BE.en).DB(435,95).DE(7.2,0.8).DN(54.5,3.4).DQ(0.658,3.4).DT(17.6,3.4).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.eo).DB(405,82).DE(7.1,0.55).DH(215,45.0).DK(6.6,0.55).DN(56.65,3.375).DQ(0.613,1.81).DT(18.0,3.5).DW(30.0,0).DY(125).Du(345);
		boot.P.b.EP(boot.BE.ep).DB(403,104).DE(7.9,0.95).DH(240,40.0).DK(6.3,0.4).DN(55.52,3.1875).DQ(0.625,1.63).DT(17.75,3.25).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.fa).DB(378,82).DE(4.25,0.55).DH(203,43.0).DK(6.5,0.5).DN(49.0,2.9).DQ(0.658,3.28).DT(12.75,3.25).DW(30.0,0).DY(500).Du(335);
		boot.P.b.EP(boot.BE.fb).DB(440,96).DE(7.5,0.85).DH(205,40.0).DK(6.45,0.45).DN(54.1,4.2).DQ(0.625,2.1).DT(19.0,3.8).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.fc).DB(340,70).DE(4.5,0.55).DH(265,45.0).DK(7.0,0.65).DN(47.0,3.0).DQ(0.644,2.3).DT(6.0,3.3).DW(30.0,0).DY(550).Du(330);
		boot.P.b.EP(boot.BE.fd).DB(375,71).DE(4.5,0.55).DH(240,60.0).DK(6.8,0.65).DN(48.8,3.0).DQ(0.625,2.14).DT(7.4,3.8).DW(30.0,0).DY(550).Du(335);
		boot.P.b.EP(boot.BE.fe).DB(385,78).DE(6.75,0.65).DH(240,50.0).DK(6.8,0.65).DN(49.0,3.0).DQ(0.625,2.11).DT(12.0,4.0).DW(30.0,0).DY(500).Du(335);
		boot.P.b.EP(boot.BE.ff).DB(380,78).DE(5.5,0.6).DH(250,50.0).DK(6.9,0.6).DN(51.0,2.9).DQ(0.625,2.0).DT(15.0,3.4).DW(30.0,0).DY(550).Du(330);
		boot.P.b.EP(boot.BE.fg).DB(440,85).DE(7.25,0.75).DH(260,40.0).DK(6.75,0.5).DN(50.0,3.1).DQ(0.668,2.7).DT(17.0,3.5).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.fh).DB(468,90).DE(7.1,0.5).DH(255,56.0).DK(4.1,0.4).DN(58.0,3.5).DQ(0.625,2.02).DT(16.5,3.2).DW(30.0,1.25).DY(125).Du(340);
		boot.P.b.EP(boot.BE.fi).DB(383,82).DE(4.65,0.65).DH(200,40.0).DK(6.45,0.45).DN(44.5,3.0).DQ(0.69,3.38).DT(14.0,3.75).DW(30.0,0).DY(500).Du(330);
		boot.P.b.EP(boot.BE.fj).DB(415,82).DE(5.1,0.65).DH(193,32.0).DK(6.45,0.45).DN(46.5,3.0).DQ(0.658,3.01).DT(15.0,3.0).DW(30.0,0).DY(550).Du(325);
		boot.P.b.EP(boot.BE.fk).DB(455,96).DE(8.0,0.85).DH(206,45.0).DK(6.9,0.6).DN(54.66,3.0).DQ(0.672,2.9).DT(19.0,2.7).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.fl).DB(461,98).DE(7.9,0.9).DN(56.0,3.2).DQ(0.644,2.9).DT(14.9,3.1).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.fm).DB(384,82).DE(4.5,0.6).DH(202,38.0).DK(6.5,0.5).DN(46.61,3.3).DQ(0.651,3.22).DT(111.25,3.15).DW(30.0,0).DY(525).Du(330);
		boot.P.b.EP(boot.BE.fn).DB(389,81).DE(5.0,0.6).DH(220,40.0).DK(6.5,0.45).DN(49.0,3.0).DQ(0.679,3.38).DT(14.0,3.0).DW(30.0,0).DY(550).Du(330);
		boot.P.b.EP(boot.BE.fo).DB(427,99).DE(7.45,0.75).DH(220,30.0).DK(6.4,0.45).DN(52.91,3.2).DQ(0.658,2.67).DT(14.75,4.0).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.fp).DB(437,89).DE(5.5,0.6).DH(220,55.0).DK(7.5,0.65).DN(48.0,3.6).DQ(0.644,2.9).DT(15.0,3.3).DW(30.0,0).DY(425).Du(335);
		boot.P.b.EP(boot.BE.ga).DB(400,82).DE(4.5,0.55).DH(250,36.0).DK(6.5,0.5).DN(46.0,3.0).DQ(0.658,2.65).DT(13.5,3.4).DW(30.0,0).DY(575).Du(335);
		boot.P.b.EP(boot.BE.gb).DB(359,83).DE(4.5,0.55).DH(173,27.0).DK(6.3,0.4).DN(50.0,3.25).DQ(0.658,3.1).DT(9.3,3.4).DW(30.0,0).DY(550).Du(330);
		boot.P.b.EP(boot.BE.gc).DB(355,82).DE(4.5,0.55).DH(250,55.0).DK(6.9,0.6).DN(48.3,2.625).DQ(0.625,2.24).DT(12.25,3.75).DW(30.0,0).DY(525).Du(340);
		boot.P.b.EP(boot.BE.gd).DB(440,85).DE(7.5,0.9).DH(220,45.0).DK(7.0,0.65).DN(55.0,3.5).DQ(0.643,2.5).DT(16.0,3.5).DW(30.0,1.25).DY(125).Du(350);
		boot.P.b.EP(boot.BE.ge).DB(385,78).DE(6.75,0.65).DH(240,50.0).DK(6.9,0.45).DN(49.0,3.0).DQ(0.625,2.11).DT(12.0,4.0).DW(30.0,0).DY(525).Du(335);
		boot.P.b.EP(boot.BE.gf).DB(400,85).DE(6.0,0.6).DN(45.0,3.0).DQ(0.6258,2.0).DT(12.0,3.5).DW(30.0,0).DY(450).Du(335);
		boot.P.b.EP(boot.BE.gg).DB(440,86).DE(7.0,0.65).DH(220,30.0).DK(7.0,0.65).DN(54.0,3.3).DQ(0.625,2.9).DT(16.5,3.5).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.gh).DB(428,98).DE(7.05,0.8).DH(190,30.0).DK(7.1,0.6).DN(56.76,3.375).DQ(0.679,2.88).DT(16.0,3.5).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.gi).DB(435,85).DE(5.1,0.65).DH(202,38.0).DK(6.9,0.65).DN(54.0,3.2).DQ(0.658,3.0).DT(15.0,3.5).DW(30.0,1.25).DY(175).Du(345);
		boot.P.b.EP(boot.BE.gj).DB(380,80).DE(5.0,0.55).DH(250,45.0).DK(8.0,0.6).DN(52.0,3.0).DQ(0.625,1.36).DT(12.6,3.4).DW(30.0,0).DY(550).Du(340);
		boot.P.b.EP(boot.BE.gk).DB(445,87).DE(7.0,0.7).DH(213,31.0).DK(6.6,0.45).DN(52.0,3.3).DQ(0.672,2.7).DT(16.2,3.7).DW(30.0,1.25).DY(175).Du(345);
		boot.P.b.EP(boot.BE.gl).DB(421,85).DE(8.5,0.7).DH(235,35.0).DK(6.5,0.45).DN(51.5,3.5).DQ(0.625,3.0).DT(18.0,3.6).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.gm).DB(445,85).DE(6.0,0.65).Dw(20).Dy(50).DN(48.6,3.4).DQ(0.658,3.1).DT(17.5,3.5).DW(30.0,1.25).DY(125).Du(345);
		boot.P.b.EP(boot.BE.gn).DB(390,80).DE(5.25,0.6).DH(250,50.0).DK(6.75,0.6).DN(54.0,3.1).DQ(0.656,1.7).DT(12.0,3.3).DW(30.0,0).DY(575).Du(330);
		boot.P.b.EP(boot.BE.go).DB(380,71).DE(4.6,0.5).DH(260,60.0).DK(6.95,0.65).DN(48.6,3.0).DQ(0.625,2.13).DT(6.75,3.8).DW(30.0,0).DY(600).Du(335);
		boot.P.b.EP(boot.BE.gp).DB(355,74).DE(4.85,0.5).DH(250,50.0).DK(7.1,0.75).DN(50.0,3.2).DQ(0.625,1.8).DT(11.0,3.0).DW(30.0,0).DY(575).Du(325);
		boot.P.c=new boot.P(1520,2012,12,3,"Preseason 3",boot.P.b,0);
		boot.P.c.EK("Shard of True Ice");
		boot.P.c.EK("Liandry's Torment");
		boot.P.c.EK("Haunting Guise");
		boot.P.a=boot.P.c;
	},
	// teemowork.model.Patch#<init>(int, int, int, int, java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C,D,E,F){
		this.d=new boot.BJ(0);
		this.e=new boot.BJ(0);
		this.f=A;
		this.g=E;
		this.h=F;
	},
	// teemowork.model.Patch#updateItem(java.lang.String)
	EK:function(A,B){
		B=new boot.Bu(A,this,0);
		this.e.CM(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	EP:function(A){
		A.hb=new boot.BH(this,A.hb,0);
		return A.hb;
	}
});

boot.define("B","C",{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B,C,D,E){
		A=[1,2,3];
		E=A;D=E.length;C=0;
		l2:for (;
		C<D;
		++C) {
			B=E[C];
			console.log(B);
		}C=boot.find(boot.J.$).K();
		l7:for (;
		C.M()!=0;
		console.log(B)) {
			B=C.L();
		}this.D(boot.L.$);
		this.D(boot.M.$);
		boot.C.prototype.A.call(this);
		$("body").css("padding","0px 10%");
		B=new boot.N(0);
		B.N("< ^ v ^ > Teemowork","test.html");
		B.N("Patch","#");
		C=B.N("Data","#");
		C.N("Champion","#");
		C.N("Item","#");
		C.N("Mastery","#");
		C.N("Rune","#");
		B.N("Builder","#");
		B.N("About","#");
		B.N("Contact","#");
		console.log(boot.P.a);
	}
});

try {new boot.B(0).A();} catch(e) {console.log(e)}