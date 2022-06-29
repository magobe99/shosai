/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function reporte(){
	
	var Parameter1 = document.getElementById("Parameter1").value;
	
	var tip0 = document.getElementById("tip0").value;
	
	
	window.open("http://localhost:8080/report/ventas/download?fechaInicio="+Parameter1+"&tipo="+tip0);
	
}

