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

boot.define("Bw","",{
	
	// booton.live.LiveCoding$1#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		console.log(A);
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
boot.define("Bz","",{
	
	// booton.translator.web.Window#<init>()
	$0:function(){
	}
});

boot.define("w","",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("CA","",{
	
	// booton.translator.web.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// booton.translator.web.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("Bx","CA",{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.CA.prototype.$0.call(this);
	},
	// booton.live.LiveCoding$2#message(booton.translator.web.WebSocket$MessageEvent)
	message:function(A,B){
		B=A.data;
		if(B.endsWith("css")==0){
			window.location.reload(0);
		}else{
			$("link[href^='"+B+"']").attr("href",""+B+"?"+new Date().getTime());
		}
	}
});

boot.define("Bv","",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_A:function(){
		$(window).on("error",new boot.Bw(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.Bx(0));
	}
});

try {boot.Bv.A();} catch(e) {console.log(e)}