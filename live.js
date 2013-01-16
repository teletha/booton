boot.define("BO",{
	
	// booton.translator.web.Window#<init>()
	$0:function(){
	}
});

boot.define("M",{
	
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
	N:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	O:function(){
	},
	// booton.translator.web.jQuery$1#next()
	P:function(){
		return this.N();
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
boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	J:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	K:function(A){
		return this.J("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	L:function(){
		return new boot.M(this,0);
	}
});
boot.define("BM",{
	
	// booton.live.LiveCoding$1#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		console.log(A);
	}
});

boot.define("BP",{
	
	// booton.translator.web.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// booton.translator.web.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("BC",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.define("BN",boot.BP,{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.BP.prototype.$0.call(this);
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

boot.define("BL",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_A:function(){
		$(window).on("error",new boot.BM(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.BN(0));
	}
});

try {boot.BL.A();} catch(e) {console.log(e)}