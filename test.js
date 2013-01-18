boot.define("R","",{
	
	// booton.translator.js.JSAnnotatedElement#<init>(java.lang.String, booton.translator.js.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// booton.translator.js.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	T:function(A){
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
				if(C[0].equals(A.U())==0){
				}else{
					return C[1];
				}
			}
		}return null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotations()
	V:function(){
		return null;
	},
	// booton.translator.js.JSAnnotatedElement#getDeclaredAnnotations()
	W:function(){
		return this.V();
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
	v:function(A,B){
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
	y:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	z:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	BA:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	BB:function(){
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
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject)
	$0:function(A,B,C){
		boot.R.prototype.$0.call(this,A,C["$"]);
		this.c=B;
		this.d=C;
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
	X:function(A,B,C,D){
		A=[];
		B=Object.keys(this.c);
		C=0;
		l4:while (C<B.length) {
			D=B[C];
			if(D.startsWith("$")!=0){
			}else{
				A.push(new boot.S(D,this.c,this.c[D],this.d[D],0));
			}++C;
			continue l4;
		}return A;
	},
	// booton.translator.js.JSClass#getDeclaredMethods()
	Y:function(A,B,C,D){
		A=[];
		B=Object.keys(this.c);
		C=0;
		l4:while (C<B.length) {
			D=B[C];
			if(D.startsWith("$")!=0){
			}else{
				A.push(new boot.S(D,this.c,this.c[D],this.d[D],0));
			}++C;
			continue l4;
		}B=Object.keys(this.c["$"]);
		C=0;
		l12:for (;
		C<B.length;
		++C) {
			D=B[C];
			A.push(new boot.S(D,this.c,this.c[D],this.d[D],0));
		}return A;
	},
	// booton.translator.js.JSClass#getName()
	Z:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	U:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	u:function(A){
		try{
			return this.E()[0].v(new Array(0));
		} catch ($) {
			if ($ instanceof boot.T) {
				throw new boot.U(A,0);
			}
		}
	},
	// booton.translator.js.JSClass#getConstructor()
	w:function(){
		return null;
	},
	// booton.translator.js.JSClass#forName(java.lang.String)
	_x:function(A){
		return null;
	}
});

boot.define("Z","",{
});

boot.define("X","",{
});

boot.define("Y","",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	BJ:function(){
		return this.BK()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BL:function(A,B,C,D){
		B=0;
		D=A.BD();
		l2:while (D.BH()!=0) {
			C=D.BE();
			if(this.H(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BM:function(A,B,C,D){
		B=0;
		D=this.BD();
		l2:while (D.BH()!=0) {
			C=D.BE();
			if(A.BN(C)!=0){
			}else{
				B=this.BO(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BP:function(A,B,C,D){
		B=0;
		D=A.BD();
		l2:while (D.BH()!=0) {
			C=D.BE();
			if(this.BO(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BQ:function(A,B,C){
		C=A.BD();
		l1:while (C.BH()!=0) {
			B=C.BE();
			if(this.BN(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BR:function(){
		return this.BS(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BS:function(A,B,C,D,E){
		B=this.BK();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.BD();
		D=0;
		l6:while (C.BH()!=0) {
			E=C.BE();
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
	BH:function(){
		return this.b<boot.W.CA(this.a).length;
	},
	// js.util.ArrayList$View#next()
	BE:function(){
		return boot.W.CA(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	CB:function(){
		if(this.b<=0){
		}else{
			boot.W.CA(this.a).splice(this.b-1,1)[0];
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
	BK:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BN:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	BD:function(){
		return new boot.u(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	H:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BO:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	BT:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BU:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	BV:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	BW:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	BX:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	BY:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	BZ:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	Bu:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	Bv:function(){
		throw new boot.U(1);
	},
	// js.util.ArrayList#listIterator(int)
	Bw:function(A){
		throw new boot.U(1);
	},
	// js.util.ArrayList#subList(int, int)
	Bx:function(A,B){
		throw new boot.U(1);
	},
	// js.util.ArrayList#checkRange(int)
	Bz:function(A){
		if(A>=0){
			if(this.BK()>A){
				return;
			}else{
				throw new boot.v("Index is overflowed. Size: "+this.BK()+"  Index: "+A,0);
			}
		}else{
			throw new boot.v("Negative index is unacceptable. Size: "+this.BK()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_CA:function(A){
		return A.a;
	}
});

boot.define("x","",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("I","",{
});

boot.define("F","",{
},{
	"$":[["y",{
	}],["z",{
		CE:function() {return [CONSTRUCTOR,TYPE];}
	}],["BA",{
		CF:function() {return RUNTIME;}
	}]]
});

boot.define("H","",{
	
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo)
	$1:function(A,B){
		this.a=A;
		this.b=new RegExp(B.CC().replace(/\*/g,"([^/].+)"),"");
	},
	// js.Application$Route#match(java.lang.String)
	CD:function(A,B,C,D){
		B=this.b.exec(A);
		if(B!=null!=0){
			C=new boot.W(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.H(B[D+1]);
			}try{
				return this.a.v(C.BR());
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
	_BF:function(A,B){
		return A.CD(B);
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

boot.define("BD","",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	BH:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	CI:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	CB:function(){
	},
	// booton.translator.web.jQuery$1#next()
	BE:function(){
		return this.CI();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	CG:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	CH:function(A){
		return this.CG("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	BD:function(){
		return new boot.BD(this,0);
	}
});
boot.define("E","",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.W(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.BC(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	BC:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.BD();
		l3:while (C.BH()!=0) {
			B=C.BE();
			D=boot.H.BF(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.BG(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	BI:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.BG(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.BC(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_G:function(A){
		return A.a;
	}
},{
	"BI":[["Q",{
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

boot.define("BS","Y",{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
	}
});

boot.define("BT","",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	BH:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	BE:function(){
		this.d=boot.BM.DD(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	CB:function(){
		if(this.b<=0){
		}else{
			this.a.BO(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
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
	BK:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BN:function(A){
		return this.DC(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	H:function(A,B){
		B=this.DC(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BO:function(A,B){
		B=this.DC(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BU:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	BD:function(){
		return new boot.BT(this,Object.keys(this.b),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	DC:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CY:function(A){
		return this.b[this.DC(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	Cu:function(A,B,C){
		B=null;
		C=this.DC(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	Cw:function(A,B,C){
		B=null;
		C=this.DC(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_DD:function(A){
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
	Cz:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CZ:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	DE:function(A,B){
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
	BH:function(){
		return this.b.BH();
	},
	// js.util.HashMap$View#next()
	BE:function(A){
		A=this.b.BE();
		if(this.c==0){
			return A.CZ();
		}else{
			return A.Cz();
		}
	},
	// js.util.HashMap$View#remove()
	CB:function(){
		this.b.CB();
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
	BK:function(){
		return boot.BK.DB(this.a).BK();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BN:function(A){
		return boot.BK.DB(this.a).BN(A);
	},
	// js.util.HashMap$Keys#iterator()
	BD:function(){
		return new boot.BU(this.a,boot.BK.DB(this.a).BD(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BO:function(A){
		return boot.BK.DB(this.a).BO(A);
	},
	// js.util.HashMap$Keys#clear()
	BU:function(){
		boot.BK.DB(this.a).BU();
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
	BK:function(){
		return boot.BK.DB(this.a).BK();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BN:function(A){
		return this.a.CX(A);
	},
	// js.util.HashMap$Values#iterator()
	BD:function(){
		return new boot.BU(this.a,boot.BK.DB(this.a).BD(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BO:function(A,B,C){
		B=this.BD();
		l2:while (B.BH()!=0) {
			C=B.BE();
			if(C!=A){
			}else{
				B.CB();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BU:function(){
		boot.BK.DB(this.a).BU();
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
	BK:function(){
		return this.a.BK();
	},
	// js.util.HashMap#isEmpty()
	BJ:function(){
		return this.a.BJ();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	CW:function(A){
		return this.a.BN(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CX:function(A,B,C){
		C=this.CV().BD();
		l1:while (C.BH()!=0) {
			B=C.BE();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CT:function(A,B){
		B=this.a.CY(A);
		return (B==null?null:B.CZ());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CS:function(A,B,C){
		C=this.a.Cu(new boot.BO(A,B,null,0));
		if(C!=null){
			return C.CZ();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	Cv:function(A,B){
		B=this.a.Cw(A);
		if(B!=null){
			return B.CZ();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	Cx:function(A,B,C){
		C=A.Cy().BD();
		l1:for (;
		C.BH()!=0;
		this.CS(B.Cz(),B.CZ())) {
			B=C.BE();
		}
	},
	// js.util.HashMap#clear()
	BU:function(){
		this.a.BU();
	},
	// js.util.HashMap#keySet()
	DA:function(){
		return new boot.BQ(this,null,0);
	},
	// js.util.HashMap#values()
	CV:function(){
		return new boot.BR(this,null,0);
	},
	// js.util.HashMap#entrySet()
	Cy:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_DB:function(A){
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
		this.ha=this.CR().toLowerCase();
		boot.BF.b.CS(A,this);
	},
	// teemowork.model.Champion#getStatus()
	CN:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CR:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	CK:function(){
		return "src/main/resources/teemowork/splash/"+this.CR()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	CL:function(){
		return "src/main/resources/teemowork/icon/"+this.CR()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_CJ:function(A){
		return boot.BF.b.CT(A);
	},
	// teemowork.model.Champion#getAll()
	_CU:function(){
		return boot.BF.b.CV();
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("BG","",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.K.CQ(this.a,boot.K.CP(this.a)+1);
	}
});

boot.define("BH","",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.K.CQ(this.a,boot.K.CP(this.a)-1);
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
	DF:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	DG:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	DH:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	DI:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DJ:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	DK:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DL:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DM:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	DN:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DO:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DP:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	DQ:function(A,B,C,D){
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
	DT:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DU:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DV:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	DW:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DX:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DY:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DZ:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	Du:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	Dv:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	Dw:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	Dx:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	Dy:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	Dz:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	EA:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	EB:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	EC:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	ED:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	EE:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	CO:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	EG:function(A){
		return this.g+this.h*A;
	}
});

boot.define("K","J",{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.K.prototype.$1.call(this,boot.BF.CJ(A));
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
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	BG:function(A,B,C){
		B=A.CH("a").css("background-image","url('"+this.a.CK()+"')").CH("b");
		C=B.CH("c").css("background-image","url("+this.a.CL()+")").click(new boot.BG(this,0)).on("contextmenu",new boot.BH(this,0));
		this.b=C.CH("d");
		this.c=B.CH("e").text("Health").CH("f");
		this.CM(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	CM:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.CN();
			this.c.text(""+B.CO(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	J:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_CP:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CQ:function(A,B){
		A.CM(B);
	}
},{
	"$0":[["F",{
		CC:function() {return "Champion/*";}
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
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BX.EL(this.a).Cy().BD();
		l2:while (D.BH()!=0) {
			C=D.BE();
			if(this.a.EK(C.Cz()).toLowerCase().indexOf(B) != -1==0){
				C.CZ().addClass("j");
				continue l2;
			}else{
				C.CZ().removeClass("j");
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
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.EM(this.b);
	}
});

boot.define("BX","BY",{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BY.prototype.$0.call(this);
		this.b=new boot.BK(0);
		this.c=this.EI();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	EH:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BZ(this,B,0));
		D=this.c.BD();
		l6:for (;
		D.BH()!=0;
		this.b.CS(C,E)) {
			C=D.BE();
			E=this.a.CH("h").css("background-image","url("+this.EJ(C)+")");
			E.CG("span").addClass("i").text(this.EK(C));
			E.click(new boot.Bu(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_EL:function(A){
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
	EI:function(){
		return boot.BF.CU();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	EO:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	EP:function(A){
		return A.CL();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	EQ:function(A){
		boot.C.I(new boot.K(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	EK:function(A){
		return this.EO(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	EJ:function(A){
		return this.EP(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	EM:function(A){
		this.EQ(A);
	}
});

boot.define("L","J",{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.J.prototype.$0.call(this);
		this.a=new boot.BW(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	BG:function(A){
		this.a.EH(A);
	},
	// teemowork.ChampionSelect#getPageId()
	J:function(){
		return "";
	}
},{
	"$0":[["F",{
		CC:function() {return "";}
	}]]
});

boot.define("N","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.CG("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	K:function(A,B,C){
		C=this.b.CG("li").addClass("o");
		C.CG("a").addClass("m").attr("href",B).text(A);
		return new boot.N(this.a,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
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
	K:function(A,B,C){
		C=this.a.CG("li").addClass("l");
		C.CG("a").addClass("m").attr("href",B).text(A);
		return new boot.N(this,C,null,0);
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
		C=boot.Bv.a.CT(A);
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
		boot.Bv.a.CS(A,this);
	},
	// teemowork.model.Item#cost()
	EW:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	ES:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	EX:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	EY:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	EZ:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	Eu:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	Ev:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	Ew:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	Ex:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	Ey:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	Ez:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	FA:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	FB:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	FC:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	FD:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	EU:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	FE:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	FF:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	FG:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	FH:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	FI:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	FJ:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	FK:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	FL:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	FM:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	ET:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	FN:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	FO:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FP:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FQ:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FR:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FS:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FT:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FU:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FV:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FW:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FX:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FY:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FZ:function(A){
		return boot.Bv.a.CT(A);
	},
	// teemowork.model.Item#getAll()
	_CU:function(){
		return boot.Bv.a.CV();
	}
});

boot.define("O","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.O.b=new boot.O(1510,2012,11,13,"Initial",null,0);
		boot.O.b.ER("Ruby Crystal").ES(475).ET(180);
		boot.O.b.ER("Haunting Guise").ET(200).EU(25);
		boot.O.b.EV(boot.BF.c).DH(380,80).DK(5.5,0.6).DN(230,50.0).DQ(6.25,0.6).DT(50.0,3.0).DW(0.668,2.0).DZ(10.0,3.5).Dw(30.0,0).Dy(550).EA(330);
		boot.O.b.EV(boot.BF.d).DH(445,85).DK(7.25,0.65).EC(200).EE(50).DT(53.0,3.2).DW(0.694,3.1).DZ(16.5,3.5).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.e).DH(442,102).DK(7.25,0.85).DN(215,38.0).DQ(6.45,0.45).DT(55.03,3.62).DW(0.625,3.62).DZ(14.5,3.5).Dw(30.0,1.25).Dy(125).EA(325);
		boot.O.b.EV(boot.BF.f).DH(472,84).DK(7.45,0.85).DN(220,40.0).DQ(6.5,0.525).DT(47.0,3.8).DW(0.638,2.18).DZ(18.0,3.3).Dw(30.0,1.25).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.g).DH(350,70).DK(4.65,0.55).DN(257,53.0).DQ(7.0,0.6).DT(48.0,3.2).DW(0.625,1.68).DZ(10.5,4.0).Dw(30.0,0).Dy(600).EA(325);
		boot.O.b.EV(boot.BF.h).DH(384,76).DK(4.5,0.55).DN(250,50.0).DQ(6.9,0.6).DT(49.0,2.625).DW(0.579,1.36).DZ(12.5,4.0).Dw(30.0,0).Dy(625).EA(335);
		boot.O.b.EV(boot.BF.i).DH(395,79).DK(4.5,0.55).DN(173,35.0).DQ(6.3,0.4).DT(46.3,2.85).DW(0.658,3.34).DZ(11.5,3.4).Dw(30.0,0).Dy(600).EA(325);
		boot.O.b.EV(boot.BF.j).DH(423,95).DK(7.25,0.75).DN(260,40.0).DQ(6.6,0.5).DT(55.66,3.5).DW(0.625,1.13).DZ(14.5,3.5).Dw(30.0,1.25).Dy(125).EA(325);
		boot.O.b.EV(boot.BF.k).DH(380,76).DK(4.5,0.55).DN(250,45.0).DQ(7.0,0.6).DT(51.66,3.0).DW(0.625,1.36).DZ(12.0,3.5).Dw(30.0,0).Dy(550).EA(340);
		boot.O.b.EV(boot.BF.l).DH(390,80).DK(4.75,0.55).DN(255,35.0).DQ(6.5,0.55).DT(47.0,3.0).DW(0.668,3.0).DZ(13.0,3.5).Dw(30.0,0).Dy(650).EA(325);
		boot.O.b.EV(boot.BF.m).DH(380,75).DK(4.85,0.5).DN(250,50.0).DQ(7.1,0.75).DT(47.0,3.2).DW(0.644,1.68).DZ(11.5,4.0).Dw(30.0,0).Dy(550).EA(335);
		boot.O.b.EV(boot.BF.n).DH(440,80).DK(7.5,0.85).DN(205,40.0).DQ(6.45,0.45).DT(54.1,4.2).DW(0.625,1.44).DZ(19.0,3.5).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.o).DH(375,82).DK(4.5,0.55).DN(243,37.0).DQ(6.5,0.55).DT(48.2,3.0).DW(0.658,2.3).DZ(13.5,3.5).Dw(30.0,0).Dy(550).EA(325);
		boot.O.b.EV(boot.BF.p).DH(426,93).DK(8.25,0.95).DN(200,37.5).DQ(6.0,0.35).DT(50.0,3.5).DW(0.679,2.6).DZ(20.0,3.5).Dw(30.0,1.25).Dy(125).EA(340);
		boot.O.b.EV(boot.BF.ba).DH(438,90).DK(7.0,0.85).DN(230,40.0).DQ(7.0,0.6).DT(48.0,3.0).DW(0.625,2.25).DZ(16.0,3.6).Dw(30.0,1.25).Dy(150).EA(345);
		boot.O.b.EV(boot.BF.bb).DH(433,89).DK(6.5,0.75).DT(56.23,3.0).DW(0.625,2.8).DZ(17.0,3.5).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.bc).DH(420,82).DK(5.0,0.7).DN(240,42.0).DQ(6.95,0.65).DT(46.5,3.5).DW(0.679,2.6).DZ(16.0,3.3).Dw(30.0,0).Dy(550).EA(330);
		boot.O.b.EV(boot.BF.bd).DH(395,80).DK(4.7,0.6).DN(240,50.0).DQ(6.8,0.65).DT(47.5,3.0).DW(0.625,1.75).DZ(12.65,3.35).Dw(30.0,0).Dy(550).EA(335);
		boot.O.b.EV(boot.BF.be).DH(414,86).DK(6.95,0.55).DN(180,42.0).DQ(7.1,0.6).DT(48.0,3.3).DW(0.658,3.84).DZ(12.5,4.0).Dw(30.0,1.25).Dy(125).EA(340);
		boot.O.b.EV(boot.BF.bf).DH(350,80).DK(5.5,0.55).DN(235,45.0).DQ(7.0,0.65).DT(47.2,3.0).DW(0.665,2.8).DZ(12.0,3.5).Dw(30.0,0).Dy(550).EA(330);
		boot.O.b.EV(boot.BF.bg).DH(390,80).DK(4.6,0.6).DN(251,59.0).DQ(6.9,0.65).DT(45.95,2.625).DW(0.625,2.11).DZ(11.0,3.5).Dw(30.0,0).Dy(480).EA(335);
		boot.O.b.EV(boot.BF.bh).DH(450,85).DK(6.3,0.8).DN(220,40.0).DQ(7.25,0.5).DT(54.5,3.2).DW(0.672,3.0).DZ(15.5,3.5).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.bi).DH(414,86).DK(7.0,0.7).DN(200,40.0).DQ(6.15,0.45).DT(53.0,3.0).DW(0.658,3.1).DZ(13.0,3.4).Dw(30.0,1.25).Dy(175).EA(335);
		boot.O.b.EV(boot.BF.bj).DH(435,85).DK(7.45,0.75).DN(235,50.0).DQ(7.0,0.7).DT(56.3,3.375).DW(0.638,1.2).DZ(17.0,3.5).Dw(30.0,0).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.bk).DH(495,81).DK(425.0,0.75).DN(215,40.0).DQ(6.5,0.7).DT(54.0,3.0).DW(0.651,2.75).DZ(16.5,3.3).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.bl).DH(455,96).DK(7.5,0.75).DT(52.5,3.5).DW(0.625,2.9).DZ(19.0,2.7).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.bm).DH(434,89).DK(7.25,0.85).DN(221,47.0).DQ(6.45,0.45).DT(55.78,3.375).DW(0.651,2.05).DZ(16.0,3.6).Dw(30.0,0).Dy(125).EA(340);
		boot.O.b.EV(boot.BF.bn).DH(410,84).DK(5.5,0.7).DN(255,40.0).DQ(6.75,0.7).DT(51.0,3.1).DW(0.625,2.9).DZ(15.0,3.2).Dw(30.0,0).Dy(525).EA(330);
		boot.O.b.EV(boot.BF.bo).DH(440,95).DK(8.0,0.75).DN(210,40.0).DQ(6.5,0.6).DT(56.0,3.2).DW(0.67,2.5).DZ(16.0,4.0).Dw(30.0,1.25).Dy(175).EA(345);
		boot.O.b.EV(boot.BF.bp).DH(350,75).DK(4.5,0.55).DN(240,65.0).DQ(7.0,0.65).DT(49.24,3.0).DW(0.625,1.21).DZ(7.0,3.0).Dw(30.0,0).Dy(550).EA(325);
		boot.O.b.EV(boot.BF.ca).DH(456,90).DK(7.5,0.65).DN(230,35.0).DQ(7.0,0.65).DT(56.0,3.3).DW(0.665,3.2).DZ(15.0,3.75).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.cb).DH(356,78).DK(4.5,0.55).DN(302,64.0).DQ(6.9,0.6).DT(49.0,2.95).DW(0.625,2.61).DZ(9.0,3.8).Dw(30.0,0).Dy(475).EA(335);
		boot.O.b.EV(boot.BF.cc).DH(420,90).DK(7.0,0.7).DN(235,40.0).DQ(6.0,0.45).DT(50.0,3.4).DW(0.658,2.5).DZ(14.0,3.0).Dw(30.0,1.25).Dy(175).EA(340);
		boot.O.b.EV(boot.BF.cd).DH(463,98).DK(7.45,0.55).DN(230,35.0).DQ(6.4,0.7).DT(56.3,3.375).DW(0.638,3.4).DZ(18.0,3.5).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.ce).DH(420,90).DK(6.0,0.8).DN(240,40.0).DQ(7.0,0.7).DT(46.5,3.5).DW(0.658,3.0).DZ(12.5,3.5).Dw(30.0,0).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.cf).DH(410,86).DK(4.7,0.55).DN(240,60.0).DQ(6.8,0.65).DT(50.0,3.3).DW(0.625,2.3).DZ(15.0,3.5).Dw(30.0,0).Dy(425).EA(335);
		boot.O.b.EV(boot.BF.cg).DH(390,75).DK(5.5,0.55).DN(270,61.0).DQ(6.5,0.6).DT(42.2,3.25).DW(0.625,2.11).DZ(11.0,3.5).Dw(30.0,0).Dy(450).EA(335);
		boot.O.b.EV(boot.BF.ch).DH(433,78).DK(6.95,0.5).DN(230,45.0).DQ(6.9,0.6).DT(52.3,3.9).DW(0.638,3.7).DZ(14.0,3.2).Dw(30.0,1.25).Dy(125).EA(340);
		boot.O.b.EV(boot.BF.ci).DH(395,83).DK(6.95,0.55).DT(53.0,3.2).DW(0.658,2.74).DZ(14.75,4.0).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.cj).DH(418,93).DK(7.0,0.75).DN(255,40.0).DQ(6.9,0.525).DT(53.3,2.8).DW(0.638,2.5).DZ(17.0,3.5).Dw(30.0,0.75).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.ck).DH(403,79).DK(4.65,0.65).EC(200).EE(50).DT(51.3,3.3).DW(0.69,3.4).DZ(14.0,3.75).Dw(30.0,0).Dy(550).EA(335);
		boot.O.b.EV(boot.BF.cl).DH(430,85).DK(6.25,0.75).DN(260,40.0).DQ(6.75,0.5).DT(50.0,3.1).DW(0.665,2.7).DZ(15.0,3.0).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.cm).DH(440,84).DK(5.0,0.55).DN(295,40.0).DQ(7.5,0.7).DT(46.0,3.0).DW(0.665,2.65).DZ(13.0,3.53).Dw(30.0,0).Dy(500).EA(340);
		boot.O.b.EV(boot.BF.cn).DH(390,75).DK(4.5,0.55).DN(250,50.0).DQ(6.9,0.6).DT(51.0,3.1).DW(0.625,1.4).DZ(12.0,3.5).Dw(30.0,0).Dy(525).EA(335);
		boot.O.b.EV(boot.BF.co).DH(428,85).DK(6.25,61.0).EE(200).EE(50).DT(55.8,3.2).DW(0.651,3.0).DZ(16.0,3.7).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.cp).DH(430,87).DK(9.0,0.85).DN(235,40.0).DQ(8.0,0.7).DT(55.0,3.0).DW(0.625,2.9).DZ(18.0,3.1).Dw(30.0,1.25).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.da).DH(415,82).DK(6.0,0.72).DN(200,50.0).DQ(6.0,0.6).DT(44.4,2.6).DW(0.625,2.2).DZ(9.0,3.7).Dw(30.0,0).Dy(550).EA(325);
		boot.O.b.EV(boot.BF.db).DH(345,79).DK(4.5,0.55).DN(250,50.0).DQ(6.0,0.6).DT(50.0,3.3).DW(0.625,1.36).DZ(8.0,4.0).Dw(30.0,0).Dy(550).EA(340);
		boot.O.b.EV(boot.BF.dc).DH(423,90).DK(7.45,0.55).DN(215,40.0).DQ(6.4,0.55).DT(56.3,3.375).DW(0.638,3.4).DZ(18.0,3.75).Dw(30.0,1.25).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.dd).DH(380,80).DK(4.5,0.55).DN(250,45.0).DQ(7.0,0.6).DT(51.66,3.0).DW(0.625,1.36).DZ(15.0,3.5).Dw(30.0,0).Dy(550).EA(340);
		boot.O.b.EV(boot.BF.de).DH(421,90).DK(7.25,0.85).DN(250,46.0).DQ(6.45,0.45).DT(58.0,3.3).DW(0.694,2.13).DZ(18.0,4.0).Dw(30.0,0).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.df).DH(444,86).DK(6.75,0.65).DN(199,36.0).DQ(6.5,0.45).DT(55.12,3.1).DW(0.679,2.98).DZ(16.3,3.7).Dw(30.0,1.25).Dy(125).EA(355);
		boot.O.b.EV(boot.BF.dg).DH(435,85).DK(5.1,0.65).DN(212,38.0).DQ(6.95,0.65).DT(46.5,3.0).DW(0.658,3.01).DZ(15.0,3.0).Dw(30.0,0).Dy(550).EA(325);
		boot.O.b.EV(boot.BF.dh).DH(421,80).DK(7.45,0.55).DT(51.7,3.5).DW(0.694,3.0).DZ(15.0,3.5).Dw(30.0,1.25).Dy(125).EA(340);
		boot.O.b.EV(boot.BF.di).DH(403,86).DK(4.7,0.6).DN(240,60.0).DQ(6.8,0.65).DT(51.58,3.5).DW(0.579,1.53).DZ(15.0,3.8).Dw(30.0,0).Dy(425).EA(335);
		boot.O.b.EV(boot.BF.dj).DH(365,74).DK(4.5,45.0).DN(305,43.0).DQ(6.9,0.6).DT(48.0,3.1).DW(0.644,2.6).DZ(9.0,4.0).Dw(30.0,0).Dy(550).EA(330);
		boot.O.b.EV(boot.BF.dk).DH(410,90).DK(7.5,0.9).DN(200,45.0).DQ(6.6,0.5).DT(53.3,3.5).DW(0.638,3.48).DZ(15.0,3.5).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.dl).DH(432,86).DK(7.45,0.55).DN(200,50.0).DQ(7.45,0.7).DT(52.0,3.3).DW(0.613,0.98).DZ(12.0,3.25).Dw(30.0,1.25).Dy(175).EA(325);
		boot.O.b.EV(boot.BF.dm).DH(370,90).DK(5.0,0.6).DN(220,45.0).DQ(7.0,0.5).DT(49.0,3.5).DW(0.672,3.22).DZ(11.0,3.5).Dw(30.0,10.75).Dy(525).EA(335);
		boot.O.b.EV(boot.BF.dn).DH(430,85).DK(7.0,0.75).DN(215,35.0).DQ(6.0,0.45).DT(54.0,3.1).DW(0.668,2.7).DZ(17.0,3.5).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.dp).DH(437,108).DK(7.05,0.8).DN(213,42.0).DQ(6.6,0.5).DT(51.6,3.4).DW(0.625,2.25).DZ(16.5,3.5).Dw(30.0,1.25).Dy(125).EA(340);
		boot.O.b.EV(boot.BF.ea).DH(441,93).DK(7.0,0.9).DN(225,45.0).DQ(6.5,0.575).DT(54.1,3.5).DW(0.694,2.7).DZ(17.0,3.0).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.eb).DH(385,79).DK(5.95,0.55).DN(250,50.0).DQ(7.0,0.5).DT(44.0,2.6).DW(0.658,3.5).DZ(8.0,3.0).Dw(30.0,0).Dy(525).EA(325);
		boot.O.b.EV(boot.BF.ec).DH(433,87).DK(6.75,0.65).DN(210,34.0).DQ(6.6,0.45).DT(50.7,2.9).DW(0.679,2.95).DZ(17.1,3.9).Dw(30.0,1.25).Dy(155).EA(355);
		boot.O.b.EV(boot.BF.ed).DH(423,81).DK(7.45,0.55).DN(185,30.0).DQ(6.4,0.45).DT(56.3,3.375).DW(0.638,3.35).DZ(18.0,4.0).Dw(30.0,0).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.ee).DH(420,86).DK(8.0,0.55).DN(255,33.0).DQ(4.5,0.3).DT(50.0,3.5).DW(0.625,2.22).DZ(21.0,3.8).Dw(30.0,1.25).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.ef).DH(426,87).DK(6.7,0.75).DT(53.12,3.1).DW(0.665,2.65).DZ(15.2,3.8).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.eg).DH(435,85).DK(4.0,0.4).DT(55.0,3.0).DW(0.679,2.85).DZ(16.0,3.5).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.eh).DH(414,86).DK(10.4,0.9).DT(54.0,2.75).DW(0.625,3.5).DZ(15.0,3.1).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.ei).DH(450,80).DK(7.0,0.7).DT(55.32,3.2).DW(0.644,1.85).DZ(16.0,3.5).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.ej).DH(360,86).DK(4.35,0.55).DN(250,55.0).DQ(7.0,0.6).DT(52.0,3.0).DW(0.625,2.11).DZ(11.0,3.9).Dw(30.0,0).Dy(550).EA(335);
		boot.O.b.EV(boot.BF.ek).DH(450,85).DK(7.35,0.85).DN(220,40.0).DQ(6.45,0.45).DT(54.0,3.4).DW(0.67,1.45).DZ(20.5,3.5).Dw(30.0,1.25).Dy(125).EA(340);
		boot.O.b.EV(boot.BF.el).DH(441,84).DK(7.45,0.55).DN(270,40.0).DQ(6.4,0.45).DT(51.7,3.5).DW(0.694,3.0).DZ(15.0,3.5).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.em).DH(428,85).DK(7.45,0.55).EC(200).EE(50).DT(54.5,3.375).DW(0.651,3.4).DZ(15.0,4.0).Dw(30.0,0).Dy(125).EA(335);
		boot.O.b.EV(boot.BF.en).DH(435,95).DK(7.2,0.8).DT(54.5,3.4).DW(0.658,3.4).DZ(17.6,3.4).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.eo).DH(405,82).DK(7.1,0.55).DN(215,45.0).DQ(6.6,0.55).DT(56.65,3.375).DW(0.613,1.81).DZ(18.0,3.5).Dw(30.0,0).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.ep).DH(403,104).DK(7.9,0.95).DN(240,40.0).DQ(6.3,0.4).DT(55.52,3.1875).DW(0.625,1.63).DZ(17.75,3.25).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.fa).DH(378,82).DK(4.25,0.55).DN(203,43.0).DQ(6.5,0.5).DT(49.0,2.9).DW(0.658,3.28).DZ(12.75,3.25).Dw(30.0,0).Dy(500).EA(335);
		boot.O.b.EV(boot.BF.fb).DH(440,96).DK(7.5,0.85).DN(205,40.0).DQ(6.45,0.45).DT(54.1,4.2).DW(0.625,2.1).DZ(19.0,3.8).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.fc).DH(340,70).DK(4.5,0.55).DN(265,45.0).DQ(7.0,0.65).DT(47.0,3.0).DW(0.644,2.3).DZ(6.0,3.3).Dw(30.0,0).Dy(550).EA(330);
		boot.O.b.EV(boot.BF.fd).DH(375,71).DK(4.5,0.55).DN(240,60.0).DQ(6.8,0.65).DT(48.8,3.0).DW(0.625,2.14).DZ(7.4,3.8).Dw(30.0,0).Dy(550).EA(335);
		boot.O.b.EV(boot.BF.fe).DH(385,78).DK(6.75,0.65).DN(240,50.0).DQ(6.8,0.65).DT(49.0,3.0).DW(0.625,2.11).DZ(12.0,4.0).Dw(30.0,0).Dy(500).EA(335);
		boot.O.b.EV(boot.BF.ff).DH(380,78).DK(5.5,0.6).DN(250,50.0).DQ(6.9,0.6).DT(51.0,2.9).DW(0.625,2.0).DZ(15.0,3.4).Dw(30.0,0).Dy(550).EA(330);
		boot.O.b.EV(boot.BF.fg).DH(440,85).DK(7.25,0.75).DN(260,40.0).DQ(6.75,0.5).DT(50.0,3.1).DW(0.668,2.7).DZ(17.0,3.5).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.fh).DH(468,90).DK(7.1,0.5).DN(255,56.0).DQ(4.1,0.4).DT(58.0,3.5).DW(0.625,2.02).DZ(16.5,3.2).Dw(30.0,1.25).Dy(125).EA(340);
		boot.O.b.EV(boot.BF.fi).DH(383,82).DK(4.65,0.65).DN(200,40.0).DQ(6.45,0.45).DT(44.5,3.0).DW(0.69,3.38).DZ(14.0,3.75).Dw(30.0,0).Dy(500).EA(330);
		boot.O.b.EV(boot.BF.fj).DH(415,82).DK(5.1,0.65).DN(193,32.0).DQ(6.45,0.45).DT(46.5,3.0).DW(0.658,3.01).DZ(15.0,3.0).Dw(30.0,0).Dy(550).EA(325);
		boot.O.b.EV(boot.BF.fk).DH(455,96).DK(8.0,0.85).DN(206,45.0).DQ(6.9,0.6).DT(54.66,3.0).DW(0.672,2.9).DZ(19.0,2.7).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.fl).DH(461,98).DK(7.9,0.9).DT(56.0,3.2).DW(0.644,2.9).DZ(14.9,3.1).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.fm).DH(384,82).DK(4.5,0.6).DN(202,38.0).DQ(6.5,0.5).DT(46.61,3.3).DW(0.651,3.22).DZ(111.25,3.15).Dw(30.0,0).Dy(525).EA(330);
		boot.O.b.EV(boot.BF.fn).DH(389,81).DK(5.0,0.6).DN(220,40.0).DQ(6.5,0.45).DT(49.0,3.0).DW(0.679,3.38).DZ(14.0,3.0).Dw(30.0,0).Dy(550).EA(330);
		boot.O.b.EV(boot.BF.fo).DH(427,99).DK(7.45,0.75).DN(220,30.0).DQ(6.4,0.45).DT(52.91,3.2).DW(0.658,2.67).DZ(14.75,4.0).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.fp).DH(437,89).DK(5.5,0.6).DN(220,55.0).DQ(7.5,0.65).DT(48.0,3.6).DW(0.644,2.9).DZ(15.0,3.3).Dw(30.0,0).Dy(425).EA(335);
		boot.O.b.EV(boot.BF.ga).DH(400,82).DK(4.5,0.55).DN(250,36.0).DQ(6.5,0.5).DT(46.0,3.0).DW(0.658,2.65).DZ(13.5,3.4).Dw(30.0,0).Dy(575).EA(335);
		boot.O.b.EV(boot.BF.gb).DH(359,83).DK(4.5,0.55).DN(173,27.0).DQ(6.3,0.4).DT(50.0,3.25).DW(0.658,3.1).DZ(9.3,3.4).Dw(30.0,0).Dy(550).EA(330);
		boot.O.b.EV(boot.BF.gc).DH(355,82).DK(4.5,0.55).DN(250,55.0).DQ(6.9,0.6).DT(48.3,2.625).DW(0.625,2.24).DZ(12.25,3.75).Dw(30.0,0).Dy(525).EA(340);
		boot.O.b.EV(boot.BF.gd).DH(440,85).DK(7.5,0.9).DN(220,45.0).DQ(7.0,0.65).DT(55.0,3.5).DW(0.643,2.5).DZ(16.0,3.5).Dw(30.0,1.25).Dy(125).EA(350);
		boot.O.b.EV(boot.BF.ge).DH(385,78).DK(6.75,0.65).DN(240,50.0).DQ(6.9,0.45).DT(49.0,3.0).DW(0.625,2.11).DZ(12.0,4.0).Dw(30.0,0).Dy(525).EA(335);
		boot.O.b.EV(boot.BF.gf).DH(400,85).DK(6.0,0.6).DT(45.0,3.0).DW(0.6258,2.0).DZ(12.0,3.5).Dw(30.0,0).Dy(450).EA(335);
		boot.O.b.EV(boot.BF.gg).DH(440,86).DK(7.0,0.65).DN(220,30.0).DQ(7.0,0.65).DT(54.0,3.3).DW(0.625,2.9).DZ(16.5,3.5).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.gh).DH(428,98).DK(7.05,0.8).DN(190,30.0).DQ(7.1,0.6).DT(56.76,3.375).DW(0.679,2.88).DZ(16.0,3.5).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.gi).DH(435,85).DK(5.1,0.65).DN(202,38.0).DQ(6.9,0.65).DT(54.0,3.2).DW(0.658,3.0).DZ(15.0,3.5).Dw(30.0,1.25).Dy(175).EA(345);
		boot.O.b.EV(boot.BF.gj).DH(380,80).DK(5.0,0.55).DN(250,45.0).DQ(8.0,0.6).DT(52.0,3.0).DW(0.625,1.36).DZ(12.6,3.4).Dw(30.0,0).Dy(550).EA(340);
		boot.O.b.EV(boot.BF.gk).DH(445,87).DK(7.0,0.7).DN(213,31.0).DQ(6.6,0.45).DT(52.0,3.3).DW(0.672,2.7).DZ(16.2,3.7).Dw(30.0,1.25).Dy(175).EA(345);
		boot.O.b.EV(boot.BF.gl).DH(421,85).DK(8.5,0.7).DN(235,35.0).DQ(6.5,0.45).DT(51.5,3.5).DW(0.625,3.0).DZ(18.0,3.6).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.gm).DH(445,85).DK(6.0,0.65).EC(20).EE(50).DT(48.6,3.4).DW(0.658,3.1).DZ(17.5,3.5).Dw(30.0,1.25).Dy(125).EA(345);
		boot.O.b.EV(boot.BF.gn).DH(390,80).DK(5.25,0.6).DN(250,50.0).DQ(6.75,0.6).DT(54.0,3.1).DW(0.656,1.7).DZ(12.0,3.3).Dw(30.0,0).Dy(575).EA(330);
		boot.O.b.EV(boot.BF.go).DH(380,71).DK(4.6,0.5).DN(260,60.0).DQ(6.95,0.65).DT(48.6,3.0).DW(0.625,2.13).DZ(6.75,3.8).Dw(30.0,0).Dy(600).EA(335);
		boot.O.b.EV(boot.BF.gp).DH(355,74).DK(4.85,0.5).DN(250,50.0).DQ(7.1,0.75).DT(50.0,3.2).DW(0.625,1.8).DZ(11.0,3.0).Dw(30.0,0).Dy(575).EA(325);
		boot.O.c=new boot.O(1520,2012,12,3,"Preseason 3",boot.O.b,0);
		boot.O.c.ER("Shard of True Ice");
		boot.O.c.ER("Liandry's Torment");
		boot.O.c.ER("Haunting Guise");
		boot.O.a=boot.O.c;
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
	ER:function(A,B){
		B=new boot.Bv(A,this,0);
		this.e.CS(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	EV:function(A){
		A.hb=new boot.BI(this,A.hb,0);
		return A.hb;
	}
});

boot.define("B","C",{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B){
		this.D(boot.K.$);
		this.D(boot.L.$);
		boot.C.prototype.A.call(this);
		$("body").css("padding","0px 10%");
		A=new boot.M(0);
		A.K("< ^ v ^ > Teemowork","test.html");
		A.K("Patch","#");
		B=A.K("Data","#");
		B.K("Champion","#");
		B.K("Item","#");
		B.K("Mastery","#");
		B.K("Rune","#");
		A.K("Builder","#");
		A.K("About","#");
		A.K("Contact","#");
		console.log(boot.O.a);
	},
	// teemowork.Teemowork#test()
	L:function(){
		console.log("called");
	}
},{
	"$":[["P",{
		M:function() {return true;},N:function() {return 10;},O:function() {return 10;},P:function() {return 4;},Q:function() {return 10;},R:function() {return 10.0;},S:function() {return 10.0;}
	}]],"L":[["Q",{
	}]]
});

try {new boot.B(0).A();} catch(e) {console.log(e)}