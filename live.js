boot.define("P","",{
	
	// booton.translator.js.JSAnnotatedElement#<init>(java.lang.String, booton.translator.js.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// booton.translator.js.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	P:function(A){
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
				if(C[0].equals(A.Q())==0){
				}else{
					return C[1];
				}
			}
		}return null;
	},
	// booton.translator.js.JSAnnotatedElement#getAnnotations()
	R:function(){
		return null;
	},
	// booton.translator.js.JSAnnotatedElement#getDeclaredAnnotations()
	S:function(){
		return this.R();
	}
});

boot.define("G","P",{
	
	// booton.translator.js.JSConstructor#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	},
	// booton.translator.js.JSConstructor#newInstance(java.lang.Object[])
	Z:function(A,B){
		B=Object.create(this.c);
		this.d.apply(B,A);
		return B;
	}
});

boot.define("Q","P",{
	
	// booton.translator.js.JSMethod#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeFunction, booton.translator.js.NativeArray)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	}
});

boot.define("T","",{
	
	// booton.translator.Javascript$ThrowableReplacement#<init>()
	$0:function(){
		boot.T.prototype.$1.call(this,"",null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String)
	$2:function(A){
		boot.T.prototype.$1.call(this,A,null);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.Throwable)
	$3:function(A){
		boot.T.prototype.$1.call(this,"",A);
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ThrowableReplacement#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.T.prototype.$1.call(this,A,B);
	},
	// booton.translator.Javascript$ThrowableReplacement#getMessage()
	w:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getLocalizedMessage()
	x:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#getCause()
	y:function(){
		return this.b;
	},
	// booton.translator.Javascript$ThrowableReplacement#toString()
	toString:function(){
		return this.a;
	},
	// booton.translator.Javascript$ThrowableReplacement#printStackTrace()
	z:function(){
		console.log(this.a);
	}
});

boot.define("S","T",{
	
	// java.lang.Error#<init>()
	$1:function(){
		boot.T.prototype.$0.call(this);
	},
	// java.lang.Error#<init>(java.lang.String)
	$2:function(A){
		boot.T.prototype.$2.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable)
	$3:function(A,B){
		boot.T.prototype.$1.call(this,A,B);
	},
	// java.lang.Error#<init>(java.lang.Throwable)
	$0:function(A){
		boot.T.prototype.$3.call(this,A);
	},
	// java.lang.Error#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.T.prototype.$4.call(this,A,B,C,D);
	}
});

boot.define("A","P",{
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject, booton.translator.js.JSClass)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,C["$"]);
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
	T:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")!=0){
			}else{
				A.push(new boot.Q(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// booton.translator.js.JSClass#getDeclaredMethods()
	U:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")!=0){
			}else{
				A.push(new boot.Q(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// booton.translator.js.JSClass#isAssignableFrom(java.lang.Class)
	V:function(A){
		l1:for (;
		A!=null;
		A=A.W()) {
			if(this!=A){
			}else{
				return true;
			}
		}return false;
	},
	// booton.translator.js.JSClass#getSuperclass()
	W:function(){
		return this.e;
	},
	// booton.translator.js.JSClass#getName()
	X:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	Q:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	Y:function(A){
		try{
			return this.E()[0].Z(new Array(0));
		} catch ($) {
			if ($ instanceof boot.R) {
				throw new boot.S(A,0);
			}
		}
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

boot.define("BS","",{
	
	// booton.live.LiveCoding$1#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding$1#handler(js.util.jQuery$Event)
	handler:function(A){
		console.log(A);
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
boot.define("BB","",{
	
	// js.util.jQuery$1#<init>(js.util.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// js.util.jQuery$1#hasNext()
	N:function(){
		return this.b<this.a.size();
	},
	// js.util.jQuery$1#next()
	CD:function(){
		return $(this.a.get(this.b++));
	},
	// js.util.jQuery$1#remove()
	Bv:function(){
	},
	// js.util.jQuery$1#next()
	M:function(){
		return this.CD();
	}
});

boot.defineNative("jQuery",{
	
	// js.util.jQuery#<init>()
	$0:function(){
	},
	// js.util.jQuery#child(java.lang.String)
	CB:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// js.util.jQuery#child(java.lang.Class)
	CC:function(A){
		return this.CB("span").addClass(A);
	},
	// js.util.jQuery#iterator()
	L:function(){
		return new boot.BB(this,0);
	}
});
boot.define("BU","",{
	
	// js.dom.Window#<init>()
	$0:function(){
	}
});

boot.define("v","",{
	
	// js.dom.Location#<init>()
	$0:function(){
	}
});

boot.define("BV","",{
	
	// js.net.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// js.net.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("BT","BV",{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.BV.prototype.$0.call(this);
	},
	// booton.live.LiveCoding$2#message(js.net.WebSocket$MessageEvent)
	message:function(A,B){
		B=A.data;
		if(B.endsWith("css")==0){
			window.location.reload(0);
		}else{
			$("link[href^='"+B+"']").attr("href",""+B+"?"+new Date().getTime());
		}
	}
});

boot.define("BR","",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_A:function(){
		$(window).on("error",new boot.BS(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.BT(0));
	}
});

try {boot.BR.A();} catch(e) {console.log(e)}