var CurrenteTime = new Date().getTime(); 
var SessionTime = 15*60*1000; //Tiempo de la Session
var checkTime = 60*1000; //Tiempo entre chekeos

setTimeout(fnCheckTimeout, checkTime); 
function fnCheckTimeout(){
  var curMs = new Date().getTime();
  if( (curMs-CurrenteTime)>SessionTime){ 
	  $.get('CloseSession', function(data) {
	        alert(data);
	    });
    window.location.href = 'LoginSessionTimeOut.jsp';
    
  }
}

