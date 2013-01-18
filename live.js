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

boot.define("Bx","",{
	
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
boot.define("CA","",{
	
	// booton.translator.web.Window#<init>()
	$0:function(){
	}
});

boot.define("x","",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("CB","",{
	
	// booton.translator.web.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// booton.translator.web.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("Bz","CB",{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.CB.prototype.$0.call(this);
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

boot.define("Bw","",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_A:function(){
		$(window).on("error",new boot.Bx(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.Bz(0));
	}
});

try {boot.Bw.A();} catch(e) {console.log(e)}