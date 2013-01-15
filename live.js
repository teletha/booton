boot.define("BM",{
	
	// booton.translator.web.Window#<init>()
	$0:function(){
	}
});

boot.define("BL",{
	
	// booton.translator.web.WebSocket#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// booton.translator.web.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("BG",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
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
boot.define("P",{
	
	// booton.translator.web.jQuery$1#<init>(booton.translator.web.jQuery)
	$0:function(A){
		this.a=A;
		this.b=0;
	},
	// booton.translator.web.jQuery$1#hasNext()
	T:function(){
		return this.b<this.a.size();
	},
	// booton.translator.web.jQuery$1#next()
	U:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	V:function(){
	},
	// booton.translator.web.jQuery$1#next()
	W:function(){
		return this.U();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	R:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	L:function(A){
		return this.R("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	S:function(){
		return new boot.P(this,0);
	}
});
boot.define("BK",boot.BL,{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.BL.prototype.$0.call(this);
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

boot.define("BJ",{
	
	// booton.live.LiveCoding$1#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		console.log(A);
	}
});

boot.define("BI",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_A:function(){
		$(window).on("error",new boot.BJ(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.BK(0));
	}
});

try {boot.BI.A();} catch(e) {console.log(e)}