boot.define("R","",{
	
	// booton.translator.js.JSAnnotatedElement#<init>(java.lang.String, booton.translator.js.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// booton.translator.js.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	U:function(A){
		return this.I(A)!=null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotation(java.lang.Class)
	I:function(A,B,C){
		if(this.b==null){
		}else{
			B=0;
			l4:for (;
			B<this.b.length;
			++B) {
				C=this.b[B];
				if(C[0].equals(A.V())==0){
				}else{
					return C[1];
				}
			}
		}return null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotations()
	W:function(){
		return null;
	},
	// booton.translator.js.JSAnnotatedElement#getDeclaredAnnotations()
	X:function(){
		return this.W();
	}
});

boot.define("I","R",{
	
	// booton.translator.js.JSConstructor#<init>(booton.translator.js.JSClass, java.lang.String, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.R.prototype.$0.call(this,B,D);
		this.c=A;
		this.d=C;
	},
	// booton.translator.js.JSConstructor#newInstance(java.lang.Object[])
	w:function(A){
	console.log(new this.c.$(this.a.substring(1)), this.c.$.prototype, A);
	  var instance = Object.create(this.c.$.prototype);
    this.c.$.apply(instance, A);
    return instance;
      
		// return new this.c.$(this.a.substring(1));
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
	H:function(A,B,C,D){
		A=[];
		B=this.c.keys();
		C=0;
		l4:while (C<B.length) {
			D=B[C];
			if(D.startsWith("$")==0){
			}else{
				A.push(new boot.I(this,D,this.c[D],this.d[D],0));
			}++C;
			continue l4;
		}return A;
	},
	// booton.translator.js.JSClass#getName()
	Y:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	V:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	Z:function(){
		return null;
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

boot.define("V","",{
});

boot.define("T","",{
});

boot.define("U","",{
	
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
		D=A.y();
		l2:while (D.BC()!=0) {
			C=D.z();
			if(this.F(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	BH:function(A,B,C,D){
		B=0;
		D=this.y();
		l2:while (D.BC()!=0) {
			C=D.z();
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
		D=A.y();
		l2:while (D.BC()!=0) {
			C=D.z();
			if(this.BJ(C)==0){
			}else{
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	BL:function(A,B,C){
		C=A.y();
		l1:while (C.BC()!=0) {
			B=C.z();
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
		}C=this.y();
		D=0;
		l6:while (C.BC()!=0) {
			E=C.z();
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
	BC:function(){
		return this.b<boot.S.Bu(this.a).length;
	},
	// js.util.ArrayList$View#next()
	z:function(){
		return boot.S.Bu(this.a)[this.b++];
	},
	// js.util.ArrayList$View#remove()
	Bv:function(){
		if(this.b<=0){
		}else{
			boot.S.Bu(this.a).splice(this.b-1,1)[0];
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
	Bw:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	Bx:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	Bz:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	CA:function(){
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
	BF:function(){
		return this.a.length;
	},
	// js.util.ArrayList#contains(java.lang.Object)
	BI:function(A){
		return this.a.indexOf(A)!=-1;
	},
	// js.util.ArrayList#iterator()
	y:function(){
		return new boot.W(this,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	F:function(A){
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
		throw new boot.X(0);
	},
	// js.util.ArrayList#listIterator(int)
	BX:function(A){
		throw new boot.X(0);
	},
	// js.util.ArrayList#subList(int, int)
	BY:function(A,B){
		throw new boot.X(0);
	},
	// js.util.ArrayList#checkRange(int)
	BZ:function(A){
		if(A>=0){
			if(this.BF()>A){
				return;
			}else{
				throw new boot.Y("Index is overflowed. Size: "+this.BF()+"  Index: "+A,0);
			}
		}else{
			throw new boot.Y("Negative index is unacceptable. Size: "+this.BF()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_Bu:function(A){
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

boot.define("H","",{
},{
	"$":[["x",{
	}],["y",{
		CD:function() {return [CONSTRUCTOR,TYPE];}
	}],["z",{
		CE:function() {return RUNTIME;}
	}]]
});

boot.define("F","",{
	
	// js.Application$Route#<init>(java.lang.String, java.lang.Class)
	$2:function(A,B){
		this.a=new RegExp(A.replace(/\*/g,"([^/].+)"),"");
		this.b=B;
	},
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo)
	$3:function(A,B){
		this.a=new RegExp(B.CB().replace(/\*/g,"([^/].+)"),"");
		this.b=null;
		this.c=A;
	},
	// js.Application$Route#match(java.lang.String)
	CC:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.S(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.F(B[D+1]);
			}try{
				return this.c.w(C.BM());
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
	_BA:function(A,B){
		return A.CC(B);
	},
	// js.Application$Route#<init>(java.lang.String, java.lang.Class, js.Application$Route)
	$0:function(A,B,C){
		boot.F.prototype.$2.call(this,A,B);
	},
	// js.Application$Route#<init>(java.lang.reflect.Constructor, js.PageInfo, js.Application$Route)
	$1:function(A,B,C){
		boot.F.prototype.$3.call(this,A,B);
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
	BC:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	CH:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	Bv:function(){
	},
	// booton.translator.web.jQuery$1#next()
	z:function(){
		return this.CH();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	CF:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	CG:function(A){
		return this.CF("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	y:function(){
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
		this.x(location.hash);
	},
	// js.Application$Router#dispatch(java.lang.String)
	x:function(A,B,C,D,E){
		if((A.length==0||A.startsWith("#")==0)){
		}else{
			A=A.substring(1);
		}C=this.a.y();
		l3:while (C.BC()!=0) {
			B=C.z();
			D=boot.F.BA(B,A);
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
	BD:function(A,B){
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
		A.x(B);
	},
	// js.Application$Router#access$2(js.Application$Router)
	_E:function(A){
		return A.a;
	}
},{
	"BD":[["Q",{
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
	// js.Application#register(java.lang.Class)
	G:function(A,B,C,D){
		B=A.H();
		C=0;
		l3:while (C<B.length) {
			D=B[C].I(boot.H.$);
			if(D==null){
			}else{
				boot.E.E(boot.C.a).F(new boot.F(B[C],D,null,1));
			}++C;
			continue l3;
		}
	},
	// js.Application#show(js.Page)
	_J:function(A){
		if(A==null){
		}else{
			boot.E.B(boot.C.a,A.K());
			history.pushState("","","#"+A.K());
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
	BC:function(){
		return this.b<this.c.length;
	},
	// js.util.HashSet$View#next()
	z:function(){
		this.d=boot.BL.DC(this.a)[this.c[this.b++]];
		return this.d;
	},
	// js.util.HashSet$View#remove()
	Bv:function(){
		if(this.b<=0){
		}else{
			this.a.BJ(this.d);
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
	BF:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BI:function(A){
		return this.DB(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	F:function(A,B){
		B=this.DB(A);
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
		B=this.DB(A);
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
		this.b=[];
	},
	// js.util.HashSet#iterator()
	y:function(){
		return new boot.BS(this,this.b.keys(),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	DB:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	CX:function(A){
		return this.b[this.DB(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	CZ:function(A,B,C){
		B=null;
		C=this.DB(A);
		if(C in this.b==0){
			this.a=this.a+1;
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	Cv:function(A,B,C){
		B=null;
		C=this.DB(A);
		if(C in this.b==0){
		}else{
			B=this.b[C];
			this.a=this.a-1;
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_DC:function(A){
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
	Cy:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	CY:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	DD:function(A,B){
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
	BC:function(){
		return this.b.BC();
	},
	// js.util.HashMap$View#next()
	z:function(A){
		A=this.b.z();
		if(this.c==0){
			return A.CY();
		}else{
			return A.Cy();
		}
	},
	// js.util.HashMap$View#remove()
	Bv:function(){
		this.b.Bv();
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
	BF:function(){
		return boot.BJ.DA(this.a).BF();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BI:function(A){
		return boot.BJ.DA(this.a).BI(A);
	},
	// js.util.HashMap$Keys#iterator()
	y:function(){
		return new boot.BT(this.a,boot.BJ.DA(this.a).y(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BJ:function(A){
		return boot.BJ.DA(this.a).BJ(A);
	},
	// js.util.HashMap$Keys#clear()
	BP:function(){
		boot.BJ.DA(this.a).BP();
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
	BF:function(){
		return boot.BJ.DA(this.a).BF();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BI:function(A){
		return this.a.CW(A);
	},
	// js.util.HashMap$Values#iterator()
	y:function(){
		return new boot.BT(this.a,boot.BJ.DA(this.a).y(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	F:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BJ:function(A,B,C){
		B=this.y();
		l2:while (B.BC()!=0) {
			C=B.z();
			if(C!=A){
			}else{
				B.Bv();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BP:function(){
		boot.BJ.DA(this.a).BP();
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
	BF:function(){
		return this.a.BF();
	},
	// js.util.HashMap#isEmpty()
	BE:function(){
		return this.a.BE();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	CV:function(A){
		return this.a.BI(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	CW:function(A,B,C){
		C=this.CU().y();
		l1:while (C.BC()!=0) {
			B=C.z();
			if(B!=A){
			}else{
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	CS:function(A,B){
		B=this.a.CX(A);
		return (B==null?null:B.CY());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	CR:function(A,B,C){
		C=this.a.CZ(new boot.BN(A,B,null,0));
		if(C!=null){
			return C.CY();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	Cu:function(A,B){
		B=this.a.Cv(A);
		if(B!=null){
			return B.CY();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	Cw:function(A,B,C){
		C=A.Cx().y();
		l1:for (;
		C.BC()!=0;
		this.CR(B.Cy(),B.CY())) {
			B=C.z();
		}
	},
	// js.util.HashMap#clear()
	BP:function(){
		this.a.BP();
	},
	// js.util.HashMap#keySet()
	Cz:function(){
		return new boot.BP(this,null,0);
	},
	// js.util.HashMap#values()
	CU:function(){
		return new boot.BQ(this,null,0);
	},
	// js.util.HashMap#entrySet()
	Cx:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_DA:function(A){
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
		this.ha=this.CQ().toLowerCase();
		boot.BE.b.CR(A,this);
	},
	// teemowork.model.Champion#getStatus()
	CM:function(){
		return this.hb;
	},
	// teemowork.model.Champion#getSystemName()
	CQ:function(){
		return this.a.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	CJ:function(){
		return "src/main/resources/teemowork/splash/"+this.CQ()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	CK:function(){
		return "src/main/resources/teemowork/icon/"+this.CQ()+".png";
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_CI:function(A){
		return boot.BE.b.CS(A);
	},
	// teemowork.model.Champion#getAll()
	_CT:function(){
		return boot.BE.b.CU();
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
		boot.K.CP(this.a,boot.K.CO(this.a)+1);
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
		boot.K.CP(this.a,boot.K.CO(this.a)-1);
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
	DE:function(){
		return this.c;
	},
	// teemowork.model.ChampionStatus#healthPerLevel()
	DF:function(){
		return this.d;
	},
	// teemowork.model.ChampionStatus#health(int, int)
	DG:function(A,B){
		this.c=A;
		this.d=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getHregInitial()
	DH:function(){
		return this.e;
	},
	// teemowork.model.ChampionStatus#getHregPerLvel()
	DI:function(){
		return this.f;
	},
	// teemowork.model.ChampionStatus#hreg(double, double)
	DJ:function(A,B,C,D){
		this.e=A;
		this.f=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getManaInitial()
	DK:function(){
		return this.g;
	},
	// teemowork.model.ChampionStatus#getManaPerLvel()
	DL:function(){
		return this.h;
	},
	// teemowork.model.ChampionStatus#mana(int, double)
	DM:function(A,B,C){
		this.g=A;
		this.h=B;
		return this;
	},
	// teemowork.model.ChampionStatus#getMregInitial()
	DN:function(){
		return this.i;
	},
	// teemowork.model.ChampionStatus#getMregPerLvel()
	DO:function(){
		return this.j;
	},
	// teemowork.model.ChampionStatus#mreg(double, double)
	DP:function(A,B,C,D){
		this.i=A;
		this.j=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAdInitial()
	DQ:function(){
		return this.k;
	},
	// teemowork.model.ChampionStatus#getAdPerLvel()
	DR:function(){
		return this.l;
	},
	// teemowork.model.ChampionStatus#ad(double, double)
	DS:function(A,B,C,D){
		this.k=A;
		this.l=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getAsInitial()
	DT:function(){
		return this.m;
	},
	// teemowork.model.ChampionStatus#getAsPerLvel()
	DU:function(){
		return this.n;
	},
	// teemowork.model.ChampionStatus#as(double, double)
	DV:function(A,B,C,D){
		this.m=A;
		this.n=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getArInitial()
	DW:function(){
		return this.o;
	},
	// teemowork.model.ChampionStatus#getArPerLvel()
	DX:function(){
		return this.p;
	},
	// teemowork.model.ChampionStatus#ar(double, double)
	DY:function(A,B,C,D){
		this.o=A;
		this.p=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getMrInitial()
	DZ:function(){
		return this.ba;
	},
	// teemowork.model.ChampionStatus#getMrPerLvel()
	Du:function(){
		return this.bb;
	},
	// teemowork.model.ChampionStatus#mr(double, double)
	Dv:function(A,B,C,D){
		this.ba=A;
		this.bb=C;
		return this;
	},
	// teemowork.model.ChampionStatus#getRange()
	Dw:function(){
		return this.bc;
	},
	// teemowork.model.ChampionStatus#range(int)
	Dx:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getMs()
	Dy:function(){
		return this.bd;
	},
	// teemowork.model.ChampionStatus#ms(int)
	Dz:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEnergy()
	EA:function(){
		return this.be;
	},
	// teemowork.model.ChampionStatus#energy(int)
	EB:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getEreg()
	EC:function(){
		return this.bf;
	},
	// teemowork.model.ChampionStatus#ereg(int)
	ED:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.ChampionStatus#getHealth(int)
	CN:function(A){
		return this.c+this.d*A;
	},
	// teemowork.model.ChampionStatus#getMana(int)
	EE:function(A){
		return this.g+this.h*A;
	}
});

boot.define("K","J",{
	
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.K.prototype.$1.call(this,boot.BE.CI(A));
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
	BB:function(A,B,C){
		B=A.CG("a").css("background-image","url('"+this.a.CJ()+"')").CG("b");
		C=B.CG("c").css("background-image","url("+this.a.CK()+")").click(new boot.BF(this,0)).on("contextmenu",new boot.BG(this,0));
		this.b=C.CG("d");
		this.c=B.CG("e").text("Health").CG("f");
		this.CL(1);
	},
	// teemowork.ChampionDetail#setLevel(int)
	CL:function(A,B){
		if((A<1||18<A)){
			return;
		}else{
			this.d=A;
			this.b.text(""+A);
			B=this.a.CM();
			this.c.text(""+B.CN(A));
			return;
		}
	},
	// teemowork.ChampionDetail#getPageId()
	K:function(){
		return "Champion/"+this.a.a;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_CO:function(A){
		return A.d;
	},
	// teemowork.ChampionDetail#access$1(teemowork.ChampionDetail, int)
	_CP:function(A,B){
		A.CL(B);
	}
},{
	"$0":[["H",{
		CB:function() {return "Champion/*";}
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
		D=boot.BW.EK(this.a).Cx().y();
		l2:while (D.BC()!=0) {
			C=D.z();
			if(this.a.EJ(C.Cy()).toLowerCase().indexOf(B) != -1==0){
				C.CY().addClass("j");
				continue l2;
			}else{
				C.CY().removeClass("j");
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
		this.a.EL(this.b);
	}
});

boot.define("BW","BX",{
	
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.BX.prototype.$0.call(this);
		this.b=new boot.BJ(0);
		this.c=this.EH();
	},
	// js.ui.ImageGrid#compose(booton.translator.web.jQuery)
	EG:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("g").css("display","block");
		B.keyup(new boot.BY(this,B,0));
		D=this.c.y();
		l6:for (;
		D.BC()!=0;
		this.b.CR(C,E)) {
			C=D.z();
			E=this.a.CG("h").css("background-image","url("+this.EI(C)+")");
			E.CF("span").addClass("i").text(this.EJ(C));
			E.click(new boot.BZ(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_EK:function(A){
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
	EH:function(){
		return boot.BE.CT();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	EM:function(A){
		return A.a;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	EO:function(A){
		return A.CK();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	EP:function(A){
		boot.C.J(new boot.K(A.a,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	EJ:function(A){
		return this.EM(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	EI:function(A){
		return this.EO(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	EL:function(A){
		this.EP(A);
	}
});

boot.define("L","J",{
	
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.J.prototype.$0.call(this);
		this.a=new boot.BV(this,0);
	},
	// teemowork.ChampionSelect#load(booton.translator.web.jQuery)
	BB:function(A){
		this.a.EG(A);
	},
	// teemowork.ChampionSelect#getPageId()
	K:function(){
		return "";
	}
},{
	"$0":[["H",{
		CB:function() {return "";}
	}]]
});

boot.define("N","",{
	
	// js.application.Header$Menu#<init>(js.application.Header, booton.translator.web.jQuery)
	$1:function(A,B){
		this.a=A;;
		this.b=B.CF("ul").addClass("n");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	L:function(A,B,C){
		C=this.b.CF("li").addClass("o");
		C.CF("a").addClass("m").attr("href",B).text(A);
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
	L:function(A,B,C){
		C=this.a.CF("li").addClass("l");
		C.CF("a").addClass("m").attr("href",B).text(A);
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
		C=boot.Bu.a.CS(A);
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
		boot.Bu.a.CR(A,this);
	},
	// teemowork.model.Item#cost()
	EV:function(){
		return this.d;
	},
	// teemowork.model.Item#cost(int)
	ER:function(A){
		this.d=A;
		return this;
	},
	// teemowork.model.Item#ad()
	EW:function(){
		return this.e;
	},
	// teemowork.model.Item#ad(int)
	EX:function(A){
		this.e=A;
		return this;
	},
	// teemowork.model.Item#as()
	EY:function(){
		return this.f;
	},
	// teemowork.model.Item#as(int)
	EZ:function(A){
		this.f=A;
		return this;
	},
	// teemowork.model.Item#critical()
	Eu:function(){
		return this.g;
	},
	// teemowork.model.Item#critical(int)
	Ev:function(A){
		this.g=A;
		return this;
	},
	// teemowork.model.Item#arpen()
	Ew:function(){
		return this.h;
	},
	// teemowork.model.Item#arpen(int)
	Ex:function(A){
		this.h=A;
		return this;
	},
	// teemowork.model.Item#arpenRatio()
	Ey:function(){
		return this.i;
	},
	// teemowork.model.Item#arpenRatio(int)
	Ez:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.Item#ls()
	FA:function(){
		return this.j;
	},
	// teemowork.model.Item#ls(int)
	FB:function(A){
		this.j=A;
		return this;
	},
	// teemowork.model.Item#ap()
	FC:function(){
		return this.k;
	},
	// teemowork.model.Item#ap(int)
	ET:function(A){
		this.k=A;
		return this;
	},
	// teemowork.model.Item#mrpen()
	FD:function(){
		return this.l;
	},
	// teemowork.model.Item#mrpen(int)
	FE:function(A){
		this.l=A;
		return this;
	},
	// teemowork.model.Item#mrpenRatio()
	FF:function(){
		return this.m;
	},
	// teemowork.model.Item#mrpenRatio(int)
	FG:function(A){
		this.m=A;
		return this;
	},
	// teemowork.model.Item#cdr()
	FH:function(){
		return this.n;
	},
	// teemowork.model.Item#cdr(int)
	FI:function(A){
		this.n=A;
		return this;
	},
	// teemowork.model.Item#sv()
	FJ:function(){
		return this.o;
	},
	// teemowork.model.Item#sv(int)
	FK:function(A){
		this.o=A;
		return this;
	},
	// teemowork.model.Item#health()
	FL:function(){
		return this.p;
	},
	// teemowork.model.Item#health(int)
	ES:function(A){
		this.p=A;
		return this;
	},
	// teemowork.model.Item#hreg()
	FM:function(){
		return this.ba;
	},
	// teemowork.model.Item#hreg(int)
	FN:function(A){
		this.ba=A;
		return this;
	},
	// teemowork.model.Item#mreg()
	FO:function(){
		return this.bb;
	},
	// teemowork.model.Item#mreg(int)
	FP:function(A){
		this.bb=A;
		return this;
	},
	// teemowork.model.Item#ar()
	FQ:function(){
		return this.bc;
	},
	// teemowork.model.Item#ar(int)
	FR:function(A){
		this.bc=A;
		return this;
	},
	// teemowork.model.Item#mr()
	FS:function(){
		return this.bd;
	},
	// teemowork.model.Item#mr(int)
	FT:function(A){
		this.bd=A;
		return this;
	},
	// teemowork.model.Item#ms()
	FU:function(){
		return this.be;
	},
	// teemowork.model.Item#ms(int)
	FV:function(A){
		this.be=A;
		return this;
	},
	// teemowork.model.Item#msRatio()
	FW:function(){
		return this.bf;
	},
	// teemowork.model.Item#msRatio(int)
	FX:function(A){
		this.bf=A;
		return this;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_FY:function(A){
		return boot.Bu.a.CS(A);
	},
	// teemowork.model.Item#getAll()
	_CT:function(){
		return boot.Bu.a.CU();
	}
});

boot.define("O","",{
	
	// teemowork.model.Patch#<clinit>()
	_:function(){
		boot.O.b=new boot.O(1510,2012,11,13,"Initial",null,0);
		boot.O.b.EQ("Ruby Crystal").ER(475).ES(180);
		boot.O.b.EQ("Haunting Guise").ES(200).ET(25);
		boot.O.b.EU(boot.BE.c).DG(380,80).DJ(5.5,0.6).DM(230,50.0).DP(6.25,0.6).DS(50.0,3.0).DV(0.668,2.0).DY(10.0,3.5).Dv(30.0,0).Dx(550).Dz(330);
		boot.O.b.EU(boot.BE.d).DG(445,85).DJ(7.25,0.65).EB(200).ED(50).DS(53.0,3.2).DV(0.694,3.1).DY(16.5,3.5).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.e).DG(442,102).DJ(7.25,0.85).DM(215,38.0).DP(6.45,0.45).DS(55.03,3.62).DV(0.625,3.62).DY(14.5,3.5).Dv(30.0,1.25).Dx(125).Dz(325);
		boot.O.b.EU(boot.BE.f).DG(472,84).DJ(7.45,0.85).DM(220,40.0).DP(6.5,0.525).DS(47.0,3.8).DV(0.638,2.18).DY(18.0,3.3).Dv(30.0,1.25).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.g).DG(350,70).DJ(4.65,0.55).DM(257,53.0).DP(7.0,0.6).DS(48.0,3.2).DV(0.625,1.68).DY(10.5,4.0).Dv(30.0,0).Dx(600).Dz(325);
		boot.O.b.EU(boot.BE.h).DG(384,76).DJ(4.5,0.55).DM(250,50.0).DP(6.9,0.6).DS(49.0,2.625).DV(0.579,1.36).DY(12.5,4.0).Dv(30.0,0).Dx(625).Dz(335);
		boot.O.b.EU(boot.BE.i).DG(395,79).DJ(4.5,0.55).DM(173,35.0).DP(6.3,0.4).DS(46.3,2.85).DV(0.658,3.34).DY(11.5,3.4).Dv(30.0,0).Dx(600).Dz(325);
		boot.O.b.EU(boot.BE.j).DG(423,95).DJ(7.25,0.75).DM(260,40.0).DP(6.6,0.5).DS(55.66,3.5).DV(0.625,1.13).DY(14.5,3.5).Dv(30.0,1.25).Dx(125).Dz(325);
		boot.O.b.EU(boot.BE.k).DG(380,76).DJ(4.5,0.55).DM(250,45.0).DP(7.0,0.6).DS(51.66,3.0).DV(0.625,1.36).DY(12.0,3.5).Dv(30.0,0).Dx(550).Dz(340);
		boot.O.b.EU(boot.BE.l).DG(390,80).DJ(4.75,0.55).DM(255,35.0).DP(6.5,0.55).DS(47.0,3.0).DV(0.668,3.0).DY(13.0,3.5).Dv(30.0,0).Dx(650).Dz(325);
		boot.O.b.EU(boot.BE.m).DG(380,75).DJ(4.85,0.5).DM(250,50.0).DP(7.1,0.75).DS(47.0,3.2).DV(0.644,1.68).DY(11.5,4.0).Dv(30.0,0).Dx(550).Dz(335);
		boot.O.b.EU(boot.BE.n).DG(440,80).DJ(7.5,0.85).DM(205,40.0).DP(6.45,0.45).DS(54.1,4.2).DV(0.625,1.44).DY(19.0,3.5).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.o).DG(375,82).DJ(4.5,0.55).DM(243,37.0).DP(6.5,0.55).DS(48.2,3.0).DV(0.658,2.3).DY(13.5,3.5).Dv(30.0,0).Dx(550).Dz(325);
		boot.O.b.EU(boot.BE.p).DG(426,93).DJ(8.25,0.95).DM(200,37.5).DP(6.0,0.35).DS(50.0,3.5).DV(0.679,2.6).DY(20.0,3.5).Dv(30.0,1.25).Dx(125).Dz(340);
		boot.O.b.EU(boot.BE.ba).DG(438,90).DJ(7.0,0.85).DM(230,40.0).DP(7.0,0.6).DS(48.0,3.0).DV(0.625,2.25).DY(16.0,3.6).Dv(30.0,1.25).Dx(150).Dz(345);
		boot.O.b.EU(boot.BE.bb).DG(433,89).DJ(6.5,0.75).DS(56.23,3.0).DV(0.625,2.8).DY(17.0,3.5).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.bc).DG(420,82).DJ(5.0,0.7).DM(240,42.0).DP(6.95,0.65).DS(46.5,3.5).DV(0.679,2.6).DY(16.0,3.3).Dv(30.0,0).Dx(550).Dz(330);
		boot.O.b.EU(boot.BE.bd).DG(395,80).DJ(4.7,0.6).DM(240,50.0).DP(6.8,0.65).DS(47.5,3.0).DV(0.625,1.75).DY(12.65,3.35).Dv(30.0,0).Dx(550).Dz(335);
		boot.O.b.EU(boot.BE.be).DG(414,86).DJ(6.95,0.55).DM(180,42.0).DP(7.1,0.6).DS(48.0,3.3).DV(0.658,3.84).DY(12.5,4.0).Dv(30.0,1.25).Dx(125).Dz(340);
		boot.O.b.EU(boot.BE.bf).DG(350,80).DJ(5.5,0.55).DM(235,45.0).DP(7.0,0.65).DS(47.2,3.0).DV(0.665,2.8).DY(12.0,3.5).Dv(30.0,0).Dx(550).Dz(330);
		boot.O.b.EU(boot.BE.bg).DG(390,80).DJ(4.6,0.6).DM(251,59.0).DP(6.9,0.65).DS(45.95,2.625).DV(0.625,2.11).DY(11.0,3.5).Dv(30.0,0).Dx(480).Dz(335);
		boot.O.b.EU(boot.BE.bh).DG(450,85).DJ(6.3,0.8).DM(220,40.0).DP(7.25,0.5).DS(54.5,3.2).DV(0.672,3.0).DY(15.5,3.5).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.bi).DG(414,86).DJ(7.0,0.7).DM(200,40.0).DP(6.15,0.45).DS(53.0,3.0).DV(0.658,3.1).DY(13.0,3.4).Dv(30.0,1.25).Dx(175).Dz(335);
		boot.O.b.EU(boot.BE.bj).DG(435,85).DJ(7.45,0.75).DM(235,50.0).DP(7.0,0.7).DS(56.3,3.375).DV(0.638,1.2).DY(17.0,3.5).Dv(30.0,0).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.bk).DG(495,81).DJ(425.0,0.75).DM(215,40.0).DP(6.5,0.7).DS(54.0,3.0).DV(0.651,2.75).DY(16.5,3.3).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.bl).DG(455,96).DJ(7.5,0.75).DS(52.5,3.5).DV(0.625,2.9).DY(19.0,2.7).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.bm).DG(434,89).DJ(7.25,0.85).DM(221,47.0).DP(6.45,0.45).DS(55.78,3.375).DV(0.651,2.05).DY(16.0,3.6).Dv(30.0,0).Dx(125).Dz(340);
		boot.O.b.EU(boot.BE.bn).DG(410,84).DJ(5.5,0.7).DM(255,40.0).DP(6.75,0.7).DS(51.0,3.1).DV(0.625,2.9).DY(15.0,3.2).Dv(30.0,0).Dx(525).Dz(330);
		boot.O.b.EU(boot.BE.bo).DG(440,95).DJ(8.0,0.75).DM(210,40.0).DP(6.5,0.6).DS(56.0,3.2).DV(0.67,2.5).DY(16.0,4.0).Dv(30.0,1.25).Dx(175).Dz(345);
		boot.O.b.EU(boot.BE.bp).DG(350,75).DJ(4.5,0.55).DM(240,65.0).DP(7.0,0.65).DS(49.24,3.0).DV(0.625,1.21).DY(7.0,3.0).Dv(30.0,0).Dx(550).Dz(325);
		boot.O.b.EU(boot.BE.ca).DG(456,90).DJ(7.5,0.65).DM(230,35.0).DP(7.0,0.65).DS(56.0,3.3).DV(0.665,3.2).DY(15.0,3.75).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.cb).DG(356,78).DJ(4.5,0.55).DM(302,64.0).DP(6.9,0.6).DS(49.0,2.95).DV(0.625,2.61).DY(9.0,3.8).Dv(30.0,0).Dx(475).Dz(335);
		boot.O.b.EU(boot.BE.cc).DG(420,90).DJ(7.0,0.7).DM(235,40.0).DP(6.0,0.45).DS(50.0,3.4).DV(0.658,2.5).DY(14.0,3.0).Dv(30.0,1.25).Dx(175).Dz(340);
		boot.O.b.EU(boot.BE.cd).DG(463,98).DJ(7.45,0.55).DM(230,35.0).DP(6.4,0.7).DS(56.3,3.375).DV(0.638,3.4).DY(18.0,3.5).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.ce).DG(420,90).DJ(6.0,0.8).DM(240,40.0).DP(7.0,0.7).DS(46.5,3.5).DV(0.658,3.0).DY(12.5,3.5).Dv(30.0,0).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.cf).DG(410,86).DJ(4.7,0.55).DM(240,60.0).DP(6.8,0.65).DS(50.0,3.3).DV(0.625,2.3).DY(15.0,3.5).Dv(30.0,0).Dx(425).Dz(335);
		boot.O.b.EU(boot.BE.cg).DG(390,75).DJ(5.5,0.55).DM(270,61.0).DP(6.5,0.6).DS(42.2,3.25).DV(0.625,2.11).DY(11.0,3.5).Dv(30.0,0).Dx(450).Dz(335);
		boot.O.b.EU(boot.BE.ch).DG(433,78).DJ(6.95,0.5).DM(230,45.0).DP(6.9,0.6).DS(52.3,3.9).DV(0.638,3.7).DY(14.0,3.2).Dv(30.0,1.25).Dx(125).Dz(340);
		boot.O.b.EU(boot.BE.ci).DG(395,83).DJ(6.95,0.55).DS(53.0,3.2).DV(0.658,2.74).DY(14.75,4.0).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.cj).DG(418,93).DJ(7.0,0.75).DM(255,40.0).DP(6.9,0.525).DS(53.3,2.8).DV(0.638,2.5).DY(17.0,3.5).Dv(30.0,0.75).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.ck).DG(403,79).DJ(4.65,0.65).EB(200).ED(50).DS(51.3,3.3).DV(0.69,3.4).DY(14.0,3.75).Dv(30.0,0).Dx(550).Dz(335);
		boot.O.b.EU(boot.BE.cl).DG(430,85).DJ(6.25,0.75).DM(260,40.0).DP(6.75,0.5).DS(50.0,3.1).DV(0.665,2.7).DY(15.0,3.0).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.cm).DG(440,84).DJ(5.0,0.55).DM(295,40.0).DP(7.5,0.7).DS(46.0,3.0).DV(0.665,2.65).DY(13.0,3.53).Dv(30.0,0).Dx(500).Dz(340);
		boot.O.b.EU(boot.BE.cn).DG(390,75).DJ(4.5,0.55).DM(250,50.0).DP(6.9,0.6).DS(51.0,3.1).DV(0.625,1.4).DY(12.0,3.5).Dv(30.0,0).Dx(525).Dz(335);
		boot.O.b.EU(boot.BE.co).DG(428,85).DJ(6.25,61.0).ED(200).ED(50).DS(55.8,3.2).DV(0.651,3.0).DY(16.0,3.7).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.cp).DG(430,87).DJ(9.0,0.85).DM(235,40.0).DP(8.0,0.7).DS(55.0,3.0).DV(0.625,2.9).DY(18.0,3.1).Dv(30.0,1.25).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.da).DG(415,82).DJ(6.0,0.72).DM(200,50.0).DP(6.0,0.6).DS(44.4,2.6).DV(0.625,2.2).DY(9.0,3.7).Dv(30.0,0).Dx(550).Dz(325);
		boot.O.b.EU(boot.BE.db).DG(345,79).DJ(4.5,0.55).DM(250,50.0).DP(6.0,0.6).DS(50.0,3.3).DV(0.625,1.36).DY(8.0,4.0).Dv(30.0,0).Dx(550).Dz(340);
		boot.O.b.EU(boot.BE.dc).DG(423,90).DJ(7.45,0.55).DM(215,40.0).DP(6.4,0.55).DS(56.3,3.375).DV(0.638,3.4).DY(18.0,3.75).Dv(30.0,1.25).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.dd).DG(380,80).DJ(4.5,0.55).DM(250,45.0).DP(7.0,0.6).DS(51.66,3.0).DV(0.625,1.36).DY(15.0,3.5).Dv(30.0,0).Dx(550).Dz(340);
		boot.O.b.EU(boot.BE.de).DG(421,90).DJ(7.25,0.85).DM(250,46.0).DP(6.45,0.45).DS(58.0,3.3).DV(0.694,2.13).DY(18.0,4.0).Dv(30.0,0).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.df).DG(444,86).DJ(6.75,0.65).DM(199,36.0).DP(6.5,0.45).DS(55.12,3.1).DV(0.679,2.98).DY(16.3,3.7).Dv(30.0,1.25).Dx(125).Dz(355);
		boot.O.b.EU(boot.BE.dg).DG(435,85).DJ(5.1,0.65).DM(212,38.0).DP(6.95,0.65).DS(46.5,3.0).DV(0.658,3.01).DY(15.0,3.0).Dv(30.0,0).Dx(550).Dz(325);
		boot.O.b.EU(boot.BE.dh).DG(421,80).DJ(7.45,0.55).DS(51.7,3.5).DV(0.694,3.0).DY(15.0,3.5).Dv(30.0,1.25).Dx(125).Dz(340);
		boot.O.b.EU(boot.BE.di).DG(403,86).DJ(4.7,0.6).DM(240,60.0).DP(6.8,0.65).DS(51.58,3.5).DV(0.579,1.53).DY(15.0,3.8).Dv(30.0,0).Dx(425).Dz(335);
		boot.O.b.EU(boot.BE.dj).DG(365,74).DJ(4.5,45.0).DM(305,43.0).DP(6.9,0.6).DS(48.0,3.1).DV(0.644,2.6).DY(9.0,4.0).Dv(30.0,0).Dx(550).Dz(330);
		boot.O.b.EU(boot.BE.dk).DG(410,90).DJ(7.5,0.9).DM(200,45.0).DP(6.6,0.5).DS(53.3,3.5).DV(0.638,3.48).DY(15.0,3.5).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.dl).DG(432,86).DJ(7.45,0.55).DM(200,50.0).DP(7.45,0.7).DS(52.0,3.3).DV(0.613,0.98).DY(12.0,3.25).Dv(30.0,1.25).Dx(175).Dz(325);
		boot.O.b.EU(boot.BE.dm).DG(370,90).DJ(5.0,0.6).DM(220,45.0).DP(7.0,0.5).DS(49.0,3.5).DV(0.672,3.22).DY(11.0,3.5).Dv(30.0,10.75).Dx(525).Dz(335);
		boot.O.b.EU(boot.BE.dn).DG(430,85).DJ(7.0,0.75).DM(215,35.0).DP(6.0,0.45).DS(54.0,3.1).DV(0.668,2.7).DY(17.0,3.5).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.dp).DG(437,108).DJ(7.05,0.8).DM(213,42.0).DP(6.6,0.5).DS(51.6,3.4).DV(0.625,2.25).DY(16.5,3.5).Dv(30.0,1.25).Dx(125).Dz(340);
		boot.O.b.EU(boot.BE.ea).DG(441,93).DJ(7.0,0.9).DM(225,45.0).DP(6.5,0.575).DS(54.1,3.5).DV(0.694,2.7).DY(17.0,3.0).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.eb).DG(385,79).DJ(5.95,0.55).DM(250,50.0).DP(7.0,0.5).DS(44.0,2.6).DV(0.658,3.5).DY(8.0,3.0).Dv(30.0,0).Dx(525).Dz(325);
		boot.O.b.EU(boot.BE.ec).DG(433,87).DJ(6.75,0.65).DM(210,34.0).DP(6.6,0.45).DS(50.7,2.9).DV(0.679,2.95).DY(17.1,3.9).Dv(30.0,1.25).Dx(155).Dz(355);
		boot.O.b.EU(boot.BE.ed).DG(423,81).DJ(7.45,0.55).DM(185,30.0).DP(6.4,0.45).DS(56.3,3.375).DV(0.638,3.35).DY(18.0,4.0).Dv(30.0,0).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.ee).DG(420,86).DJ(8.0,0.55).DM(255,33.0).DP(4.5,0.3).DS(50.0,3.5).DV(0.625,2.22).DY(21.0,3.8).Dv(30.0,1.25).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.ef).DG(426,87).DJ(6.7,0.75).DS(53.12,3.1).DV(0.665,2.65).DY(15.2,3.8).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.eg).DG(435,85).DJ(4.0,0.4).DS(55.0,3.0).DV(0.679,2.85).DY(16.0,3.5).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.eh).DG(414,86).DJ(10.4,0.9).DS(54.0,2.75).DV(0.625,3.5).DY(15.0,3.1).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.ei).DG(450,80).DJ(7.0,0.7).DS(55.32,3.2).DV(0.644,1.85).DY(16.0,3.5).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.ej).DG(360,86).DJ(4.35,0.55).DM(250,55.0).DP(7.0,0.6).DS(52.0,3.0).DV(0.625,2.11).DY(11.0,3.9).Dv(30.0,0).Dx(550).Dz(335);
		boot.O.b.EU(boot.BE.ek).DG(450,85).DJ(7.35,0.85).DM(220,40.0).DP(6.45,0.45).DS(54.0,3.4).DV(0.67,1.45).DY(20.5,3.5).Dv(30.0,1.25).Dx(125).Dz(340);
		boot.O.b.EU(boot.BE.el).DG(441,84).DJ(7.45,0.55).DM(270,40.0).DP(6.4,0.45).DS(51.7,3.5).DV(0.694,3.0).DY(15.0,3.5).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.em).DG(428,85).DJ(7.45,0.55).EB(200).ED(50).DS(54.5,3.375).DV(0.651,3.4).DY(15.0,4.0).Dv(30.0,0).Dx(125).Dz(335);
		boot.O.b.EU(boot.BE.en).DG(435,95).DJ(7.2,0.8).DS(54.5,3.4).DV(0.658,3.4).DY(17.6,3.4).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.eo).DG(405,82).DJ(7.1,0.55).DM(215,45.0).DP(6.6,0.55).DS(56.65,3.375).DV(0.613,1.81).DY(18.0,3.5).Dv(30.0,0).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.ep).DG(403,104).DJ(7.9,0.95).DM(240,40.0).DP(6.3,0.4).DS(55.52,3.1875).DV(0.625,1.63).DY(17.75,3.25).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.fa).DG(378,82).DJ(4.25,0.55).DM(203,43.0).DP(6.5,0.5).DS(49.0,2.9).DV(0.658,3.28).DY(12.75,3.25).Dv(30.0,0).Dx(500).Dz(335);
		boot.O.b.EU(boot.BE.fb).DG(440,96).DJ(7.5,0.85).DM(205,40.0).DP(6.45,0.45).DS(54.1,4.2).DV(0.625,2.1).DY(19.0,3.8).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.fc).DG(340,70).DJ(4.5,0.55).DM(265,45.0).DP(7.0,0.65).DS(47.0,3.0).DV(0.644,2.3).DY(6.0,3.3).Dv(30.0,0).Dx(550).Dz(330);
		boot.O.b.EU(boot.BE.fd).DG(375,71).DJ(4.5,0.55).DM(240,60.0).DP(6.8,0.65).DS(48.8,3.0).DV(0.625,2.14).DY(7.4,3.8).Dv(30.0,0).Dx(550).Dz(335);
		boot.O.b.EU(boot.BE.fe).DG(385,78).DJ(6.75,0.65).DM(240,50.0).DP(6.8,0.65).DS(49.0,3.0).DV(0.625,2.11).DY(12.0,4.0).Dv(30.0,0).Dx(500).Dz(335);
		boot.O.b.EU(boot.BE.ff).DG(380,78).DJ(5.5,0.6).DM(250,50.0).DP(6.9,0.6).DS(51.0,2.9).DV(0.625,2.0).DY(15.0,3.4).Dv(30.0,0).Dx(550).Dz(330);
		boot.O.b.EU(boot.BE.fg).DG(440,85).DJ(7.25,0.75).DM(260,40.0).DP(6.75,0.5).DS(50.0,3.1).DV(0.668,2.7).DY(17.0,3.5).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.fh).DG(468,90).DJ(7.1,0.5).DM(255,56.0).DP(4.1,0.4).DS(58.0,3.5).DV(0.625,2.02).DY(16.5,3.2).Dv(30.0,1.25).Dx(125).Dz(340);
		boot.O.b.EU(boot.BE.fi).DG(383,82).DJ(4.65,0.65).DM(200,40.0).DP(6.45,0.45).DS(44.5,3.0).DV(0.69,3.38).DY(14.0,3.75).Dv(30.0,0).Dx(500).Dz(330);
		boot.O.b.EU(boot.BE.fj).DG(415,82).DJ(5.1,0.65).DM(193,32.0).DP(6.45,0.45).DS(46.5,3.0).DV(0.658,3.01).DY(15.0,3.0).Dv(30.0,0).Dx(550).Dz(325);
		boot.O.b.EU(boot.BE.fk).DG(455,96).DJ(8.0,0.85).DM(206,45.0).DP(6.9,0.6).DS(54.66,3.0).DV(0.672,2.9).DY(19.0,2.7).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.fl).DG(461,98).DJ(7.9,0.9).DS(56.0,3.2).DV(0.644,2.9).DY(14.9,3.1).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.fm).DG(384,82).DJ(4.5,0.6).DM(202,38.0).DP(6.5,0.5).DS(46.61,3.3).DV(0.651,3.22).DY(111.25,3.15).Dv(30.0,0).Dx(525).Dz(330);
		boot.O.b.EU(boot.BE.fn).DG(389,81).DJ(5.0,0.6).DM(220,40.0).DP(6.5,0.45).DS(49.0,3.0).DV(0.679,3.38).DY(14.0,3.0).Dv(30.0,0).Dx(550).Dz(330);
		boot.O.b.EU(boot.BE.fo).DG(427,99).DJ(7.45,0.75).DM(220,30.0).DP(6.4,0.45).DS(52.91,3.2).DV(0.658,2.67).DY(14.75,4.0).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.fp).DG(437,89).DJ(5.5,0.6).DM(220,55.0).DP(7.5,0.65).DS(48.0,3.6).DV(0.644,2.9).DY(15.0,3.3).Dv(30.0,0).Dx(425).Dz(335);
		boot.O.b.EU(boot.BE.ga).DG(400,82).DJ(4.5,0.55).DM(250,36.0).DP(6.5,0.5).DS(46.0,3.0).DV(0.658,2.65).DY(13.5,3.4).Dv(30.0,0).Dx(575).Dz(335);
		boot.O.b.EU(boot.BE.gb).DG(359,83).DJ(4.5,0.55).DM(173,27.0).DP(6.3,0.4).DS(50.0,3.25).DV(0.658,3.1).DY(9.3,3.4).Dv(30.0,0).Dx(550).Dz(330);
		boot.O.b.EU(boot.BE.gc).DG(355,82).DJ(4.5,0.55).DM(250,55.0).DP(6.9,0.6).DS(48.3,2.625).DV(0.625,2.24).DY(12.25,3.75).Dv(30.0,0).Dx(525).Dz(340);
		boot.O.b.EU(boot.BE.gd).DG(440,85).DJ(7.5,0.9).DM(220,45.0).DP(7.0,0.65).DS(55.0,3.5).DV(0.643,2.5).DY(16.0,3.5).Dv(30.0,1.25).Dx(125).Dz(350);
		boot.O.b.EU(boot.BE.ge).DG(385,78).DJ(6.75,0.65).DM(240,50.0).DP(6.9,0.45).DS(49.0,3.0).DV(0.625,2.11).DY(12.0,4.0).Dv(30.0,0).Dx(525).Dz(335);
		boot.O.b.EU(boot.BE.gf).DG(400,85).DJ(6.0,0.6).DS(45.0,3.0).DV(0.6258,2.0).DY(12.0,3.5).Dv(30.0,0).Dx(450).Dz(335);
		boot.O.b.EU(boot.BE.gg).DG(440,86).DJ(7.0,0.65).DM(220,30.0).DP(7.0,0.65).DS(54.0,3.3).DV(0.625,2.9).DY(16.5,3.5).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.gh).DG(428,98).DJ(7.05,0.8).DM(190,30.0).DP(7.1,0.6).DS(56.76,3.375).DV(0.679,2.88).DY(16.0,3.5).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.gi).DG(435,85).DJ(5.1,0.65).DM(202,38.0).DP(6.9,0.65).DS(54.0,3.2).DV(0.658,3.0).DY(15.0,3.5).Dv(30.0,1.25).Dx(175).Dz(345);
		boot.O.b.EU(boot.BE.gj).DG(380,80).DJ(5.0,0.55).DM(250,45.0).DP(8.0,0.6).DS(52.0,3.0).DV(0.625,1.36).DY(12.6,3.4).Dv(30.0,0).Dx(550).Dz(340);
		boot.O.b.EU(boot.BE.gk).DG(445,87).DJ(7.0,0.7).DM(213,31.0).DP(6.6,0.45).DS(52.0,3.3).DV(0.672,2.7).DY(16.2,3.7).Dv(30.0,1.25).Dx(175).Dz(345);
		boot.O.b.EU(boot.BE.gl).DG(421,85).DJ(8.5,0.7).DM(235,35.0).DP(6.5,0.45).DS(51.5,3.5).DV(0.625,3.0).DY(18.0,3.6).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.gm).DG(445,85).DJ(6.0,0.65).EB(20).ED(50).DS(48.6,3.4).DV(0.658,3.1).DY(17.5,3.5).Dv(30.0,1.25).Dx(125).Dz(345);
		boot.O.b.EU(boot.BE.gn).DG(390,80).DJ(5.25,0.6).DM(250,50.0).DP(6.75,0.6).DS(54.0,3.1).DV(0.656,1.7).DY(12.0,3.3).Dv(30.0,0).Dx(575).Dz(330);
		boot.O.b.EU(boot.BE.go).DG(380,71).DJ(4.6,0.5).DM(260,60.0).DP(6.95,0.65).DS(48.6,3.0).DV(0.625,2.13).DY(6.75,3.8).Dv(30.0,0).Dx(600).Dz(335);
		boot.O.b.EU(boot.BE.gp).DG(355,74).DJ(4.85,0.5).DM(250,50.0).DP(7.1,0.75).DS(50.0,3.2).DV(0.625,1.8).DY(11.0,3.0).Dv(30.0,0).Dx(575).Dz(325);
		boot.O.c=new boot.O(1520,2012,12,3,"Preseason 3",boot.O.b,0);
		boot.O.c.EQ("Shard of True Ice");
		boot.O.c.EQ("Liandry's Torment");
		boot.O.c.EQ("Haunting Guise");
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
	EQ:function(A,B){
		B=new boot.Bu(A,this,0);
		this.e.CR(A,B);
		return B;
	},
	// teemowork.model.Patch#update(teemowork.model.Champion)
	EU:function(A){
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
		this.G(boot.K.$);
		this.G(boot.L.$);
		boot.C.prototype.A.call(this);
		$("body").css("padding","0px 10%");
		A=new boot.M(0);
		A.L("< ^ v ^ > Teemowork","test.html");
		A.L("Patch","#");
		B=A.L("Data","#");
		B.L("Champion","#");
		B.L("Item","#");
		B.L("Mastery","#");
		B.L("Rune","#");
		A.L("Builder","#");
		A.L("About","#");
		A.L("Contact","#");
		console.log(boot.O.a);
	},
	// teemowork.Teemowork#test()
	M:function(){
		console.log("called");
	}
},{
	"$":[["P",{
		N:function() {return true;},O:function() {return 10;},P:function() {return 10;},Q:function() {return 4;},R:function() {return 10;},S:function() {return 10.0;},T:function() {return 10.0;}
	}]],"M":[["Q",{
	}]]
});

try {new boot.B(0).A();} catch(e) {console.log(e)}