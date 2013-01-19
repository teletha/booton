boot.define("P","",{
	
	// js.lang.reflect.JSAnnotatedElement#<init>(java.lang.String, js.lang.NativeArray)
	$0:function(A,B){
		{};
		this.a=A;
		this.b=B;
	},
	// js.lang.reflect.JSAnnotatedElement#isAnnotationPresent(java.lang.Class)
	O:function(A){
		return this.E(A)!=null;
	},
	// js.lang.reflect.JSAnnotatedElement#getAnnotation(java.lang.Class)
	E:function(A,B,C){
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
	// js.lang.reflect.JSAnnotatedElement#getAnnotations()
	Q:function(){
		return null;
	},
	// js.lang.reflect.JSAnnotatedElement#getDeclaredAnnotations()
	R:function(){
		return this.Q();
	}
},{
	"$":[["Q",{
		S:function() {return boot.R.$;}
	}]]
});

boot.define("K","P",{
	
	// js.lang.reflect.JSConstructor#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeFunction, js.lang.NativeArray)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	},
	// js.lang.reflect.JSConstructor#newInstance(java.lang.Object[])
	Z:function(A,B){
		B=Object.create(this.c);
		this.d.apply(B,A);
		return B;
	}
},{
	"$":[["Q",{
		S:function() {return boot.K.$;}
	}]]
});

boot.define("S","P",{
	
	// js.lang.reflect.JSMethod#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeFunction, js.lang.NativeArray)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,D);
		this.c=B;
		this.d=C;
	}
},{
	"$":[["Q",{
		S:function() {return boot.S.$;}
	}]]
});

boot.define("V","",{
	
	// js.lang.JSThrowable#<init>()
	$0:function(){
		boot.V.prototype.$1.call(this,"",null);
	},
	// js.lang.JSThrowable#<init>(java.lang.String)
	$2:function(A){
		boot.V.prototype.$1.call(this,A,null);
	},
	// js.lang.JSThrowable#<init>(java.lang.Throwable)
	$3:function(A){
		boot.V.prototype.$1.call(this,"",A);
	},
	// js.lang.JSThrowable#<init>(java.lang.String, java.lang.Throwable)
	$1:function(A,B){
		this.a=A;
		this.b=B;
	},
	// js.lang.JSThrowable#<init>(java.lang.String, java.lang.Throwable, boolean, boolean)
	$4:function(A,B,C,D){
		boot.V.prototype.$1.call(this,A,B);
	},
	// js.lang.JSThrowable#getMessage()
	w:function(){
		return this.a;
	},
	// js.lang.JSThrowable#getLocalizedMessage()
	x:function(){
		return this.a;
	},
	// js.lang.JSThrowable#getCause()
	y:function(){
		return this.b;
	},
	// js.lang.JSThrowable#toString()
	toString:function(){
		return this.a;
	},
	// js.lang.JSThrowable#printStackTrace()
	z:function(){
		console.log(this.a);
	}
},{
	"$":[["Q",{
		S:function() {return boot.V.$;}
	}]]
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

boot.define("A","P",{
	
	// js.lang.reflect.JSClass#<init>(java.lang.String, js.lang.NativeObject, js.lang.NativeObject, js.lang.reflect.JSClass)
	$0:function(A,B,C,D){
		boot.P.prototype.$0.call(this,A,C["$"]);
		this.c=B;
		this.d=C;
		this.e=D;
	},
	// js.lang.reflect.JSClass#getConstructors()
	D:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")==0){
			}else{
				A.push(new boot.K(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getMethods()
	T:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")!=0){
			}else{
				A.push(new boot.S(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#getDeclaredMethods()
	U:function(A,B,C,D,E){
		A=[];
		E=Object.keys(this.c);D=E.length;C=0;
		l2:while (C<D) {
			B=E[C];
			if(B.startsWith("$")!=0){
			}else{
				A.push(new boot.S(B,this.c,this.c[B],this.d[B],0));
			}++C;
			continue l2;
		}return A;
	},
	// js.lang.reflect.JSClass#isAssignableFrom(java.lang.Class)
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
	// js.lang.reflect.JSClass#getSuperclass()
	W:function(){
		return this.e;
	},
	// js.lang.reflect.JSClass#getName()
	X:function(){
		return "boot."+this.a;
	},
	// js.lang.reflect.JSClass#getSimpleName()
	P:function(){
		return this.a;
	},
	// js.lang.reflect.JSClass#newInstance()
	Y:function(A){
		try{
			return this.D()[0].Z(new Array(0));
		} catch ($) {
			if ($ instanceof boot.T) {
				throw new boot.U(A,0);
			}
		}
	},
	// js.lang.reflect.JSClass#getConstructor()
	u:function(){
		return null;
	},
	// js.lang.reflect.JSClass#forName(java.lang.String)
	_v:function(A){
		return null;
	}
},{
	"$":[["Q",{
		S:function() {return boot.A.$;}
	}]]
});

boot.define("CA","",{
	
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
boot.define("BK","",{
	
	// js.util.jQuery$1#<init>(js.util.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// js.util.jQuery$1#hasNext()
	H:function(){
		return this.b<this.a.size();
	},
	// js.util.jQuery$1#next()
	CN:function(){
		return $(this.a.get(this.b++));
	},
	// js.util.jQuery$1#remove()
	CK:function(){
	},
	// js.util.jQuery$1#next()
	C:function(){
		return this.CN();
	}
});

boot.defineNative("jQuery",{
	
	// js.util.jQuery#<init>()
	$0:function(){
	},
	// js.util.jQuery#child(java.lang.String)
	CM:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// js.util.jQuery#child(java.lang.Class)
	BC:function(A){
		return this.CM("span").addClass(A);
	},
	// js.util.jQuery#iterator()
	B:function(){
		return new boot.BK(this,0);
	}
});
boot.define("CC","",{
	
	// js.dom.Window#<init>()
	$0:function(){
	}
});

boot.define("BY","",{
	
	// js.dom.Location#<init>()
	$0:function(){
	}
});

boot.define("CD","",{
	
	// js.net.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// js.net.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("CB","CD",{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.CD.prototype.$0.call(this);
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

boot.define("Bz","",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_M:function(){
		$(window).on("error",new boot.CA(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.CB(0));
	}
});

try {boot.Bz.M();} catch(e) {console.log(e)}