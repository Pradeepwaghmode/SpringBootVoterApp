

function validation(frm){
	
	alert(1);
	//get the error messages
//	alert(1);
	document.getElementById("c1err").innerHTML="";
	document.getElementById("c2err").innerHTML="";
	document.getElementById("c3err").innerHTML="";
	document.getElementById("c4err").innerHTML="";
	
	let fc=frm.c1.value;
	let sc=frm.c2.value;
	let tc=frm.c3.value;
	let fca=frm.c4.value;
	let flag=true;
	let tes=frm.test.value;
	
	if(fc=="" && sc=="" && tc=="" && fca==""){
		document.getElementById("c1err").innerHTML="please select any one !!";
		flag=false;
	}
	
	alert(ended);

	

//	alert(document.getElementById("flag").value="yes");
 	return flag;
}