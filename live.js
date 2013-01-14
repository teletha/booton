boot.defineNative("Document",{
	
	// booton.translator.web.Document#<init>()
	$0:function(){
	},
	// booton.translator.web.Document#createElement(java.lang.String)
	createElement:function(A){
		return this.createElement(A);
	}
});
boot.define("R",{
	
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
	Y:function(){
		return $(this.a.get(this.b++));
	},
	// booton.translator.web.jQuery$1#remove()
	Z:function(){
	},
	// booton.translator.web.jQuery$1#next()
	N:function(){
		return this.Y();
	}
});

boot.defineNative("jQuery",{
	
	// booton.translator.web.jQuery#<init>()
	$0:function(){
	},
	// booton.translator.web.jQuery#child(java.lang.String)
	Q:function(A){
		return $(document.createElement(A)).appendTo(this);
	},
	// booton.translator.web.jQuery#child(java.lang.Class)
	O:function(A){
		return this.Q("span").addClass(A);
	},
	// booton.translator.web.jQuery#iterator()
	M:function(){
		return new boot.R(this,0);
	}
});
boot.define("BG",{
	
	// booton.live.LiveCoding$1#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding$1#handler(booton.translator.web.jQuery$Event)
	handler:function(A){
		console.log(A);
	}
});

boot.define("BE",{
	
	// booton.translator.web.Location#<init>()
	$0:function(){
	}
});

boot.defineNative("MessageEvent",{
	
	// booton.translator.web.WebSocket$MessageEvent#<init>()
	$0:function(){
	}
});
boot.define("BK",{
	
	// booton.translator.web.Window#<init>()
	$0:function(){
	}
});

boot.define("BI",{
	
	// booton.translator.web.WebSocket#<init>()
	$0:function(){
	}
});

boot.define("BH",boot.BI,{
	
	// booton.live.LiveCoding$2#<init>()
	$0:function(){
		boot.BI.prototype.$0.call(this);
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

boot.define("BF",{
	
	// booton.live.LiveCoding#<init>()
	$0:function(){
	},
	// booton.live.LiveCoding#jsmain()
	_A:function(){
		$(window).on("error",new boot.BG(0));
		WebSocket.connect("ws://localhost:10021/live"+window.location.pathname,new boot.BH(0));
	}
});

try {boot.BF.A();} catch(e) {console.log(e)}