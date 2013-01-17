boot.define("A",{
	
	// booton.translator.Javascript$ClassReplacement#<init>(java.lang.String, booton.translator.js.NativeObject)
	$0:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ClassReplacement#isAnnotationPresent(java.lang.Class)
	M:function(A){
		return false;
	},
	// booton.translator.Javascript$ClassReplacement#getName()
	N:function(){
		return "boot."+this.a;
	},
	// booton.translator.Javascript$ClassReplacement#getSimpleName()
	O:function(){
		return this.a;
	},
	// booton.translator.Javascript$ClassReplacement#newInstance()
	P:function(){
		return null;
	},
	// booton.translator.Javascript$ClassReplacement#getConstructor()
	Q:function(){
		return null;
	},
	// booton.translator.Javascript$ClassReplacement#getAnnotation(java.lang.Class)
	J:function(A,B,C,D){
		B=this.b["$A"]["$"];
		C=0;
		l3:for (;
		C<B.length;
		++C) {
			D=B[C];
			if(D[0].equals(A.N())==0){
			}else{
				return D[1];
			}
		}return null;
	}
});

boot.define("S",{
});

boot.define("Q",{
});

boot.define("R",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	Y:function(){
		return this.Z()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	u:function(A,B,C,D){
		B=0;
		D=A.S();
		l2:while (D.W()!=0) {
			C=D.T();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	v:function(A,B,C,D){
		B=0;
		D=this.S();
		l2:while (D.W()!=0) {
			C=D.T();
			if(A.w(C)!=0){
			}else{
				B=this.x(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	y:function(A,B,C,D){
		B=0;
		D=A.S();
		l2:while (D.W()!=0) {
			C=D.T();
			if(this.x(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	z:function(A,B,C){
		C=A.S();
		l1:while (C.W()!=0) {
			B=C.T();
			if(this.w(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BA:function(){
		return this.BB(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BB:function(A,B,C,D,E){
		B=this.Z();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.S();
		D=0;
		l6:while (C.W()!=0) {
			E=C.T();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("T",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	W:function(){
		return this.b<boot.P.BO(this.a).length;
	},
	// js.util.ArrayList$View#next()
	T:function(){
		return boot.P.BO(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	BP:function(){
		if(this.b<=0){
		}else{
			boot.P.BO(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.T.prototype.$1.call(this,A);
	}
});

boot.define("W",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.W.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.W.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.W.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.W.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	BQ:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	BR:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	BS:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	BT:function(){
		console.log(this.a);
	}
});

boot.define("U",boot.W,{
	
	// java.lang.Error#<init>()
	$0:function(){
		boot.W.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$1:function(A){
		boot.W.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.W.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$3:function(A){
		boot.W.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.W.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("Y",boot.W,{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.W.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.W.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.W.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.W.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.W.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("X",boot.Y,{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.Y.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.Y.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.Y.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.Y.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.Y.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("V",boot.X,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.X.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.X.prototype.$1.call(this,A);
	}
});

boot.define("P",boot.R,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.R.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	Z:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	w:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	S:function(){
		return new boot.T(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	x:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	BC:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BD:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	BE:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	BF:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	BG:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	BH:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	BI:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	BJ:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	BK:function(){
		throw new boot.U(0);
	},
	// js.util.ArrayList#listIterator(int)
	BL:function(A){
		throw new boot.U(0);
	},
	// js.util.ArrayList#subList(int, int)
	BM:function(A,B){
		throw new boot.U(0);
	},
	// js.util.ArrayList#checkRange(int)
	BN:function(A){
		if(A>=0){
			if(this.Z()>A){
				return;
			}else{
				throw new boot.V("Index is overflowed. Size: "+this.Z()+"  Index: "+A,0);
			}
		}else{
			throw new boot.V("Negative index is unacceptable. Size: "+this.Z()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_BO:function(A){
		return A.a;
	}
});

boot.define("Z",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("G",{
});

boot.define("F",{
	
	// js.Application$Route#<init>(java.lang.String, java.lang.Class)
	$1:function(A,B){
		this.a=new RegExp(A.replace(/\*/g,"([^/].+)"),"");
		this.b=B;
	},
	// js.Application$Route#match(java.lang.String)
	BU:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.P(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.BA());
			} catch ($) {
				if ($ instanceof boot.Y) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_U:function(A,B){
		return A.BU(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.F.prototype.$1.call(this,A,B);
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
boot.define("H",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("w",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	W:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	BX:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	BP:function(){
	},
	// booton.translator.web.jQuery$1#next()
	T:function(){
		return this.BX();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	BV:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	BW:function(A){
		return this.BV("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	S:function(){
		return new boot.w(this,0);
	}
});
boot.define("E",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.P(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.R(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	R:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.S();
		l3:while (C.W()!=0) {
			B=C.T();
			D=boot.F.U(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.V(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	X:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.V(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.R(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_E:function(A){
		return A.a;
	}
});

boot.defineAnnotation("E",{
	"X":[["boot.O",{
	}]]
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

boot.define("BM",boot.R,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.R.prototype.$0.call(this);
	}
});

boot.define("BN",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	W:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	T:function(){
		this.d=boot.BG.CU(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	BP:function(){
		if(this.b<=0){
		}else{
			this.a.x(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.BN.prototype.$1.call(this,A,B);
	}
});

boot.define("BG",boot.BM,{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.BM.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	Z:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	w:function(A){
		return this.CT(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.CT(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	x:function(A,B){
		B=this.CT(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BD:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	S:function(){
		return new boot.BN(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	CT:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CJ:function(A){
		return this.b[this.CT(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CL:function(A,B,C){
		B=null;
		C=this.CT(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	CN:function(A,B,C){
		B=null;
		C=this.CT(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_CU:function(A){
		return A.b;
	}
});

boot.define("BH",{
});

boot.define("BI",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	CQ:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CK:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	CV:function(A,B){
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
		boot.BI.prototype.$1.call(this,A,B);
	}
});

boot.define("BF",{
});

boot.define("BJ",{
});

boot.define("BO",{
	
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.a=A;;
		this.b=B;
		this.c=C;
	},
	// js.util.HashMap$View#hasNext()
	W:function(){
		return this.b.W();
	},
	// js.util.HashMap$View#next()
	T:function(A){
		A=this.b.T();
		if(this.c==0){
			return A.CK();
		}else{
			return A.CQ();
		}
	},
	// js.util.HashMap$View#remove()
	BP:function(){
		this.b.BP();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.BO.prototype.$1.call(this,A,B,C);
	}
});

boot.define("BK",boot.BM,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.BM.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	Z:function(){
		return boot.BE.CS(this.a).Z();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	w:function(A){
		return boot.BE.CS(this.a).w(A);
	},
	// js.util.HashMap$Keys#iterator()
	S:function(){
		return new boot.BO(this.a,boot.BE.CS(this.a).S(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	x:function(A){
		return boot.BE.CS(this.a).x(A);
	},
	// js.util.HashMap$Keys#clear()
	BD:function(){
		boot.BE.CS(this.a).BD();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.BK.prototype.$1.call(this,A);
	}
});

boot.define("BL",boot.R,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.R.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	Z:function(){
		return boot.BE.CS(this.a).Z();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	w:function(A){
		return this.a.CI(A);
	},
	// js.util.HashMap$Values#iterator()
	S:function(){
		return new boot.BO(this.a,boot.BE.CS(this.a).S(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	x:function(A,B,C){
		B=this.S();
		l2:while (B.W()!=0) {
			C=B.T();
			if(C!=A){
			}else{
				B.BP();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BD:function(){
		boot.BE.CS(this.a).BD();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.BL.prototype.$1.call(this,A);
	}
});

boot.define("BE",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.BG(0);
	},
	// js.util.HashMap#size()
	Z:function(){
		return this.a.Z();
	},
	// js.util.HashMap#isEmpty()
	Y:function(){
		return this.a.Y();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	CH:function(A){
		return this.a.w(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CI:function(A,B,C){
		C=this.CG().S();
		l1:while (C.W()!=0) {
			B=C.T();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CE:function(A,B){
		B=this.a.CJ(A);
		return (B==null?null:B.CK());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CD:function(A,B,C){
		C=this.a.CL(new boot.BI(A,B,null,0));
		if(C!=null){
			return C.CK();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	CM:function(A,B){
		B=this.a.CN(A);
		if(B!=null){
			return B.CK();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	CO:function(A,B,C){
		C=A.CP().S();
		l1:for (;
		C.W()!=0;
		this.CD(B.CQ(),B.CK())) {
			B=C.T();
		}
	},
	// js.util.HashMap#clear()
	BD:function(){
		this.a.BD();
	},
	// js.util.HashMap#keySet()
	CR:function(){
		return new boot.BK(this,null,0);
	},
	// js.util.HashMap#values()
	CG:function(){
		return new boot.BL(this,null,0);
	},
	// js.util.HashMap#entrySet()
	CP:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_CS:function(A){
		return A.a;
	}
});

boot.define("y",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.y.b=new boot.BE(0);
		boot.y.c=new boot.y("Ahri",0);
		boot.y.d=new boot.y("Akali",0);
		boot.y.e=new boot.y("Alistar",0);
		boot.y.f=new boot.y("Amumu",0);
		boot.y.g=new boot.y("Anivia",0);
		boot.y.h=new boot.y("Annie",0);
		boot.y.i=new boot.y("Ashe",0);
		boot.y.j=new boot.y("Blitzcrank",0);
		boot.y.k=new boot.y("Brand",0);
		boot.y.l=new boot.y("Caitlyn",0);
		boot.y.m=new boot.y("Cassiopeia",0);
		boot.y.n=new boot.y("Chogath",0);
		boot.y.o=new boot.y("Corki",0);
		boot.y.p=new boot.y("Darius",0);
		boot.y.ba=new boot.y("Diana",0);
		boot.y.bb=new boot.y("Dr.Mundo",0);
		boot.y.bc=new boot.y("Draven",0);
		boot.y.bd=new boot.y("Elise",0);
		boot.y.be=new boot.y("Evelynn",0);
		boot.y.bf=new boot.y("Ezreal",0);
		boot.y.bg=new boot.y("Fiddlesticks",0);
		boot.y.bh=new boot.y("Fiora",0);
		boot.y.bi=new boot.y("Fizz",0);
		boot.y.bj=new boot.y("Galio",0);
		boot.y.bk=new boot.y("Gangplank",0);
		boot.y.bl=new boot.y("Garen",0);
		boot.y.bm=new boot.y("Gragas",0);
		boot.y.bn=new boot.y("Graves",0);
		boot.y.bo=new boot.y("Hecarim",0);
		boot.y.bp=new boot.y("Heimerdinger",0);
		boot.y.ca=new boot.y("Irelia",0);
		boot.y.cb=new boot.y("Janna",0);
		boot.y.cc=new boot.y("Jarvan IV",0);
		boot.y.cd=new boot.y("Jax",0);
		boot.y.ce=new boot.y("Jayce",0);
		boot.y.cf=new boot.y("Karma",0);
		boot.y.cg=new boot.y("Karthus",0);
		boot.y.ch=new boot.y("Kassadin",0);
		boot.y.ci=new boot.y("Katarina",0);
		boot.y.cj=new boot.y("Kayle",0);
		boot.y.ck=new boot.y("Kennen",0);
		boot.y.cl=new boot.y("Kha'zix",0);
		boot.y.cm=new boot.y("Kog'maw",0);
		boot.y.cn=new boot.y("LeBlanc",0);
		boot.y.co=new boot.y("Lee Sin",0);
		boot.y.cp=new boot.y("Leona",0);
		boot.y.da=new boot.y("Lulu",0);
		boot.y.db=new boot.y("Lux",0);
		boot.y.dc=new boot.y("Malphite",0);
		boot.y.dd=new boot.y("Malzahar",0);
		boot.y.de=new boot.y("Maokai",0);
		boot.y.df=new boot.y("Master Yi",0);
		boot.y.dg=new boot.y("Miss Fortune",0);
		boot.y.dh=new boot.y("Mordekaiser",0);
		boot.y.di=new boot.y("Morgana",0);
		boot.y.dj=new boot.y("Nami",0);
		boot.y.dk=new boot.y("Nasus",0);
		boot.y.dl=new boot.y("Nautilus",0);
		boot.y.dm=new boot.y("Nidalee",0);
		boot.y.dn=new boot.y("Nocturne",0);
		boot.y.dp=new boot.y("Nunu",0);
		boot.y.ea=new boot.y("Olaf",0);
		boot.y.eb=new boot.y("Orianna",0);
		boot.y.ec=new boot.y("Pantheon",0);
		boot.y.ed=new boot.y("Poppy",0);
		boot.y.ee=new boot.y("Rammus",0);
		boot.y.ef=new boot.y("Renekton",0);
		boot.y.eg=new boot.y("Rengar",0);
		boot.y.eh=new boot.y("Riven",0);
		boot.y.ei=new boot.y("Rumble",0);
		boot.y.ej=new boot.y("Ryze",0);
		boot.y.ek=new boot.y("Sejuani",0);
		boot.y.el=new boot.y("Shaco",0);
		boot.y.em=new boot.y("Shen",0);
		boot.y.en=new boot.y("Shyvana",0);
		boot.y.eo=new boot.y("Singed",0);
		boot.y.ep=new boot.y("Sion",0);
		boot.y.fa=new boot.y("Sivir",0);
		boot.y.fb=new boot.y("Skarner",0);
		boot.y.fc=new boot.y("Sona",0);
		boot.y.fd=new boot.y("Soraka",0);
		boot.y.fe=new boot.y("Swain",0);
		boot.y.ff=new boot.y("Syndra",0);
		boot.y.fg=new boot.y("Talon",0);
		boot.y.fh=new boot.y("Taric",0);
		boot.y.fi=new boot.y("Teemo",0);
		boot.y.fj=new boot.y("Tristana",0);
		boot.y.fk=new boot.y("Trundle",0);
		boot.y.fl=new boot.y("Tryndamere",0);
		boot.y.fm=new boot.y("Twisted Fate",0);
		boot.y.fn=new boot.y("Twitch",0);
		boot.y.fo=new boot.y("Udyr",0);
		boot.y.fp=new boot.y("Urgot",0);
		boot.y.ga=new boot.y("Varus",0);
		boot.y.gb=new boot.y("Vayne",0);
		boot.y.gc=new boot.y("Veigar",0);
		boot.y.gd=new boot.y("Vi",0);
		boot.y.ge=new boot.y("Viktor",0);
		boot.y.gf=new boot.y("Vladimir",0);
		boot.y.gg=new boot.y("Volibear",0);
		boot.y.gh=new boot.y("Warwick",0);
		boot.y.gi=new boot.y("Wukong",0);
		boot.y.gj=new boot.y("Xerath",0);
		boot.y.gk=new boot.y("Xin Zhao",0);
		boot.y.gl=new boot.y("Yorick",0);
		boot.y.gm=new boot.y("Zed",0);
		boot.y.gn=new boot.y("Ziggs",0);
		boot.y.go=new boot.y("Zilean",0);
		boot.y.gp=new boot.y("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.CC().toLowerCase();
		boot.y.b.CD(A,this);
	},
	// teemowork.model.Champion#getStatus()
	Bw:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CC:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	BZ:function(){
		return "src/main/resources/teemowork/splash/"+this.CC()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	Bu:function(){
		return "src/main/resources/teemowork/icon/"+this.CC()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_BY:function(A){
		return boot.y.b.CE(A);
	},
	// teemowork.model.Champion#getAll()
	_CF:function(){
		return boot.y.b.CG();
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("z",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.I.CA(this.a,boot.I.Bz(this.a)+1);
	}
});

boot.define("BA",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.I.CA(this.a,boot.I.Bz(this.a)-1);
	}
});

boot.define("BB",{
	
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
	CW:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	CX:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	CY:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	CZ:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	Cu:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	Cv:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	Cw:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	Cx:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	Cy:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	Cz:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DA:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	DB:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DC:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DD:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	DE:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DF:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DG:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	DH:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DI:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DJ:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DK:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DL:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DM:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	DN:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	DO:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	DP:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	DQ:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	DR:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	DS:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	DT:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	DU:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	DV:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	Bx:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	DW:function(A){
		return this.g+this.h*A;
	}
});

boot.define("I",boot.H,{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.I.prototype.$1.call(this,boot.y.BY(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.H.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.U(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	V:function(A,B,C){
		B=A.BW("a").css("background-image","url('"+this.a.BZ()+"')").BW("b");
		C=B.BW("c").css("background-image","url("+this.a.Bu()+")").click(new boot.z(this,0)).on("contextmenu",new boot.BA(this,0));
		this.b=C.BW("d");
		this.c=B.BW("e").text("Health").BW("f");
		this.Bv(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	Bv:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.Bw();
			this.c.text(""+B.Bx(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_Bz:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CA:function(A,B){
		A.Bv(B);
	}
});

boot.defineAnnotation("I",{
	"$0":[["boot.BC",{
		CB:function() {return "Champion/*";}
	}]],"e":[["boot.BD",{
	}]]
});
boot.define("BS",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BS.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BT",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BR.Dv(this.a).CP().S();
		l2:while (D.W()!=0) {
			C=D.T();
			if(this.a.Du(C.CQ()).toLowerCase().indexOf(B) != -1==0){
				C.CK().addClass("j");
				continue l2;
			}else{
				C.CK().removeClass("j");
				continue l2;
			}
		}
	}
});

boot.define("BU",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.Dw(this.b);
	}
});

boot.define("BR",boot.BS,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BS.prototype.$0.call(this);
		this.b=new boot.BE(0);
		this.c=this.DY();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	DX:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BT(this,B,0));
		D=this.c.S();
		l6:for (;
		D.W()!=0;
		this.b.CD(C,E)) {
			C=D.T();
			E=this.a.BW("h").css("background-image","url("+this.DZ(C)+")");
			E.BV("span").addClass("i").text(this.Du(C));
			E.click(new boot.BU(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_Dv:function(A){
		return A.b;
	}
});

boot.define("BQ",boot.BR,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BR.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	DY:function(){
		return boot.y.CF();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	Dx:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	Dy:function(A){
		return A.Bu();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	Dz:function(A){
		boot.C.G(new boot.I(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	Du:function(A){
		return this.Dx(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	DZ:function(A){
		return this.Dy(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	Dw:function(A){
		this.Dz(A);
	}
});

boot.define("J",boot.H,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.H.prototype.$0.call(this);
		this.a=new boot.BQ(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	V:function(A){
		this.a.DX(A);
	},
	// teemowork.ChampionSelect#getPageId()
	H:function(){
		return "";
	}
});

boot.defineAnnotation("J",{
	"$":[["boot.BC",{
		CB:function() {return "";}
	}]]
});
boot.define("L",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.BV("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.BV("li").addClass("o");
		C.BV("a").addClass("m").attr("href",B).text(A);
		return new boot.L(this.a,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
	$0:function(A,B,C){
		boot.L.prototype.$1.call(this,A,B);
	}
});

boot.define("K",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("k");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.a.BV("li").addClass("l");
		C.BV("a").addClass("m").attr("href",B).text(A);
		return new boot.L(this,C,null,0);
	}
});

boot.define("BV",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.BV.a=new boot.BE(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.BV.a.CE(A);
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
		boot.BV.a.CD(A,this);
	},
	// teemowork.model.Item#cost()
	EG:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	EB:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	EH:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	EI:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	EJ:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	EK:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	EL:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	EM:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	EO:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	EP:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	EQ:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	ER:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	ES:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	ET:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	EU:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	ED:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	EV:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	EW:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	EX:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	EY:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	EZ:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	Eu:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	Ev:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	Ew:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	Ex:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	EC:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	Ey:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	Ez:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FA:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FB:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FC:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FD:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FE:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FF:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FG:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FH:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FI:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FJ:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FK:function(A){
		return boot.BV.a.CE(A);
	},
	// teemowork.model.Item#getAll()
	_CF:function(){
		return boot.BV.a.CG();
	}
});

boot.define("M",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.M.b=new boot.M(1510,2012,11,13,"Initial",null,0);
		boot.M.b.EA("Ruby Crystal").EB(475).EC(180);
		boot.M.b.EA("Haunting Guise").EC(200).ED(25);
		boot.M.b.EE(boot.y.c).CY(380,80).Cv(5.5,0.6).Cy(230,50.0).DB(6.25,0.6).DE(50.0,3.0).DH(0.668,2.0).DK(10.0,3.5).DN(30.0,0).DP(550).DR(330);
		boot.M.b.EE(boot.y.d).CY(445,85).Cv(7.25,0.65).DT(200).DV(50).DE(53.0,3.2).DH(0.694,3.1).DK(16.5,3.5).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.e).CY(442,102).Cv(7.25,0.85).Cy(215,38.0).DB(6.45,0.45).DE(55.03,3.62).DH(0.625,3.62).DK(14.5,3.5).DN(30.0,1.25).DP(125).DR(325);
		boot.M.b.EE(boot.y.f).CY(472,84).Cv(7.45,0.85).Cy(220,40.0).DB(6.5,0.525).DE(47.0,3.8).DH(0.638,2.18).DK(18.0,3.3).DN(30.0,1.25).DP(125).DR(335);
		boot.M.b.EE(boot.y.g).CY(350,70).Cv(4.65,0.55).Cy(257,53.0).DB(7.0,0.6).DE(48.0,3.2).DH(0.625,1.68).DK(10.5,4.0).DN(30.0,0).DP(600).DR(325);
		boot.M.b.EE(boot.y.h).CY(384,76).Cv(4.5,0.55).Cy(250,50.0).DB(6.9,0.6).DE(49.0,2.625).DH(0.579,1.36).DK(12.5,4.0).DN(30.0,0).DP(625).DR(335);
		boot.M.b.EE(boot.y.i).CY(395,79).Cv(4.5,0.55).Cy(173,35.0).DB(6.3,0.4).DE(46.3,2.85).DH(0.658,3.34).DK(11.5,3.4).DN(30.0,0).DP(600).DR(325);
		boot.M.b.EE(boot.y.j).CY(423,95).Cv(7.25,0.75).Cy(260,40.0).DB(6.6,0.5).DE(55.66,3.5).DH(0.625,1.13).DK(14.5,3.5).DN(30.0,1.25).DP(125).DR(325);
		boot.M.b.EE(boot.y.k).CY(380,76).Cv(4.5,0.55).Cy(250,45.0).DB(7.0,0.6).DE(51.66,3.0).DH(0.625,1.36).DK(12.0,3.5).DN(30.0,0).DP(550).DR(340);
		boot.M.b.EE(boot.y.l).CY(390,80).Cv(4.75,0.55).Cy(255,35.0).DB(6.5,0.55).DE(47.0,3.0).DH(0.668,3.0).DK(13.0,3.5).DN(30.0,0).DP(650).DR(325);
		boot.M.b.EE(boot.y.m).CY(380,75).Cv(4.85,0.5).Cy(250,50.0).DB(7.1,0.75).DE(47.0,3.2).DH(0.644,1.68).DK(11.5,4.0).DN(30.0,0).DP(550).DR(335);
		boot.M.b.EE(boot.y.n).CY(440,80).Cv(7.5,0.85).Cy(205,40.0).DB(6.45,0.45).DE(54.1,4.2).DH(0.625,1.44).DK(19.0,3.5).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.o).CY(375,82).Cv(4.5,0.55).Cy(243,37.0).DB(6.5,0.55).DE(48.2,3.0).DH(0.658,2.3).DK(13.5,3.5).DN(30.0,0).DP(550).DR(325);
		boot.M.b.EE(boot.y.p).CY(426,93).Cv(8.25,0.95).Cy(200,37.5).DB(6.0,0.35).DE(50.0,3.5).DH(0.679,2.6).DK(20.0,3.5).DN(30.0,1.25).DP(125).DR(340);
		boot.M.b.EE(boot.y.ba).CY(438,90).Cv(7.0,0.85).Cy(230,40.0).DB(7.0,0.6).DE(48.0,3.0).DH(0.625,2.25).DK(16.0,3.6).DN(30.0,1.25).DP(150).DR(345);
		boot.M.b.EE(boot.y.bb).CY(433,89).Cv(6.5,0.75).DE(56.23,3.0).DH(0.625,2.8).DK(17.0,3.5).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.bc).CY(420,82).Cv(5.0,0.7).Cy(240,42.0).DB(6.95,0.65).DE(46.5,3.5).DH(0.679,2.6).DK(16.0,3.3).DN(30.0,0).DP(550).DR(330);
		boot.M.b.EE(boot.y.bd).CY(395,80).Cv(4.7,0.6).Cy(240,50.0).DB(6.8,0.65).DE(47.5,3.0).DH(0.625,1.75).DK(12.65,3.35).DN(30.0,0).DP(550).DR(335);
		boot.M.b.EE(boot.y.be).CY(414,86).Cv(6.95,0.55).Cy(180,42.0).DB(7.1,0.6).DE(48.0,3.3).DH(0.658,3.84).DK(12.5,4.0).DN(30.0,1.25).DP(125).DR(340);
		boot.M.b.EE(boot.y.bf).CY(350,80).Cv(5.5,0.55).Cy(235,45.0).DB(7.0,0.65).DE(47.2,3.0).DH(0.665,2.8).DK(12.0,3.5).DN(30.0,0).DP(550).DR(330);
		boot.M.b.EE(boot.y.bg).CY(390,80).Cv(4.6,0.6).Cy(251,59.0).DB(6.9,0.65).DE(45.95,2.625).DH(0.625,2.11).DK(11.0,3.5).DN(30.0,0).DP(480).DR(335);
		boot.M.b.EE(boot.y.bh).CY(450,85).Cv(6.3,0.8).Cy(220,40.0).DB(7.25,0.5).DE(54.5,3.2).DH(0.672,3.0).DK(15.5,3.5).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.bi).CY(414,86).Cv(7.0,0.7).Cy(200,40.0).DB(6.15,0.45).DE(53.0,3.0).DH(0.658,3.1).DK(13.0,3.4).DN(30.0,1.25).DP(175).DR(335);
		boot.M.b.EE(boot.y.bj).CY(435,85).Cv(7.45,0.75).Cy(235,50.0).DB(7.0,0.7).DE(56.3,3.375).DH(0.638,1.2).DK(17.0,3.5).DN(30.0,0).DP(125).DR(335);
		boot.M.b.EE(boot.y.bk).CY(495,81).Cv(425.0,0.75).Cy(215,40.0).DB(6.5,0.7).DE(54.0,3.0).DH(0.651,2.75).DK(16.5,3.3).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.bl).CY(455,96).Cv(7.5,0.75).DE(52.5,3.5).DH(0.625,2.9).DK(19.0,2.7).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.bm).CY(434,89).Cv(7.25,0.85).Cy(221,47.0).DB(6.45,0.45).DE(55.78,3.375).DH(0.651,2.05).DK(16.0,3.6).DN(30.0,0).DP(125).DR(340);
		boot.M.b.EE(boot.y.bn).CY(410,84).Cv(5.5,0.7).Cy(255,40.0).DB(6.75,0.7).DE(51.0,3.1).DH(0.625,2.9).DK(15.0,3.2).DN(30.0,0).DP(525).DR(330);
		boot.M.b.EE(boot.y.bo).CY(440,95).Cv(8.0,0.75).Cy(210,40.0).DB(6.5,0.6).DE(56.0,3.2).DH(0.67,2.5).DK(16.0,4.0).DN(30.0,1.25).DP(175).DR(345);
		boot.M.b.EE(boot.y.bp).CY(350,75).Cv(4.5,0.55).Cy(240,65.0).DB(7.0,0.65).DE(49.24,3.0).DH(0.625,1.21).DK(7.0,3.0).DN(30.0,0).DP(550).DR(325);
		boot.M.b.EE(boot.y.ca).CY(456,90).Cv(7.5,0.65).Cy(230,35.0).DB(7.0,0.65).DE(56.0,3.3).DH(0.665,3.2).DK(15.0,3.75).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.cb).CY(356,78).Cv(4.5,0.55).Cy(302,64.0).DB(6.9,0.6).DE(49.0,2.95).DH(0.625,2.61).DK(9.0,3.8).DN(30.0,0).DP(475).DR(335);
		boot.M.b.EE(boot.y.cc).CY(420,90).Cv(7.0,0.7).Cy(235,40.0).DB(6.0,0.45).DE(50.0,3.4).DH(0.658,2.5).DK(14.0,3.0).DN(30.0,1.25).DP(175).DR(340);
		boot.M.b.EE(boot.y.cd).CY(463,98).Cv(7.45,0.55).Cy(230,35.0).DB(6.4,0.7).DE(56.3,3.375).DH(0.638,3.4).DK(18.0,3.5).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.ce).CY(420,90).Cv(6.0,0.8).Cy(240,40.0).DB(7.0,0.7).DE(46.5,3.5).DH(0.658,3.0).DK(12.5,3.5).DN(30.0,0).DP(125).DR(335);
		boot.M.b.EE(boot.y.cf).CY(410,86).Cv(4.7,0.55).Cy(240,60.0).DB(6.8,0.65).DE(50.0,3.3).DH(0.625,2.3).DK(15.0,3.5).DN(30.0,0).DP(425).DR(335);
		boot.M.b.EE(boot.y.cg).CY(390,75).Cv(5.5,0.55).Cy(270,61.0).DB(6.5,0.6).DE(42.2,3.25).DH(0.625,2.11).DK(11.0,3.5).DN(30.0,0).DP(450).DR(335);
		boot.M.b.EE(boot.y.ch).CY(433,78).Cv(6.95,0.5).Cy(230,45.0).DB(6.9,0.6).DE(52.3,3.9).DH(0.638,3.7).DK(14.0,3.2).DN(30.0,1.25).DP(125).DR(340);
		boot.M.b.EE(boot.y.ci).CY(395,83).Cv(6.95,0.55).DE(53.0,3.2).DH(0.658,2.74).DK(14.75,4.0).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.cj).CY(418,93).Cv(7.0,0.75).Cy(255,40.0).DB(6.9,0.525).DE(53.3,2.8).DH(0.638,2.5).DK(17.0,3.5).DN(30.0,0.75).DP(125).DR(335);
		boot.M.b.EE(boot.y.ck).CY(403,79).Cv(4.65,0.65).DT(200).DV(50).DE(51.3,3.3).DH(0.69,3.4).DK(14.0,3.75).DN(30.0,0).DP(550).DR(335);
		boot.M.b.EE(boot.y.cl).CY(430,85).Cv(6.25,0.75).Cy(260,40.0).DB(6.75,0.5).DE(50.0,3.1).DH(0.665,2.7).DK(15.0,3.0).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.cm).CY(440,84).Cv(5.0,0.55).Cy(295,40.0).DB(7.5,0.7).DE(46.0,3.0).DH(0.665,2.65).DK(13.0,3.53).DN(30.0,0).DP(500).DR(340);
		boot.M.b.EE(boot.y.cn).CY(390,75).Cv(4.5,0.55).Cy(250,50.0).DB(6.9,0.6).DE(51.0,3.1).DH(0.625,1.4).DK(12.0,3.5).DN(30.0,0).DP(525).DR(335);
		boot.M.b.EE(boot.y.co).CY(428,85).Cv(6.25,61.0).DV(200).DV(50).DE(55.8,3.2).DH(0.651,3.0).DK(16.0,3.7).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.cp).CY(430,87).Cv(9.0,0.85).Cy(235,40.0).DB(8.0,0.7).DE(55.0,3.0).DH(0.625,2.9).DK(18.0,3.1).DN(30.0,1.25).DP(125).DR(335);
		boot.M.b.EE(boot.y.da).CY(415,82).Cv(6.0,0.72).Cy(200,50.0).DB(6.0,0.6).DE(44.4,2.6).DH(0.625,2.2).DK(9.0,3.7).DN(30.0,0).DP(550).DR(325);
		boot.M.b.EE(boot.y.db).CY(345,79).Cv(4.5,0.55).Cy(250,50.0).DB(6.0,0.6).DE(50.0,3.3).DH(0.625,1.36).DK(8.0,4.0).DN(30.0,0).DP(550).DR(340);
		boot.M.b.EE(boot.y.dc).CY(423,90).Cv(7.45,0.55).Cy(215,40.0).DB(6.4,0.55).DE(56.3,3.375).DH(0.638,3.4).DK(18.0,3.75).DN(30.0,1.25).DP(125).DR(335);
		boot.M.b.EE(boot.y.dd).CY(380,80).Cv(4.5,0.55).Cy(250,45.0).DB(7.0,0.6).DE(51.66,3.0).DH(0.625,1.36).DK(15.0,3.5).DN(30.0,0).DP(550).DR(340);
		boot.M.b.EE(boot.y.de).CY(421,90).Cv(7.25,0.85).Cy(250,46.0).DB(6.45,0.45).DE(58.0,3.3).DH(0.694,2.13).DK(18.0,4.0).DN(30.0,0).DP(125).DR(335);
		boot.M.b.EE(boot.y.df).CY(444,86).Cv(6.75,0.65).Cy(199,36.0).DB(6.5,0.45).DE(55.12,3.1).DH(0.679,2.98).DK(16.3,3.7).DN(30.0,1.25).DP(125).DR(355);
		boot.M.b.EE(boot.y.dg).CY(435,85).Cv(5.1,0.65).Cy(212,38.0).DB(6.95,0.65).DE(46.5,3.0).DH(0.658,3.01).DK(15.0,3.0).DN(30.0,0).DP(550).DR(325);
		boot.M.b.EE(boot.y.dh).CY(421,80).Cv(7.45,0.55).DE(51.7,3.5).DH(0.694,3.0).DK(15.0,3.5).DN(30.0,1.25).DP(125).DR(340);
		boot.M.b.EE(boot.y.di).CY(403,86).Cv(4.7,0.6).Cy(240,60.0).DB(6.8,0.65).DE(51.58,3.5).DH(0.579,1.53).DK(15.0,3.8).DN(30.0,0).DP(425).DR(335);
		boot.M.b.EE(boot.y.dj).CY(365,74).Cv(4.5,45.0).Cy(305,43.0).DB(6.9,0.6).DE(48.0,3.1).DH(0.644,2.6).DK(9.0,4.0).DN(30.0,0).DP(550).DR(330);
		boot.M.b.EE(boot.y.dk).CY(410,90).Cv(7.5,0.9).Cy(200,45.0).DB(6.6,0.5).DE(53.3,3.5).DH(0.638,3.48).DK(15.0,3.5).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.dl).CY(432,86).Cv(7.45,0.55).Cy(200,50.0).DB(7.45,0.7).DE(52.0,3.3).DH(0.613,0.98).DK(12.0,3.25).DN(30.0,1.25).DP(175).DR(325);
		boot.M.b.EE(boot.y.dm).CY(370,90).Cv(5.0,0.6).Cy(220,45.0).DB(7.0,0.5).DE(49.0,3.5).DH(0.672,3.22).DK(11.0,3.5).DN(30.0,10.75).DP(525).DR(335);
		boot.M.b.EE(boot.y.dn).CY(430,85).Cv(7.0,0.75).Cy(215,35.0).DB(6.0,0.45).DE(54.0,3.1).DH(0.668,2.7).DK(17.0,3.5).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.dp).CY(437,108).Cv(7.05,0.8).Cy(213,42.0).DB(6.6,0.5).DE(51.6,3.4).DH(0.625,2.25).DK(16.5,3.5).DN(30.0,1.25).DP(125).DR(340);
		boot.M.b.EE(boot.y.ea).CY(441,93).Cv(7.0,0.9).Cy(225,45.0).DB(6.5,0.575).DE(54.1,3.5).DH(0.694,2.7).DK(17.0,3.0).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.eb).CY(385,79).Cv(5.95,0.55).Cy(250,50.0).DB(7.0,0.5).DE(44.0,2.6).DH(0.658,3.5).DK(8.0,3.0).DN(30.0,0).DP(525).DR(325);
		boot.M.b.EE(boot.y.ec).CY(433,87).Cv(6.75,0.65).Cy(210,34.0).DB(6.6,0.45).DE(50.7,2.9).DH(0.679,2.95).DK(17.1,3.9).DN(30.0,1.25).DP(155).DR(355);
		boot.M.b.EE(boot.y.ed).CY(423,81).Cv(7.45,0.55).Cy(185,30.0).DB(6.4,0.45).DE(56.3,3.375).DH(0.638,3.35).DK(18.0,4.0).DN(30.0,0).DP(125).DR(345);
		boot.M.b.EE(boot.y.ee).CY(420,86).Cv(8.0,0.55).Cy(255,33.0).DB(4.5,0.3).DE(50.0,3.5).DH(0.625,2.22).DK(21.0,3.8).DN(30.0,1.25).DP(125).DR(335);
		boot.M.b.EE(boot.y.ef).CY(426,87).Cv(6.7,0.75).DE(53.12,3.1).DH(0.665,2.65).DK(15.2,3.8).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.eg).CY(435,85).Cv(4.0,0.4).DE(55.0,3.0).DH(0.679,2.85).DK(16.0,3.5).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.eh).CY(414,86).Cv(10.4,0.9).DE(54.0,2.75).DH(0.625,3.5).DK(15.0,3.1).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.ei).CY(450,80).Cv(7.0,0.7).DE(55.32,3.2).DH(0.644,1.85).DK(16.0,3.5).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.ej).CY(360,86).Cv(4.35,0.55).Cy(250,55.0).DB(7.0,0.6).DE(52.0,3.0).DH(0.625,2.11).DK(11.0,3.9).DN(30.0,0).DP(550).DR(335);
		boot.M.b.EE(boot.y.ek).CY(450,85).Cv(7.35,0.85).Cy(220,40.0).DB(6.45,0.45).DE(54.0,3.4).DH(0.67,1.45).DK(20.5,3.5).DN(30.0,1.25).DP(125).DR(340);
		boot.M.b.EE(boot.y.el).CY(441,84).Cv(7.45,0.55).Cy(270,40.0).DB(6.4,0.45).DE(51.7,3.5).DH(0.694,3.0).DK(15.0,3.5).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.em).CY(428,85).Cv(7.45,0.55).DT(200).DV(50).DE(54.5,3.375).DH(0.651,3.4).DK(15.0,4.0).DN(30.0,0).DP(125).DR(335);
		boot.M.b.EE(boot.y.en).CY(435,95).Cv(7.2,0.8).DE(54.5,3.4).DH(0.658,3.4).DK(17.6,3.4).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.eo).CY(405,82).Cv(7.1,0.55).Cy(215,45.0).DB(6.6,0.55).DE(56.65,3.375).DH(0.613,1.81).DK(18.0,3.5).DN(30.0,0).DP(125).DR(345);
		boot.M.b.EE(boot.y.ep).CY(403,104).Cv(7.9,0.95).Cy(240,40.0).DB(6.3,0.4).DE(55.52,3.1875).DH(0.625,1.63).DK(17.75,3.25).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.fa).CY(378,82).Cv(4.25,0.55).Cy(203,43.0).DB(6.5,0.5).DE(49.0,2.9).DH(0.658,3.28).DK(12.75,3.25).DN(30.0,0).DP(500).DR(335);
		boot.M.b.EE(boot.y.fb).CY(440,96).Cv(7.5,0.85).Cy(205,40.0).DB(6.45,0.45).DE(54.1,4.2).DH(0.625,2.1).DK(19.0,3.8).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.fc).CY(340,70).Cv(4.5,0.55).Cy(265,45.0).DB(7.0,0.65).DE(47.0,3.0).DH(0.644,2.3).DK(6.0,3.3).DN(30.0,0).DP(550).DR(330);
		boot.M.b.EE(boot.y.fd).CY(375,71).Cv(4.5,0.55).Cy(240,60.0).DB(6.8,0.65).DE(48.8,3.0).DH(0.625,2.14).DK(7.4,3.8).DN(30.0,0).DP(550).DR(335);
		boot.M.b.EE(boot.y.fe).CY(385,78).Cv(6.75,0.65).Cy(240,50.0).DB(6.8,0.65).DE(49.0,3.0).DH(0.625,2.11).DK(12.0,4.0).DN(30.0,0).DP(500).DR(335);
		boot.M.b.EE(boot.y.ff).CY(380,78).Cv(5.5,0.6).Cy(250,50.0).DB(6.9,0.6).DE(51.0,2.9).DH(0.625,2.0).DK(15.0,3.4).DN(30.0,0).DP(550).DR(330);
		boot.M.b.EE(boot.y.fg).CY(440,85).Cv(7.25,0.75).Cy(260,40.0).DB(6.75,0.5).DE(50.0,3.1).DH(0.668,2.7).DK(17.0,3.5).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.fh).CY(468,90).Cv(7.1,0.5).Cy(255,56.0).DB(4.1,0.4).DE(58.0,3.5).DH(0.625,2.02).DK(16.5,3.2).DN(30.0,1.25).DP(125).DR(340);
		boot.M.b.EE(boot.y.fi).CY(383,82).Cv(4.65,0.65).Cy(200,40.0).DB(6.45,0.45).DE(44.5,3.0).DH(0.69,3.38).DK(14.0,3.75).DN(30.0,0).DP(500).DR(330);
		boot.M.b.EE(boot.y.fj).CY(415,82).Cv(5.1,0.65).Cy(193,32.0).DB(6.45,0.45).DE(46.5,3.0).DH(0.658,3.01).DK(15.0,3.0).DN(30.0,0).DP(550).DR(325);
		boot.M.b.EE(boot.y.fk).CY(455,96).Cv(8.0,0.85).Cy(206,45.0).DB(6.9,0.6).DE(54.66,3.0).DH(0.672,2.9).DK(19.0,2.7).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.fl).CY(461,98).Cv(7.9,0.9).DE(56.0,3.2).DH(0.644,2.9).DK(14.9,3.1).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.fm).CY(384,82).Cv(4.5,0.6).Cy(202,38.0).DB(6.5,0.5).DE(46.61,3.3).DH(0.651,3.22).DK(111.25,3.15).DN(30.0,0).DP(525).DR(330);
		boot.M.b.EE(boot.y.fn).CY(389,81).Cv(5.0,0.6).Cy(220,40.0).DB(6.5,0.45).DE(49.0,3.0).DH(0.679,3.38).DK(14.0,3.0).DN(30.0,0).DP(550).DR(330);
		boot.M.b.EE(boot.y.fo).CY(427,99).Cv(7.45,0.75).Cy(220,30.0).DB(6.4,0.45).DE(52.91,3.2).DH(0.658,2.67).DK(14.75,4.0).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.fp).CY(437,89).Cv(5.5,0.6).Cy(220,55.0).DB(7.5,0.65).DE(48.0,3.6).DH(0.644,2.9).DK(15.0,3.3).DN(30.0,0).DP(425).DR(335);
		boot.M.b.EE(boot.y.ga).CY(400,82).Cv(4.5,0.55).Cy(250,36.0).DB(6.5,0.5).DE(46.0,3.0).DH(0.658,2.65).DK(13.5,3.4).DN(30.0,0).DP(575).DR(335);
		boot.M.b.EE(boot.y.gb).CY(359,83).Cv(4.5,0.55).Cy(173,27.0).DB(6.3,0.4).DE(50.0,3.25).DH(0.658,3.1).DK(9.3,3.4).DN(30.0,0).DP(550).DR(330);
		boot.M.b.EE(boot.y.gc).CY(355,82).Cv(4.5,0.55).Cy(250,55.0).DB(6.9,0.6).DE(48.3,2.625).DH(0.625,2.24).DK(12.25,3.75).DN(30.0,0).DP(525).DR(340);
		boot.M.b.EE(boot.y.gd).CY(440,85).Cv(7.5,0.9).Cy(220,45.0).DB(7.0,0.65).DE(55.0,3.5).DH(0.643,2.5).DK(16.0,3.5).DN(30.0,1.25).DP(125).DR(350);
		boot.M.b.EE(boot.y.ge).CY(385,78).Cv(6.75,0.65).Cy(240,50.0).DB(6.9,0.45).DE(49.0,3.0).DH(0.625,2.11).DK(12.0,4.0).DN(30.0,0).DP(525).DR(335);
		boot.M.b.EE(boot.y.gf).CY(400,85).Cv(6.0,0.6).DE(45.0,3.0).DH(0.6258,2.0).DK(12.0,3.5).DN(30.0,0).DP(450).DR(335);
		boot.M.b.EE(boot.y.gg).CY(440,86).Cv(7.0,0.65).Cy(220,30.0).DB(7.0,0.65).DE(54.0,3.3).DH(0.625,2.9).DK(16.5,3.5).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.gh).CY(428,98).Cv(7.05,0.8).Cy(190,30.0).DB(7.1,0.6).DE(56.76,3.375).DH(0.679,2.88).DK(16.0,3.5).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.gi).CY(435,85).Cv(5.1,0.65).Cy(202,38.0).DB(6.9,0.65).DE(54.0,3.2).DH(0.658,3.0).DK(15.0,3.5).DN(30.0,1.25).DP(175).DR(345);
		boot.M.b.EE(boot.y.gj).CY(380,80).Cv(5.0,0.55).Cy(250,45.0).DB(8.0,0.6).DE(52.0,3.0).DH(0.625,1.36).DK(12.6,3.4).DN(30.0,0).DP(550).DR(340);
		boot.M.b.EE(boot.y.gk).CY(445,87).Cv(7.0,0.7).Cy(213,31.0).DB(6.6,0.45).DE(52.0,3.3).DH(0.672,2.7).DK(16.2,3.7).DN(30.0,1.25).DP(175).DR(345);
		boot.M.b.EE(boot.y.gl).CY(421,85).Cv(8.5,0.7).Cy(235,35.0).DB(6.5,0.45).DE(51.5,3.5).DH(0.625,3.0).DK(18.0,3.6).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.gm).CY(445,85).Cv(6.0,0.65).DT(20).DV(50).DE(48.6,3.4).DH(0.658,3.1).DK(17.5,3.5).DN(30.0,1.25).DP(125).DR(345);
		boot.M.b.EE(boot.y.gn).CY(390,80).Cv(5.25,0.6).Cy(250,50.0).DB(6.75,0.6).DE(54.0,3.1).DH(0.656,1.7).DK(12.0,3.3).DN(30.0,0).DP(575).DR(330);
		boot.M.b.EE(boot.y.go).CY(380,71).Cv(4.6,0.5).Cy(260,60.0).DB(6.95,0.65).DE(48.6,3.0).DH(0.625,2.13).DK(6.75,3.8).DN(30.0,0).DP(600).DR(335);
		boot.M.b.EE(boot.y.gp).CY(355,74).Cv(4.85,0.5).Cy(250,50.0).DB(7.1,0.75).DE(50.0,3.2).DH(0.625,1.8).DK(11.0,3.0).DN(30.0,0).DP(575).DR(325);
		boot.M.c=new boot.M(1520,2012,12,3,"Preseason 3",boot.M.b,0);
		boot.M.c.EA("Shard of True Ice");
		boot.M.c.EA("Liandry's Torment");
		boot.M.c.EA("Haunting Guise");
		boot.M.a=boot.M.c;
	},
	// teemowork.model.Patch#<init>(int, int, int, int, java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C,D,E,F){
		this.d=new boot.BE(0);
		this.e=new boot.BE(0);
		this.f=A;
		this.g=E;
		this.h=F;
	},
	// teemowork.model.Patch#updateItem(java.lang.String)
	EA:function(A,B){
		B=new boot.BV(A,this,0);
		this.e.CD(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	EE:function(A){
		A.hb=new boot.BB(this,A.hb,0);
		return A.hb;
	}
});

boot.define("N",{
});

boot.defineAnnotation("N",{
	"$":[["boot.BW",{
		FL:function() {return RUNTIME;}
	}]]
});
boot.define("B",boot.C,{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B,C){
		this.D("Champion/*",boot.I._);
		this.D("",boot.J._);
		boot.C.prototype.A.call(this);
		$("body").css("padding","0px 10%");
		A=new boot.K(0);
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
		console.log(boot.M.a);
		C=boot.B._;
		console.log(C);
		console.log(C.J(boot.N._).K());
	},
	// teemowork.Teemowork#test()
	L:function(){
		console.log("called");
	}
});

boot.defineAnnotation("B",{
	"$":[["boot.N",{
		K:function() {return 4;}
	}]],"L":[["boot.O",{
	}]]
});
try {new boot.B(0).A();} catch(e) {console.log(e)}