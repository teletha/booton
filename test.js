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
	// booton.translator.js.JSClass#getName()
	X:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	U:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	Y:function(){
		return null;
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

boot.define("V","",{
});

boot.define("T","",{
});

boot.define("U","",{
	
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
		D=A.x();
		l2:while (D.BB()!=0) {
			C=D.y();
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
		D=this.x();
		l2:while (D.BB()!=0) {
			C=D.y();
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
		D=A.x();
		l2:while (D.BB()!=0) {
			C=D.y();
			if(this.BI(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BK:function(A,B,C){
		C=A.x();
		l1:while (C.BB()!=0) {
			B=C.y();
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
		}C=this.x();
		D=0;
		l6:while (C.BB()!=0) {
			E=C.y();
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
	BB:function(){
		return this.b<boot.S.BZ(this.a).length;
	},
	// js.util.ArrayList$View#next()
	y:function(){
		return boot.S.BZ(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	Bu:function(){
		if(this.b<=0){
		}else{
			boot.S.BZ(this.a).splice(this.b-1,1)[0];
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
	Bv:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	Bw:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	Bx:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	Bz:function(){
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
	BE:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BH:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	x:function(){
		return new boot.W(this,null,0);
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
		throw new boot.X(0);
	},
	// js.util.ArrayList#listIterator(int)
	BW:function(A){
		throw new boot.X(0);
	},
	// js.util.ArrayList#subList(int, int)
	BX:function(A,B){
		throw new boot.X(0);
	},
	// js.util.ArrayList#checkRange(int)
	BY:function(A){
		if(A>=0){
			if(this.BE()>A){
				return;
			}else{
				throw new boot.Y("Index is overflowed. Size: "+this.BE()+"  Index: "+A,0);
			}
		}else{
			throw new boot.Y("Negative index is unacceptable. Size: "+this.BE()+"  Index: "+A,0);
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
		CC:function() {return [CONSTRUCTOR,TYPE];}
	}],["z",{
		CD:function() {return RUNTIME;}
	}]]
});

boot.define("H","",{
	
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo)
	$1:function(A,B){
		this.a=A;
		this.b=new RegExp(B.CA().replace(/\*/g,"([^/].+)"),"");
	},
	// js.Application$Route#match(java.lang.String)
	CB:function(A,B,C,D){
		B=this.b.exec(A);
		if(B!=null!=0){
			C=new boot.S(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.H(B[D+1]);
			}try{
				return this.a.v(C.BL());
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
	_z:function(A,B){
		return A.CB(B);
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
	BB:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	CG:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	Bu:function(){
	},
	// booton.translator.web.jQuery$1#next()
	y:function(){
		return this.CG();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	CE:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	CF:function(A){
		return this.CE("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	x:function(){
		return new boot.BC(this,0);
	}
});
boot.define("E","",{
	
	// js.Application$Router#<init>()
	$1:function(){
		this.a=new boot.S(0);
	},
	// js.Application$Router#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		this.w(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	w:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.x();
		l3:while (C.BB()!=0) {
			B=C.y();
			D=boot.H.z(B,A);
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
	BC:function(A,B){
		B=$(document.createDocumentFragment());
		this.b=A;
		this.b.BA(B);
		$("#Content").empty().append(B);
	},
	// js.Application$Router#<init>(js.Application$Router)
	$0:function(A){
		boot.E.prototype.$1.call(this);
	},
	// js.Application$Router#access$1(js.Application$Router, java.lang.String)
	_B:function(A,B){
		A.w(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_G:function(A){
		return A.a;
	}
},{
	"BC":[["Q",{
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

boot.define("BR","U",{
	
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.U.prototype.$0.call(this);
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
	BB:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	y:function(){
		this.d=boot.BL.DB(this.a)[this.c[this.b++]];
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
		return this.DA(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	H:function(A,B){
		B=this.DA(A);
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
		B=this.DA(A);
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
	x:function(){
		return new boot.BS(this,Object.keys(this.b),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	DA:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CW:function(A){
		return this.b[this.DA(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CY:function(A,B,C){
		B=null;
		C=this.DA(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	Cu:function(A,B,C){
		B=null;
		C=this.DA(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_DB:function(A){
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
	Cx:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CX:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	DC:function(A,B){
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
	BB:function(){
		return this.b.BB();
	},
	// js.util.HashMap$View#next()
	y:function(A){
		A=this.b.y();
		if(this.c==0){
			return A.CX();
		}else{
			return A.Cx();
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
		return boot.BJ.Cz(this.a).BE();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BH:function(A){
		return boot.BJ.Cz(this.a).BH(A);
	},
	// js.util.HashMap$Keys#iterator()
	x:function(){
		return new boot.BT(this.a,boot.BJ.Cz(this.a).x(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BI:function(A){
		return boot.BJ.Cz(this.a).BI(A);
	},
	// js.util.HashMap$Keys#clear()
	BO:function(){
		boot.BJ.Cz(this.a).BO();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.BP.prototype.$1.call(this,A);
	}
});

boot.define("BQ","U",{
	
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.U.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BE:function(){
		return boot.BJ.Cz(this.a).BE();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BH:function(A){
		return this.a.CV(A);
	},
	// js.util.HashMap$Values#iterator()
	x:function(){
		return new boot.BT(this.a,boot.BJ.Cz(this.a).x(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	H:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BI:function(A,B,C){
		B=this.x();
		l2:while (B.BB()!=0) {
			C=B.y();
			if(C!=A){
			}else{
				B.Bu();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BO:function(){
		boot.BJ.Cz(this.a).BO();
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
	CU:function(A){
		return this.a.BH(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CV:function(A,B,C){
		C=this.CT().x();
		l1:while (C.BB()!=0) {
			B=C.y();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CR:function(A,B){
		B=this.a.CW(A);
		return (B==null?null:B.CX());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CQ:function(A,B,C){
		C=this.a.CY(new boot.BN(A,B,null,0));
		if(C!=null){
			return C.CX();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	CZ:function(A,B){
		B=this.a.Cu(A);
		if(B!=null){
			return B.CX();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	Cv:function(A,B,C){
		C=A.Cw().x();
		l1:for (;
		C.BB()!=0;
		this.CQ(B.Cx(),B.CX())) {
			B=C.y();
		}
	},
	// js.util.HashMap#clear()
	BO:function(){
		this.a.BO();
	},
	// js.util.HashMap#keySet()
	Cy:function(){
		return new boot.BP(this,null,0);
	},
	// js.util.HashMap#values()
	CT:function(){
		return new boot.BQ(this,null,0);
	},
	// js.util.HashMap#entrySet()
	Cw:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_Cz:function(A){
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
		this.ha=this.CP().toLowerCase();
		boot.BE.b.CQ(A,this);
	},
	// teemowork.model.Champion#getStatus()
	CL:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CP:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	CI:function(){
		return "src/main/resources/teemowork/splash/"+this.CP()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	CJ:function(){
		return "src/main/resources/teemowork/icon/"+this.CP()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_CH:function(A){
		return boot.BE.b.CR(A);
	},
	// teemowork.model.Champion#getAll()
	_CS:function(){
		return boot.BE.b.CT();
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
		boot.K.CO(this.a,boot.K.CN(this.a)+1);
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
		boot.K.CO(this.a,boot.K.CN(this.a)-1);
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
	DD:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	DE:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	DF:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	DG:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DH:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	DI:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DJ:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DK:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	DL:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DM:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DN:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	DO:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DP:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DQ:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	DR:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DS:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DT:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	DU:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DV:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DW:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DX:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DY:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	DZ:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	Du:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	Dv:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	Dw:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	Dx:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	Dy:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	Dz:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	EA:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	EB:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	EC:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	CM:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	ED:function(A){
		return this.g+this.h*A;
	}
});

boot.define("K","J",{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.K.prototype.$1.call(this,boot.BE.CH(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.J.prototype.$0.call(this);
		if(A!=null){
			this.a=A;
			return;
		}else{
			throw new boot.X(0);
		}
	},
	// teemowork.ChampionDetail#load(booton.translator.web.jQuery)
	BA:function(A,B,C){
		B=A.CF("a").css("background-image","url('"+this.a.CI()+"')").CF("b");
		C=B.CF("c").css("background-image","url("+this.a.CJ()+")").click(new boot.BF(this,0)).on("contextmenu",new boot.BG(this,0));
		this.b=C.CF("d");
		this.c=B.CF("e").text("Health").CF("f");
		this.CK(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	CK:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.CL();
			this.c.text(""+B.CM(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	J:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_CN:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CO:function(A,B){
		A.CK(B);
	}
},{
	"$0":[["F",{
		CA:function() {return "Champion/*";}
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
		D=boot.BW.EJ(this.a).Cw().x();
		l2:while (D.BB()!=0) {
			C=D.y();
			if(this.a.EI(C.Cx()).toLowerCase().indexOf(B) != -1==0){
				C.CX().addClass("j");
				continue l2;
			}else{
				C.CX().removeClass("j");
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
		this.a.EK(this.b);
	}
});

boot.define("BW","BX",{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BX.prototype.$0.call(this);
		this.b=new boot.BJ(0);
		this.c=this.EG();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	EE:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BY(this,B,0));
		D=this.c.x();
		l6:for (;
		D.BB()!=0;
		this.b.CQ(C,E)) {
			C=D.y();
			E=this.a.CF("h").css("background-image","url("+this.EH(C)+")");
			E.CE("span").addClass("i").text(this.EI(C));
			E.click(new boot.BZ(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_EJ:function(A){
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
	EG:function(){
		return boot.BE.CS();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	EL:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	EM:function(A){
		return A.CJ();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	EO:function(A){
		boot.C.I(new boot.K(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	EI:function(A){
		return this.EL(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	EH:function(A){
		return this.EM(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	EK:function(A){
		this.EO(A);
	}
});

boot.define("L","J",{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.J.prototype.$0.call(this);
		this.a=new boot.BV(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	BA:function(A){
		this.a.EE(A);
	},
	// teemowork.ChampionSelect#getPageId()
	J:function(){
		return "";
	}
},{
	"$0":[["F",{
		CA:function() {return "";}
	}]]
});

boot.define("N","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.CE("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	K:function(A,B,C){
		C=this.b.CE("li").addClass("o");
		C.CE("a").addClass("m").attr("href",B).text(A);
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
		C=this.a.CE("li").addClass("l");
		C.CE("a").addClass("m").attr("href",B).text(A);
		return new boot.N(this,C,null,0);
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
		C=boot.Bu.a.CR(A);
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
		boot.Bu.a.CQ(A,this);
	},
	// teemowork.model.Item#cost()
	EU:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	EQ:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	EV:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	EW:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	EX:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	EY:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	EZ:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	Eu:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	Ev:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	Ew:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	Ex:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	Ey:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	Ez:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	FA:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	FB:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	ES:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	FC:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	FD:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	FE:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	FF:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	FG:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	FH:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	FI:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	FJ:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	FK:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	ER:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	FL:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	FM:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FN:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FO:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FP:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FQ:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FR:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FS:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FT:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FU:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FV:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FW:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FX:function(A){
		return boot.Bu.a.CR(A);
	},
	// teemowork.model.Item#getAll()
	_CS:function(){
		return boot.Bu.a.CT();
	}
});

boot.define("O","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.O.b=new boot.O(1510,2012,11,13,"Initial",null,0);
		boot.O.b.EP("Ruby Crystal").EQ(475).ER(180);
		boot.O.b.EP("Haunting Guise").ER(200).ES(25);
		boot.O.b.ET(boot.BE.c).DF(380,80).DI(5.5,0.6).DL(230,50.0).DO(6.25,0.6).DR(50.0,3.0).DU(0.668,2.0).DX(10.0,3.5).Du(30.0,0).Dw(550).Dy(330);
		boot.O.b.ET(boot.BE.d).DF(445,85).DI(7.25,0.65).EA(200).EC(50).DR(53.0,3.2).DU(0.694,3.1).DX(16.5,3.5).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.e).DF(442,102).DI(7.25,0.85).DL(215,38.0).DO(6.45,0.45).DR(55.03,3.62).DU(0.625,3.62).DX(14.5,3.5).Du(30.0,1.25).Dw(125).Dy(325);
		boot.O.b.ET(boot.BE.f).DF(472,84).DI(7.45,0.85).DL(220,40.0).DO(6.5,0.525).DR(47.0,3.8).DU(0.638,2.18).DX(18.0,3.3).Du(30.0,1.25).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.g).DF(350,70).DI(4.65,0.55).DL(257,53.0).DO(7.0,0.6).DR(48.0,3.2).DU(0.625,1.68).DX(10.5,4.0).Du(30.0,0).Dw(600).Dy(325);
		boot.O.b.ET(boot.BE.h).DF(384,76).DI(4.5,0.55).DL(250,50.0).DO(6.9,0.6).DR(49.0,2.625).DU(0.579,1.36).DX(12.5,4.0).Du(30.0,0).Dw(625).Dy(335);
		boot.O.b.ET(boot.BE.i).DF(395,79).DI(4.5,0.55).DL(173,35.0).DO(6.3,0.4).DR(46.3,2.85).DU(0.658,3.34).DX(11.5,3.4).Du(30.0,0).Dw(600).Dy(325);
		boot.O.b.ET(boot.BE.j).DF(423,95).DI(7.25,0.75).DL(260,40.0).DO(6.6,0.5).DR(55.66,3.5).DU(0.625,1.13).DX(14.5,3.5).Du(30.0,1.25).Dw(125).Dy(325);
		boot.O.b.ET(boot.BE.k).DF(380,76).DI(4.5,0.55).DL(250,45.0).DO(7.0,0.6).DR(51.66,3.0).DU(0.625,1.36).DX(12.0,3.5).Du(30.0,0).Dw(550).Dy(340);
		boot.O.b.ET(boot.BE.l).DF(390,80).DI(4.75,0.55).DL(255,35.0).DO(6.5,0.55).DR(47.0,3.0).DU(0.668,3.0).DX(13.0,3.5).Du(30.0,0).Dw(650).Dy(325);
		boot.O.b.ET(boot.BE.m).DF(380,75).DI(4.85,0.5).DL(250,50.0).DO(7.1,0.75).DR(47.0,3.2).DU(0.644,1.68).DX(11.5,4.0).Du(30.0,0).Dw(550).Dy(335);
		boot.O.b.ET(boot.BE.n).DF(440,80).DI(7.5,0.85).DL(205,40.0).DO(6.45,0.45).DR(54.1,4.2).DU(0.625,1.44).DX(19.0,3.5).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.o).DF(375,82).DI(4.5,0.55).DL(243,37.0).DO(6.5,0.55).DR(48.2,3.0).DU(0.658,2.3).DX(13.5,3.5).Du(30.0,0).Dw(550).Dy(325);
		boot.O.b.ET(boot.BE.p).DF(426,93).DI(8.25,0.95).DL(200,37.5).DO(6.0,0.35).DR(50.0,3.5).DU(0.679,2.6).DX(20.0,3.5).Du(30.0,1.25).Dw(125).Dy(340);
		boot.O.b.ET(boot.BE.ba).DF(438,90).DI(7.0,0.85).DL(230,40.0).DO(7.0,0.6).DR(48.0,3.0).DU(0.625,2.25).DX(16.0,3.6).Du(30.0,1.25).Dw(150).Dy(345);
		boot.O.b.ET(boot.BE.bb).DF(433,89).DI(6.5,0.75).DR(56.23,3.0).DU(0.625,2.8).DX(17.0,3.5).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.bc).DF(420,82).DI(5.0,0.7).DL(240,42.0).DO(6.95,0.65).DR(46.5,3.5).DU(0.679,2.6).DX(16.0,3.3).Du(30.0,0).Dw(550).Dy(330);
		boot.O.b.ET(boot.BE.bd).DF(395,80).DI(4.7,0.6).DL(240,50.0).DO(6.8,0.65).DR(47.5,3.0).DU(0.625,1.75).DX(12.65,3.35).Du(30.0,0).Dw(550).Dy(335);
		boot.O.b.ET(boot.BE.be).DF(414,86).DI(6.95,0.55).DL(180,42.0).DO(7.1,0.6).DR(48.0,3.3).DU(0.658,3.84).DX(12.5,4.0).Du(30.0,1.25).Dw(125).Dy(340);
		boot.O.b.ET(boot.BE.bf).DF(350,80).DI(5.5,0.55).DL(235,45.0).DO(7.0,0.65).DR(47.2,3.0).DU(0.665,2.8).DX(12.0,3.5).Du(30.0,0).Dw(550).Dy(330);
		boot.O.b.ET(boot.BE.bg).DF(390,80).DI(4.6,0.6).DL(251,59.0).DO(6.9,0.65).DR(45.95,2.625).DU(0.625,2.11).DX(11.0,3.5).Du(30.0,0).Dw(480).Dy(335);
		boot.O.b.ET(boot.BE.bh).DF(450,85).DI(6.3,0.8).DL(220,40.0).DO(7.25,0.5).DR(54.5,3.2).DU(0.672,3.0).DX(15.5,3.5).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.bi).DF(414,86).DI(7.0,0.7).DL(200,40.0).DO(6.15,0.45).DR(53.0,3.0).DU(0.658,3.1).DX(13.0,3.4).Du(30.0,1.25).Dw(175).Dy(335);
		boot.O.b.ET(boot.BE.bj).DF(435,85).DI(7.45,0.75).DL(235,50.0).DO(7.0,0.7).DR(56.3,3.375).DU(0.638,1.2).DX(17.0,3.5).Du(30.0,0).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.bk).DF(495,81).DI(425.0,0.75).DL(215,40.0).DO(6.5,0.7).DR(54.0,3.0).DU(0.651,2.75).DX(16.5,3.3).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.bl).DF(455,96).DI(7.5,0.75).DR(52.5,3.5).DU(0.625,2.9).DX(19.0,2.7).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.bm).DF(434,89).DI(7.25,0.85).DL(221,47.0).DO(6.45,0.45).DR(55.78,3.375).DU(0.651,2.05).DX(16.0,3.6).Du(30.0,0).Dw(125).Dy(340);
		boot.O.b.ET(boot.BE.bn).DF(410,84).DI(5.5,0.7).DL(255,40.0).DO(6.75,0.7).DR(51.0,3.1).DU(0.625,2.9).DX(15.0,3.2).Du(30.0,0).Dw(525).Dy(330);
		boot.O.b.ET(boot.BE.bo).DF(440,95).DI(8.0,0.75).DL(210,40.0).DO(6.5,0.6).DR(56.0,3.2).DU(0.67,2.5).DX(16.0,4.0).Du(30.0,1.25).Dw(175).Dy(345);
		boot.O.b.ET(boot.BE.bp).DF(350,75).DI(4.5,0.55).DL(240,65.0).DO(7.0,0.65).DR(49.24,3.0).DU(0.625,1.21).DX(7.0,3.0).Du(30.0,0).Dw(550).Dy(325);
		boot.O.b.ET(boot.BE.ca).DF(456,90).DI(7.5,0.65).DL(230,35.0).DO(7.0,0.65).DR(56.0,3.3).DU(0.665,3.2).DX(15.0,3.75).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.cb).DF(356,78).DI(4.5,0.55).DL(302,64.0).DO(6.9,0.6).DR(49.0,2.95).DU(0.625,2.61).DX(9.0,3.8).Du(30.0,0).Dw(475).Dy(335);
		boot.O.b.ET(boot.BE.cc).DF(420,90).DI(7.0,0.7).DL(235,40.0).DO(6.0,0.45).DR(50.0,3.4).DU(0.658,2.5).DX(14.0,3.0).Du(30.0,1.25).Dw(175).Dy(340);
		boot.O.b.ET(boot.BE.cd).DF(463,98).DI(7.45,0.55).DL(230,35.0).DO(6.4,0.7).DR(56.3,3.375).DU(0.638,3.4).DX(18.0,3.5).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.ce).DF(420,90).DI(6.0,0.8).DL(240,40.0).DO(7.0,0.7).DR(46.5,3.5).DU(0.658,3.0).DX(12.5,3.5).Du(30.0,0).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.cf).DF(410,86).DI(4.7,0.55).DL(240,60.0).DO(6.8,0.65).DR(50.0,3.3).DU(0.625,2.3).DX(15.0,3.5).Du(30.0,0).Dw(425).Dy(335);
		boot.O.b.ET(boot.BE.cg).DF(390,75).DI(5.5,0.55).DL(270,61.0).DO(6.5,0.6).DR(42.2,3.25).DU(0.625,2.11).DX(11.0,3.5).Du(30.0,0).Dw(450).Dy(335);
		boot.O.b.ET(boot.BE.ch).DF(433,78).DI(6.95,0.5).DL(230,45.0).DO(6.9,0.6).DR(52.3,3.9).DU(0.638,3.7).DX(14.0,3.2).Du(30.0,1.25).Dw(125).Dy(340);
		boot.O.b.ET(boot.BE.ci).DF(395,83).DI(6.95,0.55).DR(53.0,3.2).DU(0.658,2.74).DX(14.75,4.0).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.cj).DF(418,93).DI(7.0,0.75).DL(255,40.0).DO(6.9,0.525).DR(53.3,2.8).DU(0.638,2.5).DX(17.0,3.5).Du(30.0,0.75).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.ck).DF(403,79).DI(4.65,0.65).EA(200).EC(50).DR(51.3,3.3).DU(0.69,3.4).DX(14.0,3.75).Du(30.0,0).Dw(550).Dy(335);
		boot.O.b.ET(boot.BE.cl).DF(430,85).DI(6.25,0.75).DL(260,40.0).DO(6.75,0.5).DR(50.0,3.1).DU(0.665,2.7).DX(15.0,3.0).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.cm).DF(440,84).DI(5.0,0.55).DL(295,40.0).DO(7.5,0.7).DR(46.0,3.0).DU(0.665,2.65).DX(13.0,3.53).Du(30.0,0).Dw(500).Dy(340);
		boot.O.b.ET(boot.BE.cn).DF(390,75).DI(4.5,0.55).DL(250,50.0).DO(6.9,0.6).DR(51.0,3.1).DU(0.625,1.4).DX(12.0,3.5).Du(30.0,0).Dw(525).Dy(335);
		boot.O.b.ET(boot.BE.co).DF(428,85).DI(6.25,61.0).EC(200).EC(50).DR(55.8,3.2).DU(0.651,3.0).DX(16.0,3.7).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.cp).DF(430,87).DI(9.0,0.85).DL(235,40.0).DO(8.0,0.7).DR(55.0,3.0).DU(0.625,2.9).DX(18.0,3.1).Du(30.0,1.25).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.da).DF(415,82).DI(6.0,0.72).DL(200,50.0).DO(6.0,0.6).DR(44.4,2.6).DU(0.625,2.2).DX(9.0,3.7).Du(30.0,0).Dw(550).Dy(325);
		boot.O.b.ET(boot.BE.db).DF(345,79).DI(4.5,0.55).DL(250,50.0).DO(6.0,0.6).DR(50.0,3.3).DU(0.625,1.36).DX(8.0,4.0).Du(30.0,0).Dw(550).Dy(340);
		boot.O.b.ET(boot.BE.dc).DF(423,90).DI(7.45,0.55).DL(215,40.0).DO(6.4,0.55).DR(56.3,3.375).DU(0.638,3.4).DX(18.0,3.75).Du(30.0,1.25).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.dd).DF(380,80).DI(4.5,0.55).DL(250,45.0).DO(7.0,0.6).DR(51.66,3.0).DU(0.625,1.36).DX(15.0,3.5).Du(30.0,0).Dw(550).Dy(340);
		boot.O.b.ET(boot.BE.de).DF(421,90).DI(7.25,0.85).DL(250,46.0).DO(6.45,0.45).DR(58.0,3.3).DU(0.694,2.13).DX(18.0,4.0).Du(30.0,0).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.df).DF(444,86).DI(6.75,0.65).DL(199,36.0).DO(6.5,0.45).DR(55.12,3.1).DU(0.679,2.98).DX(16.3,3.7).Du(30.0,1.25).Dw(125).Dy(355);
		boot.O.b.ET(boot.BE.dg).DF(435,85).DI(5.1,0.65).DL(212,38.0).DO(6.95,0.65).DR(46.5,3.0).DU(0.658,3.01).DX(15.0,3.0).Du(30.0,0).Dw(550).Dy(325);
		boot.O.b.ET(boot.BE.dh).DF(421,80).DI(7.45,0.55).DR(51.7,3.5).DU(0.694,3.0).DX(15.0,3.5).Du(30.0,1.25).Dw(125).Dy(340);
		boot.O.b.ET(boot.BE.di).DF(403,86).DI(4.7,0.6).DL(240,60.0).DO(6.8,0.65).DR(51.58,3.5).DU(0.579,1.53).DX(15.0,3.8).Du(30.0,0).Dw(425).Dy(335);
		boot.O.b.ET(boot.BE.dj).DF(365,74).DI(4.5,45.0).DL(305,43.0).DO(6.9,0.6).DR(48.0,3.1).DU(0.644,2.6).DX(9.0,4.0).Du(30.0,0).Dw(550).Dy(330);
		boot.O.b.ET(boot.BE.dk).DF(410,90).DI(7.5,0.9).DL(200,45.0).DO(6.6,0.5).DR(53.3,3.5).DU(0.638,3.48).DX(15.0,3.5).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.dl).DF(432,86).DI(7.45,0.55).DL(200,50.0).DO(7.45,0.7).DR(52.0,3.3).DU(0.613,0.98).DX(12.0,3.25).Du(30.0,1.25).Dw(175).Dy(325);
		boot.O.b.ET(boot.BE.dm).DF(370,90).DI(5.0,0.6).DL(220,45.0).DO(7.0,0.5).DR(49.0,3.5).DU(0.672,3.22).DX(11.0,3.5).Du(30.0,10.75).Dw(525).Dy(335);
		boot.O.b.ET(boot.BE.dn).DF(430,85).DI(7.0,0.75).DL(215,35.0).DO(6.0,0.45).DR(54.0,3.1).DU(0.668,2.7).DX(17.0,3.5).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.dp).DF(437,108).DI(7.05,0.8).DL(213,42.0).DO(6.6,0.5).DR(51.6,3.4).DU(0.625,2.25).DX(16.5,3.5).Du(30.0,1.25).Dw(125).Dy(340);
		boot.O.b.ET(boot.BE.ea).DF(441,93).DI(7.0,0.9).DL(225,45.0).DO(6.5,0.575).DR(54.1,3.5).DU(0.694,2.7).DX(17.0,3.0).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.eb).DF(385,79).DI(5.95,0.55).DL(250,50.0).DO(7.0,0.5).DR(44.0,2.6).DU(0.658,3.5).DX(8.0,3.0).Du(30.0,0).Dw(525).Dy(325);
		boot.O.b.ET(boot.BE.ec).DF(433,87).DI(6.75,0.65).DL(210,34.0).DO(6.6,0.45).DR(50.7,2.9).DU(0.679,2.95).DX(17.1,3.9).Du(30.0,1.25).Dw(155).Dy(355);
		boot.O.b.ET(boot.BE.ed).DF(423,81).DI(7.45,0.55).DL(185,30.0).DO(6.4,0.45).DR(56.3,3.375).DU(0.638,3.35).DX(18.0,4.0).Du(30.0,0).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.ee).DF(420,86).DI(8.0,0.55).DL(255,33.0).DO(4.5,0.3).DR(50.0,3.5).DU(0.625,2.22).DX(21.0,3.8).Du(30.0,1.25).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.ef).DF(426,87).DI(6.7,0.75).DR(53.12,3.1).DU(0.665,2.65).DX(15.2,3.8).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.eg).DF(435,85).DI(4.0,0.4).DR(55.0,3.0).DU(0.679,2.85).DX(16.0,3.5).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.eh).DF(414,86).DI(10.4,0.9).DR(54.0,2.75).DU(0.625,3.5).DX(15.0,3.1).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.ei).DF(450,80).DI(7.0,0.7).DR(55.32,3.2).DU(0.644,1.85).DX(16.0,3.5).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.ej).DF(360,86).DI(4.35,0.55).DL(250,55.0).DO(7.0,0.6).DR(52.0,3.0).DU(0.625,2.11).DX(11.0,3.9).Du(30.0,0).Dw(550).Dy(335);
		boot.O.b.ET(boot.BE.ek).DF(450,85).DI(7.35,0.85).DL(220,40.0).DO(6.45,0.45).DR(54.0,3.4).DU(0.67,1.45).DX(20.5,3.5).Du(30.0,1.25).Dw(125).Dy(340);
		boot.O.b.ET(boot.BE.el).DF(441,84).DI(7.45,0.55).DL(270,40.0).DO(6.4,0.45).DR(51.7,3.5).DU(0.694,3.0).DX(15.0,3.5).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.em).DF(428,85).DI(7.45,0.55).EA(200).EC(50).DR(54.5,3.375).DU(0.651,3.4).DX(15.0,4.0).Du(30.0,0).Dw(125).Dy(335);
		boot.O.b.ET(boot.BE.en).DF(435,95).DI(7.2,0.8).DR(54.5,3.4).DU(0.658,3.4).DX(17.6,3.4).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.eo).DF(405,82).DI(7.1,0.55).DL(215,45.0).DO(6.6,0.55).DR(56.65,3.375).DU(0.613,1.81).DX(18.0,3.5).Du(30.0,0).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.ep).DF(403,104).DI(7.9,0.95).DL(240,40.0).DO(6.3,0.4).DR(55.52,3.1875).DU(0.625,1.63).DX(17.75,3.25).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.fa).DF(378,82).DI(4.25,0.55).DL(203,43.0).DO(6.5,0.5).DR(49.0,2.9).DU(0.658,3.28).DX(12.75,3.25).Du(30.0,0).Dw(500).Dy(335);
		boot.O.b.ET(boot.BE.fb).DF(440,96).DI(7.5,0.85).DL(205,40.0).DO(6.45,0.45).DR(54.1,4.2).DU(0.625,2.1).DX(19.0,3.8).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.fc).DF(340,70).DI(4.5,0.55).DL(265,45.0).DO(7.0,0.65).DR(47.0,3.0).DU(0.644,2.3).DX(6.0,3.3).Du(30.0,0).Dw(550).Dy(330);
		boot.O.b.ET(boot.BE.fd).DF(375,71).DI(4.5,0.55).DL(240,60.0).DO(6.8,0.65).DR(48.8,3.0).DU(0.625,2.14).DX(7.4,3.8).Du(30.0,0).Dw(550).Dy(335);
		boot.O.b.ET(boot.BE.fe).DF(385,78).DI(6.75,0.65).DL(240,50.0).DO(6.8,0.65).DR(49.0,3.0).DU(0.625,2.11).DX(12.0,4.0).Du(30.0,0).Dw(500).Dy(335);
		boot.O.b.ET(boot.BE.ff).DF(380,78).DI(5.5,0.6).DL(250,50.0).DO(6.9,0.6).DR(51.0,2.9).DU(0.625,2.0).DX(15.0,3.4).Du(30.0,0).Dw(550).Dy(330);
		boot.O.b.ET(boot.BE.fg).DF(440,85).DI(7.25,0.75).DL(260,40.0).DO(6.75,0.5).DR(50.0,3.1).DU(0.668,2.7).DX(17.0,3.5).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.fh).DF(468,90).DI(7.1,0.5).DL(255,56.0).DO(4.1,0.4).DR(58.0,3.5).DU(0.625,2.02).DX(16.5,3.2).Du(30.0,1.25).Dw(125).Dy(340);
		boot.O.b.ET(boot.BE.fi).DF(383,82).DI(4.65,0.65).DL(200,40.0).DO(6.45,0.45).DR(44.5,3.0).DU(0.69,3.38).DX(14.0,3.75).Du(30.0,0).Dw(500).Dy(330);
		boot.O.b.ET(boot.BE.fj).DF(415,82).DI(5.1,0.65).DL(193,32.0).DO(6.45,0.45).DR(46.5,3.0).DU(0.658,3.01).DX(15.0,3.0).Du(30.0,0).Dw(550).Dy(325);
		boot.O.b.ET(boot.BE.fk).DF(455,96).DI(8.0,0.85).DL(206,45.0).DO(6.9,0.6).DR(54.66,3.0).DU(0.672,2.9).DX(19.0,2.7).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.fl).DF(461,98).DI(7.9,0.9).DR(56.0,3.2).DU(0.644,2.9).DX(14.9,3.1).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.fm).DF(384,82).DI(4.5,0.6).DL(202,38.0).DO(6.5,0.5).DR(46.61,3.3).DU(0.651,3.22).DX(111.25,3.15).Du(30.0,0).Dw(525).Dy(330);
		boot.O.b.ET(boot.BE.fn).DF(389,81).DI(5.0,0.6).DL(220,40.0).DO(6.5,0.45).DR(49.0,3.0).DU(0.679,3.38).DX(14.0,3.0).Du(30.0,0).Dw(550).Dy(330);
		boot.O.b.ET(boot.BE.fo).DF(427,99).DI(7.45,0.75).DL(220,30.0).DO(6.4,0.45).DR(52.91,3.2).DU(0.658,2.67).DX(14.75,4.0).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.fp).DF(437,89).DI(5.5,0.6).DL(220,55.0).DO(7.5,0.65).DR(48.0,3.6).DU(0.644,2.9).DX(15.0,3.3).Du(30.0,0).Dw(425).Dy(335);
		boot.O.b.ET(boot.BE.ga).DF(400,82).DI(4.5,0.55).DL(250,36.0).DO(6.5,0.5).DR(46.0,3.0).DU(0.658,2.65).DX(13.5,3.4).Du(30.0,0).Dw(575).Dy(335);
		boot.O.b.ET(boot.BE.gb).DF(359,83).DI(4.5,0.55).DL(173,27.0).DO(6.3,0.4).DR(50.0,3.25).DU(0.658,3.1).DX(9.3,3.4).Du(30.0,0).Dw(550).Dy(330);
		boot.O.b.ET(boot.BE.gc).DF(355,82).DI(4.5,0.55).DL(250,55.0).DO(6.9,0.6).DR(48.3,2.625).DU(0.625,2.24).DX(12.25,3.75).Du(30.0,0).Dw(525).Dy(340);
		boot.O.b.ET(boot.BE.gd).DF(440,85).DI(7.5,0.9).DL(220,45.0).DO(7.0,0.65).DR(55.0,3.5).DU(0.643,2.5).DX(16.0,3.5).Du(30.0,1.25).Dw(125).Dy(350);
		boot.O.b.ET(boot.BE.ge).DF(385,78).DI(6.75,0.65).DL(240,50.0).DO(6.9,0.45).DR(49.0,3.0).DU(0.625,2.11).DX(12.0,4.0).Du(30.0,0).Dw(525).Dy(335);
		boot.O.b.ET(boot.BE.gf).DF(400,85).DI(6.0,0.6).DR(45.0,3.0).DU(0.6258,2.0).DX(12.0,3.5).Du(30.0,0).Dw(450).Dy(335);
		boot.O.b.ET(boot.BE.gg).DF(440,86).DI(7.0,0.65).DL(220,30.0).DO(7.0,0.65).DR(54.0,3.3).DU(0.625,2.9).DX(16.5,3.5).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.gh).DF(428,98).DI(7.05,0.8).DL(190,30.0).DO(7.1,0.6).DR(56.76,3.375).DU(0.679,2.88).DX(16.0,3.5).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.gi).DF(435,85).DI(5.1,0.65).DL(202,38.0).DO(6.9,0.65).DR(54.0,3.2).DU(0.658,3.0).DX(15.0,3.5).Du(30.0,1.25).Dw(175).Dy(345);
		boot.O.b.ET(boot.BE.gj).DF(380,80).DI(5.0,0.55).DL(250,45.0).DO(8.0,0.6).DR(52.0,3.0).DU(0.625,1.36).DX(12.6,3.4).Du(30.0,0).Dw(550).Dy(340);
		boot.O.b.ET(boot.BE.gk).DF(445,87).DI(7.0,0.7).DL(213,31.0).DO(6.6,0.45).DR(52.0,3.3).DU(0.672,2.7).DX(16.2,3.7).Du(30.0,1.25).Dw(175).Dy(345);
		boot.O.b.ET(boot.BE.gl).DF(421,85).DI(8.5,0.7).DL(235,35.0).DO(6.5,0.45).DR(51.5,3.5).DU(0.625,3.0).DX(18.0,3.6).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.gm).DF(445,85).DI(6.0,0.65).EA(20).EC(50).DR(48.6,3.4).DU(0.658,3.1).DX(17.5,3.5).Du(30.0,1.25).Dw(125).Dy(345);
		boot.O.b.ET(boot.BE.gn).DF(390,80).DI(5.25,0.6).DL(250,50.0).DO(6.75,0.6).DR(54.0,3.1).DU(0.656,1.7).DX(12.0,3.3).Du(30.0,0).Dw(575).Dy(330);
		boot.O.b.ET(boot.BE.go).DF(380,71).DI(4.6,0.5).DL(260,60.0).DO(6.95,0.65).DR(48.6,3.0).DU(0.625,2.13).DX(6.75,3.8).Du(30.0,0).Dw(600).Dy(335);
		boot.O.b.ET(boot.BE.gp).DF(355,74).DI(4.85,0.5).DL(250,50.0).DO(7.1,0.75).DR(50.0,3.2).DU(0.625,1.8).DX(11.0,3.0).Du(30.0,0).Dw(575).Dy(325);
		boot.O.c=new boot.O(1520,2012,12,3,"Preseason 3",boot.O.b,0);
		boot.O.c.EP("Shard of True Ice");
		boot.O.c.EP("Liandry's Torment");
		boot.O.c.EP("Haunting Guise");
		boot.O.a=boot.O.c;
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
	EP:function(A,B){
		B=new boot.Bu(A,this,0);
		this.e.CQ(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	ET:function(A){
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
		M:function() {return true;},N:function() {return 10;},O:function() {return 4;},P:function() {return 10;},Q:function() {return 10.0;},R:function() {return 10.0;},S:function() {return 10;}
	}]],"L":[["Q",{
	}]]
});

try {new boot.B(0).A();} catch(e) {console.log(e)}