boot.define("A",{
	
	// booton.translator.Javascript$ClassReplacement#<init>(java.lang.String, booton.translator.js.NativeObject)
	$0:function(A,B){
		this.a=A;
		this.b=B;
	},
	// booton.translator.Javascript$ClassReplacement#isAnnotationPresent(java.lang.Class)
	M:function(A){
		return false;
	},
	// booton.translator.Javascript$ClassReplacement#getName()
	N:function(){
		return "boot."+this.a;
	},
	// booton.translator.Javascript$ClassReplacement#getSimpleName()
	O:function(){
		return this.a;
	},
	// booton.translator.Javascript$ClassReplacement#newInstance()
	P:function(){
		return null;
	},
	// booton.translator.Javascript$ClassReplacement#getConstructor()
	Q:function(){
		return null;
	},
	// booton.translator.Javascript$ClassReplacement#getAnnotation(java.lang.Class)
	J:function(A,B,C,D){
		B=this.b["$A"]["$"];
		C=0;
		l3:for (;
		C<B.length;
		++C) {
			D=B[C];
			if(D[0].equals(A.N())==0){
			}else{
				return D[1];
			}
		}return null;
	}
});

boot.define("BY",{
	
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
boot.define("w",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	W:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	BX:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	BP:function(){
	},
	// booton.translator.web.jQuery$1#next()
	T:function(){
		return this.BX();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	BV:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	BW:function(A){
		return this.BV("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	S:function(){
		return new boot.w(this,0);
	}
});
boot.define("Bu",{
	
	// booton.translator.web.Window#<init>()
	$0:function(){
	}
});

boot.define("Z",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("Bv",{
	
	// booton.translator.web.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// booton.translator.web.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("BZ",boot.Bv,{
	
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

boot.define("BX",{
	
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