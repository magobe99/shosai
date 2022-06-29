function enviosUsuario(){
    let correo = document.getElementById("correo");
    let asunto = document.getElementById("asunto");
    let mensaje = document.getElementById("mensaje");
        
    if( correo.value === "" ||  asunto.value === "" ||
             mensaje.value === ""  ){
    swal("ERROR!", "Completa todos los campos!", "error");    
    }
    else {
       swal("ENVIADO!", "Correo enviado correctamente!", "success");
  
    }
    
}

