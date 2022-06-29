function envios(){
    let nombre = document.getElementById("nombre");
    let correo = document.getElementById("correo");
    let asunto = document.getElementById("asunto");
    let mensaje = document.getElementById("mensaje");
   
        
    if( nombre.value === "" || correo.value === "" ||  asunto.value === "" ||
             mensaje.value === ""  ){
    swal("Error!", "Completa todos los campos!", "error");    
    }
    else {
       swal("ENVIADO!", "correo correctamente enviado!", "success");
  
    }
    
}
