boot.define("O","",[],{
	equals:null,toString:null,hashCode:null,U:null
});

boot.define("B","",[],{
	// js.lang.reflect.JSAnnotatedElement#<init>(java.lang.String, js.lang.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// js.lang.reflect.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	W:function(A){
		return this.X(A)!=null;
	},
	// js.lang.reflect.JSAnnotatedElement#getAnnotation(java.lang.Class)
	X:function(A,B,C){
		if(!(this.b==null)){
			B=0;
			l4:for (;
			B<this.b.length;
			++B) {
				C=this.b[B];
				if(C.U()!=A){
				}else{
					return C;
				}
			}
		}return null;
	},
	// js.lang.reflect.JSAnnotatedElement#getAnnotations()
	Y:function(){
		return null;
	},
	// js.lang.reflect.JSAnnotatedElement#getDeclaredAnnotations()
	Z:function(){
		return this.Y();
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.Q.$;
		}
	}]
});

boot.define("G","B",[],{
	// js.lang.reflect.JSConstructor#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeFunction, js.lang.NativeArray)
	$0:function(A,B,C,D){
		boot.B.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	},
	// js.lang.reflect.JSConstructor#newInstance(java.lang.Object[])
	P:function(A,B){
		B=Object.create(this.c);
		this.d.apply(B,A);
		return B;
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.G.$;
		}
	}]
});

boot.define("H","B",[],{
	// js.lang.reflect.JSMethod#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeArray)
	$0:function(A,B,C){
		boot.B.prototype.$0.call(this,A,C);
		this.c=B;
	},
	// js.lang.reflect.JSMethod#getName()
	L:function(){
		return this.a;
	},
	// js.lang.reflect.JSMethod#invoke(java.lang.Object, java.lang.Object[])
	u:function(A,B){
		return A[this.a].apply(A,B);
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.H.$;
		}
	}]
});

boot.define("G","B",[],{
	// js.lang.reflect.JSConstructor#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeFunction, js.lang.NativeArray)
	$0:function(A,B,C,D){
		boot.B.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	},
	// js.lang.reflect.JSConstructor#newInstance(java.lang.Object[])
	P:function(A,B){
		B=Object.create(this.c);
		this.d.apply(B,A);
		return B;
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.G.$;
		}
	}]
});

boot.define("J","",[],{
	// js.lang.JSThrowable#<init>()
	$0:function(){
		boot.J.prototype.$2.call(this,"",null);
	},
	// js.lang.JSThrowable#<init>(java.lang.String)
	$1:function(A){
		boot.J.prototype.$2.call(this,A,null);
	},
	// js.lang.JSThrowable#<init>(java.lang.Throwable)
	$3:function(A){
		boot.J.prototype.$2.call(this,"",A);
	},
	// js.lang.JSThrowable#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.lang.JSThrowable#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.J.prototype.$2.call(this,A,B);
	},
	// js.lang.JSThrowable#getMessage()
	v:function(){
		return this.a;
	},
	// js.lang.JSThrowable#getLocalizedMessage()
	w:function(){
		return this.a;
	},
	// js.lang.JSThrowable#getCause()
	x:function(){
		return this.b;
	},
	// js.lang.JSThrowable#toString()
	toString:function(){
		return this.a;
	},
	// js.lang.JSThrowable#printStackTrace()
	y:function(){
		console.log(this.a);
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.J.$;
		}
	}]
});

boot.define("J","",[],{
	// js.lang.JSThrowable#<init>()
	$0:function(){
		boot.J.prototype.$2.call(this,"",null);
	},
	// js.lang.JSThrowable#<init>(java.lang.String)
	$1:function(A){
		boot.J.prototype.$2.call(this,A,null);
	},
	// js.lang.JSThrowable#<init>(java.lang.Throwable)
	$3:function(A){
		boot.J.prototype.$2.call(this,"",A);
	},
	// js.lang.JSThrowable#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.lang.JSThrowable#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.J.prototype.$2.call(this,A,B);
	},
	// js.lang.JSThrowable#getMessage()
	v:function(){
		return this.a;
	},
	// js.lang.JSThrowable#getLocalizedMessage()
	w:function(){
		return this.a;
	},
	// js.lang.JSThrowable#getCause()
	x:function(){
		return this.b;
	},
	// js.lang.JSThrowable#toString()
	toString:function(){
		return this.a;
	},
	// js.lang.JSThrowable#printStackTrace()
	y:function(){
		console.log(this.a);
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.J.$;
		}
	}]
});

boot.define("K","J",[],{
	// java.lang.Error#<init>()
	$1:function(){
		boot.J.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$2:function(A){
		boot.J.prototype.$1.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$3:function(A,B){
		boot.J.prototype.$2.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$0:function(A){
		boot.J.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.J.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("N","",[],{
	BN:null,BJ:null,T:null,equals:null,BF:null,hashCode:null,BR:null,z:null,BB:null,BA:null,BP:null,BS:null,BC:null,BE:null
});

boot.define("w","",[],{
	BG:null
});

boot.define("U","",["w"],{
	BV:null,BW:null,equals:null,hashCode:null,BR:null,BG:null,BD:null,BB:null,BA:null,BY:null,BZ:null,Bu:null,Bv:null,Bw:null,Bx:null
});

boot.define("Y","",["U"],{
	BV:null,BW:null,equals:null,hashCode:null,BR:null,BG:null,BD:null,BB:null,BA:null,BY:null,BZ:null,Bu:null,Bv:null,Bw:null,Bx:null
});

boot.define("V","",[],{
	Bz:null,BI:null,BH:null
});

boot.define("T","",["U"],{
	// js.util.AbstractCollection#<init>()
	$0:function(){
	},
	// js.util.AbstractCollection#isEmpty()
	BB:function(){
		return this.BA()==0;
	},
	// js.util.AbstractCollection#addAll(java.util.Collection)
	Bu:function(A,B,C,D){
		B=0;
		D=A.BG();
		l2:while (D.BI()!=0) {
			C=D.BH();
			if(!(this.BV(C)==0)){
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#retainAll(java.util.Collection)
	Bx:function(A,B,C,D){
		B=0;
		D=this.BG();
		l2:while (D.BI()!=0) {
			C=D.BH();
			if(!(A.BD(C)!=0)){
				B=this.BW(C);
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#removeAll(java.util.Collection)
	Bw:function(A,B,C,D){
		B=0;
		D=A.BG();
		l2:while (D.BI()!=0) {
			C=D.BH();
			if(!(this.BW(C)==0)){
				B=1;
				continue l2;
			}continue l2;
		}return B;
	},
	// js.util.AbstractCollection#containsAll(java.util.Collection)
	Bv:function(A,B,C){
		C=A.BG();
		l1:while (C.BI()!=0) {
			B=C.BH();
			if(!(this.BD(B)!=0)){
				return false;
			}continue l1;
		}return true;
	},
	// js.util.AbstractCollection#toArray()
	BY:function(){
		return this.BZ(new Array(0));
	},
	// js.util.AbstractCollection#toArray(java.lang.Object[])
	BZ:function(A,B,C,D,E){
		B=this.BA();
		if(!(A.length>=B)){
			A=[];
		}C=this.BG();
		D=0;
		l6:while (C.BI()!=0) {
			E=C.BH();
			A[D]=E;
			++D;
			continue l6;
		}return A;
	}
});

boot.define("S","T",["Y"],{
	// js.util.AbstractSet#<init>()
	$0:function(){
		boot.T.prototype.$0.call(this);
	}
});

boot.define("v","",["V"],{
	b:0,
	// js.util.HashSet$View#<init>(js.util.HashSet, java.lang.String[])
	$1:function(A,B){
		this.d=A;;
		this.b=0;
		this.a=B;
	},
	// js.util.HashSet$View#hasNext()
	BI:function(){
		return this.b<this.a.length;
	},
	// js.util.HashSet$View#next()
	BH:function(){
		this.c=boot.R.BX(this.d)[this.a[this.b++]];
		return this.c;
	},
	// js.util.HashSet$View#remove()
	Bz:function(){
		if(!(this.b<=0)){
			this.d.BW(this.c);
		}
	},
	// js.util.HashSet$View#<init>(js.util.HashSet, java.lang.String[], js.util.HashSet$View)
	$0:function(A,B,C){
		boot.v.prototype.$1.call(this,A,B);
	}
});

boot.define("R","S",[],{
	a:0,
	// js.util.HashSet#<init>()
	$0:function(){
		boot.S.prototype.$0.call(this);
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#size()
	BA:function(){
		return this.a;
	},
	// js.util.HashSet#contains(java.lang.Object)
	BD:function(A){
		return this.BU(A) in this.b;
	},
	// js.util.HashSet#add(java.lang.Object)
	BV:function(A,B){
		B=this.BU(A);
		if(B in this.b==0){
			this.a=(this.a+1);
			this.b[B]=A;
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#remove(java.lang.Object)
	BW:function(A,B){
		B=this.BU(A);
		if(B in this.b!=0){
			this.a=(this.a-1);
			delete this.b[B];
			return true;
		}else{
			return false;
		}
	},
	// js.util.HashSet#clear()
	BR:function(){
		this.a=0;
		this.b={};
	},
	// js.util.HashSet#iterator()
	BG:function(){
		return new boot.v(this,Object.keys(this.b),null,0);
	},
	// js.util.HashSet#hash(java.lang.Object)
	BU:function(A){
		return (A==null?-1:A.hashCode());
	},
	// js.util.HashSet#find(java.lang.Object)
	BK:function(A){
		return this.b[this.BU(A)];
	},
	// js.util.HashSet#push(java.lang.Object)
	BM:function(A,B,C){
		B=null;
		C=this.BU(A);
		if(C in this.b==0){
			this.a=(this.a+1);
		}else{
			B=this.b[C];
		}this.b[C]=A;
		return B;
	},
	// js.util.HashSet#pull(java.lang.Object)
	BO:function(A,B,C){
		B=null;
		C=this.BU(A);
		if(!(C in this.b==0)){
			B=this.b[C];
			this.a=(this.a-1);
			delete this.b[C];
		}return B;
	},
	// js.util.HashSet#access$0(js.util.HashSet)
	_BX:function(A){
		return A.b;
	}
});

boot.define("W","",[],{
	equals:null,hashCode:null,BQ:null,BL:null,CA:null
});

boot.define("X","",["W"],{
	// js.util.HashMap$SimpleEntry#<init>(java.lang.Object, java.lang.Object)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.util.HashMap$SimpleEntry#getKey()
	BQ:function(){
		return this.a;
	},
	// js.util.HashMap$SimpleEntry#getValue()
	BL:function(){
		return this.b;
	},
	// js.util.HashMap$SimpleEntry#setValue(java.lang.Object)
	CA:function(A,B){
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
		boot.X.prototype.$1.call(this,A,B);
	}
});

boot.define("x","",["V"],{
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean)
	$1:function(A,B,C){
		this.c=A;;
		this.a=B;
		this.b=C;
	},
	// js.util.HashMap$View#hasNext()
	BI:function(){
		return this.a.BI();
	},
	// js.util.HashMap$View#next()
	BH:function(A){
		A=this.a.BH();
		if(this.b==0){
			return A.BL();
		}else{
			return A.BQ();
		}
	},
	// js.util.HashMap$View#remove()
	Bz:function(){
		this.a.Bz();
	},
	// js.util.HashMap$View#<init>(js.util.HashMap, java.util.Iterator, boolean, js.util.HashMap$View)
	$0:function(A,B,C,D){
		boot.x.prototype.$1.call(this,A,B,C);
	}
});

boot.define("Z","S",[],{
	// js.util.HashMap$Keys#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.S.prototype.$0.call(this);
	},
	// js.util.HashMap$Keys#size()
	BA:function(){
		return boot.L.BT(this.a).BA();
	},
	// js.util.HashMap$Keys#contains(java.lang.Object)
	BD:function(A){
		return boot.L.BT(this.a).BD(A);
	},
	// js.util.HashMap$Keys#iterator()
	BG:function(){
		return new boot.x(this.a,boot.L.BT(this.a).BG(),1,null,0);
	},
	// js.util.HashMap$Keys#add(java.lang.Object)
	BV:function(A){
		return false;
	},
	// js.util.HashMap$Keys#remove(java.lang.Object)
	BW:function(A){
		return boot.L.BT(this.a).BW(A);
	},
	// js.util.HashMap$Keys#clear()
	BR:function(){
		boot.L.BT(this.a).BR();
	},
	// js.util.HashMap$Keys#<init>(js.util.HashMap, js.util.HashMap$Keys)
	$0:function(A,B){
		boot.Z.prototype.$1.call(this,A);
	}
});

boot.define("u","T",[],{
	// js.util.HashMap$Values#<init>(js.util.HashMap)
	$1:function(A){
		this.a=A;boot.T.prototype.$0.call(this);
	},
	// js.util.HashMap$Values#size()
	BA:function(){
		return boot.L.BT(this.a).BA();
	},
	// js.util.HashMap$Values#contains(java.lang.Object)
	BD:function(A){
		return this.a.BE(A);
	},
	// js.util.HashMap$Values#iterator()
	BG:function(){
		return new boot.x(this.a,boot.L.BT(this.a).BG(),0,null,0);
	},
	// js.util.HashMap$Values#add(java.lang.Object)
	BV:function(A){
		return false;
	},
	// js.util.HashMap$Values#remove(java.lang.Object)
	BW:function(A,B,C){
		B=this.BG();
		l2:while (B.BI()!=0) {
			C=B.BH();
			if(!(C!=A)){
				B.Bz();
				return true;
			}continue l2;
		}return false;
	},
	// js.util.HashMap$Values#clear()
	BR:function(){
		boot.L.BT(this.a).BR();
	},
	// js.util.HashMap$Values#<init>(js.util.HashMap, js.util.HashMap$Values)
	$0:function(A,B){
		boot.u.prototype.$1.call(this,A);
	}
});

boot.define("L","",["N"],{
	// js.util.HashMap#<init>()
	$0:function(){
		this.a=new boot.R(0);
	},
	// js.util.HashMap#<init>(java.util.Map)
	$1:function(A){
		this.a=new boot.R(0);
		if(!(A==null)){
			this.z(A);
		}
	},
	// js.util.HashMap#size()
	BA:function(){
		return this.a.BA();
	},
	// js.util.HashMap#isEmpty()
	BB:function(){
		return this.a.BB();
	},
	// js.util.HashMap#containsKey(java.lang.Object)
	BC:function(A){
		return this.a.BD(A);
	},
	// js.util.HashMap#containsValue(java.lang.Object)
	BE:function(A,B,C){
		C=this.BF().BG();
		l1:while (C.BI()!=0) {
			B=C.BH();
			if(!(B!=A)){
				return true;
			}continue l1;
		}return false;
	},
	// js.util.HashMap#get(java.lang.Object)
	BJ:function(A,B){
		B=this.a.BK(A);
		return (B==null?null:B.BL());
	},
	// js.util.HashMap#put(java.lang.Object, java.lang.Object)
	T:function(A,B,C){
		C=this.a.BM(new boot.X(A,B,null,0));
		if(C!=null){
			return C.BL();
		}else{
			return null;
		}
	},
	// js.util.HashMap#remove(java.lang.Object)
	BN:function(A,B){
		B=this.a.BO(A);
		if(B!=null){
			return B.BL();
		}else{
			return null;
		}
	},
	// js.util.HashMap#putAll(java.util.Map)
	z:function(A,B,C){
		C=A.BP().BG();
		l1:for (;
		C.BI()!=0;
		this.T(B.BQ(),B.BL())) {
			B=C.BH();
		}
	},
	// js.util.HashMap#clear()
	BR:function(){
		this.a.BR();
	},
	// js.util.HashMap#keySet()
	BS:function(){
		return new boot.Z(this,null,0);
	},
	// js.util.HashMap#values()
	BF:function(){
		return new boot.u(this,null,0);
	},
	// js.util.HashMap#entrySet()
	BP:function(){
		return this.a;
	},
	// js.util.HashMap#access$0(js.util.HashMap)
	_BT:function(A){
		return A.a;
	}
});

boot.define("y","",[],{
	CG:null
});

boot.define("z","",[],{
});

boot.define("I","J",[],{
	// java.lang.Exception#<init>()
	$0:function(){
		boot.J.prototype.$0.call(this);
	},
	// java.lang.Exception#<init>(java.lang.String)
	$1:function(A){
		boot.J.prototype.$1.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.J.prototype.$2.call(this,A,B);
	},
	// java.lang.Exception#<init>(java.lang.Throwable)
	$3:function(A){
		boot.J.prototype.$3.call(this,A);
	},
	// java.lang.Exception#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.J.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BA","I",[],{
	// java.lang.CloneNotSupportedException#<init>()
	$0:function(){
		boot.I.prototype.$0.call(this);
	},
	// java.lang.CloneNotSupportedException#<init>(java.lang.String)
	$1:function(A){
		boot.I.prototype.$1.call(this,A);
	}
});

boot.define("BC","I",[],{
	// java.lang.RuntimeException#<init>()
	$0:function(){
		boot.I.prototype.$0.call(this);
	},
	// java.lang.RuntimeException#<init>(java.lang.String)
	$1:function(A){
		boot.I.prototype.$1.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.I.prototype.$2.call(this,A,B);
	},
	// java.lang.RuntimeException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.I.prototype.$3.call(this,A);
	},
	// java.lang.RuntimeException#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.I.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("BB","BC",[],{
	// java.lang.ClassCastException#<init>()
	$0:function(){
		boot.BC.prototype.$0.call(this);
	},
	// java.lang.ClassCastException#<init>(java.lang.String)
	$1:function(A){
		boot.BC.prototype.$1.call(this,A);
	}
});

boot.define("BD","BC",[],{
	// java.lang.NullPointerException#<init>()
	$1:function(){
		boot.BC.prototype.$0.call(this);
	},
	// java.lang.NullPointerException#<init>(java.lang.String)
	$0:function(A){
		boot.BC.prototype.$1.call(this,A);
	}
});

boot.define("BE","BC",[],{
	// java.lang.IllegalArgumentException#<init>()
	$1:function(){
		boot.BC.prototype.$0.call(this);
	},
	// java.lang.IllegalArgumentException#<init>(java.lang.String)
	$0:function(A){
		boot.BC.prototype.$1.call(this,A);
	},
	// java.lang.IllegalArgumentException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.BC.prototype.$2.call(this,A,B);
	},
	// java.lang.IllegalArgumentException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.BC.prototype.$3.call(this,A);
	}
});

boot.define("BH","I",[],{
	// java.io.IOException#<init>()
	$1:function(){
		boot.I.prototype.$0.call(this);
	},
	// java.io.IOException#<init>(java.lang.String)
	$0:function(A){
		boot.I.prototype.$1.call(this,A);
	},
	// java.io.IOException#<init>(java.lang.String, java.lang.Throwable)
	$2:function(A,B){
		boot.I.prototype.$2.call(this,A,B);
	},
	// java.io.IOException#<init>(java.lang.Throwable)
	$3:function(A){
		boot.I.prototype.$3.call(this,A);
	}
});

boot.define("BG","BH",[],{
	// java.io.ObjectStreamException#<init>(java.lang.String)
	$0:function(A){
		boot.BH.prototype.$0.call(this,A);
	},
	// java.io.ObjectStreamException#<init>()
	$1:function(){
		boot.BH.prototype.$1.call(this);
	}
});

boot.define("BF","BG",[],{
	// java.io.InvalidObjectException#<init>(java.lang.String)
	$0:function(A){
		boot.BG.prototype.$0.call(this,A);
	}
});

boot.define("M","",["y","z"],{
	// java.lang.Enum#name()
	S:function(){
		return this.a;
	},
	// java.lang.Enum#ordinal()
	CB:function(){
		return this.b;
	},
	// java.lang.Enum#<init>(java.lang.String, int)
	$0:function(A,B){
		this.a=A;
		this.b=B;
	},
	// java.lang.Enum#toString()
	toString:function(){
		return this.a;
	},
	// java.lang.Enum#equals(java.lang.Object)
	equals:function(A){
		return this==A;
	},
	// java.lang.Enum#hashCode()
	hashCode:function(){
		return Object.prototype.hashCode.call(this);
	},
	// java.lang.Enum#clone()
	clone:function(){
		throw new boot.BA(0);
	},
	// java.lang.Enum#compareTo(java.lang.Enum)
	CC:function(A,B,C){
		B=A;
		C=this;
		if((C.getClass()==B.getClass()||C.CD()==B.CD())){
			return (C.b-B.b);
		}else{
			throw new boot.BB(0);
		}
	},
	// java.lang.Enum#getDeclaringClass()
	CD:function(A,B){
		A=this.getClass();
		B=A.J();
		return (B==boot.M.$?A:B);
	},
	// java.lang.Enum#valueOf(java.lang.Class, java.lang.String)
	_CE:function(A,B,C){
		C=A.R().BJ(B);
		if(C==null){
			if(B!=null){
				throw new boot.BE(""+"No enum constant "+A.N()+"."+B,0);
			}else{
				throw new boot.BD("Name is null",0);
			}
		}else{
			return C;
		}
	},
	// java.lang.Enum#finalize()
	finalize:function(){
	},
	// java.lang.Enum#readObjectNoData()
	CF:function(){
		throw new boot.BF("can't deserialize enum",0);
	},
	// java.lang.Enum#compareTo(java.lang.Object)
	CG:function(A){
		return this.CC(A);
	}
});

boot.define("A","B",[],{
	// js.lang.reflect.JSClass#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeObject, java.lang.Class, java.lang.String[])
	$0:function(A,B,C,D,E,F){
		boot.B.prototype.$0.call(this,A,C["$"]);
		this.c=B;
		this.d=C;
		this.e=D;
		this.f=new Array(E.length);
		F=0;
		l7:for (;
		F<E.length;
		++F) {
			this.f[F]=boot.A.C(E[F]);
		}
	},
	// js.lang.reflect.JSClass#getConstructors()
	D:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(!(B.startsWith("$")==0)){
				A.push(new boot.G(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getMethods()
	E:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(!(B.startsWith("$")!=0)){
				A.push(new boot.H(B,this.c,this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getDeclaredMethods()
	F:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(!(B.startsWith("$")!=0)){
				A.push(new boot.H(B,this.c,this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getFields()
	G:function(){
		return null;
	},
	// js.lang.reflect.JSClass#isAssignableFrom(java.lang.Class)
	H:function(A,B,C,D,E){
		l1:for (;
		A!=null;
		A=A.J()) {
			if(this!=A){
				E=A.I();D=E.length;C=0;
				l5:for (;
				C<D;
				++C) {
					B=E[C];
					if(this.H(B)==0){
					}else{
						return true;
					}
				}
			}else{
				return true;
			}
		}return false;
	},
	// js.lang.reflect.JSClass#isInstance(java.lang.Object)
	K:function(A){
		return this.H(A.getClass());
	},
	// js.lang.reflect.JSClass#getSuperclass()
	J:function(){
		return this.e;
	},
	// js.lang.reflect.JSClass#getInterfaces()
	I:function(){
		return this.f;
	},
	// js.lang.reflect.JSClass#getName()
	L:function(){
		return "boot."+this.a;
	},
	// js.lang.reflect.JSClass#getSimpleName()
	M:function(){
		return this.a;
	},
	// js.lang.reflect.JSClass#getCanonicalName()
	N:function(){
		return this.a;
	},
	// js.lang.reflect.JSClass#newInstance()
	O:function(A){
		try{
			return this.D()[0].P(new Array(0));
		} catch ($) {
			if ($ instanceof boot.I) {
				throw new boot.K(A,0);
			}
		}
	},
	// js.lang.reflect.JSClass#getConstructor()
	Q:function(){
		return null;
	},
	// js.lang.reflect.JSClass#enumConstantDirectory()
	R:function(A,B,C,D,E,F,G,H,I,J){
		if(!(this.g!=null)){
			this.g=new boot.L(0);
			A=this.c["$"];
			E=Object.keys(A);D=E.length;C=0;
			l5:while (C<D) {
				B=E[C];
				F=A[B];
				if(!(Array.isArray(F)==0)){
					J=F;I=J.length;H=0;
					l11:for (;
					H<I;
					++H) {
						G=J[H];
						this.g.T(G.S(),G);
					}
				}++C;
				continue l5;
			}
		}return this.g;
	},
	// js.lang.reflect.JSClass#forName(java.lang.String)
	_C:function(A){
		return boot[A]["$"];
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.A.$;
		}
	}]
});

boot.define("A","B",[],{
	// js.lang.reflect.JSClass#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeObject, java.lang.Class, java.lang.String[])
	$0:function(A,B,C,D,E,F){
		boot.B.prototype.$0.call(this,A,C["$"]);
		this.c=B;
		this.d=C;
		this.e=D;
		this.f=new Array(E.length);
		F=0;
		l7:for (;
		F<E.length;
		++F) {
			this.f[F]=boot.A.C(E[F]);
		}
	},
	// js.lang.reflect.JSClass#getConstructors()
	D:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(!(B.startsWith("$")==0)){
				A.push(new boot.G(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getMethods()
	E:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(!(B.startsWith("$")!=0)){
				A.push(new boot.H(B,this.c,this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getDeclaredMethods()
	F:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(!(B.startsWith("$")!=0)){
				A.push(new boot.H(B,this.c,this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getFields()
	G:function(){
		return null;
	},
	// js.lang.reflect.JSClass#isAssignableFrom(java.lang.Class)
	H:function(A,B,C,D,E){
		l1:for (;
		A!=null;
		A=A.J()) {
			if(this!=A){
				E=A.I();D=E.length;C=0;
				l5:for (;
				C<D;
				++C) {
					B=E[C];
					if(this.H(B)==0){
					}else{
						return true;
					}
				}
			}else{
				return true;
			}
		}return false;
	},
	// js.lang.reflect.JSClass#isInstance(java.lang.Object)
	K:function(A){
		return this.H(A.getClass());
	},
	// js.lang.reflect.JSClass#getSuperclass()
	J:function(){
		return this.e;
	},
	// js.lang.reflect.JSClass#getInterfaces()
	I:function(){
		return this.f;
	},
	// js.lang.reflect.JSClass#getName()
	L:function(){
		return "boot."+this.a;
	},
	// js.lang.reflect.JSClass#getSimpleName()
	M:function(){
		return this.a;
	},
	// js.lang.reflect.JSClass#getCanonicalName()
	N:function(){
		return this.a;
	},
	// js.lang.reflect.JSClass#newInstance()
	O:function(A){
		try{
			return this.D()[0].P(new Array(0));
		} catch ($) {
			if ($ instanceof boot.I) {
				throw new boot.K(A,0);
			}
		}
	},
	// js.lang.reflect.JSClass#getConstructor()
	Q:function(){
		return null;
	},
	// js.lang.reflect.JSClass#enumConstantDirectory()
	R:function(A,B,C,D,E,F,G,H,I,J){
		if(!(this.g!=null)){
			this.g=new boot.L(0);
			A=this.c["$"];
			E=Object.keys(A);D=E.length;C=0;
			l5:while (C<D) {
				B=E[C];
				F=A[B];
				if(!(Array.isArray(F)==0)){
					J=F;I=J.length;H=0;
					l11:for (;
					H<I;
					++H) {
						G=J[H];
						this.g.T(G.S(),G);
					}
				}++C;
				continue l5;
			}
		}return this.g;
	},
	// js.lang.reflect.JSClass#forName(java.lang.String)
	_C:function(A){
		return boot[A]["$"];
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.A.$;
		}
	}]
});

boot.define("BX","",[],{
	// js.math.Mathematics#<init>()
	$0:function(){
	},
	// js.math.Mathematics#round(double, int)
	_Cy:function(A,C,D){
		D=Math.pow(10.0,C);
		return Math.round(A*D)/D;
	}
});

boot.define("BK","M",[],{
	// teemowork.model.Status#<clinit>()
	_:function(){
		boot.BK.c=new boot.BK("Damage",0,"DM",0);boot.BK.d=new boot.BK("DamageRatio",1,"DM",0);
		boot.BK.e=new boot.BK("PhysicalDamage",2,"物理DM",0);
		boot.BK.f=new boot.BK("MagicDamage",3,"魔法DM",0);
		boot.BK.g=new boot.BK("TrueDamage",4,"TrueDM",0);
		boot.BK.h=new boot.BK("AttackDamage",5,"通常攻撃によるDM",0);boot.BK.i=new boot.BK("AttackDamageRatio",6,boot.BK.h,1);
		boot.BK.j=new boot.BK("DealtDamage",7,"与えたDM",0);boot.BK.k=new boot.BK("DealtDamageRatio",8,boot.BK.j,1);
		boot.BK.l=new boot.BK("ReceivedDamage",9,"受けたDM",0);boot.BK.m=new boot.BK("ReceivedDamageRatio",10,boot.BK.l,1);
		boot.BK.n=new boot.BK("PreventedDamage",11,"軽減したDM",0);boot.BK.o=new boot.BK("PreventedDamageRatio",12,boot.BK.l,1);
		boot.BK.p=new boot.BK("Health",13,2);boot.BK.ba=new boot.BK("HealthPerLv",14,2);boot.BK.bb=new boot.BK("HealthRatio",15,"Health",0);boot.BK.bc=new boot.BK("BounusHealth",16,"増加Health",0);
		boot.BK.bd=new boot.BK("Hreg",17,2,3);boot.BK.be=new boot.BK("HregPerLv",18,2,3);boot.BK.bf=new boot.BK("HregRatio",19,"Hreg",2,4);
		boot.BK.bg=new boot.BK("Mana",20,"Mana",0);boot.BK.bh=new boot.BK("ManaPerLv",21,2);boot.BK.bi=new boot.BK("ManaRatio",22,"Mana",0);boot.BK.bj=new boot.BK("BounusMana",23,"増加Mana",0);
		boot.BK.bk=new boot.BK("Mreg",24,2,3);boot.BK.bl=new boot.BK("MregPerLv",25,2,3);boot.BK.bm=new boot.BK("MregRatio",26,"Mreg",2,4);
		boot.BK.bn=new boot.BK("Energy",27,2);boot.BK.bo=new boot.BK("EnergyPerLv",28,2);boot.BK.bp=new boot.BK("EnergyRatio",29,"Energy",0);
		boot.BK.ca=new boot.BK("Ereg",30,2);boot.BK.cb=new boot.BK("EregPerLv",31,2);boot.BK.cc=new boot.BK("EregRatio",32,"Energy",0);
		boot.BK.cd=new boot.BK("CurrentHealthRatio",33,"現在のHealth",0);
		boot.BK.ce=new boot.BK("MissingHealthRatio",34,"失ったHealth",0);
		boot.BK.cf=new boot.BK("MissingHealthPercentage",35,"Health損耗率",0);
		boot.BK.cg=new boot.BK("TargetMaxHealthRatio",36,"対象の最大Health",0);
		boot.BK.ch=new boot.BK("TargetCurrentHealthRatio",37,"対象の現在のHealth",0);
		boot.BK.ci=new boot.BK("TargetMissingHealthRatio",38,"対象の減っているHealth",0);
		boot.BK.cj=new boot.BK("TargetMissingHealthPercentage",39,"対象のHealth損耗率",0);
		boot.BK.ck=new boot.BK("CurrentManaRatio",40,"現在のMana",0);
		boot.BK.cl=new boot.BK("MissingManaRatio",41,"失ったMana",0);
		boot.BK.cm=new boot.BK("MissingManaPercentage",42,"Mana損耗率",0);
		boot.BK.cn=new boot.BK("TargetAP",43,"対象のAP",0);
		boot.BK.co=new boot.BK("TargetManaRatio",44,"対象の最大Mana",0);
		boot.BK.cp=new boot.BK("TargetCurrentManaRatio",45,"対象の現在のMana",0);
		boot.BK.da=new boot.BK("TargetMissingManaRatio",46,"対象の減っているMana",0);
		boot.BK.db=new boot.BK("TargetMissingManaPercetage",47,"対象のMana損耗率",0);
		boot.BK.dc=new boot.BK("AD",48,2);boot.BK.dd=new boot.BK("ADPerLv",49,2);boot.BK.de=new boot.BK("ADRatio",50,"AD",0);boot.BK.df=new boot.BK("BounusAD",51,"増加AD",0);
		boot.BK.dg=new boot.BK("AS",52,3,3);boot.BK.dh=new boot.BK("ASPerLv",53,3,3);boot.BK.di=new boot.BK("ASRatio",54,"攻撃速度",0);
		boot.BK.dj=new boot.BK("LS",55,"Life Steal",0);boot.BK.dk=new boot.BK("LSPerLv",56,2);boot.BK.dl=new boot.BK("LSRatio",57,2);
		boot.BK.dm=new boot.BK("Critical",58,"Critical Chance",0);boot.BK.dn=new boot.BK("CriticalPerLv",59,2);boot.BK.dp=new boot.BK("CriticalRatio",60,2);
		boot.BK.ea=new boot.BK("AP",61,2);boot.BK.eb=new boot.BK("APPerLv",62,2);boot.BK.ec=new boot.BK("APRatio",63,2);
		boot.BK.ed=new boot.BK("CDR",64,"CD減少",0);boot.BK.ee=new boot.BK("CDRPerLv",65,2);boot.BK.ef=new boot.BK("CDRRatio",66,2);
		boot.BK.eg=new boot.BK("SV",67,"Spell Vamp",0);boot.BK.eh=new boot.BK("SVPerLv",68,2);boot.BK.ei=new boot.BK("SVRatio",69,2);
		boot.BK.ej=new boot.BK("ARPen",70,2);boot.BK.ek=new boot.BK("ARPenPerLv",71,2);
		boot.BK.el=new boot.BK("ARPenRatio",72,"ARPen",0);boot.BK.em=new boot.BK("ARPenRatioPerLv",73,2);
		boot.BK.en=new boot.BK("ARReduction",74,"AR減少",0);
		boot.BK.eo=new boot.BK("ARReductionRatio",75,"AR減少",0);
		boot.BK.ep=new boot.BK("MRPen",76,2);boot.BK.fa=new boot.BK("MRPenPerLv",77,2);
		boot.BK.fb=new boot.BK("MRPenRatio",78,"MRPen",0);boot.BK.fc=new boot.BK("MRPenRatioPerLv",79,2);
		boot.BK.fd=new boot.BK("MRReduction",80,"MR減少",0);
		boot.BK.fe=new boot.BK("MRReductionRatio",81,"MR減少",0);
		boot.BK.ff=new boot.BK("AR",82,2);boot.BK.fg=new boot.BK("ARPerLv",83,2);boot.BK.fh=new boot.BK("ARRatio",84,"AR",3,4);boot.BK.fi=new boot.BK("BounusAR",85,"増加AR",0);
		boot.BK.fj=new boot.BK("MR",86,2);boot.BK.fk=new boot.BK("MRPerLv",87,2);boot.BK.fl=new boot.BK("MRRatio",88,"MR",3,4);boot.BK.fm=new boot.BK("BounusMR",89,"増加MR",0);
		boot.BK.fn=new boot.BK("DamageReduction",90,boot.BK.c,1);boot.BK.fo=new boot.BK("DamageReductionRatio",91,boot.BK.c,1);
		boot.BK.fp=new boot.BK("PhysicalDamageReduction",92,boot.BK.e,1);boot.BK.ga=new boot.BK("PhysicalDamageReductionRatio",93,boot.BK.e,1);
		boot.BK.gb=new boot.BK("MagicDamageReduction",94,boot.BK.f,1);boot.BK.gc=new boot.BK("MagicDamageReductionRatio",95,boot.BK.f,1);
		boot.BK.gd=new boot.BK("AttackDamageReduction",96,boot.BK.h,1);boot.BK.ge=new boot.BK("AttackDamageReductionRatio",97,boot.BK.h,1);
		boot.BK.gf=new boot.BK("Shield",98,"シールド",0);boot.BK.gg=new boot.BK("PhysicalShield",99,"物理DM用シールド",0);boot.BK.gh=new boot.BK("MagicShield",100,"魔法DM用シールド",0);boot.BK.gi=new boot.BK("SpellShield",101,"スペルシールド",0);
		boot.BK.gj=new boot.BK("Range",102,"射程",0);boot.BK.gk=new boot.BK("RangePerLv",103,2);boot.BK.gl=new boot.BK("RangeRatio",104,"射程",0);
		boot.BK.gm=new boot.BK("Lv",105,2);
		boot.BK.gn=new boot.BK("Tenacity",106,"Tenacity",0);boot.BK.go=new boot.BK("TenacityPerLv",107,2);
		boot.BK.gp=new boot.BK("Experiment",108,"経験値",0);boot.BK.ha=new boot.BK("ExperimentRatio",109,"経験値",0);
		boot.BK.hb=new boot.BK("CD",110,1,3);boot.BK.hc=new boot.BK("CDPerLv",111,2);boot.BK.hd=new boot.BK("CDDecrease",112,1,3);
		boot.BK.he=new boot.BK("RestoreHealth",113,"Health",0);
		boot.BK.hf=new boot.BK("RestoreHealthRatio",114,"Health回復量",3,4);
		boot.BK.hg=new boot.BK("RestoreMana",115,"Mana",0);
		boot.BK.hh=new boot.BK("RestoreEnergy",116,"気",0);
		boot.BK.hi=new boot.BK("Charm",117,"魅了",3,4);
		boot.BK.hj=new boot.BK("Stun",118,"スタン",3,4);
		boot.BK.hk=new boot.BK("Snare",119,"スネア",3,4);
		boot.BK.hl=new boot.BK("Fear",120,"Fear",3,4);
		boot.BK.hm=new boot.BK("Terrified",121,"Terrified",3,4);
		boot.BK.hn=new boot.BK("Silence",122,"サイレンス",3,4);
		boot.BK.ho=new boot.BK("Blind",123,"ブラインド",3,4);
		boot.BK.hp=new boot.BK("Taunt",124,"タウント",3,4);
		boot.BK.ia=new boot.BK("Suppression",125,"サプレッション",3,4);
		boot.BK.ib=new boot.BK("Knockup",126,"打ち上げ",3,4);
		boot.BK.ic=new boot.BK("Knockback",127,"ノックバック",0);
		boot.BK.id=new boot.BK("MSSlow",128,"移動速度低下",0);boot.BK.ie=new boot.BK("MSSlowRatio",129,"スロー",0);
		boot.BK.ig=new boot.BK("ASSlow",130,"攻撃速度低下",0);boot.BK.ih=new boot.BK("ASSlowRatio",131,boot.BK.ig,1);
		boot.BK.ii=new boot.BK("Wounds",132,"HP回復量半減",0);
		boot.BK.ij=new boot.BK("Foggy",133,"視界低下",0);
		boot.BK.ik=new boot.BK("MS",134,"移動速度",0);boot.BK.il=new boot.BK("MSPerLv",135,2);boot.BK.im=new boot.BK("MSRatio",136,"移動速度",0);boot.BK.io=new boot.BK("BounusMS",137,"増加移動速度",0);
		boot.BK.ip=new boot.BK("IgnoreSlow",138,""+boot.BK.ie.kf+"無効",0);
		boot.BK.ja=new boot.BK("IgnoreUnitCollision",139,"ユニット衝突無効",0);
		boot.BK.jb=new boot.BK("IgnoreCC",140,"CC無効",0);
		boot.BK.jc=new boot.BK("Stealth",141,"ステルス",0);
		boot.BK.jd=new boot.BK("Visionable",142,"視界を得る",0);
		boot.BK.je=new boot.BK("Chill",143,2);
		boot.BK.jf=new boot.BK("Cost",144,2);boot.BK.jg=new boot.BK("CostPerLv",145,2);
		boot.BK.jh=new boot.BK("Sell",146,2);
		boot.BK.ji=new boot.BK("Gold",147,"",0);
		boot.BK.jj=new boot.BK("Time",148,"",3,4);boot.BK.jk=new boot.BK("CDRAwareTime",149,"",0);
		boot.BK.jl=new boot.BK("Duration",150,"経過秒数",0);
		boot.BK.jm=new boot.BK("Count",151,"",3,4);boot.BK.jn=new boot.BK("Radius",152,"範囲",0);
		boot.BK.jo=new boot.BK("Length",153,"長さ",0);
		boot.BK.jp=new boot.BK("Distance",154,"距離",0);
		boot.BK.ka=new boot.BK("MissileSpeed",155,"弾速",0);
		boot.BK.kb=new boot.BK("EnemyChampion",156,"敵Championの数",0);
		boot.BK.kc=new boot.BK("Percentage",157,"",0);
		boot.BK.kd=new boot.BK("Charge",158,2);
		boot.BK.ke=new boot.BK("Stack",159,"スタック",0);
		boot.BK.ki=[boot.BK.c,boot.BK.d,boot.BK.e,boot.BK.f,boot.BK.g,boot.BK.h,boot.BK.i,boot.BK.j,boot.BK.k,boot.BK.l,boot.BK.m,boot.BK.n,boot.BK.o,boot.BK.p,boot.BK.ba,boot.BK.bb,boot.BK.bc,boot.BK.bd,boot.BK.be,boot.BK.bf,boot.BK.bg,boot.BK.bh,boot.BK.bi,boot.BK.bj,boot.BK.bk,boot.BK.bl,boot.BK.bm,boot.BK.bn,boot.BK.bo,boot.BK.bp,boot.BK.ca,boot.BK.cb,boot.BK.cc,boot.BK.cd,boot.BK.ce,boot.BK.cf,boot.BK.cg,boot.BK.ch,boot.BK.ci,boot.BK.cj,boot.BK.ck,boot.BK.cl,boot.BK.cm,boot.BK.cn,boot.BK.co,boot.BK.cp,boot.BK.da,boot.BK.db,boot.BK.dc,boot.BK.dd,boot.BK.de,boot.BK.df,boot.BK.dg,boot.BK.dh,boot.BK.di,boot.BK.dj,boot.BK.dk,boot.BK.dl,boot.BK.dm,boot.BK.dn,boot.BK.dp,boot.BK.ea,boot.BK.eb,boot.BK.ec,boot.BK.ed,boot.BK.ee,boot.BK.ef,boot.BK.eg,boot.BK.eh,boot.BK.ei,boot.BK.ej,boot.BK.ek,boot.BK.el,boot.BK.em,boot.BK.en,boot.BK.eo,boot.BK.ep,boot.BK.fa,boot.BK.fb,boot.BK.fc,boot.BK.fd,boot.BK.fe,boot.BK.ff,boot.BK.fg,boot.BK.fh,boot.BK.fi,boot.BK.fj,boot.BK.fk,boot.BK.fl,boot.BK.fm,boot.BK.fn,boot.BK.fo,boot.BK.fp,boot.BK.ga,boot.BK.gb,boot.BK.gc,boot.BK.gd,boot.BK.ge,boot.BK.gf,boot.BK.gg,boot.BK.gh,boot.BK.gi,boot.BK.gj,boot.BK.gk,boot.BK.gl,boot.BK.gm,boot.BK.gn,boot.BK.go,boot.BK.gp,boot.BK.ha,boot.BK.hb,boot.BK.hc,boot.BK.hd,boot.BK.he,boot.BK.hf,boot.BK.hg,boot.BK.hh,boot.BK.hi,boot.BK.hj,boot.BK.hk,boot.BK.hl,boot.BK.hm,boot.BK.hn,boot.BK.ho,boot.BK.hp,boot.BK.ia,boot.BK.ib,boot.BK.ic,boot.BK.id,boot.BK.ie,boot.BK.ig,boot.BK.ih,boot.BK.ii,boot.BK.ij,boot.BK.ik,boot.BK.il,boot.BK.im,boot.BK.io,boot.BK.ip,boot.BK.ja,boot.BK.jb,boot.BK.jc,boot.BK.jd,boot.BK.je,boot.BK.jf,boot.BK.jg,boot.BK.jh,boot.BK.ji,boot.BK.jj,boot.BK.jk,boot.BK.jl,boot.BK.jm,boot.BK.jn,boot.BK.jo,boot.BK.jp,boot.BK.ka,boot.BK.kb,boot.BK.kc,boot.BK.kd,boot.BK.ke];
	},
	// teemowork.model.Status#<init>(java.lang.String, int)
	$2:function(A,B){
		boot.BK.prototype.$3.call(this,A,B,0);
	},
	// teemowork.model.Status#<init>(java.lang.String, int, java.lang.String)
	$0:function(A,B,C){
		boot.BK.prototype.$4.call(this,A,B,C,0);
	},
	// teemowork.model.Status#<init>(java.lang.String, int, teemowork.model.Status)
	$1:function(A,B,C){
		boot.BK.prototype.$4.call(this,A,B,C.kf,0);
	},
	// teemowork.model.Status#<init>(java.lang.String, int, int)
	$3:function(A,B,C){
		boot.BK.prototype.$4.call(this,A,B,null,C);
	},
	// teemowork.model.Status#<init>(java.lang.String, int, java.lang.String, int)
	$4:function(A,B,C,D){
		boot.M.prototype.$0.call(this,A,B);
		this.kf=(C==null?this.S():C);
		this.kg=D;
	},
	// teemowork.model.Status#per()
	Cu:function(){
		return boot.BK.Cv(""+this.S()+"PerLv");
	},
	// teemowork.model.Status#ratio()
	Cw:function(){
		return boot.BK.Cv(""+this.S()+"Ratio");
	},
	// teemowork.model.Status#round(double)
	Cx:function(A){
		return boot.BX.Cy(A,this.kg);
	},
	// teemowork.model.Status#compute(double, double)
	Cz:function(A,C){
		switch(this.CB()+1){
			case 73:
			case 76:
			case 79:
			case 82:
			case 107:
			return (1-(1-A/100.0)*(1-C/100.0))*100.0;
		}
		return (A+C);
	},
	// teemowork.model.Status#getUnit()
	DA:function(){
		if(this.S().endsWith("Ratio")==0){
			switch(this.CB()+1){
				case 56:
				case 59:
				case 65:
				case 68:
				case 107:
				case 158:
				return "%";
				case 113:
				case 118:
				case 119:
				case 120:
				case 121:
				case 122:
				case 123:
				case 124:
				case 125:
				case 126:
				case 127:
				case 133:
				case 149:
				case 150:
				return "秒";
				case 142:
				return "秒間";
				case 148:
				return "Gold";
			}
			return "";
		}else{
			return "%";
		}
	},
	// teemowork.model.Status#format(double)
	DB:function(A){
		switch(this.CB()+1){
			case 2:
			case 51:
			case 55:
			case 59:
			case 85:
			case 89:
			case 110:
			case 135:
			case 137:
			return ""+this.kf+"が"+this.DC(A)+"増加";
			case 91:
			case 92:
			case 93:
			case 94:
			case 95:
			case 96:
			case 97:
			case 98:
			return ""+this.kf+"を"+this.DC(A)+"軽減";
			case 113:
			return "CDが"+this.DC(A)+"解消";
			case 114:
			case 116:
			case 117:
			return ""+this.kf+"が"+this.DC(A)+"回復";
			case 142:
			return ""+this.DC(A)+"ステルス";
			default:
			return ""+this.kf+this.DC(A);
		}
	},
	// teemowork.model.Status#formatValue(double)
	DC:function(A){
		return (A==0?"":""+this.Cx(A)+this.DA());
	},
	// teemowork.model.Status#toString()
	toString:function(){
		return this.kf;
	},
	// teemowork.model.Status#values()
	_DD:function(A,B,C){
		A=boot.BK.ki;B=A.length;C=new Array(B);A.copy(0,C,0,B);return C;
	},
	// teemowork.model.Status#valueOf(java.lang.String)
	_Cv:function(A){
		return boot.M.CE(boot.BK.$,A);
	}
});

boot.define("BJ","",[],{
	// js.application.Page#<init>()
	$0:function(){
	}
});

boot.define("BQ","",["U"],{
	BV:null,DI:null,DJ:null,BW:null,DG:null,equals:null,hashCode:null,DK:null,BR:null,BG:null,BD:null,BB:null,DL:null,BA:null,DO:null,BZ:null,BY:null,Bu:null,DF:null,DH:null,Bv:null,DN:null,DM:null,Bw:null,Bx:null
});

boot.define("Bu","",["V"],{
	DW:null,Bz:null,BI:null,BH:null,DV:null,DU:null,DR:null,DS:null,DT:null
});

boot.define("BY","",["V","Bu"],{
	a:0,
	// js.util.ArrayList$View#<init>(js.util.ArrayList, int)
	$1:function(A,B){
		this.b=A;;
		this.a=0;
		this.a=B;
	},
	// js.util.ArrayList$View#hasNext()
	BI:function(){
		return this.a<boot.BL.DQ(this.b).length;
	},
	// js.util.ArrayList$View#next()
	BH:function(){
		return boot.BL.DQ(this.b)[this.a++];
	},
	// js.util.ArrayList$View#nextIndex()
	DR:function(){
		return this.a;
	},
	// js.util.ArrayList$View#hasPrevious()
	DS:function(){
		return this.a>0;
	},
	// js.util.ArrayList$View#previous()
	DT:function(){
		this.a=(this.a-1);
		return boot.BL.DQ(this.b)[this.a];
	},
	// js.util.ArrayList$View#previousIndex()
	DU:function(){
		return (this.a-1);
	},
	// js.util.ArrayList$View#remove()
	Bz:function(){
		if(!(this.a<=0)){
			boot.BL.DQ(this.b).splice((this.a-1),1)[0];
		}
	},
	// js.util.ArrayList$View#set(java.lang.Object)
	DV:function(A){
		boot.BL.DQ(this.b)[this.a]=A;
	},
	// js.util.ArrayList$View#add(java.lang.Object)
	DW:function(A){
		throw new boot.K(1);
	},
	// js.util.ArrayList$View#<init>(js.util.ArrayList, int, js.util.ArrayList$View)
	$0:function(A,B,C){
		boot.BY.prototype.$1.call(this,A,B);
	}
});

boot.define("BZ","BC",[],{
	// java.lang.IndexOutOfBoundsException#<init>()
	$1:function(){
		boot.BC.prototype.$0.call(this);
	},
	// java.lang.IndexOutOfBoundsException#<init>(java.lang.String)
	$0:function(A){
		boot.BC.prototype.$1.call(this,A);
	}
});

boot.define("BL","T",["BQ"],{
	// js.util.ArrayList#<init>()
	$0:function(){
		boot.T.prototype.$0.call(this);
		this.a=[];
	},
	// js.util.ArrayList#<init>(int)
	$1:function(A){
		boot.T.prototype.$0.call(this);
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
	BG:function(){
		return new boot.BY(this,0,null,0);
	},
	// js.util.ArrayList#add(java.lang.Object)
	BV:function(A){
		this.a.push(A);
		return true;
	},
	// js.util.ArrayList#remove(java.lang.Object)
	BW:function(A,B){
		B=this.a.indexOf(A);
		if(B!=-1){
			this.a.splice(B,1)[0];
			return true;
		}else{
			return false;
		}
	},
	// js.util.ArrayList#addAll(int, java.util.Collection)
	DF:function(A,B){
		return false;
	},
	// js.util.ArrayList#clear()
	BR:function(){
		this.a=[];
	},
	// js.util.ArrayList#get(int)
	DG:function(A){
		return this.a[A];
	},
	// js.util.ArrayList#set(int, java.lang.Object)
	DH:function(A,B){
		return this.a[A]=B;
	},
	// js.util.ArrayList#add(int, java.lang.Object)
	DI:function(A,B){
		this.a.splice(A,0,B);
	},
	// js.util.ArrayList#remove(int)
	DJ:function(A){
		return this.a.splice(A,1)[0];
	},
	// js.util.ArrayList#indexOf(java.lang.Object)
	DK:function(A){
		return this.a.indexOf(A);
	},
	// js.util.ArrayList#lastIndexOf(java.lang.Object)
	DL:function(A){
		return this.a.lastIndexOf(A);
	},
	// js.util.ArrayList#listIterator()
	DM:function(){
		return new boot.BY(this,0,null,0);
	},
	// js.util.ArrayList#listIterator(int)
	DN:function(A){
		return new boot.BY(this,A,null,0);
	},
	// js.util.ArrayList#subList(int, int)
	DO:function(A,B){
		throw new boot.K(1);
	},
	// js.util.ArrayList#checkRange(int)
	DP:function(A){
		if(A>=0){
			if(this.BA()>A){
				return;
			}else{
				throw new boot.BZ("Index is overflowed. Size: "+this.BA()+"  Index: "+A,0);
			}
		}else{
			throw new boot.BZ("Negative index is unacceptable. Size: "+this.BA()+"  Index: "+A,0);
		}
	},
	// js.util.ArrayList#access$0(js.util.ArrayList)
	_DQ:function(A){
		return A.a;
	}
});

boot.define("Bw","M",[],{
	// teemowork.model.SkillKey#<clinit>()
	_:function(){
		boot.Bw.c=new boot.Bw("Passive",0,0);
		boot.Bw.d=new boot.Bw("Q",1,0);
		boot.Bw.e=new boot.Bw("W",2,0);
		boot.Bw.f=new boot.Bw("E",3,0);
		boot.Bw.g=new boot.Bw("R",4,0);
		boot.Bw.h=[boot.Bw.c,boot.Bw.d,boot.Bw.e,boot.Bw.f,boot.Bw.g];
	},
	// teemowork.model.SkillKey#<init>(java.lang.String, int)
	$0:function(A,B){
		boot.M.prototype.$0.call(this,A,B);
	},
	// teemowork.model.SkillKey#values()
	_FD:function(A,B,C){
		A=boot.Bw.h;B=A.length;C=new Array(B);A.copy(0,C,0,B);return C;
	},
	// teemowork.model.SkillKey#valueOf(java.lang.String)
	_FE:function(A){
		return boot.M.CE(boot.Bw.$,A);
	}
});

boot.define("CC","M",[],{
	// teemowork.model.SkillType#<clinit>()
	_:function(){
		boot.CC.c=new boot.CC("Active",0,0);
		boot.CC.d=new boot.CC("Toggle",1,0);
		boot.CC.e=new boot.CC("Channel",2,0);
		boot.CC.f=new boot.CC("OnHitEffectable",3,0);
		boot.CC.g=[boot.CC.c,boot.CC.d,boot.CC.e,boot.CC.f];
	},
	// teemowork.model.SkillType#<init>(java.lang.String, int)
	$0:function(A,B){
		boot.M.prototype.$0.call(this,A,B);
	},
	// teemowork.model.SkillType#values()
	_FQ:function(A,B,C){
		A=boot.CC.g;B=A.length;C=new Array(B);A.copy(0,C,0,B);return C;
	},
	// teemowork.model.SkillType#valueOf(java.lang.String)
	_FR:function(A){
		return boot.M.CE(boot.CC.$,A);
	}
});

boot.define("CQ","",[],{
	// teemowork.model.SkillStatus$VariableReference#<init>(java.lang.String)
	$1:function(A){
		this.a=A;
	},
	// teemowork.model.SkillStatus$VariableReference#toString()
	toString:function(){
		return this.a;
	},
	// teemowork.model.SkillStatus$VariableReference#<init>(java.lang.String, teemowork.model.SkillStatus$VariableReference)
	$0:function(A,B){
		boot.CQ.prototype.$1.call(this,A);
	}
});

boot.define("CB","",[],{
	// teemowork.model.variable.VariableResolver#<init>()
	$0:function(){
	},
	// teemowork.model.variable.VariableResolver#isSkillLevelBased()
	FU:function(){
		return true;
	},
	// teemowork.model.variable.VariableResolver#convertLevel(int)
	FV:function(A){
		return A;
	}
});

boot.define("CK","CB",[],{
	// teemowork.model.variable.VariableResolver$Diff#<init>(double, double, int)
	$0:function(A,C,E){
		boot.CB.prototype.$0.call(this);
		this.a=A;
		this.b=C;
		this.c=E;
	},
	// teemowork.model.variable.VariableResolver$Diff#compute(int)
	FS:function(A){
		return (this.a+this.b*(A-1));
	},
	// teemowork.model.variable.VariableResolver$Diff#estimateSize()
	FT:function(){
		return (this.a==0?0:(this.b==0?1:this.c));
	}
});

boot.define("CR","",[],{
	Fw:null
});

boot.define("CP","",[],{
	c:false,
	// teemowork.model.variable.Variable#<init>()
	$2:function(){
		this.c=0;
		this.d=new boot.BL(0);
		this.e=new boot.R(0);
	},
	// teemowork.model.variable.Variable#<init>(teemowork.model.Status, teemowork.model.variable.VariableResolver)
	$0:function(A,B){
		this.c=0;
		this.d=new boot.BL(0);
		this.e=new boot.R(0);
		this.a=A;
		this.b=B;
	},
	// teemowork.model.variable.Variable#<init>(teemowork.model.Status, teemowork.model.variable.VariableResolver, teemowork.model.variable.Variable)
	$1:function(A,B,C){
		this.c=0;
		this.d=new boot.BL(0);
		this.e=new boot.R(0);
		this.a=A;
		this.b=B;
		if(!(C==null)){
			this.d.BV(C);
		}
	},
	// teemowork.model.variable.Variable#getStatus()
	FW:function(){
		return this.a;
	},
	// teemowork.model.variable.Variable#setStatus(teemowork.model.Status)
	FX:function(A){
		this.a=A;
	},
	// teemowork.model.variable.Variable#getResolver()
	FY:function(){
		return this.b;
	},
	// teemowork.model.variable.Variable#setResolver(teemowork.model.variable.VariableResolver)
	FZ:function(A){
		this.b=A;
	},
	// teemowork.model.variable.Variable#isConditional()
	Fu:function(){
		return this.c;
	},
	// teemowork.model.variable.Variable#setConditional()
	FP:function(){
		this.c=1;
	},
	// teemowork.model.variable.Variable#calculate(int, teemowork.model.StatusCalculator)
	Fv:function(A,B,C,E,F){
		if(this.e.BV(B)!=0){
			C=this.b.FS(A);
			F=this.d.BG();
			l4:for (;
			F.BI()!=0;
			C=(C+E.Fv(A,B)*B.Fw(E.FW()))) {
				E=F.BH();
			}if((this.a==boot.BK.hb||this.a==boot.BK.jk)){
				C=C*(1-B.Fw(boot.BK.ed)/100.0);
			}this.e.BW(B);
			return C;
		}else{
			return 0;
		}
	},
	// teemowork.model.variable.Variable#getAmplifiers()
	Fx:function(){
		return this.d;
	},
	// teemowork.model.variable.Variable#add(teemowork.model.variable.Variable)
	FC:function(A){
		if(!(A==null)){
			this.d.BV(A);
		}
	}
});

boot.define("Bx","",[],{
	c:false,
	// teemowork.model.SkillStatus#<init>(teemowork.model.Skill, teemowork.model.SkillStatus)
	$0:function(A,B){
		this.c=1;
		this.a=A;
		this.b=B;
		if(B!=null){
			this.d=B.d.slice(0);
			this.e=B.e;
			this.j=B.j;
			this.k=B.k;
			this.i=B.i;
			this.g=B.g;
			this.f=B.f;
			this.h=B.h;
		}else{
			this.d=[];
			this.e=new boot.L(0);
			this.j=new boot.BL(0);
			this.k=new boot.BL(0);
			this.i=boot.CC.c;
			this.c=0;
		}
	},
	// teemowork.model.SkillStatus#getPassive()
	FF:function(A,B,C){
		A=new boot.BL(0);
		C=this.j.BG();
		l2:while (C.BI()!=0) {
			B=C.BH();
			if(B instanceof boot.CQ==0){
				A.BV(B);
				continue l2;
			}else{
				A.BV(this.e.BJ(B.toString()));
				continue l2;
			}
		}return A;
	},
	// teemowork.model.SkillStatus#getActive()
	FG:function(A,B,C){
		A=new boot.BL(0);
		C=this.k.BG();
		l2:while (C.BI()!=0) {
			B=C.BH();
			if(B instanceof boot.CQ==0){
				A.BV(B);
				continue l2;
			}else{
				A.BV(this.e.BJ(B.toString()));
				continue l2;
			}
		}return A;
	},
	// teemowork.model.SkillStatus#get(int)
	FH:function(A){
		if(this.e!=null){
			return this.e.BJ(A);
		}else{
			return this.b.FH(A);
		}
	},
	// teemowork.model.SkillStatus#put(int, teemowork.model.variable.Variable)
	FI:function(A,B){
		if(!(this.c==0)){
			this.e=new boot.L(0);
			if(!(this.b==null)){
				this.e.z(this.b.e);
			}
		}
	},
	// teemowork.model.SkillStatus#get(teemowork.model.Status)
	CN:function(A,B){
		B=this.d[A.CB()];
		return (B==null?0:B);
	},
	// teemowork.model.SkillStatus#set(teemowork.model.Status, double)
	FJ:function(A,B){
		this.d[A.CB()]=B;
		return this;
	},
	// teemowork.model.SkillStatus#passive(java.lang.String)
	Dz:function(A){
		this.j=new boot.BL(0);
		return this.FK(this.j,A);
	},
	// teemowork.model.SkillStatus#active(java.lang.String)
	ED:function(A){
		this.k=new boot.BL(0);
		return this.FK(this.k,A);
	},
	// teemowork.model.SkillStatus#parse(java.util.List, java.lang.String)
	FK:function(A,B,C,D,E,F){
		A.BR();
		F=B.split(/[\{\}]/);E=F.length;D=0;
		l2:while (D<E) {
			C=F[D];
			if((C.length!=1||jQuery.isNumeric(C.charAt(0))==0)){
				A.BV(C);
			}else{
				A.BV(new boot.CQ(C,null,0));
			}++D;
			continue l2;
		}return this;
	},
	// teemowork.model.SkillStatus#variable(int, teemowork.model.Status)
	EO:function(A,B){
		return this.EA(A,B,0);
	},
	// teemowork.model.SkillStatus#variable(int, teemowork.model.Status, double)
	EA:function(A,B,C){
		return this.EK(A,B,C,0);
	},
	// teemowork.model.SkillStatus#variable(int, teemowork.model.Status, double, double)
	EK:function(A,B,C,E){
		return this.EQ(A,B,C,E,null,null);
	},
	// teemowork.model.SkillStatus#variable(int, teemowork.model.Status, teemowork.model.variable.VariableResolver)
	ES:function(A,B,C){
		return this.Ev(A,B,C,null,null);
	},
	// teemowork.model.SkillStatus#variable(int, teemowork.model.Status, double, double, teemowork.model.variable.Variable)
	EG:function(A,B,C,E,G){
		return this.EQ(A,B,C,E,G,null);
	},
	// teemowork.model.SkillStatus#variable(int, teemowork.model.Status, double, double, teemowork.model.variable.Variable, teemowork.model.variable.Variable)
	EQ:function(A,B,C,E,G,H){
		return this.Ev(A,B,new boot.CK(C,E,this.a.FA(),0),G,H);
	},
	// teemowork.model.SkillStatus#variable(int, teemowork.model.Status, teemowork.model.variable.VariableResolver, teemowork.model.variable.Variable, teemowork.model.variable.Variable)
	Ev:function(A,B,C,D,E,F){
		F=new boot.CP(B,C,0);
		F.FC(D);
		F.FC(E);
		if(!(this.c==0)){
			this.c=0;
			this.e=new boot.L(0);
			if(!(this.b==null)){
				this.e.z(this.b.e);
			}
		}this.e.T(""+A,F);
		return this;
	},
	// teemowork.model.SkillStatus#cd(double)
	EV:function(A){
		return this.EH(A,0);
	},
	// teemowork.model.SkillStatus#cd(double, double)
	EH:function(A,C){
		return this.Ey(new boot.CK(A,C,this.a.FA(),0));
	},
	// teemowork.model.SkillStatus#cd(teemowork.model.variable.VariableResolver)
	Ey:function(A){
		this.h=new boot.CP(boot.BK.hb,A,0);
		return this;
	},
	// teemowork.model.SkillStatus#mana(double)
	EU:function(A){
		return this.EB(boot.BK.bg,A,0);
	},
	// teemowork.model.SkillStatus#mana(double, double)
	EI:function(A,C){
		return this.EB(boot.BK.bg,A,C);
	},
	// teemowork.model.SkillStatus#cost(teemowork.model.Status, double, double)
	EB:function(A,B,D){
		return this.Eu(A,new boot.CK(B,D,this.a.FA(),0),null);
	},
	// teemowork.model.SkillStatus#cost(teemowork.model.Status, teemowork.model.variable.VariableResolver, teemowork.model.variable.Variable)
	Eu:function(A,B,C){
		this.g=new boot.CP(A,B,C,1);
		return this;
	},
	// teemowork.model.SkillStatus#getCost()
	FL:function(){
		return this.g;
	},
	// teemowork.model.SkillStatus#getCooldown()
	FM:function(){
		return this.h;
	},
	// teemowork.model.SkillStatus#getRange()
	FN:function(){
		return this.f;
	},
	// teemowork.model.SkillStatus#range(double)
	EJ:function(A){
		return this.EX(A,0);
	},
	// teemowork.model.SkillStatus#range(double, double)
	EX:function(A,C){
		return this.Ew(new boot.CK(A,C,this.a.FA(),0),null);
	},
	// teemowork.model.SkillStatus#range(teemowork.model.variable.VariableResolver, teemowork.model.variable.Variable)
	Ew:function(A,B){
		this.f=new boot.CP(boot.BK.gj,A,0);
		this.f.FC(B);
		return this;
	},
	// teemowork.model.SkillStatus#getType()
	FO:function(){
		return this.i;
	},
	// teemowork.model.SkillStatus#type(teemowork.model.SkillType)
	EW:function(A){
		this.i=A;
		return this;
	},
	// teemowork.model.SkillStatus#conditional(int)
	EC:function(A,B){
		B=this.e.BJ(""+A);
		if(!(B==null)){
			B.FP();
		}return this;
	}
});

boot.define("CA","CB",[],{
	// teemowork.model.variable.VariableResolver$PerLevel#<init>(int[], double, double)
	$1:function(A,B,D){
		boot.CB.prototype.$0.call(this);
		this.a=A;
		this.b=B;
		this.c=D;
	},
	// teemowork.model.variable.VariableResolver$PerLevel#estimateSize()
	FT:function(){
		return this.a.length;
	},
	// teemowork.model.variable.VariableResolver$PerLevel#compute(int)
	FS:function(A){
		return (this.b+this.c*(A-1));
	},
	// teemowork.model.variable.VariableResolver$PerLevel#isSkillLevelBased()
	FU:function(){
		return false;
	},
	// teemowork.model.variable.VariableResolver$PerLevel#convertLevel(int)
	FV:function(A,B){
		B=0;
		l2:for (;
		B<this.a.length;
		++B) {
			if(A>=this.a[B]){
			}else{
				return B;
			}
		}return this.a.length;
	},
	// teemowork.model.variable.VariableResolver$PerLevel#<init>(int[], double, double, teemowork.model.variable.VariableResolver$PerLevel)
	$0:function(A,B,D,F){
		boot.CA.prototype.$1.call(this,A,B,D);
	}
});

boot.define("Bz","CA",[],{
	// teemowork.model.variable.VariableResolver$Per6Level#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,7,13],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per6Level#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per6Level#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per6Level#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per6Level#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("BR","M",[],{
	// teemowork.model.Version#<clinit>()
	_:function(){
		boot.BR.c=new boot.BR("P0000",0,"Release",2009,10,27,0);
		boot.BR.d=new boot.BR("P1148",1,"Late September",2012,9,26,0);
		boot.BR.e=new boot.BR("P1149",2,"World Championship Hotfix",2012,9,18,0);
		boot.BR.f=new boot.BR("P1150",3,"Shadow Isles",2012,10,25,0);
		boot.BR.g=new boot.BR("P1151",4,"End of Season 2",2012,11,13,0);
		boot.BR.h=new boot.BR("P1152",5,"Preseason 3",2012,12,4,0);
		boot.BR.i=new boot.BR("P1153",6,"Preseason Balance Update 1",2012,12,14,0);
		boot.BR.j=new boot.BR("P1154",7,"Preseason Balance Update 2",2013,1,16,0);
		boot.BR.k=new boot.BR("P303",8,"3.03",2013,2,28,0);
		boot.BR.l=new boot.BR("PBE",9,"Public Beta Environment",2013,1,26,0);boot.BR.bb=[boot.BR.c,boot.BR.d,boot.BR.e,boot.BR.f,boot.BR.g,boot.BR.h,boot.BR.i,boot.BR.j,boot.BR.k,boot.BR.l];
		boot.BR.m=boot.BR.k;
	},
	// teemowork.model.Version#<init>(java.lang.String, int, java.lang.String, int, int, int)
	$0:function(A,B,C,D,E,F){
		boot.M.prototype.$0.call(this,A,B);
		this.n=C;
		this.o=D;
		this.p=E;
		this.ba=F;
	},
	// teemowork.model.Version#values()
	_Du:function(A,B,C){
		A=boot.BR.bb;B=A.length;C=new Array(B);A.copy(0,C,0,B);return C;
	},
	// teemowork.model.Version#valueOf(java.lang.String)
	_Fy:function(A){
		return boot.M.CE(boot.BR.$,A);
	}
});

boot.define("CD","CA",[],{
	// teemowork.model.variable.VariableResolver$Per4Level#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,5,8,12,15],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per4Level#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per4Level#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per4Level#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per4Level#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("CE","CA",[],{
	// teemowork.model.variable.VariableResolver$Per3Level#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,4,7,10,13,16],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per3Level#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per3Level#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per3Level#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per3Level#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("CF","CB",[],{
	// teemowork.model.variable.VariableResolver$Per1Level#<init>(double[])
	$0:function(A){
		boot.CB.prototype.$0.call(this);
		this.a=A;
	},
	// teemowork.model.variable.VariableResolver$Per1Level#<init>(double, double)
	$1:function(A,C,E,F){
		boot.CB.prototype.$0.call(this);
		E=Array.create(18);
		F=0;
		l4:for (;
		F<E.length;
		++F) {
			E[F]=(A+C*F);
		}this.a=E;
	},
	// teemowork.model.variable.VariableResolver$Per1Level#estimateSize()
	FT:function(){
		return 18;
	},
	// teemowork.model.variable.VariableResolver$Per1Level#compute(int)
	FS:function(A){
		return this.a[(A-1)];
	},
	// teemowork.model.variable.VariableResolver$Per1Level#isSkillLevelBased()
	FU:function(){
		return false;
	}
});

boot.define("CG","CB",[],{
	// teemowork.model.variable.VariableResolver$Fixed#<init>(double[])
	$0:function(A){
		boot.CB.prototype.$0.call(this);
		this.a=A;
	},
	// teemowork.model.variable.VariableResolver$Fixed#compute(int)
	FS:function(A){
		return this.a[(A-1)];
	},
	// teemowork.model.variable.VariableResolver$Fixed#estimateSize()
	FT:function(){
		return this.a.length;
	}
});

boot.define("CH","CA",[],{
	// teemowork.model.variable.VariableResolver$Per3LevelAdditional#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,3,6,9,12,15,18],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per3LevelAdditional#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per3LevelAdditional#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per3LevelAdditional#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per3LevelAdditional#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("CI","CA",[],{
	// teemowork.model.variable.VariableResolver$Per5LevelForHeimer#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,6,11,15],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per5LevelForHeimer#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per5LevelForHeimer#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per5LevelForHeimer#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per5LevelForHeimer#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("CJ","CA",[],{
	// teemowork.model.variable.VariableResolver$Per3LevelForKarma#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,3,6,9,12,15],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per3LevelForKarma#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per3LevelForKarma#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per3LevelForKarma#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per3LevelForKarma#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("CL","CA",[],{
	// teemowork.model.variable.VariableResolver$Per4LevelForTrundle#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,5,9,12,15],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per4LevelForTrundle#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per4LevelForTrundle#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per4LevelForTrundle#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per4LevelForTrundle#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("CM","CA",[],{
	// teemowork.model.variable.VariableResolver$Per5Level#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,6,11,16],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per5Level#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per5Level#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per5Level#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per5Level#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("CN","CA",[],{
	// teemowork.model.variable.VariableResolver$Per6LevelForVi#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,7,12],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per6LevelForVi#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per6LevelForVi#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per6LevelForVi#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per6LevelForVi#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("CO","CA",[],{
	// teemowork.model.variable.VariableResolver$Per6LevelForZed#<init>(double, double)
	$0:function(A,C){
		boot.CA.prototype.$0.call(this,[1,7,17],A,C,null);
	},
	// teemowork.model.variable.VariableResolver$Per6LevelForZed#estimateSize()
	FT:function(){
		return boot.CA.prototype.FT.call(this);
	},
	// teemowork.model.variable.VariableResolver$Per6LevelForZed#convertLevel(int)
	FV:function(A){
		return boot.CA.prototype.FV.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per6LevelForZed#compute(int)
	FS:function(A){
		return boot.CA.prototype.FS.call(this,A);
	},
	// teemowork.model.variable.VariableResolver$Per6LevelForZed#isSkillLevelBased()
	FU:function(){
		return boot.CA.prototype.FU.call(this);
	}
});

boot.define("Bv","",[],{
	// teemowork.model.Skill#<clinit>()
	_:function(){
		boot.Bv.a=new boot.Bv("Essence Theft",boot.Bw.c,0);
		boot.Bv.b=new boot.Bv("Orb of Deception",boot.Bw.d,0);
		boot.Bv.c=new boot.Bv("Fox-Fire",boot.Bw.e,0);
		boot.Bv.d=new boot.Bv("Charm",boot.Bw.f,0);
		boot.Bv.e=new boot.Bv("Spirit Rush",boot.Bw.g,0);
		boot.Bv.f=new boot.Bv("Twin Disciplines",boot.Bw.c,0);
		boot.Bv.g=new boot.Bv("Mark of the Assassin",boot.Bw.d,0);
		boot.Bv.h=new boot.Bv("Twilight Shroud",boot.Bw.e,0);
		boot.Bv.i=new boot.Bv("Crescent Slash",boot.Bw.f,0);
		boot.Bv.j=new boot.Bv("Shadow Dance",boot.Bw.g,0);
		boot.Bv.k=new boot.Bv("Trample",boot.Bw.c,0);
		boot.Bv.l=new boot.Bv("Pulverize",boot.Bw.d,0);
		boot.Bv.m=new boot.Bv("Headbutt",boot.Bw.e,0);
		boot.Bv.n=new boot.Bv("Triumphant Roar",boot.Bw.f,0);
		boot.Bv.o=new boot.Bv("Unbreakable Will",boot.Bw.g,0);
		boot.Bv.p=new boot.Bv("Cursed Touch",boot.Bw.c,0);
		boot.Bv.ba=new boot.Bv("Bandage Toss",boot.Bw.d,0);
		boot.Bv.bb=new boot.Bv("Despair",boot.Bw.e,0);
		boot.Bv.bc=new boot.Bv("Tantrum",boot.Bw.f,0);
		boot.Bv.bd=new boot.Bv("Curse of the Sad Mummy",boot.Bw.g,0);
		boot.Bv.be=new boot.Bv("Rebirth",boot.Bw.c,0);
		boot.Bv.bf=new boot.Bv("Flash Frost",boot.Bw.d,0);
		boot.Bv.bg=new boot.Bv("Crystalize",boot.Bw.e,0);
		boot.Bv.bh=new boot.Bv("Frostbite",boot.Bw.f,0);
		boot.Bv.bi=new boot.Bv("Glacial Storm",boot.Bw.g,0);
		boot.Bv.bj=new boot.Bv("Pyromania",boot.Bw.c,0);
		boot.Bv.bk=new boot.Bv("Disintegrate",boot.Bw.d,0);
		boot.Bv.bl=new boot.Bv("Incinerate",boot.Bw.e,0);
		boot.Bv.bm=new boot.Bv("Molten Shield",boot.Bw.f,0);
		boot.Bv.bn=new boot.Bv("Summon: Tibbers",boot.Bw.g,0);
		boot.Bv.bo=new boot.Bv("Focus",boot.Bw.c,0);
		boot.Bv.bp=new boot.Bv("Frost Shot",boot.Bw.d,0);
		boot.Bv.ca=new boot.Bv("Volley",boot.Bw.e,0);
		boot.Bv.cb=new boot.Bv("Hawkshot",boot.Bw.f,0);
		boot.Bv.cc=new boot.Bv("Enchanted Crystal Arrow",boot.Bw.g,0);
		boot.Bv.cd=new boot.Bv("Mana Barrier",boot.Bw.c,0);
		boot.Bv.ce=new boot.Bv("Rocket Grab",boot.Bw.d,0);
		boot.Bv.cf=new boot.Bv("Overdrive",boot.Bw.e,0);
		boot.Bv.cg=new boot.Bv("Power Fist",boot.Bw.f,0);
		boot.Bv.ch=new boot.Bv("Static Field",boot.Bw.g,0);
		boot.Bv.ci=new boot.Bv("Blaze",boot.Bw.c,0);
		boot.Bv.cj=new boot.Bv("Sear",boot.Bw.d,0);
		boot.Bv.ck=new boot.Bv("Pillar of Flame",boot.Bw.e,0);
		boot.Bv.cl=new boot.Bv("Conflagration",boot.Bw.f,0);
		boot.Bv.cm=new boot.Bv("Pyroclasm",boot.Bw.g,0);
		boot.Bv.cn=new boot.Bv("Headshot",boot.Bw.c,0);
		boot.Bv.co=new boot.Bv("Piltover Peacemaker",boot.Bw.d,0);
		boot.Bv.cp=new boot.Bv("Yordle Snap Trap",boot.Bw.e,0);
		boot.Bv.da=new boot.Bv("90 Caliber Net",boot.Bw.f,0);
		boot.Bv.db=new boot.Bv("Ace in the Hole",boot.Bw.g,0);
		boot.Bv.dc=new boot.Bv("Deadly Cadence",boot.Bw.c,0);
		boot.Bv.dd=new boot.Bv("Noxious Blast",boot.Bw.d,0);
		boot.Bv.de=new boot.Bv("Miasma",boot.Bw.e,0);
		boot.Bv.df=new boot.Bv("Twin Fang",boot.Bw.f,0);
		boot.Bv.dg=new boot.Bv("Petrifying Gaze",boot.Bw.g,0);
		boot.Bv.dh=new boot.Bv("Carnivore",boot.Bw.c,0);
		boot.Bv.di=new boot.Bv("Rupture",boot.Bw.d,0);
		boot.Bv.dj=new boot.Bv("Feral Scream",boot.Bw.e,0);
		boot.Bv.dk=new boot.Bv("Vorpal Spikes",boot.Bw.f,0);
		boot.Bv.dl=new boot.Bv("Feast",boot.Bw.g,0);
		boot.Bv.dm=new boot.Bv("Hextech Shrapnel Shells",boot.Bw.c,0);
		boot.Bv.dn=new boot.Bv("Phosphorus Bomb",boot.Bw.d,0);
		boot.Bv.dp=new boot.Bv("Valkyrie",boot.Bw.e,0);
		boot.Bv.ea=new boot.Bv("Gatling Gun",boot.Bw.f,0);
		boot.Bv.eb=new boot.Bv("Missile Barrage",boot.Bw.g,0);
		boot.Bv.ec=new boot.Bv("Hemorrhage",boot.Bw.c,0);
		boot.Bv.ed=new boot.Bv("Decimate",boot.Bw.d,0);
		boot.Bv.ee=new boot.Bv("Crippling Strike",boot.Bw.e,0);
		boot.Bv.ef=new boot.Bv("Apprehend",boot.Bw.f,0);
		boot.Bv.eg=new boot.Bv("Noxian Guillotine",boot.Bw.g,0);
		boot.Bv.eh=new boot.Bv("Moonsilver Blade",boot.Bw.c,0);
		boot.Bv.ei=new boot.Bv("Crescent Strike",boot.Bw.d,0);
		boot.Bv.ej=new boot.Bv("Pale Cascade",boot.Bw.e,0);
		boot.Bv.ek=new boot.Bv("Moonfall",boot.Bw.f,0);
		boot.Bv.el=new boot.Bv("Lunar Rush",boot.Bw.g,0);
		boot.Bv.em=new boot.Bv("Adrenaline Rush",boot.Bw.c,0);
		boot.Bv.en=new boot.Bv("Infected Cleaver",boot.Bw.d,0);
		boot.Bv.eo=new boot.Bv("Burning Agony",boot.Bw.e,0);
		boot.Bv.ep=new boot.Bv("Masochism",boot.Bw.f,0);
		boot.Bv.fa=new boot.Bv("Sadism",boot.Bw.g,0);
		boot.Bv.fb=new boot.Bv("Wicked Blades",boot.Bw.c,0);
		boot.Bv.fc=new boot.Bv("Spinning Axe",boot.Bw.d,0);
		boot.Bv.fd=new boot.Bv("Blood Rush",boot.Bw.e,0);
		boot.Bv.fe=new boot.Bv("Stand Aside",boot.Bw.f,0);
		boot.Bv.ff=new boot.Bv("Whirling Death",boot.Bw.g,0);
		boot.Bv.fg=new boot.Bv("Spider Swarm",boot.Bw.c,0);
		boot.Bv.fh=new boot.Bv("Neurotoxin",boot.Bw.d,0);
		boot.Bv.fi=new boot.Bv("Venomous Bite",boot.Bw.d,0);
		boot.Bv.fj=new boot.Bv("Volatile Spiderling",boot.Bw.e,0);
		boot.Bv.fk=new boot.Bv("Skittering Frenzy",boot.Bw.e,0);
		boot.Bv.fl=new boot.Bv("Cocoon",boot.Bw.f,0);
		boot.Bv.fm=new boot.Bv("Rappel",boot.Bw.f,0);
		boot.Bv.fn=new boot.Bv("Spider Form",boot.Bw.g,0);
		boot.Bv.fo=new boot.Bv("Human Form",boot.Bw.g,0);
		boot.Bv.fp=new boot.Bv("Shadow Walk",boot.Bw.c,0);
		boot.Bv.ga=new boot.Bv("Hate Spike",boot.Bw.d,0);
		boot.Bv.gb=new boot.Bv("Dark Frenzy",boot.Bw.e,0);
		boot.Bv.gc=new boot.Bv("Ravage",boot.Bw.f,0);
		boot.Bv.gd=new boot.Bv("Agony's Embrace",boot.Bw.g,0);
		boot.Bv.ge=new boot.Bv("Rising Spell Force",boot.Bw.c,0);
		boot.Bv.gf=new boot.Bv("Mystic Shot",boot.Bw.d,0);
		boot.Bv.gg=new boot.Bv("Essence Flux",boot.Bw.e,0);
		boot.Bv.gh=new boot.Bv("Arcane Shift",boot.Bw.f,0);
		boot.Bv.gi=new boot.Bv("Trueshot Barrage",boot.Bw.g,0);
		boot.Bv.gj=new boot.Bv("Dread",boot.Bw.c,0);
		boot.Bv.gk=new boot.Bv("Terrify",boot.Bw.d,0);
		boot.Bv.gl=new boot.Bv("Drain",boot.Bw.e,0);
		boot.Bv.gm=new boot.Bv("Dark Wind",boot.Bw.f,0);
		boot.Bv.gn=new boot.Bv("Crowstorm",boot.Bw.g,0);
		boot.Bv.go=new boot.Bv("Duelist",boot.Bw.c,0);
		boot.Bv.gp=new boot.Bv("Lunge",boot.Bw.d,0);
		boot.Bv.ha=new boot.Bv("Riposte",boot.Bw.e,0);
		boot.Bv.hb=new boot.Bv("Burst of Speed",boot.Bw.f,0);
		boot.Bv.hc=new boot.Bv("Blade Waltz",boot.Bw.g,0);
		boot.Bv.hd=new boot.Bv("Nimble Fighter",boot.Bw.c,0);
		boot.Bv.he=new boot.Bv("Urchin Strike",boot.Bw.d,0);
		boot.Bv.hf=new boot.Bv("Seastone Trident",boot.Bw.e,0);
		boot.Bv.hg=new boot.Bv("Playful",boot.Bw.f,0);
		boot.Bv.hh=new boot.Bv("Trickster",boot.Bw.f,0);
		boot.Bv.hi=new boot.Bv("Chum the Waters",boot.Bw.g,0);
		boot.Bv.hj=new boot.Bv("Runic Skin",boot.Bw.c,0);
		boot.Bv.hk=new boot.Bv("Resolute Smite",boot.Bw.d,0);
		boot.Bv.hl=new boot.Bv("Bulwark",boot.Bw.e,0);
		boot.Bv.hm=new boot.Bv("Righteous Gust",boot.Bw.f,0);
		boot.Bv.hn=new boot.Bv("Idol of Durand",boot.Bw.g,0);
		boot.Bv.ho=new boot.Bv("Grog Soaked Blade",boot.Bw.c,0);
		boot.Bv.hp=new boot.Bv("Parrrley",boot.Bw.d,0);
		boot.Bv.ia=new boot.Bv("Remove Scurvy",boot.Bw.e,0);
		boot.Bv.ib=new boot.Bv("Raise Morale",boot.Bw.f,0);
		boot.Bv.ic=new boot.Bv("Cannon Barrage",boot.Bw.g,0);
		boot.Bv.id=new boot.Bv("Perseverance",boot.Bw.c,0);
		boot.Bv.ie=new boot.Bv("Decisive Strike",boot.Bw.d,0);
		boot.Bv.ig=new boot.Bv("Courage",boot.Bw.e,0);
		boot.Bv.ih=new boot.Bv("Judgment",boot.Bw.f,0);
		boot.Bv.ii=new boot.Bv("Demacian Justice",boot.Bw.g,0);
		boot.Bv.ij=new boot.Bv("Happy Hour",boot.Bw.c,0);
		boot.Bv.ik=new boot.Bv("Barrel Roll",boot.Bw.d,0);
		boot.Bv.il=new boot.Bv("Drunken Rage",boot.Bw.e,0);
		boot.Bv.im=new boot.Bv("Body Slam",boot.Bw.f,0);
		boot.Bv.io=new boot.Bv("Explosive Cask",boot.Bw.g,0);
		boot.Bv.ip=new boot.Bv("True Grit",boot.Bw.c,0);
		boot.Bv.ja=new boot.Bv("Buckshot",boot.Bw.d,0);
		boot.Bv.jb=new boot.Bv("Smokescreen",boot.Bw.e,0);
		boot.Bv.jc=new boot.Bv("Quickdraw",boot.Bw.f,0);
		boot.Bv.jd=new boot.Bv("Collateral Damage",boot.Bw.g,0);
		boot.Bv.je=new boot.Bv("Warpath",boot.Bw.c,0);
		boot.Bv.jf=new boot.Bv("Rampage",boot.Bw.d,0);
		boot.Bv.jg=new boot.Bv("Spirit of Dread",boot.Bw.e,0);
		boot.Bv.jh=new boot.Bv("Devastating Charge",boot.Bw.f,0);
		boot.Bv.ji=new boot.Bv("Onslaught of Shadows",boot.Bw.g,0);
		boot.Bv.jj=new boot.Bv("Techmaturgical Repair Bots",boot.Bw.c,0);
		boot.Bv.jk=new boot.Bv("H-28G Evolution Turret",boot.Bw.d,0);
		boot.Bv.jl=new boot.Bv("Hextech Micro-Rockets",boot.Bw.e,0);
		boot.Bv.jm=new boot.Bv("CH-1 Concussion Grenade",boot.Bw.f,0);
		boot.Bv.jn=new boot.Bv("UPGRADE!!!",boot.Bw.g,0);
		boot.Bv.jo=new boot.Bv("Ionian Fervor",boot.Bw.c,0);
		boot.Bv.jp=new boot.Bv("Bladesurge",boot.Bw.d,0);
		boot.Bv.ka=new boot.Bv("Hiten Style",boot.Bw.e,0);
		boot.Bv.kb=new boot.Bv("Equilibrium Strike",boot.Bw.f,0);
		boot.Bv.kc=new boot.Bv("Transcendent Blades",boot.Bw.g,0);
		boot.Bv.kd=new boot.Bv("Tailwind",boot.Bw.c,0);
		boot.Bv.ke=new boot.Bv("Howling Gale",boot.Bw.d,0);
		boot.Bv.kf=new boot.Bv("Zephyr",boot.Bw.e,0);
		boot.Bv.kg=new boot.Bv("Eye Of The Storm",boot.Bw.f,0);
		boot.Bv.kh=new boot.Bv("Monsoon",boot.Bw.g,0);
		boot.Bv.ki=new boot.Bv("Martial Cadence",boot.Bw.c,0);
		boot.Bv.kj=new boot.Bv("Dragon Strike",boot.Bw.d,0);
		boot.Bv.kk=new boot.Bv("Golden Aegis",boot.Bw.e,0);
		boot.Bv.kl=new boot.Bv("Demacian Standard",boot.Bw.f,0);
		boot.Bv.km=new boot.Bv("Cataclysm",boot.Bw.g,0);
		boot.Bv.kn=new boot.Bv("Relentless Assault",boot.Bw.c,0);
		boot.Bv.ko=new boot.Bv("Leap Strike",boot.Bw.d,0);
		boot.Bv.kp=new boot.Bv("Empower",boot.Bw.e,0);
		boot.Bv.la=new boot.Bv("Counter Strike",boot.Bw.f,0);
		boot.Bv.lb=new boot.Bv("Grandmaster's Might",boot.Bw.g,0);
		boot.Bv.lc=new boot.Bv("Hextech Capacitor",boot.Bw.c,0);
		boot.Bv.ld=new boot.Bv("To the Skies!",boot.Bw.d,0);
		boot.Bv.le=new boot.Bv("Shock Blast",boot.Bw.d,0);
		boot.Bv.lf=new boot.Bv("Lightning Field",boot.Bw.e,0);
		boot.Bv.lg=new boot.Bv("Hyper Charge",boot.Bw.e,0);
		boot.Bv.lh=new boot.Bv("Thundering Blow",boot.Bw.f,0);
		boot.Bv.li=new boot.Bv("Acceleration Gate",boot.Bw.f,0);
		boot.Bv.lj=new boot.Bv("Transform: Mercury Cannon",boot.Bw.g,0);
		boot.Bv.lk=new boot.Bv("Transform: Mercury Hammer",boot.Bw.g,0);
		boot.Bv.ll=new boot.Bv("Inner Flame",boot.Bw.c,0);
		boot.Bv.lm=new boot.Bv("Heavenly Wave",boot.Bw.d,0);
		boot.Bv.ln=new boot.Bv("Spirit Bond",boot.Bw.e,0);
		boot.Bv.lo=new boot.Bv("Soul Shield",boot.Bw.f,0);
		boot.Bv.lp=new boot.Bv("Mantra",boot.Bw.g,0);
		boot.Bv.ma=new boot.Bv("Death Defied",boot.Bw.c,0);
		boot.Bv.mb=new boot.Bv("Lay Waste",boot.Bw.d,0);
		boot.Bv.mc=new boot.Bv("Wall of Pain",boot.Bw.e,0);
		boot.Bv.md=new boot.Bv("Defile",boot.Bw.f,0);
		boot.Bv.me=new boot.Bv("Requiem",boot.Bw.g,0);
		boot.Bv.mf=new boot.Bv("Void Stone",boot.Bw.c,0);
		boot.Bv.mg=new boot.Bv("Null Sphere",boot.Bw.d,0);
		boot.Bv.mh=new boot.Bv("Nether Blade",boot.Bw.e,0);
		boot.Bv.mi=new boot.Bv("Force Pulse",boot.Bw.f,0);
		boot.Bv.mj=new boot.Bv("Riftwalk",boot.Bw.g,0);
		boot.Bv.mk=new boot.Bv("Voracity",boot.Bw.c,0);
		boot.Bv.ml=new boot.Bv("Bouncing Blade",boot.Bw.d,0);
		boot.Bv.mm=new boot.Bv("Sinister Steel",boot.Bw.e,0);
		boot.Bv.mn=new boot.Bv("Shunpo",boot.Bw.f,0);
		boot.Bv.mo=new boot.Bv("Death Lotus",boot.Bw.g,0);
		boot.Bv.mp=new boot.Bv("Holy Fervor",boot.Bw.c,0);
		boot.Bv.na=new boot.Bv("Reckoning",boot.Bw.d,0);
		boot.Bv.nb=new boot.Bv("Divine Blessing",boot.Bw.e,0);
		boot.Bv.nc=new boot.Bv("Righteous Fury",boot.Bw.f,0);
		boot.Bv.nd=new boot.Bv("Intervention",boot.Bw.g,0);
		boot.Bv.ne=new boot.Bv("Mark of the Storm",boot.Bw.c,0);
		boot.Bv.nf=new boot.Bv("Thundering Shuriken",boot.Bw.d,0);
		boot.Bv.ng=new boot.Bv("Electrical Surge",boot.Bw.e,0);
		boot.Bv.nh=new boot.Bv("Lightning Rush",boot.Bw.f,0);
		boot.Bv.ni=new boot.Bv("Slicing Maelstrom",boot.Bw.g,0);
		boot.Bv.nj=new boot.Bv("Unseen Threat",boot.Bw.c,0);
		boot.Bv.nk=new boot.Bv("Taste Their Fear",boot.Bw.d,0);
		boot.Bv.nl=new boot.Bv("Void Spike",boot.Bw.e,0);
		boot.Bv.nm=new boot.Bv("Leap",boot.Bw.f,0);
		boot.Bv.nn=new boot.Bv("Void Assault",boot.Bw.g,0);
		boot.Bv.no=new boot.Bv("Icathian Surprise",boot.Bw.c,0);
		boot.Bv.np=new boot.Bv("Caustic Spittle",boot.Bw.d,0);
		boot.Bv.oa=new boot.Bv("Bio-Arcane Barrage",boot.Bw.e,0);
		boot.Bv.ob=new boot.Bv("Void Ooze",boot.Bw.f,0);
		boot.Bv.oc=new boot.Bv("Living Artillery",boot.Bw.g,0);
		boot.Bv.od=new boot.Bv("Mirror Image",boot.Bw.c,0);
		boot.Bv.oe=new boot.Bv("Sigil of Silence",boot.Bw.d,0);
		boot.Bv.of=new boot.Bv("Distortion",boot.Bw.e,0);
		boot.Bv.og=new boot.Bv("Ethereal Chains",boot.Bw.f,0);
		boot.Bv.oh=new boot.Bv("Mimic",boot.Bw.g,0);
		boot.Bv.oi=new boot.Bv("Flurry",boot.Bw.c,0);
		boot.Bv.oj=new boot.Bv("Sonic Wave",boot.Bw.d,0);
		boot.Bv.ok=new boot.Bv("Resonating Strike",boot.Bw.d,0);
		boot.Bv.ol=new boot.Bv("Safeguard",boot.Bw.e,0);
		boot.Bv.om=new boot.Bv("Iron Will",boot.Bw.e,0);
		boot.Bv.on=new boot.Bv("Tempest",boot.Bw.f,0);
		boot.Bv.oo=new boot.Bv("Cripple",boot.Bw.f,0);
		boot.Bv.op=new boot.Bv("Dragon's Rage",boot.Bw.g,0);
		boot.Bv.pa=new boot.Bv("Sunlight",boot.Bw.c,0);
		boot.Bv.pb=new boot.Bv("Shield of Daybreak",boot.Bw.d,0);
		boot.Bv.pc=new boot.Bv("Eclipse",boot.Bw.e,0);
		boot.Bv.pd=new boot.Bv("Zenith Blade",boot.Bw.f,0);
		boot.Bv.pe=new boot.Bv("Solar Flare",boot.Bw.g,0);
		boot.Bv.pf=new boot.Bv("Pix, Faerie Companion",boot.Bw.c,0);
		boot.Bv.pg=new boot.Bv("Glitterlance",boot.Bw.d,0);
		boot.Bv.ph=new boot.Bv("Whimsy",boot.Bw.e,0);
		boot.Bv.pi=new boot.Bv("Help, Pix!",boot.Bw.f,0);
		boot.Bv.pj=new boot.Bv("Wild Growth",boot.Bw.g,0);
		boot.Bv.pk=new boot.Bv("Illumination",boot.Bw.c,0);
		boot.Bv.pl=new boot.Bv("Light Binding",boot.Bw.d,0);
		boot.Bv.pm=new boot.Bv("Prismatic Barrier",boot.Bw.e,0);
		boot.Bv.pn=new boot.Bv("Lucent Singularity",boot.Bw.f,0);
		boot.Bv.po=new boot.Bv("Final Spark",boot.Bw.g,0);
		boot.Bv.pp=new boot.Bv("Granite Shield",boot.Bw.c,0);
		boot.Bv.baa=new boot.Bv("Seismic Shard",boot.Bw.d,0);
		boot.Bv.bab=new boot.Bv("Brutal Strikes",boot.Bw.e,0);
		boot.Bv.bac=new boot.Bv("Ground Slam",boot.Bw.f,0);
		boot.Bv.bad=new boot.Bv("Unstoppable Force",boot.Bw.g,0);
		boot.Bv.bae=new boot.Bv("Summon Voidling",boot.Bw.c,0);
		boot.Bv.baf=new boot.Bv("Call of the Void",boot.Bw.d,0);
		boot.Bv.bag=new boot.Bv("Null Zone",boot.Bw.e,0);
		boot.Bv.bah=new boot.Bv("Malefic Visions",boot.Bw.f,0);
		boot.Bv.bai=new boot.Bv("Nether Grasp",boot.Bw.g,0);
		boot.Bv.baj=new boot.Bv("Sap Magic",boot.Bw.c,0);
		boot.Bv.bak=new boot.Bv("Arcane Smash",boot.Bw.d,0);
		boot.Bv.bal=new boot.Bv("Twisted Advance",boot.Bw.e,0);
		boot.Bv.bam=new boot.Bv("Sapling Toss",boot.Bw.f,0);
		boot.Bv.ban=new boot.Bv("Vengeful Maelstrom",boot.Bw.g,0);
		boot.Bv.bao=new boot.Bv("Double Strike",boot.Bw.c,0);
		boot.Bv.bap=new boot.Bv("Alpha Strike",boot.Bw.d,0);
		boot.Bv.bba=new boot.Bv("Meditate",boot.Bw.e,0);
		boot.Bv.bbb=new boot.Bv("Wuju Style",boot.Bw.f,0);
		boot.Bv.bbc=new boot.Bv("Highlander",boot.Bw.g,0);
		boot.Bv.bbd=new boot.Bv("Strut",boot.Bw.c,0);
		boot.Bv.bbe=new boot.Bv("Double Up",boot.Bw.d,0);
		boot.Bv.bbf=new boot.Bv("Impure Shots",boot.Bw.e,0);
		boot.Bv.bbg=new boot.Bv("Make It Rain",boot.Bw.f,0);
		boot.Bv.bbh=new boot.Bv("Bullet Time",boot.Bw.g,0);
		boot.Bv.bbi=new boot.Bv("Iron Man",boot.Bw.c,0);
		boot.Bv.bbj=new boot.Bv("Mace of Spades",boot.Bw.d,0);
		boot.Bv.bbk=new boot.Bv("Creeping Death",boot.Bw.e,0);
		boot.Bv.bbl=new boot.Bv("Siphon of Destruction",boot.Bw.f,0);
		boot.Bv.bbm=new boot.Bv("Children of the Grave",boot.Bw.g,0);
		boot.Bv.bbn=new boot.Bv("Soul Siphon",boot.Bw.c,0);
		boot.Bv.bbo=new boot.Bv("Dark Binding",boot.Bw.d,0);
		boot.Bv.bbp=new boot.Bv("Tormented Soil",boot.Bw.e,0);
		boot.Bv.bca=new boot.Bv("Black Shield",boot.Bw.f,0);
		boot.Bv.bcb=new boot.Bv("Soul Shackles",boot.Bw.g,0);
		boot.Bv.bcc=new boot.Bv("Surging Tides",boot.Bw.c,0);
		boot.Bv.bcd=new boot.Bv("Aqua Prison",boot.Bw.d,0);
		boot.Bv.bce=new boot.Bv("Ebb and Flow",boot.Bw.e,0);
		boot.Bv.bcf=new boot.Bv("Tidecaller's Blessing",boot.Bw.f,0);
		boot.Bv.bcg=new boot.Bv("Tidal Wave",boot.Bw.g,0);
		boot.Bv.bch=new boot.Bv("Soul Eater",boot.Bw.c,0);
		boot.Bv.bci=new boot.Bv("Siphoning Strike",boot.Bw.d,0);
		boot.Bv.bcj=new boot.Bv("Wither",boot.Bw.e,0);
		boot.Bv.bck=new boot.Bv("Spirit Fire",boot.Bw.f,0);
		boot.Bv.bcl=new boot.Bv("Fury of the Sands",boot.Bw.g,0);
		boot.Bv.bcm=new boot.Bv("Staggering Blow",boot.Bw.c,0);
		boot.Bv.bcn=new boot.Bv("Dredge Line",boot.Bw.d,0);
		boot.Bv.bco=new boot.Bv("Titan's Wrath",boot.Bw.e,0);
		boot.Bv.bcp=new boot.Bv("Riptide",boot.Bw.f,0);
		boot.Bv.bda=new boot.Bv("Depth Charge",boot.Bw.g,0);
		boot.Bv.bdb=new boot.Bv("Prowl",boot.Bw.c,0);
		boot.Bv.bdc=new boot.Bv("Javelin Toss",boot.Bw.d,0);
		boot.Bv.bdd=new boot.Bv("Takedown",boot.Bw.d,0);
		boot.Bv.bde=new boot.Bv("Bushwhack",boot.Bw.e,0);
		boot.Bv.bdf=new boot.Bv("Pounce",boot.Bw.e,0);
		boot.Bv.bdg=new boot.Bv("Primal Surge",boot.Bw.f,0);
		boot.Bv.bdh=new boot.Bv("Swipe",boot.Bw.f,0);
		boot.Bv.bdi=new boot.Bv("Aspect Of The Cougar",boot.Bw.g,0);
		boot.Bv.bdj=new boot.Bv("Aspect Of The Cougar",boot.Bw.g,0);
		boot.Bv.bdk=new boot.Bv("Umbra Blades",boot.Bw.c,0);
		boot.Bv.bdl=new boot.Bv("Duskbringer",boot.Bw.d,0);
		boot.Bv.bdm=new boot.Bv("Shroud of Darkness",boot.Bw.e,0);
		boot.Bv.bdn=new boot.Bv("Unspeakable Horror",boot.Bw.f,0);
		boot.Bv.bdo=new boot.Bv("Paranoia",boot.Bw.g,0);
		boot.Bv.bdp=new boot.Bv("Visionary",boot.Bw.c,0);
		boot.Bv.bea=new boot.Bv("Consume",boot.Bw.d,0);
		boot.Bv.beb=new boot.Bv("Blood Boil",boot.Bw.e,0);
		boot.Bv.bec=new boot.Bv("Ice Blast",boot.Bw.f,0);
		boot.Bv.bed=new boot.Bv("Absolute Zero",boot.Bw.g,0);
		boot.Bv.bee=new boot.Bv("Berserker Rage",boot.Bw.c,0);
		boot.Bv.bef=new boot.Bv("Undertow",boot.Bw.d,0);
		boot.Bv.beg=new boot.Bv("Vicious Strikes",boot.Bw.e,0);
		boot.Bv.beh=new boot.Bv("Reckless Swing",boot.Bw.f,0);
		boot.Bv.bei=new boot.Bv("Ragnarok",boot.Bw.g,0);
		boot.Bv.bej=new boot.Bv("Clockwork Windup",boot.Bw.c,0);
		boot.Bv.bek=new boot.Bv("Command: Attack",boot.Bw.d,0);
		boot.Bv.bel=new boot.Bv("Command: Dissonance",boot.Bw.e,0);
		boot.Bv.bem=new boot.Bv("Command: Protect",boot.Bw.f,0);
		boot.Bv.ben=new boot.Bv("Command: Shockwave",boot.Bw.g,0);
		boot.Bv.beo=new boot.Bv("Aegis Protection",boot.Bw.c,0);
		boot.Bv.bep=new boot.Bv("Spear Shot",boot.Bw.d,0);
		boot.Bv.bfa=new boot.Bv("Aegis of Zeonia",boot.Bw.e,0);
		boot.Bv.bfb=new boot.Bv("Heartseeker Strike",boot.Bw.f,0);
		boot.Bv.bfc=new boot.Bv("Grand Skyfall",boot.Bw.g,0);
		boot.Bv.bfd=new boot.Bv("Valiant Fighter",boot.Bw.c,0);
		boot.Bv.bfe=new boot.Bv("Devastating Blow",boot.Bw.d,0);
		boot.Bv.bff=new boot.Bv("Paragon of Demacia",boot.Bw.e,0);
		boot.Bv.bfg=new boot.Bv("Heroic Charge",boot.Bw.f,0);
		boot.Bv.bfh=new boot.Bv("Diplomatic Immunity",boot.Bw.g,0);
		boot.Bv.bfi=new boot.Bv("Spiked Shell",boot.Bw.c,0);
		boot.Bv.bfj=new boot.Bv("Powerball",boot.Bw.d,0);
		boot.Bv.bfk=new boot.Bv("Defensive Ball Curl",boot.Bw.e,0);
		boot.Bv.bfl=new boot.Bv("Puncturing Taunt",boot.Bw.f,0);
		boot.Bv.bfm=new boot.Bv("Tremors",boot.Bw.g,0);
		boot.Bv.bfn=new boot.Bv("Reign of Anger",boot.Bw.c,0);
		boot.Bv.bfo=new boot.Bv("Cull the Meek",boot.Bw.d,0);
		boot.Bv.bfp=new boot.Bv("Ruthless Predator",boot.Bw.e,0);
		boot.Bv.bga=new boot.Bv("Slice and Dice",boot.Bw.f,0);
		boot.Bv.bgb=new boot.Bv("Dominus",boot.Bw.g,0);
		boot.Bv.bgc=new boot.Bv("Unseen Predator",boot.Bw.c,0);
		boot.Bv.bgd=new boot.Bv("Savagery",boot.Bw.d,0);
		boot.Bv.bge=new boot.Bv("Battle Roar",boot.Bw.e,0);
		boot.Bv.bgf=new boot.Bv("Bola Strike",boot.Bw.f,0);
		boot.Bv.bgg=new boot.Bv("Thrill of the Hunt",boot.Bw.g,0);
		boot.Bv.bgh=new boot.Bv("Runic Blade",boot.Bw.c,0);
		boot.Bv.bgi=new boot.Bv("Broken Wings",boot.Bw.d,0);
		boot.Bv.bgj=new boot.Bv("Ki Burst",boot.Bw.e,0);
		boot.Bv.bgk=new boot.Bv("Valor",boot.Bw.f,0);
		boot.Bv.bgl=new boot.Bv("Blade of the Exile",boot.Bw.g,0);
		boot.Bv.bgm=new boot.Bv("Junkyard Titan",boot.Bw.c,0);
		boot.Bv.bgn=new boot.Bv("Flamespitter",boot.Bw.d,0);
		boot.Bv.bgo=new boot.Bv("Scrap Shield",boot.Bw.e,0);
		boot.Bv.bgp=new boot.Bv("Electro-Harpoon",boot.Bw.f,0);
		boot.Bv.bha=new boot.Bv("The Equalizer",boot.Bw.g,0);
		boot.Bv.bhb=new boot.Bv("Arcane Mastery",boot.Bw.c,0);
		boot.Bv.bhc=new boot.Bv("Overload",boot.Bw.d,0);
		boot.Bv.bhd=new boot.Bv("Rune Prison",boot.Bw.e,0);
		boot.Bv.bhe=new boot.Bv("Spell Flux",boot.Bw.f,0);
		boot.Bv.bhf=new boot.Bv("Desperate Power",boot.Bw.g,0);
		boot.Bv.bhg=new boot.Bv("Frost",boot.Bw.c,0);
		boot.Bv.bhh=new boot.Bv("Arctic Assault",boot.Bw.d,0);
		boot.Bv.bhi=new boot.Bv("Northern Winds",boot.Bw.e,0);
		boot.Bv.bhj=new boot.Bv("Permafrost",boot.Bw.f,0);
		boot.Bv.bhk=new boot.Bv("Glacial Prison",boot.Bw.g,0);
		boot.Bv.bhl=new boot.Bv("Backstab",boot.Bw.c,0);
		boot.Bv.bhm=new boot.Bv("Deceive",boot.Bw.d,0);
		boot.Bv.bhn=new boot.Bv("Jack In The Box",boot.Bw.e,0);
		boot.Bv.bho=new boot.Bv("Two-Shiv Poison",boot.Bw.f,0);
		boot.Bv.bhp=new boot.Bv("Hallucinate",boot.Bw.g,0);
		boot.Bv.bia=new boot.Bv("Ki Strike",boot.Bw.c,0);
		boot.Bv.bib=new boot.Bv("Vorpal Blade",boot.Bw.d,0);
		boot.Bv.bic=new boot.Bv("Feint",boot.Bw.e,0);
		boot.Bv.bid=new boot.Bv("Shadow Dash",boot.Bw.f,0);
		boot.Bv.bie=new boot.Bv("Stand United",boot.Bw.g,0);
		boot.Bv.bif=new boot.Bv("Fury of the Dragonborn",boot.Bw.c,0);
		boot.Bv.big=new boot.Bv("Twin Bite",boot.Bw.d,0);
		boot.Bv.bih=new boot.Bv("Burnout",boot.Bw.e,0);
		boot.Bv.bii=new boot.Bv("Flame Breath",boot.Bw.f,0);
		boot.Bv.bij=new boot.Bv("Dragon's Descent",boot.Bw.g,0);
		boot.Bv.bik=new boot.Bv("Empowered Bulwark",boot.Bw.c,0);
		boot.Bv.bil=new boot.Bv("Poison Trail",boot.Bw.d,0);
		boot.Bv.bim=new boot.Bv("Mega Adhesive",boot.Bw.e,0);
		boot.Bv.bin=new boot.Bv("Fling",boot.Bw.f,0);
		boot.Bv.bio=new boot.Bv("Insanity Potion",boot.Bw.g,0);
		boot.Bv.bip=new boot.Bv("Feel No Pain",boot.Bw.c,0);
		boot.Bv.bja=new boot.Bv("Cryptic Gaze",boot.Bw.d,0);
		boot.Bv.bjb=new boot.Bv("Death's Caress",boot.Bw.e,0);
		boot.Bv.bjc=new boot.Bv("Enrage",boot.Bw.f,0);
		boot.Bv.bjd=new boot.Bv("Cannibalism",boot.Bw.g,0);
		boot.Bv.bje=new boot.Bv("Fleet of Foot",boot.Bw.c,0);
		boot.Bv.bjf=new boot.Bv("Boomerang Blade",boot.Bw.d,0);
		boot.Bv.bjg=new boot.Bv("Ricochet",boot.Bw.e,0);
		boot.Bv.bjh=new boot.Bv("Spell Shield",boot.Bw.f,0);
		boot.Bv.bji=new boot.Bv("On The Hunt",boot.Bw.g,0);
		boot.Bv.bjj=new boot.Bv("Energize",boot.Bw.c,0);
		boot.Bv.bjk=new boot.Bv("Crystal Slash",boot.Bw.d,0);
		boot.Bv.bjl=new boot.Bv("Crystalline Exoskeleton",boot.Bw.e,0);
		boot.Bv.bjm=new boot.Bv("Fracture",boot.Bw.f,0);
		boot.Bv.bjn=new boot.Bv("Impale",boot.Bw.g,0);
		boot.Bv.bjo=new boot.Bv("Power Chord",boot.Bw.c,0);
		boot.Bv.bjp=new boot.Bv("Hymn of Valor",boot.Bw.d,0);
		boot.Bv.bka=new boot.Bv("Aria of Perseverance",boot.Bw.e,0);
		boot.Bv.bkb=new boot.Bv("Song of Celerity",boot.Bw.f,0);
		boot.Bv.bkc=new boot.Bv("Crescendo",boot.Bw.g,0);
		boot.Bv.bkd=new boot.Bv("Consecration",boot.Bw.c,0);
		boot.Bv.bke=new boot.Bv("Starcall",boot.Bw.d,0);
		boot.Bv.bkf=new boot.Bv("Astral Blessing",boot.Bw.e,0);
		boot.Bv.bkg=new boot.Bv("Infuse",boot.Bw.f,0);
		boot.Bv.bkh=new boot.Bv("Wish",boot.Bw.g,0);
		boot.Bv.bki=new boot.Bv("Carrion Renewal",boot.Bw.c,0);
		boot.Bv.bkj=new boot.Bv("Decrepify",boot.Bw.d,0);
		boot.Bv.bkk=new boot.Bv("Nevermove",boot.Bw.e,0);
		boot.Bv.bkl=new boot.Bv("Torment",boot.Bw.f,0);
		boot.Bv.bkm=new boot.Bv("Ravenous Flock",boot.Bw.g,0);
		boot.Bv.bkn=new boot.Bv("Transcendent",boot.Bw.c,0);
		boot.Bv.bko=new boot.Bv("Dark Sphere",boot.Bw.d,0);
		boot.Bv.bkp=new boot.Bv("Force of Will",boot.Bw.e,0);
		boot.Bv.bla=new boot.Bv("Scatter the Weak",boot.Bw.f,0);
		boot.Bv.blb=new boot.Bv("Unleashed Power",boot.Bw.g,0);
		boot.Bv.blc=new boot.Bv("Mercy",boot.Bw.c,0);
		boot.Bv.bld=new boot.Bv("Noxian Diplomacy",boot.Bw.d,0);
		boot.Bv.ble=new boot.Bv("Rake",boot.Bw.e,0);
		boot.Bv.blf=new boot.Bv("Cutthroat",boot.Bw.f,0);
		boot.Bv.blg=new boot.Bv("Shadow Assault",boot.Bw.g,0);
		boot.Bv.blh=new boot.Bv("Gemcraft",boot.Bw.c,0);
		boot.Bv.bli=new boot.Bv("Imbue",boot.Bw.d,0);
		boot.Bv.blj=new boot.Bv("Shatter",boot.Bw.e,0);
		boot.Bv.blk=new boot.Bv("Dazzle",boot.Bw.f,0);
		boot.Bv.bll=new boot.Bv("Radiance",boot.Bw.g,0);
		boot.Bv.blm=new boot.Bv("Camouflage",boot.Bw.c,0);
		boot.Bv.bln=new boot.Bv("Blinding Dart",boot.Bw.d,0);
		boot.Bv.blo=new boot.Bv("Move Quick",boot.Bw.e,0);
		boot.Bv.blp=new boot.Bv("Toxic Shot",boot.Bw.f,0);
		boot.Bv.bma=new boot.Bv("Noxious Trap",boot.Bw.g,0);
		boot.Bv.bmb=new boot.Bv("Damnation",boot.Bw.c,0);
		boot.Bv.bmc=new boot.Bv("Death Sentence",boot.Bw.d,0);
		boot.Bv.bmd=new boot.Bv("Dark Passage",boot.Bw.e,0);
		boot.Bv.bme=new boot.Bv("Flay",boot.Bw.f,0);
		boot.Bv.bmf=new boot.Bv("The Box",boot.Bw.g,0);
		boot.Bv.bmg=new boot.Bv("Draw a Bead",boot.Bw.c,0);
		boot.Bv.bmh=new boot.Bv("Rapid Fire",boot.Bw.d,0);
		boot.Bv.bmi=new boot.Bv("Rocket Jump",boot.Bw.e,0);
		boot.Bv.bmj=new boot.Bv("Explosive Shot",boot.Bw.f,0);
		boot.Bv.bmk=new boot.Bv("Buster Shot",boot.Bw.g,0);
		boot.Bv.bml=new boot.Bv("Decompose",boot.Bw.c,0);
		boot.Bv.bmm=new boot.Bv("Rabid Bite",boot.Bw.d,0);
		boot.Bv.bmn=new boot.Bv("Contaminate",boot.Bw.e,0);
		boot.Bv.bmo=new boot.Bv("Pillar of Filth",boot.Bw.f,0);
		boot.Bv.bmp=new boot.Bv("Agony",boot.Bw.g,0);
		boot.Bv.bna=new boot.Bv("Battle Fury",boot.Bw.c,0);
		boot.Bv.bnb=new boot.Bv("Bloodlust",boot.Bw.d,0);
		boot.Bv.bnc=new boot.Bv("Mocking Shout",boot.Bw.e,0);
		boot.Bv.bnd=new boot.Bv("Spinning Slash",boot.Bw.f,0);
		boot.Bv.bne=new boot.Bv("Undying Rage",boot.Bw.g,0);
		boot.Bv.bnf=new boot.Bv("Loaded Dice",boot.Bw.c,0);
		boot.Bv.bng=new boot.Bv("Wild Cards",boot.Bw.d,0);
		boot.Bv.bnh=new boot.Bv("Pick A Card",boot.Bw.e,0);
		boot.Bv.bni=new boot.Bv("Stacked Deck",boot.Bw.f,0);
		boot.Bv.bnj=new boot.Bv("Destiny",boot.Bw.g,0);
		boot.Bv.bnk=new boot.Bv("Deadly Venom",boot.Bw.c,0);
		boot.Bv.bnl=new boot.Bv("Ambush",boot.Bw.d,0);
		boot.Bv.bnm=new boot.Bv("Venom Cask",boot.Bw.e,0);
		boot.Bv.bnn=new boot.Bv("Expunge",boot.Bw.f,0);
		boot.Bv.bno=new boot.Bv("Spray and Pray",boot.Bw.g,0);
		boot.Bv.bnp=new boot.Bv("Monkey's Agility",boot.Bw.c,0);
		boot.Bv.boa=new boot.Bv("Tiger Stance",boot.Bw.d,0);
		boot.Bv.bob=new boot.Bv("Turtle Stance",boot.Bw.e,0);
		boot.Bv.boc=new boot.Bv("Bear Stance",boot.Bw.f,0);
		boot.Bv.bod=new boot.Bv("Phoenix Stance",boot.Bw.g,0);
		boot.Bv.boe=new boot.Bv("Zaun-Touched Bolt Augmenter",boot.Bw.c,0);
		boot.Bv.bof=new boot.Bv("Acid Hunter",boot.Bw.d,0);
		boot.Bv.bog=new boot.Bv("Terror Capacitor",boot.Bw.e,0);
		boot.Bv.boh=new boot.Bv("Noxian Corrosive Charge",boot.Bw.f,0);
		boot.Bv.boi=new boot.Bv("Hyper-Kinetic Position Reverser",boot.Bw.g,0);
		boot.Bv.boj=new boot.Bv("Living Vengeance",boot.Bw.c,0);
		boot.Bv.bok=new boot.Bv("Piercing Arrow",boot.Bw.d,0);
		boot.Bv.bol=new boot.Bv("Blighted Quiver",boot.Bw.e,0);
		boot.Bv.bom=new boot.Bv("Hail of Arrows",boot.Bw.f,0);
		boot.Bv.bon=new boot.Bv("Chain of Corruption",boot.Bw.g,0);
		boot.Bv.boo=new boot.Bv("Night Hunter",boot.Bw.c,0);
		boot.Bv.bop=new boot.Bv("Tumble",boot.Bw.d,0);
		boot.Bv.bpa=new boot.Bv("Silver Bolts",boot.Bw.e,0);
		boot.Bv.bpb=new boot.Bv("Condemn",boot.Bw.f,0);
		boot.Bv.bpc=new boot.Bv("Final Hour",boot.Bw.g,0);
		boot.Bv.bpd=new boot.Bv("Equilibrium",boot.Bw.c,0);
		boot.Bv.bpe=new boot.Bv("Baleful Strike",boot.Bw.d,0);
		boot.Bv.bpf=new boot.Bv("Dark Matter",boot.Bw.e,0);
		boot.Bv.bpg=new boot.Bv("Event Horizon",boot.Bw.f,0);
		boot.Bv.bph=new boot.Bv("Primordial Burst",boot.Bw.g,0);
		boot.Bv.bpi=new boot.Bv("Blast Shield",boot.Bw.c,0);
		boot.Bv.bpj=new boot.Bv("Vault Breaker",boot.Bw.d,0);
		boot.Bv.bpk=new boot.Bv("Denting Blows",boot.Bw.e,0);
		boot.Bv.bpl=new boot.Bv("Excessive Force",boot.Bw.f,0);
		boot.Bv.bpm=new boot.Bv("Assault and Battery",boot.Bw.g,0);
		boot.Bv.bpn=new boot.Bv("Evolving Technology",boot.Bw.c,0);
		boot.Bv.bpo=new boot.Bv("Power Transfer",boot.Bw.d,0);
		boot.Bv.bpp=new boot.Bv("Gravity Field",boot.Bw.e,0);
		boot.Bv.caa=new boot.Bv("Death Ray",boot.Bw.f,0);
		boot.Bv.cab=new boot.Bv("Chaos Storm",boot.Bw.g,0);
		boot.Bv.cac=new boot.Bv("Crimson Pact",boot.Bw.c,0);
		boot.Bv.cad=new boot.Bv("Transfusion",boot.Bw.d,0);
		boot.Bv.cae=new boot.Bv("Sanguine Pool",boot.Bw.e,0);
		boot.Bv.caf=new boot.Bv("Tides of Blood",boot.Bw.f,0);
		boot.Bv.cag=new boot.Bv("Hemoplague",boot.Bw.g,0);
		boot.Bv.cah=new boot.Bv("Chosen of the Storm",boot.Bw.c,0);
		boot.Bv.cai=new boot.Bv("Rolling Thunder",boot.Bw.d,0);
		boot.Bv.caj=new boot.Bv("Frenzy",boot.Bw.e,0);
		boot.Bv.cak=new boot.Bv("Majestic Roar",boot.Bw.f,0);
		boot.Bv.cal=new boot.Bv("Thunder Claws",boot.Bw.g,0);
		boot.Bv.cam=new boot.Bv("Eternal Thirst",boot.Bw.c,0);
		boot.Bv.can=new boot.Bv("Hungering Strike",boot.Bw.d,0);
		boot.Bv.cao=new boot.Bv("Hunters Call",boot.Bw.e,0);
		boot.Bv.cap=new boot.Bv("Blood Scent",boot.Bw.f,0);
		boot.Bv.cba=new boot.Bv("Infinite Duress",boot.Bw.g,0);
		boot.Bv.cbb=new boot.Bv("Stone Skin",boot.Bw.c,0);
		boot.Bv.cbc=new boot.Bv("Crushing Blow",boot.Bw.d,0);
		boot.Bv.cbd=new boot.Bv("Decoy",boot.Bw.e,0);
		boot.Bv.cbe=new boot.Bv("Nimbus Strike",boot.Bw.f,0);
		boot.Bv.cbf=new boot.Bv("Cyclone",boot.Bw.g,0);
		boot.Bv.cbg=new boot.Bv("Ascended Form",boot.Bw.c,0);
		boot.Bv.cbh=new boot.Bv("Arcanopulse",boot.Bw.d,0);
		boot.Bv.cbi=new boot.Bv("Locus of Power",boot.Bw.e,0);
		boot.Bv.cbj=new boot.Bv("Mage Chains",boot.Bw.f,0);
		boot.Bv.cbk=new boot.Bv("Arcane Barrage",boot.Bw.g,0);
		boot.Bv.cbl=new boot.Bv("Challenge",boot.Bw.c,0);
		boot.Bv.cbm=new boot.Bv("Three Talon Strike",boot.Bw.d,0);
		boot.Bv.cbn=new boot.Bv("Battle Cry",boot.Bw.e,0);
		boot.Bv.cbo=new boot.Bv("Audacious Charge",boot.Bw.f,0);
		boot.Bv.cbp=new boot.Bv("Crescent Sweep",boot.Bw.g,0);
		boot.Bv.cca=new boot.Bv("Unholy Covenant",boot.Bw.c,0);
		boot.Bv.ccb=new boot.Bv("Omen of War",boot.Bw.d,0);
		boot.Bv.ccc=new boot.Bv("Omen of Pestilence",boot.Bw.e,0);
		boot.Bv.ccd=new boot.Bv("Omen of Famine",boot.Bw.f,0);
		boot.Bv.cce=new boot.Bv("Omen of Death",boot.Bw.g,0);
		boot.Bv.ccf=new boot.Bv("Contempt for the Weak",boot.Bw.c,0);
		boot.Bv.ccg=new boot.Bv("Razor Shuriken",boot.Bw.d,0);
		boot.Bv.cch=new boot.Bv("Living Shadow",boot.Bw.e,0);
		boot.Bv.cci=new boot.Bv("Shadow Slash",boot.Bw.f,0);
		boot.Bv.ccj=new boot.Bv("Death Mark",boot.Bw.g,0);
		boot.Bv.cck=new boot.Bv("Short Fuse",boot.Bw.c,0);
		boot.Bv.ccl=new boot.Bv("Bouncing Bomb",boot.Bw.d,0);
		boot.Bv.ccm=new boot.Bv("Satchel Charge",boot.Bw.e,0);
		boot.Bv.ccn=new boot.Bv("Hexplosive Minefield",boot.Bw.f,0);
		boot.Bv.cco=new boot.Bv("Mega Inferno Bomb",boot.Bw.g,0);
		boot.Bv.ccp=new boot.Bv("Heightened Learning",boot.Bw.c,0);
		boot.Bv.cda=new boot.Bv("Time Bomb",boot.Bw.d,0);
		boot.Bv.cdb=new boot.Bv("Rewind",boot.Bw.e,0);
		boot.Bv.cdc=new boot.Bv("Time Warp",boot.Bw.f,0);
		boot.Bv.cdd=new boot.Bv("Chrono Shift",boot.Bw.g,0);
		boot.Bv.cde=new boot.Bv("Rise of the Thorns",boot.Bw.c,0);
		boot.Bv.cdf=new boot.Bv("Deadly Bloom",boot.Bw.d,0);
		boot.Bv.cdg=new boot.Bv("Rampant Growth",boot.Bw.e,0);
		boot.Bv.cdh=new boot.Bv("Grasping Roots",boot.Bw.f,0);
		boot.Bv.cdi=new boot.Bv("Stranglethorns",boot.Bw.g,0);
		boot.Bv.cdj=new boot.Bv("Harrier",boot.Bw.c,0);
		boot.Bv.cdk=new boot.Bv("Blinding Assault",boot.Bw.d,0);
		boot.Bv.cdl=new boot.Bv("Heightened Senses",boot.Bw.e,0);
		boot.Bv.cdm=new boot.Bv("Vault",boot.Bw.f,0);
		boot.Bv.cdn=new boot.Bv("Tag Team",boot.Bw.g,0);
		boot.Bv.a.Dy().Dz("スキルが敵ユニットに当たる度に"+boot.Bv.a+"のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルに{1}が追加される。").EA(1,boot.BK.eg,35.0).EB(boot.BK.kd,9.0,0).EC(1);
		boot.Bv.b.Dy().ED("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。").EG(1,boot.BK.f,40.0,25.0,boot.Bv.EE(0.33)).EG(2,boot.BK.g,40.0,25.0,boot.Bv.EE(0.33)).EH(7.0,0).EI(70.0,5.0).EJ(880.0);
		boot.Bv.c.Dy().ED("Ahriの周囲を回る3本の鬼火を放つ。鬼火は5秒間持続し、近くの敵ユニットに自動的に突撃して{1}を与える。鬼火が同一対象に突撃した場合、2発目以降は本来の50%分の魔法DMを与える(同一対象に3発hitで合計200%の魔法DM)。Ahriの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。").EG(1,boot.BK.f,40.0,25.0,boot.Bv.EE(0.4)).EH(9.0,-1.0).EI(60.0,0).EJ(800.0);
		boot.Bv.d.Dy().ED("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。また"+boot.BK.hi+"した対象には{3}を与える。").EG(1,boot.BK.f,60.0,30.0,boot.Bv.EE(0.35)).EK(2,boot.BK.hi,1,0.25).EA(3,boot.BK.ie,50.0).EH(12.0,0).EI(50.0,15.0).EJ(975.0);
		boot.Bv.e.Dy().ED("指定方向にダッシュした後、{2}の敵ユニット(敵Championを優先)3体に{1}を与える。このスキルは10秒の間、3回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2～3発目はマナコスト無しで使用可能。").EG(1,boot.BK.f,85.0,40.0,boot.Bv.EE(0.35)).EA(2,boot.BK.jn,500.0).EH(110.0,-15.0).EI(100.0,0).EJ(450.0);
		boot.Bv.f.Dy().Dz("{1}を得る。また通常攻撃に{2}が付与される。").EG(1,boot.BK.eg,6.0,0,boot.Bv.EL(0.167)).EG(2,boot.BK.f,0,0,boot.Bv.EM(boot.BK.dc,0.06,0,boot.Bv.EE(0.00167)));
		boot.Bv.g.Dy().ED("対象の敵ユニットにカマを投げつけ{1}と6秒間マークを与える。マークが付いた対象に通常攻撃またはCrescent Slashでダメージを与えたとき、マークを消費して{2}を与え、{3}する。").EG(1,boot.BK.f,45.0,25.0,boot.Bv.EE(0.4)).EG(2,boot.BK.f,45.0,25.0,boot.Bv.EE(0.4)).EK(3,boot.BK.hh,20.0,5.0).EH(6.0,-0.5).EB(boot.BK.bn,60.0,0).EJ(600.0);
		boot.Bv.h.Dy().ED("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与える。Akaliは{2}と{3}、{5}を得る。敵ユニットには{4}を与える。").EA(1,boot.BK.jn,300.0).EK(2,boot.BK.ff,10.0,10.0).EK(3,boot.BK.fj,10.0,10.0).EK(4,boot.BK.ie,14.0,4.0).EO(5,boot.BK.jc).EH(20.0,0).EB(boot.BK.bn,80.0,-5.0).EJ(700.0);
		boot.Bv.i.Dy().ED("{2}の敵ユニットに{1}を与える。").EQ(1,boot.BK.e,30.0,25.0,boot.Bv.EE(0.3),boot.Bv.EP(0.6)).EK(2,boot.BK.jn,325.0,0).EH(7.0,-1.0).EB(boot.BK.bn,60.0,-5.0);
		boot.Bv.j.Dy().ED("対象の敵ユニットまで高速で移動し{1}を与える。使用時にチャージを消費する。チャージは{2}毎に又は敵Championキル/アシストで増加し最大で3つまでチャージされる。チャージ増加時間はCD低減の影響を受ける。").EG(1,boot.BK.f,100.0,75.0,boot.Bv.EE(0.5)).EK(2,boot.BK.jk,25.0,-5.0).EH(2.0,-0.5).EB(boot.BK.kd,1,0).EJ(800.0);
		boot.Bv.k.Dy().Dz("スキルを使用すると3秒間{1}を得て、{2}の敵ユニットと建物に毎秒{3}を与える。ミニオンとモンスターに対しては与えるダメージが2倍になる。").EQ(3,boot.BK.f,6.0,0,boot.Bv.EE(0.1),boot.Bv.ER(boot.BK.gm,1)).EA(2,boot.BK.jn,182.5).EO(1,boot.BK.ja);
		boot.Bv.l.Dy().ED("{4}の敵ユニットに{1}を与え、{2}後に{3}を与える。").EG(1,boot.BK.f,60.0,45.0,boot.Bv.EE(0.5)).EA(2,boot.BK.ib,1).EK(3,boot.BK.hj,0.5,0).EA(4,boot.BK.jn,365.0).EH(17.0,-1.0).EI(70.0,10.0);
		boot.Bv.m.Dy().ED("対象の敵ユニットに突撃し{1}と{2}を与える。").EG(1,boot.BK.f,55.0,55.0,boot.Bv.EE(0.7)).EA(2,boot.BK.ic,650.0).EH(14.0,-1.0).EI(70.0,10.0).EJ(650.0);
		boot.Bv.n.Dy().ED("{1}する。{3}の味方ユニットは{2}する。近くの敵ユニットが死ぬと{4}する。").EG(1,boot.BK.he,60.0,30.0,boot.Bv.EE(0.2)).EG(2,boot.BK.he,30.0,15.0,boot.Bv.EE(0.1)).EA(3,boot.BK.jn,575.0).EA(4,boot.BK.hd,2.0).EH(12.0,0).EI(40.0,10.0);
		boot.Bv.o.Dy().ED("7秒間Alistarは{1}を得て、{2}する。Disable中でも使用可能。使用時に自身にかかっているCCを全て解除する。").EK(1,boot.BK.dc,60.0,10.0).EK(2,boot.BK.fo,50.0,10.0).EH(120.0,-20.0).EI(100.0,0);
		boot.Bv.p.Dy().Dz("通常攻撃した対象に3秒間{1}を与える。レベル1、7、13で低下値が上昇する。").ES(1,boot.BK.fd,new boot.Bz(15.0,5.0,0)).EC(1);
		boot.Bv.ba.Dy().ED("指定方向に包帯を飛ばし、当たった敵ユニットに{1}及び{2}を与え、そこまで移動する。").EG(1,boot.BK.f,80.0,60.0,boot.Bv.EE(0.7)).EA(2,boot.BK.hj,1).EI(80.0,10.0).EH(16.0,-2.0).EJ(1100.0);
		boot.Bv.ba.ET(boot.BR.k).EG(1,boot.BK.f,80.0,50.0,boot.Bv.EE(0.7));
		boot.Bv.bb.Dy().ED("毎秒、{2}の敵ユニットに{1}を与える。").EG(1,boot.BK.f,8.0,4.0,boot.Bv.EM(boot.BK.cg,1.5,0.3,boot.Bv.EE(0.01))).EA(2,boot.BK.jn,350.0).EU(8.0).EV(1).EW(boot.CC.d);
		boot.Bv.bc.Dy().Dz("{1}する。").EK(1,boot.BK.fp,2.0,2.0).ED("{3}の敵ユニットに{2}を与える。Amumuが通常攻撃でダメージを受けるたびに{4}。").EG(2,boot.BK.f,75.0,25.0,boot.Bv.EE(0.5)).EA(3,boot.BK.jn,400.0).EA(4,boot.BK.hd,0.5).EU(35.0).EH(10.0,-1.0);
		boot.Bv.bd.Dy().ED("{2}の敵ユニットに{1}を与え、2秒間通常攻撃と移動を封じる。").EG(1,boot.BK.f,150.0,100.0,boot.Bv.EE(0.8)).EA(2,boot.BK.jn,600.0).EI(100.0,50.0).EH(150.0,-20.0);
		boot.Bv.bd.ET(boot.BR.k).EA(2,boot.BK.jn,550.0);
		boot.Bv.be.Dy().Dz("死亡時に卵になり6秒かけて復活する。復活中は{1}及び{2}を得る。復活中にHPが0になった場合は死亡する。レベル1、5、8、12、15で増加AR/MRが上昇する。").ES(1,boot.BK.ff,new boot.CD(-40.0,15.0,0)).ES(2,boot.BK.fj,new boot.CD(-40.0,15.0,0)).EV(240.0).EC(1).EC(2);
		boot.Bv.bf.Dy().ED("指定方向に貫通する氷を飛ばし、氷に触れた敵ユニットに{1}と3秒間{2}を与え、{4}状態にする。氷が飛んでいる最中に再度スキルを使用するか、最大距離まで飛ぶと氷が破裂し、破裂地点の{6}の敵ユニットにさらに{1}と{5}と3秒間{2}を与え、{4}状態にする。").EG(1,boot.BK.f,60.0,30.0,boot.Bv.EE(0.5)).EA(2,boot.BK.ie,20.0).EA(4,boot.BK.je,0).EA(5,boot.BK.hj,1).EA(6,boot.BK.jn,150.0).EI(80.0,20.0).EH(12.0,-1.0).EJ(1100.0);
		boot.Bv.bg.Dy().ED("指定地点に5秒間{1}の壁を作りユニットを通れなくする。また、指定地点の{2}。").EK(1,boot.BK.jo,400.0,100.0).EO(2,boot.BK.jd).EI(70.0,20.0).EV(25.0).EJ(1000.0);
		boot.Bv.bh.Dy().ED("対象の敵ユニットに{1}を与える。対象が"+boot.BK.je+"の場合は{2}を与える。").EG(1,boot.BK.f,55.0,30.0,boot.Bv.EE(0.5)).EG(2,boot.BK.f,110.0,60.0,boot.Bv.EE(1)).EI(50.0,10.0).EV(5.0).EJ(650.0);
		boot.Bv.bi.Dy().ED("指定地点の{6}の敵ユニットに毎秒{1}、1秒間の{2}と{3}を与え、{5}状態にする。").EG(1,boot.BK.f,80.0,40.0,boot.Bv.EE(0.25)).EK(2,boot.BK.ih,20.0,0).EA(3,boot.BK.ie,20.0).EA(5,boot.BK.je,0).EA(6,boot.BK.jn,300.0).EU(75.0).EV(6.0).EJ(625.0).EW(boot.CC.d);
		boot.Bv.bj.Dy().Dz("スキルを使用するたびにスタックが1貯まり、4スタック時に"+boot.Bv.bm+"以外のスキルを使用すると、スタックを全て消費してそのスキルに{1}が追加される。").EA(1,boot.BK.hj,1.75);
		boot.Bv.bk.Dy().ED("対象の敵ユニットに{1}を与える。このスキルでLHを取ると{2}する。").EG(1,boot.BK.f,85.0,40.0,boot.Bv.EE(0.7)).EK(2,boot.BK.hg,60.0,5.0).EI(60.0,5.0).EV(4.0).EJ(625.0);
		boot.Bv.bl.Dy().ED("指定方向扇形45°の{1}の敵ユニットに{2}を与える。").EA(1,boot.BK.jn,625.0).EG(2,boot.BK.f,80.0,50.0,boot.Bv.EE(0.75)).EI(70.0,10.0).EV(8.0);
		boot.Bv.bm.Dy().ED("{1}間{2}と{3}を得て、効果時間中に通常攻撃をしてきた敵ユニットに{4}を与える。").EA(1,boot.BK.jj,5.0).EK(2,boot.BK.ff,20.0,10.0).EK(3,boot.BK.fj,20.0,10.0).EG(4,boot.BK.f,20.0,10.0,boot.Bv.EE(0.2)).EU(20.0).EV(10.0);
		boot.Bv.bn.Dy().ED("指定地点の{1}の敵ユニットに{2}を与え、操作可能なTibbersを召喚する。Tibbersは{3}間持続し、{4}の敵ユニットに毎秒{5}を与える。").EA(1,boot.BK.jn,150.0).EG(2,boot.BK.f,200.0,125.0,boot.Bv.EE(0.7)).EK(3,boot.BK.jj,45.0,0).EA(4,boot.BK.jn,200.0).EG(5,boot.BK.f,35.0,0,boot.Bv.EE(0.2)).EI(125.0,50.0).EV(120.0).EJ(600.0);
		boot.Bv.bo.Dy().Dz("3秒毎に{1}する(最大100%)。通常攻撃を行うとリセットされる。上昇値は3レベル毎に増加する。").ES(1,boot.BK.dm,new boot.CE(3.0,3.0,0)).EC(1);
		boot.Bv.bp.Dy().ED("通常攻撃に2秒間の{1}を付与する。").EK(1,boot.BK.ie,15.0,5.0).EU(8.0).EW(boot.CC.d);
		boot.Bv.ca.Dy().ED("指定方向扇形57.5°の方向に非貫通の矢7本を飛ばし当たった敵ユニットに{1}と{2}("+boot.Bv.bp+"のLvに依存)を与える。"+boot.Bv.bp+"を覚えていない場合はスローは発生しない。").EG(1,boot.BK.e,40.0,10.0,boot.Bv.EP(1)).EA(2,boot.BK.ie,0).EU(60.0).EH(16.0,-3.0).EJ(1200.0);
		boot.Bv.cb.Dy().Dz("敵を倒した際に追加で{1}を得る。").EK(1,boot.BK.ji,1,1).ED("指定地点に偵察鷹を放つ。鷹は5秒間指定した地点の{2}。また飛行中の鷹も{2}。").EO(2,boot.BK.jd).EV(60.0).EX(2500.0,750.0);
		boot.Bv.cc.Dy().ED("指定方向に敵Championにのみ当たる矢を飛ばし、当たった敵Championに{1}と{2}(飛距離に比例して１～3.5秒)と3秒間の{4}を与える。また敵Champion命中時に矢が爆発し、{5}の敵ユニットに{6}と3秒間の{4}を与える。飛行中の矢は{3}。").EG(1,boot.BK.f,250.0,175.0,boot.Bv.EE(1)).EA(2,boot.BK.hj,0).EO(3,boot.BK.jd).EA(4,boot.BK.ie,50.0).EA(5,boot.BK.jn,250.0).EG(6,boot.BK.f,125.0,87.5,boot.Bv.EE(0.5)).EU(150.0).EH(100.0,-10.0).EJ(-1.0);
		boot.Bv.cd.Dy().Dz(" HPが20%以下になると、10秒間持続する{1}を張る。").EG(1,boot.BK.gf,0,0,boot.Bv.ER(boot.BK.ck,50.0)).EV(90.0);
		boot.Bv.ce.Dy().ED("指定方向に腕を飛ばし、当たった敵ユニットに{1}と{2}を与え自分の位置まで引き寄せる。またこのスキル命中時に対象の{3}。").EG(1,boot.BK.f,80.0,55.0,boot.Bv.EE(1)).EA(2,boot.BK.hj,1).EO(3,boot.BK.jd).EU(120.0).EH(20.0,-1.0).EJ(925.0);
		boot.Bv.cf.Dy().ED("8秒間{1}、{2}する。").EK(1,boot.BK.im,16.0,4.0).EK(2,boot.BK.di,30.0,8.0).EU(75.0).EV(15.0);
		boot.Bv.cg.Dy().ED("次の通常攻撃に追加{1}を付与し、対象に{2}を与える。").EG(1,boot.BK.e,0,0,boot.Bv.EP(1)).EK(2,boot.BK.ib,1,0).EU(25.0).EH(9.0,-1.0);
		boot.Bv.ch.Dy().Dz("{1}の敵ユニット1体(対象はランダム)に2.5秒ごとに{2}を与える。").EA(1,boot.BK.jn,450.0).EG(2,boot.BK.f,100.0,100.0,boot.Bv.EE(0.25)).ED("{3}の敵ユニットに{4}と{5}を与える。効果後はCDが解消されるまでPassiveの効果がなくなる。").EA(3,boot.BK.jn,600.0).EG(4,boot.BK.f,250.0,125.0,boot.Bv.EE(1)).EA(5,boot.BK.hn,0.5).EU(150.0).EV(30.0);
		boot.Bv.ci.Dy().Dz("スキルが当たった敵ユニットを炎上させ、毎秒{1}与える。この効果は4秒間続く。炎上している敵ユニットにスキルが命中すると追加効果が発生する。(Minionに対しては毎秒80DMが上限)").EG(1,boot.BK.f,0,0,boot.Bv.ER(boot.BK.cg,2.0));
		boot.Bv.cj.Dy().ED("指定方向に火球を投射し、当たった敵ユニットに{1}を与える。敵が炎上していた場合、{2}を与える。").EG(1,boot.BK.f,80.0,40.0,boot.Bv.EE(0.65)).EA(2,boot.BK.hj,2.0).EU(50.0).EH(8.0,-0.5).EJ(1025.0);
		boot.Bv.ck.Dy().ED("指定地点に炎の柱を作り出し、0.5秒後に{1}の敵ユニットに{2}を与える。敵が炎上していた場合、代わりに{3}を与える。").EA(1,boot.BK.jn,175.0).EG(2,boot.BK.f,75.0,45.0,boot.Bv.EE(0.6)).EG(3,boot.BK.f,94.0,56.0,boot.Bv.EE(0.75)).EI(70.0,10.0).EV(10.0).EJ(900.0);
		boot.Bv.cl.Dy().ED("対象の敵ユニットに{1}を与える。敵が炎上していた場合、{2}の敵にも{1}を与える。").EG(1,boot.BK.f,70.0,35.0,boot.Bv.EE(0.55)).EA(2,boot.BK.jn,200.0).EI(60.0,5.0).EH(12.0,-1.0).EJ(625.0);
		boot.Bv.cm.Dy().ED("対象の敵ユニットに火炎弾を放つ。火炎弾は近くの敵ユニットに4回まで跳ね、その度に{1}を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。敵が炎上していた場合、敵Championに優先して跳ね返るようになる。").EG(1,boot.BK.f,150.0,100.0,boot.Bv.EE(0.5)).EI(100.0,50.0).EH(105.0,-15.0).EJ(750.0);
		boot.Bv.cn.Dy().Dz("通常攻撃{1}回毎にダメージが増加する(Minionには250%、Championには150%)。茂みから通常攻撃を行うと2回分としてカウントされる。レベル1、7、13でダメージが増加するまでの攻撃回数が減少する。").ES(1,boot.BK.jm,new boot.Bz(8.0,-1.0,0));
		boot.Bv.co.Dy().ED("1秒詠唱後、指定方向に貫通する弾を発射し当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%減少していき最小で{2}を与える。").EG(1,boot.BK.e,20.0,40.0,boot.Bv.EP(1.3)).EG(2,boot.BK.e,10.0,20.0,boot.Bv.EP(0.65)).EI(50.0,10.0).EH(10.0,-1.0).EJ(1250.0);
		boot.Bv.cp.Dy().ED("指定地点に罠を仕掛ける。敵Championが罠の{4}に入ると発動して、対象に{1}かけて{2}と{3}を与え、9秒間対象の{5}。罠は3個まで置け、4分間持続する。").EA(1,boot.BK.jj,1.5).EG(2,boot.BK.f,80.0,50.0,boot.Bv.EE(0.6)).EA(3,boot.BK.hk,1.5).EA(4,boot.BK.jn,135.0).EO(5,boot.BK.jd).EU(50.0).EH(20.0,-3.0).EJ(800.0);
		boot.Bv.da.Dy().ED("指定方向にネットを飛ばし当たった敵ユニットに{1}と{3}間{2}を与え、Caitlynはネットを飛ばした方向の反対側にジャンプ({4})する。").EG(1,boot.BK.f,80.0,50.0,boot.Bv.EE(0.8)).EA(2,boot.BK.ie,50.0).EK(3,boot.BK.jj,1,0.25).EA(4,boot.BK.jp,400.0).EU(75.0).EH(18.0,-2.0).EJ(850.0);
		boot.Bv.db.Dy().ED("0.5秒詠唱後に対象の敵Championの視界を得て、更に1秒詠唱後対象に目掛けて敵Championにのみ当たる弾を発射し、当たった敵Championに{1}を与える。ターゲットとの射線を遮ると間に入った敵Championに当たる。").EG(1,boot.BK.e,250.0,225.0,boot.Bv.EL(2.0)).EU(100.0).EH(90.0,-15.0).EX(2000.0,500.0);
		boot.Bv.bhb.Dy().Dz("スキルを使用すると使用した以外のスキルの{1}する。").EA(1,boot.BK.hd,1);
		boot.Bv.bhc.Dy().ED("対象の敵ユニットに{1}を与える。").Dz("{2}を得る。").EQ(1,boot.BK.f,60.0,25.0,boot.Bv.EE(0.4),boot.Bv.ER(boot.BK.bg,0.065)).EK(2,boot.BK.ed,2.0,2.0).EU(60.0).EV(3.5).EJ(650.0);
		boot.Bv.bhd.Dy().ED("対象の敵ユニットに{1}と{2}を与える。").EQ(1,boot.BK.f,60.0,35.0,boot.Bv.EE(0.6),boot.Bv.ER(boot.BK.bg,0.045)).EK(2,boot.BK.hk,0.75,0.25).EI(80.0,10.0).EV(14.0).EJ(625.0);
		boot.Bv.bhe.Dy().ED("対象の敵ユニットに魔法弾を飛ばし{1}と{2}を与える。魔法弾は{3}の敵ユニット及び自身に4回まで跳ね返る(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返り、また自身から跳ね返った弾は敵Championを優先で狙う。").EQ(1,boot.BK.f,50.0,20.0,boot.Bv.EE(0.35),boot.Bv.ER(boot.BK.bg,0.01)).EK(2,boot.BK.fd,12.0,3.0).EA(3,boot.BK.jn,400.0).EI(60.0,10.0).EV(14.0).EJ(675.0);
		boot.Bv.bhf.Dy().ED("{1}間、{2}を得て{3}する。更にスキルに50%のスプラッシュダメージ({4})が付与される。").EK(1,boot.BK.jj,5.0,1).EK(2,boot.BK.eg,15.0,5.0).EK(3,boot.BK.ik,35.0,10.0).EA(4,boot.BK.jn,200.0).EH(70.0,-10.0);
		boot.Bv.dc.Dy().Dz("スキル使用後の5秒間、全てのスキルのコストが1スタックにつき10%低減する。");
		boot.Bv.dd.Dy().ED("指定地点に0.5秒後に毒を発生させ、{1}の敵ユニットに毒を与え3秒かけて{2}を与える。このスキルがChampionにヒットした場合、3秒間{3}する。").EA(1,boot.BK.jn,75.0).EG(2,boot.BK.f,75.0,40.0,boot.Bv.EE(0.8)).EK(3,boot.BK.im,15.0,2.5).EI(35.0,10.0).EV(3.0).EJ(850.0);
		boot.Bv.de.Dy().ED("指定地点に7秒間持続する毒霧を吹き出す。毒霧は徐々に範囲(100～175)が広がり、毒霧の上を通過した敵に2秒間持続する毒を付与し{1}と2秒間{3}を与える。また指定地点の{4}。").EG(1,boot.BK.f,25.0,10.0,boot.Bv.EE(0.15)).EK(3,boot.BK.ie,15.0,5.0).EO(4,boot.BK.jd).EI(70.0,10.0).EV(9.0).EJ(850.0);
		boot.Bv.df.Dy().ED("対象の敵ユニットに{1}を与える。対象が毒を受けている場合、CDが0.5秒になる。").EG(1,boot.BK.f,50.0,35.0,boot.Bv.EE(0.55)).EI(50.0,10.0).EV(5.0).EJ(700.0);
		boot.Bv.dg.Dy().ED("眼からビームを放ち、指定方向扇形83°の範囲内の敵ユニットに{1}を与え、こちらを向いている敵に更に{2}を与える。後ろを向いていた場合2秒間{4}を与える。").EG(1,boot.BK.f,200.0,125.0,boot.Bv.EE(0.6)).EA(2,boot.BK.hj,2.0).EA(4,boot.BK.ie,60.0).EI(120.0,40.0).EH(130.0,-10.0).EJ(750.0);
		boot.Bv.dh.Dy().Dz("敵ユニットを倒すと{1}、{2}する。").EG(1,boot.BK.he,17.0,0,boot.Bv.ER(boot.BK.gm,3.0)).EG(2,boot.BK.hg,3.25,0,boot.Bv.ER(boot.BK.gm,0.25));
		boot.Bv.di.Dy().ED("指定地点に0.5秒後にトゲを出現させ、{1}の敵ユニットに{2}、{3}を与えて、3秒間{5}にする。また指定地点の視界を得る。").EA(1,boot.BK.jn,175.0).EG(2,boot.BK.f,80.0,55.0,boot.Bv.EE(1)).EA(3,boot.BK.ib,1).EA(5,boot.BK.ie,60.0).EU(90.0).EV(9.0).EJ(950.0);
		boot.Bv.dj.Dy().ED("前方扇形60°の領域の敵ユニットに{1}と{2}を与える。").EG(1,boot.BK.f,75.0,50.0,boot.Bv.EE(0.7)).EK(2,boot.BK.hn,1.5,0.25).EI(70.0,10.0).EV(13.0).EJ(700.0);
		boot.Bv.dk.Dy().ED("通常攻撃時に前方にトゲを飛ばし当たった敵ユニットに{1}を与える。トゲを飛ばす範囲はUltのスタック数に比例し増加する。").EG(1,boot.BK.f,20.0,15.0,boot.Bv.EE(0.3)).EV(0.5).EJ(500.0).EW(boot.CC.d);
		boot.Bv.dl.Dy().ED("対象の敵ユニットに{1}を与える。対象がChampion以外の場合は{2}を与える。このスキルで敵を倒すとスタックが1増えて{3}と{4}を得る。死亡するとスタックが半分(端数切り上げ)消失する。").EG(1,boot.BK.g,300.0,175.0,boot.Bv.EE(0.7)).EG(2,boot.BK.g,1000.0,0,boot.Bv.EE(0.7)).EG(3,boot.BK.p,0,0,boot.Bv.EY(boot.BK.ke,90.0,30.0)).EG(4,boot.BK.gj,0,0,boot.Bv.EY(boot.BK.ke,4.0,2.15)).EU(100.0).EV(60.0).EJ(150.0);
		boot.Bv.dm.Dy().Dz("通常攻撃に{1}が付与される。建物には無効。").EG(1,boot.BK.g,0,0,boot.Bv.EP(0.1));
		boot.Bv.dn.Dy().ED("指定した{1}の敵ユニットに{2}を与え、6秒間指定地点の{3}。また、Championに当たった場合、6秒間そのChampionの{3}。このスキルで敵のステルスを看破する事はできない。").EA(1,boot.BK.jn,150.0).EG(2,boot.BK.f,80.0,50.0,boot.Bv.EE(0.5)).EO(3,boot.BK.jd).EI(80.0,10.0).EV(8.0).EJ(600.0);
		boot.Bv.dp.Dy().ED("指定地点まで高速で移動し、通過地点を2.5秒間炎上させる。炎上地点の上にいる敵ユニットに毎秒{2}を与える。").EG(2,boot.BK.f,60.0,30.0,boot.Bv.EE(0.4)).EU(100.0).EH(26.0,-3.0).EJ(800.0);
		boot.Bv.ea.Dy().ED("4秒間、Corkiの前方にいる敵ユニットに0.5秒毎に{1}を与える(最大8hit)。ダメージを与える度に対象ユニットに{2}を与える。この効果は2秒間持続し、8回までスタックする。").EG(1,boot.BK.e,10.0,6.0,boot.Bv.EL(0.02)).EK(2,boot.BK.en,1,1).EI(60.0,5.0).EV(16.0).EJ(600.0);
		boot.Bv.eb.Dy().ED("指定方向にミサイルを発射し、当たった敵ユニットの{1}に{2}を与える。使用時にスタックを消費する。スタックは{3}毎に1つ増加し最大7つまでスタックされる。4発毎に大きいミサイル(効果範囲2倍、ダメージ50%上昇)を発射させる。スタック増加時間はCD低減の影響を受ける。").EK(1,boot.BK.jn,150.0,0).EQ(2,boot.BK.f,120.0,70.0,boot.Bv.EE(0.3),boot.Bv.ER(boot.BK.dc,0.2)).EA(3,boot.BK.jk,12.0).EI(30.0,5.0).EV(1.2).EJ(1200.0);
		boot.Bv.ec.Dy().Dz("通常攻撃またはスキルでダメージを与えた敵ユニットに出血スタックを付与する。出血スタックが付与された敵ユニットは毎秒{1}を受ける。出血スタックは最大5回までスタックし、5秒間持続する。また、出血スタックを受けている敵Champion数に応じて{2}していく。").EQ(1,boot.BK.f,2.4,0,boot.Bv.ER(boot.BK.gm,0.3),boot.Bv.EL(0.06)).EA(2,boot.BK.im,5.0).EC(2);
		boot.Bv.ed.Dy().ED("斧を振り回し{3}の敵ユニットに{1}を与える。斧の刃に当たった敵Championに対しては{2}を与える。").EG(1,boot.BK.e,70.0,35.0,boot.Bv.EL(0.7)).EG(2,boot.BK.e,105.0,52.5,boot.Bv.EL(1.05)).EA(3,boot.BK.jn,425.0).EU(40.0).EH(9.0,-1.0);
		boot.Bv.ee.Dy().ED("次の通常攻撃に{1}を追加し、2秒間{3}と{4}が付与される。対象の出血スタック数1個につき、このスキルの{5}する。").EG(1,boot.BK.e,0,0,boot.Bv.EP(0.2)).EK(3,boot.BK.ih,20.0,5.0).EK(4,boot.BK.ie,20.0,5.0).EA(5,boot.BK.hd,1).EI(30.0,5.0).EV(8.0);
		boot.Bv.ef.Dy().Dz("{1}を得る。").EK(1,boot.BK.el,5.0,5.0).ED("前方範囲内の敵ユニットをDariusがいる方向に引き寄せる。").EU(45.0).EH(24.0,-3.0).EJ(550.0);
		boot.Bv.eg.Dy().ED("対象の敵Championに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵Championのキルを取った場合、{3}する。").EG(1,boot.BK.g,160.0,90.0,boot.Bv.EL(0.75)).EO(3,boot.BK.hd).EU(100.0).EH(100.0,-10.0).EJ(475.0);
		boot.Bv.eg.ET(boot.BR.k).ED("対象の敵Championに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵Championのキルを取った場合、12秒間再使用することが出来る。この効果は複数回起こりえる。").EH(120.0,-20.0);
		boot.Bv.eh.Dy().Dz("{1}する。通常攻撃3回毎に周囲にいる敵ユニットに{2}を与える。").EA(1,boot.BK.di,20.0).ES(2,boot.BK.f,new boot.CF([20.0,25.0,30.0,40.0,50.0,65.0,80.0,95.0,110.0,125.0,140.0,155.0,175.0,195.0,215.0,240.0,265.0,290.0],0));
		boot.Bv.ei.Dy().ED("指定地点に弧を描くエネルギーを放ち、当たった敵ユニットと{2}のユニットに{1}とMoonlight(3秒)を与える。またMoonlightが付与されている敵ユニットの{3}。").EG(1,boot.BK.f,60.0,35.0,boot.Bv.EE(0.7)).EA(2,boot.BK.jn,50.0).EO(3,boot.BK.jd).EU(55.0).EH(10.0,-1.0).EJ(830.0);
		boot.Bv.ej.Dy().ED("5秒間{1}を張ると同時に、Dianaの周りを回る3つの球体を召喚する。敵ユニットが触れた球体は爆発し、{2}の敵ユニットに{3}を与える。球体が全て爆発するとシールドが張りなおされる。").EG(1,boot.BK.gf,55.0,25.0,boot.Bv.EE(0.45)).EA(2,boot.BK.jn,400.0).EG(3,boot.BK.f,20.0,14.0,boot.Bv.EE(0.2)).EI(60.0,10.0).EV(10.0);
		boot.Bv.ek.Dy().ED("{1}にいるすべての敵ユニットをDianaがいる方向に引き寄せた後、2秒間{3}を与える。").EA(1,boot.BK.jn,500.0).EK(3,boot.BK.ie,35.0,5.0).EU(70.0).EH(26.0,-2.0);
		boot.Bv.el.Dy().ED("対象の敵ユニットの元までテレポートし、{1}を与える。対象にMoonlightが付与されていた場合、すべての敵ユニットに付与されたMoonlightを消費してこのスキルの{2}する。").EG(1,boot.BK.f,100.0,60.0,boot.Bv.EE(0.6)).EO(2,boot.BK.hd).EI(50.0,15.0).EH(25.0,-5.0).EJ(825.0);
		boot.Bv.em.Dy().Dz("毎秒{1}する。").EG(1,boot.BK.he,0,0,boot.Bv.ER(boot.BK.p,0.003));
		boot.Bv.en.Dy().ED("指定方向に包丁を投げ、当たった敵ユニットに{1}と2秒間の{3}を与える。最小で{4}。ミニオンやモンスターへの最大DMは{5}。命中すると{6}する。").EG(1,boot.BK.f,0,0,boot.Bv.EY(boot.BK.ch,15.0,3.0)).EA(3,boot.BK.ie,40.0).EK(4,boot.BK.f,80.0,50.0).EK(5,boot.BK.f,300.0,100.0).EK(6,boot.BK.he,25.0,5.0).EB(boot.BK.p,50.0,10.0).EV(4.0).EJ(1000.0);
		boot.Bv.eo.Dy().ED("{1}の敵ユニットに毎秒{2}を与える。また{3}を得る。").EA(1,boot.BK.jn,325.0).EG(2,boot.BK.f,35.0,15.0,boot.Bv.EE(0.2)).EK(3,boot.BK.gn,10.0,5.0).EB(boot.BK.p,10.0,5.0).EV(4.0).EW(boot.CC.d);
		boot.Bv.ep.Dy().ED("5秒間{1}を得る。").EG(1,boot.BK.dc,40.0,15.0,boot.Bv.EY(boot.BK.cf,0.4,0.15)).EB(boot.BK.p,35.0,10.0).EV(7.0);
		boot.Bv.fa.Dy().ED("12秒かけて{1}し、{2}する。").EG(1,boot.BK.he,0,0,boot.Bv.EY(boot.BK.p,0.4,0.15)).EK(2,boot.BK.im,15.0,10.0).EV(75.0).EB(boot.BK.cd,20.0,0);
		boot.Bv.fb.Dy().Dz("クリティカル時または"+boot.Bv.fc+"使用時の通常攻撃に毎秒{1}が付与される。毎秒ダメージは4秒間持続する。").EG(1,boot.BK.e,7.5,0,boot.Bv.ER(boot.BK.gm,1));
		boot.Bv.fc.Dy().ED("次に行う通常攻撃に追加{1}が付与される。このスキルによる通常攻撃が敵ユニットに命中すると、斧がDravenの近くに跳ね返る。その斧をキャッチするとBlood RushのCDが解消され、更に次の通常攻撃もSpinning Axeの効果を受けるようになる。このスキルは連続で使用する事で最大2回分までチャージできる。").EG(1,boot.BK.e,0,0,boot.Bv.EY(boot.BK.dc,0.45,0.1)).EU(45.0).EH(12.0,-1.0);
		boot.Bv.fd.Dy().ED("1.5秒間{1}し、3秒間{2}する。移動速度増加は1.5秒かけて元に戻る。").EK(1,boot.BK.im,40.0,5.0).EK(2,boot.BK.di,20.0,5.0).EU(40.0).EV(12.0);
		boot.Bv.fe.Dy().ED("指定方向に貫通する斧を投げ、当たった敵ユニットに{1}と{2}と2秒間{3}を与える。このノックバックは斧から弾かれる形で左右に吹き飛ぶ。").EG(1,boot.BK.e,70.0,35.0,boot.Bv.EL(0.5)).EA(2,boot.BK.ic,0).EK(3,boot.BK.ie,20.0,5.0).EU(70.0).EH(18.0,-1.0).EJ(1050.0);
		boot.Bv.ff.Dy().ED("指定方向に地面を這う貫通する斧を投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに8%ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定があり、斧が飛んでいる最中に再度このスキルを使用するか、敵Championに命中した時点で斧が反転してDravenの元に戻ってくる。反転した際、低下ダメージはリセットされる。また移動中の斧は{2}。").EG(1,boot.BK.e,175.0,100.0,boot.Bv.EL(1.1)).EO(2,boot.BK.jd).EU(120.0).EV(110.0).EJ(-1.0);
		boot.Bv.fg.Dy().Dz("Human Form時に使用したスキルが敵ユニットに命中するとSpiderlingのチャージを1得る。Spider Formになるとチャージ数に比例したSpiderlingを召喚する。召喚される数はSpider Formのレベルに比例し増加する。召喚されたSpiderlingは死亡するとチャージが減るが、再度Human Formに戻ると再度チャージ状態に戻る。");
		boot.Bv.fh.Dy().ED("対象の敵ユニットに毒を放ち{1}を与える。").EG(1,boot.BK.f,50.0,45.0,boot.Bv.EM(boot.BK.ch,8.0,0,boot.Bv.ER(boot.BK.ea,0.03))).EI(80.0,5.0).EV(6.0).EJ(475.0);
		boot.Bv.fj.Dy().ED("指定地点に蜘蛛を放つ。蜘蛛は敵ユニットに当たるか3秒間経過すると爆発し、範囲内の敵ユニットに{1}を与える。蜘蛛は指定地点に移動した後、最も近くにいる敵ユニットに向かって移動する。また{2}。").EG(1,boot.BK.f,75.0,50.0,boot.Bv.EE(0.8)).EO(2,boot.BK.jd).EI(60.0,10.0).EV(12.0).EJ(950.0);
		boot.Bv.fl.Dy().ED("指定方向に糸を飛ばし当たった敵ユニットに{1}を与え、{2}。").EA(1,boot.BK.hj,1.5).EO(2,boot.BK.jd).EU(50.0).EH(14.0,-1.0).EJ(1075.0);
		boot.Bv.fn.Dy().ED("EliseがSpider Formに変身し射程125のMeleeになる。その間は通常攻撃に追加{1}が付与され、{2}と{3}を得て、{4}する。またこのスキルに比例しSpiderlingの最大チャージ数、攻撃力が増加し、Spiderlingが受けるAoEダメージが低減される。").EG(1,boot.BK.f,10.0,10.0,boot.Bv.EE(0.3)).EK(2,boot.BK.ff,10.0,5.0).EK(3,boot.BK.fj,10.0,5.0).EA(4,boot.BK.ik,10.0).EV(4.0);
		boot.Bv.fi.Dy().ED("対象の敵ユニットに飛びつき{1}を与える。").EG(1,boot.BK.f,50.0,45.0,boot.Bv.EM(boot.BK.ci,8.0,0,boot.Bv.EE(0.03))).EV(6.0).EJ(475.0);
		boot.Bv.fk.Dy().Dz("Spiderlingの{1}する。").EK(1,boot.BK.di,5.0,5.0).ED("3秒間EliseとSpiderlingの{2}する。また、その間Spiderlingが攻撃を行うたびにEliseの{3}する。").EK(2,boot.BK.di,60.0,20.0).EG(3,boot.BK.he,4.0,0,boot.Bv.EE(0.02)).EV(12.0);
		boot.Bv.fm.Dy().ED("EliseとSpiderlingが上空に退避し(ターゲット不可になる)指定の方法で降下する。上空にいる間は射程内の視界を得る地面をクリックした場合: 最大2秒間上空に待機し、初期位置へ降下する。この間、敵ユニットをターゲットし裏側に降下できる。敵ユニットをクリックした場合: 即座に下降し裏側に降り立つ。").EH(26.0,-2.0).EJ(1075.0);
		boot.Bv.fo.Dy().Dz("通常攻撃に追加{1}が付与される。").EG(1,boot.BK.f,10.0,10.0,boot.Bv.EE(0.3)).ED("EliseがHuman Formに変身し射程550のRangedになる。").EV(4.0);
		boot.Bv.fp.Dy().Dz("Evelynnが{2}状態になる。スキルを使うか、ダメージを受けるか与えるかすると、6秒間ステルスが解除された状態になる。敵Championに範囲700まで近づくとステルス状態でも敵Championに視認されるようになる。また、ステルス中は毎秒{1}していく。").EG(1,boot.BK.hg,0,0,boot.Bv.ER(boot.BK.bg,0.01)).EO(2,boot.BK.jc);
		boot.Bv.ga.Dy().ED("視界内にいる最も近くにいる敵ユニット1体に向けて棘を放ち、直線状にいる敵ユニットに{1}を与える。Evelynnが敵ユニットをターゲットしている場合は、その対象に向けて棘が放たれる。").EQ(1,boot.BK.f,40.0,20.0,boot.Bv.EE(0.45),boot.Bv.EL(0.5)).EI(16.0,6.0).EV(1.5).EJ(400.0);
		boot.Bv.gb.Dy().Dz("敵Championにスキルを当てるたびに{1}する。この効果は3秒間持続し、最大4スタックする。").EK(1,boot.BK.ik,4.0,4.0).EC(1).ED("3秒間{2}して、{3}と{4}を得る。敵Championキル/アシスト時に、このスキルの{5}する。").EK(2,boot.BK.im,30.0,10.0).EO(3,boot.BK.ip).EO(4,boot.BK.ja).EO(5,boot.BK.hd).EV(15.0);
		boot.Bv.gc.Dy().ED("対象の敵ユニットに2回連続で{1}を与え、3秒間{2}する。").EQ(1,boot.BK.f,35.0,20.0,boot.Bv.EE(0.5),boot.Bv.EL(0.5)).EK(2,boot.BK.di,60.0,15.0).EI(50.0,5.0).EV(9.0).EJ(225.0);
		boot.Bv.gd.Dy().ED("指定{1}の敵ユニットに{2}と2秒間の{3}を与え、このスキルを命中させた敵Champion毎に6秒間持続する{4}を得る。").EA(1,boot.BK.jn,500.0).EG(2,boot.BK.f,0,0,boot.Bv.EM(boot.BK.ch,15.0,5.0,boot.Bv.EE(0.01))).EK(3,boot.BK.ie,30.0,20.0).EK(4,boot.BK.gf,150.0,75.0).EU(100.0).EH(150.0,-30.0).EJ(650.0);
		boot.Bv.ge.Dy().Dz("ユニット(敵味方問わず)にスキルを当てる度に5秒間{1}する。この効果は5回分までスタックする。").EA(1,boot.BK.di,10.0).EC(1);
		boot.Bv.gf.Dy().ED("指定方向に魔法の矢を飛ばし、当たった敵ユニットに{1}を与える。このスキルが命中すると、Ezrealのすべてのスキルの{2}。").EQ(1,boot.BK.e,35.0,20.0,boot.Bv.EE(0.2),boot.Bv.EP(1)).EA(2,boot.BK.hd,1).EI(28.0,3.0).EH(6.0,-0.5).EJ(1150.0);
		boot.Bv.gg.Dy().ED("指定方向にChampionにのみ当たる貫通するエネルギーを飛ばし、当たった味方Championには5秒間{1}し、敵Championには{2}を与える。").EK(1,boot.BK.di,20.0,5.0).EG(2,boot.BK.f,70.0,45.0,boot.Bv.EE(0.8)).EI(50.0,10.0).EV(9.0).EJ(1000.0);
		boot.Bv.gh.Dy().ED("指定地点にテレポートし、テレポート先から一番近い敵ユニット({1})1体に{2}を与える。").EA(1,boot.BK.jn,750.0).EG(2,boot.BK.f,75.0,50.0,boot.Bv.EE(0.75)).EU(90.0).EH(19.0,-2.0).EJ(475.0);
		boot.Bv.gi.Dy().ED("1秒詠唱後、指定方向に射程無限の貫通する魔法の矢を飛ばし当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%ずつ減り、最大で30%まで低下する。また飛行中の矢は{2}。").EQ(1,boot.BK.f,350.0,150.0,boot.Bv.EE(0.9),boot.Bv.EL(1)).EO(2,boot.BK.jd).EU(100.0).EV(80.0).EJ(-1.0);
		boot.Bv.gj.Dy().Dz("{1}の敵ユニットに{2}を与える。").EA(1,boot.BK.jn,1000.0).EA(2,boot.BK.fd,10.0);
		boot.Bv.gk.Dy().ED("対象の敵ユニットに{1}を与える。").EK(1,boot.BK.hl,1,0.5).EI(65.0,10.0).EH(15.0,-1.0).EJ(575.0);
		boot.Bv.gl.Dy().ED("対象の敵ユニットに最大5秒間毎秒{1}を与え、{2}する。敵が離れる({3})と詠唱が中断される。").EG(1,boot.BK.f,60.0,30.0,boot.Bv.EE(0.45)).EG(2,boot.BK.he,0,0,boot.Bv.EY(boot.BK.k,60.0,5.0)).EA(3,boot.BK.jn,750.0).EI(80.0,10.0).EH(10.0,-1.0).EJ(475.0).EW(boot.CC.e);
		boot.Bv.gm.Dy().ED("対象の敵ユニットにカラスを飛ばし{1}と{2}を与える。カラスは{4}の敵ユニットに4回まで跳ね返りその度に効果を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。ミニオンとモンスターに対しては{3}を与える。").EG(1,boot.BK.f,65.0,20.0,boot.Bv.EE(0.45)).EA(2,boot.BK.hn,1.2).EG(3,boot.BK.f,97.5,30.0,boot.Bv.EE(0.675)).EA(4,boot.BK.jn,450.0).EI(50.0,20.0).EH(15.0,-1.0).EJ(750.0);
		boot.Bv.gn.Dy().ED("1.5秒詠唱後に指定地点にテレポートし、{1}の敵ユニットに5秒間毎秒{2}を与える。最大DMは{3}となる。").EA(1,boot.BK.jn,600.0).EG(2,boot.BK.f,125.0,100.0,boot.Bv.EE(0.45)).EG(3,boot.BK.f,625.0,500.0,boot.Bv.EE(2.25)).EI(150.0,50.0).EH(150.0,-10.0).EJ(800.0).EW(boot.CC.e);
		boot.Bv.go.Dy().Dz("通常攻撃またはLungeでダメージを与えると、6秒かけて{1}する。対象がChampionの場合、この効果は4回までスタックする。").EG(1,boot.BK.he,7.0,0,boot.Bv.ER(boot.BK.gm,1));
		boot.Bv.gp.Dy().ED("対象の敵ユニットへダッシュし{1}を与える。このスキルは4秒の間、もう1度だけ使用できる。2度目は消費MN無しで使用可能。").EG(1,boot.BK.e,40.0,25.0,boot.Bv.EL(0.6)).EU(60.0).EH(16.0,-2.0).EJ(600.0);
		boot.Bv.ha.Dy().Dz("{1}を得る。").EK(1,boot.BK.dc,15.0,5.0).ED("1.5秒の間に受ける通常攻撃を一度だけ無効化し、その相手に{2}を与える。この効果は一部のミニオンとモンスターには発生しない。").EG(2,boot.BK.f,60.0,50.0,boot.Bv.EE(1)).EU(45.0).EH(10.0,-1.0);
		boot.Bv.hb.Dy().ED("3秒間{1}する。効果中に通常攻撃を行うかまたはLungeを使用すると3秒間{2}する。移動速度の増加は3回までスタックする。敵Championを倒すとこのスキルの{3}する。").EK(1,boot.BK.di,60.0,15.0).EK(2,boot.BK.im,7.0,2.0).EO(3,boot.BK.hd).EU(55.0).EH(15.0,-1.0);
		boot.Bv.hc.Dy().ED("対象の敵Championにダッシュし{1}を与え、範囲内にいる敵Championをランダムに対象とし4回{1}を与える(合計5回)。最後の攻撃は最初に対象とした敵Championで固定。同一ユニットに複数回DMを与える場合、2回目以降は25%のダメージになる。単一対象への最大DMは{2}。").EG(1,boot.BK.e,160.0,170.0,boot.Bv.EL(1.15)).EG(2,boot.BK.e,320.0,340.0,boot.Bv.EL(2.3)).EU(100.0).EH(130.0,-10.0).EJ(400.0);
		boot.Bv.hd.Dy().Dz("{2}を得て、{1}する。この軽減は防御力計算より先に行われる。").ES(1,boot.BK.gd,new boot.CE(4.0,2.0,0)).EO(2,boot.BK.ja);
		boot.Bv.he.Dy().ED("対象の敵ユニットに追加{1}が付与された通常攻撃を与え、その方向に駆け抜ける。移動距離は固定。").EG(1,boot.BK.f,10.0,30.0,boot.Bv.EE(0.6)).EI(50.0,5.0).EH(10.0,-1.0).EJ(550.0);
		boot.Bv.hf.Dy().Dz("通常攻撃に{1}が付与される。このダメージは0.5秒毎に3秒間かけて与えられる。(Minionに対しては300DMが上限)").EQ(1,boot.BK.f,30.0,10.0,boot.Bv.EE(0.35),boot.Bv.EY(boot.BK.ci,4.0,1)).ED("5秒間通常攻撃に{2}と{3}を付与する。このダメージはPassiveと重複する。").EG(2,boot.BK.f,10.0,5.0,boot.Bv.EE(0.35)).EA(3,boot.BK.ii,3.0).EU(40.0).EV(10.0);
		boot.Bv.hg.Dy().ED("指定地点にジャンプする。ジャンプ中はターゲットされない状態になる。0.75秒後にその場に降下し、{1}の敵ユニットに{2}と2秒間{3}を与える。").EA(1,boot.BK.jn,250.0).EG(2,boot.BK.f,70.0,50.0,boot.Bv.EE(0.75)).EK(3,boot.BK.ie,40.0,5.0).EI(90.0,10.0).EH(16.0,-2.0).EJ(400.0);
		boot.Bv.hh.Dy().ED("Playfulのジャンプ中のみ使用可能。降下する場所を別の指定地点に変更し、その{1}の敵ユニットに{2}を与える。このスキルを使用した場合Playfulのダメージとスローは発生しない。").EA(1,boot.BK.jn,150.0).EG(2,boot.BK.f,70.0,50.0,boot.Bv.EE(0.75)).EH(16.0,-2.0).EJ(400.0);
		boot.Bv.hi.Dy().ED("指定地点に敵Championのみに命中する魚を投げ、命中した敵Championに魚がくっつき、{1}を与える。その1.5秒後に地面から鮫が現れ、魚が命中した対象を襲い、対象とその周囲({2})の敵ユニットに{3}を与え、{4}後に1.5秒間{5}を与える。魚がくっついていた敵Champion以外のユニットには{4}の代わりに{6}を与える。魚がChampionに当たらなかった場合は指定地点に魚が残り、その地点に鮫が現れる。また魚は視界を確保し、その上を敵Championが通り過ぎると、当たった場合と同様にその敵Championにくっつき、鮫が襲いかかる。").EK(1,boot.BK.ie,50.0,10.0).EA(2,boot.BK.jn,250.0).EG(3,boot.BK.f,200.0,125.0,boot.Bv.EE(1)).EA(4,boot.BK.ib,0).EK(5,boot.BK.ie,50.0,10.0).EA(6,boot.BK.ic,0).EU(100.0).EH(100.0,-15.0).EJ(1275.0);
		boot.Bv.hj.Dy().Dz("{1}を得る。").EG(1,boot.BK.ea,0,0,boot.Bv.ER(boot.BK.fj,0.5));
		boot.Bv.hk.Dy().ED("指定地点に魔法弾を飛ばし、{1}の敵ユニットに{2}と2.5秒間{3}を与える。").EA(1,boot.BK.jn,175.0).EG(2,boot.BK.f,80.0,55.0,boot.Bv.EE(0.6)).EK(3,boot.BK.ie,24.0,4.0).EI(60.0,5.0).EV(7.0).EJ(900.0);
		boot.Bv.hl.Dy().ED("4秒間対象のChampionは{1}と{2}を得て、効果中にその対象のChampionがダメージを受ける度にGalioの{3}する。自身に使用した場合はダメージを受けてから回復される。").EK(1,boot.BK.ff,30.0,15.0).EK(2,boot.BK.fj,30.0,15.0).EG(3,boot.BK.he,25.0,15.0,boot.Bv.EE(0.3)).EU(60.0).EV(13.0).EJ(800.0);
		boot.Bv.hm.Dy().ED("指定方向に風を発生させ、当たった敵ユニットに{1}を与える。このスキルを使用すると指定した方向に5秒間持続する風が残り、その風の進行方向上にいる味方ユニットは{2}する。").EG(1,boot.BK.f,60.0,45.0,boot.Bv.EE(0.5)).EK(2,boot.BK.im,20.0,8.0).EI(70.0,5.0).EV(12.0).EJ(1000.0);
		boot.Bv.hn.Dy().ED("{1}の敵ユニットに{2}を与え、さらに2秒間詠唱を行う。詠唱中Galioは{3}して、詠唱中にGalioがダメージを受ける度にこのスキルのダメージが5%ずつ増加していく(最大40%増加)。また詠唱中にBulwarkを使用することが出来る。詠唱完了またはキャンセル時に、周囲の敵ユニットのTauntを解除するとともに{4}を与える。最大DMは{5}。").EA(1,boot.BK.jn,600.0).EA(2,boot.BK.hp,2.0).EA(3,boot.BK.fo,50.0).EG(4,boot.BK.f,220.0,110.0,boot.Bv.EE(0.6)).EG(5,boot.BK.f,308.0,154.0,boot.Bv.EE(0.84)).EI(100.0,50.0).EH(170.0,-20.0).EW(boot.CC.e);
		boot.Bv.ho.Dy().Dz("通常攻撃時に対象にスタックを付与し、1スタックにつき毎秒{1}と{2}を与える。この効果は3秒間持続し、3回までスタックする。").EG(1,boot.BK.f,3.0,0,boot.Bv.ER(boot.BK.gm,1)).EA(2,boot.BK.ie,7.0);
		boot.Bv.hp.Dy().ED("対象の敵ユニットに{1}(クリティカルあり)を与える。このスキルで敵ユニットを倒すと消費マナの半分のマナが回復し、追加で{2}得る。").EG(1,boot.BK.e,20.0,25.0,boot.Bv.EP(1)).EK(2,boot.BK.ji,4.0,1).EI(50.0,5.0).EV(5.0).EJ(625.0);
		boot.Bv.ia.Dy().ED("自身のCC(Stun, Slow, Taunt, Fear, Snare, Silence, Suppression, Blind)を取り除き{1}する。StunなどのDisable中でも使用可能。").EG(1,boot.BK.he,80.0,70.0,boot.Bv.EE(1)).EU(65.0).EH(22.0,-1.0);
		boot.Bv.ib.Dy().Dz("{1}を得て、{2}する。").EK(1,boot.BK.dc,8.0,2.0).EK(2,boot.BK.im,3.0,1).ED("7秒間{7}を得て、{3}する。{6}内の味方Championは{4}を得て{5}する。効果中はPassiveの効果が無効になる。").EA(6,boot.BK.jn,1200.0).EK(7,boot.BK.dc,12.0,7.0).EK(3,boot.BK.im,8.0,3.0).EK(4,boot.BK.dc,6.0,3.5).EK(5,boot.BK.im,4.0,1.1).EI(50.0,5.0).EV(25.0);
		boot.Bv.ic.Dy().ED("MAP内の指定した地点に砲撃を行い、その地点の視界({1})を得る。範囲内には7秒間砲弾が降り注ぎ(場所はランダム、計25発)、着弾した{2}にいる敵ユニットに{4}と1.25秒間{3}を与える。").EA(1,boot.BK.jn,575.0).EA(2,boot.BK.jn,275.0).EA(3,boot.BK.ie,25.0).EG(4,boot.BK.f,75.0,45.0,boot.Bv.EE(0.2)).EU(100.0).EH(120.0,-5.0).EJ(-1.0);
		boot.Bv.id.Dy().Dz("9秒間敵Minion以外からダメージを受けない状態が続くと、以降敵Minion以外からダメージを受けるまで毎秒{1}し続ける。").EG(1,boot.BK.he,0,0,boot.Bv.ER(boot.BK.p,0.005));
		boot.Bv.id.ET(boot.BR.k).EG(1,boot.BK.he,0,0,boot.Bv.ER(boot.BK.p,0.004));
		boot.Bv.ie.Dy().ED("{1}間{2}し、スキル使用後6秒間に行った次の通常攻撃に追加{3}と{4}が付与される。またこのスキル使用時に自身にかかっているスローを解除する。").EK(1,boot.BK.jj,1.5,0.75).EA(2,boot.BK.im,35.0).EG(3,boot.BK.e,30.0,25.0,boot.Bv.EP(0.4)).EK(4,boot.BK.hn,1.5,0.25).EV(8.0);
		boot.Bv.ig.Dy().Dz("{1}し{2}する。").EG(1,boot.BK.ff,0,0,boot.Bv.ER(boot.BK.ff,0.2)).EG(2,boot.BK.fj,0,0,boot.Bv.ER(boot.BK.fj,0.2)).ED("{3}間{4}し、{5}を得る。").EK(3,boot.BK.jj,2.0,1).EA(4,boot.BK.fo,30.0).EA(5,boot.BK.gn,30.0).EH(24.0,-1.0);
		boot.Bv.ig.ET(boot.BR.k).EG(1,boot.BK.ff,0,0,boot.Bv.ER(boot.BK.fi,0.2)).EG(2,boot.BK.fj,0,0,boot.Bv.ER(boot.BK.fm,0.2));
		boot.Bv.ih.Dy().ED("Garenが3秒間回転し、その間近くの敵ユニットに0.5秒毎に{1}を与える(最大6hit)。このスキルにはクリティカル判定があり、クリティカル時は追加{2}を与える。回転中は{3}を得るが、敵Minionをすり抜けている間は移動速度が20%低下する。Minionに与えるダメージは通常の75%。").EG(1,boot.BK.e,10.0,12.5,boot.Bv.EP(0.35)).EG(2,boot.BK.e,0,0,boot.Bv.EP(0.175)).EO(3,boot.BK.ja).EH(13.0,-1.0);
		boot.Bv.ii.Dy().ED("対象の敵Championに{1}を与える。").EG(1,boot.BK.f,175.0,175.0,boot.Bv.EZ(boot.BK.ci,new boot.CG([28.6,33.3,40.0],0))).EH(160.0,-40.0).EJ(400.0);
		boot.Bv.ij.Dy().Dz("スキル使用後に4秒かけて{1}する。").EG(1,boot.BK.he,0,0,boot.Bv.ER(boot.BK.p,0.02));
		boot.Bv.ik.Dy().ED("指定地点に樽を転がし、爆発時に{1}の敵ユニットに{2}と3秒間{3}を与える。樽は5秒経つか、スキルを再度使用すると爆発する。").EA(1,boot.BK.jn,375.0).EG(2,boot.BK.f,85.0,50.0,boot.Bv.EE(0.9)).EK(3,boot.BK.ih,20.0,5.0).EI(80.0,10.0).EH(12.0,-1.0).EJ(1100.0);
		boot.Bv.il.Dy().ED("{1}する。さらに1秒詠唱後に20秒間{2}を得て、{3}するようになる。").EK(1,boot.BK.hg,30.0,15.0).EK(2,boot.BK.dc,30.0,10.0).EK(3,boot.BK.fo,10.0,2.0).EV(25.0);
		boot.Bv.im.Dy().ED("指定方向に突進し、衝突した敵ユニットとその周囲にいる敵ユニットに{1}と2.5秒間{2}を与える。衝突時に突進は止まる。衝突地点に複数の敵ユニットがいた場合、{3}を与える。").EQ(1,boot.BK.f,80.0,40.0,boot.Bv.EE(0.5),boot.Bv.EP(0.66)).EA(2,boot.BK.ie,35.0).EG(3,boot.BK.f,50.0,25.0,boot.Bv.EE(0.5)).EU(75.0).EV(7.0).EJ(650.0);
		boot.Bv.io.Dy().ED("指定地点に爆発する樽を投げ、{1}内の敵ユニットに{2}を与え、{3}させる。").EA(1,boot.BK.jn,400.0).EG(2,boot.BK.f,200.0,125.0,boot.Bv.EE(1)).EA(3,boot.BK.ic,800.0).EI(100.0,25.0).EH(100.0,-10.0).EJ(1050.0);
		boot.Bv.ip.Dy().Dz("戦闘状態になると1秒ごとにスタックが1増加し、スタック数に比例して{1}と{2}を得る。この効果は10回までスタックし、3秒間戦闘を行わないとスタックが0になる。レベル1、7、13で1スタック毎の増加AR,MRが上昇する。").ES(1,boot.BK.ff,new boot.Bz(1,1,0)).ES(2,boot.BK.fj,new boot.Bz(1,1,0));
		boot.Bv.ja.Dy().ED("指定方向扇形の範囲に貫通する弾を3発発射し、当たった敵ユニットに{1}を与える。同一対象に対して複数hitし、2発目以降は本来の35%分の物理DMを与える(3発hitで合計{2})。").EG(1,boot.BK.e,60.0,35.0,boot.Bv.EL(0.8)).EG(2,boot.BK.e,102.0,59.5,boot.Bv.EL(1.36)).EI(60.0,10.0).EH(12.0,-1.0).EJ(750.0);
		boot.Bv.jb.Dy().ED("指定地点にスモーク弾を発射し範囲内の敵ユニットに{1}を与え、4秒間持続する煙幕を残す。煙幕内にいる敵Championに視界低下とス{2}を与える。").EG(1,boot.BK.f,60.0,50.0,boot.Bv.EE(0.6)).EK(2,boot.BK.ie,15.0,5.0).EU(70.0).EH(20.0,-1.0).EJ(700.0);
		boot.Bv.jc.Dy().ED("指定方向にダッシュし4秒間{1}する。このスキルは自身が通常攻撃を行う毎に{2}する。対象が建物の場合は無効。").EK(1,boot.BK.di,30.0,10.0).EA(2,boot.BK.hd,1).EU(50.0).EH(22.0,-2.0).EJ(425.0);
		boot.Bv.jd.Dy().ED("指定方向にMinionを貫通する爆発弾を発射し、hitした敵ユニットに{1}を与える。敵Championにhitするか最大距離飛ぶとターゲット後方に扇形に爆発が広がり、範囲内の敵ユニットに{2}を与える。").EG(1,boot.BK.e,250.0,100.0,boot.Bv.EL(1.4)).EG(2,boot.BK.e,140.0,110.0,boot.Bv.EL(1.2)).EU(100.0).EH(100.0,-10.0).EJ(1000.0);
		boot.Bv.je.Dy().Dz("{2}と{1}を得る。レベル1、3、6、9、12、15、18で増加割合が上昇する。").EG(1,boot.BK.dc,0,0,boot.Bv.EZ(boot.BK.io,new boot.CH(0.1,0.025,0))).EO(2,boot.BK.ja);
		boot.Bv.jf.Dy().ED("武器を振り回し{2}の敵ユニットに{1}を与える。このスキルが敵ユニットに命中した場合、Hecarimは短時間の間1スタックを得て、1スタックにつきこのスキルの{4}する(最大2スタック)。スタックは6秒間増加がないと0になる。ミニオンやモンスターには{3}を与える。").EG(1,boot.BK.e,50.0,35.0,boot.Bv.EL(0.6)).EA(2,boot.BK.jn,200.0).EG(3,boot.BK.e,18.5,11.5,boot.Bv.EL(0.2)).EA(4,boot.BK.hd,1).EU(25.0).EV(4.0);
		boot.Bv.jf.ET(boot.BR.k).EG(1,boot.BK.e,60.0,35.0,boot.Bv.EL(0.6));
		boot.Bv.jg.Dy().ED("4秒間{1}の敵ユニットに毎秒{2}を与える。この効果を受けている敵ユニットがダメージを受けた場合、そのダメージの値に応じて{3}する。").EA(1,boot.BK.jn,575.0).EG(2,boot.BK.f,20.0,11.25,boot.Bv.EE(0.2)).EG(3,boot.BK.he,0,0,boot.Bv.EY(boot.BK.k,10.0,5.0)).EI(50.0,10.0).EV(14.0);
		boot.Bv.jg.ET(boot.BR.k).EG(3,boot.BK.he,0,0,boot.Bv.EY(boot.BK.k,20.0,0)).EH(20.0,-1.5);
		boot.Bv.jh.Dy().ED("3秒間{1}して(最大75%)、その後1秒間その移動速度を維持する。また次の通常攻撃のダメージはこのスキルを使用してからHecarimが移動した距離に比例し最小で{3}、最大で{4}を与えるようになり、{2}が付与される。").EG(1,boot.BK.im,20.0,0,boot.Bv.ER(boot.BK.jl,18.3)).EA(2,boot.BK.ic,300.0).EG(3,boot.BK.e,40.0,35.0,boot.Bv.EL(0.5)).EG(4,boot.BK.e,80.0,70.0,boot.Bv.EL(1)).EU(60.0).EH(24.0,-2.0);
		boot.Bv.ji.Dy().ED("亡霊の騎兵隊を従え指定地点に突撃し、Hecarimと騎兵に触れた敵ユニットに{1}を与える。指定した地点に到着すると衝撃波を放ち、{2}の敵ユニットに{3}と{4}を与える。Hecarimが指定した地点に到着しても、騎兵隊は常に最大距離まで突撃する。"+boot.BK.hm+"に陥ったユニットは強制的にHecarimから遠ざかるように移動する。この時、Hecarimとの距離に比例して移動速度が変化する。").EG(1,boot.BK.f,100.0,100.0,boot.Bv.EE(0.8)).EA(2,boot.BK.jn,0).EG(3,boot.BK.f,50.0,75.0,boot.Bv.EE(0.4)).EA(4,boot.BK.hm,1).EU(100.0).EH(140.0,-20.0).EJ(1000.0);
		boot.Bv.jj.Dy().Dz("{1}の味方ユニットとTurretは{2}を得る。レベル1、6、11、15でベースの増加HRegが上昇する。").EA(1,boot.BK.jn,800.0).ES(2,boot.BK.bd,new boot.CI(10.0,5.0,0));
		boot.Bv.jk.Dy().ED("指定地点にTurretを設置する。使用時にスタックを消費する。設置後6秒間はTurretの攻撃速度が1.5倍になる。{1}毎にスタックが1つ増加し最大2つまでスタックされる。スタック増加時間はCD低減の影響を受ける。Turretが塔に与えるダメージは半分になる。Debuff(CCのみ)を無効化、Heimerdingerが攻撃するor攻撃されている場合、その対象を優先で攻撃。Lv2.攻撃したユニットに{6}と{7}を与える。この効果は2秒間持続し、50回までスタックする。Lv3.Turretの最大スタック数と設置できる上限が2に増える。Lv4.Turretの最大HP+125。Lv5.50%のスプラッシュダメージが付与される。　HP:{2} ダメージ:{3} 射程:525 AR:{4} MR:{5} AS:1.25 視界:625").EA(1,boot.BK.jk,25.0).EG(2,boot.BK.jm,295.0,0,boot.Bv.ER(boot.BK.gm,15.0)).EG(3,boot.BK.f,30.0,8.0,boot.Bv.EE(0.2)).EG(4,boot.BK.jm,30.0,0,boot.Bv.ER(boot.BK.gm,1)).EG(5,boot.BK.jm,80.0,0,boot.Bv.ER(boot.BK.gm,1)).EA(6,boot.BK.en,1).EA(7,boot.BK.fd,1).EI(70.0,10.0).EV(1).EJ(250.0);
		boot.Bv.jl.Dy().ED("視界内にいる最も近い敵ユニット3体に{1}を与える。").EG(1,boot.BK.f,85.0,50.0,boot.Bv.EE(0.55)).EI(65.0,20.0).EV(10.0).EJ(1000.0);
		boot.Bv.jm.Dy().ED("指定地点に手榴弾を投げ、破裂した{1}にいる敵ユニットに{2}と{3}を与え、真ん中のユニットにはさらに{4}を与える。また指定地点の視界を得る。").EA(1,boot.BK.jn,250.0).EG(2,boot.BK.f,80.0,55.0,boot.Bv.EE(0.6)).EK(3,boot.BK.ho,1,0.5).EA(4,boot.BK.hj,1).EI(80.0,10.0).EH(13.0,-1.0).EJ(925.0);
		boot.Bv.jn.Dy().Dz("{1}を得る。").EK(1,boot.BK.ed,10.0,5.0).ED("設置したTurretのHPが最大まで回復し、10秒間Turretの攻撃に{2}が付与され、Hextech Micro-Rocketsの同時攻撃可能数が5体に増加し、CH-1 Concussion Grenadeの弾速が増加(+250)する。").EK(2,boot.BK.ie,20.0,5.0).EU(90.0).EH(120.0,-15.0);
		boot.Bv.jo.Dy().Dz("Ireliaの視界内(範囲1200)に敵Championがいる数に応じて{1}を得る。効果の上限は最大3人まで。").ES(1,boot.BK.gn,new boot.CG([10.0,25.0,40.0],0)).EC(1);
		boot.Bv.jp.Dy().ED("対象の敵ユニットに突進し、{1}を与える。このスキルで敵を倒したとき、このスキルの{2}されManaが35回復する。").EG(1,boot.BK.e,20.0,30.0,boot.Bv.EP(1)).EO(2,boot.BK.hd).EI(60.0,5.0).EH(14.0,-2.0).EW(boot.CC.f).EJ(650.0);
		boot.Bv.ka.Dy().Dz("通常攻撃を行う度に{1}する。").EK(1,boot.BK.he,5.0,2.0).ED("6秒間通常攻撃に{2}が付与され、PassiveのHP回復量が倍になる。").EK(2,boot.BK.g,15.0,15.0).EU(40.0).EV(15.0);
		boot.Bv.kb.Dy().ED("対象の敵ユニットに{1}を与える。対象の残HP%がIreliaより高かった場合{2}を与え、低かった場合は{4}間{3}を与える。").EK(1,boot.BK.f,80.0,50.0).EK(2,boot.BK.hj,1,0.25).EK(3,boot.BK.ie,60.0,0).EK(4,boot.BK.jj,1,0.25).EI(50.0,5.0).EV(8.0).EJ(425.0);
		boot.Bv.kc.Dy().ED("指定方向に貫通する刃を飛ばし、当たった敵ユニットに{1}を与える。このスキルは15秒の間、4回まで連続して使用できる(但し、一度使用する度に0.5秒のCDが発生する)。2〜4発目はマナコスト無しで使用可能。ミニオンやモンスターにダメージを与えると{2}し、Championにダメージを与えると{3}する。").EQ(1,boot.BK.e,80.0,40.0,boot.Bv.EE(0.5),boot.Bv.EL(0.6)).EG(2,boot.BK.he,0,0,boot.Bv.ER(boot.BK.k,10.0)).EG(3,boot.BK.he,0,0,boot.Bv.ER(boot.BK.k,25.0)).EU(100.0).EH(70.0,-10.0).EJ(1000.0);
		boot.Bv.kd.Dy().Dz("すべての味方Championは{1}する。").EA(1,boot.BK.im,3.0);
		boot.Bv.ke.Dy().ED("指定方向に竜巻を発生させ、触れた敵ユニットに{1}と{2}を与える。竜巻は設置後に再度スキル使用ですぐに飛ばすことができるが、溜めた時間に比例して魔法DM、射程距離、打ち上げ時間が増加する。").EQ(1,boot.BK.f,60.0,25.0,boot.Bv.EE(0.75),boot.Bv.ER(boot.BK.jl,25.0)).EG(2,boot.BK.ib,0.8,0,boot.Bv.ER(boot.BK.jl,0.1)).EI(90.0,15.0).EH(14.0,-1.0).EJ(1100.0);
		boot.Bv.kf.Dy().Dz("{1}し{2}を得る。").EK(1,boot.BK.im,4.0,3.0).EA(2,boot.BK.ja,0).ED("対象の敵ユニットに{3}と3秒間{4}を与える。またこのスキルがCDの間はPassiveの効果が無くなる。").EG(3,boot.BK.f,60.0,55.0,boot.Bv.EE(0.6)).EK(4,boot.BK.ie,24.0,6.0).EI(40.0,10.0).EH(12.0,-1.0).EJ(600.0);
		boot.Bv.kg.Dy().ED("対象の味方Championか塔に5秒間{1}を付与する。シールドが持続している間は対象は{2}を得る。").EG(1,boot.BK.gf,80.0,40.0,boot.Bv.EE(0.9)).EK(2,boot.BK.dc,14.0,9.0).EI(70.0,10.0).EV(10.0).EJ(800.0);
		boot.Bv.kh.Dy().ED("{1}の敵ユニットを{2}して4秒間詠唱する。詠唱中は{1}の味方ユニットは毎秒{3}する。").EA(1,boot.BK.jn,725.0).EA(2,boot.BK.ic,875.0).EG(3,boot.BK.he,70.0,40.0,boot.Bv.EE(0.35)).EI(150.0,75.0).EH(150.0,-15.0);
		boot.Bv.kh.ET(boot.BR.k).EI(100.0,50.0);
		boot.Bv.ki.Dy().Dz("通常攻撃に{1}(最大400DM)が付与される。同一の対象には6秒に一度しか発動しない。レベル1、7、13で追加物理DMの増加値が上昇する。").EG(1,boot.BK.e,0,0,boot.Bv.EZ(boot.BK.ch,new boot.Bz(6.0,2.0,0)));
		boot.Bv.kj.Dy().ED("槍を突き出して直線上の敵ユニットに{1}を与え、3秒間{2}を与える。また、Demacian Standardの旗にヒットした場合、旗の位置まで突進し、進路上の敵ユニットに{3}を与える。").EG(1,boot.BK.e,70.0,45.0,boot.Bv.EL(1.1)).EK(2,boot.BK.eo,10.0,4.0).EA(3,boot.BK.ib,0.75).EI(45.0,5.0).EH(10.0,-1.0).EJ(770.0);
		boot.Bv.kk.Dy().ED("5秒間{1}を付与すると同時に、{2}の敵ユニットに２秒間{3}を与える。").EG(1,boot.BK.gf,50.0,40.0,boot.Bv.EY(boot.BK.kb,20.0,5.0)).EA(2,boot.BK.jn,600.0).EK(3,boot.BK.ie,15.0,5.0).EU(65.0).EH(20.0,-2.0);
		boot.Bv.kl.Dy().Dz("{1}し{2}を得る。").EK(1,boot.BK.di,10.0,3.0).EK(2,boot.BK.ff,10.0,3.0).ED("指定地点に旗を投げ、{3}の敵ユニットに{4}を与える。旗は8秒間その場に残り視界を確保するとともに、{5}の味方ChampionにPassiveの効果を与える。(Jarvan IV自身はPassiveと合わせて倍の効果を受ける)").EA(3,boot.BK.jn,150.0).EG(4,boot.BK.f,60.0,45.0,boot.Bv.EE(0.8)).EA(5,boot.BK.jn,1200.0).EU(55.0).EV(13.0).EJ(830.0);
		boot.Bv.km.Dy().ED("対象の敵Championまで跳躍して{1}を与え、3.5秒間その周囲に通行不可能の円形の地形を作る。再度このスキルを使用すると地形を破壊できる。").EG(1,boot.BK.e,200.0,125.0,boot.Bv.EL(1.5)).EI(100.0,25.0).EH(120.0,-15.0).EJ(650.0);
		boot.Bv.kn.Dy().Dz("通常攻撃を行う度にスタックが1増加し、スタック数に比例して{1}する(最大6スタック)。スタックは2.5秒増加がないと0になる。増加値は3レベル毎に上昇する。").ES(1,boot.BK.di,new boot.CE(4.0,2.0,0)).EC(1);
		boot.Bv.ko.Dy().ED("対象のユニットまで飛びかかる。対象が敵ユニットの場合、{1}を与える。").EQ(1,boot.BK.e,70.0,40.0,boot.Bv.EE(0.6),boot.Bv.EL(1)).EU(65.0).EH(10.0,-1.0).EJ(700.0);
		boot.Bv.kp.Dy().ED("使用後に最初に行った通常攻撃かLeap Strikeに追加{1}を付与する。建物には無効。").EG(1,boot.BK.f,40.0,35.0,boot.Bv.EE(0.6)).EU(30.0).EH(7.0,-1.0);
		boot.Bv.la.Dy().ED("2秒間、Jaxが受けるタワー以外の通常攻撃を無効化し、AoEダメージを25%低減、さらに効果終了時に{1}の敵ユニットに{2}と{3}を与える。スキルを使用してから1秒経つと再使用できるようになり、任意に効果を終了できる。通常攻撃を回避する度にこのスキルのダメージが20%ずつ増加する(上限は100%、最大で2倍ダメージ)。").EA(1,boot.BK.jn,375.0).EG(2,boot.BK.e,50.0,25.0,boot.Bv.EL(0.5)).EA(3,boot.BK.hj,1).EI(70.0,5.0).EH(18.0,-2.0);
		boot.Bv.lb.Dy().Dz("通常攻撃3回目ごとに追加で{1}を与える。建物には無効。").EG(1,boot.BK.f,100.0,60.0,boot.Bv.EE(0.7)).ED("8秒間{2}と{3}を得る。").EG(2,boot.BK.ff,25.0,10.0,boot.Bv.EL(0.3)).EG(3,boot.BK.fj,25.0,10.0,boot.Bv.EE(0.2)).EU(100.0).EV(80.0);
		boot.Bv.lc.Dy().Dz("Transformを使用すると1.25秒の間{1}し、{2}を得る。").EA(1,boot.BK.ik,40.0).EO(2,boot.BK.ja).EC(1);
		boot.Bv.ld.Dy().ED("対象の敵ユニットに飛びかかり、対象と周囲の敵ユニットに{1}と2秒間{2}を与える。").EG(1,boot.BK.e,20.0,45.0,boot.Bv.EL(1)).EK(2,boot.BK.ie,30.0,5.0).EI(40.0,5.0).EH(16.0,-2.0).EJ(600.0);
		boot.Bv.le.Dy().ED("指定方向に雷のオーブを飛ばし、敵ユニットに命中するか一定距離で爆発し、周囲の敵ユニット{1}を与える。オーブがAcceleration Gateによって生成されたゲートを通過した場合、弾速、射程距離、爆発範囲、与えるDMが各40%増加する。{2}").EG(1,boot.BK.e,60.0,55.0,boot.Bv.EL(1.2)).EG(2,boot.BK.e,84.0,77.0,boot.Bv.EL(1.68)).EI(55.0,5.0).EV(8.0).EJ(1050.0);
		boot.Bv.lf.Dy().Dz("通常攻撃ごとに{1}する。").EK(1,boot.BK.hg,6.0,2.0).ED("4秒間雷のオーラを身にまとい、{2}の敵ユニットに毎秒{3}を与える。").EA(2,boot.BK.jn,285.0).EG(3,boot.BK.f,25.0,17.5,boot.Bv.EE(0.25)).EU(40.0).EV(10.0);
		boot.Bv.lg.Dy().ED("Jayceの攻撃速度が最大まで上昇する。3回通常攻撃を行うと効果が解消される。また効果中は通常攻撃で与えるダメージが{1}%になる。").EK(1,boot.BK.kc,70.0,15.0).EU(40.0).EH(14.0,-2.0);
		boot.Bv.lh.Dy().ED("対象の敵ユニットに{1}と短い距離のノックバックを与える。ミニオンやモンスターに対しては{2}が上限。").EQ(1,boot.BK.f,0,0,boot.Bv.EL(1),boot.Bv.EY(boot.BK.cg,8.0,3.0)).EK(2,boot.BK.f,200.0,100.0).EU(40.0).EH(14.0,-1.0).EJ(240.0);
		boot.Bv.li.Dy().ED("4秒間持続するゲート(通りぬけ可能)を生成し、触れた味方ユニットは3秒間{1}する。移動速度は3秒かけて元に戻る。").EK(1,boot.BK.im,30.0,5.0).EU(50.0).EH(14.0,-1.0).EJ(650.0);
		boot.Bv.lj.Dy().ED("Jayceの射程が500(Ranged)になる。また、次の通常攻撃は５秒間{1}と{2}を与える。").EK(1,boot.BK.eo,10.0,5.0).EK(2,boot.BK.fe,10.0,5.0).EV(6.0);
		boot.Bv.lk.Dy().ED("Jayceの射程が125(Melee)になり、その間は{1}と{2}を得る。また、次の通常攻撃に追加{3}を付与する。").EK(1,boot.BK.ff,5.0,10.0).EK(2,boot.BK.fj,5.0,10.0).EK(3,boot.BK.f,20.0,40.0).EV(6.0);
		boot.Bv.ll.Dy().Dz("{1}を得る。レベル1、3、6、9、12、15で最大値が上昇する。").EG(1,boot.BK.ea,0,0,boot.Bv.EZ(boot.BK.cf,new boot.CJ(0.3,0.2,0)));
		boot.Bv.lm.Dy().ED("指定方向扇形60°の{1}の敵ユニットに{2}を与える。Mantra Bonus:自身と効果範囲内の味方ユニットは{3}する。回復量は対象のHP残量によって変化する。").EA(1,boot.BK.jn,600.0).EG(2,boot.BK.f,70.0,40.0,boot.Bv.EE(0.6)).EG(3,boot.BK.he,35.0,20.0,boot.Bv.EM(boot.BK.ce,0.05,0,boot.Bv.EE(0.02))).EI(70.0,5.0).EV(6.0);
		boot.Bv.ln.Dy().ED("対象のユニットと自身を繋ぐビームを発生させる。ビームは5秒間持続し、自身及び味方ユニットは{1}し、敵ユニットには{2}を与える。ビームに触れたChampion(敵味方問わず)にも同様の効果を与え、それが敵ユニットだった場合は更に{3}を与える。ビームを繋ぐ対象がステルス状態または距離1000まで離れた場合、効果が途切れる。Mantra Bonus:MS増加/MS低下の効果が2倍になる。").EK(1,boot.BK.im,10.0,2.0).EK(2,boot.BK.ie,10.0,2.0).EG(3,boot.BK.f,80.0,45.0,boot.Bv.EE(0.7)).EI(65.0,10.0).EH(15.0,-1.0).EJ(800.0);
		boot.Bv.lo.Dy().ED("対象の味方ユニットに5秒間持続する{1}を付与する。Mantra Bonus:味方ユニットにシールドを付与した際、その味方ユニットの{2}にいる敵ユニットに{3}を与える。").EG(1,boot.BK.gf,80.0,40.0,boot.Bv.EE(0.8)).EA(2,boot.BK.jn,600.0).EG(3,boot.BK.f,80.0,40.0,boot.Bv.EE(0.8)).EI(80.0,10.0).EV(10.0).EJ(650.0);
		boot.Bv.lp.Dy().ED("次に使用するスキルにMantra Bonusを付与する。Lv1から使用でき、スキルポイントを割り振ることはできない。{1}毎にスタック数が1つ増加し最大で2つまでスタックされる。スタック増加時間はCD低減の影響を受ける。レベル1、7、13でスタック増加時間が短縮される。").ES(1,boot.BK.jk,new boot.Bz(30.0,-5.0,0)).EV(0.25);
		boot.Bv.ma.Dy().Dz("死亡後7秒間スキルが使用可能。この状態ではスキルコストがなくなる。");
		boot.Bv.mb.Dy().ED("指定地点を0.5秒後に爆発させ{1}の敵ユニットに{2}を与える。対象が1体の場合は{3}を与える。また、指定地点の{4}。").EA(1,boot.BK.jn,100.0).EG(2,boot.BK.f,40.0,20.0,boot.Bv.EE(0.3)).EG(3,boot.BK.f,80.0,40.0,boot.Bv.EE(0.6)).EO(4,boot.BK.jd).EI(20.0,6.0).EV(1).EJ(875.0);
		boot.Bv.mc.Dy().ED("指定地点に{3}の通りぬけ可能な壁を5秒間生成し、触れた敵ユニットに５秒間{1}と{2}を与える。スローの効果は5秒かけて元に戻る。また、指定地点の{4}。").EA(1,boot.BK.fe,15.0).EK(2,boot.BK.ie,40.0,10.0).EK(3,boot.BK.jo,800.0,100.0).EO(4,boot.BK.jd).EU(100.0).EV(18.0).EJ(1000.0);
		boot.Bv.md.Dy().Dz("敵ユニットを倒すと{1}する。").EK(1,boot.BK.hg,20.0,7.0).ED("{2}の敵ユニットに毎秒{3}を与える。").EA(2,boot.BK.jn,550.0).EG(3,boot.BK.f,30.0,20.0,boot.Bv.EE(0.25)).EI(30.0,12.0).EV(0.5).EW(boot.CC.d);
		boot.Bv.me.Dy().ED("3秒詠唱後にすべての敵Championに{1}を与える。").EG(1,boot.BK.f,250.0,150.0,boot.Bv.EE(0.6)).EI(150.0,25.0).EH(200.0,-20.0).EJ(-1.0);
		boot.Bv.mf.Dy().Dz("自身が受ける{1}して、4秒間軽減した分のダメージを攻撃速度(%)に加算する。").EA(1,boot.BK.gc,15.0);
		boot.Bv.mg.Dy().ED("対象の敵ユニットに{1}と{2}を与える。").EG(1,boot.BK.f,80.0,50.0,boot.Bv.EE(0.7)).EK(2,boot.BK.hn,1,0.4).EI(70.0,10.0).EV(9.0).EJ(650.0);
		boot.Bv.mh.Dy().Dz("通常攻撃ごとに{1}する。対象がChampionの場合は{2}する。").EK(1,boot.BK.hg,8.0,3.0).EK(2,boot.BK.hg,16.0,6.0).ED("5秒間、通常攻撃に追加{3}が付与される。建物には無効。").EG(3,boot.BK.f,30.0,15.0,boot.Bv.EE(0.3)).EU(25.0).EV(12.0);
		boot.Bv.mi.Dy().ED("指定方向扇形80°の{1}の敵ユニットに{2}と3秒間{3}を与える。近くのChampion(敵味方自分問わず)がスキルを使用するとスタックが増え、6スタックまで溜まると使用可能。スキル使用時にスタックは0になる。").EA(1,boot.BK.jn,700.0).EG(2,boot.BK.f,80.0,50.0,boot.Bv.EE(0.7)).EK(3,boot.BK.ie,30.0,5.0).EU(80.0).EV(6.0);
		boot.Bv.mj.Dy().ED("指定地点にテレポートし、テレポート先の{1}の敵ユニットに{2}を与える。スキル使用時にスタックが増加し、1スタックごとに消費MNと魔法DMが増加していく。(最大10スタック)スタックは8秒間増加がないと0になる。").EA(1,boot.BK.jn,150.0).EQ(2,boot.BK.f,60.0,10.0,boot.Bv.EE(0.8),boot.Bv.EY(boot.BK.ke,60.0,10.0)).Eu(boot.BK.bg,new boot.CK(100.0,0,1,0),boot.Bv.ER(boot.BK.ke,100.0)).EH(7.0,-1.0).EJ(700.0);
		boot.Bv.mk.Dy().Dz("敵Championキル/アシスト時に、すべてのスキルの{1}する。").EA(1,boot.BK.hd,15.0);
		boot.Bv.ml.Dy().ED("対象の敵ユニットにナイフを飛ばし{1}と４秒間Debuffを与える。ナイフは近くの敵ユニット({2})に4回まで跳ね返り、その度にダメージとDebuffを与える。ナイフが与えるダメージは跳ね返る度に10%低下する。Debuffが付与された敵ユニットにKatarinaが通常攻撃またはスキルでダメージを与えると、付与されたDebuffを消費して{3}を与える。").EG(1,boot.BK.f,60.0,25.0,boot.Bv.EE(0.15)).EA(2,boot.BK.jn,400.0).EG(3,boot.BK.f,15.0,15.0,boot.Bv.EE(0.15)).EH(10.0,-0.5).EJ(675.0);
		boot.Bv.mm.Dy().ED("{1}にいる敵ユニットに{2}を与える。このスキルが敵Championに命中した場合、1秒間{3}する。").EG(2,boot.BK.f,40.0,35.0,boot.Bv.EE(0.25)).EA(1,boot.BK.jn,375.0).EK(3,boot.BK.im,15.0,5.0).EV(4.0);
		boot.Bv.mn.Dy().ED("対象のユニットの後方までワープし、それが敵ユニットの場合は{1}を与える。またこのスキル使用後、Katarinaが受ける{2}する。この効果は1.5秒間持続する。").EG(1,boot.BK.f,60.0,25.0,boot.Bv.EE(0.5)).EA(2,boot.BK.fo,15.0).EH(12.0,-1.5).EJ(700.0);
		boot.Bv.mo.Dy().ED("Katarinaが最大2秒間回転する。その間は0.2秒毎に{2}にいる最も近い敵Champion3体にナイフを連続で飛ばし、都度{1}と3秒間HP回復量-50%を与える。敵一体に与える最大DMは{3}。").EQ(1,boot.BK.f,40.0,10.0,boot.Bv.EE(0.2),boot.Bv.EL(0.3)).EA(2,boot.BK.jn,550.0).EQ(3,boot.BK.f,400.0,100.0,boot.Bv.EE(2.0),boot.Bv.EL(3.0)).EH(60.0,-5.0).EW(boot.CC.e);
		boot.Bv.mp.Dy().Dz("敵Championに通常攻撃を行う度に、{1}と{2}を与える。この効果は5秒間持続し、5回までスタックする。").EA(1,boot.BK.eo,3.0).EA(2,boot.BK.fe,3.0);
		boot.Bv.na.Dy().ED("{4}の光の玉を撃ち対象の敵ユニットに{1}と4秒間{2}を与える。このスキルのスローがかかった敵ユニットに対しては、Kayleが対象のユニットに与える{3}する。").EQ(1,boot.BK.f,60.0,50.0,boot.Bv.EE(1),boot.Bv.EL(1)).EA(2,boot.BK.ie,35.0).EK(3,boot.BK.d,6.0,1).EA(4,boot.BK.ka,1300.0).EI(70.0,5.0).EV(8.0).EJ(650.0);
		boot.Bv.na.ET(boot.BR.k).ED("{4}の光の玉を撃ち対象の敵ユニットに{1}と3秒間{2}、HolyFervorのスタックをひとつ与える。").EK(2,boot.BK.ie,35.0,5.0).EA(4,boot.BK.ka,1500.0);
		boot.Bv.nb.Dy().ED("対象の味方Championは{1}し、3秒間{2}する。").EG(1,boot.BK.he,60.0,45.0,boot.Bv.EE(0.35)).EK(2,boot.BK.im,18.0,3.0).EI(60.0,10.0).EV(15.0).EJ(1000.0);
		boot.Bv.nc.Dy().ED("10秒間Kayleの通常攻撃の射程が525に伸びる(Ranged)。更に通常攻撃に追加{1}が付与され、スプラッシュ効果{2}が付く。塔を攻撃する時はスプラッシュ効果は発生しない。").EQ(1,boot.BK.f,20.0,10.0,boot.Bv.EE(0.4),boot.Bv.EY(boot.BK.dc,0.2,0.05)).EA(2,boot.BK.jn,300.0).EU(45.0).EV(16.0);
		boot.Bv.nd.Dy().ED("対象の味方Championを{1}間無敵(ダメージ無効)にする。").EK(1,boot.BK.jj,2.0,0.5).EI(100.0,-25.0).EH(90.0,-15.0).EJ(1200.0);
		boot.Bv.ne.Dy().Dz("スキルヒット時対象に雷スタックを追加する。スタックが3つ溜まると対象を{1}させ、{2}する。スタックは8秒間増加がないと0になる。同一の敵Championを7秒以内に2度スタンさせると、{3}を与える。").EA(1,boot.BK.hj,1).EA(2,boot.BK.hh,25.0).EA(3,boot.BK.hj,0.5);
		boot.Bv.nf.Dy().ED("指定方向に手裏剣を飛ばし、当たった敵ユニットに{1}と雷スタックを与える。").EG(1,boot.BK.f,75.0,40.0,boot.Bv.EE(0.75)).EH(8.0,-1.0).EJ(900.0).EB(boot.BK.bn,65.0,-5.0);
		boot.Bv.ng.Dy().Dz("5回毎の通常攻撃時に追加{1}と雷スタックを与える効果を追加する。").EG(1,boot.BK.f,0,0,boot.Bv.EP(0.4)).ED("{3}の雷スタックの付与されている敵ユニットに{2}と雷スタックを与える。").EA(3,boot.BK.jn,800.0).EG(2,boot.BK.f,65.0,30.0,boot.Bv.EE(0.55)).EH(14.0,-2.0).EB(boot.BK.bn,45.0,0);
		boot.Bv.nh.Dy().ED("2.5秒間{1}し、{6}を得る。この間は通常攻撃が不可能になり、Kennenに触れた敵ユニットに{2}と雷スタックを与え、一度だけ{3}する。また、このスキルを使用すると4秒間{4}と{5}を得る。Minionに与えるダメージは半分。").EA(1,boot.BK.ik,230.0).EG(2,boot.BK.f,85.0,40.0,boot.Bv.EE(0.6)).EA(3,boot.BK.hh,40.0).EK(4,boot.BK.ff,10.0,10.0).EK(5,boot.BK.fj,10.0,10.0).EO(6,boot.BK.ja).EH(10.0,-1.0).EB(boot.BK.bn,100.0,-5.0);
		boot.Bv.ni.Dy().ED("{1}に嵐を発生させ、{4}間{2}毎に範囲内にいる敵Champion一人をランダムに雷を落とし{3}と雷スタックを与える。同一の対象には3回までヒットし、最大DMは{5}。また、範囲内に複数の対象がいる場合、同一の対象に連続してはヒットしない。雷スタックはヒットする毎に蓄積する。").EA(1,boot.BK.jn,550.0).ES(2,boot.BK.jj,new boot.CG([0.5,0.4,0.33],0)).EG(3,boot.BK.f,80.0,65.0,boot.Bv.EE(0.4)).EK(4,boot.BK.jj,3.0,1).EG(5,boot.BK.f,240.0,195.0,boot.Bv.EE(1.2)).EV(120.0);
		boot.Bv.nj.Dy().Dz("自身が敵チームの視界から消えた時に発動する。次の敵Championに対する通常攻撃かEvolved Void Spikeに追加{1}と2秒間{2}を付与する。この効果は敵チームの視界に現れても効果が消費されるまでは失われない。").Ev(1,boot.BK.f,new boot.CF([15.0,20.0,25.0,35.0,45.0,55.0,65.0,75.0,85.0,95.0,110.0,125.0,140.0,150.0,160.0,170.0,180.0,190.0],0),boot.Bv.EE(0.5),null).EA(2,boot.BK.ie,25.0);
		boot.Bv.nk.Dy().Dz("敵チームの中で孤立している敵ユニットにマークを付与する。").ED("対象の敵ユニットに{1}を与える。マークが付与されている敵ユニットのマークの範囲内に他の敵ユニットがいない場合、{2}を与える。進化すると孤立した敵ユニットに追加{3}を与え、このスキルの射程と通常攻撃の射程が50増加する。").EU(25.0).EG(1,boot.BK.e,70.0,30.0,boot.Bv.EL(1.5)).EG(2,boot.BK.e,100.0,45.0,boot.Bv.EL(2.0)).EG(3,boot.BK.e,0,0,boot.Bv.ER(boot.BK.ci,12.0)).EV(3.5).EJ(325.0);
		boot.Bv.nl.Dy().ED("指定方向に敵ユニットに命中すると爆発する針を発射し、{1}の敵ユニットに{2}を与える。自身が爆発範囲内にいる場合は更に{3}する。進化すると指定方向に対して扇形になるような3方向に針を発射するようになり、また爆発にUnseen Threatの追加魔法DMとスローを付与する。").EI(60.0,10.0).EA(1,boot.BK.jn,0).EG(2,boot.BK.e,75.0,40.0,boot.Bv.EL(0.9)).EG(3,boot.BK.he,40.0,30.0,boot.Bv.EE(0.5)).EV(8.0).EJ(1000.0);
		boot.Bv.nm.Dy().ED("指定地点にジャンプし、{1}の敵ユニットに{2}を与える。進化すると射程が400増加し、またkillやassistを取った場合にこのスキルの{3}する。").EA(1,boot.BK.jn,0).EG(2,boot.BK.e,65.0,35.0,boot.Bv.EL(0.8)).EA(3,boot.BK.hd,0).EU(50.0).EH(22.0,-2.0).EJ(600.0);
		boot.Bv.nn.Dy().Dz("このスキルを取得、またはランクが上がる毎に、いずれかのスキルを選んで進化させることができる。").ED("使用後{2}状態になり、{1}する。この際にUnseen Threatの効果が発動する。また使用後10秒以内であれば、消費mana無しでもう一度だけこのスキルを使用することができる。進化すると10秒以内に再度使用可能な回数が2回に増加し、またステルス状態の間に受けるDMを40%軽減するようになる。").EA(1,boot.BK.im,40.0).EA(2,boot.BK.jc,1).EU(100.0).EV(3.0);
		boot.Bv.no.Dy().Dz("死亡すると4秒後に自爆して周囲の敵ユニットに{1}を与える。自爆するまでの間は徐々に移動速度が増加する(最大時40%増加)。").EG(1,boot.BK.g,100.0,0,boot.Bv.ER(boot.BK.gm,25.0));
		boot.Bv.np.Dy().Dz("{1}する。").EK(1,boot.BK.di,10.0,5.0).ED("対象の敵ユニットに{2}を与え、4秒間{3}と{4}を与える。").EG(2,boot.BK.f,60.0,50.0,boot.Bv.EE(0.7)).EK(3,boot.BK.en,5.0,5.0).EK(4,boot.BK.fd,5.0,5.0).EU(60.0).EV(8.0).EJ(625.0);
		boot.Bv.oa.Dy().ED("8秒間通常攻撃の射程が{1}増加し、通常攻撃時に{2}を追加で与える。").EK(1,boot.BK.gj,130.0,20.0).EG(2,boot.BK.f,0,0,boot.Bv.EM(boot.BK.cg,2.0,1,boot.Bv.EE(0.01))).EU(50.0).EV(17.0).EX(130.0,20.0);
		boot.Bv.ob.Dy().ED("指定方向に貫通する弾を発射し、当たった敵ユニットに{1}を与える。弾の通過点に4秒間持続する液体が残り、その上にいる敵ユニットに{2}を与える。").EG(1,boot.BK.f,60.0,50.0,boot.Bv.EE(0.7)).EK(2,boot.BK.ie,20.0,8.0).EI(80.0,10.0).EV(12.0).EJ(1400.0);
		boot.Bv.oc.Dy().ED("指定地点を砲撃し、{1}の敵ユニットに{2}を敵Championには{3}を与え、4秒間そのユニットの視界を得る。このスキルを使うたびにスタックが増加し、1スタックにつきこのスキルの消費マナが40ずつ増加していく。スタックは6秒間持続する。").EA(1,boot.BK.jn,200.0).EQ(2,boot.BK.f,80.0,40.0,boot.Bv.EE(0.3),boot.Bv.EL(0.5)).EQ(3,boot.BK.f,180.0,90.0,boot.Bv.EE(0.3),boot.Bv.EL(0.5)).Eu(boot.BK.bg,new boot.CK(40.0,0,1,0),boot.Bv.ER(boot.BK.ke,40.0)).EH(2.0,-0.5).EX(1400.0,300.0);
		boot.Bv.od.Dy().Dz("HPが40%以下になったとき0.5秒間ステルス状態になり、自分の分身を作り出す。分身は8秒間持続し、分身が敵にダメージを与えることはできない。").EV(60.0);
		boot.Bv.oe.Dy().ED("対象の敵ユニットに{1}と3.5秒間持続するマークを付与する。マークが付いている間に再度スキルでダメージを与えると、マークを消費して追加{2}と{3}を付与する。").EG(1,boot.BK.f,70.0,40.0,boot.Bv.EE(0.6)).EG(2,boot.BK.f,20.0,20.0,boot.Bv.EE(0.3)).EA(3,boot.BK.hn,2.0).EI(70.0,5.0).EV(6.0).EJ(700.0);
		boot.Bv.of.Dy().ED("指定地点まで高速で移動し、移動先の{1}にいる敵ユニットに{2}を与える。3秒間以内にもう一度このスキルを使用すると元居た地点に戻る。").EA(1,boot.BK.jn,250.0).EG(2,boot.BK.f,85.0,40.0,boot.Bv.EE(0.6)).EI(80.0,5.0).EH(18.0,-2.0).EJ(600.0);
		boot.Bv.og.Dy().ED("指定方向に鎖を放ち、当たった敵ユニットに{1}と2秒間{2}を与え対象と鎖で繋がれる。2秒間対象が鎖の範囲内(範囲1000)に留まっていた場合、対象に追加{3}と{4}を与える。").EG(1,boot.BK.f,40.0,25.0,boot.Bv.EE(0.5)).EA(2,boot.BK.ie,25.0).EG(3,boot.BK.f,40.0,25.0,boot.Bv.EE(0.5)).EK(4,boot.BK.hk,1,0.3).EU(80.0).EV(10.0).EJ(950.0);
		boot.Bv.oh.Dy().ED("直前に使ったスキルを、威力を{1}増した状態で再使用する。Distortionとして使用した場合、それぞれDistortionとDistortion:Mimicを使用した地点に戻る事ができる。").EK(1,boot.BK.kc,10.0,15.0).EI(100.0,-50.0).EH(40.0,-8.0);
		boot.Bv.oi.Dy().Dz("スキルを使用すると{1}し通常攻撃の度に{2}する。この効果は3秒経つか2回通常攻撃を行うと解消される。").EA(1,boot.BK.di,40.0).EA(2,boot.BK.hh,15.0).EC(1);
		boot.Bv.oj.Dy().ED("指定方向に気を飛ばし当たった敵ユニットに{1}を与える。このスキルが敵ユニットに当たった場合、3秒間Resonating Strikeが使用可能になる。また3秒間対象の視界を得る。").EG(1,boot.BK.e,50.0,30.0,boot.Bv.EL(0.9)).EH(11.0,-1.0).EJ(975.0).EB(boot.BK.bn,50.0,0);
		boot.Bv.ok.Dy().ED("Sonic Waveが当たった敵ユニットにダッシュし、{1}を与える。(追加ダメージはMinionに対して400DMが上限)").EQ(1,boot.BK.e,50.0,0,boot.Bv.EL(0.5),boot.Bv.ER(boot.BK.ci,8.0)).EB(boot.BK.bn,30.0,0).EJ(1100.0);
		boot.Bv.ol.Dy().ED("対象の味方ユニットまで移動し、対象と自身に{1}を付与する。自身を対象とした場合はシールドのみが付与される。").EG(1,boot.BK.gf,40.0,40.0,boot.Bv.EE(0.8)).EV(9.0).EB(boot.BK.bn,50.0,0).EJ(700.0);
		boot.Bv.om.Dy().ED("5秒間{1}と{2}を得る。").EK(1,boot.BK.dj,5.0,5.0).EK(2,boot.BK.eg,5.0,5.0).EB(boot.BK.bn,30.0,0);
		boot.Bv.on.Dy().ED("{1}の敵ユニットに{2}を与え、4秒間そのユニットの{3}。このスキルが敵ユニットに当たった場合、3秒間Crippleが使用可能になる。").EA(1,boot.BK.jn,450.0).EG(2,boot.BK.f,60.0,35.0,boot.Bv.EL(1)).EO(3,boot.BK.jd).EV(10.0).EB(boot.BK.bn,50.0,0);
		boot.Bv.oo.Dy().ED("Tempestが当たった敵ユニット４秒間{1}と{2}を与える。これらの速度低下は時間と共に戻っていく。").EK(1,boot.BK.ie,20.0,10.0).EK(2,boot.BK.ih,20.0,10.0);
		boot.Bv.op.Dy().ED("対象の敵Championに{1}を与え、{2}させる。ノックバックした対象に触れた敵ユニットにも{1}を与え、{3}を与える。").EG(1,boot.BK.e,200.0,200.0,boot.Bv.EL(2.0)).EA(2,boot.BK.ic,1200.0).EA(3,boot.BK.ib,0).EH(90.0,-15.0).EJ(375.0);
		boot.Bv.pa.Dy().Dz("スキルでダメージを与えた敵ユニットに、3.5秒間持続するDebuffを付与する。この敵ユニットに対してLeona以外の味方Championがダメージを与えると、付与されたDebuffを消費して追加{1}を与える。追加魔法DMは2レベル毎に増加する。").ES(1,boot.BK.f,new boot.CH(20.0,15.0,0));
		boot.Bv.pb.Dy().ED("次の通常攻撃に追加{1}と{2}が付与される。").EG(1,boot.BK.f,40.0,30.0,boot.Bv.EE(0.3)).EA(2,boot.BK.hj,1.25).EI(45.0,5.0).EH(11.0,-1.0);
		boot.Bv.pc.Dy().ED("3秒間{1}と{2}を得て、効果終了時に{3}の敵ユニットに{4}を与える。魔法DMが敵ユニットに命中した場合、ARとMR増加の効果時間が3秒延長される。").EK(1,boot.BK.ff,30.0,10.0).EK(2,boot.BK.fj,30.0,10.0).EA(3,boot.BK.jn,450.0).EG(4,boot.BK.f,60.0,50.0,boot.Bv.EE(0.4)).EU(60.0).EV(14.0);
		boot.Bv.pd.Dy().ED("指定方向に貫通するエネルギーを飛ばし当たった敵ユニットに{1}を与える。このスキルが敵Championに命中した場合、その敵Championの元までLeonaが移動する。また移動中は対象の敵ChampionにSnareを与える。複数の敵Championに命中した場合は最後に命中した敵Championの元に移動する。").EG(1,boot.BK.f,60.0,40.0,boot.Bv.EE(0.4)).EU(60.0).EH(13.0,-1.0).EJ(875.0);
		boot.Bv.pe.Dy().ED("わずかな間をおいて、指定地点を中心として{1}の敵ユニットに{2}を、{5}の敵ユニットに1.5秒間{3}を、{6}の敵ユニットに{4}を与える。").EA(1,boot.BK.jn,125.0).EG(2,boot.BK.f,150.0,100.0,boot.Bv.EE(0.8)).EA(5,boot.BK.jn,350.0).EA(3,boot.BK.ie,80.0).EA(6,boot.BK.jn,50.0).EA(4,boot.BK.hj,1.5).EI(100.0,50.0).EH(90.0,-15.0).EJ(1200.0);
		boot.Bv.pf.Dy().Dz("Pixという妖精がお供になる。Pixが付いている味方Championが通常攻撃を行った場合、Pixは同一の敵ユニットの方向に3発の弾を放ち1発毎に{1}を与える。この弾は敵ユニットを追尾するが、弾の進行方向上にいる敵ユニットにも当たる。建物を攻撃した場合はPixは弾を撃たない。").EG(1,boot.BK.f,1,0,boot.Bv.ER(boot.BK.gm,2.0));
		boot.Bv.pg.Dy().ED("指定方向に貫通するエネルギーを発射し当たった敵ユニットに{1}と{2}間{3}を与える。スローの効果は時間と共に元に戻る。またPixがいる位置からもこのスキルが発射される(Pixが放つ方向はPixから見て指定した地点)。同一の対象に2回ヒットはしない。").EG(1,boot.BK.f,80.0,45.0,boot.Bv.EE(0.5)).EK(2,boot.BK.jj,1,0.25).EA(3,boot.BK.ie,80.0).EI(40.0,10.0).EV(7.0).EJ(925.0);
		boot.Bv.ph.Dy().ED("対象の味方Championに使用した場合、5秒間対象の味方Championは{1}し{2}を得る。敵Championに使用した場合、{3}間無力な動物に変化させ(Polymorph)、その間通常攻撃とスキルを封じ、基本移動速度を60下げる。").EA(1,boot.BK.im,35.0).EK(2,boot.BK.ea,20.0,10.0).EK(3,boot.BK.jj,1.5,0.25).EI(65.0,5.0).EH(18.0,-1.5).EJ(650.0);
		boot.Bv.pi.Dy().ED("対象の味方ユニットに使用した場合、6秒間対象の味方ユニットにPixを付けると同時に{1}を付与する。敵ユニットに使用した場合、Pixが敵ユニットに付くと同時に{2}を与え、6秒間その敵ユニットの{3}。").EG(1,boot.BK.gf,60.0,45.0,boot.Bv.EE(0.6)).EG(2,boot.BK.f,80.0,50.0,boot.Bv.EE(0.6)).EO(3,boot.BK.jd).EI(60.0,10.0).EV(10.0).EJ(650.0);
		boot.Bv.pj.Dy().ED("対象の味方Championを7秒間巨大化させ、同時に対象の{3}の敵ユニットに{1}を与える。巨大化した味方Championは{2}を得て、{3}の敵ユニットに継続的に{4}を与える。スローの効果は範囲内から出ても1秒間持続する。").EA(1,boot.BK.ib,1.5).EG(2,boot.BK.p,300.0,150.0,boot.Bv.EE(0.5)).EA(3,boot.BK.jn,0).EK(4,boot.BK.ie,30.0,15.0).EU(150.0).EH(110.0,-15.0).EJ(900.0);
		boot.Bv.pk.Dy().Dz("スキルでダメージを与えた敵ユニットに6秒間持続するDebuffを付与する。この敵ユニットに対して通常攻撃かFinal Sparkでダメージを与えると、付与されたDebuffを消費して追加{1}を与える。").EG(1,boot.BK.f,10.0,0,boot.Bv.ER(boot.BK.gm,10.0));
		boot.Bv.pl.Dy().ED("指定方向に光の玉を飛ばし、当たった敵ユニットに{1}と{2}を与える。光の玉は一度だけ敵ユニットを貫通し、2体目のユニットには{3}と{4}を与える。").EG(1,boot.BK.f,60.0,50.0,boot.Bv.EE(0.7)).EA(2,boot.BK.hk,2.0).EG(3,boot.BK.f,50.0,25.0,boot.Bv.EE(0.35)).EA(4,boot.BK.hk,1).EI(50.0,10.0).EH(15.0,-1.0).EJ(1175.0);
		boot.Bv.pm.Dy().ED("指定方向に杖を投げ、自身と当たった味方Championに{1}を付与する。行きと帰りそれぞれに判定があり、シールドは3秒間持続する。").EG(1,boot.BK.gf,80.0,25.0,boot.Bv.EE(0.35)).EU(60.0).EH(14.0,-1.0).EJ(1000.0);
		boot.Bv.pn.Dy().ED("指定地点に光の玉を設置し、{1}の敵ユニットに{2}を与える。光の玉は5秒経つか再度スキルを使用する事で爆発し、{1}の敵ユニットに{3}を与える。光の玉は{4}。").EA(1,boot.BK.jn,350.0).EK(2,boot.BK.ie,20.0,4.0).EG(3,boot.BK.f,60.0,45.0,boot.Bv.EE(0.6)).EO(4,boot.BK.jd).EI(70.0,15.0).EV(10.0).EJ(1100.0);
		boot.Bv.po.Dy().ED("1秒詠唱後、指定方向の直線状にいるすべての敵ユニットに{1}を与える。また効果範囲内の視界を確保する。Hitした敵がIlluminationのデバフを受けていた場合はその分の追加ダメージを与えたうえ、新たにIlluminationのデバフを与える。").EG(1,boot.BK.f,300.0,100.0,boot.Bv.EE(0.75)).EU(100.0).EH(80.0,-20.0).EJ(3000.0);
		boot.Bv.pp.Dy().Dz("10秒間ダメージを受けないと{1}を得る。").EG(1,boot.BK.gf,0,0,boot.Bv.ER(boot.BK.p,0.1));
		boot.Bv.baa.Dy().ED("対象の敵ユニットに{1}と4秒間{2}を与える。また、このスキルで減少させた移動速度を自身の移動速度に加算する。移動速度増加は4秒間持続する。").EG(1,boot.BK.f,70.0,50.0,boot.Bv.EE(0.6)).EK(2,boot.BK.ie,14.0,3.0).EI(70.0,5.0).EV(8.0).EJ(625.0);
		boot.Bv.bab.Dy().Dz("通常攻撃時に対象の{1}にいる敵ユニットに{2}を与える。建物を攻撃する際にはスプラッシュ効果は発生しない。").EA(1,boot.BK.jn,200.0).EG(2,boot.BK.e,0,0,boot.Bv.EY(boot.BK.dc,0.3,0.08)).ED("6秒間{3}、{4}する。").EK(3,boot.BK.de,20.0,5.0).EK(4,boot.BK.fh,20.0,5.0).EI(50.0,5.0).EV(14.0);
		boot.Bv.bac.Dy().ED("{1}の敵ユニットに{2}と3秒間{3}を与える。").EA(1,boot.BK.jn,400.0).EQ(2,boot.BK.f,60.0,40.0,boot.Bv.EE(0.2),boot.Bv.ER(boot.BK.ff,0.3)).EK(3,boot.BK.ih,30.0,5.0).EI(50.0,5.0).EV(7.0);
		boot.Bv.bad.Dy().ED("指定地点に突撃し{1}の敵ユニットに{2}を与えると共に{3}後、{4}を与える。").EA(1,boot.BK.jn,325.0).EG(2,boot.BK.f,200.0,100.0,boot.Bv.EE(1)).EA(3,boot.BK.ib,1).EA(4,boot.BK.hj,0.5).EU(100.0).EH(130.0,-15.0).EJ(1000.0);
		boot.Bv.bae.Dy().Dz("スキルを4回使う度にVoidlingを召喚する。Voidlingは21秒間持続し、また召喚から7秒後にDMとARが1.5倍、14秒後にASが2倍に増加する。「Voidling」最大HP: {1} 通常攻撃DM: {2} AR: 30 MR: 50 AS: 0.831 MS: 451【備考】任意の操作不可。攻撃する優先順位は、Ultを掛けた相手、Malefic Visionsを掛けた相手、Malzaharがターゲットしている相手の順。").EG(1,boot.BK.jm,200.0,0,boot.Bv.ER(boot.BK.gm,40.0)).EQ(2,boot.BK.jm,20.0,0,boot.Bv.ER(boot.BK.gm,5.0),boot.Bv.EL(1));
		boot.Bv.baf.Dy().ED("指定した地点の左右から挟み込む様に2本の波動が出現し、当たった敵ユニットに{1}と{2}を与える。また、指定した場所の視界を得る。").EG(1,boot.BK.f,80.0,55.0,boot.Bv.EE(0.8)).EK(2,boot.BK.hn,1.4,0.4).EI(80.0,10.0).EV(9.0).EJ(900.0);
		boot.Bv.bag.Dy().ED("指定地点に5秒間持続する{1}のダメージゾーンを発生させ、上にいる敵ユニットに毎秒{2}を与える。(Minionに対しては毎秒120DMが上限)").EA(1,boot.BK.jn,250.0).EG(2,boot.BK.f,0,0,boot.Bv.EM(boot.BK.cg,4.0,1,boot.Bv.EE(0.01))).EI(90.0,10.0).EV(14.0).EJ(800.0);
		boot.Bv.bah.Dy().ED("対象の敵ユニットに4秒かけて{1}を与える。効果中に敵ユニットが死亡した場合、{2}し、近くの敵ユニットに効果が移り変わる。移る度に4秒のタイマーはリセットされる。").EG(1,boot.BK.f,80.0,60.0,boot.Bv.EE(0.8)).EK(2,boot.BK.hg,10.0,4.0).EI(60.0,15.0).EH(15.0,-2.0).EJ(650.0);
		boot.Bv.bai.Dy().ED("対象の敵Championに2.5秒かけて{1}と{2}を与える。ダメージは0.5秒毎に計5回の判定がある。").EG(1,boot.BK.f,250.0,150.0,boot.Bv.EE(1.3)).EA(2,boot.BK.ia,2.5).EU(150.0).EH(120.0,-20.0).EJ(700.0).EW(boot.CC.e);
		boot.Bv.baj.Dy().Dz("近くのChampion(敵味方自分問わず)がスキルを使用するとスタックが増え、5スタックまで溜まった状態で通常攻撃を行うと{1}する。このスキル発動時にスタックは0になる。建物を攻撃した場合は発動しない。").EG(1,boot.BK.he,0,0,boot.Bv.ER(boot.BK.p,0.07));
		boot.Bv.bak.Dy().ED("{1}の敵ユニットと指定方向の敵ユニットに{2}と2秒間{3}を与える。{4}の敵ユニットには更に{5}を与える。").EA(1,boot.BK.jn,0).EG(2,boot.BK.f,70.0,45.0,boot.Bv.EE(0.4)).EK(3,boot.BK.ie,20.0,7.0).EA(4,boot.BK.jn,200.0).EA(5,boot.BK.ic,0).EU(55.0).EV(6.0).EJ(700.0);
		boot.Bv.bal.Dy().ED("対象の敵ユニットまで高速移動し{1}と{2}を与える。").EG(1,boot.BK.f,80.0,35.0,boot.Bv.EE(0.8)).EK(2,boot.BK.hk,1,0.25).EI(75.0,5.0).EV(13.0).EJ(650.0);
		boot.Bv.bam.Dy().ED("指定地点に苗木を投げ、{1}の敵ユニットに{2}を与える。苗木は最大35秒間その場で待機し、敵ユニットが近付く({4})と相手に向かって移動を開始する、敵に接触するか数秒経つと爆発して{1}に{3}を与える。").EA(1,boot.BK.jn,350.0).EG(2,boot.BK.f,40.0,35.0,boot.Bv.EE(0.4)).EG(3,boot.BK.f,80.0,50.0,boot.Bv.EE(0.6)).EA(4,boot.BK.jn,500.0).EI(70.0,10.0).EV(12.0).EJ(1100.0);
		boot.Bv.ban.Dy().Dz("指定地点の{1}にシールドを展開し、範囲内の味方Championが受けるダメージを20%低減させる(タワーからの攻撃以外)。解除すると範囲内の敵ユニットに{2}を与える。低減したダメージ量に比例して与えるダメージが増加する。").EA(1,boot.BK.jn,0).EG(2,boot.BK.f,100.0,50.0,boot.Bv.EE(0.5)).EU(75.0).EH(40.0,-10.0).EJ(575.0);
		boot.Bv.bao.Dy().Dz("通常攻撃7回毎に2回分ダメージを与える。対象が建物の場合も有効。");
		boot.Bv.bap.Dy().ED("対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え、対象の近くにワープする。minionの場合は50%の確率で追加{3}を与える。").EA(1,boot.BK.jn,600.0).EG(2,boot.BK.f,100.0,50.0,boot.Bv.EE(1)).EK(3,boot.BK.f,260.0,60.0).EI(60.0,10.0).EH(18.0,-2.0).EJ(600.0);
		boot.Bv.bba.Dy().ED("5秒間詠唱を行い、毎秒{1}し、詠唱中は{2}と{3}を得る。").EG(1,boot.BK.he,40.0,30.0,boot.Bv.EE(0.4)).EK(2,boot.BK.ff,100.0,50.0).EK(3,boot.BK.fj,100.0,50.0).EI(50.0,15.0).EV(35.0).EW(boot.CC.e);
		boot.Bv.bbb.Dy().Dz("{1}を得る。").EK(1,boot.BK.dc,15.0,5.0).ED("10秒間{2}を得る。CDが解消されるまでPassiveの増加ダメージがなくなる。").EK(2,boot.BK.dc,30.0,10.0).EU(40.0).EH(25.0,-2.0);
		boot.Bv.bbc.Dy().ED("{4}間{1}、{2}し、{3}を得る。効果中に敵Championを倒すとすべてのスキルの{5}する。").EA(1,boot.BK.im,40.0).EA(2,boot.BK.di,40.0).EO(3,boot.BK.ip).EK(4,boot.BK.jj,8.0,2.0).EO(5,boot.BK.hd).EU(100.0).EV(75.0);
		boot.Bv.bbd.Dy().Dz("5秒間ダメージを受けないと{1}する。以後、毎秒移動速度が9ずつ上昇し、5秒後に移動速度上昇値は上限の70に到達する。ダメージを受けると解除される。").EA(1,boot.BK.ik,25.0).EC(1);
		boot.Bv.bbe.Dy().ED("対象の敵ユニットに弾丸を飛ばし{1}を与える。弾は一度だけ跳ね返り、背後にいる敵ユニット一体(範囲500)を対象とし{2}を与える。").EG(1,boot.BK.e,25.0,35.0,boot.Bv.EP(0.75)).EG(2,boot.BK.e,30.0,42.0,boot.Bv.EP(0.9)).EI(70.0,5.0).EH(9.0,-1.0).EJ(625.0);
		boot.Bv.bbf.Dy().Dz("通常攻撃に{1}を与え、対象にスタックを付与する。1スタックにつき追加魔法DMが倍増していく。スタックは最大4スタック(最大4倍ダメージ)で5秒間持続する。").EG(1,boot.BK.f,6.0,2.0,boot.Bv.EE(0.05)).ED("6秒間{2}し、通常攻撃に{3}を付加する。").EK(2,boot.BK.di,30.0,5.0).EA(3,boot.BK.ii,3.0).EU(50.0).EV(16.0);
		boot.Bv.bbg.Dy().ED("地点を指定した0.5秒後に2秒間銃弾の雨を降らし、{1}の敵ユニットに{2}と1秒間{3}を与える。").EA(1,boot.BK.jn,400.0).EG(2,boot.BK.f,90.0,55.0,boot.Bv.EE(0.8)).EK(3,boot.BK.ie,20.0,8.0).EU(80.0).EV(15.0).EJ(800.0);
		boot.Bv.bbh.Dy().ED("指定方向扇形の範囲に2秒間、弾幕砲火を浴びせて範囲内の敵ユニットに{1}を与える。弾は0.25秒毎に一発発射され、同一の対象に8回までヒットする。最大で{2}。").EQ(1,boot.BK.e,65.0,30.0,boot.Bv.EE(0.2),boot.Bv.EL(0.35)).EQ(2,boot.BK.e,520.0,240.0,boot.Bv.EE(1.6),boot.Bv.EL(2.8)).EU(100.0).EH(120.0,-10.0).EJ(1400.0).EW(boot.CC.e);
		boot.Bv.bbi.Dy().Dz("スキルで与えたダメージの17.5%(Championに対しては35%)をシールドに変換して(最大で{1})受けたダメージはHPより先にシールドがくらってくれる。1秒毎に3%ずつ低下していく。").EG(1,boot.BK.gf,90.0,0,boot.Bv.ER(boot.BK.gm,30.0));
		boot.Bv.bbj.Dy().ED("次に行う通常攻撃が{1}になり、更に近くの敵ユニット3体({2})にもダメージを与える。対象が1体だけの場合は{3}与える。").EQ(1,boot.BK.f,80.0,30.0,boot.Bv.EE(0.4),boot.Bv.EL(1)).EA(2,boot.BK.jn,600.0).EQ(3,boot.BK.f,132.0,49.5,boot.Bv.EE(0.66),boot.Bv.EL(1.65)).EH(8.0,-1.0).EB(boot.BK.p,20.0,5.0);
		boot.Bv.bbk.Dy().ED("対象の味方ユニットに6秒間持続するシールドを付与する。付与されたユニットは{1}と{2}を得て、{3}の敵ユニットに毎秒{4}を与える。").EK(1,boot.BK.ff,10.0,5.0).EK(2,boot.BK.fj,10.0,5.0).EA(3,boot.BK.jn,250.0).EG(4,boot.BK.f,24.0,12.0,boot.Bv.EE(0.2)).EH(20.0,-2.0).EJ(750.0).EB(boot.BK.p,26.0,6.0);
		boot.Bv.bbl.Dy().ED("指定方向扇形の範囲内の敵ユニットに{1}を与える。").EG(1,boot.BK.f,70.0,45.0,boot.Bv.EE(0.6)).EV(6.0).EJ(700.0).EB(boot.BK.p,24.0,12.0);
		boot.Bv.bbm.Dy().ED("対象の敵Championに{1}を与え、その後10秒間、毎秒{2}を与える。10秒間で総計{4}を与え、{3}する。効果中に対象が死ぬとThe Spiritを生成し30秒間従わせる。(RまたはALT押しながらクリックで任意の操作可能)　The Spirit AD: 元になったChampのAD + MordekaiserのADの75%AP: 元になったChampのAP + MordekaiserのAPの75%HP: 元になったChampのHP + MordekaiserのHPの15%行動範囲: 1125 また、The Spiritを従えている間、Mordekaiserは元になったChampのADとAPの20％を得る。").EG(1,boot.BK.f,0,0,boot.Bv.EM(boot.BK.cg,12.0,2.5,boot.Bv.EE(0.02))).EG(2,boot.BK.f,0,0,boot.Bv.EM(boot.BK.cg,1.2,0.25,boot.Bv.EE(0.002))).EG(3,boot.BK.he,0,0,boot.Bv.ER(boot.BK.k,100.0)).EG(4,boot.BK.f,0,0,boot.Bv.EM(boot.BK.cg,24.0,5.0,boot.Bv.EE(0.04))).EH(120.0,-15.0).EJ(850.0);
		boot.Bv.bbn.Dy().Dz("{1}を得る。レベル1、7、13で増加値が上昇する。").ES(1,boot.BK.eg,new boot.Bz(10.0,5.0,0));
		boot.Bv.bbo.Dy().ED("指定方向に魔法弾を飛ばし、当たった敵ユニットに{1}と{2}を与える。").EG(1,boot.BK.f,80.0,55.0,boot.Bv.EE(0.9)).EK(2,boot.BK.hk,2.0,0.25).EI(60.0,15.0).EV(11.0).EJ(1300.0);
		boot.Bv.bbp.Dy().ED("指定地点に5秒間持続する黒い沼({3})を発生させ、上にいる敵ユニットに毎秒{1}と{2}を与える。MR低下は2秒間持続し、5回までスタックする。").EG(1,boot.BK.f,25.0,15.0,boot.Bv.EE(0.2)).EK(2,boot.BK.fd,4.0,1).EA(3,boot.BK.jn,350.0).EI(70.0,15.0).EV(10.0).EJ(900.0);
		boot.Bv.bca.Dy().ED("対象の味方Championは5秒間{1}と{2}を得る。").EG(1,boot.BK.gh,95.0,65.0,boot.Bv.EE(0.7)).EO(2,boot.BK.jb).EU(50.0).EH(23.0,-2.0).EJ(750.0);
		boot.Bv.bcb.Dy().ED("周囲の敵Championに{1}と３秒間{2}を与え対象と糸で繋がれる。3秒間対象が糸の範囲内({3})に留まっていた場合、対象に{1}と{4}を与える。").EG(1,boot.BK.f,175.0,75.0,boot.Bv.EE(0.7)).EA(2,boot.BK.ie,20.0).EA(3,boot.BK.jn,1000.0).EA(4,boot.BK.hj,1.5).EI(100.0,50.0).EH(120.0,-10.0).EJ(600.0);
		boot.Bv.bcc.Dy().Dz("スキルが味方Championに命中した際に、対象は1.5秒間{1}する。レベル1/7/13で増加量が上昇する。").ES(1,boot.BK.ik,new boot.Bz(40.0,5.0,0)).EC(1);
		boot.Bv.bcd.Dy().ED("指定地点に泡を投げ、範囲内の敵ユニットに{1}と{2}を与える。").EG(1,boot.BK.f,75.0,55.0,boot.Bv.EE(0.65)).EA(2,boot.BK.hj,1.25).EU(60.0).EH(14.0,-1.0).EJ(875.0);
		boot.Bv.bce.Dy().ED("対象の味方Championまたは敵Championに、Championにのみ3回まで跳ね返る({3})水流を発射する。水流が味方Championに命中した場合は{1}し、敵Championに命中した場合は{2}を与える。水流は同一のChampionには一度しか跳ね返らず、味方Championに命中した場合は一番近くの敵Championに、敵Championに命中した場合は一番近くの味方Championに跳ね返る。").EG(1,boot.BK.he,65.0,30.0,boot.Bv.EE(0.3)).EG(2,boot.BK.f,70.0,40.0,boot.Bv.EE(0.5)).EA(3,boot.BK.jn,875.0).EI(70.0,15.0).EV(9.0).EJ(725.0);
		boot.Bv.bcf.Dy().ED("対象の味方Championの通常攻撃に{1}と1秒間の{2}を付与する。この効果は5秒経つか3回通常攻撃を行うと解消される。").EG(1,boot.BK.f,25.0,15.0,boot.Bv.EE(0.2)).EK(2,boot.BK.ie,15.0,5.0).EI(55.0,5.0).EV(11.0).EJ(800.0);
		boot.Bv.bcg.Dy().ED("指定方向に津波を発生させ、命中した敵ユニットに{1}と{2}を与えた後2～4秒間{3}与える。スローの効果時間は当たるまでの津波の移動距離に比例して効果時間が長くなる。").EA(1,boot.BK.ib,1).EG(2,boot.BK.f,150.0,100.0,boot.Bv.EE(0.7)).EK(3,boot.BK.ie,50.0,10.0).EI(100.0,50.0).EH(140.0,-20.0).EJ(2550.0);
		boot.Bv.bch.Dy().Dz("{1}を得る。レベル1、7、13で増加値が上昇する。").ES(1,boot.BK.dj,new boot.Bz(14.0,3.0,0));
		boot.Bv.bci.Dy().ED("次に行う通常攻撃に{1}を付与する。このスキルを使用しLHをとると増加ダメージが+3されていく。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+6)になる。").EG(1,boot.BK.e,30.0,20.0,boot.Bv.ER(boot.BK.ke,3.0)).EI(20.0,5.0).EH(8.0,-1.0);
		boot.Bv.bcj.Dy().ED("対象の敵Championに5秒間{1}と{2}を与える。").EG(1,boot.BK.ih,35.0,0,boot.Bv.EY(boot.BK.jl,3.0,3.0)).EG(2,boot.BK.ie,35.0,0,boot.Bv.EY(boot.BK.jl,3.0,3.0)).EU(80.0).EH(15.0,-1.0).EJ(700.0);
		boot.Bv.bck.Dy().ED("指定地点に魔法陣を呼び出し{1}の敵ユニットに{2}を与える。魔方陣は5秒間持続し、上にいる敵ユニットに{3}と毎秒{4}を与える。").EA(1,boot.BK.jn,400.0).EG(2,boot.BK.f,55.0,40.0,boot.Bv.EE(0.6)).EK(3,boot.BK.en,20.0,5.0).EG(4,boot.BK.f,11.0,8.0,boot.Bv.EE(0.12)).EI(70.0,15.0).EV(12.0).EJ(650.0);
		boot.Bv.bcl.Dy().ED("15秒間自身の周りに砂嵐を発生させ{1}増加し、周囲の敵ユニットに毎秒{2}を与える。また効果中はこのスキルで与えたダメージの5%を自身の攻撃力に加える。毎秒ダメージの上限は240、増加攻撃力の上限は300。").EK(1,boot.BK.p,300.0,150.0).EG(2,boot.BK.f,0,0,boot.Bv.EM(boot.BK.cg,3.0,1,boot.Bv.EE(0.01))).EU(150.0).EV(120.0);
		boot.Bv.bcm.Dy().Dz("通常攻撃に{1}と{2}が付与される。同一の対象には12秒に一度しか発動しない。レベル1、7、13で効果時間が上昇する。").EG(1,boot.BK.e,2.0,0,boot.Bv.ER(boot.BK.gm,6.0)).ES(2,boot.BK.hk,new boot.Bz(0.5,0.25,0));
		boot.Bv.bcn.Dy().ED("指定方向に錨を投げ、最初に命中した敵ユニットに{1}を与えNautilusの方向に引き寄せる。またNautilus自身も敵ユニットの方向に移動する。錨が壁に命中した場合、壁の方向にNautilusが移動しこのスキルのCDが半分になる。").EG(1,boot.BK.f,60.0,45.0,boot.Bv.EE(0.75)).EI(60.0,10.0).EH(18.0,-2.0).EJ(950.0);
		boot.Bv.bco.Dy().ED("10秒間{1}を得る。シールドが持続している間は通常攻撃時に対象とその周囲({2})にいる敵ユニットに{3}を与える。この魔法DMは2秒間かけて与えられる。").EG(1,boot.BK.gf,100.0,50.0,boot.Bv.ER(boot.BK.bc,0.1)).EA(2,boot.BK.jn,350.0).EG(3,boot.BK.f,30.0,15.0,boot.Bv.EE(0.4)).EU(80.0).EH(26.0,-2.0);
		boot.Bv.bcp.Dy().ED("周囲を爆発させ命中した敵ユニットに{1}と２秒間{2}を与える。スローの効果は2秒かけて元に戻る。爆発はNautilusを中心に3回まで発生し、同一対象に対して複数hitする。2発目以降は本来の50%分の魔法DMを与える(3発hitで{3})。").EG(1,boot.BK.f,60.0,40.0,boot.Bv.EE(0.5)).EK(2,boot.BK.ie,30.0,5.0).EG(3,boot.BK.f,120.0,80.0,boot.Bv.EE(1)).EI(60.0,10.0).EV(10.0).EJ(400.0);
		boot.Bv.bda.Dy().ED("対象の敵Championに衝撃波を放ち、移動中の衝撃波に当たった敵ユニットに{1}と{2}を与える。衝撃波が対象の敵Championに当たると爆発し、対象とその周囲にいる敵ユニットに{3}と{2}を与える。対象の敵Championには{2}と同時に{4}を与える。").EG(1,boot.BK.f,125.0,50.0,boot.Bv.EE(0.4)).EA(2,boot.BK.ib,1).EG(3,boot.BK.f,200.0,125.0,boot.Bv.EE(0.8)).EK(4,boot.BK.hj,1,0.5).EU(100.0).EH(140.0,-30.0).EJ(850.0);
		boot.Bv.bdb.Dy().Dz("茂みに入ると{1}する。この効果は茂みから出ても2秒間持続する。").EA(1,boot.BK.im,15.0).EC(1);
		boot.Bv.bdc.Dy().ED("指定方向に槍を投げて当たった敵ユニットに{1}を与える。槍がhitした時のNidaleeとターゲットの間の距離に比例して与えるダメージが増加する。最大で{2}。").EG(1,boot.BK.f,55.0,40.0,boot.Bv.EE(0.65)).EG(2,boot.BK.f,137.5,100.0,boot.Bv.EE(1.625)).EI(50.0,10.0).EV(5.0).EJ(1500.0);
		boot.Bv.bdd.Dy().ED("次に行う通常攻撃のダメージが{1}増加する。対象が受けているダメージに比例してダメージが増加する。最大で{2}。").EK(1,boot.BK.e,40.0,30.0).EG(2,boot.BK.e,120.0,90.0,boot.Bv.EP(2.0)).EV(5.0);
		boot.Bv.bde.Dy().ED("指定地点に罠を仕掛ける。敵ユニットが罠を踏むと発動し、対象の敵ユニットとその周囲の敵ユニットに2秒かけて{1}を与え、12秒間{2}と{3}を与え{4}。罠は4分間持続する。罠を設置してから2秒間の間は罠は発動しない。").EG(1,boot.BK.f,80.0,45.0,boot.Bv.EE(0.4)).EK(2,boot.BK.eo,20.0,5.0).EK(3,boot.BK.fe,20.0,5.0).EO(4,boot.BK.jd).EI(60.0,15.0).EV(18.0).EJ(900.0);
		boot.Bv.bdf.Dy().ED("前方に飛びかかり着地地点の敵ユニットに{1}を与える。").EG(1,boot.BK.f,125.0,50.0,boot.Bv.EE(0.4)).EV(3.5).EJ(350.0);
		boot.Bv.bdg.Dy().ED("対象の味方Championの{1}し、7秒間{2}する。").EG(1,boot.BK.he,50.0,35.0,boot.Bv.EE(0.7)).EK(2,boot.BK.di,20.0,10.0).EI(60.0,20.0).EV(10.0).EJ(600.0);
		boot.Bv.bdh.Dy().ED("前方扇形180°{2}の敵ユニットに{1}を与える。").EG(1,boot.BK.f,150.0,75.0,boot.Bv.EE(0.4)).EA(2,boot.BK.jn,300.0).EV(6.0);
		boot.Bv.bdh.Dy().EG(1,boot.BK.f,150.0,75.0,boot.Bv.EE(0.6));
		boot.Bv.bdi.Dy().ED("HumanからCougarに変身する。Cougar時はスキルの効果が変わり、通常攻撃の射程距離が125(Melee)になり、{1}、{2}、{3}を得る。Cougarスキルはこのスキルのレベルに比例し威力が増加する。").EA(1,boot.BK.ik,20.0).EK(2,boot.BK.ff,10.0,10.0).EK(3,boot.BK.fj,10.0,10.0).EV(4.0);
		boot.Bv.bdi.ET(boot.BR.k).ED("HumanからCougarに変身する。Cougar時はスキルの効果が変わり、通常攻撃の射程距離が125(Melee)になり、{1}を得る。Cougarスキルはこのスキルのレベルに比例し威力が増加する。");
		boot.Bv.bdj.Dy().ED("CougarからHumanに変身する。Human時はスキルの効果が変わり、通常攻撃の射程距離が525(Ranged)になる。").EV(4.0);
		boot.Bv.bdk.Dy().Dz("10秒に1度、通常攻撃のダメージが120%に増加し、{1}の敵ユニットにダメージを与える範囲攻撃になる。この効果がヒットした敵の数に応じて{2}する。また、通常攻撃を行うごとに、このスキルの{3}する。建物を攻撃する時はこの効果は発生しない。レベル1、7、13でHP回復量が上昇する。").EA(1,boot.BK.jn,200.0).ES(2,boot.BK.he,new boot.Bz(10.0,8.0,0)).EA(3,boot.BK.hd,1).EV(10.0);
		boot.Bv.bdl.Dy().ED("指定方向に影の刃を投げて当たった敵ユニットに{1}を与える。刃の軌跡には5秒間持続するDusk Trailが残り、刃がヒットした敵Championの動いた軌道上にもDusk Trailが残るようになる。Dusk Trailの上ではNocturneは{2}と{3}を得て、{4}する。").EG(1,boot.BK.e,60.0,45.0,boot.Bv.EL(0.75)).EK(2,boot.BK.dc,15.0,10.0).EO(3,boot.BK.ja).EK(4,boot.BK.di,15.0,5.0).EI(60.0,5.0).EV(10.0).EJ(1200.0);
		boot.Bv.bdm.Dy().Dz("{1}する。").EK(1,boot.BK.di,20.0,5.0).ED("Nocturneに1.5秒間持続する{2}を付与し、その間一度だけ敵のスキルを無効化する。無効化した場合、5秒間Passiveの増加攻撃速度が2倍になる。").EO(2,boot.BK.gi).EU(50.0).EH(20.0,-2.0);
		boot.Bv.bdn.Dy().ED("対象の敵ユニットに2秒間0.5秒毎に{1}、合計で{3}を与え、2秒間対象が一定範囲内(範囲465)に留まり続けていれば、更に{2}を与える。").EG(1,boot.BK.f,12.5,12.5,boot.Bv.EE(0.25)).EK(2,boot.BK.hl,1,0.25).EG(3,boot.BK.f,50.0,50.0,boot.Bv.EE(1)).EI(60.0,5.0).EH(15.0,-1.0).EJ(425.0);
		boot.Bv.bdo.Dy().ED("4秒間すべての敵Championに{1}を与え、また自分以外の視界を得られなくする。効果中に範囲内にいる敵Championを指定すると対象の位置まで移動し、到着時に対象に{2}を与える。").EA(1,boot.BK.ij,300.0).EG(2,boot.BK.e,150.0,100.0,boot.Bv.EL(1.2)).EU(100.0).EH(180.0,-40.0).EX(2000.0,750.0);
		boot.Bv.bdp.Dy().Dz("通常攻撃を行うたびにスタックが増加する(最大5スタック)。5スタックの状態でスキルを使用すると、スタックを消費して対象のスキルの消費マナが0になる。");
		boot.Bv.bea.Dy().ED("対象の敵MinionかPet及び中立クリープ1体に{1}を与え、{2}する。").EK(1,boot.BK.g,500.0,100.0).EG(2,boot.BK.he,125.0,55.0,boot.Bv.EE(1)).EU(60.0).EH(16.0,-2.0).EJ(125.0);
		boot.Bv.beb.Dy().ED("12秒間対象の味方ユニットは{1}し{2}する。自分以外に使用した場合は自身にも同様の効果が発生する。").EK(1,boot.BK.di,25.0,5.0).EK(2,boot.BK.im,8.0,1).EU(50.0).EV(15.0).EJ(700.0);
		boot.Bv.bec.Dy().ED("対象の敵ユニットに{1}と3秒間{2}、{3}を与える。").EG(1,boot.BK.f,85.0,45.0,boot.Bv.EE(1)).EA(2,boot.BK.ih,25.0).EK(3,boot.BK.ie,20.0,10.0).EI(75.0,10.0).EV(6.0).EJ(550.0);
		boot.Bv.bed.Dy().ED("最大3秒詠唱を行い、詠唱完了またはキャンセル時に{1}の敵ユニットに{2}を与える。ダメージは詠唱した時間に比例して最大で{3}。また詠唱中は範囲内の敵ユニットに{4}と{5}を与える。").EA(1,boot.BK.jn,550.0).EG(2,boot.BK.f,78.0,31.0,boot.Bv.EE(0.3)).EG(3,boot.BK.f,625.0,250.0,boot.Bv.EE(2.5)).EA(4,boot.BK.ih,25.0).EA(5,boot.BK.ie,50.0).EU(150.0).EH(150.0,-30.0);
		boot.Bv.bee.Dy().Dz("{1}する。").EG(1,boot.BK.di,0,0,boot.Bv.ER(boot.BK.cf,1));
		boot.Bv.bef.Dy().ED("指定地点に貫通する斧を投げ、当たった敵ユニットに{1}と2.5秒間{2}を与える。このスローは2.5秒かけて元に戻る。投げた斧は指定地点に7秒間留まり、斧を回収するとこのスキルの{3}する。").EG(1,boot.BK.e,80.0,45.0,boot.Bv.EL(1)).EK(2,boot.BK.ie,24.0,4.0).EA(3,boot.BK.hd,4.5).EI(55.0,5.0).EV(8.0).EJ(1000.0);
		boot.Bv.beg.Dy().ED("6秒間{1}と{2}と{3}を得る。").EG(1,boot.BK.dc,7.0,7.0,boot.Bv.ER(boot.BK.p,0.01)).EK(2,boot.BK.dj,9.0,3.0).EK(3,boot.BK.eg,9.0,3.0).EI(40.0,5.0).EV(16.0);
		boot.Bv.beh.Dy().ED("対象の敵ユニットに{1}を与える。").EK(1,boot.BK.g,100.0,60.0).EB(boot.BK.p,40.0,24.0).EH(9.0,-1.0).EJ(325.0);
		boot.Bv.bei.Dy().ED("6秒間{1}、{2}、{3}と{4}を得る。既にCCを受けていた場合はそれらを解除する。StunなどのDisable中でも使用可能。").EK(1,boot.BK.ej,10.0,10.0).EK(2,boot.BK.ff,30.0,15.0).EK(3,boot.BK.fj,30.0,15.0).EO(4,boot.BK.jb).EI(100.0,-25.0).EV(100.0);
		boot.Bv.bej.Dy().Dz("通常攻撃に追加{1}が付与される。4秒以内に同一の対象を連続して攻撃すると、追加魔法DMが20%上昇していく(最大+40%)。追加魔法の基礎DMは4/7/10/13/16レベル時に増加する。建物には無効。").Ev(1,boot.BK.f,new boot.CE(10.0,8.0,0),boot.Bv.EE(0.15),null);
		boot.Bv.bek.Dy().ED("指定した地点にBallを移動させ、移動中のBallに触れた敵ユニットと指定{1}にいる敵ユニットに{2}を与える。ダメージは敵に当たるごとに10%づつ減少する(最大60%減少)。BallはOriannaから一定距離離れなければその場に待機して{3}。").EO(1,boot.BK.jn).EG(2,boot.BK.f,60.0,30.0,boot.Bv.EE(0.5)).EO(3,boot.BK.jd).EU(50.0).EH(6.0,-0.75).EJ(825.0);
		boot.Bv.bel.Dy().ED("Ballの存在する地点にフィールドを展開しBallの{1}にいる敵ユニットに{2}を与える。フィールドは3秒間持続し、フィールドの上の味方ユニットは{3}し、敵ユニットには{4}を与える。フィールドから出た場合、この効果は2秒かけて元に戻る。").EA(1,boot.BK.jn,250.0).EG(2,boot.BK.f,70.0,45.0,boot.Bv.EE(0.7)).EK(3,boot.BK.im,20.0,5.0).EK(4,boot.BK.ie,20.0,5.0).EI(70.0,10.0).EV(9.0);
		boot.Bv.bem.Dy().Dz("Ballが付いている味方Championは{1}と{2}を得る。").EK(1,boot.BK.ff,10.0,5.0).EK(2,boot.BK.fj,10.0,5.0).ED("対象の味方ChampionまでBallを移動させ、4秒間持続する{3}を付与する。また、移動中のBallに触れた敵ユニットに{4}を与える。Ballは対象がOriannaから一定距離離れなければ貼り付き続ける。").EG(3,boot.BK.gf,80.0,40.0,boot.Bv.EE(0.4)).EG(4,boot.BK.f,60.0,30.0,boot.Bv.EE(0.3)).EU(60.0).EV(9.0).EJ(1120.0);
		boot.Bv.ben.Dy().ED("約0.5秒詠唱後にBallから衝撃波を発生させ、Ballの{1}にいる敵ユニットに{2}を与えると共に、Ballの方向に{3}させる。").EA(1,boot.BK.jn,400.0).EG(2,boot.BK.f,150.0,75.0,boot.Bv.EE(0.7)).EA(3,boot.BK.ic,350.0).EI(100.0,25.0).EH(120.0,-15.0);
		boot.Bv.beo.Dy().Dz("通常攻撃を行うかスキルを使用するたびにスタックが1増加(最大4スタック)し、4スタック時に40DM以上の通常攻撃を受けるとスタックを消費して通常攻撃のダメージを無効化する。");
		boot.Bv.bep.Dy().ED("対象の敵ユニットに槍を投げ{1}を与える。").EG(1,boot.BK.e,65.0,40.0,boot.Bv.EL(1.4)).EU(45.0).EV(4.0).EJ(600.0);
		boot.Bv.bfa.Dy().ED("対象の敵Championに飛びかかり{1}と{2}を与え、Aegis Protectionを発動する。").EG(1,boot.BK.f,50.0,25.0,boot.Bv.EE(1)).EA(2,boot.BK.hj,1).EU(55.0).EH(13.0,-1.0).EJ(600.0);
		boot.Bv.bfb.Dy().Dz("敵ユニットのHPが15%以下の時は通常攻撃が必ずクリティカルになり、またSpear Shotのダメージが1.5倍になる。").ED("指定方向に0.75秒間槍を突き出し、範囲内の敵ユニットに{1}を最大3回与える(0.25秒毎に1ヒット)。対象がChampionの場合、与えるダメージが{2}になる。").EG(1,boot.BK.e,13.0,10.0,boot.Bv.EL(0.6)).EG(2,boot.BK.e,26.0,20.0,boot.Bv.EL(1.2)).EI(45.0,5.0).EH(10.0,-1.0).EJ(400.0).EW(boot.CC.e);
		boot.Bv.bfc.Dy().ED("地点を指定して2秒後にジャンプし、その1.5秒後に指定地点の{1}に{2}と1秒間{3}を与えつつ落下する。DMは指定地点から離れるほど低減され、範囲最端では50%となる。ジャンプ前にキャンセルすると、消費した分のマナが回復し、このスキルのCDは10秒になる。").EA(1,boot.BK.jn,1000.0).EG(2,boot.BK.f,400.0,300.0,boot.Bv.EE(1)).EA(3,boot.BK.ie,35.0).EU(125.0).EH(150.0,-15.0).EJ(5500.0);
		boot.Bv.bfd.Dy().Dz("現在HPの10%を超えるダメージを受けた際、その超過分のダメージを50%低減する。塔の攻撃には無効。");
		boot.Bv.bfe.Dy().ED("次に行う通常攻撃が魔法DMになり、追加{1}が付与される。").EQ(1,boot.BK.f,20.0,20.0,boot.Bv.EE(0.6),boot.Bv.ER(boot.BK.cg,8.0)).EU(55.0).EH(8.0,-1.0);
		boot.Bv.bff.Dy().Dz("通常攻撃を行うか、ダメージを受ける度にスタックが1増加する(最大10)。スタック数に比例して{1}と{2}を得る。スタックは5秒間増加がないと0になる。").EG(1,boot.BK.dc,1.5,0,boot.Bv.ER(boot.BK.ke,0.5)).EG(2,boot.BK.ff,1.5,0,boot.Bv.ER(boot.BK.ke,0.5)).EC(1).EC(2).ED("スタックを最大(10)まで増加させ、5秒間{3}する。").EK(3,boot.BK.im,17.0,2.0).EI(70.0,5.0).EV(12.0);
		boot.Bv.bfg.Dy().ED("対象の敵ユニットに突撃し{1}と{2}を与える。ノックバック時に壁にぶつかった場合、追加{3}と{4}を与える。").EO(1,boot.BK.ic).EG(2,boot.BK.f,50.0,25.0,boot.Bv.EE(0.4)).EG(3,boot.BK.f,75.0,50.0,boot.Bv.EE(0.4)).EA(4,boot.BK.hj,1.5).EI(60.0,5.0).EH(12.0,-1.0).EJ(525.0);
		boot.Bv.bfh.Dy().ED("対象の敵Championを{2}秒間ターゲットし、その対象に与える{1}する。効果中は対象以外からのすべての攻撃を無効化する(対象のPetからはダメージを受ける)。").EK(1,boot.BK.d,20.0,10.0).EK(2,boot.BK.jj,6.0,1).EU(100.0).EH(140.0,-20.0).EJ(900.0);
		boot.Bv.bfi.Dy().Dz("{1}を得る。").EG(1,boot.BK.dc,0,0,boot.Bv.ER(boot.BK.ff,0.45));
		boot.Bv.bfj.Dy().ED("使用してから7秒間Rammusが回転し、その間徐々に移動速度が増加する(最大時85%増加)。回転中に最初に当たった敵ユニットとRammusの周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。回転中にスキル再使用または、Defensive Ball Curlを使用すると回転がキャンセルされる。").EA(1,boot.BK.jn,200.0).EG(2,boot.BK.f,100.0,50.0,boot.Bv.EE(1)).EA(3,boot.BK.ib,0.75).EK(4,boot.BK.ie,20.0,5.0).EI(70.0,10.0).EV(10.0);
		boot.Bv.bfk.Dy().ED("6秒間{1}と{2}を得て、Rammusを通常攻撃した敵ユニットに{3}を与える。効果中にPowerballを使用すると効果がキャンセルされる。また、このスキルを再使用することで効果をキャンセルできる。").EK(1,boot.BK.ff,40.0,20.0).EK(2,boot.BK.fj,40.0,20.0).EG(3,boot.BK.f,15.0,10.0,boot.Bv.ER(boot.BK.ff,0.1)).EU(40.0).EV(14.0);
		boot.Bv.bfl.Dy().ED("対象の敵ユニットに{1}と{2}を与える。").EK(1,boot.BK.hp,1,0.5).EK(2,boot.BK.en,10.0,5.0).EI(50.0,10.0).EV(12.0).EJ(325.0);
		boot.Bv.bfm.Dy().ED("8秒間地震を発生させ{1}の敵ユニット及び建物に毎秒{2}を与える。").EA(1,boot.BK.jn,300.0).EG(2,boot.BK.f,65.0,65.0,boot.Bv.EE(0.3)).EU(120.0).EV(60.0);
		boot.Bv.bfn.Dy().Dz("通常攻撃ごとにFuryが5増加する。12秒間戦闘を行わないとFuryは毎秒2.5減少する。Furyの最大値は100、Furyが50以上ある場合にスキルを使用すると、Furyを50消費してスキルが強化される。また、RenektonのHPが50%以下になるとFuryの増加量が50%増加する。建物を攻撃した場合はFuryは増加しない。");
		boot.Bv.bfo.Dy().ED("武器を振り回し{1}の敵ユニットに{2}を与え、{3}する(上限あり)。対象がChampionの場合、{4}する。当たったユニット1体につきFuryが5増加する(最大25)。Fury消費すると与えるダメージが50%増加し、HP回復量が2倍、回復上限が3倍に増加する。但し、Fury増加効果は無くなる。").EA(1,boot.BK.jn,450.0).EG(2,boot.BK.e,60.0,30.0,boot.Bv.EL(0.8)).EG(3,boot.BK.he,0,0,boot.Bv.ER(boot.BK.k,5.0)).EG(4,boot.BK.he,0,0,boot.Bv.ER(boot.BK.k,20.0)).EV(8.0);
		boot.Bv.bfp.Dy().ED("次に行う通常攻撃が2回攻撃になり、{1}が付与される。Fury消費すると攻撃回数が3回に増加し、{2}を付与する。但し、Fury増加効果は無くなる。").EA(1,boot.BK.hj,0.75).EA(2,boot.BK.hj,1.5).EH(13.0,-1.0).EW(boot.CC.f);
		boot.Bv.bga.Dy().ED("指定方向にダッシュし触れた敵ユニットに{1}を与える(Slice)。このスキルが敵にヒットした場合、4秒間の間だけ再度使用できる(Dice)。Fury消費時:Diceで与えるダメージが50%増加し、4秒間{2}を与える。SliceではFuryを消費しない。").EG(1,boot.BK.e,30.0,30.0,boot.Bv.EL(0.9)).EK(2,boot.BK.eo,15.0,5.0).EH(18.0,-1.0).EJ(450.0);
		boot.Bv.bgb.Dy().ED("15秒間サイズが大きくなり、スキルの射程が増加する。更に{1}を得て{2}の敵ユニットに毎秒{3}を与える。また、毎秒5Furyを得る。").EK(1,boot.BK.p,300.0,150.0).EA(2,boot.BK.jn,350.0).EG(3,boot.BK.f,40.0,30.0,boot.Bv.EE(0.1)).EV(120.0);
		boot.Bv.bgc.Dy().Dz("ステルス状態または茂みの中から相手を攻撃する際には、通常攻撃の射程が増加し相手に飛びつくようになる。この効果はステルス状態が解除された、また茂みから出た後0.5秒の間でも発生し、またステルス状態や茂みの中の視界が取られていた場合でも発生する。増加後射程: 600(Bonetooth Necklaceが9 Trophies以上の場合は750)また、Rengarがスキルで敵ユニットにダメージを与える度に1 Ferocityを得て(最大5 Ferocity)、5 Ferocity時にはFerocityを消費して強化(Empowered)されたスキルを使用することが出来る。");
		boot.Bv.bgd.Dy().ED("次の通常攻撃に追加物理DMを付与し、次の通常攻撃から4秒間攻撃速度が増加する。追加物理DM: 30/60/90/120/150増加AS: 30/35/40/45/50%CD: 8/7.5/7/6.5/6sEmpoweredActive:次の通常攻撃に追加物理DMを付与し、次の通常攻撃から4秒間攻撃速度が増加する。攻撃速度増加効果は通常のSavageryと重複する。").EH(8.0,-0.5);
		boot.Bv.bge.Dy().ED("周囲の敵ユニットに魔法DMを与える。また、このスキルが敵ユニットに命中すると、3秒間自身のArmorとMagic Resistが増加する。魔法DM: 50/80/110/140/170 (+0.8) 効果範囲: 500増加AR/MR: 15/22/29/36/43CD: 15/14/13/12/11sEmpoweredActive:周囲の敵ユニットに魔法DMを与え、自身のHPを回復する。また、このスキルが敵ユニットに命中すると、3秒間自身のArmorとMagic Resistが増加する。ArmorとMagic Resistの増加効果は通常のBattle Roarと重複しない。").EH(15.0,-1.0);
		boot.Bv.bgf.Dy().ED("対象の敵ユニットに投げ縄を投げ、物理DMとスロー(2.5s)を与える。スローは時間経過と共に元に戻る。物理DM: 60/105/150/195/240 + [増加攻撃力 × 70%]スロー: 50/55/60/65/70%CD: 12/11/10/9/8s Range: 575EmpoweredActive:対象の敵ユニットに投げ縄を投げ、物理DMとスネア(1s)とスロー(2.5s)を与える。スローは時間経過と共に元に戻る。").EH(12.0,-1.0).EJ(575.0);
		boot.Bv.bgg.Dy().ED("1秒後に自身が最大7秒間(Bonetooth Necklaceが14 Trophiesの場合10秒間)ステルス状態になり、自身を中心とした広範囲内の敵Champion全員の視界を得る。ステルス準備中に攻撃を行うかダメージを受ける度に、ステルス状態になるのに必要な時間が1秒増加する。ステルス準備開始から3秒経過するとダメージを受けていてもステルス状態になる。ステルス状態の間は移動速度が増加し、0.75秒毎に1 Ferocityを得る。これらの効果はステルス状態が解除されると終了する。").EH(140.0,-35.0);
		boot.Bv.bgh.Dy().Dz("スキルを使用するごとに1チャージを得る。チャージがある状態で通常攻撃を行うと、チャージを消費して通常攻撃に{1}が付与される。チャージは最大3スタックされ、通常攻撃ごとに1チャージずつ消費される。チャージは5秒間増加または消費がないと0になる。建物には無効。").EG(1,boot.BK.e,0,0,boot.Bv.EZ(boot.BK.dc,new boot.CH(0.2,0.05,0)));
		boot.Bv.bgi.Dy().ED("前方にステップし、{1}の敵ユニットを剣で切りつけて{2}を与える。このスキルは短期間の間、3回まで連続して使用できる。3度目の使用でジャンプを行い、着地時に{3}の敵ユニットに{2}と{4}を与える。また、スキルを使用する度にオートアタックタイマーがリセットされる。最大DMは{5}。").EA(1,boot.BK.jn,112.5).EG(2,boot.BK.e,30.0,25.0,boot.Bv.EL(0.7)).EA(3,boot.BK.jn,150.0).EA(4,boot.BK.ic,225.0).EG(5,boot.BK.e,90.0,75.0,boot.Bv.EL(2.1)).EV(1).EJ(260.0);
		boot.Bv.bgj.Dy().ED("{1}の敵ユニットに{2}と{3}を与える。").EA(1,boot.BK.jn,125.0).EG(2,boot.BK.e,50.0,30.0,boot.Bv.EL(1)).EA(3,boot.BK.hj,0.75).EH(11.0,-1.0);
		boot.Bv.bgk.Dy().ED("指定方向にダッシュ({1})し、2.5秒間{2}が付与される。").EA(1,boot.BK.jp,325.0).EG(2,boot.BK.gf,70.0,30.0,boot.Bv.EL(1)).EH(10.0,-1.0).EJ(325.0);
		boot.Bv.bgl.Dy().ED("15秒間折れた剣の刃を再生させ、{1}増加し、射程が増加する(通常攻撃: {2} Broken Wings: {3} Ki Burst: {4})。また、このスキルを再度使用することで一度だけ0.5秒後に指定方向に巨大な衝撃波を発生させ、範囲内の敵ユニットに{5}与える。対象が受けているダメージに比例して与えるダメージが増加して、最大DMは{6}。").EG(1,boot.BK.dc,0,0,boot.Bv.EP(0.2)).EA(2,boot.BK.gj,200.0).EA(3,boot.BK.gj,325.0).EA(4,boot.BK.gj,270.0).EG(5,boot.BK.e,80.0,40.0,boot.Bv.EL(0.6)).EG(6,boot.BK.e,240.0,120.0,boot.Bv.EL(1.8)).EH(110.0,-30.0);
		boot.Bv.bgm.Dy().Dz("Ult以外のスキルを使うとHeatが20増加し、それが50以上になると「Danger Zone」状態に入り全てのスキルに追加効果がつくようになる。Heatが100になると6秒間スキルが使用不可能になり、通常攻撃に追加{1}が付与される。Heatは時間によって減少していく。追加魔法DMは建物には無効。").EQ(1,boot.BK.f,20.0,0,boot.Bv.EE(0.3),boot.Bv.ER(boot.BK.gm,5.0));
		boot.Bv.bgn.Dy().ED("3秒間前方の範囲を火炎放射器で焼き払い、範囲内の敵ユニットに毎秒{1}を与える。minionに与えるダメージは半分。Danger Zone中は{2}を与える。").EG(1,boot.BK.f,30.0,23.3,boot.Bv.EE(0.45)).EG(2,boot.BK.f,37.5,29.1,boot.Bv.EE(0.56)).EV(6.0).EJ(600.0);
		boot.Bv.bgo.Dy().ED("2秒間{1}を得て1秒間{2}する。Danger Zone中は{3}を得て1秒間{4}する。").EG(1,boot.BK.gf,50.0,30.0,boot.Bv.EE(0.4)).EK(2,boot.BK.im,10.0,5.0).EG(3,boot.BK.gf,62.5,37.5,boot.Bv.EE(0.5)).EK(4,boot.BK.im,12.5,6.25).EV(6.0);
		boot.Bv.bgp.Dy().ED("指定方向に銛を放ち当たった敵ユニットに{1}と3秒間{2}を与える。このスキルは3秒の間、2回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2発目はHeatが増加しない。また、このスキルによるスローはスタックする。Danger Zone中では{3}と3秒間{4}を与える。").EG(1,boot.BK.f,55.0,30.0,boot.Bv.EE(0.5)).EK(2,boot.BK.ie,15.0,5.0).EG(3,boot.BK.f,68.75,37.5,boot.Bv.EE(0.625)).EK(4,boot.BK.ie,18.75,6.25).EV(10.0).EJ(850.0);
		boot.Bv.bha.Dy().ED("指定した位置から指定方向({4})にロケットを打ち出し、当たった敵ユニットに{1}と{2}を与える。また5秒間ロケットの着弾した地面に炎が残り、その上にいる敵ユニットに毎秒{3}と{2}を与える。").EG(1,boot.BK.f,150.0,75.0,boot.Bv.EE(0.5)).EA(2,boot.BK.ie,35.0).EG(3,boot.BK.f,100.0,40.0,boot.Bv.EE(0.2)).EA(4,boot.BK.jp,1000.0).EH(105.0,-15.0).EJ(1750.0);
		boot.Bv.bhg.Dy().Dz("通常攻撃にFrostを付与する。Frost状態の敵ユニットは3秒間{1}になる。").EA(1,boot.BK.ie,30.0);
		boot.Bv.bhh.Dy().ED("指定方向に突進し、接触した全ての敵ユニットに{1}とFrostを与え、対象がMinionの場合は更に{2}させる。敵Championに当たるか最大距離だけ移動すると突進は止まる。").EG(1,boot.BK.f,60.0,30.0,boot.Bv.EE(0.4)).EO(2,boot.BK.ic).EI(70.0,5.0).EH(19.0,-2.0).EJ(700.0);
		boot.Bv.bhi.Dy().ED("6秒間極寒の嵐を周囲に召還し、{1}の敵ユニットに毎秒{2}を与える。魔法DMは敵ユニットがFrostまたはPermafrostの時には50%増加する。").EA(1,boot.BK.jn,350.0).EQ(2,boot.BK.f,12.0,6.0,boot.Bv.EE(0.1),boot.Bv.EY(boot.BK.p,0.01,0.0025)).EU(40.0).EV(10.0);
		boot.Bv.bhj.Dy().ED("{0}の敵ユニットのFrostをPermafrostにし、{1}を与える。Permafrost状態の敵ユニットは3秒間{2}を受ける。").EA(0,boot.BK.jn,1000.0).EG(1,boot.BK.f,60.0,50.0,boot.Bv.EE(0.5)).EK(2,boot.BK.ie,30.0,10.0).EU(55.0).EV(11.0);
		boot.Bv.bhk.Dy().ED("指定方向に武器を投げ、最大距離飛ぶか敵Championに命中するとその場で氷が爆発し、{1}の敵ユニットに{2}と{3}を与え、Frostにする。武器が直撃した敵Championには{4}を与える。").EA(1,boot.BK.jn,450.0).EG(2,boot.BK.f,150.0,100.0,boot.Bv.EE(0.8)).EA(3,boot.BK.hj,1).EA(4,boot.BK.hj,2.0).EU(100.0).EH(130.0,-15.0).EJ(1150.0);
		boot.Bv.bhl.Dy().Dz("対象の背後から攻撃した場合に{1}する。").EA(1,boot.BK.d,20.0);
		boot.Bv.bhm.Dy().ED("指定地点にテレポートし、{1}になる。また、スキル使用後6秒以内に通常攻撃を行うと必ずクリティカルになる。その際のクリティカルダメージは{2}になる。").EA(1,boot.BK.jc,3.5).EK(2,boot.BK.kc,140.0,20.0).EV(11.0).EI(90.0,-10.0).EJ(400.0);
		boot.Bv.bhn.Dy().ED("指定地点に60秒持続する人形を設置する。人形は設置後2秒で{1}となり、敵ユニットがステルス状態の人形から範囲300以内に近づくと、人形のステルスが解除されると同時に近くの敵ユニットに{2}を与え、5秒間通常攻撃({3})を行った後に破壊される。").EO(1,boot.BK.jc).EK(2,boot.BK.hl,0.5,0.25).EG(3,boot.BK.f,35.0,15.0,boot.Bv.EE(0.2)).EU(60.0).EV(16.0).EJ(425.0);
		boot.Bv.bho.Dy().Dz("通常攻撃に2秒間の{1}を付与する。対象がChampion以外の場合、更に命中率低下(値はスローと同じ)を与える。命中率低下を受けたユニットは一定確率で通常攻撃が外れる(ブラインドと同じ)。").EK(1,boot.BK.ie,10.0,5.0).ED("対象の敵ユニットに{2}と3秒間{1}を与える。効果後はCDが解消されるまでPassiveの効果が無くなる。").EQ(2,boot.BK.f,50.0,40.0,boot.Bv.EE(1),boot.Bv.EL(1)).EI(50.0,5.0).EV(8.0).EJ(625.0);
		boot.Bv.bhp.Dy().ED("18秒間持続する自身のイリュージョン(敵からの見た目は本体と同じ)を作成する。(RまたはALT押しながらクリックで任意の操作可能)イリュージョンは本体の75%の攻撃力を持ち、150%のダメージを受ける。また本体の一部アイテムの効果を引き継ぐ。イリュージョン死亡または効果時間終了時に爆発し、{1}の敵ユニットに{2}を与える。イリュージョンが塔に与えるダメージは半分。このスキルを使用してもステルスは解除されない。").EA(1,boot.BK.jn,250.0).EG(2,boot.BK.f,300.0,150.0,boot.Bv.EE(1)).EU(100.0).EH(100.0,-10.0);
		boot.Bv.bia.Dy().Dz("9秒に1度通常攻撃に追加{1}が付与され、{2}する。このスキルはShenが通常攻撃を行う度にCDが1秒解消される。CD解消は建物を攻撃した場合は発生しない。LV1/7/13で「気」回復量が増加する。").EQ(1,boot.BK.f,4.0,0,boot.Bv.ER(boot.BK.gm,4.0),boot.Bv.ER(boot.BK.bc,0.1)).ES(2,boot.BK.hh,new boot.Bz(10.0,10.0,0));
		boot.Bv.bib.Dy().ED("対象の敵ユニットに{1}と5秒間持続するDebuffを与える。Debuffが付与された対象に通常攻撃またはダメージスペルで攻撃をすると、攻撃した味方Championは3秒かけて{2}する。このスキルでLHを取った場合、{3}する。").EG(1,boot.BK.f,60.0,40.0,boot.Bv.EE(0.6)).EG(2,boot.BK.he,6.0,4.0,boot.Bv.ER(boot.BK.p,0.015)).EG(3,boot.BK.he,2.0,1.3,boot.Bv.ER(boot.BK.p,0.005)).EH(6.0,-0.5).EB(boot.BK.bn,60.0,0).EJ(475.0);
		boot.Bv.bic.Dy().ED("3秒間{1}を得る。シールドが持続している間はKi StrikeのCD解消効果が1秒から2秒になる。").EG(1,boot.BK.gf,70.0,45.0,boot.Bv.EE(0.6)).EH(9.0,-1.0).EB(boot.BK.bn,50.0,0);
		boot.Bv.bid.Dy().ED("指定地点まで素早く移動し接触した敵Championに{1}と{2}を与える。ShenはTaunt効果中の対象から受ける通常攻撃のダメージを半減する。またこのスキルが敵Championに命中する度に{3}する。").EG(1,boot.BK.f,50.0,35.0,boot.Bv.EE(0.5)).EA(2,boot.BK.hp,1.5).EA(3,boot.BK.hh,40.0).EH(16.0,-2.0).EB(boot.BK.bn,120.0,0).EJ(600.0);
		boot.Bv.bie.Dy().ED("対象の味方Championに5秒間{1}を付与し、3秒詠唱後そこまでワープする。").EG(1,boot.BK.gf,250.0,300.0,boot.Bv.EE(1.5)).EH(200.0,-20.0).EJ(-1.0);
		boot.Bv.bif.Dy().Dz("Shyvanaは通常攻撃時に次の効果を得る。Twin BiteのCDを0.5秒解消する。対象が建物の場合は無効。Burnoutの効果時間が1秒延長される。最大4秒延長できる。対象が建物の場合も有効。Flame BreathのAR低下を受けている敵ユニットに対し、Flame Breathのダメージの15%分の追加魔法DMが発生する。Dragon's Descent通常攻撃時に2Furyを得る。また、Human formの時には1.5秒毎に1Furyを得る。");
		boot.Bv.big.Dy().ED("次に行う通常攻撃が二回攻撃になり、ニ回目の攻撃は{1}を与える。Dragon Form時は対象の周囲にいる敵ユニットにも同様の効果を与える。").EG(1,boot.BK.e,0,0,boot.Bv.EY(boot.BK.dc,0.8,0.05)).EH(10.0,-1.0).EW(boot.CC.f);
		boot.Bv.bih.Dy().ED("3秒間{1}の敵ユニットに毎秒{2}を与え、{3}する。移動速度上昇は時間経過と共に減少する。Dragon Form時Shyvanaの通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒{2}を与える。").EA(1,boot.BK.jn,325.0).EG(2,boot.BK.f,25.0,15.0,boot.Bv.EL(0.2)).EK(3,boot.BK.im,30.0,5.0).EV(12.0);
		boot.Bv.bii.Dy().ED("指定方向に火球を放ち当たった敵ユニットに{1}と４秒間{2}を与える。Dragon Form時Shyvanaの前方の扇状の範囲を巻き込む範囲攻撃となる。").EG(1,boot.BK.f,80.0,45.0,boot.Bv.EE(0.6)).EA(2,boot.BK.eo,15.0).EH(12.0,-1.0).EJ(700.0);
		boot.Bv.bij.Dy().Dz("{1}と{2}を得る。 Dragon Formの時は2倍になる。また、このスキルのLv1取得時に100Furyを得る。").EK(1,boot.BK.ff,10.0,5.0).EK(2,boot.BK.fj,10.0,5.0).ED("このスキルはHuman formでFuryが100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに{1}を与え、移動地点の方向に{2}を与える。Dragon Formでは毎秒6Fury減少し、0になるとHuman Formに戻る。").EG(1,boot.BK.f,200.0,100.0,boot.Bv.EE(0.7)).EO(2,boot.BK.ic).EJ(1000.0);
		boot.Bv.bik.Dy().Dz("{1}を得る。").EG(1,boot.BK.p,0,0,boot.Bv.ER(boot.BK.bg,0.25));
		boot.Bv.bil.Dy().Dz("Singedの通り道に3.25秒間持続する毒を撒き、触れた敵ユニットに3秒間毎秒{1}を与える。").EG(1,boot.BK.f,22.0,0,boot.Bv.EE(0.3)).EU(13.0).EV(1);
		boot.Bv.bim.Dy().ED("指定地点に5秒間持続する粘着剤を撒き、{1}の敵ユニットに{2}を与え続ける。この効果は範囲外に出てからも1秒間持続する。").EA(1,boot.BK.jn,350.0).EK(2,boot.BK.ie,35.0,10.0).EI(70.0,10.0).EV(14.0).EJ(1000.0);
		boot.Bv.bin.Dy().ED("対象の敵ユニット{1}を与え、Singedの後ろに投げ飛ばす({2})。").EG(1,boot.BK.f,100.0,50.0,boot.Bv.EE(1)).EA(2,boot.BK.jp,550.0).EI(100.0,10.0).EV(10.0).EJ(125.0);
		boot.Bv.bio.Dy().ED("25秒間{1}、{2}、{3}、{4}、{5}、{6}を得て、{7}する。").EK(1,boot.BK.ea,35.0,15.0).EK(2,boot.BK.ff,35.0,15.0).EK(3,boot.BK.fj,35.0,15.0).EK(4,boot.BK.bd,35.0,15.0).EK(5,boot.BK.bk,35.0,15.0).EK(6,boot.BK.gn,10.0,5.0).EK(7,boot.BK.im,35.0,15.0).EU(150.0).EV(100.0);
		boot.Bv.bip.Dy().Dz("40%の確率で{1}する。この軽減は防御力計算より先に行われる。レベル1、7、13で軽減DMが上昇する。").ES(1,boot.BK.gd,new boot.Bz(30.0,10.0,0));
		boot.Bv.bja.Dy().ED("対象の敵ユニットに{1}と{2}を与える。").EG(1,boot.BK.f,70.0,55.0,boot.Bv.EE(0.9)).EA(2,boot.BK.hj,1.5).EU(100.0).EH(12.0,-1.0).EJ(550.0);
		boot.Bv.bjb.Dy().ED("{1}を得る。10秒間シールドが残っていた場合、シールドが破裂し{2}の敵ユニットに{3}を与える。使用から4秒後以降に再度使用で、即座にシールドを破裂させる。").EG(1,boot.BK.gf,100.0,50.0,boot.Bv.EE(0.9)).EA(2,boot.BK.jn,550.0).EG(3,boot.BK.f,100.0,50.0,boot.Bv.EE(0.9)).EI(70.0,10.0);
		boot.Bv.bjc.Dy().Dz("{1}を得る。使用中にLHをとるとSionの最大HPが{2}増加する。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍になる。").EK(1,boot.BK.dc,25.0,10.0).EK(2,boot.BK.jm,1,0.5).EB(boot.BK.p,6.0,2.0).EW(boot.CC.d);
		boot.Bv.bjd.Dy().ED("20秒間{1}を得て{2}し、通常攻撃をするたびに{4}の味方ユニットは{3}する。").EK(1,boot.BK.dj,50.0,25.0).EA(2,boot.BK.di,50.0).EG(3,boot.BK.he,0,0,boot.Bv.EY(boot.BK.i,25.0,12.5)).EA(4,boot.BK.jn,200.0).EU(100.0).EV(90.0);
		boot.Bv.bje.Dy().Dz("敵Championに通常攻撃でダメージを与えると、2秒間{1}する。").EA(1,boot.BK.im,50.0).EC(1);
		boot.Bv.bjf.Dy().ED("指定方向にブーメランを投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに20%ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定がある。").EQ(1,boot.BK.e,60.0,45.0,boot.Bv.EE(0.5),boot.Bv.EL(1.1)).EI(70.0,10.0).EV(9.0).EJ(1200.0);
		boot.Bv.bjg.Dy().ED("次に行う通常攻撃に追加{1}が付与され、5回跳ね返る({2})ようになる。この追加ダメージはCriticalHitによって増幅される。On-Hit Effectsの効果は最初に当たったユニットにのみ発動し、跳ね返る毎にダメージが20%ずつ低下する。").EK(1,boot.BK.e,20.0,15.0).EA(2,boot.BK.jn,450.0).EU(40.0).EH(7.0,-1.0);
		boot.Bv.bjh.Dy().ED("Sivirに3秒間{1}を付与し、その間一度だけ敵のスキルを無効化する。無効化した場合{2}する。").EO(1,boot.BK.gi).EA(2,boot.BK.hg,150.0).EU(75.0).EH(22.0,-3.0);
		boot.Bv.bji.Dy().ED("10秒間以下の能力をもつ{1}のオーラを発生させる。{2}し、自身は{3}、近くの味方ユニットは{4}する。一度範囲内に入れば、Sivirから離れても効果が持続する。").EA(1,boot.BK.jn,1200.0).EA(2,boot.BK.im,20.0).EK(3,boot.BK.di,30.0,15.0).EK(4,boot.BK.di,15.0,7.5).EU(100.0).EH(100.0,-10.0).EJ(1200.0);
		boot.Bv.bjj.Dy().Dz("通常攻撃を行うたびに、 Skarnerのすべてのスキルの{1}される(対象がChampionの場合は{2})。建物に対しては無効。").EA(1,boot.BK.hd,0.5).EA(2,boot.BK.hd,1);
		boot.Bv.bjk.Dy().ED("Skarnerの近くにいるすべての敵ユニットに{1}を与える。このスキルが敵ユニットにヒットした場合、5秒間Crystal Energyのスタックを得る。スタックがある状態で再度このスキルを使用すると、追加{2}と2秒間{3}が付与される。").EG(1,boot.BK.e,25.0,15.0,boot.Bv.EL(0.8)).EG(2,boot.BK.f,24.0,12.0,boot.Bv.EE(0.4)).EK(3,boot.BK.ie,20.0,5.0).EI(20.0,2.0).EV(3.5).EJ(350.0);
		boot.Bv.bjl.Dy().ED("6秒間{1}を張る。シールドが残っている間{2}し、{3}する。").EG(1,boot.BK.gf,70.0,45.0,boot.Bv.EE(0.6)).EK(2,boot.BK.im,15.0,2.0).EK(3,boot.BK.di,30.0,5.0).EU(60.0).EV(18.0);
		boot.Bv.bjm.Dy().ED("指定方向に貫通するエネルギーを飛ばし、当たった敵ユニットに{1}と6秒間持続するマークを付与する。自身がマークが付いた敵ユニットを攻撃するか、このスキルで敵ユニットを倒した場合、マークを消費して{2}する。HP回復量はマークを消費する度に50%ずつ低下していく。").EG(1,boot.BK.f,80.0,40.0,boot.Bv.EE(0.7)).EG(2,boot.BK.he,30.0,15.0,boot.Bv.EE(0.3)).EI(50.0,5.0).EV(10.0).EJ(600.0);
		boot.Bv.bjn.Dy().ED("対象の敵Championに{1}と{2}を与える。効果中は対象の敵Championを引っ張る事が出来る。また、効果終了時に追加{3}を与える。").EG(1,boot.BK.f,100.0,50.0,boot.Bv.EE(0.5)).EA(2,boot.BK.ia,1.75).EG(3,boot.BK.f,100.0,50.0,boot.Bv.EE(0.5)).EI(100.0,25.0).EH(130.0,-10.0).EJ(350.0);
		boot.Bv.bjo.Dy().Dz("Auraを切り替えても、以前のAuraの効果が1秒間持続する。切替時は他のAuraスキルが0.5秒間CDになる。また、3回スキルを使用した後の通常攻撃に追加魔法DMと、そのとき展開しているAuraに応じた追加効果が発生する。");
		boot.Bv.bjp.Dy().Dz("Aura:周囲の味方ChampionのAD,APを増加させる。増加AD,AP: 4/8/12/16/20").ED("最も近い敵ユニット2体に魔法DMを与える。Sonaの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。魔法DM: 50/100/150/200/250 (+0.7)消費MN: 45/50/55/60/65 CD: 7s Range: 700Power Chord - Stacatto:追加魔法DMが2倍になる。").EI(45.0,5.0).EV(7.0).EJ(700.0);
		boot.Bv.bka.Dy().Dz("Aura:周囲の味方ChampionのAR,MRを増加させる。増加AR,MR: 3/6/9/12/15").ED("近くにいる最もHPが減っている味方Champion1体とSonaのHPを回復する。HPを回復した対象と自身は3秒間、AuraのAR,MR増加が2倍になる。回復HP: 40/60/80/100/120 (+0.25)消費MN: 60/65/70/75/80 CD: 7s Range: 900Power Chord - Diminuendo:対象が与えるダメージを20%低下するDebuffを付与する。この効果は4秒間持続する。").EI(60.0,5.0).EV(7.0).EJ(900.0);
		boot.Bv.bkb.Dy().Dz("Aura:周囲の味方Championの移動速度を増加させる。増加移動速度: 4/8/12/16/20").ED("1.5秒間周囲の味方ユニットの移動速度を増加させる。増加移動速度: 6/8/10/12/14% 効果範囲: 850消費MN: 65 CD: 7sPower Chord - Tempo:スロー(40%,2s)効果を付与する。").EU(65.0).EV(7.0);
		boot.Bv.bkc.Dy().ED("前方範囲の敵Championに魔法DMを与え、1.5秒間強制的に踊らせる(スタン)。").EI(100.0,50.0).EH(140.0,-20.0).EJ(1000.0);
		boot.Bv.bkd.Dy().Dz("{1}の味方Championは{2}を得る。").EA(1,boot.BK.jn,1000.0).EA(2,boot.BK.fj,16.0);
		boot.Bv.bke.Dy().ED("{1}の敵ユニットに{2}を与え、スタックを1つ増加させる。スタック1つにつき{3}を与える。スタックは5秒間持続し最大10まで増加する。").EA(1,boot.BK.jn,675.0).EG(2,boot.BK.f,60.0,25.0,boot.Bv.EE(0.4)).EK(3,boot.BK.fd,8.0,1).EI(20.0,15.0).EV(2.5);
		boot.Bv.bkf.Dy().ED("対象の味方ユニットは{1}し、3秒間{2}を得る。").EG(1,boot.BK.he,70.0,70.0,boot.Bv.EE(0.45)).EK(2,boot.BK.ff,25.0,20.0).EI(80.0,30.0).EV(20.0).EJ(750.0);
		boot.Bv.bkg.Dy().ED("対象の味方Championに使用すると{1}する。敵ユニットに使用すると{2}と{3}を与える。このスキルはSoraka自身を対象とすることが出来ない。").EK(1,boot.BK.hg,40.0,40.0).EG(2,boot.BK.f,50.0,50.0,boot.Bv.EE(0.6)).EK(3,boot.BK.hn,1.5,0.25).EI(40.0,40.0).EV(10.0).EJ(725.0);
		boot.Bv.bkh.Dy().ED("全ての味方Championは{1}する。").EG(1,boot.BK.he,200.0,120.0,boot.Bv.EE(0.7)).EI(100.0,75.0).EH(160.0,-15.0);
		boot.Bv.bki.Dy().Dz("敵ユニットを倒す毎に{1}する。").EG(1,boot.BK.hg,9.0,0,boot.Bv.ER(boot.BK.gm,1));
		boot.Bv.bkj.Dy().ED("Swainの位置にビームを吐くカラスを設置し、対象の敵ユニットに毎秒{1}と{2}を与える。3秒経つか対象のユニットがカラスの有効範囲外({3})に移動すると効果が切れる。").EG(1,boot.BK.f,25.0,15.0,boot.Bv.EE(0.3)).EK(2,boot.BK.ie,20.0,5.0).EA(3,boot.BK.jn,900.0).EI(60.0,10.0).EV(8.0).EJ(625.0);
		boot.Bv.bkk.Dy().ED("地点を指定した0.5秒後に範囲内の敵ユニットに{1}と{2}を与える。").EG(1,boot.BK.f,80.0,40.0,boot.Bv.EE(0.7)).EA(2,boot.BK.hk,2.0).EI(80.0,10.0).EH(18.0,-2.0).EJ(900.0);
		boot.Bv.bkl.Dy().ED("対象の敵ユニットに4秒かけて{1}を与える。また、効果中はSwainが対象のユニットに与える{2}する。").EG(1,boot.BK.f,75.0,40.0,boot.Bv.EE(0.8)).EK(2,boot.BK.d,8.0,3.0).EI(65.0,5.0).EV(10.0).EJ(625.0);
		boot.Bv.bkm.Dy().ED("カラスに変身し、{0}の敵ユニット3体(敵Championを優先)に毎秒{1}を与える。また、{2}して敵Championの場合は{3}する。").EA(0,boot.BK.jn,700.0).EG(1,boot.BK.f,50.0,25.0,boot.Bv.EE(0.2)).EG(2,boot.BK.he,0,0,boot.Bv.ER(boot.BK.k,0.25)).EG(3,boot.BK.he,0,0,boot.Bv.ER(boot.BK.j,0.75)).EV(8.0).Eu(boot.BK.bg,new boot.CK(25.0,0,1,0),boot.Bv.EY(boot.BK.jl,5.0,1)).EW(boot.CC.d);
		boot.Bv.bkn.Dy().Dz("各スキルを最高ランクまで上げると追加効果が発生する。・Dark Sphere：Championに対するDMが15%増加する。・Force of Will：スローの効果時間が2sになる。・Scatter the Weak：扇形範囲の横幅が50%増加する。・Unleashed Power：射程が75増加する。");
		boot.Bv.bko.Dy().ED("指定地点にDark Sphereを召喚し、周囲の敵ユニットに魔法DMを与える。Dark Sphereはその後6秒間持続する。").EI(40.0,10.0).EV(4.0).EJ(800.0);
		boot.Bv.bkp.Dy().ED("指定したDark Sphereか敵minionまたは中立モンスター(DragonとBaronには無効)のいずれかを自身まで引き寄せ、最大5秒間引っ張り続ける。この際Dark Sphereを引き寄せた場合、そのDark Sphereの持続時間は引き寄せてから6秒間に更新される。その後再度地点を指定することで指定地点に引き寄せたものを投げ、その周囲の敵ユニットに魔法DMとスロー(1.5s)を与える。また指定地点の視界を得る。").EI(60.0,10.0).EH(12.0,-1.0);
		boot.Bv.bla.Dy().ED("指定方向扇形の範囲にいる敵ユニットに魔法DMを与え、ノックバックさせる。ノックバック距離はSyndraに近い地点にいるほど増加する。扇形の範囲内にDark Sphereがあった場合同様にノックバックさせ、それに当たった敵ユニットに同様の魔法DM(このスキルのDMとは重複しない)とスタン(1.5s)を与える。").EU(50.0).EH(18.0,-1.5).EJ(650.0);
		boot.Bv.blb.Dy().ED("自身の周辺にDark Sphereを3つ召喚し、指定した敵Championに向けて自身の周囲に存在する全てのDark Sphereを向かわせ、魔法DMを与える。この際に召喚したDark Sphereは6秒間持続する。").EU(100.0).EH(100.0,-10.0).EJ(675.0);
		boot.Bv.blc.Dy().Dz("スロー、スタン、スネア、サプレッションを受けている状態の敵ユニットに対しては通常攻撃のダメージが10%上昇する。");
		boot.Bv.bld.Dy().ED("次の通常攻撃に追加物理DMが付与される。対象がChampionの場合、更に6秒間対象を出血させその間毎秒物理DMを与える。また出血中の対象の視界を得る。").EI(40.0,5.0).EH(8.0,-1.0);
		boot.Bv.ble.Dy().ED("前方指定範囲に飛んだ後すぐ戻る刃を投げ当たった敵ユニットに物理DMとスロー(2s)を与える。刃は戻り際にも判定がある。").EI(60.0,5.0).EV(10.0).EJ(600.0);
		boot.Bv.blf.Dy().ED("対象の敵ユニットに跳躍しサイレンス(1s)とマーク(3s)を与える。マークがついた敵ユニットに対してはTalonが与えるダメージが増加する。").EI(35.0,5.0).EH(18.0,-2.0).EJ(700.0);
		boot.Bv.blg.Dy().ED("Talonの周囲に8本の刃を投げ当たった敵ユニットに物理DMを与え、同時に2.5秒間ステルスになりその間移動速度が40%増加する。ステルスが解除される、または敵ユニットを攻撃すると刃がTalonの元に戻ってくる。刃は戻り際にも判定がある。").EI(80.0,10.0).EH(75.0,-10.0).EJ(1000.0);
		boot.Bv.blh.Dy().Dz("通常攻撃をすると{1}する。").EG(1,boot.BK.hg,0,0,boot.Bv.ER(boot.BK.k,0.075));
		boot.Bv.blh.ET(boot.BR.k).Dz("通常攻撃に追加{1}を付与する。敵チャンピオンに対しては{2}を与える。建物には無効。").EG(1,boot.BK.f,0,0,boot.Bv.ER(boot.BK.bg,0.02)).EG(2,boot.BK.f,0,0,boot.Bv.ER(boot.BK.bg,0.04));
		boot.Bv.bli.Dy().ED("対象の味方ユニットとTaricの{1}する。自身に使用した場合は{2}する。このスキルは自身が通常攻撃を行う毎にCDが1秒解消される。対象が敵Championの場合は3秒解消される。").EG(1,boot.BK.he,60.0,40.0,boot.Bv.EE(0.6)).EG(2,boot.BK.he,84.0,56.0,boot.Bv.EE(0.84)).EI(80.0,15.0).EH(20.0,-1.0).EJ(750.0);
		boot.Bv.blj.Dy().Dz("Taricは{1}を得て、味方Championの{1}を増加させる{2}のAuraを得る。(Taric自身はAuraと合わせて2倍の効果を得る)").EK(1,boot.BK.ff,10.0,5.0).EA(2,boot.BK.jn,1000.0).ED("{4}の敵ユニットに{5}を与え、4秒間{6}を与える。効果後はCDが解消されるまでPassiveのTaric自身の増加ARが無くなる。").EA(4,boot.BK.jn,400.0).EG(5,boot.BK.f,60.0,45.0,boot.Bv.EE(0.6)).EK(6,boot.BK.en,10.0,5.0).EI(50.0,10.0).EV(10.0);
		boot.Bv.blj.ET(boot.BR.k).Dz("Taricは{1}を得て、味方Championの{3}を増加させる{2}のAuraを得る。(Taric自身はAuraと両方の効果を得る)").EG(3,boot.BK.ff,0,0,boot.Bv.ER(boot.BK.ff,0.12)).EQ(5,boot.BK.f,60.0,45.0,boot.Bv.EE(0.6),boot.Bv.ER(boot.BK.ff,0.3)).EU(50.0);
		boot.Bv.blk.Dy().ED("対象の敵ユニットに{1}と{2}を与える。魔法DMは対象との距離が近いほど増加し、距離が遠いほど低下する。最大DMは{3}。").EG(1,boot.BK.f,80.0,60.0,boot.Bv.EE(0.8)).EA(2,boot.BK.hj,1.5).EG(3,boot.BK.f,40.0,30.0,boot.Bv.EE(0.3)).EU(95.0).EH(14.0,-1.0).EJ(625.0);
		boot.Bv.blk.ET(boot.BR.k).EU(75.0);
		boot.Bv.bll.Dy().ED("{1}の敵ユニットに{2}を与える。スキル使用後の10秒間、{3}と{4}を得て、更に近くの味方Championの{5}と{6}を増加させるAura({7})を展開する。").EA(1,boot.BK.jn,400.0).EG(2,boot.BK.f,150.0,100.0,boot.Bv.EE(0.7)).EK(3,boot.BK.dc,30.0,20.0).EK(4,boot.BK.ea,30.0,20.0).EK(5,boot.BK.dc,15.0,10.0).EK(6,boot.BK.ea,15.0,10.0).EA(7,boot.BK.jn,1000.0).EU(100.0).EV(60.0);
		boot.Bv.blm.Dy().Dz("2秒間動かないとステルス状態になる。何か行動を行うか、強制的に移動させられるとステルスが解除され、ステルス解除後3秒間攻撃速度が40%増加する。");
		boot.Bv.bln.Dy().ED("対象の敵ユニットに魔法DMとブラインドを与える。").EI(70.0,10.0).EV(8.0).EJ(680.0);
		boot.Bv.blo.Dy().Dz("Teemoの移動速度が増加する。敵Championかタワーからダメージを受けると5秒間効果が切れる。増加移動速度: 10/14/18/22/26%").ED("3秒間Passiveの増加移動速度が倍になる。移動速度が倍の間は敵Championやタワーからのダメージで効果が切れない。").EU(40.0).EV(17.0);
		boot.Bv.blp.Dy().Dz("通常攻撃時に追加魔法DMと毒が付与される。毒は4秒間持続し、毎秒魔法DMを与える。");
		boot.Bv.bma.Dy().ED("指定地点に10分間持続するキノコの罠を仕掛ける(設置後1秒でステルス状態となる)。使用時にスタックを消費する。敵ユニットがステルス状態の罠を踏むと破裂し、周囲のユニットに4秒かけて魔法DMとスロー(4s)を与える。一定時間毎にスタック数が1つ増加し最大3つまでスタックされる。スタック増加時間はCD低減の影響を受ける。設置したキノコはChampionの通常攻撃でのみダメージを与えられる。").EV(1).EJ(230.0);
		boot.Bv.bmb.Dy().Dz("レベルアップでArmorを得る事ができない。自身の周囲で敵ユニットが死んだ場合、一定の確率で魂(Soul)を落とす。魂へ近づくかDark Passageのランタンを魂の近くに置くとその魂を回収する事ができ、自身のArmorとAbility Powerが上昇する。落とした魂は15秒間持続し、敵チームがThreshの視界を得ていた場合、敵チームからも視認することができる。");
		boot.Bv.bmc.Dy().Dz("通常攻撃に追加魔法DMを付与する。このDMはDamnationのスタック数と、自身が前回敵ユニットに通常攻撃をしてから経過した時間に比例して増加する。建物を攻撃した場合は追加魔法DMは発生せず、時間がリセットされる事もない。追加魔法DM(最小): Damnationのスタック数追加魔法DM(最大): Damnationのスタック数 + [攻撃力 × 80/110/140/170/200%]").ED("指定方向に鎌を投げ、命中した敵ユニットに魔法DMとスタン(1.5s)を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。").EU(80.0).EH(18.0,-1.5).EJ(1075.0);
		boot.Bv.bmd.Dy().ED("指定地点に6秒間持続するランタンを設置する。味方Championがランタンを指定すると、ランタンとその味方Championが自身の方へと引き寄せられる。更にランタンの周囲にいる魂を自動的に回収し、味方Championにダメージを一定値軽減するシールドを付与する。シールドを得られるのは1ユニットにつき1回のみ。自身がランタンから距離1500以上離れるとランタンは自動的に自身の下へと戻る。").EU(40.0).EH(22.0,-1.5).EJ(950.0);
		boot.Bv.bme.Dy().ED("自身後方から前方への帯状領域内の敵ユニットに魔法DMを与える。また自身後方にいる敵ユニットは自身に近づく向きに、自身前方にいる敵ユニットには自身から遠ざかる向きにノックバックさせ、スロー(1.5s)を与える。").EI(60.0,5.0).EV(9.0);
		boot.Bv.bmf.Dy().ED("自身の周囲に五角形の壁を創り出し、最初に壁に触れた敵Championに魔法DMとスロー(99%,2s)を与える。2つ目以降の壁に触れた敵championには半分の魔法DMとスロー(99%,1s)を与える。敵が触れた部分の壁は破壊され消滅する。").EU(100.0).EH(150.0,-10.0);
		boot.Bv.bmg.Dy().Dz("通常攻撃とExplosive Shotは追加の{1}を得る。").ES(1,boot.BK.gj,new boot.CF(0,9.0,1));
		boot.Bv.bmh.Dy().ED("7秒間{1}する。").EK(1,boot.BK.di,30.0,15.0).EU(50.0).EV(20.0);
		boot.Bv.bmi.Dy().ED("指定地点にジャンプしジャンプ先の{1}の敵ユニットに{2}と2.5秒間{3}を与える。キルかアシストをとるとこのスキルの{4}する。").EO(1,boot.BK.jn).EG(2,boot.BK.f,70.0,45.0,boot.Bv.EE(0.8)).EA(3,boot.BK.ie,60.0).EO(4,boot.BK.hd).EU(80.0).EH(22.0,-2.0).EJ(800.0);
		boot.Bv.bmj.Dy().Dz("通常攻撃で敵ユニットを倒した時にそのユニットの{1}の敵ユニットに{2}を与える。").EA(1,boot.BK.jn,150.0).EG(2,boot.BK.f,50.0,25.0,boot.Bv.EE(0.25)).ED("対象の敵ユニットに5秒かけて{3}と{4}を与える。").EG(3,boot.BK.f,110.0,40.0,boot.Bv.EE(1)).EO(4,boot.BK.ii).EI(50.0,10.0).EV(16.0).Ew(new boot.CK(616.0,0,1,0),boot.Bv.ER(boot.BK.gm,9.0));
		boot.Bv.bmk.Dy().ED("対象の敵ユニットに{1}を与え、対象と{2}の敵ユニットを{3}させる。").EG(1,boot.BK.f,300.0,100.0,boot.Bv.EE(1.5)).EA(2,boot.BK.jn,200.0).EK(3,boot.BK.ic,600.0,200.0).EU(100.0).EV(60.0).EJ(700.0);
		boot.Bv.bml.Dy().Dz("{1}以内で敵ユニットが死んだとき、{2}する。レベル1、5、9、12、15で回復する割合が上昇する。").EA(1,boot.BK.jn,1000.0).EG(2,boot.BK.he,0,0,boot.Bv.EZ(boot.BK.p,new boot.CL(0.02,0.01,0)));
		boot.Bv.bmm.Dy().ED("次の通常攻撃のダメージが変更され、攻撃後自身の攻撃力が8秒間増加し、攻撃を受けたユニットの攻撃力をその半分だけ減少させる。建物には無効。").EU(30.0).EV(4.0);
		boot.Bv.bmn.Dy().ED("指定範囲に8秒間持続する呪いを振りまく。範囲内に入っている間、自身の攻撃速度と移動速度が上昇し、受けるCC(Stun, Slow, Taunt, Fear, Snare, Silence, Blind)の効果時間が低減される。").EU(60.0).EV(15.0).EJ(900.0);
		boot.Bv.bmo.Dy().ED("指定地点に7秒間持続する通行不可能なビーコンを設置し、ビーコンの周囲にいる敵ユニットにスローを与える。また、指定地点の視界を得る。").EU(60.0).EH(23.0,-3.0).EJ(1000.0);
		boot.Bv.bmp.Dy().ED("対象の敵ユニットのHPを一定量(魔法DM)、ARとMRを割合で奪う。その後6秒間かけて、合計で最初に吸収した量と同じだけのHP、AR、MRを奪う(つまり合計で2倍)。この効果は対象が吸収を受けている間続く。").EU(75.0).EH(80.0,-10.0).EJ(700.0);
		boot.Bv.bna.Dy().Dz("{1}する。通常攻撃時に5Fury、クリティカル時に10Fury、Spinning Slashが敵ユニットに命中するたびに2Furyを得る。敵ユニットを倒すと追加で10Furyを得る。Furyの上限は100、8秒間戦闘を行わないと毎秒5Furyずつ減少していく。建物を攻撃した場合はFuryは増加しない。").EG(1,boot.BK.dm,0,0,boot.Bv.ER(boot.BK.ke,0.35)).EC(1);
		boot.Bv.bnb.Dy().Dz("{1}を得る。").EG(1,boot.BK.dc,5.0,5.0,boot.Bv.EY(boot.BK.cf,0.15,0.05)).ED("Furyをすべて消費し{2}する。").EQ(2,boot.BK.he,30.0,10.0,boot.Bv.EE(1.5),boot.Bv.EY(boot.BK.ke,0.5,0.45)).EV(12.0);
		boot.Bv.bnb.ET(boot.BR.k).EQ(2,boot.BK.he,30.0,10.0,boot.Bv.EE(0.3),boot.Bv.EM(boot.BK.ke,0.5,0.45,boot.Bv.EE(0.012)));
		boot.Bv.bnc.Dy().ED("4秒間近くの敵Championに{1}を与え、後ろを向いている敵Championには更に4秒間{2}を与える。").EK(1,boot.BK.ih,20.0,15.0).EK(2,boot.BK.ie,30.0,7.5).EV(14.0).EJ(850.0);
		boot.Bv.bnd.Dy().ED("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに{1}を与える。このスキルはクリティカルが発生するたびに{2}する。").EQ(1,boot.BK.e,70.0,30.0,boot.Bv.EE(1),boot.Bv.EL(1.2)).EA(2,boot.BK.hd,2.0).EH(13.0,-1.0).EJ(660.0);
		boot.Bv.bne.Dy().ED("5秒間HPが1未満にならなくなる(死ななくなる)。また、このスキル使用時にFuryが{1}増加する。このスキルの使用は状態異常によって阻害されない。").EK(1,boot.BK.jm,50.0,25.0).EH(110.0,-10.0);
		boot.Bv.bnf.Dy().Dz("味方Championが敵を倒した時に追加で{1}を得るようになる。").EA(1,boot.BK.ji,2.0);
		boot.Bv.bng.Dy().ED("指定向き3方向に貫通するカードを飛ばし、当たった敵ユニットに{1}を与える。").EG(1,boot.BK.f,60.0,50.0,boot.Bv.EE(0.65)).EI(60.0,10.0).EV(6.0).EJ(1450.0);
		boot.Bv.bnh.Dy().ED("使用するとBlue、Red、Goldの3種のカードを選択し始め、再度使用でカードが決定する。決定したカードにより次の通常攻撃が魔法DMに変換され、以下の効果が追加される。Blue Card: {2}を与え{3}する。　Red Card: {4}の敵に{5}と2.5秒間{6}を与える。　Gold Card: {7}と{8}を与える。").EQ(2,boot.BK.f,40.0,20.0,boot.Bv.EE(0.4),boot.Bv.EP(1)).EG(3,boot.BK.hg,26.0,13.0,boot.Bv.EP(0.65)).EA(4,boot.BK.jn,100.0).EQ(5,boot.BK.f,30.0,15.0,boot.Bv.EE(0.4),boot.Bv.EP(1)).EK(6,boot.BK.ie,30.0,5.0).EQ(7,boot.BK.f,15.0,7.5,boot.Bv.EE(0.4),boot.Bv.EP(1)).EK(8,boot.BK.hj,1.2,0.2).EI(40.0,15.0).EV(6.0);
		boot.Bv.bni.Dy().Dz("{1}を得て{2}する。通常攻撃4回毎に追加{3}を与える。").EK(1,boot.BK.ed,3.0,3.0).EK(2,boot.BK.di,3.0,3.0).EG(3,boot.BK.f,55.0,25.0,boot.Bv.EE(0.4));
		boot.Bv.bnj.Dy().ED("{1}間すべての敵Champion(ステルス中のChampion含む)の視界を得る。効果中に再度使用すると2秒間移動・攻撃が不可能になった後、指定した地点にワープする。。効果中は敵Championの頭上にアイコンが表示される。").EK(1,boot.BK.jj,6.0,2.0).EI(150.0,-25.0).EH(150.0,-15.0).EJ(5500.0);
		boot.Bv.bnk.Dy().Dz("通常攻撃時に毒を付与し、６秒間かけて{1}を与える。毒は6回までスタックする。レベル1、6、11、16でダメージが増加する。").ES(1,boot.BK.g,new boot.CM(12.0,12.0,0));
		boot.Bv.bnl.Dy().ED("使用から1.25秒後に{1}になる。ステルス状態では{2}し、ステルスを解除すると5秒間{3}する。ステルス準備中に攻撃を行うかダメージを受けると、ステルス状態になるのに再度1.25秒必要になる。ステルス準備開始から5秒経過するとダメージを受けていてもステルス状態になる。").EK(1,boot.BK.jc,4.0,1).EA(2,boot.BK.im,20.0).EK(3,boot.BK.di,30.0,10.0).EU(60.0);
		boot.Bv.bnm.Dy().ED("指定地点に{1}で毒の入った瓶を投げつけ、範囲内の敵ユニットに3秒間{2}と毒を2スタック分与える。また、指定した地点の{3}。").EA(1,boot.BK.ka,1400.0).EK(2,boot.BK.ie,25.0,5.0).EO(3,boot.BK.jd).EU(50.0).EH(13.0,-1.0).EJ(950.0);
		boot.Bv.bnn.Dy().ED("毒をスタックされている{1}の敵ユニットに{2}を与える。").EA(1,boot.BK.jn,1200.0).EG(2,boot.BK.e,40.0,10.0,boot.Bv.Ex(boot.BK.ke,15.0,5.0,boot.Bv.EE(0.2),boot.Bv.EL(0.25))).EI(50.0,10.0).EH(12.0,-1.0);
		boot.Bv.bno.Dy().ED("7秒間射程が850になり{1}を得て、通常攻撃が敵ユニットを貫通するようになる。対象との直線上にいる敵ユニットにもダメージと毒スタックを与える。ダメージは敵に当たるごとに20%減少する。最小で40%。").EK(1,boot.BK.dc,20.0,8.0).EI(100.0,25.0).EH(120.0,-10.0);
		boot.Bv.bnp.Dy().Dz("スキルを使用する度に攻撃速度が10%増加し、ARとMRが4%増加する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒間のCDになる。");
		boot.Bv.boa.Dy().Dz("Persistent Effect:Udyrの攻撃速度が増加する。増加攻撃速度: 20/25/30/35/40%Activation:5秒間Udyrの攻撃速度が増加する(Persistent Effectと重複)。また、次の通常攻撃に追加魔法DMを付与する。このダメージは2秒かけて与えられる。建物には無効。").EI(55.0,-5.0).EV(6.0);
		boot.Bv.bob.Dy().Dz("Persistent Effect:通常攻撃でクリティカルが発生しなくなるが、通常攻撃で与えたダメージの一定割合のHPとMNが回復する。回復HP: 10/12/14/16/18% 回復MN: 5/6/7/8/9%Activation:自身に5秒間持続するシールドを付与しダメージを軽減する。").EI(55.0,-5.0).EV(6.0);
		boot.Bv.boc.Dy().Dz("Persistent Effect:通常攻撃にスタン(1s)が付与される。この効果は同一の対象に6秒に1度しか発動しない。Activation:一定時間移動速度が増加する。").EI(55.0,-5.0).EV(6.0);
		boot.Bv.bod.Dy().Dz("Persistent Effect:通常攻撃を3回行うごとに火を吹き前方の敵ユニットに魔法DMを与える。魔法DM: 40/80/120/160/200 (+0.25)Activation:5秒間周囲の敵ユニットに毎秒魔法DMを与える。またその間は攻撃力とAPが増加する。").EI(55.0,-5.0).EV(6.0);
		boot.Bv.boe.Dy().Dz("通常攻撃またはAcid Hunterでダメージを与えた対象に、与えるダメージを15%低下するDebuffを付与する。この効果は2.5秒間持続する。");
		boot.Bv.bof.Dy().ED("指定方向にミサイルを飛ばし当たった敵ユニットに{1}を与える。Noxian Corrosive Chargeの効果を受けている敵ユニットの近くを指定して使用すると、その敵ユニット目掛けてミサイルが飛んでいく。").EG(1,boot.BK.e,10.0,30.0,boot.Bv.EP(0.85)).EU(40.0).EV(2.0).EJ(1000.0);
		boot.Bv.bog.Dy().ED("7秒間{1}を得る。シールドが残っている間は通常攻撃とAcid Hunterに1秒間{2}が付与される。").EG(1,boot.BK.gf,80.0,40.0,boot.Bv.EE(0.8)).EK(2,boot.BK.ie,20.0,5.0).EI(55.0,5.0).EH(16.0,-1.0);
		boot.Bv.boh.Dy().ED("指定地点に爆弾を飛ばし{1}の敵ユニットに5秒間かけて{2}と{3}を与える。また指定地点の{4}。").EA(1,boot.BK.jn,300.0).EG(2,boot.BK.e,75.0,55.0,boot.Bv.EL(0.6)).EK(3,boot.BK.ie,12.0,2.0).EO(4,boot.BK.jd).EI(50.0,5.0).EH(15.0,-1.0).EJ(900.0);
		boot.Bv.boi.Dy().ED("対象の敵Championに{1}を与え、5秒間{2}と{3}を得る。1秒詠唱後に敵Championと自分の位置を入れ替え、敵Championに3秒間{4}を与える。").EA(1,boot.BK.ia,1).EK(2,boot.BK.ff,60.0,30.0).EK(3,boot.BK.fj,60.0,30.0).EA(4,boot.BK.ie,40.0).EU(120.0).EV(120.0).EX(550.0,150.0);
		boot.Bv.boj.Dy().Dz("敵ユニットを倒すと3秒間{1}する。敵Championをキル/アシストすると6秒間{2}する。この効果はスタックしない。").EA(1,boot.BK.di,20.0).EA(2,boot.BK.di,40.0).EC(1).EC(2);
		boot.Bv.bok.Dy().ED("最初にスキルを使用すると狙いを付ける。この間は通常攻撃や他のスキルを使用できなくなり、Varusの移動速度が20%低下するが、狙いを付けている間は徐々にこのスキルのダメージと射程距離が増加していく(2秒で最大)。再度このスキルを使用することで指定方向に貫通する矢を放ち、当たった敵ユニットに{1}を与える(最大で{2})。ダメージは敵に当たるごとに15%減少する。最小で33%。狙いを付けて4秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。").EG(1,boot.BK.e,10.0,33.0,boot.Bv.EP(1)).EG(2,boot.BK.e,15.0,50.0,boot.Bv.EP(1.65)).EI(70.0,5.0).EH(16.0,-2.0).Ew(new boot.CK(850.0,0,1,0),boot.Bv.ER(boot.BK.jl,200.0));
		boot.Bv.bol.Dy().Dz("通常攻撃に追加{1}と6秒間持続する疫病が付与される。疫病は3回までスタックする。疫病のスタックが付与されている敵ユニットにVarusの他のスキルが命中した場合、疫病のスタックを全て消費して1スタック毎に{2}を与える。").EG(1,boot.BK.f,10.0,4.0,boot.Bv.EE(0.25)).EG(2,boot.BK.f,0,0,boot.Bv.EM(boot.BK.cg,2.0,0.75,boot.Bv.EE(0.02)));
		boot.Bv.bom.Dy().ED("指定地点に矢の雨を放ち、範囲内の敵ユニットに{1}を与える。指定地点は4秒間呪われ、範囲内の敵ユニットに{2}と{3}を付与する。").EG(1,boot.BK.e,65.0,40.0,boot.Bv.EL(0.6)).EK(2,boot.BK.ie,25.0,5.0).EO(3,boot.BK.ii).EU(80.0).EH(18.0,-2.0).EJ(925.0);
		boot.Bv.bon.Dy().ED("指定方向に腐敗の蔓を投げつけ、当たった敵Championに{1}と{2}を与える。当たった敵Championからは徐々に腐敗が広がり({3})、腐敗に触れた敵Championにも同様の効果を与える。").EG(1,boot.BK.f,150.0,100.0,boot.Bv.EE(1)).EA(2,boot.BK.hk,2.0).EA(3,boot.BK.jn,550.0).EU(120.0).EH(120.0,-15.0).EJ(1075.0);
		boot.Bv.boo.Dy().Dz("敵Championに向かって移動する際に{1}する。").EA(1,boot.BK.ik,30.0).EC(1);
		boot.Bv.bop.Dy().ED("指定地点にローリングし、次の通常攻撃に追加{1}を付与する。6秒間攻撃を行わないとCDになる。").EG(1,boot.BK.e,0,0,boot.Bv.EY(boot.BK.dc,0.3,0.05)).EU(40.0).EH(6.0,-1.0);
		boot.Bv.bop.ET(boot.BR.k).EU(30.0);
		boot.Bv.bpa.Dy().Dz("同じターゲットに3回連続して通常攻撃またはスキルで攻撃すると、{1}を与える。").EG(1,boot.BK.g,20.0,10.0,boot.Bv.EY(boot.BK.cg,3.0,1));
		boot.Bv.bpb.Dy().ED("対象の敵ユニットをヘビークロスボウで狙撃し{1}と{2}を与える。ノックバックした敵が壁等に当たると追加で{1}と{3}を与える。").EG(1,boot.BK.e,45.0,35.0,boot.Bv.EL(0.5)).EO(2,boot.BK.ic).EA(3,boot.BK.hj,1.5).EU(90.0).EH(20.0,-2.0).EJ(450.0);
		boot.Bv.bpc.Dy().ED("{1}間{2}を得て、Tumbleを使うと{3}になり、Night Hunterの移動速度増加が3倍になる。").EK(1,boot.BK.jj,8.0,2.0).EK(2,boot.BK.dc,25.0,15.0).EA(3,boot.BK.jc,1).EU(80.0).EV(70.0);
		boot.Bv.bpd.Dy().Dz("{1}を得る。").EG(1,boot.BK.bm,0,0,boot.Bv.ER(boot.BK.cm,1));
		boot.Bv.bpe.Dy().Dz("敵Championを倒すと{1}を得る。").EK(1,boot.BK.ea,1,1).EC(1).ED("対象の敵ユニットに{2}を与える。このスキルでLHを取るとAPが1増加する。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+2)になる。").EG(2,boot.BK.f,80.0,45.0,boot.Bv.EE(0.6)).EI(60.0,5.0).EH(8.0,-1.0).EJ(650.0);
		boot.Bv.bpf.Dy().ED("指定地点に1.2秒後に隕石を降らし、{1}の敵ユニットに{2}を与える。また隕石が落下するまでの間、指定地点の{3}。").EA(1,boot.BK.jn,225.0).EG(2,boot.BK.f,120.0,50.0,boot.Bv.EE(1)).EO(3,boot.BK.jd).EI(70.0,10.0).EV(10.0).EJ(900.0);
		boot.Bv.bpg.Dy().ED("指定した{1}に3秒間魔法陣を呼び出し、魔法陣の縁に触れた敵ユニットに{2}を与える。").EA(1,boot.BK.jn,425.0).EK(2,boot.BK.hj,1.5,0.25).EI(80.0,10.0).EH(20.0,-1.0).EJ(600.0);
		boot.Bv.bph.Dy().ED("対象の敵Championに{1}を与える。").EQ(1,boot.BK.f,250.0,125.0,boot.Bv.EE(1.2),boot.Bv.ER(boot.BK.cn,0.8)).EI(125.0,50.0).EH(130.0,-20.0).EJ(650.0);
		boot.Bv.bpi.Dy().Dz("敵ユニットにスキルでダメージを与えると、3秒間{1}を得る。レベル1/7/12でCDが減少する。").EG(1,boot.BK.gf,0,0,boot.Bv.ER(boot.BK.p,0.1)).Ey(new boot.CN(18.0,-5.0,0));
		boot.Bv.bpj.Dy().ED("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵Championに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。").EG(1,boot.BK.e,50.0,30.0,boot.Bv.EL(0.7)).EG(2,boot.BK.e,100.0,60.0,boot.Bv.EL(1.4)).EA(3,boot.BK.jp,50.0).EA(4,boot.BK.jp,600.0).EI(50.0,10.0).EH(18.0,-2.5).EJ(50.0);
		boot.Bv.bpj.ET(boot.BR.k).ED("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵Championに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。途中で詠唱を停止させられた場合、このスキルのCDは3秒になり、消費したmanaの半分が回復する。");
		boot.Bv.bpk.Dy().Dz("同一対象に3回連続して通常攻撃を行うと、{1}と4秒間{2}を与え、4秒間{3}する。(ミニオンやモンスターへは最大300DMを与える)").EG(1,boot.BK.e,0,0,boot.Bv.EM(boot.BK.cg,6.0,1,boot.Bv.EL(0.03))).EA(2,boot.BK.eo,20.0).EK(3,boot.BK.di,30.0,5.0);
		boot.Bv.bpk.ET(boot.BR.k).EG(1,boot.BK.e,0,0,boot.Bv.EM(boot.BK.cg,4.0,1.5,boot.Bv.EL(0.03)));
		boot.Bv.bpl.Dy().ED("チャージを1つ消費することで、次の通常攻撃に追加{1}を付与し、対象とその後方扇形{2}にいる敵ユニットにもダメージを与える範囲攻撃になる。チャージは{3}毎に増加し、最大2つまでスタックされる。").EQ(1,boot.BK.e,5.0,15.0,boot.Bv.EP(1.15),boot.Bv.EE(0.7)).EA(2,boot.BK.jn,600.0).EK(3,boot.BK.jk,14.0,-1.5).EU(60.0).EV(1);
		boot.Bv.bpm.Dy().ED("対象の敵Championに突撃し、{1}と{2}を与える。一連の動作中は{4}を得て、また対象のChampion以外でViに触れた敵ユニットには{3}を与え、左右に吹き飛ばす。").EG(1,boot.BK.e,200.0,125.0,boot.Bv.EL(1.4)).EA(2,boot.BK.ib,1.25).EG(3,boot.BK.e,150.0,112.5,boot.Bv.EL(1.05)).EO(4,boot.BK.jb).EI(100.0,25.0).EH(130.0,-25.0).EJ(700.0);
		boot.Bv.bpn.Dy().Dz("Viktorは最初からHex Coreという、自身のステータスとスキルの効果を強化するアイテムを所持している。Hex Coreは1度だけショップで1000Gを消費して以下の３通りのいずれかにアップグレードすることが出来る。Hex CoreはViktorのアイテムスロットを1つ占有し、売却することは出来ない。Hex Core : +3 ability power per levelAugment: Power+3 ability power per level、+220 health、+6 health regen per 5sを得る。また、Power Transfer使用・命中時に移動速度が3秒間30%増加する。Augment: Gravity+3 ability power per level、+200 mana、+10% cooldown reduction、+5 mana regen per 5sを得る。また、Gravity Fieldの射程が30%増加する。Augment: Death+3 ability power per level、+45 ability powerを得る。また、Death Rayにダメージの30%分の追加魔法DMが付与される。このダメージは4秒間かけて与える。");
		boot.Bv.bpo.Dy().ED("対象の敵ユニットに魔法DMを与え、ダメージの40%をシールドとして得る。シールドは3秒間持続する。").EI(45.0,5.0).EH(9.0,-1.0).EJ(600.0);
		boot.Bv.bpp.Dy().ED("0.25秒詠唱後、指定範囲に4秒間持続する重力束縛装置を呼び出し、範囲内の敵ユニットにスローを与え、0.5秒毎にスタックを付与する。スタックが3溜まった敵ユニットにはスタン(1.5s)を与える。").EU(65.0).EH(17.0,-1.0).EJ(625.0);
		boot.Bv.caa.Dy().ED("指定地点から指定方向にビームを発射し、ビームが通過する線上の敵ユニットに魔法DMを与える。また、ビームが通過した地点の視界を得る。").EI(70.0,10.0).EH(13.0,-1.0).EJ(700.0);
		boot.Bv.cab.Dy().ED("指定地点に7秒間持続する特異点を呼び出し、範囲内の敵ユニットに魔法DMとサイレンス(0.5s)を与える。特異点は周囲の敵ユニットに毎秒魔法DMを与え、また近くにいる敵Championを自動的に追尾する。このスキルがActiveの間に再度地点を指定することで、特異点を指定した地点に手動で移動させる事が出来る。").EI(125.0,50.0).EV(120.0).EJ(700.0);
		boot.Bv.cac.Dy().Dz(""+boot.BK.bc+"に比例して{1}を、"+boot.BK.ea+"に比例して{2}を得る。").EG(1,boot.BK.ea,0,0,boot.Bv.ER(boot.BK.bc,0.025)).EG(2,boot.BK.p,0,0,boot.Bv.EE(1.4));
		boot.Bv.cad.Dy().ED("対象の敵ユニットに{1}を与え、{2}する。").EG(1,boot.BK.f,90.0,35.0,boot.Bv.EE(0.6)).EG(2,boot.BK.he,15.0,10.0,boot.Bv.EE(0.25)).EH(10.0,-1.5).EJ(600.0);
		boot.Bv.cae.Dy().ED("Vladimirが2秒間血の海に沈む。その間はターゲットされなくなり、{1}内にいる敵ユニットに0.5秒毎に{2}と{3}間の{4}を与え続ける。また、与えたダメージの12.5%Healthが回復する。").EA(1,boot.BK.jn,300.0).EG(2,boot.BK.f,20.0,13.75,boot.Bv.ER(boot.BK.bc,0.00375)).EA(3,boot.BK.jj,1).EA(4,boot.BK.ie,40.0).EB(boot.BK.cd,20.0,0).EH(26.0,-3.0);
		boot.Bv.caf.Dy().ED("{1}の敵ユニットに{2}を与える。使用する度にスタックが増加し、1スタックにつきこのスキルの基礎魔法DMとHPコストが25%増加し、{4}と{3}を得るく(最大4スタック)。スタックは10秒増加が無いと0になる。このスキルは周囲に敵ユニットがいなくても使用可能。").EA(1,boot.BK.jn,0).EG(2,boot.BK.f,60.0,25.0,boot.Bv.EE(0.45)).EK(3,boot.BK.bf,4.0,1).EK(4,boot.BK.hf,4.0,1).EB(boot.BK.p,30.0,10.0).EV(4.5).EJ(620.0);
		boot.Bv.cag.Dy().ED("指定地点の{1}の敵ユニットに疫病を付与し、その敵ユニットは5秒間受けるダメージが12%増加する。効果終了時に{2}を与える。ダメージ増加効果のため実際には{3}を与える。").EA(1,boot.BK.jn,300.0).EG(2,boot.BK.f,150.0,100.0,boot.Bv.EE(0.7)).EG(3,boot.BK.f,168.0,112.0,boot.Bv.EE(0.784)).EH(150.0,-15.0).EJ(700.0);
		boot.Bv.cah.Dy().Dz("VolibearのHPが30%以下になったとき、6秒間かけて{1}する。").EG(1,boot.BK.he,0,0,boot.Bv.ER(boot.BK.p,0.3)).EV(120.0);
		boot.Bv.cai.Dy().ED("4秒間{1}する。敵Championに向かって移動する場合は{2}する。また次の通常攻撃に追加{3}を付与し、対象をVolibearの後ろに投げ飛ばす。4秒間攻撃を行わないとCDになる。").EA(1,boot.BK.im,15.0).EA(2,boot.BK.im,45.0).EK(3,boot.BK.e,30.0,30.0).EC(2).EU(40.0).EH(12.0,-1.0);
		boot.Bv.caj.Dy().Dz("通常攻撃でダメージを与える度にスタックが1増加し(最大3スタック)、{1}する。スタックは4秒持続する。").EG(1,boot.BK.di,0,0,boot.Bv.EY(boot.BK.ke,8.0,3.0)).EC(1).ED("スタックが最大まで溜まった時のみ使用可能。対象の敵ユニットに{2}を与える。対象が失っているHP1%につきダメージが1%上昇する。").EG(2,boot.BK.e,80.0,45.0,boot.Bv.ER(boot.BK.bc,0.15)).EU(35.0).EV(17.0).EJ(400.0);
		boot.Bv.cak.Dy().ED("{1}の敵ユニットに{2}と3秒間{3}を与える。対象がMinionの場合、さらに{4}を与える。").EA(1,boot.BK.jn,425.0).EG(2,boot.BK.f,60.0,45.0,boot.Bv.EE(0.6)).EK(3,boot.BK.ie,30.0,5.0).EA(4,boot.BK.hl,3.0).EI(60.0,5.0).EV(11.0);
		boot.Bv.cal.Dy().ED("12秒間Volibearが通常攻撃した対象に雷を放ち{1}を与える。雷は対象の{2}の敵ユニット(敵Championを優先)3体にも連鎖し同様のダメージを与える。建物を攻撃する時は効果は発生しない。").EG(1,boot.BK.f,75.0,40.0,boot.Bv.EE(0.3)).EA(2,boot.BK.jn,300.0).EU(100.0).EH(100.0,-10.0);
		boot.Bv.cam.Dy().Dz("通常攻撃で対象にスタックを付与し、追加{1}を与え{2}する。スタックは4秒持続し、最大3つまでスタックされる。建物を攻撃した場合は無効。").EG(1,boot.BK.f,0,0,boot.Bv.EZ(boot.BK.ke,new boot.CF([3.0,3.5,4.0,4.5,5.0,5.5,6.0,6.5,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0,16.0],0))).EG(2,boot.BK.he,0,0,boot.Bv.EZ(boot.BK.ke,new boot.CF([3.0,3.5,4.0,4.5,5.0,5.5,6.0,6.5,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0,16.0],0)));
		boot.Bv.can.Dy().ED("対象の敵ユニットに{1}を与え、{2}する。対象がChampionの場合は{3}と比較し大きいほうのDMを与える。").EG(1,boot.BK.f,75.0,50.0,boot.Bv.EE(1)).EG(2,boot.BK.he,0,0,boot.Bv.ER(boot.BK.k,80.0)).EQ(3,boot.BK.f,0,0,boot.Bv.EE(1),boot.Bv.EY(boot.BK.cg,8.0,2.0)).EI(70.0,10.0).EH(10.0,-1.0).EJ(400.0);
		boot.Bv.cao.Dy().ED("10秒間{2}し、{1}の味方Championは{3}する。").EA(1,boot.BK.jn,1200.0).EK(2,boot.BK.di,40.0,10.0).EK(3,boot.BK.di,20.0,5.0).EC(3).EU(35.0).EH(24.0,-2.0);
		boot.Bv.cap.Dy().Dz("{1}して、{2}内にいるHPが50%以下の敵Championの{3}。このスキルで敵のステルスを看破する事はできず、ステルス中の敵Championの視界を得ることもできない。").EK(1,boot.BK.im,20.0,5.0).EK(2,boot.BK.jn,1500.0,800.0).EO(3,boot.BK.jd).EV(4.0);
		boot.Bv.cba.Dy().ED("対象の敵Championに突撃し{2}を与えて、その間{3}を得て0.36秒毎に{1}を、計5回で{4}を与える。").EG(1,boot.BK.f,50.0,17.0,boot.Bv.EL(0.4)).EA(2,boot.BK.ia,1.8).EA(3,boot.BK.dj,30.0).EG(4,boot.BK.f,250.0,85.0,boot.Bv.EL(2.0)).EW(boot.CC.e).EW(boot.CC.f).EI(100.0,25.0).EH(90.0,-10.0).EJ(700.0);
		boot.Bv.cbb.Dy().Dz("Wukongの視界内(範囲1400)にいる敵Championの数に比例して、WukongのArmorとMagic Resistが増加する。レベル1、7、13で増加値が上昇する。");
		boot.Bv.cbc.Dy().ED("次の通常攻撃の射程とダメージが増加し、対象のArmorを30%低下させる効果が付与される。Armor低下は3秒間持続する。").EU(40.0).EH(9.0,-1.0).EJ(300.0);
		boot.Bv.cbd.Dy().ED("Wukongが1.5秒間ステルス状態になり、その間ユニットを通過できるようになる。同時にWukongがいた場所に分身(操作不可能)を作り出す。分身は1.5秒経過すると消滅し、その際に分身の周囲の敵に魔法DMを与える。").EI(50.0,5.0).EH(18.0,-2.0);
		boot.Bv.cbe.Dy().ED("対象の敵ユニットまでダッシュし物理DMを与える。対象の敵ユニットの近くにいる敵ユニット2体にもWukongの幻影が飛び、同様のダメージを与える。また、スキル使用後4秒間攻撃速度が上昇する。").EI(45.0,5.0).EV(8.0).EJ(625.0);
		boot.Bv.cbf.Dy().ED("4秒間Wukongが回転する。回転中は近くにいる敵ユニットに0.5秒毎に物理DMと打ち上げ(1.5s)を与える(最大8hit)。打ち上げ効果は同一の対象に1度までしか発生しない。また、このスキルを使用してから0.5秒毎にWukongの移動速度が5%ずつ上昇していく(最大40%)。").EU(100.0).EH(120.0,-15.0);
		boot.Bv.cbg.Dy().Dz("APの15%分、ARが上昇する。");
		boot.Bv.cbh.Dy().ED("0.75秒詠唱後指定方向にビームを放ち、直線状の敵ユニットすべてに魔法DMを与える。").EI(65.0,5.0).EH(7.0,-0.5).EX(900.0,400.0);
		boot.Bv.cbi.Dy().ED("0.5秒詠唱後に移動が不可能になる代わりに、全てのスキルの射程が400増加し、Magic Penetrationが増加する。この効果は8秒経過するか、再度このスキルを使用する事で解除される。このスキルが解除された時に自身の移動速度が2秒間35%増加する。").EH(20.0,-4.0);
		boot.Bv.cbj.Dy().ED("対象の敵ユニットに魔法DMとマーク(3s)を与える。マークがついている敵ユニットにXerathのスキルが命中した場合、マークを消費して対象にスタン(1.5s)を与える。").EI(70.0,5.0).EH(12.0,-1.0).EX(600.0,400.0);
		boot.Bv.cbk.Dy().ED("地点を指定して0.5秒後に範囲内の敵ユニットに魔法DMを与える。このスキルは12秒の間、3回まで連続して使用できる(但し、一度使用する度に0.35秒のCDが発生する)。2〜3発目はマナコスト無しで使用可能。また、指定地点の視界を得る。").EI(150.0,30.0).EH(80.0,-10.0).EX(900.0,400.0);
		boot.Bv.cbl.Dy().Dz("通常攻撃または"+boot.Bv.cbo+"で指定した敵ユニットに{1}を与える。この効果はスタックせず、3秒間持続し、また1体の敵ユニットにしか発動しない。").EA(1,boot.BK.eo,15.0);
		boot.Bv.cbm.Dy().ED("次の3回の通常攻撃に{1}が追加され、3回目の攻撃で{2}を与える。効果中に通常攻撃を行う度に、このスキル以外のCDが1秒解消される。").EG(1,boot.BK.e,15.0,15.0,boot.Bv.EP(0.2)).EA(2,boot.BK.ib,1).EU(30.0).EH(9.0,-1.0);
		boot.Bv.cbn.Dy().Dz("通常攻撃3回ごとに{1}する。").EG(1,boot.BK.he,26.0,6.0,boot.Bv.EE(0.7)).ED("5秒間{2}増加する。").EK(2,boot.BK.di,40.0,10.0).EU(40.0).EH(16.0,-1.0);
		boot.Bv.cbo.Dy().ED("対象の敵ユニットに突進し、{1}の敵ユニットに{2}と2秒間{3}を与える。").EA(1,boot.BK.jn,225.0).EG(2,boot.BK.f,70.0,40.0,boot.Bv.EE(0.6)).EK(3,boot.BK.ie,25.0,5.0).EU(70.0).EH(13.0,-1.0).EJ(600.0);
		boot.Bv.cbo.ET(boot.BR.k).EG(2,boot.BK.f,70.0,35.0,boot.Bv.EE(0.6)).EH(14.0,-1.0);
		boot.Bv.cbp.Dy().ED("槍を振り回し{3}の敵ユニットに{1}と{2}を与え、このスキルを命中させた敵Championの数に比例して6秒間{4}と{5}を得る。"+boot.Bv.cbl+"効果中の敵ユニットに対しては"+boot.BK.ic+"は発動しない。").EQ(1,boot.BK.e,125.0,100.0,boot.Bv.EL(1),boot.Bv.ER(boot.BK.ch,0.15)).EA(2,boot.BK.ic,0).EA(3,boot.BK.jn,375.0).EK(4,boot.BK.ff,15.0,5.0).EK(5,boot.BK.fj,15.0,5.0).EU(100.0).EH(100.0,-10.0);
		boot.Bv.cbp.ET(boot.BR.k).EQ(1,boot.BK.e,75.0,100.0,boot.Bv.EL(1),boot.Bv.ER(boot.BK.ch,0.15)).EH(120.0,-10.0);
		boot.Bv.cca.Dy().Dz("(召喚中のGhoulsの数×5)%の被ダメージ軽減および通常攻撃のダメージ増加効果を得る。召喚したGhoulは5秒間持続し、また毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。ペット「Ghouls」HP: [YorickのHP × 35%] 攻撃力: [Yorickの攻撃力 × 35%]AR: 10 + (2 × Lv) MR: 20 + (2 × Lv)AS: 0.670 MS: 300/340/410/433 (レベル1、6、9、12で移動速度が上昇する。)【備考】任意の操作不可、スロー無効化、AoEスキルのダメージを50%低減。Ghoulsは敵ユニットの通行を妨げない(引っかからずにすり抜ける)。");
		boot.Bv.ccb.Dy().ED("次の通常攻撃時のダメージが増加し、通常攻撃時と同時にSpectral Ghoulを召喚する。Spectral GhoulはYorickの他のGhoulと比べて攻撃力が高く、移動速度が速い。Spectral Ghoulが生存している間、Yorick自身の移動速度も上昇する。").EU(40.0).EH(9.0,-1.0);
		boot.Bv.ccc.Dy().ED("指定範囲を爆発させ範囲内の敵ユニットに魔法DMとスロー(1.5s)を与え、同時にその地点にDecaying Ghoulを召喚する。Decaying Ghoulは近くの敵ユニットに継続的にスローを与える。").EI(55.0,5.0).EV(12.0).EJ(600.0);
		boot.Bv.ccd.Dy().ED("対象の敵ユニットに魔法DMを与え、与えたダメージの40%を回復し、対象の背後にRavenous Ghoulを召喚する。Ravenous Ghoulは、通常攻撃を行うたびにYorickのHPを回復する。回復量はRavenous Ghoulの攻撃力の半分となり、敵Championを攻撃した場合は回復量が2倍になる。").EI(55.0,5.0).EH(10.0,-1.0).EJ(550.0);
		boot.Bv.cce.Dy().ED("対象の味方Champion一人の姿形を持ったRevenant(死霊)を召喚する(RまたはALT押しながら右クリックで任意の操作可能)。Revenantは10秒間持続し、対象の味方Championの一定割合の攻撃力を持つ。Revenantが生存している間に対象となった味方Championが死亡した場合、Revenantが消滅し、死亡した味方ChampionはHPとMNが最大の状態で蘇生される。蘇生した味方Championは10秒経過すると消滅する。消費MN: 100 CD: 120/105/90s Range: 900ペット「Revenant」攻撃力: 元になったChampの45/60/75%【備考】元になったChampionのステータス・一部アイテムとスキルの効果を引き継ぐ。").EU(100.0).EH(120.0,-15.0).EJ(900.0);
		boot.Bv.ccf.Dy().Dz("HPが50%以下の敵ユニットへの通常攻撃に{1}を付与する。同一の対象には10秒に一度しか発動しない。レベル1、7、17でDMが上昇する。").EG(1,boot.BK.f,0,0,boot.Bv.EZ(boot.BK.cg,new boot.CO(6.0,2.0,0)));
		boot.Bv.ccg.Dy().ED("Zedと「影」から指定方向に貫通する手裏剣を飛ばし、当たった敵ユニットに{1}を与える。手裏剣は一度敵ユニットに当たるとそれ以降の敵ユニットには80%のDMを与える。Zedと「影」が同一の対象に手裏剣を命中させた場合、2発目以降は{2}を与える。").EG(1,boot.BK.e,75.0,35.0,boot.Bv.EL(1)).EG(2,boot.BK.e,37.5,20.0,boot.Bv.EL(0.5)).EB(boot.BK.bn,75.0,-5.0).EV(6.0).EJ(900.0);
		boot.Bv.ccg.ET(boot.BR.k).EG(1,boot.BK.e,75.0,40.0,boot.Bv.EL(1));
		boot.Bv.cch.Dy().Dz("{1}を得る。").EG(1,boot.BK.dc,0,0,boot.Bv.EY(boot.BK.df,0.05,0.05)).ED("Zedの「影」が指定方向にダッシュし、4秒間その場に留まる。再度このスキルを使用するとZedと「影」の位置が入れ替わる。「影」はZedが通常スキルを使用すると同時に同じスキルを使用する。この時スキルがZedのスキルと同一の敵ユニットに命中した場合、{1}する。回復効果はスキル1回毎に1度のみ発動する。").EK(1,boot.BK.hh,20.0,5.0).EB(boot.BK.bn,40.0,-5.0).EH(22.0,-1.5).EJ(550.0);
		boot.Bv.cci.Dy().ED("Zedと「影」から衝撃波を発生させ、{1}の敵ユニットに{2}を与える。ZedのShadow Slashは敵ユニットに当たる度にLiving ShadowのCDを1秒解消させる。「影」のShadow Slashはダメージと共に敵ユニットに1.5秒間{3}を与える。Zedと「影」が同一の対象にShadow Slashを命中させた場合、DMは重複しないがスローの効果が上昇する。").EA(1,boot.BK.jn,290.0).EG(2,boot.BK.e,60.0,35.0,boot.Bv.EL(0.9)).EK(3,boot.BK.ie,30.0,7.5).EB(boot.BK.bn,50.0,0).EV(3.0);
		boot.Bv.cci.ET(boot.BR.k).EG(2,boot.BK.e,60.0,30.0,boot.Bv.EL(0.9));
		boot.Bv.ccj.Dy().ED("対象の敵Championにダッシュしマークを付与する。ダッシュ中はターゲット不可状態になる。また対象の背後に4秒間持続する「影」を召喚する。再度このスキルを使用するとZedと「影」の位置が入れ替わる。付与から3秒後にマークは消費され、対象にマークが付与されている間にZedと「影」が与えた物理DMと魔法DMの合計に比例し{1}を与える。").EQ(1,boot.BK.e,0,0,boot.Bv.EP(1),boot.Bv.EY(boot.BK.k,20.0,15.0)).EH(120.0,-20.0).EJ(625.0);
		boot.Bv.cck.Dy().Dz("12秒毎に通常攻撃に追加魔法DMが付与される。Ziggsがスキルを使う度にCDが4秒低減される。建物に対しては150%のDMを与える。").EV(12.0);
		boot.Bv.ccl.Dy().ED("指定地点に跳ねながら転がる爆弾を投げ、爆発時に周囲の敵ユニットに魔法DMを与える。敵に当たらなかった場合には投げた方向に2回までバウンドする。").EI(50.0,10.0).EH(6.0,-0.5).EJ(850.0);
		boot.Bv.ccm.Dy().ED("指定地点に火薬を投げ、爆発時に周囲の敵ユニットに魔法DMを与え、ノックバックさせる。Ziggsが範囲内にいた場合は自分もノックバックを受ける(Ziggsにダメージは無し)。火薬は4秒経つか、スキルを再度使用すると爆発する。また火薬は視界を確保する。").EU(65.0).EH(26.0,-2.0).EJ(1000.0);
		boot.Bv.ccn.Dy().ED("指定範囲に11個の近接地雷を円形にばら撒き、敵ユニットが地雷に触れると魔法DMとスロー(1.5s)を与える。同ユニットが2個目以降に踏む地雷のダメージは本来の40%となる。地雷は爆発するか10秒経つと消滅する。").EI(70.0,10.0).EV(16.0).EJ(900.0);
		boot.Bv.cco.Dy().ED("指定地点に巨大な爆弾を投下し、範囲内の敵ユニットに魔法DMを与える。爆発の中心点から離れた位置にいる敵ユニットには80%のDMを与える。").EU(100.0).EH(120.0,-15.0).EJ(5300.0);
		boot.Bv.ccp.Dy().Dz("すべての味方Championが取得する{1}する。").EA(1,boot.BK.ha,8.0);
		boot.Bv.cda.Dy().ED("対象のユニットに爆弾をつけ、4秒後に対象(味方ユニットの場合ダメージ無し)とその周辺{1}の敵ユニットに{2}を与える。対象が死亡した場合は即座に爆発する。").EA(1,boot.BK.jn,330.0).EG(2,boot.BK.f,90.0,55.0,boot.Bv.EE(0.9)).EI(70.0,15.0).EV(10.0).EJ(700.0);
		boot.Bv.cdb.Dy().ED(""+boot.Bv.cdb+"以外のスキルのCDを10秒解消する。").EU(50.0).EH(18.0,-3.0);
		boot.Bv.cdc.Dy().ED("味方Championに使用した場合は{2}間{1}増加し、敵Championに使用した場合は{2}間{3}を与える。").EA(1,boot.BK.im,55.0).EK(2,boot.BK.jj,2.5,0.75).EA(3,boot.BK.ie,55.0).EU(80.0).EV(20.0).EJ(700.0);
		boot.Bv.cdd.Dy().ED("対象の味方Championが使用してから7秒以内に死亡した場合、2秒後にその場で{1}して復活する。").EG(1,boot.BK.he,600.0,150.0,boot.Bv.EE(2.0)).EI(125.0,25.0).EV(180.0).EJ(900.0);
		boot.Bv.cde.Dy().Dz("死亡すると2秒後にその場で植物に変形し、指定方向に一度だけ貫通する光線を放つことができる。光線に当たった敵ユニットに{1}を与える。").EG(1,boot.BK.g,80.0,0,boot.Bv.ER(boot.BK.gm,20.0)).EJ(1500.0);
		boot.Bv.cdf.Dy().ED("地面から棘を出現させ、指定範囲内の敵ユニットに{1}を与える。種にHitした場合Thorn Spitterに成長し、{3}の敵を自動攻撃して{2}を与える。Thorn Spitterは10秒間持続する。").EG(1,boot.BK.f,75.0,40.0,boot.Bv.EE(0.6)).EQ(2,boot.BK.f,26.0,0,boot.Bv.ER(boot.BK.gm,6.0),boot.Bv.EE(0.6)).EA(3,boot.BK.jn,650.0).EI(75.0,5.0).EH(7.0,-0.5).EJ(825.0);
		boot.Bv.cdg.Dy().Dz("{1}を得る。").EK(1,boot.BK.ed,4.0,4.0).ED("指定地点に30秒持続する種を植える。他のスキルを種に当てることで成長させることができる。敵Championが種を踏んだ場合、視界を2秒間得る。{2}毎にチャージが1つ増加し最大2つまでチャージされる。種が植物に成長し、同一ユニットに複数の植物がDMを与える場合、2体目以降は50%のダメージを与える。").EK(2,boot.BK.jk,17.0,-1.0).EJ(825.0).EB(boot.BK.kd,1,0);
		boot.Bv.cdh.Dy().ED("指定方向に蔓を放ち、当たった全ての敵ユニットに{1}と{2}を与える。種にHitした場合Vine Lasherに成長し、{3}の敵を自動攻撃して{4}と2秒間{5}を与える。Vine Lasherは10秒間持続する。").EG(1,boot.BK.f,60.0,35.0,boot.Bv.EE(0.5)).EK(2,boot.BK.hk,0.75,0.25).EA(3,boot.BK.jn,250.0).EQ(4,boot.BK.f,26.0,0,boot.Bv.ER(boot.BK.gm,6.0),boot.Bv.EE(0.2)).EA(5,boot.BK.ie,30.0).EI(70.0,5.0).EH(14.0,-1.0).EJ(1100.0);
		boot.Bv.cdi.Dy().ED("指定地点に藪を召還し、{1}の全ての敵に{2}を与え、2秒後に{3}。成長した植物にHitした場合、その植物の攻撃速度が50%増加する。").EA(1,boot.BK.jn,700.0).EG(2,boot.BK.f,180.0,85.0,boot.Bv.EE(0.75)).EA(3,boot.BK.ib,0).EI(100.0,20.0).EH(130.0,-10.0).EJ(700.0);
	},
	// teemowork.model.Skill#<init>(java.lang.String, teemowork.model.SkillKey)
	$0:function(A,B){
		this.cec=new Array(boot.BR.Du().length);
		this.cdp=A;
		this.cea=A.replace(/ of /g,"Of").replace(/[\s-,!':/]/g,"");
		this.ceb=B;
	},
	// teemowork.model.Skill#getIcon()
	CM:function(){
		return "src/main/resources/teemowork/skill/"+this.cea+".jpg";
	},
	// teemowork.model.Skill#toString()
	toString:function(){
		return this.cdp;
	},
	// teemowork.model.Skill#getMinLevel()
	Ez:function(){
		if((this.ceb==boot.Bw.c||this==boot.Bv.lp)){
			return 1;
		}else{
			if((this==boot.Bv.fn||(this==boot.Bv.fo||(this==boot.Bv.lj||this==boot.Bv.lk)))){
				return 1;
			}else{
				return 0;
			}
		}
	},
	// teemowork.model.Skill#getMaxLevel()
	FA:function(){
		if(this.ceb!=boot.Bw.c){
			if(this!=boot.Bv.lp){
				if((this==boot.Bv.fn||(this==boot.Bv.fo||(this==boot.Bv.lj||this==boot.Bv.lk)))){
					return 4;
				}else{
					if((this==boot.Bv.bod||(this.ceb!=boot.Bw.g&&(this!=boot.Bv.bdd&&(this!=boot.Bv.bdf&&this!=boot.Bv.bdh))))){
						return 5;
					}else{
						return 3;
					}
				}
			}else{
				return 1;
			}
		}else{
			return 0;
		}
	},
	// teemowork.model.Skill#getStatus(teemowork.model.Version)
	FB:function(A,B,C){
		B=A.CB();
		l2:for (;
		B>=0;
		--B) {
			C=this.cec[B];
			if(C==null){
			}else{
				return C;
			}
		}return null;
	},
	// teemowork.model.Skill#update()
	Dy:function(){
		return this.ET(boot.BR.c);
	},
	// teemowork.model.Skill#update(teemowork.model.Version)
	ET:function(A,B){
		B=new boot.Bx(this,this.FB(A),0);
		this.cec[A.CB()]=B;
		boot.Bv.cdo=this;
		return B;
	},
	// teemowork.model.Skill#ad(double)
	_EP:function(A){
		return boot.Bv.ER(boot.BK.dc,A);
	},
	// teemowork.model.Skill#bounusAD(double)
	_EL:function(A){
		return boot.Bv.ER(boot.BK.df,A);
	},
	// teemowork.model.Skill#ap(double)
	_EE:function(A){
		return boot.Bv.ER(boot.BK.ea,A);
	},
	// teemowork.model.Skill#amplify(teemowork.model.Status, double)
	_ER:function(A,B){
		return boot.Bv.EY(A,B,0);
	},
	// teemowork.model.Skill#amplify(teemowork.model.Status, double, double)
	_EY:function(A,B,D){
		return boot.Bv.EZ(A,new boot.CK(B,D,boot.Bv.cdo.FA(),0));
	},
	// teemowork.model.Skill#amplify(teemowork.model.Status, teemowork.model.variable.VariableResolver)
	_EZ:function(A,B){
		return new boot.CP(A,B,0);
	},
	// teemowork.model.Skill#amplify(teemowork.model.Status, double, double, teemowork.model.variable.Variable)
	_EM:function(A,B,D,F){
		return boot.Bv.Ex(A,B,D,F,null);
	},
	// teemowork.model.Skill#amplify(teemowork.model.Status, double, double, teemowork.model.variable.Variable, teemowork.model.variable.Variable)
	_Ex:function(A,B,D,F,G,H){
		H=boot.Bv.EY(A,B,D);
		H.FC(F);
		H.FC(G);
		return H;
	}
});

boot.define("BS","",[],{
	// teemowork.model.ChampionStatus#<init>(teemowork.model.ChampionStatus)
	$0:function(A){
		if(A==null){
			this.a=[];
		}else{
			this.a=A.a.slice(0);
		}
	},
	// teemowork.model.ChampionStatus#get(teemowork.model.Status)
	CN:function(A,B){
		B=this.a[A.CB()];
		return (B==null?0:B);
	},
	// teemowork.model.ChampionStatus#set(teemowork.model.Status, double)
	DZ:function(A,B){
		this.a[A.CB()]=B;
		return this;
	},
	// teemowork.model.ChampionStatus#set(teemowork.model.Status, double, double)
	DY:function(A,B,D){
		this.a[A.CB()]=B;
		this.a[boot.BK.Cv(""+A.S()+"PerLv").CB()]=D;
		return this;
	}
});

boot.define("BP","",[],{
	// teemowork.model.Champion#<clinit>()
	_:function(){
		boot.BP.a=new boot.BL(0);
		boot.BP.b=new boot.BP("Ahri",[boot.Bv.a,boot.Bv.b,boot.Bv.c,boot.Bv.d,boot.Bv.e],0);
		boot.BP.c=new boot.BP("Akali",[boot.Bv.f,boot.Bv.g,boot.Bv.h,boot.Bv.i,boot.Bv.j],0);
		boot.BP.d=new boot.BP("Alistar",[boot.Bv.k,boot.Bv.l,boot.Bv.m,boot.Bv.n,boot.Bv.o],0);
		boot.BP.e=new boot.BP("Amumu",[boot.Bv.p,boot.Bv.ba,boot.Bv.bb,boot.Bv.bc,boot.Bv.bd],0);
		boot.BP.f=new boot.BP("Anivia",[boot.Bv.be,boot.Bv.bf,boot.Bv.bg,boot.Bv.bh,boot.Bv.bi],0);
		boot.BP.g=new boot.BP("Annie",[boot.Bv.bj,boot.Bv.bk,boot.Bv.bl,boot.Bv.bm,boot.Bv.bn],0);
		boot.BP.h=new boot.BP("Ashe",[boot.Bv.bo,boot.Bv.bp,boot.Bv.ca,boot.Bv.cb,boot.Bv.cc],0);
		boot.BP.i=new boot.BP("Blitzcrank",[boot.Bv.cd,boot.Bv.ce,boot.Bv.cf,boot.Bv.cg,boot.Bv.ch],0);
		boot.BP.j=new boot.BP("Brand",[boot.Bv.ci,boot.Bv.cj,boot.Bv.ck,boot.Bv.cl,boot.Bv.cm],0);
		boot.BP.k=new boot.BP("Caitlyn",[boot.Bv.cn,boot.Bv.co,boot.Bv.cp,boot.Bv.da,boot.Bv.db],0);
		boot.BP.l=new boot.BP("Cassiopeia",[boot.Bv.dc,boot.Bv.dd,boot.Bv.de,boot.Bv.df,boot.Bv.dg],0);
		boot.BP.m=new boot.BP("Cho'Gath",[boot.Bv.dh,boot.Bv.di,boot.Bv.dj,boot.Bv.dk,boot.Bv.dl],0);
		boot.BP.n=new boot.BP("Corki",[boot.Bv.dm,boot.Bv.dn,boot.Bv.dp,boot.Bv.ea,boot.Bv.eb],0);
		boot.BP.o=new boot.BP("Darius",[boot.Bv.ec,boot.Bv.ed,boot.Bv.ee,boot.Bv.ef,boot.Bv.eg],0);
		boot.BP.p=new boot.BP("Diana",[boot.Bv.eh,boot.Bv.ei,boot.Bv.ej,boot.Bv.ek,boot.Bv.el],0);
		boot.BP.ba=new boot.BP("Dr.Mundo",[boot.Bv.em,boot.Bv.en,boot.Bv.eo,boot.Bv.ep,boot.Bv.fa],0);
		boot.BP.bb=new boot.BP("Draven",[boot.Bv.fb,boot.Bv.fc,boot.Bv.fd,boot.Bv.fe,boot.Bv.ff],0);
		boot.BP.bc=new boot.BP("Elise",[boot.Bv.fg,boot.Bv.fh,boot.Bv.fj,boot.Bv.fl,boot.Bv.fn],0);
		boot.BP.bd=new boot.BP("Elise",1,[boot.Bv.fg,boot.Bv.fi,boot.Bv.fk,boot.Bv.fm,boot.Bv.fo],1);
		boot.BP.be=new boot.BP("Evelynn",[boot.Bv.fp,boot.Bv.ga,boot.Bv.gb,boot.Bv.gc,boot.Bv.gd],0);
		boot.BP.bf=new boot.BP("Ezreal",[boot.Bv.ge,boot.Bv.gf,boot.Bv.gg,boot.Bv.gh,boot.Bv.gi],0);
		boot.BP.bg=new boot.BP("Fiddlesticks",[boot.Bv.gj,boot.Bv.gk,boot.Bv.gl,boot.Bv.gm,boot.Bv.gn],0);
		boot.BP.bh=new boot.BP("Fiora",[boot.Bv.go,boot.Bv.gp,boot.Bv.ha,boot.Bv.hb,boot.Bv.hc],0);
		boot.BP.bi=new boot.BP("Fizz",[boot.Bv.hd,boot.Bv.he,boot.Bv.hf,boot.Bv.hg,boot.Bv.hh,boot.Bv.hi],0);
		boot.BP.bj=new boot.BP("Galio",[boot.Bv.hj,boot.Bv.hk,boot.Bv.hl,boot.Bv.hm,boot.Bv.hn],0);
		boot.BP.bk=new boot.BP("Gangplank",[boot.Bv.ho,boot.Bv.hp,boot.Bv.ia,boot.Bv.ib,boot.Bv.ic],0);
		boot.BP.bl=new boot.BP("Garen",[boot.Bv.id,boot.Bv.ie,boot.Bv.ig,boot.Bv.ih,boot.Bv.ii],0);
		boot.BP.bm=new boot.BP("Gragas",[boot.Bv.ij,boot.Bv.ik,boot.Bv.il,boot.Bv.im,boot.Bv.io],0);
		boot.BP.bn=new boot.BP("Graves",[boot.Bv.ip,boot.Bv.ja,boot.Bv.jb,boot.Bv.jc,boot.Bv.jd],0);
		boot.BP.bo=new boot.BP("Hecarim",[boot.Bv.je,boot.Bv.jf,boot.Bv.jg,boot.Bv.jh,boot.Bv.ji],0);
		boot.BP.bp=new boot.BP("Heimerdinger",[boot.Bv.jj,boot.Bv.jk,boot.Bv.jl,boot.Bv.jm,boot.Bv.jn],0);
		boot.BP.ca=new boot.BP("Irelia",[boot.Bv.jo,boot.Bv.jp,boot.Bv.ka,boot.Bv.kb,boot.Bv.kc],0);
		boot.BP.cb=new boot.BP("Janna",[boot.Bv.kd,boot.Bv.ke,boot.Bv.kf,boot.Bv.kg,boot.Bv.kh],0);
		boot.BP.cc=new boot.BP("Jarvan IV",[boot.Bv.ki,boot.Bv.kj,boot.Bv.kk,boot.Bv.kl,boot.Bv.km],0);
		boot.BP.cd=new boot.BP("Jax",[boot.Bv.kn,boot.Bv.ko,boot.Bv.kp,boot.Bv.la,boot.Bv.lb],0);
		boot.BP.ce=new boot.BP("Jayce",[boot.Bv.lc,boot.Bv.ld,boot.Bv.lf,boot.Bv.lh,boot.Bv.lj],0);
		boot.BP.cf=new boot.BP("Jayce",1,[boot.Bv.lc,boot.Bv.le,boot.Bv.lg,boot.Bv.li,boot.Bv.lk],1);
		boot.BP.cg=new boot.BP("Karma",[boot.Bv.ll,boot.Bv.lm,boot.Bv.ln,boot.Bv.lo,boot.Bv.lp],0);
		boot.BP.ch=new boot.BP("Karthus",[boot.Bv.ma,boot.Bv.mb,boot.Bv.mc,boot.Bv.md,boot.Bv.me],0);
		boot.BP.ci=new boot.BP("Kassadin",[boot.Bv.mf,boot.Bv.mg,boot.Bv.mh,boot.Bv.mi,boot.Bv.mj],0);
		boot.BP.cj=new boot.BP("Katarina",[boot.Bv.mk,boot.Bv.ml,boot.Bv.mm,boot.Bv.mn,boot.Bv.mo],0);
		boot.BP.ck=new boot.BP("Kayle",[boot.Bv.mp,boot.Bv.na,boot.Bv.nb,boot.Bv.nc,boot.Bv.nd],0);
		boot.BP.cl=new boot.BP("Kennen",[boot.Bv.ne,boot.Bv.nf,boot.Bv.ng,boot.Bv.nh,boot.Bv.ni],0);
		boot.BP.cm=new boot.BP("Kha'Zix",[boot.Bv.nj,boot.Bv.nk,boot.Bv.nl,boot.Bv.nm,boot.Bv.nn],0);
		boot.BP.cn=new boot.BP("Kog'Maw",[boot.Bv.no,boot.Bv.np,boot.Bv.oa,boot.Bv.ob,boot.Bv.oc],0);
		boot.BP.co=new boot.BP("LeBlanc",[boot.Bv.od,boot.Bv.oe,boot.Bv.of,boot.Bv.og,boot.Bv.oh],0);
		boot.BP.cp=new boot.BP("Lee Sin",[boot.Bv.oi,boot.Bv.oj,boot.Bv.ok,boot.Bv.ol,boot.Bv.om,boot.Bv.on,boot.Bv.oo,boot.Bv.op],0);
		boot.BP.da=new boot.BP("Leona",[boot.Bv.pa,boot.Bv.pb,boot.Bv.pc,boot.Bv.pd,boot.Bv.pe],0);
		boot.BP.db=new boot.BP("Lulu",[boot.Bv.pf,boot.Bv.pg,boot.Bv.ph,boot.Bv.pi,boot.Bv.pj],0);
		boot.BP.dc=new boot.BP("Lux",[boot.Bv.pk,boot.Bv.pl,boot.Bv.pm,boot.Bv.pn,boot.Bv.po],0);
		boot.BP.dd=new boot.BP("Malphite",[boot.Bv.pp,boot.Bv.baa,boot.Bv.bab,boot.Bv.bac,boot.Bv.bad],0);
		boot.BP.de=new boot.BP("Malzahar",[boot.Bv.bae,boot.Bv.baf,boot.Bv.bag,boot.Bv.bah,boot.Bv.bai],0);
		boot.BP.df=new boot.BP("Maokai",[boot.Bv.baj,boot.Bv.bak,boot.Bv.bal,boot.Bv.bam,boot.Bv.ban],0);
		boot.BP.dg=new boot.BP("Master Yi",[boot.Bv.bao,boot.Bv.bap,boot.Bv.bba,boot.Bv.bbb,boot.Bv.bbc],0);
		boot.BP.dh=new boot.BP("Miss Fortune",[boot.Bv.bbd,boot.Bv.bbe,boot.Bv.bbf,boot.Bv.bbg,boot.Bv.bbh],0);
		boot.BP.di=new boot.BP("Mordekaiser",[boot.Bv.bbi,boot.Bv.bbj,boot.Bv.bbk,boot.Bv.bbl,boot.Bv.bbm],0);
		boot.BP.dj=new boot.BP("Morgana",[boot.Bv.bbn,boot.Bv.bbo,boot.Bv.bbp,boot.Bv.bca,boot.Bv.bcb],0);
		boot.BP.dk=new boot.BP("Nami",[boot.Bv.bcc,boot.Bv.bcd,boot.Bv.bce,boot.Bv.bcf,boot.Bv.bcg],0);
		boot.BP.dl=new boot.BP("Nasus",[boot.Bv.bch,boot.Bv.bci,boot.Bv.bcj,boot.Bv.bck,boot.Bv.bcl],0);
		boot.BP.dm=new boot.BP("Nautilus",[boot.Bv.bcm,boot.Bv.bcn,boot.Bv.bco,boot.Bv.bcp,boot.Bv.bda],0);
		boot.BP.dn=new boot.BP("Nidalee",[boot.Bv.bdb,boot.Bv.bdc,boot.Bv.bde,boot.Bv.bdg,boot.Bv.bdi],0);
		boot.BP.dp=new boot.BP("Nidalee",1,[boot.Bv.bdb,boot.Bv.bdd,boot.Bv.bdf,boot.Bv.bdh,boot.Bv.bdj],1);
		boot.BP.ea=new boot.BP("Nocturne",[boot.Bv.bdk,boot.Bv.bdl,boot.Bv.bdm,boot.Bv.bdn,boot.Bv.bdo],0);
		boot.BP.eb=new boot.BP("Nunu",[boot.Bv.bdp,boot.Bv.bea,boot.Bv.beb,boot.Bv.bec,boot.Bv.bed],0);
		boot.BP.ec=new boot.BP("Olaf",[boot.Bv.bee,boot.Bv.bef,boot.Bv.beg,boot.Bv.beh,boot.Bv.bei],0);
		boot.BP.ed=new boot.BP("Orianna",[boot.Bv.bej,boot.Bv.bek,boot.Bv.bel,boot.Bv.bem,boot.Bv.ben],0);
		boot.BP.ee=new boot.BP("Pantheon",[boot.Bv.beo,boot.Bv.bep,boot.Bv.bfa,boot.Bv.bfb,boot.Bv.bfc],0);
		boot.BP.ef=new boot.BP("Poppy",[boot.Bv.bfd,boot.Bv.bfe,boot.Bv.bff,boot.Bv.bfg,boot.Bv.bfh],0);
		boot.BP.eg=new boot.BP("Quinn",[boot.Bv.cdj,boot.Bv.cdk,boot.Bv.cdl,boot.Bv.cdm,boot.Bv.cdn],0);
		boot.BP.eh=new boot.BP("Rammus",[boot.Bv.bfi,boot.Bv.bfj,boot.Bv.bfk,boot.Bv.bfl,boot.Bv.bfm],0);
		boot.BP.ei=new boot.BP("Renekton",[boot.Bv.bfn,boot.Bv.bfo,boot.Bv.bfp,boot.Bv.bga,boot.Bv.bgb],0);
		boot.BP.ej=new boot.BP("Rengar",[boot.Bv.bgc,boot.Bv.bgd,boot.Bv.bge,boot.Bv.bgf,boot.Bv.bgg],0);
		boot.BP.ek=new boot.BP("Riven",[boot.Bv.bgh,boot.Bv.bgi,boot.Bv.bgj,boot.Bv.bgk,boot.Bv.bgl],0);
		boot.BP.el=new boot.BP("Rumble",[boot.Bv.bgm,boot.Bv.bgn,boot.Bv.bgo,boot.Bv.bgp,boot.Bv.bha],0);
		boot.BP.em=new boot.BP("Ryze",[boot.Bv.bhb,boot.Bv.bhc,boot.Bv.bhd,boot.Bv.bhe,boot.Bv.bhf],0);
		boot.BP.en=new boot.BP("Sejuani",[boot.Bv.bhg,boot.Bv.bhh,boot.Bv.bhi,boot.Bv.bhj,boot.Bv.bhk],0);
		boot.BP.eo=new boot.BP("Shaco",[boot.Bv.bhl,boot.Bv.bhm,boot.Bv.bhn,boot.Bv.bho,boot.Bv.bhp],0);
		boot.BP.ep=new boot.BP("Shen",[boot.Bv.bia,boot.Bv.bib,boot.Bv.bic,boot.Bv.bid,boot.Bv.bie],0);
		boot.BP.fa=new boot.BP("Shyvana",[boot.Bv.bif,boot.Bv.big,boot.Bv.bih,boot.Bv.bii,boot.Bv.bij],0);
		boot.BP.fb=new boot.BP("Singed",[boot.Bv.bik,boot.Bv.bil,boot.Bv.bim,boot.Bv.bin,boot.Bv.bio],0);
		boot.BP.fc=new boot.BP("Sion",[boot.Bv.bip,boot.Bv.bja,boot.Bv.bjb,boot.Bv.bjc,boot.Bv.bjd],0);
		boot.BP.fd=new boot.BP("Sivir",[boot.Bv.bje,boot.Bv.bjf,boot.Bv.bjg,boot.Bv.bjh,boot.Bv.bji],0);
		boot.BP.fe=new boot.BP("Skarner",[boot.Bv.bjj,boot.Bv.bjk,boot.Bv.bjl,boot.Bv.bjm,boot.Bv.bjn],0);
		boot.BP.ff=new boot.BP("Sona",[boot.Bv.bjo,boot.Bv.bjp,boot.Bv.bka,boot.Bv.bkb,boot.Bv.bkc],0);
		boot.BP.fg=new boot.BP("Soraka",[boot.Bv.bkd,boot.Bv.bke,boot.Bv.bkf,boot.Bv.bkg,boot.Bv.bkh],0);
		boot.BP.fh=new boot.BP("Swain",[boot.Bv.bki,boot.Bv.bkj,boot.Bv.bkk,boot.Bv.bkl,boot.Bv.bkm],0);
		boot.BP.fi=new boot.BP("Syndra",[boot.Bv.bkn,boot.Bv.bko,boot.Bv.bkp,boot.Bv.bla,boot.Bv.blb],0);
		boot.BP.fj=new boot.BP("Talon",[boot.Bv.blc,boot.Bv.bld,boot.Bv.ble,boot.Bv.blf,boot.Bv.blg],0);
		boot.BP.fk=new boot.BP("Taric",[boot.Bv.blh,boot.Bv.bli,boot.Bv.blj,boot.Bv.blk,boot.Bv.bll],0);
		boot.BP.fl=new boot.BP("Teemo",[boot.Bv.blm,boot.Bv.bln,boot.Bv.blo,boot.Bv.blp,boot.Bv.bma],0);
		boot.BP.fm=new boot.BP("Thresh",[boot.Bv.bmb,boot.Bv.bmc,boot.Bv.bmd,boot.Bv.bme,boot.Bv.bmf],0);
		boot.BP.fn=new boot.BP("Tristana",[boot.Bv.bmg,boot.Bv.bmh,boot.Bv.bmi,boot.Bv.bmj,boot.Bv.bmk],0);
		boot.BP.fo=new boot.BP("Trundle",[boot.Bv.bml,boot.Bv.bmm,boot.Bv.bmn,boot.Bv.bmo,boot.Bv.bmp],0);
		boot.BP.fp=new boot.BP("Tryndamere",[boot.Bv.bna,boot.Bv.bnb,boot.Bv.bnc,boot.Bv.bnd,boot.Bv.bne],0);
		boot.BP.ga=new boot.BP("Twisted Fate",[boot.Bv.bnf,boot.Bv.bng,boot.Bv.bnh,boot.Bv.bni,boot.Bv.bnj],0);
		boot.BP.gb=new boot.BP("Twitch",[boot.Bv.bnk,boot.Bv.bnl,boot.Bv.bnm,boot.Bv.bnn,boot.Bv.bno],0);
		boot.BP.gc=new boot.BP("Udyr",[boot.Bv.bnp,boot.Bv.boa,boot.Bv.bob,boot.Bv.boc,boot.Bv.bod],0);
		boot.BP.gd=new boot.BP("Urgot",[boot.Bv.boe,boot.Bv.bof,boot.Bv.bog,boot.Bv.boh,boot.Bv.boi],0);
		boot.BP.ge=new boot.BP("Varus",[boot.Bv.boj,boot.Bv.bok,boot.Bv.bol,boot.Bv.bom,boot.Bv.bon],0);
		boot.BP.gf=new boot.BP("Vayne",[boot.Bv.boo,boot.Bv.bop,boot.Bv.bpa,boot.Bv.bpb,boot.Bv.bpc],0);
		boot.BP.gg=new boot.BP("Veigar",[boot.Bv.bpd,boot.Bv.bpe,boot.Bv.bpf,boot.Bv.bpg,boot.Bv.bph],0);
		boot.BP.gh=new boot.BP("Vi",[boot.Bv.bpi,boot.Bv.bpj,boot.Bv.bpk,boot.Bv.bpl,boot.Bv.bpm],0);
		boot.BP.gi=new boot.BP("Viktor",[boot.Bv.bpn,boot.Bv.bpo,boot.Bv.bpp,boot.Bv.caa,boot.Bv.cab],0);
		boot.BP.gj=new boot.BP("Vladimir",[boot.Bv.cac,boot.Bv.cad,boot.Bv.cae,boot.Bv.caf,boot.Bv.cag],0);
		boot.BP.gk=new boot.BP("Volibear",[boot.Bv.cah,boot.Bv.cai,boot.Bv.caj,boot.Bv.cak,boot.Bv.cal],0);
		boot.BP.gl=new boot.BP("Warwick",[boot.Bv.cam,boot.Bv.can,boot.Bv.cao,boot.Bv.cap,boot.Bv.cba],0);
		boot.BP.gm=new boot.BP("Wukong",[boot.Bv.cbb,boot.Bv.cbc,boot.Bv.cbd,boot.Bv.cbe,boot.Bv.cbf],0);
		boot.BP.gn=new boot.BP("Xerath",[boot.Bv.cbg,boot.Bv.cbh,boot.Bv.cbi,boot.Bv.cbj,boot.Bv.cbk],0);
		boot.BP.go=new boot.BP("Xin Zhao",[boot.Bv.cbl,boot.Bv.cbm,boot.Bv.cbn,boot.Bv.cbo,boot.Bv.cbp],0);
		boot.BP.gp=new boot.BP("Yorick",[boot.Bv.cca,boot.Bv.ccb,boot.Bv.ccc,boot.Bv.ccd,boot.Bv.cce],0);
		boot.BP.ha=new boot.BP("Zed",[boot.Bv.ccf,boot.Bv.ccg,boot.Bv.cch,boot.Bv.cci,boot.Bv.ccj],0);
		boot.BP.hb=new boot.BP("Ziggs",[boot.Bv.cck,boot.Bv.ccl,boot.Bv.ccm,boot.Bv.ccn,boot.Bv.cco],0);
		boot.BP.hc=new boot.BP("Zilean",[boot.Bv.ccp,boot.Bv.cda,boot.Bv.cdb,boot.Bv.cdc,boot.Bv.cdd],0);
		boot.BP.hd=new boot.BP("Zyra",[boot.Bv.cde,boot.Bv.cdf,boot.Bv.cdg,boot.Bv.cdh,boot.Bv.cdi],0);
		boot.BP.b.DX(boot.BR.c).DY(boot.BK.p,380.0,80.0).DY(boot.BK.bd,5.5,0.6).DY(boot.BK.bg,230.0,50.0).DY(boot.BK.bk,6.25,0.6).DY(boot.BK.dc,50.0,3.0).DY(boot.BK.dg,0.668,2.0).DY(boot.BK.ff,10.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,330.0);
		boot.BP.c.DX(boot.BR.c).DY(boot.BK.p,445.0,85.0).DY(boot.BK.bd,7.25,0.65).DZ(boot.BK.bn,200.0).DZ(boot.BK.ca,50.0).DY(boot.BK.dc,53.0,3.2).DY(boot.BK.dg,0.694,3.1).DY(boot.BK.ff,16.5,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.d.DX(boot.BR.c).DY(boot.BK.p,442.0,102.0).DY(boot.BK.bd,7.25,0.85).DY(boot.BK.bg,215.0,38.0).DY(boot.BK.bk,6.45,0.45).DY(boot.BK.dc,55.03,3.62).DY(boot.BK.dg,0.625,3.62).DY(boot.BK.ff,14.5,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,325.0);
		boot.BP.e.DX(boot.BR.c).DY(boot.BK.p,472.0,84.0).DY(boot.BK.bd,7.45,0.85).DY(boot.BK.bg,220.0,40.0).DY(boot.BK.bk,6.5,0.525).DY(boot.BK.dc,47.0,3.8).DY(boot.BK.dg,0.638,2.18).DY(boot.BK.ff,18.0,3.3).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.f.DX(boot.BR.c).DY(boot.BK.p,350.0,70.0).DY(boot.BK.bd,4.65,0.55).DY(boot.BK.bg,257.0,53.0).DY(boot.BK.bk,7.0,0.6).DY(boot.BK.dc,48.0,3.2).DY(boot.BK.dg,0.625,1.68).DY(boot.BK.ff,10.5,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,600.0).DZ(boot.BK.ik,325.0);
		boot.BP.g.DX(boot.BR.c).DY(boot.BK.p,384.0,76.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,250.0,50.0).DY(boot.BK.bk,6.9,0.6).DY(boot.BK.dc,49.0,2.625).DY(boot.BK.dg,0.579,1.36).DY(boot.BK.ff,12.5,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,625.0).DZ(boot.BK.ik,335.0);
		boot.BP.h.DX(boot.BR.c).DY(boot.BK.p,395.0,79.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,173.0,35.0).DY(boot.BK.bk,6.3,0.4).DY(boot.BK.dc,46.3,2.85).DY(boot.BK.dg,0.658,3.34).DY(boot.BK.ff,11.5,3.4).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,600.0).DZ(boot.BK.ik,325.0);
		boot.BP.h.DX(boot.BR.k).DY(boot.BK.dg,0.658,4.0);
		boot.BP.i.DX(boot.BR.c).DY(boot.BK.p,423.0,95.0).DY(boot.BK.bd,7.25,0.75).DY(boot.BK.bg,200.0,40.0).DY(boot.BK.bk,6.6,0.5).DY(boot.BK.dc,55.66,3.5).DY(boot.BK.dg,0.625,1.13).DY(boot.BK.ff,14.5,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,325.0);
		boot.BP.j.DX(boot.BR.c).DY(boot.BK.p,380.0,76.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,250.0,45.0).DY(boot.BK.bk,7.0,0.6).DY(boot.BK.dc,51.66,3.0).DY(boot.BK.dg,0.625,1.36).DY(boot.BK.ff,12.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,340.0);
		boot.BP.k.DX(boot.BR.c).DY(boot.BK.p,390.0,80.0).DY(boot.BK.bd,4.75,0.55).DY(boot.BK.bg,255.0,35.0).DY(boot.BK.bk,6.5,0.55).DY(boot.BK.dc,47.0,3.0).DY(boot.BK.dg,0.668,3.0).DY(boot.BK.ff,13.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,650.0).DZ(boot.BK.ik,325.0);
		boot.BP.l.DX(boot.BR.c).DY(boot.BK.p,380.0,75.0).DY(boot.BK.bd,4.85,0.5).DY(boot.BK.bg,250.0,50.0).DY(boot.BK.bk,7.1,0.75).DY(boot.BK.dc,47.0,3.2).DY(boot.BK.dg,0.644,1.68).DY(boot.BK.ff,11.5,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,335.0);
		boot.BP.m.DX(boot.BR.c).DY(boot.BK.p,440.0,80.0).DY(boot.BK.bd,7.5,0.85).DY(boot.BK.bg,205.0,40.0).DY(boot.BK.bk,6.45,0.45).DY(boot.BK.dc,54.1,4.2).DY(boot.BK.dg,0.625,1.44).DY(boot.BK.ff,19.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.n.DX(boot.BR.c).DY(boot.BK.p,375.0,82.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,243.0,37.0).DY(boot.BK.bk,6.5,0.55).DY(boot.BK.dc,48.2,3.0).DY(boot.BK.dg,0.658,2.3).DY(boot.BK.ff,13.5,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,325.0);
		boot.BP.o.DX(boot.BR.c).DY(boot.BK.p,426.0,93.0).DY(boot.BK.bd,8.25,0.95).DY(boot.BK.bg,200.0,37.5).DY(boot.BK.bk,6.0,0.35).DY(boot.BK.dc,50.0,3.5).DY(boot.BK.dg,0.679,2.6).DY(boot.BK.ff,20.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,340.0);
		boot.BP.p.DX(boot.BR.c).DY(boot.BK.p,438.0,90.0).DY(boot.BK.bd,7.0,0.85).DY(boot.BK.bg,230.0,40.0).DY(boot.BK.bk,7.0,0.6).DY(boot.BK.dc,48.0,3.0).DY(boot.BK.dg,0.625,2.25).DY(boot.BK.ff,16.0,3.6).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,150.0).DZ(boot.BK.ik,345.0);
		boot.BP.ba.DX(boot.BR.c).DY(boot.BK.p,433.0,89.0).DY(boot.BK.bd,6.5,0.75).DY(boot.BK.dc,56.23,3.0).DY(boot.BK.dg,0.625,2.8).DY(boot.BK.ff,17.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.bb.DX(boot.BR.c).DY(boot.BK.p,420.0,82.0).DY(boot.BK.bd,5.0,0.7).DY(boot.BK.bg,240.0,42.0).DY(boot.BK.bk,6.95,0.65).DY(boot.BK.dc,46.5,3.5).DY(boot.BK.dg,0.679,2.6).DY(boot.BK.ff,16.0,3.3).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,330.0);
		boot.BP.bc.DX(boot.BR.c).DY(boot.BK.p,395.0,80.0).DY(boot.BK.bd,4.7,0.6).DY(boot.BK.bg,240.0,50.0).DY(boot.BK.bk,6.8,0.65).DY(boot.BK.dc,47.5,3.0).DY(boot.BK.dg,0.625,1.75).DY(boot.BK.ff,12.65,3.35).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,335.0);
		boot.BP.bd.DX(boot.BR.c).DY(boot.BK.p,395.0,80.0).DY(boot.BK.bd,4.7,0.6).DY(boot.BK.bg,240.0,50.0).DY(boot.BK.bk,6.8,0.65).DY(boot.BK.dc,47.5,3.0).DY(boot.BK.dg,0.625,1.75).DY(boot.BK.ff,12.65,3.35).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.be.DX(boot.BR.c).DY(boot.BK.p,414.0,86.0).DY(boot.BK.bd,6.95,0.55).DY(boot.BK.bg,180.0,42.0).DY(boot.BK.bk,7.1,0.6).DY(boot.BK.dc,48.0,3.3).DY(boot.BK.dg,0.658,3.84).DY(boot.BK.ff,12.5,4.0).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,340.0);
		boot.BP.bf.DX(boot.BR.c).DY(boot.BK.p,350.0,80.0).DY(boot.BK.bd,5.5,0.55).DY(boot.BK.bg,235.0,45.0).DY(boot.BK.bk,7.0,0.65).DY(boot.BK.dc,47.2,3.0).DY(boot.BK.dg,0.625,2.8).DY(boot.BK.ff,12.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,325.0);
		boot.BP.bg.DX(boot.BR.c).DY(boot.BK.p,390.0,80.0).DY(boot.BK.bd,4.6,0.6).DY(boot.BK.bg,251.0,59.0).DY(boot.BK.bk,6.9,0.65).DY(boot.BK.dc,45.95,2.625).DY(boot.BK.dg,0.625,2.11).DY(boot.BK.ff,11.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,480.0).DZ(boot.BK.ik,335.0);
		boot.BP.bh.DX(boot.BR.c).DY(boot.BK.p,450.0,85.0).DY(boot.BK.bd,6.3,0.8).DY(boot.BK.bg,220.0,40.0).DY(boot.BK.bk,7.25,0.5).DY(boot.BK.dc,54.5,3.2).DY(boot.BK.dg,0.672,3.0).DY(boot.BK.ff,15.5,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.bi.DX(boot.BR.c).DY(boot.BK.p,414.0,86.0).DY(boot.BK.bd,7.0,0.7).DY(boot.BK.bg,200.0,40.0).DY(boot.BK.bk,6.15,0.45).DY(boot.BK.dc,53.0,3.0).DY(boot.BK.dg,0.658,3.1).DY(boot.BK.ff,13.0,3.4).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,175.0).DZ(boot.BK.ik,335.0);
		boot.BP.bj.DX(boot.BR.c).DY(boot.BK.p,435.0,85.0).DY(boot.BK.bd,7.45,0.75).DY(boot.BK.bg,235.0,50.0).DY(boot.BK.bk,7.0,0.7).DY(boot.BK.dc,56.3,3.375).DY(boot.BK.dg,0.638,1.2).DY(boot.BK.ff,17.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.bk.DX(boot.BR.c).DY(boot.BK.p,495.0,81.0).DY(boot.BK.bd,425.0,0.75).DY(boot.BK.bg,215.0,40.0).DY(boot.BK.bk,6.5,0.7).DY(boot.BK.dc,54.0,3.0).DY(boot.BK.dg,0.651,2.75).DY(boot.BK.ff,16.5,3.3).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.bl.DX(boot.BR.c).DY(boot.BK.p,455.0,96.0).DY(boot.BK.bd,7.5,0.75).DY(boot.BK.dc,52.5,3.5).DY(boot.BK.dg,0.625,2.9).DY(boot.BK.ff,19.0,2.7).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.bm.DX(boot.BR.c).DY(boot.BK.p,434.0,89.0).DY(boot.BK.bd,7.25,0.85).DY(boot.BK.bg,221.0,47.0).DY(boot.BK.bk,6.45,0.45).DY(boot.BK.dc,55.78,3.375).DY(boot.BK.dg,0.651,2.05).DY(boot.BK.ff,16.0,3.6).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,340.0);
		boot.BP.bn.DX(boot.BR.c).DY(boot.BK.p,410.0,84.0).DY(boot.BK.bd,5.5,0.7).DY(boot.BK.bg,255.0,40.0).DY(boot.BK.bk,6.75,0.7).DY(boot.BK.dc,51.0,3.1).DY(boot.BK.dg,0.625,2.9).DY(boot.BK.ff,15.0,3.2).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,525.0).DZ(boot.BK.ik,330.0);
		boot.BP.bo.DX(boot.BR.c).DY(boot.BK.p,440.0,95.0).DY(boot.BK.bd,8.0,0.75).DY(boot.BK.bg,210.0,40.0).DY(boot.BK.bk,6.5,0.6).DY(boot.BK.dc,56.0,3.2).DY(boot.BK.dg,0.67,2.5).DY(boot.BK.ff,16.0,4.0).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,175.0).DZ(boot.BK.ik,345.0);
		boot.BP.bp.DX(boot.BR.c).DY(boot.BK.p,350.0,75.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,240.0,65.0).DY(boot.BK.bk,7.0,0.65).DY(boot.BK.dc,49.24,3.0).DY(boot.BK.dg,0.625,1.21).DY(boot.BK.ff,7.0,3.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,325.0);
		boot.BP.ca.DX(boot.BR.c).DY(boot.BK.p,456.0,90.0).DY(boot.BK.bd,7.5,0.65).DY(boot.BK.bg,230.0,35.0).DY(boot.BK.bk,7.0,0.65).DY(boot.BK.dc,56.0,3.3).DY(boot.BK.dg,0.665,3.2).DY(boot.BK.ff,15.0,3.75).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.cb.DX(boot.BR.c).DY(boot.BK.p,356.0,78.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,302.0,64.0).DY(boot.BK.bk,6.9,0.6).DY(boot.BK.dc,49.0,2.95).DY(boot.BK.dg,0.625,2.61).DY(boot.BK.ff,9.0,3.8).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,475.0).DZ(boot.BK.ik,335.0);
		boot.BP.cc.DX(boot.BR.c).DY(boot.BK.p,420.0,90.0).DY(boot.BK.bd,7.0,0.7).DY(boot.BK.bg,235.0,40.0).DY(boot.BK.bk,6.0,0.45).DY(boot.BK.dc,50.0,3.4).DY(boot.BK.dg,0.658,2.5).DY(boot.BK.ff,14.0,3.0).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,175.0).DZ(boot.BK.ik,340.0);
		boot.BP.cd.DX(boot.BR.c).DY(boot.BK.p,463.0,98.0).DY(boot.BK.bd,7.45,0.55).DY(boot.BK.bg,230.0,35.0).DY(boot.BK.bk,6.4,0.7).DY(boot.BK.dc,56.3,3.375).DY(boot.BK.dg,0.638,3.4).DY(boot.BK.ff,18.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.ce.DX(boot.BR.c).DY(boot.BK.p,420.0,90.0).DY(boot.BK.bd,6.0,0.8).DY(boot.BK.bg,240.0,40.0).DY(boot.BK.bk,7.0,0.7).DY(boot.BK.dc,46.5,3.5).DY(boot.BK.dg,0.658,3.0).DY(boot.BK.ff,12.5,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.cf.DX(boot.BR.c).DY(boot.BK.p,420.0,90.0).DY(boot.BK.bd,6.0,0.8).DY(boot.BK.bg,240.0,40.0).DY(boot.BK.bk,7.0,0.7).DY(boot.BK.dc,46.5,3.5).DY(boot.BK.dg,0.658,3.0).DY(boot.BK.ff,12.5,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,500.0).DZ(boot.BK.ik,335.0);
		boot.BP.cg.DX(boot.BR.c).DY(boot.BK.p,410.0,86.0).DY(boot.BK.bd,4.7,0.55).DY(boot.BK.bg,240.0,60.0).DY(boot.BK.bk,6.8,0.65).DY(boot.BK.dc,50.0,3.3).DY(boot.BK.dg,0.625,2.3).DY(boot.BK.ff,15.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,425.0).DZ(boot.BK.ik,335.0);
		boot.BP.ch.DX(boot.BR.c).DY(boot.BK.p,390.0,75.0).DY(boot.BK.bd,5.5,0.55).DY(boot.BK.bg,270.0,61.0).DY(boot.BK.bk,6.5,0.6).DY(boot.BK.dc,42.2,3.25).DY(boot.BK.dg,0.625,2.11).DY(boot.BK.ff,11.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,450.0).DZ(boot.BK.ik,335.0);
		boot.BP.ci.DX(boot.BR.c).DY(boot.BK.p,433.0,78.0).DY(boot.BK.bd,6.95,0.5).DY(boot.BK.bg,230.0,45.0).DY(boot.BK.bk,6.9,0.6).DY(boot.BK.dc,52.3,3.9).DY(boot.BK.dg,0.638,3.7).DY(boot.BK.ff,14.0,3.2).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,340.0);
		boot.BP.cj.DX(boot.BR.c).DY(boot.BK.p,395.0,83.0).DY(boot.BK.bd,6.95,0.55).DY(boot.BK.dc,53.0,3.2).DY(boot.BK.dg,0.658,2.74).DY(boot.BK.ff,14.75,4.0).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.ck.DX(boot.BR.c).DY(boot.BK.p,418.0,93.0).DY(boot.BK.bd,7.0,0.75).DY(boot.BK.bg,255.0,40.0).DY(boot.BK.bk,6.9,0.525).DY(boot.BK.dc,53.3,2.8).DY(boot.BK.dg,0.638,2.5).DY(boot.BK.ff,17.0,3.5).DY(boot.BK.fj,30.0,0.75).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.ck.DX(boot.BR.k).DY(boot.BK.fj,30.0,0);
		boot.BP.cl.DX(boot.BR.c).DY(boot.BK.p,403.0,79.0).DY(boot.BK.bd,4.65,0.65).DZ(boot.BK.bn,200.0).DZ(boot.BK.ca,50.0).DY(boot.BK.dc,51.3,3.3).DY(boot.BK.dg,0.69,3.4).DY(boot.BK.ff,14.0,3.75).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,335.0);
		boot.BP.cm.DX(boot.BR.c).DY(boot.BK.p,430.0,85.0).DY(boot.BK.bd,6.25,0.75).DY(boot.BK.bg,260.0,40.0).DY(boot.BK.bk,6.75,0.5).DY(boot.BK.dc,50.0,3.1).DY(boot.BK.dg,0.665,2.7).DY(boot.BK.ff,15.0,3.0).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.cn.DX(boot.BR.c).DY(boot.BK.p,440.0,84.0).DY(boot.BK.bd,5.0,0.55).DY(boot.BK.bg,295.0,40.0).DY(boot.BK.bk,7.5,0.7).DY(boot.BK.dc,46.0,3.0).DY(boot.BK.dg,0.665,2.65).DY(boot.BK.ff,13.0,3.53).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,500.0).DZ(boot.BK.ik,340.0);
		boot.BP.co.DX(boot.BR.c).DY(boot.BK.p,390.0,75.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,250.0,50.0).DY(boot.BK.bk,6.9,0.6).DY(boot.BK.dc,51.0,3.1).DY(boot.BK.dg,0.625,1.4).DY(boot.BK.ff,12.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,525.0).DZ(boot.BK.ik,335.0);
		boot.BP.cp.DX(boot.BR.c).DY(boot.BK.p,428.0,85.0).DY(boot.BK.bd,6.25,61.0).DZ(boot.BK.ca,200.0).DZ(boot.BK.ca,50.0).DY(boot.BK.dc,55.8,3.2).DY(boot.BK.dg,0.651,3.0).DY(boot.BK.ff,16.0,3.7).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.da.DX(boot.BR.c).DY(boot.BK.p,430.0,87.0).DY(boot.BK.bd,9.0,0.85).DY(boot.BK.bg,235.0,40.0).DY(boot.BK.bk,8.0,0.7).DY(boot.BK.dc,55.0,3.0).DY(boot.BK.dg,0.625,2.9).DY(boot.BK.ff,18.0,3.1).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.db.DX(boot.BR.c).DY(boot.BK.p,415.0,82.0).DY(boot.BK.bd,6.0,0.72).DY(boot.BK.bg,200.0,50.0).DY(boot.BK.bk,6.0,0.6).DY(boot.BK.dc,44.4,2.6).DY(boot.BK.dg,0.625,2.2).DY(boot.BK.ff,9.0,3.7).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,325.0);
		boot.BP.dc.DX(boot.BR.c).DY(boot.BK.p,345.0,79.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,250.0,50.0).DY(boot.BK.bk,6.0,0.6).DY(boot.BK.dc,50.0,3.3).DY(boot.BK.dg,0.625,1.36).DY(boot.BK.ff,8.0,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,340.0);
		boot.BP.dd.DX(boot.BR.c).DY(boot.BK.p,423.0,90.0).DY(boot.BK.bd,7.45,0.55).DY(boot.BK.bg,215.0,40.0).DY(boot.BK.bk,6.4,0.55).DY(boot.BK.dc,56.3,3.375).DY(boot.BK.dg,0.638,3.4).DY(boot.BK.ff,18.0,3.75).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.de.DX(boot.BR.c).DY(boot.BK.p,380.0,80.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,250.0,45.0).DY(boot.BK.bk,7.0,0.6).DY(boot.BK.dc,51.66,3.0).DY(boot.BK.dg,0.625,1.36).DY(boot.BK.ff,15.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,340.0);
		boot.BP.df.DX(boot.BR.c).DY(boot.BK.p,421.0,90.0).DY(boot.BK.bd,7.25,0.85).DY(boot.BK.bg,250.0,46.0).DY(boot.BK.bk,6.45,0.45).DY(boot.BK.dc,58.0,3.3).DY(boot.BK.dg,0.694,2.13).DY(boot.BK.ff,18.0,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.dg.DX(boot.BR.c).DY(boot.BK.p,444.0,86.0).DY(boot.BK.bd,6.75,0.65).DY(boot.BK.bg,199.0,36.0).DY(boot.BK.bk,6.5,0.45).DY(boot.BK.dc,55.12,3.1).DY(boot.BK.dg,0.679,2.98).DY(boot.BK.ff,16.3,3.7).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,355.0);
		boot.BP.dh.DX(boot.BR.c).DY(boot.BK.p,435.0,85.0).DY(boot.BK.bd,5.1,0.65).DY(boot.BK.bg,212.0,38.0).DY(boot.BK.bk,6.95,0.65).DY(boot.BK.dc,46.5,3.0).DY(boot.BK.dg,0.658,3.01).DY(boot.BK.ff,15.0,3.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,325.0);
		boot.BP.di.DX(boot.BR.c).DY(boot.BK.p,421.0,80.0).DY(boot.BK.bd,7.45,0.55).DY(boot.BK.dc,51.7,3.5).DY(boot.BK.dg,0.694,3.0).DY(boot.BK.ff,15.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,340.0);
		boot.BP.dj.DX(boot.BR.c).DY(boot.BK.p,403.0,86.0).DY(boot.BK.bd,4.7,0.6).DY(boot.BK.bg,240.0,60.0).DY(boot.BK.bk,6.8,0.65).DY(boot.BK.dc,51.58,3.5).DY(boot.BK.dg,0.579,1.53).DY(boot.BK.ff,15.0,3.8).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,425.0).DZ(boot.BK.ik,335.0);
		boot.BP.dk.DX(boot.BR.c).DY(boot.BK.p,365.0,74.0).DY(boot.BK.bd,4.5,45.0).DY(boot.BK.bg,305.0,43.0).DY(boot.BK.bk,6.9,0.6).DY(boot.BK.dc,48.0,3.1).DY(boot.BK.dg,0.644,2.6).DY(boot.BK.ff,9.0,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,340.0);
		boot.BP.dl.DX(boot.BR.c).DY(boot.BK.p,410.0,90.0).DY(boot.BK.bd,7.5,0.9).DY(boot.BK.bg,200.0,45.0).DY(boot.BK.bk,6.6,0.5).DY(boot.BK.dc,53.3,3.5).DY(boot.BK.dg,0.638,3.48).DY(boot.BK.ff,15.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.dm.DX(boot.BR.c).DY(boot.BK.p,432.0,86.0).DY(boot.BK.bd,7.45,0.55).DY(boot.BK.bg,200.0,50.0).DY(boot.BK.bk,7.45,0.7).DY(boot.BK.dc,52.0,3.3).DY(boot.BK.dg,0.613,0.98).DY(boot.BK.ff,12.0,3.25).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,175.0).DZ(boot.BK.ik,325.0);
		boot.BP.dn.DX(boot.BR.c).DY(boot.BK.p,370.0,90.0).DY(boot.BK.bd,5.0,0.6).DY(boot.BK.bg,220.0,45.0).DY(boot.BK.bk,7.0,0.5).DY(boot.BK.dc,49.0,3.5).DY(boot.BK.dg,0.672,3.22).DY(boot.BK.ff,11.0,3.5).DY(boot.BK.fj,30.0,0.75).DZ(boot.BK.gj,525.0).DZ(boot.BK.ik,335.0);
		boot.BP.dn.DX(boot.BR.k).DY(boot.BK.fj,30.0,0);
		boot.BP.dp.DX(boot.BR.c).DY(boot.BK.p,370.0,90.0).DY(boot.BK.bd,5.0,0.6).DY(boot.BK.bg,220.0,45.0).DY(boot.BK.bk,7.0,0.5).DY(boot.BK.dc,49.0,3.5).DY(boot.BK.dg,0.672,3.22).DY(boot.BK.ff,11.0,3.5).DY(boot.BK.fj,30.0,0.75).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.dp.DX(boot.BR.k).DY(boot.BK.fj,30.0,0);
		boot.BP.ea.DX(boot.BR.c).DY(boot.BK.p,430.0,85.0).DY(boot.BK.bd,7.0,0.75).DY(boot.BK.bg,215.0,35.0).DY(boot.BK.bk,6.0,0.45).DY(boot.BK.dc,54.0,3.1).DY(boot.BK.dg,0.668,2.7).DY(boot.BK.ff,17.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.eb.DX(boot.BR.c).DY(boot.BK.p,437.0,108.0).DY(boot.BK.bd,7.05,0.8).DY(boot.BK.bg,213.0,42.0).DY(boot.BK.bk,6.6,0.5).DY(boot.BK.dc,51.6,3.4).DY(boot.BK.dg,0.625,2.25).DY(boot.BK.ff,16.5,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.ec.DX(boot.BR.c).DY(boot.BK.p,441.0,93.0).DY(boot.BK.bd,7.0,0.9).DY(boot.BK.bg,225.0,45.0).DY(boot.BK.bk,6.5,0.575).DY(boot.BK.dc,54.1,3.5).DY(boot.BK.dg,0.694,2.7).DY(boot.BK.ff,17.0,3.0).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.ed.DX(boot.BR.c).DY(boot.BK.p,385.0,79.0).DY(boot.BK.bd,5.95,0.55).DY(boot.BK.bg,250.0,50.0).DY(boot.BK.bk,7.0,0.5).DY(boot.BK.dc,44.0,2.6).DY(boot.BK.dg,0.658,3.5).DY(boot.BK.ff,8.0,3.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,525.0).DZ(boot.BK.ik,325.0);
		boot.BP.ee.DX(boot.BR.c).DY(boot.BK.p,433.0,87.0).DY(boot.BK.bd,6.75,0.65).DY(boot.BK.bg,210.0,34.0).DY(boot.BK.bk,6.6,0.45).DY(boot.BK.dc,50.7,2.9).DY(boot.BK.dg,0.679,2.95).DY(boot.BK.ff,17.1,3.9).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,155.0).DZ(boot.BK.ik,355.0);
		boot.BP.ef.DX(boot.BR.c).DY(boot.BK.p,423.0,81.0).DY(boot.BK.bd,7.45,0.55).DY(boot.BK.bg,185.0,30.0).DY(boot.BK.bk,6.4,0.45).DY(boot.BK.dc,56.3,3.375).DY(boot.BK.dg,0.638,3.35).DY(boot.BK.ff,18.0,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.eh.DX(boot.BR.c).DY(boot.BK.p,420.0,86.0).DY(boot.BK.bd,8.0,0.55).DY(boot.BK.bg,255.0,33.0).DY(boot.BK.bk,4.5,0.3).DY(boot.BK.dc,50.0,3.5).DY(boot.BK.dg,0.625,2.22).DY(boot.BK.ff,21.0,3.8).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.ei.DX(boot.BR.c).DY(boot.BK.p,426.0,87.0).DY(boot.BK.bd,6.7,0.75).DY(boot.BK.dc,53.12,3.1).DY(boot.BK.dg,0.665,2.65).DY(boot.BK.ff,15.2,3.8).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.ej.DX(boot.BR.c).DY(boot.BK.p,435.0,85.0).DY(boot.BK.bd,4.0,0.4).DY(boot.BK.dc,55.0,3.0).DY(boot.BK.dg,0.679,2.85).DY(boot.BK.ff,16.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.ek.DX(boot.BR.c).DY(boot.BK.p,414.0,86.0).DY(boot.BK.bd,5.5,0.5).DY(boot.BK.dc,54.0,2.75).DY(boot.BK.dg,0.625,3.5).DY(boot.BK.ff,15.0,3.1).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.el.DX(boot.BR.c).DY(boot.BK.p,450.0,80.0).DY(boot.BK.bd,7.0,0.7).DY(boot.BK.dc,55.32,3.2).DY(boot.BK.dg,0.644,1.85).DY(boot.BK.ff,16.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.em.DX(boot.BR.c).DY(boot.BK.p,360.0,86.0).DY(boot.BK.bd,4.35,0.55).DY(boot.BK.bg,250.0,55.0).DY(boot.BK.bk,7.0,0.6).DY(boot.BK.dc,52.0,3.0).DY(boot.BK.dg,0.625,2.11).DY(boot.BK.ff,11.0,3.9).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,335.0);
		boot.BP.en.DX(boot.BR.c).DY(boot.BK.p,450.0,85.0).DY(boot.BK.bd,7.35,0.85).DY(boot.BK.bg,220.0,40.0).DY(boot.BK.bk,6.45,0.45).DY(boot.BK.dc,54.0,3.4).DY(boot.BK.dg,0.67,1.45).DY(boot.BK.ff,20.5,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,340.0);
		boot.BP.eo.DX(boot.BR.c).DY(boot.BK.p,441.0,84.0).DY(boot.BK.bd,7.45,0.55).DY(boot.BK.bg,270.0,40.0).DY(boot.BK.bk,6.4,0.45).DY(boot.BK.dc,51.7,3.5).DY(boot.BK.dg,0.694,3.0).DY(boot.BK.ff,15.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.ep.DX(boot.BR.c).DY(boot.BK.p,428.0,85.0).DY(boot.BK.bd,7.45,0.55).DZ(boot.BK.bn,200.0).DZ(boot.BK.ca,50.0).DY(boot.BK.dc,54.5,3.375).DY(boot.BK.dg,0.651,3.4).DY(boot.BK.ff,15.0,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,335.0);
		boot.BP.fa.DX(boot.BR.c).DY(boot.BK.p,435.0,95.0).DY(boot.BK.bd,7.2,0.8).DY(boot.BK.dc,54.5,3.4).DY(boot.BK.dg,0.658,3.4).DY(boot.BK.ff,17.6,3.4).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.fb.DX(boot.BR.c).DY(boot.BK.p,405.0,82.0).DY(boot.BK.bd,7.1,0.55).DY(boot.BK.bg,215.0,45.0).DY(boot.BK.bk,6.6,0.55).DY(boot.BK.dc,56.65,3.375).DY(boot.BK.dg,0.613,1.81).DY(boot.BK.ff,18.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.fc.DX(boot.BR.c).DY(boot.BK.p,403.0,104.0).DY(boot.BK.bd,7.9,0.95).DY(boot.BK.bg,240.0,40.0).DY(boot.BK.bk,6.3,0.4).DY(boot.BK.dc,55.52,3.1875).DY(boot.BK.dg,0.625,1.63).DY(boot.BK.ff,17.75,3.25).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.fd.DX(boot.BR.c).DY(boot.BK.p,378.0,82.0).DY(boot.BK.bd,4.25,0.55).DY(boot.BK.bg,203.0,43.0).DY(boot.BK.bk,6.5,0.5).DY(boot.BK.dc,49.0,2.9).DY(boot.BK.dg,0.658,3.28).DY(boot.BK.ff,12.75,3.25).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,500.0).DZ(boot.BK.ik,335.0);
		boot.BP.fe.DX(boot.BR.c).DY(boot.BK.p,440.0,96.0).DY(boot.BK.bd,7.5,0.85).DY(boot.BK.bg,205.0,40.0).DY(boot.BK.bk,6.45,0.45).DY(boot.BK.dc,54.1,4.2).DY(boot.BK.dg,0.625,2.1).DY(boot.BK.ff,19.0,3.8).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.ff.DX(boot.BR.c).DY(boot.BK.p,340.0,70.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,265.0,45.0).DY(boot.BK.bk,7.0,0.65).DY(boot.BK.dc,47.0,3.0).DY(boot.BK.dg,0.644,2.3).DY(boot.BK.ff,6.0,3.3).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,330.0);
		boot.BP.fg.DX(boot.BR.c).DY(boot.BK.p,375.0,71.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,240.0,60.0).DY(boot.BK.bk,6.8,0.65).DY(boot.BK.dc,48.8,3.0).DY(boot.BK.dg,0.625,2.14).DY(boot.BK.ff,7.4,3.8).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,335.0);
		boot.BP.fh.DX(boot.BR.c).DY(boot.BK.p,385.0,78.0).DY(boot.BK.bd,6.75,0.65).DY(boot.BK.bg,240.0,50.0).DY(boot.BK.bk,6.8,0.65).DY(boot.BK.dc,49.0,3.0).DY(boot.BK.dg,0.625,2.11).DY(boot.BK.ff,12.0,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,500.0).DZ(boot.BK.ik,335.0);
		boot.BP.fi.DX(boot.BR.c).DY(boot.BK.p,380.0,78.0).DY(boot.BK.bd,5.5,0.6).DY(boot.BK.bg,250.0,50.0).DY(boot.BK.bk,6.9,0.6).DY(boot.BK.dc,51.0,2.9).DY(boot.BK.dg,0.625,2.0).DY(boot.BK.ff,15.0,3.4).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,330.0);
		boot.BP.fj.DX(boot.BR.c).DY(boot.BK.p,440.0,85.0).DY(boot.BK.bd,7.25,0.75).DY(boot.BK.bg,260.0,40.0).DY(boot.BK.bk,6.75,0.5).DY(boot.BK.dc,50.0,3.1).DY(boot.BK.dg,0.668,2.7).DY(boot.BK.ff,17.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.fk.DX(boot.BR.c).DY(boot.BK.p,468.0,90.0).DY(boot.BK.bd,7.1,0.5).DY(boot.BK.bg,255.0,56.0).DY(boot.BK.bk,4.1,0.4).DY(boot.BK.dc,58.0,3.5).DY(boot.BK.dg,0.625,2.02).DY(boot.BK.ff,16.5,3.2).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,340.0);
		boot.BP.fk.DX(boot.BR.k).DY(boot.BK.dc,53.0,3.5);
		boot.BP.fl.DX(boot.BR.c).DY(boot.BK.p,383.0,82.0).DY(boot.BK.bd,4.65,0.65).DY(boot.BK.bg,200.0,40.0).DY(boot.BK.bk,6.45,0.45).DY(boot.BK.dc,44.5,3.0).DY(boot.BK.dg,0.69,3.38).DY(boot.BK.ff,14.0,3.75).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,500.0).DZ(boot.BK.ik,330.0);
		boot.BP.fn.DX(boot.BR.c).DY(boot.BK.p,415.0,82.0).DY(boot.BK.bd,5.1,0.65).DY(boot.BK.bg,193.0,32.0).DY(boot.BK.bk,6.45,0.45).DY(boot.BK.dc,46.5,3.0).DY(boot.BK.dg,0.658,3.01).DY(boot.BK.ff,15.0,3.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,325.0);
		boot.BP.fn.DX(boot.BR.k).DY(boot.BK.dg,0.658,4.0);
		boot.BP.fo.DX(boot.BR.c).DY(boot.BK.p,455.0,96.0).DY(boot.BK.bd,8.0,0.85).DY(boot.BK.bg,206.0,45.0).DY(boot.BK.bk,6.9,0.6).DY(boot.BK.dc,54.66,3.0).DY(boot.BK.dg,0.672,2.9).DY(boot.BK.ff,19.0,2.7).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.fp.DX(boot.BR.c).DY(boot.BK.p,461.0,98.0).DY(boot.BK.bd,7.9,0.9).DY(boot.BK.dc,56.0,3.2).DY(boot.BK.dg,0.67,2.9).DY(boot.BK.ff,14.9,3.1).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.ga.DX(boot.BR.c).DY(boot.BK.p,384.0,82.0).DY(boot.BK.bd,4.5,0.6).DY(boot.BK.bg,202.0,38.0).DY(boot.BK.bk,6.5,0.5).DY(boot.BK.dc,46.61,3.3).DY(boot.BK.dg,0.651,3.22).DY(boot.BK.ff,11.25,3.15).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,525.0).DZ(boot.BK.ik,330.0);
		boot.BP.gb.DX(boot.BR.c).DY(boot.BK.p,389.0,81.0).DY(boot.BK.bd,5.0,0.6).DY(boot.BK.bg,220.0,40.0).DY(boot.BK.bk,6.5,0.45).DY(boot.BK.dc,49.0,3.0).DY(boot.BK.dg,0.679,3.38).DY(boot.BK.ff,14.0,3.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,330.0);
		boot.BP.gc.DX(boot.BR.c).DY(boot.BK.p,427.0,99.0).DY(boot.BK.bd,7.45,0.75).DY(boot.BK.bg,220.0,30.0).DY(boot.BK.bk,6.4,0.45).DY(boot.BK.dc,52.91,3.2).DY(boot.BK.dg,0.658,2.67).DY(boot.BK.ff,14.75,4.0).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.gd.DX(boot.BR.c).DY(boot.BK.p,437.0,89.0).DY(boot.BK.bd,5.5,0.6).DY(boot.BK.bg,220.0,55.0).DY(boot.BK.bk,7.5,0.65).DY(boot.BK.dc,48.0,3.6).DY(boot.BK.dg,0.644,2.9).DY(boot.BK.ff,15.0,3.3).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,425.0).DZ(boot.BK.ik,335.0);
		boot.BP.ge.DX(boot.BR.c).DY(boot.BK.p,400.0,82.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,250.0,36.0).DY(boot.BK.bk,6.5,0.5).DY(boot.BK.dc,46.0,3.0).DY(boot.BK.dg,0.658,2.65).DY(boot.BK.ff,13.5,3.4).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,575.0).DZ(boot.BK.ik,335.0);
		boot.BP.gf.DX(boot.BR.c).DY(boot.BK.p,359.0,83.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,173.0,27.0).DY(boot.BK.bk,6.3,0.4).DY(boot.BK.dc,50.0,3.25).DY(boot.BK.dg,0.658,3.1).DY(boot.BK.ff,9.3,3.4).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,330.0);
		boot.BP.gf.DX(boot.BR.k).DY(boot.BK.bg,173.0,35.0).DY(boot.BK.dg,0.658,4.0);
		boot.BP.gg.DX(boot.BR.c).DY(boot.BK.p,355.0,82.0).DY(boot.BK.bd,4.5,0.55).DY(boot.BK.bg,250.0,55.0).DY(boot.BK.bk,6.9,0.6).DY(boot.BK.dc,48.3,2.625).DY(boot.BK.dg,0.625,2.24).DY(boot.BK.ff,12.25,3.75).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,525.0).DZ(boot.BK.ik,340.0);
		boot.BP.gh.DX(boot.BR.c).DY(boot.BK.p,440.0,85.0).DY(boot.BK.bd,7.5,0.9).DY(boot.BK.bg,220.0,45.0).DY(boot.BK.bk,7.0,0.65).DY(boot.BK.dc,55.0,3.5).DY(boot.BK.dg,0.643,2.5).DY(boot.BK.ff,16.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,350.0);
		boot.BP.gh.DX(boot.BR.k).DY(boot.BK.dc,51.0,3.5);
		boot.BP.gi.DX(boot.BR.c).DY(boot.BK.p,385.0,78.0).DY(boot.BK.bd,6.75,0.65).DY(boot.BK.bg,240.0,50.0).DY(boot.BK.bk,6.9,0.45).DY(boot.BK.dc,49.0,3.0).DY(boot.BK.dg,0.625,2.11).DY(boot.BK.ff,12.0,4.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,525.0).DZ(boot.BK.ik,335.0);
		boot.BP.gj.DX(boot.BR.c).DY(boot.BK.p,400.0,85.0).DY(boot.BK.bd,6.0,0.6).DY(boot.BK.dc,45.0,3.0).DY(boot.BK.dg,0.6258,2.0).DY(boot.BK.ff,12.0,3.5).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,450.0).DZ(boot.BK.ik,335.0);
		boot.BP.gk.DX(boot.BR.c).DY(boot.BK.p,440.0,86.0).DY(boot.BK.bd,7.0,0.65).DY(boot.BK.bg,220.0,30.0).DY(boot.BK.bk,7.0,0.65).DY(boot.BK.dc,54.0,3.3).DY(boot.BK.dg,0.658,2.9).DY(boot.BK.ff,16.5,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.gl.DX(boot.BR.c).DY(boot.BK.p,428.0,98.0).DY(boot.BK.bd,7.05,0.8).DY(boot.BK.bg,190.0,30.0).DY(boot.BK.bk,7.1,0.6).DY(boot.BK.dc,56.76,3.375).DY(boot.BK.dg,0.679,2.88).DY(boot.BK.ff,16.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.gm.DX(boot.BR.c).DY(boot.BK.p,435.0,85.0).DY(boot.BK.bd,5.1,0.65).DY(boot.BK.bg,202.0,38.0).DY(boot.BK.bk,6.9,0.65).DY(boot.BK.dc,54.0,3.2).DY(boot.BK.dg,0.658,3.0).DY(boot.BK.ff,15.0,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,175.0).DZ(boot.BK.ik,345.0);
		boot.BP.gn.DX(boot.BR.c).DY(boot.BK.p,380.0,80.0).DY(boot.BK.bd,5.0,0.55).DY(boot.BK.bg,250.0,45.0).DY(boot.BK.bk,8.0,0.6).DY(boot.BK.dc,52.0,3.0).DY(boot.BK.dg,0.625,1.36).DY(boot.BK.ff,12.6,3.4).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,550.0).DZ(boot.BK.ik,340.0);
		boot.BP.go.DX(boot.BR.c).DY(boot.BK.p,445.0,87.0).DY(boot.BK.bd,7.0,0.7).DY(boot.BK.bg,213.0,31.0).DY(boot.BK.bk,6.6,0.45).DY(boot.BK.dc,52.0,3.3).DY(boot.BK.dg,0.672,2.7).DY(boot.BK.ff,16.2,3.7).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,175.0).DZ(boot.BK.ik,345.0);
		boot.BP.gp.DX(boot.BR.c).DY(boot.BK.p,421.0,85.0).DY(boot.BK.bd,8.5,0.7).DY(boot.BK.bg,235.0,35.0).DY(boot.BK.bk,6.5,0.45).DY(boot.BK.dc,51.5,3.5).DY(boot.BK.dg,0.625,3.0).DY(boot.BK.ff,18.0,3.6).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.ha.DX(boot.BR.c).DY(boot.BK.p,445.0,85.0).DY(boot.BK.bd,6.0,0.65).DZ(boot.BK.bn,20.0).DZ(boot.BK.ca,50.0).DY(boot.BK.dc,48.6,3.4).DY(boot.BK.dg,0.658,3.1).DY(boot.BK.ff,17.5,3.5).DY(boot.BK.fj,30.0,1.25).DZ(boot.BK.gj,125.0).DZ(boot.BK.ik,345.0);
		boot.BP.hb.DX(boot.BR.c).DY(boot.BK.p,390.0,80.0).DY(boot.BK.bd,5.25,0.6).DY(boot.BK.bg,250.0,50.0).DY(boot.BK.bk,6.75,0.6).DY(boot.BK.dc,54.0,3.1).DY(boot.BK.dg,0.656,1.7).DY(boot.BK.ff,12.0,3.3).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,575.0).DZ(boot.BK.ik,330.0);
		boot.BP.hc.DX(boot.BR.c).DY(boot.BK.p,380.0,71.0).DY(boot.BK.bd,4.6,0.5).DY(boot.BK.bg,260.0,60.0).DY(boot.BK.bk,6.95,0.65).DY(boot.BK.dc,48.6,3.0).DY(boot.BK.dg,0.625,2.13).DY(boot.BK.ff,6.75,3.8).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,600.0).DZ(boot.BK.ik,335.0);
		boot.BP.hd.DX(boot.BR.c).DY(boot.BK.p,355.0,74.0).DY(boot.BK.bd,4.85,0.5).DY(boot.BK.bg,250.0,50.0).DY(boot.BK.bk,7.1,0.75).DY(boot.BK.dc,50.0,3.2).DY(boot.BK.dg,0.625,1.8).DY(boot.BK.ff,11.0,3.0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,575.0).DZ(boot.BK.ik,325.0);
		boot.BP.fm.DX(boot.BR.c).DY(boot.BK.p,452.0,92.0).DY(boot.BK.bd,9.0,0.85).DY(boot.BK.bg,200.0,50.0).DY(boot.BK.bk,8.45,0.85).DY(boot.BK.dc,46.0,2.2).DY(boot.BK.dg,0.625,2.1).DY(boot.BK.ff,18.0,0).DY(boot.BK.fj,30.0,0).DZ(boot.BK.gj,475.0).DZ(boot.BK.ik,325.0);
	},
	// teemowork.model.Champion#<init>(java.lang.String, teemowork.model.Skill[])
	$0:function(A,B){
		boot.BP.prototype.$1.call(this,A,0,B);
	},
	// teemowork.model.Champion#<init>(java.lang.String, boolean, teemowork.model.Skill[])
	$1:function(A,B,C){
		this.hh=new Array(boot.BR.Du().length);
		this.he=A;
		this.hf=this.Dv().toLowerCase().replace(/[\s'\.]/g,"");
		this.hg=C;
		if(!(B!=0)){
			boot.BP.a.BV(this);
		}
	},
	// teemowork.model.Champion#getSystemName()
	Dv:function(){
		return this.he.replace(/\./g,"").replace(/\s/g,"").replace(/\'/g,"");
	},
	// teemowork.model.Champion#getSplashArt()
	Dw:function(){
		return "src/main/resources/teemowork/splash/"+this.Dv()+".jpg";
	},
	// teemowork.model.Champion#getIcon()
	CM:function(){
		return "src/main/resources/teemowork/icon/"+this.Dv()+".png";
	},
	// teemowork.model.Champion#getStatus(teemowork.model.Version)
	CL:function(A,B,C){
		B=A.CB();
		l2:for (;
		B>=0;
		--B) {
			C=this.hh[B];
			if(C==null){
			}else{
				return C;
			}
		}return null;
	},
	// teemowork.model.Champion#update(teemowork.model.Version)
	DX:function(A,B){
		B=new boot.BS(this.CL(A),0);
		this.hh[A.CB()]=B;
		return B;
	},
	// teemowork.model.Champion#getAll()
	_CK:function(){
		return boot.BP.a;
	},
	// teemowork.model.Champion#getByName(java.lang.String)
	_Dx:function(A,B,C){
		C=boot.BP.a.BG();
		l1:while (C.BI()!=0) {
			B=C.BH();
			if(!(B.hf.equals(A)==0)){
				return B;
			}continue l1;
		}return null;
	}
});

boot.define("BM","",[],{
	// teemowork.model.ChampionGroup#<clinit>()
	_:function(){
		boot.BM.a=new boot.BM([boot.BP.h,boot.BP.k,boot.BP.n,boot.BP.bb,boot.BP.bf,boot.BP.bn,boot.BP.ce,boot.BP.cl,boot.BP.cn,boot.BP.dh,boot.BP.fd,boot.BP.fl,boot.BP.fm,boot.BP.fn,boot.BP.ga,boot.BP.gb,boot.BP.gd,boot.BP.ge,boot.BP.gf],0);
	},
	// teemowork.model.ChampionGroup#<init>(teemowork.model.Champion[])
	$0:function(A,B,C,D,E){
		this.b=new boot.BL(0);
		E=A;D=E.length;C=0;
		l3:for (;
		C<D;
		++C) {
			B=E[C];
			this.b.BV(B);
		}
	},
	// teemowork.model.ChampionGroup#contains(teemowork.model.Champion)
	CQ:function(A){
		return this.b.BD(A);
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
boot.define("CS","",["V"],{
	a:0,
	// js.util.jQuery$1#<init>(js.util.jQuery)
	$0:function(A){
		this.b=A;
		this.a=0;
	},
	// js.util.jQuery$1#hasNext()
	BI:function(){
		return this.a<this.b.size();
	},
	// js.util.jQuery$1#next()
	GB:function(){
		return $(this.b.get(this.a++));
	},
	// js.util.jQuery$1#remove()
	Bz:function(){
	},
	// js.util.jQuery$1#next()
	BH:function(){
		return this.GB();
	}
});

boot.defineNative("jQuery",{
	// js.util.jQuery#<init>()
	$0:function(){
	},
	// js.util.jQuery#child(java.lang.String)
	Fz:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// js.util.jQuery#child(java.lang.Class)
	CJ:function(A){
		return this.Fz("span").addClass(A);
	},
	// js.util.jQuery#child(booton.css.CSS)
	GA:function(A){
		return this.Fz("span").addClass(A);
	},
	// js.util.jQuery#iterator()
	BG:function(){
		return new boot.CS(this,0);
	}
});
boot.define("BO","",[],{
	// teemowork.ChampionComparing$1#<init>(teemowork.ChampionComparing, teemowork.model.Status)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// teemowork.ChampionComparing$1#handler(js.util.jQuery$Event)
	handler:function(A){
		boot.BI.CY(this.a,this.b);
	}
});

boot.define("BT","",[],{
	// teemowork.ChampionComparing$Row#<init>(teemowork.model.Champion, js.util.jQuery)
	$1:function(A,B){
		this.a=A;
		this.b=A.CL(boot.BR.m);
		this.c=B;
	},
	// teemowork.ChampionComparing$Row#access$0(teemowork.ChampionComparing$Row)
	_GC:function(A){
		return A.b;
	},
	// teemowork.ChampionComparing$Row#<init>(teemowork.model.Champion, js.util.jQuery, teemowork.ChampionComparing$Row)
	$0:function(A,B,C){
		boot.BT.prototype.$1.call(this,A,B);
	},
	// teemowork.ChampionComparing$Row#access$2(teemowork.ChampionComparing$Row)
	_CP:function(A){
		return A.a;
	},
	// teemowork.ChampionComparing$Row#access$3(teemowork.ChampionComparing$Row)
	_CR:function(A){
		return A.c;
	}
});

boot.define("CU","",[],{
	equals:null,compare:null
});

boot.define("BU","",["CU"],{
	b:0,
	// teemowork.ChampionComparing$Sorter#<init>(teemowork.model.Status)
	$1:function(A){
		this.b=1;
		this.a=A;
	},
	// teemowork.ChampionComparing$Sorter#compare(teemowork.ChampionComparing$Row, teemowork.ChampionComparing$Row)
	GD:function(A,B,C,E){
		C=boot.BT.GC(A).CN(this.a);
		E=boot.BT.GC(B).CN(this.a);
		if(C!=E){
			if(C>=E){
				return this.b*-1;
			}else{
				return this.b;
			}
		}else{
			return 0;
		}
	},
	// teemowork.ChampionComparing$Sorter#compare(java.lang.Object, java.lang.Object)
	compare:function(A,B){
		return this.GD(A,B);
	},
	// teemowork.ChampionComparing$Sorter#access$1(teemowork.ChampionComparing$Sorter)
	_CT:function(A){
		return A.a;
	},
	// teemowork.ChampionComparing$Sorter#access$2(teemowork.ChampionComparing$Sorter)
	_CU:function(A){
		return A.b;
	},
	// teemowork.ChampionComparing$Sorter#access$3(teemowork.ChampionComparing$Sorter, int)
	_CV:function(A,B){
		A.b=B;
	},
	// teemowork.ChampionComparing$Sorter#<init>(teemowork.model.Status, teemowork.ChampionComparing$Sorter)
	$0:function(A,B){
		boot.BU.prototype.$1.call(this,A);
	}
});

boot.define("BV","",[],{
	// js.util.Collections#<init>()
	$0:function(){
	},
	// js.util.Collections#sort(java.util.List, java.util.Comparator)
	_CW:function(A,B,C,D,E){
		C=A.BY();
		C.sortBy(B);
		D=A.DM();
		E=0;
		l5:for (;
		E<C.length;
		++E) {
			D.BH();
			D.DV(C[E]);
		}
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.BV.$;
		}
	}]
});

boot.define("BI","BJ",[],{
	// teemowork.ChampionComparing#<clinit>()
	_:function(){
		boot.BI.a=[boot.BK.p,boot.BK.bg,boot.BK.dc,boot.BK.dg,boot.BK.ff,boot.BK.fj,boot.BK.ik,boot.BK.gj];
	},
	// teemowork.ChampionComparing#<init>()
	$0:function(){
		boot.BJ.prototype.$0.call(this);
		this.b=new boot.BL(0);
		this.e=boot.BM.a;
	},
	// teemowork.ChampionComparing#load(js.util.jQuery)
	CI:function(A,B,C,D,E,F,G,H,I,J,K){
		B=A.CJ("c");
		C=B.CJ("d");
		C.CJ("e");
		C.CJ("f").text("Name");
		G=boot.BI.a;F=G.length;E=0;
		l5:for (;
		E<F;
		++E) {
			D=G[E];
			C.CJ("g").text(D.kf).click(new boot.BO(this,D,0));
		}this.c=B.CJ("h");
		E=boot.BP.CK().BG();
		l11:for (;
		E.BI()!=0;
		this.b.BV(new boot.BT(D,G,null,0))) {
			D=E.BH();
			F=D.CL(boot.BR.m);
			G=$("<div>").addClass("i");
			G.CJ("j").css("background-image","url("+D.CM()+")");
			G.CJ("f").text(D.he);
			K=boot.BI.a;J=K.length;I=0;
			l18:for (;
			I<J;
			++I) {
				H=K[I];
				G.CJ("g").text(F.CN(H));
			}
		}this.CO();
	},
	// teemowork.ChampionComparing#update()
	CO:function(A,B){
		this.c.empty();
		B=this.b.BG();
		l2:while (B.BI()!=0) {
			A=B.BH();
			if((this.e==null||this.e.CQ(boot.BT.CP(A))!=0)){
				this.c.append(boot.BT.CR(A));
				continue l2;
			}continue l2;
		}
	},
	// teemowork.ChampionComparing#sort(teemowork.model.Status)
	CS:function(A){
		if((this.d==null||boot.BU.CT(this.d)!=A)){
			this.d=new boot.BU(A,null,0);
		}else{
			boot.BU.CV(this.d,boot.BU.CU(this.d)*-1);
		}boot.BV.CW(this.b,this.d);
		this.CO();
	},
	// teemowork.ChampionComparing#getPageId()
	CX:function(){
		return "ChampionComparing";
	},
	// teemowork.ChampionComparing#access$0(teemowork.ChampionComparing, teemowork.model.Status)
	_CY:function(A,B){
		A.CS(B);
	}
},{
	$0:[{
		U: function() {
			return boot.BW.$;
		},
		CZ: function() {
			return "ChampionComparing";
		}
	}]
});

boot.define("DD","",[],{
	// js.bind.Notifiable$Observer#<init>(java.lang.Object, java.lang.reflect.Method)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.bind.Notifiable$Observer#<init>(java.lang.Object, java.lang.reflect.Method, js.bind.Notifiable$Observer)
	$0:function(A,B,C){
		boot.DD.prototype.$1.call(this,A,B);
	},
	// js.bind.Notifiable$Observer#access$1(js.bind.Notifiable$Observer)
	_Gz:function(A){
		return A.b;
	},
	// js.bind.Notifiable$Observer#access$2(js.bind.Notifiable$Observer)
	_HA:function(A){
		return A.a;
	}
});

boot.define("H","B",[],{
	// js.lang.reflect.JSMethod#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeArray)
	$0:function(A,B,C){
		boot.B.prototype.$0.call(this,A,C);
		this.c=B;
	},
	// js.lang.reflect.JSMethod#getName()
	L:function(){
		return this.a;
	},
	// js.lang.reflect.JSMethod#invoke(java.lang.Object, java.lang.Object[])
	u:function(A,B){
		return A[this.a].apply(A,B);
	}
},{
	$:[{
		U: function() {
			return boot.P.$;
		},
		V: function() {
			return boot.H.$;
		}
	}]
});

boot.define("CX","",[],{
	// js.bind.Notifiable#<init>()
	$0:function(){
		this.a=new boot.BL(0);
	},
	// js.bind.Notifiable#register(java.lang.Object, java.lang.reflect.Method)
	GF:function(A,B){
		this.a.BV(new boot.DD(A,B,null,0));
	},
	// js.bind.Notifiable#fire()
	GM:function(A,B,C){
		B=this.a.BG();
		l4:for (;
		B.BI()!=0;
		) {
			A=B.BH();
			try{
				boot.DD.Gz(A).u(boot.DD.HA(A),new Array(0));
			} catch ($) {
				if ($ instanceof boot.I) {
					throw new boot.K(1);
				}
			}continue l4;
		}
	}
});

boot.define("DB","",[],{
	// teemowork.model.ItemStatus#<init>(teemowork.model.ItemStatus)
	$0:function(A){
		if(A==null){
			this.a=[];
			this.b=[];
			this.c=new Array(0);
			this.d=new boot.L(0);
		}else{
			this.a=A.a.slice(0);
			this.b=A.b;
			this.c=A.c;
			this.d=A.d;
		}
	},
	// teemowork.model.ItemStatus#passive(java.lang.String, java.lang.String)
	HF:function(A,B,C,D,E,F,G,H,I){
		C=new boot.BL(0);
		G=B.split(/[\{\}]/);F=G.length;E=0;
		l2:while (E<F) {
			D=G[E];
			if((D.length!=1||jQuery.isNumeric(D.charAt(0))==0)){
				C.BV(D);
			}else{
				H=parseInt(D);
				I=this.b[H];
				if(!(I!=null)){
					I=new boot.CP(2);
					this.b[H]=I;
				}C.BV(I);
			}++E;
			continue l2;
		}this.d.T(A,C);
		return this;
	},
	// teemowork.model.ItemStatus#variable(int, teemowork.model.Status)
	HK:function(A,B){
		return this.HL(A,B,0);
	},
	// teemowork.model.ItemStatus#variable(int, teemowork.model.Status, double)
	HL:function(A,B,C){
		return this.HM(A,B,C,0);
	},
	// teemowork.model.ItemStatus#variable(int, teemowork.model.Status, double, double)
	HM:function(A,B,C,E){
		return this.HN(A,B,C,E,null,null);
	},
	// teemowork.model.ItemStatus#variable(int, teemowork.model.Status, teemowork.model.variable.VariableResolver)
	HO:function(A,B,C){
		return this.HP(A,B,C,null,null);
	},
	// teemowork.model.ItemStatus#variable(int, teemowork.model.Status, double, double, teemowork.model.variable.Variable)
	HG:function(A,B,C,E,G){
		return this.HN(A,B,C,E,G,null);
	},
	// teemowork.model.ItemStatus#variable(int, teemowork.model.Status, double, double, teemowork.model.variable.Variable, teemowork.model.variable.Variable)
	HN:function(A,B,C,E,G,H){
		return this.HP(A,B,new boot.CK(C,E,0,0),G,H);
	},
	// teemowork.model.ItemStatus#variable(int, teemowork.model.Status, teemowork.model.variable.VariableResolver, teemowork.model.variable.Variable, teemowork.model.variable.Variable)
	HP:function(A,B,C,D,E,F){
		F=new boot.CP(B,C,0);
		F.FC(D);
		F.FC(E);
		this.b.splice(A,0,F);
		return this;
	},
	// teemowork.model.ItemStatus#get(teemowork.model.Status)
	CN:function(A,B){
		B=this.a[A.CB()];
		return (B==null?0:B);
	},
	// teemowork.model.ItemStatus#set(teemowork.model.Status, double)
	HE:function(A,B){
		this.a[A.CB()]=B;
		return this;
	},
	// teemowork.model.ItemStatus#cost(double)
	HD:function(A){
		this.HE(boot.BK.jf,A);
		return this;
	},
	// teemowork.model.ItemStatus#build(teemowork.model.Item[])
	HC:function(A){
		this.c=A;
		return this;
	}
});

boot.define("Cz","",[],{
	// teemowork.model.Item#<clinit>()
	_:function(){
		boot.Cz.a=new boot.BL(0);
		boot.Cz.b=new boot.Cz(3001,"Abyssal Scepter",0);
		boot.Cz.c=new boot.Cz(3105,"Aegis of the Legion",0);
		boot.Cz.d=new boot.Cz(1052,"Amplifying Tome",0);
		boot.Cz.e=new boot.Cz(3003,"Archangel's Staff",0);
		boot.Cz.f=new boot.Cz(3174,"Athene's Unholy Grail",0);
		boot.Cz.g=new boot.Cz(3005,"Atma's Impaler",0);
		boot.Cz.h=new boot.Cz(3196,"Augment: Power",0);
		boot.Cz.i=new boot.Cz(3197,"Augment: Gravity",0);
		boot.Cz.j=new boot.Cz(3198,"Augment: Death",0);
		boot.Cz.k=new boot.Cz(3093,"Avarice Blade",0);
		boot.Cz.l=new boot.Cz(1038,"B. F. Sword",0);
		boot.Cz.m=new boot.Cz(3060,"Banner of Command",0);
		boot.Cz.n=new boot.Cz(3102,"Banshee's Veil",0);
		boot.Cz.o=new boot.Cz(3006,"Berserker's Greaves",0);
		boot.Cz.p=new boot.Cz(3144,"Bilgewater Cutlass",0);
		boot.Cz.ba=new boot.Cz(3071,"The Black Cleaver",0);
		boot.Cz.bb=new boot.Cz(3153,"Blade of the Ruined King",0);
		boot.Cz.bc=new boot.Cz(1026,"Blasting Wand",0);
		boot.Cz.bd=new boot.Cz(3072,"The Bloodthirster",0);
		boot.Cz.be=new boot.Cz(3166,"Bonetooth Necklace",0);
		boot.Cz.bf=new boot.Cz(3117,"Boots of Mobility",0);
		boot.Cz.bg=new boot.Cz(1001,"Boots of Speed",0);
		boot.Cz.bh=new boot.Cz(3009,"Boots of Swiftness",0);
		boot.Cz.bi=new boot.Cz(1051,"Brawler's Gloves",0);
		boot.Cz.bj=new boot.Cz(3134,"The Brutalizer",0);
		boot.Cz.bk=new boot.Cz(3010,"Catalyst the Protector",0);
		boot.Cz.bl=new boot.Cz(1031,"Chain Vest",0);
		boot.Cz.bm=new boot.Cz(3028,"Chalice of Harmony",0);
		boot.Cz.bn=new boot.Cz(1018,"Cloak of Agility",0);
		boot.Cz.bo=new boot.Cz(1029,"Cloth Armor",0);
		boot.Cz.bp=new boot.Cz(2041,"Crystalline Flask",0);
		boot.Cz.ca=new boot.Cz(1042,"Dagger",0);
		boot.Cz.cb=new boot.Cz(3128,"Deathfire Grasp",0);
		boot.Cz.cc=new boot.Cz(1055,"Doran's Blade",0);
		boot.Cz.cd=new boot.Cz(1056,"Doran's Ring",0);
		boot.Cz.ce=new boot.Cz(1054,"Doran's Shield",0);
		boot.Cz.cf=new boot.Cz(3173,"Eleisa's Miracle",0);
		boot.Cz.cg=new boot.Cz(2039,"Elixir of Brilliance",0);
		boot.Cz.ch=new boot.Cz(2037,"Elixir of Fortitude",0);
		boot.Cz.ci=new boot.Cz(3097,"Emblem of Valor",0);
		boot.Cz.cj=new boot.Cz(3123,"Executioner's Calling",0);
		boot.Cz.ck=new boot.Cz(1004,"Faerie Charm",0);
		boot.Cz.cl=new boot.Cz(3108,"Fiendish Codex",0);
		boot.Cz.cm=new boot.Cz(3110,"Frozen Heart",0);
		boot.Cz.cn=new boot.Cz(3022,"Frozen Mallet",0);
		boot.Cz.co=new boot.Cz(1011,"Giant's Belt",0);
		boot.Cz.cp=new boot.Cz(3024,"Glacial Shroud",0);
		boot.Cz.da=new boot.Cz(3026,"Guardian Angel",0);
		boot.Cz.db=new boot.Cz(3124,"Guinsoo's Rageblade",0);
		boot.Cz.dc=new boot.Cz(3136,"Haunting Guise",0);
		boot.Cz.dd=new boot.Cz(2003,"Health Potion",0);
		boot.Cz.de=new boot.Cz(3200,"The Hex Core",0);
		boot.Cz.df=new boot.Cz(3155,"Hexdrinker",0);
		boot.Cz.dg=new boot.Cz(3146,"Hextech Gunblade",0);
		boot.Cz.dh=new boot.Cz(3145,"Hextech Revolver",0);
		boot.Cz.di=new boot.Cz(1039,"Hunter's Machete",0);
		boot.Cz.dj=new boot.Cz(3025,"Iceborn Gauntlet",0);
		boot.Cz.dk=new boot.Cz(3031,"Infinity Edge",0);
		boot.Cz.dl=new boot.Cz(3158,"Ionian Boots of Lucidity",0);
		boot.Cz.dm=new boot.Cz(3098,"Kage's Lucky Pick",0);
		boot.Cz.dn=new boot.Cz(3067,"Kindlegem",0);
		boot.Cz.dp=new boot.Cz(3035,"Last Whisper",0);
		boot.Cz.ea=new boot.Cz(3151,"Liandry's Torment",0);
		boot.Cz.eb=new boot.Cz(3100,"Lich Bane",0);
		boot.Cz.ec=new boot.Cz(3190,"Locket of the Iron Solari",0);
		boot.Cz.ed=new boot.Cz(1036,"Long Sword",0);
		boot.Cz.ee=new boot.Cz(3106,"Madred's Razors",0);
		boot.Cz.ef=new boot.Cz(3114,"Malady",0);
		boot.Cz.eg=new boot.Cz(3037,"Mana Manipulator",0);
		boot.Cz.eh=new boot.Cz(2004,"Mana Potion",0);
		boot.Cz.ei=new boot.Cz(3004,"Manamune",0);
		boot.Cz.ej=new boot.Cz(3156,"Maw of Malmortius",0);
		boot.Cz.ek=new boot.Cz(3041,"Mejai's Soulstealer",0);
		boot.Cz.el=new boot.Cz(3139,"Mercurial Scimitar",0);
		boot.Cz.em=new boot.Cz(3111,"Mercury's Treads",0);
		boot.Cz.en=new boot.Cz(3222,"Mikael's Crucible",0);
		boot.Cz.eo=new boot.Cz(3165,"Morellonomicon",0);
		boot.Cz.ep=new boot.Cz(3042,"Muramana",0);
		boot.Cz.fa=new boot.Cz(3115,"Nashor's Tooth",0);
		boot.Cz.fb=new boot.Cz(1058,"Needlessly Large Rod",0);
		boot.Cz.fc=new boot.Cz(1057,"Negatron Cloak",0);
		boot.Cz.fd=new boot.Cz(3047,"Ninja Tabi",0);
		boot.Cz.fe=new boot.Cz(1033,"Null-Magic Mantle",0);
		boot.Cz.ff=new boot.Cz(3056,"Ohmwrecker",0);
		boot.Cz.fg=new boot.Cz(2042,"Oracle's Elixir",0);
		boot.Cz.fh=new boot.Cz(3044,"Phage",0);
		boot.Cz.fi=new boot.Cz(3046,"Phantom Dancer",0);
		boot.Cz.fj=new boot.Cz(3096,"Philosopher's Stone",0);
		boot.Cz.fk=new boot.Cz(1037,"Pickaxe",0);
		boot.Cz.fl=new boot.Cz(3140,"Quicksilver Sash",0);
		boot.Cz.fm=new boot.Cz(3089,"Rabadon's Deathcap",0);
		boot.Cz.fn=new boot.Cz(3143,"Randuin's Omen",0);
		boot.Cz.fo=new boot.Cz(3074,"Ravenous Hydra",0);
		boot.Cz.fp=new boot.Cz(1043,"Recurve Bow",0);
		boot.Cz.ga=new boot.Cz(1006,"Rejuvenation Bead",0);
		boot.Cz.gb=new boot.Cz(3027,"Rod of Ages",0);
		boot.Cz.gc=new boot.Cz(1028,"Ruby Crystal",0);
		boot.Cz.gd=new boot.Cz(2045,"Ruby Sightstone",0);
		boot.Cz.ge=new boot.Cz(3085,"Runaan's Hurricane",0);
		boot.Cz.gf=new boot.Cz(3107,"Runic Bulwark",0);
		boot.Cz.gg=new boot.Cz(3116,"Rylai's Crystal Scepter",0);
		boot.Cz.gh=new boot.Cz(1027,"Sapphire Crystal",0);
		boot.Cz.gi=new boot.Cz(3040,"Seraph's Embrace",0);
		boot.Cz.gj=new boot.Cz(3191,"Seeker's Armguard",0);
		boot.Cz.gk=new boot.Cz(3092,"Shard of True Ice",0);
		boot.Cz.gl=new boot.Cz(3057,"Sheen",0);
		boot.Cz.gm=new boot.Cz(3069,"Shurelya's Reverie",0);
		boot.Cz.gn=new boot.Cz(2044,"Sight Ward",0);
		boot.Cz.go=new boot.Cz(2049,"Sightstone",0);
		boot.Cz.gp=new boot.Cz(3020,"Sorcerer's Shoes",0);
		boot.Cz.ha=new boot.Cz(1080,"Spirit Stone",0);
		boot.Cz.hb=new boot.Cz(3207,"Spirit of the Ancient Golem",0);
		boot.Cz.hc=new boot.Cz(3209,"Spirit of the Elder Lizard",0);
		boot.Cz.hd=new boot.Cz(3206,"Spirit of the Spectral Wraith",0);
		boot.Cz.he=new boot.Cz(3065,"Spirit Visage",0);
		boot.Cz.hf=new boot.Cz(3087,"Statikk Shiv",0);
		boot.Cz.hg=new boot.Cz(3101,"Stinger",0);
		boot.Cz.hh=new boot.Cz(3068,"Sunfire Cape",0);
		boot.Cz.hi=new boot.Cz(3131,"Sword of the Divine",0);
		boot.Cz.hj=new boot.Cz(3141,"Sword of the Occult",0);
		boot.Cz.hk=new boot.Cz(3070,"Tear of the Goddess",0);
		boot.Cz.hl=new boot.Cz(3075,"Thornmail",0);
		boot.Cz.hm=new boot.Cz(3077,"Tiamat",0);
		boot.Cz.hn=new boot.Cz(3078,"Trinity Force",0);
		boot.Cz.ho=new boot.Cz(3023,"Twin Shadows",0);
		boot.Cz.hp=new boot.Cz(1053,"Vampiric Scepter",0);
		boot.Cz.ia=new boot.Cz(2043,"Vision Ward",0);
		boot.Cz.ib=new boot.Cz(3135,"Void Staff",0);
		boot.Cz.ic=new boot.Cz(3082,"Warden's Mail",0);
		boot.Cz.id=new boot.Cz(3083,"Warmog's Armor",0);
		boot.Cz.ie=new boot.Cz(3152,"Will of the Ancients",0);
		boot.Cz.ig=new boot.Cz(3091,"Wit's End",0);
		boot.Cz.ih=new boot.Cz(3154,"Wriggle's Lantern",0);
		boot.Cz.ii=new boot.Cz(3142,"Youmuu's Ghostblade",0);
		boot.Cz.ij=new boot.Cz(3086,"Zeal",0);
		boot.Cz.ik=new boot.Cz(3050,"Zeke's Herald",0);
		boot.Cz.il=new boot.Cz(3172,"Zephyr",0);
		boot.Cz.im=new boot.Cz(3157,"Zhonya's Hourglass",0);
		boot.Cz.b.HB().HC([boot.Cz.bc,boot.Cz.fc]).HD(980.0).HE(boot.BK.ea,70.0).HE(boot.BK.fj,45.0);
		boot.Cz.c.HB().HC([boot.Cz.ci,boot.Cz.fe,boot.Cz.gc]).HD(625.0).HE(boot.BK.p,250.0).HE(boot.BK.ff,20.0).HE(boot.BK.fj,20.0).HF("Insight","{1}を得る。").HG(1,boot.BK.ea,0,0,boot.Cz.ER(boot.BK.bg,0.03)).HF("Mana Charge","スキル使用時及びMana消費時に最大Manaが6だけ増加する(最大+750)。CD: 3s");
		boot.Cz.d.HB().HD(435.0).HE(boot.BK.ea,20.0);
		boot.Cz.e.HB().HC([boot.Cz.hk,boot.Cz.bc]).HD(1140.0).HE(boot.BK.ea,60.0).HE(boot.BK.bk,10.0).HE(boot.BK.bg,250.0);
		boot.Cz.f.HB().HC([boot.Cz.bm,boot.Cz.cl]).HD(900.0).HE(boot.BK.ea,60.0).HE(boot.BK.bk,15.0).HE(boot.BK.fj,40.0);
		boot.Cz.g.HB().HC([boot.Cz.k,boot.Cz.bl]).HD(780.0).HE(boot.BK.ff,45.0).HE(boot.BK.dm,15.0);
		boot.Cz.j.HB().HC([boot.Cz.de]).HD(1000.0).HE(boot.BK.ea,45.0);
		boot.Cz.i.HB().HC([boot.Cz.de]).HD(1000.0).HE(boot.BK.ed,10.0).HE(boot.BK.bk,5.0).HE(boot.BK.bg,200.0);
		boot.Cz.h.HB().HC([boot.Cz.de]).HD(1000.0).HE(boot.BK.p,220.0).HE(boot.BK.bd,6.0);
		boot.Cz.k.HB().HC([boot.Cz.bi]).HD(400.0).HE(boot.BK.dm,10.0);
		boot.Cz.l.HB().HD(1550.0).HE(boot.BK.dc,45.0);
		boot.Cz.m.HB().HC([boot.Cz.cl,boot.Cz.ci]).HD(890.0).HE(boot.BK.ea,40.0).HE(boot.BK.ed,10.0).HE(boot.BK.ff,30.0);
		boot.Cz.n.HB().HC([boot.Cz.fc,boot.Cz.bk]).HD(600.0).HE(boot.BK.p,400.0).HE(boot.BK.bg,300.0).HE(boot.BK.fj,45.0);
		boot.Cz.o.HB().HC([boot.Cz.bg,boot.Cz.ca]).HD(150.0).HE(boot.BK.di,20.0);
		boot.Cz.p.HB().HC([boot.Cz.fk,boot.Cz.hp]).HD(250.0).HE(boot.BK.dj,10.0).HE(boot.BK.dc,40.0);
		boot.Cz.bb.HB().HC([boot.Cz.p]).HD(975.0).HE(boot.BK.dj,10.0).HE(boot.BK.dc,45.0);
		boot.Cz.bc.HB().HD(860.0).HE(boot.BK.ea,40.0);
		boot.Cz.be.HB().HD(800.0).HE(boot.BK.dc,5.0);
		boot.Cz.bf.HB().HC([boot.Cz.bg]).HD(650.0);
		boot.Cz.bg.HB().HD(350.0);
		boot.Cz.bh.HB().HC([boot.Cz.bg]).HD(650.0);
		boot.Cz.bi.HB().HD(400.0).HE(boot.BK.dm,8.0);
		boot.Cz.bk.HB().HC([boot.Cz.gc,boot.Cz.gh]).HD(325.0).HE(boot.BK.p,200.0).HE(boot.BK.bg,300.0);
		boot.Cz.bl.HB().HD(720.0).HE(boot.BK.ff,40.0);
		boot.Cz.bm.HB().HC([boot.Cz.ck,boot.Cz.ck,boot.Cz.fe]).HD(120.0).HE(boot.BK.bk,7.0).HE(boot.BK.fj,25.0);
		boot.Cz.bn.HB().HD(730.0).HE(boot.BK.dm,15.0);
		boot.Cz.bo.HB().HD(300.0).HE(boot.BK.ff,15.0);
		boot.Cz.bp.HB().HD(345.0);
		boot.Cz.ca.HB().HD(400.0).HE(boot.BK.di,12.0);
		boot.Cz.cb.HB().HC([boot.Cz.cl,boot.Cz.fb]).HD(680.0).HE(boot.BK.ea,120.0).HE(boot.BK.ed,10.0);
		boot.Cz.cc.HB().HD(475.0).HE(boot.BK.dc,10.0).HE(boot.BK.p,80.0);
		boot.Cz.cd.HB().HD(475.0).HE(boot.BK.ea,15.0).HE(boot.BK.p,80.0).HE(boot.BK.bk,3.0);
		boot.Cz.ce.HB().HD(475.0).HE(boot.BK.p,100.0).HE(boot.BK.bd,8.0).HE(boot.BK.ff,5.0);
		boot.Cz.cf.HB().HC([boot.Cz.fj]).HD(400.0).HE(boot.BK.bk,15.0).HE(boot.BK.bd,10.0);
		boot.Cz.cg.HB().HD(250.0);
		boot.Cz.ch.HB().HD(250.0);
		boot.Cz.ci.HB().HC([boot.Cz.bo,boot.Cz.ga]).HD(170.0).HE(boot.BK.ff,20.0);
		boot.Cz.cj.HB().HC([boot.Cz.k,boot.Cz.ed]).HD(700.0).HE(boot.BK.dc,25.0).HE(boot.BK.dm,20.0);
		boot.Cz.ck.HB().HD(180.0).HE(boot.BK.bk,3.0);
		boot.Cz.cl.HB().HC([boot.Cz.d]).HD(385.0).HE(boot.BK.ea,30.0);
		boot.Cz.cm.HB().HC([boot.Cz.cp,boot.Cz.ic]).HD(550.0).HE(boot.BK.ed,20.0).HE(boot.BK.ff,95.0).HE(boot.BK.bg,400.0);
		boot.Cz.cn.HB().HC([boot.Cz.fh,boot.Cz.co]).HD(835.0).HE(boot.BK.dc,30.0).HE(boot.BK.p,700.0);
		boot.Cz.co.HB().HD(1000.0).HE(boot.BK.p,380.0);
		boot.Cz.cp.HB().HC([boot.Cz.gh,boot.Cz.bl]).HD(230.0).HE(boot.BK.ff,45.0).HE(boot.BK.bg,300.0);
		boot.Cz.da.HB().HC([boot.Cz.fe,boot.Cz.bl]).HD(1480.0).HE(boot.BK.ff,50.0).HE(boot.BK.fj,30.0);
		boot.Cz.db.HB().HC([boot.Cz.bc,boot.Cz.fk]).HD(865.0).HE(boot.BK.dc,30.0).HE(boot.BK.ea,40.0);
		boot.Cz.dc.HB().HC([boot.Cz.gc,boot.Cz.d]).HD(575.0).HE(boot.BK.ea,25.0).HE(boot.BK.p,200.0);
		boot.Cz.dd.HB().HD(35.0);
		boot.Cz.df.HB().HC([boot.Cz.ed,boot.Cz.fe]).HD(550.0).HE(boot.BK.dc,25.0).HE(boot.BK.fj,25.0);
		boot.Cz.dg.HB().HC([boot.Cz.p,boot.Cz.dh]).HD(275.0).HE(boot.BK.dj,10.0).HE(boot.BK.dc,45.0).HE(boot.BK.ea,65.0);
		boot.Cz.dh.HB().HC([boot.Cz.d,boot.Cz.d]).HD(330.0).HE(boot.BK.ea,40.0);
		boot.Cz.di.HB().HD(300.0);
		boot.Cz.dj.HB().HC([boot.Cz.gl,boot.Cz.cp]).HD(640.0).HE(boot.BK.ea,40.0).HE(boot.BK.ed,10.0).HE(boot.BK.ff,60.0).HE(boot.BK.bg,500.0);
		boot.Cz.dk.HB().HC([boot.Cz.l,boot.Cz.bn,boot.Cz.fk]).HD(645.0).HE(boot.BK.dc,70.0).HE(boot.BK.dm,25.0);
		boot.Cz.dl.HB().HC([boot.Cz.bg]).HD(700.0);
		boot.Cz.dm.HB().HC([boot.Cz.d]).HD(330.0).HE(boot.BK.ea,25.0);
		boot.Cz.dn.HB().HC([boot.Cz.gc]).HD(375.0).HE(boot.BK.p,200.0);
		boot.Cz.dp.HB().HC([boot.Cz.ed,boot.Cz.fk]).HD(1025.0).HE(boot.BK.dc,40.0);
		boot.Cz.ea.HB().HC([boot.Cz.dc,boot.Cz.d]).HD(980.0).HE(boot.BK.ea,50.0).HE(boot.BK.p,300.0);
		boot.Cz.eb.HB().HC([boot.Cz.gl,boot.Cz.bc]).HD(880.0).HE(boot.BK.ea,80.0).HE(boot.BK.bg,250.0).HE(boot.BK.im,5.0);
		boot.Cz.ec.HB().HC([boot.Cz.dn,boot.Cz.bo,boot.Cz.ga]).HD(670.0).HE(boot.BK.p,425.0).HE(boot.BK.ed,10.0).HE(boot.BK.ff,35.0);
		boot.Cz.ed.HB().HD(400.0).HE(boot.BK.dc,10.0);
		boot.Cz.ee.HB().HC([boot.Cz.bo,boot.Cz.di]).HD(100.0).HE(boot.BK.ff,25.0);
		boot.Cz.ef.HB().HC([boot.Cz.ca,boot.Cz.ca,boot.Cz.d]).HD(800.0).HE(boot.BK.ea,25.0).HE(boot.BK.di,45.0);
		boot.Cz.eg.HB().HC([boot.Cz.ck,boot.Cz.ck]).HD(40.0);
		boot.Cz.ei.HB().HC([boot.Cz.hk,boot.Cz.ed]).HD(1000.0).HE(boot.BK.dc,20.0).HE(boot.BK.bk,7.0).HE(boot.BK.bg,250.0);
		boot.Cz.eh.HB().HD(35.0);
		boot.Cz.ej.HB().HC([boot.Cz.df,boot.Cz.fk]).HD(975.0).HE(boot.BK.dc,55.0).HE(boot.BK.fj,36.0);
		boot.Cz.ek.HB().HC([boot.Cz.d]).HD(800.0).HE(boot.BK.ea,20.0);
		boot.Cz.el.HB().HC([boot.Cz.fl,boot.Cz.l]).HD(600.0).HE(boot.BK.dc,60.0).HE(boot.BK.fj,45.0);
		boot.Cz.em.HB().HC([boot.Cz.bg,boot.Cz.fe]).HD(450.0).HE(boot.BK.fj,25.0);
		boot.Cz.en.HB().HC([boot.Cz.gh,boot.Cz.bm]).HD(920.0).HE(boot.BK.bk,9.0).HE(boot.BK.bg,300.0).HE(boot.BK.fj,40.0);
		boot.Cz.eo.HB().HC([boot.Cz.ck,boot.Cz.cl,boot.Cz.dm]).HD(435.0).HE(boot.BK.ea,75.0).HE(boot.BK.ed,20.0).HE(boot.BK.bk,12.0);
		boot.Cz.ep.HB().HC([boot.Cz.ei]).HD(0).HE(boot.BK.dc,20.0).HE(boot.BK.bk,7.0).HE(boot.BK.bg,1000.0);
		boot.Cz.fa.HB().HC([boot.Cz.hg,boot.Cz.cl]).HD(200.0).HE(boot.BK.ea,65.0).HE(boot.BK.di,50.0);
		boot.Cz.fb.HB().HD(1600.0).HE(boot.BK.ea,80.0);
		boot.Cz.fc.HB().HD(720.0).HE(boot.BK.fj,40.0);
		boot.Cz.fd.HB().HC([boot.Cz.bg,boot.Cz.bo]).HD(350.0).HE(boot.BK.ff,25.0);
		boot.Cz.fe.HB().HD(400.0).HE(boot.BK.fj,20.0);
		boot.Cz.ff.HB().HC([boot.Cz.gc,boot.Cz.bc,boot.Cz.fj]).HD(800.0).HE(boot.BK.ea,50.0).HE(boot.BK.p,350.0).HE(boot.BK.bk,15.0).HE(boot.BK.bd,15.0);
		boot.Cz.fg.HB().HD(400.0);
		boot.Cz.fh.HB().HC([boot.Cz.gc,boot.Cz.ed]).HD(590.0).HE(boot.BK.dc,20.0).HE(boot.BK.p,200.0);
		boot.Cz.fi.HB().HC([boot.Cz.bn,boot.Cz.ij,boot.Cz.ca]).HD(495.0).HE(boot.BK.di,50.0).HE(boot.BK.im,5.0).HE(boot.BK.dm,30.0);
		boot.Cz.fj.HB().HC([boot.Cz.ck,boot.Cz.ga]).HD(340.0).HE(boot.BK.bk,9.0).HE(boot.BK.bd,7.0);
		boot.Cz.fk.HB().HD(875.0).HE(boot.BK.dc,25.0);
		boot.Cz.fl.HB().HC([boot.Cz.fc]).HD(830.0).HE(boot.BK.fj,45.0);
		boot.Cz.fm.HB().HC([boot.Cz.bc,boot.Cz.fb]).HD(840.0).HE(boot.BK.ea,120.0);
		boot.Cz.fn.HB().HC([boot.Cz.co,boot.Cz.ic]).HD(1000.0).HE(boot.BK.p,500.0).HE(boot.BK.ff,70.0);
		boot.Cz.fo.HB().HC([boot.Cz.hm,boot.Cz.hp]).HD(400.0).HE(boot.BK.dj,10.0).HE(boot.BK.dc,75.0).HE(boot.BK.bd,15.0);
		boot.Cz.fp.HB().HD(950.0).HE(boot.BK.di,30.0);
		boot.Cz.ga.HB().HD(180.0).HE(boot.BK.bd,5.0);
		boot.Cz.gb.HB().HC([boot.Cz.bk,boot.Cz.bc]).HD(740.0).HE(boot.BK.ea,60.0).HE(boot.BK.p,450.0).HE(boot.BK.bg,450.0);
		boot.Cz.gc.HB().HD(475.0).HE(boot.BK.p,180.0);
		boot.Cz.gd.HB().HC([boot.Cz.gc,boot.Cz.go]).HD(125.0).HE(boot.BK.p,360.0);
		boot.Cz.ge.HB().HC([boot.Cz.ca,boot.Cz.fp,boot.Cz.ca]).HD(1000.0).HE(boot.BK.di,70.0);
		boot.Cz.gf.HB().HC([boot.Cz.fe,boot.Cz.c]).HD(650.0).HE(boot.BK.p,400.0).HE(boot.BK.ff,20.0).HE(boot.BK.fj,30.0);
		boot.Cz.gg.HB().HC([boot.Cz.bc,boot.Cz.d,boot.Cz.co]).HD(605.0).HE(boot.BK.ea,80.0).HE(boot.BK.p,500.0);
		boot.Cz.gh.HB().HD(400.0).HE(boot.BK.bg,200.0);
		boot.Cz.gj.HB().HC([boot.Cz.d,boot.Cz.bo,boot.Cz.bo]).HD(125.0).HE(boot.BK.ea,25.0).HE(boot.BK.ff,30.0);
		boot.Cz.gi.HB().HC([boot.Cz.e]).HD(0).HE(boot.BK.ea,60.0).HE(boot.BK.bk,10.0).HE(boot.BK.bg,1000.0);
		boot.Cz.gk.HB().HC([boot.Cz.dm,boot.Cz.eg]).HD(535.0).HE(boot.BK.ea,45.0);
		boot.Cz.gl.HB().HC([boot.Cz.gh,boot.Cz.d]).HD(425.0).HE(boot.BK.ea,25.0).HE(boot.BK.bg,200.0);
		boot.Cz.gm.HB().HC([boot.Cz.dn,boot.Cz.fj]).HD(550.0).HE(boot.BK.p,250.0).HE(boot.BK.ed,10.0).HE(boot.BK.bk,10.0).HE(boot.BK.bd,10.0);
		boot.Cz.go.HB().HC([boot.Cz.gc]).HD(475.0).HE(boot.BK.p,180.0);
		boot.Cz.gn.HB().HD(75.0);
		boot.Cz.gp.HB().HC([boot.Cz.bg]).HD(750.0);
		boot.Cz.hb.HB().HC([boot.Cz.ha,boot.Cz.co]).HD(600.0).HE(boot.BK.p,500.0).HE(boot.BK.bk,7.0).HE(boot.BK.bd,14.0).HE(boot.BK.ff,30.0);
		boot.Cz.hc.HB().HC([boot.Cz.ha,boot.Cz.fk]).HD(725.0).HE(boot.BK.dc,50.0).HE(boot.BK.ed,10.0).HE(boot.BK.bk,7.0).HE(boot.BK.bd,14.0);
		boot.Cz.hd.HB().HC([boot.Cz.ha,boot.Cz.dh]).HD(100.0).HE(boot.BK.ea,50.0).HE(boot.BK.ed,10.0).HE(boot.BK.bk,10.0);
		boot.Cz.ha.HB().HC([boot.Cz.di,boot.Cz.ck,boot.Cz.ga]).HD(40.0).HE(boot.BK.bk,7.0).HE(boot.BK.bd,14.0);
		boot.Cz.he.HB().HC([boot.Cz.dn,boot.Cz.fc]).HD(630.0).HE(boot.BK.p,200.0).HE(boot.BK.ed,20.0).HE(boot.BK.fj,50.0);
		boot.Cz.hf.HB().HC([boot.Cz.ij,boot.Cz.k]).HD(525.0).HE(boot.BK.di,40.0).HE(boot.BK.im,6.0).HE(boot.BK.dm,20.0);
		boot.Cz.hg.HB().HC([boot.Cz.ca,boot.Cz.ca]).HD(450.0).HE(boot.BK.di,40.0);
		boot.Cz.hh.HB().HC([boot.Cz.bl,boot.Cz.co]).HD(930.0).HE(boot.BK.p,450.0).HE(boot.BK.ff,45.0);
		boot.Cz.hi.HB().HC([boot.Cz.fp,boot.Cz.ca]).HD(850.0).HE(boot.BK.di,45.0);
		boot.Cz.hj.HB().HC([boot.Cz.ed]).HD(800.0).HE(boot.BK.dc,10.0);
		boot.Cz.hk.HB().HC([boot.Cz.gh,boot.Cz.ck]).HD(120.0).HE(boot.BK.bk,7.0).HE(boot.BK.bg,250.0);
		boot.Cz.ba.HB().HC([boot.Cz.bj,boot.Cz.gc]).HD(1188.0).HE(boot.BK.dc,50.0).HE(boot.BK.p,200.0).HE(boot.BK.ed,10.0);
		boot.Cz.bd.HB().HC([boot.Cz.l,boot.Cz.hp]).HD(850.0).HE(boot.BK.dj,12.0).HE(boot.BK.dc,70.0);
		boot.Cz.bj.HB().HC([boot.Cz.ed,boot.Cz.ed]).HD(537.0).HE(boot.BK.dc,25.0);
		boot.Cz.de.HB().HD(0);
		boot.Cz.hl.HB().HC([boot.Cz.bl,boot.Cz.bo]).HD(1180.0).HE(boot.BK.ff,100.0);
		boot.Cz.hm.HB().HC([boot.Cz.fk,boot.Cz.ed,boot.Cz.ga,boot.Cz.ga]).HD(665.0).HE(boot.BK.dc,50.0).HE(boot.BK.bd,15.0);
		boot.Cz.hn.HB().HC([boot.Cz.ij,boot.Cz.gl,boot.Cz.fh]).HD(3.0).HE(boot.BK.dc,30.0).HE(boot.BK.ea,30.0).HE(boot.BK.p,250.0).HE(boot.BK.di,30.0).HE(boot.BK.bg,200.0).HE(boot.BK.im,8.0).HE(boot.BK.dm,10.0);
		boot.Cz.ho.HB().HC([boot.Cz.dm,boot.Cz.fe]).HD(735.0).HE(boot.BK.ea,40.0).HE(boot.BK.im,6.0);
		boot.Cz.hp.HB().HC([boot.Cz.ed]).HD(400.0).HE(boot.BK.dj,10.0).HE(boot.BK.dc,10.0);
		boot.Cz.ia.HB().HD(125.0);
		boot.Cz.ib.HB().HC([boot.Cz.bc,boot.Cz.d]).HD(1000.0).HE(boot.BK.ea,70.0);
		boot.Cz.ic.HB().HC([boot.Cz.bo,boot.Cz.bo]).HD(500.0).HE(boot.BK.ff,50.0);
		boot.Cz.id.HB().HC([boot.Cz.co,boot.Cz.gc,boot.Cz.ga,boot.Cz.ga]).HD(995.0).HE(boot.BK.p,1000.0);
		boot.Cz.ie.HB().HC([boot.Cz.dm,boot.Cz.dh]).HD(585.0).HE(boot.BK.ea,50.0);
		boot.Cz.ig.HB().HC([boot.Cz.fp,boot.Cz.fe]).HD(850.0).HE(boot.BK.di,40.0).HE(boot.BK.fj,25.0);
		boot.Cz.ih.HB().HC([boot.Cz.hp,boot.Cz.ee]).HD(100.0).HE(boot.BK.dj,10.0).HE(boot.BK.dc,15.0).HE(boot.BK.ff,30.0);
		boot.Cz.ii.HB().HC([boot.Cz.k,boot.Cz.bj]).HD(563.0).HE(boot.BK.dc,30.0).HE(boot.BK.ed,10.0).HE(boot.BK.dm,15.0);
		boot.Cz.ij.HB().HC([boot.Cz.bi,boot.Cz.ca]).HD(375.0).HE(boot.BK.di,18.0).HE(boot.BK.im,5.0).HE(boot.BK.dm,10.0);
		boot.Cz.ik.HB().HC([boot.Cz.hp,boot.Cz.dn]).HD(900.0).HE(boot.BK.p,250.0).HE(boot.BK.ed,20.0);
		boot.Cz.il.HB().HC([boot.Cz.hg,boot.Cz.ed]).HD(1200.0).HE(boot.BK.dc,20.0).HE(boot.BK.ed,10.0).HE(boot.BK.di,50.0).HE(boot.BK.im,10.0);
		boot.Cz.im.HB().HC([boot.Cz.fb,boot.Cz.gj]).HD(650.0).HE(boot.BK.ea,120.0).HE(boot.BK.ff,50.0);
	},
	// teemowork.model.Item#<init>(int, java.lang.String)
	$0:function(A,B){
		this.io=new Array(boot.BR.Du().length);
		this.ip=A;
		this.ja=B;
		boot.Cz.a.BV(this);
	},
	// teemowork.model.Item#getIcon()
	CM:function(){
		return "src/main/resources/teemowork/item/"+this.ip+".png";
	},
	// teemowork.model.Item#getStatus(teemowork.model.Version)
	GX:function(A,B,C){
		B=A.CB();
		l2:for (;
		B>=0;
		--B) {
			C=this.io[B];
			if(C==null){
			}else{
				return C;
			}
		}return null;
	},
	// teemowork.model.Item#getTotalCost(teemowork.model.Version)
	HH:function(A,B,C,E,F,G,H){
		B=this.GX(A);
		C=B.CN(boot.BK.jf);
		H=B.c;G=H.length;F=0;
		l3:for (;
		F<G;
		++F) {
			E=H[F];
			C=(C+E.HH(A));
		}return C;
	},
	// teemowork.model.Item#update()
	HB:function(A){
		A=new boot.DB(this.GX(boot.BR.c),0);
		this.io[boot.BR.c.CB()]=A;
		return A;
	},
	// teemowork.model.Item#update(teemowork.model.Version)
	HI:function(A,B){
		B=new boot.DB(this.GX(A),0);
		this.io[A.CB()]=B;
		return B;
	},
	// teemowork.model.Item#getAll()
	_CK:function(){
		return boot.Cz.a;
	},
	// teemowork.model.Item#getByName(java.lang.String)
	_HJ:function(A,B,C){
		C=boot.Cz.a.BG();
		l1:while (C.BI()!=0) {
			B=C.BH();
			if(!(B.ja.equals(A)==0)){
				return B;
			}continue l1;
		}return null;
	},
	// teemowork.model.Item#ad(double)
	_EP:function(A){
		return boot.Cz.ER(boot.BK.dc,A);
	},
	// teemowork.model.Item#bounusAD(double)
	_EL:function(A){
		return boot.Cz.ER(boot.BK.df,A);
	},
	// teemowork.model.Item#ap(double)
	_EE:function(A){
		return boot.Cz.ER(boot.BK.ea,A);
	},
	// teemowork.model.Item#amplify(teemowork.model.Status, double)
	_ER:function(A,B){
		return boot.Cz.EY(A,B,0);
	},
	// teemowork.model.Item#amplify(teemowork.model.Status, double, double)
	_EY:function(A,B,D){
		return boot.Cz.EZ(A,new boot.CK(B,D,1,0));
	},
	// teemowork.model.Item#amplify(teemowork.model.Status, teemowork.model.variable.VariableResolver)
	_EZ:function(A,B){
		return new boot.CP(A,B,0);
	},
	// teemowork.model.Item#amplify(teemowork.model.Status, double, double, teemowork.model.variable.Variable)
	_EM:function(A,B,D,F,G){
		G=boot.Cz.EY(A,B,D);
		G.Fx().BV(F);
		return G;
	}
});

boot.define("DA","",[],{
	// teemowork.model.Build$Computed#<init>(teemowork.model.Build, double, double, teemowork.model.Status)
	$1:function(A,B,D,F){
		this.d=A;;
		this.a=F.Cx(B);
		this.b=F.Cx(D);
		this.c=F.Cx((D-B));
		boot.CW.Gy(A).DH(F.CB(),this);
	},
	// teemowork.model.Build$Computed#value()
	HQ:function(){
		return ""+this.b;
	},
	// teemowork.model.Build$Computed#base()
	HR:function(){
		return ""+this.a;
	},
	// teemowork.model.Build$Computed#increased()
	HS:function(){
		return ""+this.c;
	},
	// teemowork.model.Build$Computed#toString()
	toString:function(){
		return this.HQ();
	},
	// teemowork.model.Build$Computed#<init>(teemowork.model.Build, double, double, teemowork.model.Status, teemowork.model.Build$Computed)
	$0:function(A,B,D,F,G){
		boot.DA.prototype.$1.call(this,A,B,D,F);
	}
});

boot.define("DC","",[],{
	// teemowork.model.DependencyManager#<clinit>()
	_:function(){
		boot.DC.a=new boot.R(0);
	},
	// teemowork.model.DependencyManager#<init>()
	$0:function(){
	},
	// teemowork.model.DependencyManager#use(teemowork.model.Skill)
	_Gu:function(A){
		if(!((boot.DC.a.BV(A)!=0||(A!=boot.Bv.cac&&A!=boot.Bv.cch)))){
			return true;
		}return false;
	},
	// teemowork.model.DependencyManager#unuse(teemowork.model.Skill)
	_Gv:function(A){
		boot.DC.a.BW(A);
	}
});

boot.define("CW","CX",["CR"],{
	d:0,
	// teemowork.model.Build#<init>(teemowork.model.Champion)
	$0:function(A,B){
		boot.CX.prototype.$0.call(this);
		this.c=boot.BR.m;
		this.d=1;
		this.e=new Array(6);
		this.f=[1,1,1,1,1,1];
		this.g=Array.create(18);
		this.h=Array.create(5);
		this.i=Array.create(5);
		this.k=new boot.BL(0);
		this.l=new boot.BL(0);
		this.m=new boot.BL(0);
		this.n=new boot.BL(0);
		this.o=new boot.BL(boot.BK.DD().length,1);
		this.b=A;
		B=0;
		l16:for (;
		B<5;
		++B) {
			this.h[B]=A.hg[B].Ez();
		}this.e[0]=boot.Cz.dp;
		this.e[2]=boot.Cz.cb;
	},
	// teemowork.model.Build#getLevel()
	GH:function(){
		return this.d;
	},
	// teemowork.model.Build#setLevel(int)
	GL:function(A){
		if(!((A<=0||A>=19))){
			this.d=A;
			this.GM();
		}
	},
	// teemowork.model.Build#getVersion()
	GN:function(){
		return this.c;
	},
	// teemowork.model.Build#setVersion(teemowork.model.Version)
	GO:function(A){
		if(!(A==null)){
			this.c=A;
			this.GM();
		}
	},
	// teemowork.model.Build#get(teemowork.model.Status)
	GP:function(A,B,D,F,H,J,L){
		switch(A.CB()+1){
			case 7:
			case 28:
			case 31:
			case 36:
			case 37:
			case 38:
			case 39:
			case 40:
			case 41:
			case 43:
			case 44:
			case 149:
			case 151:
			case 157:
			case 160:
			return new boot.DA(this,0,0,A,null,0);
			case 9:
			case 107:
			return new boot.DA(this,this.GQ(A),this.GR(A),A,null,0);
			case 17:
			return new boot.DA(this,0,this.GP(boot.BK.p).c,A,null,0);
			case 52:
			return new boot.DA(this,0,this.GP(boot.BK.dc).c,A,null,0);
			case 53:
			F=this.b.CL(this.c).CN(boot.BK.dg);
			H=this.b.CL(this.c).CN(boot.BK.dh)*(this.d-1);
			return new boot.DA(this,F*(1+H/100.0),Math.min(2.5,F*(1+(H+this.GR(boot.BK.di))/100.0)),A,null,0);
			case 86:
			return new boot.DA(this,0,this.GP(boot.BK.ff).c,A,null,0);
			case 90:
			return new boot.DA(this,0,this.GP(boot.BK.fj).c,A,null,0);
			case 106:
			return new boot.DA(this,this.d,this.d,boot.BK.gm,null,0);
			case 135:
			B=this.GQ(A);
			D=((B+this.GR(A))+this.GR(boot.BK.il)*this.d)*(1+this.GR(boot.BK.im)/100.0);
			if(490.0>=D){
				if(415.0>=D){
					if(!(D>=220.0)){
						D=(D*0.5+110.0);
					}
				}else{
					D=(D*0.8+83.0);
				}
			}else{
				D=(D*0.5+230.0);
			}return new boot.DA(this,B,D,A,null,0);
			case 138:
			return new boot.DA(this,0,this.GP(boot.BK.ik).c,A,null,0);
			default:
			J=this.GQ(A);
			L=((J+this.GR(A))+this.GR(A.Cu())*this.d)*(1+this.GR(A.Cw())/100.0);
			return new boot.DA(this,J,L,A,null,0);
		}
	},
	// teemowork.model.Build#calculate(teemowork.model.Status)
	Fw:function(A){
		return this.GP(A).b;
	},
	// teemowork.model.Build#setItem(int, teemowork.model.Item)
	GS:function(A,B){
		if(!((A<0||A>5))){
			this.e[A]=B;
			this.f[A]=1;
			this.GM();
		}
	},
	// teemowork.model.Build#getLevel(teemowork.model.Skill)
	GT:function(A){
		return this.h[A.ceb.CB()];
	},
	// teemowork.model.Build#up(teemowork.model.Skill)
	GU:function(A,B,C){
		B=A.ceb.CB();
		C=this.h[B];
		if(!(C>=A.FA())){
			this.h[B]=(C+1);
			this.GM();
		}
	},
	// teemowork.model.Build#down(teemowork.model.Skill)
	GV:function(A,B,C){
		B=A.ceb.CB();
		C=this.h[B];
		if(!(A.Ez()>=C)){
			this.h[B]=(C-1);
			this.GM();
		}
	},
	// teemowork.model.Build#base(teemowork.model.Status)
	GQ:function(A,B){
		switch(A.CB()+1){
			case 9:
			case 28:
			case 31:
			case 137:
			return this.b.CL(this.c).CN(A);
			default:
			B=(this.b.CL(this.c).CN(A)+this.b.CL(this.c).CN(A.Cu())*this.d);
			if(!(this.b!=boot.BP.bd)){
				B=(B+this.GW(A,boot.Bv.fn));
			}if(!(this.b!=boot.BP.dp)){
				B=(B+this.GW(A,boot.Bv.bdi));
			}if(!(this.b!=boot.BP.ce)){
				B=(B+this.GW(A,boot.Bv.lk));
			}return B;
		}
	},
	// teemowork.model.Build#sum(teemowork.model.Status)
	GR:function(A,B,D,E,F,G){
		B=0;
		D=new boot.R(0);
		E=0;
		l4:while (E<6) {
			F=this.e[E];
			if(!(F==null)){
				G=F.GX(this.c);
				B=A.Cz(B,G.CN(A));
			}++E;
			continue l4;
		}E=0;
		l12:while (E<this.b.hg.length) {
			F=this.b.hg[E];
			G=F.FB(this.c);
			B=(B+this.GY(G.FF(),F,A));
			if(!(this.i[E]==0)){
				B=(B+this.GY(G.FG(),F,A));
			}++E;
			continue l12;
		}return B;
	},
	// teemowork.model.Build#sum(java.util.List, teemowork.model.Skill, teemowork.model.Status)
	GY:function(A,B,C,D,F,G,H,I,J,K){
		D=0;
		G=A.BG();
		l2:while (G.BI()!=0) {
			F=G.BH();
			if(!(F instanceof boot.CP==0)){
				H=F;
				I=H.FW();
				if(!((I!=C||H.Fu()!=0))){
					J=H.FY();
					K=(J.FU()!=0?this.GT(B):J.FV(this.d));
					if(!(K==0)){
						D=I.Cz(D,this.GZ(B,H,K));
						continue l2;
					}continue l2;
				}continue l2;
			}continue l2;
		}return D;
	},
	// teemowork.model.Build#calculateVariable(teemowork.model.Skill, teemowork.model.variable.Variable, int)
	GZ:function(A,B,C,D){
		if(boot.DC.Gu(A)==0){
			D=B.Fv(C,this);
			boot.DC.Gv(A);
			return D;
		}else{
			return 0;
		}
	},
	// teemowork.model.Build#computeVariable(teemowork.model.Status, teemowork.model.Skill)
	GW:function(A,B,C,E,F,G,H,I){
		C=0;
		E=this.h[B.ceb.CB()];
		if(!(E<=0)){
			F=B.FB(this.c);
			H=F.FG().BG();
			l6:while (H.BI()!=0) {
				G=H.BH();
				if(!(G instanceof boot.CP==0)){
					I=G;
					if(!(I.FW()!=A)){
						C=(C+this.GZ(B,I,this.h[B.ceb.CB()]));
						continue l6;
					}continue l6;
				}continue l6;
			}
		}return C;
	},
	// teemowork.model.Build#active(teemowork.model.SkillKey)
	Gw:function(A,B){
		B=A.CB();
		this.i[B]=this.i[B]==0;
		if(!((this.i[B]==0||this.h[B]!=0))){
			this.h[B]=1;
		}if(!(A!=boot.Bw.g)){
			if(this.b!=boot.BP.dn){
				if(!(this.b!=boot.BP.dp)){
					this.b=boot.BP.dn;
				}
			}else{
				this.b=boot.BP.dp;
			}if(this.b!=boot.BP.bc){
				if(!(this.b!=boot.BP.bd)){
					this.b=boot.BP.bc;
				}
			}else{
				this.b=boot.BP.bd;
			}if(this.b!=boot.BP.ce){
				if(!(this.b!=boot.BP.cf)){
					this.b=boot.BP.ce;
				}
			}else{
				this.b=boot.BP.cf;
			}
		}this.GM();
	},
	// teemowork.model.Build#isActive(teemowork.model.Skill)
	Gx:function(A){
		return this.i[A.ceb.CB()];
	},
	// teemowork.model.Build#access$0(teemowork.model.Build)
	_Gy:function(A){
		return A.o;
	}
});

boot.define("CY","",["O"],{
},{
	$:[{
		U: function() {
			return boot.DE.$;
		},
		HT: function() {
			return [METHOD];
		}
	},{
		U: function() {
			return boot.DF.$;
		},
		HU: function() {
			return RUNTIME;
		}
	}]
});

boot.defineNative("Event",{
	// js.util.jQuery$Event#<init>()
	$0:function(){
	}
});
boot.define("CZ","",[],{
	// teemowork.ChampionDetail$1#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$1#handler(js.util.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.CV.GK(this.a).GL((boot.CV.GK(this.a).GH()+1));
	}
});

boot.define("Cu","",[],{
	// teemowork.ChampionDetail$2#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$2#handler(js.util.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.CV.GK(this.a).GL((boot.CV.GK(this.a).GH()-1));
	}
});

boot.define("Cv","",[],{
	// teemowork.ChampionDetail$StatusView#<init>(teemowork.ChampionDetail, teemowork.model.Status, js.util.jQuery)
	$1:function(A,B,C,D){
		this.c=A;;
		D=C.CJ("p");
		D.CJ("q").text(B.S());
		this.a=B;
		this.b=D.CJ("r");
	},
	// teemowork.ChampionDetail$StatusView#calcurate()
	GG:function(A){
		A=boot.CV.GK(this.c).GP(this.a);
		this.b.text(""+A.HQ()+this.a.DA());
		if(!(this.a!=boot.BK.ej)){
			this.b.append(" | ").append(""+boot.CV.GK(this.c).GP(boot.BK.el).HQ()+boot.BK.el.DA());
		}if(!(this.a!=boot.BK.ep)){
			this.b.append(" | ").append(""+boot.CV.GK(this.c).GP(boot.BK.fb).HQ()+boot.BK.fb.DA());
		}
	},
	// teemowork.ChampionDetail$StatusView#<init>(teemowork.ChampionDetail, teemowork.model.Status, js.util.jQuery, teemowork.ChampionDetail$StatusView)
	$0:function(A,B,C,D){
		boot.Cv.prototype.$1.call(this,A,B,C);
	},
	// teemowork.ChampionDetail$StatusView#access$1(teemowork.ChampionDetail$StatusView)
	_GJ:function(A){
		A.GG();
	}
});

boot.define("Cw","",[],{
	// teemowork.ChampionDetail$3#<init>(teemowork.ChampionDetail)
	$0:function(A){
		this.a=A;
	},
	// teemowork.ChampionDetail$3#handler(js.util.jQuery$Event)
	handler:function(A){
		switch(A.which){
			case 101:
			boot.CV.GK(this.a).Gw(boot.Bw.f);
			break;
			case 113:
			boot.CV.GK(this.a).Gw(boot.Bw.d);
			break;
			case 114:
			boot.CV.GK(this.a).Gw(boot.Bw.g);
			break;
			case 119:
			boot.CV.GK(this.a).Gw(boot.Bw.e);
			break;
		}
	}
});

boot.define("DH","",[],{
	// teemowork.ChampionDetail$SkillView$1#<init>(teemowork.ChampionDetail$SkillView, teemowork.model.Skill)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// teemowork.ChampionDetail$SkillView$1#handler(js.util.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.CV.GK(boot.Cx.HY(this.a)).GU(this.b);
	}
});

boot.define("DI","",[],{
	// teemowork.ChampionDetail$SkillView$2#<init>(teemowork.ChampionDetail$SkillView, teemowork.model.Skill)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// teemowork.ChampionDetail$SkillView$2#handler(js.util.jQuery$Event)
	handler:function(A){
		A.preventDefault();
		boot.CV.GK(boot.Cx.HY(this.a)).GV(this.b);
	}
});

boot.define("Cx","",[],{
	// teemowork.ChampionDetail$SkillView#<init>(teemowork.ChampionDetail, teemowork.model.Skill, js.util.jQuery)
	$1:function(A,B,C,D,E,F,G){
		this.i=A;;
		D=B.FA();
		this.a=B;
		this.c=new Array(D);
		E=C.CJ("s");
		this.b=E.CJ("t").css("background-image","url("+B.CM()+")");
		E.click(new boot.DH(this,B,0)).on("contextmenu",new boot.DI(this,B,0));
		if(!(B.ceb==boot.Bw.c)){
			F=E.CJ("u");
			G=0;
			l13:for (;
			G<D;
			++G) {
				this.c[G]=F.CJ((D==3?"v":"v"));
			}
		}F=C.CJ("w");
		F.CJ("x").text(B.cdp);
		this.h=F.CJ("y");
		this.f=F.CJ("y");
		this.g=F.CJ("y");
		this.d=F.CJ("z");
		this.e=F.CJ("z");
	},
	// teemowork.ChampionDetail$SkillView#update()
	CO:function(A,B,C,D,E){
		A=this.a.FB(boot.CV.GK(this.i).GN());
		B=boot.CV.GK(this.i).GT(this.a);
		C=0;
		l4:while (C<this.c.length) {
			if(C>=B){
				this.c[C].removeClass("A");
			}else{
				this.c[C].addClass("A");
			}++C;
			continue l4;
		}if(boot.CV.GK(this.i).Gx(this.a)==0){
			this.b.removeClass("B");
		}else{
			this.b.addClass("B");
		}this.HV(this.f,A,A.FM());
		this.HV(this.g,A,A.FL());
		this.HV(this.h,A,A.FN());
		boot.DC.Gu(this.a);
		this.d.empty();
		if(!(A.FF().BB()!=0)){
			this.d.CJ("C").text("PASSIVE");
			D=A.FF().BG();
			l23:while (D.BI()!=0) {
				C=D.BH();
				if(C instanceof boot.CP==0){
					this.d.append(C.toString());
					continue l23;
				}else{
					this.HW(this.d,C,B);
					continue l23;
				}
			}
		}this.e.empty();
		C=A.FO();
		if(!((C==boot.CC.c||C==boot.CC.f))){
			this.e.CJ("C").text(A.FO().S().toUpperCase());
		}E=A.FG().BG();
		l33:while (E.BI()!=0) {
			D=E.BH();
			if(D instanceof boot.CP==0){
				this.e.append(D.toString());
				continue l33;
			}else{
				this.HW(this.e,D,B);
				continue l33;
			}
		}if(!(C!=boot.CC.f)){
			this.e.append("このスキルはOn-Hit Effectの影響を受ける。");
		}boot.DC.Gv(this.a);
	},
	// teemowork.ChampionDetail$SkillView#write(js.util.jQuery, teemowork.model.SkillStatus, teemowork.model.variable.Variable)
	HV:function(A,B,C,D,E,F,G,H,I,J,L){
		A.empty();
		if(!(C==null)){
			D=C.FW();
			E=C.FY();
			F=boot.CV.GK(this.i).GT(this.a);
			if(!(E.FU()!=0)){
				F=E.FV(boot.CV.GK(this.i).GH());
			}G=D.kf;
			if(!((D==boot.BK.gj||(D==boot.BK.hb||B.FO()!=boot.CC.d)))){
				G="毎秒"+G;
			}A.CJ("D").text(G);
			H=E.FT();
			I=1;
			l15:while (I<=H) {
				J=D.Cx(C.Fv(I,boot.CV.GK(this.i)));
				L=A.CJ("E").text((J==-1.0?"∞":J));
				if(!((H==1||I!=F))){
					L.addClass("F");
				}if(!(I==H)){
					A.CJ("G").text("/");
				}++I;
				continue l15;
			}this.HX(A,C.Fx(),0);
			A.append(D.DA());
		}
	},
	// teemowork.ChampionDetail$SkillView#writeVariable(js.util.jQuery, teemowork.model.variable.Variable, int)
	HW:function(A,B,C,D,E,F,G,H,I){
		D=B.FY();
		E=B.FW();
		F=B.Fx();
		if(!(D.FU()!=0)){
			C=D.FV(boot.CV.GK(this.i).GH());
		}A.CJ("H").text(E.DB(B.Fv(Math.max(1,C),boot.CV.GK(this.i))));
		G=D.FT();
		if((1<G||F.BB()==0)){
			A.append("(");
			H=1;
			l12:while (H<=G) {
				I=A.CJ("I").text(boot.BX.Cy(D.FS(H),2));
				if(!(H!=C)){
					I.addClass("F");
				}if(!(H==G)){
					A.CJ("G").text("/");
				}++H;
				continue l12;
			}this.HX(A,F,C);
			A.append(")");
		}
	},
	// teemowork.ChampionDetail$SkillView#writeAmplifier(js.util.jQuery, java.util.List, int)
	HX:function(A,B,C,D,E,F,G,H,I,J){
		E=B.BG();
		l1:while (E.BI()!=0) {
			D=E.BH();
			F=A.CJ("J");
			F.append("+");
			G=D.FY();
			if(!(G.FU()!=0)){
				C=G.FV(boot.CV.GK(this.i).GH());
			}H=G.FT();
			I=1;
			l11:while (I<=H) {
				J=F.CJ("I").text(boot.BX.Cy(D.Fv(I,boot.CV.GK(this.i)),4));
				if(!((H==1||I!=C))){
					J.addClass("F");
				}if(!(I==H)){
					F.CJ("G").text("/");
				}++I;
				continue l11;
			}F.append(D.FW().DA());
			if(!(D.Fx().BB()!=0)){
				F.append("(");
				this.HX(F,D.Fx(),C);
				F.append(")");
			}F.append(D.FW().kf);
			continue l1;
		}
	},
	// teemowork.ChampionDetail$SkillView#<init>(teemowork.ChampionDetail, teemowork.model.Skill, js.util.jQuery, teemowork.ChampionDetail$SkillView)
	$0:function(A,B,C,D){
		boot.Cx.prototype.$1.call(this,A,B,C);
	},
	// teemowork.ChampionDetail$SkillView#access$1(teemowork.ChampionDetail$SkillView)
	_GI:function(A){
		A.CO();
	},
	// teemowork.ChampionDetail$SkillView#access$2(teemowork.ChampionDetail$SkillView)
	_HY:function(A){
		return A.i;
	}
});

boot.define("CV","BJ",[],{
	// teemowork.ChampionDetail#<clinit>()
	_:function(){
		boot.CV.a=[boot.BK.p,boot.BK.bd,boot.BK.bg,boot.BK.bk,boot.BK.dc,boot.BK.ej,boot.BK.dg,boot.BK.dj,boot.BK.dm,boot.BK.ea,boot.BK.ep,boot.BK.ed,boot.BK.eg,boot.BK.ff,boot.BK.fj,boot.BK.ik,boot.BK.gj,boot.BK.gn];
	},
	// teemowork.ChampionDetail#<init>(java.lang.String)
	$0:function(A){
		boot.CV.prototype.$1.call(this,boot.BP.Dx(A));
	},
	// teemowork.ChampionDetail#<init>(teemowork.model.Champion)
	$1:function(A){
		boot.BJ.prototype.$0.call(this);
		this.b=new boot.BL(0);
		this.c=new boot.BL(0);
		if(A!=null){
			this.d=new boot.CW(A,0);
			this.GE(this.d);
			return;
		}else{
			throw new boot.K(1);
		}
	},
	// teemowork.ChampionDetail#bind(js.bind.Notifiable)
	GE:function(A,B,C,D,E){
		if(!(A==null)){
			E=this.getClass().E();D=E.length;C=0;
			l3:while (C<D) {
				B=E[C];
				if(!(B.W(boot.CY.$)==0)){
					A.GF(this,B);
				}++C;
				continue l3;
			}
		}
	},
	// teemowork.ChampionDetail#load(js.util.jQuery)
	CI:function(A,B,C,D,E,F,G){
		B=A.CJ("k").css("background-image","url("+this.d.b.CM()+")").click(new boot.CZ(this,0)).on("contextmenu",new boot.Cu(this,0));
		this.e=B.CJ("l");
		C=A.CJ("m");
		G=boot.CV.a;F=G.length;E=0;
		l8:for (;
		E<F;
		++E) {
			D=G[E];
			this.b.BV(new boot.Cv(this,D,C,null,0));
		}this.f=A.CJ("n");
		$(window).keypress(new boot.Cw(this,0));
		this.GG();
	},
	// teemowork.ChampionDetail#calcurate()
	GG:function(A,B,C,D){
		this.e.text(""+this.d.GH());
		this.f.empty();
		D=this.d.b.hg;C=D.length;B=0;
		l3:for (;
		B<C;
		++B) {
			A=D[B];
			boot.Cx.GI(new boot.Cx(this,A,this.f.CJ("o"),null,0));
		}B=this.b.BG();
		l8:for (;
		B.BI()!=0;
		boot.Cv.GJ(A)) {
			A=B.BH();
		}
	},
	// teemowork.ChampionDetail#getPageId()
	CX:function(){
		return "Champion/"+this.d.b.hf;
	},
	// teemowork.ChampionDetail#access$0(teemowork.ChampionDetail)
	_GK:function(A){
		return A.d;
	}
},{
	$0:[{
		U: function() {
			return boot.BW.$;
		},
		CZ: function() {
			return "Champion/*";
		}
	}],d:[{
		U: function() {
			return boot.Cy.$;
		}
	}],GG:[{
		U: function() {
			return boot.CY.$;
		}
	}]
});

boot.define("DM","",[],{
	// js.ui.UI#<init>()
	$0:function(){
		boot.DM.prototype.$1.call(this,"div");
	},
	// js.ui.UI#<init>(java.lang.String)
	$1:function(A){
		this.a=$("<"+A+">");
	}
});

boot.define("DN","",[],{
	// js.ui.ImageGrid$1#<init>(js.ui.ImageGrid, js.util.jQuery)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$1#handler(js.util.jQuery$Event)
	handler:function(A,B,C,D){
		B=this.b.val().toLowerCase().replace(/\s/g,"");
		D=boot.DL.IC(this.a).BP().BG();
		l2:while (D.BI()!=0) {
			C=D.BH();
			if(this.a.Hz(C.BQ()).toLowerCase().indexOf(B) != -1==0){
				C.BL().addClass("N");
				continue l2;
			}else{
				C.BL().removeClass("N");
				continue l2;
			}
		}
	}
});

boot.define("DO","",[],{
	// js.ui.ImageGrid$2#<init>(js.ui.ImageGrid, java.lang.Object)
	$0:function(A,B){
		this.a=A;this.b=B;
	},
	// js.ui.ImageGrid$2#handler(js.util.jQuery$Event)
	handler:function(A){
		this.a.IB(this.b);
	}
});

boot.define("DL","DM",[],{
	// js.ui.ImageGrid#<init>()
	$0:function(){
		boot.DM.prototype.$0.call(this);
		this.b=new boot.L(0);
		this.c=this.Hu();
	},
	// js.ui.ImageGrid#compose(js.util.jQuery)
	HZ:function(A,B,C,D,E){
		this.a.css("line-height","0").css("width","700px").css("margin","0 auto");
		B=$("<input type='text'>");
		B.appendTo(this.a);
		B.addClass("K").css("display","block");
		B.keyup(new boot.DN(this,B,0));
		D=this.c.BG();
		l6:for (;
		D.BI()!=0;
		this.b.T(C,E)) {
			C=D.BH();
			E=this.a.CJ("L").css("background-image","url("+this.IA(C)+")");
			E.Fz("span").addClass("M").text(this.Hz(C));
			E.click(new boot.DO(this,C,0));
		}A.append(this.a);
	},
	// js.ui.ImageGrid#access$0(js.ui.ImageGrid)
	_IC:function(A){
		return A.b;
	}
});

boot.define("DS","",[],{
	port:0,
	// js.dom.Location#<init>()
	$0:function(){
	}
});

boot.define("BW","",["O"],{
	CZ:null
},{
	$:[{
		U: function() {
			return boot.DT.$;
		}
	},{
		U: function() {
			return boot.DE.$;
		},
		HT: function() {
			return [CONSTRUCTOR,TYPE];
		}
	},{
		U: function() {
			return boot.DF.$;
		},
		HU: function() {
			return RUNTIME;
		}
	}]
});

boot.define("DR","",[],{
	// js.application.Application$Route#<init>(java.lang.reflect.Constructor, js.application.PageInfo)
	$1:function(A,B){
		this.b=A;
		this.a=new RegExp(B.CZ().replace(/\*/g,"([^/].+)"),"");
	},
	// js.application.Application$Route#match(java.lang.String)
	IL:function(A,B,C,D){
		B=this.a.exec(A);
		if(B!=null!=0){
			C=new boot.BL(0);
			D=0;
			l9:for (;
			D<B.length-1;
			++D) {
				C.BV(B[(D+1)]);
			}try{
				return this.b.P(C.BY());
			} catch ($) {
				if ($ instanceof boot.I) {
					return null;
				}
			}
		}else{
			return null;
		}
	},
	// js.application.Application$Route#access$0(js.application.Application$Route, java.lang.String)
	_IK:function(A,B){
		return A.IL(B);
	},
	// js.application.Application$Route#<init>(java.lang.reflect.Constructor, js.application.PageInfo, js.application.Application$Route)
	$0:function(A,B,C){
		boot.DR.prototype.$1.call(this,A,B);
	}
});

boot.define("DP","",[],{
	// js.application.Application$Router#<init>()
	$1:function(){
		this.a=new boot.L(0);
		this.b=new boot.BL(0);
	},
	// js.application.Application$Router#handler(js.util.jQuery$Event)
	handler:function(A){
		this.II(location.hash);
	},
	// js.application.Application$Router#dispatch(java.lang.String)
	II:function(A,B,C,D,E){
		if(!((A.length==0||A.startsWith("#")==0))){
			A=A.substring(1);
		}B=this.a.BJ(A);
		if(B==null){
			D=this.b.BG();
			l10:while (D.BI()!=0) {
				C=D.BH();
				E=boot.DR.IK(C,A);
				if(!(E==null)){
					this.IJ(E);
					return;
				}continue l10;
			}
		}else{
			try{
				this.IJ(B.P(new Array(0)));
			} catch ($) {
				if ($ instanceof boot.I) {
				}
			}
		}
	},
	// js.application.Application$Router#dispatch(js.application.Page)
	IJ:function(A,B){
		B=$(document.createDocumentFragment());
		A.CI(B);
		$("#Content").empty().append(B);
	},
	// js.application.Application$Router#<init>(js.application.Application$Router)
	$0:function(A){
		boot.DP.prototype.$1.call(this);
	},
	// js.application.Application$Router#access$1(js.application.Application$Router)
	_IE:function(A){
		return A.b;
	},
	// js.application.Application$Router#access$2(js.application.Application$Router)
	_IF:function(A){
		return A.a;
	},
	// js.application.Application$Router#access$3(js.application.Application$Router, java.lang.String)
	_IG:function(A,B){
		A.II(B);
	}
});

boot.define("DV","",[],{
});

boot.define("DW","",[],{
	IO:null
});

boot.define("DU","",["DV"],{
	// js.lang.Classes$1#<init>(java.lang.reflect.InvocationHandler, js.lang.NativeObject, java.lang.reflect.Method)
	$0:function(A,B,C){
		this.a=A;this.b=B;this.c=C;
	},
	// js.lang.Classes$1#evaluate()
	IN:function(){
		return this.a.IO(this.b,this.c,new Array(0));
	}
});

boot.define("DQ","",[],{
	// js.lang.Classes#<init>()
	$0:function(){
	},
	// js.lang.Classes#find(java.lang.Class)
	_ID:function(A,B,C,D,E,F,G){
		B=new boot.BL(0);
		F=Object.keys(boot);E=F.length;D=0;
		l2:while (D<E) {
			C=F[D];
			G=boot[C]["$"];
			if(!((A==G||A.H(G)==0))){
				B.BV(G);
			}++D;
			continue l2;
		}return B;
	},
	// js.lang.Classes#newProxyInstance(java.lang.Class, java.lang.reflect.InvocationHandler)
	_IM:function(A,B,C,D,E,F,G){
		C={};
		G=A.E();F=G.length;E=0;
		l2:for (;
		E<F;
		++E) {
			D=G[E];
			C[D.L()]=new boot.DU(B,C,D,"IN");
		}return C;
	}
});

boot.defineNative("History",{
	// js.dom.History#<init>()
	$0:function(){
	}
});
boot.define("D","",[],{
	// js.application.Application#<clinit>()
	_:function(){
		boot.D.a=new boot.DP(null,0);
	},
	// js.application.Application#<init>()
	$0:function(A,B,C,D,E,F,G){
		B=boot.DQ.ID(boot.BJ.$).BG();
		l2:while (B.BI()!=0) {
			A=B.BH();
			F=A.D();E=F.length;D=0;
			l5:while (D<E) {
				C=F[D];
				G=C.X(boot.BW.$);
				if(!(G==null)){
					if(G.CZ().indexOf("*") != -1==0){
						boot.DP.IF(boot.D.a).T(G.CZ(),C);
					}else{
						boot.DP.IE(boot.D.a).BV(new boot.DR(C,G,null,0));
					}
				}++D;
				continue l5;
			}continue l2;
		}$(window).on("hashchange",boot.D.a);
		boot.DP.IG(boot.D.a,location.hash);
	},
	// js.application.Application#configure(js.application.Header)
	IH:function(A){
	},
	// js.application.Application#show(js.application.Page)
	_Hy:function(A){
		if(!(A==null)){
			boot.DP.IG(boot.D.a,A.CX());
			history.pushState("","","#"+A.CX());
		}
	}
});

boot.define("DK","DL",[],{
	// teemowork.ChampionSelect$1#<init>(teemowork.ChampionSelect)
	$0:function(A){
		this.d=A;
		boot.DL.prototype.$0.call(this);
	},
	// teemowork.ChampionSelect$1#sources()
	Hu:function(){
		return boot.BP.CK();
	},
	// teemowork.ChampionSelect$1#getTitle(teemowork.model.Champion)
	Hv:function(A){
		return A.he;
	},
	// teemowork.ChampionSelect$1#getImageURI(teemowork.model.Champion)
	Hw:function(A){
		return A.CM();
	},
	// teemowork.ChampionSelect$1#select(teemowork.model.Champion)
	Hx:function(A){
		boot.D.Hy(new boot.CV(A.hf,0));
	},
	// teemowork.ChampionSelect$1#getTitle(java.lang.Object)
	Hz:function(A){
		return this.Hv(A);
	},
	// teemowork.ChampionSelect$1#getImageURI(java.lang.Object)
	IA:function(A){
		return this.Hw(A);
	},
	// teemowork.ChampionSelect$1#select(java.lang.Object)
	IB:function(A){
		this.Hx(A);
	}
});

boot.define("DJ","BJ",[],{
	// teemowork.ChampionSelect#<init>()
	$0:function(){
		boot.BJ.prototype.$0.call(this);
		this.a=new boot.DK(this,0);
	},
	// teemowork.ChampionSelect#load(js.util.jQuery)
	CI:function(A){
		this.a.HZ(A);
	},
	// teemowork.ChampionSelect#getPageId()
	CX:function(){
		return "";
	}
},{
	$0:[{
		U: function() {
			return boot.BW.$;
		},
		CZ: function() {
			return "";
		}
	}]
});

boot.define("DY","BJ",[],{
	// teemowork.ItemCatalog#<clinit>()
	_:function(){
		boot.DY.a=[boot.BK.p,boot.BK.bd,boot.BK.bg,boot.BK.bk,boot.BK.dc,boot.BK.di,boot.BK.dj,boot.BK.dm,boot.BK.ea,boot.BK.ed,boot.BK.eg,boot.BK.ff,boot.BK.fj,boot.BK.im];
	},
	// teemowork.ItemCatalog#<init>()
	$0:function(){
		boot.BJ.prototype.$0.call(this);
	},
	// teemowork.ItemCatalog#load(js.util.jQuery)
	CI:function(A,B,C,D,E,F,G,H,I,K,M,N,O,P,Q){
		C=boot.Cz.CK().BG();
		l1:while (C.BI()!=0) {
			B=C.BH();
			D=B.GX(boot.BR.m);
			E=A.CJ("O");
			F=E.CJ("P");
			F.CJ("Q").css("background-image","url("+B.CM()+")");
			G=E.CJ("R");
			H=G.CJ("S");
			H.CJ("T").text(B.ja);
			I=D.CN(boot.BK.jf);
			K=B.HH(boot.BR.m);
			H.CJ("U").text(K);
			if(!(I==K)){
				H.append("(");
				H.CJ("V").text(I);
				H.append(")");
			}P=boot.DY.a;O=P.length;N=0;
			l18:while (N<O) {
				M=P[N];
				Q=D.CN(M);
				if(!(Q==0)){
					G.CJ("W").text(""+Q+M.DA()+" "+M.kf);
				}++N;
				continue l18;
			}N=D.d.BP().BG();
			l25:while (N.BI()!=0) {
				M=N.BH();
				G.CJ("W").text(""+M.BQ()+" - ");
				P=M.BL().BG();
				l29:while (P.BI()!=0) {
					O=P.BH();
					if(O instanceof boot.CP==0){
						G.append(O.toString());
						continue l29;
					}else{
						G.append(O.toString());
						continue l29;
					}
				}continue l25;
			}continue l1;
		}
	},
	// teemowork.ItemCatalog#getPageId()
	CX:function(){
		return "ItemCatalog";
	}
},{
	$0:[{
		U: function() {
			return boot.BW.$;
		},
		CZ: function() {
			return "ItemCatalog";
		}
	}]
});

boot.define("F","",[],{
	// js.application.Header$Menu#<init>(js.application.Header, js.util.jQuery)
	$1:function(A,B){
		this.b=A;;
		this.a=B.Fz("ul").addClass("ba");
	},
	// js.application.Header$Menu#add(java.lang.String, java.lang.String)
	B:function(A,B,C){
		C=this.a.Fz("li").addClass("bb");
		C.Fz("a").addClass("Z").attr("href",B).text(A);
		return new boot.F(this.b,C,1);
	},
	// js.application.Header$Menu#<init>(js.application.Header, js.util.jQuery, js.application.Header$Menu)
	$0:function(A,B,C){
		boot.F.prototype.$1.call(this,A,B);
	}
});

boot.define("E","",[],{
	// js.application.Header#<init>()
	$0:function(){
		this.a=$("#Header").addClass("X");
	},
	// js.application.Header#add(java.lang.String, java.lang.String)
	B:function(A,B,C){
		C=this.a.Fz("li").addClass("Y");
		C.Fz("a").addClass("Z").attr("href",B).text(A);
		return new boot.F(this,C,null,0);
	}
});

boot.define("C","D",[],{
	// teemowork.Teemowork#<init>()
	$0:function(){
		boot.D.prototype.$0.call(this);
	},
	// teemowork.Teemowork#jsmain()
	A:function(A,B){
		$("html").addClass("a");
		$("#Content").addClass("b");
		A=new boot.E(0);
		A.B("< ^ v ^ > Teemowork","");
		A.B("Patch","#");
		B=A.B("Champion","#");
		B.B("Compare","#ChampionComparing");
		B.B("Item","#ItemCatalog");
		B.B("Mastery","#");
		B.B("Rune","#");
		A.B("Builder","#");
		A.B("About","#");
		A.B("Contact","#");
	}
});

try {new boot.C(0).A();} catch(e) {console.log(e)}