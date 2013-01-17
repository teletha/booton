boot.define("R","",{
	
	// booton.translator.js.JSAnnotatedElement#<init>(java.lang.String, booton.translator.js.NativeObject)
	$0:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.js.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	K:function(A){
		return this.T(A)!=null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotation(java.lang.Class)
	T:function(A,B,C,D){
		if(this.b==null){
		}else{
			B=this.b[this.a];
			if(B==null){
			}else{
				C=0;
				l6:for (;
				C<B.length;
				++C) {
					D=B[C];
					if(D[0].equals(A.U())==0){
					}else{
						return D[1];
					}
				}
			}
		}return null;
	}
});

boot.define("O","R",{
	
	// booton.translator.js.JSConstructor#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject)
	$0:function(A,B,C){
		boot.R.prototype.$0.call(this,A,C);
		this.c=B;
	}
});

boot.define("A","R",{
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject)
	$0:function(A,B,C){
		boot.R.prototype.$0.call(this,A,C);
		this.c=B;
	},
	// booton.translator.js.JSClass#isAnnotationPresent(java.lang.Class)
	K:function(A){
		return this.T(A)!=null;
	},
	// booton.translator.js.JSClass#getAnnotation(java.lang.Class)
	T:function(A,B,C,D){
		if(this.b==null){
		}else{
			B=this.b["$"];
			if(B==null){
			}else{
				C=0;
				l6:for (;
				C<B.length;
				++C) {
					D=B[C];
					if(D[0].equals(A.U())==0){
					}else{
						return D[1];
					}
				}
			}
		}return null;
	},
	// booton.translator.js.JSClass#getConstructors()
	J:function(A,B,C,D){
		A=[];
		B=this.c.keys();
		C=0;
		l4:while (C<B.length) {
			D=B[C];
			if(D.startsWith("$")==0){
			}else{
				A.push(new boot.O(D,this.c[D],this.b,0));
			}++C;
			continue l4;
		}return A;
	},
	// booton.translator.js.JSClass#getName()
	V:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	U:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	W:function(){
		return null;
	},
	// booton.translator.js.JSClass#getConstructor()
	X:function(){
		return null;
	}
});

boot.define("V","",{
});

boot.define("T","",{
});

boot.define("U","",{
	
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	z:function(){
		return this.BA()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	BB:function(A,B,C,D){
		B=0;
		D=A.Z();
		l2:while (D.x()!=0) {
			C=D.u();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BC:function(A,B,C,D){
		B=0;
		D=this.Z();
		l2:while (D.x()!=0) {
			C=D.u();
			if(A.BD(C)!=0){
			}else{
				B=this.BE(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	BF:function(A,B,C,D){
		B=0;
		D=A.Z();
		l2:while (D.x()!=0) {
			C=D.u();
			if(this.BE(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BG:function(A,B,C){
		C=A.Z();
		l1:while (C.x()!=0) {
			B=C.u();
			if(this.BD(B)!=0){
			}else{
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BH:function(){
		return this.BI(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BI:function(A,B,C,D,E){
		B=this.BA();
		if(A.length>=B){
		}else{
			A=[];
		}C=this.Z();
		D=0;
		l6:while (C.x()!=0) {
			E=C.u();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("W","",{
	
	// js.util.ArrayList$View#<init>(js.util.ArrayList)
	$1:function(A){
		this.a=A;;
		this.b=0;
	},
	// js.util.ArrayList$View#hasNext()
	x:function(){
		return this.b<boot.S.BV(this.a).length;
	},
	// js.util.ArrayList$View#next()
	u:function(){
		return boot.S.BV(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	BW:function(){
		if(this.b<=0){
		}else{
			boot.S.BV(this.a).splice(this.b-1,1)[0];
		}
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, js.util.ArrayList$View)
	$0:function(A,B){
		boot.W.prototype.$1.call(this,A);
	}
});

boot.define("Z","",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.Z.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.Z.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.Z.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.Z.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	BX:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	BY:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	BZ:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	Bu:function(){
		console.log(this.a);
	}
});

boot.define("X","Z",{
	
	// java.lang.Error#<init>()
	$0:function(){
		boot.Z.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$1:function(A){
		boot.Z.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.Z.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$3:function(A){
		boot.Z.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.Z.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("v","Z",{
	
	// java.lang.Exception#<init>()
	$0:function(){
		boot.Z.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.Z.prototype.$2.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.Z.prototype.$1.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.Z.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.Z.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("u","v",{
	
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.v.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.v.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.v.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.v.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.v.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("Y","u",{
	
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.u.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.u.prototype.$1.call(this,A);
	}
});

boot.define("S","U",{
	
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.U.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#size()
	BA:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BD:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	Z:function(){
		return new boot.W(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BE:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	BJ:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BK:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	BL:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	BM:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	BN:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	BO:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	BP:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	BQ:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	BR:function(){
		throw new boot.X(0);
	},
	// js.util.ArrayList#listIterator(int)
	BS:function(A){
		throw new boot.X(0);
	},
	// js.util.ArrayList#subList(int, int)
	BT:function(A,B){
		throw new boot.X(0);
	},
	// js.util.ArrayList#checkRange(int)
	BU:function(A){
		if(A>=0){
			if(this.BA()>A){
				return;
			}else{
				throw new boot.Y("Index is overflowed. Size: "+this.BA()+"  Index: "+A,0);
			}
		}else{
			throw new boot.Y("Negative index is unacceptable. Size: "+this.BA()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_BV:function(A){
		return A.a;
	}
});

boot.define("w","",{
	
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
	Bv:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.S(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.b.newInstance(0,C.BH());
			} catch ($) {
				if ($ instanceof boot.v) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.Application$Route#access$0(js.Application$Route, java.lang.String)
	_v:function(A,B){
		return A.Bv(B);
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

boot.define("z","",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	x:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	Bz:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	BW:function(){
	},
	// booton.translator.web.jQuery$1#next()
	u:function(){
		return this.Bz();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	Bw:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	Bx:function(A){
		return this.Bw("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	Z:function(){
		return new boot.z(this,0);
	}
});
boot.define("E","",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.S(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.Y(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	Y:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.Z();
		l3:while (C.x()!=0) {
			B=C.u();
			D=boot.F.v(B,A);
			if(D==null){
			}else{
				E=$(document.createDocumentFragment());
				D.w(E);
				$("#Content").empty().append(E);
				return;
			}continue l3;
		}
	},
	// js.Application$Router#dispatch(js.Page)
	y:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.w(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.Y(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_E:function(A){
		return A.a;
	}
},{
	"y":[["Q",{
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

boot.define("BO","U",{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.U.prototype.$0.call(this);
	}
});

boot.define("BP","",{
	
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray)
	$1:function(A,B){
		this.a=A;;
		this.b=0;
		this.c=B;
	},
	// js.util.HashSet$View#hasNext()
	x:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	u:function(){
		this.d=boot.BI.Cv(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	BW:function(){
		if(this.b<=0){
		}else{
			this.a.BE(this.d);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, booton.translator.js.NativeArray, js.util.HashSet$View)
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
	BA:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BD:function(A){
		return this.Cu(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.Cu(A);
		if(B in this.b==0){
			this.a=this.a+1;
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BE:function(A,B){
		B=this.Cu(A);
		if(B in this.b!=0){
			this.a=this.a-1;
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BK:function(){
		this.a=0;
		this.b=[];
	},
	// js.util.HashSet#iterator()
	Z:function(){
		return new boot.BP(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	Cu:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CQ:function(A){
		return this.b[this.Cu(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CS:function(A,B,C){
		B=null;
		C=this.Cu(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	CU:function(A,B,C){
		B=null;
		C=this.Cu(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_Cv:function(A){
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
	CX:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CR:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	Cw:function(A,B){
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
	x:function(){
		return this.b.x();
	},
	// js.util.HashMap$View#next()
	u:function(A){
		A=this.b.u();
		if(this.c==0){
			return A.CR();
		}else{
			return A.CX();
		}
	},
	// js.util.HashMap$View#remove()
	BW:function(){
		this.b.BW();
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
	BA:function(){
		return boot.BG.CZ(this.a).BA();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BD:function(A){
		return boot.BG.CZ(this.a).BD(A);
	},
	// js.util.HashMap$Keys#iterator()
	Z:function(){
		return new boot.BQ(this.a,boot.BG.CZ(this.a).Z(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BE:function(A){
		return boot.BG.CZ(this.a).BE(A);
	},
	// js.util.HashMap$Keys#clear()
	BK:function(){
		boot.BG.CZ(this.a).BK();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.BM.prototype.$1.call(this,A);
	}
});

boot.define("BN","U",{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.U.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BA:function(){
		return boot.BG.CZ(this.a).BA();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BD:function(A){
		return this.a.CP(A);
	},
	// js.util.HashMap$Values#iterator()
	Z:function(){
		return new boot.BQ(this.a,boot.BG.CZ(this.a).Z(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BE:function(A,B,C){
		B=this.Z();
		l2:while (B.x()!=0) {
			C=B.u();
			if(C!=A){
			}else{
				B.BW();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BK:function(){
		boot.BG.CZ(this.a).BK();
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
	BA:function(){
		return this.a.BA();
	},
	// js.util.HashMap#isEmpty()
	z:function(){
		return this.a.z();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	CO:function(A){
		return this.a.BD(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CP:function(A,B,C){
		C=this.CN().Z();
		l1:while (C.x()!=0) {
			B=C.u();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CL:function(A,B){
		B=this.a.CQ(A);
		return (B==null?null:B.CR());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CK:function(A,B,C){
		C=this.a.CS(new boot.BK(A,B,null,0));
		if(C!=null){
			return C.CR();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	CT:function(A,B){
		B=this.a.CU(A);
		if(B!=null){
			return B.CR();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	CV:function(A,B,C){
		C=A.CW().Z();
		l1:for (;
		C.x()!=0;
		this.CK(B.CX(),B.CR())) {
			B=C.u();
		}
	},
	// js.util.HashMap#clear()
	BK:function(){
		this.a.BK();
	},
	// js.util.HashMap#keySet()
	CY:function(){
		return new boot.BM(this,null,0);
	},
	// js.util.HashMap#values()
	CN:function(){
		return new boot.BN(this,null,0);
	},
	// js.util.HashMap#entrySet()
	CW:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_CZ:function(A){
		return A.a;
	}
});

boot.define("BB","",{
	
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.BB.b=new boot.BG(0);
		boot.BB.c=new boot.BB("Ahri",0);
		boot.BB.d=new boot.BB("Akali",0);
		boot.BB.e=new boot.BB("Alistar",0);
		boot.BB.f=new boot.BB("Amumu",0);
		boot.BB.g=new boot.BB("Anivia",0);
		boot.BB.h=new boot.BB("Annie",0);
		boot.BB.i=new boot.BB("Ashe",0);
		boot.BB.j=new boot.BB("Blitzcrank",0);
		boot.BB.k=new boot.BB("Brand",0);
		boot.BB.l=new boot.BB("Caitlyn",0);
		boot.BB.m=new boot.BB("Cassiopeia",0);
		boot.BB.n=new boot.BB("Chogath",0);
		boot.BB.o=new boot.BB("Corki",0);
		boot.BB.p=new boot.BB("Darius",0);
		boot.BB.ba=new boot.BB("Diana",0);
		boot.BB.bb=new boot.BB("Dr.Mundo",0);
		boot.BB.bc=new boot.BB("Draven",0);
		boot.BB.bd=new boot.BB("Elise",0);
		boot.BB.be=new boot.BB("Evelynn",0);
		boot.BB.bf=new boot.BB("Ezreal",0);
		boot.BB.bg=new boot.BB("Fiddlesticks",0);
		boot.BB.bh=new boot.BB("Fiora",0);
		boot.BB.bi=new boot.BB("Fizz",0);
		boot.BB.bj=new boot.BB("Galio",0);
		boot.BB.bk=new boot.BB("Gangplank",0);
		boot.BB.bl=new boot.BB("Garen",0);
		boot.BB.bm=new boot.BB("Gragas",0);
		boot.BB.bn=new boot.BB("Graves",0);
		boot.BB.bo=new boot.BB("Hecarim",0);
		boot.BB.bp=new boot.BB("Heimerdinger",0);
		boot.BB.ca=new boot.BB("Irelia",0);
		boot.BB.cb=new boot.BB("Janna",0);
		boot.BB.cc=new boot.BB("Jarvan IV",0);
		boot.BB.cd=new boot.BB("Jax",0);
		boot.BB.ce=new boot.BB("Jayce",0);
		boot.BB.cf=new boot.BB("Karma",0);
		boot.BB.cg=new boot.BB("Karthus",0);
		boot.BB.ch=new boot.BB("Kassadin",0);
		boot.BB.ci=new boot.BB("Katarina",0);
		boot.BB.cj=new boot.BB("Kayle",0);
		boot.BB.ck=new boot.BB("Kennen",0);
		boot.BB.cl=new boot.BB("Kha'zix",0);
		boot.BB.cm=new boot.BB("Kog'maw",0);
		boot.BB.cn=new boot.BB("LeBlanc",0);
		boot.BB.co=new boot.BB("Lee Sin",0);
		boot.BB.cp=new boot.BB("Leona",0);
		boot.BB.da=new boot.BB("Lulu",0);
		boot.BB.db=new boot.BB("Lux",0);
		boot.BB.dc=new boot.BB("Malphite",0);
		boot.BB.dd=new boot.BB("Malzahar",0);
		boot.BB.de=new boot.BB("Maokai",0);
		boot.BB.df=new boot.BB("Master Yi",0);
		boot.BB.dg=new boot.BB("Miss Fortune",0);
		boot.BB.dh=new boot.BB("Mordekaiser",0);
		boot.BB.di=new boot.BB("Morgana",0);
		boot.BB.dj=new boot.BB("Nami",0);
		boot.BB.dk=new boot.BB("Nasus",0);
		boot.BB.dl=new boot.BB("Nautilus",0);
		boot.BB.dm=new boot.BB("Nidalee",0);
		boot.BB.dn=new boot.BB("Nocturne",0);
		boot.BB.dp=new boot.BB("Nunu",0);
		boot.BB.ea=new boot.BB("Olaf",0);
		boot.BB.eb=new boot.BB("Orianna",0);
		boot.BB.ec=new boot.BB("Pantheon",0);
		boot.BB.ed=new boot.BB("Poppy",0);
		boot.BB.ee=new boot.BB("Rammus",0);
		boot.BB.ef=new boot.BB("Renekton",0);
		boot.BB.eg=new boot.BB("Rengar",0);
		boot.BB.eh=new boot.BB("Riven",0);
		boot.BB.ei=new boot.BB("Rumble",0);
		boot.BB.ej=new boot.BB("Ryze",0);
		boot.BB.ek=new boot.BB("Sejuani",0);
		boot.BB.el=new boot.BB("Shaco",0);
		boot.BB.em=new boot.BB("Shen",0);
		boot.BB.en=new boot.BB("Shyvana",0);
		boot.BB.eo=new boot.BB("Singed",0);
		boot.BB.ep=new boot.BB("Sion",0);
		boot.BB.fa=new boot.BB("Sivir",0);
		boot.BB.fb=new boot.BB("Skarner",0);
		boot.BB.fc=new boot.BB("Sona",0);
		boot.BB.fd=new boot.BB("Soraka",0);
		boot.BB.fe=new boot.BB("Swain",0);
		boot.BB.ff=new boot.BB("Syndra",0);
		boot.BB.fg=new boot.BB("Talon",0);
		boot.BB.fh=new boot.BB("Taric",0);
		boot.BB.fi=new boot.BB("Teemo",0);
		boot.BB.fj=new boot.BB("Tristana",0);
		boot.BB.fk=new boot.BB("Trundle",0);
		boot.BB.fl=new boot.BB("Tryndamere",0);
		boot.BB.fm=new boot.BB("Twisted Fate",0);
		boot.BB.fn=new boot.BB("Twitch",0);
		boot.BB.fo=new boot.BB("Udyr",0);
		boot.BB.fp=new boot.BB("Urgot",0);
		boot.BB.ga=new boot.BB("Varus",0);
		boot.BB.gb=new boot.BB("Vayne",0);
		boot.BB.gc=new boot.BB("Veigar",0);
		boot.BB.gd=new boot.BB("Vi",0);
		boot.BB.ge=new boot.BB("Viktor",0);
		boot.BB.gf=new boot.BB("Vladimir",0);
		boot.BB.gg=new boot.BB("Volibear",0);
		boot.BB.gh=new boot.BB("Warwick",0);
		boot.BB.gi=new boot.BB("Wukong",0);
		boot.BB.gj=new boot.BB("Xerath",0);
		boot.BB.gk=new boot.BB("Xin Zhao",0);
		boot.BB.gl=new boot.BB("Yorick",0);
		boot.BB.gm=new boot.BB("Zed",0);
		boot.BB.gn=new boot.BB("Ziggs",0);
		boot.BB.go=new boot.BB("Zilean",0);
		boot.BB.gp=new boot.BB("Zyra",0);
	},
	// teemowork.model.Champion#<init>(java.lang.String)
	$0:function(A){
		this.a=A;
		this.ha=this.CJ().toLowerCase();
		boot.BB.b.CK(A,this);
	},
	// teemowork.model.Champion#getStatus()
	CE:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CJ:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	CB:function(){
		return "src/main/resources/teemowork/splash/"+this.CJ()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	CC:function(){
		return "src/main/resources/teemowork/icon/"+this.CJ()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_CA:function(A){
		return boot.BB.b.CL(A);
	},
	// teemowork.model.Champion#getAll()
	_CM:function(){
		return boot.BB.b.CN();
	}
});

boot.defineNative("Event",{
	
	// booton.translator.web.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("BC","",{
	
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.I.CH(this.a,boot.I.CG(this.a)+1);
	}
});

boot.define("BD","",{
	
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.I.CH(this.a,boot.I.CG(this.a)-1);
	}
});

boot.define("BE","",{
	
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
	Cx:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	Cy:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	Cz:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	DA:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DB:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	DC:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DD:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DE:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	DF:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DG:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DH:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	DI:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DJ:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DK:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	DL:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DM:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DN:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	DO:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DP:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DQ:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DR:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DS:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DT:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	DU:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	DV:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	DW:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	DX:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	DY:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	DZ:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	Du:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	Dv:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	Dw:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	CF:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	Dx:function(A){
		return this.g+this.h*A;
	}
});

boot.define("I","H",{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.I.prototype.$1.call(this,boot.BB.CA(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.H.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.X(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	w:function(A,B,C){
		B=A.Bx("a").css("background-image","url('"+this.a.CB()+"')").Bx("b");
		C=B.Bx("c").css("background-image","url("+this.a.CC()+")").click(new boot.BC(this,0)).on("contextmenu",new boot.BD(this,0));
		this.b=C.Bx("d");
		this.c=B.Bx("e").text("Health").Bx("f");
		this.CD(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	CD:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.CE();
			this.c.text(""+B.CF(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	H:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_CG:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CH:function(A,B){
		A.CD(B);
	}
},{
	"$0":[["N",{
		CI:function() {return "Champion/*";}
	}]],"e":[["BF",{
	}]]
});

boot.define("BU","",{
	
	// js.ui.UI#<init>()
	$0:function(){
		boot.BU.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("BV","",{
	
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, booton.translator.web.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.BT.EC(this.a).CW().Z();
		l2:while (D.x()!=0) {
			C=D.u();
			if(this.a.EB(C.CX()).toLowerCase().indexOf(B) != -1==0){
				C.CR().addClass("j");
				continue l2;
			}else{
				C.CR().removeClass("j");
				continue l2;
			}
		}
	}
});

boot.define("BW","",{
	
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.a.ED(this.b);
	}
});

boot.define("BT","BU",{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BU.prototype.$0.call(this);
		this.b=new boot.BG(0);
		this.c=this.Dz();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	Dy:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BV(this,B,0));
		D=this.c.Z();
		l6:for (;
		D.x()!=0;
		this.b.CK(C,E)) {
			C=D.u();
			E=this.a.Bx("h").css("background-image","url("+this.EA(C)+")");
			E.Bw("span").addClass("i").text(this.EB(C));
			E.click(new boot.BW(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_EC:function(A){
		return A.b;
	}
});

boot.define("BS","BT",{
	
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.BT.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	Dz:function(){
		return boot.BB.CM();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	EE:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	EG:function(A){
		return A.CC();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	EH:function(A){
		boot.C.G(new boot.I(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	EB:function(A){
		return this.EE(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	EA:function(A){
		return this.EG(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	ED:function(A){
		this.EH(A);
	}
});

boot.define("J","H",{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.H.prototype.$0.call(this);
		this.a=new boot.BS(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	w:function(A){
		this.a.Dy(A);
	},
	// teemowork.ChampionSelect#getPageId()
	H:function(){
		return "";
	}
},{
	"$":[["N",{
		CI:function() {return "";}
	}]]
});

boot.define("L","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.Bw("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	I:function(A,B,C){
		C=this.b.Bw("li").addClass("o");
		C.Bw("a").addClass("m").attr("href",B).text(A);
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
		C=this.a.Bw("li").addClass("l");
		C.Bw("a").addClass("m").attr("href",B).text(A);
		return new boot.L(this,C,null,0);
	}
});

boot.define("BX","",{
	
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.BX.a=new boot.BG(0);
	},
	// teemowork.model.Item#<init>(java.lang.String, teemowork.model.Patch)
	$0:function(A,B,C){
		this.b=A;
		this.c=B;
		C=boot.BX.a.CL(A);
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
		boot.BX.a.CK(A,this);
	},
	// teemowork.model.Item#cost()
	EO:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	EJ:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	EP:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	EQ:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	ER:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	ES:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	ET:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	EU:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	EV:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	EW:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	EX:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	EY:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	EZ:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	Eu:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	Ev:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	EL:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	Ew:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	Ex:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	Ey:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	Ez:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	FA:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	FB:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	FC:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	FD:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	FE:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	EK:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	FF:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	FG:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FH:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FI:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FJ:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FK:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FL:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FM:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FN:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FO:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FP:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FQ:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FR:function(A){
		return boot.BX.a.CL(A);
	},
	// teemowork.model.Item#getAll()
	_CM:function(){
		return boot.BX.a.CN();
	}
});

boot.define("M","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.M.b=new boot.M(1510,2012,11,13,"Initial",null,0);
		boot.M.b.EI("Ruby Crystal").EJ(475).EK(180);
		boot.M.b.EI("Haunting Guise").EK(200).EL(25);
		boot.M.b.EM(boot.BB.c).Cz(380,80).DC(5.5,0.6).DF(230,50.0).DI(6.25,0.6).DL(50.0,3.0).DO(0.668,2.0).DR(10.0,3.5).DU(30.0,0).DW(550).DY(330);
		boot.M.b.EM(boot.BB.d).Cz(445,85).DC(7.25,0.65).Du(200).Dw(50).DL(53.0,3.2).DO(0.694,3.1).DR(16.5,3.5).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.e).Cz(442,102).DC(7.25,0.85).DF(215,38.0).DI(6.45,0.45).DL(55.03,3.62).DO(0.625,3.62).DR(14.5,3.5).DU(30.0,1.25).DW(125).DY(325);
		boot.M.b.EM(boot.BB.f).Cz(472,84).DC(7.45,0.85).DF(220,40.0).DI(6.5,0.525).DL(47.0,3.8).DO(0.638,2.18).DR(18.0,3.3).DU(30.0,1.25).DW(125).DY(335);
		boot.M.b.EM(boot.BB.g).Cz(350,70).DC(4.65,0.55).DF(257,53.0).DI(7.0,0.6).DL(48.0,3.2).DO(0.625,1.68).DR(10.5,4.0).DU(30.0,0).DW(600).DY(325);
		boot.M.b.EM(boot.BB.h).Cz(384,76).DC(4.5,0.55).DF(250,50.0).DI(6.9,0.6).DL(49.0,2.625).DO(0.579,1.36).DR(12.5,4.0).DU(30.0,0).DW(625).DY(335);
		boot.M.b.EM(boot.BB.i).Cz(395,79).DC(4.5,0.55).DF(173,35.0).DI(6.3,0.4).DL(46.3,2.85).DO(0.658,3.34).DR(11.5,3.4).DU(30.0,0).DW(600).DY(325);
		boot.M.b.EM(boot.BB.j).Cz(423,95).DC(7.25,0.75).DF(260,40.0).DI(6.6,0.5).DL(55.66,3.5).DO(0.625,1.13).DR(14.5,3.5).DU(30.0,1.25).DW(125).DY(325);
		boot.M.b.EM(boot.BB.k).Cz(380,76).DC(4.5,0.55).DF(250,45.0).DI(7.0,0.6).DL(51.66,3.0).DO(0.625,1.36).DR(12.0,3.5).DU(30.0,0).DW(550).DY(340);
		boot.M.b.EM(boot.BB.l).Cz(390,80).DC(4.75,0.55).DF(255,35.0).DI(6.5,0.55).DL(47.0,3.0).DO(0.668,3.0).DR(13.0,3.5).DU(30.0,0).DW(650).DY(325);
		boot.M.b.EM(boot.BB.m).Cz(380,75).DC(4.85,0.5).DF(250,50.0).DI(7.1,0.75).DL(47.0,3.2).DO(0.644,1.68).DR(11.5,4.0).DU(30.0,0).DW(550).DY(335);
		boot.M.b.EM(boot.BB.n).Cz(440,80).DC(7.5,0.85).DF(205,40.0).DI(6.45,0.45).DL(54.1,4.2).DO(0.625,1.44).DR(19.0,3.5).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.o).Cz(375,82).DC(4.5,0.55).DF(243,37.0).DI(6.5,0.55).DL(48.2,3.0).DO(0.658,2.3).DR(13.5,3.5).DU(30.0,0).DW(550).DY(325);
		boot.M.b.EM(boot.BB.p).Cz(426,93).DC(8.25,0.95).DF(200,37.5).DI(6.0,0.35).DL(50.0,3.5).DO(0.679,2.6).DR(20.0,3.5).DU(30.0,1.25).DW(125).DY(340);
		boot.M.b.EM(boot.BB.ba).Cz(438,90).DC(7.0,0.85).DF(230,40.0).DI(7.0,0.6).DL(48.0,3.0).DO(0.625,2.25).DR(16.0,3.6).DU(30.0,1.25).DW(150).DY(345);
		boot.M.b.EM(boot.BB.bb).Cz(433,89).DC(6.5,0.75).DL(56.23,3.0).DO(0.625,2.8).DR(17.0,3.5).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.bc).Cz(420,82).DC(5.0,0.7).DF(240,42.0).DI(6.95,0.65).DL(46.5,3.5).DO(0.679,2.6).DR(16.0,3.3).DU(30.0,0).DW(550).DY(330);
		boot.M.b.EM(boot.BB.bd).Cz(395,80).DC(4.7,0.6).DF(240,50.0).DI(6.8,0.65).DL(47.5,3.0).DO(0.625,1.75).DR(12.65,3.35).DU(30.0,0).DW(550).DY(335);
		boot.M.b.EM(boot.BB.be).Cz(414,86).DC(6.95,0.55).DF(180,42.0).DI(7.1,0.6).DL(48.0,3.3).DO(0.658,3.84).DR(12.5,4.0).DU(30.0,1.25).DW(125).DY(340);
		boot.M.b.EM(boot.BB.bf).Cz(350,80).DC(5.5,0.55).DF(235,45.0).DI(7.0,0.65).DL(47.2,3.0).DO(0.665,2.8).DR(12.0,3.5).DU(30.0,0).DW(550).DY(330);
		boot.M.b.EM(boot.BB.bg).Cz(390,80).DC(4.6,0.6).DF(251,59.0).DI(6.9,0.65).DL(45.95,2.625).DO(0.625,2.11).DR(11.0,3.5).DU(30.0,0).DW(480).DY(335);
		boot.M.b.EM(boot.BB.bh).Cz(450,85).DC(6.3,0.8).DF(220,40.0).DI(7.25,0.5).DL(54.5,3.2).DO(0.672,3.0).DR(15.5,3.5).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.bi).Cz(414,86).DC(7.0,0.7).DF(200,40.0).DI(6.15,0.45).DL(53.0,3.0).DO(0.658,3.1).DR(13.0,3.4).DU(30.0,1.25).DW(175).DY(335);
		boot.M.b.EM(boot.BB.bj).Cz(435,85).DC(7.45,0.75).DF(235,50.0).DI(7.0,0.7).DL(56.3,3.375).DO(0.638,1.2).DR(17.0,3.5).DU(30.0,0).DW(125).DY(335);
		boot.M.b.EM(boot.BB.bk).Cz(495,81).DC(425.0,0.75).DF(215,40.0).DI(6.5,0.7).DL(54.0,3.0).DO(0.651,2.75).DR(16.5,3.3).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.bl).Cz(455,96).DC(7.5,0.75).DL(52.5,3.5).DO(0.625,2.9).DR(19.0,2.7).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.bm).Cz(434,89).DC(7.25,0.85).DF(221,47.0).DI(6.45,0.45).DL(55.78,3.375).DO(0.651,2.05).DR(16.0,3.6).DU(30.0,0).DW(125).DY(340);
		boot.M.b.EM(boot.BB.bn).Cz(410,84).DC(5.5,0.7).DF(255,40.0).DI(6.75,0.7).DL(51.0,3.1).DO(0.625,2.9).DR(15.0,3.2).DU(30.0,0).DW(525).DY(330);
		boot.M.b.EM(boot.BB.bo).Cz(440,95).DC(8.0,0.75).DF(210,40.0).DI(6.5,0.6).DL(56.0,3.2).DO(0.67,2.5).DR(16.0,4.0).DU(30.0,1.25).DW(175).DY(345);
		boot.M.b.EM(boot.BB.bp).Cz(350,75).DC(4.5,0.55).DF(240,65.0).DI(7.0,0.65).DL(49.24,3.0).DO(0.625,1.21).DR(7.0,3.0).DU(30.0,0).DW(550).DY(325);
		boot.M.b.EM(boot.BB.ca).Cz(456,90).DC(7.5,0.65).DF(230,35.0).DI(7.0,0.65).DL(56.0,3.3).DO(0.665,3.2).DR(15.0,3.75).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.cb).Cz(356,78).DC(4.5,0.55).DF(302,64.0).DI(6.9,0.6).DL(49.0,2.95).DO(0.625,2.61).DR(9.0,3.8).DU(30.0,0).DW(475).DY(335);
		boot.M.b.EM(boot.BB.cc).Cz(420,90).DC(7.0,0.7).DF(235,40.0).DI(6.0,0.45).DL(50.0,3.4).DO(0.658,2.5).DR(14.0,3.0).DU(30.0,1.25).DW(175).DY(340);
		boot.M.b.EM(boot.BB.cd).Cz(463,98).DC(7.45,0.55).DF(230,35.0).DI(6.4,0.7).DL(56.3,3.375).DO(0.638,3.4).DR(18.0,3.5).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.ce).Cz(420,90).DC(6.0,0.8).DF(240,40.0).DI(7.0,0.7).DL(46.5,3.5).DO(0.658,3.0).DR(12.5,3.5).DU(30.0,0).DW(125).DY(335);
		boot.M.b.EM(boot.BB.cf).Cz(410,86).DC(4.7,0.55).DF(240,60.0).DI(6.8,0.65).DL(50.0,3.3).DO(0.625,2.3).DR(15.0,3.5).DU(30.0,0).DW(425).DY(335);
		boot.M.b.EM(boot.BB.cg).Cz(390,75).DC(5.5,0.55).DF(270,61.0).DI(6.5,0.6).DL(42.2,3.25).DO(0.625,2.11).DR(11.0,3.5).DU(30.0,0).DW(450).DY(335);
		boot.M.b.EM(boot.BB.ch).Cz(433,78).DC(6.95,0.5).DF(230,45.0).DI(6.9,0.6).DL(52.3,3.9).DO(0.638,3.7).DR(14.0,3.2).DU(30.0,1.25).DW(125).DY(340);
		boot.M.b.EM(boot.BB.ci).Cz(395,83).DC(6.95,0.55).DL(53.0,3.2).DO(0.658,2.74).DR(14.75,4.0).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.cj).Cz(418,93).DC(7.0,0.75).DF(255,40.0).DI(6.9,0.525).DL(53.3,2.8).DO(0.638,2.5).DR(17.0,3.5).DU(30.0,0.75).DW(125).DY(335);
		boot.M.b.EM(boot.BB.ck).Cz(403,79).DC(4.65,0.65).Du(200).Dw(50).DL(51.3,3.3).DO(0.69,3.4).DR(14.0,3.75).DU(30.0,0).DW(550).DY(335);
		boot.M.b.EM(boot.BB.cl).Cz(430,85).DC(6.25,0.75).DF(260,40.0).DI(6.75,0.5).DL(50.0,3.1).DO(0.665,2.7).DR(15.0,3.0).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.cm).Cz(440,84).DC(5.0,0.55).DF(295,40.0).DI(7.5,0.7).DL(46.0,3.0).DO(0.665,2.65).DR(13.0,3.53).DU(30.0,0).DW(500).DY(340);
		boot.M.b.EM(boot.BB.cn).Cz(390,75).DC(4.5,0.55).DF(250,50.0).DI(6.9,0.6).DL(51.0,3.1).DO(0.625,1.4).DR(12.0,3.5).DU(30.0,0).DW(525).DY(335);
		boot.M.b.EM(boot.BB.co).Cz(428,85).DC(6.25,61.0).Dw(200).Dw(50).DL(55.8,3.2).DO(0.651,3.0).DR(16.0,3.7).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.cp).Cz(430,87).DC(9.0,0.85).DF(235,40.0).DI(8.0,0.7).DL(55.0,3.0).DO(0.625,2.9).DR(18.0,3.1).DU(30.0,1.25).DW(125).DY(335);
		boot.M.b.EM(boot.BB.da).Cz(415,82).DC(6.0,0.72).DF(200,50.0).DI(6.0,0.6).DL(44.4,2.6).DO(0.625,2.2).DR(9.0,3.7).DU(30.0,0).DW(550).DY(325);
		boot.M.b.EM(boot.BB.db).Cz(345,79).DC(4.5,0.55).DF(250,50.0).DI(6.0,0.6).DL(50.0,3.3).DO(0.625,1.36).DR(8.0,4.0).DU(30.0,0).DW(550).DY(340);
		boot.M.b.EM(boot.BB.dc).Cz(423,90).DC(7.45,0.55).DF(215,40.0).DI(6.4,0.55).DL(56.3,3.375).DO(0.638,3.4).DR(18.0,3.75).DU(30.0,1.25).DW(125).DY(335);
		boot.M.b.EM(boot.BB.dd).Cz(380,80).DC(4.5,0.55).DF(250,45.0).DI(7.0,0.6).DL(51.66,3.0).DO(0.625,1.36).DR(15.0,3.5).DU(30.0,0).DW(550).DY(340);
		boot.M.b.EM(boot.BB.de).Cz(421,90).DC(7.25,0.85).DF(250,46.0).DI(6.45,0.45).DL(58.0,3.3).DO(0.694,2.13).DR(18.0,4.0).DU(30.0,0).DW(125).DY(335);
		boot.M.b.EM(boot.BB.df).Cz(444,86).DC(6.75,0.65).DF(199,36.0).DI(6.5,0.45).DL(55.12,3.1).DO(0.679,2.98).DR(16.3,3.7).DU(30.0,1.25).DW(125).DY(355);
		boot.M.b.EM(boot.BB.dg).Cz(435,85).DC(5.1,0.65).DF(212,38.0).DI(6.95,0.65).DL(46.5,3.0).DO(0.658,3.01).DR(15.0,3.0).DU(30.0,0).DW(550).DY(325);
		boot.M.b.EM(boot.BB.dh).Cz(421,80).DC(7.45,0.55).DL(51.7,3.5).DO(0.694,3.0).DR(15.0,3.5).DU(30.0,1.25).DW(125).DY(340);
		boot.M.b.EM(boot.BB.di).Cz(403,86).DC(4.7,0.6).DF(240,60.0).DI(6.8,0.65).DL(51.58,3.5).DO(0.579,1.53).DR(15.0,3.8).DU(30.0,0).DW(425).DY(335);
		boot.M.b.EM(boot.BB.dj).Cz(365,74).DC(4.5,45.0).DF(305,43.0).DI(6.9,0.6).DL(48.0,3.1).DO(0.644,2.6).DR(9.0,4.0).DU(30.0,0).DW(550).DY(330);
		boot.M.b.EM(boot.BB.dk).Cz(410,90).DC(7.5,0.9).DF(200,45.0).DI(6.6,0.5).DL(53.3,3.5).DO(0.638,3.48).DR(15.0,3.5).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.dl).Cz(432,86).DC(7.45,0.55).DF(200,50.0).DI(7.45,0.7).DL(52.0,3.3).DO(0.613,0.98).DR(12.0,3.25).DU(30.0,1.25).DW(175).DY(325);
		boot.M.b.EM(boot.BB.dm).Cz(370,90).DC(5.0,0.6).DF(220,45.0).DI(7.0,0.5).DL(49.0,3.5).DO(0.672,3.22).DR(11.0,3.5).DU(30.0,10.75).DW(525).DY(335);
		boot.M.b.EM(boot.BB.dn).Cz(430,85).DC(7.0,0.75).DF(215,35.0).DI(6.0,0.45).DL(54.0,3.1).DO(0.668,2.7).DR(17.0,3.5).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.dp).Cz(437,108).DC(7.05,0.8).DF(213,42.0).DI(6.6,0.5).DL(51.6,3.4).DO(0.625,2.25).DR(16.5,3.5).DU(30.0,1.25).DW(125).DY(340);
		boot.M.b.EM(boot.BB.ea).Cz(441,93).DC(7.0,0.9).DF(225,45.0).DI(6.5,0.575).DL(54.1,3.5).DO(0.694,2.7).DR(17.0,3.0).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.eb).Cz(385,79).DC(5.95,0.55).DF(250,50.0).DI(7.0,0.5).DL(44.0,2.6).DO(0.658,3.5).DR(8.0,3.0).DU(30.0,0).DW(525).DY(325);
		boot.M.b.EM(boot.BB.ec).Cz(433,87).DC(6.75,0.65).DF(210,34.0).DI(6.6,0.45).DL(50.7,2.9).DO(0.679,2.95).DR(17.1,3.9).DU(30.0,1.25).DW(155).DY(355);
		boot.M.b.EM(boot.BB.ed).Cz(423,81).DC(7.45,0.55).DF(185,30.0).DI(6.4,0.45).DL(56.3,3.375).DO(0.638,3.35).DR(18.0,4.0).DU(30.0,0).DW(125).DY(345);
		boot.M.b.EM(boot.BB.ee).Cz(420,86).DC(8.0,0.55).DF(255,33.0).DI(4.5,0.3).DL(50.0,3.5).DO(0.625,2.22).DR(21.0,3.8).DU(30.0,1.25).DW(125).DY(335);
		boot.M.b.EM(boot.BB.ef).Cz(426,87).DC(6.7,0.75).DL(53.12,3.1).DO(0.665,2.65).DR(15.2,3.8).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.eg).Cz(435,85).DC(4.0,0.4).DL(55.0,3.0).DO(0.679,2.85).DR(16.0,3.5).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.eh).Cz(414,86).DC(10.4,0.9).DL(54.0,2.75).DO(0.625,3.5).DR(15.0,3.1).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.ei).Cz(450,80).DC(7.0,0.7).DL(55.32,3.2).DO(0.644,1.85).DR(16.0,3.5).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.ej).Cz(360,86).DC(4.35,0.55).DF(250,55.0).DI(7.0,0.6).DL(52.0,3.0).DO(0.625,2.11).DR(11.0,3.9).DU(30.0,0).DW(550).DY(335);
		boot.M.b.EM(boot.BB.ek).Cz(450,85).DC(7.35,0.85).DF(220,40.0).DI(6.45,0.45).DL(54.0,3.4).DO(0.67,1.45).DR(20.5,3.5).DU(30.0,1.25).DW(125).DY(340);
		boot.M.b.EM(boot.BB.el).Cz(441,84).DC(7.45,0.55).DF(270,40.0).DI(6.4,0.45).DL(51.7,3.5).DO(0.694,3.0).DR(15.0,3.5).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.em).Cz(428,85).DC(7.45,0.55).Du(200).Dw(50).DL(54.5,3.375).DO(0.651,3.4).DR(15.0,4.0).DU(30.0,0).DW(125).DY(335);
		boot.M.b.EM(boot.BB.en).Cz(435,95).DC(7.2,0.8).DL(54.5,3.4).DO(0.658,3.4).DR(17.6,3.4).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.eo).Cz(405,82).DC(7.1,0.55).DF(215,45.0).DI(6.6,0.55).DL(56.65,3.375).DO(0.613,1.81).DR(18.0,3.5).DU(30.0,0).DW(125).DY(345);
		boot.M.b.EM(boot.BB.ep).Cz(403,104).DC(7.9,0.95).DF(240,40.0).DI(6.3,0.4).DL(55.52,3.1875).DO(0.625,1.63).DR(17.75,3.25).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.fa).Cz(378,82).DC(4.25,0.55).DF(203,43.0).DI(6.5,0.5).DL(49.0,2.9).DO(0.658,3.28).DR(12.75,3.25).DU(30.0,0).DW(500).DY(335);
		boot.M.b.EM(boot.BB.fb).Cz(440,96).DC(7.5,0.85).DF(205,40.0).DI(6.45,0.45).DL(54.1,4.2).DO(0.625,2.1).DR(19.0,3.8).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.fc).Cz(340,70).DC(4.5,0.55).DF(265,45.0).DI(7.0,0.65).DL(47.0,3.0).DO(0.644,2.3).DR(6.0,3.3).DU(30.0,0).DW(550).DY(330);
		boot.M.b.EM(boot.BB.fd).Cz(375,71).DC(4.5,0.55).DF(240,60.0).DI(6.8,0.65).DL(48.8,3.0).DO(0.625,2.14).DR(7.4,3.8).DU(30.0,0).DW(550).DY(335);
		boot.M.b.EM(boot.BB.fe).Cz(385,78).DC(6.75,0.65).DF(240,50.0).DI(6.8,0.65).DL(49.0,3.0).DO(0.625,2.11).DR(12.0,4.0).DU(30.0,0).DW(500).DY(335);
		boot.M.b.EM(boot.BB.ff).Cz(380,78).DC(5.5,0.6).DF(250,50.0).DI(6.9,0.6).DL(51.0,2.9).DO(0.625,2.0).DR(15.0,3.4).DU(30.0,0).DW(550).DY(330);
		boot.M.b.EM(boot.BB.fg).Cz(440,85).DC(7.25,0.75).DF(260,40.0).DI(6.75,0.5).DL(50.0,3.1).DO(0.668,2.7).DR(17.0,3.5).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.fh).Cz(468,90).DC(7.1,0.5).DF(255,56.0).DI(4.1,0.4).DL(58.0,3.5).DO(0.625,2.02).DR(16.5,3.2).DU(30.0,1.25).DW(125).DY(340);
		boot.M.b.EM(boot.BB.fi).Cz(383,82).DC(4.65,0.65).DF(200,40.0).DI(6.45,0.45).DL(44.5,3.0).DO(0.69,3.38).DR(14.0,3.75).DU(30.0,0).DW(500).DY(330);
		boot.M.b.EM(boot.BB.fj).Cz(415,82).DC(5.1,0.65).DF(193,32.0).DI(6.45,0.45).DL(46.5,3.0).DO(0.658,3.01).DR(15.0,3.0).DU(30.0,0).DW(550).DY(325);
		boot.M.b.EM(boot.BB.fk).Cz(455,96).DC(8.0,0.85).DF(206,45.0).DI(6.9,0.6).DL(54.66,3.0).DO(0.672,2.9).DR(19.0,2.7).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.fl).Cz(461,98).DC(7.9,0.9).DL(56.0,3.2).DO(0.644,2.9).DR(14.9,3.1).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.fm).Cz(384,82).DC(4.5,0.6).DF(202,38.0).DI(6.5,0.5).DL(46.61,3.3).DO(0.651,3.22).DR(111.25,3.15).DU(30.0,0).DW(525).DY(330);
		boot.M.b.EM(boot.BB.fn).Cz(389,81).DC(5.0,0.6).DF(220,40.0).DI(6.5,0.45).DL(49.0,3.0).DO(0.679,3.38).DR(14.0,3.0).DU(30.0,0).DW(550).DY(330);
		boot.M.b.EM(boot.BB.fo).Cz(427,99).DC(7.45,0.75).DF(220,30.0).DI(6.4,0.45).DL(52.91,3.2).DO(0.658,2.67).DR(14.75,4.0).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.fp).Cz(437,89).DC(5.5,0.6).DF(220,55.0).DI(7.5,0.65).DL(48.0,3.6).DO(0.644,2.9).DR(15.0,3.3).DU(30.0,0).DW(425).DY(335);
		boot.M.b.EM(boot.BB.ga).Cz(400,82).DC(4.5,0.55).DF(250,36.0).DI(6.5,0.5).DL(46.0,3.0).DO(0.658,2.65).DR(13.5,3.4).DU(30.0,0).DW(575).DY(335);
		boot.M.b.EM(boot.BB.gb).Cz(359,83).DC(4.5,0.55).DF(173,27.0).DI(6.3,0.4).DL(50.0,3.25).DO(0.658,3.1).DR(9.3,3.4).DU(30.0,0).DW(550).DY(330);
		boot.M.b.EM(boot.BB.gc).Cz(355,82).DC(4.5,0.55).DF(250,55.0).DI(6.9,0.6).DL(48.3,2.625).DO(0.625,2.24).DR(12.25,3.75).DU(30.0,0).DW(525).DY(340);
		boot.M.b.EM(boot.BB.gd).Cz(440,85).DC(7.5,0.9).DF(220,45.0).DI(7.0,0.65).DL(55.0,3.5).DO(0.643,2.5).DR(16.0,3.5).DU(30.0,1.25).DW(125).DY(350);
		boot.M.b.EM(boot.BB.ge).Cz(385,78).DC(6.75,0.65).DF(240,50.0).DI(6.9,0.45).DL(49.0,3.0).DO(0.625,2.11).DR(12.0,4.0).DU(30.0,0).DW(525).DY(335);
		boot.M.b.EM(boot.BB.gf).Cz(400,85).DC(6.0,0.6).DL(45.0,3.0).DO(0.6258,2.0).DR(12.0,3.5).DU(30.0,0).DW(450).DY(335);
		boot.M.b.EM(boot.BB.gg).Cz(440,86).DC(7.0,0.65).DF(220,30.0).DI(7.0,0.65).DL(54.0,3.3).DO(0.625,2.9).DR(16.5,3.5).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.gh).Cz(428,98).DC(7.05,0.8).DF(190,30.0).DI(7.1,0.6).DL(56.76,3.375).DO(0.679,2.88).DR(16.0,3.5).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.gi).Cz(435,85).DC(5.1,0.65).DF(202,38.0).DI(6.9,0.65).DL(54.0,3.2).DO(0.658,3.0).DR(15.0,3.5).DU(30.0,1.25).DW(175).DY(345);
		boot.M.b.EM(boot.BB.gj).Cz(380,80).DC(5.0,0.55).DF(250,45.0).DI(8.0,0.6).DL(52.0,3.0).DO(0.625,1.36).DR(12.6,3.4).DU(30.0,0).DW(550).DY(340);
		boot.M.b.EM(boot.BB.gk).Cz(445,87).DC(7.0,0.7).DF(213,31.0).DI(6.6,0.45).DL(52.0,3.3).DO(0.672,2.7).DR(16.2,3.7).DU(30.0,1.25).DW(175).DY(345);
		boot.M.b.EM(boot.BB.gl).Cz(421,85).DC(8.5,0.7).DF(235,35.0).DI(6.5,0.45).DL(51.5,3.5).DO(0.625,3.0).DR(18.0,3.6).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.gm).Cz(445,85).DC(6.0,0.65).Du(20).Dw(50).DL(48.6,3.4).DO(0.658,3.1).DR(17.5,3.5).DU(30.0,1.25).DW(125).DY(345);
		boot.M.b.EM(boot.BB.gn).Cz(390,80).DC(5.25,0.6).DF(250,50.0).DI(6.75,0.6).DL(54.0,3.1).DO(0.656,1.7).DR(12.0,3.3).DU(30.0,0).DW(575).DY(330);
		boot.M.b.EM(boot.BB.go).Cz(380,71).DC(4.6,0.5).DF(260,60.0).DI(6.95,0.65).DL(48.6,3.0).DO(0.625,2.13).DR(6.75,3.8).DU(30.0,0).DW(600).DY(335);
		boot.M.b.EM(boot.BB.gp).Cz(355,74).DC(4.85,0.5).DF(250,50.0).DI(7.1,0.75).DL(50.0,3.2).DO(0.625,1.8).DR(11.0,3.0).DU(30.0,0).DW(575).DY(325);
		boot.M.c=new boot.M(1520,2012,12,3,"Preseason 3",boot.M.b,0);
		boot.M.c.EI("Shard of True Ice");
		boot.M.c.EI("Liandry's Torment");
		boot.M.c.EI("Haunting Guise");
		boot.M.a=boot.M.c;
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
	EI:function(A,B){
		B=new boot.BX(A,this,0);
		this.e.CK(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	EM:function(A){
		A.hb=new boot.BE(this,A.hb,0);
		return A.hb;
	}
});

boot.define("N","",{
},{
	"$":[["BY",{
	}],["BZ",{
		FS:function() {return [CONSTRUCTOR,TYPE];}
	}],["Bu",{
		FT:function() {return RUNTIME;}
	}]]
});

boot.define("B","C",{
	
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.C.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B,C,D,E,F,G){
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
		C=boot.I.$;
		G=C.J();F=G.length;E=0;
		l18:for (;
		E<F;
		++E) {
			D=G[E];
			console.log(D);
			console.log(D.K(boot.N.$));
		}
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