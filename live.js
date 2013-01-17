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
		return this.d.apply(this.c,A);
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