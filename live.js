boot.define("A","",{
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject)
	$0:function(A,B,C){
		this.a=A;
		this.b=B;
		this.c=C;
	},
	// booton.translator.js.JSClass#isAnnotationPresent(java.lang.Class)
	K:function(A){
		return this.T(A)!=null;
	},
	// booton.translator.js.JSClass#getConstructors()
	J:function(A,B,C,D){
		A=[];
		B=this.b.keys();
		C=0;
		l4:while (C<B.length) {
			D=B[C];
			if(D.startsWith("$")==0){
			}else{
				A.push(this.b[D]);
			}++C;
			continue l4;
		}return A;
	},
	// booton.translator.js.JSClass#getName()
	U:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	V:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	W:function(){
		return null;
	},
	// booton.translator.js.JSClass#getConstructor()
	X:function(){
		return null;
	},
	// booton.translator.js.JSClass#getAnnotation(java.lang.Class)
	T:function(A,B,C,D){
		if(this.c==null){
		}else{
			B=this.c["$"];
			C=0;
			l5:for (;
			C<B.length;
			++C) {
				D=B[C];
				if(D[0].equals(A.V())==0){
				}else{
					return D[1];
				}
			}
		}return null;
	}
});

boot.define("Bv","",{
	
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
boot.define("y","",{
	
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
		return new boot.y(this,0);
	}
});
boot.define("Bx","",{
	
	// booton.translator.web.Window#<init>()
	$0:function(){
	}
});

boot.define("v","",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("Bz","",{
	
	// booton.translator.web.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// booton.translator.web.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("Bw","Bz",{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.Bz.prototype.$0.call(this);
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

boot.define("Bu","",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_A:function(){
		$(window).on("error",new boot.Bv(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.Bw(0));
	}
});

try {boot.Bu.A();} catch(e) {console.log(e)}