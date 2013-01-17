boot.define("A","",{
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject)
	$0:function(A,B,C){
		this.a=A;
		this.b=B;
		this.c=C;
	},
	// booton.translator.js.JSClass#isAnnotationPresent(java.lang.Class)
	L:function(A,B,C,D){
		if(this.c!=null){
			B=this.c["$"];
			C=0;
			l5:for (;
			C<B.length;
			++C) {
				D=B[C];
				if(D[0].equals(A.T())==0){
				}else{
					return true;
				}
			}return false;
		}else{
			return false;
		}
	},
	// booton.translator.js.JSClass#getName()
	U:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	T:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	V:function(){
		return null;
	},
	// booton.translator.js.JSClass#getConstructor()
	W:function(){
		return null;
	},
	// booton.translator.js.JSClass#getAnnotation(java.lang.Class)
	J:function(A,B,C,D){
		if(this.c==null){
		}else{
			B=this.c["$"];
			C=0;
			l5:for (;
			C<B.length;
			++C) {
				D=B[C];
				if(D[0].equals(A.T())==0){
				}else{
					return D[1];
				}
			}
		}return null;
	}
});

boot.define("S","",{
});

boot.define("Q","",{
});

boot.define("R","",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	y:function(){
		return this.z()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BA:function(A,B,C,D){
		B=0;
		D=A.Y();
		l2:while (D.w()!=0) {
			C=D.Z();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BB:function(A,B,C,D){
		B=0;
		D=this.Y();
		l2:while (D.w()!=0) {
			C=D.Z();
			if(A.BC(C)!=0){
			}else{
				B=this.BD(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BE:function(A,B,C,D){
		B=0;
		D=A.Y();
		l2:while (D.w()!=0) {
			C=D.Z();
			if(this.BD(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BF:function(A,B,C){
		C=A.Y();
		l1:while (C.w()!=0) {
			B=C.Z();
			if(this.BC(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BG:function(){
		return this.BH(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BH:function(A,B,C,D,E){
		B=this.z();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.Y();
		D=0;
		l6:while (C.w()!=0) {
			E=C.Z();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("T","",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	w:function(){
		return this.b<boot.P.BU(this.a).length;
	},
	// js.util.ArrayList$View#next()
	Z:function(){
		return boot.P.BU(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	BV:function(){
		if(this.b<=0){
		}else{
			boot.P.BU(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.T.prototype.$1.call(this,A);
	}
});

boot.define("W","",{
	
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
	BW:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	BX:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	BY:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	BZ:function(){
		console.log(this.a);
	}
});

boot.define("U","W",{
	
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

boot.define("Y","W",{
	
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

boot.define("X","Y",{
	
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

boot.define("V","X",{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.X.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.X.prototype.$1.call(this,A);
	}
});

boot.define("P","R",{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.R.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	z:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BC:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	Y:function(){
		return new boot.T(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BD:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	BI:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BJ:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	BK:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	BL:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	BM:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	BN:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	BO:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	BP:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	BQ:function(){
		throw new boot.U(0);
	},
	// js.util.ArrayList#listIterator(int)
	BR:function(A){
		throw new boot.U(0);
	},
	// js.util.ArrayList#subList(int, int)
	BS:function(A,B){
		throw new boot.U(0);
	},
	// js.util.ArrayList#checkRange(int)
	BT:function(A){
		if(A>=0){
			if(this.z()>A){
				return;
			}else{
				throw new boot.V("Index is overflowed. Size: "+this.z()+"  Index: "+A,0);
			}
		}else{
			throw new boot.V("Negative index is unacceptable. Size: "+this.z()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_BU:function(A){
		return A.a;
	}
});

boot.define("Z","",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("G","",{
});

boot.define("F","",{
	
	// js.Application$Route#<init>(java.lang.String, java.lang.Class)
	$1:function(A,B){
		this.a=new RegExp(A.replace(/\*/g,"([^/].+)"),"");
		this.b=B;
	},
	// js.Application$Route#match(java.lang.String)
	Bu:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.P(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.BG());
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
	_u:function(A,B){
		return A.Bu(B);
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
boot.define("H","",{
	
	// js.Page#<init>()
	$0:function(){
	}
});

boot.define("w","",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	w:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	Bx:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	BV:function(){
	},
	// booton.translator.web.jQuery$1#next()
	Z:function(){
		return this.Bx();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	Bv:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	Bw:function(A){
		return this.Bv("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	Y:function(){
		return new boot.w(this,0);
	}
});
boot.define("E","",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.P(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.X(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	X:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.Y();
		l3:while (C.w()!=0) {
			B=C.Z();
			D=boot.F.u(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.v(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	x:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.v(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.X(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_E:function(A){
		return A.a;
	}
},{
	"x":[["O",{
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

boot.define("BM","R",{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.R.prototype.$0.call(this);
	}
});

boot.define("BN","",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	w:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	Z:function(){
		this.d=boot.BG.Cu(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	BV:function(){
		if(this.b<=0){
		}else{
			this.a.BD(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
	$0:function(A,B,C){
		boot.BN.prototype.$1.call(this,A,B);
	}
});

boot.define("BG","BM",{
	
	// js.util.HashSet#<init>()
	$0:function(){
		boot.BM.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	z:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BC:function(A){
		return this.CZ(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.CZ(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BD:function(A,B){
		B=this.CZ(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BJ:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	Y:function(){
		return new boot.BN(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	CZ:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CP:function(A){
		return this.b[this.CZ(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CR:function(A,B,C){
		B=null;
		C=this.CZ(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	CT:function(A,B,C){
		B=null;
		C=this.CZ(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_Cu:function(A){
		return A.b;
	}
});

boot.define("BH","",{
});

boot.define("BI","",{
	
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	CW:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CQ:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	Cv:function(A,B){
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

boot.define("BF","",{
});

boot.define("BJ","",{
});

boot.define("BO","",{
	
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.a=A;;
		this.b=B;
		this.c=C;
	},
	// js.util.HashMap$View#hasNext()
	w:function(){
		return this.b.w();
	},
	// js.util.HashMap$View#next()
	Z:function(A){
		A=this.b.Z();
		if(this.c==0){
			return A.CQ();
		}else{
			return A.CW();
		}
	},
	// js.util.HashMap$View#remove()
	BV:function(){
		this.b.BV();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.BO.prototype.$1.call(this,A,B,C);
	}
});

boot.define("BK","BM",{
	
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.BM.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	z:function(){
		return boot.BE.CY(this.a).z();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BC:function(A){
		return boot.BE.CY(this.a).BC(A);
	},
	// js.util.HashMap$Keys#iterator()
	Y:function(){
		return new boot.BO(this.a,boot.BE.CY(this.a).Y(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BD:function(A){
		return boot.BE.CY(this.a).BD(A);
	},
	// js.util.HashMap$Keys#clear()
	BJ:function(){
		boot.BE.CY(this.a).BJ();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.BK.prototype.$1.call(this,A);
	}
});

boot.define("BL","R",{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.R.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	z:function(){
		return boot.BE.CY(this.a).z();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BC:function(A){
		return this.a.CO(A);
	},
	// js.util.HashMap$Values#iterator()
	Y:function(){
		return new boot.BO(this.a,boot.BE.CY(this.a).Y(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BD:function(A,B,C){
		B=this.Y();
		l2:while (B.w()!=0) {
			C=B.Z();
			if(C!=A){
			}else{
				B.BV();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BJ:function(){
		boot.BE.CY(this.a).BJ();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.BL.prototype.$1.call(this,A);
	}
});

boot.define("BE","",{
	
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.BG(0);
	},
	// js.util.HashMap#size()
	z:function(){
		return this.a.z();
	},
	// js.util.HashMap#isEmpty()
	y:function(){
		return this.a.y();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	CN:function(A){
		return this.a.BC(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CO:function(A,B,C){
		C=this.CM().Y();
		l1:while (C.w()!=0) {
			B=C.Z();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CK:function(A,B){
		B=this.a.CP(A);
		return (B==null?null:B.CQ());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CJ:function(A,B,C){
		C=this.a.CR(new boot.BI(A,B,null,0));
		if(C!=null){
			return C.CQ();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	CS:function(A,B){
		B=this.a.CT(A);
		if(B!=null){
			return B.CQ();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	CU:function(A,B,C){
		C=A.CV().Y();
		l1:for (;
		C.w()!=0;
		this.CJ(B.CW(),B.CQ())) {
			B=C.Z();
		}
	},
	// js.util.HashMap#clear()
	BJ:function(){
		this.a.BJ();
	},
	// js.util.HashMap#keySet()
	CX:function(){
		return new boot.BK(this,null,0);
	},
	// js.util.HashMap#values()
	CM:function(){
		return new boot.BL(this,null,0);
	},
	// js.util.HashMap#entrySet()
	CV:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_CY:function(A){
		return A.a;
	}
});

boot.define("y","",{
	
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
		this.ha=this.CI().toLowerCase();
		boot.y.b.CJ(A,this);
	},
	// teemowork.model.Champion#getStatus()
	CD:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CI:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	CA:function(){
		return "src/main/resources/teemowork/splash/"+this.CI()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	CB:function(){
		return "src/main/resources/teemowork/icon/"+this.CI()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_Bz:function(A){
		return boot.y.b.CK(A);
	},
	// teemowork.model.Champion#getAll()
	_CL:function(){
		return boot.y.b.CM();
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("z","",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.I.CG(this.a,boot.I.CF(this.a)+1);
	}
});

boot.define("BA","",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.I.CG(this.a,boot.I.CF(this.a)-1);
	}
});

boot.define("BB","",{
	
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
	Cw:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	Cx:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	Cy:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	Cz:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DA:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	DB:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DC:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DD:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	DE:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DF:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DG:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	DH:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DI:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DJ:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	DK:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DL:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DM:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	DN:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DO:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DP:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DQ:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DR:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DS:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	DT:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	DU:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	DV:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	DW:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	DX:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	DY:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	DZ:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	Du:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	Dv:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	CE:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	Dw:function(A){
		return this.g+this.h*A;
	}
});

boot.define("I","H",{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.I.prototype.$1.call(this,boot.y.Bz(A));
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
	v:function(A,B,C){
		B=A.Bw("a").css("background-image","url('"+this.a.CA()+"')").Bw("b");
		C=B.Bw("c").css("background-image","url("+this.a.CB()+")").click(new boot.z(this,0)).on("contextmenu",new boot.BA(this,0));
		this.b=C.Bw("d");
		this.c=B.Bw("e").text("Health").Bw("f");
		this.CC(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	CC:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.CD();
			this.c.text(""+B.CE(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_CF:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CG:function(A,B){
		A.CC(B);
	}
},{
	"$0":[["BC",{
		CH:function() {return "Champion/*";}
	}]],"e":[["BD",{
	}]]
});

boot.define("BS","",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BS.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BT","",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BR.EB(this.a).CV().Y();
		l2:while (D.w()!=0) {
			C=D.Z();
			if(this.a.EA(C.CW()).toLowerCase().indexOf(B) != -1==0){
				C.CQ().addClass("j");
				continue l2;
			}else{
				C.CQ().removeClass("j");
				continue l2;
			}
		}
	}
});

boot.define("BU","",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.EC(this.b);
	}
});

boot.define("BR","BS",{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BS.prototype.$0.call(this);
		this.b=new boot.BE(0);
		this.c=this.Dy();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	Dx:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BT(this,B,0));
		D=this.c.Y();
		l6:for (;
		D.w()!=0;
		this.b.CJ(C,E)) {
			C=D.Z();
			E=this.a.Bw("h").css("background-image","url("+this.Dz(C)+")");
			E.Bv("span").addClass("i").text(this.EA(C));
			E.click(new boot.BU(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_EB:function(A){
		return A.b;
	}
});

boot.define("BQ","BR",{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BR.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	Dy:function(){
		return boot.y.CL();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	ED:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	EE:function(A){
		return A.CB();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	EG:function(A){
		boot.C.G(new boot.I(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	EA:function(A){
		return this.ED(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	Dz:function(A){
		return this.EE(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	EC:function(A){
		this.EG(A);
	}
});

boot.define("J","H",{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.H.prototype.$0.call(this);
		this.a=new boot.BQ(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	v:function(A){
		this.a.Dx(A);
	},
	// teemowork.ChampionSelect#getPageId()
	H:function(){
		return "";
	}
},{
	"$":[["BC",{
		CH:function() {return "";}
	}]]
});

boot.define("L","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.Bv("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.Bv("li").addClass("o");
		C.Bv("a").addClass("m").attr("href",B).text(A);
		return new boot.L(this.a,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery, js.application.Header$Menu)
	$0:function(A,B,C){
		boot.L.prototype.$1.call(this,A,B);
	}
});

boot.define("K","",{
	
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("k");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.a.Bv("li").addClass("l");
		C.Bv("a").addClass("m").attr("href",B).text(A);
		return new boot.L(this,C,null,0);
	}
});

boot.define("BV","",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.BV.a=new boot.BE(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.BV.a.CK(A);
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
		boot.BV.a.CJ(A,this);
	},
	// teemowork.model.Item#cost()
	EM:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	EI:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	EO:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	EP:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	EQ:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	ER:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	ES:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	ET:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	EU:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	EV:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	EW:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	EX:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	EY:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	EZ:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	Eu:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	EK:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	Ev:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	Ew:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	Ex:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	Ey:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	Ez:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	FA:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	FB:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	FC:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	FD:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	EJ:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	FE:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	FF:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FG:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FH:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FI:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FJ:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FK:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FL:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FM:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FN:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FO:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FP:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FQ:function(A){
		return boot.BV.a.CK(A);
	},
	// teemowork.model.Item#getAll()
	_CL:function(){
		return boot.BV.a.CM();
	}
});

boot.define("M","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.M.b=new boot.M(1510,2012,11,13,"Initial",null,0);
		boot.M.b.EH("Ruby Crystal").EI(475).EJ(180);
		boot.M.b.EH("Haunting Guise").EJ(200).EK(25);
		boot.M.b.EL(boot.y.c).Cy(380,80).DB(5.5,0.6).DE(230,50.0).DH(6.25,0.6).DK(50.0,3.0).DN(0.668,2.0).DQ(10.0,3.5).DT(30.0,0).DV(550).DX(330);
		boot.M.b.EL(boot.y.d).Cy(445,85).DB(7.25,0.65).DZ(200).Dv(50).DK(53.0,3.2).DN(0.694,3.1).DQ(16.5,3.5).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.e).Cy(442,102).DB(7.25,0.85).DE(215,38.0).DH(6.45,0.45).DK(55.03,3.62).DN(0.625,3.62).DQ(14.5,3.5).DT(30.0,1.25).DV(125).DX(325);
		boot.M.b.EL(boot.y.f).Cy(472,84).DB(7.45,0.85).DE(220,40.0).DH(6.5,0.525).DK(47.0,3.8).DN(0.638,2.18).DQ(18.0,3.3).DT(30.0,1.25).DV(125).DX(335);
		boot.M.b.EL(boot.y.g).Cy(350,70).DB(4.65,0.55).DE(257,53.0).DH(7.0,0.6).DK(48.0,3.2).DN(0.625,1.68).DQ(10.5,4.0).DT(30.0,0).DV(600).DX(325);
		boot.M.b.EL(boot.y.h).Cy(384,76).DB(4.5,0.55).DE(250,50.0).DH(6.9,0.6).DK(49.0,2.625).DN(0.579,1.36).DQ(12.5,4.0).DT(30.0,0).DV(625).DX(335);
		boot.M.b.EL(boot.y.i).Cy(395,79).DB(4.5,0.55).DE(173,35.0).DH(6.3,0.4).DK(46.3,2.85).DN(0.658,3.34).DQ(11.5,3.4).DT(30.0,0).DV(600).DX(325);
		boot.M.b.EL(boot.y.j).Cy(423,95).DB(7.25,0.75).DE(260,40.0).DH(6.6,0.5).DK(55.66,3.5).DN(0.625,1.13).DQ(14.5,3.5).DT(30.0,1.25).DV(125).DX(325);
		boot.M.b.EL(boot.y.k).Cy(380,76).DB(4.5,0.55).DE(250,45.0).DH(7.0,0.6).DK(51.66,3.0).DN(0.625,1.36).DQ(12.0,3.5).DT(30.0,0).DV(550).DX(340);
		boot.M.b.EL(boot.y.l).Cy(390,80).DB(4.75,0.55).DE(255,35.0).DH(6.5,0.55).DK(47.0,3.0).DN(0.668,3.0).DQ(13.0,3.5).DT(30.0,0).DV(650).DX(325);
		boot.M.b.EL(boot.y.m).Cy(380,75).DB(4.85,0.5).DE(250,50.0).DH(7.1,0.75).DK(47.0,3.2).DN(0.644,1.68).DQ(11.5,4.0).DT(30.0,0).DV(550).DX(335);
		boot.M.b.EL(boot.y.n).Cy(440,80).DB(7.5,0.85).DE(205,40.0).DH(6.45,0.45).DK(54.1,4.2).DN(0.625,1.44).DQ(19.0,3.5).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.o).Cy(375,82).DB(4.5,0.55).DE(243,37.0).DH(6.5,0.55).DK(48.2,3.0).DN(0.658,2.3).DQ(13.5,3.5).DT(30.0,0).DV(550).DX(325);
		boot.M.b.EL(boot.y.p).Cy(426,93).DB(8.25,0.95).DE(200,37.5).DH(6.0,0.35).DK(50.0,3.5).DN(0.679,2.6).DQ(20.0,3.5).DT(30.0,1.25).DV(125).DX(340);
		boot.M.b.EL(boot.y.ba).Cy(438,90).DB(7.0,0.85).DE(230,40.0).DH(7.0,0.6).DK(48.0,3.0).DN(0.625,2.25).DQ(16.0,3.6).DT(30.0,1.25).DV(150).DX(345);
		boot.M.b.EL(boot.y.bb).Cy(433,89).DB(6.5,0.75).DK(56.23,3.0).DN(0.625,2.8).DQ(17.0,3.5).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.bc).Cy(420,82).DB(5.0,0.7).DE(240,42.0).DH(6.95,0.65).DK(46.5,3.5).DN(0.679,2.6).DQ(16.0,3.3).DT(30.0,0).DV(550).DX(330);
		boot.M.b.EL(boot.y.bd).Cy(395,80).DB(4.7,0.6).DE(240,50.0).DH(6.8,0.65).DK(47.5,3.0).DN(0.625,1.75).DQ(12.65,3.35).DT(30.0,0).DV(550).DX(335);
		boot.M.b.EL(boot.y.be).Cy(414,86).DB(6.95,0.55).DE(180,42.0).DH(7.1,0.6).DK(48.0,3.3).DN(0.658,3.84).DQ(12.5,4.0).DT(30.0,1.25).DV(125).DX(340);
		boot.M.b.EL(boot.y.bf).Cy(350,80).DB(5.5,0.55).DE(235,45.0).DH(7.0,0.65).DK(47.2,3.0).DN(0.665,2.8).DQ(12.0,3.5).DT(30.0,0).DV(550).DX(330);
		boot.M.b.EL(boot.y.bg).Cy(390,80).DB(4.6,0.6).DE(251,59.0).DH(6.9,0.65).DK(45.95,2.625).DN(0.625,2.11).DQ(11.0,3.5).DT(30.0,0).DV(480).DX(335);
		boot.M.b.EL(boot.y.bh).Cy(450,85).DB(6.3,0.8).DE(220,40.0).DH(7.25,0.5).DK(54.5,3.2).DN(0.672,3.0).DQ(15.5,3.5).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.bi).Cy(414,86).DB(7.0,0.7).DE(200,40.0).DH(6.15,0.45).DK(53.0,3.0).DN(0.658,3.1).DQ(13.0,3.4).DT(30.0,1.25).DV(175).DX(335);
		boot.M.b.EL(boot.y.bj).Cy(435,85).DB(7.45,0.75).DE(235,50.0).DH(7.0,0.7).DK(56.3,3.375).DN(0.638,1.2).DQ(17.0,3.5).DT(30.0,0).DV(125).DX(335);
		boot.M.b.EL(boot.y.bk).Cy(495,81).DB(425.0,0.75).DE(215,40.0).DH(6.5,0.7).DK(54.0,3.0).DN(0.651,2.75).DQ(16.5,3.3).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.bl).Cy(455,96).DB(7.5,0.75).DK(52.5,3.5).DN(0.625,2.9).DQ(19.0,2.7).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.bm).Cy(434,89).DB(7.25,0.85).DE(221,47.0).DH(6.45,0.45).DK(55.78,3.375).DN(0.651,2.05).DQ(16.0,3.6).DT(30.0,0).DV(125).DX(340);
		boot.M.b.EL(boot.y.bn).Cy(410,84).DB(5.5,0.7).DE(255,40.0).DH(6.75,0.7).DK(51.0,3.1).DN(0.625,2.9).DQ(15.0,3.2).DT(30.0,0).DV(525).DX(330);
		boot.M.b.EL(boot.y.bo).Cy(440,95).DB(8.0,0.75).DE(210,40.0).DH(6.5,0.6).DK(56.0,3.2).DN(0.67,2.5).DQ(16.0,4.0).DT(30.0,1.25).DV(175).DX(345);
		boot.M.b.EL(boot.y.bp).Cy(350,75).DB(4.5,0.55).DE(240,65.0).DH(7.0,0.65).DK(49.24,3.0).DN(0.625,1.21).DQ(7.0,3.0).DT(30.0,0).DV(550).DX(325);
		boot.M.b.EL(boot.y.ca).Cy(456,90).DB(7.5,0.65).DE(230,35.0).DH(7.0,0.65).DK(56.0,3.3).DN(0.665,3.2).DQ(15.0,3.75).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.cb).Cy(356,78).DB(4.5,0.55).DE(302,64.0).DH(6.9,0.6).DK(49.0,2.95).DN(0.625,2.61).DQ(9.0,3.8).DT(30.0,0).DV(475).DX(335);
		boot.M.b.EL(boot.y.cc).Cy(420,90).DB(7.0,0.7).DE(235,40.0).DH(6.0,0.45).DK(50.0,3.4).DN(0.658,2.5).DQ(14.0,3.0).DT(30.0,1.25).DV(175).DX(340);
		boot.M.b.EL(boot.y.cd).Cy(463,98).DB(7.45,0.55).DE(230,35.0).DH(6.4,0.7).DK(56.3,3.375).DN(0.638,3.4).DQ(18.0,3.5).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.ce).Cy(420,90).DB(6.0,0.8).DE(240,40.0).DH(7.0,0.7).DK(46.5,3.5).DN(0.658,3.0).DQ(12.5,3.5).DT(30.0,0).DV(125).DX(335);
		boot.M.b.EL(boot.y.cf).Cy(410,86).DB(4.7,0.55).DE(240,60.0).DH(6.8,0.65).DK(50.0,3.3).DN(0.625,2.3).DQ(15.0,3.5).DT(30.0,0).DV(425).DX(335);
		boot.M.b.EL(boot.y.cg).Cy(390,75).DB(5.5,0.55).DE(270,61.0).DH(6.5,0.6).DK(42.2,3.25).DN(0.625,2.11).DQ(11.0,3.5).DT(30.0,0).DV(450).DX(335);
		boot.M.b.EL(boot.y.ch).Cy(433,78).DB(6.95,0.5).DE(230,45.0).DH(6.9,0.6).DK(52.3,3.9).DN(0.638,3.7).DQ(14.0,3.2).DT(30.0,1.25).DV(125).DX(340);
		boot.M.b.EL(boot.y.ci).Cy(395,83).DB(6.95,0.55).DK(53.0,3.2).DN(0.658,2.74).DQ(14.75,4.0).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.cj).Cy(418,93).DB(7.0,0.75).DE(255,40.0).DH(6.9,0.525).DK(53.3,2.8).DN(0.638,2.5).DQ(17.0,3.5).DT(30.0,0.75).DV(125).DX(335);
		boot.M.b.EL(boot.y.ck).Cy(403,79).DB(4.65,0.65).DZ(200).Dv(50).DK(51.3,3.3).DN(0.69,3.4).DQ(14.0,3.75).DT(30.0,0).DV(550).DX(335);
		boot.M.b.EL(boot.y.cl).Cy(430,85).DB(6.25,0.75).DE(260,40.0).DH(6.75,0.5).DK(50.0,3.1).DN(0.665,2.7).DQ(15.0,3.0).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.cm).Cy(440,84).DB(5.0,0.55).DE(295,40.0).DH(7.5,0.7).DK(46.0,3.0).DN(0.665,2.65).DQ(13.0,3.53).DT(30.0,0).DV(500).DX(340);
		boot.M.b.EL(boot.y.cn).Cy(390,75).DB(4.5,0.55).DE(250,50.0).DH(6.9,0.6).DK(51.0,3.1).DN(0.625,1.4).DQ(12.0,3.5).DT(30.0,0).DV(525).DX(335);
		boot.M.b.EL(boot.y.co).Cy(428,85).DB(6.25,61.0).Dv(200).Dv(50).DK(55.8,3.2).DN(0.651,3.0).DQ(16.0,3.7).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.cp).Cy(430,87).DB(9.0,0.85).DE(235,40.0).DH(8.0,0.7).DK(55.0,3.0).DN(0.625,2.9).DQ(18.0,3.1).DT(30.0,1.25).DV(125).DX(335);
		boot.M.b.EL(boot.y.da).Cy(415,82).DB(6.0,0.72).DE(200,50.0).DH(6.0,0.6).DK(44.4,2.6).DN(0.625,2.2).DQ(9.0,3.7).DT(30.0,0).DV(550).DX(325);
		boot.M.b.EL(boot.y.db).Cy(345,79).DB(4.5,0.55).DE(250,50.0).DH(6.0,0.6).DK(50.0,3.3).DN(0.625,1.36).DQ(8.0,4.0).DT(30.0,0).DV(550).DX(340);
		boot.M.b.EL(boot.y.dc).Cy(423,90).DB(7.45,0.55).DE(215,40.0).DH(6.4,0.55).DK(56.3,3.375).DN(0.638,3.4).DQ(18.0,3.75).DT(30.0,1.25).DV(125).DX(335);
		boot.M.b.EL(boot.y.dd).Cy(380,80).DB(4.5,0.55).DE(250,45.0).DH(7.0,0.6).DK(51.66,3.0).DN(0.625,1.36).DQ(15.0,3.5).DT(30.0,0).DV(550).DX(340);
		boot.M.b.EL(boot.y.de).Cy(421,90).DB(7.25,0.85).DE(250,46.0).DH(6.45,0.45).DK(58.0,3.3).DN(0.694,2.13).DQ(18.0,4.0).DT(30.0,0).DV(125).DX(335);
		boot.M.b.EL(boot.y.df).Cy(444,86).DB(6.75,0.65).DE(199,36.0).DH(6.5,0.45).DK(55.12,3.1).DN(0.679,2.98).DQ(16.3,3.7).DT(30.0,1.25).DV(125).DX(355);
		boot.M.b.EL(boot.y.dg).Cy(435,85).DB(5.1,0.65).DE(212,38.0).DH(6.95,0.65).DK(46.5,3.0).DN(0.658,3.01).DQ(15.0,3.0).DT(30.0,0).DV(550).DX(325);
		boot.M.b.EL(boot.y.dh).Cy(421,80).DB(7.45,0.55).DK(51.7,3.5).DN(0.694,3.0).DQ(15.0,3.5).DT(30.0,1.25).DV(125).DX(340);
		boot.M.b.EL(boot.y.di).Cy(403,86).DB(4.7,0.6).DE(240,60.0).DH(6.8,0.65).DK(51.58,3.5).DN(0.579,1.53).DQ(15.0,3.8).DT(30.0,0).DV(425).DX(335);
		boot.M.b.EL(boot.y.dj).Cy(365,74).DB(4.5,45.0).DE(305,43.0).DH(6.9,0.6).DK(48.0,3.1).DN(0.644,2.6).DQ(9.0,4.0).DT(30.0,0).DV(550).DX(330);
		boot.M.b.EL(boot.y.dk).Cy(410,90).DB(7.5,0.9).DE(200,45.0).DH(6.6,0.5).DK(53.3,3.5).DN(0.638,3.48).DQ(15.0,3.5).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.dl).Cy(432,86).DB(7.45,0.55).DE(200,50.0).DH(7.45,0.7).DK(52.0,3.3).DN(0.613,0.98).DQ(12.0,3.25).DT(30.0,1.25).DV(175).DX(325);
		boot.M.b.EL(boot.y.dm).Cy(370,90).DB(5.0,0.6).DE(220,45.0).DH(7.0,0.5).DK(49.0,3.5).DN(0.672,3.22).DQ(11.0,3.5).DT(30.0,10.75).DV(525).DX(335);
		boot.M.b.EL(boot.y.dn).Cy(430,85).DB(7.0,0.75).DE(215,35.0).DH(6.0,0.45).DK(54.0,3.1).DN(0.668,2.7).DQ(17.0,3.5).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.dp).Cy(437,108).DB(7.05,0.8).DE(213,42.0).DH(6.6,0.5).DK(51.6,3.4).DN(0.625,2.25).DQ(16.5,3.5).DT(30.0,1.25).DV(125).DX(340);
		boot.M.b.EL(boot.y.ea).Cy(441,93).DB(7.0,0.9).DE(225,45.0).DH(6.5,0.575).DK(54.1,3.5).DN(0.694,2.7).DQ(17.0,3.0).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.eb).Cy(385,79).DB(5.95,0.55).DE(250,50.0).DH(7.0,0.5).DK(44.0,2.6).DN(0.658,3.5).DQ(8.0,3.0).DT(30.0,0).DV(525).DX(325);
		boot.M.b.EL(boot.y.ec).Cy(433,87).DB(6.75,0.65).DE(210,34.0).DH(6.6,0.45).DK(50.7,2.9).DN(0.679,2.95).DQ(17.1,3.9).DT(30.0,1.25).DV(155).DX(355);
		boot.M.b.EL(boot.y.ed).Cy(423,81).DB(7.45,0.55).DE(185,30.0).DH(6.4,0.45).DK(56.3,3.375).DN(0.638,3.35).DQ(18.0,4.0).DT(30.0,0).DV(125).DX(345);
		boot.M.b.EL(boot.y.ee).Cy(420,86).DB(8.0,0.55).DE(255,33.0).DH(4.5,0.3).DK(50.0,3.5).DN(0.625,2.22).DQ(21.0,3.8).DT(30.0,1.25).DV(125).DX(335);
		boot.M.b.EL(boot.y.ef).Cy(426,87).DB(6.7,0.75).DK(53.12,3.1).DN(0.665,2.65).DQ(15.2,3.8).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.eg).Cy(435,85).DB(4.0,0.4).DK(55.0,3.0).DN(0.679,2.85).DQ(16.0,3.5).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.eh).Cy(414,86).DB(10.4,0.9).DK(54.0,2.75).DN(0.625,3.5).DQ(15.0,3.1).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.ei).Cy(450,80).DB(7.0,0.7).DK(55.32,3.2).DN(0.644,1.85).DQ(16.0,3.5).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.ej).Cy(360,86).DB(4.35,0.55).DE(250,55.0).DH(7.0,0.6).DK(52.0,3.0).DN(0.625,2.11).DQ(11.0,3.9).DT(30.0,0).DV(550).DX(335);
		boot.M.b.EL(boot.y.ek).Cy(450,85).DB(7.35,0.85).DE(220,40.0).DH(6.45,0.45).DK(54.0,3.4).DN(0.67,1.45).DQ(20.5,3.5).DT(30.0,1.25).DV(125).DX(340);
		boot.M.b.EL(boot.y.el).Cy(441,84).DB(7.45,0.55).DE(270,40.0).DH(6.4,0.45).DK(51.7,3.5).DN(0.694,3.0).DQ(15.0,3.5).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.em).Cy(428,85).DB(7.45,0.55).DZ(200).Dv(50).DK(54.5,3.375).DN(0.651,3.4).DQ(15.0,4.0).DT(30.0,0).DV(125).DX(335);
		boot.M.b.EL(boot.y.en).Cy(435,95).DB(7.2,0.8).DK(54.5,3.4).DN(0.658,3.4).DQ(17.6,3.4).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.eo).Cy(405,82).DB(7.1,0.55).DE(215,45.0).DH(6.6,0.55).DK(56.65,3.375).DN(0.613,1.81).DQ(18.0,3.5).DT(30.0,0).DV(125).DX(345);
		boot.M.b.EL(boot.y.ep).Cy(403,104).DB(7.9,0.95).DE(240,40.0).DH(6.3,0.4).DK(55.52,3.1875).DN(0.625,1.63).DQ(17.75,3.25).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.fa).Cy(378,82).DB(4.25,0.55).DE(203,43.0).DH(6.5,0.5).DK(49.0,2.9).DN(0.658,3.28).DQ(12.75,3.25).DT(30.0,0).DV(500).DX(335);
		boot.M.b.EL(boot.y.fb).Cy(440,96).DB(7.5,0.85).DE(205,40.0).DH(6.45,0.45).DK(54.1,4.2).DN(0.625,2.1).DQ(19.0,3.8).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.fc).Cy(340,70).DB(4.5,0.55).DE(265,45.0).DH(7.0,0.65).DK(47.0,3.0).DN(0.644,2.3).DQ(6.0,3.3).DT(30.0,0).DV(550).DX(330);
		boot.M.b.EL(boot.y.fd).Cy(375,71).DB(4.5,0.55).DE(240,60.0).DH(6.8,0.65).DK(48.8,3.0).DN(0.625,2.14).DQ(7.4,3.8).DT(30.0,0).DV(550).DX(335);
		boot.M.b.EL(boot.y.fe).Cy(385,78).DB(6.75,0.65).DE(240,50.0).DH(6.8,0.65).DK(49.0,3.0).DN(0.625,2.11).DQ(12.0,4.0).DT(30.0,0).DV(500).DX(335);
		boot.M.b.EL(boot.y.ff).Cy(380,78).DB(5.5,0.6).DE(250,50.0).DH(6.9,0.6).DK(51.0,2.9).DN(0.625,2.0).DQ(15.0,3.4).DT(30.0,0).DV(550).DX(330);
		boot.M.b.EL(boot.y.fg).Cy(440,85).DB(7.25,0.75).DE(260,40.0).DH(6.75,0.5).DK(50.0,3.1).DN(0.668,2.7).DQ(17.0,3.5).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.fh).Cy(468,90).DB(7.1,0.5).DE(255,56.0).DH(4.1,0.4).DK(58.0,3.5).DN(0.625,2.02).DQ(16.5,3.2).DT(30.0,1.25).DV(125).DX(340);
		boot.M.b.EL(boot.y.fi).Cy(383,82).DB(4.65,0.65).DE(200,40.0).DH(6.45,0.45).DK(44.5,3.0).DN(0.69,3.38).DQ(14.0,3.75).DT(30.0,0).DV(500).DX(330);
		boot.M.b.EL(boot.y.fj).Cy(415,82).DB(5.1,0.65).DE(193,32.0).DH(6.45,0.45).DK(46.5,3.0).DN(0.658,3.01).DQ(15.0,3.0).DT(30.0,0).DV(550).DX(325);
		boot.M.b.EL(boot.y.fk).Cy(455,96).DB(8.0,0.85).DE(206,45.0).DH(6.9,0.6).DK(54.66,3.0).DN(0.672,2.9).DQ(19.0,2.7).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.fl).Cy(461,98).DB(7.9,0.9).DK(56.0,3.2).DN(0.644,2.9).DQ(14.9,3.1).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.fm).Cy(384,82).DB(4.5,0.6).DE(202,38.0).DH(6.5,0.5).DK(46.61,3.3).DN(0.651,3.22).DQ(111.25,3.15).DT(30.0,0).DV(525).DX(330);
		boot.M.b.EL(boot.y.fn).Cy(389,81).DB(5.0,0.6).DE(220,40.0).DH(6.5,0.45).DK(49.0,3.0).DN(0.679,3.38).DQ(14.0,3.0).DT(30.0,0).DV(550).DX(330);
		boot.M.b.EL(boot.y.fo).Cy(427,99).DB(7.45,0.75).DE(220,30.0).DH(6.4,0.45).DK(52.91,3.2).DN(0.658,2.67).DQ(14.75,4.0).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.fp).Cy(437,89).DB(5.5,0.6).DE(220,55.0).DH(7.5,0.65).DK(48.0,3.6).DN(0.644,2.9).DQ(15.0,3.3).DT(30.0,0).DV(425).DX(335);
		boot.M.b.EL(boot.y.ga).Cy(400,82).DB(4.5,0.55).DE(250,36.0).DH(6.5,0.5).DK(46.0,3.0).DN(0.658,2.65).DQ(13.5,3.4).DT(30.0,0).DV(575).DX(335);
		boot.M.b.EL(boot.y.gb).Cy(359,83).DB(4.5,0.55).DE(173,27.0).DH(6.3,0.4).DK(50.0,3.25).DN(0.658,3.1).DQ(9.3,3.4).DT(30.0,0).DV(550).DX(330);
		boot.M.b.EL(boot.y.gc).Cy(355,82).DB(4.5,0.55).DE(250,55.0).DH(6.9,0.6).DK(48.3,2.625).DN(0.625,2.24).DQ(12.25,3.75).DT(30.0,0).DV(525).DX(340);
		boot.M.b.EL(boot.y.gd).Cy(440,85).DB(7.5,0.9).DE(220,45.0).DH(7.0,0.65).DK(55.0,3.5).DN(0.643,2.5).DQ(16.0,3.5).DT(30.0,1.25).DV(125).DX(350);
		boot.M.b.EL(boot.y.ge).Cy(385,78).DB(6.75,0.65).DE(240,50.0).DH(6.9,0.45).DK(49.0,3.0).DN(0.625,2.11).DQ(12.0,4.0).DT(30.0,0).DV(525).DX(335);
		boot.M.b.EL(boot.y.gf).Cy(400,85).DB(6.0,0.6).DK(45.0,3.0).DN(0.6258,2.0).DQ(12.0,3.5).DT(30.0,0).DV(450).DX(335);
		boot.M.b.EL(boot.y.gg).Cy(440,86).DB(7.0,0.65).DE(220,30.0).DH(7.0,0.65).DK(54.0,3.3).DN(0.625,2.9).DQ(16.5,3.5).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.gh).Cy(428,98).DB(7.05,0.8).DE(190,30.0).DH(7.1,0.6).DK(56.76,3.375).DN(0.679,2.88).DQ(16.0,3.5).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.gi).Cy(435,85).DB(5.1,0.65).DE(202,38.0).DH(6.9,0.65).DK(54.0,3.2).DN(0.658,3.0).DQ(15.0,3.5).DT(30.0,1.25).DV(175).DX(345);
		boot.M.b.EL(boot.y.gj).Cy(380,80).DB(5.0,0.55).DE(250,45.0).DH(8.0,0.6).DK(52.0,3.0).DN(0.625,1.36).DQ(12.6,3.4).DT(30.0,0).DV(550).DX(340);
		boot.M.b.EL(boot.y.gk).Cy(445,87).DB(7.0,0.7).DE(213,31.0).DH(6.6,0.45).DK(52.0,3.3).DN(0.672,2.7).DQ(16.2,3.7).DT(30.0,1.25).DV(175).DX(345);
		boot.M.b.EL(boot.y.gl).Cy(421,85).DB(8.5,0.7).DE(235,35.0).DH(6.5,0.45).DK(51.5,3.5).DN(0.625,3.0).DQ(18.0,3.6).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.gm).Cy(445,85).DB(6.0,0.65).DZ(20).Dv(50).DK(48.6,3.4).DN(0.658,3.1).DQ(17.5,3.5).DT(30.0,1.25).DV(125).DX(345);
		boot.M.b.EL(boot.y.gn).Cy(390,80).DB(5.25,0.6).DE(250,50.0).DH(6.75,0.6).DK(54.0,3.1).DN(0.656,1.7).DQ(12.0,3.3).DT(30.0,0).DV(575).DX(330);
		boot.M.b.EL(boot.y.go).Cy(380,71).DB(4.6,0.5).DE(260,60.0).DH(6.95,0.65).DK(48.6,3.0).DN(0.625,2.13).DQ(6.75,3.8).DT(30.0,0).DV(600).DX(335);
		boot.M.b.EL(boot.y.gp).Cy(355,74).DB(4.85,0.5).DE(250,50.0).DH(7.1,0.75).DK(50.0,3.2).DN(0.625,1.8).DQ(11.0,3.0).DT(30.0,0).DV(575).DX(325);
		boot.M.c=new boot.M(1520,2012,12,3,"Preseason 3",boot.M.b,0);
		boot.M.c.EH("Shard of True Ice");
		boot.M.c.EH("Liandry's Torment");
		boot.M.c.EH("Haunting Guise");
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
	EH:function(A,B){
		B=new boot.BV(A,this,0);
		this.e.CJ(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	EL:function(A){
		A.hb=new boot.BB(this,A.hb,0);
		return A.hb;
	}
});

boot.define("N","",{
},{
	"$":[["BW",{
		FR:function() {return RUNTIME;}
	}]]
});

boot.define("B","C",{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B,C){
		this.D("Champion/*",boot.I.$);
		this.D("",boot.J.$);
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
		C=boot.B.$;
		console.log(C);
		console.log(C.J(boot.N.$).K());
		console.log(C.L(boot.N.$));
	},
	// teemowork.Teemowork#test()
	M:function(){
		console.log("called");
	}
},{
	"$":[["N",{
		N:function() {return true;},O:function() {return 10;},P:function() {return 10;},K:function() {return 4;},Q:function() {return 10;},R:function() {return 10.0;},S:function() {return 10.0;}
	}]],"M":[["O",{
	}]]
});

try {new boot.B(0).A();} catch(e) {console.log(e)}