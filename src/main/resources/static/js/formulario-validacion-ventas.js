/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function crear(){
       let idventa = document.getElementById("idventa");
    let detalle = document.getElementById("detalle");
    let selecidcliente = document.getElementById("selecidcliente");
    let selectiddomicilio = document.getElementById("selectiddomicilio");
 
    
        
    if( idventa.value === "" || detalle.value === "" || 
             selecidcliente.value === "" ||  selectiddomicilio.value === ""   ){
    swal("Eror!", "Completa todos los campos!", "error");    
    }
    else {
       swal("GUARDADO!", "venta guardado con exito!", "success");
  
    }
    
}



