boot.define("A","",{
	
	// booton.translator.js.JSClass#<init>(java.lang.String, booton.translator.js.NativeObject, booton.translator.js.NativeObject)
	$0:function(A,B,C){
		this.a=A;
		this.b=B;
		this.c=C;
	},
	// booton.translator.js.JSClass#isAnnotationPresent(java.lang.Class)
	L:function(A,B,C,D){
		if(this.c!=null){
			B=this.c["$"];
			C=0;
			l5:for (;
			C<B.length;
			++C) {
				D=B[C];
				if(D[0].equals(A.T())==0){
				}else{
					return true;
				}
			}return false;
		}else{
			return false;
		}
	},
	// booton.translator.js.JSClass#getName()
	U:function(){
		return "boot."+this.a;
	},
	// booton.translator.js.JSClass#getSimpleName()
	T:function(){
		return this.a;
	},
	// booton.translator.js.JSClass#newInstance()
	V:function(){
		return null;
	},
	// booton.translator.js.JSClass#getConstructor()
	W:function(){
		return null;
	},
	// booton.translator.js.JSClass#getAnnotation(java.lang.Class)
	J:function(A,B,C,D){
		if(this.c==null){
		}else{
			B=this.c["$"];
			C=0;
			l5:for (;
			C<B.length;
			++C) {
				D=B[C];
				if(D[0].equals(A.T())==0){
				}else{
					return D[1];
				}
			}
		}return null;
	}
});

boot.define("BY","",{
	
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
boot.define("w","",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	w:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	Bx:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	BV:function(){
	},
	// booton.translator.web.jQuery$1#next()
	Z:function(){
		return this.Bx();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	Bv:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	Bw:function(A){
		return this.Bv("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	Y:function(){
		return new boot.w(this,0);
	}
});
boot.define("Bu","",{
	
	// booton.translator.web.Window#<init>()
	$0:function(){
	}
});

boot.define("Z","",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("Bv","",{
	
	// booton.translator.web.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// booton.translator.web.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("BZ","Bv",{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.Bv.prototype.$0.call(this);
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

boot.define("BX","",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_A:function(){
		$(window).on("error",new boot.BY(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.BZ(0));
	}
});

try {boot.BX.A();} catch(e) {console.log(e)}