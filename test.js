boot.defineNative("Document",{
	
	// booton.translator.web.Document#<init>()
	$0:function(){
	},
	// booton.translator.web.Document#createElement(java.lang.String)
	createElement:function(A){
		return this.createElement(A);
	}
});
boot.define("S",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.S.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.S.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.S.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.S.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	BH:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	BI:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	BJ:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	BK:function(){
		console.log(this.a);
	}
});

boot.define("R",boot.S,{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.S.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.S.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.S.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.S.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.S.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("Q",boot.R,{
	
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

boot.define("P",boot.Q,{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.Q.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.Q.prototype.$1.call(this,A);
	}
});

boot.define("N",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	O:function(){
		return this.b<boot.K.BG(this.a).length;
	},
	// js.util.ArrayList$View#next()
	L:function(){
		return boot.K.BG(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	BL:function(){
		if(this.b<=0){
		}else{
			boot.K.BG(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.N.prototype.$1.call(this,A);
	}
});

boot.define("M",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	Q:function(){
		return this.R()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	S:function(A,B,C,D){
		B=0;
		D=A.K();
		l2:while (D.O()!=0) {
			C=D.L();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	T:function(A,B,C,D){
		B=0;
		D=this.K();
		l2:while (D.O()!=0) {
			C=D.L();
			if(A.U(C)!=0){
			}else{
				B=this.V(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	W:function(A,B,C,D){
		B=0;
		D=A.K();
		l2:while (D.O()!=0) {
			C=D.L();
			if(this.V(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	X:function(A,B,C){
		C=A.K();
		l1:while (C.O()!=0) {
			B=C.L();
			if(this.U(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	Y:function(){
		return this.Z(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	Z:function(A,B,C,D,E){
		B=this.R();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.K();
		D=0;
		l6:while (C.O()!=0) {
			E=C.L();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("O",boot.S,{
	
	// java.lang.Error#<init>()
	$0:function(){
		boot.S.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$1:function(A){
		boot.S.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.S.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$3:function(A){
		boot.S.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.S.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("K",boot.M,{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.M.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	R:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	U:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	K:function(){
		return new boot.N(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	V:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	u:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	v:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	w:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	x:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	y:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	z:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	BA:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	BB:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	BC:function(){
		throw new boot.O(0);
	},
	// js.util.ArrayList#listIterator(int)
	BD:function(A){
		throw new boot.O(0);
	},
	// js.util.ArrayList#subList(int, int)
	BE:function(A,B){
		throw new boot.O(0);
	},
	// js.util.ArrayList#checkRange(int)
	BF:function(A){
		if(A>=0){
			if(this.R()>A){
				return;
			}else{
				throw new boot.P("Index is overflowed. Size: "+this.R()+"  Index: "+A,0);
			}
		}else{
			throw new boot.P("Negative index is unacceptable. Size: "+this.R()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_BG:function(A){
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
	BM:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.K(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.Y());
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
	_M:function(A,B){
		return A.BM(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.E.prototype.$1.call(this,A,B);
	}
});

boot.define("F",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("T",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("V",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	O:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	BP:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	BL:function(){
	},
	// booton.translator.web.jQuery$1#next()
	L:function(){
		return this.BP();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	BN:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	BO:function(A){
		return this.BN("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	K:function(){
		return new boot.V(this,0);
	}
});
boot.define("D",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.K(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.J(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	J:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.K();
		l3:while (C.O()!=0) {
			B=C.L();
			D=boot.E.M(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.N(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	P:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.N(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.D.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.J(B);
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

boot.define("J",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.BN("ul").addClass("d");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.BN("li").addClass("e");
		C.BN("a").addClass("c").attr("href",B).text(A);
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
		C=this.a.BN("li").addClass("b");
		C.BN("a").addClass("c").attr("href",B).text(A);
		return new boot.J(this,C,null,0);
	}
});

boot.define("x",{
	
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
	L:function(A){
		A=this.b.L();
		if(this.c==0){
			return A.Bv();
		}else{
			return A.CC();
		}
	},
	// js.util.HashMap$View#remove()
	BL:function(){
		this.b.BL();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.x.prototype.$1.call(this,A,B,C);
	}
});

boot.define("y",boot.M,{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.M.prototype.$0.call(this);
	}
});

boot.define("z",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
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
	L:function(){
		this.d=boot.Z.CG(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	BL:function(){
		if(this.b<=0){
		}else{
			this.a.V(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.z.prototype.$1.call(this,A,B);
	}
});

boot.define("Z",boot.y,{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.y.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	R:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	U:function(A){
		return this.CF(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.CF(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	V:function(A,B){
		B=this.CF(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	v:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	K:function(){
		return new boot.z(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	CF:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	Bu:function(A){
		return this.b[this.CF(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	Bw:function(A,B,C){
		B=null;
		C=this.CF(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	Bz:function(A,B,C){
		B=null;
		C=this.CF(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_CG:function(A){
		return A.b;
	}
});

boot.define("w",boot.M,{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.M.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	R:function(){
		return boot.Y.CE(this.a).R();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	U:function(A){
		return this.a.BZ(A);
	},
	// js.util.HashMap$Values#iterator()
	K:function(){
		return new boot.x(this.a,boot.Y.CE(this.a).K(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	V:function(A,B,C){
		B=this.K();
		l2:while (B.O()!=0) {
			C=B.L();
			if(C!=A){
			}else{
				B.BL();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	v:function(){
		boot.Y.CE(this.a).v();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.w.prototype.$1.call(this,A);
	}
});

boot.define("u",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	CC:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	Bv:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	CH:function(A,B){
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
		boot.u.prototype.$1.call(this,A,B);
	}
});

boot.define("v",boot.y,{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.y.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	R:function(){
		return boot.Y.CE(this.a).R();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	U:function(A){
		return boot.Y.CE(this.a).U(A);
	},
	// js.util.HashMap$Keys#iterator()
	K:function(){
		return new boot.x(this.a,boot.Y.CE(this.a).K(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	V:function(A){
		return boot.Y.CE(this.a).V(A);
	},
	// js.util.HashMap$Keys#clear()
	v:function(){
		boot.Y.CE(this.a).v();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.v.prototype.$1.call(this,A);
	}
});

boot.define("Y",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.Z(0);
	},
	// js.util.HashMap#size()
	R:function(){
		return this.a.R();
	},
	// js.util.HashMap#isEmpty()
	Q:function(){
		return this.a.Q();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	BY:function(A){
		return this.a.U(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	BZ:function(A,B,C){
		C=this.BX().K();
		l1:while (C.O()!=0) {
			B=C.L();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	BV:function(A,B){
		B=this.a.Bu(A);
		return (B==null?null:B.Bv());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	BS:function(A,B,C){
		C=this.a.Bw(new boot.u(A,B,null,0));
		if(C!=null){
			return C.Bv();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	Bx:function(A,B){
		B=this.a.Bz(A);
		if(B!=null){
			return B.Bv();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	CA:function(A,B,C){
		C=A.CB().K();
		l1:for (;
		C.O()!=0;
		this.BS(B.CC(),B.Bv())) {
			B=C.L();
		}
	},
	// js.util.HashMap#clear()
	v:function(){
		this.a.v();
	},
	// js.util.HashMap#keySet()
	CD:function(){
		return new boot.v(this,null,0);
	},
	// js.util.HashMap#values()
	BX:function(){
		return new boot.w(this,null,0);
	},
	// js.util.HashMap#entrySet()
	CB:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_CE:function(A){
		return A.a;
	}
});

boot.define("X",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.X.b=new boot.Y(0);
		boot.X.c=new boot.X("Ahri",0);
		boot.X.d=new boot.X("Akali",0);
		boot.X.e=new boot.X("Alistar",0);
		boot.X.f=new boot.X("Amumu",0);
		boot.X.g=new boot.X("Ashe",0);
		boot.X.h=new boot.X("Blitzcrank",0);
		boot.X.i=new boot.X("Brand",0);
		boot.X.j=new boot.X("Caitlyn",0);
		boot.X.k=new boot.X("Cassiopeia",0);
		boot.X.l=new boot.X("Chogath",0);
		boot.X.m=new boot.X("Corki",0);
		boot.X.n=new boot.X("Darius",0);
		boot.X.o=new boot.X("Diana",0);
		boot.X.p=new boot.X("Dr.Mundo",0);
		boot.X.ba=new boot.X("Elise",0);
		boot.X.bb=new boot.X("Evelynn",0);
		boot.X.bc=new boot.X("Ezreal",0);
		boot.X.bd=new boot.X("Fiddlesticks",0);
		boot.X.be=new boot.X("Fiora",0);
		boot.X.bf=new boot.X("Fizz",0);
		boot.X.bg=new boot.X("Galio",0);
		boot.X.bh=new boot.X("Gangplank",0);
		boot.X.bi=new boot.X("Garen",0);
		boot.X.bj=new boot.X("Gragas",0);
		boot.X.bk=new boot.X("Graves",0);
		boot.X.bl=new boot.X("Hecarim",0);
		boot.X.bm=new boot.X("Heimerdinger",0);
		boot.X.bn=new boot.X("Irelia",0);
		boot.X.bo=new boot.X("Janna",0);
		boot.X.bp=new boot.X("Jarvan IV",0);
		boot.X.ca=new boot.X("Jax",0);
		boot.X.cb=new boot.X("Jayce",0);
		boot.X.cc=new boot.X("Karma",0);
		boot.X.cd=new boot.X("Karthus",0);
		boot.X.ce=new boot.X("Kassadin",0);
		boot.X.cf=new boot.X("Katarina",0);
		boot.X.cg=new boot.X("Kayle",0);
		boot.X.ch=new boot.X("Kennen",0);
		boot.X.ci=new boot.X("Kha'zix",0);
		boot.X.cj=new boot.X("Kog'maw",0);
		boot.X.ck=new boot.X("LeBlanc",0);
		boot.X.cl=new boot.X("Lee Sin",0);
		boot.X.cm=new boot.X("Leona",0);
		boot.X.cn=new boot.X("Lulu",0);
		boot.X.co=new boot.X("Lux",0);
		boot.X.cp=new boot.X("Malphite",0);
		boot.X.da=new boot.X("Maokai",0);
		boot.X.db=new boot.X("Master Yi",0);
		boot.X.dc=new boot.X("Miss Fortune",0);
		boot.X.dd=new boot.X("Mordekaiser",0);
		boot.X.de=new boot.X("Morgana",0);
		boot.X.df=new boot.X("Nami",0);
		boot.X.dg=new boot.X("Nasus",0);
		boot.X.dh=new boot.X("Nautilus",0);
		boot.X.di=new boot.X("Nidalee",0);
		boot.X.dj=new boot.X("Nocturne",0);
		boot.X.dk=new boot.X("Nunu",0);
		boot.X.dl=new boot.X("Olaf",0);
		boot.X.dm=new boot.X("Orianna",0);
		boot.X.dn=new boot.X("Pantheon",0);
		boot.X.dp=new boot.X("Poppy",0);
		boot.X.ea=new boot.X("Rammus",0);
		boot.X.eb=new boot.X("Renekton",0);
		boot.X.ec=new boot.X("Rengar",0);
		boot.X.ed=new boot.X("Riven",0);
		boot.X.ee=new boot.X("Rumble",0);
		boot.X.ef=new boot.X("Ryze",0);
		boot.X.eg=new boot.X("Sejuani",0);
		boot.X.eh=new boot.X("Shaco",0);
		boot.X.ei=new boot.X("Shen",0);
		boot.X.ej=new boot.X("Shyvana",0);
		boot.X.ek=new boot.X("Singed",0);
		boot.X.el=new boot.X("Sion",0);
		boot.X.em=new boot.X("Sivir",0);
		boot.X.en=new boot.X("Skarner",0);
		boot.X.eo=new boot.X("Sona",0);
		boot.X.ep=new boot.X("Soraka",0);
		boot.X.fa=new boot.X("Swain",0);
		boot.X.fb=new boot.X("Syndra",0);
		boot.X.fc=new boot.X("Talon",0);
		boot.X.fd=new boot.X("Taric",0);
		boot.X.fe=new boot.X("Teemo",0);
		boot.X.ff=new boot.X("Tristana",0);
		boot.X.fg=new boot.X("Trundle",0);
		boot.X.fh=new boot.X("Tryndamere",0);
		boot.X.fi=new boot.X("Twisted Fate",0);
		boot.X.fj=new boot.X("Twitch",0);
		boot.X.fk=new boot.X("Udyr",0);
		boot.X.fl=new boot.X("Urgot",0);
		boot.X.fm=new boot.X("Varus",0);
		boot.X.fn=new boot.X("Vayne",0);
		boot.X.fo=new boot.X("Veigar",0);
		boot.X.fp=new boot.X("Vi",0);
		boot.X.ga=new boot.X("Viktor",0);
		boot.X.gb=new boot.X("Vladimir",0);
		boot.X.gc=new boot.X("Volibear",0);
		boot.X.gd=new boot.X("Warwick",0);
		boot.X.ge=new boot.X("Wukong",0);
		boot.X.gf=new boot.X("Xerath",0);
		boot.X.gg=new boot.X("Xin Zhao",0);
		boot.X.gh=new boot.X("Yorick",0);
		boot.X.gi=new boot.X("Zed",0);
		boot.X.gj=new boot.X("Ziggs",0);
		boot.X.gk=new boot.X("Zilean",0);
		boot.X.gl=new boot.X("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.gm=this.BR().toLowerCase();
		boot.X.b.BS(A,this);
	},
	// teemowork.model.Champion#getSystemName()
	BR:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	BT:function(){
		return "src/main/resources/teemowork/splash/"+this.BR()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	BU:function(){
		return "src/main/resources/teemowork/icon/"+this.BR()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_BQ:function(A){
		return boot.X.b.BV(A);
	},
	// teemowork.model.Champion#getAll()
	_BW:function(){
		return boot.X.b.BX();
	}
});

boot.define("G",boot.F,{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.G.prototype.$1.call(this,boot.X.BQ(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.F.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.O(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	N:function(A){
		console.log("detail page "+this.a+"  "+this.a.a);
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	}
});

boot.define("BD",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BB.CM(this.a).CB().K();
		l2:while (D.O()!=0) {
			C=D.L();
			if(this.a.CL(C.CC()).toLowerCase().indexOf(B) != -1==0){
				C.Bv().addClass("i");
				continue l2;
			}else{
				C.Bv().removeClass("i");
				continue l2;
			}
		}
	}
});

boot.define("BE",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.CQ(this.b);
	}
});

boot.define("BC",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BC.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BB",boot.BC,{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BC.prototype.$0.call(this);
		this.b=new boot.Y(0);
		this.c=this.CJ();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	CI:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("f").css("display","block");
		B.keyup(new boot.BD(this,B,0));
		D=this.c.K();
		l6:for (;
		D.O()!=0;
		this.b.BS(C,E)) {
			C=D.L();
			E=this.a.BO("g").css("background-image","url("+this.CK(C)+")");
			E.BN("span").addClass("h").text(this.CL(C));
			E.click(new boot.BE(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_CM:function(A){
		return A.b;
	}
});

boot.define("BA",boot.BB,{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BB.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	CJ:function(){
		return boot.X.BW();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	CN:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	CO:function(A){
		return A.BU();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	CP:function(A){
		boot.B.G(new boot.G(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	CL:function(A){
		return this.CN(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	CK:function(A){
		return this.CO(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	CQ:function(A){
		this.CP(A);
	}
});

boot.define("H",boot.F,{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.F.prototype.$0.call(this);
		this.a=new boot.BA(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	N:function(A){
		this.a.CI(A);
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